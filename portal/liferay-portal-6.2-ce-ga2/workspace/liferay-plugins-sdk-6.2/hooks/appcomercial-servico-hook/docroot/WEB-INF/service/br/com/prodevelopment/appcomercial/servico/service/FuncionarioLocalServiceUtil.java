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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Funcionario. This utility wraps
 * {@link br.com.prodevelopment.appcomercial.servico.service.impl.FuncionarioLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author marcelo
 * @see FuncionarioLocalService
 * @see br.com.prodevelopment.appcomercial.servico.service.base.FuncionarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.appcomercial.servico.service.impl.FuncionarioLocalServiceImpl
 * @generated
 */
public class FuncionarioLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.appcomercial.servico.service.impl.FuncionarioLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the funcionario to the database. Also notifies the appropriate model listeners.
	*
	* @param funcionario the funcionario
	* @return the funcionario that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario addFuncionario(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFuncionario(funcionario);
	}

	/**
	* Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	*
	* @param funcionarioId the primary key for the new funcionario
	* @return the new funcionario
	*/
	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario createFuncionario(
		long funcionarioId) {
		return getService().createFuncionario(funcionarioId);
	}

	/**
	* Deletes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario that was removed
	* @throws PortalException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario deleteFuncionario(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFuncionario(funcionarioId);
	}

	/**
	* Deletes the funcionario from the database. Also notifies the appropriate model listeners.
	*
	* @param funcionario the funcionario
	* @return the funcionario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario deleteFuncionario(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFuncionario(funcionario);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.appcomercial.servico.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario fetchFuncionario(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFuncionario(funcionarioId);
	}

	/**
	* Returns the funcionario with the primary key.
	*
	* @param funcionarioId the primary key of the funcionario
	* @return the funcionario
	* @throws PortalException if a funcionario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario getFuncionario(
		long funcionarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFuncionario(funcionarioId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> getFuncionarios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFuncionarios(start, end);
	}

	/**
	* Returns the number of funcionarios.
	*
	* @return the number of funcionarios
	* @throws SystemException if a system exception occurred
	*/
	public static int getFuncionariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFuncionariosCount();
	}

	/**
	* Updates the funcionario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param funcionario the funcionario
	* @return the funcionario that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario updateFuncionario(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFuncionario(funcionario);
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

	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario addFuncionario(
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
		return getService()
				   .addFuncionario(companyId, groupId, createUserId, nome,
			apelido, observacao, rg, rgOrgaoEmissor, rgDataEmissaoMonth,
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

	public static br.com.prodevelopment.appcomercial.servico.model.Funcionario update(
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
		return getService()
				   .update(funcionarioId, modifieduserId, nome, apelido,
			observacao, rg, rgOrgaoEmissor, rgDataEmissaoMonth,
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

	public static java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, nome, start, end,
			orderByComparator);
	}

	public static int searchCount(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, groupId, nome);
	}

	public static java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, start, end, orderByComparator);
	}

	public static int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, groupId);
	}

	public static java.util.List<br.com.prodevelopment.appcomercial.servico.model.Funcionario> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().search(companyId, start, end, orderByComparator);
	}

	public static int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static FuncionarioLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FuncionarioLocalService.class.getName());

			if (invokableLocalService instanceof FuncionarioLocalService) {
				_service = (FuncionarioLocalService)invokableLocalService;
			}
			else {
				_service = new FuncionarioLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FuncionarioLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FuncionarioLocalService service) {
	}

	private static FuncionarioLocalService _service;
}