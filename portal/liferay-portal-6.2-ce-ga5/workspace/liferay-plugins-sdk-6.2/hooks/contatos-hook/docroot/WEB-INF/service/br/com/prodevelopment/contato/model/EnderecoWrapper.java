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

package br.com.prodevelopment.contato.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Endereco}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Endereco
 * @generated
 */
public class EnderecoWrapper implements Endereco, ModelWrapper<Endereco> {
	public EnderecoWrapper(Endereco endereco) {
		_endereco = endereco;
	}

	@Override
	public Class<?> getModelClass() {
		return Endereco.class;
	}

	@Override
	public String getModelClassName() {
		return Endereco.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("enderecoId", getEnderecoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("logradouro", getLogradouro());
		attributes.put("numero", getNumero());
		attributes.put("complemento", getComplemento());
		attributes.put("cep", getCep());
		attributes.put("bairro", getBairro());
		attributes.put("cidadeId", getCidadeId());
		attributes.put("uf", getUf());
		attributes.put("paisId", getPaisId());
		attributes.put("principal", getPrincipal());
		attributes.put("tipo", getTipo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long enderecoId = (Long)attributes.get("enderecoId");

		if (enderecoId != null) {
			setEnderecoId(enderecoId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String logradouro = (String)attributes.get("logradouro");

		if (logradouro != null) {
			setLogradouro(logradouro);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		String complemento = (String)attributes.get("complemento");

		if (complemento != null) {
			setComplemento(complemento);
		}

		String cep = (String)attributes.get("cep");

		if (cep != null) {
			setCep(cep);
		}

		String bairro = (String)attributes.get("bairro");

		if (bairro != null) {
			setBairro(bairro);
		}

		Long cidadeId = (Long)attributes.get("cidadeId");

		if (cidadeId != null) {
			setCidadeId(cidadeId);
		}

		String uf = (String)attributes.get("uf");

		if (uf != null) {
			setUf(uf);
		}

		Long paisId = (Long)attributes.get("paisId");

		if (paisId != null) {
			setPaisId(paisId);
		}

		Boolean principal = (Boolean)attributes.get("principal");

		if (principal != null) {
			setPrincipal(principal);
		}

		Integer tipo = (Integer)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}
	}

	/**
	* Returns the primary key of this endereco.
	*
	* @return the primary key of this endereco
	*/
	@Override
	public long getPrimaryKey() {
		return _endereco.getPrimaryKey();
	}

	/**
	* Sets the primary key of this endereco.
	*
	* @param primaryKey the primary key of this endereco
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_endereco.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this endereco.
	*
	* @return the uuid of this endereco
	*/
	@Override
	public java.lang.String getUuid() {
		return _endereco.getUuid();
	}

	/**
	* Sets the uuid of this endereco.
	*
	* @param uuid the uuid of this endereco
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_endereco.setUuid(uuid);
	}

	/**
	* Returns the endereco ID of this endereco.
	*
	* @return the endereco ID of this endereco
	*/
	@Override
	public long getEnderecoId() {
		return _endereco.getEnderecoId();
	}

	/**
	* Sets the endereco ID of this endereco.
	*
	* @param enderecoId the endereco ID of this endereco
	*/
	@Override
	public void setEnderecoId(long enderecoId) {
		_endereco.setEnderecoId(enderecoId);
	}

	/**
	* Returns the company ID of this endereco.
	*
	* @return the company ID of this endereco
	*/
	@Override
	public long getCompanyId() {
		return _endereco.getCompanyId();
	}

	/**
	* Sets the company ID of this endereco.
	*
	* @param companyId the company ID of this endereco
	*/
	@Override
	public void setCompanyId(long companyId) {
		_endereco.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this endereco.
	*
	* @return the group ID of this endereco
	*/
	@Override
	public long getGroupId() {
		return _endereco.getGroupId();
	}

	/**
	* Sets the group ID of this endereco.
	*
	* @param groupId the group ID of this endereco
	*/
	@Override
	public void setGroupId(long groupId) {
		_endereco.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this endereco.
	*
	* @return the create user ID of this endereco
	*/
	@Override
	public long getCreateUserId() {
		return _endereco.getCreateUserId();
	}

	/**
	* Sets the create user ID of this endereco.
	*
	* @param createUserId the create user ID of this endereco
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_endereco.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this endereco.
	*
	* @return the create user uuid of this endereco
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _endereco.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this endereco.
	*
	* @param createUserUuid the create user uuid of this endereco
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_endereco.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this endereco.
	*
	* @return the modified user ID of this endereco
	*/
	@Override
	public long getModifiedUserId() {
		return _endereco.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this endereco.
	*
	* @param modifiedUserId the modified user ID of this endereco
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_endereco.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this endereco.
	*
	* @return the modified user uuid of this endereco
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _endereco.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this endereco.
	*
	* @param modifiedUserUuid the modified user uuid of this endereco
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_endereco.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this endereco.
	*
	* @return the create date of this endereco
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _endereco.getCreateDate();
	}

	/**
	* Sets the create date of this endereco.
	*
	* @param createDate the create date of this endereco
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_endereco.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this endereco.
	*
	* @return the modified date of this endereco
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _endereco.getModifiedDate();
	}

	/**
	* Sets the modified date of this endereco.
	*
	* @param modifiedDate the modified date of this endereco
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_endereco.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fully qualified class name of this endereco.
	*
	* @return the fully qualified class name of this endereco
	*/
	@Override
	public java.lang.String getClassName() {
		return _endereco.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_endereco.setClassName(className);
	}

	/**
	* Returns the class name ID of this endereco.
	*
	* @return the class name ID of this endereco
	*/
	@Override
	public long getClassNameId() {
		return _endereco.getClassNameId();
	}

	/**
	* Sets the class name ID of this endereco.
	*
	* @param classNameId the class name ID of this endereco
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_endereco.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this endereco.
	*
	* @return the class p k of this endereco
	*/
	@Override
	public long getClassPK() {
		return _endereco.getClassPK();
	}

	/**
	* Sets the class p k of this endereco.
	*
	* @param classPK the class p k of this endereco
	*/
	@Override
	public void setClassPK(long classPK) {
		_endereco.setClassPK(classPK);
	}

	/**
	* Returns the logradouro of this endereco.
	*
	* @return the logradouro of this endereco
	*/
	@Override
	public java.lang.String getLogradouro() {
		return _endereco.getLogradouro();
	}

	/**
	* Sets the logradouro of this endereco.
	*
	* @param logradouro the logradouro of this endereco
	*/
	@Override
	public void setLogradouro(java.lang.String logradouro) {
		_endereco.setLogradouro(logradouro);
	}

	/**
	* Returns the numero of this endereco.
	*
	* @return the numero of this endereco
	*/
	@Override
	public java.lang.String getNumero() {
		return _endereco.getNumero();
	}

	/**
	* Sets the numero of this endereco.
	*
	* @param numero the numero of this endereco
	*/
	@Override
	public void setNumero(java.lang.String numero) {
		_endereco.setNumero(numero);
	}

	/**
	* Returns the complemento of this endereco.
	*
	* @return the complemento of this endereco
	*/
	@Override
	public java.lang.String getComplemento() {
		return _endereco.getComplemento();
	}

	/**
	* Sets the complemento of this endereco.
	*
	* @param complemento the complemento of this endereco
	*/
	@Override
	public void setComplemento(java.lang.String complemento) {
		_endereco.setComplemento(complemento);
	}

	/**
	* Returns the cep of this endereco.
	*
	* @return the cep of this endereco
	*/
	@Override
	public java.lang.String getCep() {
		return _endereco.getCep();
	}

	/**
	* Sets the cep of this endereco.
	*
	* @param cep the cep of this endereco
	*/
	@Override
	public void setCep(java.lang.String cep) {
		_endereco.setCep(cep);
	}

	/**
	* Returns the bairro of this endereco.
	*
	* @return the bairro of this endereco
	*/
	@Override
	public java.lang.String getBairro() {
		return _endereco.getBairro();
	}

	/**
	* Sets the bairro of this endereco.
	*
	* @param bairro the bairro of this endereco
	*/
	@Override
	public void setBairro(java.lang.String bairro) {
		_endereco.setBairro(bairro);
	}

	/**
	* Returns the cidade ID of this endereco.
	*
	* @return the cidade ID of this endereco
	*/
	@Override
	public long getCidadeId() {
		return _endereco.getCidadeId();
	}

	/**
	* Sets the cidade ID of this endereco.
	*
	* @param cidadeId the cidade ID of this endereco
	*/
	@Override
	public void setCidadeId(long cidadeId) {
		_endereco.setCidadeId(cidadeId);
	}

	/**
	* Returns the uf of this endereco.
	*
	* @return the uf of this endereco
	*/
	@Override
	public java.lang.String getUf() {
		return _endereco.getUf();
	}

	/**
	* Sets the uf of this endereco.
	*
	* @param uf the uf of this endereco
	*/
	@Override
	public void setUf(java.lang.String uf) {
		_endereco.setUf(uf);
	}

	/**
	* Returns the pais ID of this endereco.
	*
	* @return the pais ID of this endereco
	*/
	@Override
	public long getPaisId() {
		return _endereco.getPaisId();
	}

	/**
	* Sets the pais ID of this endereco.
	*
	* @param paisId the pais ID of this endereco
	*/
	@Override
	public void setPaisId(long paisId) {
		_endereco.setPaisId(paisId);
	}

	/**
	* Returns the principal of this endereco.
	*
	* @return the principal of this endereco
	*/
	@Override
	public boolean getPrincipal() {
		return _endereco.getPrincipal();
	}

	/**
	* Returns <code>true</code> if this endereco is principal.
	*
	* @return <code>true</code> if this endereco is principal; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrincipal() {
		return _endereco.isPrincipal();
	}

	/**
	* Sets whether this endereco is principal.
	*
	* @param principal the principal of this endereco
	*/
	@Override
	public void setPrincipal(boolean principal) {
		_endereco.setPrincipal(principal);
	}

	/**
	* Returns the tipo of this endereco.
	*
	* @return the tipo of this endereco
	*/
	@Override
	public int getTipo() {
		return _endereco.getTipo();
	}

	/**
	* Sets the tipo of this endereco.
	*
	* @param tipo the tipo of this endereco
	*/
	@Override
	public void setTipo(int tipo) {
		_endereco.setTipo(tipo);
	}

	@Override
	public boolean isNew() {
		return _endereco.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_endereco.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _endereco.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_endereco.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _endereco.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _endereco.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_endereco.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _endereco.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_endereco.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_endereco.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_endereco.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnderecoWrapper((Endereco)_endereco.clone());
	}

	@Override
	public int compareTo(br.com.prodevelopment.contato.model.Endereco endereco) {
		return _endereco.compareTo(endereco);
	}

	@Override
	public int hashCode() {
		return _endereco.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.contato.model.Endereco> toCacheModel() {
		return _endereco.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.contato.model.Endereco toEscapedModel() {
		return new EnderecoWrapper(_endereco.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.contato.model.Endereco toUnescapedModel() {
		return new EnderecoWrapper(_endereco.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _endereco.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _endereco.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_endereco.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EnderecoWrapper)) {
			return false;
		}

		EnderecoWrapper enderecoWrapper = (EnderecoWrapper)obj;

		if (Validator.equals(_endereco, enderecoWrapper._endereco)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _endereco.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Endereco getWrappedEndereco() {
		return _endereco;
	}

	@Override
	public Endereco getWrappedModel() {
		return _endereco;
	}

	@Override
	public void resetOriginalValues() {
		_endereco.resetOriginalValues();
	}

	private Endereco _endereco;
}