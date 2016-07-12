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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for TypeTaskUsers. This utility wraps
 * {@link br.com.prodevelopment.etask.service.impl.TypeTaskUsersLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see TypeTaskUsersLocalService
 * @see br.com.prodevelopment.etask.service.base.TypeTaskUsersLocalServiceBaseImpl
 * @see br.com.prodevelopment.etask.service.impl.TypeTaskUsersLocalServiceImpl
 * @generated
 */
public class TypeTaskUsersLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.etask.service.impl.TypeTaskUsersLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the type task users to the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsers the type task users
	* @return the type task users that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers addTypeTaskUsers(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTypeTaskUsers(typeTaskUsers);
	}

	/**
	* Creates a new type task users with the primary key. Does not add the type task users to the database.
	*
	* @param typeTaskUsersId the primary key for the new type task users
	* @return the new type task users
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers createTypeTaskUsers(
		long typeTaskUsersId) {
		return getService().createTypeTaskUsers(typeTaskUsersId);
	}

	/**
	* Deletes the type task users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users that was removed
	* @throws PortalException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers deleteTypeTaskUsers(
		long typeTaskUsersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTypeTaskUsers(typeTaskUsersId);
	}

	/**
	* Deletes the type task users from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsers the type task users
	* @return the type task users that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers deleteTypeTaskUsers(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTypeTaskUsers(typeTaskUsers);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchTypeTaskUsers(
		long typeTaskUsersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTypeTaskUsers(typeTaskUsersId);
	}

	/**
	* Returns the type task users with the primary key.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users
	* @throws PortalException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers getTypeTaskUsers(
		long typeTaskUsersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypeTaskUsers(typeTaskUsersId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> getTypeTaskUserses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypeTaskUserses(start, end);
	}

	/**
	* Returns the number of type task userses.
	*
	* @return the number of type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static int getTypeTaskUsersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypeTaskUsersesCount();
	}

	/**
	* Updates the type task users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsers the type task users
	* @return the type task users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers updateTypeTaskUsers(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTypeTaskUsers(typeTaskUsers);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static br.com.prodevelopment.etask.model.TypeTaskUsers addTypeTaskUsers(
		long userIdCreate, long typeTaskId, long userId,
		java.lang.String typeUser,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTypeTaskUsers(userIdCreate, typeTaskId, userId,
			typeUser, serviceContext);
	}

	public static br.com.prodevelopment.etask.model.TypeTaskUsers deleteTypeTaskUsers(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers,
		long userId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTypeTaskUsers(typeTaskUsers, userId);
	}

	public static br.com.prodevelopment.etask.model.TypeTaskUsers deleteTypeTaskUsers(
		long typeTaskUsersId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTypeTaskUsers(typeTaskUsersId, userId);
	}

	public static void addUsers(long typeTaskId, long[] userIds,
		java.lang.String typeUser, long userIdCreate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addUsers(typeTaskId, userIds, typeUser, userIdCreate,
			serviceContext);
	}

	public static void removeUsers(long typeTaskId, long[] userIds,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeUsers(typeTaskId, userIds, typeUser);
	}

	public static void updateUsers(long typeTaskId, long[] addUserIds,
		long[] removeUserIds, java.lang.String typeUser, long userIdCreate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateUsers(typeTaskId, addUserIds, removeUserIds, typeUser,
			userIdCreate, serviceContext);
	}

	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> searchByTypeTask(
		long typeTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchByTypeTask(typeTaskId, start, end, orderByComparator);
	}

	public static int searchByTypeTaskCount(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchByTypeTaskCount(typeId);
	}

	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> searchByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchByUser(userId, start, end, orderByComparator);
	}

	public static int searchByUserCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchByUserCount(userId);
	}

	public static br.com.prodevelopment.etask.model.TypeTaskUsers getTypeTaskUsers(
		long typeTaskId, long userId, java.lang.String typeUser)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypeTaskUsers(typeTaskId, userId, typeUser);
	}

	public static void clearService() {
		_service = null;
	}

	public static TypeTaskUsersLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TypeTaskUsersLocalService.class.getName());

			if (invokableLocalService instanceof TypeTaskUsersLocalService) {
				_service = (TypeTaskUsersLocalService)invokableLocalService;
			}
			else {
				_service = new TypeTaskUsersLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TypeTaskUsersLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TypeTaskUsersLocalService service) {
	}

	private static TypeTaskUsersLocalService _service;
}