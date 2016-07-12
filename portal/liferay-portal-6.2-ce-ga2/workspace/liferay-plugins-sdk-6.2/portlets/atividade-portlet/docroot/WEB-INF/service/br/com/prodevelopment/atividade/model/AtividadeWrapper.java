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

package br.com.prodevelopment.atividade.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Atividade}.
 * </p>
 *
 * @author Marcelo
 * @see Atividade
 * @generated
 */
public class AtividadeWrapper implements Atividade, ModelWrapper<Atividade> {
	public AtividadeWrapper(Atividade atividade) {
		_atividade = atividade;
	}

	@Override
	public Class<?> getModelClass() {
		return Atividade.class;
	}

	@Override
	public String getModelClassName() {
		return Atividade.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("atividadeId", getAtividadeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("descricao", getDescricao());
		attributes.put("imagemId", getImagemId());
		attributes.put("existeImagem", getExisteImagem());
		attributes.put("versao", getVersao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long atividadeId = (Long)attributes.get("atividadeId");

		if (atividadeId != null) {
			setAtividadeId(atividadeId);
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

		String descricao = (String)attributes.get("descricao");

		if (descricao != null) {
			setDescricao(descricao);
		}

		Long imagemId = (Long)attributes.get("imagemId");

		if (imagemId != null) {
			setImagemId(imagemId);
		}

		Boolean existeImagem = (Boolean)attributes.get("existeImagem");

		if (existeImagem != null) {
			setExisteImagem(existeImagem);
		}

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}
	}

	/**
	* Returns the primary key of this atividade.
	*
	* @return the primary key of this atividade
	*/
	@Override
	public long getPrimaryKey() {
		return _atividade.getPrimaryKey();
	}

	/**
	* Sets the primary key of this atividade.
	*
	* @param primaryKey the primary key of this atividade
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_atividade.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this atividade.
	*
	* @return the uuid of this atividade
	*/
	@Override
	public java.lang.String getUuid() {
		return _atividade.getUuid();
	}

	/**
	* Sets the uuid of this atividade.
	*
	* @param uuid the uuid of this atividade
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_atividade.setUuid(uuid);
	}

	/**
	* Returns the atividade ID of this atividade.
	*
	* @return the atividade ID of this atividade
	*/
	@Override
	public long getAtividadeId() {
		return _atividade.getAtividadeId();
	}

	/**
	* Sets the atividade ID of this atividade.
	*
	* @param atividadeId the atividade ID of this atividade
	*/
	@Override
	public void setAtividadeId(long atividadeId) {
		_atividade.setAtividadeId(atividadeId);
	}

	/**
	* Returns the company ID of this atividade.
	*
	* @return the company ID of this atividade
	*/
	@Override
	public long getCompanyId() {
		return _atividade.getCompanyId();
	}

	/**
	* Sets the company ID of this atividade.
	*
	* @param companyId the company ID of this atividade
	*/
	@Override
	public void setCompanyId(long companyId) {
		_atividade.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this atividade.
	*
	* @return the group ID of this atividade
	*/
	@Override
	public long getGroupId() {
		return _atividade.getGroupId();
	}

	/**
	* Sets the group ID of this atividade.
	*
	* @param groupId the group ID of this atividade
	*/
	@Override
	public void setGroupId(long groupId) {
		_atividade.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this atividade.
	*
	* @return the create user ID of this atividade
	*/
	@Override
	public long getCreateUserId() {
		return _atividade.getCreateUserId();
	}

	/**
	* Sets the create user ID of this atividade.
	*
	* @param createUserId the create user ID of this atividade
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_atividade.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this atividade.
	*
	* @return the create user uuid of this atividade
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividade.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this atividade.
	*
	* @param createUserUuid the create user uuid of this atividade
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_atividade.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this atividade.
	*
	* @return the modified user ID of this atividade
	*/
	@Override
	public long getModifiedUserId() {
		return _atividade.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this atividade.
	*
	* @param modifiedUserId the modified user ID of this atividade
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_atividade.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this atividade.
	*
	* @return the modified user uuid of this atividade
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atividade.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this atividade.
	*
	* @param modifiedUserUuid the modified user uuid of this atividade
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_atividade.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this atividade.
	*
	* @return the create date of this atividade
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _atividade.getCreateDate();
	}

	/**
	* Sets the create date of this atividade.
	*
	* @param createDate the create date of this atividade
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_atividade.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this atividade.
	*
	* @return the modified date of this atividade
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _atividade.getModifiedDate();
	}

	/**
	* Sets the modified date of this atividade.
	*
	* @param modifiedDate the modified date of this atividade
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_atividade.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nome of this atividade.
	*
	* @return the nome of this atividade
	*/
	@Override
	public java.lang.String getNome() {
		return _atividade.getNome();
	}

	/**
	* Returns the localized nome of this atividade in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized nome of this atividade
	*/
	@Override
	public java.lang.String getNome(java.util.Locale locale) {
		return _atividade.getNome(locale);
	}

	/**
	* Returns the localized nome of this atividade in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized nome of this atividade. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getNome(java.util.Locale locale, boolean useDefault) {
		return _atividade.getNome(locale, useDefault);
	}

	/**
	* Returns the localized nome of this atividade in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized nome of this atividade
	*/
	@Override
	public java.lang.String getNome(java.lang.String languageId) {
		return _atividade.getNome(languageId);
	}

	/**
	* Returns the localized nome of this atividade in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized nome of this atividade
	*/
	@Override
	public java.lang.String getNome(java.lang.String languageId,
		boolean useDefault) {
		return _atividade.getNome(languageId, useDefault);
	}

	@Override
	public java.lang.String getNomeCurrentLanguageId() {
		return _atividade.getNomeCurrentLanguageId();
	}

	@Override
	public java.lang.String getNomeCurrentValue() {
		return _atividade.getNomeCurrentValue();
	}

	/**
	* Returns a map of the locales and localized nomes of this atividade.
	*
	* @return the locales and localized nomes of this atividade
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNomeMap() {
		return _atividade.getNomeMap();
	}

	/**
	* Sets the nome of this atividade.
	*
	* @param nome the nome of this atividade
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_atividade.setNome(nome);
	}

	/**
	* Sets the localized nome of this atividade in the language.
	*
	* @param nome the localized nome of this atividade
	* @param locale the locale of the language
	*/
	@Override
	public void setNome(java.lang.String nome, java.util.Locale locale) {
		_atividade.setNome(nome, locale);
	}

	/**
	* Sets the localized nome of this atividade in the language, and sets the default locale.
	*
	* @param nome the localized nome of this atividade
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNome(java.lang.String nome, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_atividade.setNome(nome, locale, defaultLocale);
	}

	@Override
	public void setNomeCurrentLanguageId(java.lang.String languageId) {
		_atividade.setNomeCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized nomes of this atividade from the map of locales and localized nomes.
	*
	* @param nomeMap the locales and localized nomes of this atividade
	*/
	@Override
	public void setNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> nomeMap) {
		_atividade.setNomeMap(nomeMap);
	}

	/**
	* Sets the localized nomes of this atividade from the map of locales and localized nomes, and sets the default locale.
	*
	* @param nomeMap the locales and localized nomes of this atividade
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNomeMap(
		java.util.Map<java.util.Locale, java.lang.String> nomeMap,
		java.util.Locale defaultLocale) {
		_atividade.setNomeMap(nomeMap, defaultLocale);
	}

	/**
	* Returns the descricao of this atividade.
	*
	* @return the descricao of this atividade
	*/
	@Override
	public java.lang.String getDescricao() {
		return _atividade.getDescricao();
	}

	/**
	* Returns the localized descricao of this atividade in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized descricao of this atividade
	*/
	@Override
	public java.lang.String getDescricao(java.util.Locale locale) {
		return _atividade.getDescricao(locale);
	}

	/**
	* Returns the localized descricao of this atividade in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this atividade. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescricao(java.util.Locale locale,
		boolean useDefault) {
		return _atividade.getDescricao(locale, useDefault);
	}

	/**
	* Returns the localized descricao of this atividade in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized descricao of this atividade
	*/
	@Override
	public java.lang.String getDescricao(java.lang.String languageId) {
		return _atividade.getDescricao(languageId);
	}

	/**
	* Returns the localized descricao of this atividade in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this atividade
	*/
	@Override
	public java.lang.String getDescricao(java.lang.String languageId,
		boolean useDefault) {
		return _atividade.getDescricao(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescricaoCurrentLanguageId() {
		return _atividade.getDescricaoCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescricaoCurrentValue() {
		return _atividade.getDescricaoCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descricaos of this atividade.
	*
	* @return the locales and localized descricaos of this atividade
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescricaoMap() {
		return _atividade.getDescricaoMap();
	}

	/**
	* Sets the descricao of this atividade.
	*
	* @param descricao the descricao of this atividade
	*/
	@Override
	public void setDescricao(java.lang.String descricao) {
		_atividade.setDescricao(descricao);
	}

	/**
	* Sets the localized descricao of this atividade in the language.
	*
	* @param descricao the localized descricao of this atividade
	* @param locale the locale of the language
	*/
	@Override
	public void setDescricao(java.lang.String descricao, java.util.Locale locale) {
		_atividade.setDescricao(descricao, locale);
	}

	/**
	* Sets the localized descricao of this atividade in the language, and sets the default locale.
	*
	* @param descricao the localized descricao of this atividade
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescricao(java.lang.String descricao,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_atividade.setDescricao(descricao, locale, defaultLocale);
	}

	@Override
	public void setDescricaoCurrentLanguageId(java.lang.String languageId) {
		_atividade.setDescricaoCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descricaos of this atividade from the map of locales and localized descricaos.
	*
	* @param descricaoMap the locales and localized descricaos of this atividade
	*/
	@Override
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap) {
		_atividade.setDescricaoMap(descricaoMap);
	}

	/**
	* Sets the localized descricaos of this atividade from the map of locales and localized descricaos, and sets the default locale.
	*
	* @param descricaoMap the locales and localized descricaos of this atividade
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		java.util.Locale defaultLocale) {
		_atividade.setDescricaoMap(descricaoMap, defaultLocale);
	}

	/**
	* Returns the imagem ID of this atividade.
	*
	* @return the imagem ID of this atividade
	*/
	@Override
	public long getImagemId() {
		return _atividade.getImagemId();
	}

	/**
	* Sets the imagem ID of this atividade.
	*
	* @param imagemId the imagem ID of this atividade
	*/
	@Override
	public void setImagemId(long imagemId) {
		_atividade.setImagemId(imagemId);
	}

	/**
	* Returns the existe imagem of this atividade.
	*
	* @return the existe imagem of this atividade
	*/
	@Override
	public boolean getExisteImagem() {
		return _atividade.getExisteImagem();
	}

	/**
	* Returns <code>true</code> if this atividade is existe imagem.
	*
	* @return <code>true</code> if this atividade is existe imagem; <code>false</code> otherwise
	*/
	@Override
	public boolean isExisteImagem() {
		return _atividade.isExisteImagem();
	}

	/**
	* Sets whether this atividade is existe imagem.
	*
	* @param existeImagem the existe imagem of this atividade
	*/
	@Override
	public void setExisteImagem(boolean existeImagem) {
		_atividade.setExisteImagem(existeImagem);
	}

	/**
	* Returns the versao of this atividade.
	*
	* @return the versao of this atividade
	*/
	@Override
	public double getVersao() {
		return _atividade.getVersao();
	}

	/**
	* Sets the versao of this atividade.
	*
	* @param versao the versao of this atividade
	*/
	@Override
	public void setVersao(double versao) {
		_atividade.setVersao(versao);
	}

	@Override
	public boolean isNew() {
		return _atividade.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_atividade.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _atividade.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_atividade.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _atividade.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _atividade.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_atividade.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _atividade.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_atividade.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_atividade.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_atividade.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _atividade.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _atividade.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_atividade.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_atividade.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new AtividadeWrapper((Atividade)_atividade.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.atividade.model.Atividade atividade) {
		return _atividade.compareTo(atividade);
	}

	@Override
	public int hashCode() {
		return _atividade.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.atividade.model.Atividade> toCacheModel() {
		return _atividade.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.atividade.model.Atividade toEscapedModel() {
		return new AtividadeWrapper(_atividade.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.atividade.model.Atividade toUnescapedModel() {
		return new AtividadeWrapper(_atividade.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _atividade.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _atividade.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_atividade.persist();
	}

	@Override
	public java.lang.String getImagemURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atividade.getImagemURL(themeDisplay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AtividadeWrapper)) {
			return false;
		}

		AtividadeWrapper atividadeWrapper = (AtividadeWrapper)obj;

		if (Validator.equals(_atividade, atividadeWrapper._atividade)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _atividade.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Atividade getWrappedAtividade() {
		return _atividade;
	}

	@Override
	public Atividade getWrappedModel() {
		return _atividade;
	}

	@Override
	public void resetOriginalValues() {
		_atividade.resetOriginalValues();
	}

	private Atividade _atividade;
}