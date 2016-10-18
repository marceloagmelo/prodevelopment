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

import br.com.prodevelopment.cliente.service.ClienteLocalServiceUtil;
import br.com.prodevelopment.cliente.service.ClpSerializer;

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
 * @author marcelo
 */
public class ClienteClp extends BaseModelImpl<Cliente> implements Cliente {
	public ClienteClp() {
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
	public long getPrimaryKey() {
		return _clienteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClienteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clienteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_clienteRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClienteId() {
		return _clienteId;
	}

	@Override
	public void setClienteId(long clienteId) {
		_clienteId = clienteId;

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setClienteId", long.class);

				method.invoke(_clienteRemoteModel, clienteId);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_clienteRemoteModel, companyId);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_clienteRemoteModel, groupId);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_clienteRemoteModel, createUserId);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_clienteRemoteModel, modifiedUserId);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_clienteRemoteModel, createDate);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_clienteRemoteModel, modifiedDate);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_clienteRemoteModel, nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRgInscricaoMun() {
		return _rgInscricaoMun;
	}

	@Override
	public void setRgInscricaoMun(String rgInscricaoMun) {
		_rgInscricaoMun = rgInscricaoMun;

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setRgInscricaoMun",
						String.class);

				method.invoke(_clienteRemoteModel, rgInscricaoMun);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setRgOrgaoEmissor",
						String.class);

				method.invoke(_clienteRemoteModel, rgOrgaoEmissor);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setRgDataEmissao", Date.class);

				method.invoke(_clienteRemoteModel, rgDataEmissao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoPessoa() {
		return _tipoPessoa;
	}

	@Override
	public void setTipoPessoa(String tipoPessoa) {
		_tipoPessoa = tipoPessoa;

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoPessoa", String.class);

				method.invoke(_clienteRemoteModel, tipoPessoa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCpfCnpj() {
		return _cpfCnpj;
	}

	@Override
	public void setCpfCnpj(String cpfCnpj) {
		_cpfCnpj = cpfCnpj;

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setCpfCnpj", String.class);

				method.invoke(_clienteRemoteModel, cpfCnpj);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setSexo", String.class);

				method.invoke(_clienteRemoteModel, sexo);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEstadoCivil", String.class);

				method.invoke(_clienteRemoteModel, estadoCivil);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setDataNascimento", Date.class);

				method.invoke(_clienteRemoteModel, dataNascimento);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComLogradouro",
						String.class);

				method.invoke(_clienteRemoteModel, endComLogradouro);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComNumero", String.class);

				method.invoke(_clienteRemoteModel, endComNumero);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComComplemento",
						String.class);

				method.invoke(_clienteRemoteModel, endComComplemento);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComCep", String.class);

				method.invoke(_clienteRemoteModel, endComCep);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComBairro", String.class);

				method.invoke(_clienteRemoteModel, endComBairro);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComCidade", long.class);

				method.invoke(_clienteRemoteModel, endComCidade);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComUf", String.class);

				method.invoke(_clienteRemoteModel, endComUf);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndComPais", String.class);

				method.invoke(_clienteRemoteModel, endComPais);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResLogradouro",
						String.class);

				method.invoke(_clienteRemoteModel, endResLogradouro);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResNumero", String.class);

				method.invoke(_clienteRemoteModel, endResNumero);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResComplemento",
						String.class);

				method.invoke(_clienteRemoteModel, endResComplemento);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResCep", String.class);

				method.invoke(_clienteRemoteModel, endResCep);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResBairro", String.class);

				method.invoke(_clienteRemoteModel, endResBairro);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResCidade", long.class);

				method.invoke(_clienteRemoteModel, endResCidade);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResUf", String.class);

				method.invoke(_clienteRemoteModel, endResUf);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndResPais", String.class);

				method.invoke(_clienteRemoteModel, endResPais);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelComDdd() {
		return _telComDdd;
	}

	@Override
	public void setTelComDdd(String telComDdd) {
		_telComDdd = telComDdd;

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setTelComDdd", String.class);

				method.invoke(_clienteRemoteModel, telComDdd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getVersao() {
		return _versao;
	}

	@Override
	public void setVersao(double versao) {
		_versao = versao;

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setVersao", double.class);

				method.invoke(_clienteRemoteModel, versao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLogoTipoId() {
		return _logoTipoId;
	}

	@Override
	public void setLogoTipoId(long logoTipoId) {
		_logoTipoId = logoTipoId;

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setLogoTipoId", long.class);

				method.invoke(_clienteRemoteModel, logoTipoId);
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

		if (_clienteRemoteModel != null) {
			try {
				Class<?> clazz = _clienteRemoteModel.getClass();

				Method method = clazz.getMethod("setObservacao", String.class);

				method.invoke(_clienteRemoteModel, observacao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getLogoTipoURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		try {
			String methodName = "getLogoTipoURL";

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
				Cliente.class.getName()));
	}

	public BaseModel<?> getClienteRemoteModel() {
		return _clienteRemoteModel;
	}

	public void setClienteRemoteModel(BaseModel<?> clienteRemoteModel) {
		_clienteRemoteModel = clienteRemoteModel;
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

		Class<?> remoteModelClass = _clienteRemoteModel.getClass();

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

		Object returnValue = method.invoke(_clienteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ClienteLocalServiceUtil.addCliente(this);
		}
		else {
			ClienteLocalServiceUtil.updateCliente(this);
		}
	}

	@Override
	public Cliente toEscapedModel() {
		return (Cliente)ProxyUtil.newProxyInstance(Cliente.class.getClassLoader(),
			new Class[] { Cliente.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ClienteClp clone = new ClienteClp();

		clone.setUuid(getUuid());
		clone.setClienteId(getClienteId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNome(getNome());
		clone.setRgInscricaoMun(getRgInscricaoMun());
		clone.setRgOrgaoEmissor(getRgOrgaoEmissor());
		clone.setRgDataEmissao(getRgDataEmissao());
		clone.setTipoPessoa(getTipoPessoa());
		clone.setCpfCnpj(getCpfCnpj());
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
		clone.setTelComDdd(getTelComDdd());
		clone.setVersao(getVersao());
		clone.setLogoTipoId(getLogoTipoId());
		clone.setObservacao(getObservacao());

		return clone;
	}

	@Override
	public int compareTo(Cliente cliente) {
		int value = 0;

		value = getNome().compareTo(cliente.getNome());

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

		if (!(obj instanceof ClienteClp)) {
			return false;
		}

		ClienteClp cliente = (ClienteClp)obj;

		long primaryKey = cliente.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", clienteId=");
		sb.append(getClienteId());
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
		sb.append(", rgInscricaoMun=");
		sb.append(getRgInscricaoMun());
		sb.append(", rgOrgaoEmissor=");
		sb.append(getRgOrgaoEmissor());
		sb.append(", rgDataEmissao=");
		sb.append(getRgDataEmissao());
		sb.append(", tipoPessoa=");
		sb.append(getTipoPessoa());
		sb.append(", cpfCnpj=");
		sb.append(getCpfCnpj());
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
		sb.append(", telComDdd=");
		sb.append(getTelComDdd());
		sb.append(", versao=");
		sb.append(getVersao());
		sb.append(", logoTipoId=");
		sb.append(getLogoTipoId());
		sb.append(", observacao=");
		sb.append(getObservacao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.cliente.model.Cliente");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clienteId</column-name><column-value><![CDATA[");
		sb.append(getClienteId());
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
			"<column><column-name>rgInscricaoMun</column-name><column-value><![CDATA[");
		sb.append(getRgInscricaoMun());
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
			"<column><column-name>tipoPessoa</column-name><column-value><![CDATA[");
		sb.append(getTipoPessoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cpfCnpj</column-name><column-value><![CDATA[");
		sb.append(getCpfCnpj());
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
			"<column><column-name>telComDdd</column-name><column-value><![CDATA[");
		sb.append(getTelComDdd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versao</column-name><column-value><![CDATA[");
		sb.append(getVersao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logoTipoId</column-name><column-value><![CDATA[");
		sb.append(getLogoTipoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>observacao</column-name><column-value><![CDATA[");
		sb.append(getObservacao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _clienteId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
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
	private BaseModel<?> _clienteRemoteModel;
}