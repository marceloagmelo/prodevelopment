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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Funcionario}.
 * </p>
 *
 * @author marcelo
 * @see Funcionario
 * @generated
 */
public class FuncionarioWrapper implements Funcionario,
	ModelWrapper<Funcionario> {
	public FuncionarioWrapper(Funcionario funcionario) {
		_funcionario = funcionario;
	}

	@Override
	public Class<?> getModelClass() {
		return Funcionario.class;
	}

	@Override
	public String getModelClassName() {
		return Funcionario.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("funcionarioId", getFuncionarioId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("apelido", getApelido());
		attributes.put("observacao", getObservacao());
		attributes.put("rg", getRg());
		attributes.put("rgOrgaoEmissor", getRgOrgaoEmissor());
		attributes.put("rgDataEmissao", getRgDataEmissao());
		attributes.put("cpf", getCpf());
		attributes.put("sexo", getSexo());
		attributes.put("estadoCivil", getEstadoCivil());
		attributes.put("dataNascimento", getDataNascimento());
		attributes.put("endComLogradouro", getEndComLogradouro());
		attributes.put("endComDescricao", getEndComDescricao());
		attributes.put("endComCep", getEndComCep());
		attributes.put("endComBairro", getEndComBairro());
		attributes.put("endComCidade", getEndComCidade());
		attributes.put("endComUf", getEndComUf());
		attributes.put("endComPais", getEndComPais());
		attributes.put("endResLogradouro", getEndResLogradouro());
		attributes.put("endResDescricao", getEndResDescricao());
		attributes.put("endResCep", getEndResCep());
		attributes.put("endResBairro", getEndResBairro());
		attributes.put("endResCidade", getEndResCidade());
		attributes.put("endResUf", getEndResUf());
		attributes.put("endResPais", getEndResPais());
		attributes.put("telComDdd", getTelComDdd());
		attributes.put("telComNumero", getTelComNumero());
		attributes.put("telComRamal", getTelComRamal());
		attributes.put("telResDdd", getTelResDdd());
		attributes.put("telResNumero", getTelResNumero());
		attributes.put("telCelDdd", getTelCelDdd());
		attributes.put("telCelNumero", getTelCelNumero());
		attributes.put("endEmail", getEndEmail());
		attributes.put("dataEntrada", getDataEntrada());
		attributes.put("dataSaida", getDataSaida());
		attributes.put("existeUser", getExisteUser());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long funcionarioId = (Long)attributes.get("funcionarioId");

		if (funcionarioId != null) {
			setFuncionarioId(funcionarioId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String apelido = (String)attributes.get("apelido");

		if (apelido != null) {
			setApelido(apelido);
		}

		String observacao = (String)attributes.get("observacao");

		if (observacao != null) {
			setObservacao(observacao);
		}

		String rg = (String)attributes.get("rg");

		if (rg != null) {
			setRg(rg);
		}

		String rgOrgaoEmissor = (String)attributes.get("rgOrgaoEmissor");

		if (rgOrgaoEmissor != null) {
			setRgOrgaoEmissor(rgOrgaoEmissor);
		}

		Date rgDataEmissao = (Date)attributes.get("rgDataEmissao");

		if (rgDataEmissao != null) {
			setRgDataEmissao(rgDataEmissao);
		}

		String cpf = (String)attributes.get("cpf");

		if (cpf != null) {
			setCpf(cpf);
		}

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		String estadoCivil = (String)attributes.get("estadoCivil");

		if (estadoCivil != null) {
			setEstadoCivil(estadoCivil);
		}

		Date dataNascimento = (Date)attributes.get("dataNascimento");

		if (dataNascimento != null) {
			setDataNascimento(dataNascimento);
		}

		String endComLogradouro = (String)attributes.get("endComLogradouro");

		if (endComLogradouro != null) {
			setEndComLogradouro(endComLogradouro);
		}

		String endComDescricao = (String)attributes.get("endComDescricao");

		if (endComDescricao != null) {
			setEndComDescricao(endComDescricao);
		}

		String endComCep = (String)attributes.get("endComCep");

		if (endComCep != null) {
			setEndComCep(endComCep);
		}

		String endComBairro = (String)attributes.get("endComBairro");

		if (endComBairro != null) {
			setEndComBairro(endComBairro);
		}

		String endComCidade = (String)attributes.get("endComCidade");

		if (endComCidade != null) {
			setEndComCidade(endComCidade);
		}

		String endComUf = (String)attributes.get("endComUf");

		if (endComUf != null) {
			setEndComUf(endComUf);
		}

		String endComPais = (String)attributes.get("endComPais");

		if (endComPais != null) {
			setEndComPais(endComPais);
		}

		String endResLogradouro = (String)attributes.get("endResLogradouro");

		if (endResLogradouro != null) {
			setEndResLogradouro(endResLogradouro);
		}

		String endResDescricao = (String)attributes.get("endResDescricao");

		if (endResDescricao != null) {
			setEndResDescricao(endResDescricao);
		}

		String endResCep = (String)attributes.get("endResCep");

		if (endResCep != null) {
			setEndResCep(endResCep);
		}

		String endResBairro = (String)attributes.get("endResBairro");

		if (endResBairro != null) {
			setEndResBairro(endResBairro);
		}

		String endResCidade = (String)attributes.get("endResCidade");

		if (endResCidade != null) {
			setEndResCidade(endResCidade);
		}

		String endResUf = (String)attributes.get("endResUf");

		if (endResUf != null) {
			setEndResUf(endResUf);
		}

		String endResPais = (String)attributes.get("endResPais");

		if (endResPais != null) {
			setEndResPais(endResPais);
		}

		String telComDdd = (String)attributes.get("telComDdd");

		if (telComDdd != null) {
			setTelComDdd(telComDdd);
		}

		String telComNumero = (String)attributes.get("telComNumero");

		if (telComNumero != null) {
			setTelComNumero(telComNumero);
		}

		String telComRamal = (String)attributes.get("telComRamal");

		if (telComRamal != null) {
			setTelComRamal(telComRamal);
		}

		String telResDdd = (String)attributes.get("telResDdd");

		if (telResDdd != null) {
			setTelResDdd(telResDdd);
		}

		String telResNumero = (String)attributes.get("telResNumero");

		if (telResNumero != null) {
			setTelResNumero(telResNumero);
		}

		String telCelDdd = (String)attributes.get("telCelDdd");

		if (telCelDdd != null) {
			setTelCelDdd(telCelDdd);
		}

		String telCelNumero = (String)attributes.get("telCelNumero");

		if (telCelNumero != null) {
			setTelCelNumero(telCelNumero);
		}

		String endEmail = (String)attributes.get("endEmail");

		if (endEmail != null) {
			setEndEmail(endEmail);
		}

		Date dataEntrada = (Date)attributes.get("dataEntrada");

		if (dataEntrada != null) {
			setDataEntrada(dataEntrada);
		}

		Date dataSaida = (Date)attributes.get("dataSaida");

		if (dataSaida != null) {
			setDataSaida(dataSaida);
		}

		Boolean existeUser = (Boolean)attributes.get("existeUser");

		if (existeUser != null) {
			setExisteUser(existeUser);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this funcionario.
	*
	* @return the primary key of this funcionario
	*/
	@Override
	public long getPrimaryKey() {
		return _funcionario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this funcionario.
	*
	* @param primaryKey the primary key of this funcionario
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_funcionario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the funcionario ID of this funcionario.
	*
	* @return the funcionario ID of this funcionario
	*/
	@Override
	public long getFuncionarioId() {
		return _funcionario.getFuncionarioId();
	}

	/**
	* Sets the funcionario ID of this funcionario.
	*
	* @param funcionarioId the funcionario ID of this funcionario
	*/
	@Override
	public void setFuncionarioId(long funcionarioId) {
		_funcionario.setFuncionarioId(funcionarioId);
	}

	/**
	* Returns the company ID of this funcionario.
	*
	* @return the company ID of this funcionario
	*/
	@Override
	public long getCompanyId() {
		return _funcionario.getCompanyId();
	}

	/**
	* Sets the company ID of this funcionario.
	*
	* @param companyId the company ID of this funcionario
	*/
	@Override
	public void setCompanyId(long companyId) {
		_funcionario.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this funcionario.
	*
	* @return the group ID of this funcionario
	*/
	@Override
	public long getGroupId() {
		return _funcionario.getGroupId();
	}

	/**
	* Sets the group ID of this funcionario.
	*
	* @param groupId the group ID of this funcionario
	*/
	@Override
	public void setGroupId(long groupId) {
		_funcionario.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this funcionario.
	*
	* @return the create user ID of this funcionario
	*/
	@Override
	public long getCreateUserId() {
		return _funcionario.getCreateUserId();
	}

	/**
	* Sets the create user ID of this funcionario.
	*
	* @param createUserId the create user ID of this funcionario
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_funcionario.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this funcionario.
	*
	* @return the create user uuid of this funcionario
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionario.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this funcionario.
	*
	* @param createUserUuid the create user uuid of this funcionario
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_funcionario.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this funcionario.
	*
	* @return the modified user ID of this funcionario
	*/
	@Override
	public long getModifiedUserId() {
		return _funcionario.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this funcionario.
	*
	* @param modifiedUserId the modified user ID of this funcionario
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_funcionario.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this funcionario.
	*
	* @return the modified user uuid of this funcionario
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionario.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this funcionario.
	*
	* @param modifiedUserUuid the modified user uuid of this funcionario
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_funcionario.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this funcionario.
	*
	* @return the create date of this funcionario
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _funcionario.getCreateDate();
	}

	/**
	* Sets the create date of this funcionario.
	*
	* @param createDate the create date of this funcionario
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_funcionario.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this funcionario.
	*
	* @return the modified date of this funcionario
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _funcionario.getModifiedDate();
	}

	/**
	* Sets the modified date of this funcionario.
	*
	* @param modifiedDate the modified date of this funcionario
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_funcionario.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nome of this funcionario.
	*
	* @return the nome of this funcionario
	*/
	@Override
	public java.lang.String getNome() {
		return _funcionario.getNome();
	}

	/**
	* Sets the nome of this funcionario.
	*
	* @param nome the nome of this funcionario
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_funcionario.setNome(nome);
	}

	/**
	* Returns the apelido of this funcionario.
	*
	* @return the apelido of this funcionario
	*/
	@Override
	public java.lang.String getApelido() {
		return _funcionario.getApelido();
	}

	/**
	* Sets the apelido of this funcionario.
	*
	* @param apelido the apelido of this funcionario
	*/
	@Override
	public void setApelido(java.lang.String apelido) {
		_funcionario.setApelido(apelido);
	}

	/**
	* Returns the observacao of this funcionario.
	*
	* @return the observacao of this funcionario
	*/
	@Override
	public java.lang.String getObservacao() {
		return _funcionario.getObservacao();
	}

	/**
	* Sets the observacao of this funcionario.
	*
	* @param observacao the observacao of this funcionario
	*/
	@Override
	public void setObservacao(java.lang.String observacao) {
		_funcionario.setObservacao(observacao);
	}

	/**
	* Returns the rg of this funcionario.
	*
	* @return the rg of this funcionario
	*/
	@Override
	public java.lang.String getRg() {
		return _funcionario.getRg();
	}

	/**
	* Sets the rg of this funcionario.
	*
	* @param rg the rg of this funcionario
	*/
	@Override
	public void setRg(java.lang.String rg) {
		_funcionario.setRg(rg);
	}

	/**
	* Returns the rg orgao emissor of this funcionario.
	*
	* @return the rg orgao emissor of this funcionario
	*/
	@Override
	public java.lang.String getRgOrgaoEmissor() {
		return _funcionario.getRgOrgaoEmissor();
	}

	/**
	* Sets the rg orgao emissor of this funcionario.
	*
	* @param rgOrgaoEmissor the rg orgao emissor of this funcionario
	*/
	@Override
	public void setRgOrgaoEmissor(java.lang.String rgOrgaoEmissor) {
		_funcionario.setRgOrgaoEmissor(rgOrgaoEmissor);
	}

	/**
	* Returns the rg data emissao of this funcionario.
	*
	* @return the rg data emissao of this funcionario
	*/
	@Override
	public java.util.Date getRgDataEmissao() {
		return _funcionario.getRgDataEmissao();
	}

	/**
	* Sets the rg data emissao of this funcionario.
	*
	* @param rgDataEmissao the rg data emissao of this funcionario
	*/
	@Override
	public void setRgDataEmissao(java.util.Date rgDataEmissao) {
		_funcionario.setRgDataEmissao(rgDataEmissao);
	}

	/**
	* Returns the cpf of this funcionario.
	*
	* @return the cpf of this funcionario
	*/
	@Override
	public java.lang.String getCpf() {
		return _funcionario.getCpf();
	}

	/**
	* Sets the cpf of this funcionario.
	*
	* @param cpf the cpf of this funcionario
	*/
	@Override
	public void setCpf(java.lang.String cpf) {
		_funcionario.setCpf(cpf);
	}

	/**
	* Returns the sexo of this funcionario.
	*
	* @return the sexo of this funcionario
	*/
	@Override
	public java.lang.String getSexo() {
		return _funcionario.getSexo();
	}

	/**
	* Sets the sexo of this funcionario.
	*
	* @param sexo the sexo of this funcionario
	*/
	@Override
	public void setSexo(java.lang.String sexo) {
		_funcionario.setSexo(sexo);
	}

	/**
	* Returns the estado civil of this funcionario.
	*
	* @return the estado civil of this funcionario
	*/
	@Override
	public java.lang.String getEstadoCivil() {
		return _funcionario.getEstadoCivil();
	}

	/**
	* Sets the estado civil of this funcionario.
	*
	* @param estadoCivil the estado civil of this funcionario
	*/
	@Override
	public void setEstadoCivil(java.lang.String estadoCivil) {
		_funcionario.setEstadoCivil(estadoCivil);
	}

	/**
	* Returns the data nascimento of this funcionario.
	*
	* @return the data nascimento of this funcionario
	*/
	@Override
	public java.util.Date getDataNascimento() {
		return _funcionario.getDataNascimento();
	}

	/**
	* Sets the data nascimento of this funcionario.
	*
	* @param dataNascimento the data nascimento of this funcionario
	*/
	@Override
	public void setDataNascimento(java.util.Date dataNascimento) {
		_funcionario.setDataNascimento(dataNascimento);
	}

	/**
	* Returns the end com logradouro of this funcionario.
	*
	* @return the end com logradouro of this funcionario
	*/
	@Override
	public java.lang.String getEndComLogradouro() {
		return _funcionario.getEndComLogradouro();
	}

	/**
	* Sets the end com logradouro of this funcionario.
	*
	* @param endComLogradouro the end com logradouro of this funcionario
	*/
	@Override
	public void setEndComLogradouro(java.lang.String endComLogradouro) {
		_funcionario.setEndComLogradouro(endComLogradouro);
	}

	/**
	* Returns the end com descricao of this funcionario.
	*
	* @return the end com descricao of this funcionario
	*/
	@Override
	public java.lang.String getEndComDescricao() {
		return _funcionario.getEndComDescricao();
	}

	/**
	* Sets the end com descricao of this funcionario.
	*
	* @param endComDescricao the end com descricao of this funcionario
	*/
	@Override
	public void setEndComDescricao(java.lang.String endComDescricao) {
		_funcionario.setEndComDescricao(endComDescricao);
	}

	/**
	* Returns the end com cep of this funcionario.
	*
	* @return the end com cep of this funcionario
	*/
	@Override
	public java.lang.String getEndComCep() {
		return _funcionario.getEndComCep();
	}

	/**
	* Sets the end com cep of this funcionario.
	*
	* @param endComCep the end com cep of this funcionario
	*/
	@Override
	public void setEndComCep(java.lang.String endComCep) {
		_funcionario.setEndComCep(endComCep);
	}

	/**
	* Returns the end com bairro of this funcionario.
	*
	* @return the end com bairro of this funcionario
	*/
	@Override
	public java.lang.String getEndComBairro() {
		return _funcionario.getEndComBairro();
	}

	/**
	* Sets the end com bairro of this funcionario.
	*
	* @param endComBairro the end com bairro of this funcionario
	*/
	@Override
	public void setEndComBairro(java.lang.String endComBairro) {
		_funcionario.setEndComBairro(endComBairro);
	}

	/**
	* Returns the end com cidade of this funcionario.
	*
	* @return the end com cidade of this funcionario
	*/
	@Override
	public java.lang.String getEndComCidade() {
		return _funcionario.getEndComCidade();
	}

	/**
	* Sets the end com cidade of this funcionario.
	*
	* @param endComCidade the end com cidade of this funcionario
	*/
	@Override
	public void setEndComCidade(java.lang.String endComCidade) {
		_funcionario.setEndComCidade(endComCidade);
	}

	/**
	* Returns the end com uf of this funcionario.
	*
	* @return the end com uf of this funcionario
	*/
	@Override
	public java.lang.String getEndComUf() {
		return _funcionario.getEndComUf();
	}

	/**
	* Sets the end com uf of this funcionario.
	*
	* @param endComUf the end com uf of this funcionario
	*/
	@Override
	public void setEndComUf(java.lang.String endComUf) {
		_funcionario.setEndComUf(endComUf);
	}

	/**
	* Returns the end com pais of this funcionario.
	*
	* @return the end com pais of this funcionario
	*/
	@Override
	public java.lang.String getEndComPais() {
		return _funcionario.getEndComPais();
	}

	/**
	* Sets the end com pais of this funcionario.
	*
	* @param endComPais the end com pais of this funcionario
	*/
	@Override
	public void setEndComPais(java.lang.String endComPais) {
		_funcionario.setEndComPais(endComPais);
	}

	/**
	* Returns the end res logradouro of this funcionario.
	*
	* @return the end res logradouro of this funcionario
	*/
	@Override
	public java.lang.String getEndResLogradouro() {
		return _funcionario.getEndResLogradouro();
	}

	/**
	* Sets the end res logradouro of this funcionario.
	*
	* @param endResLogradouro the end res logradouro of this funcionario
	*/
	@Override
	public void setEndResLogradouro(java.lang.String endResLogradouro) {
		_funcionario.setEndResLogradouro(endResLogradouro);
	}

	/**
	* Returns the end res descricao of this funcionario.
	*
	* @return the end res descricao of this funcionario
	*/
	@Override
	public java.lang.String getEndResDescricao() {
		return _funcionario.getEndResDescricao();
	}

	/**
	* Sets the end res descricao of this funcionario.
	*
	* @param endResDescricao the end res descricao of this funcionario
	*/
	@Override
	public void setEndResDescricao(java.lang.String endResDescricao) {
		_funcionario.setEndResDescricao(endResDescricao);
	}

	/**
	* Returns the end res cep of this funcionario.
	*
	* @return the end res cep of this funcionario
	*/
	@Override
	public java.lang.String getEndResCep() {
		return _funcionario.getEndResCep();
	}

	/**
	* Sets the end res cep of this funcionario.
	*
	* @param endResCep the end res cep of this funcionario
	*/
	@Override
	public void setEndResCep(java.lang.String endResCep) {
		_funcionario.setEndResCep(endResCep);
	}

	/**
	* Returns the end res bairro of this funcionario.
	*
	* @return the end res bairro of this funcionario
	*/
	@Override
	public java.lang.String getEndResBairro() {
		return _funcionario.getEndResBairro();
	}

	/**
	* Sets the end res bairro of this funcionario.
	*
	* @param endResBairro the end res bairro of this funcionario
	*/
	@Override
	public void setEndResBairro(java.lang.String endResBairro) {
		_funcionario.setEndResBairro(endResBairro);
	}

	/**
	* Returns the end res cidade of this funcionario.
	*
	* @return the end res cidade of this funcionario
	*/
	@Override
	public java.lang.String getEndResCidade() {
		return _funcionario.getEndResCidade();
	}

	/**
	* Sets the end res cidade of this funcionario.
	*
	* @param endResCidade the end res cidade of this funcionario
	*/
	@Override
	public void setEndResCidade(java.lang.String endResCidade) {
		_funcionario.setEndResCidade(endResCidade);
	}

	/**
	* Returns the end res uf of this funcionario.
	*
	* @return the end res uf of this funcionario
	*/
	@Override
	public java.lang.String getEndResUf() {
		return _funcionario.getEndResUf();
	}

	/**
	* Sets the end res uf of this funcionario.
	*
	* @param endResUf the end res uf of this funcionario
	*/
	@Override
	public void setEndResUf(java.lang.String endResUf) {
		_funcionario.setEndResUf(endResUf);
	}

	/**
	* Returns the end res pais of this funcionario.
	*
	* @return the end res pais of this funcionario
	*/
	@Override
	public java.lang.String getEndResPais() {
		return _funcionario.getEndResPais();
	}

	/**
	* Sets the end res pais of this funcionario.
	*
	* @param endResPais the end res pais of this funcionario
	*/
	@Override
	public void setEndResPais(java.lang.String endResPais) {
		_funcionario.setEndResPais(endResPais);
	}

	/**
	* Returns the tel com ddd of this funcionario.
	*
	* @return the tel com ddd of this funcionario
	*/
	@Override
	public java.lang.String getTelComDdd() {
		return _funcionario.getTelComDdd();
	}

	/**
	* Sets the tel com ddd of this funcionario.
	*
	* @param telComDdd the tel com ddd of this funcionario
	*/
	@Override
	public void setTelComDdd(java.lang.String telComDdd) {
		_funcionario.setTelComDdd(telComDdd);
	}

	/**
	* Returns the tel com numero of this funcionario.
	*
	* @return the tel com numero of this funcionario
	*/
	@Override
	public java.lang.String getTelComNumero() {
		return _funcionario.getTelComNumero();
	}

	/**
	* Sets the tel com numero of this funcionario.
	*
	* @param telComNumero the tel com numero of this funcionario
	*/
	@Override
	public void setTelComNumero(java.lang.String telComNumero) {
		_funcionario.setTelComNumero(telComNumero);
	}

	/**
	* Returns the tel com ramal of this funcionario.
	*
	* @return the tel com ramal of this funcionario
	*/
	@Override
	public java.lang.String getTelComRamal() {
		return _funcionario.getTelComRamal();
	}

	/**
	* Sets the tel com ramal of this funcionario.
	*
	* @param telComRamal the tel com ramal of this funcionario
	*/
	@Override
	public void setTelComRamal(java.lang.String telComRamal) {
		_funcionario.setTelComRamal(telComRamal);
	}

	/**
	* Returns the tel res ddd of this funcionario.
	*
	* @return the tel res ddd of this funcionario
	*/
	@Override
	public java.lang.String getTelResDdd() {
		return _funcionario.getTelResDdd();
	}

	/**
	* Sets the tel res ddd of this funcionario.
	*
	* @param telResDdd the tel res ddd of this funcionario
	*/
	@Override
	public void setTelResDdd(java.lang.String telResDdd) {
		_funcionario.setTelResDdd(telResDdd);
	}

	/**
	* Returns the tel res numero of this funcionario.
	*
	* @return the tel res numero of this funcionario
	*/
	@Override
	public java.lang.String getTelResNumero() {
		return _funcionario.getTelResNumero();
	}

	/**
	* Sets the tel res numero of this funcionario.
	*
	* @param telResNumero the tel res numero of this funcionario
	*/
	@Override
	public void setTelResNumero(java.lang.String telResNumero) {
		_funcionario.setTelResNumero(telResNumero);
	}

	/**
	* Returns the tel cel ddd of this funcionario.
	*
	* @return the tel cel ddd of this funcionario
	*/
	@Override
	public java.lang.String getTelCelDdd() {
		return _funcionario.getTelCelDdd();
	}

	/**
	* Sets the tel cel ddd of this funcionario.
	*
	* @param telCelDdd the tel cel ddd of this funcionario
	*/
	@Override
	public void setTelCelDdd(java.lang.String telCelDdd) {
		_funcionario.setTelCelDdd(telCelDdd);
	}

	/**
	* Returns the tel cel numero of this funcionario.
	*
	* @return the tel cel numero of this funcionario
	*/
	@Override
	public java.lang.String getTelCelNumero() {
		return _funcionario.getTelCelNumero();
	}

	/**
	* Sets the tel cel numero of this funcionario.
	*
	* @param telCelNumero the tel cel numero of this funcionario
	*/
	@Override
	public void setTelCelNumero(java.lang.String telCelNumero) {
		_funcionario.setTelCelNumero(telCelNumero);
	}

	/**
	* Returns the end email of this funcionario.
	*
	* @return the end email of this funcionario
	*/
	@Override
	public java.lang.String getEndEmail() {
		return _funcionario.getEndEmail();
	}

	/**
	* Sets the end email of this funcionario.
	*
	* @param endEmail the end email of this funcionario
	*/
	@Override
	public void setEndEmail(java.lang.String endEmail) {
		_funcionario.setEndEmail(endEmail);
	}

	/**
	* Returns the data entrada of this funcionario.
	*
	* @return the data entrada of this funcionario
	*/
	@Override
	public java.util.Date getDataEntrada() {
		return _funcionario.getDataEntrada();
	}

	/**
	* Sets the data entrada of this funcionario.
	*
	* @param dataEntrada the data entrada of this funcionario
	*/
	@Override
	public void setDataEntrada(java.util.Date dataEntrada) {
		_funcionario.setDataEntrada(dataEntrada);
	}

	/**
	* Returns the data saida of this funcionario.
	*
	* @return the data saida of this funcionario
	*/
	@Override
	public java.util.Date getDataSaida() {
		return _funcionario.getDataSaida();
	}

	/**
	* Sets the data saida of this funcionario.
	*
	* @param dataSaida the data saida of this funcionario
	*/
	@Override
	public void setDataSaida(java.util.Date dataSaida) {
		_funcionario.setDataSaida(dataSaida);
	}

	/**
	* Returns the existe user of this funcionario.
	*
	* @return the existe user of this funcionario
	*/
	@Override
	public java.lang.Boolean getExisteUser() {
		return _funcionario.getExisteUser();
	}

	/**
	* Sets the existe user of this funcionario.
	*
	* @param existeUser the existe user of this funcionario
	*/
	@Override
	public void setExisteUser(java.lang.Boolean existeUser) {
		_funcionario.setExisteUser(existeUser);
	}

	/**
	* Returns the user ID of this funcionario.
	*
	* @return the user ID of this funcionario
	*/
	@Override
	public long getUserId() {
		return _funcionario.getUserId();
	}

	/**
	* Sets the user ID of this funcionario.
	*
	* @param userId the user ID of this funcionario
	*/
	@Override
	public void setUserId(long userId) {
		_funcionario.setUserId(userId);
	}

	/**
	* Returns the user uuid of this funcionario.
	*
	* @return the user uuid of this funcionario
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funcionario.getUserUuid();
	}

	/**
	* Sets the user uuid of this funcionario.
	*
	* @param userUuid the user uuid of this funcionario
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_funcionario.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _funcionario.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_funcionario.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _funcionario.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_funcionario.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _funcionario.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _funcionario.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_funcionario.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _funcionario.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_funcionario.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_funcionario.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_funcionario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FuncionarioWrapper((Funcionario)_funcionario.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.appcomercial.servico.model.Funcionario funcionario) {
		return _funcionario.compareTo(funcionario);
	}

	@Override
	public int hashCode() {
		return _funcionario.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.appcomercial.servico.model.Funcionario> toCacheModel() {
		return _funcionario.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario toEscapedModel() {
		return new FuncionarioWrapper(_funcionario.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.appcomercial.servico.model.Funcionario toUnescapedModel() {
		return new FuncionarioWrapper(_funcionario.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _funcionario.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _funcionario.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_funcionario.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FuncionarioWrapper)) {
			return false;
		}

		FuncionarioWrapper funcionarioWrapper = (FuncionarioWrapper)obj;

		if (Validator.equals(_funcionario, funcionarioWrapper._funcionario)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Funcionario getWrappedFuncionario() {
		return _funcionario;
	}

	@Override
	public Funcionario getWrappedModel() {
		return _funcionario;
	}

	@Override
	public void resetOriginalValues() {
		_funcionario.resetOriginalValues();
	}

	private Funcionario _funcionario;
}