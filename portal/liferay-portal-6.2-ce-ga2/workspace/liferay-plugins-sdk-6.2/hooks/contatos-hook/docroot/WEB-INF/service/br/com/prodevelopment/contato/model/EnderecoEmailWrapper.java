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
 * This class is a wrapper for {@link EnderecoEmail}.
 * </p>
 *
 * @author marcelo
 * @see EnderecoEmail
 * @generated
 */
public class EnderecoEmailWrapper implements EnderecoEmail,
	ModelWrapper<EnderecoEmail> {
	public EnderecoEmailWrapper(EnderecoEmail enderecoEmail) {
		_enderecoEmail = enderecoEmail;
	}

	@Override
	public Class<?> getModelClass() {
		return EnderecoEmail.class;
	}

	@Override
	public String getModelClassName() {
		return EnderecoEmail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("enderecoEmailId", getEnderecoEmailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("endereco", getEndereco());
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

		Long enderecoEmailId = (Long)attributes.get("enderecoEmailId");

		if (enderecoEmailId != null) {
			setEnderecoEmailId(enderecoEmailId);
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

		String endereco = (String)attributes.get("endereco");

		if (endereco != null) {
			setEndereco(endereco);
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
	* Returns the primary key of this endereco email.
	*
	* @return the primary key of this endereco email
	*/
	@Override
	public long getPrimaryKey() {
		return _enderecoEmail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this endereco email.
	*
	* @param primaryKey the primary key of this endereco email
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_enderecoEmail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this endereco email.
	*
	* @return the uuid of this endereco email
	*/
	@Override
	public java.lang.String getUuid() {
		return _enderecoEmail.getUuid();
	}

	/**
	* Sets the uuid of this endereco email.
	*
	* @param uuid the uuid of this endereco email
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_enderecoEmail.setUuid(uuid);
	}

	/**
	* Returns the endereco email ID of this endereco email.
	*
	* @return the endereco email ID of this endereco email
	*/
	@Override
	public long getEnderecoEmailId() {
		return _enderecoEmail.getEnderecoEmailId();
	}

	/**
	* Sets the endereco email ID of this endereco email.
	*
	* @param enderecoEmailId the endereco email ID of this endereco email
	*/
	@Override
	public void setEnderecoEmailId(long enderecoEmailId) {
		_enderecoEmail.setEnderecoEmailId(enderecoEmailId);
	}

	/**
	* Returns the company ID of this endereco email.
	*
	* @return the company ID of this endereco email
	*/
	@Override
	public long getCompanyId() {
		return _enderecoEmail.getCompanyId();
	}

	/**
	* Sets the company ID of this endereco email.
	*
	* @param companyId the company ID of this endereco email
	*/
	@Override
	public void setCompanyId(long companyId) {
		_enderecoEmail.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this endereco email.
	*
	* @return the group ID of this endereco email
	*/
	@Override
	public long getGroupId() {
		return _enderecoEmail.getGroupId();
	}

	/**
	* Sets the group ID of this endereco email.
	*
	* @param groupId the group ID of this endereco email
	*/
	@Override
	public void setGroupId(long groupId) {
		_enderecoEmail.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this endereco email.
	*
	* @return the create user ID of this endereco email
	*/
	@Override
	public long getCreateUserId() {
		return _enderecoEmail.getCreateUserId();
	}

	/**
	* Sets the create user ID of this endereco email.
	*
	* @param createUserId the create user ID of this endereco email
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_enderecoEmail.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this endereco email.
	*
	* @return the create user uuid of this endereco email
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoEmail.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this endereco email.
	*
	* @param createUserUuid the create user uuid of this endereco email
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_enderecoEmail.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this endereco email.
	*
	* @return the modified user ID of this endereco email
	*/
	@Override
	public long getModifiedUserId() {
		return _enderecoEmail.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this endereco email.
	*
	* @param modifiedUserId the modified user ID of this endereco email
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_enderecoEmail.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this endereco email.
	*
	* @return the modified user uuid of this endereco email
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enderecoEmail.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this endereco email.
	*
	* @param modifiedUserUuid the modified user uuid of this endereco email
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_enderecoEmail.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this endereco email.
	*
	* @return the create date of this endereco email
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _enderecoEmail.getCreateDate();
	}

	/**
	* Sets the create date of this endereco email.
	*
	* @param createDate the create date of this endereco email
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_enderecoEmail.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this endereco email.
	*
	* @return the modified date of this endereco email
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _enderecoEmail.getModifiedDate();
	}

	/**
	* Sets the modified date of this endereco email.
	*
	* @param modifiedDate the modified date of this endereco email
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_enderecoEmail.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fully qualified class name of this endereco email.
	*
	* @return the fully qualified class name of this endereco email
	*/
	@Override
	public java.lang.String getClassName() {
		return _enderecoEmail.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_enderecoEmail.setClassName(className);
	}

	/**
	* Returns the class name ID of this endereco email.
	*
	* @return the class name ID of this endereco email
	*/
	@Override
	public long getClassNameId() {
		return _enderecoEmail.getClassNameId();
	}

	/**
	* Sets the class name ID of this endereco email.
	*
	* @param classNameId the class name ID of this endereco email
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_enderecoEmail.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this endereco email.
	*
	* @return the class p k of this endereco email
	*/
	@Override
	public long getClassPK() {
		return _enderecoEmail.getClassPK();
	}

	/**
	* Sets the class p k of this endereco email.
	*
	* @param classPK the class p k of this endereco email
	*/
	@Override
	public void setClassPK(long classPK) {
		_enderecoEmail.setClassPK(classPK);
	}

	/**
	* Returns the endereco of this endereco email.
	*
	* @return the endereco of this endereco email
	*/
	@Override
	public java.lang.String getEndereco() {
		return _enderecoEmail.getEndereco();
	}

	/**
	* Sets the endereco of this endereco email.
	*
	* @param endereco the endereco of this endereco email
	*/
	@Override
	public void setEndereco(java.lang.String endereco) {
		_enderecoEmail.setEndereco(endereco);
	}

	/**
	* Returns the tipo of this endereco email.
	*
	* @return the tipo of this endereco email
	*/
	@Override
	public int getTipo() {
		return _enderecoEmail.getTipo();
	}

	/**
	* Sets the tipo of this endereco email.
	*
	* @param tipo the tipo of this endereco email
	*/
	@Override
	public void setTipo(int tipo) {
		_enderecoEmail.setTipo(tipo);
	}

	/**
	* Returns the principal of this endereco email.
	*
	* @return the principal of this endereco email
	*/
	@Override
	public boolean getPrincipal() {
		return _enderecoEmail.getPrincipal();
	}

	/**
	* Returns <code>true</code> if this endereco email is principal.
	*
	* @return <code>true</code> if this endereco email is principal; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrincipal() {
		return _enderecoEmail.isPrincipal();
	}

	/**
	* Sets whether this endereco email is principal.
	*
	* @param principal the principal of this endereco email
	*/
	@Override
	public void setPrincipal(boolean principal) {
		_enderecoEmail.setPrincipal(principal);
	}

	@Override
	public boolean isNew() {
		return _enderecoEmail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_enderecoEmail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _enderecoEmail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_enderecoEmail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _enderecoEmail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _enderecoEmail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_enderecoEmail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _enderecoEmail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_enderecoEmail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_enderecoEmail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_enderecoEmail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnderecoEmailWrapper((EnderecoEmail)_enderecoEmail.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail) {
		return _enderecoEmail.compareTo(enderecoEmail);
	}

	@Override
	public int hashCode() {
		return _enderecoEmail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.contato.model.EnderecoEmail> toCacheModel() {
		return _enderecoEmail.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.contato.model.EnderecoEmail toEscapedModel() {
		return new EnderecoEmailWrapper(_enderecoEmail.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.contato.model.EnderecoEmail toUnescapedModel() {
		return new EnderecoEmailWrapper(_enderecoEmail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _enderecoEmail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _enderecoEmail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_enderecoEmail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EnderecoEmailWrapper)) {
			return false;
		}

		EnderecoEmailWrapper enderecoEmailWrapper = (EnderecoEmailWrapper)obj;

		if (Validator.equals(_enderecoEmail, enderecoEmailWrapper._enderecoEmail)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _enderecoEmail.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EnderecoEmail getWrappedEnderecoEmail() {
		return _enderecoEmail;
	}

	@Override
	public EnderecoEmail getWrappedModel() {
		return _enderecoEmail;
	}

	@Override
	public void resetOriginalValues() {
		_enderecoEmail.resetOriginalValues();
	}

	private EnderecoEmail _enderecoEmail;
}