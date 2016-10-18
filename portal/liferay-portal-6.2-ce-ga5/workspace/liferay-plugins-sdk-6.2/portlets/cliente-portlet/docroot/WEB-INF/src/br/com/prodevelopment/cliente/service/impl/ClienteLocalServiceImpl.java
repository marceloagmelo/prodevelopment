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

package br.com.prodevelopment.cliente.service.impl;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import br.com.prodevelopment.cliente.ClienteAlteradoOutroUsuarioException;
import br.com.prodevelopment.cliente.ClienteCNPJDuplicadoException;
import br.com.prodevelopment.cliente.ClienteCNPJInvalidoException;
import br.com.prodevelopment.cliente.ClienteCPFDuplicadoException;
import br.com.prodevelopment.cliente.ClienteCPFInvalidoException;
import br.com.prodevelopment.cliente.ClienteDataNascimentoInvalidaException;
import br.com.prodevelopment.cliente.ClienteNomeObrigatorioException;
import br.com.prodevelopment.cliente.ClienteRGDataEmissaoInvalidaException;
import br.com.prodevelopment.cliente.ClienteRGInscricaoMunDuplicadoException;
import br.com.prodevelopment.cliente.FotoClienteTamanhoException;
import br.com.prodevelopment.cliente.model.Cliente;
import br.com.prodevelopment.cliente.model.ClienteLimCredito;
import br.com.prodevelopment.cliente.service.ClienteLimCreditoLocalServiceUtil;
import br.com.prodevelopment.cliente.service.base.ClienteLocalServiceBaseImpl;
import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.model.Telefone;
import br.com.prodevelopment.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil;
import br.com.prodevelopment.contato.service.TelefoneLocalServiceUtil;
import br.com.prodevelopment.portlet.cliente.Constantes;
import br.com.prodevelopment.portlet.cliente.social.ClienteActivityKeys;
import br.com.prodevelopment.portlet.cliente.util.DateUtil;
import br.com.prodevelopment.portlet.cliente.util.Helper;

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
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.documentlibrary.ImageSizeException;

/**
 * The implementation of the cliente local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.cliente.service.ClienteLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author marcelo
 * @see br.com.prodevelopment.cliente.service.base.ClienteLocalServiceBaseImpl
 * @see br.com.prodevelopment.cliente.service.ClienteLocalServiceUtil
 */
