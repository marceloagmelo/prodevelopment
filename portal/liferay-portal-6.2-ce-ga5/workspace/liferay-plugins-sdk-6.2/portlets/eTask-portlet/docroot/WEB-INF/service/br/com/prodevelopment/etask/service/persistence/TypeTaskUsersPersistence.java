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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the type task users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTaskUsersPersistenceImpl
 * @see TypeTaskUsersUtil
 * @generated
 */
public interface TypeTaskUsersPersistence extends BasePersistence<TypeTaskUsers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeTaskUsersUtil} to access the type task users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the type task userses where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTask(
		long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTask(
		long typeTaskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTask(
		long typeTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTask_First(
		long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTask_First(
		long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTask_Last(
		long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTask_Last(
		long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers[] findByTypeTask_PrevAndNext(
		long typeTaskUsersId, long typeTaskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type task userses where typeTaskId = &#63; from the database.
	*
	* @param typeTaskId the type task ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeTask(long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type task userses where typeTaskId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeTask(long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type task userses where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskUser(
		long typeTaskId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskUser(
		long typeTaskId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskUser(
		long typeTaskId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskUser_First(
		long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskUser_First(
		long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskUser_Last(
		long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskUser_Last(
		long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers[] findByTypeTaskUser_PrevAndNext(
		long typeTaskUsersId, long typeTaskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type task userses where typeTaskId = &#63; and userId = &#63; from the database.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeTaskUser(long typeTaskId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type task userses where typeTaskId = &#63; and userId = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeTaskUser(long typeTaskId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type task userses where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskTypeUser(
		long typeTaskId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskTypeUser(
		long typeTaskId, java.lang.String typeUser, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByTypeTaskTypeUser(
		long typeTaskId, java.lang.String typeUser, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskTypeUser_First(
		long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskTypeUser_First(
		long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskTypeUser_Last(
		long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskTypeUser_Last(
		long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers[] findByTypeTaskTypeUser_PrevAndNext(
		long typeTaskUsersId, long typeTaskId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type task userses where typeTaskId = &#63; and typeUser = &#63; from the database.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeTaskTypeUser(long typeTaskId,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type task userses where typeTaskId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param typeUser the type user
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeTaskTypeUser(long typeTaskId,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type task userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers[] findByUser_PrevAndNext(
		long typeTaskUsersId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type task userses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type task userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type task userses where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @return the matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUserTypeUser(
		long userId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUserTypeUser(
		long userId, java.lang.String typeUser, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findByUserTypeUser(
		long userId, java.lang.String typeUser, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByUserTypeUser_First(
		long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByUserTypeUser_First(
		long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByUserTypeUser_Last(
		long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByUserTypeUser_Last(
		long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers[] findByUserTypeUser_PrevAndNext(
		long typeTaskUsersId, long userId, java.lang.String typeUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type task userses where userId = &#63; and typeUser = &#63; from the database.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserTypeUser(long userId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type task userses where userId = &#63; and typeUser = &#63;.
	*
	* @param userId the user ID
	* @param typeUser the type user
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserTypeUser(long userId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByTypeTaskUserType(
		long typeTaskId, long userId, java.lang.String typeUser)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param typeUser the type user
	* @return the matching type task users, or <code>null</code> if a matching type task users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskUserType(
		long typeTaskId, long userId, java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByTypeTaskUserType(
		long typeTaskId, long userId, java.lang.String typeUser,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; from the database.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param typeUser the type user
	* @return the type task users that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers removeByTypeTaskUserType(
		long typeTaskId, long userId, java.lang.String typeUser)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type task userses where typeTaskId = &#63; and userId = &#63; and typeUser = &#63;.
	*
	* @param typeTaskId the type task ID
	* @param userId the user ID
	* @param typeUser the type user
	* @return the number of matching type task userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeTaskUserType(long typeTaskId, long userId,
		java.lang.String typeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the type task users in the entity cache if it is enabled.
	*
	* @param typeTaskUsers the type task users
	*/
	public void cacheResult(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers);

	/**
	* Caches the type task userses in the entity cache if it is enabled.
	*
	* @param typeTaskUserses the type task userses
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> typeTaskUserses);

	/**
	* Creates a new type task users with the primary key. Does not add the type task users to the database.
	*
	* @param typeTaskUsersId the primary key for the new type task users
	* @return the new type task users
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers create(
		long typeTaskUsersId);

	/**
	* Removes the type task users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users that was removed
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers remove(
		long typeTaskUsersId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.etask.model.TypeTaskUsers updateImpl(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task users with the primary key or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskUsersException} if it could not be found.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users
	* @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers findByPrimaryKey(
		long typeTaskUsersId)
		throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the type task users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeTaskUsersId the primary key of the type task users
	* @return the type task users, or <code>null</code> if a type task users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.etask.model.TypeTaskUsers fetchByPrimaryKey(
		long typeTaskUsersId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the type task userses.
	*
	* @return the type task userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.etask.model.TypeTaskUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the type task userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of type task userses.
	*
	* @return the number of type task userses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}