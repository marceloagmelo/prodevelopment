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

import br.com.prodevelopment.testeconhecimento.service.TesteLocalServiceUtil;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Marcelo Melo
 */
public class TesteClp extends BaseModelImpl<Teste> implements Teste {
	public TesteClp() {
	}

	public Class<?> getModelClass() {
		return Teste.class;
	}

	public String getModelClassName() {
		return Teste.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTitulo() {
		return _titulo;
	}

	public String getTitulo(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitulo(languageId);
	}

	public String getTitulo(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitulo(languageId, useDefault);
	}

	public String getTitulo(String languageId) {
		return LocalizationUtil.getLocalization(getTitulo(), languageId);
	}

	public String getTitulo(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitulo(), languageId,
			useDefault);
	}

	public String getTituloCurrentLanguageId() {
		return _tituloCurrentLanguageId;
	}

	public String getTituloCurrentValue() {
		Locale locale = getLocale(_tituloCurrentLanguageId);

		return getTitulo(locale);
	}

	public Map<Locale, String> getTituloMap() {
		return LocalizationUtil.getLocalizationMap(getTitulo());
	}

	public void setTitulo(String titulo) {
		_titulo = titulo;
	}

	public void setTitulo(String titulo, Locale locale) {
		setTitulo(titulo, locale, LocaleUtil.getDefault());
	}

