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

package br.com.prodevelopment.etask.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TypeTaskUsersLocalService}.
 *
 * @author Marcelo Melo
 * @see TypeTaskUsersLocalService
 * @generated
 */
public class TypeTaskUsersLocalServiceWrapper
	implements TypeTaskUsersLocalService,
		ServiceWrapper<TypeTaskUsersLocalService> {
	public TypeTaskUsersLocalServiceWrapper(
		TypeTaskUsersLocalService typeTaskUsersLocalService) {
		_typeTaskUsersLocalService = typeTaskUsersLocalService;
	}

	/**
	* Adds the type task users to the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsers the type task users
	* @return the type task users that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers addTypeTaskUsers(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.addTypeTaskUsers(typeTaskUsers);
	}

	/**
	* Creates a new type task users with the primary key. Does not add the type task users to the database.
	*
	* @param typeTaskUsersId the primary key for the new type task users
	* @return the new type task users
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers createTypeTaskUsers(
		long typeTaskUsersId) {
		return _typeTaskUsersLocalService.createTypeTaskUsers(typeTaskUsersId);
	}

	/**
	* Deletes the type task users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users that was removed
	* @throws PortalException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers deleteTypeTaskUsers(
		long typeTaskUsersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.deleteTypeTaskUsers(typeTaskUsersId);
	}

	/**
	* Deletes the type task users from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsers the type task users
	* @return the type task users that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers deleteTypeTaskUsers(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.deleteTypeTaskUsers(typeTaskUsers);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _typeTaskUsersLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchTypeTaskUsers(
		long typeTaskUsersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.fetchTypeTaskUsers(typeTaskUsersId);
	}

	/**
	* Returns the type task users with the primary key.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users
	* @throws PortalException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers getTypeTaskUsers(
		long typeTaskUsersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.getTypeTaskUsers(typeTaskUsersId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the type task userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @return the range of type task userses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> getTypeTaskUserses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.getTypeTaskUserses(start, end);
	}

	/**
	* Returns the number of type task userses.
	*
	* @return the number of type task userses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTypeTaskUsersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.getTypeTaskUsersesCount();
	}

	/**
	* Updates the type task users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsers the type task users
	* @return the type task users that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers updateTypeTaskUsers(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.updateTypeTaskUsers(typeTaskUsers);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _typeTaskUsersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_typeTaskUsersLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _typeTaskUsersLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers addTypeTaskUsers(
		long userIdCreate, long typeTaskId, long userId,
		java.lang.String typeUser,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.addTypeTaskUsers(userIdCreate,
			typeTaskId, userId, typeUser, serviceContext);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers deleteTypeTaskUsers(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers,
		long userId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.deleteTypeTaskUsers(typeTaskUsers,
			userId);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers deleteTypeTaskUsers(
		long typeTaskUsersId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.deleteTypeTaskUsers(typeTaskUsersId,
			userId);
	}

	@Override
	public void addUsers(long typeTaskId, long[] userIds,
		java.lang.String typeUser, long userIdCreate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_typeTaskUsersLocalService.addUsers(typeTaskId, userIds, typeUser,
			userIdCreate, serviceContext);
	}

	@Override
	public void removeUsers(long typeTaskId, long[] userIds,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_typeTaskUsersLocalService.removeUsers(typeTaskId, userIds, typeUser);
	}

	@Override
	public void updateUsers(long typeTaskId, long[] addUserIds,
		long[] removeUserIds, java.lang.String typeUser, long userIdCreate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_typeTaskUsersLocalService.updateUsers(typeTaskId, addUserIds,
			removeUserIds, typeUser, userIdCreate, serviceContext);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> searchByTypeTask(
		long typeTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.searchByTypeTask(typeTaskId, start,
			end, orderByComparator);
	}

	@Override
	public int searchByTypeTaskCount(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.searchByTypeTaskCount(typeId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> searchByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.searchByUser(userId, start, end,
			orderByComparator);
	}

	@Override
	public int searchByUserCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.searchByUserCount(userId);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers getTypeTaskUsers(
		long typeTaskId, long userId, java.lang.String typeUser)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsersLocalService.getTypeTaskUsers(typeTaskId, userId,
			typeUser);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TypeTaskUsersLocalService getWrappedTypeTaskUsersLocalService() {
		return _typeTaskUsersLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTypeTaskUsersLocalService(
		TypeTaskUsersLocalService typeTaskUsersLocalService) {
		_typeTaskUsersLocalService = typeTaskUsersLocalService;
	}

	@Override
	public TypeTaskUsersLocalService getWrappedService() {
		return _typeTaskUsersLocalService;
	}

	@Override
	public void setWrappedService(
		TypeTaskUsersLocalService typeTaskUsersLocalService) {
		_typeTaskUsersLocalService = typeTaskUsersLocalService;
	}

	private TypeTaskUsersLocalService _typeTaskUsersLocalService;
}