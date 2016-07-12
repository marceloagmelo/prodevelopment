/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.prodevelopment.contato.service.persistence;

import br.com.prodevelopment.contato.model.EnderecoEmail;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the endereco email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EnderecoEmailPersistenceImpl
 * @see EnderecoEmailUtil
 * @generated
 */
public interface EnderecoEmailPersistence extends BasePersistence<EnderecoEmail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnderecoEmailUtil} to access the endereco email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the endereco emails where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the endereco emails where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the endereco emails where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where uuid = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail[] findByUuid_PrevAndNext(
		long enderecoEmailId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the endereco emails where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of endereco emails where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco email where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoEmailException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco email where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco email where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the endereco email where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the endereco email that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of endereco emails where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the endereco emails where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the endereco emails where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the endereco emails where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail[] findByUuid_C_PrevAndNext(
		long enderecoEmailId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the endereco emails where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of endereco emails where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the endereco emails where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the endereco emails where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the endereco emails where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail[] findByCompanyId_PrevAndNext(
		long enderecoEmailId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the endereco emails where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of endereco emails where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the endereco emails where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail[] findByC_C_PrevAndNext(
		long enderecoEmailId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the endereco emails where companyId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of endereco emails where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail[] findByC_C_C_PrevAndNext(
		long enderecoEmailId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param enderecoEmailId the primary key of the current endereco email
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail[] findByC_C_C_P_PrevAndNext(
		long enderecoEmailId, long companyId, long classNameId, long classPK,
		boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
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
	* Returns the number of endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @return the number of matching endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the endereco email in the entity cache if it is enabled.
	*
	* @param enderecoEmail the endereco email
	*/
	public void cacheResult(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail);

	/**
	* Caches the endereco emails in the entity cache if it is enabled.
	*
	* @param enderecoEmails the endereco emails
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> enderecoEmails);

	/**
	* Creates a new endereco email with the primary key. Does not add the endereco email to the database.
	*
	* @param enderecoEmailId the primary key for the new endereco email
	* @return the new endereco email
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail create(
		long enderecoEmailId);

	/**
	* Removes the endereco email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoEmailId the primary key of the endereco email
	* @return the endereco email that was removed
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail remove(
		long enderecoEmailId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.contato.model.EnderecoEmail updateImpl(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco email with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoEmailException} if it could not be found.
	*
	* @param enderecoEmailId the primary key of the endereco email
	* @return the endereco email
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail findByPrimaryKey(
		long enderecoEmailId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the endereco email with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enderecoEmailId the primary key of the endereco email
	* @return the endereco email, or <code>null</code> if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.contato.model.EnderecoEmail fetchByPrimaryKey(
		long enderecoEmailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the endereco emails.
	*
	* @return the endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the endereco emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the endereco emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the endereco emails from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of endereco emails.
	*
	* @return the number of endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}