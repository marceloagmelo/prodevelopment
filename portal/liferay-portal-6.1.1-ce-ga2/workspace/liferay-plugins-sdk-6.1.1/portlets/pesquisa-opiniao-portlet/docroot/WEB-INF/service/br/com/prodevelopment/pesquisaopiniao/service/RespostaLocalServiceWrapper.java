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

package br.com.prodevelopment.pesquisaopiniao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link RespostaLocalService}.
 * </p>
 *
 * @author    Marcelo Melo
 * @see       RespostaLocalService
 * @generated
 */
public class RespostaLocalServiceWrapper implements RespostaLocalService,
	ServiceWrapper<RespostaLocalService> {
	public RespostaLocalServiceWrapper(
		RespostaLocalService respostaLocalService) {
		_respostaLocalService = respostaLocalService;
	}

	/**
	* Adds the resposta to the database. Also notifies the appropriate model listeners.
	*
	* @param resposta the resposta
	* @return the resposta that was added
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta addResposta(
		br.com.prodevelopment.pesquisaopiniao.model.Resposta resposta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.addResposta(resposta);
	}

	/**
	* Creates a new resposta with the primary key. Does not add the resposta to the database.
	*
	* @param id the primary key for the new resposta
	* @return the new resposta
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta createResposta(
		long id) {
		return _respostaLocalService.createResposta(id);
	}

	/**
	* Deletes the resposta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the resposta
	* @return the resposta that was removed
	* @throws PortalException if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta deleteResposta(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.deleteResposta(id);
	}

	/**
	* Deletes the resposta from the database. Also notifies the appropriate model listeners.
	*
	* @param resposta the resposta
	* @return the resposta that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta deleteResposta(
		br.com.prodevelopment.pesquisaopiniao.model.Resposta resposta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.deleteResposta(resposta);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _respostaLocalService.dynamicQuery();
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
		return _respostaLocalService.dynamicQuery(dynamicQuery);
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
		return _respostaLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _respostaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _respostaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public br.com.prodevelopment.pesquisaopiniao.model.Resposta fetchResposta(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.fetchResposta(id);
	}

	/**
	* Returns the resposta with the primary key.
	*
	* @param id the primary key of the resposta
	* @return the resposta
	* @throws PortalException if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta getResposta(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.getResposta(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the respostas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of respostas
	* @param end the upper bound of the range of respostas (not inclusive)
	* @return the range of respostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta> getRespostas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.getRespostas(start, end);
	}

	/**
	* Returns the number of respostas.
	*
	* @return the number of respostas
	* @throws SystemException if a system exception occurred
	*/
	public int getRespostasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.getRespostasCount();
	}

	/**
	* Updates the resposta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resposta the resposta
	* @return the resposta that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta updateResposta(
		br.com.prodevelopment.pesquisaopiniao.model.Resposta resposta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.updateResposta(resposta);
	}

	/**
	* Updates the resposta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resposta the resposta
	* @param merge whether to merge the resposta with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the resposta that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta updateResposta(
		br.com.prodevelopment.pesquisaopiniao.model.Resposta resposta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _respostaLocalService.updateResposta(resposta, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _respostaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_respostaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _respostaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RespostaLocalService getWrappedRespostaLocalService() {
		return _respostaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRespostaLocalService(
		RespostaLocalService respostaLocalService) {
		_respostaLocalService = respostaLocalService;
	}

	public RespostaLocalService getWrappedService() {
		return _respostaLocalService;
	}

	public void setWrappedService(RespostaLocalService respostaLocalService) {
		_respostaLocalService = respostaLocalService;
	}

	private RespostaLocalService _respostaLocalService;
}