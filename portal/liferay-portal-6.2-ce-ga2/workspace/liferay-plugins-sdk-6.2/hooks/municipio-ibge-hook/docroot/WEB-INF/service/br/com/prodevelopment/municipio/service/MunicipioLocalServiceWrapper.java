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

package br.com.prodevelopment.municipio.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MunicipioLocalService}.
 *
 * @author marcelo
 * @see MunicipioLocalService
 * @generated
 */
public class MunicipioLocalServiceWrapper implements MunicipioLocalService,
	ServiceWrapper<MunicipioLocalService> {
	public MunicipioLocalServiceWrapper(
		MunicipioLocalService municipioLocalService) {
		_municipioLocalService = municipioLocalService;
	}

	/**
	* Adds the municipio to the database. Also notifies the appropriate model listeners.
	*
	* @param municipio the municipio
	* @return the municipio that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.municipio.model.Municipio addMunicipio(
		br.com.prodevelopment.municipio.model.Municipio municipio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.addMunicipio(municipio);
	}

	/**
	* Creates a new municipio with the primary key. Does not add the municipio to the database.
	*
	* @param codigo the primary key for the new municipio
	* @return the new municipio
	*/
	@Override
	public br.com.prodevelopment.municipio.model.Municipio createMunicipio(
		long codigo) {
		return _municipioLocalService.createMunicipio(codigo);
	}

	/**
	* Deletes the municipio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codigo the primary key of the municipio
	* @return the municipio that was removed
	* @throws PortalException if a municipio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.municipio.model.Municipio deleteMunicipio(
		long codigo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.deleteMunicipio(codigo);
	}

	/**
	* Deletes the municipio from the database. Also notifies the appropriate model listeners.
	*
	* @param municipio the municipio
	* @return the municipio that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.municipio.model.Municipio deleteMunicipio(
		br.com.prodevelopment.municipio.model.Municipio municipio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.deleteMunicipio(municipio);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _municipioLocalService.dynamicQuery();
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
		return _municipioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _municipioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _municipioLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _municipioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _municipioLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.municipio.model.Municipio fetchMunicipio(
		long codigo) throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.fetchMunicipio(codigo);
	}

	/**
	* Returns the municipio with the primary key.
	*
	* @param codigo the primary key of the municipio
	* @return the municipio
	* @throws PortalException if a municipio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.municipio.model.Municipio getMunicipio(
		long codigo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.getMunicipio(codigo);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the municipios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of municipios
	* @param end the upper bound of the range of municipios (not inclusive)
	* @return the range of municipios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.municipio.model.Municipio> getMunicipios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.getMunicipios(start, end);
	}

	/**
	* Returns the number of municipios.
	*
	* @return the number of municipios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMunicipiosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.getMunicipiosCount();
	}

	/**
	* Updates the municipio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param municipio the municipio
	* @return the municipio that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.municipio.model.Municipio updateMunicipio(
		br.com.prodevelopment.municipio.model.Municipio municipio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.updateMunicipio(municipio);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _municipioLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_municipioLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _municipioLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<br.com.prodevelopment.municipio.model.Municipio> search(
		java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.search(uf);
	}

	@Override
	public int searchCount(java.lang.String uf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.searchCount(uf);
	}

	@Override
	public java.util.List<br.com.prodevelopment.municipio.model.Municipio> search(
		java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.search(uf, start, end);
	}

	@Override
	public int searchCount(java.lang.String uf, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.searchCount(uf, start, end);
	}

	@Override
	public java.util.List<br.com.prodevelopment.municipio.model.Municipio> search(
		java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.search(uf, start, end, orderByComparator);
	}

	@Override
	public int searchCount(java.lang.String uf, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.searchCount(uf, start, end,
			orderByComparator);
	}

	@Override
	public br.com.prodevelopment.municipio.model.Municipio getDadosCep(
		java.lang.String cep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _municipioLocalService.getDadosCep(cep);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MunicipioLocalService getWrappedMunicipioLocalService() {
		return _municipioLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMunicipioLocalService(
		MunicipioLocalService municipioLocalService) {
		_municipioLocalService = municipioLocalService;
	}

	@Override
	public MunicipioLocalService getWrappedService() {
		return _municipioLocalService;
	}

	@Override
	public void setWrappedService(MunicipioLocalService municipioLocalService) {
		_municipioLocalService = municipioLocalService;
	}

	private MunicipioLocalService _municipioLocalService;
}