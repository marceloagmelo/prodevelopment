/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package br.com.prodevelopment.testeconhecimento.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Resposta_Usuario}.
 * </p>
 *
 * @author    Marcelo Melo
 * @see       Resposta_Usuario
 * @generated
 */
public class Resposta_UsuarioWrapper implements Resposta_Usuario,
	ModelWrapper<Resposta_Usuario> {
	public Resposta_UsuarioWrapper(Resposta_Usuario resposta_Usuario) {
		_resposta_Usuario = resposta_Usuario;
	}

	public Class<?> getModelClass() {
		return Resposta_Usuario.class;
	}

	public String getModelClassName() {
		return Resposta_Usuario.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("correta", getCorreta());
		attributes.put("dataInclusao", getDataInclusao());
		attributes.put("testeUsuarioId", getTesteUsuarioId());
		attributes.put("respostaId", getRespostaId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Boolean correta = (Boolean)attributes.get("correta");

		if (correta != null) {
			setCorreta(correta);
		}

		Date dataInclusao = (Date)attributes.get("dataInclusao");

		if (dataInclusao != null) {
			setDataInclusao(dataInclusao);
		}

		Long testeUsuarioId = (Long)attributes.get("testeUsuarioId");

		if (testeUsuarioId != null) {
			setTesteUsuarioId(testeUsuarioId);
		}

		Long respostaId = (Long)attributes.get("respostaId");

		if (respostaId != null) {
			setRespostaId(respostaId);
		}
	}

	/**
	* Returns the primary key of this resposta_ usuario.
	*
	* @return the primary key of this resposta_ usuario
	*/
	public long getPrimaryKey() {
		return _resposta_Usuario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this resposta_ usuario.
	*
	* @param primaryKey the primary key of this resposta_ usuario
	*/
	public void setPrimaryKey(long primaryKey) {
		_resposta_Usuario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this resposta_ usuario.
	*
	* @return the ID of this resposta_ usuario
	*/
	public long getId() {
		return _resposta_Usuario.getId();
	}

	/**
	* Sets the ID of this resposta_ usuario.
	*
	* @param id the ID of this resposta_ usuario
	*/
	public void setId(long id) {
		_resposta_Usuario.setId(id);
	}

	/**
	* Returns the correta of this resposta_ usuario.
	*
	* @return the correta of this resposta_ usuario
	*/
	public boolean getCorreta() {
		return _resposta_Usuario.getCorreta();
	}

	/**
	* Returns <code>true</code> if this resposta_ usuario is correta.
	*
	* @return <code>true</code> if this resposta_ usuario is correta; <code>false</code> otherwise
	*/
	public boolean isCorreta() {
		return _resposta_Usuario.isCorreta();
	}

	/**
	* Sets whether this resposta_ usuario is correta.
	*
	* @param correta the correta of this resposta_ usuario
	*/
	public void setCorreta(boolean correta) {
		_resposta_Usuario.setCorreta(correta);
	}

	/**
	* Returns the data inclusao of this resposta_ usuario.
	*
	* @return the data inclusao of this resposta_ usuario
	*/
	public java.util.Date getDataInclusao() {
		return _resposta_Usuario.getDataInclusao();
	}

	/**
	* Sets the data inclusao of this resposta_ usuario.
	*
	* @param dataInclusao the data inclusao of this resposta_ usuario
	*/
	public void setDataInclusao(java.util.Date dataInclusao) {
		_resposta_Usuario.setDataInclusao(dataInclusao);
	}

	/**
	* Returns the teste usuario ID of this resposta_ usuario.
	*
	* @return the teste usuario ID of this resposta_ usuario
	*/
	public long getTesteUsuarioId() {
		return _resposta_Usuario.getTesteUsuarioId();
	}

	/**
	* Sets the teste usuario ID of this resposta_ usuario.
	*
	* @param testeUsuarioId the teste usuario ID of this resposta_ usuario
	*/
	public void setTesteUsuarioId(long testeUsuarioId) {
		_resposta_Usuario.setTesteUsuarioId(testeUsuarioId);
	}

	/**
	* Returns the resposta ID of this resposta_ usuario.
	*
	* @return the resposta ID of this resposta_ usuario
	*/
	public long getRespostaId() {
		return _resposta_Usuario.getRespostaId();
	}

	/**
	* Sets the resposta ID of this resposta_ usuario.
	*
	* @param respostaId the resposta ID of this resposta_ usuario
	*/
	public void setRespostaId(long respostaId) {
		_resposta_Usuario.setRespostaId(respostaId);
	}

	public boolean isNew() {
		return _resposta_Usuario.isNew();
	}

	public void setNew(boolean n) {
		_resposta_Usuario.setNew(n);
	}

	public boolean isCachedModel() {
		return _resposta_Usuario.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_resposta_Usuario.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _resposta_Usuario.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _resposta_Usuario.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_resposta_Usuario.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _resposta_Usuario.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resposta_Usuario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Resposta_UsuarioWrapper((Resposta_Usuario)_resposta_Usuario.clone());
	}

	public int compareTo(
		br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario resposta_Usuario) {
		return _resposta_Usuario.compareTo(resposta_Usuario);
	}

	@Override
	public int hashCode() {
		return _resposta_Usuario.hashCode();
	}

	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> toCacheModel() {
		return _resposta_Usuario.toCacheModel();
	}

	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario toEscapedModel() {
		return new Resposta_UsuarioWrapper(_resposta_Usuario.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _resposta_Usuario.toString();
	}

	public java.lang.String toXmlString() {
		return _resposta_Usuario.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_resposta_Usuario.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Resposta_Usuario getWrappedResposta_Usuario() {
		return _resposta_Usuario;
	}

	public Resposta_Usuario getWrappedModel() {
		return _resposta_Usuario;
	}

	public void resetOriginalValues() {
		_resposta_Usuario.resetOriginalValues();
	}

	private Resposta_Usuario _resposta_Usuario;
}