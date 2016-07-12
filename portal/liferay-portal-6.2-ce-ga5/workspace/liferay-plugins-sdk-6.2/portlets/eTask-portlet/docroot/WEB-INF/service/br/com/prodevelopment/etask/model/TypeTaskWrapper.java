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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TypeTask}.
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTask
 * @generated
 */
public class TypeTaskWrapper implements TypeTask, ModelWrapper<TypeTask> {
	public TypeTaskWrapper(TypeTask typeTask) {
		_typeTask = typeTask;
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

	/**
	* Returns the primary key of this type task.
	*
	* @return the primary key of this type task
	*/
	@Override
	public long getPrimaryKey() {
		return _typeTask.getPrimaryKey();
	}

	/**
	* Sets the primary key of this type task.
	*
	* @param primaryKey the primary key of this type task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_typeTask.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this type task.
	*
	* @return the uuid of this type task
	*/
	@Override
	public java.lang.String getUuid() {
		return _typeTask.getUuid();
	}

	/**
	* Sets the uuid of this type task.
	*
	* @param uuid the uuid of this type task
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_typeTask.setUuid(uuid);
	}

	/**
	* Returns the type task ID of this type task.
	*
	* @return the type task ID of this type task
	*/
	@Override
	public long getTypeTaskId() {
		return _typeTask.getTypeTaskId();
	}

	/**
	* Sets the type task ID of this type task.
	*
	* @param typeTaskId the type task ID of this type task
	*/
	@Override
	public void setTypeTaskId(long typeTaskId) {
		_typeTask.setTypeTaskId(typeTaskId);
	}

	/**
	* Returns the group ID of this type task.
	*
	* @return the group ID of this type task
	*/
	@Override
	public long getGroupId() {
		return _typeTask.getGroupId();
	}

	/**
	* Sets the group ID of this type task.
	*
	* @param groupId the group ID of this type task
	*/
	@Override
	public void setGroupId(long groupId) {
		_typeTask.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this type task.
	*
	* @return the company ID of this type task
	*/
	@Override
	public long getCompanyId() {
		return _typeTask.getCompanyId();
	}

	/**
	* Sets the company ID of this type task.
	*
	* @param companyId the company ID of this type task
	*/
	@Override
	public void setCompanyId(long companyId) {
		_typeTask.setCompanyId(companyId);
	}

	/**
	* Returns the user ID create of this type task.
	*
	* @return the user ID create of this type task
	*/
	@Override
	public long getUserIdCreate() {
		return _typeTask.getUserIdCreate();
	}

	/**
	* Sets the user ID create of this type task.
	*
	* @param userIdCreate the user ID create of this type task
	*/
	@Override
	public void setUserIdCreate(long userIdCreate) {
		_typeTask.setUserIdCreate(userIdCreate);
	}

	/**
	* Returns the user ID modified of this type task.
	*
	* @return the user ID modified of this type task
	*/
	@Override
	public long getUserIdModified() {
		return _typeTask.getUserIdModified();
	}

	/**
	* Sets the user ID modified of this type task.
	*
	* @param userIdModified the user ID modified of this type task
	*/
	@Override
	public void setUserIdModified(long userIdModified) {
		_typeTask.setUserIdModified(userIdModified);
	}

	/**
	* Returns the create date of this type task.
	*
	* @return the create date of this type task
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _typeTask.getCreateDate();
	}

	/**
	* Sets the create date of this type task.
	*
	* @param createDate the create date of this type task
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_typeTask.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this type task.
	*
	* @return the modified date of this type task
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _typeTask.getModifiedDate();
	}

	/**
	* Sets the modified date of this type task.
	*
	* @param modifiedDate the modified date of this type task
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_typeTask.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this type task.
	*
	* @return the name of this type task
	*/
	@Override
	public java.lang.String getName() {
		return _typeTask.getName();
	}

	/**
	* Returns the localized name of this type task in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this type task
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _typeTask.getName(locale);
	}

	/**
	* Returns the localized name of this type task in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this type task. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _typeTask.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this type task in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this type task
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _typeTask.getName(languageId);
	}

	/**
	* Returns the localized name of this type task in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this type task
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _typeTask.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _typeTask.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _typeTask.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this type task.
	*
	* @return the locales and localized names of this type task
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _typeTask.getNameMap();
	}

	/**
	* Sets the name of this type task.
	*
	* @param name the name of this type task
	*/
	@Override
	public void setName(java.lang.String name) {
		_typeTask.setName(name);
	}

	/**
	* Sets the localized name of this type task in the language.
	*
	* @param name the localized name of this type task
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_typeTask.setName(name, locale);
	}

	/**
	* Sets the localized name of this type task in the language, and sets the default locale.
	*
	* @param name the localized name of this type task
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_typeTask.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_typeTask.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this type task from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this type task
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_typeTask.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this type task from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this type task
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_typeTask.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the description of this type task.
	*
	* @return the description of this type task
	*/
	@Override
	public java.lang.String getDescription() {
		return _typeTask.getDescription();
	}

	/**
	* Returns the localized description of this type task in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this type task
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _typeTask.getDescription(locale);
	}

	/**
	* Returns the localized description of this type task in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this type task. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _typeTask.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this type task in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this type task
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _typeTask.getDescription(languageId);
	}

	/**
	* Returns the localized description of this type task in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this type task
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _typeTask.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _typeTask.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _typeTask.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this type task.
	*
	* @return the locales and localized descriptions of this type task
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _typeTask.getDescriptionMap();
	}

	/**
	* Sets the description of this type task.
	*
	* @param description the description of this type task
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_typeTask.setDescription(description);
	}

	/**
	* Sets the localized description of this type task in the language.
	*
	* @param description the localized description of this type task
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_typeTask.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this type task in the language, and sets the default locale.
	*
	* @param description the localized description of this type task
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_typeTask.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_typeTask.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this type task from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this type task
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_typeTask.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this type task from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this type task
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_typeTask.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the d d m structure ID of this type task.
	*
	* @return the d d m structure ID of this type task
	*/
	@Override
	public long getDDMStructureId() {
		return _typeTask.getDDMStructureId();
	}

	/**
	* Sets the d d m structure ID of this type task.
	*
	* @param DDMStructureId the d d m structure ID of this type task
	*/
	@Override
	public void setDDMStructureId(long DDMStructureId) {
		_typeTask.setDDMStructureId(DDMStructureId);
	}

	/**
	* Returns the status of this type task.
	*
	* @return the status of this type task
	*/
	@Override
	public int getStatus() {
		return _typeTask.getStatus();
	}

	/**
	* Sets the status of this type task.
	*
	* @param status the status of this type task
	*/
	@Override
	public void setStatus(int status) {
		_typeTask.setStatus(status);
	}

	/**
	* Returns the status by user ID of this type task.
	*
	* @return the status by user ID of this type task
	*/
	@Override
	public long getStatusByUserId() {
		return _typeTask.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this type task.
	*
	* @param statusByUserId the status by user ID of this type task
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_typeTask.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this type task.
	*
	* @return the status by user uuid of this type task
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTask.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this type task.
	*
	* @param statusByUserUuid the status by user uuid of this type task
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_typeTask.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this type task.
	*
	* @return the status by user name of this type task
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _typeTask.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this type task.
	*
	* @param statusByUserName the status by user name of this type task
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_typeTask.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this type task.
	*
	* @return the status date of this type task
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _typeTask.getStatusDate();
	}

	/**
	* Sets the status date of this type task.
	*
	* @param statusDate the status date of this type task
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_typeTask.setStatusDate(statusDate);
	}

	/**
	* Returns the custom fields active of this type task.
	*
	* @return the custom fields active of this type task
	*/
	@Override
	public boolean getCustomFieldsActive() {
		return _typeTask.getCustomFieldsActive();
	}

	/**
	* Returns <code>true</code> if this type task is custom fields active.
	*
	* @return <code>true</code> if this type task is custom fields active; <code>false</code> otherwise
	*/
	@Override
	public boolean isCustomFieldsActive() {
		return _typeTask.isCustomFieldsActive();
	}

	/**
	* Sets whether this type task is custom fields active.
	*
	* @param customFieldsActive the custom fields active of this type task
	*/
	@Override
	public void setCustomFieldsActive(boolean customFieldsActive) {
		_typeTask.setCustomFieldsActive(customFieldsActive);
	}

	/**
	* Returns the fully qualified class name of this type task.
	*
	* @return the fully qualified class name of this type task
	*/
	@Override
	public java.lang.String getClassName() {
		return _typeTask.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_typeTask.setClassName(className);
	}

	/**
	* Returns the class name ID of this type task.
	*
	* @return the class name ID of this type task
	*/
	@Override
	public long getClassNameId() {
		return _typeTask.getClassNameId();
	}

	/**
	* Sets the class name ID of this type task.
	*
	* @param classNameId the class name ID of this type task
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_typeTask.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this type task.
	*
	* @return the class p k of this type task
	*/
	@Override
	public long getClassPK() {
		return _typeTask.getClassPK();
	}

	/**
	* Sets the class p k of this type task.
	*
	* @param classPK the class p k of this type task
	*/
	@Override
	public void setClassPK(long classPK) {
		_typeTask.setClassPK(classPK);
	}

	/**
	* Returns the trash entry created when this type task was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this type task.
	*
	* @return the trash entry created when this type task was moved to the Recycle Bin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTask.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this type task.
	*
	* @return the class primary key of the trash entry for this type task
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _typeTask.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this type task.
	*
	* @return the trash handler for this type task
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _typeTask.getTrashHandler();
	}

	/**
	* Returns <code>true</code> if this type task is in the Recycle Bin.
	*
	* @return <code>true</code> if this type task is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _typeTask.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this type task is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this type task is in the Recycle Bin; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean isInTrashContainer() {
		return _typeTask.isInTrashContainer();
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _typeTask.getApproved();
	}

	/**
	* Returns <code>true</code> if this type task is approved.
	*
	* @return <code>true</code> if this type task is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _typeTask.isApproved();
	}

	/**
	* Returns <code>true</code> if this type task is denied.
	*
	* @return <code>true</code> if this type task is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _typeTask.isDenied();
	}

	/**
	* Returns <code>true</code> if this type task is a draft.
	*
	* @return <code>true</code> if this type task is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _typeTask.isDraft();
	}

	/**
	* Returns <code>true</code> if this type task is expired.
	*
	* @return <code>true</code> if this type task is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _typeTask.isExpired();
	}

	/**
	* Returns <code>true</code> if this type task is inactive.
	*
	* @return <code>true</code> if this type task is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _typeTask.isInactive();
	}

	/**
	* Returns <code>true</code> if this type task is incomplete.
	*
	* @return <code>true</code> if this type task is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _typeTask.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this type task is pending.
	*
	* @return <code>true</code> if this type task is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _typeTask.isPending();
	}

	/**
	* Returns <code>true</code> if this type task is scheduled.
	*
	* @return <code>true</code> if this type task is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _typeTask.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _typeTask.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_typeTask.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _typeTask.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_typeTask.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _typeTask.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _typeTask.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_typeTask.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _typeTask.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_typeTask.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_typeTask.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_typeTask.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _typeTask.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _typeTask.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_typeTask.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_typeTask.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new TypeTaskWrapper((TypeTask)_typeTask.clone());
	}

	@Override
	public int compareTo(br.com.prodevelopment.etask.model.TypeTask typeTask) {
		return _typeTask.compareTo(typeTask);
	}

	@Override
	public int hashCode() {
		return _typeTask.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.etask.model.TypeTask> toCacheModel() {
		return _typeTask.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask toEscapedModel() {
		return new TypeTaskWrapper(_typeTask.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTask toUnescapedModel() {
		return new TypeTaskWrapper(_typeTask.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _typeTask.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _typeTask.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_typeTask.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeTaskWrapper)) {
			return false;
		}

		TypeTaskWrapper typeTaskWrapper = (TypeTaskWrapper)obj;

		if (Validator.equals(_typeTask, typeTaskWrapper._typeTask)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _typeTask.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TypeTask getWrappedTypeTask() {
		return _typeTask;
	}

	@Override
	public TypeTask getWrappedModel() {
		return _typeTask;
	}

	@Override
	public void resetOriginalValues() {
		_typeTask.resetOriginalValues();
	}

	private TypeTask _typeTask;
}