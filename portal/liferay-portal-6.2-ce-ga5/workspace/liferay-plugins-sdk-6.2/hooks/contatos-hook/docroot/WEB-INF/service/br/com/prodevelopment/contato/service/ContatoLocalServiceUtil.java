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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Contato. This utility wraps
 * {@link br.com.prodevelopment.contato.service.impl.ContatoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see ContatoLocalService
 * @see br.com.prodevelopment.contato.service.base.ContatoLocalServiceBaseImpl
 * @see br.com.prodevelopment.contato.service.impl.ContatoLocalServiceImpl
 * @generated
 */
public class ContatoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.contato.service.impl.ContatoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contato to the database. Also notifies the appropriate model listeners.
	*
	* @param contato the contato
	* @return the contato that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato addContato(
		br.com.prodevelopment.contato.model.Contato contato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContato(contato);
	}

	/**
	* Creates a new contato with the primary key. Does not add the contato to the database.
	*
	* @param contatoId the primary key for the new contato
	* @return the new contato
	*/
	public static br.com.prodevelopment.contato.model.Contato createContato(
		long contatoId) {
		return getService().createContato(contatoId);
	}

	/**
	* Deletes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contatoId the primary key of the contato
	* @return the contato that was removed
	* @throws PortalException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato deleteContato(
		long contatoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContato(contatoId);
	}

	/**
	* Deletes the contato from the database. Also notifies the appropriate model listeners.
	*
	* @param contato the contato
	* @return the contato that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato deleteContato(
		br.com.prodevelopment.contato.model.Contato contato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContato(contato);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.contato.model.Contato fetchContato(
		long contatoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContato(contatoId);
	}

	/**
	* Returns the contato with the primary key.
	*
	* @param contatoId the primary key of the contato
	* @return the contato
	* @throws PortalException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato getContato(
		long contatoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContato(contatoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> getContatos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContatos(start, end);
	}

	/**
	* Returns the number of contatos.
	*
	* @return the number of contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int getContatosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContatosCount();
	}

	/**
	* Updates the contato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contato the contato
	* @return the contato that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato updateContato(
		br.com.prodevelopment.contato.model.Contato contato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContato(contato);
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

	public static br.com.prodevelopment.contato.model.Contato addContato(
		long companyId, long groupId, long createUserId,
		java.lang.String className, long classPK, java.lang.String nome,
		java.lang.String endEmail, java.lang.String sexo,
		java.lang.String dataNascimento, long cargoId, java.lang.String skype,
		java.lang.String facebook, java.lang.String twitter)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addContato(companyId, groupId, createUserId, className,
			classPK, nome, endEmail, sexo, dataNascimento, cargoId, skype,
			facebook, twitter);
	}

	public static br.com.prodevelopment.contato.model.Contato update(
		long contatoId, long modifieduserId, java.lang.String nome,
		java.lang.String endEmail, java.lang.String sexo,
		java.lang.String dataNascimento, long cargoId, java.lang.String skype,
		java.lang.String facebook, java.lang.String twitter)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(contatoId, modifieduserId, nome, endEmail, sexo,
			dataNascimento, cargoId, skype, facebook, twitter);
	}

	public static java.util.List<br.com.prodevelopment.contato.model.Contato> search(
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

	public static java.util.List<br.com.prodevelopment.contato.model.Contato> search(
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

	public static br.com.prodevelopment.contato.model.Contato findByContato(
		long classNameId, long classPK)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByContato(classNameId, classPK);
	}

	public static br.com.prodevelopment.contato.model.Contato createContato()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createContato();
	}

	public static void clearService() {
		_service = null;
	}

	public static ContatoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContatoLocalService.class.getName());

			if (invokableLocalService instanceof ContatoLocalService) {
				_service = (ContatoLocalService)invokableLocalService;
			}
			else {
				_service = new ContatoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContatoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ContatoLocalService service) {
	}

	private static ContatoLocalService _service;
}