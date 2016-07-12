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
import br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
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
public class EnderecoEmailClp extends BaseModelImpl<EnderecoEmail>
	implements EnderecoEmail {
	public EnderecoEmailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EnderecoEmail.class;
	}

	@Override
	public String getModelClassName() {
		return EnderecoEmail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _enderecoEmailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEnderecoEmailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _enderecoEmailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("enderecoEmailId", getEnderecoEmailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("endereco", getEndereco());
		attributes.put("tipo", getTipo());
		attributes.put("principal", getPrincipal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long enderecoEmailId = (Long)attributes.get("enderecoEmailId");

		if (enderecoEmailId != null) {
			setEnderecoEmailId(enderecoEmailId);
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

		String endereco = (String)attributes.get("endereco");

		if (endereco != null) {
			setEndereco(endereco);
		}

		Integer tipo = (Integer)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		Boolean principal = (Boolean)attributes.get("principal");

		if (principal != null) {
			setPrincipal(principal);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_enderecoEmailRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEnderecoEmailId() {
		return _enderecoEmailId;
	}

	@Override
	public void setEnderecoEmailId(long enderecoEmailId) {
		_enderecoEmailId = enderecoEmailId;

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setEnderecoEmailId", long.class);

				method.invoke(_enderecoEmailRemoteModel, enderecoEmailId);
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

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_enderecoEmailRemoteModel, companyId);
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

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_enderecoEmailRemoteModel, groupId);
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

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_enderecoEmailRemoteModel, createUserId);
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

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_enderecoEmailRemoteModel, modifiedUserId);
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

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_enderecoEmailRemoteModel, createDate);
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

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_enderecoEmailRemoteModel, modifiedDate);
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

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_enderecoEmailRemoteModel, classNameId);
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

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_enderecoEmailRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndereco() {
		return _endereco;
	}

	@Override
	public void setEndereco(String endereco) {
		_endereco = endereco;

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setEndereco", String.class);

				method.invoke(_enderecoEmailRemoteModel, endereco);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTipo() {
		return _tipo;
	}

	@Override
	public void setTipo(int tipo) {
		_tipo = tipo;

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo", int.class);

				method.invoke(_enderecoEmailRemoteModel, tipo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPrincipal() {
		return _principal;
	}

	@Override
	public boolean isPrincipal() {
		return _principal;
	}

	@Override
	public void setPrincipal(boolean principal) {
		_principal = principal;

		if (_enderecoEmailRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipal", boolean.class);

				method.invoke(_enderecoEmailRemoteModel, principal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				EnderecoEmail.class.getName()), getClassNameId());
	}

	public BaseModel<?> getEnderecoEmailRemoteModel() {
		return _enderecoEmailRemoteModel;
	}

	public void setEnderecoEmailRemoteModel(
		BaseModel<?> enderecoEmailRemoteModel) {
		_enderecoEmailRemoteModel = enderecoEmailRemoteModel;
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

		Class<?> remoteModelClass = _enderecoEmailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_enderecoEmailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EnderecoEmailLocalServiceUtil.addEnderecoEmail(this);
		}
		else {
			EnderecoEmailLocalServiceUtil.updateEnderecoEmail(this);
		}
	}

	@Override
	public EnderecoEmail toEscapedModel() {
		return (EnderecoEmail)ProxyUtil.newProxyInstance(EnderecoEmail.class.getClassLoader(),
			new Class[] { EnderecoEmail.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EnderecoEmailClp clone = new EnderecoEmailClp();

		clone.setUuid(getUuid());
		clone.setEnderecoEmailId(getEnderecoEmailId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setEndereco(getEndereco());
		clone.setTipo(getTipo());
		clone.setPrincipal(getPrincipal());

		return clone;
	}

	@Override
	public int compareTo(EnderecoEmail enderecoEmail) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				enderecoEmail.getCreateDate());

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

		if (!(obj instanceof EnderecoEmailClp)) {
			return false;
		}

		EnderecoEmailClp enderecoEmail = (EnderecoEmailClp)obj;

		long primaryKey = enderecoEmail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", enderecoEmailId=");
		sb.append(getEnderecoEmailId());
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
		sb.append(", endereco=");
		sb.append(getEndereco());
		sb.append(", tipo=");
		sb.append(getTipo());
		sb.append(", principal=");
		sb.append(getPrincipal());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.contato.model.EnderecoEmail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enderecoEmailId</column-name><column-value><![CDATA[");
		sb.append(getEnderecoEmailId());
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
			"<column><column-name>endereco</column-name><column-value><![CDATA[");
		sb.append(getEndereco());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo</column-name><column-value><![CDATA[");
		sb.append(getTipo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principal</column-name><column-value><![CDATA[");
		sb.append(getPrincipal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _enderecoEmailId;
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
	private String _endereco;
	private int _tipo;
	private boolean _principal;
	private BaseModel<?> _enderecoEmailRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.contato.service.ClpSerializer.class;
}