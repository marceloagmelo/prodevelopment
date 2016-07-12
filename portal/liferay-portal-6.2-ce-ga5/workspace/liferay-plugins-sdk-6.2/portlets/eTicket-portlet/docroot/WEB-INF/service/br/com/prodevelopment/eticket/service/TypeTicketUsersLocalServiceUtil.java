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

package br.com.prodevelopment.eticket.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for TypeTicketUsers. This utility wraps
 * {@link br.com.prodevelopment.eticket.service.impl.TypeTicketUsersLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see TypeTicketUsersLocalService
 * @see br.com.prodevelopment.eticket.service.base.TypeTicketUsersLocalServiceBaseImpl
 * @see br.com.prodevelopment.eticket.service.impl.TypeTicketUsersLocalServiceImpl
 * @generated
 */
public class TypeTicketUsersLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.eticket.service.impl.TypeTicketUsersLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the type ticket users to the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicketUsers the type ticket users
	* @return the type ticket users that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers addTypeTicketUsers(
		br.com.prodevelopment.eticket.model.TypeTicketUsers typeTicketUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTypeTicketUsers(typeTicketUsers);
	}

	/**
	* Creates a new type ticket users with the primary key. Does not add the type ticket users to the database.
	*
	* @param typeTicketUsersId the primary key for the new type ticket users
	* @return the new type ticket users
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers createTypeTicketUsers(
		long typeTicketUsersId) {
		return getService().createTypeTicketUsers(typeTicketUsersId);
	}

	/**
	* Deletes the type ticket users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicketUsersId the primary key of the type ticket users
	* @return the type ticket users that was removed
	* @throws PortalException if a type ticket users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers deleteTypeTicketUsers(
		long typeTicketUsersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTypeTicketUsers(typeTicketUsersId);
	}

	/**
	* Deletes the type ticket users from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicketUsers the type ticket users
	* @return the type ticket users that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers deleteTypeTicketUsers(
		br.com.prodevelopment.eticket.model.TypeTicketUsers typeTicketUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTypeTicketUsers(typeTicketUsers);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.eticket.model.TypeTicketUsers fetchTypeTicketUsers(
		long typeTicketUsersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTypeTicketUsers(typeTicketUsersId);
	}

	/**
	* Returns the type ticket users with the primary key.
	*
	* @param typeTicketUsersId the primary key of the type ticket users
	* @return the type ticket users
	* @throws PortalException if a type ticket users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers getTypeTicketUsers(
		long typeTicketUsersId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypeTicketUsers(typeTicketUsersId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the type ticket userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type ticket userses
	* @param end the upper bound of the range of type ticket userses (not inclusive)
	* @return the range of type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> getTypeTicketUserses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypeTicketUserses(start, end);
	}

	/**
	* Returns the number of type ticket userses.
	*
	* @return the number of type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static int getTypeTicketUsersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypeTicketUsersesCount();
	}

	/**
	* Updates the type ticket users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param typeTicketUsers the type ticket users
	* @return the type ticket users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers updateTypeTicketUsers(
		br.com.prodevelopment.eticket.model.TypeTicketUsers typeTicketUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTypeTicketUsers(typeTicketUsers);
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

	public static br.com.prodevelopment.eticket.model.TypeTicketUsers addTypeTicketUsers(
		long userIdCreate, long typeTicketId, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTypeTicketUsers(userIdCreate, typeTicketId, userId,
			serviceContext);
	}

	public static br.com.prodevelopment.eticket.model.TypeTicketUsers deleteTypeTicketUsers(
		br.com.prodevelopment.eticket.model.TypeTicketUsers typeTicketUsers,
		long userId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTypeTicketUsers(typeTicketUsers, userId);
	}

	public static br.com.prodevelopment.eticket.model.TypeTicketUsers deleteTypeTicketUsers(
		long typeTicketUsersId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTypeTicketUsers(typeTicketUsersId, userId);
	}

	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> searchByTypeTcket(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchByTypeTcket(typeId, start, end, orderByComparator);
	}

	public static int searchByTypeTicketCount(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchByTypeTicketCount(typeId);
	}

	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> searchByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchByUser(userId, start, end, orderByComparator);
	}

	public static int searchByUserCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchByUserCount(userId);
	}

	public static br.com.prodevelopment.eticket.model.TypeTicketUsers getTypeTicketUsers(
		long typeId, long userId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypeTicketUsers(typeId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TypeTicketUsersLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TypeTicketUsersLocalService.class.getName());

			if (invokableLocalService instanceof TypeTicketUsersLocalService) {
				_service = (TypeTicketUsersLocalService)invokableLocalService;
			}
			else {
				_service = new TypeTicketUsersLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TypeTicketUsersLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TypeTicketUsersLocalService service) {
	}

	private static TypeTicketUsersLocalService _service;
}