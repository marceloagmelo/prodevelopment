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

package br.com.prodevelopment.atividade.service.persistence;

import br.com.prodevelopment.atividade.model.Atividade;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the atividade service. This utility wraps {@link AtividadePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo
 * @see AtividadePersistence
 * @see AtividadePersistenceImpl
 * @generated
 */
public class AtividadeUtil {
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
	public static void clearCache(Atividade atividade) {
		getPersistence().clearCache(atividade);
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
	public static List<Atividade> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Atividade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Atividade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Atividade update(Atividade atividade)
		throws SystemException {
		return getPersistence().update(atividade);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Atividade update(Atividade atividade,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(atividade, serviceContext);
	}

	/**
	* Returns all the atividades where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the atividades where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the atividades where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set where uuid = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] findByUuid_PrevAndNext(
		long atividadeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(atividadeId, uuid, orderByComparator);
	}

	/**
	* Removes all the atividades where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of atividades where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the atividade where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.atividade.NoSuchAtividadeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the atividade where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the atividade where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the atividade where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the atividade that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of atividades where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the atividades where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the atividades where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the atividades where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] findByUuid_C_PrevAndNext(
		long atividadeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(atividadeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the atividades where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of atividades where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the atividades where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the atividades where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the atividades where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] findByCompany_PrevAndNext(
		long atividadeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(atividadeId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the atividades where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of atividades where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the atividades where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId);
	}

	/**
	* Returns a range of all the atividades where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] findByC_G_PrevAndNext(
		long atividadeId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(atividadeId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G(companyId, groupId);
	}

	/**
	* Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] filterFindByC_G_PrevAndNext(
		long atividadeId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_PrevAndNext(atividadeId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the atividades where companyId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of atividades where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, groupId);
	}

	/**
	* Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_G(companyId, groupId);
	}

	/**
	* Returns all the atividades where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_NOME(companyId, nome);
	}

	/**
	* Returns a range of all the atividades where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_NOME(companyId, nome, start, end);
	}

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME(companyId, nome, start, end, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_First(companyId, nome, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_NOME_First(companyId, nome, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_Last(companyId, nome, orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_NOME_Last(companyId, nome, orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] findByC_NOME_PrevAndNext(
		long atividadeId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_PrevAndNext(atividadeId, companyId, nome,
			orderByComparator);
	}

	/**
	* Removes all the atividades where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_NOME(companyId, nome);
	}

	/**
	* Returns the number of atividades where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_NOME(companyId, nome);
	}

	/**
	* Returns all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns a range of all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME(companyId, groupId, nome, start, end);
	}

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME(companyId, groupId, nome, start, end,
			orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_First(companyId, groupId, nome,
			orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_NOME_First(companyId, groupId, nome,
			orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_Last(companyId, groupId, nome,
			orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_NOME_Last(companyId, groupId, nome,
			orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] findByC_G_NOME_PrevAndNext(
		long atividadeId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_PrevAndNext(atividadeId, companyId, groupId,
			nome, orderByComparator);
	}

	/**
	* Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME(companyId, groupId, nome, start, end);
	}

	/**
	* Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME(companyId, groupId, nome, start, end,
			orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] filterFindByC_G_NOME_PrevAndNext(
		long atividadeId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME_PrevAndNext(atividadeId, companyId,
			groupId, nome, orderByComparator);
	}

	/**
	* Removes all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns the number of atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns all the atividades where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_DESCRICAO(
		long companyId, java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_DESCRICAO(companyId, descricao);
	}

	/**
	* Returns a range of all the atividades where companyId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_DESCRICAO(
		long companyId, java.lang.String descricao, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DESCRICAO(companyId, descricao, start, end);
	}

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_DESCRICAO(
		long companyId, java.lang.String descricao, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DESCRICAO(companyId, descricao, start, end,
			orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_DESCRICAO_First(
		long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DESCRICAO_First(companyId, descricao,
			orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_DESCRICAO_First(
		long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_DESCRICAO_First(companyId, descricao,
			orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_DESCRICAO_Last(
		long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DESCRICAO_Last(companyId, descricao,
			orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_DESCRICAO_Last(
		long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_DESCRICAO_Last(companyId, descricao,
			orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] findByC_DESCRICAO_PrevAndNext(
		long atividadeId, long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DESCRICAO_PrevAndNext(atividadeId, companyId,
			descricao, orderByComparator);
	}

	/**
	* Removes all the atividades where companyId = &#63; and descricao LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_DESCRICAO(long companyId,
		java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_DESCRICAO(companyId, descricao);
	}

	/**
	* Returns the number of atividades where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_DESCRICAO(long companyId,
		java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_DESCRICAO(companyId, descricao);
	}

	/**
	* Returns all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DESCRICAO(companyId, groupId, descricao);
	}

	/**
	* Returns a range of all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DESCRICAO(companyId, groupId, descricao, start,
			end);
	}

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DESCRICAO(companyId, groupId, descricao, start,
			end, orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_G_DESCRICAO_First(
		long companyId, long groupId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DESCRICAO_First(companyId, groupId, descricao,
			orderByComparator);
	}

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_G_DESCRICAO_First(
		long companyId, long groupId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_DESCRICAO_First(companyId, groupId, descricao,
			orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByC_G_DESCRICAO_Last(
		long companyId, long groupId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DESCRICAO_Last(companyId, groupId, descricao,
			orderByComparator);
	}

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByC_G_DESCRICAO_Last(
		long companyId, long groupId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_DESCRICAO_Last(companyId, groupId, descricao,
			orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] findByC_G_DESCRICAO_PrevAndNext(
		long atividadeId, long companyId, long groupId,
		java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DESCRICAO_PrevAndNext(atividadeId, companyId,
			groupId, descricao, orderByComparator);
	}

	/**
	* Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @return the matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_DESCRICAO(companyId, groupId, descricao);
	}

	/**
	* Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_DESCRICAO(companyId, groupId, descricao,
			start, end);
	}

	/**
	* Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_DESCRICAO(companyId, groupId, descricao,
			start, end, orderByComparator);
	}

	/**
	* Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade[] filterFindByC_G_DESCRICAO_PrevAndNext(
		long atividadeId, long companyId, long groupId,
		java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_DESCRICAO_PrevAndNext(atividadeId,
			companyId, groupId, descricao, orderByComparator);
	}

	/**
	* Removes all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_DESCRICAO(long companyId, long groupId,
		java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_DESCRICAO(companyId, groupId, descricao);
	}

	/**
	* Returns the number of atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_DESCRICAO(long companyId, long groupId,
		java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_DESCRICAO(companyId, groupId, descricao);
	}

	/**
	* Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @return the number of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G_DESCRICAO(long companyId, long groupId,
		java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByC_G_DESCRICAO(companyId, groupId, descricao);
	}

	/**
	* Caches the atividade in the entity cache if it is enabled.
	*
	* @param atividade the atividade
	*/
	public static void cacheResult(
		br.com.prodevelopment.atividade.model.Atividade atividade) {
		getPersistence().cacheResult(atividade);
	}

	/**
	* Caches the atividades in the entity cache if it is enabled.
	*
	* @param atividades the atividades
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.atividade.model.Atividade> atividades) {
		getPersistence().cacheResult(atividades);
	}

	/**
	* Creates a new atividade with the primary key. Does not add the atividade to the database.
	*
	* @param atividadeId the primary key for the new atividade
	* @return the new atividade
	*/
	public static br.com.prodevelopment.atividade.model.Atividade create(
		long atividadeId) {
		return getPersistence().create(atividadeId);
	}

	/**
	* Removes the atividade with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade that was removed
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade remove(
		long atividadeId)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(atividadeId);
	}

	public static br.com.prodevelopment.atividade.model.Atividade updateImpl(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(atividade);
	}

	/**
	* Returns the atividade with the primary key or throws a {@link br.com.prodevelopment.atividade.NoSuchAtividadeException} if it could not be found.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade findByPrimaryKey(
		long atividadeId)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(atividadeId);
	}

	/**
	* Returns the atividade with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade, or <code>null</code> if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchByPrimaryKey(
		long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(atividadeId);
	}

	/**
	* Returns all the atividades.
	*
	* @return the atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the atividades.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the atividades.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of atividades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the atividades from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of atividades.
	*
	* @return the number of atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AtividadePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AtividadePersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.atividade.service.ClpSerializer.getServletContextName(),
					AtividadePersistence.class.getName());

			ReferenceRegistry.registerReference(AtividadeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AtividadePersistence persistence) {
	}

	private static AtividadePersistence _persistence;
}