/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package br.com.prodevelopment.pesquisaopiniao.model;

import br.com.prodevelopment.pesquisaopiniao.service.Pesquisa_UsuarioLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcelo Melo
 */
public class Pesquisa_UsuarioClp extends BaseModelImpl<Pesquisa_Usuario>
	implements Pesquisa_Usuario {
	public Pesquisa_UsuarioClp() {
	}

	public Class<?> getModelClass() {
		return Pesquisa_Usuario.class;
	}

	public String getModelClassName() {
		return Pesquisa_Usuario.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("email", getEmail());
		attributes.put("dataInclusao", getDataInclusao());
		attributes.put("pesquisaId", getPesquisaId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date dataInclusao = (Date)attributes.get("dataInclusao");

		if (dataInclusao != null) {
			setDataInclusao(dataInclusao);
		}

		Long pesquisaId = (Long)attributes.get("pesquisaId");

		if (pesquisaId != null) {
			setPesquisaId(pesquisaId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getDataInclusao() {
		return _dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		_dataInclusao = dataInclusao;
	}

	public long getPesquisaId() {
		return _pesquisaId;
	}

	public void setPesquisaId(long pesquisaId) {
		_pesquisaId = pesquisaId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getPesquisa_UsuarioRemoteModel() {
		return _pesquisa_UsuarioRemoteModel;
	}

	public void setPesquisa_UsuarioRemoteModel(
		BaseModel<?> pesquisa_UsuarioRemoteModel) {
		_pesquisa_UsuarioRemoteModel = pesquisa_UsuarioRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			Pesquisa_UsuarioLocalServiceUtil.addPesquisa_Usuario(this);
		}
		else {
			Pesquisa_UsuarioLocalServiceUtil.updatePesquisa_Usuario(this);
		}
	}

	@Override
	public Pesquisa_Usuario toEscapedModel() {
		return (Pesquisa_Usuario)Proxy.newProxyInstance(Pesquisa_Usuario.class.getClassLoader(),
			new Class[] { Pesquisa_Usuario.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Pesquisa_UsuarioClp clone = new Pesquisa_UsuarioClp();

		clone.setId(getId());
		clone.setNome(getNome());
		clone.setEmail(getEmail());
		clone.setDataInclusao(getDataInclusao());
		clone.setPesquisaId(getPesquisaId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(Pesquisa_Usuario pesquisa_Usuario) {
		int value = 0;

		if (getId() < pesquisa_Usuario.getId()) {
			value = -1;
		}
		else if (getId() > pesquisa_Usuario.getId()) {
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
		if (obj == null) {
			return false;
		}

		Pesquisa_UsuarioClp pesquisa_Usuario = null;

		try {
			pesquisa_Usuario = (Pesquisa_UsuarioClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = pesquisa_Usuario.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", dataInclusao=");
		sb.append(getDataInclusao());
		sb.append(", pesquisaId=");
		sb.append(getPesquisaId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataInclusao</column-name><column-value><![CDATA[");
		sb.append(getDataInclusao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pesquisaId</column-name><column-value><![CDATA[");
		sb.append(getPesquisaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _nome;
	private String _email;
	private Date _dataInclusao;
	private long _pesquisaId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _pesquisa_UsuarioRemoteModel;
}