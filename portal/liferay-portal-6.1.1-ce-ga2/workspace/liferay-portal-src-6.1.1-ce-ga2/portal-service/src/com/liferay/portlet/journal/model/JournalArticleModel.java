/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.journal.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.ResourcedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the JournalArticle service. Represents a row in the &quot;JournalArticle&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.journal.model.impl.JournalArticleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.journal.model.impl.JournalArticleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticle
 * @see com.liferay.portlet.journal.model.impl.JournalArticleImpl
 * @see com.liferay.portlet.journal.model.impl.JournalArticleModelImpl
 * @generated
 */
public interface JournalArticleModel extends AttachedModel,
	BaseModel<JournalArticle>, GroupedModel, ResourcedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a journal article model instance should use the {@link JournalArticle} interface instead.
	 */

	/**
	 * Returns the primary key of this journal article.
	 *
	 * @return the primary key of this journal article
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this journal article.
	 *
	 * @param primaryKey the primary key of this journal article
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this journal article.
	 *
	 * @return the uuid of this journal article
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this journal article.
	 *
	 * @param uuid the uuid of this journal article
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this journal article.
	 *
	 * @return the ID of this journal article
	 */
	public long getId();

	/**
	 * Sets the ID of this journal article.
	 *
	 * @param id the ID of this journal article
	 */
	public void setId(long id);

	/**
	 * Returns the resource prim key of this journal article.
	 *
	 * @return the resource prim key of this journal article
	 */
	public long getResourcePrimKey();

	/**
	 * Sets the resource prim key of this journal article.
	 *
	 * @param resourcePrimKey the resource prim key of this journal article
	 */
	public void setResourcePrimKey(long resourcePrimKey);

	public boolean isResourceMain();

	/**
	 * Returns the group ID of this journal article.
	 *
	 * @return the group ID of this journal article
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this journal article.
	 *
	 * @param groupId the group ID of this journal article
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this journal article.
	 *
	 * @return the company ID of this journal article
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this journal article.
	 *
	 * @param companyId the company ID of this journal article
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this journal article.
	 *
	 * @return the user ID of this journal article
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this journal article.
	 *
	 * @param userId the user ID of this journal article
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this journal article.
	 *
	 * @return the user uuid of this journal article
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this journal article.
	 *
	 * @param userUuid the user uuid of this journal article
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this journal article.
	 *
	 * @return the user name of this journal article
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this journal article.
	 *
	 * @param userName the user name of this journal article
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this journal article.
	 *
	 * @return the create date of this journal article
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this journal article.
	 *
	 * @param createDate the create date of this journal article
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this journal article.
	 *
	 * @return the modified date of this journal article
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this journal article.
	 *
	 * @param modifiedDate the modified date of this journal article
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this journal article.
	 *
	 * @return the fully qualified class name of this journal article
	 */
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this journal article.
	 *
	 * @return the class name ID of this journal article
	 */
	public long getClassNameId();

	/**
	 * Sets the class name ID of this journal article.
	 *
	 * @param classNameId the class name ID of this journal article
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this journal article.
	 *
	 * @return the class p k of this journal article
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this journal article.
	 *
	 * @param classPK the class p k of this journal article
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the article ID of this journal article.
	 *
	 * @return the article ID of this journal article
	 */
	public String getArticleId();

	/**
	 * Sets the article ID of this journal article.
	 *
	 * @param articleId the article ID of this journal article
	 */
	public void setArticleId(String articleId);

	/**
	 * Returns the version of this journal article.
	 *
	 * @return the version of this journal article
	 */
	public double getVersion();

	/**
	 * Sets the version of this journal article.
	 *
	 * @param version the version of this journal article
	 */
	public void setVersion(double version);

	/**
	 * Returns the title of this journal article.
	 *
	 * @return the title of this journal article
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this journal article in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this journal article
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this journal article in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this journal article. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this journal article in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this journal article
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this journal article in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this journal article
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this journal article.
	 *
	 * @return the locales and localized titles of this journal article
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this journal article.
	 *
	 * @param title the title of this journal article
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this journal article in the language.
	 *
	 * @param title the localized title of this journal article
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this journal article in the language, and sets the default locale.
	 *
	 * @param title the localized title of this journal article
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this journal article from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this journal article
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this journal article from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this journal article
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the url title of this journal article.
	 *
	 * @return the url title of this journal article
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this journal article.
	 *
	 * @param urlTitle the url title of this journal article
	 */
	public void setUrlTitle(String urlTitle);

	/**
	 * Returns the description of this journal article.
	 *
	 * @return the description of this journal article
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this journal article in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this journal article
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this journal article in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this journal article. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this journal article in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this journal article
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this journal article in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this journal article
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this journal article.
	 *
	 * @return the locales and localized descriptions of this journal article
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this journal article.
	 *
	 * @param description the description of this journal article
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this journal article in the language.
	 *
	 * @param description the localized description of this journal article
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this journal article in the language, and sets the default locale.
	 *
	 * @param description the localized description of this journal article
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this journal article from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this journal article
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this journal article from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this journal article
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the content of this journal article.
	 *
	 * @return the content of this journal article
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this journal article.
	 *
	 * @param content the content of this journal article
	 */
	public void setContent(String content);

	/**
	 * Returns the type of this journal article.
	 *
	 * @return the type of this journal article
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this journal article.
	 *
	 * @param type the type of this journal article
	 */
	public void setType(String type);

	/**
	 * Returns the structure ID of this journal article.
	 *
	 * @return the structure ID of this journal article
	 */
	public String getStructureId();

	/**
	 * Sets the structure ID of this journal article.
	 *
	 * @param structureId the structure ID of this journal article
	 */
	public void setStructureId(String structureId);

	/**
	 * Returns the template ID of this journal article.
	 *
	 * @return the template ID of this journal article
	 */
	public String getTemplateId();

	/**
	 * Sets the template ID of this journal article.
	 *
	 * @param templateId the template ID of this journal article
	 */
	public void setTemplateId(String templateId);

	/**
	 * Returns the layout uuid of this journal article.
	 *
	 * @return the layout uuid of this journal article
	 */
	@AutoEscape
	public String getLayoutUuid();

	/**
	 * Sets the layout uuid of this journal article.
	 *
	 * @param layoutUuid the layout uuid of this journal article
	 */
	public void setLayoutUuid(String layoutUuid);

	/**
	 * Returns the display date of this journal article.
	 *
	 * @return the display date of this journal article
	 */
	public Date getDisplayDate();

	/**
	 * Sets the display date of this journal article.
	 *
	 * @param displayDate the display date of this journal article
	 */
	public void setDisplayDate(Date displayDate);

	/**
	 * Returns the expiration date of this journal article.
	 *
	 * @return the expiration date of this journal article
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this journal article.
	 *
	 * @param expirationDate the expiration date of this journal article
	 */
	public void setExpirationDate(Date expirationDate);

	/**
	 * Returns the review date of this journal article.
	 *
	 * @return the review date of this journal article
	 */
	public Date getReviewDate();

	/**
	 * Sets the review date of this journal article.
	 *
	 * @param reviewDate the review date of this journal article
	 */
	public void setReviewDate(Date reviewDate);

	/**
	 * Returns the indexable of this journal article.
	 *
	 * @return the indexable of this journal article
	 */
	public boolean getIndexable();

	/**
	 * Returns <code>true</code> if this journal article is indexable.
	 *
	 * @return <code>true</code> if this journal article is indexable; <code>false</code> otherwise
	 */
	public boolean isIndexable();

	/**
	 * Sets whether this journal article is indexable.
	 *
	 * @param indexable the indexable of this journal article
	 */
	public void setIndexable(boolean indexable);

	/**
	 * Returns the small image of this journal article.
	 *
	 * @return the small image of this journal article
	 */
	public boolean getSmallImage();

	/**
	 * Returns <code>true</code> if this journal article is small image.
	 *
	 * @return <code>true</code> if this journal article is small image; <code>false</code> otherwise
	 */
	public boolean isSmallImage();

	/**
	 * Sets whether this journal article is small image.
	 *
	 * @param smallImage the small image of this journal article
	 */
	public void setSmallImage(boolean smallImage);

	/**
	 * Returns the small image ID of this journal article.
	 *
	 * @return the small image ID of this journal article
	 */
	public long getSmallImageId();

	/**
	 * Sets the small image ID of this journal article.
	 *
	 * @param smallImageId the small image ID of this journal article
	 */
	public void setSmallImageId(long smallImageId);

	/**
	 * Returns the small image u r l of this journal article.
	 *
	 * @return the small image u r l of this journal article
	 */
	@AutoEscape
	public String getSmallImageURL();

	/**
	 * Sets the small image u r l of this journal article.
	 *
	 * @param smallImageURL the small image u r l of this journal article
	 */
	public void setSmallImageURL(String smallImageURL);

	/**
	 * Returns the status of this journal article.
	 *
	 * @return the status of this journal article
	 */
	public int getStatus();

	/**
	 * Sets the status of this journal article.
	 *
	 * @param status the status of this journal article
	 */
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this journal article.
	 *
	 * @return the status by user ID of this journal article
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this journal article.
	 *
	 * @param statusByUserId the status by user ID of this journal article
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this journal article.
	 *
	 * @return the status by user uuid of this journal article
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this journal article.
	 *
	 * @param statusByUserUuid the status by user uuid of this journal article
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this journal article.
	 *
	 * @return the status by user name of this journal article
	 */
	@AutoEscape
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this journal article.
	 *
	 * @param statusByUserName the status by user name of this journal article
	 */
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this journal article.
	 *
	 * @return the status date of this journal article
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this journal article.
	 *
	 * @param statusDate the status date of this journal article
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * @deprecated Renamed to {@link #isApproved()}
	 */
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this journal article is approved.
	 *
	 * @return <code>true</code> if this journal article is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this journal article is denied.
	 *
	 * @return <code>true</code> if this journal article is denied; <code>false</code> otherwise
	 */
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this journal article is a draft.
	 *
	 * @return <code>true</code> if this journal article is a draft; <code>false</code> otherwise
	 */
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this journal article is expired.
	 *
	 * @return <code>true</code> if this journal article is expired; <code>false</code> otherwise
	 */
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this journal article is inactive.
	 *
	 * @return <code>true</code> if this journal article is inactive; <code>false</code> otherwise
	 */
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this journal article is incomplete.
	 *
	 * @return <code>true</code> if this journal article is incomplete; <code>false</code> otherwise
	 */
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this journal article is pending.
	 *
	 * @return <code>true</code> if this journal article is pending; <code>false</code> otherwise
	 */
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this journal article is scheduled.
	 *
	 * @return <code>true</code> if this journal article is scheduled; <code>false</code> otherwise
	 */
	public boolean isScheduled();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	public Object clone();

	public int compareTo(JournalArticle journalArticle);

	public int hashCode();

	public CacheModel<JournalArticle> toCacheModel();

	public JournalArticle toEscapedModel();

	public String toString();

	public String toXmlString();
}