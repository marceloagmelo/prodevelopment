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

import br.com.prodevelopment.cliente.service.ClienteLimCreditoLocalServiceUtil;
import br.com.prodevelopment.cliente.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author marcelo
 */
public class ClienteLimCreditoClp extends BaseModelImpl<ClienteLimCredito>
	implements ClienteLimCredito {
	public ClienteLimCreditoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ClienteLimCredito.class;
	}

	@Override
	public String getModelClassName() {
		return ClienteLimCredito.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _clienteLimCreditoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClienteLimCreditoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clienteLimCreditoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clienteLimCreditoId", getClienteLimCreditoId());
		attributes.put("valorLimiteMaximoCredito", getValorLimiteMaximoCredito());
		attributes.put("dataLimiteMaximoCredito", getDataLimiteMaximoCredito());
		attributes.put("valorLimiteMaximoCheque", getValorLimiteMaximoCheque());
		attributes.put("qtdeLimiteMaximoCheque", getQtdeLimiteMaximoCheque());
		attributes.put("clienteId", getClienteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clienteLimCreditoId = (Long)attributes.get("clienteLimCreditoId");

		if (clienteLimCreditoId != null) {
			setClienteLimCreditoId(clienteLimCreditoId);
		}

		Double valorLimiteMaximoCredito = (Double)attributes.get(
				"valorLimiteMaximoCredito");

		if (valorLimiteMaximoCredito != null) {
			setValorLimiteMaximoCredito(valorLimiteMaximoCredito);
		}

		Date dataLimiteMaximoCredito = (Date)attributes.get(
				"dataLimiteMaximoCredito");

		if (dataLimiteMaximoCredito != null) {
			setDataLimiteMaximoCredito(dataLimiteMaximoCredito);
		}

		Double valorLimiteMaximoCheque = (Double)attributes.get(
				"valorLimiteMaximoCheque");

		if (valorLimiteMaximoCheque != null) {
			setValorLimiteMaximoCheque(valorLimiteMaximoCheque);
		}

		Integer qtdeLimiteMaximoCheque = (Integer)attributes.get(
				"qtdeLimiteMaximoCheque");

		if (qtdeLimiteMaximoCheque != null) {
			setQtdeLimiteMaximoCheque(qtdeLimiteMaximoCheque);
		}

		Long clienteId = (Long)attributes.get("clienteId");

		if (clienteId != null) {
			setClienteId(clienteId);
		}
	}

	@Override
	public long getClienteLimCreditoId() {
		return _clienteLimCreditoId;
	}

	@Override
	public void setClienteLimCreditoId(long clienteLimCreditoId) {
		_clienteLimCreditoId = clienteLimCreditoId;

		if (_clienteLimCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _clienteLimCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setClienteLimCreditoId",
						long.class);

				method.invoke(_clienteLimCreditoRemoteModel, clienteLimCreditoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getValorLimiteMaximoCredito() {
		return _valorLimiteMaximoCredito;
	}

	@Override
	public void setValorLimiteMaximoCredito(double valorLimiteMaximoCredito) {
		_valorLimiteMaximoCredito = valorLimiteMaximoCredito;

		if (_clienteLimCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _clienteLimCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setValorLimiteMaximoCredito",
						double.class);

				method.invoke(_clienteLimCreditoRemoteModel,
					valorLimiteMaximoCredito);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataLimiteMaximoCredito() {
		return _dataLimiteMaximoCredito;
	}

	@Override
	public void setDataLimiteMaximoCredito(Date dataLimiteMaximoCredito) {
		_dataLimiteMaximoCredito = dataLimiteMaximoCredito;

		if (_clienteLimCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _clienteLimCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setDataLimiteMaximoCredito",
						Date.class);

				method.invoke(_clienteLimCreditoRemoteModel,
					dataLimiteMaximoCredito);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getValorLimiteMaximoCheque() {
		return _valorLimiteMaximoCheque;
	}

	@Override
	public void setValorLimiteMaximoCheque(double valorLimiteMaximoCheque) {
		_valorLimiteMaximoCheque = valorLimiteMaximoCheque;

		if (_clienteLimCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _clienteLimCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setValorLimiteMaximoCheque",
						double.class);

				method.invoke(_clienteLimCreditoRemoteModel,
					valorLimiteMaximoCheque);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQtdeLimiteMaximoCheque() {
		return _qtdeLimiteMaximoCheque;
	}

	@Override
	public void setQtdeLimiteMaximoCheque(int qtdeLimiteMaximoCheque) {
		_qtdeLimiteMaximoCheque = qtdeLimiteMaximoCheque;

		if (_clienteLimCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _clienteLimCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setQtdeLimiteMaximoCheque",
						int.class);

				method.invoke(_clienteLimCreditoRemoteModel,
					qtdeLimiteMaximoCheque);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClienteId() {
		return _clienteId;
	}

	@Override
	public void setClienteId(long clienteId) {
		_clienteId = clienteId;

		if (_clienteLimCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _clienteLimCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setClienteId", long.class);

				method.invoke(_clienteLimCreditoRemoteModel, clienteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getClienteLimCreditoRemoteModel() {
		return _clienteLimCreditoRemoteModel;
	}

	public void setClienteLimCreditoRemoteModel(
		BaseModel<?> clienteLimCreditoRemoteModel) {
		_clienteLimCreditoRemoteModel = clienteLimCreditoRemoteModel;
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

		Class<?> remoteModelClass = _clienteLimCreditoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_clienteLimCreditoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ClienteLimCreditoLocalServiceUtil.addClienteLimCredito(this);
		}
		else {
			ClienteLimCreditoLocalServiceUtil.updateClienteLimCredito(this);
		}
	}

	@Override
	public ClienteLimCredito toEscapedModel() {
		return (ClienteLimCredito)ProxyUtil.newProxyInstance(ClienteLimCredito.class.getClassLoader(),
			new Class[] { ClienteLimCredito.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ClienteLimCreditoClp clone = new ClienteLimCreditoClp();

		clone.setClienteLimCreditoId(getClienteLimCreditoId());
		clone.setValorLimiteMaximoCredito(getValorLimiteMaximoCredito());
		clone.setDataLimiteMaximoCredito(getDataLimiteMaximoCredito());
		clone.setValorLimiteMaximoCheque(getValorLimiteMaximoCheque());
		clone.setQtdeLimiteMaximoCheque(getQtdeLimiteMaximoCheque());
		clone.setClienteId(getClienteId());

		return clone;
	}

	@Override
	public int compareTo(ClienteLimCredito clienteLimCredito) {
		int value = 0;

		if (getClienteLimCreditoId() < clienteLimCredito.getClienteLimCreditoId()) {
			value = -1;
		}
		else if (getClienteLimCreditoId() > clienteLimCredito.getClienteLimCreditoId()) {
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

		if (!(obj instanceof ClienteLimCreditoClp)) {
			return false;
		}

		ClienteLimCreditoClp clienteLimCredito = (ClienteLimCreditoClp)obj;

		long primaryKey = clienteLimCredito.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{clienteLimCreditoId=");
		sb.append(getClienteLimCreditoId());
		sb.append(", valorLimiteMaximoCredito=");
		sb.append(getValorLimiteMaximoCredito());
		sb.append(", dataLimiteMaximoCredito=");
		sb.append(getDataLimiteMaximoCredito());
		sb.append(", valorLimiteMaximoCheque=");
		sb.append(getValorLimiteMaximoCheque());
		sb.append(", qtdeLimiteMaximoCheque=");
		sb.append(getQtdeLimiteMaximoCheque());
		sb.append(", clienteId=");
		sb.append(getClienteId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.cliente.model.ClienteLimCredito");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>clienteLimCreditoId</column-name><column-value><![CDATA[");
		sb.append(getClienteLimCreditoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorLimiteMaximoCredito</column-name><column-value><![CDATA[");
		sb.append(getValorLimiteMaximoCredito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataLimiteMaximoCredito</column-name><column-value><![CDATA[");
		sb.append(getDataLimiteMaximoCredito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorLimiteMaximoCheque</column-name><column-value><![CDATA[");
		sb.append(getValorLimiteMaximoCheque());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qtdeLimiteMaximoCheque</column-name><column-value><![CDATA[");
		sb.append(getQtdeLimiteMaximoCheque());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clienteId</column-name><column-value><![CDATA[");
		sb.append(getClienteId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _clienteLimCreditoId;
	private double _valorLimiteMaximoCredito;
	private Date _dataLimiteMaximoCredito;
	private double _valorLimiteMaximoCheque;
	private int _qtdeLimiteMaximoCheque;
	private long _clienteId;
	private BaseModel<?> _clienteLimCreditoRemoteModel;
}