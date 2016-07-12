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

package br.com.prodevelopment.atividade.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AtividadeLocalService}.
 *
 * @author Marcelo
 * @see AtividadeLocalService
 * @generated
 */
public class AtividadeLocalServiceWrapper implements AtividadeLocalService,
	ServiceWrapper<AtividadeLocalService> {
	public AtividadeLocalServiceWrapper(
		AtividadeLocalService atividadeLocalService) {
		_atividadeLocalService = atividadeLocalService;
	}

	/**
	* Adds the atividade to the database. Also notifies the appropriate model listeners.
	*
	* @param atividade the atividade
	* @return the atividade that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade addAtividade(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.addAtividade(atividade);
	}

	/**
	* Creates a new atividade with the primary key. Does not add the atividade to the database.
	*
	* @param atividadeId the primary key for the new atividade
	* @return the new atividade
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade createAtividade(
		long atividadeId) {
		return _atividadeLocalService.createAtividade(atividadeId);
	}

	/**
	* Deletes the atividade with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade that was removed
	* @throws PortalException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade deleteAtividade(
		long atividadeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.deleteAtividade(atividadeId);
	}

	/**
	* Deletes the atividade from the database. Also notifies the appropriate model listeners.
	*
	* @param atividade the atividade
	* @return the atividade that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade deleteAtividade(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.deleteAtividade(atividade);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _atividadeLocalService.dynamicQuery();
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
		return _atividadeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _atividadeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _atividadeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _atividadeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _atividadeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.atividade.model.Atividade fetchAtividade(
		long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.fetchAtividade(atividadeId);
	}

	/**
	* Returns the atividade with the matching UUID and company.
	*
	* @param uuid the atividade's UUID
	* @param companyId the primary key of the company
	* @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade fetchAtividadeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.fetchAtividadeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the atividade matching the UUID and group.
	*
	* @param uuid the atividade's UUID
	* @param groupId the primary key of the group
	* @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade fetchAtividadeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.fetchAtividadeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the atividade with the primary key.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade
	* @throws PortalException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade getAtividade(
		long atividadeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.getAtividade(atividadeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the atividade with the matching UUID and company.
	*
	* @param uuid the atividade's UUID
	* @param companyId the primary key of the company
	* @return the matching atividade
	* @throws PortalException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade getAtividadeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.getAtividadeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the atividade matching the UUID and group.
	*
	* @param uuid the atividade's UUID
	* @param groupId the primary key of the group
	* @return the matching atividade
	* @throws PortalException if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade getAtividadeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.getAtividadeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the atividades.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of atividades
	* @param end the upper bound of the range of atividades (not inclusive)
	* @return the range of atividades
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> getAtividades(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.getAtividades(start, end);
	}

	/**
	* Returns the number of atividades.
	*
	* @return the number of atividades
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAtividadesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.getAtividadesCount();
	}

	/**
	* Updates the atividade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param atividade the atividade
	* @return the atividade that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.atividade.model.Atividade updateAtividade(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.updateAtividade(atividade);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _atividadeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_atividadeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _atividadeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.atividade.model.Atividade addAtividade(
		long companyId, long groupId, long createUserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		boolean existeImagem, java.io.InputStream streamImagem, double versao,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _atividadeLocalService.addAtividade(companyId, groupId,
			createUserId, nomeMap, descricaoMap, existeImagem, streamImagem,
			versao, serviceContext);
	}

	@Override
	public br.com.prodevelopment.atividade.model.Atividade update(
		long atividadeId, long modifieduserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		boolean existeImagem, java.io.InputStream streamImagem, double versao,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _atividadeLocalService.update(atividadeId, modifieduserId,
			nomeMap, descricaoMap, existeImagem, streamImagem, versao,
			serviceContext);
	}

	@Override
	public void updateAsset(long userId,
		br.com.prodevelopment.atividade.model.Atividade atividade,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_atividadeLocalService.updateAsset(userId, atividade, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	@Override
	public br.com.prodevelopment.atividade.model.Atividade deleteAtividade(
		br.com.prodevelopment.atividade.model.Atividade atividade, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.deleteAtividade(atividade, userId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.search(companyId, groupId, nome, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.searchCount(companyId, groupId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> search(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.search(companyId, nome, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.searchCount(companyId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.atividade.model.Atividade> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividadeLocalService.searchCount(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AtividadeLocalService getWrappedAtividadeLocalService() {
		return _atividadeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAtividadeLocalService(
		AtividadeLocalService atividadeLocalService) {
		_atividadeLocalService = atividadeLocalService;
	}

	@Override
	public AtividadeLocalService getWrappedService() {
		return _atividadeLocalService;
	}

	@Override
	public void setWrappedService(AtividadeLocalService atividadeLocalService) {
		_atividadeLocalService = atividadeLocalService;
	}

	private AtividadeLocalService _atividadeLocalService;
}