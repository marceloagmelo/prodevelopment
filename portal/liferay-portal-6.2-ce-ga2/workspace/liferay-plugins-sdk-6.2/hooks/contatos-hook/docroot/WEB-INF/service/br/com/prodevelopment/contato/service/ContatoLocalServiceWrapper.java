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

package br.com.prodevelopment.contato.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContatoLocalService}.
 *
 * @author marcelo
 * @see ContatoLocalService
 * @generated
 */
public class ContatoLocalServiceWrapper implements ContatoLocalService,
	ServiceWrapper<ContatoLocalService> {
	public ContatoLocalServiceWrapper(ContatoLocalService contatoLocalService) {
		_contatoLocalService = contatoLocalService;
	}

	/**
	* Adds the contato to the database. Also notifies the appropriate model listeners.
	*
	* @param contato the contato
	* @return the contato that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Contato addContato(
		br.com.prodevelopment.contato.model.Contato contato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.addContato(contato);
	}

	/**
	* Creates a new contato with the primary key. Does not add the contato to the database.
	*
	* @param contatoId the primary key for the new contato
	* @return the new contato
	*/
	@Override
	public br.com.prodevelopment.contato.model.Contato createContato(
		long contatoId) {
		return _contatoLocalService.createContato(contatoId);
	}

	/**
	* Deletes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contatoId the primary key of the contato
	* @return the contato that was removed
	* @throws PortalException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Contato deleteContato(
		long contatoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.deleteContato(contatoId);
	}

	/**
	* Deletes the contato from the database. Also notifies the appropriate model listeners.
	*
	* @param contato the contato
	* @return the contato that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Contato deleteContato(
		br.com.prodevelopment.contato.model.Contato contato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.deleteContato(contato);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contatoLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.contato.model.Contato fetchContato(
		long contatoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.fetchContato(contatoId);
	}

	/**
	* Returns the contato with the primary key.
	*
	* @param contatoId the primary key of the contato
	* @return the contato
	* @throws PortalException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Contato getContato(
		long contatoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.getContato(contatoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contatos
	* @param end the upper bound of the range of contatos (not inclusive)
	* @return the range of contatos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.contato.model.Contato> getContatos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.getContatos(start, end);
	}

	/**
	* Returns the number of contatos.
	*
	* @return the number of contatos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContatosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.getContatosCount();
	}

	/**
	* Updates the contato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contato the contato
	* @return the contato that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Contato updateContato(
		br.com.prodevelopment.contato.model.Contato contato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.updateContato(contato);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contatoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contatoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contatoLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public br.com.prodevelopment.contato.model.Contato addContato(
		long companyId, long groupId, long createUserId,
		java.lang.String className, long classPK, java.lang.String nome,
		java.lang.String endEmail, java.lang.String sexo,
		java.lang.String dataNascimento, long cargoId, java.lang.String skype,
		java.lang.String facebook, java.lang.String twitter)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.addContato(companyId, groupId,
			createUserId, className, classPK, nome, endEmail, sexo,
			dataNascimento, cargoId, skype, facebook, twitter);
	}

	@Override
	public br.com.prodevelopment.contato.model.Contato update(long contatoId,
		long modifieduserId, java.lang.String nome, java.lang.String endEmail,
		java.lang.String sexo, java.lang.String dataNascimento, long cargoId,
		java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.update(contatoId, modifieduserId, nome,
			endEmail, sexo, dataNascimento, cargoId, skype, facebook, twitter);
	}

	@Override
	public java.util.List<br.com.prodevelopment.contato.model.Contato> search(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.search(companyId, nome, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.searchCount(companyId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.contato.model.Contato> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.search(companyId, groupId, nome, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.searchCount(companyId, groupId, nome);
	}

	@Override
	public br.com.prodevelopment.contato.model.Contato findByContato(
		long classNameId, long classPK)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.findByContato(classNameId, classPK);
	}

	@Override
	public br.com.prodevelopment.contato.model.Contato createContato()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contatoLocalService.createContato();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContatoLocalService getWrappedContatoLocalService() {
		return _contatoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContatoLocalService(
		ContatoLocalService contatoLocalService) {
		_contatoLocalService = contatoLocalService;
	}

	@Override
	public ContatoLocalService getWrappedService() {
		return _contatoLocalService;
	}

	@Override
	public void setWrappedService(ContatoLocalService contatoLocalService) {
		_contatoLocalService = contatoLocalService;
	}

	private ContatoLocalService _contatoLocalService;
}