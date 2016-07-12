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

package br.com.prodevelopment.etask.model;

import br.com.prodevelopment.etask.service.ClpSerializer;
import br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil;

import com.liferay.portal.LocaleException;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.ContainerModel;
import com.liferay.portal.model.TrashedModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.trash.model.TrashEntry;
import com.liferay.portlet.trash.service.TrashEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Marcelo Melo
 */
public class TypeTaskClp extends BaseModelImpl<TypeTask> implements TypeTask {
	public TypeTaskClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TypeTask.class;
	}

	@Override
	public String getModelClassName() {
		return TypeTask.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _typeTaskId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTypeTaskId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _typeTaskId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("typeTaskId", getTypeTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userIdCreate", getUserIdCreate());
		attributes.put("userIdModified", getUserIdModified());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("DDMStructureId", getDDMStructureId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("customFieldsActive", getCustomFieldsActive());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long typeTaskId = (Long)attributes.get("typeTaskId");

		if (typeTaskId != null) {
			setTypeTaskId(typeTaskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userIdCreate = (Long)attributes.get("userIdCreate");

		if (userIdCreate != null) {
			setUserIdCreate(userIdCreate);
		}

		Long userIdModified = (Long)attributes.get("userIdModified");

		if (userIdModified != null) {
			setUserIdModified(userIdModified);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long DDMStructureId = (Long)attributes.get("DDMStructureId");

		if (DDMStructureId != null) {
			setDDMStructureId(DDMStructureId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Boolean customFieldsActive = (Boolean)attributes.get(
				"customFieldsActive");

		if (customFieldsActive != null) {
			setCustomFieldsActive(customFieldsActive);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_typeTaskRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTypeTaskId() {
		return _typeTaskId;
	}

	@Override
	public void setTypeTaskId(long typeTaskId) {
		_typeTaskId = typeTaskId;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeTaskId", long.class);

				method.invoke(_typeTaskRemoteModel, typeTaskId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_typeTaskRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_typeTaskRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserIdCreate() {
		return _userIdCreate;
	}

	@Override
	public void setUserIdCreate(long userIdCreate) {
		_userIdCreate = userIdCreate;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdCreate", long.class);

				method.invoke(_typeTaskRemoteModel, userIdCreate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserIdModified() {
		return _userIdModified;
	}

	@Override
	public void setUserIdModified(long userIdModified) {
		_userIdModified = userIdModified;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdModified", long.class);

				method.invoke(_typeTaskRemoteModel, userIdModified);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_typeTaskRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_typeTaskRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_typeTaskRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setName(LocalizationUtil.updateLocalization(nameMap, getName(),
					"Name", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_typeTaskRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setDescription(LocalizationUtil.updateLocalization(descriptionMap,
					getDescription(), "Description",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getDDMStructureId() {
		return _DDMStructureId;
	}

	@Override
	public void setDDMStructureId(long DDMStructureId) {
		_DDMStructureId = DDMStructureId;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setDDMStructureId", long.class);

				method.invoke(_typeTaskRemoteModel, DDMStructureId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_typeTaskRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_typeTaskRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_typeTaskRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_typeTaskRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCustomFieldsActive() {
		return _customFieldsActive;
	}

	@Override
	public boolean isCustomFieldsActive() {
		return _customFieldsActive;
	}

	@Override
	public void setCustomFieldsActive(boolean customFieldsActive) {
		_customFieldsActive = customFieldsActive;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomFieldsActive",
						boolean.class);

				method.invoke(_typeTaskRemoteModel, customFieldsActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_typeTaskRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_typeTaskRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_typeTaskRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				TypeTask.class.getName()), getClassNameId());
	}

	@Override
	public TrashEntry getTrashEntry() throws PortalException, SystemException {
		if (!isInTrash()) {
			return null;
		}

		TrashEntry trashEntry = TrashEntryLocalServiceUtil.fetchEntry(getModelClassName(),
				getTrashEntryClassPK());

		if (trashEntry != null) {
			return trashEntry;
		}

		TrashHandler trashHandler = getTrashHandler();

		if (!Validator.isNull(trashHandler.getContainerModelClassName())) {
			ContainerModel containerModel = null;

			try {
				containerModel = trashHandler.getParentContainerModel(this);
			}
			catch (NoSuchModelException nsme) {
				return null;
			}

			while (containerModel != null) {
				if (containerModel instanceof TrashedModel) {
					TrashedModel trashedModel = (TrashedModel)containerModel;

					return trashedModel.getTrashEntry();
				}

				trashHandler = TrashHandlerRegistryUtil.getTrashHandler(trashHandler.getContainerModelClassName());

				if (trashHandler == null) {
					return null;
				}

				containerModel = trashHandler.getContainerModel(containerModel.getParentContainerModelId());
			}
		}

		return null;
	}

	@Override
	public long getTrashEntryClassPK() {
		return getPrimaryKey();
	}

	@Override
	public TrashHandler getTrashHandler() {
		return TrashHandlerRegistryUtil.getTrashHandler(getModelClassName());
	}

	@Override
	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInTrashContainer() {
		TrashHandler trashHandler = getTrashHandler();

		if ((trashHandler == null) ||
				Validator.isNull(trashHandler.getContainerModelClassName())) {
			return false;
		}

		try {
			ContainerModel containerModel = trashHandler.getParentContainerModel(this);

			if (containerModel == null) {
				return false;
			}

			if (containerModel instanceof TrashedModel) {
				return ((TrashedModel)containerModel).isInTrash();
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public BaseModel<?> getTypeTaskRemoteModel() {
		return _typeTaskRemoteModel;
	}

	public void setTypeTaskRemoteModel(BaseModel<?> typeTaskRemoteModel) {
		_typeTaskRemoteModel = typeTaskRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _typeTaskRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_typeTaskRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TypeTaskLocalServiceUtil.addTypeTask(this);
		}
		else {
			TypeTaskLocalServiceUtil.updateTypeTask(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(getDescription(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public TypeTask toEscapedModel() {
		return (TypeTask)ProxyUtil.newProxyInstance(TypeTask.class.getClassLoader(),
			new Class[] { TypeTask.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TypeTaskClp clone = new TypeTaskClp();

		clone.setUuid(getUuid());
		clone.setTypeTaskId(getTypeTaskId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserIdCreate(getUserIdCreate());
		clone.setUserIdModified(getUserIdModified());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setDDMStructureId(getDDMStructureId());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setCustomFieldsActive(getCustomFieldsActive());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());

		return clone;
	}

	@Override
	public int compareTo(TypeTask typeTask) {
		int value = 0;

		value = getName().compareTo(typeTask.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeTaskClp)) {
			return false;
		}

		TypeTaskClp typeTask = (TypeTaskClp)obj;

		long primaryKey = typeTask.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", typeTaskId=");
		sb.append(getTypeTaskId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userIdCreate=");
		sb.append(getUserIdCreate());
		sb.append(", userIdModified=");
		sb.append(getUserIdModified());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", DDMStructureId=");
		sb.append(getDDMStructureId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", customFieldsActive=");
		sb.append(getCustomFieldsActive());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.etask.model.TypeTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeTaskId</column-name><column-value><![CDATA[");
		sb.append(getTypeTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdCreate</column-name><column-value><![CDATA[");
		sb.append(getUserIdCreate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdModified</column-name><column-value><![CDATA[");
		sb.append(getUserIdModified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DDMStructureId</column-name><column-value><![CDATA[");
		sb.append(getDDMStructureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customFieldsActive</column-name><column-value><![CDATA[");
		sb.append(getCustomFieldsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _typeTaskId;
	private long _groupId;
	private long _companyId;
	private long _userIdCreate;
	private long _userIdModified;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private long _DDMStructureId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private boolean _customFieldsActive;
	private long _classNameId;
	private long _classPK;
	private BaseModel<?> _typeTaskRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.etask.service.ClpSerializer.class;
}