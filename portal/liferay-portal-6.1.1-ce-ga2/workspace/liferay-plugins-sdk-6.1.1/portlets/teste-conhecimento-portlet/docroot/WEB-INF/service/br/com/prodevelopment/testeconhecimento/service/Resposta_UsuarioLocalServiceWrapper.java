/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package br.com.prodevelopment.testeconhecimento.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Resposta_UsuarioLocalService}.
 * </p>
 *
 * @author    Marcelo Melo
 * @see       Resposta_UsuarioLocalService
 * @generated
 */
public class Resposta_UsuarioLocalServiceWrapper
	implements Resposta_UsuarioLocalService,
		ServiceWrapper<Resposta_UsuarioLocalService> {
	public Resposta_UsuarioLocalServiceWrapper(
		Resposta_UsuarioLocalService resposta_UsuarioLocalService) {
		_resposta_UsuarioLocalService = resposta_UsuarioLocalService;
	}

	/**
	* Adds the resposta_ usuario to the database. Also notifies the appropriate model listeners.
	*
	* @param resposta_Usuario the resposta_ usuario
	* @return the resposta_ usuario that was added
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario addResposta_Usuario(
		br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario resposta_Usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.addResposta_Usuario(resposta_Usuario);
	}

	/**
	* Creates a new resposta_ usuario with the primary key. Does not add the resposta_ usuario to the database.
	*
	* @param id the primary key for the new resposta_ usuario
	* @return the new resposta_ usuario
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario createResposta_Usuario(
		long id) {
		return _resposta_UsuarioLocalService.createResposta_Usuario(id);
	}

	/**
	* Deletes the resposta_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the resposta_ usuario
	* @return the resposta_ usuario that was removed
	* @throws PortalException if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario deleteResposta_Usuario(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.deleteResposta_Usuario(id);
	}

	/**
	* Deletes the resposta_ usuario from the database. Also notifies the appropriate model listeners.
	*
	* @param resposta_Usuario the resposta_ usuario
	* @return the resposta_ usuario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario deleteResposta_Usuario(
		br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario resposta_Usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.deleteResposta_Usuario(resposta_Usuario);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resposta_UsuarioLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.dynamicQueryCount(dynamicQuery);
	}

	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario fetchResposta_Usuario(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.fetchResposta_Usuario(id);
	}

	/**
	* Returns the resposta_ usuario with the primary key.
	*
	* @param id the primary key of the resposta_ usuario
	* @return the resposta_ usuario
	* @throws PortalException if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario getResposta_Usuario(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.getResposta_Usuario(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the resposta_ usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resposta_ usuarios
	* @param end the upper bound of the range of resposta_ usuarios (not inclusive)
	* @return the range of resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> getResposta_Usuarios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.getResposta_Usuarios(start, end);
	}

	/**
	* Returns the number of resposta_ usuarios.
	*
	* @return the number of resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public int getResposta_UsuariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.getResposta_UsuariosCount();
	}

	/**
	* Updates the resposta_ usuario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resposta_Usuario the resposta_ usuario
	* @return the resposta_ usuario that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario updateResposta_Usuario(
		br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario resposta_Usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.updateResposta_Usuario(resposta_Usuario);
	}

	/**
	* Updates the resposta_ usuario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resposta_Usuario the resposta_ usuario
	* @param merge whether to merge the resposta_ usuario with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the resposta_ usuario that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario updateResposta_Usuario(
		br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario resposta_Usuario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resposta_UsuarioLocalService.updateResposta_Usuario(resposta_Usuario,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _resposta_UsuarioLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_resposta_UsuarioLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _resposta_UsuarioLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Resposta_UsuarioLocalService getWrappedResposta_UsuarioLocalService() {
		return _resposta_UsuarioLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedResposta_UsuarioLocalService(
		Resposta_UsuarioLocalService resposta_UsuarioLocalService) {
		_resposta_UsuarioLocalService = resposta_UsuarioLocalService;
	}

	public Resposta_UsuarioLocalService getWrappedService() {
		return _resposta_UsuarioLocalService;
	}

	public void setWrappedService(
		Resposta_UsuarioLocalService resposta_UsuarioLocalService) {
		_resposta_UsuarioLocalService = resposta_UsuarioLocalService;
	}

	private Resposta_UsuarioLocalService _resposta_UsuarioLocalService;
}