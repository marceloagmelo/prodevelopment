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
 * Provides a wrapper for {@link TelefoneLocalService}.
 *
 * @author Marcelo Melo
 * @see TelefoneLocalService
 * @generated
 */
public class TelefoneLocalServiceWrapper implements TelefoneLocalService,
	ServiceWrapper<TelefoneLocalService> {
	public TelefoneLocalServiceWrapper(
		TelefoneLocalService telefoneLocalService) {
		_telefoneLocalService = telefoneLocalService;
	}

	/**
	* Adds the telefone to the database. Also notifies the appropriate model listeners.
	*
	* @param telefone the telefone
	* @return the telefone that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Telefone addTelefone(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.addTelefone(telefone);
	}

	/**
	* Creates a new telefone with the primary key. Does not add the telefone to the database.
	*
	* @param telefoneId the primary key for the new telefone
	* @return the new telefone
	*/
	@Override
	public br.com.prodevelopment.contato.model.Telefone createTelefone(
		long telefoneId) {
		return _telefoneLocalService.createTelefone(telefoneId);
	}

	/**
	* Deletes the telefone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone that was removed
	* @throws PortalException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Telefone deleteTelefone(
		long telefoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.deleteTelefone(telefoneId);
	}

	/**
	* Deletes the telefone from the database. Also notifies the appropriate model listeners.
	*
	* @param telefone the telefone
	* @return the telefone that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Telefone deleteTelefone(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.deleteTelefone(telefone);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _telefoneLocalService.dynamicQuery();
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
		return _telefoneLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _telefoneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _telefoneLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.contato.model.Telefone fetchTelefone(
		long telefoneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.fetchTelefone(telefoneId);
	}

	/**
	* Returns the telefone with the matching UUID and company.
	*
	* @param uuid the telefone's UUID
	* @param companyId the primary key of the company
	* @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Telefone fetchTelefoneByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.fetchTelefoneByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the telefone matching the UUID and group.
	*
	* @param uuid the telefone's UUID
	* @param groupId the primary key of the group
	* @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Telefone fetchTelefoneByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.fetchTelefoneByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the telefone with the primary key.
	*
	* @param telefoneId the primary key of the telefone
	* @return the telefone
	* @throws PortalException if a telefone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Telefone getTelefone(
		long telefoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.getTelefone(telefoneId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public br.com.prodevelopment.contato.model.Telefone getTelefoneByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.getTelefoneByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public br.com.prodevelopment.contato.model.Telefone getTelefoneByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.getTelefoneByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> getTelefones(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.getTelefones(start, end);
	}

	/**
	* Returns the number of telefones.
	*
	* @return the number of telefones
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTelefonesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.getTelefonesCount();
	}

	/**
	* Updates the telefone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param telefone the telefone
	* @return the telefone that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.contato.model.Telefone updateTelefone(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.updateTelefone(telefone);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _telefoneLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_telefoneLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _telefoneLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.contato.model.Telefone addTelefone(
		long companyId, long groupId, long createUserId,
		java.lang.String className, long classPK, java.lang.String ddi,
		java.lang.String ddd, java.lang.String numero, java.lang.String ramal,
		int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.addTelefone(companyId, groupId,
			createUserId, className, classPK, ddi, ddd, numero, ramal, tipo,
			principal);
	}

	@Override
	public br.com.prodevelopment.contato.model.Telefone update(
		long telefoneId, long companyId, java.lang.String className,
		long classPK, long modifieduserId, java.lang.String ddi,
		java.lang.String ddd, java.lang.String numero, java.lang.String ramal,
		int tipo, boolean principal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.update(telefoneId, companyId, className,
			classPK, modifieduserId, ddi, ddd, numero, ramal, tipo, principal);
	}

	@Override
	public void updateTelefones(long companyId, long groupId, long userId,
		java.lang.String className, long classPK,
		java.util.List<br.com.prodevelopment.contato.model.Telefone> telefones)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_telefoneLocalService.updateTelefones(companyId, groupId, userId,
			className, classPK, telefones);
	}

	@Override
	public void deleteTelefones(long companyId, java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		_telefoneLocalService.deleteTelefones(companyId, className, classPK);
	}

	@Override
	public java.util.List<br.com.prodevelopment.contato.model.Telefone> getTelefones(
		long companyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.getTelefones(companyId, className, classPK);
	}

	@Override
	public br.com.prodevelopment.contato.model.Telefone createTelefone()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefoneLocalService.createTelefone();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TelefoneLocalService getWrappedTelefoneLocalService() {
		return _telefoneLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTelefoneLocalService(
		TelefoneLocalService telefoneLocalService) {
		_telefoneLocalService = telefoneLocalService;
	}

	@Override
	public TelefoneLocalService getWrappedService() {
		return _telefoneLocalService;
	}

	@Override
	public void setWrappedService(TelefoneLocalService telefoneLocalService) {
		_telefoneLocalService = telefoneLocalService;
	}

	private TelefoneLocalService _telefoneLocalService;
}