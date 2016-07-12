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

package br.com.prodevelopment.funcionario.model;

import com.liferay.portal.kernel.lar.StagedModelType;
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
 * @author Marcelo Melo
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

		attributes.put("uuid", getUuid());
		attributes.put("funcionarioId", getFuncionarioId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("nomeReduzido", getNomeReduzido());
		attributes.put("observacao", getObservacao());
		attributes.put("rg", getRg());
		attributes.put("rgOrgaoEmissor", getRgOrgaoEmissor());
		attributes.put("rgDataEmissao", getRgDataEmissao());
		attributes.put("cpf", getCpf());
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
		attributes.put("dataEntrada", getDataEntrada());
		attributes.put("dataSaida", getDataSaida());
		attributes.put("existeUser", getExisteUser());
		attributes.put("userId", getUserId());
		attributes.put("versao", getVersao());
		attributes.put("cargoId", getCargoId());
		attributes.put("fotoId", getFotoId());
		attributes.put("ativo", getAtivo());
		attributes.put("salario", getSalario());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

		String nomeReduzido = (String)attributes.get("nomeReduzido");

		if (nomeReduzido != null) {
			setNomeReduzido(nomeReduzido);
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

		Double versao = (Double)attributes.get("versao");

		if (versao != null) {
			setVersao(versao);
		}

		Long cargoId = (Long)attributes.get("cargoId");

		if (cargoId != null) {
			setCargoId(cargoId);
		}

		Long fotoId = (Long)attributes.get("fotoId");

		if (fotoId != null) {
			setFotoId(fotoId);
		}

		Boolean ativo = (Boolean)attributes.get("ativo");

		if (ativo != null) {
			setAtivo(ativo);
		}

		Double salario = (Double)attributes.get("salario");

		if (salario != null) {
			setSalario(salario);
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
	* Returns the uuid of this funcionario.
	*
	* @return the uuid of this funcionario
	*/
	@Override
	public java.lang.String getUuid() {
		return _funcionario.getUuid();
	}

	/**
	* Sets the uuid of this funcionario.
	*
	* @param uuid the uuid of this funcionario
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_funcionario.setUuid(uuid);
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
	* Returns the nome reduzido of this funcionario.
	*
	* @return the nome reduzido of this funcionario
	*/
	@Override
	public java.lang.String getNomeReduzido() {
		return _funcionario.getNomeReduzido();
	}

	/**
	* Sets the nome reduzido of this funcionario.
	*
	* @param nomeReduzido the nome reduzido of this funcionario
	*/
	@Override
	public void setNomeReduzido(java.lang.String nomeReduzido) {
		_funcionario.setNomeReduzido(nomeReduzido);
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
	* Returns the end com numero of this funcionario.
	*
	* @return the end com numero of this funcionario
	*/
	@Override
	public java.lang.String getEndComNumero() {
		return _funcionario.getEndComNumero();
	}

	/**
	* Sets the end com numero of this funcionario.
	*
	* @param endComNumero the end com numero of this funcionario
	*/
	@Override
	public void setEndComNumero(java.lang.String endComNumero) {
		_funcionario.setEndComNumero(endComNumero);
	}

	/**
	* Returns the end com complemento of this funcionario.
	*
	* @return the end com complemento of this funcionario
	*/
	@Override
	public java.lang.String getEndComComplemento() {
		return _funcionario.getEndComComplemento();
	}

	/**
	* Sets the end com complemento of this funcionario.
	*
	* @param endComComplemento the end com complemento of this funcionario
	*/
	@Override
	public void setEndComComplemento(java.lang.String endComComplemento) {
		_funcionario.setEndComComplemento(endComComplemento);
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
	public long getEndComCidade() {
		return _funcionario.getEndComCidade();
	}

	/**
	* Sets the end com cidade of this funcionario.
	*
	* @param endComCidade the end com cidade of this funcionario
	*/
	@Override
	public void setEndComCidade(long endComCidade) {
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
	* Returns the end res numero of this funcionario.
	*
	* @return the end res numero of this funcionario
	*/
	@Override
	public java.lang.String getEndResNumero() {
		return _funcionario.getEndResNumero();
	}

	/**
	* Sets the end res numero of this funcionario.
	*
	* @param endResNumero the end res numero of this funcionario
	*/
	@Override
	public void setEndResNumero(java.lang.String endResNumero) {
		_funcionario.setEndResNumero(endResNumero);
	}

	/**
	* Returns the end res complemento of this funcionario.
	*
	* @return the end res complemento of this funcionario
	*/
	@Override
	public java.lang.String getEndResComplemento() {
		return _funcionario.getEndResComplemento();
	}

	/**
	* Sets the end res complemento of this funcionario.
	*
	* @param endResComplemento the end res complemento of this funcionario
	*/
	@Override
	public void setEndResComplemento(java.lang.String endResComplemento) {
		_funcionario.setEndResComplemento(endResComplemento);
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
	public long getEndResCidade() {
		return _funcionario.getEndResCidade();
	}

	/**
	* Sets the end res cidade of this funcionario.
	*
	* @param endResCidade the end res cidade of this funcionario
	*/
	@Override
	public void setEndResCidade(long endResCidade) {
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

	/**
	* Returns the versao of this funcionario.
	*
	* @return the versao of this funcionario
	*/
	@Override
	public double getVersao() {
		return _funcionario.getVersao();
	}

	/**
	* Sets the versao of this funcionario.
	*
	* @param versao the versao of this funcionario
	*/
	@Override
	public void setVersao(double versao) {
		_funcionario.setVersao(versao);
	}

	/**
	* Returns the cargo ID of this funcionario.
	*
	* @return the cargo ID of this funcionario
	*/
	@Override
	public long getCargoId() {
		return _funcionario.getCargoId();
	}

	/**
	* Sets the cargo ID of this funcionario.
	*
	* @param cargoId the cargo ID of this funcionario
	*/
	@Override
	public void setCargoId(long cargoId) {
		_funcionario.setCargoId(cargoId);
	}

	/**
	* Returns the foto ID of this funcionario.
	*
	* @return the foto ID of this funcionario
	*/
	@Override
	public long getFotoId() {
		return _funcionario.getFotoId();
	}

	/**
	* Sets the foto ID of this funcionario.
	*
	* @param fotoId the foto ID of this funcionario
	*/
	@Override
	public void setFotoId(long fotoId) {
		_funcionario.setFotoId(fotoId);
	}

	/**
	* Returns the ativo of this funcionario.
	*
	* @return the ativo of this funcionario
	*/
	@Override
	public java.lang.Boolean getAtivo() {
		return _funcionario.getAtivo();
	}

	/**
	* Sets the ativo of this funcionario.
	*
	* @param ativo the ativo of this funcionario
	*/
	@Override
	public void setAtivo(java.lang.Boolean ativo) {
		_funcionario.setAtivo(ativo);
	}

	/**
	* Returns the salario of this funcionario.
	*
	* @return the salario of this funcionario
	*/
	@Override
	public double getSalario() {
		return _funcionario.getSalario();
	}

	/**
	* Sets the salario of this funcionario.
	*
	* @param salario the salario of this funcionario
	*/
	@Override
	public void setSalario(double salario) {
		_funcionario.setSalario(salario);
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
		br.com.prodevelopment.funcionario.model.Funcionario funcionario) {
		return _funcionario.compareTo(funcionario);
	}

	@Override
	public int hashCode() {
		return _funcionario.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.funcionario.model.Funcionario> toCacheModel() {
		return _funcionario.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario toEscapedModel() {
		return new FuncionarioWrapper(_funcionario.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.funcionario.model.Funcionario toUnescapedModel() {
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
	public java.lang.String getFotoURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funcionario.getFotoURL(themeDisplay);
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

	@Override
	public StagedModelType getStagedModelType() {
		return _funcionario.getStagedModelType();
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