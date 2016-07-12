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

package br.com.prodevelopment.etask.model;

import br.com.prodevelopment.etask.service.ClpSerializer;
import br.com.prodevelopment.etask.service.TypeTaskUsersLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
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
public class TypeTaskUsersClp extends BaseModelImpl<TypeTaskUsers>
	implements TypeTaskUsers {
	public TypeTaskUsersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TypeTaskUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TypeTaskUsers.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _typeTaskUsersId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTypeTaskUsersId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _typeTaskUsersId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeTaskUsersId", getTypeTaskUsersId());
		attributes.put("userIdCreate", getUserIdCreate());
		attributes.put("createDate", getCreateDate());
		attributes.put("typeTaskId", getTypeTaskId());
		attributes.put("userId", getUserId());
		attributes.put("typeUser", getTypeUser());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeTaskUsersId = (Long)attributes.get("typeTaskUsersId");

		if (typeTaskUsersId != null) {
			setTypeTaskUsersId(typeTaskUsersId);
		}

		Long userIdCreate = (Long)attributes.get("userIdCreate");

		if (userIdCreate != null) {
			setUserIdCreate(userIdCreate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long typeTaskId = (Long)attributes.get("typeTaskId");

		if (typeTaskId != null) {
			setTypeTaskId(typeTaskId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String typeUser = (String)attributes.get("typeUser");

		if (typeUser != null) {
			setTypeUser(typeUser);
		}
	}

	@Override
	public long getTypeTaskUsersId() {
		return _typeTaskUsersId;
	}

	@Override
	public void setTypeTaskUsersId(long typeTaskUsersId) {
		_typeTaskUsersId = typeTaskUsersId;

		if (_typeTaskUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeTaskUsersId", long.class);

				method.invoke(_typeTaskUsersRemoteModel, typeTaskUsersId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserIdCreate() {
		return _userIdCreate;
	}

	@Override
	public void setUserIdCreate(long userIdCreate) {
		_userIdCreate = userIdCreate;

		if (_typeTaskUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdCreate", long.class);

				method.invoke(_typeTaskUsersRemoteModel, userIdCreate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_typeTaskUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_typeTaskUsersRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTypeTaskId() {
		return _typeTaskId;
	}

	@Override
	public void setTypeTaskId(long typeTaskId) {
		_typeTaskId = typeTaskId;

		if (_typeTaskUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeTaskId", long.class);

				method.invoke(_typeTaskUsersRemoteModel, typeTaskId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_typeTaskUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_typeTaskUsersRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getTypeUser() {
		return _typeUser;
	}

	@Override
	public void setTypeUser(String typeUser) {
		_typeUser = typeUser;

		if (_typeTaskUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTaskUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeUser", String.class);

				method.invoke(_typeTaskUsersRemoteModel, typeUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTypeTaskUsersRemoteModel() {
		return _typeTaskUsersRemoteModel;
	}

	public void setTypeTaskUsersRemoteModel(
		BaseModel<?> typeTaskUsersRemoteModel) {
		_typeTaskUsersRemoteModel = typeTaskUsersRemoteModel;
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

		Class<?> remoteModelClass = _typeTaskUsersRemoteModel.getClass();

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

		Object returnValue = method.invoke(_typeTaskUsersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TypeTaskUsersLocalServiceUtil.addTypeTaskUsers(this);
		}
		else {
			TypeTaskUsersLocalServiceUtil.updateTypeTaskUsers(this);
		}
	}

	@Override
	public TypeTaskUsers toEscapedModel() {
		return (TypeTaskUsers)ProxyUtil.newProxyInstance(TypeTaskUsers.class.getClassLoader(),
			new Class[] { TypeTaskUsers.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TypeTaskUsersClp clone = new TypeTaskUsersClp();

		clone.setTypeTaskUsersId(getTypeTaskUsersId());
		clone.setUserIdCreate(getUserIdCreate());
		clone.setCreateDate(getCreateDate());
		clone.setTypeTaskId(getTypeTaskId());
		clone.setUserId(getUserId());
		clone.setTypeUser(getTypeUser());

		return clone;
	}

	@Override
	public int compareTo(TypeTaskUsers typeTaskUsers) {
		int value = 0;

		if (getTypeTaskUsersId() < typeTaskUsers.getTypeTaskUsersId()) {
			value = -1;
		}
		else if (getTypeTaskUsersId() > typeTaskUsers.getTypeTaskUsersId()) {
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
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeTaskUsersClp)) {
			return false;
		}

		TypeTaskUsersClp typeTaskUsers = (TypeTaskUsersClp)obj;

		long primaryKey = typeTaskUsers.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{typeTaskUsersId=");
		sb.append(getTypeTaskUsersId());
		sb.append(", userIdCreate=");
		sb.append(getUserIdCreate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", typeTaskId=");
		sb.append(getTypeTaskId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", typeUser=");
		sb.append(getTypeUser());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.etask.model.TypeTaskUsers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>typeTaskUsersId</column-name><column-value><![CDATA[");
		sb.append(getTypeTaskUsersId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdCreate</column-name><column-value><![CDATA[");
		sb.append(getUserIdCreate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeTaskId</column-name><column-value><![CDATA[");
		sb.append(getTypeTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeUser</column-name><column-value><![CDATA[");
		sb.append(getTypeUser());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _typeTaskUsersId;
	private long _userIdCreate;
	private Date _createDate;
	private long _typeTaskId;
	private long _userId;
	private String _userUuid;
	private String _typeUser;
	private BaseModel<?> _typeTaskUsersRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.etask.service.ClpSerializer.class;
}