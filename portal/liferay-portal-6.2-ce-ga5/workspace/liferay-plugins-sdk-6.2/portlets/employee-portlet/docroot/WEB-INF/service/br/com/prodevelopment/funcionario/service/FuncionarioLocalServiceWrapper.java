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

package br.com.prodevelopment.funcionario.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FuncionarioLocalService}.
 *
 * @author Marcelo Melo
 * @see FuncionarioLocalService
 * @generated
 */
public class FuncionarioLocalServiceWrapper implements FuncionarioLocalService,
	ServiceWrapper<FuncionarioLocalService> {
	public FuncionarioLocalServiceWrapper(
		FuncionarioLocalService funcionarioLocalService) {
		_funcionarioLocalService = funcionarioLocalService;
	}

	/**
	* Adds the funcionario to the database. Also notifies the appropriate model listeners.
	*
	* @param funcionario the funcionario
	* @return the funcionario that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario addFuncionario(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.addFuncionario(funcionario);
	}

	/**
	* Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	*
	* @param funcionarioId the primary key for the new funcionario
	* @return the new funcionario
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario createFuncionario(
		long funcionarioId) {
		return _funcionarioLocalService.createFuncionario(funcionarioId);
	}

	/**
	* Deletes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario that was removed
	* @throws PortalException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario deleteFuncionario(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.deleteFuncionario(funcionarioId);
	}

	/**
	* Deletes the funcionario from the database. Also notifies the appropriate model listeners.
	*
	* @param funcionario the funcionario
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario deleteFuncionario(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.deleteFuncionario(funcionario);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _funcionarioLocalService.dynamicQuery();
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
		return _funcionarioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _funcionarioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _funcionarioLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _funcionarioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _funcionarioLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario fetchFuncionario(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.fetchFuncionario(funcionarioId);
	}

	/**
	* Returns the funcionario with the matching UUID and company.
	*
	* @param uuid the funcionario's UUID
	* @param companyId the primary key of the company
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario fetchFuncionarioByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.fetchFuncionarioByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the funcionario matching the UUID and group.
	*
	* @param uuid the funcionario's UUID
	* @param groupId the primary key of the group
	* @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario fetchFuncionarioByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.fetchFuncionarioByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the funcionario with the primary key.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario
	* @throws PortalException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario getFuncionario(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.getFuncionario(funcionarioId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the funcionario with the matching UUID and company.
	*
	* @param uuid the funcionario's UUID
	* @param companyId the primary key of the company
	* @return the matching funcionario
	* @throws PortalException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario getFuncionarioByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.getFuncionarioByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the funcionario matching the UUID and group.
	*
	* @param uuid the funcionario's UUID
	* @param groupId the primary key of the group
	* @return the matching funcionario
	* @throws PortalException if a matching funcionario could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario getFuncionarioByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.getFuncionarioByUuidAndGroupId(uuid,
			groupId);
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
	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> getFuncionarios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.getFuncionarios(start, end);
	}

	/**
	* Returns the number of funcionarios.
	*
	* @return the number of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFuncionariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.getFuncionariosCount();
	}

	/**
	* Updates the funcionario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param funcionario the funcionario
	* @return the funcionario that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario updateFuncionario(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.updateFuncionario(funcionario);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _funcionarioLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_funcionarioLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _funcionarioLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario addFuncionario(
		long companyId, long groupId, long createUserId, java.lang.String nome,
		java.lang.String nomeReduzido, java.lang.String observacao,
		java.lang.String rg, java.lang.String rgOrgaoEmissor,
		java.lang.String rgDataEmissao, java.lang.String cpf,
		java.lang.String sexo, java.lang.String estadoCivil,
		java.lang.String dataNascimento, java.lang.String endComLogradouro,
		java.lang.String endComNumero, java.lang.String endComComplemento,
		java.lang.String endComCep, java.lang.String endComBairro,
		long endComCidade, java.lang.String endComUf,
		java.lang.String endComPais, java.lang.String endResLogradouro,
		java.lang.String endResNumero, java.lang.String endResComplemento,
		java.lang.String endResCep, java.lang.String endResBairro,
		long endResCidade, java.lang.String endResUf,
		java.lang.String endResPais, java.lang.String dataEntrada,
		java.lang.String dataSaida, boolean existeUser, long userId,
		double versao, long cargoId, boolean ativo, double salario,
		java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.contato.model.Telefone> telefones,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.addFuncionario(companyId, groupId,
			createUserId, nome, nomeReduzido, observacao, rg, rgOrgaoEmissor,
			rgDataEmissao, cpf, sexo, estadoCivil, dataNascimento,
			endComLogradouro, endComNumero, endComComplemento, endComCep,
			endComBairro, endComCidade, endComUf, endComPais, endResLogradouro,
			endResNumero, endResComplemento, endResCep, endResBairro,
			endResCidade, endResUf, endResPais, dataEntrada, dataSaida,
			existeUser, userId, versao, cargoId, ativo, salario,
			enderecosEmail, telefones, serviceContext);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario update(
		long funcionarioId, long companyId, long groupId, long modifieduserId,
		java.lang.String nome, java.lang.String nomeReduzido,
		java.lang.String observacao, java.lang.String rg,
		java.lang.String rgOrgaoEmissor, java.lang.String rgDataEmissao,
		java.lang.String cpf, java.lang.String sexo,
		java.lang.String estadoCivil, java.lang.String dataNascimento,
		java.lang.String endComLogradouro, java.lang.String endComNumero,
		java.lang.String endComComplemento, java.lang.String endComCep,
		java.lang.String endComBairro, long endComCidade,
		java.lang.String endComUf, java.lang.String endComPais,
		java.lang.String endResLogradouro, java.lang.String endResNumero,
		java.lang.String endResComplemento, java.lang.String endResCep,
		java.lang.String endResBairro, long endResCidade,
		java.lang.String endResUf, java.lang.String endResPais,
		java.lang.String dataEntrada, java.lang.String dataSaida,
		boolean existeUser, long userId, double versao, long cargoId,
		boolean ativo, double salario,
		java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> enderecosEmail,
		java.util.List<br.com.prodevelopment.contato.model.Telefone> telefones,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.update(funcionarioId, companyId,
			groupId, modifieduserId, nome, nomeReduzido, observacao, rg,
			rgOrgaoEmissor, rgDataEmissao, cpf, sexo, estadoCivil,
			dataNascimento, endComLogradouro, endComNumero, endComComplemento,
			endComCep, endComBairro, endComCidade, endComUf, endComPais,
			endResLogradouro, endResNumero, endResComplemento, endResCep,
			endResBairro, endResCidade, endResUf, endResPais, dataEntrada,
			dataSaida, existeUser, userId, versao, cargoId, ativo, salario,
			enderecosEmail, telefones, serviceContext);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario deleteFuncionario(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.deleteFuncionario(funcionario, userId);
	}

	@Override
	public void updateAsset(long userId,
		br.com.prodevelopment.funcionario.model.Funcionario funcionario,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_funcionarioLocalService.updateAsset(userId, funcionario,
			assetCategoryIds, assetTagNames, assetLinkEntryIds);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.search(companyId, groupId, nome, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.searchCount(companyId, groupId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> search(
		long companyId, long groupId, java.lang.String nome, boolean ativo,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.search(companyId, groupId, nome, ativo,
			start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String nome,
		boolean ativo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.searchCount(companyId, groupId, nome,
			ativo);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> search(
		long companyId, long groupId, boolean ativo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.search(companyId, groupId, ativo,
			start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, boolean ativo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.searchCount(companyId, groupId, ativo);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> search(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.search(companyId, nome, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.searchCount(companyId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> search(
		long companyId, java.lang.String nome, boolean ativo, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.search(companyId, nome, ativo, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, java.lang.String nome, boolean ativo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.searchCount(companyId, nome, ativo);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.searchCount(companyId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Funcionario> search(
		long companyId, boolean ativo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.search(companyId, ativo, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, boolean ativo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.searchCount(companyId, ativo);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario updateFoto(
		long funcionarioId, byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.updateFoto(funcionarioId, bytes);
	}

	@Override
	public void deleteFoto(long funcionarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_funcionarioLocalService.deleteFoto(funcionarioId);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario updateFoto(
		long funcionarioId, long fotoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.updateFoto(funcionarioId, fotoId);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario fetchByUSUARIO(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.fetchByUSUARIO(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FuncionarioLocalService getWrappedFuncionarioLocalService() {
		return _funcionarioLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFuncionarioLocalService(
		FuncionarioLocalService funcionarioLocalService) {
		_funcionarioLocalService = funcionarioLocalService;
	}

	@Override
	public FuncionarioLocalService getWrappedService() {
		return _funcionarioLocalService;
	}

	@Override
	public void setWrappedService(
		FuncionarioLocalService funcionarioLocalService) {
		_funcionarioLocalService = funcionarioLocalService;
	}

	private FuncionarioLocalService _funcionarioLocalService;
}