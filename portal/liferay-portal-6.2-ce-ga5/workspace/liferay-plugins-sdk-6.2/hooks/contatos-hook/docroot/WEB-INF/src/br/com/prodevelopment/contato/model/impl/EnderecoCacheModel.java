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

import br.com.prodevelopment.contato.model.Endereco;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Endereco in entity cache.
 *
 * @author Marcelo Melo
 * @see Endereco
 * @generated
 */
public class EnderecoCacheModel implements CacheModel<Endereco>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", enderecoId=");
		sb.append(enderecoId);
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
		sb.append(", logradouro=");
		sb.append(logradouro);
		sb.append(", numero=");
		sb.append(numero);
		sb.append(", complemento=");
		sb.append(complemento);
		sb.append(", cep=");
		sb.append(cep);
		sb.append(", bairro=");
		sb.append(bairro);
		sb.append(", cidadeId=");
		sb.append(cidadeId);
		sb.append(", uf=");
		sb.append(uf);
		sb.append(", paisId=");
		sb.append(paisId);
		sb.append(", principal=");
		sb.append(principal);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Endereco toEntityModel() {
		EnderecoImpl enderecoImpl = new EnderecoImpl();

		if (uuid == null) {
			enderecoImpl.setUuid(StringPool.BLANK);
		}
		else {
			enderecoImpl.setUuid(uuid);
		}

		enderecoImpl.setEnderecoId(enderecoId);
		enderecoImpl.setCompanyId(companyId);
		enderecoImpl.setGroupId(groupId);
		enderecoImpl.setCreateUserId(createUserId);
		enderecoImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			enderecoImpl.setCreateDate(null);
		}
		else {
			enderecoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			enderecoImpl.setModifiedDate(null);
		}
		else {
			enderecoImpl.setModifiedDate(new Date(modifiedDate));
		}

		enderecoImpl.setClassNameId(classNameId);
		enderecoImpl.setClassPK(classPK);

		if (logradouro == null) {
			enderecoImpl.setLogradouro(StringPool.BLANK);
		}
		else {
			enderecoImpl.setLogradouro(logradouro);
		}

		if (numero == null) {
			enderecoImpl.setNumero(StringPool.BLANK);
		}
		else {
			enderecoImpl.setNumero(numero);
		}

		if (complemento == null) {
			enderecoImpl.setComplemento(StringPool.BLANK);
		}
		else {
			enderecoImpl.setComplemento(complemento);
		}

		if (cep == null) {
			enderecoImpl.setCep(StringPool.BLANK);
		}
		else {
			enderecoImpl.setCep(cep);
		}

		if (bairro == null) {
			enderecoImpl.setBairro(StringPool.BLANK);
		}
		else {
			enderecoImpl.setBairro(bairro);
		}

		enderecoImpl.setCidadeId(cidadeId);

		if (uf == null) {
			enderecoImpl.setUf(StringPool.BLANK);
		}
		else {
			enderecoImpl.setUf(uf);
		}

		enderecoImpl.setPaisId(paisId);
		enderecoImpl.setPrincipal(principal);
		enderecoImpl.setTipo(tipo);

		enderecoImpl.resetOriginalValues();

		return enderecoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		enderecoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		logradouro = objectInput.readUTF();
		numero = objectInput.readUTF();
		complemento = objectInput.readUTF();
		cep = objectInput.readUTF();
		bairro = objectInput.readUTF();
		cidadeId = objectInput.readLong();
		uf = objectInput.readUTF();
		paisId = objectInput.readLong();
		principal = objectInput.readBoolean();
		tipo = objectInput.readInt();
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

		objectOutput.writeLong(enderecoId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);

		if (logradouro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logradouro);
		}

		if (numero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(numero);
		}

		if (complemento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(complemento);
		}

		if (cep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cep);
		}

		if (bairro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bairro);
		}

		objectOutput.writeLong(cidadeId);

		if (uf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uf);
		}

		objectOutput.writeLong(paisId);
		objectOutput.writeBoolean(principal);
		objectOutput.writeInt(tipo);
	}

	public String uuid;
	public long enderecoId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public String logradouro;
	public String numero;
	public String complemento;
	public String cep;
	public String bairro;
	public long cidadeId;
	public String uf;
	public long paisId;
	public boolean principal;
	public int tipo;
}