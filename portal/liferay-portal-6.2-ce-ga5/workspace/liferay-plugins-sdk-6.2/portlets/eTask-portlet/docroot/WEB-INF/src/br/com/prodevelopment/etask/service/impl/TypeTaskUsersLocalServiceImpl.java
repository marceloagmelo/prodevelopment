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

package br.com.prodevelopment.etask.service.impl;

import java.util.Date;
import java.util.List;

import br.com.prodevelopment.etask.NoSuchTypeTaskException;
import br.com.prodevelopment.etask.NoSuchTypeTaskUsersException;
import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.model.TypeTaskUsers;
import br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil;
import br.com.prodevelopment.etask.service.base.TypeTaskUsersLocalServiceBaseImpl;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the type task users local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.etask.service.TypeTaskUsersLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo Melo
 * @see br.com.prodevelopment.etask.service.base.TypeTaskUsersLocalServiceBaseImpl
 * @see br.com.prodevelopment.etask.service.TypeTaskUsersLocalServiceUtil
 */
public class TypeTaskUsersLocalServiceImpl extends
		TypeTaskUsersLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.etask.service.TypeTaskUsersLocalServiceUtil} to
	 * access the type task users local service.
	 */
	private static Log _log = LogFactoryUtil
			.getLog(TypeTaskUsersLocalServiceImpl.class);

	public TypeTaskUsers addTypeTaskUsers(long userIdCreate, long typeTaskId,
			long userId, String typeUser, ServiceContext serviceContext)
			throws PortalException, SystemException {

		long typeTaskUsersId = counterLocalService.increment();

		Date now = new Date();

		TypeTaskUsers typeTaskUsers = typeTaskUsersPersistence
				.create(typeTaskUsersId);

		typeTaskUsers.setUserIdCreate(userIdCreate);
		typeTaskUsers.setCreateDate(serviceContext.getCreateDate(now));
		typeTaskUsers.setTypeTaskId(typeTaskId);
		typeTaskUsers.setUserId(userId);
		typeTaskUsers.setTypeUser(typeUser);

		typeTaskUsersPersistence.update(typeTaskUsers);
		return typeTaskUsers;
	}

	public TypeTaskUsers deleteTypeTaskUsers(TypeTaskUsers typeTaskUsers,
			long userId) throws SystemException, NoSuchTypeTaskException,
			NoSuchTypeTaskUsersException, NoSuchUserException {

		try {
			typeTaskUsersLocalService.deleteTypeTaskUsers(typeTaskUsers
					.getPrimaryKey());

		} catch (PortalException e) {
			_log.error(e, e);
		}

		return typeTaskUsers;
	}

	public TypeTaskUsers deleteTypeTaskUsers(long typeTaskUsersId, long userId)
			throws PortalException, SystemException {

		TypeTaskUsers typeTaskUsers = typeTaskUsersPersistence
				.findByPrimaryKey(typeTaskUsersId);

		return deleteTypeTaskUsers(typeTaskUsers, userId);
	}

	public void addUsers(long typeTaskId, long[] userIds, String typeUser,
			long userIdCreate, ServiceContext serviceContext)
			throws PortalException, SystemException {

		TypeTask typeTask = TypeTaskLocalServiceUtil.getTypeTask(typeTaskId);

		if (Validator.isNotNull(typeTask)) {
			for (long userId : userIds) {
				TypeTaskUsers typeTaskUsers = typeTaskUsersPersistence
						.fetchByTypeTaskUserType(typeTaskId, userId, typeUser);
				if (Validator.isNull(typeTaskUsers)) {
					addTypeTaskUsers(userIdCreate, typeTaskId, userId, typeUser,
							serviceContext);
				}
			}
		}
	}

	public void removeUsers(long typeTaskId, long[] userIds, String typeUser)
			throws PortalException, SystemException {

		for (long userId : userIds) {
			TypeTaskUsers typeTaskUsers = typeTaskUsersPersistence
					.fetchByTypeTaskUserType(typeTaskId, userId, typeUser);
			if (Validator.isNotNull(typeTaskUsers)) {
				typeTaskUsersPersistence.remove(typeTaskUsers
						.getTypeTaskUsersId());
			}
		}
	}

	public void updateUsers(long typeTaskId, long[] addUserIds,
			long[] removeUserIds, String typeUser, long userIdCreate,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		removeUsers(typeTaskId, removeUserIds, typeUser);
		addUsers(typeTaskId, addUserIds, typeUser, userIdCreate, serviceContext);
	}

	public List<TypeTaskUsers> searchByTypeTask(long typeTaskId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTaskUsersPersistence.findByTypeTask(typeTaskId, start, end,
				orderByComparator);
	}

	public int searchByTypeTaskCount(long typeId) throws SystemException {
		return typeTaskUsersPersistence.findByTypeTask(typeId).size();
	}

	public List<TypeTaskUsers> searchByUser(long userId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return typeTaskUsersPersistence.findByUser(userId, start, end,
				orderByComparator);
	}

	public int searchByUserCount(long userId) throws SystemException {
		return typeTaskUsersPersistence.findByUser(userId).size();
	}

	public TypeTaskUsers getTypeTaskUsers(long typeTaskId, long userId,
			String typeUser) throws SystemException,
			NoSuchTypeTaskUsersException {
		return typeTaskUsersPersistence.fetchByTypeTaskUserType(typeTaskId, userId, typeUser);		
	}

	protected String getExtraDataJSON(User user) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("name", user.getFullName());

		return jsonObject.toString();
	}
}