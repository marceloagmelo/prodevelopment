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

package br.com.prodevelopment.funcionario.service.impl;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.model.Telefone;
import br.com.prodevelopment.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil;
import br.com.prodevelopment.contato.service.TelefoneLocalServiceUtil;
import br.com.prodevelopment.funcionario.FotoFuncionarioTamanhoException;
import br.com.prodevelopment.funcionario.FuncionarioAlteradoOutroUsuarioException;
import br.com.prodevelopment.funcionario.FuncionarioCPFDuplicadoException;
import br.com.prodevelopment.funcionario.FuncionarioCPFInvalidoException;
import br.com.prodevelopment.funcionario.FuncionarioDataEntradaInvalidaException;
import br.com.prodevelopment.funcionario.FuncionarioDataNascimentoInvalidaException;
import br.com.prodevelopment.funcionario.FuncionarioDataSaidaInvalidaException;
import br.com.prodevelopment.funcionario.FuncionarioNomeObrigatorioException;
import br.com.prodevelopment.funcionario.FuncionarioRGDataEmissaoInvalidaException;
import br.com.prodevelopment.funcionario.FuncionarioRGDuplicadoException;
import br.com.prodevelopment.funcionario.FuncionarioUsuarioDuplicadoException;
import br.com.prodevelopment.funcionario.model.Cargo;
import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.funcionario.service.base.FuncionarioLocalServiceBaseImpl;
import br.com.prodevelopment.portlet.funcionario.Constantes;
import br.com.prodevelopment.portlet.funcionario.social.FuncionarioActivityKeys;
import br.com.prodevelopment.portlet.funcionario.util.DateUtil;
import br.com.prodevelopment.portlet.funcionario.util.Helper;

import com.liferay.portal.UserPortraitTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.documentlibrary.ImageSizeException;

/**
 * The implementation of the funcionario local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.funcionario.service.FuncionarioLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author marcelo
 * @see br.com.prodevelopment.funcionario.service.base.FuncionarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.funcionario.service.FuncionarioLocalServiceUtil
 */
