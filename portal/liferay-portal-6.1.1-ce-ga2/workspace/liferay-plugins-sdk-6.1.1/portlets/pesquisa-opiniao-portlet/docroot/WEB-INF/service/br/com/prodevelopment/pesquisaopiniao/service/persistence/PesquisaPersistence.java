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

package br.com.prodevelopment.pesquisaopiniao.service.persistence;

import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the pesquisa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see PesquisaPersistenceImpl
 * @see PesquisaUtil
 * @generated
 */
public interface PesquisaPersistence extends BasePersistence<Pesquisa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PesquisaUtil} to access the pesquisa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the pesquisa in the entity cache if it is enabled.
	*
	* @param pesquisa the pesquisa
	*/
	public void cacheResult(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa pesquisa);

	/**
	* Caches the pesquisas in the entity cache if it is enabled.
	*
	* @param pesquisas the pesquisas
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> pesquisas);

	/**
	* Creates a new pesquisa with the primary key. Does not add the pesquisa to the database.
	*
	* @param id the primary key for the new pesquisa
	* @return the new pesquisa
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa create(long id);

	/**
	* Removes the pesquisa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the pesquisa
	* @return the pesquisa that was removed
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa remove(long id)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa updateImpl(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa pesquisa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisa with the primary key or throws a {@link br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException} if it could not be found.
	*
	* @param id the primary key of the pesquisa
	* @return the pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the pesquisa
	* @return the pesquisa, or <code>null</code> if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pesquisas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pesquisas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @return the range of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pesquisas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pesquisa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pesquisa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pesquisa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pesquisa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisas before and after the current pesquisa in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current pesquisa
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisa where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pesquisas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pesquisas where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @return the range of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pesquisas where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisas before and after the current pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current pesquisa
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa[] findByC_G_PrevAndNext(
		long id, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pesquisas that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching pesquisas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pesquisas that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @return the range of matching pesquisas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pesquisas that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pesquisas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisas before and after the current pesquisa in the ordered set of pesquisas that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param id the primary key of the current pesquisa
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa[] filterFindByC_G_PrevAndNext(
		long id, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pesquisas where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pesquisas where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @return the range of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pesquisas where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pesquisa in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pesquisa in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pesquisa in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pesquisa in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisas before and after the current pesquisa in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current pesquisa
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa[] findByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pesquisas that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching pesquisas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pesquisas that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @return the range of matching pesquisas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pesquisas that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pesquisas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisas before and after the current pesquisa in the ordered set of pesquisas that the user has permission to view where groupId = &#63;.
	*
	* @param id the primary key of the current pesquisa
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa[] filterFindByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pesquisas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pesquisas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @return the range of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pesquisas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pesquisa in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pesquisa in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pesquisa in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pesquisa in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pesquisas before and after the current pesquisa in the ordered set where companyId = &#63;.
	*
	* @param id the primary key of the current pesquisa
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pesquisa
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa[] findByCompanyId_PrevAndNext(
		long id, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pesquisas.
	*
	* @return the pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pesquisas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @return the range of pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pesquisas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pesquisas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the pesquisa where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the pesquisa that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pesquisas where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pesquisas where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pesquisas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pesquisas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pesquisas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pesquisas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pesquisas where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pesquisas that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching pesquisas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pesquisas where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pesquisas that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching pesquisas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pesquisas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pesquisas.
	*
	* @return the number of pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}