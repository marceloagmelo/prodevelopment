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

import br.com.prodevelopment.funcionario.model.Funcionario;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the funcionario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see FuncionarioPersistenceImpl
 * @see FuncionarioUtil
 * @generated
 */
public interface FuncionarioPersistence extends BasePersistence<Funcionario> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FuncionarioUtil} to access the funcionario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the funcionarios where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where uuid = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByUuid_PrevAndNext(
		long funcionarioId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the funcionario where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByUuid_C_PrevAndNext(
		long funcionarioId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByCompany_PrevAndNext(
		long funcionarioId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByC_G_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] filterFindByC_G_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByC_NOME_PrevAndNext(
		long funcionarioId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByC_G_NOME_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] filterFindByC_G_NOME_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
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
	* Returns the number of funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_N_REDUZIDO(
		long companyId, java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_N_REDUZIDO(
		long companyId, java.lang.String nomeReduzido, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_N_REDUZIDO(
		long companyId, java.lang.String nomeReduzido, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_N_REDUZIDO_First(
		long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_N_REDUZIDO_First(
		long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_N_REDUZIDO_Last(
		long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_N_REDUZIDO_Last(
		long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByC_N_REDUZIDO_PrevAndNext(
		long funcionarioId, long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_N_REDUZIDO(long companyId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_N_REDUZIDO(long companyId, java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_G_N_REDUZIDO_First(
		long companyId, long groupId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_N_REDUZIDO_First(
		long companyId, long groupId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByC_G_N_REDUZIDO_Last(
		long companyId, long groupId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_N_REDUZIDO_Last(
		long companyId, long groupId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByC_G_N_REDUZIDO_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @return the matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios that the user has permissions to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] filterFindByC_G_N_REDUZIDO_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_N_REDUZIDO(long companyId, long groupId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_N_REDUZIDO(long companyId, long groupId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @return the number of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G_N_REDUZIDO(long companyId, long groupId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where cpf = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param cpf the cpf
	* @return the matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByCPF(
		java.lang.String cpf)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where cpf = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cpf the cpf
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByCPF(
		java.lang.String cpf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where cpf = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cpf the cpf
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByCPF(
		java.lang.String cpf, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the funcionario where cpf = &#63; from the database.
	*
	* @param cpf the cpf
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario removeByCPF(
		java.lang.String cpf)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where cpf = &#63;.
	*
	* @param cpf the cpf
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByCPF(java.lang.String cpf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where rg = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param rg the rg
	* @return the matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByRG(
		java.lang.String rg)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where rg = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rg the rg
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByRG(
		java.lang.String rg)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where rg = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rg the rg
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByRG(
		java.lang.String rg, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the funcionario where rg = &#63; from the database.
	*
	* @param rg the rg
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario removeByRG(
		java.lang.String rg)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where rg = &#63;.
	*
	* @param rg the rg
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByRG(java.lang.String rg)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByDT_NASCIMENTO_PrevAndNext(
		long funcionarioId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where dataNascimento = &#63; from the database.
	*
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDT_NASCIMENTO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByDT_NASCIMENTO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCARGO(
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where cargoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cargoId the cargo ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCARGO(
		long cargoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where cargoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cargoId the cargo ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCARGO(
		long cargoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByCARGO_First(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByCARGO_First(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByCARGO_Last(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByCARGO_Last(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where cargoId = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario[] findByCARGO_PrevAndNext(
		long funcionarioId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where cargoId = &#63; from the database.
	*
	* @param cargoId the cargo ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCARGO(long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByCARGO(long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where userId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByUSUARIO(
		long userId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUSUARIO(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUSUARIO(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the funcionario where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario removeByUSUARIO(
		long userId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByUSUARIO(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the funcionario in the entity cache if it is enabled.
	*
	* @param funcionario the funcionario
	*/
	public void cacheResult(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario);

	/**
	* Caches the funcionarios in the entity cache if it is enabled.
	*
	* @param funcionarios the funcionarios
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> funcionarios);

	/**
	* Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	*
	* @param funcionarioId the primary key for the new funcionario
	* @return the new funcionario
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario create(
		long funcionarioId);

	/**
	* Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario that was removed
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario remove(
		long funcionarioId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.funcionario.model.Funcionario updateImpl(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario with the primary key or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario findByPrimaryKey(
		long funcionarioId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario, or <code>null</code> if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByPrimaryKey(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios.
	*
	* @return the funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios.
	*
	* @return the number of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}