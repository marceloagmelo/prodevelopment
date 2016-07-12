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

import br.com.prodevelopment.eticket.model.TypeTicketUsers;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TypeTicketUsers in entity cache.
 *
 * @author Marcelo Melo
 * @see TypeTicketUsers
 * @generated
 */
public class TypeTicketUsersCacheModel implements CacheModel<TypeTicketUsers>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{typeTicketUsersId=");
		sb.append(typeTicketUsersId);
		sb.append(", userIdCreate=");
		sb.append(userIdCreate);
		sb.append(", userIdModified=");
		sb.append(userIdModified);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", typeTicketId=");
		sb.append(typeTicketId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TypeTicketUsers toEntityModel() {
		TypeTicketUsersImpl typeTicketUsersImpl = new TypeTicketUsersImpl();

		typeTicketUsersImpl.setTypeTicketUsersId(typeTicketUsersId);
		typeTicketUsersImpl.setUserIdCreate(userIdCreate);
		typeTicketUsersImpl.setUserIdModified(userIdModified);

		if (createDate == Long.MIN_VALUE) {
			typeTicketUsersImpl.setCreateDate(null);
		}
		else {
			typeTicketUsersImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			typeTicketUsersImpl.setModifiedDate(null);
		}
		else {
			typeTicketUsersImpl.setModifiedDate(new Date(modifiedDate));
		}

		typeTicketUsersImpl.setTypeTicketId(typeTicketId);
		typeTicketUsersImpl.setUserId(userId);

		typeTicketUsersImpl.resetOriginalValues();

		return typeTicketUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeTicketUsersId = objectInput.readLong();
		userIdCreate = objectInput.readLong();
		userIdModified = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		typeTicketId = objectInput.readLong();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(typeTicketUsersId);
		objectOutput.writeLong(userIdCreate);
		objectOutput.writeLong(userIdModified);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(typeTicketId);
		objectOutput.writeLong(userId);
	}

	public long typeTicketUsersId;
	public long userIdCreate;
	public long userIdModified;
	public long createDate;
	public long modifiedDate;
	public long typeTicketId;
	public long userId;
}