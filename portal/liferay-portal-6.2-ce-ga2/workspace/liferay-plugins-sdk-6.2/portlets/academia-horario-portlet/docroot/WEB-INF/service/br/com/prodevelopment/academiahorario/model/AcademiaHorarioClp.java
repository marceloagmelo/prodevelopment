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

import br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil;
import br.com.prodevelopment.academiahorario.service.ClpSerializer;

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
public class AcademiaHorarioClp extends BaseModelImpl<AcademiaHorario>
	implements AcademiaHorario {
	public AcademiaHorarioClp() {
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
	public long getPrimaryKey() {
		return _academiaHorarioId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAcademiaHorarioId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _academiaHorarioId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_academiaHorarioRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAcademiaHorarioId() {
		return _academiaHorarioId;
	}

	@Override
	public void setAcademiaHorarioId(long academiaHorarioId) {
		_academiaHorarioId = academiaHorarioId;

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setAcademiaHorarioId",
						long.class);

				method.invoke(_academiaHorarioRemoteModel, academiaHorarioId);
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

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_academiaHorarioRemoteModel, companyId);
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

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_academiaHorarioRemoteModel, groupId);
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

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_academiaHorarioRemoteModel, createUserId);
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

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_academiaHorarioRemoteModel, modifiedUserId);
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

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_academiaHorarioRemoteModel, createDate);
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

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_academiaHorarioRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDiaSemana() {
		return _diaSemana;
	}

	@Override
	public void setDiaSemana(int diaSemana) {
		_diaSemana = diaSemana;

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setDiaSemana", int.class);

				method.invoke(_academiaHorarioRemoteModel, diaSemana);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHoraInicial() {
		return _horaInicial;
	}

	@Override
	public void setHoraInicial(String horaInicial) {
		_horaInicial = horaInicial;

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setHoraInicial", String.class);

				method.invoke(_academiaHorarioRemoteModel, horaInicial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHoraFinal() {
		return _HoraFinal;
	}

	@Override
	public void setHoraFinal(String HoraFinal) {
		_HoraFinal = HoraFinal;

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setHoraFinal", String.class);

				method.invoke(_academiaHorarioRemoteModel, HoraFinal);
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

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setAtividadeId", long.class);

				method.invoke(_academiaHorarioRemoteModel, atividadeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAtividadeNome() {
		return _atividadeNome;
	}

	@Override
	public String getAtividadeNome(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getAtividadeNome(languageId);
	}

	@Override
	public String getAtividadeNome(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getAtividadeNome(languageId, useDefault);
	}

	@Override
	public String getAtividadeNome(String languageId) {
		return LocalizationUtil.getLocalization(getAtividadeNome(), languageId);
	}

	@Override
	public String getAtividadeNome(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getAtividadeNome(), languageId,
			useDefault);
	}

	@Override
	public String getAtividadeNomeCurrentLanguageId() {
		return _atividadeNomeCurrentLanguageId;
	}

	@Override
	public String getAtividadeNomeCurrentValue() {
		Locale locale = getLocale(_atividadeNomeCurrentLanguageId);

		return getAtividadeNome(locale);
	}

	@Override
	public Map<Locale, String> getAtividadeNomeMap() {
		return LocalizationUtil.getLocalizationMap(getAtividadeNome());
	}

	@Override
	public void setAtividadeNome(String atividadeNome) {
		_atividadeNome = atividadeNome;

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setAtividadeNome", String.class);

				method.invoke(_academiaHorarioRemoteModel, atividadeNome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setAtividadeNome(String atividadeNome, Locale locale) {
		setAtividadeNome(atividadeNome, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setAtividadeNome(String atividadeNome, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(atividadeNome)) {
			setAtividadeNome(LocalizationUtil.updateLocalization(
					getAtividadeNome(), "AtividadeNome", atividadeNome,
					languageId, defaultLanguageId));
		}
		else {
			setAtividadeNome(LocalizationUtil.removeLocalization(
					getAtividadeNome(), "AtividadeNome", languageId));
		}
	}

	@Override
	public void setAtividadeNomeCurrentLanguageId(String languageId) {
		_atividadeNomeCurrentLanguageId = languageId;
	}

	@Override
	public void setAtividadeNomeMap(Map<Locale, String> atividadeNomeMap) {
		setAtividadeNomeMap(atividadeNomeMap, LocaleUtil.getDefault());
	}

	@Override
	public void setAtividadeNomeMap(Map<Locale, String> atividadeNomeMap,
		Locale defaultLocale) {
		if (atividadeNomeMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setAtividadeNome(LocalizationUtil.updateLocalization(
					atividadeNomeMap, getAtividadeNome(), "AtividadeNome",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
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

		if (_academiaHorarioRemoteModel != null) {
			try {
				Class<?> clazz = _academiaHorarioRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_academiaHorarioRemoteModel, versao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				AcademiaHorario.class.getName()));
	}

	public BaseModel<?> getAcademiaHorarioRemoteModel() {
		return _academiaHorarioRemoteModel;
	}

	public void setAcademiaHorarioRemoteModel(
		BaseModel<?> academiaHorarioRemoteModel) {
		_academiaHorarioRemoteModel = academiaHorarioRemoteModel;
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

		Class<?> remoteModelClass = _academiaHorarioRemoteModel.getClass();

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

		Object returnValue = method.invoke(_academiaHorarioRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AcademiaHorarioLocalServiceUtil.addAcademiaHorario(this);
		}
		else {
			AcademiaHorarioLocalServiceUtil.updateAcademiaHorario(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> atividadeNomeMap = getAtividadeNomeMap();

		for (Map.Entry<Locale, String> entry : atividadeNomeMap.entrySet()) {
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
		String xml = getAtividadeNome();

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

		String atividadeNome = getAtividadeNome(defaultLocale);

		if (Validator.isNull(atividadeNome)) {
			setAtividadeNome(getAtividadeNome(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setAtividadeNome(getAtividadeNome(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public AcademiaHorario toEscapedModel() {
		return (AcademiaHorario)ProxyUtil.newProxyInstance(AcademiaHorario.class.getClassLoader(),
			new Class[] { AcademiaHorario.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AcademiaHorarioClp clone = new AcademiaHorarioClp();

		clone.setUuid(getUuid());
		clone.setAcademiaHorarioId(getAcademiaHorarioId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDiaSemana(getDiaSemana());
		clone.setHoraInicial(getHoraInicial());
		clone.setHoraFinal(getHoraFinal());
		clone.setAtividadeId(getAtividadeId());
		clone.setAtividadeNome(getAtividadeNome());
		clone.setVersao(getVersao());

		return clone;
	}

	@Override
	public int compareTo(AcademiaHorario academiaHorario) {
		int value = 0;

		value = getAtividadeNome().compareTo(academiaHorario.getAtividadeNome());

		if (value != 0) {
			return value;
		}

		if (getDiaSemana() < academiaHorario.getDiaSemana()) {
			value = -1;
		}
		else if (getDiaSemana() > academiaHorario.getDiaSemana()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getHoraInicial().compareTo(academiaHorario.getHoraInicial());

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

		if (!(obj instanceof AcademiaHorarioClp)) {
			return false;
		}

		AcademiaHorarioClp academiaHorario = (AcademiaHorarioClp)obj;

		long primaryKey = academiaHorario.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", academiaHorarioId=");
		sb.append(getAcademiaHorarioId());
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
		sb.append(", diaSemana=");
		sb.append(getDiaSemana());
		sb.append(", horaInicial=");
		sb.append(getHoraInicial());
		sb.append(", HoraFinal=");
		sb.append(getHoraFinal());
		sb.append(", atividadeId=");
		sb.append(getAtividadeId());
		sb.append(", atividadeNome=");
		sb.append(getAtividadeNome());
		sb.append(", versao=");
		sb.append(getVersao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.academiahorario.model.AcademiaHorario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>academiaHorarioId</column-name><column-value><![CDATA[");
		sb.append(getAcademiaHorarioId());
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
			"<column><column-name>diaSemana</column-name><column-value><![CDATA[");
		sb.append(getDiaSemana());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>horaInicial</column-name><column-value><![CDATA[");
		sb.append(getHoraInicial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HoraFinal</column-name><column-value><![CDATA[");
		sb.append(getHoraFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atividadeId</column-name><column-value><![CDATA[");
		sb.append(getAtividadeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atividadeNome</column-name><column-value><![CDATA[");
		sb.append(getAtividadeNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _academiaHorarioId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private int _diaSemana;
	private String _horaInicial;
	private String _HoraFinal;
	private long _atividadeId;
	private String _atividadeNome;
	private String _atividadeNomeCurrentLanguageId;
	private double _versao;
	private BaseModel<?> _academiaHorarioRemoteModel;
}