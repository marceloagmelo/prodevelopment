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

import br.com.prodevelopment.contato.model.Contato;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Contato in entity cache.
 *
 * @author Marcelo Melo
 * @see Contato
 * @generated
 */
public class ContatoCacheModel implements CacheModel<Contato>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{contatoId=");
		sb.append(contatoId);
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
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", endEmail=");
		sb.append(endEmail);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", sexo=");
		sb.append(sexo);
		sb.append(", dataNascimento=");
		sb.append(dataNascimento);
		sb.append(", cargoId=");
		sb.append(cargoId);
		sb.append(", skype=");
		sb.append(skype);
		sb.append(", facebook=");
		sb.append(facebook);
		sb.append(", twitter=");
		sb.append(twitter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contato toEntityModel() {
		ContatoImpl contatoImpl = new ContatoImpl();

		contatoImpl.setContatoId(contatoId);
		contatoImpl.setCompanyId(companyId);
		contatoImpl.setGroupId(groupId);
		contatoImpl.setCreateUserId(createUserId);
		contatoImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			contatoImpl.setCreateDate(null);
		}
		else {
			contatoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contatoImpl.setModifiedDate(null);
		}
		else {
			contatoImpl.setModifiedDate(new Date(modifiedDate));
		}

		contatoImpl.setClassNameId(classNameId);
		contatoImpl.setClassPK(classPK);
		contatoImpl.setAccountId(accountId);

		if (endEmail == null) {
			contatoImpl.setEndEmail(StringPool.BLANK);
		}
		else {
			contatoImpl.setEndEmail(endEmail);
		}

		if (nome == null) {
			contatoImpl.setNome(StringPool.BLANK);
		}
		else {
			contatoImpl.setNome(nome);
		}

		if (sexo == null) {
			contatoImpl.setSexo(StringPool.BLANK);
		}
		else {
			contatoImpl.setSexo(sexo);
		}

		if (dataNascimento == Long.MIN_VALUE) {
			contatoImpl.setDataNascimento(null);
		}
		else {
			contatoImpl.setDataNascimento(new Date(dataNascimento));
		}

		contatoImpl.setCargoId(cargoId);

		if (skype == null) {
			contatoImpl.setSkype(StringPool.BLANK);
		}
		else {
			contatoImpl.setSkype(skype);
		}

		if (facebook == null) {
			contatoImpl.setFacebook(StringPool.BLANK);
		}
		else {
			contatoImpl.setFacebook(facebook);
		}

		if (twitter == null) {
			contatoImpl.setTwitter(StringPool.BLANK);
		}
		else {
			contatoImpl.setTwitter(twitter);
		}

		contatoImpl.resetOriginalValues();

		return contatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contatoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		accountId = objectInput.readLong();
		endEmail = objectInput.readUTF();
		nome = objectInput.readUTF();
		sexo = objectInput.readUTF();
		dataNascimento = objectInput.readLong();
		cargoId = objectInput.readLong();
		skype = objectInput.readUTF();
		facebook = objectInput.readUTF();
		twitter = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contatoId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);
		objectOutput.writeLong(accountId);

		if (endEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endEmail);
		}

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (sexo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sexo);
		}

		objectOutput.writeLong(dataNascimento);
		objectOutput.writeLong(cargoId);

		if (skype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(skype);
		}

		if (facebook == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(facebook);
		}

		if (twitter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(twitter);
		}
	}

	public long contatoId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public long accountId;
	public String endEmail;
	public String nome;
	public String sexo;
	public long dataNascimento;
	public long cargoId;
	public String skype;
	public String facebook;
	public String twitter;
}