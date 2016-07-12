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

package br.com.prodevelopment.testeconhecimento.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Teste}.
 * </p>
 *
 * @author    Marcelo Melo
 * @see       Teste
 * @generated
 */
public class TesteWrapper implements Teste, ModelWrapper<Teste> {
	public TesteWrapper(Teste teste) {
		_teste = teste;
	}

	public Class<?> getModelClass() {
		return Teste.class;
	}

	public String getModelClassName() {
		return Teste.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("titulo", getTitulo());
		attributes.put("descricao", getDescricao());
		attributes.put("dataInclusao", getDataInclusao());
		attributes.put("dataAlteracao", getDataAlteracao());
		attributes.put("ativo", getAtivo());
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

		Boolean ativo = (Boolean)attributes.get("ativo");

		if (ativo != null) {
			setAtivo(ativo);
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
	* Returns the primary key of this teste.
	*
	* @return the primary key of this teste
	*/
	public long getPrimaryKey() {
		return _teste.getPrimaryKey();
	}

	/**
	* Sets the primary key of this teste.
	*
	* @param primaryKey the primary key of this teste
	*/
	public void setPrimaryKey(long primaryKey) {
		_teste.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this teste.
	*
	* @return the uuid of this teste
	*/
	public java.lang.String getUuid() {
		return _teste.getUuid();
	}

	/**
	* Sets the uuid of this teste.
	*
	* @param uuid the uuid of this teste
	*/
	public void setUuid(java.lang.String uuid) {
		_teste.setUuid(uuid);
	}

	/**
	* Returns the ID of this teste.
	*
	* @return the ID of this teste
	*/
	public long getId() {
		return _teste.getId();
	}

	/**
	* Sets the ID of this teste.
	*
	* @param id the ID of this teste
	*/
	public void setId(long id) {
		_teste.setId(id);
	}

	/**
	* Returns the titulo of this teste.
	*
	* @return the titulo of this teste
	*/
	public java.lang.String getTitulo() {
		return _teste.getTitulo();
	}

	/**
	* Returns the localized titulo of this teste in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized titulo of this teste
	*/
	public java.lang.String getTitulo(java.util.Locale locale) {
		return _teste.getTitulo(locale);
	}

	/**
	* Returns the localized titulo of this teste in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized titulo of this teste. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getTitulo(java.util.Locale locale,
		boolean useDefault) {
		return _teste.getTitulo(locale, useDefault);
	}

	/**
	* Returns the localized titulo of this teste in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized titulo of this teste
	*/
	public java.lang.String getTitulo(java.lang.String languageId) {
		return _teste.getTitulo(languageId);
	}

	/**
	* Returns the localized titulo of this teste in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized titulo of this teste
	*/
	public java.lang.String getTitulo(java.lang.String languageId,
		boolean useDefault) {
		return _teste.getTitulo(languageId, useDefault);
	}

	public java.lang.String getTituloCurrentLanguageId() {
		return _teste.getTituloCurrentLanguageId();
	}

	public java.lang.String getTituloCurrentValue() {
		return _teste.getTituloCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titulos of this teste.
	*
	* @return the locales and localized titulos of this teste
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getTituloMap() {
		return _teste.getTituloMap();
	}

	/**
	* Sets the titulo of this teste.
	*
	* @param titulo the titulo of this teste
	*/
	public void setTitulo(java.lang.String titulo) {
		_teste.setTitulo(titulo);
	}

	/**
	* Sets the localized titulo of this teste in the language.
	*
	* @param titulo the localized titulo of this teste
	* @param locale the locale of the language
	*/
	public void setTitulo(java.lang.String titulo, java.util.Locale locale) {
		_teste.setTitulo(titulo, locale);
	}

	/**
	* Sets the localized titulo of this teste in the language, and sets the default locale.
	*
	* @param titulo the localized titulo of this teste
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setTitulo(java.lang.String titulo, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_teste.setTitulo(titulo, locale, defaultLocale);
	}

	public void setTituloCurrentLanguageId(java.lang.String languageId) {
		_teste.setTituloCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titulos of this teste from the map of locales and localized titulos.
	*
	* @param tituloMap the locales and localized titulos of this teste
	*/
	public void setTituloMap(
		java.util.Map<java.util.Locale, java.lang.String> tituloMap) {
		_teste.setTituloMap(tituloMap);
	}

	/**
	* Sets the localized titulos of this teste from the map of locales and localized titulos, and sets the default locale.
	*
	* @param tituloMap the locales and localized titulos of this teste
	* @param defaultLocale the default locale
	*/
	public void setTituloMap(
		java.util.Map<java.util.Locale, java.lang.String> tituloMap,
		java.util.Locale defaultLocale) {
		_teste.setTituloMap(tituloMap, defaultLocale);
	}

	/**
	* Returns the descricao of this teste.
	*
	* @return the descricao of this teste
	*/
	public java.lang.String getDescricao() {
		return _teste.getDescricao();
	}

	/**
	* Returns the localized descricao of this teste in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized descricao of this teste
	*/
	public java.lang.String getDescricao(java.util.Locale locale) {
		return _teste.getDescricao(locale);
	}

	/**
	* Returns the localized descricao of this teste in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this teste. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getDescricao(java.util.Locale locale,
		boolean useDefault) {
		return _teste.getDescricao(locale, useDefault);
	}

	/**
	* Returns the localized descricao of this teste in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized descricao of this teste
	*/
	public java.lang.String getDescricao(java.lang.String languageId) {
		return _teste.getDescricao(languageId);
	}

	/**
	* Returns the localized descricao of this teste in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this teste
	*/
	public java.lang.String getDescricao(java.lang.String languageId,
		boolean useDefault) {
		return _teste.getDescricao(languageId, useDefault);
	}

	public java.lang.String getDescricaoCurrentLanguageId() {
		return _teste.getDescricaoCurrentLanguageId();
	}

	public java.lang.String getDescricaoCurrentValue() {
		return _teste.getDescricaoCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descricaos of this teste.
	*
	* @return the locales and localized descricaos of this teste
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getDescricaoMap() {
		return _teste.getDescricaoMap();
	}

	/**
	* Sets the descricao of this teste.
	*
	* @param descricao the descricao of this teste
	*/
	public void setDescricao(java.lang.String descricao) {
		_teste.setDescricao(descricao);
	}

	/**
	* Sets the localized descricao of this teste in the language.
	*
	* @param descricao the localized descricao of this teste
	* @param locale the locale of the language
	*/
	public void setDescricao(java.lang.String descricao, java.util.Locale locale) {
		_teste.setDescricao(descricao, locale);
	}

	/**
	* Sets the localized descricao of this teste in the language, and sets the default locale.
	*
	* @param descricao the localized descricao of this teste
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setDescricao(java.lang.String descricao,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_teste.setDescricao(descricao, locale, defaultLocale);
	}

	public void setDescricaoCurrentLanguageId(java.lang.String languageId) {
		_teste.setDescricaoCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descricaos of this teste from the map of locales and localized descricaos.
	*
	* @param descricaoMap the locales and localized descricaos of this teste
	*/
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap) {
		_teste.setDescricaoMap(descricaoMap);
	}

	/**
	* Sets the localized descricaos of this teste from the map of locales and localized descricaos, and sets the default locale.
	*
	* @param descricaoMap the locales and localized descricaos of this teste
	* @param defaultLocale the default locale
	*/
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		java.util.Locale defaultLocale) {
		_teste.setDescricaoMap(descricaoMap, defaultLocale);
	}

	/**
	* Returns the data inclusao of this teste.
	*
	* @return the data inclusao of this teste
	*/
	public java.util.Date getDataInclusao() {
		return _teste.getDataInclusao();
	}

	/**
	* Sets the data inclusao of this teste.
	*
	* @param dataInclusao the data inclusao of this teste
	*/
	public void setDataInclusao(java.util.Date dataInclusao) {
		_teste.setDataInclusao(dataInclusao);
	}

	/**
	* Returns the data alteracao of this teste.
	*
	* @return the data alteracao of this teste
	*/
	public java.util.Date getDataAlteracao() {
		return _teste.getDataAlteracao();
	}

	/**
	* Sets the data alteracao of this teste.
	*
	* @param dataAlteracao the data alteracao of this teste
	*/
	public void setDataAlteracao(java.util.Date dataAlteracao) {
		_teste.setDataAlteracao(dataAlteracao);
	}

	/**
	* Returns the ativo of this teste.
	*
	* @return the ativo of this teste
	*/
	public boolean getAtivo() {
		return _teste.getAtivo();
	}

	/**
	* Returns <code>true</code> if this teste is ativo.
	*
	* @return <code>true</code> if this teste is ativo; <code>false</code> otherwise
	*/
	public boolean isAtivo() {
		return _teste.isAtivo();
	}

	/**
	* Sets whether this teste is ativo.
	*
	* @param ativo the ativo of this teste
	*/
	public void setAtivo(boolean ativo) {
		_teste.setAtivo(ativo);
	}

	/**
	* Returns the company ID of this teste.
	*
	* @return the company ID of this teste
	*/
	public long getCompanyId() {
		return _teste.getCompanyId();
	}

	/**
	* Sets the company ID of this teste.
	*
	* @param companyId the company ID of this teste
	*/
	public void setCompanyId(long companyId) {
		_teste.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this teste.
	*
	* @return the group ID of this teste
	*/
	public long getGroupId() {
		return _teste.getGroupId();
	}

	/**
	* Sets the group ID of this teste.
	*
	* @param groupId the group ID of this teste
	*/
	public void setGroupId(long groupId) {
		_teste.setGroupId(groupId);
	}

	/**
	* Returns the user ID inclusao of this teste.
	*
	* @return the user ID inclusao of this teste
	*/
	public long getUserIdInclusao() {
		return _teste.getUserIdInclusao();
	}

	/**
	* Sets the user ID inclusao of this teste.
	*
	* @param userIdInclusao the user ID inclusao of this teste
	*/
	public void setUserIdInclusao(long userIdInclusao) {
		_teste.setUserIdInclusao(userIdInclusao);
	}

	/**
	* Returns the user ID alteracao of this teste.
	*
	* @return the user ID alteracao of this teste
	*/
	public long getUserIdAlteracao() {
		return _teste.getUserIdAlteracao();
	}

	/**
	* Sets the user ID alteracao of this teste.
	*
	* @param userIdAlteracao the user ID alteracao of this teste
	*/
	public void setUserIdAlteracao(long userIdAlteracao) {
		_teste.setUserIdAlteracao(userIdAlteracao);
	}

	public boolean isNew() {
		return _teste.isNew();
	}

	public void setNew(boolean n) {
		_teste.setNew(n);
	}

	public boolean isCachedModel() {
		return _teste.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_teste.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _teste.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _teste.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_teste.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _teste.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_teste.setExpandoBridgeAttributes(serviceContext);
	}

	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_teste.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new TesteWrapper((Teste)_teste.clone());
	}

	public int compareTo(
		br.com.prodevelopment.testeconhecimento.model.Teste teste) {
		return _teste.compareTo(teste);
	}

	@Override
	public int hashCode() {
		return _teste.hashCode();
	}

	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.testeconhecimento.model.Teste> toCacheModel() {
		return _teste.toCacheModel();
	}

	public br.com.prodevelopment.testeconhecimento.model.Teste toEscapedModel() {
		return new TesteWrapper(_teste.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _teste.toString();
	}

	public java.lang.String toXmlString() {
		return _teste.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_teste.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Teste getWrappedTeste() {
		return _teste;
	}

	public Teste getWrappedModel() {
		return _teste;
	}

	public void resetOriginalValues() {
		_teste.resetOriginalValues();
	}

	private Teste _teste;
}