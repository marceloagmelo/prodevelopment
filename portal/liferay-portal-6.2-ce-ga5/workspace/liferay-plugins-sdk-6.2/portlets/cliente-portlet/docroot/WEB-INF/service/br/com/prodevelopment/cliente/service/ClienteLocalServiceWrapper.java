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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClienteLocalService}.
 *
 * @author marcelo
 * @see ClienteLocalService
 * @generated
 */
public class ClienteLocalServiceWrapper implements ClienteLocalService,
	ServiceWrapper<ClienteLocalService> {
	public ClienteLocalServiceWrapper(ClienteLocalService clienteLocalService) {
		_clienteLocalService = clienteLocalService;
	}

	/**
	* Adds the cliente to the database. Also notifies the appropriate model listeners.
	*
	* @param cliente the cliente
	* @return the cliente that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente addCliente(
		br.com.prodevelopment.cliente.model.Cliente cliente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.addCliente(cliente);
	}

	/**
	* Creates a new cliente with the primary key. Does not add the cliente to the database.
	*
	* @param clienteId the primary key for the new cliente
	* @return the new cliente
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente createCliente(
		long clienteId) {
		return _clienteLocalService.createCliente(clienteId);
	}

	/**
	* Deletes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteId the primary key of the cliente
	* @return the cliente that was removed
	* @throws PortalException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente deleteCliente(
		long clienteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.deleteCliente(clienteId);
	}

	/**
	* Deletes the cliente from the database. Also notifies the appropriate model listeners.
	*
	* @param cliente the cliente
	* @return the cliente that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente deleteCliente(
		br.com.prodevelopment.cliente.model.Cliente cliente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.deleteCliente(cliente);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clienteLocalService.dynamicQuery();
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
		return _clienteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _clienteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _clienteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _clienteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _clienteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.cliente.model.Cliente fetchCliente(
		long clienteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.fetchCliente(clienteId);
	}

	/**
	* Returns the cliente with the matching UUID and company.
	*
	* @param uuid the cliente's UUID
	* @param companyId the primary key of the company
	* @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente fetchClienteByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.fetchClienteByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the cliente matching the UUID and group.
	*
	* @param uuid the cliente's UUID
	* @param groupId the primary key of the group
	* @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente fetchClienteByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.fetchClienteByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the cliente with the primary key.
	*
	* @param clienteId the primary key of the cliente
	* @return the cliente
	* @throws PortalException if a cliente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente getCliente(
		long clienteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.getCliente(clienteId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the cliente with the matching UUID and company.
	*
	* @param uuid the cliente's UUID
	* @param companyId the primary key of the company
	* @return the matching cliente
	* @throws PortalException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente getClienteByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.getClienteByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the cliente matching the UUID and group.
	*
	* @param uuid the cliente's UUID
	* @param groupId the primary key of the group
	* @return the matching cliente
	* @throws PortalException if a matching cliente could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente getClienteByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.getClienteByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the clientes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clientes
	* @param end the upper bound of the range of clientes (not inclusive)
	* @return the range of clientes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> getClientes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.getClientes(start, end);
	}

	/**
	* Returns the number of clientes.
	*
	* @return the number of clientes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getClientesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.getClientesCount();
	}

	/**
	* Updates the cliente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cliente the cliente
	* @return the cliente that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.cliente.model.Cliente updateCliente(
		br.com.prodevelopment.cliente.model.Cliente cliente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.updateCliente(cliente);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _clienteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_clienteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _clienteLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public br.com.prodevelopment.cliente.model.Cliente addCliente(
		long companyId, long groupId, long createUserId, java.lang.String nome,
		java.lang.String tipoPessoa, java.lang.String observacao,
		java.lang.String rgInscricaoMun, java.lang.String rgOrgaoEmissor,
		java.lang.String rgDataEmissao, java.lang.String cpfCnpj,
		java.lang.String sexo, java.lang.String estadoCivil,
		java.lang.String dataNascimento, java.lang.String endComLogradouro,
		java.lang.String endComNumero, java.lang.String endComComplemento,
		java.lang.String endComCep, java.lang.String endComBairro,
		long endComCidade, java.lang.String endComUf,
		java.lang.String endComPais, java.lang.String endResLogradouro,
		java.lang.String endResNumero, java.lang.String endResComplemento,
		java.lang.String endResCep, java.lang.String endResBairro,
		long endResCidade, java.lang.String endResUf,
		java.lang.String endResPais, double valorLimiteMaximoCredito,
		java.lang.String dataLimiteMaximoCredito,
		double valorLimiteMaximoCheque, int qtdeLimiteMaximoCheque,
		double versao,
		java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.contato.model.Telefone> telefones,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.addCliente(companyId, groupId,
			createUserId, nome, tipoPessoa, observacao, rgInscricaoMun,
			rgOrgaoEmissor, rgDataEmissao, cpfCnpj, sexo, estadoCivil,
			dataNascimento, endComLogradouro, endComNumero, endComComplemento,
			endComCep, endComBairro, endComCidade, endComUf, endComPais,
			endResLogradouro, endResNumero, endResComplemento, endResCep,
			endResBairro, endResCidade, endResUf, endResPais,
			valorLimiteMaximoCredito, dataLimiteMaximoCredito,
			valorLimiteMaximoCheque, qtdeLimiteMaximoCheque, versao,
			enderecosEmail, telefones, serviceContext);
	}

	@Override
	public br.com.prodevelopment.cliente.model.Cliente update(long clienteId,
		long companyId, long groupId, long modifieduserId,
		java.lang.String nome, java.lang.String tipoPessoa,
		java.lang.String observacao, java.lang.String rgInscricaoMun,
		java.lang.String rgOrgaoEmissor, java.lang.String rgDataEmissao,
		java.lang.String cpfCnpj, java.lang.String sexo,
		java.lang.String estadoCivil, java.lang.String dataNascimento,
		java.lang.String endComLogradouro, java.lang.String endComNumero,
		java.lang.String endComComplemento, java.lang.String endComCep,
		java.lang.String endComBairro, long endComCidade,
		java.lang.String endComUf, java.lang.String endComPais,
		java.lang.String endResLogradouro, java.lang.String endResNumero,
		java.lang.String endResComplemento, java.lang.String endResCep,
		java.lang.String endResBairro, long endResCidade,
		java.lang.String endResUf, java.lang.String endResPais,
		double valorLimiteMaximoCredito,
		java.lang.String dataLimiteMaximoCredito,
		double valorLimiteMaximoCheque, int qtdeLimiteMaximoCheque,
		double versao,
		java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.contato.model.Telefone> telefones,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.update(clienteId, companyId, groupId,
			modifieduserId, nome, tipoPessoa, observacao, rgInscricaoMun,
			rgOrgaoEmissor, rgDataEmissao, cpfCnpj, sexo, estadoCivil,
			dataNascimento, endComLogradouro, endComNumero, endComComplemento,
			endComCep, endComBairro, endComCidade, endComUf, endComPais,
			endResLogradouro, endResNumero, endResComplemento, endResCep,
			endResBairro, endResCidade, endResUf, endResPais,
			valorLimiteMaximoCredito, dataLimiteMaximoCredito,
			valorLimiteMaximoCheque, qtdeLimiteMaximoCheque, versao,
			enderecosEmail, telefones, serviceContext);
	}

	@Override
	public br.com.prodevelopment.cliente.model.Cliente deleteCliente(
		br.com.prodevelopment.cliente.model.Cliente cliente, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.deleteCliente(cliente, userId);
	}

	@Override
	public void updateAsset(long userId,
		br.com.prodevelopment.cliente.model.Cliente cliente,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clienteLocalService.updateAsset(userId, cliente, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	@Override
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.search(companyId, groupId, nome, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.searchCount(companyId, groupId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> search(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.search(companyId, nome, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.searchCount(companyId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.cliente.model.Cliente> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.searchCount(companyId);
	}

	@Override
	public br.com.prodevelopment.cliente.model.Cliente updateFoto(
		long clienteId, byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.updateFoto(clienteId, bytes);
	}

	@Override
	public void deleteFoto(long clienteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clienteLocalService.deleteFoto(clienteId);
	}

	@Override
	public br.com.prodevelopment.cliente.model.Cliente updateFoto(
		long clienteId, long logoTipoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clienteLocalService.updateFoto(clienteId, logoTipoId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ClienteLocalService getWrappedClienteLocalService() {
		return _clienteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedClienteLocalService(
		ClienteLocalService clienteLocalService) {
		_clienteLocalService = clienteLocalService;
	}

	@Override
	public ClienteLocalService getWrappedService() {
		return _clienteLocalService;
	}

	@Override
	public void setWrappedService(ClienteLocalService clienteLocalService) {
		_clienteLocalService = clienteLocalService;
	}

	private ClienteLocalService _clienteLocalService;
}