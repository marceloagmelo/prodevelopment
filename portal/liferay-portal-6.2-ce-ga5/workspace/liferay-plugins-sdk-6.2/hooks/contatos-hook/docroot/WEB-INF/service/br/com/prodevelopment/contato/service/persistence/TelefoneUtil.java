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

package br.com.prodevelopment.contato.service.persistence;

import br.com.prodevelopment.contato.model.Telefone;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the telefone service. This utility wraps {@link TelefonePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TelefonePersistence
 * @see TelefonePersistenceImpl
 * @generated
 */
public class TelefoneUtil {
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
	public static void clearCache(Telefone telefone) {
		getPersistence().clearCache(telefone);
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
	public static List<Telefone> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Telefone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Telefone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Telefone update(Telefone telefone) throws SystemException {
		return getPersistence().update(telefone);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Telefone update(Telefone telefone,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(telefone, serviceContext);
	}

	/**
	* Returns all the telefones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the telefones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the telefones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the telefones before and after the current telefone in the ordered set where uuid = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone[] findByUuid_PrevAndNext(
		long telefoneId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(telefoneId, uuid, orderByComparator);
	}

	/**
	* Removes all the telefones where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of telefones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the telefone where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchTelefoneException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the telefone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the telefone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the telefone where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the telefone that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of telefones where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the telefones where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the telefones where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the telefones where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the telefones before and after the current telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone[] findByUuid_C_PrevAndNext(
		long telefoneId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(telefoneId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the telefones where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of telefones where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the telefones where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the telefones where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the telefones where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the telefones before and after the current telefone in the ordered set where companyId = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone[] findByCompanyId_PrevAndNext(
		long telefoneId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(telefoneId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the telefones where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of telefones where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the telefones where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(companyId, classNameId);
	}

	/**
	* Returns a range of all the telefones where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(companyId, classNameId, start, end);
	}

	/**
	* Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C(companyId, classNameId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_First(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_First(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_Last(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_Last(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone[] findByC_C_PrevAndNext(
		long telefoneId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_PrevAndNext(telefoneId, companyId, classNameId,
			orderByComparator);
	}

	/**
	* Removes all the telefones where companyId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C(companyId, classNameId);
	}

	/**
	* Returns the number of telefones where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C(companyId, classNameId);
	}

	/**
	* Returns all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns a range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C(companyId, classNameId, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C(companyId, classNameId, classPK, start, end,
			orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_First(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_First(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_Last(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_Last(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone[] findByC_C_C_PrevAndNext(
		long telefoneId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_PrevAndNext(telefoneId, companyId, classNameId,
			classPK, orderByComparator);
	}

	/**
	* Removes all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns the number of telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal);
	}

	/**
	* Returns a range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal,
			start, end);
	}

	/**
	* Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal,
			start, end, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_First(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_P_First(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_Last(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_P_Last(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

	/**
	* Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone[] findByC_C_C_P_PrevAndNext(
		long telefoneId, long companyId, long classNameId, long classPK,
		boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_PrevAndNext(telefoneId, companyId,
			classNameId, classPK, principal, orderByComparator);
	}

	/**
	* Removes all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByC_C_C_P(companyId, classNameId, classPK, principal);
	}

	/**
	* Returns the number of telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_C_C_P(companyId, classNameId, classPK, principal);
	}

	/**
	* Caches the telefone in the entity cache if it is enabled.
	*
	* @param telefone the telefone
	*/
	public static void cacheResult(
		br.com.prodevelopment.contato.model.Telefone telefone) {
		getPersistence().cacheResult(telefone);
	}

	/**
	* Caches the telefones in the entity cache if it is enabled.
	*
	* @param telefones the telefones
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.contato.model.Telefone> telefones) {
		getPersistence().cacheResult(telefones);
	}

	/**
	* Creates a new telefone with the primary key. Does not add the telefone to the database.
	*
	* @param telefoneId the primary key for the new telefone
	* @return the new telefone
	*/
	public static br.com.prodevelopment.contato.model.Telefone create(
		long telefoneId) {
		return getPersistence().create(telefoneId);
	}

	/**
	* Removes the telefone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone that was removed
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone remove(
		long telefoneId)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(telefoneId);
	}

	public static br.com.prodevelopment.contato.model.Telefone updateImpl(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(telefone);
	}

	/**
	* Returns the telefone with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchTelefoneException} if it could not be found.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone findByPrimaryKey(
		long telefoneId)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(telefoneId);
	}

	/**
	* Returns the telefone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone, or <code>null</code> if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchByPrimaryKey(
		long telefoneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(telefoneId);
	}

	/**
	* Returns all the telefones.
	*
	* @return the telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the telefones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the telefones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the telefones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of telefones.
	*
	* @return the number of telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TelefonePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TelefonePersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.contato.service.ClpSerializer.getServletContextName(),
					TelefonePersistence.class.getName());

			ReferenceRegistry.registerReference(TelefoneUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TelefonePersistence persistence) {
	}

	private static TelefonePersistence _persistence;
}