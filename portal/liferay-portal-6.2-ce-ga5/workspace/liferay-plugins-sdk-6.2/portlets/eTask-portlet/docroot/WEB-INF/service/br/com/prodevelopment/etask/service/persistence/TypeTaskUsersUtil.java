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

import br.com.prodevelopment.etask.model.TypeTaskUsers;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the type task users service. This utility wraps {@link TypeTaskUsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTaskUsersPersistence
 * @see TypeTaskUsersPersistenceImpl
 * @generated
 */
public class TypeTaskUsersUtil {
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
	public static void clearCache(TypeTaskUsers typeTaskUsers) {
		getPersistence().clearCache(typeTaskUsers);
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
	public static List<TypeTaskUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TypeTaskUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TypeTaskUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TypeTaskUsers update(TypeTaskUsers typeTaskUsers)
		throws SystemException {
		return getPersistence().update(typeTaskUsers);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TypeTaskUsers update(TypeTaskUsers typeTaskUsers,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(typeTaskUsers, serviceContext);
	}

	/**
	* Returns all the type task userses where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTask(
		long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeTask(typeTaskId);
	}

	/**
	* Returns a range of all the type task userses where typeTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeTaskId the type task ID
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @return the range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTask(
		long typeTaskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeTask(typeTaskId, start, end);
	}

	/**
	* Returns an ordered range of all the type task userses where typeTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeTaskId the type task ID
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTask(
		long typeTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTask(typeTaskId, start, end, orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTask_First(
		long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTask_First(typeTaskId, orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTask_First(
		long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTask_First(typeTaskId, orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTask_Last(
		long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTask_Last(typeTaskId, orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTask_Last(
		long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTask_Last(typeTaskId, orderByComparator);
	}

	/**
	* Returns the type task userses before and after the current type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskUsersId the primary key of the current type task users
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers[] findByTypeTask_PrevAndNext(
		long typeTaskUsersId, long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTask_PrevAndNext(typeTaskUsersId, typeTaskId,
			orderByComparator);
	}

	/**
	* Removes all the type task userses where typeTaskId = &#63; from the database.
	*
	* @param typeTaskId the type task ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeTask(long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeTask(typeTaskId);
	}

	/**
	* Returns the number of type task userses where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeTask(long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeTask(typeTaskId);
	}

	/**
	* Returns all the type task userses where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskUser(
		long typeTaskId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeTaskUser(typeTaskId, userId);
	}

	/**
	* Returns a range of all the type task userses where typeTaskId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @return the range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskUser(
		long typeTaskId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskUser(typeTaskId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the type task userses where typeTaskId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskUser(
		long typeTaskId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskUser(typeTaskId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskUser_First(
		long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskUser_First(typeTaskId, userId,
			orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskUser_First(
		long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTaskUser_First(typeTaskId, userId,
			orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskUser_Last(
		long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskUser_Last(typeTaskId, userId,
			orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskUser_Last(
		long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTaskUser_Last(typeTaskId, userId,
			orderByComparator);
	}

	/**
	* Returns the type task userses before and after the current type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskUsersId the primary key of the current type task users
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers[] findByTypeTaskUser_PrevAndNext(
		long typeTaskUsersId, long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskUser_PrevAndNext(typeTaskUsersId, typeTaskId,
			userId, orderByComparator);
	}

	/**
	* Removes all the type task userses where typeTaskId = &#63; and userId = &#63; from the database.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeTaskUser(long typeTaskId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeTaskUser(typeTaskId, userId);
	}

	/**
	* Returns the number of type task userses where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeTaskUser(long typeTaskId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeTaskUser(typeTaskId, userId);
	}

	/**
	* Returns all the type task userses where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskTypeUser(
		long typeTaskId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeTaskTypeUser(typeTaskId, typeUser);
	}

	/**
	* Returns a range of all the type task userses where typeTaskId = &#63; and typeUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @return the range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskTypeUser(
		long typeTaskId, java.lang.String typeUser, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskTypeUser(typeTaskId, typeUser, start, end);
	}

	/**
	* Returns an ordered range of all the type task userses where typeTaskId = &#63; and typeUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskTypeUser(
		long typeTaskId, java.lang.String typeUser, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskTypeUser(typeTaskId, typeUser, start, end,
			orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskTypeUser_First(
		long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskTypeUser_First(typeTaskId, typeUser,
			orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskTypeUser_First(
		long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTaskTypeUser_First(typeTaskId, typeUser,
			orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskTypeUser_Last(
		long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskTypeUser_Last(typeTaskId, typeUser,
			orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskTypeUser_Last(
		long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTaskTypeUser_Last(typeTaskId, typeUser,
			orderByComparator);
	}

	/**
	* Returns the type task userses before and after the current type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskUsersId the primary key of the current type task users
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers[] findByTypeTaskTypeUser_PrevAndNext(
		long typeTaskUsersId, long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskTypeUser_PrevAndNext(typeTaskUsersId,
			typeTaskId, typeUser, orderByComparator);
	}

	/**
	* Removes all the type task userses where typeTaskId = &#63; and typeUser = &#63; from the database.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeTaskTypeUser(long typeTaskId,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeTaskTypeUser(typeTaskId, typeUser);
	}

	/**
	* Returns the number of type task userses where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeTaskTypeUser(long typeTaskId,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeTaskTypeUser(typeTaskId, typeUser);
	}

	/**
	* Returns all the type task userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the type task userses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @return the range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the type task userses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the type task userses before and after the current type task users in the ordered set where userId = &#63;.
	*
	* @param typeTaskUsersId the primary key of the current type task users
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers[] findByUser_PrevAndNext(
		long typeTaskUsersId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_PrevAndNext(typeTaskUsersId, userId,
			orderByComparator);
	}

	/**
	* Removes all the type task userses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of type task userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the type task userses where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUserTypeUser(
		long userId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserTypeUser(userId, typeUser);
	}

	/**
	* Returns a range of all the type task userses where userId = &#63; and typeUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @return the range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUserTypeUser(
		long userId, java.lang.String typeUser, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserTypeUser(userId, typeUser, start, end);
	}

	/**
	* Returns an ordered range of all the type task userses where userId = &#63; and typeUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUserTypeUser(
		long userId, java.lang.String typeUser, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTypeUser(userId, typeUser, start, end,
			orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByUserTypeUser_First(
		long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTypeUser_First(userId, typeUser, orderByComparator);
	}

	/**
	* Returns the first type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByUserTypeUser_First(
		long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserTypeUser_First(userId, typeUser,
			orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByUserTypeUser_Last(
		long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTypeUser_Last(userId, typeUser, orderByComparator);
	}

	/**
	* Returns the last type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByUserTypeUser_Last(
		long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserTypeUser_Last(userId, typeUser, orderByComparator);
	}

	/**
	* Returns the type task userses before and after the current type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskUsersId the primary key of the current type task users
	* @param userId the user ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers[] findByUserTypeUser_PrevAndNext(
		long typeTaskUsersId, long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTypeUser_PrevAndNext(typeTaskUsersId, userId,
			typeUser, orderByComparator);
	}

	/**
	* Removes all the type task userses where userId = &#63; and typeUser = &#63; from the database.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserTypeUser(long userId,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserTypeUser(userId, typeUser);
	}

	/**
	* Returns the number of type task userses where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserTypeUser(long userId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserTypeUser(userId, typeUser);
	}

	/**
	* Returns the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskUsersException} if it could not be found.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param typeUser the type user
	* @return the matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskUserType(
		long typeTaskId, long userId, java.lang.String typeUser)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeTaskUserType(typeTaskId, userId, typeUser);
	}

	/**
	* Returns the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param typeUser the type user
	* @return the matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskUserType(
		long typeTaskId, long userId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTaskUserType(typeTaskId, userId, typeUser);
	}

	/**
	* Returns the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param typeUser the type user
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskUserType(
		long typeTaskId, long userId, java.lang.String typeUser,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeTaskUserType(typeTaskId, userId, typeUser,
			retrieveFromCache);
	}

	/**
	* Removes the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; from the database.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param typeUser the type user
	* @return the type task users that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers removeByTypeTaskUserType(
		long typeTaskId, long userId, java.lang.String typeUser)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByTypeTaskUserType(typeTaskId, userId, typeUser);
	}

	/**
	* Returns the number of type task userses where typeTaskId = &#63; and userId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param typeUser the type user
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeTaskUserType(long typeTaskId, long userId,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTypeTaskUserType(typeTaskId, userId, typeUser);
	}

	/**
	* Caches the type task users in the entity cache if it is enabled.
	*
	* @param typeTaskUsers the type task users
	*/
	public static void cacheResult(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers) {
		getPersistence().cacheResult(typeTaskUsers);
	}

	/**
	* Caches the type task userses in the entity cache if it is enabled.
	*
	* @param typeTaskUserses the type task userses
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> typeTaskUserses) {
		getPersistence().cacheResult(typeTaskUserses);
	}

	/**
	* Creates a new type task users with the primary key. Does not add the type task users to the database.
	*
	* @param typeTaskUsersId the primary key for the new type task users
	* @return the new type task users
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers create(
		long typeTaskUsersId) {
		return getPersistence().create(typeTaskUsersId);
	}

	/**
	* Removes the type task users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users that was removed
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers remove(
		long typeTaskUsersId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(typeTaskUsersId);
	}

	public static br.com.prodevelopment.etask.model.TypeTaskUsers updateImpl(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(typeTaskUsers);
	}

	/**
	* Returns the type task users with the primary key or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskUsersException} if it could not be found.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers findByPrimaryKey(
		long typeTaskUsersId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(typeTaskUsersId);
	}

	/**
	* Returns the type task users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users, or <code>null</code> if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.etask.model.TypeTaskUsers fetchByPrimaryKey(
		long typeTaskUsersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(typeTaskUsersId);
	}

	/**
	* Returns all the type task userses.
	*
	* @return the type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the type task userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type task userses
	* @param end the upper bound of the range of type task userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the type task userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of type task userses.
	*
	* @return the number of type task userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TypeTaskUsersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TypeTaskUsersPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.etask.service.ClpSerializer.getServletContextName(),
					TypeTaskUsersPersistence.class.getName());

			ReferenceRegistry.registerReference(TypeTaskUsersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TypeTaskUsersPersistence persistence) {
	}

	private static TypeTaskUsersPersistence _persistence;
}