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

import java.util.Date;

import br.com.prodevelopment.cliente.ClienteDataLimiteMaxCreditoInvalidaException;
import br.com.prodevelopment.cliente.model.Cliente;
import br.com.prodevelopment.cliente.model.ClienteLimCredito;
import br.com.prodevelopment.cliente.service.base.ClienteLimCreditoLocalServiceBaseImpl;
import br.com.prodevelopment.portlet.cliente.util.DateUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the cliente lim credito local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.cliente.service.ClienteLimCreditoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author marcelo
 * @see br.com.prodevelopment.cliente.service.base.ClienteLimCreditoLocalServiceBaseImpl
 * @see br.com.prodevelopment.cliente.service.ClienteLimCreditoLocalServiceUtil
 */
public class ClienteLimCreditoLocalServiceImpl
	extends ClienteLimCreditoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.cliente.service.ClienteLimCreditoLocalServiceUtil} to access the cliente lim credito local service.
	 */
	public ClienteLimCredito addClienteLimCredito(long clienteId, double valorLimiteMaximoCredito,
			String dataLimiteMaximoCredito, double valorLimiteMaximoCheque, int qtdeLimiteMaximoCheque) throws SystemException,
			PortalException {

		validate(dataLimiteMaximoCredito);

		Date dDataLimiteMaximoCredito = null;
		if (Validator.isNotNull(dataLimiteMaximoCredito)) {
			dDataLimiteMaximoCredito = DateUtil.stringToDate(dataLimiteMaximoCredito);
		}

		// Criar objeto incrementando um novo ID
		ClienteLimCredito clienteLimCredito = clienteLimCreditoPersistence
				.create(counterLocalService.increment(ClienteLimCredito.class
						.getName()));

		// Atribui novos valores
		clienteLimCredito.setClienteId(clienteId);
		clienteLimCredito.setDataLimiteMaximoCredito(dDataLimiteMaximoCredito);
		clienteLimCredito.setQtdeLimiteMaximoCheque(qtdeLimiteMaximoCheque);
		clienteLimCredito.setValorLimiteMaximoCheque(valorLimiteMaximoCheque);
		clienteLimCredito.setValorLimiteMaximoCredito(valorLimiteMaximoCredito);

		clienteLimCredito.setNew(true);

		clienteLimCredito = clienteLimCreditoPersistence.update(clienteLimCredito);
		
		return clienteLimCredito;
	}

	public ClienteLimCredito update(long clienteLimCreditoId, double valorLimiteMaximoCredito,
			String dataLimiteMaximoCredito, double valorLimiteMaximoCheque, int qtdeLimiteMaximoCheque) throws SystemException,
			PortalException {

		validate(dataLimiteMaximoCredito);

		Date dDataLimiteMaximoCredito = null;
		if (Validator.isNotNull(dataLimiteMaximoCredito)) {
			dDataLimiteMaximoCredito = DateUtil.stringToDate(dataLimiteMaximoCredito);
		}

		// Recuperar cliente
		ClienteLimCredito clienteLimCredito = clienteLimCreditoPersistence
				.fetchByPrimaryKey(clienteLimCreditoId);

		// Atribui novos valores
		clienteLimCredito.setDataLimiteMaximoCredito(dDataLimiteMaximoCredito);
		clienteLimCredito.setQtdeLimiteMaximoCheque(qtdeLimiteMaximoCheque);
		clienteLimCredito.setValorLimiteMaximoCheque(valorLimiteMaximoCheque);
		clienteLimCredito.setValorLimiteMaximoCredito(valorLimiteMaximoCredito);

		clienteLimCredito = clienteLimCreditoPersistence.update(clienteLimCredito);
		
		return clienteLimCredito;

	}

	public ClienteLimCredito fetchByClienteLimCredito(long clienteId)
			throws SystemException {
		return clienteLimCreditoPersistence.fetchByCliente(clienteId);
	}

	public Cliente fetchByCliente(long clienteId)
			throws SystemException {
		Cliente cliente = null;
		ClienteLimCredito clienteLimCredito = clienteLimCreditoPersistence.fetchByCliente(clienteId);
		if (Validator.isNotNull(clienteLimCredito)) {
			cliente = clientePersistence
					.fetchByPrimaryKey(clienteId);
		}
		return cliente;


	}

	protected void validate(String dataLimiteMaximoCredito) throws PortalException,
			SystemException {

		if ((Validator.isNotNull(dataLimiteMaximoCredito))
				&& (!DateUtil.isValidDate(dataLimiteMaximoCredito, "dd/MM/yyyy"))) {
			throw new ClienteDataLimiteMaxCreditoInvalidaException();
		}
	}
}