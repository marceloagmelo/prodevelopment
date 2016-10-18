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

import br.com.prodevelopment.cliente.model.ClienteUsuario;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the cliente usuario service. This utility wraps {@link ClienteUsuarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see ClienteUsuarioPersistence
 * @see ClienteUsuarioPersistenceImpl
 * @generated
 */
public class ClienteUsuarioUtil {
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
	public static void clearCache(ClienteUsuario clienteUsuario) {
		getPersistence().clearCache(clienteUsuario);
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
	public static List<ClienteUsuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClienteUsuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClienteUsuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ClienteUsuario update(ClienteUsuario clienteUsuario)
		throws SystemException {
		return getPersistence().update(clienteUsuario);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ClienteUsuario update(ClienteUsuario clienteUsuario,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(clienteUsuario, serviceContext);
	}

	/**
	* Returns the cliente usuario where userId = &#63; and clienteId = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteUsuarioException} if it could not be found.
	*
	* @param userId the user ID
	* @param clienteId the cliente ID
	* @return the matching cliente usuario
	* @throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException if a matching cliente usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario findByClienteUsuario(
		long userId, long clienteId)
		throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClienteUsuario(userId, clienteId);
	}

	/**
	* Returns the cliente usuario where userId = &#63; and clienteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param clienteId the cliente ID
	* @return the matching cliente usuario, or <code>null</code> if a matching cliente usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario fetchByClienteUsuario(
		long userId, long clienteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByClienteUsuario(userId, clienteId);
	}

	/**
	* Returns the cliente usuario where userId = &#63; and clienteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param clienteId the cliente ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cliente usuario, or <code>null</code> if a matching cliente usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario fetchByClienteUsuario(
		long userId, long clienteId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClienteUsuario(userId, clienteId, retrieveFromCache);
	}

	/**
	* Removes the cliente usuario where userId = &#63; and clienteId = &#63; from the database.
	*
	* @param userId the user ID
	* @param clienteId the cliente ID
	* @return the cliente usuario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario removeByClienteUsuario(
		long userId, long clienteId)
		throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByClienteUsuario(userId, clienteId);
	}

	/**
	* Returns the number of cliente usuarios where userId = &#63; and clienteId = &#63;.
	*
	* @param userId the user ID
	* @param clienteId the cliente ID
	* @return the number of matching cliente usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClienteUsuario(long userId, long clienteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClienteUsuario(userId, clienteId);
	}

	/**
	* Caches the cliente usuario in the entity cache if it is enabled.
	*
	* @param clienteUsuario the cliente usuario
	*/
	public static void cacheResult(
		br.com.prodevelopment.cliente.model.ClienteUsuario clienteUsuario) {
		getPersistence().cacheResult(clienteUsuario);
	}

	/**
	* Caches the cliente usuarios in the entity cache if it is enabled.
	*
	* @param clienteUsuarios the cliente usuarios
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.cliente.model.ClienteUsuario> clienteUsuarios) {
		getPersistence().cacheResult(clienteUsuarios);
	}

	/**
	* Creates a new cliente usuario with the primary key. Does not add the cliente usuario to the database.
	*
	* @param clienteUsuarioId the primary key for the new cliente usuario
	* @return the new cliente usuario
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario create(
		long clienteUsuarioId) {
		return getPersistence().create(clienteUsuarioId);
	}

	/**
	* Removes the cliente usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteUsuarioId the primary key of the cliente usuario
	* @return the cliente usuario that was removed
	* @throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException if a cliente usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario remove(
		long clienteUsuarioId)
		throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(clienteUsuarioId);
	}

	public static br.com.prodevelopment.cliente.model.ClienteUsuario updateImpl(
		br.com.prodevelopment.cliente.model.ClienteUsuario clienteUsuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(clienteUsuario);
	}

	/**
	* Returns the cliente usuario with the primary key or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteUsuarioException} if it could not be found.
	*
	* @param clienteUsuarioId the primary key of the cliente usuario
	* @return the cliente usuario
	* @throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException if a cliente usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario findByPrimaryKey(
		long clienteUsuarioId)
		throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(clienteUsuarioId);
	}

	/**
	* Returns the cliente usuario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clienteUsuarioId the primary key of the cliente usuario
	* @return the cliente usuario, or <code>null</code> if a cliente usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario fetchByPrimaryKey(
		long clienteUsuarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(clienteUsuarioId);
	}

	/**
	* Returns all the cliente usuarios.
	*
	* @return the cliente usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.cliente.model.ClienteUsuario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cliente usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cliente usuarios
	* @param end the upper bound of the range of cliente usuarios (not inclusive)
	* @return the range of cliente usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.cliente.model.ClienteUsuario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cliente usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cliente usuarios
	* @param end the upper bound of the range of cliente usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cliente usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.cliente.model.ClienteUsuario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cliente usuarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cliente usuarios.
	*
	* @return the number of cliente usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ClienteUsuarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ClienteUsuarioPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.cliente.service.ClpSerializer.getServletContextName(),
					ClienteUsuarioPersistence.class.getName());

			ReferenceRegistry.registerReference(ClienteUsuarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ClienteUsuarioPersistence persistence) {
	}

	private static ClienteUsuarioPersistence _persistence;
}