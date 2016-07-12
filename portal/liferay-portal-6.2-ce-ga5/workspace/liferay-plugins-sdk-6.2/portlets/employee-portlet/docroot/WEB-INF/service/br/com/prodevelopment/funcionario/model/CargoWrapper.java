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

package br.com.prodevelopment.funcionario.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Cargo}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Cargo
 * @generated
 */
public class CargoWrapper implements Cargo, ModelWrapper<Cargo> {
	public CargoWrapper(Cargo cargo) {
		_cargo = cargo;
	}

	@Override
	public Class<?> getModelClass() {
		return Cargo.class;
	}

	@Override
	public String getModelClassName() {
		return Cargo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("cargoId", getCargoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("versao", getVersao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long cargoId = (Long)attributes.get("cargoId");

		if (cargoId != null) {
			setCargoId(cargoId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}
	}

	/**
	* Returns the primary key of this cargo.
	*
	* @return the primary key of this cargo
	*/
	@Override
	public long getPrimaryKey() {
		return _cargo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cargo.
	*
	* @param primaryKey the primary key of this cargo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cargo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this cargo.
	*
	* @return the uuid of this cargo
	*/
	@Override
	public java.lang.String getUuid() {
		return _cargo.getUuid();
	}

	/**
	* Sets the uuid of this cargo.
	*
	* @param uuid the uuid of this cargo
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_cargo.setUuid(uuid);
	}

	/**
	* Returns the cargo ID of this cargo.
	*
	* @return the cargo ID of this cargo
	*/
	@Override
	public long getCargoId() {
		return _cargo.getCargoId();
	}

	/**
	* Sets the cargo ID of this cargo.
	*
	* @param cargoId the cargo ID of this cargo
	*/
	@Override
	public void setCargoId(long cargoId) {
		_cargo.setCargoId(cargoId);
	}

	/**
	* Returns the company ID of this cargo.
	*
	* @return the company ID of this cargo
	*/
	@Override
	public long getCompanyId() {
		return _cargo.getCompanyId();
	}

	/**
	* Sets the company ID of this cargo.
	*
	* @param companyId the company ID of this cargo
	*/
	@Override
	public void setCompanyId(long companyId) {
		_cargo.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this cargo.
	*
	* @return the group ID of this cargo
	*/
	@Override
	public long getGroupId() {
		return _cargo.getGroupId();
	}

	/**
	* Sets the group ID of this cargo.
	*
	* @param groupId the group ID of this cargo
	*/
	@Override
	public void setGroupId(long groupId) {
		_cargo.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this cargo.
	*
	* @return the create user ID of this cargo
	*/
	@Override
	public long getCreateUserId() {
		return _cargo.getCreateUserId();
	}

	/**
	* Sets the create user ID of this cargo.
	*
	* @param createUserId the create user ID of this cargo
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_cargo.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this cargo.
	*
	* @return the create user uuid of this cargo
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargo.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this cargo.
	*
	* @param createUserUuid the create user uuid of this cargo
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_cargo.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this cargo.
	*
	* @return the modified user ID of this cargo
	*/
	@Override
	public long getModifiedUserId() {
		return _cargo.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this cargo.
	*
	* @param modifiedUserId the modified user ID of this cargo
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_cargo.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this cargo.
	*
	* @return the modified user uuid of this cargo
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargo.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this cargo.
	*
	* @param modifiedUserUuid the modified user uuid of this cargo
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_cargo.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this cargo.
	*
	* @return the create date of this cargo
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _cargo.getCreateDate();
	}

	/**
	* Sets the create date of this cargo.
	*
	* @param createDate the create date of this cargo
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_cargo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this cargo.
	*
	* @return the modified date of this cargo
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _cargo.getModifiedDate();
	}

	/**
	* Sets the modified date of this cargo.
	*
	* @param modifiedDate the modified date of this cargo
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cargo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nome of this cargo.
	*
	* @return the nome of this cargo
	*/
	@Override
	public java.lang.String getNome() {
		return _cargo.getNome();
	}

	/**
	* Returns the localized nome of this cargo in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized nome of this cargo
	*/
	@Override
	public java.lang.String getNome(java.util.Locale locale) {
		return _cargo.getNome(locale);
	}

	/**
	* Returns the localized nome of this cargo in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized nome of this cargo. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getNome(java.util.Locale locale, boolean useDefault) {
		return _cargo.getNome(locale, useDefault);
	}

	/**
	* Returns the localized nome of this cargo in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized nome of this cargo
	*/
	@Override
	public java.lang.String getNome(java.lang.String languageId) {
		return _cargo.getNome(languageId);
	}

	/**
	* Returns the localized nome of this cargo in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized nome of this cargo
	*/
	@Override
	public java.lang.String getNome(java.lang.String languageId,
		boolean useDefault) {
		return _cargo.getNome(languageId, useDefault);
	}

	@Override
	public java.lang.String getNomeCurrentLanguageId() {
		return _cargo.getNomeCurrentLanguageId();
	}

	@Override
	public java.lang.String getNomeCurrentValue() {
		return _cargo.getNomeCurrentValue();
	}

	/**
	* Returns a map of the locales and localized nomes of this cargo.
	*
	* @return the locales and localized nomes of this cargo
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNomeMap() {
		return _cargo.getNomeMap();
	}

	/**
	* Sets the nome of this cargo.
	*
	* @param nome the nome of this cargo
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_cargo.setNome(nome);
	}

	/**
	* Sets the localized nome of this cargo in the language.
	*
	* @param nome the localized nome of this cargo
	* @param locale the locale of the language
	*/
	@Override
	public void setNome(java.lang.String nome, java.util.Locale locale) {
		_cargo.setNome(nome, locale);
	}

	/**
	* Sets the localized nome of this cargo in the language, and sets the default locale.
	*
	* @param nome the localized nome of this cargo
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNome(java.lang.String nome, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_cargo.setNome(nome, locale, defaultLocale);
	}

	@Override
	public void setNomeCurrentLanguageId(java.lang.String languageId) {
		_cargo.setNomeCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized nomes of this cargo from the map of locales and localized nomes.
	*
	* @param nomeMap the locales and localized nomes of this cargo
	*/
	@Override
	public void setNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> nomeMap) {
		_cargo.setNomeMap(nomeMap);
	}

	/**
	* Sets the localized nomes of this cargo from the map of locales and localized nomes, and sets the default locale.
	*
	* @param nomeMap the locales and localized nomes of this cargo
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Locale defaultLocale) {
		_cargo.setNomeMap(nomeMap, defaultLocale);
	}

	/**
	* Returns the versao of this cargo.
	*
	* @return the versao of this cargo
	*/
	@Override
	public double getVersao() {
		return _cargo.getVersao();
	}

	/**
	* Sets the versao of this cargo.
	*
	* @param versao the versao of this cargo
	*/
	@Override
	public void setVersao(double versao) {
		_cargo.setVersao(versao);
	}

	@Override
	public boolean isNew() {
		return _cargo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cargo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cargo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cargo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cargo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cargo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cargo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cargo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cargo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cargo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cargo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _cargo.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _cargo.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_cargo.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_cargo.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new CargoWrapper((Cargo)_cargo.clone());
	}

	@Override
	public int compareTo(br.com.prodevelopment.funcionario.model.Cargo cargo) {
		return _cargo.compareTo(cargo);
	}

	@Override
	public int hashCode() {
		return _cargo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.funcionario.model.Cargo> toCacheModel() {
		return _cargo.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Cargo toEscapedModel() {
		return new CargoWrapper(_cargo.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Cargo toUnescapedModel() {
		return new CargoWrapper(_cargo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cargo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cargo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cargo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CargoWrapper)) {
			return false;
		}

		CargoWrapper cargoWrapper = (CargoWrapper)obj;

		if (Validator.equals(_cargo, cargoWrapper._cargo)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _cargo.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Cargo getWrappedCargo() {
		return _cargo;
	}

	@Override
	public Cargo getWrappedModel() {
		return _cargo;
	}

	@Override
	public void resetOriginalValues() {
		_cargo.resetOriginalValues();
	}

	private Cargo _cargo;
}