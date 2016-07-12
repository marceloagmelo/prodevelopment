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

package br.com.prodevelopment.eticket.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.eticket.TipoNomeObrigatorioException;
import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.portlet.type.social.TypeTicketActivityKeys;
import br.com.prodevelopment.eticket.service.base.TypeTicketLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.social.model.SocialActivityConstants;

/**
 * The implementation of the type ticket local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.eticket.service.TypeTicketLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.eticket.service.base.TypeTicketLocalServiceBaseImpl
 * @see br.com.prodevelopment.eticket.service.TypeTicketLocalServiceUtil
 */
public class TypeTicketLocalServiceImpl extends TypeTicketLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.eticket.service.TypeTicketLocalServiceUtil} to access the type ticket local service.
	 */
	private static Log _log = LogFactoryUtil
			.getLog(TypeTicketLocalServiceImpl.class);


	public TypeTicket addTypeTicket(long companyId, long groupId, long userIdCreate,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		validate(nameMap, locale);

		User userCreate = userPersistence.findByPrimaryKey(userIdCreate);

		long typeId = counterLocalService.increment();

		Date now = new Date();

		TypeTicket type = typeTicketPersistence.create(typeId);

		type.setUuid(serviceContext.getUuid());
		type.setGroupId(groupId);
		type.setCompanyId(userCreate.getCompanyId());
		type.setUserIdCreate(userCreate.getUserId());
		type.setCreateDate(serviceContext.getCreateDate(now));

		typeTicketPersistence.update(type);

		socialActivityLocalService.addActivity(userIdCreate, type.getGroupId(),
				TypeTicket.class.getName(), typeId, TypeTicketActivityKeys.ADD_TYPE,
				getExtraDataJSON(type, locale), 0);

		return type;
	}

	public TypeTicket updateTypeTicket(long typeId, long companyId, long groupId,
			long userIdModified, Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		validate(nameMap, locale);

		User userModified = userPersistence.findByPrimaryKey(userIdModified);

		Date now = new Date();

		TypeTicket type = typeTicketPersistence.fetchByPrimaryKey(typeId);

		type.setUuid(serviceContext.getUuid());
		type.setUserIdCreate(userModified.getUserId());
		type.setModifiedDate(serviceContext.getCreateDate(now));
		type.setNameMap(nameMap);
		type.setDescriptionMap(descriptionMap);

		typeTicketPersistence.update(type);

		socialActivityLocalService
				.addActivity(userIdModified, type.getGroupId(),
						TypeTicket.class.getName(), typeId,
						TypeTicketActivityKeys.UPDATE_TYPE,
						getExtraDataJSON(type, locale), 0);

		return type;
	}

	public TypeTicket deleteTypeTicket(TypeTicket typeTicket, long userId) throws SystemException {

		typeTicketPersistence.remove(typeTicket);

		try {
			// Trash

			trashEntryLocalService.deleteEntry(TypeTicket.class.getName(),
					typeTicket.getTypeTicketId());
		} catch (PortalException e) {
			_log.error(e, e);
		}

		return typeTicket;
	}

	public TypeTicket deleteTypeTicket(long typeId, long userId) throws PortalException, SystemException {

		TypeTicket type = typeTicketPersistence.findByPrimaryKey(typeId);

		return deleteTypeTicket(type, userId);
	}

	public TypeTicket moveTypeTicketToTrash(long userId, TypeTicket type) throws PortalException,
			SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		socialActivityCounterLocalService.disableActivityCounters(
				TypeTicket.class.getName(), type.getTypeTicketId());

		socialActivityLocalService.addActivity(userId, type.getGroupId(),
				TypeTicket.class.getName(), type.getTypeTicketId(),
				SocialActivityConstants.TYPE_MOVE_TO_TRASH,
				getExtraDataJSON(type, locale), 0);

		return type;
	}

	public TypeTicket moveTypeTicketToTrash(long userId, long typeId)
			throws PortalException, SystemException {

		TypeTicket type = typeTicketPersistence.findByPrimaryKey(typeId);

		return moveTypeTicketToTrash(userId, type);
	}

	public TypeTicket restoreTypeTicketFromTrash(long userId, long typeId)
			throws PortalException, SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		TypeTicket type = getTypeTicket(typeId);

		socialActivityCounterLocalService.enableActivityCounters(
				TypeTicket.class.getName(), typeId);

		socialActivityLocalService.addActivity(userId, type.getGroupId(),
				TypeTicket.class.getName(), typeId,
				SocialActivityConstants.TYPE_RESTORE_FROM_TRASH,
				getExtraDataJSON(type, locale), 0);

		return type;
	}

	public List<TypeTicket> search(long companyId, int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTicketPersistence.findByCompany(companyId, start, end, orderByComparator);
	}

	public int searchCount(long companyId)
			throws SystemException {
		return typeTicketPersistence.findByCompany(companyId).size();
	}

	public List<TypeTicket> search(long companyId, String name,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTicketPersistence.findByC_LikeName(companyId, name, start, end, orderByComparator);
	}

	public int searchCount(long companyId, String name)
			throws SystemException {
		return typeTicketPersistence.findByC_LikeName(companyId, name).size();
	}
	
	public List<TypeTicket> search(long companyId, long groupId, int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTicketPersistence.findByCG(companyId, groupId, start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId)
			throws SystemException {
		return typeTicketPersistence.findByCG(companyId, groupId).size();
	}

	public List<TypeTicket> search(long companyId, long groupId, String name,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTicketPersistence.findByCG_LikeName(companyId, groupId, name, start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, String name)
			throws SystemException {
		return typeTicketPersistence.findByCG_LikeName(companyId, groupId, name).size();
	}

	protected String getExtraDataJSON(TypeTicket type, Locale locale) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("name", type.getName(locale));

		return jsonObject.toString();
	}

	protected void validate(Map<Locale, String> nameMap, Locale locale)
			throws PortalException, SystemException {

		String name = nameMap.get(locale);

		if (Validator.isNull(name)) {
			throw new TipoNomeObrigatorioException();
		}
	}
}