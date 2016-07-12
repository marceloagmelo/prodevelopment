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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the type task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTaskPersistenceImpl
 * @see TypeTaskUtil
 * @generated
 */
public interface TypeTaskPersistence extends BasePersistence<TypeTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeTaskUtil} to access the type task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the type tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByUuid_PrevAndNext(
		long typeTaskId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the type task where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the type task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByUuid_C_PrevAndNext(
		long typeTaskId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tasks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByCompany_PrevAndNext(
		long typeTaskId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByCG_PrevAndNext(
		long typeTaskId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_S_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_S_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByCG_S_PrevAndNext(
		long typeTaskId, long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S(
		long companyId, long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_S(long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_S(long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statuses the statuses
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_S(long companyId, long groupId, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_LikeName_First(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_LikeName_First(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_LikeName_Last(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_LikeName_Last(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByCG_LikeName_PrevAndNext(
		long typeTaskId, long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_LikeName(long companyId, long groupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_LikeName(long companyId, long groupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_Class(
		long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_Class(
		long companyId, long groupId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_Class(
		long companyId, long groupId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_Class_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_Class_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_Class_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_Class_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByCG_Class_PrevAndNext(
		long typeTaskId, long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_Class(long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_Class(long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int status, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int status, java.lang.String name,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int status, java.lang.String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_S_LikeName_First(
		long companyId, long groupId, int status, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_LikeName_First(
		long companyId, long groupId, int status, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_S_LikeName_Last(
		long companyId, long groupId, int status, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_LikeName_Last(
		long companyId, long groupId, int status, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByCG_S_LikeName_PrevAndNext(
		long typeTaskId, long companyId, long groupId, int status,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int[] statuses, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_S_LikeName(long companyId, long groupId, int status,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_S_LikeName(long companyId, long groupId, int status,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_S_LikeName(long companyId, long groupId,
		int[] statuses, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int status, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int status, long classNameId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int status, long classNameId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_S_Class_First(
		long companyId, long groupId, int status, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_Class_First(
		long companyId, long groupId, int status, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_S_Class_Last(
		long companyId, long groupId, int status, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_Class_Last(
		long companyId, long groupId, int status, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByCG_S_Class_PrevAndNext(
		long typeTaskId, long companyId, long groupId, int status,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int[] statuses, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int[] statuses, long classNameId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_Class(
		long companyId, long groupId, int[] statuses, long classNameId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG_S_Class(long companyId, long groupId, int status,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_S_Class(long companyId, long groupId, int status,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_S_Class(long companyId, long groupId, int[] statuses,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_S_LikeName_Class_First(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_LikeName_Class_First(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask findByCG_S_LikeName_Class_Last(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask fetchByCG_S_LikeName_Class_Last(
		long companyId, long groupId, int status, java.lang.String name,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTask[] findByCG_S_LikeName_Class_PrevAndNext(
		long typeTaskId, long companyId, long groupId, int status,
		java.lang.String name, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findByCG_S_LikeName_Class(
		long companyId, long groupId, int[] statuses, java.lang.String name,
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByCG_S_LikeName_Class(long companyId, long groupId,
		int status, java.lang.String name, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_S_LikeName_Class(long companyId, long groupId,
		int status, java.lang.String name, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCG_S_LikeName_Class(long companyId, long groupId,
		int[] statuses, java.lang.String name, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task where classPK = &#63; or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	*
	* @param classPK the class p k
	* @return the matching type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask findByTypeTaskClassPK(
		long classPK)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task where classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classPK the class p k
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByTypeTaskClassPK(
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task where classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByTypeTaskClassPK(
		long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the type task where classPK = &#63; from the database.
	*
	* @param classPK the class p k
	* @return the type task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask removeByTypeTaskClassPK(
		long classPK)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks where classPK = &#63;.
	*
	* @param classPK the class p k
	* @return the number of matching type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeTaskClassPK(long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the type task in the entity cache if it is enabled.
	*
	* @param typeTask the type task
	*/
	public void cacheResult(br.com.prodevelopment.etask.model.TypeTask typeTask);

	/**
	* Caches the type tasks in the entity cache if it is enabled.
	*
	* @param typeTasks the type tasks
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.etask.model.TypeTask> typeTasks);

	/**
	* Creates a new type task with the primary key. Does not add the type task to the database.
	*
	* @param typeTaskId the primary key for the new type task
	* @return the new type task
	*/
	public br.com.prodevelopment.etask.model.TypeTask create(long typeTaskId);

	/**
	* Removes the type task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskId the primary key of the type task
	* @return the type task that was removed
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask remove(long typeTaskId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.etask.model.TypeTask updateImpl(
		br.com.prodevelopment.etask.model.TypeTask typeTask)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task with the primary key or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	*
	* @param typeTaskId the primary key of the type task
	* @return the type task
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask findByPrimaryKey(
		long typeTaskId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeTaskId the primary key of the type task
	* @return the type task, or <code>null</code> if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTask fetchByPrimaryKey(
		long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tasks.
	*
	* @return the type tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tasks.
	*
	* @return the number of type tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}