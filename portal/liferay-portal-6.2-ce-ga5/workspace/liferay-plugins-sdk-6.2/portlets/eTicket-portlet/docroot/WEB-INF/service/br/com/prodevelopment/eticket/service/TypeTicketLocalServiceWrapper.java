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

package br.com.prodevelopment.eticket.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TypeTicketLocalService}.
 *
 * @author Marcelo Melo
 * @see TypeTicketLocalService
 * @generated
 */
public class TypeTicketLocalServiceWrapper implements TypeTicketLocalService,
	ServiceWrapper<TypeTicketLocalService> {
	public TypeTicketLocalServiceWrapper(
		TypeTicketLocalService typeTicketLocalService) {
		_typeTicketLocalService = typeTicketLocalService;
	}

	/**
	* Adds the type ticket to the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicket the type ticket
	* @return the type ticket that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket addTypeTicket(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.addTypeTicket(typeTicket);
	}

	/**
	* Creates a new type ticket with the primary key. Does not add the type ticket to the database.
	*
	* @param typeTicketId the primary key for the new type ticket
	* @return the new type ticket
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket createTypeTicket(
		long typeTicketId) {
		return _typeTicketLocalService.createTypeTicket(typeTicketId);
	}

	/**
	* Deletes the type ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicketId the primary key of the type ticket
	* @return the type ticket that was removed
	* @throws PortalException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket deleteTypeTicket(
		long typeTicketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.deleteTypeTicket(typeTicketId);
	}

	/**
	* Deletes the type ticket from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTicket the type ticket
	* @return the type ticket that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket deleteTypeTicket(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.deleteTypeTicket(typeTicket);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _typeTicketLocalService.dynamicQuery();
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
		return _typeTicketLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _typeTicketLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _typeTicketLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _typeTicketLocalService.dynamicQueryCount(dynamicQuery);
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
		return _typeTicketLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket fetchTypeTicket(
		long typeTicketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.fetchTypeTicket(typeTicketId);
	}

	/**
	* Returns the type ticket with the matching UUID and company.
	*
	* @param uuid the type ticket's UUID
	* @param companyId the primary key of the company
	* @return the matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket fetchTypeTicketByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.fetchTypeTicketByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the type ticket matching the UUID and group.
	*
	* @param uuid the type ticket's UUID
	* @param groupId the primary key of the group
	* @return the matching type ticket, or <code>null</code> if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket fetchTypeTicketByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.fetchTypeTicketByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the type ticket with the primary key.
	*
	* @param typeTicketId the primary key of the type ticket
	* @return the type ticket
	* @throws PortalException if a type ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket getTypeTicket(
		long typeTicketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.getTypeTicket(typeTicketId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the type ticket with the matching UUID and company.
	*
	* @param uuid the type ticket's UUID
	* @param companyId the primary key of the company
	* @return the matching type ticket
	* @throws PortalException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket getTypeTicketByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.getTypeTicketByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the type ticket matching the UUID and group.
	*
	* @param uuid the type ticket's UUID
	* @param groupId the primary key of the group
	* @return the matching type ticket
	* @throws PortalException if a matching type ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket getTypeTicketByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.getTypeTicketByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the type tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type tickets
	* @param end the upper bound of the range of type tickets (not inclusive)
	* @return the range of type tickets
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> getTypeTickets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.getTypeTickets(start, end);
	}

	/**
	* Returns the number of type tickets.
	*
	* @return the number of type tickets
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTypeTicketsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.getTypeTicketsCount();
	}

	/**
	* Updates the type ticket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param typeTicket the type ticket
	* @return the type ticket that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket updateTypeTicket(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.updateTypeTicket(typeTicket);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _typeTicketLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_typeTicketLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _typeTicketLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket addTypeTicket(
		long companyId, long groupId, long userIdCreate,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.addTypeTicket(companyId, groupId,
			userIdCreate, nameMap, descriptionMap, serviceContext);
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket updateTypeTicket(
		long typeId, long companyId, long groupId, long userIdModified,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.updateTypeTicket(typeId, companyId,
			groupId, userIdModified, nameMap, descriptionMap, serviceContext);
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket deleteTypeTicket(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.deleteTypeTicket(typeTicket, userId);
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket deleteTypeTicket(
		long typeId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.deleteTypeTicket(typeId, userId);
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket moveTypeTicketToTrash(
		long userId, br.com.prodevelopment.eticket.model.TypeTicket type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.moveTypeTicketToTrash(userId, type);
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket moveTypeTicketToTrash(
		long userId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.moveTypeTicketToTrash(userId, typeId);
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket restoreTypeTicketFromTrash(
		long userId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.restoreTypeTicketFromTrash(userId, typeId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.searchCount(companyId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> search(
		long companyId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.search(companyId, name, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.searchCount(companyId, name);
	}

	@Override
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.eticket.model.TypeTicket> search(
		long companyId, long groupId, java.lang.String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.search(companyId, groupId, name, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketLocalService.searchCount(companyId, groupId, name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TypeTicketLocalService getWrappedTypeTicketLocalService() {
		return _typeTicketLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTypeTicketLocalService(
		TypeTicketLocalService typeTicketLocalService) {
		_typeTicketLocalService = typeTicketLocalService;
	}

	@Override
	public TypeTicketLocalService getWrappedService() {
		return _typeTicketLocalService;
	}

	@Override
	public void setWrappedService(TypeTicketLocalService typeTicketLocalService) {
		_typeTicketLocalService = typeTicketLocalService;
	}

	private TypeTicketLocalService _typeTicketLocalService;
}