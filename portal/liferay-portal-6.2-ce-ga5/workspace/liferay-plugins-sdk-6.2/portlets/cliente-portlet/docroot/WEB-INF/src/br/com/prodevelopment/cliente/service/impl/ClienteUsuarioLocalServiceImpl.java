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

import br.com.prodevelopment.cliente.model.ClienteUsuario;
import br.com.prodevelopment.cliente.service.base.ClienteUsuarioLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the cliente usuario local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.cliente.service.ClienteUsuarioLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author marcelo
 * @see br.com.prodevelopment.cliente.service.base.ClienteUsuarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.cliente.service.ClienteUsuarioLocalServiceUtil
 */
public class ClienteUsuarioLocalServiceImpl
	extends ClienteUsuarioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.cliente.service.ClienteUsuarioLocalServiceUtil} to access the cliente usuario local service.
	 */
	public ClienteUsuario addClienteUsuario(long clienteId, long userId) throws SystemException,
			PortalException {

		// Criar objeto incrementando um novo ID
		ClienteUsuario clienteUsuario = clienteUsuarioPersistence
				.create(counterLocalService.increment(ClienteUsuario.class
						.getName()));

		// Atribui novos valores
		clienteUsuario.setClienteId(clienteId);
		clienteUsuario.setUserId(userId);

		clienteUsuario.setNew(true);

		return clienteUsuario;
	}
}