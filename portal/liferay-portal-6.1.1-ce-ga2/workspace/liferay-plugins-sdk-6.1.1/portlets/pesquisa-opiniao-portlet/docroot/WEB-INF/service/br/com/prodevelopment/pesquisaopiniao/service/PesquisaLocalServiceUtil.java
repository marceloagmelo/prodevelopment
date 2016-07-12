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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the pesquisa local service. This utility wraps {@link br.com.prodevelopment.pesquisaopiniao.service.impl.PesquisaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see PesquisaLocalService
 * @see br.com.prodevelopment.pesquisaopiniao.service.base.PesquisaLocalServiceBaseImpl
 * @see br.com.prodevelopment.pesquisaopiniao.service.impl.PesquisaLocalServiceImpl
 * @generated
 */
public class PesquisaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.pesquisaopiniao.service.impl.PesquisaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the pesquisa to the database. Also notifies the appropriate model listeners.
	*
	* @param pesquisa the pesquisa
	* @return the pesquisa that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa addPesquisa(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa pesquisa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPesquisa(pesquisa);
	}

	/**
	* Creates a new pesquisa with the primary key. Does not add the pesquisa to the database.
	*
	* @param id the primary key for the new pesquisa
	* @return the new pesquisa
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa createPesquisa(
		long id) {
		return getService().createPesquisa(id);
	}

	/**
	* Deletes the pesquisa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the pesquisa
	* @return the pesquisa that was removed
	* @throws PortalException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa deletePesquisa(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePesquisa(id);
	}

	/**
	* Deletes the pesquisa from the database. Also notifies the appropriate model listeners.
	*
	* @param pesquisa the pesquisa
	* @return the pesquisa that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa deletePesquisa(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa pesquisa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePesquisa(pesquisa);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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

	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa fetchPesquisa(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPesquisa(id);
	}

	/**
	* Returns the pesquisa with the primary key.
	*
	* @param id the primary key of the pesquisa
	* @return the pesquisa
	* @throws PortalException if a pesquisa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa getPesquisa(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPesquisa(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the pesquisa with the UUID in the group.
	*
	* @param uuid the UUID of pesquisa
	* @param groupId the group id of the pesquisa
	* @return the pesquisa
	* @throws PortalException if a pesquisa with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa getPesquisaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPesquisaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the pesquisas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pesquisas
	* @param end the upper bound of the range of pesquisas (not inclusive)
	* @return the range of pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> getPesquisas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPesquisas(start, end);
	}

	/**
	* Returns the number of pesquisas.
	*
	* @return the number of pesquisas
	* @throws SystemException if a system exception occurred
	*/
	public static int getPesquisasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPesquisasCount();
	}

	/**
	* Updates the pesquisa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pesquisa the pesquisa
	* @return the pesquisa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa updatePesquisa(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa pesquisa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePesquisa(pesquisa);
	}

	/**
	* Updates the pesquisa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pesquisa the pesquisa
	* @param merge whether to merge the pesquisa with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the pesquisa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa updatePesquisa(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa pesquisa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePesquisa(pesquisa, merge);
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

	public static void clearService() {
		_service = null;
	}

	public static PesquisaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PesquisaLocalService.class.getName());

			if (invokableLocalService instanceof PesquisaLocalService) {
				_service = (PesquisaLocalService)invokableLocalService;
			}
			else {
				_service = new PesquisaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PesquisaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PesquisaLocalService service) {
	}

	private static PesquisaLocalService _service;
}