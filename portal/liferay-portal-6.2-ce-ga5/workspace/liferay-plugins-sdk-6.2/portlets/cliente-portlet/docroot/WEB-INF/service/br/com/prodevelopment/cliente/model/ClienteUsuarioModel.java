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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ClienteUsuario service. Represents a row in the &quot;ClienteUsuario&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.prodevelopment.cliente.model.impl.ClienteUsuarioImpl}.
 * </p>
 *
 * @author marcelo
 * @see ClienteUsuario
 * @see br.com.prodevelopment.cliente.model.impl.ClienteUsuarioImpl
 * @see br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl
 * @generated
 */
public interface ClienteUsuarioModel extends BaseModel<ClienteUsuario> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cliente usuario model instance should use the {@link ClienteUsuario} interface instead.
	 */

	/**
	 * Returns the primary key of this cliente usuario.
	 *
	 * @return the primary key of this cliente usuario
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cliente usuario.
	 *
	 * @param primaryKey the primary key of this cliente usuario
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cliente usuario ID of this cliente usuario.
	 *
	 * @return the cliente usuario ID of this cliente usuario
	 */
	public long getClienteUsuarioId();

	/**
	 * Sets the cliente usuario ID of this cliente usuario.
	 *
	 * @param clienteUsuarioId the cliente usuario ID of this cliente usuario
	 */
	public void setClienteUsuarioId(long clienteUsuarioId);

	/**
	 * Returns the user ID of this cliente usuario.
	 *
	 * @return the user ID of this cliente usuario
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this cliente usuario.
	 *
	 * @param userId the user ID of this cliente usuario
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cliente usuario.
	 *
	 * @return the user uuid of this cliente usuario
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this cliente usuario.
	 *
	 * @param userUuid the user uuid of this cliente usuario
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the cliente ID of this cliente usuario.
	 *
	 * @return the cliente ID of this cliente usuario
	 */
	public long getClienteId();

	/**
	 * Sets the cliente ID of this cliente usuario.
	 *
	 * @param clienteId the cliente ID of this cliente usuario
	 */
	public void setClienteId(long clienteId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ClienteUsuario clienteUsuario);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ClienteUsuario> toCacheModel();

	@Override
	public ClienteUsuario toEscapedModel();

	@Override
	public ClienteUsuario toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}