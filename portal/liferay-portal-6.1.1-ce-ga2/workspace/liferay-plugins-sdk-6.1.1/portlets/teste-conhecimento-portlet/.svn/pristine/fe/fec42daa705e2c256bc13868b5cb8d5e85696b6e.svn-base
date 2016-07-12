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
public class Teste_UsuarioSoap implements Serializable {
	public static Teste_UsuarioSoap toSoapModel(Teste_Usuario model) {
		Teste_UsuarioSoap soapModel = new Teste_UsuarioSoap();

		soapModel.setId(model.getId());
		soapModel.setNome(model.getNome());
		soapModel.setEmail(model.getEmail());
		soapModel.setDataInclusao(model.getDataInclusao());
		soapModel.setDataFinalizacao(model.getDataFinalizacao());
		soapModel.setTotalRespostaCorreta(model.getTotalRespostaCorreta());
		soapModel.setTotalRespostaErrada(model.getTotalRespostaErrada());
		soapModel.setTotalPontuacao(model.getTotalPontuacao());
		soapModel.setTesteId(model.getTesteId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static Teste_UsuarioSoap[] toSoapModels(Teste_Usuario[] models) {
		Teste_UsuarioSoap[] soapModels = new Teste_UsuarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Teste_UsuarioSoap[][] toSoapModels(Teste_Usuario[][] models) {
		Teste_UsuarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Teste_UsuarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Teste_UsuarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Teste_UsuarioSoap[] toSoapModels(List<Teste_Usuario> models) {
		List<Teste_UsuarioSoap> soapModels = new ArrayList<Teste_UsuarioSoap>(models.size());

		for (Teste_Usuario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Teste_UsuarioSoap[soapModels.size()]);
	}

	public Teste_UsuarioSoap() {
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
}