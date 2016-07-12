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

package br.com.prodevelopment.etask.service.persistence;

import br.com.prodevelopment.etask.model.TypeTask;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the type task service. This utility wraps {@link TypeTaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTaskPersistence
 * @see TypeTaskPersistenceImpl
 * @generated
 */
public class TypeTaskUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TypeTask typeTask) {
		getPersistence().clearCache(typeTask);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TypeTask> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TypeTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TypeTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TypeTask update(TypeTask typeTask) throws SystemException {
		return getPersistence().update(typeTask);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TypeTask update(TypeTask typeTask,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(typeTask, serviceContext);
	}

	/**
	* Returns all the type tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the type tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where uuid = &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByUuid_PrevAndNext(
		long typeTaskId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(typeTaskId, uuid, orderByComparator);
	}

	/**
	* Removes all the type tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of type tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the type task where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the type task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the type task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the type task where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the type task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of type tasks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the type tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the type tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByUuid_C_PrevAndNext(
		long typeTaskId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(typeTaskId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the type tasks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of type tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the type tasks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where companyId = &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByCompany_PrevAndNext(
		long typeTaskId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(typeTaskId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the type tasks where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of type tasks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG(companyId, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByCG_PrevAndNext(
		long typeTaskId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_PrevAndNext(typeTaskId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG(companyId, groupId);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG(companyId, groupId);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG_S(companyId, groupId, status);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S(companyId, groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S(companyId, groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_S_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_First(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_S_First(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_S_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Last(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_S_Last(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByCG_S_PrevAndNext(
		long typeTaskId, long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_PrevAndNext(typeTaskId, companyId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG_S(companyId, groupId, statuses);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S(companyId, groupId, statuses, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S(companyId, groupId, statuses, start, end,
			orderByComparator);
	}

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_S(long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG_S(companyId, groupId, status);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_S(long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG_S(companyId, groupId, status);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_S(long companyId, long groupId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG_S(companyId, groupId, statuses);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG_LikeName(companyId, groupId, name);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName(companyId, groupId, name, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName(companyId, groupId, name, start, end,
			orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_LikeName_First(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName_First(companyId, groupId, name,
			orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_LikeName_First(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_LikeName_First(companyId, groupId, name,
			orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_LikeName_Last(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName_Last(companyId, groupId, name,
			orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_LikeName_Last(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_LikeName_Last(companyId, groupId, name,
			orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByCG_LikeName_PrevAndNext(
		long typeTaskId, long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName_PrevAndNext(typeTaskId, companyId,
			groupId, name, orderByComparator);
	}

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_LikeName(long companyId, long groupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG_LikeName(companyId, groupId, name);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_LikeName(long companyId, long groupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG_LikeName(companyId, groupId, name);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_Class(
		long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG_Class(companyId, groupId, classNameId);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_Class(
		long companyId, long groupId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Class(companyId, groupId, classNameId, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_Class(
		long companyId, long groupId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Class(companyId, groupId, classNameId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_Class_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Class_First(companyId, groupId, classNameId,
			orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_Class_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Class_First(companyId, groupId, classNameId,
			orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_Class_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Class_Last(companyId, groupId, classNameId,
			orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_Class_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Class_Last(companyId, groupId, classNameId,
			orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByCG_Class_PrevAndNext(
		long typeTaskId, long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Class_PrevAndNext(typeTaskId, companyId, groupId,
			classNameId, orderByComparator);
	}

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_Class(long companyId, long groupId,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG_Class(companyId, groupId, classNameId);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_Class(long companyId, long groupId,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG_Class(companyId, groupId, classNameId);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int status, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName(companyId, groupId, status, name);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int status, java.lang.String name,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName(companyId, groupId, status, name,
			start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int status, java.lang.String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName(companyId, groupId, status, name,
			start, end, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_S_LikeName_First(
		long companyId, long groupId, int status, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_First(companyId, groupId, status, name,
			orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_LikeName_First(
		long companyId, long groupId, int status, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_S_LikeName_First(companyId, groupId, status,
			name, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_S_LikeName_Last(
		long companyId, long groupId, int status, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Last(companyId, groupId, status, name,
			orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_LikeName_Last(
		long companyId, long groupId, int status, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_S_LikeName_Last(companyId, groupId, status, name,
			orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByCG_S_LikeName_PrevAndNext(
		long typeTaskId, long companyId, long groupId, int status,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_PrevAndNext(typeTaskId, companyId,
			groupId, status, name, orderByComparator);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param name the name
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int[] statuses, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName(companyId, groupId, statuses, name);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param name the name
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName(companyId, groupId, statuses, name,
			start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param name the name
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName(companyId, groupId, statuses, name,
			start, end, orderByComparator);
	}

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_S_LikeName(long companyId, long groupId,
		int status, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCG_S_LikeName(companyId, groupId, status, name);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_S_LikeName(long companyId, long groupId,
		int status, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_S_LikeName(companyId, groupId, status, name);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param name the name
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_S_LikeName(long companyId, long groupId,
		int[] statuses, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_S_LikeName(companyId, groupId, statuses, name);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int status, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class(companyId, groupId, status, classNameId);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int status, long classNameId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class(companyId, groupId, status, classNameId,
			start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int status, long classNameId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class(companyId, groupId, status, classNameId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_S_Class_First(
		long companyId, long groupId, int status, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class_First(companyId, groupId, status,
			classNameId, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_Class_First(
		long companyId, long groupId, int status, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_S_Class_First(companyId, groupId, status,
			classNameId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_S_Class_Last(
		long companyId, long groupId, int status, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class_Last(companyId, groupId, status,
			classNameId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_Class_Last(
		long companyId, long groupId, int status, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_S_Class_Last(companyId, groupId, status,
			classNameId, orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByCG_S_Class_PrevAndNext(
		long typeTaskId, long companyId, long groupId, int status,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class_PrevAndNext(typeTaskId, companyId,
			groupId, status, classNameId, orderByComparator);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param classNameId the class name ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int[] statuses, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class(companyId, groupId, statuses, classNameId);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int[] statuses, long classNameId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class(companyId, groupId, statuses, classNameId,
			start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int[] statuses, long classNameId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_Class(companyId, groupId, statuses, classNameId,
			start, end, orderByComparator);
	}

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_S_Class(long companyId, long groupId,
		int status, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_S_Class(companyId, groupId, status, classNameId);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_S_Class(long companyId, long groupId,
		int status, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_S_Class(companyId, groupId, status, classNameId);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param classNameId the class name ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_S_Class(long companyId, long groupId,
		int[] statuses, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_S_Class(companyId, groupId, statuses, classNameId);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class(companyId, groupId, status, name,
			classNameId);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class(companyId, groupId, status, name,
			classNameId, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class(companyId, groupId, status, name,
			classNameId, start, end, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_S_LikeName_Class_First(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class_First(companyId, groupId, status,
			name, classNameId, orderByComparator);
	}

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_LikeName_Class_First(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_S_LikeName_Class_First(companyId, groupId,
			status, name, classNameId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByCG_S_LikeName_Class_Last(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class_Last(companyId, groupId, status,
			name, classNameId, orderByComparator);
	}

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_LikeName_Class_Last(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_S_LikeName_Class_Last(companyId, groupId, status,
			name, classNameId, orderByComparator);
	}

	/**
	* Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* @param typeTaskId the primary key of the current type task
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask[] findByCG_S_LikeName_Class_PrevAndNext(
		long typeTaskId, long companyId, long groupId, int status,
		java.lang.String name, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class_PrevAndNext(typeTaskId,
			companyId, groupId, status, name, classNameId, orderByComparator);
	}

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param name the name
	* @param classNameId the class name ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class(companyId, groupId, statuses,
			name, classNameId);
	}

	/**
	* Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param name the name
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class(companyId, groupId, statuses,
			name, classNameId, start, end);
	}

	/**
	* Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param name the name
	* @param classNameId the class name ID
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_S_LikeName_Class(companyId, groupId, statuses,
			name, classNameId, start, end, orderByComparator);
	}

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCG_S_LikeName_Class(long companyId,
		long groupId, int status, java.lang.String name, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCG_S_LikeName_Class(companyId, groupId, status, name,
			classNameId);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @param classNameId the class name ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_S_LikeName_Class(long companyId, long groupId,
		int status, java.lang.String name, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_S_LikeName_Class(companyId, groupId, status,
			name, classNameId);
	}

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @param name the name
	* @param classNameId the class name ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_S_LikeName_Class(long companyId, long groupId,
		int[] statuses, java.lang.String name, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCG_S_LikeName_Class(companyId, groupId, statuses,
			name, classNameId);
	}

	/**
	* Returns the type task where classPK = &#63; or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	*
	* @param classPK the class p k
	* @return the matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByTypeTaskClassPK(
		long classPK)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeTaskClassPK(classPK);
	}

	/**
	* Returns the type task where classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classPK the class p k
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByTypeTaskClassPK(
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTypeTaskClassPK(classPK);
	}

	/**
	* Returns the type task where classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByTypeTaskClassPK(
		long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTaskClassPK(classPK, retrieveFromCache);
	}

	/**
	* Removes the type task where classPK = &#63; from the database.
	*
	* @param classPK the class p k
	* @return the type task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask removeByTypeTaskClassPK(
		long classPK)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByTypeTaskClassPK(classPK);
	}

	/**
	* Returns the number of type tasks where classPK = &#63;.
	*
	* @param classPK the class p k
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeTaskClassPK(long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeTaskClassPK(classPK);
	}

	/**
	* Caches the type task in the entity cache if it is enabled.
	*
	* @param typeTask the type task
	*/
	public static void cacheResult(
		br.com.prodevelopment.etask.model.TypeTask typeTask) {
		getPersistence().cacheResult(typeTask);
	}

	/**
	* Caches the type tasks in the entity cache if it is enabled.
	*
	* @param typeTasks the type tasks
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.etask.model.TypeTask> typeTasks) {
		getPersistence().cacheResult(typeTasks);
	}

	/**
	* Creates a new type task with the primary key. Does not add the type task to the database.
	*
	* @param typeTaskId the primary key for the new type task
	* @return the new type task
	*/
	public static br.com.prodevelopment.etask.model.TypeTask create(
		long typeTaskId) {
		return getPersistence().create(typeTaskId);
	}

	/**
	* Removes the type task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskId the primary key of the type task
	* @return the type task that was removed
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask remove(
		long typeTaskId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(typeTaskId);
	}

	public static br.com.prodevelopment.etask.model.TypeTask updateImpl(
		br.com.prodevelopment.etask.model.TypeTask typeTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(typeTask);
	}

	/**
	* Returns the type task with the primary key or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	*
	* @param typeTaskId the primary key of the type task
	* @return the type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask findByPrimaryKey(
		long typeTaskId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(typeTaskId);
	}

	/**
	* Returns the type task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeTaskId the primary key of the type task
	* @return the type task, or <code>null</code> if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTask fetchByPrimaryKey(
		long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(typeTaskId);
	}

	/**
	* Returns all the type tasks.
	*
	* @return the type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the type tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the type tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the type tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of type tasks.
	*
	* @return the number of type tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TypeTaskPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TypeTaskPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.etask.service.ClpSerializer.getServletContextName(),
					TypeTaskPersistence.class.getName());

			ReferenceRegistry.registerReference(TypeTaskUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TypeTaskPersistence persistence) {
	}

	private static TypeTaskPersistence _persistence;
}