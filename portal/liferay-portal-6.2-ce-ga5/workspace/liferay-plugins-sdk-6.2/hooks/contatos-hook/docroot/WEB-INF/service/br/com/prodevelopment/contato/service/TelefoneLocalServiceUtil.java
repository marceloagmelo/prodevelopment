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
 * Provides the local service utility for Telefone. This utility wraps
 * {@link br.com.prodevelopment.contato.service.impl.TelefoneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see TelefoneLocalService
 * @see br.com.prodevelopment.contato.service.base.TelefoneLocalServiceBaseImpl
 * @see br.com.prodevelopment.contato.service.impl.TelefoneLocalServiceImpl
 * @generated
 */
public class TelefoneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.contato.service.impl.TelefoneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the telefone to the database. Also notifies the appropriate model listeners.
	*
	* @param telefone the telefone
	* @return the telefone that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone addTelefone(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTelefone(telefone);
	}

	/**
	* Creates a new telefone with the primary key. Does not add the telefone to the database.
	*
	* @param telefoneId the primary key for the new telefone
	* @return the new telefone
	*/
	public static br.com.prodevelopment.contato.model.Telefone createTelefone(
		long telefoneId) {
		return getService().createTelefone(telefoneId);
	}

	/**
	* Deletes the telefone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone that was removed
	* @throws PortalException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone deleteTelefone(
		long telefoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTelefone(telefoneId);
	}

	/**
	* Deletes the telefone from the database. Also notifies the appropriate model listeners.
	*
	* @param telefone the telefone
	* @return the telefone that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone deleteTelefone(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTelefone(telefone);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.contato.model.Telefone fetchTelefone(
		long telefoneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTelefone(telefoneId);
	}

	/**
	* Returns the telefone with the matching UUID and company.
	*
	* @param uuid the telefone's UUID
	* @param companyId the primary key of the company
	* @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchTelefoneByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTelefoneByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the telefone matching the UUID and group.
	*
	* @param uuid the telefone's UUID
	* @param groupId the primary key of the group
	* @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone fetchTelefoneByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTelefoneByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the telefone with the primary key.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone
	* @throws PortalException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone getTelefone(
		long telefoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefone(telefoneId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the telefone with the matching UUID and company.
	*
	* @param uuid the telefone's UUID
	* @param companyId the primary key of the company
	* @return the matching telefone
	* @throws PortalException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone getTelefoneByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefoneByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the telefone matching the UUID and group.
	*
	* @param uuid the telefone's UUID
	* @param groupId the primary key of the group
	* @return the matching telefone
	* @throws PortalException if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone getTelefoneByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefoneByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the telefones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of telefones
	* @param end the upper bound of the range of telefones (not inclusive)
	* @return the range of telefones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> getTelefones(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefones(start, end);
	}

	/**
	* Returns the number of telefones.
	*
	* @return the number of telefones
	* @throws SystemException if a system exception occurred
	*/
	public static int getTelefonesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefonesCount();
	}

	/**
	* Updates the telefone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param telefone the telefone
	* @return the telefone that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Telefone updateTelefone(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTelefone(telefone);
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

	public static br.com.prodevelopment.contato.model.Telefone addTelefone(
		long companyId, long groupId, long createUserId,
		java.lang.String className, long classPK, java.lang.String ddi,
		java.lang.String ddd, java.lang.String numero, java.lang.String ramal,
		int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTelefone(companyId, groupId, createUserId, className,
			classPK, ddi, ddd, numero, ramal, tipo, principal);
	}

	public static br.com.prodevelopment.contato.model.Telefone update(
		long telefoneId, long companyId, java.lang.String className,
		long classPK, long modifieduserId, java.lang.String ddi,
		java.lang.String ddd, java.lang.String numero, java.lang.String ramal,
		int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(telefoneId, companyId, className, classPK,
			modifieduserId, ddi, ddd, numero, ramal, tipo, principal);
	}

	public static void updateTelefones(long companyId, long groupId,
		long userId, java.lang.String className, long classPK,
		java.util.List<br.com.prodevelopment.contato.model.Telefone> telefones)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateTelefones(companyId, groupId, userId, className, classPK,
			telefones);
	}

	public static void deleteTelefones(long companyId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTelefones(companyId, className, classPK);
	}

	public static java.util.List<br.com.prodevelopment.contato.model.Telefone> getTelefones(
		long companyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefones(companyId, className, classPK);
	}

	public static br.com.prodevelopment.contato.model.Telefone createTelefone()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createTelefone();
	}

	public static void clearService() {
		_service = null;
	}

	public static TelefoneLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TelefoneLocalService.class.getName());

			if (invokableLocalService instanceof TelefoneLocalService) {
				_service = (TelefoneLocalService)invokableLocalService;
			}
			else {
				_service = new TelefoneLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TelefoneLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TelefoneLocalService service) {
	}

	private static TelefoneLocalService _service;
}