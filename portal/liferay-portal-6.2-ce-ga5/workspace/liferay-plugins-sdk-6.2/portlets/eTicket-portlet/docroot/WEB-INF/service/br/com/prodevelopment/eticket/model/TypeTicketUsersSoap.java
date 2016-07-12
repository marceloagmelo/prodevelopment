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
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.eticket.service.http.TypeTicketUsersServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.eticket.service.http.TypeTicketUsersServiceSoap
 * @generated
 */
public class TypeTicketUsersSoap implements Serializable {
	public static TypeTicketUsersSoap toSoapModel(TypeTicketUsers model) {
		TypeTicketUsersSoap soapModel = new TypeTicketUsersSoap();

		soapModel.setTypeTicketUsersId(model.getTypeTicketUsersId());
		soapModel.setUserIdCreate(model.getUserIdCreate());
		soapModel.setUserIdModified(model.getUserIdModified());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTypeTicketId(model.getTypeTicketId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static TypeTicketUsersSoap[] toSoapModels(TypeTicketUsers[] models) {
		TypeTicketUsersSoap[] soapModels = new TypeTicketUsersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TypeTicketUsersSoap[][] toSoapModels(
		TypeTicketUsers[][] models) {
		TypeTicketUsersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TypeTicketUsersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TypeTicketUsersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TypeTicketUsersSoap[] toSoapModels(
		List<TypeTicketUsers> models) {
		List<TypeTicketUsersSoap> soapModels = new ArrayList<TypeTicketUsersSoap>(models.size());

		for (TypeTicketUsers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TypeTicketUsersSoap[soapModels.size()]);
	}

	public TypeTicketUsersSoap() {
	}

	public long getPrimaryKey() {
		return _typeTicketUsersId;
	}

	public void setPrimaryKey(long pk) {
		setTypeTicketUsersId(pk);
	}

	public long getTypeTicketUsersId() {
		return _typeTicketUsersId;
	}

	public void setTypeTicketUsersId(long typeTicketUsersId) {
		_typeTicketUsersId = typeTicketUsersId;
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

	public long getTypeTicketId() {
		return _typeTicketId;
	}

	public void setTypeTicketId(long typeTicketId) {
		_typeTicketId = typeTicketId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _typeTicketUsersId;
	private long _userIdCreate;
	private long _userIdModified;
	private Date _createDate;
	private Date _modifiedDate;
	private long _typeTicketId;
	private long _userId;
}