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

import br.com.prodevelopment.eticket.NoSuchTypeTicketException;
import br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException;
import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.model.TypeTicketUsers;
import br.com.prodevelopment.eticket.portlet.type.social.TypeTicketActivityKeys;
import br.com.prodevelopment.eticket.service.base.TypeTicketUsersLocalServiceBaseImpl;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
/**
 * The implementation of the type ticket users local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.eticket.service.TypeTicketUsersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.eticket.service.base.TypeTicketUsersLocalServiceBaseImpl
 * @see br.com.prodevelopment.eticket.service.TypeTicketUsersLocalServiceUtil
 */
public class TypeTicketUsersLocalServiceImpl
	extends TypeTicketUsersLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.eticket.service.TypeTicketUsersLocalServiceUtil} to access the type ticket users local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(TypeTicketUsersLocalServiceImpl.class);
	
	public TypeTicketUsers addTypeTicketUsers(long userIdCreate, long typeTicketId, long userId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User userCreate = userPersistence.findByPrimaryKey(userIdCreate);
		User user = userPersistence.findByPrimaryKey(userId);

		TypeTicket typeTicket = typeTicketPersistence.fetchByPrimaryKey(typeTicketId);
		
		long typeTicketUsersId = counterLocalService.increment();

		Date now = new Date();

		TypeTicketUsers typeTicketUsers = typeTicketUsersPersistence.create(
				typeTicketUsersId);

		typeTicketUsers.setUserIdCreate(userCreate.getUserId());
		typeTicketUsers.setCreateDate(serviceContext.getCreateDate(now));
		typeTicketUsers.setTypeTicketId(typeTicketId);
		typeTicketUsers.setUserId(userId);
		
		typeTicketUsersPersistence.update(typeTicketUsers);

		socialActivityLocalService.addActivity(
				userIdCreate, typeTicket.getGroupId(),
				TypeTicket.class.getName(), typeTicketId,
			TypeTicketActivityKeys.ADD_TYPE_USER,
			getExtraDataJSON(user), 0);

		return typeTicketUsers;
	}

	public TypeTicketUsers deleteTypeTicketUsers(TypeTicketUsers typeTicketUsers, long userId) throws SystemException, NoSuchTypeTicketException, NoSuchTypeTicketUsersException, NoSuchUserException {

		TypeTicket typeTicket =	typeTicketPersistence.findByPrimaryKey(typeTicketUsers.getTypeTicketId());
		User user = userPersistence.findByPrimaryKey(userId);

		try {
			typeTicketUsersLocalService.deleteTypeTicketUsers(typeTicketUsers.getPrimaryKey());
			
			// Social

			// try to get the user from the pruser for social
			// there will be no link if the user wasn't logged in
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();
			
			String name = user.getFullName();

			extraDataJSONObject.put("name", name);

			socialActivityLocalService.addActivity(userId,
					typeTicket.getGroupId(), TypeTicket.class.getName(),
					typeTicketUsers.getTypeTicketUsersId(),
					TypeTicketActivityKeys.DELETE_TYPE_USER,
					extraDataJSONObject.toString(), 0);
			
		} catch (PortalException e) {
			_log.error(e, e);
		}

		return typeTicketUsers;
	}

	public TypeTicketUsers deleteTypeTicketUsers(long typeTicketUsersId, long userId) throws PortalException, SystemException {

		TypeTicketUsers typeTicketUsers = typeTicketUsersPersistence.findByPrimaryKey(typeTicketUsersId);

		return deleteTypeTicketUsers(typeTicketUsers, userId);
	}

	public List<TypeTicketUsers> searchByTypeTcket(long typeId, int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTicketUsersPersistence.findByTypeTicket(typeId, start, end, orderByComparator);
	}
	
	public int searchByTypeTicketCount(long typeId)
			throws SystemException {
		return typeTicketUsersPersistence.findByTypeTicket(typeId).size();
	}

	public List<TypeTicketUsers> searchByUser(long userId, int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTicketUsersPersistence.findByUser(userId, start, end, orderByComparator);
	}
	
	public int searchByUserCount(long userId)
			throws SystemException {
		return typeTicketUsersPersistence.findByUser(userId).size();
	}
	
	public TypeTicketUsers getTypeTicketUsers(long typeId, long userId)
			throws SystemException, NoSuchTypeTicketUsersException {
		return typeTicketUsersPersistence.findByTypeUser(userId, typeId);
	}
	
	protected String getExtraDataJSON(User user) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("name", user.getFullName());

		return jsonObject.toString();
	}
}