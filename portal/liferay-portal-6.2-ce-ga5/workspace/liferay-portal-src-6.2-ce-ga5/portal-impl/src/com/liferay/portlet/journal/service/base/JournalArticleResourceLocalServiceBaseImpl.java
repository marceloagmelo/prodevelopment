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

package com.liferay.portlet.journal.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalService;
import com.liferay.portlet.journal.service.persistence.JournalArticleFinder;
import com.liferay.portlet.journal.service.persistence.JournalArticleImagePersistence;
import com.liferay.portlet.journal.service.persistence.JournalArticlePersistence;
import com.liferay.portlet.journal.service.persistence.JournalArticleResourcePersistence;
import com.liferay.portlet.journal.service.persistence.JournalContentSearchPersistence;
import com.liferay.portlet.journal.service.persistence.JournalFeedFinder;
import com.liferay.portlet.journal.service.persistence.JournalFeedPersistence;
import com.liferay.portlet.journal.service.persistence.JournalFolderFinder;
import com.liferay.portlet.journal.service.persistence.JournalFolderPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the journal article resource local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.journal.service.impl.JournalArticleResourceLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.journal.service.impl.JournalArticleResourceLocalServiceImpl
 * @see com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil
 * @generated
 */
public abstract class JournalArticleResourceLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements JournalArticleResourceLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil} to access the journal article resource local service.
	 */

	/**
	 * Adds the journal article resource to the database. Also notifies the appropriate model listeners.
	 *
	 * @param journalArticleResource the journal article resource
	 * @return the journal article resource that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public JournalArticleResource addJournalArticleResource(
		JournalArticleResource journalArticleResource)
		throws SystemException {
		journalArticleResource.setNew(true);

		return journalArticleResourcePersistence.update(journalArticleResource);
	}

	/**
	 * Creates a new journal article resource with the primary key. Does not add the journal article resource to the database.
	 *
	 * @param resourcePrimKey the primary key for the new journal article resource
	 * @return the new journal article resource
	 */
	@Override
	public JournalArticleResource createJournalArticleResource(
		long resourcePrimKey) {
		return journalArticleResourcePersistence.create(resourcePrimKey);
	}

	/**
	 * Deletes the journal article resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourcePrimKey the primary key of the journal article resource
	 * @return the journal article resource that was removed
	 * @throws PortalException if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public JournalArticleResource deleteJournalArticleResource(
		long resourcePrimKey) throws PortalException, SystemException {
		return journalArticleResourcePersistence.remove(resourcePrimKey);
	}

	/**
	 * Deletes the journal article resource from the database. Also notifies the appropriate model listeners.
	 *
	 * @param journalArticleResource the journal article resource
	 * @return the journal article resource that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public JournalArticleResource deleteJournalArticleResource(
		JournalArticleResource journalArticleResource)
		throws SystemException {
		return journalArticleResourcePersistence.remove(journalArticleResource);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(JournalArticleResource.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return journalArticleResourcePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.journal.model.impl.JournalArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return journalArticleResourcePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.journal.model.impl.JournalArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return journalArticleResourcePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return journalArticleResourcePersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return journalArticleResourcePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public JournalArticleResource fetchJournalArticleResource(
		long resourcePrimKey) throws SystemException {
		return journalArticleResourcePersistence.fetchByPrimaryKey(resourcePrimKey);
	}

	/**
	 * Returns the journal article resource matching the UUID and group.
	 *
	 * @param uuid the journal article resource's UUID
	 * @param groupId the primary key of the group
	 * @return the matching journal article resource, or <code>null</code> if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JournalArticleResource fetchJournalArticleResourceByUuidAndGroupId(
		String uuid, long groupId) throws SystemException {
		return journalArticleResourcePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the journal article resource with the primary key.
	 *
	 * @param resourcePrimKey the primary key of the journal article resource
	 * @return the journal article resource
	 * @throws PortalException if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JournalArticleResource getJournalArticleResource(
		long resourcePrimKey) throws PortalException, SystemException {
		return journalArticleResourcePersistence.findByPrimaryKey(resourcePrimKey);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return journalArticleResourcePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the journal article resource matching the UUID and group.
	 *
	 * @param uuid the journal article resource's UUID
	 * @param groupId the primary key of the group
	 * @return the matching journal article resource
	 * @throws PortalException if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JournalArticleResource getJournalArticleResourceByUuidAndGroupId(
		String uuid, long groupId) throws PortalException, SystemException {
		return journalArticleResourcePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the journal article resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.journal.model.impl.JournalArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of journal article resources
	 * @param end the upper bound of the range of journal article resources (not inclusive)
	 * @return the range of journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JournalArticleResource> getJournalArticleResources(int start,
		int end) throws SystemException {
		return journalArticleResourcePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of journal article resources.
	 *
	 * @return the number of journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getJournalArticleResourcesCount() throws SystemException {
		return journalArticleResourcePersistence.countAll();
	}

	/**
	 * Updates the journal article resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param journalArticleResource the journal article resource
	 * @return the journal article resource that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public JournalArticleResource updateJournalArticleResource(
		JournalArticleResource journalArticleResource)
		throws SystemException {
		return journalArticleResourcePersistence.update(journalArticleResource);
	}

	/**
	 * Returns the journal article local service.
	 *
	 * @return the journal article local service
	 */
	public com.liferay.portlet.journal.service.JournalArticleLocalService getJournalArticleLocalService() {
		return journalArticleLocalService;
	}

	/**
	 * Sets the journal article local service.
	 *
	 * @param journalArticleLocalService the journal article local service
	 */
	public void setJournalArticleLocalService(
		com.liferay.portlet.journal.service.JournalArticleLocalService journalArticleLocalService) {
		this.journalArticleLocalService = journalArticleLocalService;
	}

	/**
	 * Returns the journal article remote service.
	 *
	 * @return the journal article remote service
	 */
	public com.liferay.portlet.journal.service.JournalArticleService getJournalArticleService() {
		return journalArticleService;
	}

	/**
	 * Sets the journal article remote service.
	 *
	 * @param journalArticleService the journal article remote service
	 */
	public void setJournalArticleService(
		com.liferay.portlet.journal.service.JournalArticleService journalArticleService) {
		this.journalArticleService = journalArticleService;
	}

	/**
	 * Returns the journal article persistence.
	 *
	 * @return the journal article persistence
	 */
	public JournalArticlePersistence getJournalArticlePersistence() {
		return journalArticlePersistence;
	}

	/**
	 * Sets the journal article persistence.
	 *
	 * @param journalArticlePersistence the journal article persistence
	 */
	public void setJournalArticlePersistence(
		JournalArticlePersistence journalArticlePersistence) {
		this.journalArticlePersistence = journalArticlePersistence;
	}

	/**
	 * Returns the journal article finder.
	 *
	 * @return the journal article finder
	 */
	public JournalArticleFinder getJournalArticleFinder() {
		return journalArticleFinder;
	}

	/**
	 * Sets the journal article finder.
	 *
	 * @param journalArticleFinder the journal article finder
	 */
	public void setJournalArticleFinder(
		JournalArticleFinder journalArticleFinder) {
		this.journalArticleFinder = journalArticleFinder;
	}

	/**
	 * Returns the journal article image local service.
	 *
	 * @return the journal article image local service
	 */
	public com.liferay.portlet.journal.service.JournalArticleImageLocalService getJournalArticleImageLocalService() {
		return journalArticleImageLocalService;
	}

	/**
	 * Sets the journal article image local service.
	 *
	 * @param journalArticleImageLocalService the journal article image local service
	 */
	public void setJournalArticleImageLocalService(
		com.liferay.portlet.journal.service.JournalArticleImageLocalService journalArticleImageLocalService) {
		this.journalArticleImageLocalService = journalArticleImageLocalService;
	}

	/**
	 * Returns the journal article image persistence.
	 *
	 * @return the journal article image persistence
	 */
	public JournalArticleImagePersistence getJournalArticleImagePersistence() {
		return journalArticleImagePersistence;
	}

	/**
	 * Sets the journal article image persistence.
	 *
	 * @param journalArticleImagePersistence the journal article image persistence
	 */
	public void setJournalArticleImagePersistence(
		JournalArticleImagePersistence journalArticleImagePersistence) {
		this.journalArticleImagePersistence = journalArticleImagePersistence;
	}

	/**
	 * Returns the journal article resource local service.
	 *
	 * @return the journal article resource local service
	 */
	public com.liferay.portlet.journal.service.JournalArticleResourceLocalService getJournalArticleResourceLocalService() {
		return journalArticleResourceLocalService;
	}

	/**
	 * Sets the journal article resource local service.
	 *
	 * @param journalArticleResourceLocalService the journal article resource local service
	 */
	public void setJournalArticleResourceLocalService(
		com.liferay.portlet.journal.service.JournalArticleResourceLocalService journalArticleResourceLocalService) {
		this.journalArticleResourceLocalService = journalArticleResourceLocalService;
	}

	/**
	 * Returns the journal article resource persistence.
	 *
	 * @return the journal article resource persistence
	 */
	public JournalArticleResourcePersistence getJournalArticleResourcePersistence() {
		return journalArticleResourcePersistence;
	}

	/**
	 * Sets the journal article resource persistence.
	 *
	 * @param journalArticleResourcePersistence the journal article resource persistence
	 */
	public void setJournalArticleResourcePersistence(
		JournalArticleResourcePersistence journalArticleResourcePersistence) {
		this.journalArticleResourcePersistence = journalArticleResourcePersistence;
	}

	/**
	 * Returns the journal content search local service.
	 *
	 * @return the journal content search local service
	 */
	public com.liferay.portlet.journal.service.JournalContentSearchLocalService getJournalContentSearchLocalService() {
		return journalContentSearchLocalService;
	}

	/**
	 * Sets the journal content search local service.
	 *
	 * @param journalContentSearchLocalService the journal content search local service
	 */
	public void setJournalContentSearchLocalService(
		com.liferay.portlet.journal.service.JournalContentSearchLocalService journalContentSearchLocalService) {
		this.journalContentSearchLocalService = journalContentSearchLocalService;
	}

	/**
	 * Returns the journal content search persistence.
	 *
	 * @return the journal content search persistence
	 */
	public JournalContentSearchPersistence getJournalContentSearchPersistence() {
		return journalContentSearchPersistence;
	}

	/**
	 * Sets the journal content search persistence.
	 *
	 * @param journalContentSearchPersistence the journal content search persistence
	 */
	public void setJournalContentSearchPersistence(
		JournalContentSearchPersistence journalContentSearchPersistence) {
		this.journalContentSearchPersistence = journalContentSearchPersistence;
	}

	/**
	 * Returns the journal feed local service.
	 *
	 * @return the journal feed local service
	 */
	public com.liferay.portlet.journal.service.JournalFeedLocalService getJournalFeedLocalService() {
		return journalFeedLocalService;
	}

	/**
	 * Sets the journal feed local service.
	 *
	 * @param journalFeedLocalService the journal feed local service
	 */
	public void setJournalFeedLocalService(
		com.liferay.portlet.journal.service.JournalFeedLocalService journalFeedLocalService) {
		this.journalFeedLocalService = journalFeedLocalService;
	}

	/**
	 * Returns the journal feed remote service.
	 *
	 * @return the journal feed remote service
	 */
	public com.liferay.portlet.journal.service.JournalFeedService getJournalFeedService() {
		return journalFeedService;
	}

	/**
	 * Sets the journal feed remote service.
	 *
	 * @param journalFeedService the journal feed remote service
	 */
	public void setJournalFeedService(
		com.liferay.portlet.journal.service.JournalFeedService journalFeedService) {
		this.journalFeedService = journalFeedService;
	}

	/**
	 * Returns the journal feed persistence.
	 *
	 * @return the journal feed persistence
	 */
	public JournalFeedPersistence getJournalFeedPersistence() {
		return journalFeedPersistence;
	}

	/**
	 * Sets the journal feed persistence.
	 *
	 * @param journalFeedPersistence the journal feed persistence
	 */
	public void setJournalFeedPersistence(
		JournalFeedPersistence journalFeedPersistence) {
		this.journalFeedPersistence = journalFeedPersistence;
	}

	/**
	 * Returns the journal feed finder.
	 *
	 * @return the journal feed finder
	 */
	public JournalFeedFinder getJournalFeedFinder() {
		return journalFeedFinder;
	}

	/**
	 * Sets the journal feed finder.
	 *
	 * @param journalFeedFinder the journal feed finder
	 */
	public void setJournalFeedFinder(JournalFeedFinder journalFeedFinder) {
		this.journalFeedFinder = journalFeedFinder;
	}

	/**
	 * Returns the journal folder local service.
	 *
	 * @return the journal folder local service
	 */
	public com.liferay.portlet.journal.service.JournalFolderLocalService getJournalFolderLocalService() {
		return journalFolderLocalService;
	}

	/**
	 * Sets the journal folder local service.
	 *
	 * @param journalFolderLocalService the journal folder local service
	 */
	public void setJournalFolderLocalService(
		com.liferay.portlet.journal.service.JournalFolderLocalService journalFolderLocalService) {
		this.journalFolderLocalService = journalFolderLocalService;
	}

	/**
	 * Returns the journal folder remote service.
	 *
	 * @return the journal folder remote service
	 */
	public com.liferay.portlet.journal.service.JournalFolderService getJournalFolderService() {
		return journalFolderService;
	}

	/**
	 * Sets the journal folder remote service.
	 *
	 * @param journalFolderService the journal folder remote service
	 */
	public void setJournalFolderService(
		com.liferay.portlet.journal.service.JournalFolderService journalFolderService) {
		this.journalFolderService = journalFolderService;
	}

	/**
	 * Returns the journal folder persistence.
	 *
	 * @return the journal folder persistence
	 */
	public JournalFolderPersistence getJournalFolderPersistence() {
		return journalFolderPersistence;
	}

	/**
	 * Sets the journal folder persistence.
	 *
	 * @param journalFolderPersistence the journal folder persistence
	 */
	public void setJournalFolderPersistence(
		JournalFolderPersistence journalFolderPersistence) {
		this.journalFolderPersistence = journalFolderPersistence;
	}

	/**
	 * Returns the journal folder finder.
	 *
	 * @return the journal folder finder
	 */
	public JournalFolderFinder getJournalFolderFinder() {
		return journalFolderFinder;
	}

	/**
	 * Sets the journal folder finder.
	 *
	 * @param journalFolderFinder the journal folder finder
	 */
	public void setJournalFolderFinder(JournalFolderFinder journalFolderFinder) {
		this.journalFolderFinder = journalFolderFinder;
	}

	/**
	 * Returns the journal structure local service.
	 *
	 * @return the journal structure local service
	 */
	@SuppressWarnings("deprecation")
	public com.liferay.portlet.journal.service.JournalStructureLocalService getJournalStructureLocalService() {
		return journalStructureLocalService;
	}

	/**
	 * Sets the journal structure local service.
	 *
	 * @param journalStructureLocalService the journal structure local service
	 */
	@SuppressWarnings("deprecation")
	public void setJournalStructureLocalService(
		com.liferay.portlet.journal.service.JournalStructureLocalService journalStructureLocalService) {
		this.journalStructureLocalService = journalStructureLocalService;
	}

	/**
	 * Returns the journal structure remote service.
	 *
	 * @return the journal structure remote service
	 */
	@SuppressWarnings("deprecation")
	public com.liferay.portlet.journal.service.JournalStructureService getJournalStructureService() {
		return journalStructureService;
	}

	/**
	 * Sets the journal structure remote service.
	 *
	 * @param journalStructureService the journal structure remote service
	 */
	@SuppressWarnings("deprecation")
	public void setJournalStructureService(
		com.liferay.portlet.journal.service.JournalStructureService journalStructureService) {
		this.journalStructureService = journalStructureService;
	}

	/**
	 * Returns the journal template local service.
	 *
	 * @return the journal template local service
	 */
	@SuppressWarnings("deprecation")
	public com.liferay.portlet.journal.service.JournalTemplateLocalService getJournalTemplateLocalService() {
		return journalTemplateLocalService;
	}

	/**
	 * Sets the journal template local service.
	 *
	 * @param journalTemplateLocalService the journal template local service
	 */
	@SuppressWarnings("deprecation")
	public void setJournalTemplateLocalService(
		com.liferay.portlet.journal.service.JournalTemplateLocalService journalTemplateLocalService) {
		this.journalTemplateLocalService = journalTemplateLocalService;
	}

	/**
	 * Returns the journal template remote service.
	 *
	 * @return the journal template remote service
	 */
	@SuppressWarnings("deprecation")
	public com.liferay.portlet.journal.service.JournalTemplateService getJournalTemplateService() {
		return journalTemplateService;
	}

	/**
	 * Sets the journal template remote service.
	 *
	 * @param journalTemplateService the journal template remote service
	 */
	@SuppressWarnings("deprecation")
	public void setJournalTemplateService(
		com.liferay.portlet.journal.service.JournalTemplateService journalTemplateService) {
		this.journalTemplateService = journalTemplateService;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.portlet.journal.model.JournalArticleResource",
			journalArticleResourceLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.portlet.journal.model.JournalArticleResource");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return JournalArticleResource.class;
	}

	protected String getModelClassName() {
		return JournalArticleResource.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = journalArticleResourcePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.portlet.journal.service.JournalArticleLocalService.class)
	protected com.liferay.portlet.journal.service.JournalArticleLocalService journalArticleLocalService;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalArticleService.class)
	protected com.liferay.portlet.journal.service.JournalArticleService journalArticleService;
	@BeanReference(type = JournalArticlePersistence.class)
	protected JournalArticlePersistence journalArticlePersistence;
	@BeanReference(type = JournalArticleFinder.class)
	protected JournalArticleFinder journalArticleFinder;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalArticleImageLocalService.class)
	protected com.liferay.portlet.journal.service.JournalArticleImageLocalService journalArticleImageLocalService;
	@BeanReference(type = JournalArticleImagePersistence.class)
	protected JournalArticleImagePersistence journalArticleImagePersistence;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalArticleResourceLocalService.class)
	protected com.liferay.portlet.journal.service.JournalArticleResourceLocalService journalArticleResourceLocalService;
	@BeanReference(type = JournalArticleResourcePersistence.class)
	protected JournalArticleResourcePersistence journalArticleResourcePersistence;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalContentSearchLocalService.class)
	protected com.liferay.portlet.journal.service.JournalContentSearchLocalService journalContentSearchLocalService;
	@BeanReference(type = JournalContentSearchPersistence.class)
	protected JournalContentSearchPersistence journalContentSearchPersistence;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalFeedLocalService.class)
	protected com.liferay.portlet.journal.service.JournalFeedLocalService journalFeedLocalService;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalFeedService.class)
	protected com.liferay.portlet.journal.service.JournalFeedService journalFeedService;
	@BeanReference(type = JournalFeedPersistence.class)
	protected JournalFeedPersistence journalFeedPersistence;
	@BeanReference(type = JournalFeedFinder.class)
	protected JournalFeedFinder journalFeedFinder;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalFolderLocalService.class)
	protected com.liferay.portlet.journal.service.JournalFolderLocalService journalFolderLocalService;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalFolderService.class)
	protected com.liferay.portlet.journal.service.JournalFolderService journalFolderService;
	@BeanReference(type = JournalFolderPersistence.class)
	protected JournalFolderPersistence journalFolderPersistence;
	@BeanReference(type = JournalFolderFinder.class)
	protected JournalFolderFinder journalFolderFinder;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalStructureLocalService.class)
	@SuppressWarnings("deprecation")
	protected com.liferay.portlet.journal.service.JournalStructureLocalService journalStructureLocalService;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalStructureService.class)
	@SuppressWarnings("deprecation")
	protected com.liferay.portlet.journal.service.JournalStructureService journalStructureService;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalTemplateLocalService.class)
	@SuppressWarnings("deprecation")
	protected com.liferay.portlet.journal.service.JournalTemplateLocalService journalTemplateLocalService;
	@BeanReference(type = com.liferay.portlet.journal.service.JournalTemplateService.class)
	@SuppressWarnings("deprecation")
	protected com.liferay.portlet.journal.service.JournalTemplateService journalTemplateService;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
	@BeanReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
	private String _beanIdentifier;
}