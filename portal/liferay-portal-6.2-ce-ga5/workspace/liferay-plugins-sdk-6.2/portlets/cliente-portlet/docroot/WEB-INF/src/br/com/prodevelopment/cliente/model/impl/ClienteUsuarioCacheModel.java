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

package br.com.prodevelopment.cliente.model.impl;

import br.com.prodevelopment.cliente.model.ClienteUsuario;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ClienteUsuario in entity cache.
 *
 * @author marcelo
 * @see ClienteUsuario
 * @generated
 */
public class ClienteUsuarioCacheModel implements CacheModel<ClienteUsuario>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{clienteUsuarioId=");
		sb.append(clienteUsuarioId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", clienteId=");
		sb.append(clienteId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClienteUsuario toEntityModel() {
		ClienteUsuarioImpl clienteUsuarioImpl = new ClienteUsuarioImpl();

		clienteUsuarioImpl.setClienteUsuarioId(clienteUsuarioId);
		clienteUsuarioImpl.setUserId(userId);
		clienteUsuarioImpl.setClienteId(clienteId);

		clienteUsuarioImpl.resetOriginalValues();

		return clienteUsuarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clienteUsuarioId = objectInput.readLong();
		userId = objectInput.readLong();
		clienteId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(clienteUsuarioId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(clienteId);
	}

	public long clienteUsuarioId;
	public long userId;
	public long clienteId;
}