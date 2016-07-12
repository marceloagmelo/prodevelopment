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

package br.com.prodevelopment.eticket.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TypeTicketUsers}.
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTicketUsers
 * @generated
 */
public class TypeTicketUsersWrapper implements TypeTicketUsers,
	ModelWrapper<TypeTicketUsers> {
	public TypeTicketUsersWrapper(TypeTicketUsers typeTicketUsers) {
		_typeTicketUsers = typeTicketUsers;
	}

	@Override
	public Class<?> getModelClass() {
		return TypeTicketUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TypeTicketUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeTicketUsersId", getTypeTicketUsersId());
		attributes.put("userIdCreate", getUserIdCreate());
		attributes.put("userIdModified", getUserIdModified());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typeTicketId", getTypeTicketId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeTicketUsersId = (Long)attributes.get("typeTicketUsersId");

		if (typeTicketUsersId != null) {
			setTypeTicketUsersId(typeTicketUsersId);
		}

		Long userIdCreate = (Long)attributes.get("userIdCreate");

		if (userIdCreate != null) {
			setUserIdCreate(userIdCreate);
		}

		Long userIdModified = (Long)attributes.get("userIdModified");

		if (userIdModified != null) {
			setUserIdModified(userIdModified);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long typeTicketId = (Long)attributes.get("typeTicketId");

		if (typeTicketId != null) {
			setTypeTicketId(typeTicketId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this type ticket users.
	*
	* @return the primary key of this type ticket users
	*/
	@Override
	public long getPrimaryKey() {
		return _typeTicketUsers.getPrimaryKey();
	}

	/**
	* Sets the primary key of this type ticket users.
	*
	* @param primaryKey the primary key of this type ticket users
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_typeTicketUsers.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the type ticket users ID of this type ticket users.
	*
	* @return the type ticket users ID of this type ticket users
	*/
	@Override
	public long getTypeTicketUsersId() {
		return _typeTicketUsers.getTypeTicketUsersId();
	}

	/**
	* Sets the type ticket users ID of this type ticket users.
	*
	* @param typeTicketUsersId the type ticket users ID of this type ticket users
	*/
	@Override
	public void setTypeTicketUsersId(long typeTicketUsersId) {
		_typeTicketUsers.setTypeTicketUsersId(typeTicketUsersId);
	}

	/**
	* Returns the user ID create of this type ticket users.
	*
	* @return the user ID create of this type ticket users
	*/
	@Override
	public long getUserIdCreate() {
		return _typeTicketUsers.getUserIdCreate();
	}

	/**
	* Sets the user ID create of this type ticket users.
	*
	* @param userIdCreate the user ID create of this type ticket users
	*/
	@Override
	public void setUserIdCreate(long userIdCreate) {
		_typeTicketUsers.setUserIdCreate(userIdCreate);
	}

	/**
	* Returns the user ID modified of this type ticket users.
	*
	* @return the user ID modified of this type ticket users
	*/
	@Override
	public long getUserIdModified() {
		return _typeTicketUsers.getUserIdModified();
	}

	/**
	* Sets the user ID modified of this type ticket users.
	*
	* @param userIdModified the user ID modified of this type ticket users
	*/
	@Override
	public void setUserIdModified(long userIdModified) {
		_typeTicketUsers.setUserIdModified(userIdModified);
	}

	/**
	* Returns the create date of this type ticket users.
	*
	* @return the create date of this type ticket users
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _typeTicketUsers.getCreateDate();
	}

	/**
	* Sets the create date of this type ticket users.
	*
	* @param createDate the create date of this type ticket users
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_typeTicketUsers.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this type ticket users.
	*
	* @return the modified date of this type ticket users
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _typeTicketUsers.getModifiedDate();
	}

	/**
	* Sets the modified date of this type ticket users.
	*
	* @param modifiedDate the modified date of this type ticket users
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_typeTicketUsers.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the type ticket ID of this type ticket users.
	*
	* @return the type ticket ID of this type ticket users
	*/
	@Override
	public long getTypeTicketId() {
		return _typeTicketUsers.getTypeTicketId();
	}

	/**
	* Sets the type ticket ID of this type ticket users.
	*
	* @param typeTicketId the type ticket ID of this type ticket users
	*/
	@Override
	public void setTypeTicketId(long typeTicketId) {
		_typeTicketUsers.setTypeTicketId(typeTicketId);
	}

	/**
	* Returns the user ID of this type ticket users.
	*
	* @return the user ID of this type ticket users
	*/
	@Override
	public long getUserId() {
		return _typeTicketUsers.getUserId();
	}

	/**
	* Sets the user ID of this type ticket users.
	*
	* @param userId the user ID of this type ticket users
	*/
	@Override
	public void setUserId(long userId) {
		_typeTicketUsers.setUserId(userId);
	}

	/**
	* Returns the user uuid of this type ticket users.
	*
	* @return the user uuid of this type ticket users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTicketUsers.getUserUuid();
	}

	/**
	* Sets the user uuid of this type ticket users.
	*
	* @param userUuid the user uuid of this type ticket users
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_typeTicketUsers.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _typeTicketUsers.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_typeTicketUsers.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _typeTicketUsers.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_typeTicketUsers.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _typeTicketUsers.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _typeTicketUsers.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_typeTicketUsers.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _typeTicketUsers.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_typeTicketUsers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_typeTicketUsers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_typeTicketUsers.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TypeTicketUsersWrapper((TypeTicketUsers)_typeTicketUsers.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.eticket.model.TypeTicketUsers typeTicketUsers) {
		return _typeTicketUsers.compareTo(typeTicketUsers);
	}

	@Override
	public int hashCode() {
		return _typeTicketUsers.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.eticket.model.TypeTicketUsers> toCacheModel() {
		return _typeTicketUsers.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicketUsers toEscapedModel() {
		return new TypeTicketUsersWrapper(_typeTicketUsers.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.eticket.model.TypeTicketUsers toUnescapedModel() {
		return new TypeTicketUsersWrapper(_typeTicketUsers.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _typeTicketUsers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _typeTicketUsers.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_typeTicketUsers.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeTicketUsersWrapper)) {
			return false;
		}

		TypeTicketUsersWrapper typeTicketUsersWrapper = (TypeTicketUsersWrapper)obj;

		if (Validator.equals(_typeTicketUsers,
					typeTicketUsersWrapper._typeTicketUsers)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TypeTicketUsers getWrappedTypeTicketUsers() {
		return _typeTicketUsers;
	}

	@Override
	public TypeTicketUsers getWrappedModel() {
		return _typeTicketUsers;
	}

	@Override
	public void resetOriginalValues() {
		_typeTicketUsers.resetOriginalValues();
	}

	private TypeTicketUsers _typeTicketUsers;
}