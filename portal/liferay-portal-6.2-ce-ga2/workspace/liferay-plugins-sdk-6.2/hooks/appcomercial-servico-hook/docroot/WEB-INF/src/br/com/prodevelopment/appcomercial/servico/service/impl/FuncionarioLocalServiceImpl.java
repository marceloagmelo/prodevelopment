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

package br.com.prodevelopment.appcomercial.servico.service.impl;

import java.util.Date;
import java.util.List;

import br.com.prodevelopment.appcomercial.servico.FuncionarioCPFInvalidoException;
import br.com.prodevelopment.appcomercial.servico.FuncionarioDataEntradaInvalidaException;
import br.com.prodevelopment.appcomercial.servico.FuncionarioDataNascimentoInvalidaException;
import br.com.prodevelopment.appcomercial.servico.FuncionarioDataSaidaInvalidaException;
import br.com.prodevelopment.appcomercial.servico.FuncionarioEmailInvalidoException;
import br.com.prodevelopment.appcomercial.servico.FuncionarioLoginObrigatorioException;
import br.com.prodevelopment.appcomercial.servico.FuncionarioNomeObrigatorioException;
import br.com.prodevelopment.appcomercial.servico.FuncionarioRGDataEmissaoInvalidaException;
import br.com.prodevelopment.appcomercial.servico.model.Funcionario;
import br.com.prodevelopment.appcomercial.servico.service.base.FuncionarioLocalServiceBaseImpl;
import br.com.prodevelopment.appcomercial.servico.util.DateUtil;
import br.com.prodevelopment.appcomercial.servico.util.Helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the funcionario local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.appcomercial.servico.service.FuncionarioLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author marcelo
 * @see br.com.prodevelopment.appcomercial.servico.service.base.FuncionarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.appcomercial.servico.service.FuncionarioLocalServiceUtil
 */
