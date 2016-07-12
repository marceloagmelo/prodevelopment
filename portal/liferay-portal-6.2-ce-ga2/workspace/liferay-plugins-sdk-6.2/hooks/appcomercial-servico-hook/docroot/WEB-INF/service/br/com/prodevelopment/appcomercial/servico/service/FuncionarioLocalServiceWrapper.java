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

package br.com.prodevelopment.appcomercial.servico.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FuncionarioLocalService}.
 *
 * @author marcelo
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario addFuncionario(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario)
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario createFuncionario(
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario deleteFuncionario(
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario deleteFuncionario(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchFuncionario(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.fetchFuncionario(funcionarioId);
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario getFuncionario(
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
	* Returns a range of all the funcionarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funcionarios
	* @param end the upper bound of the range of funcionarios (not inclusive)
	* @return the range of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> getFuncionarios(
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario updateFuncionario(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario)
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
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario addFuncionario(
		long companyId, long groupId, long createUserId, java.lang.String nome,
		java.lang.String apelido, java.lang.String observacao,
		java.lang.String rg, java.lang.String rgOrgaoEmissor,
		int rgDataEmissaoMonth, int rgDataEmissaoDay, int rgDataEmissaoYear,
		java.lang.String cpf, java.lang.String sexo,
		java.lang.String estadoCivil, int dataNascimentoMonth,
		int dataNascimentoDay, int dataNascimentoYear,
		java.lang.String endComLogradouro, java.lang.String endComDescricao,
		java.lang.String endComCep, java.lang.String endComBairro,
		java.lang.String endComCidade, java.lang.String endComUf,
		java.lang.String endComPais, java.lang.String endResLogradouro,
		java.lang.String endResDescricao, java.lang.String endResCep,
		java.lang.String endResBairro, java.lang.String endResCidade,
		java.lang.String endResUf, java.lang.String endResPais,
		java.lang.String telComDdd, java.lang.String telComNumero,
		java.lang.String telComRamal, java.lang.String telResDdd,
		java.lang.String telResNumero, java.lang.String telCelDdd,
		java.lang.String telCelNumero, java.lang.String endEmail,
		int dataEntradaMonth, int dataEntradaDay, int dataEntradaYear,
		int dataSaidaMonth, int dataSaidaDay, int dataSaidaYear,
		boolean existeUser, java.lang.String login)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.addFuncionario(companyId, groupId,
			createUserId, nome, apelido, observacao, rg, rgOrgaoEmissor,
			rgDataEmissaoMonth, rgDataEmissaoDay, rgDataEmissaoYear, cpf, sexo,
			estadoCivil, dataNascimentoMonth, dataNascimentoDay,
			dataNascimentoYear, endComLogradouro, endComDescricao, endComCep,
			endComBairro, endComCidade, endComUf, endComPais, endResLogradouro,
			endResDescricao, endResCep, endResBairro, endResCidade, endResUf,
			endResPais, telComDdd, telComNumero, telComRamal, telResDdd,
			telResNumero, telCelDdd, telCelNumero, endEmail, dataEntradaMonth,
			dataEntradaDay, dataEntradaYear, dataSaidaMonth, dataSaidaDay,
			dataSaidaYear, existeUser, login);
	}

	@Override
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario update(
		long funcionarioId, long modifieduserId, java.lang.String nome,
		java.lang.String apelido, java.lang.String observacao,
		java.lang.String rg, java.lang.String rgOrgaoEmissor,
		int rgDataEmissaoMonth, int rgDataEmissaoDay, int rgDataEmissaoYear,
		java.lang.String cpf, java.lang.String sexo,
		java.lang.String estadoCivil, int dataNascimentoMonth,
		int dataNascimentoDay, int dataNascimentoYear,
		java.lang.String endComLogradouro, java.lang.String endComDescricao,
		java.lang.String endComCep, java.lang.String endComBairro,
		java.lang.String endComCidade, java.lang.String endComUf,
		java.lang.String endComPais, java.lang.String endResLogradouro,
		java.lang.String endResDescricao, java.lang.String endResCep,
		java.lang.String endResBairro, java.lang.String endResCidade,
		java.lang.String endResUf, java.lang.String endResPais,
		java.lang.String telComDdd, java.lang.String telComNumero,
		java.lang.String telComRamal, java.lang.String telResDdd,
		java.lang.String telResNumero, java.lang.String telCelDdd,
		java.lang.String telCelNumero, java.lang.String endEmail,
		int dataEntradaMonth, int dataEntradaDay, int dataEntradaYear,
		int dataSaidaMonth, int dataSaidaDay, int dataSaidaYear,
		boolean existeUser, java.lang.String login)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionarioLocalService.update(funcionarioId, modifieduserId,
			nome, apelido, observacao, rg, rgOrgaoEmissor, rgDataEmissaoMonth,
			rgDataEmissaoDay, rgDataEmissaoYear, cpf, sexo, estadoCivil,
			dataNascimentoMonth, dataNascimentoDay, dataNascimentoYear,
			endComLogradouro, endComDescricao, endComCep, endComBairro,
			endComCidade, endComUf, endComPais, endResLogradouro,
			endResDescricao, endResCep, endResBairro, endResCidade, endResUf,
			endResPais, telComDdd, telComNumero, telComRamal, telResDdd,
			telResNumero, telCelDdd, telCelNumero, endEmail, dataEntradaMonth,
			dataEntradaDay, dataEntradaYear, dataSaidaMonth, dataSaidaDay,
			dataSaidaYear, existeUser, login);
	}

	@Override
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> search(
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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> search(
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
	public java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> search(
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