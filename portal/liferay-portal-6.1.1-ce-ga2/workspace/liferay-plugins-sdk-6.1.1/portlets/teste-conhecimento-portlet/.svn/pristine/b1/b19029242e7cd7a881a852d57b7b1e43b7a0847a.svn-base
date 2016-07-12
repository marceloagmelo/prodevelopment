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

import br.com.prodevelopment.testeconhecimento.service.Resposta_UsuarioLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcelo Melo
 */
public class Resposta_UsuarioClp extends BaseModelImpl<Resposta_Usuario>
	implements Resposta_Usuario {
	public Resposta_UsuarioClp() {
	}

	public Class<?> getModelClass() {
		return Resposta_Usuario.class;
	}

	public String getModelClassName() {
		return Resposta_Usuario.class.getName();
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
		attributes.put("correta", getCorreta());
		attributes.put("dataInclusao", getDataInclusao());
		attributes.put("testeUsuarioId", getTesteUsuarioId());
		attributes.put("respostaId", getRespostaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Boolean correta = (Boolean)attributes.get("correta");

		if (correta != null) {
			setCorreta(correta);
		}

		Date dataInclusao = (Date)attributes.get("dataInclusao");

		if (dataInclusao != null) {
			setDataInclusao(dataInclusao);
		}

		Long testeUsuarioId = (Long)attributes.get("testeUsuarioId");

		if (testeUsuarioId != null) {
			setTesteUsuarioId(testeUsuarioId);
		}

		Long respostaId = (Long)attributes.get("respostaId");

		if (respostaId != null) {
			setRespostaId(respostaId);
		}
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public boolean getCorreta() {
		return _correta;
	}

	public boolean isCorreta() {
		return _correta;
	}

	public void setCorreta(boolean correta) {
		_correta = correta;
	}

	public Date getDataInclusao() {
		return _dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		_dataInclusao = dataInclusao;
	}

	public long getTesteUsuarioId() {
		return _testeUsuarioId;
	}

	public void setTesteUsuarioId(long testeUsuarioId) {
		_testeUsuarioId = testeUsuarioId;
	}

	public long getRespostaId() {
		return _respostaId;
	}

	public void setRespostaId(long respostaId) {
		_respostaId = respostaId;
	}

	public BaseModel<?> getResposta_UsuarioRemoteModel() {
		return _resposta_UsuarioRemoteModel;
	}

	public void setResposta_UsuarioRemoteModel(
		BaseModel<?> resposta_UsuarioRemoteModel) {
		_resposta_UsuarioRemoteModel = resposta_UsuarioRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			Resposta_UsuarioLocalServiceUtil.addResposta_Usuario(this);
		}
		else {
			Resposta_UsuarioLocalServiceUtil.updateResposta_Usuario(this);
		}
	}

	@Override
	public Resposta_Usuario toEscapedModel() {
		return (Resposta_Usuario)Proxy.newProxyInstance(Resposta_Usuario.class.getClassLoader(),
			new Class[] { Resposta_Usuario.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Resposta_UsuarioClp clone = new Resposta_UsuarioClp();

		clone.setId(getId());
		clone.setCorreta(getCorreta());
		clone.setDataInclusao(getDataInclusao());
		clone.setTesteUsuarioId(getTesteUsuarioId());
		clone.setRespostaId(getRespostaId());

		return clone;
	}

	public int compareTo(Resposta_Usuario resposta_Usuario) {
		int value = 0;

		if (getId() < resposta_Usuario.getId()) {
			value = -1;
		}
		else if (getId() > resposta_Usuario.getId()) {
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

		Resposta_UsuarioClp resposta_Usuario = null;

		try {
			resposta_Usuario = (Resposta_UsuarioClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = resposta_Usuario.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", correta=");
		sb.append(getCorreta());
		sb.append(", dataInclusao=");
		sb.append(getDataInclusao());
		sb.append(", testeUsuarioId=");
		sb.append(getTesteUsuarioId());
		sb.append(", respostaId=");
		sb.append(getRespostaId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>correta</column-name><column-value><![CDATA[");
		sb.append(getCorreta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataInclusao</column-name><column-value><![CDATA[");
		sb.append(getDataInclusao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testeUsuarioId</column-name><column-value><![CDATA[");
		sb.append(getTesteUsuarioId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respostaId</column-name><column-value><![CDATA[");
		sb.append(getRespostaId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private boolean _correta;
	private Date _dataInclusao;
	private long _testeUsuarioId;
	private long _respostaId;
	private BaseModel<?> _resposta_UsuarioRemoteModel;
}