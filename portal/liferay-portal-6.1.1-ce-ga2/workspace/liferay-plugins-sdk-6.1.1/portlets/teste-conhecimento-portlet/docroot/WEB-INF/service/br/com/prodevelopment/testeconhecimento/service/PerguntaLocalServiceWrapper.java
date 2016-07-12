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
 * This class is a wrapper for {@link PerguntaLocalService}.
 * </p>
 *
 * @author    Marcelo Melo
 * @see       PerguntaLocalService
 * @generated
 */
public class PerguntaLocalServiceWrapper implements PerguntaLocalService,
	ServiceWrapper<PerguntaLocalService> {
	public PerguntaLocalServiceWrapper(
		PerguntaLocalService perguntaLocalService) {
		_perguntaLocalService = perguntaLocalService;
	}

	/**
	* Adds the pergunta to the database. Also notifies the appropriate model listeners.
	*
	* @param pergunta the pergunta
	* @return the pergunta that was added
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta addPergunta(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.addPergunta(pergunta);
	}

	/**
	* Creates a new pergunta with the primary key. Does not add the pergunta to the database.
	*
	* @param id the primary key for the new pergunta
	* @return the new pergunta
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta createPergunta(
		long id) {
		return _perguntaLocalService.createPergunta(id);
	}

	/**
	* Deletes the pergunta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the pergunta
	* @return the pergunta that was removed
	* @throws PortalException if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta deletePergunta(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.deletePergunta(id);
	}

	/**
	* Deletes the pergunta from the database. Also notifies the appropriate model listeners.
	*
	* @param pergunta the pergunta
	* @return the pergunta that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta deletePergunta(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.deletePergunta(pergunta);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _perguntaLocalService.dynamicQuery();
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
		return _perguntaLocalService.dynamicQuery(dynamicQuery);
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
		return _perguntaLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _perguntaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _perguntaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public br.com.prodevelopment.testeconhecimento.model.Pergunta fetchPergunta(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.fetchPergunta(id);
	}

	/**
	* Returns the pergunta with the primary key.
	*
	* @param id the primary key of the pergunta
	* @return the pergunta
	* @throws PortalException if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta getPergunta(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.getPergunta(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the perguntas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of perguntas
	* @param end the upper bound of the range of perguntas (not inclusive)
	* @return the range of perguntas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> getPerguntas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.getPerguntas(start, end);
	}

	/**
	* Returns the number of perguntas.
	*
	* @return the number of perguntas
	* @throws SystemException if a system exception occurred
	*/
	public int getPerguntasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.getPerguntasCount();
	}

	/**
	* Updates the pergunta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pergunta the pergunta
	* @return the pergunta that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta updatePergunta(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.updatePergunta(pergunta);
	}

	/**
	* Updates the pergunta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pergunta the pergunta
	* @param merge whether to merge the pergunta with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the pergunta that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta updatePergunta(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _perguntaLocalService.updatePergunta(pergunta, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _perguntaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_perguntaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _perguntaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PerguntaLocalService getWrappedPerguntaLocalService() {
		return _perguntaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPerguntaLocalService(
		PerguntaLocalService perguntaLocalService) {
		_perguntaLocalService = perguntaLocalService;
	}

	public PerguntaLocalService getWrappedService() {
		return _perguntaLocalService;
	}

	public void setWrappedService(PerguntaLocalService perguntaLocalService) {
		_perguntaLocalService = perguntaLocalService;
	}

	private PerguntaLocalService _perguntaLocalService;
}