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

package br.com.prodevelopment.academiahorario.model.impl;

import br.com.prodevelopment.academiahorario.model.AcademiaHorario;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AcademiaHorario in entity cache.
 *
 * @author Marcelo
 * @see AcademiaHorario
 * @generated
 */
public class AcademiaHorarioCacheModel implements CacheModel<AcademiaHorario>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", academiaHorarioId=");
		sb.append(academiaHorarioId);
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
		sb.append(", diaSemana=");
		sb.append(diaSemana);
		sb.append(", horaInicial=");
		sb.append(horaInicial);
		sb.append(", HoraFinal=");
		sb.append(HoraFinal);
		sb.append(", atividadeId=");
		sb.append(atividadeId);
		sb.append(", atividadeNome=");
		sb.append(atividadeNome);
		sb.append(", versao=");
		sb.append(versao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AcademiaHorario toEntityModel() {
		AcademiaHorarioImpl academiaHorarioImpl = new AcademiaHorarioImpl();

		if (uuid == null) {
			academiaHorarioImpl.setUuid(StringPool.BLANK);
		}
		else {
			academiaHorarioImpl.setUuid(uuid);
		}

		academiaHorarioImpl.setAcademiaHorarioId(academiaHorarioId);
		academiaHorarioImpl.setCompanyId(companyId);
		academiaHorarioImpl.setGroupId(groupId);
		academiaHorarioImpl.setCreateUserId(createUserId);
		academiaHorarioImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			academiaHorarioImpl.setCreateDate(null);
		}
		else {
			academiaHorarioImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			academiaHorarioImpl.setModifiedDate(null);
		}
		else {
			academiaHorarioImpl.setModifiedDate(new Date(modifiedDate));
		}

		academiaHorarioImpl.setDiaSemana(diaSemana);

		if (horaInicial == null) {
			academiaHorarioImpl.setHoraInicial(StringPool.BLANK);
		}
		else {
			academiaHorarioImpl.setHoraInicial(horaInicial);
		}

		if (HoraFinal == null) {
			academiaHorarioImpl.setHoraFinal(StringPool.BLANK);
		}
		else {
			academiaHorarioImpl.setHoraFinal(HoraFinal);
		}

		academiaHorarioImpl.setAtividadeId(atividadeId);

		if (atividadeNome == null) {
			academiaHorarioImpl.setAtividadeNome(StringPool.BLANK);
		}
		else {
			academiaHorarioImpl.setAtividadeNome(atividadeNome);
		}

		academiaHorarioImpl.setVersao(versao);

		academiaHorarioImpl.resetOriginalValues();

		return academiaHorarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		academiaHorarioId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		diaSemana = objectInput.readInt();
		horaInicial = objectInput.readUTF();
		HoraFinal = objectInput.readUTF();
		atividadeId = objectInput.readLong();
		atividadeNome = objectInput.readUTF();
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

		objectOutput.writeLong(academiaHorarioId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(diaSemana);

		if (horaInicial == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(horaInicial);
		}

		if (HoraFinal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(HoraFinal);
		}

		objectOutput.writeLong(atividadeId);

		if (atividadeNome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(atividadeNome);
		}

		objectOutput.writeDouble(versao);
	}

	public String uuid;
	public long academiaHorarioId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public int diaSemana;
	public String horaInicial;
	public String HoraFinal;
	public long atividadeId;
	public String atividadeNome;
	public double versao;
}