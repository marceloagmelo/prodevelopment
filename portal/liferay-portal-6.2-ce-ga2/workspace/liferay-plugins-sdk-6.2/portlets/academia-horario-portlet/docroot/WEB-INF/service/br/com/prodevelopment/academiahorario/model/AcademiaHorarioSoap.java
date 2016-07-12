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

package br.com.prodevelopment.academiahorario.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.academiahorario.service.http.AcademiaHorarioServiceSoap}.
 *
 * @author Marcelo
 * @see br.com.prodevelopment.academiahorario.service.http.AcademiaHorarioServiceSoap
 * @generated
 */
public class AcademiaHorarioSoap implements Serializable {
	public static AcademiaHorarioSoap toSoapModel(AcademiaHorario model) {
		AcademiaHorarioSoap soapModel = new AcademiaHorarioSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAcademiaHorarioId(model.getAcademiaHorarioId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDiaSemana(model.getDiaSemana());
		soapModel.setHoraInicial(model.getHoraInicial());
		soapModel.setHoraFinal(model.getHoraFinal());
		soapModel.setAtividadeId(model.getAtividadeId());
		soapModel.setAtividadeNome(model.getAtividadeNome());
		soapModel.setVersao(model.getVersao());

		return soapModel;
	}

	public static AcademiaHorarioSoap[] toSoapModels(AcademiaHorario[] models) {
		AcademiaHorarioSoap[] soapModels = new AcademiaHorarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AcademiaHorarioSoap[][] toSoapModels(
		AcademiaHorario[][] models) {
		AcademiaHorarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AcademiaHorarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AcademiaHorarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AcademiaHorarioSoap[] toSoapModels(
		List<AcademiaHorario> models) {
		List<AcademiaHorarioSoap> soapModels = new ArrayList<AcademiaHorarioSoap>(models.size());

		for (AcademiaHorario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AcademiaHorarioSoap[soapModels.size()]);
	}

	public AcademiaHorarioSoap() {
	}

	public long getPrimaryKey() {
		return _academiaHorarioId;
	}

	public void setPrimaryKey(long pk) {
		setAcademiaHorarioId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAcademiaHorarioId() {
		return _academiaHorarioId;
	}

	public void setAcademiaHorarioId(long academiaHorarioId) {
		_academiaHorarioId = academiaHorarioId;
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

	public int getDiaSemana() {
		return _diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		_diaSemana = diaSemana;
	}

	public String getHoraInicial() {
		return _horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		_horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return _HoraFinal;
	}

	public void setHoraFinal(String HoraFinal) {
		_HoraFinal = HoraFinal;
	}

	public long getAtividadeId() {
		return _atividadeId;
	}

	public void setAtividadeId(long atividadeId) {
		_atividadeId = atividadeId;
	}

	public String getAtividadeNome() {
		return _atividadeNome;
	}

	public void setAtividadeNome(String atividadeNome) {
		_atividadeNome = atividadeNome;
	}

	public double getVersao() {
		return _versao;
	}

	public void setVersao(double versao) {
		_versao = versao;
	}

	private String _uuid;
	private long _academiaHorarioId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private int _diaSemana;
	private String _horaInicial;
	private String _HoraFinal;
	private long _atividadeId;
	private String _atividadeNome;
	private double _versao;
}