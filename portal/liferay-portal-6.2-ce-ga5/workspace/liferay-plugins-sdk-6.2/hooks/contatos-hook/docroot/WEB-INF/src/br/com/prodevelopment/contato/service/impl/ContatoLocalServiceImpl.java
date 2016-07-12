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
import java.util.List;

import br.com.prodevelopment.contato.ContatoDataNascimentoInvalidaException;
import br.com.prodevelopment.contato.ContatoEmailInvalidoException;
import br.com.prodevelopment.contato.NoSuchContatoException;
import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.model.impl.ContatoImpl;
import br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil;
import br.com.prodevelopment.contato.service.EnderecoLocalServiceUtil;
import br.com.prodevelopment.contato.service.TelefoneLocalServiceUtil;
import br.com.prodevelopment.contato.service.base.ContatoLocalServiceBaseImpl;
import br.com.prodevelopment.contato.util.DateUtil;
import br.com.prodevelopment.contato.util.Helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the contato local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.contato.service.ContatoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author marcelo
 * @see br.com.prodevelopment.contato.service.base.ContatoLocalServiceBaseImpl
 * @see br.com.prodevelopment.contato.service.ContatoLocalServiceUtil
 */
public class ContatoLocalServiceImpl extends ContatoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.contato.service.ContatoLocalServiceUtil} to access
	 * the contato local service.
	 */
	public Contato addContato(long companyId, long groupId, long createUserId,
			String className, long classPK, String nome, String endEmail,
			String sexo, String dataNascimento, long cargoId, String skype,
			String facebook, String twitter) throws SystemException,
			PortalException {

		validate(endEmail, dataNascimento);

		long classNameId = PortalUtil.getClassNameId(className);
		Date now = DateUtil.getDataAtual();

		Date dDataNascimento = null;
		if (Validator.isNotNull(dataNascimento)) {
			dDataNascimento = DateUtil.stringToDate(dataNascimento);
		}

		// Criar objeto incrementando um novo ID
		Contato contato = contatoPersistence.create(counterLocalService
				.increment(Contato.class.getName()));

		Company company = CompanyLocalServiceUtil.fetchCompany(companyId);

		// Atribui novos valores
		contato.setCompanyId(companyId);
		contato.setGroupId(groupId);
		contato.setCreateUserId(createUserId);
		contato.setClassNameId(classNameId);
		contato.setClassPK(classPK);
		contato.setAccountId(company.getAccountId());
		contato.setCreateDate(now);
		contato.setNome(nome);
		contato.setEndEmail(endEmail);
		contato.setSexo(sexo);
		contato.setDataNascimento(dDataNascimento);
		contato.setCargoId(cargoId);
		contato.setSkype(skype);
		contato.setFacebook(facebook);
		contato.setTwitter(twitter);

		contato.setNew(true);

		contato = contatoPersistence.update(contato);

		return contato;
	}

	public Contato update(long contatoId, long modifieduserId, String nome,
			String endEmail, String sexo, String dataNascimento, long cargoId,
			String skype, String facebook, String twitter)
			throws SystemException, PortalException {

		validate(endEmail, dataNascimento);

		Date now = DateUtil.getDataAtual();

		Date dDataNascimento = null;
		if (Validator.isNotNull(dataNascimento)) {
			dDataNascimento = DateUtil.stringToDate(dataNascimento);
		}

		// Recuperar contato
		Contato contato = contatoPersistence.fetchByPrimaryKey(contatoId);

		// Atribui novos valores
		contato.setModifiedUserId(modifieduserId);
		contato.setModifiedDate(now);
		contato.setNome(nome);
		contato.setEndEmail(endEmail);
		contato.setSexo(sexo);
		contato.setDataNascimento(dDataNascimento);
		contato.setCargoId(cargoId);
		contato.setSkype(skype);
		contato.setFacebook(facebook);
		contato.setTwitter(twitter);

		contato = contatoPersistence.update(contato);

		return contato;

	}

	public Contato deleteContato(Contato contato) throws SystemException {

		// Contato

		contatoPersistence.remove(contato);

		// Endereços
		EnderecoLocalServiceUtil.deleteEnderecos(contato.getCompanyId(),
				Contato.class.getName(), contato.getContatoId());

		// Emails
		EnderecoEmailLocalServiceUtil.deleteEnderecosEmail(contato.getCompanyId(),
				Contato.class.getName(), contato.getContatoId());

		// Telefones
		TelefoneLocalServiceUtil.deleteTelefones(contato.getCompanyId(),
				Contato.class.getName(), contato.getContatoId());

		return contato;
	}

	public Contato deleteContato(long contatoId) throws SystemException {
		Contato contato = contatoPersistence.fetchByPrimaryKey(contatoId);

		if (Validator.isNotNull(contato)) {
			deleteContato(contato);
		}

		return contato;
	}

	public List<Contato> search(long companyId, String nome, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		if (Validator.isNotNull(nome)) {
			return contatoPersistence.findByC_NOME(companyId, nome, start, end,
					orderByComparator);

		} else {
			return contatoPersistence.findByCompanyId(companyId, start, end,
					orderByComparator);

		}
	}

	public int searchCount(long companyId, String nome) throws SystemException {
		if (Validator.isNotNull(nome)) {
			return contatoPersistence.findByC_NOME(companyId, nome).size();

		} else {
			return contatoPersistence.findByCompanyId(companyId).size();

		}
	}

	public List<Contato> search(long companyId, long groupId, String nome,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		if (Validator.isNotNull(nome)) {
			return contatoPersistence.findByC_G_NOME(companyId, groupId, nome,
					start, end, orderByComparator);

		} else {
			return contatoPersistence.findByC_G(companyId, groupId, start, end,
					orderByComparator);

		}
	}

	public int searchCount(long companyId, long groupId, String nome)
			throws SystemException {
		if (Validator.isNotNull(nome)) {
			return contatoPersistence.findByC_G_NOME(companyId, groupId, nome)
					.size();

		} else {
			return contatoPersistence.findByC_G(companyId, groupId).size();

		}
	}

	public Contato findByContato(long classNameId, long classPK)
			throws SystemException, NoSuchContatoException {
		return contatoPersistence.findByContato(classNameId, classPK);
	}

	public Contato createContato() throws SystemException {

		return new ContatoImpl();
	}
	
	protected void validate(String endEmail, String dataNascimento)
			throws PortalException, SystemException {

		if (Validator.isNotNull(endEmail)) {
			if (!Helper.validaEmail(endEmail)) {
				throw new ContatoEmailInvalidoException();
			}
		}
		if ((Validator.isNotNull(dataNascimento))
				&& (!DateUtil.isValidDate(dataNascimento, "dd/MM/yyyy"))) {
			throw new ContatoDataNascimentoInvalidaException();
		}
	}
}