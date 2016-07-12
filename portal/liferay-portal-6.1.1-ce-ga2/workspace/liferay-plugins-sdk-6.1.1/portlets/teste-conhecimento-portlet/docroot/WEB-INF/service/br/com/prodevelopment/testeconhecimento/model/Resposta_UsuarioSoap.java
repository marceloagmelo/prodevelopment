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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Marcelo Melo
 * @generated
 */
public class Resposta_UsuarioSoap implements Serializable {
	public static Resposta_UsuarioSoap toSoapModel(Resposta_Usuario model) {
		Resposta_UsuarioSoap soapModel = new Resposta_UsuarioSoap();

		soapModel.setId(model.getId());
		soapModel.setCorreta(model.getCorreta());
		soapModel.setDataInclusao(model.getDataInclusao());
		soapModel.setTesteUsuarioId(model.getTesteUsuarioId());
		soapModel.setRespostaId(model.getRespostaId());

		return soapModel;
	}

	public static Resposta_UsuarioSoap[] toSoapModels(Resposta_Usuario[] models) {
		Resposta_UsuarioSoap[] soapModels = new Resposta_UsuarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Resposta_UsuarioSoap[][] toSoapModels(
		Resposta_Usuario[][] models) {
		Resposta_UsuarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Resposta_UsuarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Resposta_UsuarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Resposta_UsuarioSoap[] toSoapModels(
		List<Resposta_Usuario> models) {
		List<Resposta_UsuarioSoap> soapModels = new ArrayList<Resposta_UsuarioSoap>(models.size());

		for (Resposta_Usuario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Resposta_UsuarioSoap[soapModels.size()]);
	}

	public Resposta_UsuarioSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	private long _id;
	private boolean _correta;
	private Date _dataInclusao;
	private long _testeUsuarioId;
	private long _respostaId;
}