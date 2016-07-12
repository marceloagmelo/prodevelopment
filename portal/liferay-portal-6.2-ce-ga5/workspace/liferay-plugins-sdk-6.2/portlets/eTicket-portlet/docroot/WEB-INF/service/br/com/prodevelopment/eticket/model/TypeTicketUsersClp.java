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

package br.com.prodevelopment.eticket.model;

import br.com.prodevelopment.eticket.service.ClpSerializer;
import br.com.prodevelopment.eticket.service.TypeTicketUsersLocalServiceUtil;

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
public class TypeTicketUsersClp extends BaseModelImpl<TypeTicketUsers>
	implements TypeTicketUsers {
	public TypeTicketUsersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TypeTicketUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TypeTicketUsers.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _typeTicketUsersId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTypeTicketUsersId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _typeTicketUsersId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeTicketUsersId", getTypeTicketUsersId());
		attributes.put("userIdCreate", getUserIdCreate());
		attributes.put("userIdModified", getUserIdModified());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typeTicketId", getTypeTicketId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeTicketUsersId = (Long)attributes.get("typeTicketUsersId");

		if (typeTicketUsersId != null) {
			setTypeTicketUsersId(typeTicketUsersId);
		}

		Long userIdCreate = (Long)attributes.get("userIdCreate");

		if (userIdCreate != null) {
			setUserIdCreate(userIdCreate);
		}

		Long userIdModified = (Long)attributes.get("userIdModified");

		if (userIdModified != null) {
			setUserIdModified(userIdModified);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long typeTicketId = (Long)attributes.get("typeTicketId");

		if (typeTicketId != null) {
			setTypeTicketId(typeTicketId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public long getTypeTicketUsersId() {
		return _typeTicketUsersId;
	}

	@Override
	public void setTypeTicketUsersId(long typeTicketUsersId) {
		_typeTicketUsersId = typeTicketUsersId;

		if (_typeTicketUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTicketUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeTicketUsersId",
						long.class);

				method.invoke(_typeTicketUsersRemoteModel, typeTicketUsersId);
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

		if (_typeTicketUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTicketUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdCreate", long.class);

				method.invoke(_typeTicketUsersRemoteModel, userIdCreate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserIdModified() {
		return _userIdModified;
	}

	@Override
	public void setUserIdModified(long userIdModified) {
		_userIdModified = userIdModified;

		if (_typeTicketUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTicketUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdModified", long.class);

				method.invoke(_typeTicketUsersRemoteModel, userIdModified);
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

		if (_typeTicketUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTicketUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_typeTicketUsersRemoteModel, createDate);
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

		if (_typeTicketUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTicketUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_typeTicketUsersRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTypeTicketId() {
		return _typeTicketId;
	}

	@Override
	public void setTypeTicketId(long typeTicketId) {
		_typeTicketId = typeTicketId;

		if (_typeTicketUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTicketUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeTicketId", long.class);

				method.invoke(_typeTicketUsersRemoteModel, typeTicketId);
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

		if (_typeTicketUsersRemoteModel != null) {
			try {
				Class<?> clazz = _typeTicketUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_typeTicketUsersRemoteModel, userId);
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

	public BaseModel<?> getTypeTicketUsersRemoteModel() {
		return _typeTicketUsersRemoteModel;
	}

	public void setTypeTicketUsersRemoteModel(
		BaseModel<?> typeTicketUsersRemoteModel) {
		_typeTicketUsersRemoteModel = typeTicketUsersRemoteModel;
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

		Class<?> remoteModelClass = _typeTicketUsersRemoteModel.getClass();

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

		Object returnValue = method.invoke(_typeTicketUsersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TypeTicketUsersLocalServiceUtil.addTypeTicketUsers(this);
		}
		else {
			TypeTicketUsersLocalServiceUtil.updateTypeTicketUsers(this);
		}
	}

	@Override
	public TypeTicketUsers toEscapedModel() {
		return (TypeTicketUsers)ProxyUtil.newProxyInstance(TypeTicketUsers.class.getClassLoader(),
			new Class[] { TypeTicketUsers.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TypeTicketUsersClp clone = new TypeTicketUsersClp();

		clone.setTypeTicketUsersId(getTypeTicketUsersId());
		clone.setUserIdCreate(getUserIdCreate());
		clone.setUserIdModified(getUserIdModified());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTypeTicketId(getTypeTicketId());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(TypeTicketUsers typeTicketUsers) {
		int value = 0;

		if (getTypeTicketUsersId() < typeTicketUsers.getTypeTicketUsersId()) {
			value = -1;
		}
		else if (getTypeTicketUsersId() > typeTicketUsers.getTypeTicketUsersId()) {
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

		if (!(obj instanceof TypeTicketUsersClp)) {
			return false;
		}

		TypeTicketUsersClp typeTicketUsers = (TypeTicketUsersClp)obj;

		long primaryKey = typeTicketUsers.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{typeTicketUsersId=");
		sb.append(getTypeTicketUsersId());
		sb.append(", userIdCreate=");
		sb.append(getUserIdCreate());
		sb.append(", userIdModified=");
		sb.append(getUserIdModified());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", typeTicketId=");
		sb.append(getTypeTicketId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.eticket.model.TypeTicketUsers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>typeTicketUsersId</column-name><column-value><![CDATA[");
		sb.append(getTypeTicketUsersId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdCreate</column-name><column-value><![CDATA[");
		sb.append(getUserIdCreate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdModified</column-name><column-value><![CDATA[");
		sb.append(getUserIdModified());
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
			"<column><column-name>typeTicketId</column-name><column-value><![CDATA[");
		sb.append(getTypeTicketId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _typeTicketUsersId;
	private long _userIdCreate;
	private long _userIdModified;
	private Date _createDate;
	private Date _modifiedDate;
	private long _typeTicketId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _typeTicketUsersRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.eticket.service.ClpSerializer.class;
}