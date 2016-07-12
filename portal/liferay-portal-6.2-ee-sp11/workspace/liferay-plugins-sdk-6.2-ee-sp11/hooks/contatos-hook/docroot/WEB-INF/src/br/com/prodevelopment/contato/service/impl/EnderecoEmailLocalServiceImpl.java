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

package br.com.prodevelopment.contato.service.impl;

import br.com.prodevelopment.contato.EnderecoEmailEnderecoInvalidoException;
import br.com.prodevelopment.contato.EnderecoEmailEnderecoObrigatotioException;
import br.com.prodevelopment.contato.EnderecoEmailTipoObrigatotioException;
import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.model.impl.EnderecoEmailImpl;
import br.com.prodevelopment.contato.service.base.EnderecoEmailLocalServiceBaseImpl;
import br.com.prodevelopment.contato.util.DateUtil;
import br.com.prodevelopment.contato.util.Helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The implementation of the endereco email local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.contato.service.EnderecoEmailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.contato.service.base.EnderecoEmailLocalServiceBaseImpl
 * @see br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil
 */
public class EnderecoEmailLocalServiceImpl
	extends EnderecoEmailLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil} to access the endereco email local service.
	 */
	public EnderecoEmail addEnderecoEmail(long companyId, long groupId,
			long createUserId, String className, long classPK, String endereco,
			int tipo, boolean principal) throws SystemException,
			PortalException {

		long classNameId = PortalUtil.getClassNameId(className);

		validate(0, companyId, classNameId, classPK, endereco, tipo, principal);

		Date now = DateUtil.getDataAtual();

		// Criar objeto incrementando um novo ID
		EnderecoEmail enderecoEmail = enderecoEmailPersistence
				.create(counterLocalService.increment(EnderecoEmail.class
						.getName()));

		// Atribui novos valores
		enderecoEmail.setCompanyId(companyId);
		enderecoEmail.setGroupId(groupId);
		enderecoEmail.setCreateUserId(createUserId);
		enderecoEmail.setCreateDate(now);
		enderecoEmail.setClassNameId(classNameId);
		enderecoEmail.setClassPK(classPK);
		enderecoEmail.setEndereco(endereco);
		enderecoEmail.setTipo(tipo);
		enderecoEmail.setPrincipal(principal);

		enderecoEmail.setNew(true);

		enderecoEmail = enderecoEmailPersistence.update(enderecoEmail);

		return enderecoEmail;
	}

	public EnderecoEmail update(long enderecoEmailId, long companyId,
			String className, long classPK, long modifieduserId,
			String endereco, int tipo, boolean principal)
			throws SystemException, PortalException {

		long classNameId = PortalUtil.getClassNameId(className);

		validate(enderecoEmailId, companyId, classNameId, classPK, endereco, tipo, principal);

		Date now = DateUtil.getDataAtual();

		// Recuperar enderecoEmail
		EnderecoEmail enderecoEmail = enderecoEmailPersistence
				.fetchByPrimaryKey(enderecoEmailId);

		// Atribui novos valores
		enderecoEmail.setModifiedUserId(modifieduserId);
		enderecoEmail.setModifiedDate(now);
		enderecoEmail.setEndereco(endereco);
		enderecoEmail.setTipo(tipo);
		enderecoEmail.setPrincipal(principal);

		enderecoEmail = enderecoEmailPersistence.update(enderecoEmail);

		return enderecoEmail;

	}

	public void updateEnderecosEmail(long companyId, long groupId, long userId,
			String className, long classPK, List<EnderecoEmail> enderecosEmail)
			throws PortalException, SystemException {

		Set<Long> enderecoEmailIds = new HashSet<Long>();

		for (EnderecoEmail enderecoEmail : enderecosEmail) {
			long enderecoEmailId = enderecoEmail.getEnderecoEmailId();

			String endereco = enderecoEmail.getEndereco();
			int tipo = enderecoEmail.getTipo();
			boolean principal = enderecoEmail.isPrincipal();

			if (enderecoEmailId <= 0) {
				enderecoEmail = addEnderecoEmail(companyId, groupId, userId, className,
						classPK, endereco, tipo, principal);

				enderecoEmailId = enderecoEmail.getEnderecoEmailId();
			} else {
				update(enderecoEmailId, companyId, className, classPK, userId, endereco, tipo, principal);
			}

			enderecoEmailIds.add(enderecoEmailId);
		}

		enderecosEmail = getEnderecosEmail(companyId, className, classPK);

		for (EnderecoEmail enderecoEmail : enderecosEmail) {
			if (!enderecoEmailIds.contains(enderecoEmail.getEnderecoEmailId())) {
				deleteEnderecoEmail(enderecoEmail.getEnderecoEmailId());
			}
		}
	}

	public EnderecoEmail deleteEnderecoEmail(long enderecoEmailId)
		throws PortalException, SystemException {

		return enderecoEmailPersistence.remove(enderecoEmailId);
	}

	public void deleteEnderecosEmail(long companyId, String className, long classPK)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		List<EnderecoEmail> enderecosEmail = enderecoEmailPersistence.findByC_C_C(
			companyId, classNameId, classPK);

		for (EnderecoEmail enderecoEmail : enderecosEmail) {
			enderecoEmailPersistence.remove(enderecoEmail);
		}
	}

	public List<EnderecoEmail> getEnderecosEmail(long companyId, String className, long classPK)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return enderecoEmailPersistence.findByC_C_C(companyId, classNameId, classPK);
	}
	
	public EnderecoEmail createEnderecoEmail() throws SystemException {

		return new EnderecoEmailImpl();
	}

	protected void validate(long enderecoEmailId, long companyId, long classNameId,
			long classPK, String endereco, int tipo, boolean principal)
			throws PortalException, SystemException {

		if (tipo == 0) {
			throw new EnderecoEmailTipoObrigatotioException();
		} else {
			if (Validator.isNull(endereco)) {
				throw new EnderecoEmailEnderecoObrigatotioException();
			} else {
				if (!Helper.validaEmail(endereco)) {
					throw new EnderecoEmailEnderecoInvalidoException();
				}
			}
		}

		if (principal) {
			List<EnderecoEmail> enderecosEmail = enderecoEmailPersistence
					.findByC_C_C_P(companyId, classNameId, classPK, principal);

			for (EnderecoEmail enderecoEmail : enderecosEmail) {
				if ((enderecoEmailId <= 0) || (enderecoEmail.getEnderecoEmailId() != enderecoEmailId)) {
					enderecoEmail.setPrincipal(false);

					enderecoEmailPersistence.update(enderecoEmail);
				}
			}
		}
	}
}