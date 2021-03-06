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

package br.com.prodevelopment.funcionario.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Cargo. This utility wraps
 * {@link br.com.prodevelopment.funcionario.service.impl.CargoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcelo Melo
 * @see CargoLocalService
 * @see br.com.prodevelopment.funcionario.service.base.CargoLocalServiceBaseImpl
 * @see br.com.prodevelopment.funcionario.service.impl.CargoLocalServiceImpl
 * @generated
 */
public class CargoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.prodevelopment.funcionario.service.impl.CargoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cargo to the database. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo addCargo(
		br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCargo(cargo);
	}

	/**
	* Creates a new cargo with the primary key. Does not add the cargo to the database.
	*
	* @param cargoId the primary key for the new cargo
	* @return the new cargo
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo createCargo(
		long cargoId) {
		return getService().createCargo(cargoId);
	}

	/**
	* Deletes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo that was removed
	* @throws PortalException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo deleteCargo(
		long cargoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargo(cargoId);
	}

	/**
	* Deletes the cargo from the database. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo deleteCargo(
		br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargo(cargo);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.prodevelopment.funcionario.model.Cargo fetchCargo(
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCargo(cargoId);
	}

	/**
	* Returns the cargo with the matching UUID and company.
	*
	* @param uuid the cargo's UUID
	* @param companyId the primary key of the company
	* @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchCargoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCargoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the cargo matching the UUID and group.
	*
	* @param uuid the cargo's UUID
	* @param groupId the primary key of the group
	* @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo fetchCargoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCargoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the cargo with the primary key.
	*
	* @param cargoId the primary key of the cargo
	* @return the cargo
	* @throws PortalException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo getCargo(
		long cargoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargo(cargoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static br.com.prodevelopment.funcionario.model.Cargo getCargoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargoByUuidAndCompanyId(uuid, companyId);
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
	public static br.com.prodevelopment.funcionario.model.Cargo getCargoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargoByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> getCargos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargos(start, end);
	}

	/**
	* Returns the number of cargos.
	*
	* @return the number of cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int getCargosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargosCount();
	}

	/**
	* Updates the cargo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.funcionario.model.Cargo updateCargo(
		br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCargo(cargo);
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

	public static br.com.prodevelopment.funcionario.model.Cargo addCargo(
		long companyId, long groupId, long createUserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		double versao, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCargo(companyId, groupId, createUserId, nomeMap, versao,
			serviceContext);
	}

	public static br.com.prodevelopment.funcionario.model.Cargo update(
		long cargoId, long modifieduserId,
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		double versao, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(cargoId, modifieduserId, nomeMap, versao,
			serviceContext);
	}

	public static void updateAsset(long userId,
		br.com.prodevelopment.funcionario.model.Cargo cargo,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, cargo, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static br.com.prodevelopment.funcionario.model.Cargo deleteCargo(
		br.com.prodevelopment.funcionario.model.Cargo cargo, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargo(cargo, userId);
	}

	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> search(
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

	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> search(
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

	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> search(
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

	public static java.util.List<br.com.prodevelopment.funcionario.model.Cargo> search(
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

	public static CargoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CargoLocalService.class.getName());

			if (invokableLocalService instanceof CargoLocalService) {
				_service = (CargoLocalService)invokableLocalService;
			}
			else {
				_service = new CargoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CargoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CargoLocalService service) {
	}

	private static CargoLocalService _service;
}