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

package br.com.prodevelopment.testeconhecimento.model;

import br.com.prodevelopment.testeconhecimento.service.Teste_UsuarioLocalServiceUtil;

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
public class Teste_UsuarioClp extends BaseModelImpl<Teste_Usuario>
	implements Teste_Usuario {
	public Teste_UsuarioClp() {
	}

	public Class<?> getModelClass() {
		return Teste_Usuario.class;
	}

	public String getModelClassName() {
		return Teste_Usuario.class.getName();
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
		attributes.put("dataFinalizacao", getDataFinalizacao());
		attributes.put("totalRespostaCorreta", getTotalRespostaCorreta());
		attributes.put("totalRespostaErrada", getTotalRespostaErrada());
		attributes.put("totalPontuacao", getTotalPontuacao());
		attributes.put("testeId", getTesteId());
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

		Date dataFinalizacao = (Date)attributes.get("dataFinalizacao");

		if (dataFinalizacao != null) {
			setDataFinalizacao(dataFinalizacao);
		}

		Integer totalRespostaCorreta = (Integer)attributes.get(
				"totalRespostaCorreta");

		if (totalRespostaCorreta != null) {
			setTotalRespostaCorreta(totalRespostaCorreta);
		}

		Integer totalRespostaErrada = (Integer)attributes.get(
				"totalRespostaErrada");

		if (totalRespostaErrada != null) {
			setTotalRespostaErrada(totalRespostaErrada);
		}

		Double totalPontuacao = (Double)attributes.get("totalPontuacao");

		if (totalPontuacao != null) {
			setTotalPontuacao(totalPontuacao);
		}

		Long testeId = (Long)attributes.get("testeId");

		if (testeId != null) {
			setTesteId(testeId);
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

	public Date getDataFinalizacao() {
		return _dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		_dataFinalizacao = dataFinalizacao;
	}

	public int getTotalRespostaCorreta() {
		return _totalRespostaCorreta;
	}

	public void setTotalRespostaCorreta(int totalRespostaCorreta) {
		_totalRespostaCorreta = totalRespostaCorreta;
	}

	public int getTotalRespostaErrada() {
		return _totalRespostaErrada;
	}

	public void setTotalRespostaErrada(int totalRespostaErrada) {
		_totalRespostaErrada = totalRespostaErrada;
	}

	public double getTotalPontuacao() {
		return _totalPontuacao;
	}

	public void setTotalPontuacao(double totalPontuacao) {
		_totalPontuacao = totalPontuacao;
	}

	public long getTesteId() {
		return _testeId;
	}

	public void setTesteId(long testeId) {
		_testeId = testeId;
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

	public BaseModel<?> getTeste_UsuarioRemoteModel() {
		return _teste_UsuarioRemoteModel;
	}

	public void setTeste_UsuarioRemoteModel(
		BaseModel<?> teste_UsuarioRemoteModel) {
		_teste_UsuarioRemoteModel = teste_UsuarioRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			Teste_UsuarioLocalServiceUtil.addTeste_Usuario(this);
		}
		else {
			Teste_UsuarioLocalServiceUtil.updateTeste_Usuario(this);
		}
	}

	@Override
	public Teste_Usuario toEscapedModel() {
		return (Teste_Usuario)Proxy.newProxyInstance(Teste_Usuario.class.getClassLoader(),
			new Class[] { Teste_Usuario.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Teste_UsuarioClp clone = new Teste_UsuarioClp();

		clone.setId(getId());
		clone.setNome(getNome());
		clone.setEmail(getEmail());
		clone.setDataInclusao(getDataInclusao());
		clone.setDataFinalizacao(getDataFinalizacao());
		clone.setTotalRespostaCorreta(getTotalRespostaCorreta());
		clone.setTotalRespostaErrada(getTotalRespostaErrada());
		clone.setTotalPontuacao(getTotalPontuacao());
		clone.setTesteId(getTesteId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(Teste_Usuario teste_Usuario) {
		int value = 0;

		if (getId() < teste_Usuario.getId()) {
			value = -1;
		}
		else if (getId() > teste_Usuario.getId()) {
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

		Teste_UsuarioClp teste_Usuario = null;

		try {
			teste_Usuario = (Teste_UsuarioClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = teste_Usuario.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", dataInclusao=");
		sb.append(getDataInclusao());
		sb.append(", dataFinalizacao=");
		sb.append(getDataFinalizacao());
		sb.append(", totalRespostaCorreta=");
		sb.append(getTotalRespostaCorreta());
		sb.append(", totalRespostaErrada=");
		sb.append(getTotalRespostaErrada());
		sb.append(", totalPontuacao=");
		sb.append(getTotalPontuacao());
		sb.append(", testeId=");
		sb.append(getTesteId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.testeconhecimento.model.Teste_Usuario");
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
			"<column><column-name>dataFinalizacao</column-name><column-value><![CDATA[");
		sb.append(getDataFinalizacao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalRespostaCorreta</column-name><column-value><![CDATA[");
		sb.append(getTotalRespostaCorreta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalRespostaErrada</column-name><column-value><![CDATA[");
		sb.append(getTotalRespostaErrada());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalPontuacao</column-name><column-value><![CDATA[");
		sb.append(getTotalPontuacao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testeId</column-name><column-value><![CDATA[");
		sb.append(getTesteId());
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
	private Date _dataFinalizacao;
	private int _totalRespostaCorreta;
	private int _totalRespostaErrada;
	private double _totalPontuacao;
	private long _testeId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _teste_UsuarioRemoteModel;
}