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

package br.com.prodevelopment.cliente.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.cliente.service.http.ClienteServiceSoap}.
 *
 * @author marcelo
 * @see br.com.prodevelopment.cliente.service.http.ClienteServiceSoap
 * @generated
 */
public class ClienteSoap implements Serializable {
	public static ClienteSoap toSoapModel(Cliente model) {
		ClienteSoap soapModel = new ClienteSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setClienteId(model.getClienteId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNome(model.getNome());
		soapModel.setRgInscricaoMun(model.getRgInscricaoMun());
		soapModel.setRgOrgaoEmissor(model.getRgOrgaoEmissor());
		soapModel.setRgDataEmissao(model.getRgDataEmissao());
		soapModel.setTipoPessoa(model.getTipoPessoa());
		soapModel.setCpfCnpj(model.getCpfCnpj());
		soapModel.setSexo(model.getSexo());
		soapModel.setEstadoCivil(model.getEstadoCivil());
		soapModel.setDataNascimento(model.getDataNascimento());
		soapModel.setEndComLogradouro(model.getEndComLogradouro());
		soapModel.setEndComNumero(model.getEndComNumero());
		soapModel.setEndComComplemento(model.getEndComComplemento());
		soapModel.setEndComCep(model.getEndComCep());
		soapModel.setEndComBairro(model.getEndComBairro());
		soapModel.setEndComCidade(model.getEndComCidade());
		soapModel.setEndComUf(model.getEndComUf());
		soapModel.setEndComPais(model.getEndComPais());
		soapModel.setEndResLogradouro(model.getEndResLogradouro());
		soapModel.setEndResNumero(model.getEndResNumero());
		soapModel.setEndResComplemento(model.getEndResComplemento());
		soapModel.setEndResCep(model.getEndResCep());
		soapModel.setEndResBairro(model.getEndResBairro());
		soapModel.setEndResCidade(model.getEndResCidade());
		soapModel.setEndResUf(model.getEndResUf());
		soapModel.setEndResPais(model.getEndResPais());
		soapModel.setTelComDdd(model.getTelComDdd());
		soapModel.setVersao(model.getVersao());
		soapModel.setLogoTipoId(model.getLogoTipoId());
		soapModel.setObservacao(model.getObservacao());

		return soapModel;
	}

	public static ClienteSoap[] toSoapModels(Cliente[] models) {
		ClienteSoap[] soapModels = new ClienteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClienteSoap[][] toSoapModels(Cliente[][] models) {
		ClienteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClienteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClienteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClienteSoap[] toSoapModels(List<Cliente> models) {
		List<ClienteSoap> soapModels = new ArrayList<ClienteSoap>(models.size());

		for (Cliente model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClienteSoap[soapModels.size()]);
	}

	public ClienteSoap() {
	}

	public long getPrimaryKey() {
		return _clienteId;
	}

	public void setPrimaryKey(long pk) {
		setClienteId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getClienteId() {
		return _clienteId;
	}

	public void setClienteId(long clienteId) {
		_clienteId = clienteId;
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

	public String getRgInscricaoMun() {
		return _rgInscricaoMun;
	}

	public void setRgInscricaoMun(String rgInscricaoMun) {
		_rgInscricaoMun = rgInscricaoMun;
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

	public String getTipoPessoa() {
		return _tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		_tipoPessoa = tipoPessoa;
	}

	public String getCpfCnpj() {
		return _cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		_cpfCnpj = cpfCnpj;
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

	public String getEndComNumero() {
		return _endComNumero;
	}

	public void setEndComNumero(String endComNumero) {
		_endComNumero = endComNumero;
	}

	public String getEndComComplemento() {
		return _endComComplemento;
	}

	public void setEndComComplemento(String endComComplemento) {
		_endComComplemento = endComComplemento;
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

	public long getEndComCidade() {
		return _endComCidade;
	}

	public void setEndComCidade(long endComCidade) {
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

	public String getEndResNumero() {
		return _endResNumero;
	}

	public void setEndResNumero(String endResNumero) {
		_endResNumero = endResNumero;
	}

	public String getEndResComplemento() {
		return _endResComplemento;
	}

	public void setEndResComplemento(String endResComplemento) {
		_endResComplemento = endResComplemento;
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

	public long getEndResCidade() {
		return _endResCidade;
	}

	public void setEndResCidade(long endResCidade) {
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

	public double getVersao() {
		return _versao;
	}

	public void setVersao(double versao) {
		_versao = versao;
	}

	public long getLogoTipoId() {
		return _logoTipoId;
	}

	public void setLogoTipoId(long logoTipoId) {
		_logoTipoId = logoTipoId;
	}

	public String getObservacao() {
		return _observacao;
	}

	public void setObservacao(String observacao) {
		_observacao = observacao;
	}

	private String _uuid;
	private long _clienteId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private long _modifiedUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _rgInscricaoMun;
	private String _rgOrgaoEmissor;
	private Date _rgDataEmissao;
	private String _tipoPessoa;
	private String _cpfCnpj;
	private String _sexo;
	private String _estadoCivil;
	private Date _dataNascimento;
	private String _endComLogradouro;
	private String _endComNumero;
	private String _endComComplemento;
	private String _endComCep;
	private String _endComBairro;
	private long _endComCidade;
	private String _endComUf;
	private String _endComPais;
	private String _endResLogradouro;
	private String _endResNumero;
	private String _endResComplemento;
	private String _endResCep;
	private String _endResBairro;
	private long _endResCidade;
	private String _endResUf;
	private String _endResPais;
	private String _telComDdd;
	private double _versao;
	private long _logoTipoId;
	private String _observacao;
}