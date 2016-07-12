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

import br.com.prodevelopment.funcionario.model.Funcionario;

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
 * @author Marcelo Melo
 * @see Funcionario
 * @generated
 */
public class FuncionarioCacheModel implements CacheModel<Funcionario>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(87);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", funcionarioId=");
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
		sb.append(", nomeReduzido=");
		sb.append(nomeReduzido);
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
		sb.append(", dataEntrada=");
		sb.append(dataEntrada);
		sb.append(", dataSaida=");
		sb.append(dataSaida);
		sb.append(", existeUser=");
		sb.append(existeUser);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", versao=");
		sb.append(versao);
		sb.append(", cargoId=");
		sb.append(cargoId);
		sb.append(", fotoId=");
		sb.append(fotoId);
		sb.append(", ativo=");
		sb.append(ativo);
		sb.append(", salario=");
		sb.append(salario);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Funcionario toEntityModel() {
		FuncionarioImpl funcionarioImpl = new FuncionarioImpl();

		if (uuid == null) {
			funcionarioImpl.setUuid(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setUuid(uuid);
		}

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

		if (nomeReduzido == null) {
			funcionarioImpl.setNomeReduzido(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setNomeReduzido(nomeReduzido);
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

		if (endComNumero == null) {
			funcionarioImpl.setEndComNumero(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComNumero(endComNumero);
		}

		if (endComComplemento == null) {
			funcionarioImpl.setEndComComplemento(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndComComplemento(endComComplemento);
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

		funcionarioImpl.setEndComCidade(endComCidade);

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

		if (endResNumero == null) {
			funcionarioImpl.setEndResNumero(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResNumero(endResNumero);
		}

		if (endResComplemento == null) {
			funcionarioImpl.setEndResComplemento(StringPool.BLANK);
		}
		else {
			funcionarioImpl.setEndResComplemento(endResComplemento);
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

		funcionarioImpl.setEndResCidade(endResCidade);

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
		funcionarioImpl.setVersao(versao);
		funcionarioImpl.setCargoId(cargoId);
		funcionarioImpl.setFotoId(fotoId);
		funcionarioImpl.setAtivo(ativo);
		funcionarioImpl.setSalario(salario);

		funcionarioImpl.resetOriginalValues();

		return funcionarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		funcionarioId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createUserId = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		nomeReduzido = objectInput.readUTF();
		observacao = objectInput.readUTF();
		rg = objectInput.readUTF();
		rgOrgaoEmissor = objectInput.readUTF();
		rgDataEmissao = objectInput.readLong();
		cpf = objectInput.readUTF();
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
		dataEntrada = objectInput.readLong();
		dataSaida = objectInput.readLong();
		existeUser = objectInput.readBoolean();
		userId = objectInput.readLong();
		versao = objectInput.readDouble();
		cargoId = objectInput.readLong();
		fotoId = objectInput.readLong();
		ativo = objectInput.readBoolean();
		salario = objectInput.readDouble();
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

		if (nomeReduzido == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeReduzido);
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

		objectOutput.writeLong(dataEntrada);
		objectOutput.writeLong(dataSaida);
		objectOutput.writeBoolean(existeUser);
		objectOutput.writeLong(userId);
		objectOutput.writeDouble(versao);
		objectOutput.writeLong(cargoId);
		objectOutput.writeLong(fotoId);
		objectOutput.writeBoolean(ativo);
		objectOutput.writeDouble(salario);
	}

	public String uuid;
	public long funcionarioId;
	public long companyId;
	public long groupId;
	public long createUserId;
	public long modifiedUserId;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String nomeReduzido;
	public String observacao;
	public String rg;
	public String rgOrgaoEmissor;
	public long rgDataEmissao;
	public String cpf;
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
	public long dataEntrada;
	public long dataSaida;
	public Boolean existeUser;
	public long userId;
	public double versao;
	public long cargoId;
	public long fotoId;
	public Boolean ativo;
	public double salario;
}