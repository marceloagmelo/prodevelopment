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

package br.com.prodevelopment.eticket.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TypeTicket}.
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTicket
 * @generated
 */
public class TypeTicketWrapper implements TypeTicket, ModelWrapper<TypeTicket> {
	public TypeTicketWrapper(TypeTicket typeTicket) {
		_typeTicket = typeTicket;
	}

	@Override
	public Class<?> getModelClass() {
		return TypeTicket.class;
	}

	@Override
	public String getModelClassName() {
		return TypeTicket.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("typeTicketId", getTypeTicketId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userIdCreate", getUserIdCreate());
		attributes.put("userIdModified", getUserIdModified());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("xsd", getXsd());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long typeTicketId = (Long)attributes.get("typeTicketId");

		if (typeTicketId != null) {
			setTypeTicketId(typeTicketId);
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

		String xsd = (String)attributes.get("xsd");

		if (xsd != null) {
			setXsd(xsd);
		}
	}

	/**
	* Returns the primary key of this type ticket.
	*
	* @return the primary key of this type ticket
	*/
	@Override
	public long getPrimaryKey() {
		return _typeTicket.getPrimaryKey();
	}

	/**
	* Sets the primary key of this type ticket.
	*
	* @param primaryKey the primary key of this type ticket
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_typeTicket.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this type ticket.
	*
	* @return the uuid of this type ticket
	*/
	@Override
	public java.lang.String getUuid() {
		return _typeTicket.getUuid();
	}

	/**
	* Sets the uuid of this type ticket.
	*
	* @param uuid the uuid of this type ticket
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_typeTicket.setUuid(uuid);
	}

	/**
	* Returns the type ticket ID of this type ticket.
	*
	* @return the type ticket ID of this type ticket
	*/
	@Override
	public long getTypeTicketId() {
		return _typeTicket.getTypeTicketId();
	}

	/**
	* Sets the type ticket ID of this type ticket.
	*
	* @param typeTicketId the type ticket ID of this type ticket
	*/
	@Override
	public void setTypeTicketId(long typeTicketId) {
		_typeTicket.setTypeTicketId(typeTicketId);
	}

	/**
	* Returns the group ID of this type ticket.
	*
	* @return the group ID of this type ticket
	*/
	@Override
	public long getGroupId() {
		return _typeTicket.getGroupId();
	}

	/**
	* Sets the group ID of this type ticket.
	*
	* @param groupId the group ID of this type ticket
	*/
	@Override
	public void setGroupId(long groupId) {
		_typeTicket.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this type ticket.
	*
	* @return the company ID of this type ticket
	*/
	@Override
	public long getCompanyId() {
		return _typeTicket.getCompanyId();
	}

	/**
	* Sets the company ID of this type ticket.
	*
	* @param companyId the company ID of this type ticket
	*/
	@Override
	public void setCompanyId(long companyId) {
		_typeTicket.setCompanyId(companyId);
	}

	/**
	* Returns the user ID create of this type ticket.
	*
	* @return the user ID create of this type ticket
	*/
	@Override
	public long getUserIdCreate() {
		return _typeTicket.getUserIdCreate();
	}

	/**
	* Sets the user ID create of this type ticket.
	*
	* @param userIdCreate the user ID create of this type ticket
	*/
	@Override
	public void setUserIdCreate(long userIdCreate) {
		_typeTicket.setUserIdCreate(userIdCreate);
	}

	/**
	* Returns the user ID modified of this type ticket.
	*
	* @return the user ID modified of this type ticket
	*/
	@Override
	public long getUserIdModified() {
		return _typeTicket.getUserIdModified();
	}

	/**
	* Sets the user ID modified of this type ticket.
	*
	* @param userIdModified the user ID modified of this type ticket
	*/
	@Override
	public void setUserIdModified(long userIdModified) {
		_typeTicket.setUserIdModified(userIdModified);
	}

	/**
	* Returns the create date of this type ticket.
	*
	* @return the create date of this type ticket
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _typeTicket.getCreateDate();
	}

	/**
	* Sets the create date of this type ticket.
	*
	* @param createDate the create date of this type ticket
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_typeTicket.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this type ticket.
	*
	* @return the modified date of this type ticket
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _typeTicket.getModifiedDate();
	}

	/**
	* Sets the modified date of this type ticket.
	*
	* @param modifiedDate the modified date of this type ticket
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_typeTicket.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this type ticket.
	*
	* @return the name of this type ticket
	*/
	@Override
	public java.lang.String getName() {
		return _typeTicket.getName();
	}

	/**
	* Returns the localized name of this type ticket in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this type ticket
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _typeTicket.getName(locale);
	}

	/**
	* Returns the localized name of this type ticket in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this type ticket. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _typeTicket.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this type ticket in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this type ticket
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _typeTicket.getName(languageId);
	}

	/**
	* Returns the localized name of this type ticket in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this type ticket
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _typeTicket.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _typeTicket.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _typeTicket.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this type ticket.
	*
	* @return the locales and localized names of this type ticket
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _typeTicket.getNameMap();
	}

	/**
	* Sets the name of this type ticket.
	*
	* @param name the name of this type ticket
	*/
	@Override
	public void setName(java.lang.String name) {
		_typeTicket.setName(name);
	}

	/**
	* Sets the localized name of this type ticket in the language.
	*
	* @param name the localized name of this type ticket
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_typeTicket.setName(name, locale);
	}

	/**
	* Sets the localized name of this type ticket in the language, and sets the default locale.
	*
	* @param name the localized name of this type ticket
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_typeTicket.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_typeTicket.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this type ticket from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this type ticket
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_typeTicket.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this type ticket from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this type ticket
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_typeTicket.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the description of this type ticket.
	*
	* @return the description of this type ticket
	*/
	@Override
	public java.lang.String getDescription() {
		return _typeTicket.getDescription();
	}

	/**
	* Returns the localized description of this type ticket in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this type ticket
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _typeTicket.getDescription(locale);
	}

	/**
	* Returns the localized description of this type ticket in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this type ticket. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _typeTicket.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this type ticket in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this type ticket
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _typeTicket.getDescription(languageId);
	}

	/**
	* Returns the localized description of this type ticket in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this type ticket
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _typeTicket.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _typeTicket.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _typeTicket.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this type ticket.
	*
	* @return the locales and localized descriptions of this type ticket
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _typeTicket.getDescriptionMap();
	}

	/**
	* Sets the description of this type ticket.
	*
	* @param description the description of this type ticket
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_typeTicket.setDescription(description);
	}

	/**
	* Sets the localized description of this type ticket in the language.
	*
	* @param description the localized description of this type ticket
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_typeTicket.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this type ticket in the language, and sets the default locale.
	*
	* @param description the localized description of this type ticket
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_typeTicket.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_typeTicket.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this type ticket from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this type ticket
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_typeTicket.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this type ticket from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this type ticket
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_typeTicket.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the xsd of this type ticket.
	*
	* @return the xsd of this type ticket
	*/
	@Override
	public java.lang.String getXsd() {
		return _typeTicket.getXsd();
	}

	/**
	* Sets the xsd of this type ticket.
	*
	* @param xsd the xsd of this type ticket
	*/
	@Override
	public void setXsd(java.lang.String xsd) {
		_typeTicket.setXsd(xsd);
	}

	/**
	* Returns the status of this type ticket.
	*
	* @return the status of this type ticket
	*/
	@Override
	public int getStatus() {
		return _typeTicket.getStatus();
	}

	/**
	* Returns the trash entry created when this type ticket was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this type ticket.
	*
	* @return the trash entry created when this type ticket was moved to the Recycle Bin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeTicket.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this type ticket.
	*
	* @return the class primary key of the trash entry for this type ticket
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _typeTicket.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this type ticket.
	*
	* @return the trash handler for this type ticket
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _typeTicket.getTrashHandler();
	}

	/**
	* Returns <code>true</code> if this type ticket is in the Recycle Bin.
	*
	* @return <code>true</code> if this type ticket is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _typeTicket.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this type ticket is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this type ticket is in the Recycle Bin; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean isInTrashContainer() {
		return _typeTicket.isInTrashContainer();
	}

	@Override
	public boolean isNew() {
		return _typeTicket.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_typeTicket.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _typeTicket.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_typeTicket.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _typeTicket.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _typeTicket.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_typeTicket.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _typeTicket.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_typeTicket.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_typeTicket.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_typeTicket.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _typeTicket.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _typeTicket.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_typeTicket.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_typeTicket.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new TypeTicketWrapper((TypeTicket)_typeTicket.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket) {
		return _typeTicket.compareTo(typeTicket);
	}

	@Override
	public int hashCode() {
		return _typeTicket.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.eticket.model.TypeTicket> toCacheModel() {
		return _typeTicket.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket toEscapedModel() {
		return new TypeTicketWrapper(_typeTicket.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicket toUnescapedModel() {
		return new TypeTicketWrapper(_typeTicket.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _typeTicket.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _typeTicket.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_typeTicket.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeTicketWrapper)) {
			return false;
		}

		TypeTicketWrapper typeTicketWrapper = (TypeTicketWrapper)obj;

		if (Validator.equals(_typeTicket, typeTicketWrapper._typeTicket)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _typeTicket.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TypeTicket getWrappedTypeTicket() {
		return _typeTicket;
	}

	@Override
	public TypeTicket getWrappedModel() {
		return _typeTicket;
	}

	@Override
	public void resetOriginalValues() {
		_typeTicket.resetOriginalValues();
	}

	private TypeTicket _typeTicket;
}