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

package br.com.prodevelopment.municipio.model;

import br.com.prodevelopment.municipio.service.ClpSerializer;
import br.com.prodevelopment.municipio.service.MunicipioLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcelo Melo
 */
public class MunicipioClp extends BaseModelImpl<Municipio> implements Municipio {
	public MunicipioClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Municipio.class;
	}

	@Override
	public String getModelClassName() {
		return Municipio.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _codigo;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCodigo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codigo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codigo", getCodigo());
		attributes.put("uf", getUf());
		attributes.put("cidade", getCidade());
		attributes.put("bairro", getBairro());
		attributes.put("logradouro", getLogradouro());
		attributes.put("cep", getCep());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long codigo = (Long)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String uf = (String)attributes.get("uf");

		if (uf != null) {
			setUf(uf);
		}

		String cidade = (String)attributes.get("cidade");

		if (cidade != null) {
			setCidade(cidade);
		}

		String bairro = (String)attributes.get("bairro");

		if (bairro != null) {
			setBairro(bairro);
		}

		String logradouro = (String)attributes.get("logradouro");

		if (logradouro != null) {
			setLogradouro(logradouro);
		}

		String cep = (String)attributes.get("cep");

		if (cep != null) {
			setCep(cep);
		}
	}

	@Override
	public long getCodigo() {
		return _codigo;
	}

	@Override
	public void setCodigo(long codigo) {
		_codigo = codigo;

		if (_municipioRemoteModel != null) {
			try {
				Class<?> clazz = _municipioRemoteModel.getClass();

				Method method = clazz.getMethod("setCodigo", long.class);

				method.invoke(_municipioRemoteModel, codigo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUf() {
		return _uf;
	}

	@Override
	public void setUf(String uf) {
		_uf = uf;

		if (_municipioRemoteModel != null) {
			try {
				Class<?> clazz = _municipioRemoteModel.getClass();

				Method method = clazz.getMethod("setUf", String.class);

				method.invoke(_municipioRemoteModel, uf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCidade() {
		return _cidade;
	}

	@Override
	public void setCidade(String cidade) {
		_cidade = cidade;

		if (_municipioRemoteModel != null) {
			try {
				Class<?> clazz = _municipioRemoteModel.getClass();

				Method method = clazz.getMethod("setCidade", String.class);

				method.invoke(_municipioRemoteModel, cidade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBairro() {
		return _bairro;
	}

	@Override
	public void setBairro(String bairro) {
		_bairro = bairro;

		if (_municipioRemoteModel != null) {
			try {
				Class<?> clazz = _municipioRemoteModel.getClass();

				Method method = clazz.getMethod("setBairro", String.class);

				method.invoke(_municipioRemoteModel, bairro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLogradouro() {
		return _logradouro;
	}

	@Override
	public void setLogradouro(String logradouro) {
		_logradouro = logradouro;

		if (_municipioRemoteModel != null) {
			try {
				Class<?> clazz = _municipioRemoteModel.getClass();

				Method method = clazz.getMethod("setLogradouro", String.class);

				method.invoke(_municipioRemoteModel, logradouro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCep() {
		return _cep;
	}

	@Override
	public void setCep(String cep) {
		_cep = cep;

		if (_municipioRemoteModel != null) {
			try {
				Class<?> clazz = _municipioRemoteModel.getClass();

				Method method = clazz.getMethod("setCep", String.class);

				method.invoke(_municipioRemoteModel, cep);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMunicipioRemoteModel() {
		return _municipioRemoteModel;
	}

	public void setMunicipioRemoteModel(BaseModel<?> municipioRemoteModel) {
		_municipioRemoteModel = municipioRemoteModel;
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

		Class<?> remoteModelClass = _municipioRemoteModel.getClass();

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

		Object returnValue = method.invoke(_municipioRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MunicipioLocalServiceUtil.addMunicipio(this);
		}
		else {
			MunicipioLocalServiceUtil.updateMunicipio(this);
		}
	}

	@Override
	public Municipio toEscapedModel() {
		return (Municipio)ProxyUtil.newProxyInstance(Municipio.class.getClassLoader(),
			new Class[] { Municipio.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MunicipioClp clone = new MunicipioClp();

		clone.setCodigo(getCodigo());
		clone.setUf(getUf());
		clone.setCidade(getCidade());
		clone.setBairro(getBairro());
		clone.setLogradouro(getLogradouro());
		clone.setCep(getCep());

		return clone;
	}

	@Override
	public int compareTo(Municipio municipio) {
		int value = 0;

		value = getCidade().compareTo(municipio.getCidade());

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

		if (!(obj instanceof MunicipioClp)) {
			return false;
		}

		MunicipioClp municipio = (MunicipioClp)obj;

		long primaryKey = municipio.getPrimaryKey();

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

		sb.append("{codigo=");
		sb.append(getCodigo());
		sb.append(", uf=");
		sb.append(getUf());
		sb.append(", cidade=");
		sb.append(getCidade());
		sb.append(", bairro=");
		sb.append(getBairro());
		sb.append(", logradouro=");
		sb.append(getLogradouro());
		sb.append(", cep=");
		sb.append(getCep());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.municipio.model.Municipio");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codigo</column-name><column-value><![CDATA[");
		sb.append(getCodigo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uf</column-name><column-value><![CDATA[");
		sb.append(getUf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cidade</column-name><column-value><![CDATA[");
		sb.append(getCidade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bairro</column-name><column-value><![CDATA[");
		sb.append(getBairro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logradouro</column-name><column-value><![CDATA[");
		sb.append(getLogradouro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cep</column-name><column-value><![CDATA[");
		sb.append(getCep());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _codigo;
	private String _uf;
	private String _cidade;
	private String _bairro;
	private String _logradouro;
	private String _cep;
	private BaseModel<?> _municipioRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.municipio.service.ClpSerializer.class;
}