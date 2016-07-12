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

import br.com.prodevelopment.testeconhecimento.service.PerguntaLocalServiceUtil;

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
public class PerguntaClp extends BaseModelImpl<Pergunta> implements Pergunta {
	public PerguntaClp() {
	}

	public Class<?> getModelClass() {
		return Pergunta.class;
	}

	public String getModelClassName() {
		return Pergunta.class.getName();
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

		attributes.put("id", getId());
		attributes.put("descricao", getDescricao());
		attributes.put("justificativaResposta", getJustificativaResposta());
		attributes.put("pontuacao", getPontuacao());
		attributes.put("dataInclusao", getDataInclusao());
		attributes.put("dataAlteracao", getDataAlteracao());
		attributes.put("testeId", getTesteId());
		attributes.put("userIdInclusao", getUserIdInclusao());
		attributes.put("userIdAlteracao", getUserIdAlteracao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descricao = (String)attributes.get("descricao");

		if (descricao != null) {
			setDescricao(descricao);
		}

		String justificativaResposta = (String)attributes.get(
				"justificativaResposta");

		if (justificativaResposta != null) {
			setJustificativaResposta(justificativaResposta);
		}

		Double pontuacao = (Double)attributes.get("pontuacao");

		if (pontuacao != null) {
			setPontuacao(pontuacao);
		}

		Date dataInclusao = (Date)attributes.get("dataInclusao");

		if (dataInclusao != null) {
			setDataInclusao(dataInclusao);
		}

		Date dataAlteracao = (Date)attributes.get("dataAlteracao");

		if (dataAlteracao != null) {
			setDataAlteracao(dataAlteracao);
		}

		Long testeId = (Long)attributes.get("testeId");

		if (testeId != null) {
			setTesteId(testeId);
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public String getJustificativaResposta() {
		return _justificativaResposta;
	}

	public String getJustificativaResposta(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getJustificativaResposta(languageId);
	}

	public String getJustificativaResposta(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getJustificativaResposta(languageId, useDefault);
	}

	public String getJustificativaResposta(String languageId) {
		return LocalizationUtil.getLocalization(getJustificativaResposta(),
			languageId);
	}

	public String getJustificativaResposta(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getJustificativaResposta(),
			languageId, useDefault);
	}

	public String getJustificativaRespostaCurrentLanguageId() {
		return _justificativaRespostaCurrentLanguageId;
	}

	public String getJustificativaRespostaCurrentValue() {
		Locale locale = getLocale(_justificativaRespostaCurrentLanguageId);

		return getJustificativaResposta(locale);
	}

	public Map<Locale, String> getJustificativaRespostaMap() {
		return LocalizationUtil.getLocalizationMap(getJustificativaResposta());
	}

	public void setJustificativaResposta(String justificativaResposta) {
		_justificativaResposta = justificativaResposta;
	}

	public void setJustificativaResposta(String justificativaResposta,
		Locale locale) {
		setJustificativaResposta(justificativaResposta, locale,
			LocaleUtil.getDefault());
	}

	public void setJustificativaResposta(String justificativaResposta,
		Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(justificativaResposta)) {
			setJustificativaResposta(LocalizationUtil.updateLocalization(
					getJustificativaResposta(), "JustificativaResposta",
					justificativaResposta, languageId, defaultLanguageId));
		}
		else {
			setJustificativaResposta(LocalizationUtil.removeLocalization(
					getJustificativaResposta(), "JustificativaResposta",
					languageId));
		}
	}

	public void setJustificativaRespostaCurrentLanguageId(String languageId) {
		_justificativaRespostaCurrentLanguageId = languageId;
	}

	public void setJustificativaRespostaMap(
		Map<Locale, String> justificativaRespostaMap) {
		setJustificativaRespostaMap(justificativaRespostaMap,
			LocaleUtil.getDefault());
	}

	public void setJustificativaRespostaMap(
		Map<Locale, String> justificativaRespostaMap, Locale defaultLocale) {
		if (justificativaRespostaMap == null) {
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
				String justificativaResposta = justificativaRespostaMap.get(locale);

				setJustificativaResposta(justificativaResposta, locale,
					defaultLocale);
			}
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public double getPontuacao() {
		return _pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		_pontuacao = pontuacao;
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

	public long getTesteId() {
		return _testeId;
	}

	public void setTesteId(long testeId) {
		_testeId = testeId;
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

	public BaseModel<?> getPerguntaRemoteModel() {
		return _perguntaRemoteModel;
	}

	public void setPerguntaRemoteModel(BaseModel<?> perguntaRemoteModel) {
		_perguntaRemoteModel = perguntaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PerguntaLocalServiceUtil.addPergunta(this);
		}
		else {
			PerguntaLocalServiceUtil.updatePergunta(this);
		}
	}

	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		setDescricao(getDescricao(defaultImportLocale), defaultImportLocale,
			defaultImportLocale);
		setJustificativaResposta(getJustificativaResposta(defaultImportLocale),
			defaultImportLocale, defaultImportLocale);
	}

	@Override
	public Pergunta toEscapedModel() {
		return (Pergunta)Proxy.newProxyInstance(Pergunta.class.getClassLoader(),
			new Class[] { Pergunta.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PerguntaClp clone = new PerguntaClp();

		clone.setId(getId());
		clone.setDescricao(getDescricao());
		clone.setJustificativaResposta(getJustificativaResposta());
		clone.setPontuacao(getPontuacao());
		clone.setDataInclusao(getDataInclusao());
		clone.setDataAlteracao(getDataAlteracao());
		clone.setTesteId(getTesteId());
		clone.setUserIdInclusao(getUserIdInclusao());
		clone.setUserIdAlteracao(getUserIdAlteracao());

		return clone;
	}

	public int compareTo(Pergunta pergunta) {
		int value = 0;

		if (getId() < pergunta.getId()) {
			value = -1;
		}
		else if (getId() > pergunta.getId()) {
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

		PerguntaClp pergunta = null;

		try {
			pergunta = (PerguntaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = pergunta.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", descricao=");
		sb.append(getDescricao());
		sb.append(", justificativaResposta=");
		sb.append(getJustificativaResposta());
		sb.append(", pontuacao=");
		sb.append(getPontuacao());
		sb.append(", dataInclusao=");
		sb.append(getDataInclusao());
		sb.append(", dataAlteracao=");
		sb.append(getDataAlteracao());
		sb.append(", testeId=");
		sb.append(getTesteId());
		sb.append(", userIdInclusao=");
		sb.append(getUserIdInclusao());
		sb.append(", userIdAlteracao=");
		sb.append(getUserIdAlteracao());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.testeconhecimento.model.Pergunta");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descricao</column-name><column-value><![CDATA[");
		sb.append(getDescricao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>justificativaResposta</column-name><column-value><![CDATA[");
		sb.append(getJustificativaResposta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pontuacao</column-name><column-value><![CDATA[");
		sb.append(getPontuacao());
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
			"<column><column-name>testeId</column-name><column-value><![CDATA[");
		sb.append(getTesteId());
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

	private long _id;
	private String _descricao;
	private String _descricaoCurrentLanguageId;
	private String _justificativaResposta;
	private String _justificativaRespostaCurrentLanguageId;
	private double _pontuacao;
	private Date _dataInclusao;
	private Date _dataAlteracao;
	private long _testeId;
	private long _userIdInclusao;
	private long _userIdAlteracao;
	private BaseModel<?> _perguntaRemoteModel;
}