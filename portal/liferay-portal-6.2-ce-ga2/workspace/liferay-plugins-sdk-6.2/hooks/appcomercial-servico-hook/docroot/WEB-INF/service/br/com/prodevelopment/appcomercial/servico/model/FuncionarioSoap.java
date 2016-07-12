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

package br.com.prodevelopment.appcomercial.servico.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.appcomercial.servico.service.http.FuncionarioServiceSoap}.
 *
 * @author marcelo
 * @see br.com.prodevelopment.appcomercial.servico.service.http.FuncionarioServiceSoap
 * @generated
 */
public class FuncionarioSoap implements Serializable {
	public static FuncionarioSoap toSoapModel(Funcionario model) {
		FuncionarioSoap soapModel = new FuncionarioSoap();

		soapModel.setFuncionarioId(model.getFuncionarioId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNome(model.getNome());
		soapModel.setApelido(model.getApelido());
		soapModel.setObservacao(model.getObservacao());
		soapModel.setRg(model.getRg());
		soapModel.setRgOrgaoEmissor(model.getRgOrgaoEmissor());
		soapModel.setRgDataEmissao(model.getRgDataEmissao());
		soapModel.setCpf(model.getCpf());
		soapModel.setSexo(model.getSexo());
		soapModel.setEstadoCivil(model.getEstadoCivil());
		soapModel.setDataNascimento(model.getDataNascimento());
		soapModel.setEndComLogradouro(model.getEndComLogradouro());
		soapModel.setEndComDescricao(model.getEndComDescricao());
		soapModel.setEndComCep(model.getEndComCep());
		soapModel.setEndComBairro(model.getEndComBairro());
		soapModel.setEndComCidade(model.getEndComCidade());
		soapModel.setEndComUf(model.getEndComUf());
		soapModel.setEndComPais(model.getEndComPais());
		soapModel.setEndResLogradouro(model.getEndResLogradouro());
		soapModel.setEndResDescricao(model.getEndResDescricao());
		soapModel.setEndResCep(model.getEndResCep());
		soapModel.setEndResBairro(model.getEndResBairro());
		soapModel.setEndResCidade(model.getEndResCidade());
		soapModel.setEndResUf(model.getEndResUf());
		soapModel.setEndResPais(model.getEndResPais());
		soapModel.setTelComDdd(model.getTelComDdd());
		soapModel.setTelComNumero(model.getTelComNumero());
		soapModel.setTelComRamal(model.getTelComRamal());
		soapModel.setTelResDdd(model.getTelResDdd());
		soapModel.setTelResNumero(model.getTelResNumero());
		soapModel.setTelCelDdd(model.getTelCelDdd());
		soapModel.setTelCelNumero(model.getTelCelNumero());
		soapModel.setEndEmail(model.getEndEmail());
		soapModel.setDataEntrada(model.getDataEntrada());
		soapModel.setDataSaida(model.getDataSaida());
		soapModel.setExisteUser(model.getExisteUser());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static FuncionarioSoap[] toSoapModels(Funcionario[] models) {
		FuncionarioSoap[] soapModels = new FuncionarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FuncionarioSoap[][] toSoapModels(Funcionario[][] models) {
		FuncionarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FuncionarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FuncionarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FuncionarioSoap[] toSoapModels(List<Funcionario> models) {
		List<FuncionarioSoap> soapModels = new ArrayList<FuncionarioSoap>(models.size());

		for (Funcionario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FuncionarioSoap[soapModels.size()]);
	}

	public FuncionarioSoap() {
	}

	public long getPrimaryKey() {
		return _funcionarioId;
	}

	public void setPrimaryKey(long pk) {
		setFuncionarioId(pk);
	}

	public long getFuncionarioId() {
		return _funcionarioId;
	}

	public void setFuncionarioId(long funcionarioId) {
		_funcionarioId = funcionarioId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getApelido() {
		return _apelido;
	}

	public void setApelido(String apelido) {
		_apelido = apelido;
	}

	public String getObservacao() {
		return _observacao;
	}

	public void setObservacao(String observacao) {
		_observacao = observacao;
	}

	public String getRg() {
		return _rg;
	}

	public void setRg(String rg) {
		_rg = rg;
	}

	public String getRgOrgaoEmissor() {
		return _rgOrgaoEmissor;
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		_rgOrgaoEmissor = rgOrgaoEmissor;
	}

	public Date getRgDataEmissao() {
		return _rgDataEmissao;
	}

	public void setRgDataEmissao(Date rgDataEmissao) {
		_rgDataEmissao = rgDataEmissao;
	}

	public String getCpf() {
		return _cpf;
	}

	public void setCpf(String cpf) {
		_cpf = cpf;
	}

	public String getSexo() {
		return _sexo;
	}

	public void setSexo(String sexo) {
		_sexo = sexo;
	}

	public String getEstadoCivil() {
		return _estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		_estadoCivil = estadoCivil;
	}

	public Date getDataNascimento() {
		return _dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		_dataNascimento = dataNascimento;
	}

	public String getEndComLogradouro() {
		return _endComLogradouro;
	}

	public void setEndComLogradouro(String endComLogradouro) {
		_endComLogradouro = endComLogradouro;
	}

	public String getEndComDescricao() {
		return _endComDescricao;
	}

	public void setEndComDescricao(String endComDescricao) {
		_endComDescricao = endComDescricao;
	}

	public String getEndComCep() {
		return _endComCep;
	}

	public void setEndComCep(String endComCep) {
		_endComCep = endComCep;
	}

	public String getEndComBairro() {
		return _endComBairro;
	}

	public void setEndComBairro(String endComBairro) {
		_endComBairro = endComBairro;
	}

	public String getEndComCidade() {
		return _endComCidade;
	}

	public void setEndComCidade(String endComCidade) {
		_endComCidade = endComCidade;
	}

	public String getEndComUf() {
		return _endComUf;
	}

	public void setEndComUf(String endComUf) {
		_endComUf = endComUf;
	}

	public String getEndComPais() {
		return _endComPais;
	}

	public void setEndComPais(String endComPais) {
		_endComPais = endComPais;
	}

	public String getEndResLogradouro() {
		return _endResLogradouro;
	}

	public void setEndResLogradouro(String endResLogradouro) {
		_endResLogradouro = endResLogradouro;
	}

	public String getEndResDescricao() {
		return _endResDescricao;
	}

	public void setEndResDescricao(String endResDescricao) {
		_endResDescricao = endResDescricao;
	}

	public String getEndResCep() {
		return _endResCep;
	}

	public void setEndResCep(String endResCep) {
		_endResCep = endResCep;
	}

	public String getEndResBairro() {
		return _endResBairro;
	}

	public void setEndResBairro(String endResBairro) {
		_endResBairro = endResBairro;
	}

	public String getEndResCidade() {
		return _endResCidade;
	}

	public void setEndResCidade(String endResCidade) {
		_endResCidade = endResCidade;
	}

	public String getEndResUf() {
		return _endResUf;
	}

	public void setEndResUf(String endResUf) {
		_endResUf = endResUf;
	}

	public String getEndResPais() {
		return _endResPais;
	}

	public void setEndResPais(String endResPais) {
		_endResPais = endResPais;
	}

	public String getTelComDdd() {
		return _telComDdd;
	}

	public void setTelComDdd(String telComDdd) {
		_telComDdd = telComDdd;
	}

	public String getTelComNumero() {
		return _telComNumero;
	}

	public void setTelComNumero(String telComNumero) {
		_telComNumero = telComNumero;
	}

	public String getTelComRamal() {
		return _telComRamal;
	}

	public void setTelComRamal(String telComRamal) {
		_telComRamal = telComRamal;
	}

	public String getTelResDdd() {
		return _telResDdd;
	}

	public void setTelResDdd(String telResDdd) {
		_telResDdd = telResDdd;
	}

	public String getTelResNumero() {
		return _telResNumero;
	}

	public void setTelResNumero(String telResNumero) {
		_telResNumero = telResNumero;
	}

	public String getTelCelDdd() {
		return _telCelDdd;
	}

	public void setTelCelDdd(String telCelDdd) {
		_telCelDdd = telCelDdd;
	}

	public String getTelCelNumero() {
		return _telCelNumero;
	}

	public void setTelCelNumero(String telCelNumero) {
		_telCelNumero = telCelNumero;
	}

	public String getEndEmail() {
		return _endEmail;
	}

	public void setEndEmail(String endEmail) {
		_endEmail = endEmail;
	}

	public Date getDataEntrada() {
		return _dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		_dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return _dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		_dataSaida = dataSaida;
	}

	public Boolean getExisteUser() {
		return _existeUser;
	}

	public void setExisteUser(Boolean existeUser) {
		_existeUser = existeUser;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _funcionarioId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _apelido;
	private String _observacao;
	private String _rg;
	private String _rgOrgaoEmissor;
	private Date _rgDataEmissao;
	private String _cpf;
	private String _sexo;
	private String _estadoCivil;
	private Date _dataNascimento;
	private String _endComLogradouro;
	private String _endComDescricao;
	private String _endComCep;
	private String _endComBairro;
	private String _endComCidade;
	private String _endComUf;
	private String _endComPais;
	private String _endResLogradouro;
	private String _endResDescricao;
	private String _endResCep;
	private String _endResBairro;
	private String _endResCidade;
	private String _endResUf;
	private String _endResPais;
	private String _telComDdd;
	private String _telComNumero;
	private String _telComRamal;
	private String _telResDdd;
	private String _telResNumero;
	private String _telCelDdd;
	private String _telCelNumero;
	private String _endEmail;
	private Date _dataEntrada;
	private Date _dataSaida;
	private Boolean _existeUser;
	private long _userId;
}