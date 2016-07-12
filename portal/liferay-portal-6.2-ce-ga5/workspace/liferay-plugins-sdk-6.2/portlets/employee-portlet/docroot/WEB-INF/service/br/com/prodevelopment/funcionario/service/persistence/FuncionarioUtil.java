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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the funcionario service. This utility wraps {@link FuncionarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see FuncionarioPersistence
 * @see FuncionarioPersistenceImpl
 * @generated
 */
public class FuncionarioUtil {
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
	public static void clearCache(Funcionario funcionario) {
		getPersistence().clearCache(funcionario);
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
	public static List<Funcionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Funcionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Funcionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Funcionario update(Funcionario funcionario)
		throws SystemException {
		return getPersistence().update(funcionario);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Funcionario update(Funcionario funcionario,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(funcionario, serviceContext);
	}

	/**
	* Returns all the funcionarios where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByUuid_PrevAndNext(
		long funcionarioId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(funcionarioId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the funcionarios where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of funcionarios where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the funcionario where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the funcionario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the funcionario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the funcionario where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of funcionarios where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the funcionarios where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByUuid_C_PrevAndNext(
		long funcionarioId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(funcionarioId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the funcionarios where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of funcionarios where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the funcionarios where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByCompany_PrevAndNext(
		long funcionarioId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(funcionarioId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the funcionarios where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of funcionarios where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the funcionarios where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, groupId, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, groupId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByC_G_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(funcionarioId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G(companyId, groupId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G(companyId, groupId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G(companyId, groupId, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] filterFindByC_G_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_PrevAndNext(funcionarioId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the funcionarios where companyId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of funcionarios where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, groupId);
	}

	/**
	* Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_G(companyId, groupId);
	}

	/**
	* Returns all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_NOME(companyId, nome);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_NOME(companyId, nome, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME(companyId, nome, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_First(companyId, nome, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_NOME_First(companyId, nome, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_Last(companyId, nome, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_NOME_Last(companyId, nome, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByC_NOME_PrevAndNext(
		long funcionarioId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_PrevAndNext(funcionarioId, companyId, nome,
			orderByComparator);
	}

	/**
	* Removes all the funcionarios where companyId = &#63; and nome LIKE &#63; from the database.
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
	* Returns the number of funcionarios where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_NOME(companyId, nome);
	}

	/**
	* Returns all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_NOME(companyId, groupId, nome);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME(companyId, groupId, nome, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME(companyId, groupId, nome, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_First(companyId, groupId, nome,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_NOME_First(companyId, groupId, nome,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_Last(companyId, groupId, nome,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_NOME_Last(companyId, groupId, nome,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByC_G_NOME_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_PrevAndNext(funcionarioId, companyId,
			groupId, nome, orderByComparator);
	}

	/**
	* Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_G_NOME(companyId, groupId, nome);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME(companyId, groupId, nome, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME(companyId, groupId, nome, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] filterFindByC_G_NOME_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_NOME_PrevAndNext(funcionarioId, companyId,
			groupId, nome, orderByComparator);
	}

	/**
	* Removes all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
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
	* Returns the number of funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the number of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_N_REDUZIDO(
		long companyId, java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_N_REDUZIDO(companyId, nomeReduzido);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_N_REDUZIDO(
		long companyId, java.lang.String nomeReduzido, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N_REDUZIDO(companyId, nomeReduzido, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_N_REDUZIDO(
		long companyId, java.lang.String nomeReduzido, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N_REDUZIDO(companyId, nomeReduzido, start, end,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_N_REDUZIDO_First(
		long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N_REDUZIDO_First(companyId, nomeReduzido,
			orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_N_REDUZIDO_First(
		long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_N_REDUZIDO_First(companyId, nomeReduzido,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_N_REDUZIDO_Last(
		long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N_REDUZIDO_Last(companyId, nomeReduzido,
			orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_N_REDUZIDO_Last(
		long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_N_REDUZIDO_Last(companyId, nomeReduzido,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByC_N_REDUZIDO_PrevAndNext(
		long funcionarioId, long companyId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N_REDUZIDO_PrevAndNext(funcionarioId, companyId,
			nomeReduzido, orderByComparator);
	}

	/**
	* Removes all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_N_REDUZIDO(long companyId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_N_REDUZIDO(companyId, nomeReduzido);
	}

	/**
	* Returns the number of funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nomeReduzido the nome reduzido
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_N_REDUZIDO(long companyId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_N_REDUZIDO(companyId, nomeReduzido);
	}

	/**
	* Returns all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido,
			start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido,
			start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_G_N_REDUZIDO_First(
		long companyId, long groupId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_N_REDUZIDO_First(companyId, groupId,
			nomeReduzido, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_N_REDUZIDO_First(
		long companyId, long groupId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_N_REDUZIDO_First(companyId, groupId,
			nomeReduzido, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario findByC_G_N_REDUZIDO_Last(
		long companyId, long groupId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_N_REDUZIDO_Last(companyId, groupId, nomeReduzido,
			orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByC_G_N_REDUZIDO_Last(
		long companyId, long groupId, java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_N_REDUZIDO_Last(companyId, groupId,
			nomeReduzido, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByC_G_N_REDUZIDO_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_N_REDUZIDO_PrevAndNext(funcionarioId, companyId,
			groupId, nomeReduzido, orderByComparator);
	}

	/**
	* Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @return the matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_N_REDUZIDO(companyId, groupId,
			nomeReduzido, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> filterFindByC_G_N_REDUZIDO(
		long companyId, long groupId, java.lang.String nomeReduzido, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_N_REDUZIDO(companyId, groupId,
			nomeReduzido, start, end, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] filterFindByC_G_N_REDUZIDO_PrevAndNext(
		long funcionarioId, long companyId, long groupId,
		java.lang.String nomeReduzido,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_G_N_REDUZIDO_PrevAndNext(funcionarioId,
			companyId, groupId, nomeReduzido, orderByComparator);
	}

	/**
	* Removes all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_N_REDUZIDO(long companyId, long groupId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido);
	}

	/**
	* Returns the number of funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_N_REDUZIDO(long companyId, long groupId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido);
	}

	/**
	* Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nomeReduzido the nome reduzido
	* @return the number of matching funcionarios that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_G_N_REDUZIDO(long companyId, long groupId,
		java.lang.String nomeReduzido)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido);
	}

	/**
	* Returns the funcionario where cpf = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param cpf the cpf
	* @return the matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByCPF(
		java.lang.String cpf)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCPF(cpf);
	}

	/**
	* Returns the funcionario where cpf = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cpf the cpf
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByCPF(
		java.lang.String cpf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCPF(cpf);
	}

	/**
	* Returns the funcionario where cpf = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cpf the cpf
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByCPF(
		java.lang.String cpf, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCPF(cpf, retrieveFromCache);
	}

	/**
	* Removes the funcionario where cpf = &#63; from the database.
	*
	* @param cpf the cpf
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario removeByCPF(
		java.lang.String cpf)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCPF(cpf);
	}

	/**
	* Returns the number of funcionarios where cpf = &#63;.
	*
	* @param cpf the cpf
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCPF(java.lang.String cpf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCPF(cpf);
	}

	/**
	* Returns the funcionario where rg = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param rg the rg
	* @return the matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByRG(
		java.lang.String rg)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRG(rg);
	}

	/**
	* Returns the funcionario where rg = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rg the rg
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByRG(
		java.lang.String rg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRG(rg);
	}

	/**
	* Returns the funcionario where rg = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rg the rg
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByRG(
		java.lang.String rg, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRG(rg, retrieveFromCache);
	}

	/**
	* Removes the funcionario where rg = &#63; from the database.
	*
	* @param rg the rg
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario removeByRG(
		java.lang.String rg)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByRG(rg);
	}

	/**
	* Returns the number of funcionarios where rg = &#63;.
	*
	* @param rg the rg
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRG(java.lang.String rg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRG(rg);
	}

	/**
	* Returns all the funcionarios where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDT_NASCIMENTO(dataNascimento);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDT_NASCIMENTO(dataNascimento, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByDT_NASCIMENTO(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDT_NASCIMENTO(dataNascimento, start, end,
			orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDT_NASCIMENTO_First(dataNascimento, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByDT_NASCIMENTO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDT_NASCIMENTO_First(dataNascimento, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDT_NASCIMENTO_Last(dataNascimento, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByDT_NASCIMENTO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDT_NASCIMENTO_Last(dataNascimento, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByDT_NASCIMENTO_PrevAndNext(
		long funcionarioId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDT_NASCIMENTO_PrevAndNext(funcionarioId,
			dataNascimento, orderByComparator);
	}

	/**
	* Removes all the funcionarios where dataNascimento = &#63; from the database.
	*
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDT_NASCIMENTO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDT_NASCIMENTO(dataNascimento);
	}

	/**
	* Returns the number of funcionarios where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDT_NASCIMENTO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDT_NASCIMENTO(dataNascimento);
	}

	/**
	* Returns all the funcionarios where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @return the matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCARGO(
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCARGO(cargoId);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCARGO(
		long cargoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCARGO(cargoId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findByCARGO(
		long cargoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCARGO(cargoId, start, end, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByCARGO_First(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCARGO_First(cargoId, orderByComparator);
	}

	/**
	* Returns the first funcionario in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByCARGO_First(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCARGO_First(cargoId, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByCARGO_Last(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCARGO_Last(cargoId, orderByComparator);
	}

	/**
	* Returns the last funcionario in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByCARGO_Last(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCARGO_Last(cargoId, orderByComparator);
	}

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
	public static br.com.prodevelopment.funcionario.model.Funcionario[] findByCARGO_PrevAndNext(
		long funcionarioId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCARGO_PrevAndNext(funcionarioId, cargoId,
			orderByComparator);
	}

	/**
	* Removes all the funcionarios where cargoId = &#63; from the database.
	*
	* @param cargoId the cargo ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCARGO(long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCARGO(cargoId);
	}

	/**
	* Returns the number of funcionarios where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCARGO(long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCARGO(cargoId);
	}

	/**
	* Returns the funcionario where userId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByUSUARIO(
		long userId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUSUARIO(userId);
	}

	/**
	* Returns the funcionario where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByUSUARIO(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUSUARIO(userId);
	}

	/**
	* Returns the funcionario where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByUSUARIO(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUSUARIO(userId, retrieveFromCache);
	}

	/**
	* Removes the funcionario where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario removeByUSUARIO(
		long userId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUSUARIO(userId);
	}

	/**
	* Returns the number of funcionarios where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUSUARIO(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUSUARIO(userId);
	}

	/**
	* Caches the funcionario in the entity cache if it is enabled.
	*
	* @param funcionario the funcionario
	*/
	public static void cacheResult(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario) {
		getPersistence().cacheResult(funcionario);
	}

	/**
	* Caches the funcionarios in the entity cache if it is enabled.
	*
	* @param funcionarios the funcionarios
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> funcionarios) {
		getPersistence().cacheResult(funcionarios);
	}

	/**
	* Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	*
	* @param funcionarioId the primary key for the new funcionario
	* @return the new funcionario
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario create(
		long funcionarioId) {
		return getPersistence().create(funcionarioId);
	}

	/**
	* Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario that was removed
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario remove(
		long funcionarioId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(funcionarioId);
	}

	public static br.com.prodevelopment.funcionario.model.Funcionario updateImpl(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(funcionario);
	}

	/**
	* Returns the funcionario with the primary key or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario
	* @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario findByPrimaryKey(
		long funcionarioId)
		throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(funcionarioId);
	}

	/**
	* Returns the funcionario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario, or <code>null</code> if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Funcionario fetchByPrimaryKey(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(funcionarioId);
	}

	/**
	* Returns all the funcionarios.
	*
	* @return the funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the funcionarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of funcionarios.
	*
	* @return the number of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FuncionarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FuncionarioPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.funcionario.service.ClpSerializer.getServletContextName(),
					FuncionarioPersistence.class.getName());

			ReferenceRegistry.registerReference(FuncionarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FuncionarioPersistence persistence) {
	}

	private static FuncionarioPersistence _persistence;
}