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

import br.com.prodevelopment.eticket.model.TypeTicketUsers;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the type ticket users service. This utility wraps {@link TypeTicketUsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTicketUsersPersistence
 * @see TypeTicketUsersPersistenceImpl
 * @generated
 */
public class TypeTicketUsersUtil {
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
	public static void clearCache(TypeTicketUsers typeTicketUsers) {
		getPersistence().clearCache(typeTicketUsers);
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
	public static List<TypeTicketUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TypeTicketUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TypeTicketUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TypeTicketUsers update(TypeTicketUsers typeTicketUsers)
		throws SystemException {
		return getPersistence().update(typeTicketUsers);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TypeTicketUsers update(TypeTicketUsers typeTicketUsers,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(typeTicketUsers, serviceContext);
	}

	/**
	* Returns all the type ticket userses where typeTicketId = &#63;.
	*
	* @param typeTicketId the type ticket ID
	* @return the matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findByTypeTicket(
		long typeTicketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeTicket(typeTicketId);
	}

	/**
	* Returns a range of all the type ticket userses where typeTicketId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeTicketId the type ticket ID
	* @param start the lower bound of the range of type ticket userses
	* @param end the upper bound of the range of type ticket userses (not inclusive)
	* @return the range of matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findByTypeTicket(
		long typeTicketId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeTicket(typeTicketId, start, end);
	}

	/**
	* Returns an ordered range of all the type ticket userses where typeTicketId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeTicketId the type ticket ID
	* @param start the lower bound of the range of type ticket userses
	* @param end the upper bound of the range of type ticket userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findByTypeTicket(
		long typeTicketId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTicket(typeTicketId, start, end, orderByComparator);
	}

	/**
	* Returns the first type ticket users in the ordered set where typeTicketId = &#63;.
	*
	* @param typeTicketId the type ticket ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket users
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers findByTypeTicket_First(
		long typeTicketId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTicket_First(typeTicketId, orderByComparator);
	}

	/**
	* Returns the first type ticket users in the ordered set where typeTicketId = &#63;.
	*
	* @param typeTicketId the type ticket ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers fetchByTypeTicket_First(
		long typeTicketId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTicket_First(typeTicketId, orderByComparator);
	}

	/**
	* Returns the last type ticket users in the ordered set where typeTicketId = &#63;.
	*
	* @param typeTicketId the type ticket ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket users
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers findByTypeTicket_Last(
		long typeTicketId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTicket_Last(typeTicketId, orderByComparator);
	}

	/**
	* Returns the last type ticket users in the ordered set where typeTicketId = &#63;.
	*
	* @param typeTicketId the type ticket ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers fetchByTypeTicket_Last(
		long typeTicketId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTicket_Last(typeTicketId, orderByComparator);
	}

	/**
	* Returns the type ticket userses before and after the current type ticket users in the ordered set where typeTicketId = &#63;.
	*
	* @param typeTicketUsersId the primary key of the current type ticket users
	* @param typeTicketId the type ticket ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type ticket users
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers[] findByTypeTicket_PrevAndNext(
		long typeTicketUsersId, long typeTicketId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTicket_PrevAndNext(typeTicketUsersId,
			typeTicketId, orderByComparator);
	}

	/**
	* Removes all the type ticket userses where typeTicketId = &#63; from the database.
	*
	* @param typeTicketId the type ticket ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeTicket(long typeTicketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeTicket(typeTicketId);
	}

	/**
	* Returns the number of type ticket userses where typeTicketId = &#63;.
	*
	* @param typeTicketId the type ticket ID
	* @return the number of matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeTicket(long typeTicketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeTicket(typeTicketId);
	}

	/**
	* Returns all the type ticket userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the type ticket userses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of type ticket userses
	* @param end the upper bound of the range of type ticket userses (not inclusive)
	* @return the range of matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the type ticket userses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of type ticket userses
	* @param end the upper bound of the range of type ticket userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first type ticket users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket users
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first type ticket users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last type ticket users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket users
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last type ticket users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the type ticket userses before and after the current type ticket users in the ordered set where userId = &#63;.
	*
	* @param typeTicketUsersId the primary key of the current type ticket users
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type ticket users
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers[] findByUser_PrevAndNext(
		long typeTicketUsersId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_PrevAndNext(typeTicketUsersId, userId,
			orderByComparator);
	}

	/**
	* Removes all the type ticket userses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of type ticket userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns the type ticket users where typeTicketId = &#63; and userId = &#63; or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException} if it could not be found.
	*
	* @param typeTicketId the type ticket ID
	* @param userId the user ID
	* @return the matching type ticket users
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers findByTypeUser(
		long typeTicketId, long userId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeUser(typeTicketId, userId);
	}

	/**
	* Returns the type ticket users where typeTicketId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param typeTicketId the type ticket ID
	* @param userId the user ID
	* @return the matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers fetchByTypeUser(
		long typeTicketId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTypeUser(typeTicketId, userId);
	}

	/**
	* Returns the type ticket users where typeTicketId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param typeTicketId the type ticket ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers fetchByTypeUser(
		long typeTicketId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeUser(typeTicketId, userId, retrieveFromCache);
	}

	/**
	* Removes the type ticket users where typeTicketId = &#63; and userId = &#63; from the database.
	*
	* @param typeTicketId the type ticket ID
	* @param userId the user ID
	* @return the type ticket users that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers removeByTypeUser(
		long typeTicketId, long userId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByTypeUser(typeTicketId, userId);
	}

	/**
	* Returns the number of type ticket userses where typeTicketId = &#63; and userId = &#63;.
	*
	* @param typeTicketId the type ticket ID
	* @param userId the user ID
	* @return the number of matching type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeUser(long typeTicketId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeUser(typeTicketId, userId);
	}

	/**
	* Caches the type ticket users in the entity cache if it is enabled.
	*
	* @param typeTicketUsers the type ticket users
	*/
	public static void cacheResult(
		br.com.prodevelopment.eticket.model.TypeTicketUsers typeTicketUsers) {
		getPersistence().cacheResult(typeTicketUsers);
	}

	/**
	* Caches the type ticket userses in the entity cache if it is enabled.
	*
	* @param typeTicketUserses the type ticket userses
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> typeTicketUserses) {
		getPersistence().cacheResult(typeTicketUserses);
	}

	/**
	* Creates a new type ticket users with the primary key. Does not add the type ticket users to the database.
	*
	* @param typeTicketUsersId the primary key for the new type ticket users
	* @return the new type ticket users
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers create(
		long typeTicketUsersId) {
		return getPersistence().create(typeTicketUsersId);
	}

	/**
	* Removes the type ticket users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicketUsersId the primary key of the type ticket users
	* @return the type ticket users that was removed
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers remove(
		long typeTicketUsersId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(typeTicketUsersId);
	}

	public static br.com.prodevelopment.eticket.model.TypeTicketUsers updateImpl(
		br.com.prodevelopment.eticket.model.TypeTicketUsers typeTicketUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(typeTicketUsers);
	}

	/**
	* Returns the type ticket users with the primary key or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException} if it could not be found.
	*
	* @param typeTicketUsersId the primary key of the type ticket users
	* @return the type ticket users
	* @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers findByPrimaryKey(
		long typeTicketUsersId)
		throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(typeTicketUsersId);
	}

	/**
	* Returns the type ticket users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeTicketUsersId the primary key of the type ticket users
	* @return the type ticket users, or <code>null</code> if a type ticket users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.eticket.model.TypeTicketUsers fetchByPrimaryKey(
		long typeTicketUsersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(typeTicketUsersId);
	}

	/**
	* Returns all the type ticket userses.
	*
	* @return the type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the type ticket userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type ticket userses
	* @param end the upper bound of the range of type ticket userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.eticket.model.TypeTicketUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the type ticket userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of type ticket userses.
	*
	* @return the number of type ticket userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TypeTicketUsersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TypeTicketUsersPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.eticket.service.ClpSerializer.getServletContextName(),
					TypeTicketUsersPersistence.class.getName());

			ReferenceRegistry.registerReference(TypeTicketUsersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TypeTicketUsersPersistence persistence) {
	}

	private static TypeTicketUsersPersistence _persistence;
}