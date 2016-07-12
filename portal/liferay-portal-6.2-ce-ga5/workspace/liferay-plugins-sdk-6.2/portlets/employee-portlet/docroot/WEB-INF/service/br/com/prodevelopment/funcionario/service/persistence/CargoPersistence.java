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

package br.com.prodevelopment.funcionario.service.persistence;

import br.com.prodevelopment.funcionario.model.Cargo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the cargo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see CargoPersistenceImpl
 * @see CargoUtil
 * @generated
 */
public interface CargoPersistence extends BasePersistence<Cargo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CargoUtil} to access the cargo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cargos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargos before and after the current cargo in the ordered set where uuid = &#63;.
	*
	* @param cargoId the primary key of the current cargo
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo[] findByUuid_PrevAndNext(
		long cargoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cargos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargo where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchCargoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cargo where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the cargo that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargos before and after the current cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param cargoId the primary key of the current cargo
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo[] findByUuid_C_PrevAndNext(
		long cargoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cargos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargos before and after the current cargo in the ordered set where companyId = &#63;.
	*
	* @param cargoId the primary key of the current cargo
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo[] findByCompany_PrevAndNext(
		long cargoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cargos where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargos before and after the current cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param cargoId the primary key of the current cargo
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo[] findByC_G_PrevAndNext(
		long cargoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargos before and after the current cargo in the ordered set of cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param cargoId the primary key of the current cargo
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo[] filterFindByC_G_PrevAndNext(
		long cargoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cargos where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargos before and after the current cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param cargoId the primary key of the current cargo
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo[] findByC_NOME_PrevAndNext(
		long cargoId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cargos where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargos before and after the current cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param cargoId the primary key of the current cargo
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo[] findByC_G_NOME_PrevAndNext(
		long cargoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargos before and after the current cargo in the ordered set of cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param cargoId the primary key of the current cargo
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo[] filterFindByC_G_NOME_PrevAndNext(
		long cargoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
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
	* Returns the number of cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the cargo in the entity cache if it is enabled.
	*
	* @param cargo the cargo
	*/
	public void cacheResult(br.com.prodevelopment.funcionario.model.Cargo cargo);

	/**
	* Caches the cargos in the entity cache if it is enabled.
	*
	* @param cargos the cargos
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.funcionario.model.Cargo> cargos);

	/**
	* Creates a new cargo with the primary key. Does not add the cargo to the database.
	*
	* @param cargoId the primary key for the new cargo
	* @return the new cargo
	*/
	public br.com.prodevelopment.funcionario.model.Cargo create(long cargoId);

	/**
	* Removes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo that was removed
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo remove(long cargoId)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.funcionario.model.Cargo updateImpl(
		br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargo with the primary key or throws a {@link br.com.prodevelopment.funcionario.NoSuchCargoException} if it could not be found.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo findByPrimaryKey(
		long cargoId)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo, or <code>null</code> if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Cargo fetchByPrimaryKey(
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos.
	*
	* @return the cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cargos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cargos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cargos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos.
	*
	* @return the number of cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}