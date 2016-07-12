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
 * This class is a wrapper for {@link Telefone}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Telefone
 * @generated
 */
public class TelefoneWrapper implements Telefone, ModelWrapper<Telefone> {
	public TelefoneWrapper(Telefone telefone) {
		_telefone = telefone;
	}

	@Override
	public Class<?> getModelClass() {
		return Telefone.class;
	}

	@Override
	public String getModelClassName() {
		return Telefone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("telefoneId", getTelefoneId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("ddi", getDdi());
		attributes.put("ddd", getDdd());
		attributes.put("numero", getNumero());
		attributes.put("ramal", getRamal());
		attributes.put("tipo", getTipo());
		attributes.put("principal", getPrincipal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long telefoneId = (Long)attributes.get("telefoneId");

		if (telefoneId != null) {
			setTelefoneId(telefoneId);
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

		String ddi = (String)attributes.get("ddi");

		if (ddi != null) {
			setDdi(ddi);
		}

		String ddd = (String)attributes.get("ddd");

		if (ddd != null) {
			setDdd(ddd);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		String ramal = (String)attributes.get("ramal");

		if (ramal != null) {
			setRamal(ramal);
		}

		Integer tipo = (Integer)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		Boolean principal = (Boolean)attributes.get("principal");

		if (principal != null) {
			setPrincipal(principal);
		}
	}

	/**
	* Returns the primary key of this telefone.
	*
	* @return the primary key of this telefone
	*/
	@Override
	public long getPrimaryKey() {
		return _telefone.getPrimaryKey();
	}

	/**
	* Sets the primary key of this telefone.
	*
	* @param primaryKey the primary key of this telefone
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_telefone.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this telefone.
	*
	* @return the uuid of this telefone
	*/
	@Override
	public java.lang.String getUuid() {
		return _telefone.getUuid();
	}

	/**
	* Sets the uuid of this telefone.
	*
	* @param uuid the uuid of this telefone
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_telefone.setUuid(uuid);
	}

	/**
	* Returns the telefone ID of this telefone.
	*
	* @return the telefone ID of this telefone
	*/
	@Override
	public long getTelefoneId() {
		return _telefone.getTelefoneId();
	}

	/**
	* Sets the telefone ID of this telefone.
	*
	* @param telefoneId the telefone ID of this telefone
	*/
	@Override
	public void setTelefoneId(long telefoneId) {
		_telefone.setTelefoneId(telefoneId);
	}

	/**
	* Returns the company ID of this telefone.
	*
	* @return the company ID of this telefone
	*/
	@Override
	public long getCompanyId() {
		return _telefone.getCompanyId();
	}

	/**
	* Sets the company ID of this telefone.
	*
	* @param companyId the company ID of this telefone
	*/
	@Override
	public void setCompanyId(long companyId) {
		_telefone.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this telefone.
	*
	* @return the group ID of this telefone
	*/
	@Override
	public long getGroupId() {
		return _telefone.getGroupId();
	}

	/**
	* Sets the group ID of this telefone.
	*
	* @param groupId the group ID of this telefone
	*/
	@Override
	public void setGroupId(long groupId) {
		_telefone.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this telefone.
	*
	* @return the create user ID of this telefone
	*/
	@Override
	public long getCreateUserId() {
		return _telefone.getCreateUserId();
	}

	/**
	* Sets the create user ID of this telefone.
	*
	* @param createUserId the create user ID of this telefone
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_telefone.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this telefone.
	*
	* @return the create user uuid of this telefone
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefone.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this telefone.
	*
	* @param createUserUuid the create user uuid of this telefone
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_telefone.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this telefone.
	*
	* @return the modified user ID of this telefone
	*/
	@Override
	public long getModifiedUserId() {
		return _telefone.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this telefone.
	*
	* @param modifiedUserId the modified user ID of this telefone
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_telefone.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this telefone.
	*
	* @return the modified user uuid of this telefone
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefone.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this telefone.
	*
	* @param modifiedUserUuid the modified user uuid of this telefone
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_telefone.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this telefone.
	*
	* @return the create date of this telefone
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _telefone.getCreateDate();
	}

	/**
	* Sets the create date of this telefone.
	*
	* @param createDate the create date of this telefone
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_telefone.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this telefone.
	*
	* @return the modified date of this telefone
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _telefone.getModifiedDate();
	}

	/**
	* Sets the modified date of this telefone.
	*
	* @param modifiedDate the modified date of this telefone
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_telefone.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fully qualified class name of this telefone.
	*
	* @return the fully qualified class name of this telefone
	*/
	@Override
	public java.lang.String getClassName() {
		return _telefone.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_telefone.setClassName(className);
	}

	/**
	* Returns the class name ID of this telefone.
	*
	* @return the class name ID of this telefone
	*/
	@Override
	public long getClassNameId() {
		return _telefone.getClassNameId();
	}

	/**
	* Sets the class name ID of this telefone.
	*
	* @param classNameId the class name ID of this telefone
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_telefone.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this telefone.
	*
	* @return the class p k of this telefone
	*/
	@Override
	public long getClassPK() {
		return _telefone.getClassPK();
	}

	/**
	* Sets the class p k of this telefone.
	*
	* @param classPK the class p k of this telefone
	*/
	@Override
	public void setClassPK(long classPK) {
		_telefone.setClassPK(classPK);
	}

	/**
	* Returns the ddi of this telefone.
	*
	* @return the ddi of this telefone
	*/
	@Override
	public java.lang.String getDdi() {
		return _telefone.getDdi();
	}

	/**
	* Sets the ddi of this telefone.
	*
	* @param ddi the ddi of this telefone
	*/
	@Override
	public void setDdi(java.lang.String ddi) {
		_telefone.setDdi(ddi);
	}

	/**
	* Returns the ddd of this telefone.
	*
	* @return the ddd of this telefone
	*/
	@Override
	public java.lang.String getDdd() {
		return _telefone.getDdd();
	}

	/**
	* Sets the ddd of this telefone.
	*
	* @param ddd the ddd of this telefone
	*/
	@Override
	public void setDdd(java.lang.String ddd) {
		_telefone.setDdd(ddd);
	}

	/**
	* Returns the numero of this telefone.
	*
	* @return the numero of this telefone
	*/
	@Override
	public java.lang.String getNumero() {
		return _telefone.getNumero();
	}

	/**
	* Sets the numero of this telefone.
	*
	* @param numero the numero of this telefone
	*/
	@Override
	public void setNumero(java.lang.String numero) {
		_telefone.setNumero(numero);
	}

	/**
	* Returns the ramal of this telefone.
	*
	* @return the ramal of this telefone
	*/
	@Override
	public java.lang.String getRamal() {
		return _telefone.getRamal();
	}

	/**
	* Sets the ramal of this telefone.
	*
	* @param ramal the ramal of this telefone
	*/
	@Override
	public void setRamal(java.lang.String ramal) {
		_telefone.setRamal(ramal);
	}

	/**
	* Returns the tipo of this telefone.
	*
	* @return the tipo of this telefone
	*/
	@Override
	public int getTipo() {
		return _telefone.getTipo();
	}

	/**
	* Sets the tipo of this telefone.
	*
	* @param tipo the tipo of this telefone
	*/
	@Override
	public void setTipo(int tipo) {
		_telefone.setTipo(tipo);
	}

	/**
	* Returns the principal of this telefone.
	*
	* @return the principal of this telefone
	*/
	@Override
	public boolean getPrincipal() {
		return _telefone.getPrincipal();
	}

	/**
	* Returns <code>true</code> if this telefone is principal.
	*
	* @return <code>true</code> if this telefone is principal; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrincipal() {
		return _telefone.isPrincipal();
	}

	/**
	* Sets whether this telefone is principal.
	*
	* @param principal the principal of this telefone
	*/
	@Override
	public void setPrincipal(boolean principal) {
		_telefone.setPrincipal(principal);
	}

	@Override
	public boolean isNew() {
		return _telefone.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_telefone.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _telefone.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_telefone.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _telefone.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _telefone.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_telefone.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _telefone.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_telefone.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_telefone.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_telefone.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TelefoneWrapper((Telefone)_telefone.clone());
	}

	@Override
	public int compareTo(br.com.prodevelopment.contato.model.Telefone telefone) {
		return _telefone.compareTo(telefone);
	}

	@Override
	public int hashCode() {
		return _telefone.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.contato.model.Telefone> toCacheModel() {
		return _telefone.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.contato.model.Telefone toEscapedModel() {
		return new TelefoneWrapper(_telefone.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.contato.model.Telefone toUnescapedModel() {
		return new TelefoneWrapper(_telefone.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _telefone.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _telefone.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_telefone.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TelefoneWrapper)) {
			return false;
		}

		TelefoneWrapper telefoneWrapper = (TelefoneWrapper)obj;

		if (Validator.equals(_telefone, telefoneWrapper._telefone)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _telefone.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Telefone getWrappedTelefone() {
		return _telefone;
	}

	@Override
	public Telefone getWrappedModel() {
		return _telefone;
	}

	@Override
	public void resetOriginalValues() {
		_telefone.resetOriginalValues();
	}

	private Telefone _telefone;
}