public class ClienteLocalServiceImpl extends ClienteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.cliente.service.ClienteLocalServiceUtil} to access
	 * the cliente local service.
	 */
	public Cliente addCliente(long companyId, long groupId, long createUserId,
			String nome, String tipoPessoa, String observacao,
			String rgInscricaoMun, String rgOrgaoEmissor, String rgDataEmissao,
			String cpfCnpj, String sexo, String estadoCivil,
			String dataNascimento, String endComLogradouro,
			String endComNumero, String endComComplemento, String endComCep,
			String endComBairro, long endComCidade, String endComUf,
			String endComPais, String endResLogradouro, String endResNumero,
			String endResComplemento, String endResCep, String endResBairro,
			long endResCidade, String endResUf, String endResPais,
			double valorLimiteMaximoCredito, String dataLimiteMaximoCredito,
			double valorLimiteMaximoCheque, int qtdeLimiteMaximoCheque,
			double versao, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, ServiceContext serviceContext)
			throws SystemException, PortalException {

		validate(0, nome, tipoPessoa, cpfCnpj, rgInscricaoMun, rgDataEmissao,
				dataNascimento, versao);

		Date now = DateUtil.getDataAtual();

		Date dRgDataEmissao = null;
		Date dDataNascimento = null;
		if (Validator.isNotNull(rgDataEmissao)) {
			dRgDataEmissao = DateUtil.stringToDate(rgDataEmissao);
		}
		if (Validator.isNotNull(dataNascimento)) {
			dDataNascimento = DateUtil.stringToDate(dataNascimento);
		}

		// Criar objeto incrementando um novo ID
		Cliente cliente = clientePersistence.create(counterLocalService
				.increment(Cliente.class.getName()));

		// Atribui novos valores
		cliente.setCompanyId(companyId);
		cliente.setGroupId(groupId);
		cliente.setCreateUserId(createUserId);
		cliente.setCreateDate(now);
		cliente.setTipoPessoa(tipoPessoa);
		cliente.setNome(nome);
		cliente.setObservacao(observacao);
		cliente.setCpfCnpj(cpfCnpj);
		cliente.setDataNascimento(dDataNascimento);
		cliente.setEstadoCivil(estadoCivil);
		cliente.setRgInscricaoMun(rgInscricaoMun);
		cliente.setRgDataEmissao(dRgDataEmissao);
		cliente.setRgOrgaoEmissor(rgOrgaoEmissor);
		cliente.setSexo(sexo);
		cliente.setVersao(versao);
		cliente.setEndComLogradouro(endComLogradouro);
		cliente.setEndComNumero(endComNumero);
		cliente.setEndComComplemento(endComComplemento);
		cliente.setEndComCep(endComCep);
		cliente.setEndComBairro(endComBairro);
		cliente.setEndComCidade(endComCidade);
		cliente.setEndComUf(endComUf);
		cliente.setEndComPais(endComPais);
		cliente.setEndResLogradouro(endResLogradouro);
		cliente.setEndResNumero(endResNumero);
		cliente.setEndResComplemento(endResComplemento);
		cliente.setEndResCep(endResCep);
		cliente.setEndResBairro(endResBairro);
		cliente.setEndResCidade(endResCidade);
		cliente.setEndResUf(endResUf);
		cliente.setEndResPais(endResPais);

		cliente.setNew(true);

		cliente = clientePersistence.update(cliente);

		// Limite de crédito
		ClienteLimCreditoLocalServiceUtil.addClienteLimCredito(
				cliente.getClienteId(), valorLimiteMaximoCredito,
				dataLimiteMaximoCredito, valorLimiteMaximoCheque,
				qtdeLimiteMaximoCheque);

		// Contato
		Contato contato = ContatoLocalServiceUtil.addContato(companyId,
				groupId, createUserId, Cliente.class.getName(), cliente.getClienteId(), nome,
				null, sexo, dataNascimento, 0, null, null, null);

		// Telefones
		TelefoneLocalServiceUtil.updateTelefones(companyId, groupId,
				createUserId, Contato.class.getName(), contato.getContatoId(),
				telefones);

		// Enderecços de email
		EnderecoEmailLocalServiceUtil.updateEnderecosEmail(companyId, groupId,
				createUserId, Contato.class.getName(), contato.getContatoId(),
				enderecosEmail);

		// Asset
		updateAsset(cliente.getCreateUserId(), cliente,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", cliente.getNome());

		socialActivityLocalService.addActivity(cliente.getCreateUserId(),
				cliente.getGroupId(), Cliente.class.getName(),
				cliente.getClienteId(), ClienteActivityKeys.ADD_CLIENTE,
				extraDataJSONObject.toString(), 0);

		return cliente;
	}

	public Cliente update(long clienteId, long companyId, long groupId,
			long modifieduserId, String nome,
			String tipoPessoa, String observacao, String rgInscricaoMun,
			String rgOrgaoEmissor, String rgDataEmissao, String cpfCnpj,
			String sexo, String estadoCivil, String dataNascimento, String endComLogradouro,
			String endComNumero, String endComComplemento, String endComCep,
			String endComBairro, long endComCidade, String endComUf,
			String endComPais, String endResLogradouro, String endResNumero,
			String endResComplemento, String endResCep, String endResBairro,
			long endResCidade, String endResUf, String endResPais,
			double valorLimiteMaximoCredito, String dataLimiteMaximoCredito,
			double valorLimiteMaximoCheque, int qtdeLimiteMaximoCheque,
			double versao, List<EnderecoEmail> enderecosEmail,
			List<Telefone> telefones, ServiceContext serviceContext)
			throws SystemException, PortalException {

		validate(clienteId, nome,tipoPessoa, cpfCnpj, rgInscricaoMun, rgDataEmissao,
				dataNascimento, versao);

		Date now = DateUtil.getDataAtual();

		Date dRgDataEmissao = null;
		Date dDataNascimento = null;
		if (Validator.isNotNull(rgDataEmissao)) {
			dRgDataEmissao = DateUtil.stringToDate(rgDataEmissao);
		}
		if (Validator.isNotNull(dataNascimento)) {
			dDataNascimento = DateUtil.stringToDate(dataNascimento);
		}

		// Recuperar cliente
		Cliente cliente = clientePersistence.fetchByPrimaryKey(clienteId);

		// Atribui novos valores
		cliente.setModifiedUserId(modifieduserId);
		cliente.setModifiedDate(now);
		cliente.setTipoPessoa(tipoPessoa);
		cliente.setNome(nome);
		cliente.setObservacao(observacao);
		cliente.setCpfCnpj(cpfCnpj);
		cliente.setDataNascimento(dDataNascimento);
		cliente.setEstadoCivil(estadoCivil);
		cliente.setRgInscricaoMun(rgInscricaoMun);
		cliente.setRgDataEmissao(dRgDataEmissao);
		cliente.setRgOrgaoEmissor(rgOrgaoEmissor);
		cliente.setSexo(sexo);
		cliente.setVersao(versao + 1);
		cliente.setEndComLogradouro(endComLogradouro);
		cliente.setEndComNumero(endComNumero);
		cliente.setEndComComplemento(endComComplemento);
		cliente.setEndComCep(endComCep);
		cliente.setEndComBairro(endComBairro);
		cliente.setEndComCidade(endComCidade);
		cliente.setEndComUf(endComUf);
		cliente.setEndComPais(endComPais);
		cliente.setEndResLogradouro(endResLogradouro);
		cliente.setEndResNumero(endResNumero);
		cliente.setEndResComplemento(endResComplemento);
		cliente.setEndResCep(endResCep);
		cliente.setEndResBairro(endResBairro);
		cliente.setEndResCidade(endResCidade);
		cliente.setEndResUf(endResUf);
		cliente.setEndResPais(endResPais);

		cliente = clientePersistence.update(cliente);

		// Limite de crédito
		ClienteLimCredito clienteLimCredito = clienteLimCreditoPersistence
				.fetchByCliente(clienteId);
		if (Validator.isNotNull(clienteLimCredito)) {
			ClienteLimCreditoLocalServiceUtil.update(
					clienteLimCredito.getClienteLimCreditoId(),
					valorLimiteMaximoCredito, dataLimiteMaximoCredito,
					valorLimiteMaximoCheque, qtdeLimiteMaximoCheque);
		}

		// Contato
		long classNameId = PortalUtil.getClassNameId(Cliente.class.getName());
		Contato contato = ContatoLocalServiceUtil.findByContato(classNameId,
				clienteId);
		if (Validator.isNotNull(contato)) {
			ContatoLocalServiceUtil.update(contato.getContatoId(),
					modifieduserId, nome, null, sexo, dataNascimento, 0,
					null, null, null);

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
		updateAsset(cliente.getModifiedUserId(), cliente,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", cliente.getNome());

		socialActivityLocalService.addActivity(cliente.getModifiedUserId(),
				cliente.getGroupId(), Cliente.class.getName(),
				cliente.getClienteId(), ClienteActivityKeys.UPDATE_CLIENTE,
				extraDataJSONObject.toString(), 0);

		return cliente;

	}

	public Cliente deleteCliente(Cliente cliente, long userId)
			throws SystemException {

		try {

			cliente = super.deleteCliente(cliente);

			// Contato
			long classNameId = PortalUtil.getClassNameId(Cliente.class
					.getName());
			Contato contato = ContatoLocalServiceUtil.findByContato(
					classNameId, cliente.getClienteId());
			if (Validator.isNotNull(contato)) {
				ContatoLocalServiceUtil.deleteContato(contato);

				// Telefones
				TelefoneLocalServiceUtil.deleteTelefones(
						cliente.getCompanyId(), Contato.class.getName(),
						contato.getContatoId());

				// Enderecços de email
				EnderecoEmailLocalServiceUtil.deleteEnderecosEmail(
						cliente.getCompanyId(), Contato.class.getName(),
						contato.getContatoId());
			}

			// Asset

			assetEntryLocalService.deleteEntry(Cliente.class.getName(),
					cliente.getClienteId());

			// Social

			// try to get the user from the pruser for social
			// there will be no link if the user wasn't logged in
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

			extraDataJSONObject.put("nome", cliente.getNome());

			socialActivityLocalService.addActivity(userId,
					cliente.getGroupId(), Cliente.class.getName(),
					cliente.getClienteId(), ClienteActivityKeys.DELETE_CLIENTE,
					extraDataJSONObject.toString(), 0);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public void updateAsset(long userId, Cliente cliente,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				cliente.getGroupId(), cliente.getCreateDate(),
				cliente.getModifiedDate(), Cliente.class.getName(),
				cliente.getClienteId(), StringPool.BLANK, 0, assetCategoryIds,
				assetTagNames, true, null, null, null, ContentTypes.TEXT_HTML,
				cliente.getNome(), null, null, null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}

	public List<Cliente> search(long companyId, long groupId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return clientePersistence.findByC_G_NOME(companyId, groupId, nome,
				start, end, orderByComparator);

	}

	public int searchCount(long companyId, long groupId, String nome)
			throws SystemException {
		return clientePersistence.findByC_G_NOME(companyId, groupId, nome)
				.size();
	}

	public List<Cliente> search(long companyId, long groupId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return clientePersistence.findByC_G(companyId, groupId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, long groupId) throws SystemException {
		return clientePersistence.findByC_G(companyId, groupId).size();
	}

	public List<Cliente> search(long companyId, String nome, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {

		return clientePersistence.findByC_NOME(companyId, nome, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId, String nome) throws SystemException {
		return clientePersistence.findByC_NOME(companyId, nome).size();
	}

	public List<Cliente> search(long companyId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return clientePersistence.findByCompany(companyId, start, end,
				orderByComparator);

	}

	public int searchCount(long companyId) throws SystemException {
		return clientePersistence.findByCompany(companyId).size();
	}

	public Cliente updateFoto(long clienteId, byte[] bytes)
			throws PortalException, SystemException {

		Cliente cliente = clientePersistence.findByPrimaryKey(clienteId);

		long imageMaxSize = PrefsPropsUtil
				.getLong(PropsKeys.USERS_IMAGE_MAX_SIZE);

		if ((imageMaxSize > 0)
				&& ((bytes == null) || (bytes.length > imageMaxSize))) {

			throw new FotoClienteTamanhoException();
		}

		long logoTipoId = cliente.getLogoTipoId();

		if (logoTipoId <= 0) {
			logoTipoId = counterLocalService.increment();

			cliente.setLogoTipoId(logoTipoId);
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

			ImageLocalServiceUtil.updateImage(logoTipoId,
					ImageToolUtil.getBytes(renderedImage, contentType));
		} catch (IOException ioe) {
			throw new ImageSizeException(ioe);
		}

		clientePersistence.update(cliente);

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", cliente.getNome());

		socialActivityLocalService.addActivity(cliente.getCreateUserId(),
				cliente.getGroupId(), Cliente.class.getName(),
				cliente.getClienteId(), ClienteActivityKeys.UPDATE_FOTO,
				extraDataJSONObject.toString(), 0);

		return cliente;
	}

	public void deleteFoto(long clienteId) throws PortalException,
			SystemException {

		Cliente cliente = clientePersistence.findByPrimaryKey(clienteId);

		long logoTipoId = cliente.getLogoTipoId();

		if (logoTipoId > 0) {
			cliente.setLogoTipoId(0);

			clientePersistence.update(cliente);

			// Social

			// try to get the user from the pruser for social
			// there will be no link if the user wasn't logged in
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

			extraDataJSONObject.put("nome", cliente.getNome());

			socialActivityLocalService.addActivity(cliente.getCreateUserId(),
					cliente.getGroupId(), Cliente.class.getName(),
					cliente.getClienteId(), ClienteActivityKeys.DELETE_FOTO,
					extraDataJSONObject.toString(), 0);
		}

	}

	public Cliente updateFoto(long clienteId, long logoTipoId)
			throws PortalException, SystemException {

		Cliente cliente = clientePersistence.findByPrimaryKey(clienteId);

		cliente.setLogoTipoId(logoTipoId);

		clientePersistence.update(cliente);

		// Social

		// try to get the user from the pruser for social
		// there will be no link if the user wasn't logged in
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("nome", cliente.getNome());

		socialActivityLocalService.addActivity(cliente.getCreateUserId(),
				cliente.getGroupId(), Cliente.class.getName(),
				cliente.getClienteId(), ClienteActivityKeys.UPDATE_FOTO,
				extraDataJSONObject.toString(), 0);

		return cliente;
	}

	protected void validate(long clienteId, String nome, String tipoPessoa, String cpfCnpj,
			String rgInscricaoMun, String rgDataEmissao, String dataNascimento,
			double versao) throws PortalException, SystemException {

		if (Validator.isNull(nome)) {
			throw new ClienteNomeObrigatorioException();
		}
		if ((Validator.isNotNull(cpfCnpj)) && (Constantes.PESSOA_FISICA.equals(tipoPessoa)) && (!Helper.isCPF(cpfCnpj))) {
			throw new ClienteCPFInvalidoException();
		} else if (Validator.isNotNull(cpfCnpj)) {
			Cliente cliente = clientePersistence.fetchByCPF_CNPJ(cpfCnpj);
			if ((Validator.isNotNull(cliente)) && (clienteId > 0)
					&& (clienteId != cliente.getClienteId())) {
				throw new ClienteCPFDuplicadoException();
			}
		}
		if ((Validator.isNotNull(cpfCnpj)) && (Constantes.PESSOA_JURIDICA.equals(tipoPessoa)) && (!Helper.isCNPJ(cpfCnpj))) {
			throw new ClienteCNPJInvalidoException();
		} else if (Validator.isNotNull(cpfCnpj)) {
			Cliente cliente = clientePersistence.fetchByCPF_CNPJ(cpfCnpj);
			if ((Validator.isNotNull(cliente)) && (clienteId > 0)
					&& (clienteId != cliente.getClienteId())) {
				throw new ClienteCNPJDuplicadoException();
			}
		}
		if (Validator.isNotNull(rgInscricaoMun)) {
			Cliente cliente = clientePersistence
					.fetchByRG_INSCRICAO(rgInscricaoMun);
			if ((Validator.isNotNull(cliente)) && (clienteId > 0)
					&& (clienteId != cliente.getClienteId())) {
				throw new ClienteRGInscricaoMunDuplicadoException();
			}
		}
		if ((Validator.isNotNull(rgDataEmissao))
				&& (!DateUtil.isValidDate(rgDataEmissao, "dd/MM/yyyy"))) {
			throw new ClienteRGDataEmissaoInvalidaException();
		}
		if ((Validator.isNotNull(dataNascimento))
				&& (!DateUtil.isValidDate(dataNascimento, "dd/MM/yyyy"))) {
			throw new ClienteDataNascimentoInvalidaException();
		}
		if (clienteId > 0) {
			Cliente cliente = clientePersistence.fetchByPrimaryKey(clienteId);
			if ((Validator.isNotNull(cliente))
					&& (cliente.getVersao() > versao)) {
				throw new ClienteAlteradoOutroUsuarioException();
			}
		}
	}
}