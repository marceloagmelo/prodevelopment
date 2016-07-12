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

package br.com.prodevelopment.atividade.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.atividade.AtividadeAlteradoOutroUsuarioException;
import br.com.prodevelopment.atividade.AtividadeNomeObrigatorioException;
import br.com.prodevelopment.atividade.model.Atividade;
import br.com.prodevelopment.atividade.service.base.AtividadeLocalServiceBaseImpl;
import br.com.prodevelopment.portlet.atividade.social.AtividadeActivityKeys;
import br.com.prodevelopment.portlet.atividade.util.DateUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the atividade local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.atividade.service.AtividadeLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo
 * @see br.com.prodevelopment.atividade.service.base.AtividadeLocalServiceBaseImpl
 * @see br.com.prodevelopment.atividade.service.AtividadeLocalServiceUtil
 */
public class AtividadeLocalServiceImpl extends AtividadeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.atividade.service.AtividadeLocalServiceUtil} to
	 * access the atividade local service.
	 */
	public Atividade addAtividade(long companyId, long groupId,
			long createUserId, Map<Locale, String> nomeMap,
			Map<Locale, String> descricaoMap, boolean existeImagem,
			InputStream streamImagem, double versao,
			ServiceContext serviceContext) throws SystemException,
			PortalException, IOException {

		validate(0, nomeMap, versao);

		Date now = DateUtil.getDataAtual();

		// Criar objeto incrementando um novo ID
		Atividade atividade = atividadePersistence.create(counterLocalService
				.increment(Atividade.class.getName()));

		// Atribui novos valores
		atividade.setCompanyId(companyId);
		atividade.setGroupId(groupId);
		atividade.setCreateUserId(createUserId);
		atividade.setCreateDate(now);
		atividade.setNomeMap(nomeMap);
		atividade.setDescricaoMap(descricaoMap);
		atividade.setVersao(versao);
		atividade.setExisteImagem(existeImagem);

		atividade.setNew(true);

		atividade = atividadePersistence.update(atividade);

		// Imagem
		updateImagem(atividade, existeImagem, streamImagem);

		// Asset
		updateAsset(atividade.getCreateUserId(), atividade,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", atividade.getNome());

		socialActivityLocalService.addActivity(atividade.getCreateUserId(),
				atividade.getGroupId(), Atividade.class.getName(),
				atividade.getPrimaryKey(), AtividadeActivityKeys.ADD_ATIVIDADE,
				extraDataJSONObject.toString(), 0);

		return atividade;
	}

	public Atividade update(long atividadeId, long modifieduserId,
			Map<Locale, String> nomeMap, Map<Locale, String> descricaoMap,
			boolean existeImagem, InputStream streamImagem, double versao,
			ServiceContext serviceContext) throws SystemException,
			PortalException, IOException {

		validate(atividadeId, nomeMap, versao);

		Date now = DateUtil.getDataAtual();

		// Recuperar atividade
		Atividade atividade = atividadePersistence
				.fetchByPrimaryKey(atividadeId);

		// Atribui novos valores
		atividade.setModifiedUserId(modifieduserId);
		atividade.setModifiedDate(now);
		atividade.setNomeMap(nomeMap);
		atividade.setDescricaoMap(descricaoMap);
		atividade.setVersao(versao + 1);
		atividade.setExisteImagem(existeImagem);

		atividade = atividadePersistence.update(atividade);

		// Imagem
		updateImagem(atividade, existeImagem, streamImagem);
		
		// Asset
		updateAsset(atividade.getModifiedUserId(), atividade,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", atividade.getNome());

		socialActivityLocalService.addActivity(atividade.getModifiedUserId(),
				atividade.getGroupId(), Atividade.class.getName(),
				atividade.getPrimaryKey(),
				AtividadeActivityKeys.UPDATE_ATIVIDADE,
				extraDataJSONObject.toString(), 0);

		return atividade;
	}

	public void updateAsset(long userId, Atividade atividade,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				atividade.getGroupId(), atividade.getCreateDate(),
				atividade.getModifiedDate(), Atividade.class.getName(),
				atividade.getAtividadeId(), StringPool.BLANK, 0,
				assetCategoryIds, assetTagNames, true, null, null, null,
				ContentTypes.TEXT_HTML, atividade.getNome(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}

	public Atividade deleteAtividade(Atividade atividade, long userId)
			throws SystemException {

		try {
			// Imagem
			if (atividade.getExisteImagem()) {
				ImageLocalServiceUtil.deleteImage(atividade.getImagemId());
			}

			// Asset

			assetEntryLocalService.deleteEntry(Atividade.class.getName(),
					atividade.getAtividadeId());

			// Social

			// try to get the user from the pruser for social
			// there will be no link if the user wasn't logged in
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

			extraDataJSONObject.put("nome", atividade.getNome());

			socialActivityLocalService.addActivity(userId,
					atividade.getGroupId(), Atividade.class.getName(),
					atividade.getAtividadeId(),
					AtividadeActivityKeys.DELETE_ATIVIDADE,
					extraDataJSONObject.toString(), 0);

			atividade = super.deleteAtividade(atividade);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return atividade;
	}

	private void updateImagem(Atividade atividade, boolean existeImagem,
			InputStream streamImagem) throws PortalException, SystemException {

		if (atividade.getExisteImagem()) {
			long imagemId = atividade.getImagemId();
			if (imagemId <= 0) {
				imagemId = CounterLocalServiceUtil.increment(Image.class
						.getName());
				ImageLocalServiceUtil
						.updateImage(imagemId, streamImagem, false);

				atividade.setImagemId(imagemId);
			} else {
				if (streamImagem != null) {
					ImageLocalServiceUtil.updateImage(imagemId, streamImagem,
							false);
					atividade.setImagemId(imagemId);
				}
			}
		} else {
			deleteImagem(atividade);
			atividade.setImagemId(0);
		}
		atividadePersistence.update(atividade);
	}

	private void deleteImagem(Atividade atividade) throws PortalException,
			SystemException {

		long imagemId = atividade.getImagemId();

		if (imagemId > 0) {
			// Imagem
			ImageLocalServiceUtil.deleteImage(atividade.getImagemId());

			atividade.setImagemId(0);

			atividadePersistence.update(atividade);
		}
	}

	public List<Atividade> search(long companyId, long groupId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {

		return atividadePersistence.findByC_G_NOME(companyId, groupId, nome,
				start, end, orderByComparator);

	}

	public int searchCount(long companyId, long groupId, String nome)
			throws SystemException {
		return atividadePersistence.findByC_G_NOME(companyId, groupId, nome)
				.size();
	}

	public List<Atividade> search(long companyId, long groupId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return atividadePersistence.findByC_G(companyId, groupId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return atividadePersistence.findByC_G(companyId, groupId).size();
	}

	public List<Atividade> search(long companyId, String nome, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {

		return atividadePersistence.findByC_NOME(companyId, nome, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, String nome) throws SystemException {
		return atividadePersistence.findByC_NOME(companyId, nome).size();
	}

	public List<Atividade> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return atividadePersistence.findByCompany(companyId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId) throws SystemException {
		return atividadePersistence.findByCompany(companyId).size();
	}

	protected void validate(long atividadeId, Map<Locale, String> nomeMap,
			double versao) throws PortalException, SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		String nome = nomeMap.get(locale);

		if (Validator.isNull(nome)) {
			throw new AtividadeNomeObrigatorioException();
		}
		if (atividadeId > 0) {
			Atividade atividade = atividadePersistence
					.fetchByPrimaryKey(atividadeId);
			if ((Validator.isNotNull(atividade))
					&& (atividade.getVersao() > versao)) {
				throw new AtividadeAlteradoOutroUsuarioException();
			}
		}
	}
}