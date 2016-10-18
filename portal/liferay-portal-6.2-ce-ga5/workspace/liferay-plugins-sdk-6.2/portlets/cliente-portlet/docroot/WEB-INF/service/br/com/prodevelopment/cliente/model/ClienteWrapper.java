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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Cliente}.
 * </p>
 *
 * @author marcelo
 * @see Cliente
 * @generated
 */
public class ClienteWrapper implements Cliente, ModelWrapper<Cliente> {
	public ClienteWrapper(Cliente cliente) {
		_cliente = cliente;
	}

	@Override
	public Class<?> getModelClass() {
		return Cliente.class;
	}

	@Override
	public String getModelClassName() {
		return Cliente.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("clienteId", getClienteId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("rgInscricaoMun", getRgInscricaoMun());
		attributes.put("rgOrgaoEmissor", getRgOrgaoEmissor());
		attributes.put("rgDataEmissao", getRgDataEmissao());
		attributes.put("tipoPessoa", getTipoPessoa());
		attributes.put("cpfCnpj", getCpfCnpj());
		attributes.put("sexo", getSexo());
		attributes.put("estadoCivil", getEstadoCivil());
		attributes.put("dataNascimento", getDataNascimento());
		attributes.put("endComLogradouro", getEndComLogradouro());
		attributes.put("endComNumero", getEndComNumero());
		attributes.put("endComComplemento", getEndComComplemento());
		attributes.put("endComCep", getEndComCep());
		attributes.put("endComBairro", getEndComBairro());
		attributes.put("endComCidade", getEndComCidade());
		attributes.put("endComUf", getEndComUf());
		attributes.put("endComPais", getEndComPais());
		attributes.put("endResLogradouro", getEndResLogradouro());
		attributes.put("endResNumero", getEndResNumero());
		attributes.put("endResComplemento", getEndResComplemento());
		attributes.put("endResCep", getEndResCep());
		attributes.put("endResBairro", getEndResBairro());
		attributes.put("endResCidade", getEndResCidade());
		attributes.put("endResUf", getEndResUf());
		attributes.put("endResPais", getEndResPais());
		attributes.put("telComDdd", getTelComDdd());
		attributes.put("versao", getVersao());
		attributes.put("logoTipoId", getLogoTipoId());
		attributes.put("observacao", getObservacao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long clienteId = (Long)attributes.get("clienteId");

		if (clienteId != null) {
			setClienteId(clienteId);
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

		String rgInscricaoMun = (String)attributes.get("rgInscricaoMun");

		if (rgInscricaoMun != null) {
			setRgInscricaoMun(rgInscricaoMun);
		}

		String rgOrgaoEmissor = (String)attributes.get("rgOrgaoEmissor");

		if (rgOrgaoEmissor != null) {
			setRgOrgaoEmissor(rgOrgaoEmissor);
		}

		Date rgDataEmissao = (Date)attributes.get("rgDataEmissao");

		if (rgDataEmissao != null) {
			setRgDataEmissao(rgDataEmissao);
		}

		String tipoPessoa = (String)attributes.get("tipoPessoa");

		if (tipoPessoa != null) {
			setTipoPessoa(tipoPessoa);
		}

		String cpfCnpj = (String)attributes.get("cpfCnpj");

		if (cpfCnpj != null) {
			setCpfCnpj(cpfCnpj);
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

		String endComNumero = (String)attributes.get("endComNumero");

		if (endComNumero != null) {
			setEndComNumero(endComNumero);
		}

		String endComComplemento = (String)attributes.get("endComComplemento");

		if (endComComplemento != null) {
			setEndComComplemento(endComComplemento);
		}

		String endComCep = (String)attributes.get("endComCep");

		if (endComCep != null) {
			setEndComCep(endComCep);
		}

		String endComBairro = (String)attributes.get("endComBairro");

		if (endComBairro != null) {
			setEndComBairro(endComBairro);
		}

		Long endComCidade = (Long)attributes.get("endComCidade");

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

		String endResNumero = (String)attributes.get("endResNumero");

		if (endResNumero != null) {
			setEndResNumero(endResNumero);
		}

		String endResComplemento = (String)attributes.get("endResComplemento");

		if (endResComplemento != null) {
			setEndResComplemento(endResComplemento);
		}

		String endResCep = (String)attributes.get("endResCep");

		if (endResCep != null) {
			setEndResCep(endResCep);
		}

		String endResBairro = (String)attributes.get("endResBairro");

		if (endResBairro != null) {
			setEndResBairro(endResBairro);
		}

		Long endResCidade = (Long)attributes.get("endResCidade");

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

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}

		Long logoTipoId = (Long)attributes.get("logoTipoId");

		if (logoTipoId != null) {
			setLogoTipoId(logoTipoId);
		}

		String observacao = (String)attributes.get("observacao");

		if (observacao != null) {
			setObservacao(observacao);
		}
	}

	/**
	* Returns the primary key of this cliente.
	*
	* @return the primary key of this cliente
	*/
	@Override
	public long getPrimaryKey() {
		return _cliente.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cliente.
	*
	* @param primaryKey the primary key of this cliente
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cliente.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this cliente.
	*
	* @return the uuid of this cliente
	*/
	@Override
	public java.lang.String getUuid() {
		return _cliente.getUuid();
	}

	/**
	* Sets the uuid of this cliente.
	*
	* @param uuid the uuid of this cliente
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_cliente.setUuid(uuid);
	}

	/**
	* Returns the cliente ID of this cliente.
	*
	* @return the cliente ID of this cliente
	*/
	@Override
	public long getClienteId() {
		return _cliente.getClienteId();
	}

	/**
	* Sets the cliente ID of this cliente.
	*
	* @param clienteId the cliente ID of this cliente
	*/
	@Override
	public void setClienteId(long clienteId) {
		_cliente.setClienteId(clienteId);
	}

	/**
	* Returns the company ID of this cliente.
	*
	* @return the company ID of this cliente
	*/
	@Override
	public long getCompanyId() {
		return _cliente.getCompanyId();
	}

	/**
	* Sets the company ID of this cliente.
	*
	* @param companyId the company ID of this cliente
	*/
	@Override
	public void setCompanyId(long companyId) {
		_cliente.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this cliente.
	*
	* @return the group ID of this cliente
	*/
	@Override
	public long getGroupId() {
		return _cliente.getGroupId();
	}

	/**
	* Sets the group ID of this cliente.
	*
	* @param groupId the group ID of this cliente
	*/
	@Override
	public void setGroupId(long groupId) {
		_cliente.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this cliente.
	*
	* @return the create user ID of this cliente
	*/
	@Override
	public long getCreateUserId() {
		return _cliente.getCreateUserId();
	}

	/**
	* Sets the create user ID of this cliente.
	*
	* @param createUserId the create user ID of this cliente
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_cliente.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this cliente.
	*
	* @return the create user uuid of this cliente
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cliente.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this cliente.
	*
	* @param createUserUuid the create user uuid of this cliente
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_cliente.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this cliente.
	*
	* @return the modified user ID of this cliente
	*/
	@Override
	public long getModifiedUserId() {
		return _cliente.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this cliente.
	*
	* @param modifiedUserId the modified user ID of this cliente
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_cliente.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this cliente.
	*
	* @return the modified user uuid of this cliente
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cliente.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this cliente.
	*
	* @param modifiedUserUuid the modified user uuid of this cliente
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_cliente.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this cliente.
	*
	* @return the create date of this cliente
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _cliente.getCreateDate();
	}

	/**
	* Sets the create date of this cliente.
	*
	* @param createDate the create date of this cliente
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_cliente.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this cliente.
	*
	* @return the modified date of this cliente
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _cliente.getModifiedDate();
	}

	/**
	* Sets the modified date of this cliente.
	*
	* @param modifiedDate the modified date of this cliente
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cliente.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nome of this cliente.
	*
	* @return the nome of this cliente
	*/
	@Override
	public java.lang.String getNome() {
		return _cliente.getNome();
	}

	/**
	* Sets the nome of this cliente.
	*
	* @param nome the nome of this cliente
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_cliente.setNome(nome);
	}

	/**
	* Returns the rg inscricao mun of this cliente.
	*
	* @return the rg inscricao mun of this cliente
	*/
	@Override
	public java.lang.String getRgInscricaoMun() {
		return _cliente.getRgInscricaoMun();
	}

	/**
	* Sets the rg inscricao mun of this cliente.
	*
	* @param rgInscricaoMun the rg inscricao mun of this cliente
	*/
	@Override
	public void setRgInscricaoMun(java.lang.String rgInscricaoMun) {
		_cliente.setRgInscricaoMun(rgInscricaoMun);
	}

	/**
	* Returns the rg orgao emissor of this cliente.
	*
	* @return the rg orgao emissor of this cliente
	*/
	@Override
	public java.lang.String getRgOrgaoEmissor() {
		return _cliente.getRgOrgaoEmissor();
	}

	/**
	* Sets the rg orgao emissor of this cliente.
	*
	* @param rgOrgaoEmissor the rg orgao emissor of this cliente
	*/
	@Override
	public void setRgOrgaoEmissor(java.lang.String rgOrgaoEmissor) {
		_cliente.setRgOrgaoEmissor(rgOrgaoEmissor);
	}

	/**
	* Returns the rg data emissao of this cliente.
	*
	* @return the rg data emissao of this cliente
	*/
	@Override
	public java.util.Date getRgDataEmissao() {
		return _cliente.getRgDataEmissao();
	}

	/**
	* Sets the rg data emissao of this cliente.
	*
	* @param rgDataEmissao the rg data emissao of this cliente
	*/
	@Override
	public void setRgDataEmissao(java.util.Date rgDataEmissao) {
		_cliente.setRgDataEmissao(rgDataEmissao);
	}

	/**
	* Returns the tipo pessoa of this cliente.
	*
	* @return the tipo pessoa of this cliente
	*/
	@Override
	public java.lang.String getTipoPessoa() {
		return _cliente.getTipoPessoa();
	}

	/**
	* Sets the tipo pessoa of this cliente.
	*
	* @param tipoPessoa the tipo pessoa of this cliente
	*/
	@Override
	public void setTipoPessoa(java.lang.String tipoPessoa) {
		_cliente.setTipoPessoa(tipoPessoa);
	}

	/**
	* Returns the cpf cnpj of this cliente.
	*
	* @return the cpf cnpj of this cliente
	*/
	@Override
	public java.lang.String getCpfCnpj() {
		return _cliente.getCpfCnpj();
	}

	/**
	* Sets the cpf cnpj of this cliente.
	*
	* @param cpfCnpj the cpf cnpj of this cliente
	*/
	@Override
	public void setCpfCnpj(java.lang.String cpfCnpj) {
		_cliente.setCpfCnpj(cpfCnpj);
	}

	/**
	* Returns the sexo of this cliente.
	*
	* @return the sexo of this cliente
	*/
	@Override
	public java.lang.String getSexo() {
		return _cliente.getSexo();
	}

	/**
	* Sets the sexo of this cliente.
	*
	* @param sexo the sexo of this cliente
	*/
	@Override
	public void setSexo(java.lang.String sexo) {
		_cliente.setSexo(sexo);
	}

	/**
	* Returns the estado civil of this cliente.
	*
	* @return the estado civil of this cliente
	*/
	@Override
	public java.lang.String getEstadoCivil() {
		return _cliente.getEstadoCivil();
	}

	/**
	* Sets the estado civil of this cliente.
	*
	* @param estadoCivil the estado civil of this cliente
	*/
	@Override
	public void setEstadoCivil(java.lang.String estadoCivil) {
		_cliente.setEstadoCivil(estadoCivil);
	}

	/**
	* Returns the data nascimento of this cliente.
	*
	* @return the data nascimento of this cliente
	*/
	@Override
	public java.util.Date getDataNascimento() {
		return _cliente.getDataNascimento();
	}

	/**
	* Sets the data nascimento of this cliente.
	*
	* @param dataNascimento the data nascimento of this cliente
	*/
	@Override
	public void setDataNascimento(java.util.Date dataNascimento) {
		_cliente.setDataNascimento(dataNascimento);
	}

	/**
	* Returns the end com logradouro of this cliente.
	*
	* @return the end com logradouro of this cliente
	*/
	@Override
	public java.lang.String getEndComLogradouro() {
		return _cliente.getEndComLogradouro();
	}

	/**
	* Sets the end com logradouro of this cliente.
	*
	* @param endComLogradouro the end com logradouro of this cliente
	*/
	@Override
	public void setEndComLogradouro(java.lang.String endComLogradouro) {
		_cliente.setEndComLogradouro(endComLogradouro);
	}

	/**
	* Returns the end com numero of this cliente.
	*
	* @return the end com numero of this cliente
	*/
	@Override
	public java.lang.String getEndComNumero() {
		return _cliente.getEndComNumero();
	}

	/**
	* Sets the end com numero of this cliente.
	*
	* @param endComNumero the end com numero of this cliente
	*/
	@Override
	public void setEndComNumero(java.lang.String endComNumero) {
		_cliente.setEndComNumero(endComNumero);
	}

	/**
	* Returns the end com complemento of this cliente.
	*
	* @return the end com complemento of this cliente
	*/
	@Override
	public java.lang.String getEndComComplemento() {
		return _cliente.getEndComComplemento();
	}

	/**
	* Sets the end com complemento of this cliente.
	*
	* @param endComComplemento the end com complemento of this cliente
	*/
	@Override
	public void setEndComComplemento(java.lang.String endComComplemento) {
		_cliente.setEndComComplemento(endComComplemento);
	}

	/**
	* Returns the end com cep of this cliente.
	*
	* @return the end com cep of this cliente
	*/
	@Override
	public java.lang.String getEndComCep() {
		return _cliente.getEndComCep();
	}

	/**
	* Sets the end com cep of this cliente.
	*
	* @param endComCep the end com cep of this cliente
	*/
	@Override
	public void setEndComCep(java.lang.String endComCep) {
		_cliente.setEndComCep(endComCep);
	}

	/**
	* Returns the end com bairro of this cliente.
	*
	* @return the end com bairro of this cliente
	*/
	@Override
	public java.lang.String getEndComBairro() {
		return _cliente.getEndComBairro();
	}

	/**
	* Sets the end com bairro of this cliente.
	*
	* @param endComBairro the end com bairro of this cliente
	*/
	@Override
	public void setEndComBairro(java.lang.String endComBairro) {
		_cliente.setEndComBairro(endComBairro);
	}

	/**
	* Returns the end com cidade of this cliente.
	*
	* @return the end com cidade of this cliente
	*/
	@Override
	public long getEndComCidade() {
		return _cliente.getEndComCidade();
	}

	/**
	* Sets the end com cidade of this cliente.
	*
	* @param endComCidade the end com cidade of this cliente
	*/
	@Override
	public void setEndComCidade(long endComCidade) {
		_cliente.setEndComCidade(endComCidade);
	}

	/**
	* Returns the end com uf of this cliente.
	*
	* @return the end com uf of this cliente
	*/
	@Override
	public java.lang.String getEndComUf() {
		return _cliente.getEndComUf();
	}

	/**
	* Sets the end com uf of this cliente.
	*
	* @param endComUf the end com uf of this cliente
	*/
	@Override
	public void setEndComUf(java.lang.String endComUf) {
		_cliente.setEndComUf(endComUf);
	}

	/**
	* Returns the end com pais of this cliente.
	*
	* @return the end com pais of this cliente
	*/
	@Override
	public java.lang.String getEndComPais() {
		return _cliente.getEndComPais();
	}

	/**
	* Sets the end com pais of this cliente.
	*
	* @param endComPais the end com pais of this cliente
	*/
	@Override
	public void setEndComPais(java.lang.String endComPais) {
		_cliente.setEndComPais(endComPais);
	}

	/**
	* Returns the end res logradouro of this cliente.
	*
	* @return the end res logradouro of this cliente
	*/
	@Override
	public java.lang.String getEndResLogradouro() {
		return _cliente.getEndResLogradouro();
	}

	/**
	* Sets the end res logradouro of this cliente.
	*
	* @param endResLogradouro the end res logradouro of this cliente
	*/
	@Override
	public void setEndResLogradouro(java.lang.String endResLogradouro) {
		_cliente.setEndResLogradouro(endResLogradouro);
	}

	/**
	* Returns the end res numero of this cliente.
	*
	* @return the end res numero of this cliente
	*/
	@Override
	public java.lang.String getEndResNumero() {
		return _cliente.getEndResNumero();
	}

	/**
	* Sets the end res numero of this cliente.
	*
	* @param endResNumero the end res numero of this cliente
	*/
	@Override
	public void setEndResNumero(java.lang.String endResNumero) {
		_cliente.setEndResNumero(endResNumero);
	}

	/**
	* Returns the end res complemento of this cliente.
	*
	* @return the end res complemento of this cliente
	*/
	@Override
	public java.lang.String getEndResComplemento() {
		return _cliente.getEndResComplemento();
	}

	/**
	* Sets the end res complemento of this cliente.
	*
	* @param endResComplemento the end res complemento of this cliente
	*/
	@Override
	public void setEndResComplemento(java.lang.String endResComplemento) {
		_cliente.setEndResComplemento(endResComplemento);
	}

	/**
	* Returns the end res cep of this cliente.
	*
	* @return the end res cep of this cliente
	*/
	@Override
	public java.lang.String getEndResCep() {
		return _cliente.getEndResCep();
	}

	/**
	* Sets the end res cep of this cliente.
	*
	* @param endResCep the end res cep of this cliente
	*/
	@Override
	public void setEndResCep(java.lang.String endResCep) {
		_cliente.setEndResCep(endResCep);
	}

	/**
	* Returns the end res bairro of this cliente.
	*
	* @return the end res bairro of this cliente
	*/
	@Override
	public java.lang.String getEndResBairro() {
		return _cliente.getEndResBairro();
	}

	/**
	* Sets the end res bairro of this cliente.
	*
	* @param endResBairro the end res bairro of this cliente
	*/
	@Override
	public void setEndResBairro(java.lang.String endResBairro) {
		_cliente.setEndResBairro(endResBairro);
	}

	/**
	* Returns the end res cidade of this cliente.
	*
	* @return the end res cidade of this cliente
	*/
	@Override
	public long getEndResCidade() {
		return _cliente.getEndResCidade();
	}

	/**
	* Sets the end res cidade of this cliente.
	*
	* @param endResCidade the end res cidade of this cliente
	*/
	@Override
	public void setEndResCidade(long endResCidade) {
		_cliente.setEndResCidade(endResCidade);
	}

	/**
	* Returns the end res uf of this cliente.
	*
	* @return the end res uf of this cliente
	*/
	@Override
	public java.lang.String getEndResUf() {
		return _cliente.getEndResUf();
	}

	/**
	* Sets the end res uf of this cliente.
	*
	* @param endResUf the end res uf of this cliente
	*/
	@Override
	public void setEndResUf(java.lang.String endResUf) {
		_cliente.setEndResUf(endResUf);
	}

	/**
	* Returns the end res pais of this cliente.
	*
	* @return the end res pais of this cliente
	*/
	@Override
	public java.lang.String getEndResPais() {
		return _cliente.getEndResPais();
	}

	/**
	* Sets the end res pais of this cliente.
	*
	* @param endResPais the end res pais of this cliente
	*/
	@Override
	public void setEndResPais(java.lang.String endResPais) {
		_cliente.setEndResPais(endResPais);
	}

	/**
	* Returns the tel com ddd of this cliente.
	*
	* @return the tel com ddd of this cliente
	*/
	@Override
	public java.lang.String getTelComDdd() {
		return _cliente.getTelComDdd();
	}

	/**
	* Sets the tel com ddd of this cliente.
	*
	* @param telComDdd the tel com ddd of this cliente
	*/
	@Override
	public void setTelComDdd(java.lang.String telComDdd) {
		_cliente.setTelComDdd(telComDdd);
	}

	/**
	* Returns the versao of this cliente.
	*
	* @return the versao of this cliente
	*/
	@Override
	public double getVersao() {
		return _cliente.getVersao();
	}

	/**
	* Sets the versao of this cliente.
	*
	* @param versao the versao of this cliente
	*/
	@Override
	public void setVersao(double versao) {
		_cliente.setVersao(versao);
	}

	/**
	* Returns the logo tipo ID of this cliente.
	*
	* @return the logo tipo ID of this cliente
	*/
	@Override
	public long getLogoTipoId() {
		return _cliente.getLogoTipoId();
	}

	/**
	* Sets the logo tipo ID of this cliente.
	*
	* @param logoTipoId the logo tipo ID of this cliente
	*/
	@Override
	public void setLogoTipoId(long logoTipoId) {
		_cliente.setLogoTipoId(logoTipoId);
	}

	/**
	* Returns the observacao of this cliente.
	*
	* @return the observacao of this cliente
	*/
	@Override
	public java.lang.String getObservacao() {
		return _cliente.getObservacao();
	}

	/**
	* Sets the observacao of this cliente.
	*
	* @param observacao the observacao of this cliente
	*/
	@Override
	public void setObservacao(java.lang.String observacao) {
		_cliente.setObservacao(observacao);
	}

	@Override
	public boolean isNew() {
		return _cliente.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cliente.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cliente.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cliente.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cliente.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cliente.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cliente.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cliente.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cliente.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cliente.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cliente.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClienteWrapper((Cliente)_cliente.clone());
	}

	@Override
	public int compareTo(br.com.prodevelopment.cliente.model.Cliente cliente) {
		return _cliente.compareTo(cliente);
	}

	@Override
	public int hashCode() {
		return _cliente.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.cliente.model.Cliente> toCacheModel() {
		return _cliente.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.cliente.model.Cliente toEscapedModel() {
		return new ClienteWrapper(_cliente.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.cliente.model.Cliente toUnescapedModel() {
		return new ClienteWrapper(_cliente.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cliente.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cliente.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cliente.persist();
	}

	@Override
	public java.lang.String getLogoTipoURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cliente.getLogoTipoURL(themeDisplay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClienteWrapper)) {
			return false;
		}

		ClienteWrapper clienteWrapper = (ClienteWrapper)obj;

		if (Validator.equals(_cliente, clienteWrapper._cliente)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _cliente.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Cliente getWrappedCliente() {
		return _cliente;
	}

	@Override
	public Cliente getWrappedModel() {
		return _cliente;
	}

	@Override
	public void resetOriginalValues() {
		_cliente.resetOriginalValues();
	}

	private Cliente _cliente;
}