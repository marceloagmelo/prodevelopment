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
public class Pesquisa_UsuarioSoap implements Serializable {
	public static Pesquisa_UsuarioSoap toSoapModel(Pesquisa_Usuario model) {
		Pesquisa_UsuarioSoap soapModel = new Pesquisa_UsuarioSoap();

		soapModel.setId(model.getId());
		soapModel.setNome(model.getNome());
		soapModel.setEmail(model.getEmail());
		soapModel.setDataInclusao(model.getDataInclusao());
		soapModel.setPesquisaId(model.getPesquisaId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static Pesquisa_UsuarioSoap[] toSoapModels(Pesquisa_Usuario[] models) {
		Pesquisa_UsuarioSoap[] soapModels = new Pesquisa_UsuarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Pesquisa_UsuarioSoap[][] toSoapModels(
		Pesquisa_Usuario[][] models) {
		Pesquisa_UsuarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Pesquisa_UsuarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Pesquisa_UsuarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Pesquisa_UsuarioSoap[] toSoapModels(
		List<Pesquisa_Usuario> models) {
		List<Pesquisa_UsuarioSoap> soapModels = new ArrayList<Pesquisa_UsuarioSoap>(models.size());

		for (Pesquisa_Usuario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Pesquisa_UsuarioSoap[soapModels.size()]);
	}

	public Pesquisa_UsuarioSoap() {
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

	private long _id;
	private String _nome;
	private String _email;
	private Date _dataInclusao;
	private long _pesquisaId;
	private long _userId;
}