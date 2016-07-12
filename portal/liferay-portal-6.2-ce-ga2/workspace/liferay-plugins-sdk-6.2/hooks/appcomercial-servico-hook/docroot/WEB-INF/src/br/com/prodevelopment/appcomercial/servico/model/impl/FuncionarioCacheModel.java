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

package br.com.prodevelopment.appcomercial.servico.model.impl;

import br.com.prodevelopment.appcomercial.servico.model.Funcionario;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Funcionario in entity cache.
 *
 * @author marcelo
 * @see Funcionario
 * @generated
 */
public class FuncionarioCacheModel implements CacheModel<Funcionario>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(87);

		sb.append("{funcionarioId=");
		sb.append(funcionarioId);
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
		sb.append(", apelido=");
		sb.append(apelido);
		sb.append(", observacao=");
		sb.append(observacao);
		sb.append(", rg=");
		sb.append(rg);
		sb.append(", rgOrgaoEmissor=");
		sb.append(rgOrgaoEmissor);
		sb.append(", rgDataEmissao=");
		sb.append(rgDataEmissao);
		sb.append(", cpf=");
		sb.append(cpf);
		sb.append(", sexo=");
		sb.append(sexo);
		sb.append(", estadoCivil=");
		sb.append(estadoCivil);
		sb.append(", dataNascimento=");
		sb.append(dataNascimento);
		sb.append(", endComLogradouro=");
		sb.append(endComLogradouro);
		sb.append(", endComDescricao=");
		sb.append(endComDescricao);
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
		sb.append(", endResDescricao=");
		sb.append(endResDescricao);
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
		sb.append(", telComNumero=");
		sb.append(telComNumero);
		sb.append(", telComRamal=");
		sb.append(telComRamal);
		sb.append(", telResDdd=");
		sb.append(telResDdd);
		sb.append(", telResNumero=");
		sb.append(telResNumero);
		sb.append(", telCelDdd=");
		sb.append(telCelDdd);
		sb.append(", telCelNumero=");
		sb.append(telCelNumero);
		sb.append(", endEmail=");
		sb.append(endEmail);
		sb.append(", dataEntrada=");
		sb.append(dataEntrada);
		sb.append(", dataSaida=");
		sb.append(dataSaida);
		sb.append(", existeUser=");
		sb.append(existeUser);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Funcionario toEntityModel() {
		FuncionarioImpl funcionarioImpl = new FuncionarioImpl();

		funcionarioImpl.setFuncionarioId(funcionarioId);
		funcionarioImpl.setCompanyId(companyId);
		funcionarioImpl.setGroupId(groupId);
		funcionarioImpl.setCreateUserId(createUserId);
		funcionarioImpl.setModifiedUserId(modifiedUserId);

		if (createDate == Long.MIN_VALUE) {
			funcionarioImpl.setCreateDate(null);
		}
		else {
			funcionarioImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			funcionarioImpl.setModifiedDate(null);
		}
		else {
			funcionarioImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			funcionarioImpl.setNome(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setNome(nome);
		}

		if (apelido == null) {
			funcionarioImpl.setApelido(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setApelido(apelido);
		}

		if (observacao == null) {
			funcionarioImpl.setObservacao(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setObservacao(observacao);
		}

		if (rg == null) {
			funcionarioImpl.setRg(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setRg(rg);
		}

		if (rgOrgaoEmissor == null) {
			funcionarioImpl.setRgOrgaoEmissor(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setRgOrgaoEmissor(rgOrgaoEmissor);
		}

		if (rgDataEmissao == Long.MIN_VALUE) {
			funcionarioImpl.setRgDataEmissao(null);
		}
		else {
			funcionarioImpl.setRgDataEmissao(new Date(rgDataEmissao));
		}

		if (cpf == null) {
			funcionarioImpl.setCpf(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setCpf(cpf);
		}

		if (sexo == null) {
			funcionarioImpl.setSexo(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setSexo(sexo);
		}

		if (estadoCivil == null) {
			funcionarioImpl.setEstadoCivil(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEstadoCivil(estadoCivil);
		}

		if (dataNascimento == Long.MIN_VALUE) {
			funcionarioImpl.setDataNascimento(null);
		}
		else {
			funcionarioImpl.setDataNascimento(new Date(dataNascimento));
		}

		if (endComLogradouro == null) {
			funcionarioImpl.setEndComLogradouro(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComLogradouro(endComLogradouro);
		}

		if (endComDescricao == null) {
			funcionarioImpl.setEndComDescricao(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComDescricao(endComDescricao);
		}

		if (endComCep == null) {
			funcionarioImpl.setEndComCep(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComCep(endComCep);
		}

		if (endComBairro == null) {
			funcionarioImpl.setEndComBairro(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComBairro(endComBairro);
		}

		if (endComCidade == null) {
			funcionarioImpl.setEndComCidade(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComCidade(endComCidade);
		}

		if (endComUf == null) {
			funcionarioImpl.setEndComUf(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComUf(endComUf);
		}

		if (endComPais == null) {
			funcionarioImpl.setEndComPais(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComPais(endComPais);
		}

		if (endResLogradouro == null) {
			funcionarioImpl.setEndResLogradouro(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResLogradouro(endResLogradouro);
		}

		if (endResDescricao == null) {
			funcionarioImpl.setEndResDescricao(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResDescricao(endResDescricao);
		}

		if (endResCep == null) {
			funcionarioImpl.setEndResCep(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResCep(endResCep);
		}

		if (endResBairro == null) {
			funcionarioImpl.setEndResBairro(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResBairro(endResBairro);
		}

		if (endResCidade == null) {
			funcionarioImpl.setEndResCidade(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResCidade(endResCidade);
		}

		if (endResUf == null) {
			funcionarioImpl.setEndResUf(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResUf(endResUf);
		}

		if (endResPais == null) {
			funcionarioImpl.setEndResPais(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResPais(endResPais);
		}

		if (telComDdd == null) {
			funcionarioImpl.setTelComDdd(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setTelComDdd(telComDdd);
		}

		if (telComNumero == null) {
			funcionarioImpl.setTelComNumero(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setTelComNumero(telComNumero);
		}

		if (telComRamal == null) {
			funcionarioImpl.setTelComRamal(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setTelComRamal(telComRamal);
		}

		if (telResDdd == null) {
			funcionarioImpl.setTelResDdd(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setTelResDdd(telResDdd);
		}

		if (telResNumero == null) {
			funcionarioImpl.setTelResNumero(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setTelResNumero(telResNumero);
		}

		if (telCelDdd == null) {
			funcionarioImpl.setTelCelDdd(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setTelCelDdd(telCelDdd);
		}

		if (telCelNumero == null) {
			funcionarioImpl.setTelCelNumero(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setTelCelNumero(telCelNumero);
		}

		if (endEmail == null) {
			funcionarioImpl.setEndEmail(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndEmail(endEmail);
		}

		if (dataEntrada == Long.MIN_VALUE) {
			funcionarioImpl.setDataEntrada(null);
		}
		else {
			funcionarioImpl.setDataEntrada(new Date(dataEntrada));
		}

		if (dataSaida == Long.MIN_VALUE) {
			funcionarioImpl.setDataSaida(null);
		}
		else {
			funcionarioImpl.setDataSaida(new Date(dataSaida));
		}

		funcionarioImpl.setExisteUser(existeUser);
		funcionarioImpl.setUserId(userId);

		funcionarioImpl.resetOriginalValues();

		return funcionarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		funcionarioId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		apelido = objectInput.readUTF();
		observacao = objectInput.readUTF();
		rg = objectInput.readUTF();
		rgOrgaoEmissor = objectInput.readUTF();
		rgDataEmissao = objectInput.readLong();
		cpf = objectInput.readUTF();
		sexo = objectInput.readUTF();
		estadoCivil = objectInput.readUTF();
		dataNascimento = objectInput.readLong();
		endComLogradouro = objectInput.readUTF();
		endComDescricao = objectInput.readUTF();
		endComCep = objectInput.readUTF();
		endComBairro = objectInput.readUTF();
		endComCidade = objectInput.readUTF();
		endComUf = objectInput.readUTF();
		endComPais = objectInput.readUTF();
		endResLogradouro = objectInput.readUTF();
		endResDescricao = objectInput.readUTF();
		endResCep = objectInput.readUTF();
		endResBairro = objectInput.readUTF();
		endResCidade = objectInput.readUTF();
		endResUf = objectInput.readUTF();
		endResPais = objectInput.readUTF();
		telComDdd = objectInput.readUTF();
		telComNumero = objectInput.readUTF();
		telComRamal = objectInput.readUTF();
		telResDdd = objectInput.readUTF();
		telResNumero = objectInput.readUTF();
		telCelDdd = objectInput.readUTF();
		telCelNumero = objectInput.readUTF();
		endEmail = objectInput.readUTF();
		dataEntrada = objectInput.readLong();
		dataSaida = objectInput.readLong();
		existeUser = objectInput.readBoolean();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(funcionarioId);
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

		if (apelido == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(apelido);
		}

		if (observacao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(observacao);
		}

		if (rg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rg);
		}

		if (rgOrgaoEmissor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rgOrgaoEmissor);
		}

		objectOutput.writeLong(rgDataEmissao);

		if (cpf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cpf);
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

		if (endComDescricao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComDescricao);
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

		if (endComCidade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endComCidade);
		}

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

		if (endResDescricao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResDescricao);
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

		if (endResCidade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endResCidade);
		}

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

		if (telComNumero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telComNumero);
		}

		if (telComRamal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telComRamal);
		}

		if (telResDdd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telResDdd);
		}

		if (telResNumero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telResNumero);
		}

		if (telCelDdd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telCelDdd);
		}

		if (telCelNumero == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telCelNumero);
		}

		if (endEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endEmail);
		}

		objectOutput.writeLong(dataEntrada);
		objectOutput.writeLong(dataSaida);
		objectOutput.writeBoolean(existeUser);
		objectOutput.writeLong(userId);
	}

	public long funcionarioId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String apelido;
	public String observacao;
	public String rg;
	public String rgOrgaoEmissor;
	public long rgDataEmissao;
	public String cpf;
	public String sexo;
	public String estadoCivil;
	public long dataNascimento;
	public String endComLogradouro;
	public String endComDescricao;
	public String endComCep;
	public String endComBairro;
	public String endComCidade;
	public String endComUf;
	public String endComPais;
	public String endResLogradouro;
	public String endResDescricao;
	public String endResCep;
	public String endResBairro;
	public String endResCidade;
	public String endResUf;
	public String endResPais;
	public String telComDdd;
	public String telComNumero;
	public String telComRamal;
	public String telResDdd;
	public String telResNumero;
	public String telCelDdd;
	public String telCelNumero;
	public String endEmail;
	public long dataEntrada;
	public long dataSaida;
	public Boolean existeUser;
	public long userId;
}