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

package br.com.prodevelopment.funcionario.model.impl;

import br.com.prodevelopment.funcionario.model.Cargo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Cargo in entity cache.
 *
 * @author Marcelo Melo
 * @see Cargo
 * @generated
 */
public class CargoCacheModel implements CacheModel<Cargo>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", cargoId=");
		sb.append(cargoId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", versao=");
		sb.append(versao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cargo toEntityModel() {
		CargoImpl cargoImpl = new CargoImpl();

		if (uuid == null) {
			cargoImpl.setUuid(StringPool.BLANK);
		}
		else {
			cargoImpl.setUuid(uuid);
		}

		cargoImpl.setCargoId(cargoId);
		cargoImpl.setCompanyId(companyId);
		cargoImpl.setGroupId(groupId);
		cargoImpl.setCreateUserId(createUserId);
		cargoImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			cargoImpl.setCreateDate(null);
		}
		else {
			cargoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cargoImpl.setModifiedDate(null);
		}
		else {
			cargoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			cargoImpl.setNome(StringPool.BLANK);
		}
		else {
			cargoImpl.setNome(nome);
		}

		cargoImpl.setVersao(versao);

		cargoImpl.resetOriginalValues();

		return cargoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		cargoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		versao = objectInput.readDouble();
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

		objectOutput.writeLong(cargoId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
		}

		objectOutput.writeDouble(versao);
	}

	public String uuid;
	public long cargoId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public double versao;
}