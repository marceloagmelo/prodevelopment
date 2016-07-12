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

package br.com.prodevelopment.academiahorario.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AcademiaHorarioLocalService}.
 *
 * @author Marcelo
 * @see AcademiaHorarioLocalService
 * @generated
 */
public class AcademiaHorarioLocalServiceWrapper
	implements AcademiaHorarioLocalService,
		ServiceWrapper<AcademiaHorarioLocalService> {
	public AcademiaHorarioLocalServiceWrapper(
		AcademiaHorarioLocalService academiaHorarioLocalService) {
		_academiaHorarioLocalService = academiaHorarioLocalService;
	}

	/**
	* Adds the academia horario to the database. Also notifies the appropriate model listeners.
	*
	* @param academiaHorario the academia horario
	* @return the academia horario that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario addAcademiaHorario(
		br.com.prodevelopment.academiahorario.model.AcademiaHorario academiaHorario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.addAcademiaHorario(academiaHorario);
	}

	/**
	* Creates a new academia horario with the primary key. Does not add the academia horario to the database.
	*
	* @param academiaHorarioId the primary key for the new academia horario
	* @return the new academia horario
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario createAcademiaHorario(
		long academiaHorarioId) {
		return _academiaHorarioLocalService.createAcademiaHorario(academiaHorarioId);
	}

	/**
	* Deletes the academia horario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param academiaHorarioId the primary key of the academia horario
	* @return the academia horario that was removed
	* @throws PortalException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario deleteAcademiaHorario(
		long academiaHorarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.deleteAcademiaHorario(academiaHorarioId);
	}

	/**
	* Deletes the academia horario from the database. Also notifies the appropriate model listeners.
	*
	* @param academiaHorario the academia horario
	* @return the academia horario that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario deleteAcademiaHorario(
		br.com.prodevelopment.academiahorario.model.AcademiaHorario academiaHorario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.deleteAcademiaHorario(academiaHorario);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _academiaHorarioLocalService.dynamicQuery();
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
		return _academiaHorarioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _academiaHorarioLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _academiaHorarioLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _academiaHorarioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _academiaHorarioLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchAcademiaHorario(
		long academiaHorarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.fetchAcademiaHorario(academiaHorarioId);
	}

	/**
	* Returns the academia horario with the matching UUID and company.
	*
	* @param uuid the academia horario's UUID
	* @param companyId the primary key of the company
	* @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchAcademiaHorarioByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.fetchAcademiaHorarioByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the academia horario matching the UUID and group.
	*
	* @param uuid the academia horario's UUID
	* @param groupId the primary key of the group
	* @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario fetchAcademiaHorarioByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.fetchAcademiaHorarioByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the academia horario with the primary key.
	*
	* @param academiaHorarioId the primary key of the academia horario
	* @return the academia horario
	* @throws PortalException if a academia horario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario getAcademiaHorario(
		long academiaHorarioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.getAcademiaHorario(academiaHorarioId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the academia horario with the matching UUID and company.
	*
	* @param uuid the academia horario's UUID
	* @param companyId the primary key of the company
	* @return the matching academia horario
	* @throws PortalException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario getAcademiaHorarioByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.getAcademiaHorarioByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the academia horario matching the UUID and group.
	*
	* @param uuid the academia horario's UUID
	* @param groupId the primary key of the group
	* @return the matching academia horario
	* @throws PortalException if a matching academia horario could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario getAcademiaHorarioByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.getAcademiaHorarioByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the academia horarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of academia horarios
	* @param end the upper bound of the range of academia horarios (not inclusive)
	* @return the range of academia horarios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> getAcademiaHorarios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.getAcademiaHorarios(start, end);
	}

	/**
	* Returns the number of academia horarios.
	*
	* @return the number of academia horarios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAcademiaHorariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.getAcademiaHorariosCount();
	}

	/**
	* Updates the academia horario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param academiaHorario the academia horario
	* @return the academia horario that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario updateAcademiaHorario(
		br.com.prodevelopment.academiahorario.model.AcademiaHorario academiaHorario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.updateAcademiaHorario(academiaHorario);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _academiaHorarioLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_academiaHorarioLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _academiaHorarioLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario addAcademiaHorario(
		long companyId, long groupId, long createUserId, int diaSemana,
		java.lang.String horaInicial, java.lang.String horaFinal,
		long atividadeId, double versao,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _academiaHorarioLocalService.addAcademiaHorario(companyId,
			groupId, createUserId, diaSemana, horaInicial, horaFinal,
			atividadeId, versao, serviceContext);
	}

	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario update(
		long academiaHorarioId, long modifieduserId, int diaSemana,
		java.lang.String horaInicial, java.lang.String horaFinal,
		long atividadeId, double versao,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _academiaHorarioLocalService.update(academiaHorarioId,
			modifieduserId, diaSemana, horaInicial, horaFinal, atividadeId,
			versao, serviceContext);
	}

	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario deleteAcademiaHorario(
		br.com.prodevelopment.academiahorario.model.AcademiaHorario academiaHorario,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.deleteAcademiaHorario(academiaHorario,
			userId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.search(companyId, groupId, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.searchCount(companyId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> searchByAcademia(
		long companyId, long atividadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.searchByAcademia(companyId,
			atividadeId, start, end, orderByComparator);
	}

	@Override
	public int searchByAcademiaCount(long companyId, long atividadeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.searchByAcademiaCount(companyId,
			atividadeId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<br.com.prodevelopment.academiahorario.model.AcademiaHorario> searchByAcademia(
		long companyId, long groupId, long atividadeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.searchByAcademia(companyId,
			groupId, atividadeId, start, end, orderByComparator);
	}

	@Override
	public int searchByAcademiaCount(long companyId, long atividadeId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.searchByAcademiaCount(companyId,
			atividadeId, groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List search(long companyId, long groupId, int diaDaSemana,
		long atividadeId, boolean andSearch, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.search(companyId, groupId,
			diaDaSemana, atividadeId, andSearch, start, end);
	}

	@Override
	public int searchCount(long companyId, long groupId, int diaDaSemana,
		long atividadeId, boolean andSearch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.searchCount(companyId, groupId,
			diaDaSemana, atividadeId, andSearch);
	}

	@Override
	public java.util.List search(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.search(companyId, groupId);
	}

	@Override
	public java.util.List recuperarHorariosPorAtividade(long atividadeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorarioLocalService.recuperarHorariosPorAtividade(atividadeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AcademiaHorarioLocalService getWrappedAcademiaHorarioLocalService() {
		return _academiaHorarioLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAcademiaHorarioLocalService(
		AcademiaHorarioLocalService academiaHorarioLocalService) {
		_academiaHorarioLocalService = academiaHorarioLocalService;
	}

	@Override
	public AcademiaHorarioLocalService getWrappedService() {
		return _academiaHorarioLocalService;
	}

	@Override
	public void setWrappedService(
		AcademiaHorarioLocalService academiaHorarioLocalService) {
		_academiaHorarioLocalService = academiaHorarioLocalService;
	}

	private AcademiaHorarioLocalService _academiaHorarioLocalService;
}