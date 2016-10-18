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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.cliente.service.http.ClienteLimCreditoServiceSoap}.
 *
 * @author marcelo
 * @see br.com.prodevelopment.cliente.service.http.ClienteLimCreditoServiceSoap
 * @generated
 */
public class ClienteLimCreditoSoap implements Serializable {
	public static ClienteLimCreditoSoap toSoapModel(ClienteLimCredito model) {
		ClienteLimCreditoSoap soapModel = new ClienteLimCreditoSoap();

		soapModel.setClienteLimCreditoId(model.getClienteLimCreditoId());
		soapModel.setValorLimiteMaximoCredito(model.getValorLimiteMaximoCredito());
		soapModel.setDataLimiteMaximoCredito(model.getDataLimiteMaximoCredito());
		soapModel.setValorLimiteMaximoCheque(model.getValorLimiteMaximoCheque());
		soapModel.setQtdeLimiteMaximoCheque(model.getQtdeLimiteMaximoCheque());
		soapModel.setClienteId(model.getClienteId());

		return soapModel;
	}

	public static ClienteLimCreditoSoap[] toSoapModels(
		ClienteLimCredito[] models) {
		ClienteLimCreditoSoap[] soapModels = new ClienteLimCreditoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClienteLimCreditoSoap[][] toSoapModels(
		ClienteLimCredito[][] models) {
		ClienteLimCreditoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClienteLimCreditoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClienteLimCreditoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClienteLimCreditoSoap[] toSoapModels(
		List<ClienteLimCredito> models) {
		List<ClienteLimCreditoSoap> soapModels = new ArrayList<ClienteLimCreditoSoap>(models.size());

		for (ClienteLimCredito model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClienteLimCreditoSoap[soapModels.size()]);
	}

	public ClienteLimCreditoSoap() {
	}

	public long getPrimaryKey() {
		return _clienteLimCreditoId;
	}

	public void setPrimaryKey(long pk) {
		setClienteLimCreditoId(pk);
	}

	public long getClienteLimCreditoId() {
		return _clienteLimCreditoId;
	}

	public void setClienteLimCreditoId(long clienteLimCreditoId) {
		_clienteLimCreditoId = clienteLimCreditoId;
	}

	public double getValorLimiteMaximoCredito() {
		return _valorLimiteMaximoCredito;
	}

	public void setValorLimiteMaximoCredito(double valorLimiteMaximoCredito) {
		_valorLimiteMaximoCredito = valorLimiteMaximoCredito;
	}

	public Date getDataLimiteMaximoCredito() {
		return _dataLimiteMaximoCredito;
	}

	public void setDataLimiteMaximoCredito(Date dataLimiteMaximoCredito) {
		_dataLimiteMaximoCredito = dataLimiteMaximoCredito;
	}

	public double getValorLimiteMaximoCheque() {
		return _valorLimiteMaximoCheque;
	}

	public void setValorLimiteMaximoCheque(double valorLimiteMaximoCheque) {
		_valorLimiteMaximoCheque = valorLimiteMaximoCheque;
	}

	public int getQtdeLimiteMaximoCheque() {
		return _qtdeLimiteMaximoCheque;
	}

	public void setQtdeLimiteMaximoCheque(int qtdeLimiteMaximoCheque) {
		_qtdeLimiteMaximoCheque = qtdeLimiteMaximoCheque;
	}

	public long getClienteId() {
		return _clienteId;
	}

	public void setClienteId(long clienteId) {
		_clienteId = clienteId;
	}

	private long _clienteLimCreditoId;
	private double _valorLimiteMaximoCredito;
	private Date _dataLimiteMaximoCredito;
	private double _valorLimiteMaximoCheque;
	private int _qtdeLimiteMaximoCheque;
	private long _clienteId;
}