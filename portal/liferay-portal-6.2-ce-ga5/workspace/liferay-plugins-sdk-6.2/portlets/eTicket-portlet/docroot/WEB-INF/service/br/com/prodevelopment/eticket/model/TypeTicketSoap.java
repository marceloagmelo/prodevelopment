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

package br.com.prodevelopment.eticket.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.eticket.service.http.TypeTicketServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.eticket.service.http.TypeTicketServiceSoap
 * @generated
 */
public class TypeTicketSoap implements Serializable {
	public static TypeTicketSoap toSoapModel(TypeTicket model) {
		TypeTicketSoap soapModel = new TypeTicketSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTypeTicketId(model.getTypeTicketId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserIdCreate(model.getUserIdCreate());
		soapModel.setUserIdModified(model.getUserIdModified());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setXsd(model.getXsd());

		return soapModel;
	}

	public static TypeTicketSoap[] toSoapModels(TypeTicket[] models) {
		TypeTicketSoap[] soapModels = new TypeTicketSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TypeTicketSoap[][] toSoapModels(TypeTicket[][] models) {
		TypeTicketSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TypeTicketSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TypeTicketSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TypeTicketSoap[] toSoapModels(List<TypeTicket> models) {
		List<TypeTicketSoap> soapModels = new ArrayList<TypeTicketSoap>(models.size());

		for (TypeTicket model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TypeTicketSoap[soapModels.size()]);
	}

	public TypeTicketSoap() {
	}

	public long getPrimaryKey() {
		return _typeTicketId;
	}

	public void setPrimaryKey(long pk) {
		setTypeTicketId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTypeTicketId() {
		return _typeTicketId;
	}

	public void setTypeTicketId(long typeTicketId) {
		_typeTicketId = typeTicketId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserIdCreate() {
		return _userIdCreate;
	}

	public void setUserIdCreate(long userIdCreate) {
		_userIdCreate = userIdCreate;
	}

	public long getUserIdModified() {
		return _userIdModified;
	}

	public void setUserIdModified(long userIdModified) {
		_userIdModified = userIdModified;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getXsd() {
		return _xsd;
	}

	public void setXsd(String xsd) {
		_xsd = xsd;
	}

	private String _uuid;
	private long _typeTicketId;
	private long _groupId;
	private long _companyId;
	private long _userIdCreate;
	private long _userIdModified;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _xsd;
}