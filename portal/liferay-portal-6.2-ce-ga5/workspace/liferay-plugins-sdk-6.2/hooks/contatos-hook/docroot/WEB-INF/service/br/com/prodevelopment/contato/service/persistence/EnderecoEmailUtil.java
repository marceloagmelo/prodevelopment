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

import br.com.prodevelopment.contato.model.EnderecoEmail;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the endereco email service. This utility wraps {@link EnderecoEmailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EnderecoEmailPersistence
 * @see EnderecoEmailPersistenceImpl
 * @generated
 */
public class EnderecoEmailUtil {
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
	public static void clearCache(EnderecoEmail enderecoEmail) {
		getPersistence().clearCache(enderecoEmail);
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
	public static List<EnderecoEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EnderecoEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EnderecoEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EnderecoEmail update(EnderecoEmail enderecoEmail)
		throws SystemException {
		return getPersistence().update(enderecoEmail);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EnderecoEmail update(EnderecoEmail enderecoEmail,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(enderecoEmail, serviceContext);
	}

	/**
	* Returns all the endereco emails where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the endereco emails where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the endereco emails where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where uuid = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail[] findByUuid_PrevAndNext(
		long enderecoEmailId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(enderecoEmailId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the endereco emails where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of endereco emails where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the endereco email where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoEmailException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the endereco email where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the endereco email where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the endereco email where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the endereco email that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of endereco emails where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the endereco emails where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the endereco emails where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the endereco emails where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail[] findByUuid_C_PrevAndNext(
		long enderecoEmailId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(enderecoEmailId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the endereco emails where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of endereco emails where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the endereco emails where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the endereco emails where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the endereco emails where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail[] findByCompanyId_PrevAndNext(
		long enderecoEmailId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(enderecoEmailId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the endereco emails where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of endereco emails where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the endereco emails where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(companyId, classNameId);
	}

	/**
	* Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(companyId, classNameId, start, end);
	}

	/**
	* Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C(companyId, classNameId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_First(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_First(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_Last(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_Last(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail[] findByC_C_PrevAndNext(
		long enderecoEmailId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_PrevAndNext(enderecoEmailId, companyId,
			classNameId, orderByComparator);
	}

	/**
	* Removes all the endereco emails where companyId = &#63; and classNameId = &#63; from the database.
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
	* Returns the number of endereco emails where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C(companyId, classNameId);
	}

	/**
	* Returns all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C(companyId, classNameId, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C(companyId, classNameId, classPK, start, end,
			orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_First(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_First(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_Last(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_Last(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail[] findByC_C_C_PrevAndNext(
		long enderecoEmailId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_PrevAndNext(enderecoEmailId, companyId,
			classNameId, classPK, orderByComparator);
	}

	/**
	* Removes all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
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
	* Returns the number of endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal);
	}

	/**
	* Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal,
			start, end);
	}

	/**
	* Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal,
			start, end, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_First(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_P_First(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_Last(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_P_Last(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail[] findByC_C_C_P_PrevAndNext(
		long enderecoEmailId, long companyId, long classNameId, long classPK,
		boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_PrevAndNext(enderecoEmailId, companyId,
			classNameId, classPK, principal, orderByComparator);
	}

	/**
	* Removes all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
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
	* Returns the number of endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_C_C_P(companyId, classNameId, classPK, principal);
	}

	/**
	* Caches the endereco email in the entity cache if it is enabled.
	*
	* @param enderecoEmail the endereco email
	*/
	public static void cacheResult(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail) {
		getPersistence().cacheResult(enderecoEmail);
	}

	/**
	* Caches the endereco emails in the entity cache if it is enabled.
	*
	* @param enderecoEmails the endereco emails
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> enderecoEmails) {
		getPersistence().cacheResult(enderecoEmails);
	}

	/**
	* Creates a new endereco email with the primary key. Does not add the endereco email to the database.
	*
	* @param enderecoEmailId the primary key for the new endereco email
	* @return the new endereco email
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail create(
		long enderecoEmailId) {
		return getPersistence().create(enderecoEmailId);
	}

	/**
	* Removes the endereco email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoEmailId the primary key of the endereco email
	* @return the endereco email that was removed
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail remove(
		long enderecoEmailId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(enderecoEmailId);
	}

	public static br.com.prodevelopment.contato.model.EnderecoEmail updateImpl(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(enderecoEmail);
	}

	/**
	* Returns the endereco email with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoEmailException} if it could not be found.
	*
	* @param enderecoEmailId the primary key of the endereco email
	* @return the endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail findByPrimaryKey(
		long enderecoEmailId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(enderecoEmailId);
	}

	/**
	* Returns the endereco email with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enderecoEmailId the primary key of the endereco email
	* @return the endereco email, or <code>null</code> if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchByPrimaryKey(
		long enderecoEmailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(enderecoEmailId);
	}

	/**
	* Returns all the endereco emails.
	*
	* @return the endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the endereco emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the endereco emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the endereco emails from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of endereco emails.
	*
	* @return the number of endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EnderecoEmailPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EnderecoEmailPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.contato.service.ClpSerializer.getServletContextName(),
					EnderecoEmailPersistence.class.getName());

			ReferenceRegistry.registerReference(EnderecoEmailUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EnderecoEmailPersistence persistence) {
	}

	private static EnderecoEmailPersistence _persistence;
}