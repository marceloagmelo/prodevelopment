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

package br.com.prodevelopment.atividade.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.atividade.service.http.AtividadeServiceSoap}.
 *
 * @author Marcelo
 * @see br.com.prodevelopment.atividade.service.http.AtividadeServiceSoap
 * @generated
 */
public class AtividadeSoap implements Serializable {
	public static AtividadeSoap toSoapModel(Atividade model) {
		AtividadeSoap soapModel = new AtividadeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAtividadeId(model.getAtividadeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNome(model.getNome());
		soapModel.setDescricao(model.getDescricao());
		soapModel.setImagemId(model.getImagemId());
		soapModel.setExisteImagem(model.getExisteImagem());
		soapModel.setVersao(model.getVersao());

		return soapModel;
	}

	public static AtividadeSoap[] toSoapModels(Atividade[] models) {
		AtividadeSoap[] soapModels = new AtividadeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AtividadeSoap[][] toSoapModels(Atividade[][] models) {
		AtividadeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AtividadeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AtividadeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AtividadeSoap[] toSoapModels(List<Atividade> models) {
		List<AtividadeSoap> soapModels = new ArrayList<AtividadeSoap>(models.size());

		for (Atividade model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AtividadeSoap[soapModels.size()]);
	}

	public AtividadeSoap() {
	}

	public long getPrimaryKey() {
		return _atividadeId;
	}

	public void setPrimaryKey(long pk) {
		setAtividadeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAtividadeId() {
		return _atividadeId;
	}

	public void setAtividadeId(long atividadeId) {
		_atividadeId = atividadeId;
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

	public long getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getDescricao() {
		return _descricao;
	}

	public void setDescricao(String descricao) {
		_descricao = descricao;
	}

	public long getImagemId() {
		return _imagemId;
	}

	public void setImagemId(long imagemId) {
		_imagemId = imagemId;
	}

	public boolean getExisteImagem() {
		return _existeImagem;
	}

	public boolean isExisteImagem() {
		return _existeImagem;
	}

	public void setExisteImagem(boolean existeImagem) {
		_existeImagem = existeImagem;
	}

	public double getVersao() {
		return _versao;
	}

	public void setVersao(double versao) {
		_versao = versao;
	}

	private String _uuid;
	private long _atividadeId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _descricao;
	private long _imagemId;
	private boolean _existeImagem;
	private double _versao;
}