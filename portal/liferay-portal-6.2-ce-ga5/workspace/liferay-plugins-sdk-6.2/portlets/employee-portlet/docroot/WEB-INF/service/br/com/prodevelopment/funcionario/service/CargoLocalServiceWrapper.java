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

package br.com.prodevelopment.funcionario.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CargoLocalService}.
 *
 * @author Marcelo Melo
 * @see CargoLocalService
 * @generated
 */
public class CargoLocalServiceWrapper implements CargoLocalService,
	ServiceWrapper<CargoLocalService> {
	public CargoLocalServiceWrapper(CargoLocalService cargoLocalService) {
		_cargoLocalService = cargoLocalService;
	}

	/**
	* Adds the cargo to the database. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo addCargo(
		br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.addCargo(cargo);
	}

	/**
	* Creates a new cargo with the primary key. Does not add the cargo to the database.
	*
	* @param cargoId the primary key for the new cargo
	* @return the new cargo
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo createCargo(
		long cargoId) {
		return _cargoLocalService.createCargo(cargoId);
	}

	/**
	* Deletes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo that was removed
	* @throws PortalException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo deleteCargo(
		long cargoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.deleteCargo(cargoId);
	}

	/**
	* Deletes the cargo from the database. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo deleteCargo(
		br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.deleteCargo(cargo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cargoLocalService.dynamicQuery();
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
		return _cargoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cargoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cargoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cargoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cargoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Cargo fetchCargo(
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.fetchCargo(cargoId);
	}

	/**
	* Returns the cargo with the matching UUID and company.
	*
	* @param uuid the cargo's UUID
	* @param companyId the primary key of the company
	* @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo fetchCargoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.fetchCargoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the cargo matching the UUID and group.
	*
	* @param uuid the cargo's UUID
	* @param groupId the primary key of the group
	* @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo fetchCargoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.fetchCargoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the cargo with the primary key.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo
	* @throws PortalException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo getCargo(long cargoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getCargo(cargoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the cargo with the matching UUID and company.
	*
	* @param uuid the cargo's UUID
	* @param companyId the primary key of the company
	* @return the matching cargo
	* @throws PortalException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo getCargoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getCargoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the cargo matching the UUID and group.
	*
	* @param uuid the cargo's UUID
	* @param groupId the primary key of the group
	* @return the matching cargo
	* @throws PortalException if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo getCargoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getCargoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the cargos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of cargos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> getCargos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getCargos(start, end);
	}

	/**
	* Returns the number of cargos.
	*
	* @return the number of cargos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCargosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getCargosCount();
	}

	/**
	* Updates the cargo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.funcionario.model.Cargo updateCargo(
		br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.updateCargo(cargo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cargoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cargoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cargoLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Cargo addCargo(
		long companyId, long groupId, long createUserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		double versao, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.addCargo(companyId, groupId, createUserId,
			nomeMap, versao, serviceContext);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Cargo update(long cargoId,
		long modifieduserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		double versao, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.update(cargoId, modifieduserId, nomeMap,
			versao, serviceContext);
	}

	@Override
	public void updateAsset(long userId,
		br.com.prodevelopment.funcionario.model.Cargo cargo,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_cargoLocalService.updateAsset(userId, cargo, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Cargo deleteCargo(
		br.com.prodevelopment.funcionario.model.Cargo cargo, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.deleteCargo(cargo, userId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> search(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.search(companyId, groupId, nome, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.searchCount(companyId, groupId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> search(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.search(companyId, nome, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.searchCount(companyId, nome);
	}

	@Override
	public java.util.List<br.com.prodevelopment.funcionario.model.Cargo> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.searchCount(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CargoLocalService getWrappedCargoLocalService() {
		return _cargoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCargoLocalService(CargoLocalService cargoLocalService) {
		_cargoLocalService = cargoLocalService;
	}

	@Override
	public CargoLocalService getWrappedService() {
		return _cargoLocalService;
	}

	@Override
	public void setWrappedService(CargoLocalService cargoLocalService) {
		_cargoLocalService = cargoLocalService;
	}

	private CargoLocalService _cargoLocalService;
}