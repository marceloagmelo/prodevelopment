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
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.contato.service.http.EnderecoEmailServiceSoap}.
 *
 * @author marcelo
 * @see br.com.prodevelopment.contato.service.http.EnderecoEmailServiceSoap
 * @generated
 */
public class EnderecoEmailSoap implements Serializable {
	public static EnderecoEmailSoap toSoapModel(EnderecoEmail model) {
		EnderecoEmailSoap soapModel = new EnderecoEmailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEnderecoEmailId(model.getEnderecoEmailId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setEndereco(model.getEndereco());
		soapModel.setTipo(model.getTipo());
		soapModel.setPrincipal(model.getPrincipal());

		return soapModel;
	}

	public static EnderecoEmailSoap[] toSoapModels(EnderecoEmail[] models) {
		EnderecoEmailSoap[] soapModels = new EnderecoEmailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnderecoEmailSoap[][] toSoapModels(EnderecoEmail[][] models) {
		EnderecoEmailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnderecoEmailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnderecoEmailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnderecoEmailSoap[] toSoapModels(List<EnderecoEmail> models) {
		List<EnderecoEmailSoap> soapModels = new ArrayList<EnderecoEmailSoap>(models.size());

		for (EnderecoEmail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnderecoEmailSoap[soapModels.size()]);
	}

	public EnderecoEmailSoap() {
	}

	public long getPrimaryKey() {
		return _enderecoEmailId;
	}

	public void setPrimaryKey(long pk) {
		setEnderecoEmailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEnderecoEmailId() {
		return _enderecoEmailId;
	}

	public void setEnderecoEmailId(long enderecoEmailId) {
		_enderecoEmailId = enderecoEmailId;
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

	public String getEndereco() {
		return _endereco;
	}

	public void setEndereco(String endereco) {
		_endereco = endereco;
	}

	public int getTipo() {
		return _tipo;
	}

	public void setTipo(int tipo) {
		_tipo = tipo;
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

	private String _uuid;
	private long _enderecoEmailId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private String _endereco;
	private int _tipo;
	private boolean _principal;
}