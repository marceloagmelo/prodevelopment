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

package br.com.prodevelopment.etask.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.etask.service.http.TypeTaskUsersServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.etask.service.http.TypeTaskUsersServiceSoap
 * @generated
 */
public class TypeTaskUsersSoap implements Serializable {
	public static TypeTaskUsersSoap toSoapModel(TypeTaskUsers model) {
		TypeTaskUsersSoap soapModel = new TypeTaskUsersSoap();

		soapModel.setTypeTaskUsersId(model.getTypeTaskUsersId());
		soapModel.setUserIdCreate(model.getUserIdCreate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setTypeTaskId(model.getTypeTaskId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTypeUser(model.getTypeUser());

		return soapModel;
	}

	public static TypeTaskUsersSoap[] toSoapModels(TypeTaskUsers[] models) {
		TypeTaskUsersSoap[] soapModels = new TypeTaskUsersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TypeTaskUsersSoap[][] toSoapModels(TypeTaskUsers[][] models) {
		TypeTaskUsersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TypeTaskUsersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TypeTaskUsersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TypeTaskUsersSoap[] toSoapModels(List<TypeTaskUsers> models) {
		List<TypeTaskUsersSoap> soapModels = new ArrayList<TypeTaskUsersSoap>(models.size());

		for (TypeTaskUsers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TypeTaskUsersSoap[soapModels.size()]);
	}

	public TypeTaskUsersSoap() {
	}

	public long getPrimaryKey() {
		return _typeTaskUsersId;
	}

	public void setPrimaryKey(long pk) {
		setTypeTaskUsersId(pk);
	}

	public long getTypeTaskUsersId() {
		return _typeTaskUsersId;
	}

	public void setTypeTaskUsersId(long typeTaskUsersId) {
		_typeTaskUsersId = typeTaskUsersId;
	}

	public long getUserIdCreate() {
		return _userIdCreate;
	}

	public void setUserIdCreate(long userIdCreate) {
		_userIdCreate = userIdCreate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getTypeTaskId() {
		return _typeTaskId;
	}

	public void setTypeTaskId(long typeTaskId) {
		_typeTaskId = typeTaskId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getTypeUser() {
		return _typeUser;
	}

	public void setTypeUser(String typeUser) {
		_typeUser = typeUser;
	}

	private long _typeTaskUsersId;
	private long _userIdCreate;
	private Date _createDate;
	private long _typeTaskId;
	private long _userId;
	private String _typeUser;
}