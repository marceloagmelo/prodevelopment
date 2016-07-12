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

import br.com.prodevelopment.contato.model.Contato;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see ContatoPersistenceImpl
 * @see ContatoUtil
 * @generated
 */
public interface ContatoPersistence extends BasePersistence<Contato> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContatoUtil} to access the contato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the contatos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByCompanyId_PrevAndNext(
		long contatoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_G_PrevAndNext(
		long contatoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where accountId = &#63;.
	*
	* @param accountId the account ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByAccountId(
		long accountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where accountId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param accountId the account ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByAccountId(
		long accountId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where accountId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param accountId the account ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByAccountId(
		long accountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where accountId = &#63;.
	*
	* @param accountId the account ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByAccountId_First(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where accountId = &#63;.
	*
	* @param accountId the account ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByAccountId_First(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where accountId = &#63;.
	*
	* @param accountId the account ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByAccountId_Last(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where accountId = &#63;.
	*
	* @param accountId the account ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByAccountId_Last(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where accountId = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param accountId the account ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByAccountId_PrevAndNext(
		long contatoId, long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where accountId = &#63; from the database.
	*
	* @param accountId the account ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAccountId(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where accountId = &#63;.
	*
	* @param accountId the account ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByAccountId(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contato where classNameId = &#63; and classPK = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchContatoException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByContato(
		long classNameId, long classPK)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contato where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByContato(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contato where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByContato(
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the contato where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the contato that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato removeByContato(
		long classNameId, long classPK)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByContato(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_CARGO(
		long companyId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and cargoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_CARGO(
		long companyId, long cargoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and cargoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_CARGO(
		long companyId, long cargoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_CARGO_First(
		long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_CARGO_First(
		long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_CARGO_Last(
		long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_CARGO_Last(
		long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_CARGO_PrevAndNext(
		long contatoId, long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and cargoId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_CARGO(long companyId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_CARGO(long companyId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_CARGO(
		long companyId, long groupId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_CARGO(
		long companyId, long groupId, long cargoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_CARGO(
		long companyId, long groupId, long cargoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_CARGO_First(
		long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_CARGO_First(
		long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_CARGO_Last(
		long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_CARGO_Last(
		long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_G_CARGO_PrevAndNext(
		long contatoId, long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_CARGO(long companyId, long groupId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_CARGO(long companyId, long groupId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByCARGO(
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where cargoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cargoId the cargo ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByCARGO(
		long cargoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where cargoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cargoId the cargo ID
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByCARGO(
		long cargoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByCARGO_First(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByCARGO_First(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByCARGO_Last(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByCARGO_Last(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where cargoId = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByCARGO_PrevAndNext(
		long contatoId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where cargoId = &#63; from the database.
	*
	* @param cargoId the cargo ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCARGO(long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCARGO(long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_NOME_PrevAndNext(
		long contatoId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_G_NOME_PrevAndNext(
		long contatoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
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
	* Returns the number of contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where nome LIKE &#63;.
	*
	* @param nome the nome
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByNOME(
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByNOME(
		java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nome the nome
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByNOME(
		java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where nome LIKE &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByNOME_First(
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where nome LIKE &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByNOME_First(
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where nome LIKE &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByNOME_Last(
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where nome LIKE &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByNOME_Last(
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where nome LIKE &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByNOME_PrevAndNext(
		long contatoId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where nome LIKE &#63; from the database.
	*
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNOME(java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where nome LIKE &#63;.
	*
	* @param nome the nome
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByNOME(java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_DTN(
		long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_DTN(
		long companyId, java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_DTN(
		long companyId, java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_DTN_First(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_DTN_First(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_DTN_Last(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_DTN_Last(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_DTN_PrevAndNext(
		long contatoId, long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and dataNascimento = &#63; from the database.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_DTN(long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_DTN(long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_DTN(
		long companyId, long groupId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_DTN(
		long companyId, long groupId, java.util.Date dataNascimento, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_DTN(
		long companyId, long groupId, java.util.Date dataNascimento, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_DTN_First(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_DTN_First(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_DTN_Last(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_DTN_Last(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_G_DTN_PrevAndNext(
		long contatoId, long companyId, long groupId,
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_DTN(long companyId, long groupId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_DTN(long companyId, long groupId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByDTN(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByDTN(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByDTN(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByDTN_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByDTN_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByDTN_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByDTN_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where dataNascimento = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByDTN_PrevAndNext(
		long contatoId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where dataNascimento = &#63; from the database.
	*
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDTN(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByDTN(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_EMAIL(
		long companyId, java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and endEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_EMAIL(
		long companyId, java.lang.String endEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and endEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_EMAIL(
		long companyId, java.lang.String endEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_EMAIL_First(
		long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_EMAIL_First(
		long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_EMAIL_Last(
		long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_EMAIL_Last(
		long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_EMAIL_PrevAndNext(
		long contatoId, long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and endEmail = &#63; from the database.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_EMAIL(long companyId, java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_EMAIL(long companyId, java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_EMAIL(
		long companyId, long groupId, java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_EMAIL(
		long companyId, long groupId, java.lang.String endEmail, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_EMAIL(
		long companyId, long groupId, java.lang.String endEmail, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_EMAIL_First(
		long companyId, long groupId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_EMAIL_First(
		long companyId, long groupId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_EMAIL_Last(
		long companyId, long groupId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_EMAIL_Last(
		long companyId, long groupId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_G_EMAIL_PrevAndNext(
		long contatoId, long companyId, long groupId,
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_EMAIL(long companyId, long groupId,
		java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_EMAIL(long companyId, long groupId,
		java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByEMAIL(
		java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where endEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endEmail the end email
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByEMAIL(
		java.lang.String endEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where endEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endEmail the end email
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByEMAIL(
		java.lang.String endEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByEMAIL_First(
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByEMAIL_First(
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByEMAIL_Last(
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByEMAIL_Last(
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where endEmail = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByEMAIL_PrevAndNext(
		long contatoId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where endEmail = &#63; from the database.
	*
	* @param endEmail the end email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEMAIL(java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByEMAIL(java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_SEXO(
		long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_SEXO(
		long companyId, java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_SEXO(
		long companyId, java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_SEXO_First(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_SEXO_First(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_SEXO_Last(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_SEXO_Last(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_SEXO_PrevAndNext(
		long contatoId, long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and dataNascimento = &#63; from the database.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_SEXO(long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_SEXO(long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_SEXO(
		long companyId, long groupId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_SEXO(
		long companyId, long groupId, java.util.Date dataNascimento, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_SEXO(
		long companyId, long groupId, java.util.Date dataNascimento, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_SEXO_First(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_SEXO_First(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByC_G_SEXO_Last(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByC_G_SEXO_Last(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findByC_G_SEXO_PrevAndNext(
		long contatoId, long companyId, long groupId,
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_SEXO(long companyId, long groupId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_SEXO(long companyId, long groupId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findBySEXO(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findBySEXO(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos where dataNascimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataNascimento the data nascimento
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findBySEXO(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findBySEXO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchBySEXO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findBySEXO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchBySEXO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contatos before and after the current contato in the ordered set where dataNascimento = &#63;.
	*
	* @param contatoId the primary key of the current contato
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato[] findBySEXO_PrevAndNext(
		long contatoId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos where dataNascimento = &#63; from the database.
	*
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySEXO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countBySEXO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the contato in the entity cache if it is enabled.
	*
	* @param contato the contato
	*/
	public void cacheResult(br.com.prodevelopment.contato.model.Contato contato);

	/**
	* Caches the contatos in the entity cache if it is enabled.
	*
	* @param contatos the contatos
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.contato.model.Contato> contatos);

	/**
	* Creates a new contato with the primary key. Does not add the contato to the database.
	*
	* @param contatoId the primary key for the new contato
	* @return the new contato
	*/
	public br.com.prodevelopment.contato.model.Contato create(long contatoId);

	/**
	* Removes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contatoId the primary key of the contato
	* @return the contato that was removed
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato remove(long contatoId)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.contato.model.Contato updateImpl(
		br.com.prodevelopment.contato.model.Contato contato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contato with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchContatoException} if it could not be found.
	*
	* @param contatoId the primary key of the contato
	* @return the contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato findByPrimaryKey(
		long contatoId)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contatoId the primary key of the contato
	* @return the contato, or <code>null</code> if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Contato fetchByPrimaryKey(
		long contatoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contatos.
	*
	* @return the contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Contato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contatos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contatos.
	*
	* @return the number of contatos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}