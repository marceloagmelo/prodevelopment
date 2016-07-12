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

package br.com.prodevelopment.eticket.service.persistence;

import br.com.prodevelopment.eticket.model.TypeTicket;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the type ticket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTicketPersistenceImpl
 * @see TypeTicketUtil
 * @generated
 */
public interface TypeTicketPersistence extends BasePersistence<TypeTicket> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeTicketUtil} to access the type ticket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the type tickets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the type tickets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @return the range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the type tickets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type tickets before and after the current type ticket in the ordered set where uuid = &#63;.
	*
	* @param typeTicketId the primary key of the current type ticket
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket[] findByUuid_PrevAndNext(
		long typeTicketId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tickets where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tickets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type ticket where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type ticket where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type ticket where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the type ticket where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the type ticket that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tickets where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tickets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the type tickets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @return the range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the type tickets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type tickets before and after the current type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param typeTicketId the primary key of the current type ticket
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket[] findByUuid_C_PrevAndNext(
		long typeTicketId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tickets where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tickets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tickets where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByC_LikeName(
		long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the type tickets where companyId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param name the name
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @return the range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByC_LikeName(
		long companyId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the type tickets where companyId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param name the name
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByC_LikeName(
		long companyId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByC_LikeName_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByC_LikeName_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByC_LikeName_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByC_LikeName_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type tickets before and after the current type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param typeTicketId the primary key of the current type ticket
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket[] findByC_LikeName_PrevAndNext(
		long typeTicketId, long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tickets where companyId = &#63; and name LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_LikeName(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tickets where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_LikeName(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tickets where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the type tickets where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @return the range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the type tickets where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type tickets before and after the current type ticket in the ordered set where companyId = &#63;.
	*
	* @param typeTicketId the primary key of the current type ticket
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket[] findByCompany_PrevAndNext(
		long typeTicketId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tickets where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tickets where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tickets where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the type tickets where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @return the range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the type tickets where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type tickets before and after the current type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param typeTicketId the primary key of the current type ticket
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket[] findByCG_PrevAndNext(
		long typeTicketId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tickets where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tickets where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @return the range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByCG_LikeName_First(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByCG_LikeName_First(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByCG_LikeName_Last(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByCG_LikeName_Last(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type tickets before and after the current type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param typeTicketId the primary key of the current type ticket
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket[] findByCG_LikeName_PrevAndNext(
		long typeTicketId, long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63; from the database.
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
	* Returns the number of type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countByCG_LikeName(long companyId, long groupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the type ticket in the entity cache if it is enabled.
	*
	* @param typeTicket the type ticket
	*/
	public void cacheResult(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket);

	/**
	* Caches the type tickets in the entity cache if it is enabled.
	*
	* @param typeTickets the type tickets
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> typeTickets);

	/**
	* Creates a new type ticket with the primary key. Does not add the type ticket to the database.
	*
	* @param typeTicketId the primary key for the new type ticket
	* @return the new type ticket
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket create(
		long typeTicketId);

	/**
	* Removes the type ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicketId the primary key of the type ticket
	* @return the type ticket that was removed
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket remove(
		long typeTicketId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.eticket.model.TypeTicket updateImpl(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type ticket with the primary key or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketException} if it could not be found.
	*
	* @param typeTicketId the primary key of the type ticket
	* @return the type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket findByPrimaryKey(
		long typeTicketId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type ticket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeTicketId the primary key of the type ticket
	* @return the type ticket, or <code>null</code> if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.eticket.model.TypeTicket fetchByPrimaryKey(
		long typeTicketId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type tickets.
	*
	* @return the type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the type tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @return the range of type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the type tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of type tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type tickets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type tickets.
	*
	* @return the number of type tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}