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

import br.com.prodevelopment.cliente.model.ClienteLimCredito;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClienteLimCredito in entity cache.
 *
 * @author marcelo
 * @see ClienteLimCredito
 * @generated
 */
public class ClienteLimCreditoCacheModel implements CacheModel<ClienteLimCredito>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{clienteLimCreditoId=");
		sb.append(clienteLimCreditoId);
		sb.append(", valorLimiteMaximoCredito=");
		sb.append(valorLimiteMaximoCredito);
		sb.append(", dataLimiteMaximoCredito=");
		sb.append(dataLimiteMaximoCredito);
		sb.append(", valorLimiteMaximoCheque=");
		sb.append(valorLimiteMaximoCheque);
		sb.append(", qtdeLimiteMaximoCheque=");
		sb.append(qtdeLimiteMaximoCheque);
		sb.append(", clienteId=");
		sb.append(clienteId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClienteLimCredito toEntityModel() {
		ClienteLimCreditoImpl clienteLimCreditoImpl = new ClienteLimCreditoImpl();

		clienteLimCreditoImpl.setClienteLimCreditoId(clienteLimCreditoId);
		clienteLimCreditoImpl.setValorLimiteMaximoCredito(valorLimiteMaximoCredito);

		if (dataLimiteMaximoCredito == Long.MIN_VALUE) {
			clienteLimCreditoImpl.setDataLimiteMaximoCredito(null);
		}
		else {
			clienteLimCreditoImpl.setDataLimiteMaximoCredito(new Date(
					dataLimiteMaximoCredito));
		}

		clienteLimCreditoImpl.setValorLimiteMaximoCheque(valorLimiteMaximoCheque);
		clienteLimCreditoImpl.setQtdeLimiteMaximoCheque(qtdeLimiteMaximoCheque);
		clienteLimCreditoImpl.setClienteId(clienteId);

		clienteLimCreditoImpl.resetOriginalValues();

		return clienteLimCreditoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clienteLimCreditoId = objectInput.readLong();
		valorLimiteMaximoCredito = objectInput.readDouble();
		dataLimiteMaximoCredito = objectInput.readLong();
		valorLimiteMaximoCheque = objectInput.readDouble();
		qtdeLimiteMaximoCheque = objectInput.readInt();
		clienteId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(clienteLimCreditoId);
		objectOutput.writeDouble(valorLimiteMaximoCredito);
		objectOutput.writeLong(dataLimiteMaximoCredito);
		objectOutput.writeDouble(valorLimiteMaximoCheque);
		objectOutput.writeInt(qtdeLimiteMaximoCheque);
		objectOutput.writeLong(clienteId);
	}

	public long clienteLimCreditoId;
	public double valorLimiteMaximoCredito;
	public long dataLimiteMaximoCredito;
	public double valorLimiteMaximoCheque;
	public int qtdeLimiteMaximoCheque;
	public long clienteId;
}