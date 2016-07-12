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

package br.com.prodevelopment.contato.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.contato.service.http.EnderecoServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.contato.service.http.EnderecoServiceSoap
 * @generated
 */
public class EnderecoSoap implements Serializable {
	public static EnderecoSoap toSoapModel(Endereco model) {
		EnderecoSoap soapModel = new EnderecoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEnderecoId(model.getEnderecoId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setLogradouro(model.getLogradouro());
		soapModel.setNumero(model.getNumero());
		soapModel.setComplemento(model.getComplemento());
		soapModel.setCep(model.getCep());
		soapModel.setBairro(model.getBairro());
		soapModel.setCidadeId(model.getCidadeId());
		soapModel.setUf(model.getUf());
		soapModel.setPaisId(model.getPaisId());
		soapModel.setPrincipal(model.getPrincipal());
		soapModel.setTipo(model.getTipo());

		return soapModel;
	}

	public static EnderecoSoap[] toSoapModels(Endereco[] models) {
		EnderecoSoap[] soapModels = new EnderecoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnderecoSoap[][] toSoapModels(Endereco[][] models) {
		EnderecoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnderecoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnderecoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnderecoSoap[] toSoapModels(List<Endereco> models) {
		List<EnderecoSoap> soapModels = new ArrayList<EnderecoSoap>(models.size());

		for (Endereco model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnderecoSoap[soapModels.size()]);
	}

	public EnderecoSoap() {
	}

	public long getPrimaryKey() {
		return _enderecoId;
	}

	public void setPrimaryKey(long pk) {
		setEnderecoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEnderecoId() {
		return _enderecoId;
	}

	public void setEnderecoId(long enderecoId) {
		_enderecoId = enderecoId;
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

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getLogradouro() {
		return _logradouro;
	}

	public void setLogradouro(String logradouro) {
		_logradouro = logradouro;
	}

	public String getNumero() {
		return _numero;
	}

	public void setNumero(String numero) {
		_numero = numero;
	}

	public String getComplemento() {
		return _complemento;
	}

	public void setComplemento(String complemento) {
		_complemento = complemento;
	}

	public String getCep() {
		return _cep;
	}

	public void setCep(String cep) {
		_cep = cep;
	}

	public String getBairro() {
		return _bairro;
	}

	public void setBairro(String bairro) {
		_bairro = bairro;
	}

	public long getCidadeId() {
		return _cidadeId;
	}

	public void setCidadeId(long cidadeId) {
		_cidadeId = cidadeId;
	}

	public String getUf() {
		return _uf;
	}

	public void setUf(String uf) {
		_uf = uf;
	}

	public long getPaisId() {
		return _paisId;
	}

	public void setPaisId(long paisId) {
		_paisId = paisId;
	}

	public boolean getPrincipal() {
		return _principal;
	}

	public boolean isPrincipal() {
		return _principal;
	}

	public void setPrincipal(boolean principal) {
		_principal = principal;
	}

	public int getTipo() {
		return _tipo;
	}

	public void setTipo(int tipo) {
		_tipo = tipo;
	}

	private String _uuid;
	private long _enderecoId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private String _logradouro;
	private String _numero;
	private String _complemento;
	private String _cep;
	private String _bairro;
	private long _cidadeId;
	private String _uf;
	private long _paisId;
	private boolean _principal;
	private int _tipo;
}