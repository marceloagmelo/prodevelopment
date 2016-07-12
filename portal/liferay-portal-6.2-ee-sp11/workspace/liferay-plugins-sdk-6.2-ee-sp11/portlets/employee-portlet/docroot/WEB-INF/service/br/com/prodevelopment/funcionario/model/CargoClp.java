/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.prodevelopment.funcionario.model;

import br.com.prodevelopment.funcionario.service.CargoLocalServiceUtil;
import br.com.prodevelopment.funcionario.service.ClpSerializer;

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
 * @author Marcelo Melo
 */
public class CargoClp extends BaseModelImpl<Cargo> implements Cargo {
	public CargoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Cargo.class;
	}

	@Override
	public String getModelClassName() {
		return Cargo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _cargoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCargoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cargoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("cargoId", getCargoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("versao", getVersao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long cargoId = (Long)attributes.get("cargoId");

		if (cargoId != null) {
			setCargoId(cargoId);
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

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_cargoRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCargoId() {
		return _cargoId;
	}

	@Override
	public void setCargoId(long cargoId) {
		_cargoId = cargoId;

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setCargoId", long.class);

				method.invoke(_cargoRemoteModel, cargoId);
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

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_cargoRemoteModel, companyId);
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

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_cargoRemoteModel, groupId);
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

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_cargoRemoteModel, createUserId);
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

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_cargoRemoteModel, modifiedUserId);
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

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_cargoRemoteModel, createDate);
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

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_cargoRemoteModel, modifiedDate);
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

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_cargoRemoteModel, nome);
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
	public double getVersao() {
		return _versao;
	}

	@Override
	public void setVersao(double versao) {
		_versao = versao;

		if (_cargoRemoteModel != null) {
			try {
				Class<?> clazz = _cargoRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_cargoRemoteModel, versao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Cargo.class.getName()));
	}

	public BaseModel<?> getCargoRemoteModel() {
		return _cargoRemoteModel;
	}

	public void setCargoRemoteModel(BaseModel<?> cargoRemoteModel) {
		_cargoRemoteModel = cargoRemoteModel;
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

		Class<?> remoteModelClass = _cargoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cargoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CargoLocalServiceUtil.addCargo(this);
		}
		else {
			CargoLocalServiceUtil.updateCargo(this);
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

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getNome();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
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
	}

	@Override
	public Cargo toEscapedModel() {
		return (Cargo)ProxyUtil.newProxyInstance(Cargo.class.getClassLoader(),
			new Class[] { Cargo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CargoClp clone = new CargoClp();

		clone.setUuid(getUuid());
		clone.setCargoId(getCargoId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNome(getNome());
		clone.setVersao(getVersao());

		return clone;
	}

	@Override
	public int compareTo(Cargo cargo) {
		int value = 0;

		value = getNome().compareTo(cargo.getNome());

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

		if (!(obj instanceof CargoClp)) {
			return false;
		}

		CargoClp cargo = (CargoClp)obj;

		long primaryKey = cargo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", cargoId=");
		sb.append(getCargoId());
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
		sb.append(", versao=");
		sb.append(getVersao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.funcionario.model.Cargo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargoId</column-name><column-value><![CDATA[");
		sb.append(getCargoId());
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
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _cargoId;
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
	private double _versao;
	private BaseModel<?> _cargoRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.funcionario.service.ClpSerializer.class;
}