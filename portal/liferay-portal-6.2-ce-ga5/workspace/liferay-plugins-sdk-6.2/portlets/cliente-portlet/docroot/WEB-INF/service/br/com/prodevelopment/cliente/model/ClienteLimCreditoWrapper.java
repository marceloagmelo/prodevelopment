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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClienteLimCredito}.
 * </p>
 *
 * @author marcelo
 * @see ClienteLimCredito
 * @generated
 */
public class ClienteLimCreditoWrapper implements ClienteLimCredito,
	ModelWrapper<ClienteLimCredito> {
	public ClienteLimCreditoWrapper(ClienteLimCredito clienteLimCredito) {
		_clienteLimCredito = clienteLimCredito;
	}

	@Override
	public Class<?> getModelClass() {
		return ClienteLimCredito.class;
	}

	@Override
	public String getModelClassName() {
		return ClienteLimCredito.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clienteLimCreditoId", getClienteLimCreditoId());
		attributes.put("valorLimiteMaximoCredito", getValorLimiteMaximoCredito());
		attributes.put("dataLimiteMaximoCredito", getDataLimiteMaximoCredito());
		attributes.put("valorLimiteMaximoCheque", getValorLimiteMaximoCheque());
		attributes.put("qtdeLimiteMaximoCheque", getQtdeLimiteMaximoCheque());
		attributes.put("clienteId", getClienteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clienteLimCreditoId = (Long)attributes.get("clienteLimCreditoId");

		if (clienteLimCreditoId != null) {
			setClienteLimCreditoId(clienteLimCreditoId);
		}

		Double valorLimiteMaximoCredito = (Double)attributes.get(
				"valorLimiteMaximoCredito");

		if (valorLimiteMaximoCredito != null) {
			setValorLimiteMaximoCredito(valorLimiteMaximoCredito);
		}

		Date dataLimiteMaximoCredito = (Date)attributes.get(
				"dataLimiteMaximoCredito");

		if (dataLimiteMaximoCredito != null) {
			setDataLimiteMaximoCredito(dataLimiteMaximoCredito);
		}

		Double valorLimiteMaximoCheque = (Double)attributes.get(
				"valorLimiteMaximoCheque");

		if (valorLimiteMaximoCheque != null) {
			setValorLimiteMaximoCheque(valorLimiteMaximoCheque);
		}

		Integer qtdeLimiteMaximoCheque = (Integer)attributes.get(
				"qtdeLimiteMaximoCheque");

		if (qtdeLimiteMaximoCheque != null) {
			setQtdeLimiteMaximoCheque(qtdeLimiteMaximoCheque);
		}

		Long clienteId = (Long)attributes.get("clienteId");

		if (clienteId != null) {
			setClienteId(clienteId);
		}
	}

	/**
	* Returns the primary key of this cliente lim credito.
	*
	* @return the primary key of this cliente lim credito
	*/
	@Override
	public long getPrimaryKey() {
		return _clienteLimCredito.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cliente lim credito.
	*
	* @param primaryKey the primary key of this cliente lim credito
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_clienteLimCredito.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cliente lim credito ID of this cliente lim credito.
	*
	* @return the cliente lim credito ID of this cliente lim credito
	*/
	@Override
	public long getClienteLimCreditoId() {
		return _clienteLimCredito.getClienteLimCreditoId();
	}

	/**
	* Sets the cliente lim credito ID of this cliente lim credito.
	*
	* @param clienteLimCreditoId the cliente lim credito ID of this cliente lim credito
	*/
	@Override
	public void setClienteLimCreditoId(long clienteLimCreditoId) {
		_clienteLimCredito.setClienteLimCreditoId(clienteLimCreditoId);
	}

	/**
	* Returns the valor limite maximo credito of this cliente lim credito.
	*
	* @return the valor limite maximo credito of this cliente lim credito
	*/
	@Override
	public double getValorLimiteMaximoCredito() {
		return _clienteLimCredito.getValorLimiteMaximoCredito();
	}

	/**
	* Sets the valor limite maximo credito of this cliente lim credito.
	*
	* @param valorLimiteMaximoCredito the valor limite maximo credito of this cliente lim credito
	*/
	@Override
	public void setValorLimiteMaximoCredito(double valorLimiteMaximoCredito) {
		_clienteLimCredito.setValorLimiteMaximoCredito(valorLimiteMaximoCredito);
	}

	/**
	* Returns the data limite maximo credito of this cliente lim credito.
	*
	* @return the data limite maximo credito of this cliente lim credito
	*/
	@Override
	public java.util.Date getDataLimiteMaximoCredito() {
		return _clienteLimCredito.getDataLimiteMaximoCredito();
	}

	/**
	* Sets the data limite maximo credito of this cliente lim credito.
	*
	* @param dataLimiteMaximoCredito the data limite maximo credito of this cliente lim credito
	*/
	@Override
	public void setDataLimiteMaximoCredito(
		java.util.Date dataLimiteMaximoCredito) {
		_clienteLimCredito.setDataLimiteMaximoCredito(dataLimiteMaximoCredito);
	}

	/**
	* Returns the valor limite maximo cheque of this cliente lim credito.
	*
	* @return the valor limite maximo cheque of this cliente lim credito
	*/
	@Override
	public double getValorLimiteMaximoCheque() {
		return _clienteLimCredito.getValorLimiteMaximoCheque();
	}

	/**
	* Sets the valor limite maximo cheque of this cliente lim credito.
	*
	* @param valorLimiteMaximoCheque the valor limite maximo cheque of this cliente lim credito
	*/
	@Override
	public void setValorLimiteMaximoCheque(double valorLimiteMaximoCheque) {
		_clienteLimCredito.setValorLimiteMaximoCheque(valorLimiteMaximoCheque);
	}

	/**
	* Returns the qtde limite maximo cheque of this cliente lim credito.
	*
	* @return the qtde limite maximo cheque of this cliente lim credito
	*/
	@Override
	public int getQtdeLimiteMaximoCheque() {
		return _clienteLimCredito.getQtdeLimiteMaximoCheque();
	}

	/**
	* Sets the qtde limite maximo cheque of this cliente lim credito.
	*
	* @param qtdeLimiteMaximoCheque the qtde limite maximo cheque of this cliente lim credito
	*/
	@Override
	public void setQtdeLimiteMaximoCheque(int qtdeLimiteMaximoCheque) {
		_clienteLimCredito.setQtdeLimiteMaximoCheque(qtdeLimiteMaximoCheque);
	}

	/**
	* Returns the cliente ID of this cliente lim credito.
	*
	* @return the cliente ID of this cliente lim credito
	*/
	@Override
	public long getClienteId() {
		return _clienteLimCredito.getClienteId();
	}

	/**
	* Sets the cliente ID of this cliente lim credito.
	*
	* @param clienteId the cliente ID of this cliente lim credito
	*/
	@Override
	public void setClienteId(long clienteId) {
		_clienteLimCredito.setClienteId(clienteId);
	}

	@Override
	public boolean isNew() {
		return _clienteLimCredito.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_clienteLimCredito.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _clienteLimCredito.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_clienteLimCredito.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _clienteLimCredito.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _clienteLimCredito.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_clienteLimCredito.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _clienteLimCredito.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_clienteLimCredito.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_clienteLimCredito.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_clienteLimCredito.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClienteLimCreditoWrapper((ClienteLimCredito)_clienteLimCredito.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.cliente.model.ClienteLimCredito clienteLimCredito) {
		return _clienteLimCredito.compareTo(clienteLimCredito);
	}

	@Override
	public int hashCode() {
		return _clienteLimCredito.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.cliente.model.ClienteLimCredito> toCacheModel() {
		return _clienteLimCredito.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.cliente.model.ClienteLimCredito toEscapedModel() {
		return new ClienteLimCreditoWrapper(_clienteLimCredito.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.cliente.model.ClienteLimCredito toUnescapedModel() {
		return new ClienteLimCreditoWrapper(_clienteLimCredito.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _clienteLimCredito.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _clienteLimCredito.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_clienteLimCredito.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClienteLimCreditoWrapper)) {
			return false;
		}

		ClienteLimCreditoWrapper clienteLimCreditoWrapper = (ClienteLimCreditoWrapper)obj;

		if (Validator.equals(_clienteLimCredito,
					clienteLimCreditoWrapper._clienteLimCredito)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ClienteLimCredito getWrappedClienteLimCredito() {
		return _clienteLimCredito;
	}

	@Override
	public ClienteLimCredito getWrappedModel() {
		return _clienteLimCredito;
	}

	@Override
	public void resetOriginalValues() {
		_clienteLimCredito.resetOriginalValues();
	}

	private ClienteLimCredito _clienteLimCredito;
}