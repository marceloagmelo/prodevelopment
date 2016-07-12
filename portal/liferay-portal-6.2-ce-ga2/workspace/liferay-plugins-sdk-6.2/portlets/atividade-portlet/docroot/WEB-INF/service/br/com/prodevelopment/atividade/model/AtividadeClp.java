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

import br.com.prodevelopment.atividade.service.AtividadeLocalServiceUtil;
import br.com.prodevelopment.atividade.service.ClpSerializer;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Marcelo
 */
public class AtividadeClp extends BaseModelImpl<Atividade> implements Atividade {
	public AtividadeClp() {
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
	public long getPrimaryKey() {
		return _atividadeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAtividadeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _atividadeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_atividadeRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAtividadeId() {
		return _atividadeId;
	}

	@Override
	public void setAtividadeId(long atividadeId) {
		_atividadeId = atividadeId;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setAtividadeId", long.class);

				method.invoke(_atividadeRemoteModel, atividadeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_atividadeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_atividadeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_atividadeRemoteModel, createUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreateUserId(), "uuid",
			_createUserUuid);
	}

	@Override
	public void setCreateUserUuid(String createUserUuid) {
		_createUserUuid = createUserUuid;
	}

	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_atividadeRemoteModel, modifiedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_atividadeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_atividadeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNome() {
		return _nome;
	}

	@Override
	public String getNome(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getNome(languageId);
	}

	@Override
	public String getNome(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getNome(languageId, useDefault);
	}

	@Override
	public String getNome(String languageId) {
		return LocalizationUtil.getLocalization(getNome(), languageId);
	}

	@Override
	public String getNome(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getNome(), languageId,
			useDefault);
	}

	@Override
	public String getNomeCurrentLanguageId() {
		return _nomeCurrentLanguageId;
	}

	@Override
	public String getNomeCurrentValue() {
		Locale locale = getLocale(_nomeCurrentLanguageId);

		return getNome(locale);
	}

	@Override
	public Map<Locale, String> getNomeMap() {
		return LocalizationUtil.getLocalizationMap(getNome());
	}

	@Override
	public void setNome(String nome) {
		_nome = nome;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_atividadeRemoteModel, nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setNome(String nome, Locale locale) {
		setNome(nome, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setNome(String nome, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(nome)) {
			setNome(LocalizationUtil.updateLocalization(getNome(), "Nome",
					nome, languageId, defaultLanguageId));
		}
		else {
			setNome(LocalizationUtil.removeLocalization(getNome(), "Nome",
					languageId));
		}
	}

	@Override
	public void setNomeCurrentLanguageId(String languageId) {
		_nomeCurrentLanguageId = languageId;
	}

	@Override
	public void setNomeMap(Map<Locale, String> nomeMap) {
		setNomeMap(nomeMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNomeMap(Map<Locale, String> nomeMap, Locale defaultLocale) {
		if (nomeMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setNome(LocalizationUtil.updateLocalization(nomeMap, getNome(),
					"Nome", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getDescricao() {
		return _descricao;
	}

	@Override
	public String getDescricao(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescricao(languageId);
	}

	@Override
	public String getDescricao(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescricao(languageId, useDefault);
	}

	@Override
	public String getDescricao(String languageId) {
		return LocalizationUtil.getLocalization(getDescricao(), languageId);
	}

	@Override
	public String getDescricao(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescricao(), languageId,
			useDefault);
	}

	@Override
	public String getDescricaoCurrentLanguageId() {
		return _descricaoCurrentLanguageId;
	}

	@Override
	public String getDescricaoCurrentValue() {
		Locale locale = getLocale(_descricaoCurrentLanguageId);

		return getDescricao(locale);
	}

	@Override
	public Map<Locale, String> getDescricaoMap() {
		return LocalizationUtil.getLocalizationMap(getDescricao());
	}

	@Override
	public void setDescricao(String descricao) {
		_descricao = descricao;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescricao", String.class);

				method.invoke(_atividadeRemoteModel, descricao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDescricao(String descricao, Locale locale) {
		setDescricao(descricao, locale, LocaleUtil.getDefault());
	}

	@Override
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

	@Override
	public void setDescricaoCurrentLanguageId(String languageId) {
		_descricaoCurrentLanguageId = languageId;
	}

	@Override
	public void setDescricaoMap(Map<Locale, String> descricaoMap) {
		setDescricaoMap(descricaoMap, LocaleUtil.getDefault());
	}

	@Override
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

			setDescricao(LocalizationUtil.updateLocalization(descricaoMap,
					getDescricao(), "Descricao",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getImagemId() {
		return _imagemId;
	}

	@Override
	public void setImagemId(long imagemId) {
		_imagemId = imagemId;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setImagemId", long.class);

				method.invoke(_atividadeRemoteModel, imagemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getExisteImagem() {
		return _existeImagem;
	}

	@Override
	public boolean isExisteImagem() {
		return _existeImagem;
	}

	@Override
	public void setExisteImagem(boolean existeImagem) {
		_existeImagem = existeImagem;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setExisteImagem", boolean.class);

				method.invoke(_atividadeRemoteModel, existeImagem);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getVersao() {
		return _versao;
	}

	@Override
	public void setVersao(double versao) {
		_versao = versao;

		if (_atividadeRemoteModel != null) {
			try {
				Class<?> clazz = _atividadeRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_atividadeRemoteModel, versao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getImagemURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		try {
			String methodName = "getImagemURL";

			Class<?>[] parameterTypes = new Class<?>[] {
					com.liferay.portal.theme.ThemeDisplay.class
				};

			Object[] parameterValues = new Object[] { themeDisplay };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Atividade.class.getName()));
	}

	public BaseModel<?> getAtividadeRemoteModel() {
		return _atividadeRemoteModel;
	}

	public void setAtividadeRemoteModel(BaseModel<?> atividadeRemoteModel) {
		_atividadeRemoteModel = atividadeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _atividadeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_atividadeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AtividadeLocalServiceUtil.addAtividade(this);
		}
		else {
			AtividadeLocalServiceUtil.updateAtividade(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nomeMap = getNomeMap();

		for (Map.Entry<Locale, String> entry : nomeMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descricaoMap = getDescricaoMap();

		for (Map.Entry<Locale, String> entry : descricaoMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getNome();

		if (xml == null) {
			return StringPool.BLANK;
		}

		return LocalizationUtil.getDefaultLanguageId(xml);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String nome = getNome(defaultLocale);

		if (Validator.isNull(nome)) {
			setNome(getNome(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setNome(getNome(defaultLocale), defaultLocale, defaultLocale);
		}

		String descricao = getDescricao(defaultLocale);

		if (Validator.isNull(descricao)) {
			setDescricao(getDescricao(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescricao(getDescricao(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Atividade toEscapedModel() {
		return (Atividade)ProxyUtil.newProxyInstance(Atividade.class.getClassLoader(),
			new Class[] { Atividade.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AtividadeClp clone = new AtividadeClp();

		clone.setUuid(getUuid());
		clone.setAtividadeId(getAtividadeId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNome(getNome());
		clone.setDescricao(getDescricao());
		clone.setImagemId(getImagemId());
		clone.setExisteImagem(getExisteImagem());
		clone.setVersao(getVersao());

		return clone;
	}

	@Override
	public int compareTo(Atividade atividade) {
		int value = 0;

		value = getNome().compareTo(atividade.getNome());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AtividadeClp)) {
			return false;
		}

		AtividadeClp atividade = (AtividadeClp)obj;

		long primaryKey = atividade.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", atividadeId=");
		sb.append(getAtividadeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", descricao=");
		sb.append(getDescricao());
		sb.append(", imagemId=");
		sb.append(getImagemId());
		sb.append(", existeImagem=");
		sb.append(getExisteImagem());
		sb.append(", versao=");
		sb.append(getVersao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.atividade.model.Atividade");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atividadeId</column-name><column-value><![CDATA[");
		sb.append(getAtividadeId());
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
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descricao</column-name><column-value><![CDATA[");
		sb.append(getDescricao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imagemId</column-name><column-value><![CDATA[");
		sb.append(getImagemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>existeImagem</column-name><column-value><![CDATA[");
		sb.append(getExisteImagem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _atividadeId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _nomeCurrentLanguageId;
	private String _descricao;
	private String _descricaoCurrentLanguageId;
	private long _imagemId;
	private boolean _existeImagem;
	private double _versao;
	private BaseModel<?> _atividadeRemoteModel;
}