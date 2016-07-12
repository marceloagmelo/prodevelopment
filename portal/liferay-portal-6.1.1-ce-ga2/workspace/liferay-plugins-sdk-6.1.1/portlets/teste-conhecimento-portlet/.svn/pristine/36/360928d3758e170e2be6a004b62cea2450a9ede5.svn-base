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
public class RespostaSoap implements Serializable {
	public static RespostaSoap toSoapModel(Resposta model) {
		RespostaSoap soapModel = new RespostaSoap();

		soapModel.setId(model.getId());
		soapModel.setDescricao(model.getDescricao());
		soapModel.setCorreta(model.getCorreta());
		soapModel.setDataInclusao(model.getDataInclusao());
		soapModel.setDataAlteracao(model.getDataAlteracao());
		soapModel.setPerguntaId(model.getPerguntaId());
		soapModel.setUserIdInclusao(model.getUserIdInclusao());
		soapModel.setUserIdAlteracao(model.getUserIdAlteracao());

		return soapModel;
	}

	public static RespostaSoap[] toSoapModels(Resposta[] models) {
		RespostaSoap[] soapModels = new RespostaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RespostaSoap[][] toSoapModels(Resposta[][] models) {
		RespostaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RespostaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RespostaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RespostaSoap[] toSoapModels(List<Resposta> models) {
		List<RespostaSoap> soapModels = new ArrayList<RespostaSoap>(models.size());

		for (Resposta model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RespostaSoap[soapModels.size()]);
	}

	public RespostaSoap() {
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

	public Date getDataAlteracao() {
		return _dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		_dataAlteracao = dataAlteracao;
	}

	public long getPerguntaId() {
		return _perguntaId;
	}

	public void setPerguntaId(long perguntaId) {
		_perguntaId = perguntaId;
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
	private boolean _correta;
	private Date _dataInclusao;
	private Date _dataAlteracao;
	private long _perguntaId;
	private long _userIdInclusao;
	private long _userIdAlteracao;
}