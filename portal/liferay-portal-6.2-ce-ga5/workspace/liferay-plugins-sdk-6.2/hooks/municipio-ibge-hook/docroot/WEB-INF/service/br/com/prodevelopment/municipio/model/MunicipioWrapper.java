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

package br.com.prodevelopment.municipio.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Municipio}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Municipio
 * @generated
 */
public class MunicipioWrapper implements Municipio, ModelWrapper<Municipio> {
	public MunicipioWrapper(Municipio municipio) {
		_municipio = municipio;
	}

	@Override
	public Class<?> getModelClass() {
		return Municipio.class;
	}

	@Override
	public String getModelClassName() {
		return Municipio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codigo", getCodigo());
		attributes.put("uf", getUf());
		attributes.put("cidade", getCidade());
		attributes.put("bairro", getBairro());
		attributes.put("logradouro", getLogradouro());
		attributes.put("cep", getCep());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long codigo = (Long)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String uf = (String)attributes.get("uf");

		if (uf != null) {
			setUf(uf);
		}

		String cidade = (String)attributes.get("cidade");

		if (cidade != null) {
			setCidade(cidade);
		}

		String bairro = (String)attributes.get("bairro");

		if (bairro != null) {
			setBairro(bairro);
		}

		String logradouro = (String)attributes.get("logradouro");

		if (logradouro != null) {
			setLogradouro(logradouro);
		}

		String cep = (String)attributes.get("cep");

		if (cep != null) {
			setCep(cep);
		}
	}

	/**
	* Returns the primary key of this municipio.
	*
	* @return the primary key of this municipio
	*/
	@Override
	public long getPrimaryKey() {
		return _municipio.getPrimaryKey();
	}

	/**
	* Sets the primary key of this municipio.
	*
	* @param primaryKey the primary key of this municipio
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_municipio.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codigo of this municipio.
	*
	* @return the codigo of this municipio
	*/
	@Override
	public long getCodigo() {
		return _municipio.getCodigo();
	}

	/**
	* Sets the codigo of this municipio.
	*
	* @param codigo the codigo of this municipio
	*/
	@Override
	public void setCodigo(long codigo) {
		_municipio.setCodigo(codigo);
	}

	/**
	* Returns the uf of this municipio.
	*
	* @return the uf of this municipio
	*/
	@Override
	public java.lang.String getUf() {
		return _municipio.getUf();
	}

	/**
	* Sets the uf of this municipio.
	*
	* @param uf the uf of this municipio
	*/
	@Override
	public void setUf(java.lang.String uf) {
		_municipio.setUf(uf);
	}

	/**
	* Returns the cidade of this municipio.
	*
	* @return the cidade of this municipio
	*/
	@Override
	public java.lang.String getCidade() {
		return _municipio.getCidade();
	}

	/**
	* Sets the cidade of this municipio.
	*
	* @param cidade the cidade of this municipio
	*/
	@Override
	public void setCidade(java.lang.String cidade) {
		_municipio.setCidade(cidade);
	}

	/**
	* Returns the bairro of this municipio.
	*
	* @return the bairro of this municipio
	*/
	@Override
	public java.lang.String getBairro() {
		return _municipio.getBairro();
	}

	/**
	* Sets the bairro of this municipio.
	*
	* @param bairro the bairro of this municipio
	*/
	@Override
	public void setBairro(java.lang.String bairro) {
		_municipio.setBairro(bairro);
	}

	/**
	* Returns the logradouro of this municipio.
	*
	* @return the logradouro of this municipio
	*/
	@Override
	public java.lang.String getLogradouro() {
		return _municipio.getLogradouro();
	}

	/**
	* Sets the logradouro of this municipio.
	*
	* @param logradouro the logradouro of this municipio
	*/
	@Override
	public void setLogradouro(java.lang.String logradouro) {
		_municipio.setLogradouro(logradouro);
	}

	/**
	* Returns the cep of this municipio.
	*
	* @return the cep of this municipio
	*/
	@Override
	public java.lang.String getCep() {
		return _municipio.getCep();
	}

	/**
	* Sets the cep of this municipio.
	*
	* @param cep the cep of this municipio
	*/
	@Override
	public void setCep(java.lang.String cep) {
		_municipio.setCep(cep);
	}

	@Override
	public boolean isNew() {
		return _municipio.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_municipio.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _municipio.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_municipio.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _municipio.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _municipio.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_municipio.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _municipio.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_municipio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_municipio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_municipio.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MunicipioWrapper((Municipio)_municipio.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.municipio.model.Municipio municipio) {
		return _municipio.compareTo(municipio);
	}

	@Override
	public int hashCode() {
		return _municipio.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.municipio.model.Municipio> toCacheModel() {
		return _municipio.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.municipio.model.Municipio toEscapedModel() {
		return new MunicipioWrapper(_municipio.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.municipio.model.Municipio toUnescapedModel() {
		return new MunicipioWrapper(_municipio.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _municipio.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _municipio.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_municipio.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MunicipioWrapper)) {
			return false;
		}

		MunicipioWrapper municipioWrapper = (MunicipioWrapper)obj;

		if (Validator.equals(_municipio, municipioWrapper._municipio)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Municipio getWrappedMunicipio() {
		return _municipio;
	}

	@Override
	public Municipio getWrappedModel() {
		return _municipio;
	}

	@Override
	public void resetOriginalValues() {
		_municipio.resetOriginalValues();
	}

	private Municipio _municipio;
}