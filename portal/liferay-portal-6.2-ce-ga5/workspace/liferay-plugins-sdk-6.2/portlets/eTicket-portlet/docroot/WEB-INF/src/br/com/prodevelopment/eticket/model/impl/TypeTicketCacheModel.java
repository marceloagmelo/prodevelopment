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

package br.com.prodevelopment.eticket.model.impl;

import br.com.prodevelopment.eticket.model.TypeTicket;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TypeTicket in entity cache.
 *
 * @author Marcelo Melo
 * @see TypeTicket
 * @generated
 */
public class TypeTicketCacheModel implements CacheModel<TypeTicket>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", typeTicketId=");
		sb.append(typeTicketId);
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
		sb.append(", xsd=");
		sb.append(xsd);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TypeTicket toEntityModel() {
		TypeTicketImpl typeTicketImpl = new TypeTicketImpl();

		if (uuid == null) {
			typeTicketImpl.setUuid(StringPool.BLANK);
		}
		else {
			typeTicketImpl.setUuid(uuid);
		}

		typeTicketImpl.setTypeTicketId(typeTicketId);
		typeTicketImpl.setGroupId(groupId);
		typeTicketImpl.setCompanyId(companyId);
		typeTicketImpl.setUserIdCreate(userIdCreate);
		typeTicketImpl.setUserIdModified(userIdModified);

		if (createDate == Long.MIN_VALUE) {
			typeTicketImpl.setCreateDate(null);
		}
		else {
			typeTicketImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			typeTicketImpl.setModifiedDate(null);
		}
		else {
			typeTicketImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			typeTicketImpl.setName(StringPool.BLANK);
		}
		else {
			typeTicketImpl.setName(name);
		}

		if (description == null) {
			typeTicketImpl.setDescription(StringPool.BLANK);
		}
		else {
			typeTicketImpl.setDescription(description);
		}

		if (xsd == null) {
			typeTicketImpl.setXsd(StringPool.BLANK);
		}
		else {
			typeTicketImpl.setXsd(xsd);
		}

		typeTicketImpl.resetOriginalValues();

		return typeTicketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		typeTicketId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userIdCreate = objectInput.readLong();
		userIdModified = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		xsd = objectInput.readUTF();
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

		objectOutput.writeLong(typeTicketId);
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

		if (xsd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xsd);
		}
	}

	public String uuid;
	public long typeTicketId;
	public long groupId;
	public long companyId;
	public long userIdCreate;
	public long userIdModified;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String xsd;
}