	public void setTitulo(String titulo, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(titulo)) {
			setTitulo(LocalizationUtil.updateLocalization(getTitulo(),
					"Titulo", titulo, languageId, defaultLanguageId));
		}
		else {
			setTitulo(LocalizationUtil.removeLocalization(getTitulo(),
					"Titulo", languageId));
		}
	}

	public void setTituloCurrentLanguageId(String languageId) {
		_tituloCurrentLanguageId = languageId;
	}

	public void setTituloMap(Map<Locale, String> tituloMap) {
		setTituloMap(tituloMap, LocaleUtil.getDefault());
	}

	public void setTituloMap(Map<Locale, String> tituloMap, Locale defaultLocale) {
		if (tituloMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			Locale[] locales = LanguageUtil.getAvailableLocales();

			for (Locale locale : locales) {
				String titulo = tituloMap.get(locale);

				setTitulo(titulo, locale, defaultLocale);
			}
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public String getDescricao() {
		return _descricao;
	}

	public String getDescricao(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescricao(languageId);
	}

	public String getDescricao(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescricao(languageId, useDefault);
	}

	public String getDescricao(String languageId) {
		return LocalizationUtil.getLocalization(getDescricao(), languageId);
	}

	public String getDescricao(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescricao(), languageId,
			useDefault);
	}

	public String getDescricaoCurrentLanguageId() {
		return _descricaoCurrentLanguageId;
	}

	public String getDescricaoCurrentValue() {
		Locale locale = getLocale(_descricaoCurrentLanguageId);

		return getDescricao(locale);
	}

	public Map<Locale, String> getDescricaoMap() {
		return LocalizationUtil.getLocalizationMap(getDescricao());
	}

	public void setDescricao(String descricao) {
		_descricao = descricao;
	}

	public void setDescricao(String descricao, Locale locale) {
		setDescricao(descricao, locale, LocaleUtil.getDefault());
	}

	public void setDescricao(String descricao, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(descricao)) {
			setDescricao(LocalizationUtil.updateLocalization(getDescricao(),
					"Descricao", descricao, languageId, defaultLanguageId));
		}
		else {
			setDescricao(LocalizationUtil.removeLocalization(getDescricao(),
					"Descricao", languageId));
		}
	}

	public void setDescricaoCurrentLanguageId(String languageId) {
		_descricaoCurrentLanguageId = languageId;
	}

	public void setDescricaoMap(Map<Locale, String> descricaoMap) {
		setDescricaoMap(descricaoMap, LocaleUtil.getDefault());
	}

	public void setDescricaoMap(Map<Locale, String> descricaoMap,
		Locale defaultLocale) {
		if (descricaoMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			Locale[] locales = LanguageUtil.getAvailableLocales();

			for (Locale locale : locales) {
				String descricao = descricaoMap.get(locale);

				setDescricao(descricao, locale, defaultLocale);
			}
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public Date getDataInclusao() {
		return _dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		_dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return _dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		_dataAlteracao = dataAlteracao;
	}

	public boolean getAtivo() {
		return _ativo;
	}

	public boolean isAtivo() {
		return _ativo;
	}

	public void setAtivo(boolean ativo) {
		_ativo = ativo;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserIdInclusao() {
		return _userIdInclusao;
	}

	public void setUserIdInclusao(long userIdInclusao) {
		_userIdInclusao = userIdInclusao;
	}

	public long getUserIdAlteracao() {
		return _userIdAlteracao;
	}

	public void setUserIdAlteracao(long userIdAlteracao) {
		_userIdAlteracao = userIdAlteracao;
	}

	public BaseModel<?> getTesteRemoteModel() {
		return _testeRemoteModel;
	}

	public void setTesteRemoteModel(BaseModel<?> testeRemoteModel) {
		_testeRemoteModel = testeRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TesteLocalServiceUtil.addTeste(this);
		}
		else {
			TesteLocalServiceUtil.updateTeste(this);
		}
	}

	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		setTitulo(getTitulo(defaultImportLocale), defaultImportLocale,
			defaultImportLocale);
		setDescricao(getDescricao(defaultImportLocale), defaultImportLocale,
			defaultImportLocale);
	}

	@Override
	public Teste toEscapedModel() {
		return (Teste)Proxy.newProxyInstance(Teste.class.getClassLoader(),
			new Class[] { Teste.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TesteClp clone = new TesteClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setTitulo(getTitulo());
		clone.setDescricao(getDescricao());
		clone.setDataInclusao(getDataInclusao());
		clone.setDataAlteracao(getDataAlteracao());
		clone.setAtivo(getAtivo());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserIdInclusao(getUserIdInclusao());
		clone.setUserIdAlteracao(getUserIdAlteracao());

		return clone;
	}

	public int compareTo(Teste teste) {
		int value = 0;

		if (getId() < teste.getId()) {
			value = -1;
		}
		else if (getId() > teste.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TesteClp teste = null;

		try {
			teste = (TesteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = teste.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", titulo=");
		sb.append(getTitulo());
		sb.append(", descricao=");
		sb.append(getDescricao());
		sb.append(", dataInclusao=");
		sb.append(getDataInclusao());
		sb.append(", dataAlteracao=");
		sb.append(getDataAlteracao());
		sb.append(", ativo=");
		sb.append(getAtivo());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userIdInclusao=");
		sb.append(getUserIdInclusao());
		sb.append(", userIdAlteracao=");
		sb.append(getUserIdAlteracao());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.testeconhecimento.model.Teste");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titulo</column-name><column-value><![CDATA[");
		sb.append(getTitulo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descricao</column-name><column-value><![CDATA[");
		sb.append(getDescricao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataInclusao</column-name><column-value><![CDATA[");
		sb.append(getDataInclusao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataAlteracao</column-name><column-value><![CDATA[");
		sb.append(getDataAlteracao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ativo</column-name><column-value><![CDATA[");
		sb.append(getAtivo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdInclusao</column-name><column-value><![CDATA[");
		sb.append(getUserIdInclusao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdAlteracao</column-name><column-value><![CDATA[");
		sb.append(getUserIdAlteracao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _id;
	private String _titulo;
	private String _tituloCurrentLanguageId;
	private String _descricao;
	private String _descricaoCurrentLanguageId;
	private Date _dataInclusao;
	private Date _dataAlteracao;
	private boolean _ativo;
	private long _companyId;
	private long _groupId;
	private long _userIdInclusao;
	private long _userIdAlteracao;
	private BaseModel<?> _testeRemoteModel;
}