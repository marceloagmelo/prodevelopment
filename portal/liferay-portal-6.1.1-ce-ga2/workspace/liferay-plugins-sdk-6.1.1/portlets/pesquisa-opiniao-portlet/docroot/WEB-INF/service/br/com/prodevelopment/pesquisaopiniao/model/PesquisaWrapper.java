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

package br.com.prodevelopment.pesquisaopiniao.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Pesquisa}.
 * </p>
 *
 * @author    Marcelo Melo
 * @see       Pesquisa
 * @generated
 */
public class PesquisaWrapper implements Pesquisa, ModelWrapper<Pesquisa> {
	public PesquisaWrapper(Pesquisa pesquisa) {
		_pesquisa = pesquisa;
	}

	public Class<?> getModelClass() {
		return Pesquisa.class;
	}

	public String getModelClassName() {
		return Pesquisa.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("titulo", getTitulo());
		attributes.put("descricao", getDescricao());
		attributes.put("dataInclusao", getDataInclusao());
		attributes.put("dataAlteracao", getDataAlteracao());
		attributes.put("ativa", getAtiva());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userIdInclusao", getUserIdInclusao());
		attributes.put("userIdAlteracao", getUserIdAlteracao());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String titulo = (String)attributes.get("titulo");

		if (titulo != null) {
			setTitulo(titulo);
		}

		String descricao = (String)attributes.get("descricao");

		if (descricao != null) {
			setDescricao(descricao);
		}

		Date dataInclusao = (Date)attributes.get("dataInclusao");

		if (dataInclusao != null) {
			setDataInclusao(dataInclusao);
		}

		Date dataAlteracao = (Date)attributes.get("dataAlteracao");

		if (dataAlteracao != null) {
			setDataAlteracao(dataAlteracao);
		}

		Boolean ativa = (Boolean)attributes.get("ativa");

		if (ativa != null) {
			setAtiva(ativa);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userIdInclusao = (Long)attributes.get("userIdInclusao");

		if (userIdInclusao != null) {
			setUserIdInclusao(userIdInclusao);
		}

		Long userIdAlteracao = (Long)attributes.get("userIdAlteracao");

		if (userIdAlteracao != null) {
			setUserIdAlteracao(userIdAlteracao);
		}
	}

	/**
	* Returns the primary key of this pesquisa.
	*
	* @return the primary key of this pesquisa
	*/
	public long getPrimaryKey() {
		return _pesquisa.getPrimaryKey();
	}

	/**
	* Sets the primary key of this pesquisa.
	*
	* @param primaryKey the primary key of this pesquisa
	*/
	public void setPrimaryKey(long primaryKey) {
		_pesquisa.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this pesquisa.
	*
	* @return the uuid of this pesquisa
	*/
	public java.lang.String getUuid() {
		return _pesquisa.getUuid();
	}

	/**
	* Sets the uuid of this pesquisa.
	*
	* @param uuid the uuid of this pesquisa
	*/
	public void setUuid(java.lang.String uuid) {
		_pesquisa.setUuid(uuid);
	}

	/**
	* Returns the ID of this pesquisa.
	*
	* @return the ID of this pesquisa
	*/
	public long getId() {
		return _pesquisa.getId();
	}

	/**
	* Sets the ID of this pesquisa.
	*
	* @param id the ID of this pesquisa
	*/
	public void setId(long id) {
		_pesquisa.setId(id);
	}

	/**
	* Returns the titulo of this pesquisa.
	*
	* @return the titulo of this pesquisa
	*/
	public java.lang.String getTitulo() {
		return _pesquisa.getTitulo();
	}

	/**
	* Returns the localized titulo of this pesquisa in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized titulo of this pesquisa
	*/
	public java.lang.String getTitulo(java.util.Locale locale) {
		return _pesquisa.getTitulo(locale);
	}

	/**
	* Returns the localized titulo of this pesquisa in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized titulo of this pesquisa. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getTitulo(java.util.Locale locale,
		boolean useDefault) {
		return _pesquisa.getTitulo(locale, useDefault);
	}

	/**
	* Returns the localized titulo of this pesquisa in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized titulo of this pesquisa
	*/
	public java.lang.String getTitulo(java.lang.String languageId) {
		return _pesquisa.getTitulo(languageId);
	}

	/**
	* Returns the localized titulo of this pesquisa in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized titulo of this pesquisa
	*/
	public java.lang.String getTitulo(java.lang.String languageId,
		boolean useDefault) {
		return _pesquisa.getTitulo(languageId, useDefault);
	}

	public java.lang.String getTituloCurrentLanguageId() {
		return _pesquisa.getTituloCurrentLanguageId();
	}

	public java.lang.String getTituloCurrentValue() {
		return _pesquisa.getTituloCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titulos of this pesquisa.
	*
	* @return the locales and localized titulos of this pesquisa
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getTituloMap() {
		return _pesquisa.getTituloMap();
	}

	/**
	* Sets the titulo of this pesquisa.
	*
	* @param titulo the titulo of this pesquisa
	*/
	public void setTitulo(java.lang.String titulo) {
		_pesquisa.setTitulo(titulo);
	}

	/**
	* Sets the localized titulo of this pesquisa in the language.
	*
	* @param titulo the localized titulo of this pesquisa
	* @param locale the locale of the language
	*/
	public void setTitulo(java.lang.String titulo, java.util.Locale locale) {
		_pesquisa.setTitulo(titulo, locale);
	}

	/**
	* Sets the localized titulo of this pesquisa in the language, and sets the default locale.
	*
	* @param titulo the localized titulo of this pesquisa
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setTitulo(java.lang.String titulo, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_pesquisa.setTitulo(titulo, locale, defaultLocale);
	}

	public void setTituloCurrentLanguageId(java.lang.String languageId) {
		_pesquisa.setTituloCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titulos of this pesquisa from the map of locales and localized titulos.
	*
	* @param tituloMap the locales and localized titulos of this pesquisa
	*/
	public void setTituloMap(
		java.util.Map<java.util.Locale, java.lang.String> tituloMap) {
		_pesquisa.setTituloMap(tituloMap);
	}

	/**
	* Sets the localized titulos of this pesquisa from the map of locales and localized titulos, and sets the default locale.
	*
	* @param tituloMap the locales and localized titulos of this pesquisa
	* @param defaultLocale the default locale
	*/
	public void setTituloMap(
		java.util.Map<java.util.Locale, java.lang.String> tituloMap,
		java.util.Locale defaultLocale) {
		_pesquisa.setTituloMap(tituloMap, defaultLocale);
	}

	/**
	* Returns the descricao of this pesquisa.
	*
	* @return the descricao of this pesquisa
	*/
	public java.lang.String getDescricao() {
		return _pesquisa.getDescricao();
	}

	/**
	* Returns the localized descricao of this pesquisa in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized descricao of this pesquisa
	*/
	public java.lang.String getDescricao(java.util.Locale locale) {
		return _pesquisa.getDescricao(locale);
	}

	/**
	* Returns the localized descricao of this pesquisa in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this pesquisa. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getDescricao(java.util.Locale locale,
		boolean useDefault) {
		return _pesquisa.getDescricao(locale, useDefault);
	}

	/**
	* Returns the localized descricao of this pesquisa in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized descricao of this pesquisa
	*/
	public java.lang.String getDescricao(java.lang.String languageId) {
		return _pesquisa.getDescricao(languageId);
	}

	/**
	* Returns the localized descricao of this pesquisa in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this pesquisa
	*/
	public java.lang.String getDescricao(java.lang.String languageId,
		boolean useDefault) {
		return _pesquisa.getDescricao(languageId, useDefault);
	}

	public java.lang.String getDescricaoCurrentLanguageId() {
		return _pesquisa.getDescricaoCurrentLanguageId();
	}

	public java.lang.String getDescricaoCurrentValue() {
		return _pesquisa.getDescricaoCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descricaos of this pesquisa.
	*
	* @return the locales and localized descricaos of this pesquisa
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getDescricaoMap() {
		return _pesquisa.getDescricaoMap();
	}

	/**
	* Sets the descricao of this pesquisa.
	*
	* @param descricao the descricao of this pesquisa
	*/
	public void setDescricao(java.lang.String descricao) {
		_pesquisa.setDescricao(descricao);
	}

	/**
	* Sets the localized descricao of this pesquisa in the language.
	*
	* @param descricao the localized descricao of this pesquisa
	* @param locale the locale of the language
	*/
	public void setDescricao(java.lang.String descricao, java.util.Locale locale) {
		_pesquisa.setDescricao(descricao, locale);
	}

	/**
	* Sets the localized descricao of this pesquisa in the language, and sets the default locale.
	*
	* @param descricao the localized descricao of this pesquisa
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setDescricao(java.lang.String descricao,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_pesquisa.setDescricao(descricao, locale, defaultLocale);
	}

	public void setDescricaoCurrentLanguageId(java.lang.String languageId) {
		_pesquisa.setDescricaoCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descricaos of this pesquisa from the map of locales and localized descricaos.
	*
	* @param descricaoMap the locales and localized descricaos of this pesquisa
	*/
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap) {
		_pesquisa.setDescricaoMap(descricaoMap);
	}

	/**
	* Sets the localized descricaos of this pesquisa from the map of locales and localized descricaos, and sets the default locale.
	*
	* @param descricaoMap the locales and localized descricaos of this pesquisa
	* @param defaultLocale the default locale
	*/
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		java.util.Locale defaultLocale) {
		_pesquisa.setDescricaoMap(descricaoMap, defaultLocale);
	}

	/**
	* Returns the data inclusao of this pesquisa.
	*
	* @return the data inclusao of this pesquisa
	*/
	public java.util.Date getDataInclusao() {
		return _pesquisa.getDataInclusao();
	}

	/**
	* Sets the data inclusao of this pesquisa.
	*
	* @param dataInclusao the data inclusao of this pesquisa
	*/
	public void setDataInclusao(java.util.Date dataInclusao) {
		_pesquisa.setDataInclusao(dataInclusao);
	}

	/**
	* Returns the data alteracao of this pesquisa.
	*
	* @return the data alteracao of this pesquisa
	*/
	public java.util.Date getDataAlteracao() {
		return _pesquisa.getDataAlteracao();
	}

	/**
	* Sets the data alteracao of this pesquisa.
	*
	* @param dataAlteracao the data alteracao of this pesquisa
	*/
	public void setDataAlteracao(java.util.Date dataAlteracao) {
		_pesquisa.setDataAlteracao(dataAlteracao);
	}

	/**
	* Returns the ativa of this pesquisa.
	*
	* @return the ativa of this pesquisa
	*/
	public boolean getAtiva() {
		return _pesquisa.getAtiva();
	}

	/**
	* Returns <code>true</code> if this pesquisa is ativa.
	*
	* @return <code>true</code> if this pesquisa is ativa; <code>false</code> otherwise
	*/
	public boolean isAtiva() {
		return _pesquisa.isAtiva();
	}

	/**
	* Sets whether this pesquisa is ativa.
	*
	* @param ativa the ativa of this pesquisa
	*/
	public void setAtiva(boolean ativa) {
		_pesquisa.setAtiva(ativa);
	}

	/**
	* Returns the company ID of this pesquisa.
	*
	* @return the company ID of this pesquisa
	*/
	public long getCompanyId() {
		return _pesquisa.getCompanyId();
	}

	/**
	* Sets the company ID of this pesquisa.
	*
	* @param companyId the company ID of this pesquisa
	*/
	public void setCompanyId(long companyId) {
		_pesquisa.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this pesquisa.
	*
	* @return the group ID of this pesquisa
	*/
	public long getGroupId() {
		return _pesquisa.getGroupId();
	}

	/**
	* Sets the group ID of this pesquisa.
	*
	* @param groupId the group ID of this pesquisa
	*/
	public void setGroupId(long groupId) {
		_pesquisa.setGroupId(groupId);
	}

	/**
	* Returns the user ID inclusao of this pesquisa.
	*
	* @return the user ID inclusao of this pesquisa
	*/
	public long getUserIdInclusao() {
		return _pesquisa.getUserIdInclusao();
	}

	/**
	* Sets the user ID inclusao of this pesquisa.
	*
	* @param userIdInclusao the user ID inclusao of this pesquisa
	*/
	public void setUserIdInclusao(long userIdInclusao) {
		_pesquisa.setUserIdInclusao(userIdInclusao);
	}

	/**
	* Returns the user ID alteracao of this pesquisa.
	*
	* @return the user ID alteracao of this pesquisa
	*/
	public long getUserIdAlteracao() {
		return _pesquisa.getUserIdAlteracao();
	}

	/**
	* Sets the user ID alteracao of this pesquisa.
	*
	* @param userIdAlteracao the user ID alteracao of this pesquisa
	*/
	public void setUserIdAlteracao(long userIdAlteracao) {
		_pesquisa.setUserIdAlteracao(userIdAlteracao);
	}

	public boolean isNew() {
		return _pesquisa.isNew();
	}

	public void setNew(boolean n) {
		_pesquisa.setNew(n);
	}

	public boolean isCachedModel() {
		return _pesquisa.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pesquisa.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pesquisa.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pesquisa.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pesquisa.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pesquisa.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pesquisa.setExpandoBridgeAttributes(serviceContext);
	}

	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_pesquisa.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new PesquisaWrapper((Pesquisa)_pesquisa.clone());
	}

	public int compareTo(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa pesquisa) {
		return _pesquisa.compareTo(pesquisa);
	}

	@Override
	public int hashCode() {
		return _pesquisa.hashCode();
	}

	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa> toCacheModel() {
		return _pesquisa.toCacheModel();
	}

	public br.com.prodevelopment.pesquisaopiniao.model.Pesquisa toEscapedModel() {
		return new PesquisaWrapper(_pesquisa.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pesquisa.toString();
	}

	public java.lang.String toXmlString() {
		return _pesquisa.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pesquisa.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Pesquisa getWrappedPesquisa() {
		return _pesquisa;
	}

	public Pesquisa getWrappedModel() {
		return _pesquisa;
	}

	public void resetOriginalValues() {
		_pesquisa.resetOriginalValues();
	}

	private Pesquisa _pesquisa;
}