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

package br.com.prodevelopment.atividade.service.persistence;

import br.com.prodevelopment.atividade.model.Atividade;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the atividade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo
 * @see AtividadePersistenceImpl
 * @see AtividadeUtil
 * @generated
 */
public interface AtividadePersistence extends BasePersistence<Atividade> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AtividadeUtil} to access the atividade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the atividades where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set where uuid = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] findByUuid_PrevAndNext(
		long atividadeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividade where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.atividade.NoSuchAtividadeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividade where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividade where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the atividade where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the atividade that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] findByUuid_C_PrevAndNext(
		long atividadeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] findByCompany_PrevAndNext(
		long atividadeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] findByC_G_PrevAndNext(
		long atividadeId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] filterFindByC_G_PrevAndNext(
		long atividadeId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] findByC_NOME_PrevAndNext(
		long atividadeId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] findByC_G_NOME_PrevAndNext(
		long atividadeId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] filterFindByC_G_NOME_PrevAndNext(
		long atividadeId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
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
	* Returns the number of atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_DESCRICAO(
		long companyId, java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades where companyId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_DESCRICAO(
		long companyId, java.lang.String descricao, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_DESCRICAO(
		long companyId, java.lang.String descricao, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_DESCRICAO_First(
		long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_DESCRICAO_First(
		long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_DESCRICAO_Last(
		long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_DESCRICAO_Last(
		long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] findByC_DESCRICAO_PrevAndNext(
		long atividadeId, long companyId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades where companyId = &#63; and descricao LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_DESCRICAO(long companyId, java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades where companyId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param descricao the descricao
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_DESCRICAO(long companyId, java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @return the matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_G_DESCRICAO_First(
		long companyId, long groupId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_G_DESCRICAO_First(
		long companyId, long groupId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByC_G_DESCRICAO_Last(
		long companyId, long groupId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByC_G_DESCRICAO_Last(
		long companyId, long groupId, java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] findByC_G_DESCRICAO_PrevAndNext(
		long atividadeId, long companyId, long groupId,
		java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @return the matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> filterFindByC_G_DESCRICAO(
		long companyId, long groupId, java.lang.String descricao, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param atividadeId the primary key of the current atividade
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade[] filterFindByC_G_DESCRICAO_PrevAndNext(
		long atividadeId, long companyId, long groupId,
		java.lang.String descricao,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_DESCRICAO(long companyId, long groupId,
		java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @return the number of matching atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_DESCRICAO(long companyId, long groupId,
		java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param descricao the descricao
	* @return the number of matching atividades that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_G_DESCRICAO(long companyId, long groupId,
		java.lang.String descricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the atividade in the entity cache if it is enabled.
	*
	* @param atividade the atividade
	*/
	public void cacheResult(
		br.com.prodevelopment.atividade.model.Atividade atividade);

	/**
	* Caches the atividades in the entity cache if it is enabled.
	*
	* @param atividades the atividades
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.atividade.model.Atividade> atividades);

	/**
	* Creates a new atividade with the primary key. Does not add the atividade to the database.
	*
	* @param atividadeId the primary key for the new atividade
	* @return the new atividade
	*/
	public br.com.prodevelopment.atividade.model.Atividade create(
		long atividadeId);

	/**
	* Removes the atividade with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade that was removed
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade remove(
		long atividadeId)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.atividade.model.Atividade updateImpl(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividade with the primary key or throws a {@link br.com.prodevelopment.atividade.NoSuchAtividadeException} if it could not be found.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade
	* @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade findByPrimaryKey(
		long atividadeId)
		throws br.com.prodevelopment.atividade.NoSuchAtividadeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the atividade with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade, or <code>null</code> if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.atividade.model.Atividade fetchByPrimaryKey(
		long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the atividades.
	*
	* @return the atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the atividades.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the atividades.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of atividades
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the atividades from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of atividades.
	*
	* @return the number of atividades
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}