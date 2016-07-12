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

package br.com.prodevelopment.atividade.model.impl;

import br.com.prodevelopment.atividade.model.Atividade;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Atividade in entity cache.
 *
 * @author Marcelo
 * @see Atividade
 * @generated
 */
public class AtividadeCacheModel implements CacheModel<Atividade>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", atividadeId=");
		sb.append(atividadeId);
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
		sb.append(", descricao=");
		sb.append(descricao);
		sb.append(", imagemId=");
		sb.append(imagemId);
		sb.append(", existeImagem=");
		sb.append(existeImagem);
		sb.append(", versao=");
		sb.append(versao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Atividade toEntityModel() {
		AtividadeImpl atividadeImpl = new AtividadeImpl();

		if (uuid == null) {
			atividadeImpl.setUuid(StringPool.BLANK);
		}
		else {
			atividadeImpl.setUuid(uuid);
		}

		atividadeImpl.setAtividadeId(atividadeId);
		atividadeImpl.setCompanyId(companyId);
		atividadeImpl.setGroupId(groupId);
		atividadeImpl.setCreateUserId(createUserId);
		atividadeImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			atividadeImpl.setCreateDate(null);
		}
		else {
			atividadeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			atividadeImpl.setModifiedDate(null);
		}
		else {
			atividadeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			atividadeImpl.setNome(StringPool.BLANK);
		}
		else {
			atividadeImpl.setNome(nome);
		}

		if (descricao == null) {
			atividadeImpl.setDescricao(StringPool.BLANK);
		}
		else {
			atividadeImpl.setDescricao(descricao);
		}

		atividadeImpl.setImagemId(imagemId);
		atividadeImpl.setExisteImagem(existeImagem);
		atividadeImpl.setVersao(versao);

		atividadeImpl.resetOriginalValues();

		return atividadeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		atividadeId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		descricao = objectInput.readUTF();
		imagemId = objectInput.readLong();
		existeImagem = objectInput.readBoolean();
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

		objectOutput.writeLong(atividadeId);
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

		if (descricao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descricao);
		}

		objectOutput.writeLong(imagemId);
		objectOutput.writeBoolean(existeImagem);
		objectOutput.writeDouble(versao);
	}

	public String uuid;
	public long atividadeId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String descricao;
	public long imagemId;
	public boolean existeImagem;
	public double versao;
}