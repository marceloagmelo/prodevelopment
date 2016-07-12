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

import br.com.prodevelopment.contato.model.Telefone;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the telefone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TelefonePersistenceImpl
 * @see TelefoneUtil
 * @generated
 */
public interface TelefonePersistence extends BasePersistence<Telefone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TelefoneUtil} to access the telefone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the telefones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the telefones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the telefones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefones before and after the current telefone in the ordered set where uuid = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone[] findByUuid_PrevAndNext(
		long telefoneId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefones where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefone where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchTelefoneException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the telefone where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the telefone that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefones where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the telefones where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the telefones where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the telefones where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefones before and after the current telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone[] findByUuid_C_PrevAndNext(
		long telefoneId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefones where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefones where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the telefones where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the telefones where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the telefones where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefones before and after the current telefone in the ordered set where companyId = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone[] findByCompanyId_PrevAndNext(
		long telefoneId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefones where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefones where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the telefones where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the telefones where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone[] findByC_C_PrevAndNext(
		long telefoneId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefones where companyId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefones where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone[] findByC_C_C_PrevAndNext(
		long telefoneId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param telefoneId the primary key of the current telefone
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone[] findByC_C_C_P_PrevAndNext(
		long telefoneId, long companyId, long classNameId, long classPK,
		boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
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
	* Returns the number of telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the number of matching telefones
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the telefone in the entity cache if it is enabled.
	*
	* @param telefone the telefone
	*/
	public void cacheResult(
		br.com.prodevelopment.contato.model.Telefone telefone);

	/**
	* Caches the telefones in the entity cache if it is enabled.
	*
	* @param telefones the telefones
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.contato.model.Telefone> telefones);

	/**
	* Creates a new telefone with the primary key. Does not add the telefone to the database.
	*
	* @param telefoneId the primary key for the new telefone
	* @return the new telefone
	*/
	public br.com.prodevelopment.contato.model.Telefone create(long telefoneId);

	/**
	* Removes the telefone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone that was removed
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone remove(long telefoneId)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.contato.model.Telefone updateImpl(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefone with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchTelefoneException} if it could not be found.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone
	* @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone findByPrimaryKey(
		long telefoneId)
		throws br.com.prodevelopment.contato.NoSuchTelefoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone, or <code>null</code> if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.Telefone fetchByPrimaryKey(
		long telefoneId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the telefones.
	*
	* @return the telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the telefones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the telefones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of telefones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefones.
	*
	* @return the number of telefones
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}