public class FuncionarioLocalServiceImpl extends
		FuncionarioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment
	 * .appcomercial.servico.service.FuncionarioLocalServiceUtil} to access the
	 * funcionario local service.
	 */
	public Funcionario addFuncionario(long companyId, long groupId,
			long createUserId, String nome, String apelido, String observacao,
			String rg, String rgOrgaoEmissor, int rgDataEmissaoMonth,
			int rgDataEmissaoDay, int rgDataEmissaoYear, String cpf,
			String sexo, String estadoCivil, int dataNascimentoMonth,
			int dataNascimentoDay, int dataNascimentoYear,
			String endComLogradouro, String endComDescricao, String endComCep,
			String endComBairro, String endComCidade, String endComUf,
			String endComPais, String endResLogradouro, String endResDescricao,
			String endResCep, String endResBairro, String endResCidade,
			String endResUf, String endResPais, String telComDdd,
			String telComNumero, String telComRamal, String telResDdd,
			String telResNumero, String telCelDdd, String telCelNumero,
			String endEmail, int dataEntradaMonth, int dataEntradaDay,
			int dataEntradaYear, int dataSaidaMonth, int dataSaidaDay,
			int dataSaidaYear, boolean existeUser, String login)
			throws SystemException, PortalException {

		String sRgDataEmissao = Helper.zerosEsquerda(
				String.valueOf(rgDataEmissaoDay), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(rgDataEmissaoMonth+1), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(rgDataEmissaoYear), 4);

		String sDataNascimento = Helper.zerosEsquerda(
				String.valueOf(dataNascimentoDay), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataNascimentoMonth+1), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataNascimentoYear), 4);

		String sDataEntrada = Helper.zerosEsquerda(
				String.valueOf(dataEntradaDay), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataEntradaMonth+1), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataEntradaYear), 4);

		String sDataSaida = Helper.zerosEsquerda(
				String.valueOf(dataSaidaDay), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataSaidaMonth+1), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataSaidaYear), 4);

		boolean validarRgDataEmissao = ((rgDataEmissaoMonth+rgDataEmissaoDay+rgDataEmissaoYear) > 0);
		boolean validarDataNascimento = ((dataNascimentoMonth+dataNascimentoDay+dataNascimentoYear) > 0);
		boolean validarDataEntrada = ((dataEntradaMonth+dataEntradaDay+dataEntradaYear) > 0);
		boolean validarDataSaida = ((dataSaidaMonth+dataSaidaDay+dataSaidaYear) > 0);
		
		validate(nome, cpf, validarRgDataEmissao, sRgDataEmissao, validarDataNascimento, sDataNascimento, validarDataEntrada, sDataEntrada,
				validarDataSaida, sDataSaida, existeUser, endEmail, login);

		Date now = DateUtil.getDataAtual();
		
		Date rgDataEmissao = null;
		Date dataNascimento = null;
		Date dataEntrada = null;
		Date dataSaida = null;
		if (validarRgDataEmissao) {
			rgDataEmissao = PortalUtil.getDate(rgDataEmissaoMonth,
					rgDataEmissaoDay, rgDataEmissaoYear, 0, 0,
					FuncionarioRGDataEmissaoInvalidaException.class);
		}
		if (validarDataNascimento) {
			dataNascimento = PortalUtil.getDate(dataNascimentoMonth,
					dataNascimentoDay, dataNascimentoYear, 0, 0,
					FuncionarioDataNascimentoInvalidaException.class);
		}
		if (validarDataEntrada) {
			dataEntrada = PortalUtil.getDate(dataEntradaMonth,
					dataEntradaDay, dataEntradaYear, 0, 0,
					FuncionarioDataEntradaInvalidaException.class);
		}
		if (validarDataSaida) {
			dataSaida = PortalUtil.getDate(dataSaidaMonth,
					dataSaidaDay, dataSaidaYear, 0, 0,
					FuncionarioDataSaidaInvalidaException.class);
		}

		// Criar objeto incrementando um novo ID
		Funcionario funcionario = funcionarioPersistence
				.create(counterLocalService.increment(Funcionario.class
						.getName()));

		// Atribui novos valores
		funcionario.setCompanyId(companyId);
		funcionario.setGroupId(groupId);
		funcionario.setCreateUserId(createUserId);
		funcionario.setCreateDate(now);
		funcionario.setNome(nome);
		funcionario.setApelido(apelido);
		funcionario.setObservacao(observacao);
		funcionario.setCpf(cpf);
		funcionario.setDataNascimento(dataNascimento);
		funcionario.setEstadoCivil(estadoCivil);
		funcionario.setRg(rg);
		funcionario.setRgDataEmissao(rgDataEmissao);
		funcionario.setRgOrgaoEmissor(rgOrgaoEmissor);
		funcionario.setSexo(sexo);
		funcionario.setDataEntrada(dataEntrada);
		funcionario.setDataSaida(dataSaida);
		funcionario.setExisteUser(existeUser);
		funcionario.setEndComLogradouro(endComLogradouro);
		funcionario.setEndComDescricao(endComDescricao);
		funcionario.setEndComCep(endComCep);
		funcionario.setEndComBairro(endComBairro);
		funcionario.setEndComCidade(endComCidade);
		funcionario.setEndComUf(endComUf);
		funcionario.setEndComPais(endComPais);
		funcionario.setEndResLogradouro(endResLogradouro);
		funcionario.setEndResDescricao(endResDescricao);
		funcionario.setEndResCep(endResCep);
		funcionario.setEndResBairro(endResBairro);
		funcionario.setEndResCidade(endResCidade);
		funcionario.setEndResUf(endResUf);
		funcionario.setEndResPais(endResPais);
		funcionario.setTelComDdd(telComDdd);
		funcionario.setTelComNumero(telComNumero);
		funcionario.setTelComRamal(telComRamal);
		funcionario.setTelResDdd(telResDdd);
		funcionario.setTelResNumero(telResNumero);
		funcionario.setTelCelDdd(telCelDdd);
		funcionario.setTelCelNumero(telCelNumero);
		funcionario.setEndEmail(endEmail);

		funcionario.setNew(true);

		funcionario = funcionarioPersistence.update(funcionario);

		return funcionario;
	}

	public Funcionario update(long funcionarioId, long modifieduserId,
			String nome, String apelido, String observacao, String rg,
			String rgOrgaoEmissor, int rgDataEmissaoMonth,
			int rgDataEmissaoDay, int rgDataEmissaoYear, String cpf,
			String sexo, String estadoCivil, int dataNascimentoMonth,
			int dataNascimentoDay, int dataNascimentoYear,
			String endComLogradouro, String endComDescricao, String endComCep,
			String endComBairro, String endComCidade, String endComUf,
			String endComPais, String endResLogradouro, String endResDescricao,
			String endResCep, String endResBairro, String endResCidade,
			String endResUf, String endResPais, String telComDdd,
			String telComNumero, String telComRamal, String telResDdd,
			String telResNumero, String telCelDdd, String telCelNumero,
			String endEmail, int dataEntradaMonth, int dataEntradaDay,
			int dataEntradaYear, int dataSaidaMonth, int dataSaidaDay,
			int dataSaidaYear, boolean existeUser, String login)
			throws SystemException, PortalException {

		String sRgDataEmissao = Helper.zerosEsquerda(
				String.valueOf(rgDataEmissaoDay), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(rgDataEmissaoMonth+1), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(rgDataEmissaoYear), 4);

		String sDataNascimento = Helper.zerosEsquerda(
				String.valueOf(dataNascimentoDay), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataNascimentoMonth+1), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataNascimentoYear), 4);

		String sDataEntrada = Helper.zerosEsquerda(
				String.valueOf(dataEntradaDay), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataEntradaMonth+1), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataEntradaYear), 4);

		String sDataSaida = Helper.zerosEsquerda(
				String.valueOf(dataSaidaDay), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataSaidaMonth+1), 2)
				+ StringPool.FORWARD_SLASH
				+ Helper.zerosEsquerda(String.valueOf(dataSaidaYear), 4);

		boolean validarRgDataEmissao = ((rgDataEmissaoMonth+rgDataEmissaoDay+rgDataEmissaoYear) > 0);
		boolean validarDataNascimento = ((dataNascimentoMonth+dataNascimentoDay+dataNascimentoYear) > 0);
		boolean validarDataEntrada = ((dataEntradaMonth+dataEntradaDay+dataEntradaYear) > 0);
		boolean validarDataSaida = ((dataSaidaMonth+dataSaidaDay+dataSaidaYear) > 0);
		
		validate(nome, cpf, validarRgDataEmissao, sRgDataEmissao, validarDataNascimento, sDataNascimento, validarDataEntrada, sDataEntrada,
				validarDataSaida, sDataSaida, existeUser, endEmail, login);

		Date now = DateUtil.getDataAtual();
		
		Date rgDataEmissao = null;
		Date dataNascimento = null;
		Date dataEntrada = null;
		Date dataSaida = null;
		if (validarRgDataEmissao) {
			rgDataEmissao = PortalUtil.getDate(rgDataEmissaoMonth,
					rgDataEmissaoDay, rgDataEmissaoYear, 0, 0,
					FuncionarioRGDataEmissaoInvalidaException.class);
		}
		if (validarDataNascimento) {
			dataNascimento = PortalUtil.getDate(dataNascimentoMonth,
					dataNascimentoDay, dataNascimentoYear, 0, 0,
					FuncionarioDataNascimentoInvalidaException.class);
		}
		if (validarDataEntrada) {
			dataEntrada = PortalUtil.getDate(dataEntradaMonth,
					dataEntradaDay, dataEntradaYear, 0, 0,
					FuncionarioDataEntradaInvalidaException.class);
		}
		if (validarDataSaida) {
			dataSaida = PortalUtil.getDate(dataSaidaMonth,
					dataSaidaDay, dataSaidaYear, 0, 0,
					FuncionarioDataSaidaInvalidaException.class);
		}
		
		// Recuperar funcionario
		Funcionario funcionario = funcionarioPersistence
				.fetchByPrimaryKey(funcionarioId);

		// Atribui novos valores
		funcionario.setModifiedUserId(modifieduserId);
		funcionario.setModifiedDate(now);
		funcionario.setNome(nome);
		funcionario.setApelido(apelido);
		funcionario.setObservacao(observacao);
		funcionario.setCpf(cpf);
		funcionario.setDataNascimento(dataNascimento);
		funcionario.setEstadoCivil(estadoCivil);
		funcionario.setRg(rg);
		funcionario.setRgDataEmissao(rgDataEmissao);
		funcionario.setRgOrgaoEmissor(rgOrgaoEmissor);
		funcionario.setSexo(sexo);
		funcionario.setDataEntrada(dataEntrada);
		funcionario.setDataSaida(dataSaida);
		funcionario.setEndComLogradouro(endComLogradouro);
		funcionario.setEndComDescricao(endComDescricao);
		funcionario.setEndComCep(endComCep);
		funcionario.setEndComBairro(endComBairro);
		funcionario.setEndComCidade(endComCidade);
		funcionario.setEndComUf(endComUf);
		funcionario.setEndComPais(endComPais);
		funcionario.setEndResLogradouro(endResLogradouro);
		funcionario.setEndResDescricao(endResDescricao);
		funcionario.setEndResCep(endResCep);
		funcionario.setEndResBairro(endResBairro);
		funcionario.setEndResCidade(endResCidade);
		funcionario.setEndResUf(endResUf);
		funcionario.setEndResPais(endResPais);
		funcionario.setTelComDdd(telComDdd);
		funcionario.setTelComNumero(telComNumero);
		funcionario.setTelComRamal(telComRamal);
		funcionario.setTelResDdd(telResDdd);
		funcionario.setTelResNumero(telResNumero);
		funcionario.setTelCelDdd(telCelDdd);
		funcionario.setTelCelNumero(telCelNumero);
		funcionario.setEndEmail(endEmail);

		funcionario = funcionarioPersistence.update(funcionario);

		return funcionario;
	}

	public List<Funcionario> search(long companyId, long groupId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {

		return funcionarioPersistence.findByC_G_NOME(companyId, groupId, nome,
				start, end, orderByComparator);

	}

	public int searchCount(long companyId, long groupId, String nome)
			throws SystemException {
		return funcionarioPersistence.findByC_G_NOME(companyId, groupId, nome)
				.size();
	}

	public List<Funcionario> search(long companyId, long groupId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return funcionarioPersistence.findByC_G(companyId, groupId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return funcionarioPersistence.findByC_G(companyId, groupId).size();
	}

	public List<Funcionario> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return funcionarioPersistence.findByCompany(companyId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId) throws SystemException {
		return funcionarioPersistence.findByCompany(companyId).size();
	}

	protected void validate(String nome, String cpf, boolean validarRgDataEmissao, String rgDataEmissao,
			boolean validarDataNascimento, String dataNascimento, boolean validarDataEntrada, String dataEntrada, boolean validarDataSaida, String dataSaida,
			boolean existeUser, String email, String login)
			throws PortalException, SystemException {

		if (Validator.isNull(nome)) {
			throw new FuncionarioNomeObrigatorioException();
		}
		if ((Validator.isNotNull(cpf)) && (!Helper.isCPF(cpf))) {
			throw new FuncionarioCPFInvalidoException();
		}
		if ((validarRgDataEmissao) && (Validator.isNotNull(rgDataEmissao))
				&& (!DateUtil.isValidDate(rgDataEmissao,
						"dd/MM/yyyy"))) {
			throw new FuncionarioRGDataEmissaoInvalidaException();
		}
		if ((validarDataNascimento) && (Validator.isNotNull(dataNascimento))
				&& (!DateUtil.isValidDate(
						dataNascimento, "dd/MM/yyyy"))) {
			throw new FuncionarioDataNascimentoInvalidaException();
		}
		if (Validator.isNotNull(email)) {
			if (!Helper.validaEmail(email)) {
				throw new FuncionarioEmailInvalidoException();
			}
		}
		if ((validarDataEntrada) && (Validator.isNotNull(dataEntrada))
				&& (!DateUtil.isValidDate(dataEntrada,
						"dd/MM/yyyy"))) {
			throw new FuncionarioDataEntradaInvalidaException();
		}
		if ((validarDataSaida) && (Validator.isNotNull(dataSaida))
				&& (!DateUtil.isValidDate(dataSaida,
						"dd/MM/yyyy"))) {
			throw new FuncionarioDataSaidaInvalidaException();
		}
		if (existeUser) {
			if (Validator.isNull(login)) {
				throw new FuncionarioLoginObrigatorioException();
			}
		}
	}
}