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

package br.com.prodevelopment.testeconhecimento.service.persistence;

import br.com.prodevelopment.testeconhecimento.model.Teste;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the teste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TestePersistenceImpl
 * @see TesteUtil
 * @generated
 */
public interface TestePersistence extends BasePersistence<Teste> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TesteUtil} to access the teste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the teste in the entity cache if it is enabled.
	*
	* @param teste the teste
	*/
	public void cacheResult(
		br.com.prodevelopment.testeconhecimento.model.Teste teste);

	/**
	* Caches the testes in the entity cache if it is enabled.
	*
	* @param testes the testes
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> testes);

	/**
	* Creates a new teste with the primary key. Does not add the teste to the database.
	*
	* @param id the primary key for the new teste
	* @return the new teste
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste create(long id);

	/**
	* Removes the teste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the teste
	* @return the teste that was removed
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste remove(long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.testeconhecimento.model.Teste updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Teste teste, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the teste with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchTesteException} if it could not be found.
	*
	* @param id the primary key of the teste
	* @return the teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the teste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the teste
	* @return the teste, or <code>null</code> if a teste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the testes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the testes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @return the range of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the testes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the testes before and after the current teste in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current teste
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the teste where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchTesteException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the teste where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the teste where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the testes where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the testes where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @return the range of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the testes where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the testes before and after the current teste in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current teste
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste[] findByCompanyGroup_PrevAndNext(
		long id, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the testes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the testes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @return the range of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the testes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the testes before and after the current teste in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current teste
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste[] findByGroup_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the testes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the testes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @return the range of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the testes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste, or <code>null</code> if a matching teste could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the testes before and after the current teste in the ordered set where companyId = &#63;.
	*
	* @param id the primary key of the current teste
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next teste
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste[] findByCompany_PrevAndNext(
		long id, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the testes.
	*
	* @return the testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the testes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @return the range of testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the testes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of testes
	* @param end the upper bound of the range of testes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of testes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the testes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the teste where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the teste that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the testes where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the testes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the testes where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the testes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testes where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching testes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testes.
	*
	* @return the number of testes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}