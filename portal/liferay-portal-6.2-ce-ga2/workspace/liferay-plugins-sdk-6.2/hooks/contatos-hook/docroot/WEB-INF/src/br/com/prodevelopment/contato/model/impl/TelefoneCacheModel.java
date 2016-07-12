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

package br.com.prodevelopment.contato.model.impl;

import br.com.prodevelopment.contato.model.Telefone;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Telefone in entity cache.
 *
 * @author marcelo
 * @see Telefone
 * @generated
 */
public class TelefoneCacheModel implements CacheModel<Telefone>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", telefoneId=");
		sb.append(telefoneId);
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
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", ddi=");
		sb.append(ddi);
		sb.append(", ddd=");
		sb.append(ddd);
		sb.append(", numero=");
		sb.append(numero);
		sb.append(", ramal=");
		sb.append(ramal);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", principal=");
		sb.append(principal);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Telefone toEntityModel() {
		TelefoneImpl telefoneImpl = new TelefoneImpl();

		if (uuid == null) {
			telefoneImpl.setUuid(StringPool.BLANK);
		}
		else {
			telefoneImpl.setUuid(uuid);
		}

		telefoneImpl.setTelefoneId(telefoneId);
		telefoneImpl.setCompanyId(companyId);
		telefoneImpl.setGroupId(groupId);
		telefoneImpl.setCreateUserId(createUserId);
		telefoneImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			telefoneImpl.setCreateDate(null);
		}
		else {
			telefoneImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			telefoneImpl.setModifiedDate(null);
		}
		else {
			telefoneImpl.setModifiedDate(new Date(modifiedDate));
		}

		telefoneImpl.setClassNameId(classNameId);
		telefoneImpl.setClassPK(classPK);

		if (ddi == null) {
			telefoneImpl.setDdi(StringPool.BLANK);
		}
		else {
			telefoneImpl.setDdi(ddi);
		}

		if (ddd == null) {
			telefoneImpl.setDdd(StringPool.BLANK);
		}
		else {
			telefoneImpl.setDdd(ddd);
		}

		if (numero == null) {
			telefoneImpl.setNumero(StringPool.BLANK);
		}
		else {
			telefoneImpl.setNumero(numero);
		}

		if (ramal == null) {
			telefoneImpl.setRamal(StringPool.BLANK);
		}
		else {
			telefoneImpl.setRamal(ramal);
		}

		telefoneImpl.setTipo(tipo);
		telefoneImpl.setPrincipal(principal);

		telefoneImpl.resetOriginalValues();

		return telefoneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		telefoneId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		ddi = objectInput.readUTF();
		ddd = objectInput.readUTF();
		numero = objectInput.readUTF();
		ramal = objectInput.readUTF();
		tipo = objectInput.readInt();
		principal = objectInput.readBoolean();
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

		objectOutput.writeLong(telefoneId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);

		if (ddi == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ddi);
		}

		if (ddd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ddd);
		}

		if (numero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(numero);
		}

		if (ramal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ramal);
		}

		objectOutput.writeInt(tipo);
		objectOutput.writeBoolean(principal);
	}

	public String uuid;
	public long telefoneId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public String ddi;
	public String ddd;
	public String numero;
	public String ramal;
	public int tipo;
	public boolean principal;
}