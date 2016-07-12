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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the type ticket service. This utility wraps {@link TypeTicketPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTicketPersistence
 * @see TypeTicketPersistenceImpl
 * @generated
 */
public class TypeTicketUtil {
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
	public static void clearCache(TypeTicket typeTicket) {
		getPersistence().clearCache(typeTicket);
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
	public static List<TypeTicket> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TypeTicket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TypeTicket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TypeTicket update(TypeTicket typeTicket)
		throws SystemException {
		return getPersistence().update(typeTicket);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TypeTicket update(TypeTicket typeTicket,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(typeTicket, serviceContext);
	}

	/**
	* Returns all the type tickets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first type ticket in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first type ticket in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last type ticket in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last type ticket in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket[] findByUuid_PrevAndNext(
		long typeTicketId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(typeTicketId, uuid, orderByComparator);
	}

	/**
	* Removes all the type tickets where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of type tickets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the type ticket where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the type ticket where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the type ticket where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the type ticket where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the type ticket that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of type tickets where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the type tickets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket[] findByUuid_C_PrevAndNext(
		long typeTicketId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(typeTicketId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the type tickets where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of type tickets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the type tickets where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByC_LikeName(
		long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_LikeName(companyId, name);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByC_LikeName(
		long companyId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_LikeName(companyId, name, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByC_LikeName(
		long companyId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_LikeName(companyId, name, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket findByC_LikeName_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_LikeName_First(companyId, name, orderByComparator);
	}

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByC_LikeName_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_LikeName_First(companyId, name, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket findByC_LikeName_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_LikeName_Last(companyId, name, orderByComparator);
	}

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByC_LikeName_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_LikeName_Last(companyId, name, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket[] findByC_LikeName_PrevAndNext(
		long typeTicketId, long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_LikeName_PrevAndNext(typeTicketId, companyId, name,
			orderByComparator);
	}

	/**
	* Removes all the type tickets where companyId = &#63; and name LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_LikeName(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_LikeName(companyId, name);
	}

	/**
	* Returns the number of type tickets where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_LikeName(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_LikeName(companyId, name);
	}

	/**
	* Returns all the type tickets where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket[] findByCompany_PrevAndNext(
		long typeTicketId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(typeTicketId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the type tickets where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of type tickets where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the type tickets where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG(companyId, groupId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG(companyId, groupId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket findByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByCG_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_First(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket findByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByCG_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_Last(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket[] findByCG_PrevAndNext(
		long typeTicketId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_PrevAndNext(typeTicketId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the type tickets where companyId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of type tickets where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG(companyId, groupId);
	}

	/**
	* Returns all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @return the matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCG_LikeName(companyId, groupId, name);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName(companyId, groupId, name, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findByCG_LikeName(
		long companyId, long groupId, java.lang.String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName(companyId, groupId, name, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket findByCG_LikeName_First(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName_First(companyId, groupId, name,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByCG_LikeName_First(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_LikeName_First(companyId, groupId, name,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket findByCG_LikeName_Last(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName_Last(companyId, groupId, name,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByCG_LikeName_Last(
		long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCG_LikeName_Last(companyId, groupId, name,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.eticket.model.TypeTicket[] findByCG_LikeName_PrevAndNext(
		long typeTicketId, long companyId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCG_LikeName_PrevAndNext(typeTicketId, companyId,
			groupId, name, orderByComparator);
	}

	/**
	* Removes all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63; from the database.
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
	* Returns the number of type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCG_LikeName(long companyId, long groupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCG_LikeName(companyId, groupId, name);
	}

	/**
	* Caches the type ticket in the entity cache if it is enabled.
	*
	* @param typeTicket the type ticket
	*/
	public static void cacheResult(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket) {
		getPersistence().cacheResult(typeTicket);
	}

	/**
	* Caches the type tickets in the entity cache if it is enabled.
	*
	* @param typeTickets the type tickets
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> typeTickets) {
		getPersistence().cacheResult(typeTickets);
	}

	/**
	* Creates a new type ticket with the primary key. Does not add the type ticket to the database.
	*
	* @param typeTicketId the primary key for the new type ticket
	* @return the new type ticket
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket create(
		long typeTicketId) {
		return getPersistence().create(typeTicketId);
	}

	/**
	* Removes the type ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicketId the primary key of the type ticket
	* @return the type ticket that was removed
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket remove(
		long typeTicketId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(typeTicketId);
	}

	public static br.com.prodevelopment.eticket.model.TypeTicket updateImpl(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(typeTicket);
	}

	/**
	* Returns the type ticket with the primary key or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketException} if it could not be found.
	*
	* @param typeTicketId the primary key of the type ticket
	* @return the type ticket
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket findByPrimaryKey(
		long typeTicketId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(typeTicketId);
	}

	/**
	* Returns the type ticket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeTicketId the primary key of the type ticket
	* @return the type ticket, or <code>null</code> if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicket fetchByPrimaryKey(
		long typeTicketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(typeTicketId);
	}

	/**
	* Returns all the type tickets.
	*
	* @return the type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the type tickets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of type tickets.
	*
	* @return the number of type tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TypeTicketPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TypeTicketPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.eticket.service.ClpSerializer.getServletContextName(),
					TypeTicketPersistence.class.getName());

			ReferenceRegistry.registerReference(TypeTicketUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TypeTicketPersistence persistence) {
	}

	private static TypeTicketPersistence _persistence;
}