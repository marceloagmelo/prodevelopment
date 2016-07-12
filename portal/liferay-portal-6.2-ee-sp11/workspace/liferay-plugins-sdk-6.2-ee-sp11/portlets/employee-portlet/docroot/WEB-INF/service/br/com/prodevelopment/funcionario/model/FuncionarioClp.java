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

import br.com.prodevelopment.funcionario.service.ClpSerializer;
import br.com.prodevelopment.funcionario.service.FuncionarioLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcelo Melo
 */
public class FuncionarioClp extends BaseModelImpl<Funcionario>
	implements Funcionario {
	public FuncionarioClp() {
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
	public long getPrimaryKey() {
		return _funcionarioId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFuncionarioId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _funcionarioId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_funcionarioRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFuncionarioId() {
		return _funcionarioId;
	}

	@Override
	public void setFuncionarioId(long funcionarioId) {
		_funcionarioId = funcionarioId;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setFuncionarioId", long.class);

				method.invoke(_funcionarioRemoteModel, funcionarioId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_funcionarioRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_funcionarioRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_funcionarioRemoteModel, createUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreateUserId(), "uuid",
			_createUserUuid);
	}

	@Override
	public void setCreateUserUuid(String createUserUuid) {
		_createUserUuid = createUserUuid;
	}

	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_funcionarioRemoteModel, modifiedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_funcionarioRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_funcionarioRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNome() {
		return _nome;
	}

	@Override
	public void setNome(String nome) {
		_nome = nome;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_funcionarioRemoteModel, nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeReduzido() {
		return _nomeReduzido;
	}

	@Override
	public void setNomeReduzido(String nomeReduzido) {
		_nomeReduzido = nomeReduzido;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeReduzido", String.class);

				method.invoke(_funcionarioRemoteModel, nomeReduzido);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObservacao() {
		return _observacao;
	}

	@Override
	public void setObservacao(String observacao) {
		_observacao = observacao;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setObservacao", String.class);

				method.invoke(_funcionarioRemoteModel, observacao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRg() {
		return _rg;
	}

	@Override
	public void setRg(String rg) {
		_rg = rg;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setRg", String.class);

				method.invoke(_funcionarioRemoteModel, rg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRgOrgaoEmissor() {
		return _rgOrgaoEmissor;
	}

	@Override
	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		_rgOrgaoEmissor = rgOrgaoEmissor;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setRgOrgaoEmissor",
						String.class);

				method.invoke(_funcionarioRemoteModel, rgOrgaoEmissor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRgDataEmissao() {
		return _rgDataEmissao;
	}

	@Override
	public void setRgDataEmissao(Date rgDataEmissao) {
		_rgDataEmissao = rgDataEmissao;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setRgDataEmissao", Date.class);

				method.invoke(_funcionarioRemoteModel, rgDataEmissao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCpf() {
		return _cpf;
	}

	@Override
	public void setCpf(String cpf) {
		_cpf = cpf;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setCpf", String.class);

				method.invoke(_funcionarioRemoteModel, cpf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSexo() {
		return _sexo;
	}

	@Override
	public void setSexo(String sexo) {
		_sexo = sexo;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setSexo", String.class);

				method.invoke(_funcionarioRemoteModel, sexo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEstadoCivil() {
		return _estadoCivil;
	}

	@Override
	public void setEstadoCivil(String estadoCivil) {
		_estadoCivil = estadoCivil;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEstadoCivil", String.class);

				method.invoke(_funcionarioRemoteModel, estadoCivil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataNascimento() {
		return _dataNascimento;
	}

	@Override
	public void setDataNascimento(Date dataNascimento) {
		_dataNascimento = dataNascimento;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setDataNascimento", Date.class);

				method.invoke(_funcionarioRemoteModel, dataNascimento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndComLogradouro() {
		return _endComLogradouro;
	}

	@Override
	public void setEndComLogradouro(String endComLogradouro) {
		_endComLogradouro = endComLogradouro;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComLogradouro",
						String.class);

				method.invoke(_funcionarioRemoteModel, endComLogradouro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndComNumero() {
		return _endComNumero;
	}

	@Override
	public void setEndComNumero(String endComNumero) {
		_endComNumero = endComNumero;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComNumero", String.class);

				method.invoke(_funcionarioRemoteModel, endComNumero);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndComComplemento() {
		return _endComComplemento;
	}

	@Override
	public void setEndComComplemento(String endComComplemento) {
		_endComComplemento = endComComplemento;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComComplemento",
						String.class);

				method.invoke(_funcionarioRemoteModel, endComComplemento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndComCep() {
		return _endComCep;
	}

	@Override
	public void setEndComCep(String endComCep) {
		_endComCep = endComCep;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComCep", String.class);

				method.invoke(_funcionarioRemoteModel, endComCep);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndComBairro() {
		return _endComBairro;
	}

	@Override
	public void setEndComBairro(String endComBairro) {
		_endComBairro = endComBairro;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComBairro", String.class);

				method.invoke(_funcionarioRemoteModel, endComBairro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEndComCidade() {
		return _endComCidade;
	}

	@Override
	public void setEndComCidade(long endComCidade) {
		_endComCidade = endComCidade;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComCidade", long.class);

				method.invoke(_funcionarioRemoteModel, endComCidade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndComUf() {
		return _endComUf;
	}

	@Override
	public void setEndComUf(String endComUf) {
		_endComUf = endComUf;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComUf", String.class);

				method.invoke(_funcionarioRemoteModel, endComUf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndComPais() {
		return _endComPais;
	}

	@Override
	public void setEndComPais(String endComPais) {
		_endComPais = endComPais;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComPais", String.class);

				method.invoke(_funcionarioRemoteModel, endComPais);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndResLogradouro() {
		return _endResLogradouro;
	}

	@Override
	public void setEndResLogradouro(String endResLogradouro) {
		_endResLogradouro = endResLogradouro;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResLogradouro",
						String.class);

				method.invoke(_funcionarioRemoteModel, endResLogradouro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndResNumero() {
		return _endResNumero;
	}

	@Override
	public void setEndResNumero(String endResNumero) {
		_endResNumero = endResNumero;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResNumero", String.class);

				method.invoke(_funcionarioRemoteModel, endResNumero);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndResComplemento() {
		return _endResComplemento;
	}

	@Override
	public void setEndResComplemento(String endResComplemento) {
		_endResComplemento = endResComplemento;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResComplemento",
						String.class);

				method.invoke(_funcionarioRemoteModel, endResComplemento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndResCep() {
		return _endResCep;
	}

	@Override
	public void setEndResCep(String endResCep) {
		_endResCep = endResCep;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResCep", String.class);

				method.invoke(_funcionarioRemoteModel, endResCep);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndResBairro() {
		return _endResBairro;
	}

	@Override
	public void setEndResBairro(String endResBairro) {
		_endResBairro = endResBairro;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResBairro", String.class);

				method.invoke(_funcionarioRemoteModel, endResBairro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEndResCidade() {
		return _endResCidade;
	}

	@Override
	public void setEndResCidade(long endResCidade) {
		_endResCidade = endResCidade;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResCidade", long.class);

				method.invoke(_funcionarioRemoteModel, endResCidade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndResUf() {
		return _endResUf;
	}

	@Override
	public void setEndResUf(String endResUf) {
		_endResUf = endResUf;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResUf", String.class);

				method.invoke(_funcionarioRemoteModel, endResUf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndResPais() {
		return _endResPais;
	}

	@Override
	public void setEndResPais(String endResPais) {
		_endResPais = endResPais;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResPais", String.class);

				method.invoke(_funcionarioRemoteModel, endResPais);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataEntrada() {
		return _dataEntrada;
	}

	@Override
	public void setDataEntrada(Date dataEntrada) {
		_dataEntrada = dataEntrada;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setDataEntrada", Date.class);

				method.invoke(_funcionarioRemoteModel, dataEntrada);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataSaida() {
		return _dataSaida;
	}

	@Override
	public void setDataSaida(Date dataSaida) {
		_dataSaida = dataSaida;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setDataSaida", Date.class);

				method.invoke(_funcionarioRemoteModel, dataSaida);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getExisteUser() {
		return _existeUser;
	}

	@Override
	public void setExisteUser(Boolean existeUser) {
		_existeUser = existeUser;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setExisteUser", Boolean.class);

				method.invoke(_funcionarioRemoteModel, existeUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_funcionarioRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public double getVersao() {
		return _versao;
	}

	@Override
	public void setVersao(double versao) {
		_versao = versao;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_funcionarioRemoteModel, versao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCargoId() {
		return _cargoId;
	}

	@Override
	public void setCargoId(long cargoId) {
		_cargoId = cargoId;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setCargoId", long.class);

				method.invoke(_funcionarioRemoteModel, cargoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFotoId() {
		return _fotoId;
	}

	@Override
	public void setFotoId(long fotoId) {
		_fotoId = fotoId;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setFotoId", long.class);

				method.invoke(_funcionarioRemoteModel, fotoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getAtivo() {
		return _ativo;
	}

	@Override
	public void setAtivo(Boolean ativo) {
		_ativo = ativo;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setAtivo", Boolean.class);

				method.invoke(_funcionarioRemoteModel, ativo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getSalario() {
		return _salario;
	}

	@Override
	public void setSalario(double salario) {
		_salario = salario;

		if (_funcionarioRemoteModel != null) {
			try {
				Class<?> clazz = _funcionarioRemoteModel.getClass();

				Method method = clazz.getMethod("setSalario", double.class);

				method.invoke(_funcionarioRemoteModel, salario);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getFotoURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		try {
			String methodName = "getFotoURL";

			Class<?>[] parameterTypes = new Class<?>[] {
					com.liferay.portal.theme.ThemeDisplay.class
				};

			Object[] parameterValues = new Object[] { themeDisplay };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Funcionario.class.getName()));
	}

	public BaseModel<?> getFuncionarioRemoteModel() {
		return _funcionarioRemoteModel;
	}

	public void setFuncionarioRemoteModel(BaseModel<?> funcionarioRemoteModel) {
		_funcionarioRemoteModel = funcionarioRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _funcionarioRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_funcionarioRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FuncionarioLocalServiceUtil.addFuncionario(this);
		}
		else {
			FuncionarioLocalServiceUtil.updateFuncionario(this);
		}
	}

	@Override
	public Funcionario toEscapedModel() {
		return (Funcionario)ProxyUtil.newProxyInstance(Funcionario.class.getClassLoader(),
			new Class[] { Funcionario.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FuncionarioClp clone = new FuncionarioClp();

		clone.setUuid(getUuid());
		clone.setFuncionarioId(getFuncionarioId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNome(getNome());
		clone.setNomeReduzido(getNomeReduzido());
		clone.setObservacao(getObservacao());
		clone.setRg(getRg());
		clone.setRgOrgaoEmissor(getRgOrgaoEmissor());
		clone.setRgDataEmissao(getRgDataEmissao());
		clone.setCpf(getCpf());
		clone.setSexo(getSexo());
		clone.setEstadoCivil(getEstadoCivil());
		clone.setDataNascimento(getDataNascimento());
		clone.setEndComLogradouro(getEndComLogradouro());
		clone.setEndComNumero(getEndComNumero());
		clone.setEndComComplemento(getEndComComplemento());
		clone.setEndComCep(getEndComCep());
		clone.setEndComBairro(getEndComBairro());
		clone.setEndComCidade(getEndComCidade());
		clone.setEndComUf(getEndComUf());
		clone.setEndComPais(getEndComPais());
		clone.setEndResLogradouro(getEndResLogradouro());
		clone.setEndResNumero(getEndResNumero());
		clone.setEndResComplemento(getEndResComplemento());
		clone.setEndResCep(getEndResCep());
		clone.setEndResBairro(getEndResBairro());
		clone.setEndResCidade(getEndResCidade());
		clone.setEndResUf(getEndResUf());
		clone.setEndResPais(getEndResPais());
		clone.setDataEntrada(getDataEntrada());
		clone.setDataSaida(getDataSaida());
		clone.setExisteUser(getExisteUser());
		clone.setUserId(getUserId());
		clone.setVersao(getVersao());
		clone.setCargoId(getCargoId());
		clone.setFotoId(getFotoId());
		clone.setAtivo(getAtivo());
		clone.setSalario(getSalario());

		return clone;
	}

	@Override
	public int compareTo(Funcionario funcionario) {
		int value = 0;

		value = getNome().compareTo(funcionario.getNome());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FuncionarioClp)) {
			return false;
		}

		FuncionarioClp funcionario = (FuncionarioClp)obj;

		long primaryKey = funcionario.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(87);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", funcionarioId=");
		sb.append(getFuncionarioId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", nomeReduzido=");
		sb.append(getNomeReduzido());
		sb.append(", observacao=");
		sb.append(getObservacao());
		sb.append(", rg=");
		sb.append(getRg());
		sb.append(", rgOrgaoEmissor=");
		sb.append(getRgOrgaoEmissor());
		sb.append(", rgDataEmissao=");
		sb.append(getRgDataEmissao());
		sb.append(", cpf=");
		sb.append(getCpf());
		sb.append(", sexo=");
		sb.append(getSexo());
		sb.append(", estadoCivil=");
		sb.append(getEstadoCivil());
		sb.append(", dataNascimento=");
		sb.append(getDataNascimento());
		sb.append(", endComLogradouro=");
		sb.append(getEndComLogradouro());
		sb.append(", endComNumero=");
		sb.append(getEndComNumero());
		sb.append(", endComComplemento=");
		sb.append(getEndComComplemento());
		sb.append(", endComCep=");
		sb.append(getEndComCep());
		sb.append(", endComBairro=");
		sb.append(getEndComBairro());
		sb.append(", endComCidade=");
		sb.append(getEndComCidade());
		sb.append(", endComUf=");
		sb.append(getEndComUf());
		sb.append(", endComPais=");
		sb.append(getEndComPais());
		sb.append(", endResLogradouro=");
		sb.append(getEndResLogradouro());
		sb.append(", endResNumero=");
		sb.append(getEndResNumero());
		sb.append(", endResComplemento=");
		sb.append(getEndResComplemento());
		sb.append(", endResCep=");
		sb.append(getEndResCep());
		sb.append(", endResBairro=");
		sb.append(getEndResBairro());
		sb.append(", endResCidade=");
		sb.append(getEndResCidade());
		sb.append(", endResUf=");
		sb.append(getEndResUf());
		sb.append(", endResPais=");
		sb.append(getEndResPais());
		sb.append(", dataEntrada=");
		sb.append(getDataEntrada());
		sb.append(", dataSaida=");
		sb.append(getDataSaida());
		sb.append(", existeUser=");
		sb.append(getExisteUser());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", versao=");
		sb.append(getVersao());
		sb.append(", cargoId=");
		sb.append(getCargoId());
		sb.append(", fotoId=");
		sb.append(getFotoId());
		sb.append(", ativo=");
		sb.append(getAtivo());
		sb.append(", salario=");
		sb.append(getSalario());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(133);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.funcionario.model.Funcionario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>funcionarioId</column-name><column-value><![CDATA[");
		sb.append(getFuncionarioId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomeReduzido</column-name><column-value><![CDATA[");
		sb.append(getNomeReduzido());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>observacao</column-name><column-value><![CDATA[");
		sb.append(getObservacao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rg</column-name><column-value><![CDATA[");
		sb.append(getRg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rgOrgaoEmissor</column-name><column-value><![CDATA[");
		sb.append(getRgOrgaoEmissor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rgDataEmissao</column-name><column-value><![CDATA[");
		sb.append(getRgDataEmissao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cpf</column-name><column-value><![CDATA[");
		sb.append(getCpf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sexo</column-name><column-value><![CDATA[");
		sb.append(getSexo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estadoCivil</column-name><column-value><![CDATA[");
		sb.append(getEstadoCivil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataNascimento</column-name><column-value><![CDATA[");
		sb.append(getDataNascimento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComLogradouro</column-name><column-value><![CDATA[");
		sb.append(getEndComLogradouro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComNumero</column-name><column-value><![CDATA[");
		sb.append(getEndComNumero());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComComplemento</column-name><column-value><![CDATA[");
		sb.append(getEndComComplemento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComCep</column-name><column-value><![CDATA[");
		sb.append(getEndComCep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComBairro</column-name><column-value><![CDATA[");
		sb.append(getEndComBairro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComCidade</column-name><column-value><![CDATA[");
		sb.append(getEndComCidade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComUf</column-name><column-value><![CDATA[");
		sb.append(getEndComUf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endComPais</column-name><column-value><![CDATA[");
		sb.append(getEndComPais());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endResLogradouro</column-name><column-value><![CDATA[");
		sb.append(getEndResLogradouro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endResNumero</column-name><column-value><![CDATA[");
		sb.append(getEndResNumero());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endResComplemento</column-name><column-value><![CDATA[");
		sb.append(getEndResComplemento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endResCep</column-name><column-value><![CDATA[");
		sb.append(getEndResCep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endResBairro</column-name><column-value><![CDATA[");
		sb.append(getEndResBairro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endResCidade</column-name><column-value><![CDATA[");
		sb.append(getEndResCidade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endResUf</column-name><column-value><![CDATA[");
		sb.append(getEndResUf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endResPais</column-name><column-value><![CDATA[");
		sb.append(getEndResPais());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataEntrada</column-name><column-value><![CDATA[");
		sb.append(getDataEntrada());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataSaida</column-name><column-value><![CDATA[");
		sb.append(getDataSaida());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>existeUser</column-name><column-value><![CDATA[");
		sb.append(getExisteUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargoId</column-name><column-value><![CDATA[");
		sb.append(getCargoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fotoId</column-name><column-value><![CDATA[");
		sb.append(getFotoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ativo</column-name><column-value><![CDATA[");
		sb.append(getAtivo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>salario</column-name><column-value><![CDATA[");
		sb.append(getSalario());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _funcionarioId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _nomeReduzido;
	private String _observacao;
	private String _rg;
	private String _rgOrgaoEmissor;
	private Date _rgDataEmissao;
	private String _cpf;
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
	private Date _dataEntrada;
	private Date _dataSaida;
	private Boolean _existeUser;
	private long _userId;
	private String _userUuid;
	private double _versao;
	private long _cargoId;
	private long _fotoId;
	private Boolean _ativo;
	private double _salario;
	private BaseModel<?> _funcionarioRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.funcionario.service.ClpSerializer.class;
}