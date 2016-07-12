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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Atividade. This utility wraps
 * {@link br.com.prodevelopment.atividade.service.impl.AtividadeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo
 * @see AtividadeLocalService
 * @see br.com.prodevelopment.atividade.service.base.AtividadeLocalServiceBaseImpl
 * @see br.com.prodevelopment.atividade.service.impl.AtividadeLocalServiceImpl
 * @generated
 */
public class AtividadeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.atividade.service.impl.AtividadeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the atividade to the database. Also notifies the appropriate model listeners.
	*
	* @param atividade the atividade
	* @return the atividade that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade addAtividade(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAtividade(atividade);
	}

	/**
	* Creates a new atividade with the primary key. Does not add the atividade to the database.
	*
	* @param atividadeId the primary key for the new atividade
	* @return the new atividade
	*/
	public static br.com.prodevelopment.atividade.model.Atividade createAtividade(
		long atividadeId) {
		return getService().createAtividade(atividadeId);
	}

	/**
	* Deletes the atividade with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade that was removed
	* @throws PortalException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade deleteAtividade(
		long atividadeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAtividade(atividadeId);
	}

	/**
	* Deletes the atividade from the database. Also notifies the appropriate model listeners.
	*
	* @param atividade the atividade
	* @return the atividade that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade deleteAtividade(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAtividade(atividade);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.atividade.model.Atividade fetchAtividade(
		long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAtividade(atividadeId);
	}

	/**
	* Returns the atividade with the matching UUID and company.
	*
	* @param uuid the atividade's UUID
	* @param companyId the primary key of the company
	* @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchAtividadeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAtividadeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the atividade matching the UUID and group.
	*
	* @param uuid the atividade's UUID
	* @param groupId the primary key of the group
	* @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade fetchAtividadeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAtividadeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the atividade with the primary key.
	*
	* @param atividadeId the primary key of the atividade
	* @return the atividade
	* @throws PortalException if a atividade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade getAtividade(
		long atividadeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAtividade(atividadeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static br.com.prodevelopment.atividade.model.Atividade getAtividadeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAtividadeByUuidAndCompanyId(uuid, companyId);
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
	public static br.com.prodevelopment.atividade.model.Atividade getAtividadeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAtividadeByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> getAtividades(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAtividades(start, end);
	}

	/**
	* Returns the number of atividades.
	*
	* @return the number of atividades
	* @throws SystemException if a system exception occurred
	*/
	public static int getAtividadesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAtividadesCount();
	}

	/**
	* Updates the atividade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param atividade the atividade
	* @return the atividade that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.atividade.model.Atividade updateAtividade(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAtividade(atividade);
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

	public static br.com.prodevelopment.atividade.model.Atividade addAtividade(
		long companyId, long groupId, long createUserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		boolean existeImagem, java.io.InputStream streamImagem, double versao,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .addAtividade(companyId, groupId, createUserId, nomeMap,
			descricaoMap, existeImagem, streamImagem, versao, serviceContext);
	}

	public static br.com.prodevelopment.atividade.model.Atividade update(
		long atividadeId, long modifieduserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		boolean existeImagem, java.io.InputStream streamImagem, double versao,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .update(atividadeId, modifieduserId, nomeMap, descricaoMap,
			existeImagem, streamImagem, versao, serviceContext);
	}

	public static void updateAsset(long userId,
		br.com.prodevelopment.atividade.model.Atividade atividade,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, atividade, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static br.com.prodevelopment.atividade.model.Atividade deleteAtividade(
		br.com.prodevelopment.atividade.model.Atividade atividade, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAtividade(atividade, userId);
	}

	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> search(
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

	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> search(
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

	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> search(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, nome, start, end, orderByComparator);
	}

	public static int searchCount(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, nome);
	}

	public static java.util.List<br.com.prodevelopment.atividade.model.Atividade> search(
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

	public static AtividadeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AtividadeLocalService.class.getName());

			if (invokableLocalService instanceof AtividadeLocalService) {
				_service = (AtividadeLocalService)invokableLocalService;
			}
			else {
				_service = new AtividadeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AtividadeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AtividadeLocalService service) {
	}

	private static AtividadeLocalService _service;
}