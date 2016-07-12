/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.social.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.social.model.SocialActivityAchievement;

import java.util.List;

/**
 * The persistence utility for the social activity achievement service. This utility wraps {@link SocialActivityAchievementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivityAchievementPersistence
 * @see SocialActivityAchievementPersistenceImpl
 * @generated
 */
public class SocialActivityAchievementUtil {
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
	public static void clearCache(
		SocialActivityAchievement socialActivityAchievement) {
		getPersistence().clearCache(socialActivityAchievement);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SocialActivityAchievement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialActivityAchievement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialActivityAchievement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SocialActivityAchievement update(
		SocialActivityAchievement socialActivityAchievement, boolean merge)
		throws SystemException {
		return getPersistence().update(socialActivityAchievement, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SocialActivityAchievement update(
		SocialActivityAchievement socialActivityAchievement, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(socialActivityAchievement, merge, serviceContext);
	}

	/**
	* Caches the social activity achievement in the entity cache if it is enabled.
	*
	* @param socialActivityAchievement the social activity achievement
	*/
	public static void cacheResult(
		com.liferay.portlet.social.model.SocialActivityAchievement socialActivityAchievement) {
		getPersistence().cacheResult(socialActivityAchievement);
	}

	/**
	* Caches the social activity achievements in the entity cache if it is enabled.
	*
	* @param socialActivityAchievements the social activity achievements
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> socialActivityAchievements) {
		getPersistence().cacheResult(socialActivityAchievements);
	}

	/**
	* Creates a new social activity achievement with the primary key. Does not add the social activity achievement to the database.
	*
	* @param activityAchievementId the primary key for the new social activity achievement
	* @return the new social activity achievement
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement create(
		long activityAchievementId) {
		return getPersistence().create(activityAchievementId);
	}

	/**
	* Removes the social activity achievement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityAchievementId the primary key of the social activity achievement
	* @return the social activity achievement that was removed
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a social activity achievement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement remove(
		long activityAchievementId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence().remove(activityAchievementId);
	}

	public static com.liferay.portlet.social.model.SocialActivityAchievement updateImpl(
		com.liferay.portlet.social.model.SocialActivityAchievement socialActivityAchievement,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(socialActivityAchievement, merge);
	}

	/**
	* Returns the social activity achievement with the primary key or throws a {@link com.liferay.portlet.social.NoSuchActivityAchievementException} if it could not be found.
	*
	* @param activityAchievementId the primary key of the social activity achievement
	* @return the social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a social activity achievement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByPrimaryKey(
		long activityAchievementId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence().findByPrimaryKey(activityAchievementId);
	}

	/**
	* Returns the social activity achievement with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityAchievementId the primary key of the social activity achievement
	* @return the social activity achievement, or <code>null</code> if a social activity achievement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByPrimaryKey(
		long activityAchievementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(activityAchievementId);
	}

	/**
	* Returns all the social activity achievements where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the social activity achievements where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @return the range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the social activity achievements where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the social activity achievements before and after the current social activity achievement in the ordered set where groupId = &#63;.
	*
	* @param activityAchievementId the primary key of the current social activity achievement
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a social activity achievement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement[] findByGroupId_PrevAndNext(
		long activityAchievementId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(activityAchievementId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the social activity achievements where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	* Returns a range of all the social activity achievements where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @return the range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the social activity achievements where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U(groupId, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_U_First(groupId, userId, orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_U_First(groupId, userId, orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_U_Last(groupId, userId, orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_U_Last(groupId, userId, orderByComparator);
	}

	/**
	* Returns the social activity achievements before and after the current social activity achievement in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param activityAchievementId the primary key of the current social activity achievement
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a social activity achievement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement[] findByG_U_PrevAndNext(
		long activityAchievementId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_U_PrevAndNext(activityAchievementId, groupId,
			userId, orderByComparator);
	}

	/**
	* Returns all the social activity achievements where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_N(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_N(groupId, name);
	}

	/**
	* Returns a range of all the social activity achievements where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @return the range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_N(
		long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_N(groupId, name, start, end);
	}

	/**
	* Returns an ordered range of all the social activity achievements where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_N(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_N(groupId, name, start, end, orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_N_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence().findByG_N_First(groupId, name, orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_N_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_N_First(groupId, name, orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_N_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence().findByG_N_Last(groupId, name, orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_N_Last(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_N_Last(groupId, name, orderByComparator);
	}

	/**
	* Returns the social activity achievements before and after the current social activity achievement in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param activityAchievementId the primary key of the current social activity achievement
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a social activity achievement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement[] findByG_N_PrevAndNext(
		long activityAchievementId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_N_PrevAndNext(activityAchievementId, groupId, name,
			orderByComparator);
	}

	/**
	* Returns all the social activity achievements where groupId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @return the matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_F(
		long groupId, boolean firstInGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_F(groupId, firstInGroup);
	}

	/**
	* Returns a range of all the social activity achievements where groupId = &#63; and firstInGroup = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @return the range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_F(
		long groupId, boolean firstInGroup, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_F(groupId, firstInGroup, start, end);
	}

	/**
	* Returns an ordered range of all the social activity achievements where groupId = &#63; and firstInGroup = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_F(
		long groupId, boolean firstInGroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_F(groupId, firstInGroup, start, end,
			orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_F_First(
		long groupId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_F_First(groupId, firstInGroup, orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_F_First(
		long groupId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_F_First(groupId, firstInGroup, orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_F_Last(
		long groupId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_F_Last(groupId, firstInGroup, orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_F_Last(
		long groupId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_F_Last(groupId, firstInGroup, orderByComparator);
	}

	/**
	* Returns the social activity achievements before and after the current social activity achievement in the ordered set where groupId = &#63; and firstInGroup = &#63;.
	*
	* @param activityAchievementId the primary key of the current social activity achievement
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a social activity achievement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement[] findByG_F_PrevAndNext(
		long activityAchievementId, long groupId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_F_PrevAndNext(activityAchievementId, groupId,
			firstInGroup, orderByComparator);
	}

	/**
	* Returns the social activity achievement where groupId = &#63; and userId = &#63; and name = &#63; or throws a {@link com.liferay.portlet.social.NoSuchActivityAchievementException} if it could not be found.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param name the name
	* @return the matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_U_N(
		long groupId, long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence().findByG_U_N(groupId, userId, name);
	}

	/**
	* Returns the social activity achievement where groupId = &#63; and userId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param name the name
	* @return the matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_U_N(
		long groupId, long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_U_N(groupId, userId, name);
	}

	/**
	* Returns the social activity achievement where groupId = &#63; and userId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_U_N(
		long groupId, long userId, java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_U_N(groupId, userId, name, retrieveFromCache);
	}

	/**
	* Returns all the social activity achievements where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @return the matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_U_F(
		long groupId, long userId, boolean firstInGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U_F(groupId, userId, firstInGroup);
	}

	/**
	* Returns a range of all the social activity achievements where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @return the range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_U_F(
		long groupId, long userId, boolean firstInGroup, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_F(groupId, userId, firstInGroup, start, end);
	}

	/**
	* Returns an ordered range of all the social activity achievements where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findByG_U_F(
		long groupId, long userId, boolean firstInGroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_F(groupId, userId, firstInGroup, start, end,
			orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_U_F_First(
		long groupId, long userId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_U_F_First(groupId, userId, firstInGroup,
			orderByComparator);
	}

	/**
	* Returns the first social activity achievement in the ordered set where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_U_F_First(
		long groupId, long userId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_U_F_First(groupId, userId, firstInGroup,
			orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement findByG_U_F_Last(
		long groupId, long userId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_U_F_Last(groupId, userId, firstInGroup,
			orderByComparator);
	}

	/**
	* Returns the last social activity achievement in the ordered set where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social activity achievement, or <code>null</code> if a matching social activity achievement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement fetchByG_U_F_Last(
		long groupId, long userId, boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_U_F_Last(groupId, userId, firstInGroup,
			orderByComparator);
	}

	/**
	* Returns the social activity achievements before and after the current social activity achievement in the ordered set where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* @param activityAchievementId the primary key of the current social activity achievement
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social activity achievement
	* @throws com.liferay.portlet.social.NoSuchActivityAchievementException if a social activity achievement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement[] findByG_U_F_PrevAndNext(
		long activityAchievementId, long groupId, long userId,
		boolean firstInGroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence()
				   .findByG_U_F_PrevAndNext(activityAchievementId, groupId,
			userId, firstInGroup, orderByComparator);
	}

	/**
	* Returns all the social activity achievements.
	*
	* @return the social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the social activity achievements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @return the range of social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the social activity achievements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of social activity achievements
	* @param end the upper bound of the range of social activity achievements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.social.model.SocialActivityAchievement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the social activity achievements where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the social activity achievements where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	* Removes all the social activity achievements where groupId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_N(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_N(groupId, name);
	}

	/**
	* Removes all the social activity achievements where groupId = &#63; and firstInGroup = &#63; from the database.
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_F(long groupId, boolean firstInGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_F(groupId, firstInGroup);
	}

	/**
	* Removes the social activity achievement where groupId = &#63; and userId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param name the name
	* @return the social activity achievement that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.social.model.SocialActivityAchievement removeByG_U_N(
		long groupId, long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchActivityAchievementException {
		return getPersistence().removeByG_U_N(groupId, userId, name);
	}

	/**
	* Removes all the social activity achievements where groupId = &#63; and userId = &#63; and firstInGroup = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_U_F(long groupId, long userId,
		boolean firstInGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_U_F(groupId, userId, firstInGroup);
	}

	/**
	* Removes all the social activity achievements from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of social activity achievements where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of social activity achievements where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	* Returns the number of social activity achievements where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_N(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_N(groupId, name);
	}

	/**
	* Returns the number of social activity achievements where groupId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param firstInGroup the first in group
	* @return the number of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_F(long groupId, boolean firstInGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_F(groupId, firstInGroup);
	}

	/**
	* Returns the number of social activity achievements where groupId = &#63; and userId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param name the name
	* @return the number of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U_N(long groupId, long userId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_U_N(groupId, userId, name);
	}

	/**
	* Returns the number of social activity achievements where groupId = &#63; and userId = &#63; and firstInGroup = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param firstInGroup the first in group
	* @return the number of matching social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U_F(long groupId, long userId,
		boolean firstInGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_U_F(groupId, userId, firstInGroup);
	}

	/**
	* Returns the number of social activity achievements.
	*
	* @return the number of social activity achievements
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SocialActivityAchievementPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SocialActivityAchievementPersistence)PortalBeanLocatorUtil.locate(SocialActivityAchievementPersistence.class.getName());

			ReferenceRegistry.registerReference(SocialActivityAchievementUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SocialActivityAchievementPersistence persistence) {
	}

	private static SocialActivityAchievementPersistence _persistence;
}