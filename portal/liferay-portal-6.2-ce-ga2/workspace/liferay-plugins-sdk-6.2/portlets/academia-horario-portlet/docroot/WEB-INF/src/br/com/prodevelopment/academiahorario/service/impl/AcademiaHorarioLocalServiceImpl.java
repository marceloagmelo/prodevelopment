/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.prodevelopment.academiahorario.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.prodevelopment.academiahorario.AcademiaHorarioAlteradoOutroUsuarioException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioAtividadeObrigatoriaException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioDiaSemanaObrigatorioException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioHoraFinalObrigatoriaException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialIgualFinalException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialMaiorQueFinalException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialObrigatoriaException;
import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil;
import br.com.prodevelopment.academiahorario.service.base.AcademiaHorarioLocalServiceBaseImpl;
import br.com.prodevelopment.atividade.model.Atividade;
import br.com.prodevelopment.atividade.service.AtividadeLocalServiceUtil;
import br.com.prodevelopment.portlet.academiahorario.Constantes;
import br.com.prodevelopment.portlet.academiahorario.social.AcademiaHorarioActivityKeys;
import br.com.prodevelopment.portlet.academiahorario.util.AcademiaHorarioUtil;
import br.com.prodevelopment.portlet.academiahorario.util.DateUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the academia horario local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo
 * @see br.com.prodevelopment.academiahorario.service.base.AcademiaHorarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil
 */
