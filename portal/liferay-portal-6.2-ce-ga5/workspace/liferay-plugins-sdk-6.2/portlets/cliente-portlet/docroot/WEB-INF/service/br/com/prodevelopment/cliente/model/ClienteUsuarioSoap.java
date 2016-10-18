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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.cliente.service.http.ClienteUsuarioServiceSoap}.
 *
 * @author marcelo
 * @see br.com.prodevelopment.cliente.service.http.ClienteUsuarioServiceSoap
 * @generated
 */
public class ClienteUsuarioSoap implements Serializable {
	public static ClienteUsuarioSoap toSoapModel(ClienteUsuario model) {
		ClienteUsuarioSoap soapModel = new ClienteUsuarioSoap();

		soapModel.setClienteUsuarioId(model.getClienteUsuarioId());
		soapModel.setUserId(model.getUserId());
		soapModel.setClienteId(model.getClienteId());

		return soapModel;
	}

	public static ClienteUsuarioSoap[] toSoapModels(ClienteUsuario[] models) {
		ClienteUsuarioSoap[] soapModels = new ClienteUsuarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClienteUsuarioSoap[][] toSoapModels(ClienteUsuario[][] models) {
		ClienteUsuarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClienteUsuarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClienteUsuarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClienteUsuarioSoap[] toSoapModels(List<ClienteUsuario> models) {
		List<ClienteUsuarioSoap> soapModels = new ArrayList<ClienteUsuarioSoap>(models.size());

		for (ClienteUsuario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClienteUsuarioSoap[soapModels.size()]);
	}

	public ClienteUsuarioSoap() {
	}

	public long getPrimaryKey() {
		return _clienteUsuarioId;
	}

	public void setPrimaryKey(long pk) {
		setClienteUsuarioId(pk);
	}

	public long getClienteUsuarioId() {
		return _clienteUsuarioId;
	}

	public void setClienteUsuarioId(long clienteUsuarioId) {
		_clienteUsuarioId = clienteUsuarioId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getClienteId() {
		return _clienteId;
	}

	public void setClienteId(long clienteId) {
		_clienteId = clienteId;
	}

	private long _clienteUsuarioId;
	private long _userId;
	private long _clienteId;
}