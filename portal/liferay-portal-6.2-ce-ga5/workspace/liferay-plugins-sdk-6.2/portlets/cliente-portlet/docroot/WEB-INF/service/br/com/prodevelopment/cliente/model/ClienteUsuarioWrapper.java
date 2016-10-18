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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClienteUsuario}.
 * </p>
 *
 * @author marcelo
 * @see ClienteUsuario
 * @generated
 */
public class ClienteUsuarioWrapper implements ClienteUsuario,
	ModelWrapper<ClienteUsuario> {
	public ClienteUsuarioWrapper(ClienteUsuario clienteUsuario) {
		_clienteUsuario = clienteUsuario;
	}

	@Override
	public Class<?> getModelClass() {
		return ClienteUsuario.class;
	}

	@Override
	public String getModelClassName() {
		return ClienteUsuario.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clienteUsuarioId", getClienteUsuarioId());
		attributes.put("userId", getUserId());
		attributes.put("clienteId", getClienteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clienteUsuarioId = (Long)attributes.get("clienteUsuarioId");

		if (clienteUsuarioId != null) {
			setClienteUsuarioId(clienteUsuarioId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long clienteId = (Long)attributes.get("clienteId");

		if (clienteId != null) {
			setClienteId(clienteId);
		}
	}

	/**
	* Returns the primary key of this cliente usuario.
	*
	* @return the primary key of this cliente usuario
	*/
	@Override
	public long getPrimaryKey() {
		return _clienteUsuario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cliente usuario.
	*
	* @param primaryKey the primary key of this cliente usuario
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_clienteUsuario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cliente usuario ID of this cliente usuario.
	*
	* @return the cliente usuario ID of this cliente usuario
	*/
	@Override
	public long getClienteUsuarioId() {
		return _clienteUsuario.getClienteUsuarioId();
	}

	/**
	* Sets the cliente usuario ID of this cliente usuario.
	*
	* @param clienteUsuarioId the cliente usuario ID of this cliente usuario
	*/
	@Override
	public void setClienteUsuarioId(long clienteUsuarioId) {
		_clienteUsuario.setClienteUsuarioId(clienteUsuarioId);
	}

	/**
	* Returns the user ID of this cliente usuario.
	*
	* @return the user ID of this cliente usuario
	*/
	@Override
	public long getUserId() {
		return _clienteUsuario.getUserId();
	}

	/**
	* Sets the user ID of this cliente usuario.
	*
	* @param userId the user ID of this cliente usuario
	*/
	@Override
	public void setUserId(long userId) {
		_clienteUsuario.setUserId(userId);
	}

	/**
	* Returns the user uuid of this cliente usuario.
	*
	* @return the user uuid of this cliente usuario
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clienteUsuario.getUserUuid();
	}

	/**
	* Sets the user uuid of this cliente usuario.
	*
	* @param userUuid the user uuid of this cliente usuario
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_clienteUsuario.setUserUuid(userUuid);
	}

	/**
	* Returns the cliente ID of this cliente usuario.
	*
	* @return the cliente ID of this cliente usuario
	*/
	@Override
	public long getClienteId() {
		return _clienteUsuario.getClienteId();
	}

	/**
	* Sets the cliente ID of this cliente usuario.
	*
	* @param clienteId the cliente ID of this cliente usuario
	*/
	@Override
	public void setClienteId(long clienteId) {
		_clienteUsuario.setClienteId(clienteId);
	}

	@Override
	public boolean isNew() {
		return _clienteUsuario.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_clienteUsuario.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _clienteUsuario.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_clienteUsuario.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _clienteUsuario.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _clienteUsuario.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_clienteUsuario.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _clienteUsuario.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_clienteUsuario.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_clienteUsuario.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_clienteUsuario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClienteUsuarioWrapper((ClienteUsuario)_clienteUsuario.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.cliente.model.ClienteUsuario clienteUsuario) {
		return _clienteUsuario.compareTo(clienteUsuario);
	}

	@Override
	public int hashCode() {
		return _clienteUsuario.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.cliente.model.ClienteUsuario> toCacheModel() {
		return _clienteUsuario.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.cliente.model.ClienteUsuario toEscapedModel() {
		return new ClienteUsuarioWrapper(_clienteUsuario.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.cliente.model.ClienteUsuario toUnescapedModel() {
		return new ClienteUsuarioWrapper(_clienteUsuario.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _clienteUsuario.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _clienteUsuario.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_clienteUsuario.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClienteUsuarioWrapper)) {
			return false;
		}

		ClienteUsuarioWrapper clienteUsuarioWrapper = (ClienteUsuarioWrapper)obj;

		if (Validator.equals(_clienteUsuario,
					clienteUsuarioWrapper._clienteUsuario)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ClienteUsuario getWrappedClienteUsuario() {
		return _clienteUsuario;
	}

	@Override
	public ClienteUsuario getWrappedModel() {
		return _clienteUsuario;
	}

	@Override
	public void resetOriginalValues() {
		_clienteUsuario.resetOriginalValues();
	}

	private ClienteUsuario _clienteUsuario;
}