public class AcademiaHorarioLocalServiceImpl extends
		AcademiaHorarioLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment
	 * .academiahorario.service.AcademiaHorarioLocalServiceUtil} to access the
	 * academia horario local service.
	 */
	public AcademiaHorario addAcademiaHorario(long companyId, long groupId,
			long createUserId, int diaSemana, String horaInicial,
			String horaFinal, long atividadeId, double versao,
			ServiceContext serviceContext) throws SystemException,
			PortalException, IOException {

		Locale locale = LocaleUtil.getSiteDefault();

		validate(0, diaSemana, horaInicial, horaFinal, atividadeId, versao,
				locale);

		Date now = DateUtil.getDataAtual();

		// Criar objeto incrementando um novo ID
		AcademiaHorario academiaHorario = academiaHorarioPersistence
				.create(counterLocalService.increment(AcademiaHorario.class
						.getName()));

		// Atribui novos valores
		academiaHorario.setCompanyId(companyId);
		academiaHorario.setGroupId(groupId);
		academiaHorario.setCreateUserId(createUserId);
		academiaHorario.setCreateDate(now);
		academiaHorario.setDiaSemana(diaSemana);
		academiaHorario.setHoraInicial(horaInicial);
		academiaHorario.setHoraFinal(horaFinal);
		academiaHorario.setAtividadeId(atividadeId);
		academiaHorario.setVersao(versao);

		// Recuperar a atividade
		Atividade atividade = AtividadeLocalServiceUtil
				.fetchAtividade(atividadeId);

		if (Validator.isNotNull(atividade)) {
			academiaHorario.setAtividadeNomeMap(atividade.getNomeMap());
		}

		academiaHorario.setNew(true);

		academiaHorario = academiaHorarioPersistence.update(academiaHorario);

		// Social

		if (Validator.isNotNull(atividade)) {
			ResourceBundle resource = ResourceBundle
					.getBundle(Constantes.RESOURCE_BUNDLE);
			if (Validator.isNotNull(resource)) {
				// try to get the user from the pruser for social
				// there will be no link if the user wasn't logged in
				JSONObject extraDataJSONObject = JSONFactoryUtil
						.createJSONObject();

				extraDataJSONObject.put("atividade", atividade.getNome());

				String diaDaSemana = resource.getString(AcademiaHorarioUtil
						.getDiaDaSemana(academiaHorario.getDiaSemana() - 1));

				extraDataJSONObject.put("diaSemana", diaDaSemana);
				extraDataJSONObject.put("horaInicial",
						academiaHorario.getHoraInicial());
				extraDataJSONObject.put("horaFinal",
						academiaHorario.getHoraFinal());

				socialActivityLocalService.addActivity(
						academiaHorario.getCreateUserId(),
						academiaHorario.getGroupId(),
						AcademiaHorario.class.getName(),
						academiaHorario.getPrimaryKey(),
						AcademiaHorarioActivityKeys.ADD_ACADEMIA_HORARIO,
						extraDataJSONObject.toString(), 0);
			}
		}

		return academiaHorario;
	}

	public AcademiaHorario update(long academiaHorarioId, long modifieduserId,
			int diaSemana, String horaInicial, String horaFinal,
			long atividadeId, double versao, ServiceContext serviceContext)
			throws SystemException, PortalException, IOException {

		Locale locale = LocaleUtil.getSiteDefault();

		validate(academiaHorarioId, diaSemana, horaInicial, horaFinal,
				atividadeId, versao, locale);

		Date now = DateUtil.getDataAtual();

		// Recuperar academiaHorario
		AcademiaHorario academiaHorario = academiaHorarioPersistence
				.fetchByPrimaryKey(academiaHorarioId);

		// Atribui novos valores
		academiaHorario.setModifiedUserId(modifieduserId);
		academiaHorario.setModifiedDate(now);
		academiaHorario.setDiaSemana(diaSemana);
		academiaHorario.setHoraInicial(horaInicial);
		academiaHorario.setHoraFinal(horaFinal);
		academiaHorario.setAtividadeId(atividadeId);
		academiaHorario.setVersao(versao + 1);

		// Recuperar a atividade
		Atividade atividade = AtividadeLocalServiceUtil
				.fetchAtividade(atividadeId);

		if (Validator.isNotNull(atividade)) {
			academiaHorario.setAtividadeNomeMap(atividade.getNomeMap());
		}

		academiaHorario = academiaHorarioPersistence.update(academiaHorario);

		// Social

		if (Validator.isNotNull(atividade)) {
			ResourceBundle resource = ResourceBundle
					.getBundle(Constantes.RESOURCE_BUNDLE);
			if (Validator.isNotNull(resource)) {
				// try to get the user from the pruser for social
				// there will be no link if the user wasn't logged in
				JSONObject extraDataJSONObject = JSONFactoryUtil
						.createJSONObject();

				extraDataJSONObject.put("atividade", atividade.getNome());

				String diaDaSemana = resource.getString(AcademiaHorarioUtil
						.getDiaDaSemana(academiaHorario.getDiaSemana() - 1));

				extraDataJSONObject.put("diaSemana", diaDaSemana);
				extraDataJSONObject.put("horaInicial",
						academiaHorario.getHoraInicial());
				extraDataJSONObject.put("horaFinal",
						academiaHorario.getHoraFinal());

				socialActivityLocalService.addActivity(
						academiaHorario.getModifiedUserId(),
						academiaHorario.getGroupId(),
						AcademiaHorario.class.getName(),
						academiaHorario.getPrimaryKey(),
						AcademiaHorarioActivityKeys.UPDATE_ACADEMIA_HORARIO,
						extraDataJSONObject.toString(), 0);
			}
		}

		return academiaHorario;
	}

	public AcademiaHorario deleteAcademiaHorario(
			AcademiaHorario academiaHorario, long userId)
			throws SystemException {

		try {
			// Social

			// Recuperar a atividade
			Atividade atividade = AtividadeLocalServiceUtil
					.fetchAtividade(academiaHorario.getAtividadeId());

			if (Validator.isNotNull(atividade)) {
				Locale locale = LocaleUtil.getSiteDefault();
				ResourceBundle resource = ResourceBundle.getBundle(
						Constantes.RESOURCE_BUNDLE, locale);
				if (Validator.isNotNull(resource)) {
					// try to get the user from the pruser for social
					// there will be no link if the user wasn't logged in
					JSONObject extraDataJSONObject = JSONFactoryUtil
							.createJSONObject();

					extraDataJSONObject.put("atividade", atividade.getNome());

					String diaDaSemana = resource
							.getString(AcademiaHorarioUtil
									.getDiaDaSemana(academiaHorario
											.getDiaSemana() - 1));

					extraDataJSONObject.put("diaSemana", diaDaSemana);
					extraDataJSONObject.put("horaInicial",
							academiaHorario.getHoraInicial());
					extraDataJSONObject.put("horaFinal",
							academiaHorario.getHoraFinal());

					socialActivityLocalService
							.addActivity(
									userId,
									academiaHorario.getGroupId(),
									AcademiaHorario.class.getName(),
									academiaHorario.getAcademiaHorarioId(),
									AcademiaHorarioActivityKeys.DELETE_ACADEMIA_HORARIO,
									extraDataJSONObject.toString(), 0);
				}
			}

			academiaHorario = super.deleteAcademiaHorario(academiaHorario);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return academiaHorario;
	}

	public List<AcademiaHorario> search(long companyId, long groupId,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return academiaHorarioPersistence.findByC_G(companyId, groupId, start,
				end, orderByComparator);

	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return academiaHorarioPersistence.findByC_G(companyId, groupId).size();
	}

	public List<AcademiaHorario> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return academiaHorarioPersistence.findByCompany(companyId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId) throws SystemException {
		return academiaHorarioPersistence.findByCompany(companyId).size();
	}

	public List<AcademiaHorario> searchByAcademia(long companyId,
			long atividadeId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {

		return academiaHorarioPersistence.findByC_ATIVIDADE(companyId,
				atividadeId, start, end, orderByComparator);

	}

	public int searchByAcademiaCount(long companyId, long atividadeId,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return academiaHorarioPersistence.findByC_ATIVIDADE(companyId,
				atividadeId, start, end, orderByComparator).size();
	}

	public List<AcademiaHorario> searchByAcademia(long companyId, long groupId,
			long atividadeId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {

		return academiaHorarioPersistence.findByC_G_ATIVIDADE(companyId, groupId,
				atividadeId, start, end, orderByComparator);

	}

	public int searchByAcademiaCount(long companyId, long atividadeId, long groupId,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return academiaHorarioPersistence.findByC_G_ATIVIDADE(companyId, groupId,
				atividadeId, start, end, orderByComparator).size();
	}
	
	public List search(long companyId, long groupId, int diaDaSemana,
			long atividadeId, boolean andSearch, int start, int end)
			throws SystemException {
		DynamicQuery dynamicQuery = buildDynamicQuery(companyId, groupId,
				diaDaSemana, atividadeId, andSearch);

		return AcademiaHorarioLocalServiceUtil.dynamicQuery(dynamicQuery,
				start, end);
	}

	public int searchCount(long companyId, long groupId, int diaDaSemana,
			long atividadeId, boolean andSearch) throws SystemException {
		DynamicQuery dynamicQuery = buildDynamicQuery(companyId, groupId,
				diaDaSemana, atividadeId, andSearch);
		return (int) AcademiaHorarioLocalServiceUtil
				.dynamicQueryCount(dynamicQuery);
	}

	protected DynamicQuery buildDynamicQuery(long companyId, long groupId,
			int diaDaSemana, long atividadeId, boolean andSearch) {
		Junction junctionRestrict = RestrictionsFactoryUtil.conjunction();
		Junction junction = null;
		if (andSearch)
			junction = RestrictionsFactoryUtil.conjunction();
		else
			junction = RestrictionsFactoryUtil.disjunction();

		if (companyId > 0) {
			Property property = PropertyFactoryUtil
					.forName(Constantes.CAMPO_COMPANY_ID);
			junctionRestrict.add(property.eq(Long.valueOf(companyId)));
		}
		if (groupId > 0) {
			Property property = PropertyFactoryUtil
					.forName(Constantes.CAMPO_GROUP_ID);
			junctionRestrict.add(property.eq(Long.valueOf(groupId)));
		}
		if (diaDaSemana > 0) {
			Property property = PropertyFactoryUtil
					.forName(Constantes.CAMPO_DIA_SEMANA);
			junction.add(property.eq(Integer.valueOf(diaDaSemana)));
		}
		if (atividadeId > 0) {
			Property property = PropertyFactoryUtil
					.forName(Constantes.CAMPO_ATIVIDADE_ID);
			junction.add(property.eq(Long.valueOf(atividadeId)));
		}
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				AcademiaHorario.class, getClassLoader());
		return dynamicQuery.add(junction);
	}

	public List search(long companyId, long groupId) throws SystemException {
		// Montar a query dinâmica
		DynamicQuery horarioQuery = DynamicQueryFactoryUtil
				.forClass(AcademiaHorario.class);
		Criterion criteriaCompany = RestrictionsFactoryUtil.eq(
				Constantes.CAMPO_COMPANY_ID, companyId);
		horarioQuery.add(criteriaCompany);
		Criterion criteriaGroup = RestrictionsFactoryUtil.eq(
				Constantes.CAMPO_GROUP_ID, groupId);
		horarioQuery.add(criteriaGroup);
		horarioQuery.addOrder(OrderFactoryUtil
				.asc(Constantes.CAMPO_ATIVIDADE_ID));
		horarioQuery
				.addOrder(OrderFactoryUtil.asc(Constantes.CAMPO_DIA_SEMANA));
		horarioQuery.addOrder(OrderFactoryUtil
				.asc(Constantes.CAMPO_HORA_INICIAL));

		return AcademiaHorarioLocalServiceUtil.dynamicQuery(horarioQuery);
	}

	public List recuperarHorariosPorAtividade(long atividadeId)
			throws SystemException {
		// Montar a query dinâmica
		DynamicQuery horarioQuery = DynamicQueryFactoryUtil
				.forClass(AcademiaHorario.class);
		Criterion criteriaAtividade = RestrictionsFactoryUtil.eq(
				Constantes.CAMPO_ATIVIDADE_ID, atividadeId);
		horarioQuery.add(criteriaAtividade);
		horarioQuery
				.addOrder(OrderFactoryUtil.asc(Constantes.CAMPO_DIA_SEMANA));
		horarioQuery.addOrder(OrderFactoryUtil
				.asc(Constantes.CAMPO_HORA_INICIAL));

		return AcademiaHorarioLocalServiceUtil.dynamicQuery(horarioQuery);
	}

	protected void validate(long academiaHorarioId, int diaSemana,
			String horaInicial, String horaFinal, long atividadeId,
			double versao, Locale locale) throws PortalException,
			SystemException {

		SimpleDateFormat sdfFormat = new SimpleDateFormat("HH:mm", locale);

		if (diaSemana <= 0) {
			throw new AcademiaHorarioDiaSemanaObrigatorioException();
		}
		if (atividadeId <= 0) {
			throw new AcademiaHorarioAtividadeObrigatoriaException();
		}
		if (Validator.isNull(horaInicial)) {
			throw new AcademiaHorarioHoraInicialObrigatoriaException();
		}
		if (Validator.isNull(horaFinal)) {
			throw new AcademiaHorarioHoraFinalObrigatoriaException();
		}

		try {
			Date hrIni = sdfFormat.parse(horaInicial);
			Date hrFim = sdfFormat.parse(horaFinal);
			if (hrIni.after(hrFim)) {
				throw new AcademiaHorarioHoraInicialMaiorQueFinalException();
			} else if (hrIni.equals(hrFim)) {
				throw new AcademiaHorarioHoraInicialIgualFinalException();
			}
		} catch (ParseException e) {
		}

		if (academiaHorarioId > 0) {
			AcademiaHorario academiaHorario = academiaHorarioPersistence
					.fetchByPrimaryKey(academiaHorarioId);
			if ((Validator.isNotNull(academiaHorario))
					&& (academiaHorario.getVersao() > versao)) {
				throw new AcademiaHorarioAlteradoOutroUsuarioException();
			}
		}
	}
}