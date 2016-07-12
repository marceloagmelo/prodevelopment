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

import br.com.prodevelopment.contato.model.Endereco;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the endereco service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see EnderecoPersistenceImpl
 * @see EnderecoUtil
 * @generated
 */
public interface EnderecoPersistence extends BasePersistence<Endereco> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnderecoUtil} to access the endereco persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the enderecos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where uuid = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByUuid_PrevAndNext(
		long enderecoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the endereco where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the endereco that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByUuid_C_PrevAndNext(
		long enderecoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByCompanyId_PrevAndNext(
		long enderecoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_U(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_U(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_U(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_U_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_U_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_U_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_U_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_U_PrevAndNext(
		long enderecoId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_U(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_U(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_U(
		long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_U(
		long companyId, long groupId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_U(
		long companyId, long groupId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_U_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_U_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_U_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_U_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_G_U_PrevAndNext(
		long enderecoId, long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_U(long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_U(long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_C_PrevAndNext(
		long enderecoId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_G(
		long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_G(
		long companyId, long groupId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_G(
		long companyId, long groupId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_C_G_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_C_G_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_C_G_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_C_G_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_C_G_PrevAndNext(
		long enderecoId, long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_G(long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_G(long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_C_C_PrevAndNext(
		long enderecoId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_C_C_P_PrevAndNext(
		long enderecoId, long companyId, long classNameId, long classPK,
		boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CEP(
		long companyId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and cep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param cep the cep
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CEP(
		long companyId, java.lang.String cep, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and cep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param cep the cep
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CEP(
		long companyId, java.lang.String cep, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_CEP_First(
		long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_CEP_First(
		long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_CEP_Last(
		long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_CEP_Last(
		long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and cep = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_CEP_PrevAndNext(
		long enderecoId, long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and cep = &#63; from the database.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_CEP(long companyId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_CEP(long companyId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CEP(
		long companyId, long groupId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CEP(
		long companyId, long groupId, java.lang.String cep, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CEP(
		long companyId, long groupId, java.lang.String cep, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_CEP_First(
		long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_CEP_First(
		long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_CEP_Last(
		long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_CEP_Last(
		long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_G_CEP_PrevAndNext(
		long enderecoId, long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_CEP(long companyId, long groupId,
		java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_CEP(long companyId, long groupId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where cep = &#63;.
	*
	* @param cep the cep
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCEP(
		java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where cep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cep the cep
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCEP(
		java.lang.String cep, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where cep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cep the cep
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCEP(
		java.lang.String cep, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where cep = &#63;.
	*
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByCEP_First(
		java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where cep = &#63;.
	*
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByCEP_First(
		java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where cep = &#63;.
	*
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByCEP_Last(
		java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where cep = &#63;.
	*
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByCEP_Last(
		java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where cep = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByCEP_PrevAndNext(
		long enderecoId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where cep = &#63; from the database.
	*
	* @param cep the cep
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCEP(java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where cep = &#63;.
	*
	* @param cep the cep
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCEP(java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_BAIRRO(
		long companyId, java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and bairro LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_BAIRRO(
		long companyId, java.lang.String bairro, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and bairro LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_BAIRRO(
		long companyId, java.lang.String bairro, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_BAIRRO_First(
		long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_BAIRRO_First(
		long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_BAIRRO_Last(
		long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_BAIRRO_Last(
		long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_BAIRRO_PrevAndNext(
		long enderecoId, long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and bairro LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_BAIRRO(long companyId, java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_BAIRRO(long companyId, java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_BAIRRO(
		long companyId, long groupId, java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_BAIRRO(
		long companyId, long groupId, java.lang.String bairro, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_BAIRRO(
		long companyId, long groupId, java.lang.String bairro, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_BAIRRO_First(
		long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_BAIRRO_First(
		long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_BAIRRO_Last(
		long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_BAIRRO_Last(
		long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_G_BAIRRO_PrevAndNext(
		long enderecoId, long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_BAIRRO(long companyId, long groupId,
		java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_BAIRRO(long companyId, long groupId,
		java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByBAIRRO(
		java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where bairro LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bairro the bairro
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByBAIRRO(
		java.lang.String bairro, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where bairro LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bairro the bairro
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByBAIRRO(
		java.lang.String bairro, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByBAIRRO_First(
		java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByBAIRRO_First(
		java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByBAIRRO_Last(
		java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByBAIRRO_Last(
		java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByBAIRRO_PrevAndNext(
		long enderecoId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where bairro LIKE &#63; from the database.
	*
	* @param bairro the bairro
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBAIRRO(java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByBAIRRO(java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CIDADE(
		long companyId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and cidadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CIDADE(
		long companyId, long cidadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and cidadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CIDADE(
		long companyId, long cidadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_CIDADE_First(
		long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_CIDADE_First(
		long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_CIDADE_Last(
		long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_CIDADE_Last(
		long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_CIDADE_PrevAndNext(
		long enderecoId, long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and cidadeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_CIDADE(long companyId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_CIDADE(long companyId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CIDADE(
		long companyId, long groupId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CIDADE(
		long companyId, long groupId, long cidadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CIDADE(
		long companyId, long groupId, long cidadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_CIDADE_First(
		long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_CIDADE_First(
		long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_CIDADE_Last(
		long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_CIDADE_Last(
		long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_G_CIDADE_PrevAndNext(
		long enderecoId, long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_CIDADE(long companyId, long groupId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_CIDADE(long companyId, long groupId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCIDADE(
		long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where cidadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cidadeId the cidade ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCIDADE(
		long cidadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where cidadeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cidadeId the cidade ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCIDADE(
		long cidadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByCIDADE_First(
		long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByCIDADE_First(
		long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByCIDADE_Last(
		long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByCIDADE_Last(
		long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where cidadeId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByCIDADE_PrevAndNext(
		long enderecoId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where cidadeId = &#63; from the database.
	*
	* @param cidadeId the cidade ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCIDADE(long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCIDADE(long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_UF(
		long companyId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and uf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param uf the uf
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_UF(
		long companyId, java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and uf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param uf the uf
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_UF(
		long companyId, java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_UF_First(
		long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_UF_First(
		long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_UF_Last(
		long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_UF_Last(
		long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and uf = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_UF_PrevAndNext(
		long enderecoId, long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and uf = &#63; from the database.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_UF(long companyId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_UF(long companyId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_UF(
		long companyId, long groupId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_UF(
		long companyId, long groupId, java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_UF(
		long companyId, long groupId, java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_UF_First(
		long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_UF_First(
		long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_UF_Last(
		long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_UF_Last(
		long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_G_UF_PrevAndNext(
		long enderecoId, long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_UF(long companyId, long groupId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_UF(long companyId, long groupId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where uf = &#63;.
	*
	* @param uf the uf
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUF(
		java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where uf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uf the uf
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUF(
		java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where uf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uf the uf
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUF(
		java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByUF_First(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByUF_First(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByUF_Last(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByUF_Last(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where uf = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByUF_PrevAndNext(
		long enderecoId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where uf = &#63; from the database.
	*
	* @param uf the uf
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUF(java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where uf = &#63;.
	*
	* @param uf the uf
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUF(java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_PAIS(
		long companyId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and paisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_PAIS(
		long companyId, long paisId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and paisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_PAIS(
		long companyId, long paisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_PAIS_First(
		long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_PAIS_First(
		long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_PAIS_Last(
		long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_PAIS_Last(
		long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_PAIS_PrevAndNext(
		long enderecoId, long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and paisId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_PAIS(long companyId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_PAIS(long companyId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_PAIS(
		long companyId, long groupId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_PAIS(
		long companyId, long groupId, long paisId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_PAIS(
		long companyId, long groupId, long paisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_PAIS_First(
		long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_PAIS_First(
		long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByC_G_PAIS_Last(
		long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByC_G_PAIS_Last(
		long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByC_G_PAIS_PrevAndNext(
		long enderecoId, long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_PAIS(long companyId, long groupId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_PAIS(long companyId, long groupId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByPAIS(
		long paisId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos where paisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paisId the pais ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByPAIS(
		long paisId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos where paisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paisId the pais ID
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findByPAIS(
		long paisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByPAIS_First(
		long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco in the ordered set where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByPAIS_First(
		long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByPAIS_Last(
		long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco in the ordered set where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByPAIS_Last(
		long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enderecos before and after the current endereco in the ordered set where paisId = &#63;.
	*
	* @param enderecoId the primary key of the current endereco
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco[] findByPAIS_PrevAndNext(
		long enderecoId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos where paisId = &#63; from the database.
	*
	* @param paisId the pais ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPAIS(long paisId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countByPAIS(long paisId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the endereco in the entity cache if it is enabled.
	*
	* @param endereco the endereco
	*/
	public void cacheResult(
		br.com.prodevelopment.contato.model.Endereco endereco);

	/**
	* Caches the enderecos in the entity cache if it is enabled.
	*
	* @param enderecos the enderecos
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.contato.model.Endereco> enderecos);

	/**
	* Creates a new endereco with the primary key. Does not add the endereco to the database.
	*
	* @param enderecoId the primary key for the new endereco
	* @return the new endereco
	*/
	public br.com.prodevelopment.contato.model.Endereco create(long enderecoId);

	/**
	* Removes the endereco with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco that was removed
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco remove(long enderecoId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.contato.model.Endereco updateImpl(
		br.com.prodevelopment.contato.model.Endereco endereco)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoException} if it could not be found.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco findByPrimaryKey(
		long enderecoId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco, or <code>null</code> if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Endereco fetchByPrimaryKey(
		long enderecoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enderecos.
	*
	* @return the enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enderecos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enderecos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enderecos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enderecos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enderecos.
	*
	* @return the number of enderecos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}