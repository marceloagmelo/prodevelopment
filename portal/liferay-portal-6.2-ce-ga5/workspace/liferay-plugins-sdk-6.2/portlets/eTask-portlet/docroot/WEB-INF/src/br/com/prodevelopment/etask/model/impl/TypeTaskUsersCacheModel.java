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

import br.com.prodevelopment.etask.model.TypeTaskUsers;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TypeTaskUsers in entity cache.
 *
 * @author Marcelo Melo
 * @see TypeTaskUsers
 * @generated
 */
public class TypeTaskUsersCacheModel implements CacheModel<TypeTaskUsers>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{typeTaskUsersId=");
		sb.append(typeTaskUsersId);
		sb.append(", userIdCreate=");
		sb.append(userIdCreate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", typeTaskId=");
		sb.append(typeTaskId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", typeUser=");
		sb.append(typeUser);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TypeTaskUsers toEntityModel() {
		TypeTaskUsersImpl typeTaskUsersImpl = new TypeTaskUsersImpl();

		typeTaskUsersImpl.setTypeTaskUsersId(typeTaskUsersId);
		typeTaskUsersImpl.setUserIdCreate(userIdCreate);

		if (createDate == Long.MIN_VALUE) {
			typeTaskUsersImpl.setCreateDate(null);
		}
		else {
			typeTaskUsersImpl.setCreateDate(new Date(createDate));
		}

		typeTaskUsersImpl.setTypeTaskId(typeTaskId);
		typeTaskUsersImpl.setUserId(userId);

		if (typeUser == null) {
			typeTaskUsersImpl.setTypeUser(StringPool.BLANK);
		}
		else {
			typeTaskUsersImpl.setTypeUser(typeUser);
		}

		typeTaskUsersImpl.resetOriginalValues();

		return typeTaskUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeTaskUsersId = objectInput.readLong();
		userIdCreate = objectInput.readLong();
		createDate = objectInput.readLong();
		typeTaskId = objectInput.readLong();
		userId = objectInput.readLong();
		typeUser = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(typeTaskUsersId);
		objectOutput.writeLong(userIdCreate);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(typeTaskId);
		objectOutput.writeLong(userId);

		if (typeUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeUser);
		}
	}

	public long typeTaskUsersId;
	public long userIdCreate;
	public long createDate;
	public long typeTaskId;
	public long userId;
	public String typeUser;
}