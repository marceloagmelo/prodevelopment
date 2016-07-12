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
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.etask.service.http.TypeTaskServiceSoap}.
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.etask.service.http.TypeTaskServiceSoap
 * @generated
 */
public class TypeTaskSoap implements Serializable {
	public static TypeTaskSoap toSoapModel(TypeTask model) {
		TypeTaskSoap soapModel = new TypeTaskSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTypeTaskId(model.getTypeTaskId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserIdCreate(model.getUserIdCreate());
		soapModel.setUserIdModified(model.getUserIdModified());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setDDMStructureId(model.getDDMStructureId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCustomFieldsActive(model.getCustomFieldsActive());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());

		return soapModel;
	}

	public static TypeTaskSoap[] toSoapModels(TypeTask[] models) {
		TypeTaskSoap[] soapModels = new TypeTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TypeTaskSoap[][] toSoapModels(TypeTask[][] models) {
		TypeTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TypeTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TypeTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TypeTaskSoap[] toSoapModels(List<TypeTask> models) {
		List<TypeTaskSoap> soapModels = new ArrayList<TypeTaskSoap>(models.size());

		for (TypeTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TypeTaskSoap[soapModels.size()]);
	}

	public TypeTaskSoap() {
	}

	public long getPrimaryKey() {
		return _typeTaskId;
	}

	public void setPrimaryKey(long pk) {
		setTypeTaskId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTypeTaskId() {
		return _typeTaskId;
	}

	public void setTypeTaskId(long typeTaskId) {
		_typeTaskId = typeTaskId;
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

	public long getDDMStructureId() {
		return _DDMStructureId;
	}

	public void setDDMStructureId(long DDMStructureId) {
		_DDMStructureId = DDMStructureId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public boolean getCustomFieldsActive() {
		return _customFieldsActive;
	}

	public boolean isCustomFieldsActive() {
		return _customFieldsActive;
	}

	public void setCustomFieldsActive(boolean customFieldsActive) {
		_customFieldsActive = customFieldsActive;
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

	private String _uuid;
	private long _typeTaskId;
	private long _groupId;
	private long _companyId;
	private long _userIdCreate;
	private long _userIdModified;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private long _DDMStructureId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private boolean _customFieldsActive;
	private long _classNameId;
	private long _classPK;
}