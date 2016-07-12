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

package br.com.prodevelopment.academiahorario.service.persistence;

import br.com.prodevelopment.academiahorario.model.AcademiaHorario;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the academia horario service. This utility wraps {@link AcademiaHorarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo
 * @see AcademiaHorarioPersistence
 * @see AcademiaHorarioPersistenceImpl
 * @generated
 */
public class AcademiaHorarioUtil {
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
	public static void clearCache(AcademiaHorario academiaHorario) {
		getPersistence().clearCache(academiaHorario);
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
	public static List<AcademiaHorario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AcademiaHorario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AcademiaHorario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AcademiaHorario update(AcademiaHorario academiaHorario)
		throws SystemException {
		return getPersistence().update(academiaHorario);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AcademiaHorario update(AcademiaHorario academiaHorario,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(academiaHorario, serviceContext);
	}

	/**
	* Returns all the academia horarios where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the academia horarios where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the academia horarios where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the academia horarios before and after the current academia horario in the ordered set where uuid = &#63;.
	*
	* @param academiaHorarioId the primary key of the current academia horario
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario[] findByUuid_PrevAndNext(
		long academiaHorarioId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(academiaHorarioId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the academia horarios where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of academia horarios where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the academia horario where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the academia horario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the academia horario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the academia horario where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the academia horario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of academia horarios where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the academia horarios where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the academia horarios where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the academia horarios where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the academia horarios before and after the current academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param academiaHorarioId the primary key of the current academia horario
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario[] findByUuid_C_PrevAndNext(
		long academiaHorarioId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(academiaHorarioId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the academia horarios where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of academia horarios where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the academia horarios where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the academia horarios where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the academia horarios where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the academia horarios before and after the current academia horario in the ordered set where companyId = &#63;.
	*
	* @param academiaHorarioId the primary key of the current academia horario
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario[] findByCompany_PrevAndNext(
		long academiaHorarioId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(academiaHorarioId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the academia horarios where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of academia horarios where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the academia horarios where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId);
	}

	/**
	* Returns a range of all the academia horarios where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the academia horarios where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the academia horarios before and after the current academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param academiaHorarioId the primary key of the current academia horario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario[] findByC_G_PrevAndNext(
		long academiaHorarioId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(academiaHorarioId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching academia horarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G(companyId, groupId);
	}

	/**
	* Returns a range of all the academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of matching academia horarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the academia horarios that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching academia horarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the academia horarios before and after the current academia horario in the ordered set of academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param academiaHorarioId the primary key of the current academia horario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario[] filterFindByC_G_PrevAndNext(
		long academiaHorarioId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_PrevAndNext(academiaHorarioId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the academia horarios where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G(companyId, groupId);
	}

	/**
	* Returns the number of academia horarios where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, groupId);
	}

	/**
	* Returns the number of academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching academia horarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_G(companyId, groupId);
	}

	/**
	* Returns all the academia horarios where companyId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @return the matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_ATIVIDADE(
		long companyId, long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_ATIVIDADE(companyId, atividadeId);
	}

	/**
	* Returns a range of all the academia horarios where companyId = &#63; and atividadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_ATIVIDADE(
		long companyId, long atividadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_ATIVIDADE(companyId, atividadeId, start, end);
	}

	/**
	* Returns an ordered range of all the academia horarios where companyId = &#63; and atividadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_ATIVIDADE(
		long companyId, long atividadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_ATIVIDADE(companyId, atividadeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByC_ATIVIDADE_First(
		long companyId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_ATIVIDADE_First(companyId, atividadeId,
			orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByC_ATIVIDADE_First(
		long companyId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_ATIVIDADE_First(companyId, atividadeId,
			orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByC_ATIVIDADE_Last(
		long companyId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_ATIVIDADE_Last(companyId, atividadeId,
			orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByC_ATIVIDADE_Last(
		long companyId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_ATIVIDADE_Last(companyId, atividadeId,
			orderByComparator);
	}

	/**
	* Returns the academia horarios before and after the current academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	*
	* @param academiaHorarioId the primary key of the current academia horario
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario[] findByC_ATIVIDADE_PrevAndNext(
		long academiaHorarioId, long companyId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_ATIVIDADE_PrevAndNext(academiaHorarioId, companyId,
			atividadeId, orderByComparator);
	}

	/**
	* Removes all the academia horarios where companyId = &#63; and atividadeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_ATIVIDADE(long companyId, long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_ATIVIDADE(companyId, atividadeId);
	}

	/**
	* Returns the number of academia horarios where companyId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param atividadeId the atividade ID
	* @return the number of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_ATIVIDADE(long companyId, long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_ATIVIDADE(companyId, atividadeId);
	}

	/**
	* Returns all the academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @return the matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_G_ATIVIDADE(
		long companyId, long groupId, long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_ATIVIDADE(companyId, groupId, atividadeId);
	}

	/**
	* Returns a range of all the academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_G_ATIVIDADE(
		long companyId, long groupId, long atividadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_ATIVIDADE(companyId, groupId, atividadeId, start,
			end);
	}

	/**
	* Returns an ordered range of all the academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findByC_G_ATIVIDADE(
		long companyId, long groupId, long atividadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_ATIVIDADE(companyId, groupId, atividadeId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByC_G_ATIVIDADE_First(
		long companyId, long groupId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_ATIVIDADE_First(companyId, groupId, atividadeId,
			orderByComparator);
	}

	/**
	* Returns the first academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByC_G_ATIVIDADE_First(
		long companyId, long groupId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_ATIVIDADE_First(companyId, groupId, atividadeId,
			orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByC_G_ATIVIDADE_Last(
		long companyId, long groupId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_ATIVIDADE_Last(companyId, groupId, atividadeId,
			orderByComparator);
	}

	/**
	* Returns the last academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByC_G_ATIVIDADE_Last(
		long companyId, long groupId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_ATIVIDADE_Last(companyId, groupId, atividadeId,
			orderByComparator);
	}

	/**
	* Returns the academia horarios before and after the current academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param academiaHorarioId the primary key of the current academia horario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario[] findByC_G_ATIVIDADE_PrevAndNext(
		long academiaHorarioId, long companyId, long groupId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_ATIVIDADE_PrevAndNext(academiaHorarioId,
			companyId, groupId, atividadeId, orderByComparator);
	}

	/**
	* Returns all the academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @return the matching academia horarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> filterFindByC_G_ATIVIDADE(
		long companyId, long groupId, long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_ATIVIDADE(companyId, groupId, atividadeId);
	}

	/**
	* Returns a range of all the academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of matching academia horarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> filterFindByC_G_ATIVIDADE(
		long companyId, long groupId, long atividadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_ATIVIDADE(companyId, groupId, atividadeId,
			start, end);
	}

	/**
	* Returns an ordered range of all the academia horarios that the user has permissions to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching academia horarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> filterFindByC_G_ATIVIDADE(
		long companyId, long groupId, long atividadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_ATIVIDADE(companyId, groupId, atividadeId,
			start, end, orderByComparator);
	}

	/**
	* Returns the academia horarios before and after the current academia horario in the ordered set of academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param academiaHorarioId the primary key of the current academia horario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario[] filterFindByC_G_ATIVIDADE_PrevAndNext(
		long academiaHorarioId, long companyId, long groupId, long atividadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_ATIVIDADE_PrevAndNext(academiaHorarioId,
			companyId, groupId, atividadeId, orderByComparator);
	}

	/**
	* Removes all the academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_ATIVIDADE(long companyId, long groupId,
		long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_ATIVIDADE(companyId, groupId, atividadeId);
	}

	/**
	* Returns the number of academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @return the number of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_ATIVIDADE(long companyId, long groupId,
		long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_ATIVIDADE(companyId, groupId, atividadeId);
	}

	/**
	* Returns the number of academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param atividadeId the atividade ID
	* @return the number of matching academia horarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G_ATIVIDADE(long companyId, long groupId,
		long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByC_G_ATIVIDADE(companyId, groupId, atividadeId);
	}

	/**
	* Returns the academia horario where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63; or throws a {@link br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param diaSemana the dia semana
	* @param atividadeId the atividade ID
	* @param horaInicial the hora inicial
	* @return the matching academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByC_G_D_A_HI(
		long companyId, long groupId, int diaSemana, long atividadeId,
		java.lang.String horaInicial)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_D_A_HI(companyId, groupId, diaSemana,
			atividadeId, horaInicial);
	}

	/**
	* Returns the academia horario where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param diaSemana the dia semana
	* @param atividadeId the atividade ID
	* @param horaInicial the hora inicial
	* @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByC_G_D_A_HI(
		long companyId, long groupId, int diaSemana, long atividadeId,
		java.lang.String horaInicial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_D_A_HI(companyId, groupId, diaSemana,
			atividadeId, horaInicial);
	}

	/**
	* Returns the academia horario where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param diaSemana the dia semana
	* @param atividadeId the atividade ID
	* @param horaInicial the hora inicial
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByC_G_D_A_HI(
		long companyId, long groupId, int diaSemana, long atividadeId,
		java.lang.String horaInicial, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_D_A_HI(companyId, groupId, diaSemana,
			atividadeId, horaInicial, retrieveFromCache);
	}

	/**
	* Removes the academia horario where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param diaSemana the dia semana
	* @param atividadeId the atividade ID
	* @param horaInicial the hora inicial
	* @return the academia horario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario removeByC_G_D_A_HI(
		long companyId, long groupId, int diaSemana, long atividadeId,
		java.lang.String horaInicial)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByC_G_D_A_HI(companyId, groupId, diaSemana,
			atividadeId, horaInicial);
	}

	/**
	* Returns the number of academia horarios where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param diaSemana the dia semana
	* @param atividadeId the atividade ID
	* @param horaInicial the hora inicial
	* @return the number of matching academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_D_A_HI(long companyId, long groupId,
		int diaSemana, long atividadeId, java.lang.String horaInicial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_D_A_HI(companyId, groupId, diaSemana,
			atividadeId, horaInicial);
	}

	/**
	* Caches the academia horario in the entity cache if it is enabled.
	*
	* @param academiaHorario the academia horario
	*/
	public static void cacheResult(
		br.com.prodevelopment.academiahorario.model.AcademiaHorario academiaHorario) {
		getPersistence().cacheResult(academiaHorario);
	}

	/**
	* Caches the academia horarios in the entity cache if it is enabled.
	*
	* @param academiaHorarios the academia horarios
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> academiaHorarios) {
		getPersistence().cacheResult(academiaHorarios);
	}

	/**
	* Creates a new academia horario with the primary key. Does not add the academia horario to the database.
	*
	* @param academiaHorarioId the primary key for the new academia horario
	* @return the new academia horario
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario create(
		long academiaHorarioId) {
		return getPersistence().create(academiaHorarioId);
	}

	/**
	* Removes the academia horario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param academiaHorarioId the primary key of the academia horario
	* @return the academia horario that was removed
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario remove(
		long academiaHorarioId)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(academiaHorarioId);
	}

	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario updateImpl(
		br.com.prodevelopment.academiahorario.model.AcademiaHorario academiaHorario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(academiaHorario);
	}

	/**
	* Returns the academia horario with the primary key or throws a {@link br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException} if it could not be found.
	*
	* @param academiaHorarioId the primary key of the academia horario
	* @return the academia horario
	* @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario findByPrimaryKey(
		long academiaHorarioId)
		throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(academiaHorarioId);
	}

	/**
	* Returns the academia horario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param academiaHorarioId the primary key of the academia horario
	* @return the academia horario, or <code>null</code> if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchByPrimaryKey(
		long academiaHorarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(academiaHorarioId);
	}

	/**
	* Returns all the academia horarios.
	*
	* @return the academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the academia horarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the academia horarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the academia horarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of academia horarios.
	*
	* @return the number of academia horarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AcademiaHorarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AcademiaHorarioPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.academiahorario.service.ClpSerializer.getServletContextName(),
					AcademiaHorarioPersistence.class.getName());

			ReferenceRegistry.registerReference(AcademiaHorarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AcademiaHorarioPersistence persistence) {
	}

	private static AcademiaHorarioPersistence _persistence;
}