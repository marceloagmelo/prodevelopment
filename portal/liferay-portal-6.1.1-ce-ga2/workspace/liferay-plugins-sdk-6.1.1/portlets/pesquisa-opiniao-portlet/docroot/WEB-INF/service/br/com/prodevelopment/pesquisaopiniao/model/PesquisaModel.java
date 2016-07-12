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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Pesquisa service. Represents a row in the &quot;PO_Pesquisa&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Pesquisa
 * @see br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaImpl
 * @see br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaModelImpl
 * @generated
 */
public interface PesquisaModel extends BaseModel<Pesquisa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pesquisa model instance should use the {@link Pesquisa} interface instead.
	 */

	/**
	 * Returns the primary key of this pesquisa.
	 *
	 * @return the primary key of this pesquisa
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this pesquisa.
	 *
	 * @param primaryKey the primary key of this pesquisa
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this pesquisa.
	 *
	 * @return the uuid of this pesquisa
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this pesquisa.
	 *
	 * @param uuid the uuid of this pesquisa
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this pesquisa.
	 *
	 * @return the ID of this pesquisa
	 */
	public long getId();

	/**
	 * Sets the ID of this pesquisa.
	 *
	 * @param id the ID of this pesquisa
	 */
	public void setId(long id);

	/**
	 * Returns the titulo of this pesquisa.
	 *
	 * @return the titulo of this pesquisa
	 */
	public String getTitulo();

	/**
	 * Returns the localized titulo of this pesquisa in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized titulo of this pesquisa
	 */
	@AutoEscape
	public String getTitulo(Locale locale);

	/**
	 * Returns the localized titulo of this pesquisa in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized titulo of this pesquisa. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitulo(Locale locale, boolean useDefault);

	/**
	 * Returns the localized titulo of this pesquisa in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized titulo of this pesquisa
	 */
	@AutoEscape
	public String getTitulo(String languageId);

	/**
	 * Returns the localized titulo of this pesquisa in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized titulo of this pesquisa
	 */
	@AutoEscape
	public String getTitulo(String languageId, boolean useDefault);

	@AutoEscape
	public String getTituloCurrentLanguageId();

	@AutoEscape
	public String getTituloCurrentValue();

	/**
	 * Returns a map of the locales and localized titulos of this pesquisa.
	 *
	 * @return the locales and localized titulos of this pesquisa
	 */
	public Map<Locale, String> getTituloMap();

	/**
	 * Sets the titulo of this pesquisa.
	 *
	 * @param titulo the titulo of this pesquisa
	 */
	public void setTitulo(String titulo);

	/**
	 * Sets the localized titulo of this pesquisa in the language.
	 *
	 * @param titulo the localized titulo of this pesquisa
	 * @param locale the locale of the language
	 */
	public void setTitulo(String titulo, Locale locale);

	/**
	 * Sets the localized titulo of this pesquisa in the language, and sets the default locale.
	 *
	 * @param titulo the localized titulo of this pesquisa
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitulo(String titulo, Locale locale, Locale defaultLocale);

	public void setTituloCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titulos of this pesquisa from the map of locales and localized titulos.
	 *
	 * @param tituloMap the locales and localized titulos of this pesquisa
	 */
	public void setTituloMap(Map<Locale, String> tituloMap);

	/**
	 * Sets the localized titulos of this pesquisa from the map of locales and localized titulos, and sets the default locale.
	 *
	 * @param tituloMap the locales and localized titulos of this pesquisa
	 * @param defaultLocale the default locale
	 */
	public void setTituloMap(Map<Locale, String> tituloMap, Locale defaultLocale);

	/**
	 * Returns the descricao of this pesquisa.
	 *
	 * @return the descricao of this pesquisa
	 */
	public String getDescricao();

	/**
	 * Returns the localized descricao of this pesquisa in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized descricao of this pesquisa
	 */
	@AutoEscape
	public String getDescricao(Locale locale);

	/**
	 * Returns the localized descricao of this pesquisa in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized descricao of this pesquisa. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescricao(Locale locale, boolean useDefault);

	/**
	 * Returns the localized descricao of this pesquisa in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized descricao of this pesquisa
	 */
	@AutoEscape
	public String getDescricao(String languageId);

	/**
	 * Returns the localized descricao of this pesquisa in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized descricao of this pesquisa
	 */
	@AutoEscape
	public String getDescricao(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescricaoCurrentLanguageId();

	@AutoEscape
	public String getDescricaoCurrentValue();

	/**
	 * Returns a map of the locales and localized descricaos of this pesquisa.
	 *
	 * @return the locales and localized descricaos of this pesquisa
	 */
	public Map<Locale, String> getDescricaoMap();

	/**
	 * Sets the descricao of this pesquisa.
	 *
	 * @param descricao the descricao of this pesquisa
	 */
	public void setDescricao(String descricao);

	/**
	 * Sets the localized descricao of this pesquisa in the language.
	 *
	 * @param descricao the localized descricao of this pesquisa
	 * @param locale the locale of the language
	 */
	public void setDescricao(String descricao, Locale locale);

	/**
	 * Sets the localized descricao of this pesquisa in the language, and sets the default locale.
	 *
	 * @param descricao the localized descricao of this pesquisa
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescricao(String descricao, Locale locale,
		Locale defaultLocale);

	public void setDescricaoCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descricaos of this pesquisa from the map of locales and localized descricaos.
	 *
	 * @param descricaoMap the locales and localized descricaos of this pesquisa
	 */
	public void setDescricaoMap(Map<Locale, String> descricaoMap);

	/**
	 * Sets the localized descricaos of this pesquisa from the map of locales and localized descricaos, and sets the default locale.
	 *
	 * @param descricaoMap the locales and localized descricaos of this pesquisa
	 * @param defaultLocale the default locale
	 */
	public void setDescricaoMap(Map<Locale, String> descricaoMap,
		Locale defaultLocale);

	/**
	 * Returns the data inclusao of this pesquisa.
	 *
	 * @return the data inclusao of this pesquisa
	 */
	public Date getDataInclusao();

	/**
	 * Sets the data inclusao of this pesquisa.
	 *
	 * @param dataInclusao the data inclusao of this pesquisa
	 */
	public void setDataInclusao(Date dataInclusao);

	/**
	 * Returns the data alteracao of this pesquisa.
	 *
	 * @return the data alteracao of this pesquisa
	 */
	public Date getDataAlteracao();

	/**
	 * Sets the data alteracao of this pesquisa.
	 *
	 * @param dataAlteracao the data alteracao of this pesquisa
	 */
	public void setDataAlteracao(Date dataAlteracao);

	/**
	 * Returns the ativa of this pesquisa.
	 *
	 * @return the ativa of this pesquisa
	 */
	public boolean getAtiva();

	/**
	 * Returns <code>true</code> if this pesquisa is ativa.
	 *
	 * @return <code>true</code> if this pesquisa is ativa; <code>false</code> otherwise
	 */
	public boolean isAtiva();

	/**
	 * Sets whether this pesquisa is ativa.
	 *
	 * @param ativa the ativa of this pesquisa
	 */
	public void setAtiva(boolean ativa);

	/**
	 * Returns the company ID of this pesquisa.
	 *
	 * @return the company ID of this pesquisa
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this pesquisa.
	 *
	 * @param companyId the company ID of this pesquisa
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this pesquisa.
	 *
	 * @return the group ID of this pesquisa
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this pesquisa.
	 *
	 * @param groupId the group ID of this pesquisa
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID inclusao of this pesquisa.
	 *
	 * @return the user ID inclusao of this pesquisa
	 */
	public long getUserIdInclusao();

	/**
	 * Sets the user ID inclusao of this pesquisa.
	 *
	 * @param userIdInclusao the user ID inclusao of this pesquisa
	 */
	public void setUserIdInclusao(long userIdInclusao);

	/**
	 * Returns the user ID alteracao of this pesquisa.
	 *
	 * @return the user ID alteracao of this pesquisa
	 */
	public long getUserIdAlteracao();

	/**
	 * Sets the user ID alteracao of this pesquisa.
	 *
	 * @param userIdAlteracao the user ID alteracao of this pesquisa
	 */
	public void setUserIdAlteracao(long userIdAlteracao);

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

	public int compareTo(Pesquisa pesquisa);

	public int hashCode();

	public CacheModel<Pesquisa> toCacheModel();

	public Pesquisa toEscapedModel();

	public String toString();

	public String toXmlString();
}