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

package br.com.prodevelopment.contato.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.prodevelopment.contato.EnderecoLogradouroObrigatotioException;
import br.com.prodevelopment.contato.EnderecoTipoObrigatotioException;
import br.com.prodevelopment.contato.model.Endereco;
import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.model.Endereco;
import br.com.prodevelopment.contato.model.impl.EnderecoImpl;
import br.com.prodevelopment.contato.service.base.EnderecoLocalServiceBaseImpl;
import br.com.prodevelopment.contato.util.DateUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the endereco local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.contato.service.EnderecoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author marcelo
 * @see br.com.prodevelopment.contato.service.base.EnderecoLocalServiceBaseImpl
 * @see br.com.prodevelopment.contato.service.EnderecoLocalServiceUtil
 */
public class EnderecoLocalServiceImpl extends EnderecoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.contato.service.EnderecoLocalServiceUtil} to access
	 * the endereco local service.
	 */
	public Endereco addEndereco(long companyId, long groupId,
			long createUserId, String className, long classPK,
			String logradouro, String numero, String complemento, String cep,
			String bairro, long cidadeId, String uf, long paisId, int tipo,
			boolean principal) throws SystemException, PortalException {

		long classNameId = PortalUtil.getClassNameId(className);

		validate(companyId, classNameId, classPK, tipo, logradouro, principal);

		Date now = DateUtil.getDataAtual();

		// Criar objeto incrementando um novo ID
		Endereco endereco = enderecoPersistence.create(counterLocalService
				.increment(Endereco.class.getName()));

		// Atribui novos valores
		endereco.setCompanyId(companyId);
		endereco.setGroupId(groupId);
		endereco.setCreateUserId(createUserId);
		endereco.setCreateDate(now);
		endereco.setClassNameId(classNameId);
		endereco.setClassPK(classPK);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCep(cep);
		endereco.setBairro(bairro);
		endereco.setCidadeId(cidadeId);
		endereco.setUf(uf);
		endereco.setPaisId(paisId);
		endereco.setPrincipal(principal);
		endereco.setTipo(tipo);

		endereco.setNew(true);

		endereco = enderecoPersistence.update(endereco);

		return endereco;
	}

	public Endereco update(long enderecoId, long companyId, String className,
			long classPK, long modifieduserId, String logradouro,
			String numero, String complemento, String cep, String bairro,
			long cidadeId, String uf, long paisId, int tipo, boolean principal)
			throws SystemException, PortalException {

		long classNameId = PortalUtil.getClassNameId(className);

		validate(companyId, classNameId, classPK, tipo, logradouro, principal);

		Date now = DateUtil.getDataAtual();

		// Recuperar endereco
		Endereco endereco = enderecoPersistence.fetchByPrimaryKey(enderecoId);

		// Atribui novos valores
		endereco.setModifiedUserId(modifieduserId);
		endereco.setModifiedDate(now);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCep(cep);
		endereco.setBairro(bairro);
		endereco.setCidadeId(cidadeId);
		endereco.setUf(uf);
		endereco.setPaisId(paisId);
		endereco.setPrincipal(principal);
		endereco.setTipo(tipo);

		endereco = enderecoPersistence.update(endereco);

		return endereco;

	}

	public void updateEnderecos(long companyId, long groupId, long userId,
			String className, long classPK, List<Endereco> enderecos)
			throws PortalException, SystemException {

		Set<Long> enderecoIds = new HashSet<Long>();

		for (Endereco endereco : enderecos) {
			long enderecoId = endereco.getEnderecoId();

			String logradouro = endereco.getLogradouro();
			String numero = endereco.getNumero();
			String complemento = endereco.getComplemento();
			String cep = endereco.getCep();
			String bairro = endereco.getBairro();
			long cidadeId = endereco.getCidadeId();
			String uf = endereco.getUf();
			long paisId = endereco.getPaisId();
			int tipo = endereco.getTipo();
			boolean principal = endereco.isPrincipal();

			if (enderecoId <= 0) {
				endereco = addEndereco(companyId, groupId, userId, className,
						classPK, logradouro, numero, complemento, cep, bairro,
						cidadeId, uf, paisId, tipo, principal);

				enderecoId = endereco.getEnderecoId();
			} else {
				update(enderecoId, companyId, className, classPK, userId,
						logradouro, numero, complemento, cep, bairro, cidadeId,
						uf, paisId, tipo, principal);
			}

			enderecoIds.add(enderecoId);
		}

		enderecos = getEnderecos(companyId, className, classPK);

		for (Endereco endereco : enderecos) {
			if (!enderecoIds.contains(endereco.getEnderecoId())) {
				deleteEndereco(endereco.getEnderecoId());
			}
		}
	}

	public Endereco deleteEndereco(long enderecoId) throws PortalException,
			SystemException {

		return enderecoPersistence.remove(enderecoId);
	}

	public void deleteEnderecos(long companyId, String className, long classPK)
			throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		List<Endereco> enderecos = enderecoPersistence.findByC_C_C(companyId,
				classNameId, classPK);

		for (Endereco endereco : enderecos) {
			enderecoPersistence.remove(endereco);
		}
	}

	public List<Endereco> getEnderecos(long companyId, String className,
			long classPK) throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return enderecoPersistence.findByC_C_C(companyId, classNameId, classPK);
	}

	public Endereco createEndereco() throws SystemException {

		return new EnderecoImpl();
	}

	protected void validate(long companyId, long classNameId, long classPK,
			int tipo, String logradouro, boolean principal)
			throws PortalException, SystemException {

		if (tipo == 0) {
			throw new EnderecoTipoObrigatotioException();
		} else {
			if (Validator.isNull(logradouro)) {
				throw new EnderecoLogradouroObrigatotioException();
			}
		}

		if (principal) {
			List<EnderecoEmail> enderecosEmail = enderecoEmailPersistence
					.findByC_C_C_P(companyId, classNameId, classPK, principal);

			for (EnderecoEmail enderecoEmail : enderecosEmail) {
				enderecoEmail.setPrincipal(false);

				enderecoEmailPersistence.update(enderecoEmail);
			}
		}
	}
}