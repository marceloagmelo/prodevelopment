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

package br.com.prodevelopment.etask.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.etask.RequiredTypeTaskNameException;
import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.model.TypeTaskUsers;
import br.com.prodevelopment.etask.portlet.typetask.social.TypeTaskActivityKeys;
import br.com.prodevelopment.etask.service.TypeTaskUsersLocalServiceUtil;
import br.com.prodevelopment.etask.service.base.TypeTaskLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.SystemEventConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.trash.model.TrashEntry;

/**
 * The implementation of the type task local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.etask.service.TypeTaskLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Marcelo Melo
 * @see br.com.prodevelopment.etask.service.base.TypeTaskLocalServiceBaseImpl
 * @see br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil
 */
public class TypeTaskLocalServiceImpl extends TypeTaskLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil} to access
	 * the type task local service.
	 */
	private static Log _log = LogFactoryUtil
			.getLog(TypeTaskLocalServiceImpl.class);

	public TypeTask addTypeTask(long companyId, long groupId,
			long userIdCreate, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean customFieldsActive,
			String xsd, long DDMStructureId, long classNameId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		validate(nameMap, locale);

		User userCreate = userPersistence.findByPrimaryKey(userIdCreate);

		long typeTaskId = counterLocalService.increment();

		Date now = new Date();

		TypeTask typeTask = typeTaskPersistence.create(typeTaskId);

		typeTask.setUuid(serviceContext.getUuid());
		typeTask.setGroupId(groupId);
		typeTask.setCompanyId(companyId);
		typeTask.setUserIdCreate(userCreate.getUserId());
		typeTask.setCreateDate(serviceContext.getCreateDate(now));
		typeTask.setNameMap(nameMap);
		typeTask.setDescriptionMap(descriptionMap);
		typeTask.setCustomFieldsActive(customFieldsActive);
		if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
				companyId, groupId, TypeTask.class.getName())) {
			typeTask.setStatus(WorkflowConstants.STATUS_PENDING);
		} else {
			typeTask.setStatus(WorkflowConstants.STATUS_APPROVED);
		}

		typeTask.setStatusDate(serviceContext.getModifiedDate(now));
		typeTask.setStatusByUserId(userCreate.getUserId());
		typeTask.setStatusByUserName(userCreate.getFullName());

		if (customFieldsActive) {
			// Save structure
			DDMStructureId = saveStructure(typeTaskId, groupId, DDMStructureId,
					nameMap, descriptionMap, xsd, userCreate.getUserId(),
					serviceContext);
			typeTask.setDDMStructureId(DDMStructureId);
		}
		typeTask.setClassNameId(classNameId);
		String className = PortalUtil.getClassName(classNameId);
		typeTask.setClassName(className);

		typeTaskPersistence.update(typeTask);

		// Asset

		updateAsset(userIdCreate, typeTask,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social
		socialActivityLocalService.addActivity(userIdCreate,
				typeTask.getGroupId(), TypeTask.class.getName(), typeTaskId,
				TypeTaskActivityKeys.ADD_TYPE,
				getExtraDataJSON(typeTask, locale), 0);

		// Workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId,
				userCreate.getUserId(), TypeTask.class.getName(), typeTaskId,
				typeTask, serviceContext);

		return typeTask;
	}

	public TypeTask addTypeTask(long companyId, long groupId,
			long userIdCreate, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean customFieldsActive,
			String xsd, long DDMStructureId, long classNameId, long classPK,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		TypeTask typeTask = addTypeTask(companyId, groupId, userIdCreate,
				nameMap, descriptionMap, customFieldsActive, xsd,
				DDMStructureId, classNameId, serviceContext);
		typeTask.setClassPK(classPK);
		
		typeTaskPersistence.update(typeTask);

		return typeTask;
	}

	public TypeTask updateTypeTask(long typeTaskId, long companyId,
			long groupId, long userIdModified, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean customFieldsActive,
			String xsd, long DDMStructureId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		validate(nameMap, locale);

		User userModified = userPersistence.findByPrimaryKey(userIdModified);

		Date now = new Date();

		TypeTask typeTask = typeTaskPersistence.fetchByPrimaryKey(typeTaskId);

		typeTask.setUuid(serviceContext.getUuid());
		typeTask.setUserIdModified(userModified.getUserId());
		typeTask.setModifiedDate(serviceContext.getCreateDate(now));
		typeTask.setNameMap(nameMap);
		typeTask.setDescriptionMap(descriptionMap);
		typeTask.setCustomFieldsActive(customFieldsActive);

		if (customFieldsActive) {
			// Save structure
			DDMStructureId = saveStructure(typeTaskId, groupId, DDMStructureId,
					nameMap, descriptionMap, xsd, userModified.getUserId(),
					serviceContext);
			typeTask.setDDMStructureId(DDMStructureId);
		} else {
			typeTask.setDDMStructureId(0);
		}

		typeTaskPersistence.update(typeTask);

		// Asset
		updateAsset(userModified.getUserId(), typeTask,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social
		socialActivityLocalService.addActivity(userIdModified,
				typeTask.getGroupId(), TypeTask.class.getName(), typeTaskId,
				TypeTaskActivityKeys.UPDATE_TYPE,
				getExtraDataJSON(typeTask, locale), 0);

		return typeTask;
	}

	@SystemEvent(action = SystemEventConstants.ACTION_SKIP, send = false, type = SystemEventConstants.TYPE_DELETE)
	public TypeTask deleteTypeTask(TypeTask typeTask) throws SystemException {

		try {
			if (Validator.isNotNull(typeTask)) {
				typeTaskPersistence.remove(typeTask);

				// Users
				List<TypeTaskUsers> listTypeTaskUsers = TypeTaskUsersLocalServiceUtil
						.searchByTypeTask(typeTask.getTypeTaskId(),
								QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
				for (TypeTaskUsers typeTaskUsers : listTypeTaskUsers) {
					TypeTaskUsersLocalServiceUtil
							.deleteTypeTaskUsers(typeTaskUsers
									.getTypeTaskUsersId());
				}

				// Structure
				if (typeTask.getDDMStructureId() > 0) {
					DDMStructure ddmStructure = DDMStructureLocalServiceUtil
							.fetchDDMStructure(typeTask.getDDMStructureId());
					DDMStructureLocalServiceUtil
							.deleteDDMStructure(ddmStructure.getStructureId());
				}

				// Asset
				assetEntryLocalService.deleteEntry(TypeTask.class.getName(),
						typeTask.getTypeTaskId());

				// Trash
				trashEntryLocalService.deleteEntry(TypeTask.class.getName(),
						typeTask.getTypeTaskId());
			}
		} catch (PortalException e) {
			_log.error(e, e);
		}

		return typeTask;
	}

	public TypeTask deleteTypeTask(long typeId) throws PortalException,
			SystemException {

		TypeTask type = typeTaskPersistence.findByPrimaryKey(typeId);

		return deleteTypeTask(type);
	}

	public TypeTask moveTypeTaskToTrash(long userId, TypeTask typeTask)
			throws PortalException, SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		typeTaskLocalService.updateStatus(userId, typeTask,
				WorkflowConstants.STATUS_IN_TRASH, new ServiceContext());

		// Social
		socialActivityCounterLocalService.disableActivityCounters(
				TypeTask.class.getName(), typeTask.getTypeTaskId());

		socialActivityLocalService.addActivity(userId, typeTask.getGroupId(),
				TypeTask.class.getName(), typeTask.getTypeTaskId(),
				SocialActivityConstants.TYPE_MOVE_TO_TRASH,
				getExtraDataJSON(typeTask, locale), 0);

		// Workflow
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
				typeTask.getCompanyId(), typeTask.getGroupId(),
				TypeTask.class.getName(), typeTask.getTypeTaskId());

		return typeTask;
	}

	public TypeTask moveTypeTaskToTrash(long userId, long typeId)
			throws PortalException, SystemException {

		TypeTask type = typeTaskPersistence.findByPrimaryKey(typeId);

		return moveTypeTaskToTrash(userId, type);
	}

	@Override
	public TypeTask restoreTypeTaskFromTrash(long userId, long typeTaskId)
			throws PortalException, SystemException {

		Locale locale = LocaleUtil.getSiteDefault();

		TypeTask typeTask = getTypeTask(typeTaskId);

		TrashEntry trashEntry = trashEntryLocalService.getEntry(
				TypeTask.class.getName(), typeTaskId);

		typeTaskLocalService.updateStatus(userId, typeTaskId,
				trashEntry.getStatus(), new ServiceContext());

		// Social
		socialActivityCounterLocalService.enableActivityCounters(
				TypeTask.class.getName(), typeTaskId);

		socialActivityLocalService.addActivity(userId, typeTask.getGroupId(),
				TypeTask.class.getName(), typeTaskId,
				SocialActivityConstants.TYPE_RESTORE_FROM_TRASH,
				getExtraDataJSON(typeTask, locale), 0);

		return typeTask;
	}

	public List<TypeTask> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return typeTaskPersistence.findByCompany(companyId, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId) throws SystemException {
		return typeTaskPersistence.findByCompany(companyId).size();
	}

	public List<TypeTask> search(long companyId, long groupId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTaskPersistence.findByCG(companyId, groupId, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return typeTaskPersistence.findByCG(companyId, groupId).size();
	}

	public List<TypeTask> search(long companyId, long groupId, int[] status,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTaskPersistence.findByCG_S(companyId, groupId, status,
				start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, int[] status)
			throws SystemException {
		return typeTaskPersistence.findByCG_S(companyId, groupId, status)
				.size();
	}

	public List<TypeTask> search(long companyId, long groupId, String name,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTaskPersistence.findByCG_LikeName(companyId, groupId, name,
				start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, String name)
			throws SystemException {
		return typeTaskPersistence.findByCG_LikeName(companyId, groupId, name)
				.size();
	}

	public List<TypeTask> search(long companyId, long groupId, int[] status,
			String name, int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return typeTaskPersistence.findByCG_S_LikeName(companyId, groupId,
				status, name, start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, int[] status,
			String name) throws SystemException {
		return typeTaskPersistence.findByCG_S_LikeName(companyId, groupId,
				status, name).size();
	}

	public List<TypeTask> search(long companyId, long groupId, int[] status,
			long classNameId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return typeTaskPersistence.findByCG_S_Class(companyId, groupId, status,
				classNameId, start, end, orderByComparator);
	}

	public int searchCount(long companyId, long groupId, int[] status,
			long classNameId) throws SystemException {
		return typeTaskPersistence.findByCG_S_Class(companyId, groupId, status,
				classNameId).size();
	}

	public List<TypeTask> search(long companyId, long groupId, int[] status,
			String name, long classNameId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return typeTaskPersistence.findByCG_S_LikeName_Class(companyId,
				groupId, status, name, classNameId, start, end,
				orderByComparator);
	}

	public int searchCount(long companyId, long groupId, int[] status,
			String name, long classNameId) throws SystemException {
		return typeTaskPersistence.findByCG_S_LikeName_Class(companyId,
				groupId, status, name, classNameId).size();
	}

	public TypeTask updateStatus(long userId, TypeTask typeTask, int status,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		// Type Task

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		int oldStatus = typeTask.getStatus();

		typeTask.setUserIdModified(user.getUserId());
		typeTask.setModifiedDate(serviceContext.getModifiedDate(now));
		typeTask.setStatus(status);
		typeTask.setStatusByUserId(user.getUserId());
		typeTask.setStatusByUserName(user.getFullName());
		typeTask.setStatusDate(serviceContext.getModifiedDate(now));

		typeTaskPersistence.update(typeTask);

		// Trash

		if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
			trashEntryLocalService.deleteEntry(TypeTask.class.getName(),
					typeTask.getTypeTaskId());

			// Workflow
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					typeTask.getCompanyId(), typeTask.getGroupId(), userId,
					TypeTask.class.getName(), typeTask.getTypeTaskId(),
					typeTask, serviceContext);
		}

		if (status == WorkflowConstants.STATUS_IN_TRASH) {
			int novoStatus = WorkflowConstants.STATUS_APPROVED;
			if (WorkflowDefinitionLinkLocalServiceUtil
					.hasWorkflowDefinitionLink(typeTask.getCompanyId(),
							typeTask.getGroupId(), TypeTask.class.getName())) {
				novoStatus = WorkflowConstants.STATUS_PENDING;
			}

			trashEntryLocalService.addTrashEntry(userId, typeTask.getGroupId(),
					TypeTask.class.getName(), typeTask.getTypeTaskId(),
					typeTask.getUuid(), null, novoStatus, null, null);
		}

		return typeTask;
	}

	public TypeTask updateStatus(long userId, long typeTaskId, int status,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		TypeTask typeTask = typeTaskPersistence.findByPrimaryKey(typeTaskId);

		return typeTaskLocalService.updateStatus(userId, typeTask, status,
				serviceContext);
	}

	public void updateAsset(long userId, TypeTask typeTask,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		boolean visible = true;

		String summary = HtmlUtil.extractText(StringUtil.shorten(
				typeTask.getDescription(), 500));

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				typeTask.getGroupId(), typeTask.getCreateDate(),
				typeTask.getModifiedDate(), TypeTask.class.getName(),
				typeTask.getTypeTaskId(), typeTask.getUuid(), 0,
				assetCategoryIds, assetTagNames, visible, null, null, null,
				ContentTypes.TEXT_HTML, typeTask.getName(),
				typeTask.getDescription(), summary, null, null, 0, 0, null,
				false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}

	@Override
	public TypeTask getTypeTask(long typeTaskId) throws PortalException,
	SystemException {

		return typeTaskPersistence.findByPrimaryKey(typeTaskId);
	}

	public TypeTask findByClassPK_Other(long classPK) throws PortalException,
			SystemException {

		return typeTaskPersistence.findByTypeTaskClassPK(classPK);
	}

	protected String getExtraDataJSON(TypeTask type, Locale locale) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("name", type.getName(locale));

		return jsonObject.toString();
	}

	protected long saveStructure(long typeTaskId, long groupId,
			long DDMStructureId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String xsd, long userId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		// Save structure
		long classNameId = PortalUtil.getClassNameId(TypeTask.class);
		String structureKey = String.valueOf(classNameId) + StringPool.MINUS
				+ String.valueOf(typeTaskId);
		String storageType = "xml";

		if (DDMStructureId > 0) {
			DDMStructure ddmStructure = DDMStructureLocalServiceUtil
					.updateStructure(DDMStructureId, 0, nameMap,
							descriptionMap, xsd, serviceContext);
			DDMStructureId = ddmStructure.getStructureId();
		} else {
			if (Validator.isNotNull(xsd)) {
				DDMStructure ddmStructure = DDMStructureLocalServiceUtil
						.addStructure(userId, groupId, 0, classNameId,
								structureKey, nameMap, descriptionMap, xsd,
								storageType, 0, serviceContext);
				DDMStructureId = ddmStructure.getStructureId();
			}
		}
		return DDMStructureId;
	}

	protected void validate(Map<Locale, String> nameMap, Locale locale)
			throws PortalException, SystemException {

		String name = nameMap.get(locale);

		if (Validator.isNull(name)) {
			throw new RequiredTypeTaskNameException();
		}
	}
}