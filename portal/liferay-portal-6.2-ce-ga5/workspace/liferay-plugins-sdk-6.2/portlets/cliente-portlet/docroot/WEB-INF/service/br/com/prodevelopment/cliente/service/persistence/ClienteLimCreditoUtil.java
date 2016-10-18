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

package br.com.prodevelopment.cliente.service.persistence;

import br.com.prodevelopment.cliente.model.ClienteLimCredito;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the cliente lim credito service. This utility wraps {@link ClienteLimCreditoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see ClienteLimCreditoPersistence
 * @see ClienteLimCreditoPersistenceImpl
 * @generated
 */
public class ClienteLimCreditoUtil {
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
	public static void clearCache(ClienteLimCredito clienteLimCredito) {
		getPersistence().clearCache(clienteLimCredito);
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
	public static List<ClienteLimCredito> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClienteLimCredito> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClienteLimCredito> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ClienteLimCredito update(ClienteLimCredito clienteLimCredito)
		throws SystemException {
		return getPersistence().update(clienteLimCredito);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ClienteLimCredito update(
		ClienteLimCredito clienteLimCredito, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(clienteLimCredito, serviceContext);
	}

	/**
	* Returns the cliente lim credito where clienteId = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException} if it could not be found.
	*
	* @param clienteId the cliente ID
	* @return the matching cliente lim credito
	* @throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException if a matching cliente lim credito could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteLimCredito findByCliente(
		long clienteId)
		throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCliente(clienteId);
	}

	/**
	* Returns the cliente lim credito where clienteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param clienteId the cliente ID
	* @return the matching cliente lim credito, or <code>null</code> if a matching cliente lim credito could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteLimCredito fetchByCliente(
		long clienteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCliente(clienteId);
	}

	/**
	* Returns the cliente lim credito where clienteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param clienteId the cliente ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cliente lim credito, or <code>null</code> if a matching cliente lim credito could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteLimCredito fetchByCliente(
		long clienteId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCliente(clienteId, retrieveFromCache);
	}

	/**
	* Removes the cliente lim credito where clienteId = &#63; from the database.
	*
	* @param clienteId the cliente ID
	* @return the cliente lim credito that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteLimCredito removeByCliente(
		long clienteId)
		throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCliente(clienteId);
	}

	/**
	* Returns the number of cliente lim creditos where clienteId = &#63;.
	*
	* @param clienteId the cliente ID
	* @return the number of matching cliente lim creditos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCliente(long clienteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCliente(clienteId);
	}

	/**
	* Caches the cliente lim credito in the entity cache if it is enabled.
	*
	* @param clienteLimCredito the cliente lim credito
	*/
	public static void cacheResult(
		br.com.prodevelopment.cliente.model.ClienteLimCredito clienteLimCredito) {
		getPersistence().cacheResult(clienteLimCredito);
	}

	/**
	* Caches the cliente lim creditos in the entity cache if it is enabled.
	*
	* @param clienteLimCreditos the cliente lim creditos
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.cliente.model.ClienteLimCredito> clienteLimCreditos) {
		getPersistence().cacheResult(clienteLimCreditos);
	}

	/**
	* Creates a new cliente lim credito with the primary key. Does not add the cliente lim credito to the database.
	*
	* @param clienteLimCreditoId the primary key for the new cliente lim credito
	* @return the new cliente lim credito
	*/
	public static br.com.prodevelopment.cliente.model.ClienteLimCredito create(
		long clienteLimCreditoId) {
		return getPersistence().create(clienteLimCreditoId);
	}

	/**
	* Removes the cliente lim credito with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteLimCreditoId the primary key of the cliente lim credito
	* @return the cliente lim credito that was removed
	* @throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException if a cliente lim credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteLimCredito remove(
		long clienteLimCreditoId)
		throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(clienteLimCreditoId);
	}

	public static br.com.prodevelopment.cliente.model.ClienteLimCredito updateImpl(
		br.com.prodevelopment.cliente.model.ClienteLimCredito clienteLimCredito)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(clienteLimCredito);
	}

	/**
	* Returns the cliente lim credito with the primary key or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException} if it could not be found.
	*
	* @param clienteLimCreditoId the primary key of the cliente lim credito
	* @return the cliente lim credito
	* @throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException if a cliente lim credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteLimCredito findByPrimaryKey(
		long clienteLimCreditoId)
		throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(clienteLimCreditoId);
	}

	/**
	* Returns the cliente lim credito with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clienteLimCreditoId the primary key of the cliente lim credito
	* @return the cliente lim credito, or <code>null</code> if a cliente lim credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteLimCredito fetchByPrimaryKey(
		long clienteLimCreditoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(clienteLimCreditoId);
	}

	/**
	* Returns all the cliente lim creditos.
	*
	* @return the cliente lim creditos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.cliente.model.ClienteLimCredito> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cliente lim creditos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteLimCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cliente lim creditos
	* @param end the upper bound of the range of cliente lim creditos (not inclusive)
	* @return the range of cliente lim creditos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.cliente.model.ClienteLimCredito> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cliente lim creditos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteLimCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cliente lim creditos
	* @param end the upper bound of the range of cliente lim creditos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cliente lim creditos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.cliente.model.ClienteLimCredito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cliente lim creditos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cliente lim creditos.
	*
	* @return the number of cliente lim creditos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ClienteLimCreditoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ClienteLimCreditoPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.cliente.service.ClpSerializer.getServletContextName(),
					ClienteLimCreditoPersistence.class.getName());

			ReferenceRegistry.registerReference(ClienteLimCreditoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ClienteLimCreditoPersistence persistence) {
	}

	private static ClienteLimCreditoPersistence _persistence;
}