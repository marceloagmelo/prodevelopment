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
 * Provides the local service utility for EnderecoEmail. This utility wraps
 * {@link br.com.prodevelopment.contato.service.impl.EnderecoEmailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author marcelo
 * @see EnderecoEmailLocalService
 * @see br.com.prodevelopment.contato.service.base.EnderecoEmailLocalServiceBaseImpl
 * @see br.com.prodevelopment.contato.service.impl.EnderecoEmailLocalServiceImpl
 * @generated
 */
public class EnderecoEmailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.contato.service.impl.EnderecoEmailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the endereco email to the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoEmail the endereco email
	* @return the endereco email that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail addEnderecoEmail(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEnderecoEmail(enderecoEmail);
	}

	/**
	* Creates a new endereco email with the primary key. Does not add the endereco email to the database.
	*
	* @param enderecoEmailId the primary key for the new endereco email
	* @return the new endereco email
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail createEnderecoEmail(
		long enderecoEmailId) {
		return getService().createEnderecoEmail(enderecoEmailId);
	}

	/**
	* Deletes the endereco email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoEmailId the primary key of the endereco email
	* @return the endereco email that was removed
	* @throws PortalException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail deleteEnderecoEmail(
		long enderecoEmailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEnderecoEmail(enderecoEmailId);
	}

	/**
	* Deletes the endereco email from the database. Also notifies the appropriate model listeners.
	*
	* @param enderecoEmail the endereco email
	* @return the endereco email that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail deleteEnderecoEmail(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEnderecoEmail(enderecoEmail);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchEnderecoEmail(
		long enderecoEmailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEnderecoEmail(enderecoEmailId);
	}

	/**
	* Returns the endereco email with the matching UUID and company.
	*
	* @param uuid the endereco email's UUID
	* @param companyId the primary key of the company
	* @return the matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchEnderecoEmailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEnderecoEmailByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the endereco email matching the UUID and group.
	*
	* @param uuid the endereco email's UUID
	* @param groupId the primary key of the group
	* @return the matching endereco email, or <code>null</code> if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail fetchEnderecoEmailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEnderecoEmailByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the endereco email with the primary key.
	*
	* @param enderecoEmailId the primary key of the endereco email
	* @return the endereco email
	* @throws PortalException if a endereco email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail getEnderecoEmail(
		long enderecoEmailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecoEmail(enderecoEmailId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the endereco email with the matching UUID and company.
	*
	* @param uuid the endereco email's UUID
	* @param companyId the primary key of the company
	* @return the matching endereco email
	* @throws PortalException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail getEnderecoEmailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecoEmailByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the endereco email matching the UUID and group.
	*
	* @param uuid the endereco email's UUID
	* @param groupId the primary key of the group
	* @return the matching endereco email
	* @throws PortalException if a matching endereco email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail getEnderecoEmailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecoEmailByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the endereco emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of endereco emails
	* @param end the upper bound of the range of endereco emails (not inclusive)
	* @return the range of endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> getEnderecoEmails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecoEmails(start, end);
	}

	/**
	* Returns the number of endereco emails.
	*
	* @return the number of endereco emails
	* @throws SystemException if a system exception occurred
	*/
	public static int getEnderecoEmailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecoEmailsCount();
	}

	/**
	* Updates the endereco email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param enderecoEmail the endereco email
	* @return the endereco email that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.EnderecoEmail updateEnderecoEmail(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEnderecoEmail(enderecoEmail);
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

	public static br.com.prodevelopment.contato.model.EnderecoEmail addEnderecoEmail(
		long companyId, long groupId, long createUserId,
		java.lang.String className, long classPK, java.lang.String endereco,
		int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEnderecoEmail(companyId, groupId, createUserId,
			className, classPK, endereco, tipo, principal);
	}

	public static br.com.prodevelopment.contato.model.EnderecoEmail update(
		long enderecoEmailId, long companyId, java.lang.String className,
		long classPK, long modifieduserId, java.lang.String endereco, int tipo,
		boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(enderecoEmailId, companyId, className, classPK,
			modifieduserId, endereco, tipo, principal);
	}

	public static void updateEnderecosEmail(long companyId, long groupId,
		long userId, java.lang.String className, long classPK,
		java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> enderecosEmail)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateEnderecosEmail(companyId, groupId, userId, className,
			classPK, enderecosEmail);
	}

	public static void deleteEnderecosEmail(long companyId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEnderecosEmail(companyId, className, classPK);
	}

	public static java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail> getEnderecosEmail(
		long companyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnderecosEmail(companyId, className, classPK);
	}

	public static br.com.prodevelopment.contato.model.EnderecoEmail createEnderecoEmail()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createEnderecoEmail();
	}

	public static void clearService() {
		_service = null;
	}

	public static EnderecoEmailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EnderecoEmailLocalService.class.getName());

			if (invokableLocalService instanceof EnderecoEmailLocalService) {
				_service = (EnderecoEmailLocalService)invokableLocalService;
			}
			else {
				_service = new EnderecoEmailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EnderecoEmailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EnderecoEmailLocalService service) {
	}

	private static EnderecoEmailLocalService _service;
}