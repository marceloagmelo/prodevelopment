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

package br.com.prodevelopment.funcionario.service.persistence;

import br.com.prodevelopment.funcionario.model.Cargo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the cargo service. This utility wraps {@link CargoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see CargoPersistence
 * @see CargoPersistenceImpl
 * @generated
 */
public class CargoUtil {
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
	public static void clearCache(Cargo cargo) {
		getPersistence().clearCache(cargo);
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
	public static List<Cargo> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cargo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cargo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Cargo update(Cargo cargo) throws SystemException {
		return getPersistence().update(cargo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Cargo update(Cargo cargo, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(cargo, serviceContext);
	}

	/**
	* Returns all the cargos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first cargo in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first cargo in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last cargo in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last cargo in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo[] findByUuid_PrevAndNext(
		long cargoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(cargoId, uuid, orderByComparator);
	}

	/**
	* Removes all the cargos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of cargos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the cargo where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchCargoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the cargo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the cargo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the cargo where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the cargo that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of cargos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the cargos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo[] findByUuid_C_PrevAndNext(
		long cargoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(cargoId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the cargos where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of cargos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the cargos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first cargo in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first cargo in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last cargo in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last cargo in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo[] findByCompany_PrevAndNext(
		long cargoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(cargoId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the cargos where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of cargos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the cargos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, groupId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo[] findByC_G_PrevAndNext(
		long cargoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(cargoId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G(companyId, groupId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G(companyId, groupId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G(companyId, groupId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo[] filterFindByC_G_PrevAndNext(
		long cargoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_PrevAndNext(cargoId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the cargos where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G(companyId, groupId);
	}

	/**
	* Returns the number of cargos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, groupId);
	}

	/**
	* Returns the number of cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_G(companyId, groupId);
	}

	/**
	* Returns all the cargos where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_NOME(companyId, nome);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_NOME(companyId, nome, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME(companyId, nome, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_First(companyId, nome, orderByComparator);
	}

	/**
	* Returns the first cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_NOME_First(companyId, nome, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_Last(companyId, nome, orderByComparator);
	}

	/**
	* Returns the last cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_NOME_Last(companyId, nome, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo[] findByC_NOME_PrevAndNext(
		long cargoId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_PrevAndNext(cargoId, companyId, nome,
			orderByComparator);
	}

	/**
	* Removes all the cargos where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_NOME(companyId, nome);
	}

	/**
	* Returns the number of cargos where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_NOME(companyId, nome);
	}

	/**
	* Returns all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_NOME(companyId, groupId, nome);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME(companyId, groupId, nome, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME(companyId, groupId, nome, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_First(companyId, groupId, nome,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_NOME_First(companyId, groupId, nome,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_Last(companyId, groupId, nome,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_NOME_Last(companyId, groupId, nome,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo[] findByC_G_NOME_PrevAndNext(
		long cargoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_PrevAndNext(cargoId, companyId, groupId,
			nome, orderByComparator);
	}

	/**
	* Returns all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G_NOME(companyId, groupId, nome);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME(companyId, groupId, nome, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME(companyId, groupId, nome, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Cargo[] filterFindByC_G_NOME_PrevAndNext(
		long cargoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME_PrevAndNext(cargoId, companyId,
			groupId, nome, orderByComparator);
	}

	/**
	* Removes all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns the number of cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns the number of cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching cargos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Caches the cargo in the entity cache if it is enabled.
	*
	* @param cargo the cargo
	*/
	public static void cacheResult(
		br.com.prodevelopment.funcionario.model.Cargo cargo) {
		getPersistence().cacheResult(cargo);
	}

	/**
	* Caches the cargos in the entity cache if it is enabled.
	*
	* @param cargos the cargos
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.funcionario.model.Cargo> cargos) {
		getPersistence().cacheResult(cargos);
	}

	/**
	* Creates a new cargo with the primary key. Does not add the cargo to the database.
	*
	* @param cargoId the primary key for the new cargo
	* @return the new cargo
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo create(
		long cargoId) {
		return getPersistence().create(cargoId);
	}

	/**
	* Removes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo that was removed
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo remove(
		long cargoId)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(cargoId);
	}

	public static br.com.prodevelopment.funcionario.model.Cargo updateImpl(
		br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cargo);
	}

	/**
	* Returns the cargo with the primary key or throws a {@link br.com.prodevelopment.funcionario.NoSuchCargoException} if it could not be found.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo
	* @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo findByPrimaryKey(
		long cargoId)
		throws br.com.prodevelopment.funcionario.NoSuchCargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(cargoId);
	}

	/**
	* Returns the cargo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo, or <code>null</code> if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchByPrimaryKey(
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cargoId);
	}

	/**
	* Returns all the cargos.
	*
	* @return the cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cargos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cargos.
	*
	* @return the number of cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CargoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CargoPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.funcionario.service.ClpSerializer.getServletContextName(),
					CargoPersistence.class.getName());

			ReferenceRegistry.registerReference(CargoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CargoPersistence persistence) {
	}

	private static CargoPersistence _persistence;
}