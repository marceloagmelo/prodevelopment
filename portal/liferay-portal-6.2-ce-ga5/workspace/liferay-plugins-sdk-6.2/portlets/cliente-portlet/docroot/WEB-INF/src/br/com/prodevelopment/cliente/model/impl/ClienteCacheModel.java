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

package br.com.prodevelopment.cliente.model.impl;

import br.com.prodevelopment.cliente.model.Cliente;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Cliente in entity cache.
 *
 * @author marcelo
 * @see Cliente
 * @generated
 */
public class ClienteCacheModel implements CacheModel<Cliente>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", clienteId=");
		sb.append(clienteId);
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
		sb.append(", rgInscricaoMun=");
		sb.append(rgInscricaoMun);
		sb.append(", rgOrgaoEmissor=");
		sb.append(rgOrgaoEmissor);
		sb.append(", rgDataEmissao=");
		sb.append(rgDataEmissao);
		sb.append(", tipoPessoa=");
		sb.append(tipoPessoa);
		sb.append(", cpfCnpj=");
		sb.append(cpfCnpj);
		sb.append(", sexo=");
		sb.append(sexo);
		sb.append(", estadoCivil=");
		sb.append(estadoCivil);
		sb.append(", dataNascimento=");
		sb.append(dataNascimento);
		sb.append(", endComLogradouro=");
		sb.append(endComLogradouro);
		sb.append(", endComNumero=");
		sb.append(endComNumero);
		sb.append(", endComComplemento=");
		sb.append(endComComplemento);
		sb.append(", endComCep=");
		sb.append(endComCep);
		sb.append(", endComBairro=");
		sb.append(endComBairro);
		sb.append(", endComCidade=");
		sb.append(endComCidade);
		sb.append(", endComUf=");
		sb.append(endComUf);
		sb.append(", endComPais=");
		sb.append(endComPais);
		sb.append(", endResLogradouro=");
		sb.append(endResLogradouro);
		sb.append(", endResNumero=");
		sb.append(endResNumero);
		sb.append(", endResComplemento=");
		sb.append(endResComplemento);
		sb.append(", endResCep=");
		sb.append(endResCep);
		sb.append(", endResBairro=");
		sb.append(endResBairro);
		sb.append(", endResCidade=");
		sb.append(endResCidade);
		sb.append(", endResUf=");
		sb.append(endResUf);
		sb.append(", endResPais=");
		sb.append(endResPais);
		sb.append(", telComDdd=");
		sb.append(telComDdd);
		sb.append(", versao=");
		sb.append(versao);
		sb.append(", logoTipoId=");
		sb.append(logoTipoId);
		sb.append(", observacao=");
		sb.append(observacao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cliente toEntityModel() {
		ClienteImpl clienteImpl = new ClienteImpl();

		if (uuid == null) {
			clienteImpl.setUuid(StringPool.BLANK);
		}
		else {
			clienteImpl.setUuid(uuid);
		}

		clienteImpl.setClienteId(clienteId);
		clienteImpl.setCompanyId(companyId);
		clienteImpl.setGroupId(groupId);
		clienteImpl.setCreateUserId(createUserId);
		clienteImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			clienteImpl.setCreateDate(null);
		}
		else {
			clienteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			clienteImpl.setModifiedDate(null);
		}
		else {
			clienteImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			clienteImpl.setNome(StringPool.BLANK);
		}
		else {
			clienteImpl.setNome(nome);
		}

		if (rgInscricaoMun == null) {
			clienteImpl.setRgInscricaoMun(StringPool.BLANK);
		}
		else {
			clienteImpl.setRgInscricaoMun(rgInscricaoMun);
		}

		if (rgOrgaoEmissor == null) {
			clienteImpl.setRgOrgaoEmissor(StringPool.BLANK);
		}
		else {
			clienteImpl.setRgOrgaoEmissor(rgOrgaoEmissor);
		}

		if (rgDataEmissao == Long.MIN_VALUE) {
			clienteImpl.setRgDataEmissao(null);
		}
		else {
			clienteImpl.setRgDataEmissao(new Date(rgDataEmissao));
		}

		if (tipoPessoa == null) {
			clienteImpl.setTipoPessoa(StringPool.BLANK);
		}
		else {
			clienteImpl.setTipoPessoa(tipoPessoa);
		}

		if (cpfCnpj == null) {
			clienteImpl.setCpfCnpj(StringPool.BLANK);
		}
		else {
			clienteImpl.setCpfCnpj(cpfCnpj);
		}

		if (sexo == null) {
			clienteImpl.setSexo(StringPool.BLANK);
		}
		else {
			clienteImpl.setSexo(sexo);
		}

		if (estadoCivil == null) {
			clienteImpl.setEstadoCivil(StringPool.BLANK);
		}
		else {
			clienteImpl.setEstadoCivil(estadoCivil);
		}

		if (dataNascimento == Long.MIN_VALUE) {
			clienteImpl.setDataNascimento(null);
		}
		else {
			clienteImpl.setDataNascimento(new Date(dataNascimento));
		}

		if (endComLogradouro == null) {
			clienteImpl.setEndComLogradouro(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndComLogradouro(endComLogradouro);
		}

		if (endComNumero == null) {
			clienteImpl.setEndComNumero(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndComNumero(endComNumero);
		}

		if (endComComplemento == null) {
			clienteImpl.setEndComComplemento(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndComComplemento(endComComplemento);
		}

		if (endComCep == null) {
			clienteImpl.setEndComCep(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndComCep(endComCep);
		}

		if (endComBairro == null) {
			clienteImpl.setEndComBairro(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndComBairro(endComBairro);
		}

		clienteImpl.setEndComCidade(endComCidade);

		if (endComUf == null) {
			clienteImpl.setEndComUf(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndComUf(endComUf);
		}

		if (endComPais == null) {
			clienteImpl.setEndComPais(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndComPais(endComPais);
		}

		if (endResLogradouro == null) {
			clienteImpl.setEndResLogradouro(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndResLogradouro(endResLogradouro);
		}

		if (endResNumero == null) {
			clienteImpl.setEndResNumero(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndResNumero(endResNumero);
		}

		if (endResComplemento == null) {
			clienteImpl.setEndResComplemento(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndResComplemento(endResComplemento);
		}

		if (endResCep == null) {
			clienteImpl.setEndResCep(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndResCep(endResCep);
		}

		if (endResBairro == null) {
			clienteImpl.setEndResBairro(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndResBairro(endResBairro);
		}

		clienteImpl.setEndResCidade(endResCidade);

		if (endResUf == null) {
			clienteImpl.setEndResUf(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndResUf(endResUf);
		}

		if (endResPais == null) {
			clienteImpl.setEndResPais(StringPool.BLANK);
		}
		else {
			clienteImpl.setEndResPais(endResPais);
		}

		if (telComDdd == null) {
			clienteImpl.setTelComDdd(StringPool.BLANK);
		}
		else {
			clienteImpl.setTelComDdd(telComDdd);
		}

		clienteImpl.setVersao(versao);
		clienteImpl.setLogoTipoId(logoTipoId);

		if (observacao == null) {
			clienteImpl.setObservacao(StringPool.BLANK);
		}
		else {
			clienteImpl.setObservacao(observacao);
		}

		clienteImpl.resetOriginalValues();

		return clienteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		clienteId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		rgInscricaoMun = objectInput.readUTF();
		rgOrgaoEmissor = objectInput.readUTF();
		rgDataEmissao = objectInput.readLong();
		tipoPessoa = objectInput.readUTF();
		cpfCnpj = objectInput.readUTF();
		sexo = objectInput.readUTF();
		estadoCivil = objectInput.readUTF();
		dataNascimento = objectInput.readLong();
		endComLogradouro = objectInput.readUTF();
		endComNumero = objectInput.readUTF();
		endComComplemento = objectInput.readUTF();
		endComCep = objectInput.readUTF();
		endComBairro = objectInput.readUTF();
		endComCidade = objectInput.readLong();
		endComUf = objectInput.readUTF();
		endComPais = objectInput.readUTF();
		endResLogradouro = objectInput.readUTF();
		endResNumero = objectInput.readUTF();
		endResComplemento = objectInput.readUTF();
		endResCep = objectInput.readUTF();
		endResBairro = objectInput.readUTF();
		endResCidade = objectInput.readLong();
		endResUf = objectInput.readUTF();
		endResPais = objectInput.readUTF();
		telComDdd = objectInput.readUTF();
		versao = objectInput.readDouble();
		logoTipoId = objectInput.readLong();
		observacao = objectInput.readUTF();
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

		objectOutput.writeLong(clienteId);
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

		if (rgInscricaoMun == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rgInscricaoMun);
		}

		if (rgOrgaoEmissor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rgOrgaoEmissor);
		}

		objectOutput.writeLong(rgDataEmissao);

		if (tipoPessoa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoPessoa);
		}

		if (cpfCnpj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cpfCnpj);
		}

		if (sexo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sexo);
		}

		if (estadoCivil == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(estadoCivil);
		}

		objectOutput.writeLong(dataNascimento);

		if (endComLogradouro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComLogradouro);
		}

		if (endComNumero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComNumero);
		}

		if (endComComplemento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComComplemento);
		}

		if (endComCep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComCep);
		}

		if (endComBairro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComBairro);
		}

		objectOutput.writeLong(endComCidade);

		if (endComUf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComUf);
		}

		if (endComPais == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComPais);
		}

		if (endResLogradouro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResLogradouro);
		}

		if (endResNumero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResNumero);
		}

		if (endResComplemento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResComplemento);
		}

		if (endResCep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResCep);
		}

		if (endResBairro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResBairro);
		}

		objectOutput.writeLong(endResCidade);

		if (endResUf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResUf);
		}

		if (endResPais == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResPais);
		}

		if (telComDdd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telComDdd);
		}

		objectOutput.writeDouble(versao);
		objectOutput.writeLong(logoTipoId);

		if (observacao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(observacao);
		}
	}

	public String uuid;
	public long clienteId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String rgInscricaoMun;
	public String rgOrgaoEmissor;
	public long rgDataEmissao;
	public String tipoPessoa;
	public String cpfCnpj;
	public String sexo;
	public String estadoCivil;
	public long dataNascimento;
	public String endComLogradouro;
	public String endComNumero;
	public String endComComplemento;
	public String endComCep;
	public String endComBairro;
	public long endComCidade;
	public String endComUf;
	public String endComPais;
	public String endResLogradouro;
	public String endResNumero;
	public String endResComplemento;
	public String endResCep;
	public String endResBairro;
	public long endResCidade;
	public String endResUf;
	public String endResPais;
	public String telComDdd;
	public double versao;
	public long logoTipoId;
	public String observacao;
}