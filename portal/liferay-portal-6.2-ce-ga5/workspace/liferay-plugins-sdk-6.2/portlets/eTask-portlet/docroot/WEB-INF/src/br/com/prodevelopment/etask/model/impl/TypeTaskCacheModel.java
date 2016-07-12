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

package br.com.prodevelopment.etask.model.impl;

import br.com.prodevelopment.etask.model.TypeTask;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TypeTask in entity cache.
 *
 * @author Marcelo Melo
 * @see TypeTask
 * @generated
 */
public class TypeTaskCacheModel implements CacheModel<TypeTask>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", typeTaskId=");
		sb.append(typeTaskId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userIdCreate=");
		sb.append(userIdCreate);
		sb.append(", userIdModified=");
		sb.append(userIdModified);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", DDMStructureId=");
		sb.append(DDMStructureId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", customFieldsActive=");
		sb.append(customFieldsActive);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TypeTask toEntityModel() {
		TypeTaskImpl typeTaskImpl = new TypeTaskImpl();

		if (uuid == null) {
			typeTaskImpl.setUuid(StringPool.BLANK);
		}
		else {
			typeTaskImpl.setUuid(uuid);
		}

		typeTaskImpl.setTypeTaskId(typeTaskId);
		typeTaskImpl.setGroupId(groupId);
		typeTaskImpl.setCompanyId(companyId);
		typeTaskImpl.setUserIdCreate(userIdCreate);
		typeTaskImpl.setUserIdModified(userIdModified);

		if (createDate == Long.MIN_VALUE) {
			typeTaskImpl.setCreateDate(null);
		}
		else {
			typeTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			typeTaskImpl.setModifiedDate(null);
		}
		else {
			typeTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			typeTaskImpl.setName(StringPool.BLANK);
		}
		else {
			typeTaskImpl.setName(name);
		}

		if (description == null) {
			typeTaskImpl.setDescription(StringPool.BLANK);
		}
		else {
			typeTaskImpl.setDescription(description);
		}

		typeTaskImpl.setDDMStructureId(DDMStructureId);
		typeTaskImpl.setStatus(status);
		typeTaskImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			typeTaskImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			typeTaskImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			typeTaskImpl.setStatusDate(null);
		}
		else {
			typeTaskImpl.setStatusDate(new Date(statusDate));
		}

		typeTaskImpl.setCustomFieldsActive(customFieldsActive);
		typeTaskImpl.setClassNameId(classNameId);
		typeTaskImpl.setClassPK(classPK);

		typeTaskImpl.resetOriginalValues();

		return typeTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		typeTaskId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userIdCreate = objectInput.readLong();
		userIdModified = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		DDMStructureId = objectInput.readLong();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		customFieldsActive = objectInput.readBoolean();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(typeTaskId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userIdCreate);
		objectOutput.writeLong(userIdModified);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(DDMStructureId);
		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeBoolean(customFieldsActive);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);
	}

	public String uuid;
	public long typeTaskId;
	public long groupId;
	public long companyId;
	public long userIdCreate;
	public long userIdModified;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public long DDMStructureId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public boolean customFieldsActive;
	public long classNameId;
	public long classPK;
}