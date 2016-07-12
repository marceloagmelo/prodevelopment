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

package br.com.prodevelopment.appcomercial.servico.service.persistence;

import br.com.prodevelopment.appcomercial.servico.model.Funcionario;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the funcionario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
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
	* Returns all the funcionarios where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByCompany_Last(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByCompany_PrevAndNext(
		long funcionarioId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_G_First(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_G_Last(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByC_G_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	* Returns all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_NOME(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_NOME_First(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_NOME_Last(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByC_NOME_PrevAndNext(
		long funcionarioId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G_NOME(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_G_NOME_First(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_G_NOME_Last(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByC_G_NOME_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	* Returns all the funcionarios where companyId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_APELIDO(
		long companyId, java.lang.String apelido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and apelido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_APELIDO(
		long companyId, java.lang.String apelido, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and apelido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_APELIDO(
		long companyId, java.lang.String apelido, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_APELIDO_First(
		long companyId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_APELIDO_First(
		long companyId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_APELIDO_Last(
		long companyId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_APELIDO_Last(
		long companyId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and apelido LIKE &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByC_APELIDO_PrevAndNext(
		long funcionarioId, long companyId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where companyId = &#63; and apelido LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_APELIDO(long companyId, java.lang.String apelido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where companyId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param apelido the apelido
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_APELIDO(long companyId, java.lang.String apelido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G_APELIDO(
		long companyId, long groupId, java.lang.String apelido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G_APELIDO(
		long companyId, long groupId, java.lang.String apelido, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByC_G_APELIDO(
		long companyId, long groupId, java.lang.String apelido, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_G_APELIDO_First(
		long companyId, long groupId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_G_APELIDO_First(
		long companyId, long groupId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByC_G_APELIDO_Last(
		long companyId, long groupId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByC_G_APELIDO_Last(
		long companyId, long groupId, java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByC_G_APELIDO_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String apelido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where companyId = &#63; and groupId = &#63; and apelido LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_APELIDO(long companyId, long groupId,
		java.lang.String apelido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funcionarios where companyId = &#63; and groupId = &#63; and apelido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param apelido the apelido
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_APELIDO(long companyId, long groupId,
		java.lang.String apelido)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios where cpf = &#63;.
	*
	* @param cpf the cpf
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByCPF(
		java.lang.String cpf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where cpf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cpf the cpf
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByCPF(
		java.lang.String cpf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where cpf = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cpf the cpf
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByCPF(
		java.lang.String cpf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where cpf = &#63;.
	*
	* @param cpf the cpf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByCPF_First(
		java.lang.String cpf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where cpf = &#63;.
	*
	* @param cpf the cpf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByCPF_First(
		java.lang.String cpf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where cpf = &#63;.
	*
	* @param cpf the cpf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByCPF_Last(
		java.lang.String cpf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where cpf = &#63;.
	*
	* @param cpf the cpf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByCPF_Last(
		java.lang.String cpf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where cpf = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param cpf the cpf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByCPF_PrevAndNext(
		long funcionarioId, java.lang.String cpf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where cpf = &#63; from the database.
	*
	* @param cpf the cpf
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCPF(java.lang.String cpf)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	* Returns all the funcionarios where rg = &#63;.
	*
	* @param rg the rg
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByRG(
		java.lang.String rg)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where rg = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rg the rg
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByRG(
		java.lang.String rg, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where rg = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rg the rg
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByRG(
		java.lang.String rg, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where rg = &#63;.
	*
	* @param rg the rg
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByRG_First(
		java.lang.String rg,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where rg = &#63;.
	*
	* @param rg the rg
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByRG_First(
		java.lang.String rg,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where rg = &#63;.
	*
	* @param rg the rg
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByRG_Last(
		java.lang.String rg,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where rg = &#63;.
	*
	* @param rg the rg
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByRG_Last(
		java.lang.String rg,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionarios before and after the current funcionario in the ordered set where rg = &#63;.
	*
	* @param funcionarioId the primary key of the current funcionario
	* @param rg the rg
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByRG_PrevAndNext(
		long funcionarioId, java.lang.String rg,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funcionarios where rg = &#63; from the database.
	*
	* @param rg the rg
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRG(java.lang.String rg)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByDT_NASCIMENTO_Last(
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
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario[] findByDT_NASCIMENTO_PrevAndNext(
		long funcionarioId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
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
	* Caches the funcionario in the entity cache if it is enabled.
	*
	* @param funcionario the funcionario
	*/
	public void cacheResult(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario);

	/**
	* Caches the funcionarios in the entity cache if it is enabled.
	*
	* @param funcionarios the funcionarios
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> funcionarios);

	/**
	* Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	*
	* @param funcionarioId the primary key for the new funcionario
	* @return the new funcionario
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario create(
		long funcionarioId);

	/**
	* Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario that was removed
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario remove(
		long funcionarioId)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.appcomercial.servico.model.Funcionario updateImpl(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario with the primary key or throws a {@link br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException} if it could not be found.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario
	* @throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario findByPrimaryKey(
		long funcionarioId)
		throws br.com.prodevelopment.appcomercial.servico.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funcionario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario, or <code>null</code> if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchByPrimaryKey(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funcionarios.
	*
	* @return the funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funcionarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funcionarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> findAll(
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