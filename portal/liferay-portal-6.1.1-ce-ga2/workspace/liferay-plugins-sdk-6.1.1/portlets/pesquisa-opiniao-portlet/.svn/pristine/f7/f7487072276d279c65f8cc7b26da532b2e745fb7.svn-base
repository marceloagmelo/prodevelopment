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
public class PerguntaSoap implements Serializable {
	public static PerguntaSoap toSoapModel(Pergunta model) {
		PerguntaSoap soapModel = new PerguntaSoap();

		soapModel.setId(model.getId());
		soapModel.setDescricao(model.getDescricao());
		soapModel.setDataInclusao(model.getDataInclusao());
		soapModel.setDataAlteracao(model.getDataAlteracao());
		soapModel.setPesquisaId(model.getPesquisaId());
		soapModel.setUserIdInclusao(model.getUserIdInclusao());
		soapModel.setUserIdAlteracao(model.getUserIdAlteracao());

		return soapModel;
	}

	public static PerguntaSoap[] toSoapModels(Pergunta[] models) {
		PerguntaSoap[] soapModels = new PerguntaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PerguntaSoap[][] toSoapModels(Pergunta[][] models) {
		PerguntaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PerguntaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PerguntaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PerguntaSoap[] toSoapModels(List<Pergunta> models) {
		List<PerguntaSoap> soapModels = new ArrayList<PerguntaSoap>(models.size());

		for (Pergunta model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PerguntaSoap[soapModels.size()]);
	}

	public PerguntaSoap() {
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

	public String getDescricao() {
		return _descricao;
	}

	public void setDescricao(String descricao) {
		_descricao = descricao;
	}

	public Date getDataInclusao() {
		return _dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		_dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return _dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		_dataAlteracao = dataAlteracao;
	}

	public long getPesquisaId() {
		return _pesquisaId;
	}

	public void setPesquisaId(long pesquisaId) {
		_pesquisaId = pesquisaId;
	}

	public long getUserIdInclusao() {
		return _userIdInclusao;
	}

	public void setUserIdInclusao(long userIdInclusao) {
		_userIdInclusao = userIdInclusao;
	}

	public long getUserIdAlteracao() {
		return _userIdAlteracao;
	}

	public void setUserIdAlteracao(long userIdAlteracao) {
		_userIdAlteracao = userIdAlteracao;
	}

	private long _id;
	private String _descricao;
	private Date _dataInclusao;
	private Date _dataAlteracao;
	private long _pesquisaId;
	private long _userIdInclusao;
	private long _userIdAlteracao;
}