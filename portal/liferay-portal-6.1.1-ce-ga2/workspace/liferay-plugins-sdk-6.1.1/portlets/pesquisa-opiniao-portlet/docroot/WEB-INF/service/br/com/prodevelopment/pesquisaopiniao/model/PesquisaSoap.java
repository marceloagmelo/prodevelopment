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
public class PesquisaSoap implements Serializable {
	public static PesquisaSoap toSoapModel(Pesquisa model) {
		PesquisaSoap soapModel = new PesquisaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setTitulo(model.getTitulo());
		soapModel.setDescricao(model.getDescricao());
		soapModel.setDataInclusao(model.getDataInclusao());
		soapModel.setDataAlteracao(model.getDataAlteracao());
		soapModel.setAtiva(model.getAtiva());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserIdInclusao(model.getUserIdInclusao());
		soapModel.setUserIdAlteracao(model.getUserIdAlteracao());

		return soapModel;
	}

	public static PesquisaSoap[] toSoapModels(Pesquisa[] models) {
		PesquisaSoap[] soapModels = new PesquisaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PesquisaSoap[][] toSoapModels(Pesquisa[][] models) {
		PesquisaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PesquisaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PesquisaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PesquisaSoap[] toSoapModels(List<Pesquisa> models) {
		List<PesquisaSoap> soapModels = new ArrayList<PesquisaSoap>(models.size());

		for (Pesquisa model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PesquisaSoap[soapModels.size()]);
	}

	public PesquisaSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTitulo() {
		return _titulo;
	}

	public void setTitulo(String titulo) {
		_titulo = titulo;
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

	public boolean getAtiva() {
		return _ativa;
	}

	public boolean isAtiva() {
		return _ativa;
	}

	public void setAtiva(boolean ativa) {
		_ativa = ativa;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	private String _uuid;
	private long _id;
	private String _titulo;
	private String _descricao;
	private Date _dataInclusao;
	private Date _dataAlteracao;
	private boolean _ativa;
	private long _companyId;
	private long _groupId;
	private long _userIdInclusao;
	private long _userIdAlteracao;
}