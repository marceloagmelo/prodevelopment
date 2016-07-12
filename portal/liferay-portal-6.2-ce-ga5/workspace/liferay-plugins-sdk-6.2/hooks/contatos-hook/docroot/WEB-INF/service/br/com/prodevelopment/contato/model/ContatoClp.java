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

package br.com.prodevelopment.contato.model;

import br.com.prodevelopment.contato.service.ClpSerializer;
import br.com.prodevelopment.contato.service.ContatoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
import java.util.Map;

/**
 * @author Marcelo Melo
 */
public class ContatoClp extends BaseModelImpl<Contato> implements Contato {
	public ContatoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Contato.class;
	}

	@Override
	public String getModelClassName() {
		return Contato.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contatoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContatoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contatoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contatoId", getContatoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("accountId", getAccountId());
		attributes.put("endEmail", getEndEmail());
		attributes.put("nome", getNome());
		attributes.put("sexo", getSexo());
		attributes.put("dataNascimento", getDataNascimento());
		attributes.put("cargoId", getCargoId());
		attributes.put("skype", getSkype());
		attributes.put("facebook", getFacebook());
		attributes.put("twitter", getTwitter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contatoId = (Long)attributes.get("contatoId");

		if (contatoId != null) {
			setContatoId(contatoId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		String endEmail = (String)attributes.get("endEmail");

		if (endEmail != null) {
			setEndEmail(endEmail);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		Date dataNascimento = (Date)attributes.get("dataNascimento");

		if (dataNascimento != null) {
			setDataNascimento(dataNascimento);
		}

		Long cargoId = (Long)attributes.get("cargoId");

		if (cargoId != null) {
			setCargoId(cargoId);
		}

		String skype = (String)attributes.get("skype");

		if (skype != null) {
			setSkype(skype);
		}

		String facebook = (String)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		String twitter = (String)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}
	}

	@Override
	public long getContatoId() {
		return _contatoId;
	}

	@Override
	public void setContatoId(long contatoId) {
		_contatoId = contatoId;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setContatoId", long.class);

				method.invoke(_contatoRemoteModel, contatoId);
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

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contatoRemoteModel, companyId);
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

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contatoRemoteModel, groupId);
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

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_contatoRemoteModel, createUserId);
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

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_contatoRemoteModel, modifiedUserId);
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

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_contatoRemoteModel, createDate);
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

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_contatoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_contatoRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_contatoRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_accountId = accountId;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountId", long.class);

				method.invoke(_contatoRemoteModel, accountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndEmail() {
		return _endEmail;
	}

	@Override
	public void setEndEmail(String endEmail) {
		_endEmail = endEmail;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setEndEmail", String.class);

				method.invoke(_contatoRemoteModel, endEmail);
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
	public void setNome(String nome) {
		_nome = nome;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_contatoRemoteModel, nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSexo() {
		return _sexo;
	}

	@Override
	public void setSexo(String sexo) {
		_sexo = sexo;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setSexo", String.class);

				method.invoke(_contatoRemoteModel, sexo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataNascimento() {
		return _dataNascimento;
	}

	@Override
	public void setDataNascimento(Date dataNascimento) {
		_dataNascimento = dataNascimento;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setDataNascimento", Date.class);

				method.invoke(_contatoRemoteModel, dataNascimento);
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

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setCargoId", long.class);

				method.invoke(_contatoRemoteModel, cargoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSkype() {
		return _skype;
	}

	@Override
	public void setSkype(String skype) {
		_skype = skype;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setSkype", String.class);

				method.invoke(_contatoRemoteModel, skype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacebook() {
		return _facebook;
	}

	@Override
	public void setFacebook(String facebook) {
		_facebook = facebook;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setFacebook", String.class);

				method.invoke(_contatoRemoteModel, facebook);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTwitter() {
		return _twitter;
	}

	@Override
	public void setTwitter(String twitter) {
		_twitter = twitter;

		if (_contatoRemoteModel != null) {
			try {
				Class<?> clazz = _contatoRemoteModel.getClass();

				Method method = clazz.getMethod("setTwitter", String.class);

				method.invoke(_contatoRemoteModel, twitter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContatoRemoteModel() {
		return _contatoRemoteModel;
	}

	public void setContatoRemoteModel(BaseModel<?> contatoRemoteModel) {
		_contatoRemoteModel = contatoRemoteModel;
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

		Class<?> remoteModelClass = _contatoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contatoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContatoLocalServiceUtil.addContato(this);
		}
		else {
			ContatoLocalServiceUtil.updateContato(this);
		}
	}

	@Override
	public Contato toEscapedModel() {
		return (Contato)ProxyUtil.newProxyInstance(Contato.class.getClassLoader(),
			new Class[] { Contato.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContatoClp clone = new ContatoClp();

		clone.setContatoId(getContatoId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setAccountId(getAccountId());
		clone.setEndEmail(getEndEmail());
		clone.setNome(getNome());
		clone.setSexo(getSexo());
		clone.setDataNascimento(getDataNascimento());
		clone.setCargoId(getCargoId());
		clone.setSkype(getSkype());
		clone.setFacebook(getFacebook());
		clone.setTwitter(getTwitter());

		return clone;
	}

	@Override
	public int compareTo(Contato contato) {
		int value = 0;

		value = getNome().compareTo(contato.getNome());

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

		if (!(obj instanceof ContatoClp)) {
			return false;
		}

		ContatoClp contato = (ContatoClp)obj;

		long primaryKey = contato.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{contatoId=");
		sb.append(getContatoId());
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
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", endEmail=");
		sb.append(getEndEmail());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", sexo=");
		sb.append(getSexo());
		sb.append(", dataNascimento=");
		sb.append(getDataNascimento());
		sb.append(", cargoId=");
		sb.append(getCargoId());
		sb.append(", skype=");
		sb.append(getSkype());
		sb.append(", facebook=");
		sb.append(getFacebook());
		sb.append(", twitter=");
		sb.append(getTwitter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.contato.model.Contato");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contatoId</column-name><column-value><![CDATA[");
		sb.append(getContatoId());
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
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endEmail</column-name><column-value><![CDATA[");
		sb.append(getEndEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sexo</column-name><column-value><![CDATA[");
		sb.append(getSexo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataNascimento</column-name><column-value><![CDATA[");
		sb.append(getDataNascimento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargoId</column-name><column-value><![CDATA[");
		sb.append(getCargoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skype</column-name><column-value><![CDATA[");
		sb.append(getSkype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebook</column-name><column-value><![CDATA[");
		sb.append(getFacebook());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitter</column-name><column-value><![CDATA[");
		sb.append(getTwitter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contatoId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private long _accountId;
	private String _endEmail;
	private String _nome;
	private String _sexo;
	private Date _dataNascimento;
	private long _cargoId;
	private String _skype;
	private String _facebook;
	private String _twitter;
	private BaseModel<?> _contatoRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.contato.service.ClpSerializer.class;
}