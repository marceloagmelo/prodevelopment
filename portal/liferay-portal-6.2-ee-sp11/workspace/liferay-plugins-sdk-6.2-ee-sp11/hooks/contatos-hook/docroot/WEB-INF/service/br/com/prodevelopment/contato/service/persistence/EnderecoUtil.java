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

import br.com.prodevelopment.contato.model.Endereco;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the endereco service. This utility wraps {@link EnderecoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EnderecoPersistence
 * @see EnderecoPersistenceImpl
 * @generated
 */
public class EnderecoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Endereco endereco) {
		getPersistence().clearCache(endereco);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Endereco> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Endereco> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Endereco> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Endereco update(Endereco endereco) throws SystemException {
		return getPersistence().update(endereco);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Endereco update(Endereco endereco,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(endereco, serviceContext);
	}

	/**
	* Returns all the enderecos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByUuid_PrevAndNext(
		long enderecoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(enderecoId, uuid, orderByComparator);
	}

	/**
	* Removes all the enderecos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of enderecos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the endereco where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the endereco where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the endereco where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the endereco where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the endereco that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of enderecos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the enderecos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByUuid_C_PrevAndNext(
		long enderecoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(enderecoId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of enderecos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the enderecos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByCompanyId_PrevAndNext(
		long enderecoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(enderecoId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_U(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_U(companyId, classNameId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_U(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_U(companyId, classNameId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_U(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_U(companyId, classNameId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_U_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_U_First(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_U_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_U_First(companyId, classNameId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_U_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_U_Last(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_U_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_U_Last(companyId, classNameId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_U_PrevAndNext(
		long enderecoId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_U_PrevAndNext(enderecoId, companyId, classNameId,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_U(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_U(companyId, classNameId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_U(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_U(companyId, classNameId);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_U(
		long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_U(companyId, groupId, classNameId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_U(
		long companyId, long groupId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_U(companyId, groupId, classNameId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_U(
		long companyId, long groupId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_U(companyId, groupId, classNameId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_U_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_U_First(companyId, groupId, classNameId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_U_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_U_First(companyId, groupId, classNameId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_U_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_U_Last(companyId, groupId, classNameId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_U_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_U_Last(companyId, groupId, classNameId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_G_U_PrevAndNext(
		long enderecoId, long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_U_PrevAndNext(enderecoId, companyId, groupId,
			classNameId, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_U(long companyId, long groupId,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_U(companyId, groupId, classNameId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_U(long companyId, long groupId,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_U(companyId, groupId, classNameId);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(companyId, classNameId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(companyId, classNameId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C(companyId, classNameId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_First(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_C_First(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_First(companyId, classNameId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_Last(companyId, classNameId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_C_Last(
		long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_Last(companyId, classNameId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_C_PrevAndNext(
		long enderecoId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_PrevAndNext(enderecoId, companyId, classNameId,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C(companyId, classNameId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C(companyId, classNameId);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_G(
		long companyId, long groupId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C_G(companyId, groupId, classNameId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_G(
		long companyId, long groupId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_G(companyId, groupId, classNameId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_G(
		long companyId, long groupId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_G(companyId, groupId, classNameId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_C_G_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_G_First(companyId, groupId, classNameId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_C_G_First(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_G_First(companyId, groupId, classNameId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_C_G_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_G_Last(companyId, groupId, classNameId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_C_G_Last(
		long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_G_Last(companyId, groupId, classNameId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_C_G_PrevAndNext(
		long enderecoId, long companyId, long groupId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_G_PrevAndNext(enderecoId, companyId, groupId,
			classNameId, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_G(long companyId, long groupId,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C_G(companyId, groupId, classNameId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_G(long companyId, long groupId,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C_G(companyId, groupId, classNameId);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C_C(companyId, classNameId, classPK);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C(companyId, classNameId, classPK, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C(companyId, classNameId, classPK, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_First(companyId, classNameId, classPK,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_First(companyId, classNameId, classPK,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_Last(companyId, classNameId, classPK,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_Last(companyId, classNameId, classPK,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_C_C_PrevAndNext(
		long enderecoId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_PrevAndNext(enderecoId, companyId, classNameId,
			classPK, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C_C(companyId, classNameId, classPK);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal,
			start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean principal,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P(companyId, classNameId, classPK, principal,
			start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_First(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_P_First(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_Last(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_C_C_P_Last(
		long companyId, long classNameId, long classPK, boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_P_Last(companyId, classNameId, classPK,
			principal, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_C_C_P_PrevAndNext(
		long enderecoId, long companyId, long classNameId, long classPK,
		boolean principal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_P_PrevAndNext(enderecoId, companyId,
			classNameId, classPK, principal, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param principal the principal
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByC_C_C_P(companyId, classNameId, classPK, principal);
	}

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
	public static int countByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_C_C_P(companyId, classNameId, classPK, principal);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CEP(
		long companyId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_CEP(companyId, cep);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CEP(
		long companyId, java.lang.String cep, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_CEP(companyId, cep, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CEP(
		long companyId, java.lang.String cep, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CEP(companyId, cep, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_CEP_First(
		long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CEP_First(companyId, cep, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_CEP_First(
		long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_CEP_First(companyId, cep, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_CEP_Last(
		long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CEP_Last(companyId, cep, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_CEP_Last(
		long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_CEP_Last(companyId, cep, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_CEP_PrevAndNext(
		long enderecoId, long companyId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CEP_PrevAndNext(enderecoId, companyId, cep,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and cep = &#63; from the database.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_CEP(long companyId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_CEP(companyId, cep);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param cep the cep
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_CEP(long companyId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_CEP(companyId, cep);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CEP(
		long companyId, long groupId, java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_CEP(companyId, groupId, cep);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CEP(
		long companyId, long groupId, java.lang.String cep, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CEP(companyId, groupId, cep, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CEP(
		long companyId, long groupId, java.lang.String cep, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CEP(companyId, groupId, cep, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_CEP_First(
		long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CEP_First(companyId, groupId, cep,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_CEP_First(
		long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_CEP_First(companyId, groupId, cep,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_CEP_Last(
		long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CEP_Last(companyId, groupId, cep,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_CEP_Last(
		long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_CEP_Last(companyId, groupId, cep,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_G_CEP_PrevAndNext(
		long enderecoId, long companyId, long groupId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CEP_PrevAndNext(enderecoId, companyId, groupId,
			cep, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_CEP(long companyId, long groupId,
		java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_CEP(companyId, groupId, cep);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cep the cep
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_CEP(long companyId, long groupId,
		java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_CEP(companyId, groupId, cep);
	}

	/**
	* Returns all the enderecos where cep = &#63;.
	*
	* @param cep the cep
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCEP(
		java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCEP(cep);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCEP(
		java.lang.String cep, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCEP(cep, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCEP(
		java.lang.String cep, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCEP(cep, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where cep = &#63;.
	*
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByCEP_First(
		java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCEP_First(cep, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where cep = &#63;.
	*
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByCEP_First(
		java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCEP_First(cep, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where cep = &#63;.
	*
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByCEP_Last(
		java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCEP_Last(cep, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where cep = &#63;.
	*
	* @param cep the cep
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByCEP_Last(
		java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCEP_Last(cep, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByCEP_PrevAndNext(
		long enderecoId, java.lang.String cep,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCEP_PrevAndNext(enderecoId, cep, orderByComparator);
	}

	/**
	* Removes all the enderecos where cep = &#63; from the database.
	*
	* @param cep the cep
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCEP(java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCEP(cep);
	}

	/**
	* Returns the number of enderecos where cep = &#63;.
	*
	* @param cep the cep
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCEP(java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCEP(cep);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_BAIRRO(
		long companyId, java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_BAIRRO(companyId, bairro);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_BAIRRO(
		long companyId, java.lang.String bairro, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_BAIRRO(companyId, bairro, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_BAIRRO(
		long companyId, java.lang.String bairro, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_BAIRRO(companyId, bairro, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_BAIRRO_First(
		long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_BAIRRO_First(companyId, bairro, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_BAIRRO_First(
		long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_BAIRRO_First(companyId, bairro, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_BAIRRO_Last(
		long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_BAIRRO_Last(companyId, bairro, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_BAIRRO_Last(
		long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_BAIRRO_Last(companyId, bairro, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_BAIRRO_PrevAndNext(
		long enderecoId, long companyId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_BAIRRO_PrevAndNext(enderecoId, companyId, bairro,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and bairro LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_BAIRRO(long companyId, java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_BAIRRO(companyId, bairro);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param bairro the bairro
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_BAIRRO(long companyId, java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_BAIRRO(companyId, bairro);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_BAIRRO(
		long companyId, long groupId, java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_BAIRRO(companyId, groupId, bairro);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_BAIRRO(
		long companyId, long groupId, java.lang.String bairro, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_BAIRRO(companyId, groupId, bairro, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_BAIRRO(
		long companyId, long groupId, java.lang.String bairro, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_BAIRRO(companyId, groupId, bairro, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_BAIRRO_First(
		long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_BAIRRO_First(companyId, groupId, bairro,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_BAIRRO_First(
		long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_BAIRRO_First(companyId, groupId, bairro,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_BAIRRO_Last(
		long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_BAIRRO_Last(companyId, groupId, bairro,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_BAIRRO_Last(
		long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_BAIRRO_Last(companyId, groupId, bairro,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_G_BAIRRO_PrevAndNext(
		long enderecoId, long companyId, long groupId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_BAIRRO_PrevAndNext(enderecoId, companyId,
			groupId, bairro, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_BAIRRO(long companyId, long groupId,
		java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_BAIRRO(companyId, groupId, bairro);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param bairro the bairro
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_BAIRRO(long companyId, long groupId,
		java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_BAIRRO(companyId, groupId, bairro);
	}

	/**
	* Returns all the enderecos where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByBAIRRO(
		java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBAIRRO(bairro);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByBAIRRO(
		java.lang.String bairro, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBAIRRO(bairro, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByBAIRRO(
		java.lang.String bairro, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBAIRRO(bairro, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByBAIRRO_First(
		java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBAIRRO_First(bairro, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByBAIRRO_First(
		java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBAIRRO_First(bairro, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByBAIRRO_Last(
		java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBAIRRO_Last(bairro, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByBAIRRO_Last(
		java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBAIRRO_Last(bairro, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByBAIRRO_PrevAndNext(
		long enderecoId, java.lang.String bairro,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBAIRRO_PrevAndNext(enderecoId, bairro,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where bairro LIKE &#63; from the database.
	*
	* @param bairro the bairro
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBAIRRO(java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBAIRRO(bairro);
	}

	/**
	* Returns the number of enderecos where bairro LIKE &#63;.
	*
	* @param bairro the bairro
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBAIRRO(java.lang.String bairro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBAIRRO(bairro);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CIDADE(
		long companyId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_CIDADE(companyId, cidadeId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CIDADE(
		long companyId, long cidadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_CIDADE(companyId, cidadeId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_CIDADE(
		long companyId, long cidadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CIDADE(companyId, cidadeId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_CIDADE_First(
		long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CIDADE_First(companyId, cidadeId, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_CIDADE_First(
		long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_CIDADE_First(companyId, cidadeId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_CIDADE_Last(
		long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CIDADE_Last(companyId, cidadeId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_CIDADE_Last(
		long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_CIDADE_Last(companyId, cidadeId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_CIDADE_PrevAndNext(
		long enderecoId, long companyId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CIDADE_PrevAndNext(enderecoId, companyId, cidadeId,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and cidadeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_CIDADE(long companyId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_CIDADE(companyId, cidadeId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param cidadeId the cidade ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_CIDADE(long companyId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_CIDADE(companyId, cidadeId);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CIDADE(
		long companyId, long groupId, long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_CIDADE(companyId, groupId, cidadeId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CIDADE(
		long companyId, long groupId, long cidadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CIDADE(companyId, groupId, cidadeId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_CIDADE(
		long companyId, long groupId, long cidadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CIDADE(companyId, groupId, cidadeId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_CIDADE_First(
		long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CIDADE_First(companyId, groupId, cidadeId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_CIDADE_First(
		long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_CIDADE_First(companyId, groupId, cidadeId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_CIDADE_Last(
		long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CIDADE_Last(companyId, groupId, cidadeId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_CIDADE_Last(
		long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_CIDADE_Last(companyId, groupId, cidadeId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_G_CIDADE_PrevAndNext(
		long enderecoId, long companyId, long groupId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CIDADE_PrevAndNext(enderecoId, companyId,
			groupId, cidadeId, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_CIDADE(long companyId, long groupId,
		long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_CIDADE(companyId, groupId, cidadeId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cidadeId the cidade ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_CIDADE(long companyId, long groupId,
		long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_CIDADE(companyId, groupId, cidadeId);
	}

	/**
	* Returns all the enderecos where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCIDADE(
		long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCIDADE(cidadeId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCIDADE(
		long cidadeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCIDADE(cidadeId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByCIDADE(
		long cidadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCIDADE(cidadeId, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByCIDADE_First(
		long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCIDADE_First(cidadeId, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByCIDADE_First(
		long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCIDADE_First(cidadeId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByCIDADE_Last(
		long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCIDADE_Last(cidadeId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByCIDADE_Last(
		long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCIDADE_Last(cidadeId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByCIDADE_PrevAndNext(
		long enderecoId, long cidadeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCIDADE_PrevAndNext(enderecoId, cidadeId,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where cidadeId = &#63; from the database.
	*
	* @param cidadeId the cidade ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCIDADE(long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCIDADE(cidadeId);
	}

	/**
	* Returns the number of enderecos where cidadeId = &#63;.
	*
	* @param cidadeId the cidade ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCIDADE(long cidadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCIDADE(cidadeId);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_UF(
		long companyId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_UF(companyId, uf);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_UF(
		long companyId, java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_UF(companyId, uf, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_UF(
		long companyId, java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_UF(companyId, uf, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_UF_First(
		long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_UF_First(companyId, uf, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_UF_First(
		long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_UF_First(companyId, uf, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_UF_Last(
		long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_UF_Last(companyId, uf, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_UF_Last(
		long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_UF_Last(companyId, uf, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_UF_PrevAndNext(
		long enderecoId, long companyId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_UF_PrevAndNext(enderecoId, companyId, uf,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and uf = &#63; from the database.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_UF(long companyId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_UF(companyId, uf);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param uf the uf
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_UF(long companyId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_UF(companyId, uf);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_UF(
		long companyId, long groupId, java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_UF(companyId, groupId, uf);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_UF(
		long companyId, long groupId, java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_UF(companyId, groupId, uf, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_UF(
		long companyId, long groupId, java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_UF(companyId, groupId, uf, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_UF_First(
		long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_UF_First(companyId, groupId, uf, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_UF_First(
		long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_UF_First(companyId, groupId, uf,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_UF_Last(
		long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_UF_Last(companyId, groupId, uf, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_UF_Last(
		long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_UF_Last(companyId, groupId, uf, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_G_UF_PrevAndNext(
		long enderecoId, long companyId, long groupId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_UF_PrevAndNext(enderecoId, companyId, groupId,
			uf, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_UF(long companyId, long groupId,
		java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_UF(companyId, groupId, uf);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param uf the uf
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_UF(long companyId, long groupId,
		java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_UF(companyId, groupId, uf);
	}

	/**
	* Returns all the enderecos where uf = &#63;.
	*
	* @param uf the uf
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUF(
		java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUF(uf);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUF(
		java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUF(uf, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByUF(
		java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUF(uf, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByUF_First(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUF_First(uf, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByUF_First(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUF_First(uf, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByUF_Last(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUF_Last(uf, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where uf = &#63;.
	*
	* @param uf the uf
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByUF_Last(
		java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUF_Last(uf, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByUF_PrevAndNext(
		long enderecoId, java.lang.String uf,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUF_PrevAndNext(enderecoId, uf, orderByComparator);
	}

	/**
	* Removes all the enderecos where uf = &#63; from the database.
	*
	* @param uf the uf
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUF(java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUF(uf);
	}

	/**
	* Returns the number of enderecos where uf = &#63;.
	*
	* @param uf the uf
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUF(java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUF(uf);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_PAIS(
		long companyId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_PAIS(companyId, paisId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_PAIS(
		long companyId, long paisId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_PAIS(companyId, paisId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_PAIS(
		long companyId, long paisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_PAIS(companyId, paisId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_PAIS_First(
		long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_PAIS_First(companyId, paisId, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_PAIS_First(
		long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_PAIS_First(companyId, paisId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_PAIS_Last(
		long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_PAIS_Last(companyId, paisId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_PAIS_Last(
		long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_PAIS_Last(companyId, paisId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_PAIS_PrevAndNext(
		long enderecoId, long companyId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_PAIS_PrevAndNext(enderecoId, companyId, paisId,
			orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and paisId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_PAIS(long companyId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_PAIS(companyId, paisId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param paisId the pais ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_PAIS(long companyId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_PAIS(companyId, paisId);
	}

	/**
	* Returns all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_PAIS(
		long companyId, long groupId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_PAIS(companyId, groupId, paisId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_PAIS(
		long companyId, long groupId, long paisId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PAIS(companyId, groupId, paisId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByC_G_PAIS(
		long companyId, long groupId, long paisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PAIS(companyId, groupId, paisId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_PAIS_First(
		long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PAIS_First(companyId, groupId, paisId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_PAIS_First(
		long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_PAIS_First(companyId, groupId, paisId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco findByC_G_PAIS_Last(
		long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PAIS_Last(companyId, groupId, paisId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco fetchByC_G_PAIS_Last(
		long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_PAIS_Last(companyId, groupId, paisId,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByC_G_PAIS_PrevAndNext(
		long enderecoId, long companyId, long groupId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PAIS_PrevAndNext(enderecoId, companyId, groupId,
			paisId, orderByComparator);
	}

	/**
	* Removes all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_PAIS(long companyId, long groupId,
		long paisId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_PAIS(companyId, groupId, paisId);
	}

	/**
	* Returns the number of enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param paisId the pais ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_PAIS(long companyId, long groupId, long paisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_PAIS(companyId, groupId, paisId);
	}

	/**
	* Returns all the enderecos where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @return the matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByPAIS(
		long paisId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPAIS(paisId);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByPAIS(
		long paisId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPAIS(paisId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findByPAIS(
		long paisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPAIS(paisId, start, end, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByPAIS_First(
		long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPAIS_First(paisId, orderByComparator);
	}

	/**
	* Returns the first endereco in the ordered set where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByPAIS_First(
		long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPAIS_First(paisId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByPAIS_Last(
		long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPAIS_Last(paisId, orderByComparator);
	}

	/**
	* Returns the last endereco in the ordered set where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByPAIS_Last(
		long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPAIS_Last(paisId, orderByComparator);
	}

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
	public static br.com.prodevelopment.contato.model.Endereco[] findByPAIS_PrevAndNext(
		long enderecoId, long paisId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPAIS_PrevAndNext(enderecoId, paisId, orderByComparator);
	}

	/**
	* Removes all the enderecos where paisId = &#63; from the database.
	*
	* @param paisId the pais ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPAIS(long paisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPAIS(paisId);
	}

	/**
	* Returns the number of enderecos where paisId = &#63;.
	*
	* @param paisId the pais ID
	* @return the number of matching enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPAIS(long paisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPAIS(paisId);
	}

	/**
	* Caches the endereco in the entity cache if it is enabled.
	*
	* @param endereco the endereco
	*/
	public static void cacheResult(
		br.com.prodevelopment.contato.model.Endereco endereco) {
		getPersistence().cacheResult(endereco);
	}

	/**
	* Caches the enderecos in the entity cache if it is enabled.
	*
	* @param enderecos the enderecos
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.contato.model.Endereco> enderecos) {
		getPersistence().cacheResult(enderecos);
	}

	/**
	* Creates a new endereco with the primary key. Does not add the endereco to the database.
	*
	* @param enderecoId the primary key for the new endereco
	* @return the new endereco
	*/
	public static br.com.prodevelopment.contato.model.Endereco create(
		long enderecoId) {
		return getPersistence().create(enderecoId);
	}

	/**
	* Removes the endereco with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco that was removed
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco remove(
		long enderecoId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(enderecoId);
	}

	public static br.com.prodevelopment.contato.model.Endereco updateImpl(
		br.com.prodevelopment.contato.model.Endereco endereco)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(endereco);
	}

	/**
	* Returns the endereco with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoException} if it could not be found.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco
	* @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco findByPrimaryKey(
		long enderecoId)
		throws br.com.prodevelopment.contato.NoSuchEnderecoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(enderecoId);
	}

	/**
	* Returns the endereco with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco, or <code>null</code> if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Endereco fetchByPrimaryKey(
		long enderecoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(enderecoId);
	}

	/**
	* Returns all the enderecos.
	*
	* @return the enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.contato.model.Endereco> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the enderecos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of enderecos.
	*
	* @return the number of enderecos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EnderecoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EnderecoPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.contato.service.ClpSerializer.getServletContextName(),
					EnderecoPersistence.class.getName());

			ReferenceRegistry.registerReference(EnderecoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EnderecoPersistence persistence) {
	}

	private static EnderecoPersistence _persistence;
}