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

package br.com.prodevelopment.cliente.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ClienteUsuario. This utility wraps
 * {@link br.com.prodevelopment.cliente.service.impl.ClienteUsuarioLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author marcelo
 * @see ClienteUsuarioLocalService
 * @see br.com.prodevelopment.cliente.service.base.ClienteUsuarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.cliente.service.impl.ClienteUsuarioLocalServiceImpl
 * @generated
 */
public class ClienteUsuarioLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.cliente.service.impl.ClienteUsuarioLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cliente usuario to the database. Also notifies the appropriate model listeners.
	*
	* @param clienteUsuario the cliente usuario
	* @return the cliente usuario that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario addClienteUsuario(
		br.com.prodevelopment.cliente.model.ClienteUsuario clienteUsuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addClienteUsuario(clienteUsuario);
	}

	/**
	* Creates a new cliente usuario with the primary key. Does not add the cliente usuario to the database.
	*
	* @param clienteUsuarioId the primary key for the new cliente usuario
	* @return the new cliente usuario
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario createClienteUsuario(
		long clienteUsuarioId) {
		return getService().createClienteUsuario(clienteUsuarioId);
	}

	/**
	* Deletes the cliente usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteUsuarioId the primary key of the cliente usuario
	* @return the cliente usuario that was removed
	* @throws PortalException if a cliente usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario deleteClienteUsuario(
		long clienteUsuarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteClienteUsuario(clienteUsuarioId);
	}

	/**
	* Deletes the cliente usuario from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteUsuario the cliente usuario
	* @return the cliente usuario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario deleteClienteUsuario(
		br.com.prodevelopment.cliente.model.ClienteUsuario clienteUsuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteClienteUsuario(clienteUsuario);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static br.com.prodevelopment.cliente.model.ClienteUsuario fetchClienteUsuario(
		long clienteUsuarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchClienteUsuario(clienteUsuarioId);
	}

	/**
	* Returns the cliente usuario with the primary key.
	*
	* @param clienteUsuarioId the primary key of the cliente usuario
	* @return the cliente usuario
	* @throws PortalException if a cliente usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario getClienteUsuario(
		long clienteUsuarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClienteUsuario(clienteUsuarioId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<br.com.prodevelopment.cliente.model.ClienteUsuario> getClienteUsuarios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClienteUsuarios(start, end);
	}

	/**
	* Returns the number of cliente usuarios.
	*
	* @return the number of cliente usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int getClienteUsuariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClienteUsuariosCount();
	}

	/**
	* Updates the cliente usuario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param clienteUsuario the cliente usuario
	* @return the cliente usuario that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.cliente.model.ClienteUsuario updateClienteUsuario(
		br.com.prodevelopment.cliente.model.ClienteUsuario clienteUsuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateClienteUsuario(clienteUsuario);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static br.com.prodevelopment.cliente.model.ClienteUsuario addClienteUsuario(
		long clienteId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addClienteUsuario(clienteId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ClienteUsuarioLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ClienteUsuarioLocalService.class.getName());

			if (invokableLocalService instanceof ClienteUsuarioLocalService) {
				_service = (ClienteUsuarioLocalService)invokableLocalService;
			}
			else {
				_service = new ClienteUsuarioLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ClienteUsuarioLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ClienteUsuarioLocalService service) {
	}

	private static ClienteUsuarioLocalService _service;
}