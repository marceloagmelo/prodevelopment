/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.prodevelopment.contato.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.contato.service.http.TelefoneServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.contato.service.http.TelefoneServiceSoap
 * @generated
 */
public class TelefoneSoap implements Serializable {
	public static TelefoneSoap toSoapModel(Telefone model) {
		TelefoneSoap soapModel = new TelefoneSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTelefoneId(model.getTelefoneId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setDdi(model.getDdi());
		soapModel.setDdd(model.getDdd());
		soapModel.setNumero(model.getNumero());
		soapModel.setRamal(model.getRamal());
		soapModel.setTipo(model.getTipo());
		soapModel.setPrincipal(model.getPrincipal());

		return soapModel;
	}

	public static TelefoneSoap[] toSoapModels(Telefone[] models) {
		TelefoneSoap[] soapModels = new TelefoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TelefoneSoap[][] toSoapModels(Telefone[][] models) {
		TelefoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TelefoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TelefoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TelefoneSoap[] toSoapModels(List<Telefone> models) {
		List<TelefoneSoap> soapModels = new ArrayList<TelefoneSoap>(models.size());

		for (Telefone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TelefoneSoap[soapModels.size()]);
	}

	public TelefoneSoap() {
	}

	public long getPrimaryKey() {
		return _telefoneId;
	}

	public void setPrimaryKey(long pk) {
		setTelefoneId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTelefoneId() {
		return _telefoneId;
	}

	public void setTelefoneId(long telefoneId) {
		_telefoneId = telefoneId;
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

	public String getDdi() {
		return _ddi;
	}

	public void setDdi(String ddi) {
		_ddi = ddi;
	}

	public String getDdd() {
		return _ddd;
	}

	public void setDdd(String ddd) {
		_ddd = ddd;
	}

	public String getNumero() {
		return _numero;
	}

	public void setNumero(String numero) {
		_numero = numero;
	}

	public String getRamal() {
		return _ramal;
	}

	public void setRamal(String ramal) {
		_ramal = ramal;
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
	private long _telefoneId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private String _ddi;
	private String _ddd;
	private String _numero;
	private String _ramal;
	private int _tipo;
	private boolean _principal;
}