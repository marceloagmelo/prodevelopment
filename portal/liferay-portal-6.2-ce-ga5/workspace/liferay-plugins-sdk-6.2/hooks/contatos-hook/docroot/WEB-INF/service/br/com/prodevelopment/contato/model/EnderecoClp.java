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
import br.com.prodevelopment.contato.service.EnderecoLocalServiceUtil;

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
public class EnderecoClp extends BaseModelImpl<Endereco> implements Endereco {
	public EnderecoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Endereco.class;
	}

	@Override
	public String getModelClassName() {
		return Endereco.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _enderecoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEnderecoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _enderecoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("enderecoId", getEnderecoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("logradouro", getLogradouro());
		attributes.put("numero", getNumero());
		attributes.put("complemento", getComplemento());
		attributes.put("cep", getCep());
		attributes.put("bairro", getBairro());
		attributes.put("cidadeId", getCidadeId());
		attributes.put("uf", getUf());
		attributes.put("paisId", getPaisId());
		attributes.put("principal", getPrincipal());
		attributes.put("tipo", getTipo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long enderecoId = (Long)attributes.get("enderecoId");

		if (enderecoId != null) {
			setEnderecoId(enderecoId);
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

		String logradouro = (String)attributes.get("logradouro");

		if (logradouro != null) {
			setLogradouro(logradouro);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		String complemento = (String)attributes.get("complemento");

		if (complemento != null) {
			setComplemento(complemento);
		}

		String cep = (String)attributes.get("cep");

		if (cep != null) {
			setCep(cep);
		}

		String bairro = (String)attributes.get("bairro");

		if (bairro != null) {
			setBairro(bairro);
		}

		Long cidadeId = (Long)attributes.get("cidadeId");

		if (cidadeId != null) {
			setCidadeId(cidadeId);
		}

		String uf = (String)attributes.get("uf");

		if (uf != null) {
			setUf(uf);
		}

		Long paisId = (Long)attributes.get("paisId");

		if (paisId != null) {
			setPaisId(paisId);
		}

		Boolean principal = (Boolean)attributes.get("principal");

		if (principal != null) {
			setPrincipal(principal);
		}

		Integer tipo = (Integer)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_enderecoRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEnderecoId() {
		return _enderecoId;
	}

	@Override
	public void setEnderecoId(long enderecoId) {
		_enderecoId = enderecoId;

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setEnderecoId", long.class);

				method.invoke(_enderecoRemoteModel, enderecoId);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_enderecoRemoteModel, companyId);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_enderecoRemoteModel, groupId);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_enderecoRemoteModel, createUserId);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_enderecoRemoteModel, modifiedUserId);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_enderecoRemoteModel, createDate);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_enderecoRemoteModel, modifiedDate);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_enderecoRemoteModel, classNameId);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_enderecoRemoteModel, classPK);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setLogradouro", String.class);

				method.invoke(_enderecoRemoteModel, logradouro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNumero() {
		return _numero;
	}

	@Override
	public void setNumero(String numero) {
		_numero = numero;

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumero", String.class);

				method.invoke(_enderecoRemoteModel, numero);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComplemento() {
		return _complemento;
	}

	@Override
	public void setComplemento(String complemento) {
		_complemento = complemento;

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setComplemento", String.class);

				method.invoke(_enderecoRemoteModel, complemento);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setCep", String.class);

				method.invoke(_enderecoRemoteModel, cep);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setBairro", String.class);

				method.invoke(_enderecoRemoteModel, bairro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCidadeId() {
		return _cidadeId;
	}

	@Override
	public void setCidadeId(long cidadeId) {
		_cidadeId = cidadeId;

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setCidadeId", long.class);

				method.invoke(_enderecoRemoteModel, cidadeId);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setUf", String.class);

				method.invoke(_enderecoRemoteModel, uf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPaisId() {
		return _paisId;
	}

	@Override
	public void setPaisId(long paisId) {
		_paisId = paisId;

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setPaisId", long.class);

				method.invoke(_enderecoRemoteModel, paisId);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipal", boolean.class);

				method.invoke(_enderecoRemoteModel, principal);
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

		if (_enderecoRemoteModel != null) {
			try {
				Class<?> clazz = _enderecoRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo", int.class);

				method.invoke(_enderecoRemoteModel, tipo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Endereco.class.getName()), getClassNameId());
	}

	public BaseModel<?> getEnderecoRemoteModel() {
		return _enderecoRemoteModel;
	}

	public void setEnderecoRemoteModel(BaseModel<?> enderecoRemoteModel) {
		_enderecoRemoteModel = enderecoRemoteModel;
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

		Class<?> remoteModelClass = _enderecoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_enderecoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EnderecoLocalServiceUtil.addEndereco(this);
		}
		else {
			EnderecoLocalServiceUtil.updateEndereco(this);
		}
	}

	@Override
	public Endereco toEscapedModel() {
		return (Endereco)ProxyUtil.newProxyInstance(Endereco.class.getClassLoader(),
			new Class[] { Endereco.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EnderecoClp clone = new EnderecoClp();

		clone.setUuid(getUuid());
		clone.setEnderecoId(getEnderecoId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setLogradouro(getLogradouro());
		clone.setNumero(getNumero());
		clone.setComplemento(getComplemento());
		clone.setCep(getCep());
		clone.setBairro(getBairro());
		clone.setCidadeId(getCidadeId());
		clone.setUf(getUf());
		clone.setPaisId(getPaisId());
		clone.setPrincipal(getPrincipal());
		clone.setTipo(getTipo());

		return clone;
	}

	@Override
	public int compareTo(Endereco endereco) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), endereco.getCreateDate());

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

		if (!(obj instanceof EnderecoClp)) {
			return false;
		}

		EnderecoClp endereco = (EnderecoClp)obj;

		long primaryKey = endereco.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", enderecoId=");
		sb.append(getEnderecoId());
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
		sb.append(", logradouro=");
		sb.append(getLogradouro());
		sb.append(", numero=");
		sb.append(getNumero());
		sb.append(", complemento=");
		sb.append(getComplemento());
		sb.append(", cep=");
		sb.append(getCep());
		sb.append(", bairro=");
		sb.append(getBairro());
		sb.append(", cidadeId=");
		sb.append(getCidadeId());
		sb.append(", uf=");
		sb.append(getUf());
		sb.append(", paisId=");
		sb.append(getPaisId());
		sb.append(", principal=");
		sb.append(getPrincipal());
		sb.append(", tipo=");
		sb.append(getTipo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.contato.model.Endereco");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enderecoId</column-name><column-value><![CDATA[");
		sb.append(getEnderecoId());
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
			"<column><column-name>logradouro</column-name><column-value><![CDATA[");
		sb.append(getLogradouro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numero</column-name><column-value><![CDATA[");
		sb.append(getNumero());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complemento</column-name><column-value><![CDATA[");
		sb.append(getComplemento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cep</column-name><column-value><![CDATA[");
		sb.append(getCep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bairro</column-name><column-value><![CDATA[");
		sb.append(getBairro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cidadeId</column-name><column-value><![CDATA[");
		sb.append(getCidadeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uf</column-name><column-value><![CDATA[");
		sb.append(getUf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paisId</column-name><column-value><![CDATA[");
		sb.append(getPaisId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principal</column-name><column-value><![CDATA[");
		sb.append(getPrincipal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo</column-name><column-value><![CDATA[");
		sb.append(getTipo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _enderecoId;
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
	private String _logradouro;
	private String _numero;
	private String _complemento;
	private String _cep;
	private String _bairro;
	private long _cidadeId;
	private String _uf;
	private long _paisId;
	private boolean _principal;
	private int _tipo;
	private BaseModel<?> _enderecoRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.contato.service.ClpSerializer.class;
}