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

package br.com.prodevelopment.contato.model.impl;

import br.com.prodevelopment.contato.model.EnderecoEmail;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EnderecoEmail in entity cache.
 *
 * @author Marcelo Melo
 * @see EnderecoEmail
 * @generated
 */
public class EnderecoEmailCacheModel implements CacheModel<EnderecoEmail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", enderecoEmailId=");
		sb.append(enderecoEmailId);
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
		sb.append(", endereco=");
		sb.append(endereco);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", principal=");
		sb.append(principal);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EnderecoEmail toEntityModel() {
		EnderecoEmailImpl enderecoEmailImpl = new EnderecoEmailImpl();

		if (uuid == null) {
			enderecoEmailImpl.setUuid(StringPool.BLANK);
		}
		else {
			enderecoEmailImpl.setUuid(uuid);
		}

		enderecoEmailImpl.setEnderecoEmailId(enderecoEmailId);
		enderecoEmailImpl.setCompanyId(companyId);
		enderecoEmailImpl.setGroupId(groupId);
		enderecoEmailImpl.setCreateUserId(createUserId);
		enderecoEmailImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			enderecoEmailImpl.setCreateDate(null);
		}
		else {
			enderecoEmailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			enderecoEmailImpl.setModifiedDate(null);
		}
		else {
			enderecoEmailImpl.setModifiedDate(new Date(modifiedDate));
		}

		enderecoEmailImpl.setClassNameId(classNameId);
		enderecoEmailImpl.setClassPK(classPK);

		if (endereco == null) {
			enderecoEmailImpl.setEndereco(StringPool.BLANK);
		}
		else {
			enderecoEmailImpl.setEndereco(endereco);
		}

		enderecoEmailImpl.setTipo(tipo);
		enderecoEmailImpl.setPrincipal(principal);

		enderecoEmailImpl.resetOriginalValues();

		return enderecoEmailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		enderecoEmailId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		endereco = objectInput.readUTF();
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

		objectOutput.writeLong(enderecoEmailId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);

		if (endereco == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endereco);
		}

		objectOutput.writeInt(tipo);
		objectOutput.writeBoolean(principal);
	}

	public String uuid;
	public long enderecoEmailId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public String endereco;
	public int tipo;
	public boolean principal;
}