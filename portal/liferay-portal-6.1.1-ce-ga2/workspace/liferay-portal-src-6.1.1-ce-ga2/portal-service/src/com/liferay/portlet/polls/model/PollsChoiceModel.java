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

package com.liferay.portlet.polls.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the PollsChoice service. Represents a row in the &quot;PollsChoice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.polls.model.impl.PollsChoiceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.polls.model.impl.PollsChoiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PollsChoice
 * @see com.liferay.portlet.polls.model.impl.PollsChoiceImpl
 * @see com.liferay.portlet.polls.model.impl.PollsChoiceModelImpl
 * @generated
 */
public interface PollsChoiceModel extends BaseModel<PollsChoice> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a polls choice model instance should use the {@link PollsChoice} interface instead.
	 */

	/**
	 * Returns the primary key of this polls choice.
	 *
	 * @return the primary key of this polls choice
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this polls choice.
	 *
	 * @param primaryKey the primary key of this polls choice
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this polls choice.
	 *
	 * @return the uuid of this polls choice
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this polls choice.
	 *
	 * @param uuid the uuid of this polls choice
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the choice ID of this polls choice.
	 *
	 * @return the choice ID of this polls choice
	 */
	public long getChoiceId();

	/**
	 * Sets the choice ID of this polls choice.
	 *
	 * @param choiceId the choice ID of this polls choice
	 */
	public void setChoiceId(long choiceId);

	/**
	 * Returns the question ID of this polls choice.
	 *
	 * @return the question ID of this polls choice
	 */
	public long getQuestionId();

	/**
	 * Sets the question ID of this polls choice.
	 *
	 * @param questionId the question ID of this polls choice
	 */
	public void setQuestionId(long questionId);

	/**
	 * Returns the name of this polls choice.
	 *
	 * @return the name of this polls choice
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this polls choice.
	 *
	 * @param name the name of this polls choice
	 */
	public void setName(String name);

	/**
	 * Returns the description of this polls choice.
	 *
	 * @return the description of this polls choice
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this polls choice in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this polls choice
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this polls choice in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this polls choice. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this polls choice in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this polls choice
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this polls choice in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this polls choice
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this polls choice.
	 *
	 * @return the locales and localized descriptions of this polls choice
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this polls choice.
	 *
	 * @param description the description of this polls choice
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this polls choice in the language.
	 *
	 * @param description the localized description of this polls choice
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this polls choice in the language, and sets the default locale.
	 *
	 * @param description the localized description of this polls choice
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this polls choice from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this polls choice
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this polls choice from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this polls choice
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

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

	public int compareTo(PollsChoice pollsChoice);

	public int hashCode();

	public CacheModel<PollsChoice> toCacheModel();

	public PollsChoice toEscapedModel();

	public String toString();

	public String toXmlString();
}