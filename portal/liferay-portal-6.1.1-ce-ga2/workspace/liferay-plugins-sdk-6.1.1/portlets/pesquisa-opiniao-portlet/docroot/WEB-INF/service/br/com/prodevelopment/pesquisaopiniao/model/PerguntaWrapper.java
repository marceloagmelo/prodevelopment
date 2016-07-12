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
 * This class is a wrapper for {@link Pergunta}.
 * </p>
 *
 * @author    Marcelo Melo
 * @see       Pergunta
 * @generated
 */
public class PerguntaWrapper implements Pergunta, ModelWrapper<Pergunta> {
	public PerguntaWrapper(Pergunta pergunta) {
		_pergunta = pergunta;
	}

	public Class<?> getModelClass() {
		return Pergunta.class;
	}

	public String getModelClassName() {
		return Pergunta.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descricao", getDescricao());
		attributes.put("dataInclusao", getDataInclusao());
		attributes.put("dataAlteracao", getDataAlteracao());
		attributes.put("pesquisaId", getPesquisaId());
		attributes.put("userIdInclusao", getUserIdInclusao());
		attributes.put("userIdAlteracao", getUserIdAlteracao());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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

		Long pesquisaId = (Long)attributes.get("pesquisaId");

		if (pesquisaId != null) {
			setPesquisaId(pesquisaId);
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
	* Returns the primary key of this pergunta.
	*
	* @return the primary key of this pergunta
	*/
	public long getPrimaryKey() {
		return _pergunta.getPrimaryKey();
	}

	/**
	* Sets the primary key of this pergunta.
	*
	* @param primaryKey the primary key of this pergunta
	*/
	public void setPrimaryKey(long primaryKey) {
		_pergunta.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this pergunta.
	*
	* @return the ID of this pergunta
	*/
	public long getId() {
		return _pergunta.getId();
	}

	/**
	* Sets the ID of this pergunta.
	*
	* @param id the ID of this pergunta
	*/
	public void setId(long id) {
		_pergunta.setId(id);
	}

	/**
	* Returns the descricao of this pergunta.
	*
	* @return the descricao of this pergunta
	*/
	public java.lang.String getDescricao() {
		return _pergunta.getDescricao();
	}

	/**
	* Returns the localized descricao of this pergunta in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized descricao of this pergunta
	*/
	public java.lang.String getDescricao(java.util.Locale locale) {
		return _pergunta.getDescricao(locale);
	}

	/**
	* Returns the localized descricao of this pergunta in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this pergunta. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getDescricao(java.util.Locale locale,
		boolean useDefault) {
		return _pergunta.getDescricao(locale, useDefault);
	}

	/**
	* Returns the localized descricao of this pergunta in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized descricao of this pergunta
	*/
	public java.lang.String getDescricao(java.lang.String languageId) {
		return _pergunta.getDescricao(languageId);
	}

	/**
	* Returns the localized descricao of this pergunta in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized descricao of this pergunta
	*/
	public java.lang.String getDescricao(java.lang.String languageId,
		boolean useDefault) {
		return _pergunta.getDescricao(languageId, useDefault);
	}

	public java.lang.String getDescricaoCurrentLanguageId() {
		return _pergunta.getDescricaoCurrentLanguageId();
	}

	public java.lang.String getDescricaoCurrentValue() {
		return _pergunta.getDescricaoCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descricaos of this pergunta.
	*
	* @return the locales and localized descricaos of this pergunta
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getDescricaoMap() {
		return _pergunta.getDescricaoMap();
	}

	/**
	* Sets the descricao of this pergunta.
	*
	* @param descricao the descricao of this pergunta
	*/
	public void setDescricao(java.lang.String descricao) {
		_pergunta.setDescricao(descricao);
	}

	/**
	* Sets the localized descricao of this pergunta in the language.
	*
	* @param descricao the localized descricao of this pergunta
	* @param locale the locale of the language
	*/
	public void setDescricao(java.lang.String descricao, java.util.Locale locale) {
		_pergunta.setDescricao(descricao, locale);
	}

	/**
	* Sets the localized descricao of this pergunta in the language, and sets the default locale.
	*
	* @param descricao the localized descricao of this pergunta
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setDescricao(java.lang.String descricao,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_pergunta.setDescricao(descricao, locale, defaultLocale);
	}

	public void setDescricaoCurrentLanguageId(java.lang.String languageId) {
		_pergunta.setDescricaoCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descricaos of this pergunta from the map of locales and localized descricaos.
	*
	* @param descricaoMap the locales and localized descricaos of this pergunta
	*/
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap) {
		_pergunta.setDescricaoMap(descricaoMap);
	}

	/**
	* Sets the localized descricaos of this pergunta from the map of locales and localized descricaos, and sets the default locale.
	*
	* @param descricaoMap the locales and localized descricaos of this pergunta
	* @param defaultLocale the default locale
	*/
	public void setDescricaoMap(
		java.util.Map<java.util.Locale, java.lang.String> descricaoMap,
		java.util.Locale defaultLocale) {
		_pergunta.setDescricaoMap(descricaoMap, defaultLocale);
	}

	/**
	* Returns the data inclusao of this pergunta.
	*
	* @return the data inclusao of this pergunta
	*/
	public java.util.Date getDataInclusao() {
		return _pergunta.getDataInclusao();
	}

	/**
	* Sets the data inclusao of this pergunta.
	*
	* @param dataInclusao the data inclusao of this pergunta
	*/
	public void setDataInclusao(java.util.Date dataInclusao) {
		_pergunta.setDataInclusao(dataInclusao);
	}

	/**
	* Returns the data alteracao of this pergunta.
	*
	* @return the data alteracao of this pergunta
	*/
	public java.util.Date getDataAlteracao() {
		return _pergunta.getDataAlteracao();
	}

	/**
	* Sets the data alteracao of this pergunta.
	*
	* @param dataAlteracao the data alteracao of this pergunta
	*/
	public void setDataAlteracao(java.util.Date dataAlteracao) {
		_pergunta.setDataAlteracao(dataAlteracao);
	}

	/**
	* Returns the pesquisa ID of this pergunta.
	*
	* @return the pesquisa ID of this pergunta
	*/
	public long getPesquisaId() {
		return _pergunta.getPesquisaId();
	}

	/**
	* Sets the pesquisa ID of this pergunta.
	*
	* @param pesquisaId the pesquisa ID of this pergunta
	*/
	public void setPesquisaId(long pesquisaId) {
		_pergunta.setPesquisaId(pesquisaId);
	}

	/**
	* Returns the user ID inclusao of this pergunta.
	*
	* @return the user ID inclusao of this pergunta
	*/
	public long getUserIdInclusao() {
		return _pergunta.getUserIdInclusao();
	}

	/**
	* Sets the user ID inclusao of this pergunta.
	*
	* @param userIdInclusao the user ID inclusao of this pergunta
	*/
	public void setUserIdInclusao(long userIdInclusao) {
		_pergunta.setUserIdInclusao(userIdInclusao);
	}

	/**
	* Returns the user ID alteracao of this pergunta.
	*
	* @return the user ID alteracao of this pergunta
	*/
	public long getUserIdAlteracao() {
		return _pergunta.getUserIdAlteracao();
	}

	/**
	* Sets the user ID alteracao of this pergunta.
	*
	* @param userIdAlteracao the user ID alteracao of this pergunta
	*/
	public void setUserIdAlteracao(long userIdAlteracao) {
		_pergunta.setUserIdAlteracao(userIdAlteracao);
	}

	public boolean isNew() {
		return _pergunta.isNew();
	}

	public void setNew(boolean n) {
		_pergunta.setNew(n);
	}

	public boolean isCachedModel() {
		return _pergunta.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pergunta.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pergunta.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pergunta.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pergunta.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pergunta.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pergunta.setExpandoBridgeAttributes(serviceContext);
	}

	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_pergunta.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new PerguntaWrapper((Pergunta)_pergunta.clone());
	}

	public int compareTo(
		br.com.prodevelopment.pesquisaopiniao.model.Pergunta pergunta) {
		return _pergunta.compareTo(pergunta);
	}

	@Override
	public int hashCode() {
		return _pergunta.hashCode();
	}

	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.pesquisaopiniao.model.Pergunta> toCacheModel() {
		return _pergunta.toCacheModel();
	}

	public br.com.prodevelopment.pesquisaopiniao.model.Pergunta toEscapedModel() {
		return new PerguntaWrapper(_pergunta.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pergunta.toString();
	}

	public java.lang.String toXmlString() {
		return _pergunta.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pergunta.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Pergunta getWrappedPergunta() {
		return _pergunta;
	}

	public Pergunta getWrappedModel() {
		return _pergunta;
	}

	public void resetOriginalValues() {
		_pergunta.resetOriginalValues();
	}

	private Pergunta _pergunta;
}