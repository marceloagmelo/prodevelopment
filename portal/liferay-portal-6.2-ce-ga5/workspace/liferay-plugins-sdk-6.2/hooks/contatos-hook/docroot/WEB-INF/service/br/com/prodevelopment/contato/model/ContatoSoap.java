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
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.contato.service.http.ContatoServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.contato.service.http.ContatoServiceSoap
 * @generated
 */
public class ContatoSoap implements Serializable {
	public static ContatoSoap toSoapModel(Contato model) {
		ContatoSoap soapModel = new ContatoSoap();

		soapModel.setContatoId(model.getContatoId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setEndEmail(model.getEndEmail());
		soapModel.setNome(model.getNome());
		soapModel.setSexo(model.getSexo());
		soapModel.setDataNascimento(model.getDataNascimento());
		soapModel.setCargoId(model.getCargoId());
		soapModel.setSkype(model.getSkype());
		soapModel.setFacebook(model.getFacebook());
		soapModel.setTwitter(model.getTwitter());

		return soapModel;
	}

	public static ContatoSoap[] toSoapModels(Contato[] models) {
		ContatoSoap[] soapModels = new ContatoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContatoSoap[][] toSoapModels(Contato[][] models) {
		ContatoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContatoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContatoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContatoSoap[] toSoapModels(List<Contato> models) {
		List<ContatoSoap> soapModels = new ArrayList<ContatoSoap>(models.size());

		for (Contato model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContatoSoap[soapModels.size()]);
	}

	public ContatoSoap() {
	}

	public long getPrimaryKey() {
		return _contatoId;
	}

	public void setPrimaryKey(long pk) {
		setContatoId(pk);
	}

	public long getContatoId() {
		return _contatoId;
	}

	public void setContatoId(long contatoId) {
		_contatoId = contatoId;
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

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public String getEndEmail() {
		return _endEmail;
	}

	public void setEndEmail(String endEmail) {
		_endEmail = endEmail;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getSexo() {
		return _sexo;
	}

	public void setSexo(String sexo) {
		_sexo = sexo;
	}

	public Date getDataNascimento() {
		return _dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		_dataNascimento = dataNascimento;
	}

	public long getCargoId() {
		return _cargoId;
	}

	public void setCargoId(long cargoId) {
		_cargoId = cargoId;
	}

	public String getSkype() {
		return _skype;
	}

	public void setSkype(String skype) {
		_skype = skype;
	}

	public String getFacebook() {
		return _facebook;
	}

	public void setFacebook(String facebook) {
		_facebook = facebook;
	}

	public String getTwitter() {
		return _twitter;
	}

	public void setTwitter(String twitter) {
		_twitter = twitter;
	}

	private long _contatoId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private long _accountId;
	private String _endEmail;
	private String _nome;
	private String _sexo;
	private Date _dataNascimento;
	private long _cargoId;
	private String _skype;
	private String _facebook;
	private String _twitter;
}