public class FuncionarioLocalServiceImpl extends
		FuncionarioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.funcionario.service.FuncionarioLocalServiceUtil} to
	 * access the funcionario local service.
	 */
	public Funcionario addFuncionario(long companyId, long groupId,
			long createUserId, String nome, String nomeReduzido,
			String observacao, String rg, String rgOrgaoEmissor,
			String rgDataEmissao, String cpf, String sexo, String estadoCivil,
			String dataNascimento, String endComLogradouro,
			String endComNumero, String endComComplemento, String endComCep,
			String endComBairro, long endComCidade, String endComUf,
			String endComPais, String endResLogradouro, String endResNumero,
			String endResComplemento, String endResCep, String endResBairro,
			long endResCidade, String endResUf, String endResPais,
			String dataEntrada, String dataSaida, boolean existeUser,
			long userId, double versao, long cargoId, boolean ativo,
			double salario, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, ServiceContext serviceContext)
			throws SystemException, PortalException {

		validate(0, nome, cpf, rg, rgDataEmissao, dataNascimento, dataEntrada,
				dataSaida, existeUser, userId, versao);

		Date now = DateUtil.getDataAtual();

		Date dRgDataEmissao = null;
		Date dDataNascimento = null;
		Date dDataEntrada = null;
		Date dDataSaida = null;
		if (Validator.isNotNull(rgDataEmissao)) {
			dRgDataEmissao = DateUtil.stringToDate(rgDataEmissao);
		}
		if (Validator.isNotNull(dataNascimento)) {
			dDataNascimento = DateUtil.stringToDate(dataNascimento);
		}
		if (Validator.isNotNull(dataEntrada)) {
			dDataEntrada = DateUtil.stringToDate(dataEntrada);
		}
		if (Validator.isNotNull(dataSaida)) {
			dDataSaida = DateUtil.stringToDate(dataSaida);
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
		funcionario.setNomeReduzido(nomeReduzido);
		funcionario.setObservacao(observacao);
		funcionario.setCpf(cpf);
		funcionario.setDataNascimento(dDataNascimento);
		funcionario.setEstadoCivil(estadoCivil);
		funcionario.setRg(rg);
		funcionario.setRgDataEmissao(dRgDataEmissao);
		funcionario.setRgOrgaoEmissor(rgOrgaoEmissor);
		funcionario.setSexo(sexo);
		funcionario.setDataEntrada(dDataEntrada);
		funcionario.setDataSaida(dDataSaida);
		funcionario.setExisteUser(existeUser);
		funcionario.setEndComLogradouro(endComLogradouro);
		funcionario.setEndComNumero(endComNumero);
		funcionario.setEndComComplemento(endComComplemento);
		funcionario.setEndComCep(endComCep);
		funcionario.setEndComBairro(endComBairro);
		funcionario.setEndComCidade(endComCidade);
		funcionario.setEndComUf(endComUf);
		funcionario.setEndComPais(endComPais);
		funcionario.setEndResLogradouro(endResLogradouro);
		funcionario.setEndResNumero(endResNumero);
		funcionario.setEndResComplemento(endResComplemento);
		funcionario.setEndResCep(endResCep);
		funcionario.setEndResBairro(endResBairro);
		funcionario.setEndResCidade(endResCidade);
		funcionario.setEndResUf(endResUf);
		funcionario.setEndResPais(endResPais);
		funcionario.setUserId(userId);
		funcionario.setVersao(versao);
		funcionario.setCargoId(cargoId);
		funcionario.setAtivo(ativo);
		funcionario.setSalario(salario);

		funcionario.setNew(true);

		funcionario = funcionarioPersistence.update(funcionario);

		if (userId > 0) {
			User user = UserLocalServiceUtil.fetchUser(userId);
			if (Validator.isNotNull(user)) {
				Cargo cargo = cargoPersistence.fetchByPrimaryKey(cargoId);
				if (Validator.isNotNull(cargo)) {
					user.setJobTitle(cargo.getNomeCurrentValue());
					UserLocalServiceUtil.updateUser(user);
				}
			}
		}

		// Contato
		Contato contato = ContatoLocalServiceUtil.addContato(companyId,
				groupId, createUserId, Funcionario.class.getName(),
				funcionario.getFuncionarioId(), nome, null, sexo,
				dataNascimento, 0, null, null, null);

		// Telefones
		TelefoneLocalServiceUtil.updateTelefones(companyId, groupId,
				createUserId, Contato.class.getName(), contato.getContatoId(),
				telefones);

		// Enderecços de email
		EnderecoEmailLocalServiceUtil.updateEnderecosEmail(companyId, groupId,
				createUserId, Contato.class.getName(), contato.getContatoId(),
				enderecosEmail);

		// Asset
		updateAsset(funcionario.getCreateUserId(), funcionario,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", funcionario.getNome());

		socialActivityLocalService.addActivity(funcionario.getCreateUserId(),
				funcionario.getGroupId(), Funcionario.class.getName(),
				funcionario.getFuncionarioId(),
				FuncionarioActivityKeys.ADD_FUNCIONARIO,
				extraDataJSONObject.toString(), 0);

		return funcionario;
	}

	public Funcionario update(long funcionarioId, long companyId, long groupId,
			long modifieduserId, String nome, String nomeReduzido,
			String observacao, String rg, String rgOrgaoEmissor,
			String rgDataEmissao, String cpf, String sexo, String estadoCivil,
			String dataNascimento, String endComLogradouro,
			String endComNumero, String endComComplemento, String endComCep,
			String endComBairro, long endComCidade, String endComUf,
			String endComPais, String endResLogradouro, String endResNumero,
			String endResComplemento, String endResCep, String endResBairro,
			long endResCidade, String endResUf, String endResPais,
			String dataEntrada, String dataSaida, boolean existeUser,
			long userId, double versao, long cargoId, boolean ativo,
			double salario, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, ServiceContext serviceContext)
			throws SystemException, PortalException {

		validate(funcionarioId, nome, cpf, rg, rgDataEmissao, dataNascimento,
				dataEntrada, dataSaida, existeUser, userId, versao);

		Date now = DateUtil.getDataAtual();

		Date dRgDataEmissao = null;
		Date dDataNascimento = null;
		Date dDataEntrada = null;
		Date dDataSaida = null;
		if (Validator.isNotNull(rgDataEmissao)) {
			dRgDataEmissao = DateUtil.stringToDate(rgDataEmissao);
		}
		if (Validator.isNotNull(dataNascimento)) {
			dDataNascimento = DateUtil.stringToDate(dataNascimento);
		}
		if (Validator.isNotNull(dataEntrada)) {
			dDataEntrada = DateUtil.stringToDate(dataEntrada);
		}
		if (Validator.isNotNull(dataSaida)) {
			dDataSaida = DateUtil.stringToDate(dataSaida);
		}

		// Recuperar funcionario
		Funcionario funcionario = funcionarioPersistence
				.fetchByPrimaryKey(funcionarioId);

		boolean funcionarioAtivoAnterior = funcionario.getAtivo();

		// Atribui novos valores
		funcionario.setModifiedUserId(modifieduserId);
		funcionario.setModifiedDate(now);
		funcionario.setNome(nome);
		funcionario.setNomeReduzido(nomeReduzido);
		funcionario.setObservacao(observacao);
		funcionario.setCpf(cpf);
		funcionario.setDataNascimento(dDataNascimento);
		funcionario.setEstadoCivil(estadoCivil);
		funcionario.setRg(rg);
		funcionario.setRgDataEmissao(dRgDataEmissao);
		funcionario.setRgOrgaoEmissor(rgOrgaoEmissor);
		funcionario.setSexo(sexo);
		funcionario.setDataEntrada(dDataEntrada);
		funcionario.setDataSaida(dDataSaida);
		funcionario.setEndComLogradouro(endComLogradouro);
		funcionario.setEndComNumero(endComNumero);
		funcionario.setEndComComplemento(endComComplemento);
		funcionario.setEndComCep(endComCep);
		funcionario.setEndComBairro(endComBairro);
		funcionario.setEndComCidade(endComCidade);
		funcionario.setEndComUf(endComUf);
		funcionario.setEndComPais(endComPais);
		funcionario.setEndResLogradouro(endResLogradouro);
		funcionario.setEndResNumero(endResNumero);
		funcionario.setEndResComplemento(endResComplemento);
		funcionario.setEndResCep(endResCep);
		funcionario.setEndResBairro(endResBairro);
		funcionario.setEndResCidade(endResCidade);
		funcionario.setEndResUf(endResUf);
		funcionario.setEndResPais(endResPais);
		funcionario.setUserId(userId);
		funcionario.setVersao(versao + 1);
		funcionario.setCargoId(cargoId);
		funcionario.setAtivo(ativo);
		funcionario.setSalario(salario);

		funcionario = funcionarioPersistence.update(funcionario);

		if (userId > 0) {
			User user = UserLocalServiceUtil.fetchUser(userId);
			if (Validator.isNotNull(user)) {
				Cargo cargo = cargoPersistence.fetchByPrimaryKey(cargoId);
				if (Validator.isNotNull(cargo)) {
					user.setJobTitle(cargo.getNomeCurrentValue());
					UserLocalServiceUtil.updateUser(user);
				}
			}
		}

		String ativouFuncionario = null;
		if ((!funcionarioAtivoAnterior) && (funcionario.getAtivo())) {
			ativouFuncionario = Constantes.S;
		} else if ((funcionarioAtivoAnterior) && (!funcionario.getAtivo())) {
			ativouFuncionario = Constantes.N;
		}

		// Contato
		long classNameId = PortalUtil.getClassNameId(Funcionario.class
				.getName());
		Contato contato = ContatoLocalServiceUtil.findByContato(classNameId,
				funcionarioId);
		if (Validator.isNotNull(contato)) {
			ContatoLocalServiceUtil.update(contato.getContatoId(),
					modifieduserId, nome, null, sexo, dataNascimento, 0, null,
					null, null);

			// Telefones
			TelefoneLocalServiceUtil.updateTelefones(companyId, groupId,
					modifieduserId, Contato.class.getName(),
					contato.getContatoId(), telefones);

			// Enderecços de email
			EnderecoEmailLocalServiceUtil.updateEnderecosEmail(companyId,
					groupId, modifieduserId, Contato.class.getName(),
					contato.getContatoId(), enderecosEmail);
		}

		// Asset
		updateAsset(funcionario.getModifiedUserId(), funcionario,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", funcionario.getNome());

		socialActivityLocalService
				.addActivity(
						funcionario.getModifiedUserId(),
						funcionario.getGroupId(),
						Funcionario.class.getName(),
						funcionario.getFuncionarioId(),
						(ativouFuncionario == null ? FuncionarioActivityKeys.UPDATE_FUNCIONARIO
								: (Constantes.N.equals(ativouFuncionario) ? FuncionarioActivityKeys.DESATIVOU
										: FuncionarioActivityKeys.ATIVOU)),
						extraDataJSONObject.toString(), 0);
		/*
		 * socialActivityLocalService.addActivity(funcionario.getModifiedUserId()
		 * , funcionario.getGroupId(), Funcionario.class.getName(),
		 * funcionario.getFuncionarioId(), (ativouFuncionario ?
		 * FuncionarioActivityKeys.ATIVOU : (!ativouFuncionario ?
		 * FuncionarioActivityKeys.DESATIVOU :
		 * FuncionarioActivityKeys.UPDATE_FUNCIONARIO) ),
		 * extraDataJSONObject.toString(), 0);
		 */
		return funcionario;

	}

	public Funcionario deleteFuncionario(Funcionario funcionario, long userId)
			throws SystemException {

		try {

			funcionario = super.deleteFuncionario(funcionario);

			// Asset

			assetEntryLocalService.deleteEntry(Funcionario.class.getName(),
					funcionario.getFuncionarioId());

			// Social

			// try to get the user from the pruser for social
			// there will be no link if the user wasn't logged in
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

			extraDataJSONObject.put("nome", funcionario.getNome());

			socialActivityLocalService.addActivity(userId,
					funcionario.getGroupId(), Funcionario.class.getName(),
					funcionario.getFuncionarioId(),
					FuncionarioActivityKeys.DELETE_FUNCIONARIO,
					extraDataJSONObject.toString(), 0);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return funcionario;
	}

	public void updateAsset(long userId, Funcionario funcionario,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				funcionario.getGroupId(), funcionario.getCreateDate(),
				funcionario.getModifiedDate(), Funcionario.class.getName(),
				funcionario.getFuncionarioId(), StringPool.BLANK, 0,
				assetCategoryIds, assetTagNames, true, null, null, null,
				ContentTypes.TEXT_HTML, funcionario.getNome(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
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

	public List<Funcionario> search(long companyId, long groupId, String nome,
			boolean ativo, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		List<Funcionario> lista = funcionarioPersistence.findByC_G_NOME(
				companyId, groupId, nome, start, end, orderByComparator);
		for (Funcionario funcionario : lista) {
			if (funcionario.getAtivo() == ativo) {
				retorno.add(funcionario);
			}
		}
		return retorno;
	}

	public int searchCount(long companyId, long groupId, String nome,
			boolean ativo) throws SystemException {
		int retorno = 0;
		List<Funcionario> lista = funcionarioPersistence.findByC_G_NOME(
				companyId, groupId, nome);
		for (Funcionario funcionario : lista) {
			if (funcionario.getAtivo() == ativo) {
				retorno++;
			}
		}
		return retorno;
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

	public List<Funcionario> search(long companyId, long groupId,
			boolean ativo, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		List<Funcionario> lista = funcionarioPersistence.findByC_G(companyId,
				groupId, start, end, orderByComparator);
		for (Funcionario funcionario : lista) {
			if (funcionario.getAtivo() == ativo) {
				retorno.add(funcionario);
			}
		}
		return retorno;
	}

	public int searchCount(long companyId, long groupId, boolean ativo)
			throws SystemException {
		int retorno = 0;
		List<Funcionario> lista = funcionarioPersistence.findByC_G(companyId,
				groupId);
		for (Funcionario funcionario : lista) {
			if (funcionario.getAtivo() == ativo) {
				retorno++;
			}
		}
		return retorno;
	}

	public List<Funcionario> search(long companyId, String nome, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {

		return funcionarioPersistence.findByC_NOME(companyId, nome, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, String nome) throws SystemException {
		return funcionarioPersistence.findByC_NOME(companyId, nome).size();
	}

	public List<Funcionario> search(long companyId, String nome, boolean ativo,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		List<Funcionario> lista = funcionarioPersistence.findByC_NOME(
				companyId, nome, start, end, orderByComparator);
		for (Funcionario funcionario : lista) {
			if (funcionario.getAtivo() == ativo) {
				retorno.add(funcionario);
			}
		}
		return retorno;
	}

	public int searchCount(long companyId, String nome, boolean ativo)
			throws SystemException {
		int retorno = 0;
		List<Funcionario> lista = funcionarioPersistence.findByC_NOME(
				companyId, nome);
		for (Funcionario funcionario : lista) {
			if (funcionario.getAtivo() == ativo) {
				retorno++;
			}
		}
		return retorno;
	}

	public List<Funcionario> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return funcionarioPersistence.findByCompany(companyId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId) throws SystemException {
		return funcionarioPersistence.findByCompany(companyId).size();
	}

	public List<Funcionario> search(long companyId, boolean ativo, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		List<Funcionario> lista = funcionarioPersistence.findByCompany(
				companyId, start, end, orderByComparator);
		for (Funcionario funcionario : lista) {
			if (funcionario.getAtivo() == ativo) {
				retorno.add(funcionario);
			}
		}
		return retorno;
	}

	public int searchCount(long companyId, boolean ativo)
			throws SystemException {
		int retorno = 0;
		List<Funcionario> lista = funcionarioPersistence
				.findByCompany(companyId);
		for (Funcionario funcionario : lista) {
			if (funcionario.getAtivo() == ativo) {
				retorno++;
			}
		}
		return retorno;
	}

	public Funcionario updateFoto(long funcionarioId, byte[] bytes)
			throws PortalException, SystemException {

		Funcionario funcionario = funcionarioPersistence
				.findByPrimaryKey(funcionarioId);

		long imageMaxSize = PrefsPropsUtil
				.getLong(PropsKeys.USERS_IMAGE_MAX_SIZE);

		if ((imageMaxSize > 0)
				&& ((bytes == null) || (bytes.length > imageMaxSize))) {

			throw new FotoFuncionarioTamanhoException();
		}

		long fotoId = funcionario.getFotoId();

		if (fotoId <= 0) {
			fotoId = counterLocalService.increment();

			funcionario.setFotoId(fotoId);
		}

		try {
			ImageBag imageBag = ImageToolUtil.read(bytes);

			RenderedImage renderedImage = imageBag.getRenderedImage();

			if (renderedImage == null) {
				throw new UserPortraitTypeException();
			}

			int alturaMaxima = GetterUtil.getInteger(PropsUtil
					.get(PropsKeys.USERS_IMAGE_MAX_HEIGHT));
			int larguraMaxima = GetterUtil.getInteger(PropsUtil
					.get(PropsKeys.USERS_IMAGE_MAX_WIDTH));
			renderedImage = ImageToolUtil.scale(renderedImage, alturaMaxima,
					larguraMaxima);

			String contentType = imageBag.getType();

			ImageLocalServiceUtil.updateImage(fotoId,
					ImageToolUtil.getBytes(renderedImage, contentType));
		} catch (IOException ioe) {
			throw new ImageSizeException(ioe);
		}

		funcionarioPersistence.update(funcionario);

		// Atualiza usuário
		User user = UserLocalServiceUtil.fetchUser(funcionario.getUserId());
		if (Validator.isNotNull(user)) {
			user.setPortraitId(funcionario.getFotoId());
			UserLocalServiceUtil.updateUser(user);
		}

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", funcionario.getNome());

		socialActivityLocalService.addActivity(funcionario.getCreateUserId(),
				funcionario.getGroupId(), Funcionario.class.getName(),
				funcionario.getFuncionarioId(),
				FuncionarioActivityKeys.UPDATE_FOTO,
				extraDataJSONObject.toString(), 0);

		return funcionario;
	}

	public void deleteFoto(long funcionarioId) throws PortalException,
			SystemException {

		Funcionario funcionario = funcionarioPersistence
				.findByPrimaryKey(funcionarioId);

		long fotoId = funcionario.getFotoId();

		if (fotoId > 0) {
			funcionario.setFotoId(0);

			funcionarioPersistence.update(funcionario);

			UserLocalServiceUtil.deletePortrait(funcionario.getUserId());

			ImageLocalServiceUtil.deleteImage(fotoId);

			// Social

			// try to get the user from the pruser for social
			// there will be no link if the user wasn't logged in
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

			extraDataJSONObject.put("nome", funcionario.getNome());

			socialActivityLocalService.addActivity(
					funcionario.getCreateUserId(), funcionario.getGroupId(),
					Funcionario.class.getName(),
					funcionario.getFuncionarioId(),
					FuncionarioActivityKeys.DELETE_FOTO,
					extraDataJSONObject.toString(), 0);
		}

	}

	public Funcionario updateFoto(long funcionarioId, long fotoId)
			throws PortalException, SystemException {

		Funcionario funcionario = funcionarioPersistence
				.findByPrimaryKey(funcionarioId);

		funcionario.setFotoId(fotoId);

		funcionarioPersistence.update(funcionario);

		User user = UserLocalServiceUtil.fetchUser(funcionario.getUserId());
		user.setPortraitId(fotoId);
		UserLocalServiceUtil.updateUser(user);

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", funcionario.getNome());

		socialActivityLocalService.addActivity(funcionario.getCreateUserId(),
				funcionario.getGroupId(), Funcionario.class.getName(),
				funcionario.getFuncionarioId(),
				FuncionarioActivityKeys.UPDATE_FOTO,
				extraDataJSONObject.toString(), 0);

		return funcionario;
	}

	public Funcionario fetchByUSUARIO(long userId) throws SystemException {
		return funcionarioPersistence.fetchByUSUARIO(userId);
	}

	protected void validate(long funcionarioId, String nome, String cpf,
			String rg, String rgDataEmissao, String dataNascimento,
			String dataEntrada, String dataSaida, boolean existeUser,
			long userId, double versao) throws PortalException, SystemException {

		if (Validator.isNull(nome)) {
			throw new FuncionarioNomeObrigatorioException();
		}
		if ((Validator.isNotNull(cpf)) && (!Helper.isCPF(cpf))) {
			throw new FuncionarioCPFInvalidoException();
		} else if (Validator.isNotNull(cpf)) {
			Funcionario funcionario = funcionarioPersistence.fetchByCPF(cpf);
			if ((Validator.isNotNull(funcionario)) && (funcionarioId > 0)
					&& (funcionarioId != funcionario.getFuncionarioId())) {
				throw new FuncionarioCPFDuplicadoException();
			}
		}
		if (Validator.isNotNull(rg)) {
			Funcionario funcionario = funcionarioPersistence.fetchByRG(rg);
			if ((Validator.isNotNull(funcionario)) && (funcionarioId > 0)
					&& (funcionarioId != funcionario.getFuncionarioId())) {
				throw new FuncionarioRGDuplicadoException();
			}
		}
		if ((Validator.isNotNull(rgDataEmissao))
				&& (!DateUtil.isValidDate(rgDataEmissao, "dd/MM/yyyy"))) {
			throw new FuncionarioRGDataEmissaoInvalidaException();
		}
		if ((Validator.isNotNull(dataNascimento))
				&& (!DateUtil.isValidDate(dataNascimento, "dd/MM/yyyy"))) {
			throw new FuncionarioDataNascimentoInvalidaException();
		}
		if ((Validator.isNotNull(dataEntrada))
				&& (!DateUtil.isValidDate(dataEntrada, "dd/MM/yyyy"))) {
			throw new FuncionarioDataEntradaInvalidaException();
		}
		if ((Validator.isNotNull(dataSaida))
				&& (!DateUtil.isValidDate(dataSaida, "dd/MM/yyyy"))) {
			throw new FuncionarioDataSaidaInvalidaException();
		}
		if (existeUser) {
			if (userId > 0) {
				Funcionario funcionario = funcionarioPersistence
						.fetchByUSUARIO(userId);
				if ((Validator.isNotNull(funcionario))
						&& (funcionarioId != funcionario.getFuncionarioId())
						&& (userId == funcionario.getUserId())) {
					throw new FuncionarioUsuarioDuplicadoException();
				}
			}
		}
		if (funcionarioId > 0) {
			Funcionario funcionario = funcionarioPersistence
					.fetchByPrimaryKey(funcionarioId);
			if ((Validator.isNotNull(funcionario))
					&& (funcionario.getVersao() > versao)) {
				throw new FuncionarioAlteradoOutroUsuarioException();
			}
		}
	}
}
