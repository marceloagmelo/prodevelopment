/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.prodevelopment.contato.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EnderecoLocalService}.
 *
 * @author Marcelo Melo
 * @see EnderecoLocalService
 * @generated
 */
public class EnderecoLocalServiceWrapper implements EnderecoLocalService,
	ServiceWrapper<EnderecoLocalService> {
	public EnderecoLocalServiceWrapper(
		EnderecoLocalService enderecoLocalService) {
		_enderecoLocalService = enderecoLocalService;
	}

	/**
	* Adds the endereco to the database. Also notifies the appropriate model listeners.
	*
	* @param endereco the endereco
	* @return the endereco that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco addEndereco(
		br.com.prodevelopment.contato.model.Endereco endereco)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.addEndereco(endereco);
	}

	/**
	* Creates a new endereco with the primary key. Does not add the endereco to the database.
	*
	* @param enderecoId the primary key for the new endereco
	* @return the new endereco
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco createEndereco(
		long enderecoId) {
		return _enderecoLocalService.createEndereco(enderecoId);
	}

	/**
	* Deletes the endereco with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco that was removed
	* @throws PortalException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco deleteEndereco(
		long enderecoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.deleteEndereco(enderecoId);
	}

	/**
	* Deletes the endereco from the database. Also notifies the appropriate model listeners.
	*
	* @param endereco the endereco
	* @return the endereco that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco deleteEndereco(
		br.com.prodevelopment.contato.model.Endereco endereco)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.deleteEndereco(endereco);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _enderecoLocalService.dynamicQuery();
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
		return _enderecoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _enderecoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _enderecoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _enderecoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _enderecoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.contato.model.Endereco fetchEndereco(
		long enderecoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.fetchEndereco(enderecoId);
	}

	/**
	* Returns the endereco with the matching UUID and company.
	*
	* @param uuid the endereco's UUID
	* @param companyId the primary key of the company
	* @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco fetchEnderecoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.fetchEnderecoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the endereco matching the UUID and group.
	*
	* @param uuid the endereco's UUID
	* @param groupId the primary key of the group
	* @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco fetchEnderecoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.fetchEnderecoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the endereco with the primary key.
	*
	* @param enderecoId the primary key of the endereco
	* @return the endereco
	* @throws PortalException if a endereco with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco getEndereco(
		long enderecoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.getEndereco(enderecoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the endereco with the matching UUID and company.
	*
	* @param uuid the endereco's UUID
	* @param companyId the primary key of the company
	* @return the matching endereco
	* @throws PortalException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco getEnderecoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.getEnderecoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the endereco matching the UUID and group.
	*
	* @param uuid the endereco's UUID
	* @param groupId the primary key of the group
	* @return the matching endereco
	* @throws PortalException if a matching endereco could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco getEnderecoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.getEnderecoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the enderecos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enderecos
	* @param end the upper bound of the range of enderecos (not inclusive)
	* @return the range of enderecos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> getEnderecos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.getEnderecos(start, end);
	}

	/**
	* Returns the number of enderecos.
	*
	* @return the number of enderecos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEnderecosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.getEnderecosCount();
	}

	/**
	* Updates the endereco in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param endereco the endereco
	* @return the endereco that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Endereco updateEndereco(
		br.com.prodevelopment.contato.model.Endereco endereco)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.updateEndereco(endereco);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _enderecoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_enderecoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _enderecoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.contato.model.Endereco addEndereco(
		long companyId, long groupId, long createUserId,
		java.lang.String className, long classPK, java.lang.String logradouro,
		java.lang.String numero, java.lang.String complemento,
		java.lang.String cep, java.lang.String bairro, long cidadeId,
		java.lang.String uf, long paisId, int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.addEndereco(companyId, groupId,
			createUserId, className, classPK, logradouro, numero, complemento,
			cep, bairro, cidadeId, uf, paisId, tipo, principal);
	}

	@Override
	public br.com.prodevelopment.contato.model.Endereco update(
		long enderecoId, long companyId, java.lang.String className,
		long classPK, long modifieduserId, java.lang.String logradouro,
		java.lang.String numero, java.lang.String complemento,
		java.lang.String cep, java.lang.String bairro, long cidadeId,
		java.lang.String uf, long paisId, int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.update(enderecoId, companyId, className,
			classPK, modifieduserId, logradouro, numero, complemento, cep,
			bairro, cidadeId, uf, paisId, tipo, principal);
	}

	@Override
	public void updateEnderecos(long companyId, long groupId, long userId,
		java.lang.String className, long classPK,
		java.util.List<br.com.prodevelopment.contato.model.Endereco> enderecos)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_enderecoLocalService.updateEnderecos(companyId, groupId, userId,
			className, classPK, enderecos);
	}

	@Override
	public void deleteEnderecos(long companyId, java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		_enderecoLocalService.deleteEnderecos(companyId, className, classPK);
	}

	@Override
	public java.util.List<br.com.prodevelopment.contato.model.Endereco> getEnderecos(
		long companyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.getEnderecos(companyId, className, classPK);
	}

	@Override
	public br.com.prodevelopment.contato.model.Endereco createEndereco()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoLocalService.createEndereco();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EnderecoLocalService getWrappedEnderecoLocalService() {
		return _enderecoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEnderecoLocalService(
		EnderecoLocalService enderecoLocalService) {
		_enderecoLocalService = enderecoLocalService;
	}

	@Override
	public EnderecoLocalService getWrappedService() {
		return _enderecoLocalService;
	}

	@Override
	public void setWrappedService(EnderecoLocalService enderecoLocalService) {
		_enderecoLocalService = enderecoLocalService;
	}

	private EnderecoLocalService _enderecoLocalService;
}