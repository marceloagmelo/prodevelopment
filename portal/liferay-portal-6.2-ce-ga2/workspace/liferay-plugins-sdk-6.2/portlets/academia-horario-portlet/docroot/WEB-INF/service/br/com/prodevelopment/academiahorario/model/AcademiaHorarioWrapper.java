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

package br.com.prodevelopment.academiahorario.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AcademiaHorario}.
 * </p>
 *
 * @author Marcelo
 * @see AcademiaHorario
 * @generated
 */
public class AcademiaHorarioWrapper implements AcademiaHorario,
	ModelWrapper<AcademiaHorario> {
	public AcademiaHorarioWrapper(AcademiaHorario academiaHorario) {
		_academiaHorario = academiaHorario;
	}

	@Override
	public Class<?> getModelClass() {
		return AcademiaHorario.class;
	}

	@Override
	public String getModelClassName() {
		return AcademiaHorario.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("academiaHorarioId", getAcademiaHorarioId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("diaSemana", getDiaSemana());
		attributes.put("horaInicial", getHoraInicial());
		attributes.put("HoraFinal", getHoraFinal());
		attributes.put("atividadeId", getAtividadeId());
		attributes.put("atividadeNome", getAtividadeNome());
		attributes.put("versao", getVersao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long academiaHorarioId = (Long)attributes.get("academiaHorarioId");

		if (academiaHorarioId != null) {
			setAcademiaHorarioId(academiaHorarioId);
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

		Integer diaSemana = (Integer)attributes.get("diaSemana");

		if (diaSemana != null) {
			setDiaSemana(diaSemana);
		}

		String horaInicial = (String)attributes.get("horaInicial");

		if (horaInicial != null) {
			setHoraInicial(horaInicial);
		}

		String HoraFinal = (String)attributes.get("HoraFinal");

		if (HoraFinal != null) {
			setHoraFinal(HoraFinal);
		}

		Long atividadeId = (Long)attributes.get("atividadeId");

		if (atividadeId != null) {
			setAtividadeId(atividadeId);
		}

		String atividadeNome = (String)attributes.get("atividadeNome");

		if (atividadeNome != null) {
			setAtividadeNome(atividadeNome);
		}

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}
	}

	/**
	* Returns the primary key of this academia horario.
	*
	* @return the primary key of this academia horario
	*/
	@Override
	public long getPrimaryKey() {
		return _academiaHorario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this academia horario.
	*
	* @param primaryKey the primary key of this academia horario
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_academiaHorario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this academia horario.
	*
	* @return the uuid of this academia horario
	*/
	@Override
	public java.lang.String getUuid() {
		return _academiaHorario.getUuid();
	}

	/**
	* Sets the uuid of this academia horario.
	*
	* @param uuid the uuid of this academia horario
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_academiaHorario.setUuid(uuid);
	}

	/**
	* Returns the academia horario ID of this academia horario.
	*
	* @return the academia horario ID of this academia horario
	*/
	@Override
	public long getAcademiaHorarioId() {
		return _academiaHorario.getAcademiaHorarioId();
	}

	/**
	* Sets the academia horario ID of this academia horario.
	*
	* @param academiaHorarioId the academia horario ID of this academia horario
	*/
	@Override
	public void setAcademiaHorarioId(long academiaHorarioId) {
		_academiaHorario.setAcademiaHorarioId(academiaHorarioId);
	}

	/**
	* Returns the company ID of this academia horario.
	*
	* @return the company ID of this academia horario
	*/
	@Override
	public long getCompanyId() {
		return _academiaHorario.getCompanyId();
	}

	/**
	* Sets the company ID of this academia horario.
	*
	* @param companyId the company ID of this academia horario
	*/
	@Override
	public void setCompanyId(long companyId) {
		_academiaHorario.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this academia horario.
	*
	* @return the group ID of this academia horario
	*/
	@Override
	public long getGroupId() {
		return _academiaHorario.getGroupId();
	}

	/**
	* Sets the group ID of this academia horario.
	*
	* @param groupId the group ID of this academia horario
	*/
	@Override
	public void setGroupId(long groupId) {
		_academiaHorario.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this academia horario.
	*
	* @return the create user ID of this academia horario
	*/
	@Override
	public long getCreateUserId() {
		return _academiaHorario.getCreateUserId();
	}

	/**
	* Sets the create user ID of this academia horario.
	*
	* @param createUserId the create user ID of this academia horario
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_academiaHorario.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this academia horario.
	*
	* @return the create user uuid of this academia horario
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorario.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this academia horario.
	*
	* @param createUserUuid the create user uuid of this academia horario
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_academiaHorario.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this academia horario.
	*
	* @return the modified user ID of this academia horario
	*/
	@Override
	public long getModifiedUserId() {
		return _academiaHorario.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this academia horario.
	*
	* @param modifiedUserId the modified user ID of this academia horario
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_academiaHorario.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this academia horario.
	*
	* @return the modified user uuid of this academia horario
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _academiaHorario.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this academia horario.
	*
	* @param modifiedUserUuid the modified user uuid of this academia horario
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_academiaHorario.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this academia horario.
	*
	* @return the create date of this academia horario
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _academiaHorario.getCreateDate();
	}

	/**
	* Sets the create date of this academia horario.
	*
	* @param createDate the create date of this academia horario
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_academiaHorario.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this academia horario.
	*
	* @return the modified date of this academia horario
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _academiaHorario.getModifiedDate();
	}

	/**
	* Sets the modified date of this academia horario.
	*
	* @param modifiedDate the modified date of this academia horario
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_academiaHorario.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dia semana of this academia horario.
	*
	* @return the dia semana of this academia horario
	*/
	@Override
	public int getDiaSemana() {
		return _academiaHorario.getDiaSemana();
	}

	/**
	* Sets the dia semana of this academia horario.
	*
	* @param diaSemana the dia semana of this academia horario
	*/
	@Override
	public void setDiaSemana(int diaSemana) {
		_academiaHorario.setDiaSemana(diaSemana);
	}

	/**
	* Returns the hora inicial of this academia horario.
	*
	* @return the hora inicial of this academia horario
	*/
	@Override
	public java.lang.String getHoraInicial() {
		return _academiaHorario.getHoraInicial();
	}

	/**
	* Sets the hora inicial of this academia horario.
	*
	* @param horaInicial the hora inicial of this academia horario
	*/
	@Override
	public void setHoraInicial(java.lang.String horaInicial) {
		_academiaHorario.setHoraInicial(horaInicial);
	}

	/**
	* Returns the hora final of this academia horario.
	*
	* @return the hora final of this academia horario
	*/
	@Override
	public java.lang.String getHoraFinal() {
		return _academiaHorario.getHoraFinal();
	}

	/**
	* Sets the hora final of this academia horario.
	*
	* @param HoraFinal the hora final of this academia horario
	*/
	@Override
	public void setHoraFinal(java.lang.String HoraFinal) {
		_academiaHorario.setHoraFinal(HoraFinal);
	}

	/**
	* Returns the atividade ID of this academia horario.
	*
	* @return the atividade ID of this academia horario
	*/
	@Override
	public long getAtividadeId() {
		return _academiaHorario.getAtividadeId();
	}

	/**
	* Sets the atividade ID of this academia horario.
	*
	* @param atividadeId the atividade ID of this academia horario
	*/
	@Override
	public void setAtividadeId(long atividadeId) {
		_academiaHorario.setAtividadeId(atividadeId);
	}

	/**
	* Returns the atividade nome of this academia horario.
	*
	* @return the atividade nome of this academia horario
	*/
	@Override
	public java.lang.String getAtividadeNome() {
		return _academiaHorario.getAtividadeNome();
	}

	/**
	* Returns the localized atividade nome of this academia horario in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized atividade nome of this academia horario
	*/
	@Override
	public java.lang.String getAtividadeNome(java.util.Locale locale) {
		return _academiaHorario.getAtividadeNome(locale);
	}

	/**
	* Returns the localized atividade nome of this academia horario in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized atividade nome of this academia horario. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getAtividadeNome(java.util.Locale locale,
		boolean useDefault) {
		return _academiaHorario.getAtividadeNome(locale, useDefault);
	}

	/**
	* Returns the localized atividade nome of this academia horario in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized atividade nome of this academia horario
	*/
	@Override
	public java.lang.String getAtividadeNome(java.lang.String languageId) {
		return _academiaHorario.getAtividadeNome(languageId);
	}

	/**
	* Returns the localized atividade nome of this academia horario in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized atividade nome of this academia horario
	*/
	@Override
	public java.lang.String getAtividadeNome(java.lang.String languageId,
		boolean useDefault) {
		return _academiaHorario.getAtividadeNome(languageId, useDefault);
	}

	@Override
	public java.lang.String getAtividadeNomeCurrentLanguageId() {
		return _academiaHorario.getAtividadeNomeCurrentLanguageId();
	}

	@Override
	public java.lang.String getAtividadeNomeCurrentValue() {
		return _academiaHorario.getAtividadeNomeCurrentValue();
	}

	/**
	* Returns a map of the locales and localized atividade nomes of this academia horario.
	*
	* @return the locales and localized atividade nomes of this academia horario
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getAtividadeNomeMap() {
		return _academiaHorario.getAtividadeNomeMap();
	}

	/**
	* Sets the atividade nome of this academia horario.
	*
	* @param atividadeNome the atividade nome of this academia horario
	*/
	@Override
	public void setAtividadeNome(java.lang.String atividadeNome) {
		_academiaHorario.setAtividadeNome(atividadeNome);
	}

	/**
	* Sets the localized atividade nome of this academia horario in the language.
	*
	* @param atividadeNome the localized atividade nome of this academia horario
	* @param locale the locale of the language
	*/
	@Override
	public void setAtividadeNome(java.lang.String atividadeNome,
		java.util.Locale locale) {
		_academiaHorario.setAtividadeNome(atividadeNome, locale);
	}

	/**
	* Sets the localized atividade nome of this academia horario in the language, and sets the default locale.
	*
	* @param atividadeNome the localized atividade nome of this academia horario
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setAtividadeNome(java.lang.String atividadeNome,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_academiaHorario.setAtividadeNome(atividadeNome, locale, defaultLocale);
	}

	@Override
	public void setAtividadeNomeCurrentLanguageId(java.lang.String languageId) {
		_academiaHorario.setAtividadeNomeCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized atividade nomes of this academia horario from the map of locales and localized atividade nomes.
	*
	* @param atividadeNomeMap the locales and localized atividade nomes of this academia horario
	*/
	@Override
	public void setAtividadeNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> atividadeNomeMap) {
		_academiaHorario.setAtividadeNomeMap(atividadeNomeMap);
	}

	/**
	* Sets the localized atividade nomes of this academia horario from the map of locales and localized atividade nomes, and sets the default locale.
	*
	* @param atividadeNomeMap the locales and localized atividade nomes of this academia horario
	* @param defaultLocale the default locale
	*/
	@Override
	public void setAtividadeNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> atividadeNomeMap,
		java.util.Locale defaultLocale) {
		_academiaHorario.setAtividadeNomeMap(atividadeNomeMap, defaultLocale);
	}

	/**
	* Returns the versao of this academia horario.
	*
	* @return the versao of this academia horario
	*/
	@Override
	public double getVersao() {
		return _academiaHorario.getVersao();
	}

	/**
	* Sets the versao of this academia horario.
	*
	* @param versao the versao of this academia horario
	*/
	@Override
	public void setVersao(double versao) {
		_academiaHorario.setVersao(versao);
	}

	@Override
	public boolean isNew() {
		return _academiaHorario.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_academiaHorario.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _academiaHorario.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_academiaHorario.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _academiaHorario.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _academiaHorario.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_academiaHorario.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _academiaHorario.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_academiaHorario.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_academiaHorario.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_academiaHorario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _academiaHorario.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _academiaHorario.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_academiaHorario.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_academiaHorario.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new AcademiaHorarioWrapper((AcademiaHorario)_academiaHorario.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.academiahorario.model.AcademiaHorario academiaHorario) {
		return _academiaHorario.compareTo(academiaHorario);
	}

	@Override
	public int hashCode() {
		return _academiaHorario.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.academiahorario.model.AcademiaHorario> toCacheModel() {
		return _academiaHorario.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario toEscapedModel() {
		return new AcademiaHorarioWrapper(_academiaHorario.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.academiahorario.model.AcademiaHorario toUnescapedModel() {
		return new AcademiaHorarioWrapper(_academiaHorario.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _academiaHorario.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _academiaHorario.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_academiaHorario.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AcademiaHorarioWrapper)) {
			return false;
		}

		AcademiaHorarioWrapper academiaHorarioWrapper = (AcademiaHorarioWrapper)obj;

		if (Validator.equals(_academiaHorario,
					academiaHorarioWrapper._academiaHorario)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _academiaHorario.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AcademiaHorario getWrappedAcademiaHorario() {
		return _academiaHorario;
	}

	@Override
	public AcademiaHorario getWrappedModel() {
		return _academiaHorario;
	}

	@Override
	public void resetOriginalValues() {
		_academiaHorario.resetOriginalValues();
	}

	private AcademiaHorario _academiaHorario;
}