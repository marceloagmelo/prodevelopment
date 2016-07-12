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

package br.com.prodevelopment.etask.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TypeTaskLocalService}.
 *
 * @author Marcelo Melo
 * @see TypeTaskLocalService
 * @generated
 */
public class TypeTaskLocalServiceWrapper implements TypeTaskLocalService,
	ServiceWrapper<TypeTaskLocalService> {
	public TypeTaskLocalServiceWrapper(
		TypeTaskLocalService typeTaskLocalService) {
		_typeTaskLocalService = typeTaskLocalService;
	}

	/**
	* Adds the type task to the database. Also notifies the appropriate model listeners.
	*
	* @param typeTask the type task
	* @return the type task that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask addTypeTask(
		br.com.prodevelopment.etask.model.TypeTask typeTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.addTypeTask(typeTask);
	}

	/**
	* Creates a new type task with the primary key. Does not add the type task to the database.
	*
	* @param typeTaskId the primary key for the new type task
	* @return the new type task
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask createTypeTask(
		long typeTaskId) {
		return _typeTaskLocalService.createTypeTask(typeTaskId);
	}

	/**
	* Deletes the type task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTaskId the primary key of the type task
	* @return the type task that was removed
	* @throws PortalException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask deleteTypeTask(
		long typeTaskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.deleteTypeTask(typeTaskId);
	}

	/**
	* Deletes the type task from the database. Also notifies the appropriate model listeners.
	*
	* @param typeTask the type task
	* @return the type task that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask deleteTypeTask(
		br.com.prodevelopment.etask.model.TypeTask typeTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.deleteTypeTask(typeTask);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _typeTaskLocalService.dynamicQuery();
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
		return _typeTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _typeTaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _typeTaskLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _typeTaskLocalService.dynamicQueryCount(dynamicQuery);
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
		return _typeTaskLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask fetchTypeTask(
		long typeTaskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.fetchTypeTask(typeTaskId);
	}

	/**
	* Returns the type task with the matching UUID and company.
	*
	* @param uuid the type task's UUID
	* @param companyId the primary key of the company
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask fetchTypeTaskByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.fetchTypeTaskByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the type task matching the UUID and group.
	*
	* @param uuid the type task's UUID
	* @param groupId the primary key of the group
	* @return the matching type task, or <code>null</code> if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask fetchTypeTaskByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.fetchTypeTaskByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the type task with the primary key.
	*
	* @param typeTaskId the primary key of the type task
	* @return the type task
	* @throws PortalException if a type task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask getTypeTask(
		long typeTaskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.getTypeTask(typeTaskId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the type task with the matching UUID and company.
	*
	* @param uuid the type task's UUID
	* @param companyId the primary key of the company
	* @return the matching type task
	* @throws PortalException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask getTypeTaskByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.getTypeTaskByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the type task matching the UUID and group.
	*
	* @param uuid the type task's UUID
	* @param groupId the primary key of the group
	* @return the matching type task
	* @throws PortalException if a matching type task could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask getTypeTaskByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.getTypeTaskByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the type tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of type tasks
	* @param end the upper bound of the range of type tasks (not inclusive)
	* @return the range of type tasks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> getTypeTasks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.getTypeTasks(start, end);
	}

	/**
	* Returns the number of type tasks.
	*
	* @return the number of type tasks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTypeTasksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.getTypeTasksCount();
	}

	/**
	* Updates the type task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param typeTask the type task
	* @return the type task that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.prodevelopment.etask.model.TypeTask updateTypeTask(
		br.com.prodevelopment.etask.model.TypeTask typeTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.updateTypeTask(typeTask);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _typeTaskLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_typeTaskLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _typeTaskLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask addTypeTask(
		long companyId, long groupId, long userIdCreate,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		boolean customFieldsActive, java.lang.String xsd, long DDMStructureId,
		long classNameId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.addTypeTask(companyId, groupId,
			userIdCreate, nameMap, descriptionMap, customFieldsActive, xsd,
			DDMStructureId, classNameId, serviceContext);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask addTypeTask(
		long companyId, long groupId, long userIdCreate,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		boolean customFieldsActive, java.lang.String xsd, long DDMStructureId,
		long classNameId, long classPK,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.addTypeTask(companyId, groupId,
			userIdCreate, nameMap, descriptionMap, customFieldsActive, xsd,
			DDMStructureId, classNameId, classPK, serviceContext);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask updateTypeTask(
		long typeTaskId, long companyId, long groupId, long userIdModified,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		boolean customFieldsActive, java.lang.String xsd, long DDMStructureId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.updateTypeTask(typeTaskId, companyId,
			groupId, userIdModified, nameMap, descriptionMap,
			customFieldsActive, xsd, DDMStructureId, serviceContext);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask moveTypeTaskToTrash(
		long userId, br.com.prodevelopment.etask.model.TypeTask typeTask)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.moveTypeTaskToTrash(userId, typeTask);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask moveTypeTaskToTrash(
		long userId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.moveTypeTaskToTrash(userId, typeId);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask restoreTypeTaskFromTrash(
		long userId, long typeTaskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.restoreTypeTaskFromTrash(userId, typeTaskId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> search(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.search(companyId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.searchCount(companyId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> search(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.search(companyId, groupId, start, end,
			orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.searchCount(companyId, groupId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> search(
		long companyId, long groupId, int[] status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.search(companyId, groupId, status, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, int[] status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.searchCount(companyId, groupId, status);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> search(
		long companyId, long groupId, java.lang.String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.search(companyId, groupId, name, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.searchCount(companyId, groupId, name);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> search(
		long companyId, long groupId, int[] status, java.lang.String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.search(companyId, groupId, status, name,
			start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, int[] status,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.searchCount(companyId, groupId, status,
			name);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> search(
		long companyId, long groupId, int[] status, long classNameId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.search(companyId, groupId, status,
			classNameId, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, int[] status,
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.searchCount(companyId, groupId, status,
			classNameId);
	}

	@Override
	public java.util.List<br.com.prodevelopment.etask.model.TypeTask> search(
		long companyId, long groupId, int[] status, java.lang.String name,
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.search(companyId, groupId, status, name,
			classNameId, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long companyId, long groupId, int[] status,
		java.lang.String name, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.searchCount(companyId, groupId, status,
			name, classNameId);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask updateStatus(
		long userId, br.com.prodevelopment.etask.model.TypeTask typeTask,
		int status, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.updateStatus(userId, typeTask, status,
			serviceContext);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask updateStatus(
		long userId, long typeTaskId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.updateStatus(userId, typeTaskId, status,
			serviceContext);
	}

	@Override
	public void updateAsset(long userId,
		br.com.prodevelopment.etask.model.TypeTask typeTask,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_typeTaskLocalService.updateAsset(userId, typeTask, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask findByClassPK_Other(
		long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskLocalService.findByClassPK_Other(classPK);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TypeTaskLocalService getWrappedTypeTaskLocalService() {
		return _typeTaskLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTypeTaskLocalService(
		TypeTaskLocalService typeTaskLocalService) {
		_typeTaskLocalService = typeTaskLocalService;
	}

	@Override
	public TypeTaskLocalService getWrappedService() {
		return _typeTaskLocalService;
	}

	@Override
	public void setWrappedService(TypeTaskLocalService typeTaskLocalService) {
		_typeTaskLocalService = typeTaskLocalService;
	}

	private TypeTaskLocalService _typeTaskLocalService;
}