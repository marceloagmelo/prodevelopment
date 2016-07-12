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

package br.com.prodevelopment.funcionario.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.funcionario.service.http.CargoServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.funcionario.service.http.CargoServiceSoap
 * @generated
 */
public class CargoSoap implements Serializable {
	public static CargoSoap toSoapModel(Cargo model) {
		CargoSoap soapModel = new CargoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCargoId(model.getCargoId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNome(model.getNome());
		soapModel.setVersao(model.getVersao());

		return soapModel;
	}

	public static CargoSoap[] toSoapModels(Cargo[] models) {
		CargoSoap[] soapModels = new CargoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CargoSoap[][] toSoapModels(Cargo[][] models) {
		CargoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CargoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CargoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CargoSoap[] toSoapModels(List<Cargo> models) {
		List<CargoSoap> soapModels = new ArrayList<CargoSoap>(models.size());

		for (Cargo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CargoSoap[soapModels.size()]);
	}

	public CargoSoap() {
	}

	public long getPrimaryKey() {
		return _cargoId;
	}

	public void setPrimaryKey(long pk) {
		setCargoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCargoId() {
		return _cargoId;
	}

	public void setCargoId(long cargoId) {
		_cargoId = cargoId;
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

	public double getVersao() {
		return _versao;
	}

	public void setVersao(double versao) {
		_versao = versao;
	}

	private String _uuid;
	private long _cargoId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private double _versao;
}