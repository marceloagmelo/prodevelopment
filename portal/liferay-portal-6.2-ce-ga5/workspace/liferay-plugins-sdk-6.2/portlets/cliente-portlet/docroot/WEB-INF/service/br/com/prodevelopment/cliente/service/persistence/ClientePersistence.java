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

package br.com.prodevelopment.cliente.service.persistence;

import br.com.prodevelopment.cliente.model.Cliente;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the cliente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see ClientePersistenceImpl
 * @see ClienteUtil
 * @generated
 */
public interface ClientePersistence extends BasePersistence<Cliente> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClienteUtil} to access the cliente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the clientes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set where uuid = &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] findByUuid_PrevAndNext(
		long clienteId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clientes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cliente where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the cliente that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] findByUuid_C_PrevAndNext(
		long clienteId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clientes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set where companyId = &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] findByCompany_PrevAndNext(
		long clienteId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clientes where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] findByC_G_PrevAndNext(
		long clienteId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching clientes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set of clientes that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] filterFindByC_G_PrevAndNext(
		long clienteId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clientes where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching clientes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] findByC_NOME_PrevAndNext(
		long clienteId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clientes where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] findByC_G_NOME_PrevAndNext(
		long clienteId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching clientes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set of clientes that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] filterFindByC_G_NOME_PrevAndNext(
		long clienteId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching clientes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where cpfCnpj = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteException} if it could not be found.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByCPF_CNPJ(
		java.lang.String cpfCnpj)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where cpfCnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByCPF_CNPJ(
		java.lang.String cpfCnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where cpfCnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cpfCnpj the cpf cnpj
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByCPF_CNPJ(
		java.lang.String cpfCnpj, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cliente where cpfCnpj = &#63; from the database.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the cliente that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente removeByCPF_CNPJ(
		java.lang.String cpfCnpj)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where cpfCnpj = &#63;.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCPF_CNPJ(java.lang.String cpfCnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where rgInscricaoMun = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteException} if it could not be found.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @return the matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByRG_INSCRICAO(
		java.lang.String rgInscricaoMun)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where rgInscricaoMun = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByRG_INSCRICAO(
		java.lang.String rgInscricaoMun)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente where rgInscricaoMun = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByRG_INSCRICAO(
		java.lang.String rgInscricaoMun, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cliente where rgInscricaoMun = &#63; from the database.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @return the cliente that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente removeByRG_INSCRICAO(
		java.lang.String rgInscricaoMun)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where rgInscricaoMun = &#63;.
	*
	* @param rgInscricaoMun the rg inscricao mun
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByRG_INSCRICAO(java.lang.String rgInscricaoMun)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByDT_NASCIMENTO(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cliente in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cliente in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clientes before and after the current cliente in the ordered set where dataNascimento = &#63;.
	*
	* @param clienteId the primary key of the current cliente
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente[] findByDT_NASCIMENTO_PrevAndNext(
		long clienteId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clientes where dataNascimento = &#63; from the database.
	*
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDT_NASCIMENTO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the number of matching clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countByDT_NASCIMENTO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the cliente in the entity cache if it is enabled.
	*
	* @param cliente the cliente
	*/
	public void cacheResult(br.com.prodevelopment.cliente.model.Cliente cliente);

	/**
	* Caches the clientes in the entity cache if it is enabled.
	*
	* @param clientes the clientes
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.cliente.model.Cliente> clientes);

	/**
	* Creates a new cliente with the primary key. Does not add the cliente to the database.
	*
	* @param clienteId the primary key for the new cliente
	* @return the new cliente
	*/
	public br.com.prodevelopment.cliente.model.Cliente create(long clienteId);

	/**
	* Removes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteId the primary key of the cliente
	* @return the cliente that was removed
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente remove(long clienteId)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.cliente.model.Cliente updateImpl(
		br.com.prodevelopment.cliente.model.Cliente cliente)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente with the primary key or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteException} if it could not be found.
	*
	* @param clienteId the primary key of the cliente
	* @return the cliente
	* @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente findByPrimaryKey(
		long clienteId)
		throws br.com.prodevelopment.cliente.NoSuchClienteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cliente with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clienteId the primary key of the cliente
	* @return the cliente, or <code>null</code> if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.cliente.model.Cliente fetchByPrimaryKey(
		long clienteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clientes.
	*
	* @return the clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clientes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clientes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clientes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clientes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clientes.
	*
	* @return the number of clientes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}