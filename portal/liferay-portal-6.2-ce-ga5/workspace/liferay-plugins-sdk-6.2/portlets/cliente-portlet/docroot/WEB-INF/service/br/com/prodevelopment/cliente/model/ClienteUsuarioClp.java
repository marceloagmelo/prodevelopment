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

package br.com.prodevelopment.cliente.model;

import br.com.prodevelopment.cliente.service.ClienteUsuarioLocalServiceUtil;
import br.com.prodevelopment.cliente.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author marcelo
 */
public class ClienteUsuarioClp extends BaseModelImpl<ClienteUsuario>
	implements ClienteUsuario {
	public ClienteUsuarioClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ClienteUsuario.class;
	}

	@Override
	public String getModelClassName() {
		return ClienteUsuario.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _clienteUsuarioId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClienteUsuarioId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clienteUsuarioId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clienteUsuarioId", getClienteUsuarioId());
		attributes.put("userId", getUserId());
		attributes.put("clienteId", getClienteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clienteUsuarioId = (Long)attributes.get("clienteUsuarioId");

		if (clienteUsuarioId != null) {
			setClienteUsuarioId(clienteUsuarioId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long clienteId = (Long)attributes.get("clienteId");

		if (clienteId != null) {
			setClienteId(clienteId);
		}
	}

	@Override
	public long getClienteUsuarioId() {
		return _clienteUsuarioId;
	}

	@Override
	public void setClienteUsuarioId(long clienteUsuarioId) {
		_clienteUsuarioId = clienteUsuarioId;

		if (_clienteUsuarioRemoteModel != null) {
			try {
				Class<?> clazz = _clienteUsuarioRemoteModel.getClass();

				Method method = clazz.getMethod("setClienteUsuarioId",
						long.class);

				method.invoke(_clienteUsuarioRemoteModel, clienteUsuarioId);
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

		if (_clienteUsuarioRemoteModel != null) {
			try {
				Class<?> clazz = _clienteUsuarioRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_clienteUsuarioRemoteModel, userId);
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
	public long getClienteId() {
		return _clienteId;
	}

	@Override
	public void setClienteId(long clienteId) {
		_clienteId = clienteId;

		if (_clienteUsuarioRemoteModel != null) {
			try {
				Class<?> clazz = _clienteUsuarioRemoteModel.getClass();

				Method method = clazz.getMethod("setClienteId", long.class);

				method.invoke(_clienteUsuarioRemoteModel, clienteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getClienteUsuarioRemoteModel() {
		return _clienteUsuarioRemoteModel;
	}

	public void setClienteUsuarioRemoteModel(
		BaseModel<?> clienteUsuarioRemoteModel) {
		_clienteUsuarioRemoteModel = clienteUsuarioRemoteModel;
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

		Class<?> remoteModelClass = _clienteUsuarioRemoteModel.getClass();

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

		Object returnValue = method.invoke(_clienteUsuarioRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ClienteUsuarioLocalServiceUtil.addClienteUsuario(this);
		}
		else {
			ClienteUsuarioLocalServiceUtil.updateClienteUsuario(this);
		}
	}

	@Override
	public ClienteUsuario toEscapedModel() {
		return (ClienteUsuario)ProxyUtil.newProxyInstance(ClienteUsuario.class.getClassLoader(),
			new Class[] { ClienteUsuario.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ClienteUsuarioClp clone = new ClienteUsuarioClp();

		clone.setClienteUsuarioId(getClienteUsuarioId());
		clone.setUserId(getUserId());
		clone.setClienteId(getClienteId());

		return clone;
	}

	@Override
	public int compareTo(ClienteUsuario clienteUsuario) {
		int value = 0;

		if (getClienteUsuarioId() < clienteUsuario.getClienteUsuarioId()) {
			value = -1;
		}
		else if (getClienteUsuarioId() > clienteUsuario.getClienteUsuarioId()) {
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

		if (!(obj instanceof ClienteUsuarioClp)) {
			return false;
		}

		ClienteUsuarioClp clienteUsuario = (ClienteUsuarioClp)obj;

		long primaryKey = clienteUsuario.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{clienteUsuarioId=");
		sb.append(getClienteUsuarioId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", clienteId=");
		sb.append(getClienteId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.cliente.model.ClienteUsuario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>clienteUsuarioId</column-name><column-value><![CDATA[");
		sb.append(getClienteUsuarioId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clienteId</column-name><column-value><![CDATA[");
		sb.append(getClienteId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _clienteUsuarioId;
	private long _userId;
	private String _userUuid;
	private long _clienteId;
	private BaseModel<?> _clienteUsuarioRemoteModel;
}