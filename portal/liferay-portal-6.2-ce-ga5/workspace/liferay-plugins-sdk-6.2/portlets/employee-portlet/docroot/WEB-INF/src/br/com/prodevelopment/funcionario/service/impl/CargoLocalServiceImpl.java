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

package br.com.prodevelopment.funcionario.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.funcionario.CargoAlteradoOutroUsuarioException;
import br.com.prodevelopment.funcionario.CargoNomeObrigatorioException;
import br.com.prodevelopment.funcionario.model.Cargo;
import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.funcionario.service.base.CargoLocalServiceBaseImpl;
import br.com.prodevelopment.portlet.funcionario.social.FuncionarioActivityKeys;
import br.com.prodevelopment.portlet.funcionario.util.DateUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the cargo local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.cargo.service.CargoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author marcelo
 * @see br.com.prodevelopment.cargo.service.base.CargoLocalServiceBaseImpl
 * @see br.com.prodevelopment.cargo.service.CargoLocalServiceUtil
 */
public class CargoLocalServiceImpl extends CargoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.cargo.service.CargoLocalServiceUtil} to access the
	 * cargo local service.
	 */
	public Cargo addCargo(long companyId, long groupId, long createUserId,
			Map<Locale, String> nomeMap, double versao, ServiceContext serviceContext) throws SystemException, PortalException {

		validate(0, nomeMap, versao);

		Date now = DateUtil.getDataAtual();

		// Criar objeto incrementando um novo ID
		Cargo cargo = cargoPersistence.create(counterLocalService
				.increment(Cargo.class.getName()));

		// Atribui novos valores
		cargo.setCompanyId(companyId);
		cargo.setGroupId(groupId);
		cargo.setCreateUserId(createUserId);
		cargo.setCreateDate(now);
		cargo.setNomeMap(nomeMap);
		cargo.setVersao(versao);

		cargo.setNew(true);

		cargo = cargoPersistence.update(cargo);

		// Asset
		updateAsset(cargo.getCreateUserId(), cargo,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", cargo.getNome());

		socialActivityLocalService.addActivity(cargo.getCreateUserId(),
				cargo.getGroupId(), Funcionario.class.getName(),
				cargo.getPrimaryKey(), FuncionarioActivityKeys.ADD_CARGO,
				extraDataJSONObject.toString(), 0);
		
		return cargo;
	}

	public Cargo update(long cargoId, long modifieduserId, Map<Locale, String> nomeMap,
			double versao, ServiceContext serviceContext) throws SystemException, PortalException {

		validate(cargoId, nomeMap, versao);

		Date now = DateUtil.getDataAtual();

		// Recuperar cargo
		Cargo cargo = cargoPersistence.fetchByPrimaryKey(cargoId);

		// Atribui novos valores
		cargo.setModifiedUserId(modifieduserId);
		cargo.setModifiedDate(now);
		cargo.setNomeMap(nomeMap);
		cargo.setVersao(versao + 1);

		cargo = cargoPersistence.update(cargo);

		// Asset
		updateAsset(cargo.getModifiedUserId(), cargo,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());
		
		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", cargo.getNome());

		socialActivityLocalService.addActivity(cargo.getModifiedUserId(),
				cargo.getGroupId(), Funcionario.class.getName(),
				cargo.getPrimaryKey(), FuncionarioActivityKeys.UPDATE_CARGO,
				extraDataJSONObject.toString(), 0);

		return cargo;
	}


	public void updateAsset(long userId, Cargo cargo,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				cargo.getGroupId(), cargo.getCreateDate(),
				cargo.getModifiedDate(), Cargo.class.getName(),
				cargo.getCargoId(), StringPool.BLANK, 0,
				assetCategoryIds, assetTagNames, true, null, null, null,
				ContentTypes.TEXT_HTML, cargo.getNome(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}

	public Cargo deleteCargo(Cargo cargo, long userId)
			throws SystemException {

		try {
			// Asset

			assetEntryLocalService.deleteEntry(Cargo.class.getName(),
					cargo.getCargoId());
			
			// Social

			// try to get the user from the pruser for social
			// there will be no link if the user wasn't logged in
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

			Locale locale = LocaleUtil.getSiteDefault();
			extraDataJSONObject.put("nome", cargo.getNome());

			socialActivityLocalService.addActivity(userId,
					cargo.getGroupId(), Funcionario.class.getName(),
					cargo.getCargoId(),
					FuncionarioActivityKeys.DELETE_CARGO,
					extraDataJSONObject.toString(), 0);


			cargo = super.deleteCargo(cargo);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return cargo;
	}
	
	public List<Cargo> search(long companyId, long groupId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {

		return cargoPersistence.findByC_G_NOME(companyId, groupId, nome, start,
				end, orderByComparator);

	}

	public int searchCount(long companyId, long groupId, String nome)
			throws SystemException {
		return cargoPersistence.findByC_G_NOME(companyId, groupId, nome).size();
	}

	public List<Cargo> search(long companyId, long groupId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return cargoPersistence.findByC_G(companyId, groupId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return cargoPersistence.findByC_G(companyId, groupId).size();
	}
	
	public List<Cargo> search(long companyId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {

		return cargoPersistence.findByC_NOME(companyId, nome, start,
				end, orderByComparator);

	}

	public int searchCount(long companyId, String nome)
			throws SystemException {
		return cargoPersistence.findByC_NOME(companyId, nome).size();
	}

	public List<Cargo> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return cargoPersistence.findByCompany(companyId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId) throws SystemException {
		return cargoPersistence.findByCompany(companyId).size();
	}

	protected void validate(long cargoId, Map<Locale, String> nomeMap, double versao)
			throws PortalException, SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		String nome = nomeMap.get(locale);
		
		if (Validator.isNull(nome)) {
			throw new CargoNomeObrigatorioException();
		}
		if (cargoId > 0) {
			Cargo cargo = cargoPersistence.fetchByPrimaryKey(cargoId);
			if ((Validator.isNotNull(cargo)) && (cargo.getVersao() > versao)) {
				throw new CargoAlteradoOutroUsuarioException();
			}
		}
	}
}