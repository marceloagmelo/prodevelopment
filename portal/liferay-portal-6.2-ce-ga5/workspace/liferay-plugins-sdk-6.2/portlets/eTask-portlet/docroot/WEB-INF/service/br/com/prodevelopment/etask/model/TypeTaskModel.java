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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.model.TrashedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.trash.model.TrashEntry;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the TypeTask service. Represents a row in the &quot;etsk_TypeTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.prodevelopment.etask.model.impl.TypeTaskImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTask
 * @see br.com.prodevelopment.etask.model.impl.TypeTaskImpl
 * @see br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl
 * @generated
 */
public interface TypeTaskModel extends AttachedModel, BaseModel<TypeTask>,
	StagedModel, TrashedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a type task model instance should use the {@link TypeTask} interface instead.
	 */

	/**
	 * Returns the primary key of this type task.
	 *
	 * @return the primary key of this type task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this type task.
	 *
	 * @param primaryKey the primary key of this type task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this type task.
	 *
	 * @return the uuid of this type task
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this type task.
	 *
	 * @param uuid the uuid of this type task
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the type task ID of this type task.
	 *
	 * @return the type task ID of this type task
	 */
	public long getTypeTaskId();

	/**
	 * Sets the type task ID of this type task.
	 *
	 * @param typeTaskId the type task ID of this type task
	 */
	public void setTypeTaskId(long typeTaskId);

	/**
	 * Returns the group ID of this type task.
	 *
	 * @return the group ID of this type task
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this type task.
	 *
	 * @param groupId the group ID of this type task
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this type task.
	 *
	 * @return the company ID of this type task
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this type task.
	 *
	 * @param companyId the company ID of this type task
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID create of this type task.
	 *
	 * @return the user ID create of this type task
	 */
	public long getUserIdCreate();

	/**
	 * Sets the user ID create of this type task.
	 *
	 * @param userIdCreate the user ID create of this type task
	 */
	public void setUserIdCreate(long userIdCreate);

	/**
	 * Returns the user ID modified of this type task.
	 *
	 * @return the user ID modified of this type task
	 */
	public long getUserIdModified();

	/**
	 * Sets the user ID modified of this type task.
	 *
	 * @param userIdModified the user ID modified of this type task
	 */
	public void setUserIdModified(long userIdModified);

	/**
	 * Returns the create date of this type task.
	 *
	 * @return the create date of this type task
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this type task.
	 *
	 * @param createDate the create date of this type task
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this type task.
	 *
	 * @return the modified date of this type task
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this type task.
	 *
	 * @param modifiedDate the modified date of this type task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this type task.
	 *
	 * @return the name of this type task
	 */
	public String getName();

	/**
	 * Returns the localized name of this type task in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this type task
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this type task in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this type task. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this type task in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this type task
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this type task in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this type task
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this type task.
	 *
	 * @return the locales and localized names of this type task
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this type task.
	 *
	 * @param name the name of this type task
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this type task in the language.
	 *
	 * @param name the localized name of this type task
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this type task in the language, and sets the default locale.
	 *
	 * @param name the localized name of this type task
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this type task from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this type task
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this type task from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this type task
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the description of this type task.
	 *
	 * @return the description of this type task
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this type task in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this type task
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this type task in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this type task. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this type task in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this type task
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this type task in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this type task
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this type task.
	 *
	 * @return the locales and localized descriptions of this type task
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this type task.
	 *
	 * @param description the description of this type task
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this type task in the language.
	 *
	 * @param description the localized description of this type task
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this type task in the language, and sets the default locale.
	 *
	 * @param description the localized description of this type task
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this type task from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this type task
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this type task from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this type task
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the d d m structure ID of this type task.
	 *
	 * @return the d d m structure ID of this type task
	 */
	public long getDDMStructureId();

	/**
	 * Sets the d d m structure ID of this type task.
	 *
	 * @param DDMStructureId the d d m structure ID of this type task
	 */
	public void setDDMStructureId(long DDMStructureId);

	/**
	 * Returns the status of this type task.
	 *
	 * @return the status of this type task
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this type task.
	 *
	 * @param status the status of this type task
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this type task.
	 *
	 * @return the status by user ID of this type task
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this type task.
	 *
	 * @param statusByUserId the status by user ID of this type task
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this type task.
	 *
	 * @return the status by user uuid of this type task
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this type task.
	 *
	 * @param statusByUserUuid the status by user uuid of this type task
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this type task.
	 *
	 * @return the status by user name of this type task
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this type task.
	 *
	 * @param statusByUserName the status by user name of this type task
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this type task.
	 *
	 * @return the status date of this type task
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this type task.
	 *
	 * @param statusDate the status date of this type task
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the custom fields active of this type task.
	 *
	 * @return the custom fields active of this type task
	 */
	public boolean getCustomFieldsActive();

	/**
	 * Returns <code>true</code> if this type task is custom fields active.
	 *
	 * @return <code>true</code> if this type task is custom fields active; <code>false</code> otherwise
	 */
	public boolean isCustomFieldsActive();

	/**
	 * Sets whether this type task is custom fields active.
	 *
	 * @param customFieldsActive the custom fields active of this type task
	 */
	public void setCustomFieldsActive(boolean customFieldsActive);

	/**
	 * Returns the fully qualified class name of this type task.
	 *
	 * @return the fully qualified class name of this type task
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this type task.
	 *
	 * @return the class name ID of this type task
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this type task.
	 *
	 * @param classNameId the class name ID of this type task
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this type task.
	 *
	 * @return the class p k of this type task
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class p k of this type task.
	 *
	 * @param classPK the class p k of this type task
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the trash entry created when this type task was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this type task.
	 *
	 * @return the trash entry created when this type task was moved to the Recycle Bin
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrashEntry getTrashEntry() throws PortalException, SystemException;

	/**
	 * Returns the class primary key of the trash entry for this type task.
	 *
	 * @return the class primary key of the trash entry for this type task
	 */
	@Override
	public long getTrashEntryClassPK();

	/**
	 * Returns the trash handler for this type task.
	 *
	 * @return the trash handler for this type task
	 */
	@Override
	public TrashHandler getTrashHandler();

	/**
	 * Returns <code>true</code> if this type task is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this type task is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash();

	/**
	 * Returns <code>true</code> if the parent of this type task is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this type task is in the Recycle Bin; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean isInTrashContainer();

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	 */
	@Override
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this type task is approved.
	 *
	 * @return <code>true</code> if this type task is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this type task is denied.
	 *
	 * @return <code>true</code> if this type task is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this type task is a draft.
	 *
	 * @return <code>true</code> if this type task is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this type task is expired.
	 *
	 * @return <code>true</code> if this type task is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this type task is inactive.
	 *
	 * @return <code>true</code> if this type task is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this type task is incomplete.
	 *
	 * @return <code>true</code> if this type task is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this type task is pending.
	 *
	 * @return <code>true</code> if this type task is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this type task is scheduled.
	 *
	 * @return <code>true</code> if this type task is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public String[] getAvailableLanguageIds();

	public String getDefaultLanguageId();

	public void prepareLocalizedFieldsForImport() throws LocaleException;

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(br.com.prodevelopment.etask.model.TypeTask typeTask);

	@Override
	public int hashCode();

	@Override
	public CacheModel<br.com.prodevelopment.etask.model.TypeTask> toCacheModel();

	@Override
	public br.com.prodevelopment.etask.model.TypeTask toEscapedModel();

	@Override
	public br.com.prodevelopment.etask.model.TypeTask toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}