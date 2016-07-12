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

package br.com.prodevelopment.etask.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TypeTaskUsers}.
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTaskUsers
 * @generated
 */
public class TypeTaskUsersWrapper implements TypeTaskUsers,
	ModelWrapper<TypeTaskUsers> {
	public TypeTaskUsersWrapper(TypeTaskUsers typeTaskUsers) {
		_typeTaskUsers = typeTaskUsers;
	}

	@Override
	public Class<?> getModelClass() {
		return TypeTaskUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TypeTaskUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeTaskUsersId", getTypeTaskUsersId());
		attributes.put("userIdCreate", getUserIdCreate());
		attributes.put("createDate", getCreateDate());
		attributes.put("typeTaskId", getTypeTaskId());
		attributes.put("userId", getUserId());
		attributes.put("typeUser", getTypeUser());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeTaskUsersId = (Long)attributes.get("typeTaskUsersId");

		if (typeTaskUsersId != null) {
			setTypeTaskUsersId(typeTaskUsersId);
		}

		Long userIdCreate = (Long)attributes.get("userIdCreate");

		if (userIdCreate != null) {
			setUserIdCreate(userIdCreate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long typeTaskId = (Long)attributes.get("typeTaskId");

		if (typeTaskId != null) {
			setTypeTaskId(typeTaskId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String typeUser = (String)attributes.get("typeUser");

		if (typeUser != null) {
			setTypeUser(typeUser);
		}
	}

	/**
	* Returns the primary key of this type task users.
	*
	* @return the primary key of this type task users
	*/
	@Override
	public long getPrimaryKey() {
		return _typeTaskUsers.getPrimaryKey();
	}

	/**
	* Sets the primary key of this type task users.
	*
	* @param primaryKey the primary key of this type task users
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_typeTaskUsers.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the type task users ID of this type task users.
	*
	* @return the type task users ID of this type task users
	*/
	@Override
	public long getTypeTaskUsersId() {
		return _typeTaskUsers.getTypeTaskUsersId();
	}

	/**
	* Sets the type task users ID of this type task users.
	*
	* @param typeTaskUsersId the type task users ID of this type task users
	*/
	@Override
	public void setTypeTaskUsersId(long typeTaskUsersId) {
		_typeTaskUsers.setTypeTaskUsersId(typeTaskUsersId);
	}

	/**
	* Returns the user ID create of this type task users.
	*
	* @return the user ID create of this type task users
	*/
	@Override
	public long getUserIdCreate() {
		return _typeTaskUsers.getUserIdCreate();
	}

	/**
	* Sets the user ID create of this type task users.
	*
	* @param userIdCreate the user ID create of this type task users
	*/
	@Override
	public void setUserIdCreate(long userIdCreate) {
		_typeTaskUsers.setUserIdCreate(userIdCreate);
	}

	/**
	* Returns the create date of this type task users.
	*
	* @return the create date of this type task users
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _typeTaskUsers.getCreateDate();
	}

	/**
	* Sets the create date of this type task users.
	*
	* @param createDate the create date of this type task users
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_typeTaskUsers.setCreateDate(createDate);
	}

	/**
	* Returns the type task ID of this type task users.
	*
	* @return the type task ID of this type task users
	*/
	@Override
	public long getTypeTaskId() {
		return _typeTaskUsers.getTypeTaskId();
	}

	/**
	* Sets the type task ID of this type task users.
	*
	* @param typeTaskId the type task ID of this type task users
	*/
	@Override
	public void setTypeTaskId(long typeTaskId) {
		_typeTaskUsers.setTypeTaskId(typeTaskId);
	}

	/**
	* Returns the user ID of this type task users.
	*
	* @return the user ID of this type task users
	*/
	@Override
	public long getUserId() {
		return _typeTaskUsers.getUserId();
	}

	/**
	* Sets the user ID of this type task users.
	*
	* @param userId the user ID of this type task users
	*/
	@Override
	public void setUserId(long userId) {
		_typeTaskUsers.setUserId(userId);
	}

	/**
	* Returns the user uuid of this type task users.
	*
	* @return the user uuid of this type task users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeTaskUsers.getUserUuid();
	}

	/**
	* Sets the user uuid of this type task users.
	*
	* @param userUuid the user uuid of this type task users
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_typeTaskUsers.setUserUuid(userUuid);
	}

	/**
	* Returns the type user of this type task users.
	*
	* @return the type user of this type task users
	*/
	@Override
	public java.lang.String getTypeUser() {
		return _typeTaskUsers.getTypeUser();
	}

	/**
	* Sets the type user of this type task users.
	*
	* @param typeUser the type user of this type task users
	*/
	@Override
	public void setTypeUser(java.lang.String typeUser) {
		_typeTaskUsers.setTypeUser(typeUser);
	}

	@Override
	public boolean isNew() {
		return _typeTaskUsers.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_typeTaskUsers.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _typeTaskUsers.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_typeTaskUsers.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _typeTaskUsers.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _typeTaskUsers.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_typeTaskUsers.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _typeTaskUsers.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_typeTaskUsers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_typeTaskUsers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_typeTaskUsers.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TypeTaskUsersWrapper((TypeTaskUsers)_typeTaskUsers.clone());
	}

	@Override
	public int compareTo(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers) {
		return _typeTaskUsers.compareTo(typeTaskUsers);
	}

	@Override
	public int hashCode() {
		return _typeTaskUsers.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.etask.model.TypeTaskUsers> toCacheModel() {
		return _typeTaskUsers.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers toEscapedModel() {
		return new TypeTaskUsersWrapper(_typeTaskUsers.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.etask.model.TypeTaskUsers toUnescapedModel() {
		return new TypeTaskUsersWrapper(_typeTaskUsers.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _typeTaskUsers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _typeTaskUsers.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_typeTaskUsers.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeTaskUsersWrapper)) {
			return false;
		}

		TypeTaskUsersWrapper typeTaskUsersWrapper = (TypeTaskUsersWrapper)obj;

		if (Validator.equals(_typeTaskUsers, typeTaskUsersWrapper._typeTaskUsers)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TypeTaskUsers getWrappedTypeTaskUsers() {
		return _typeTaskUsers;
	}

	@Override
	public TypeTaskUsers getWrappedModel() {
		return _typeTaskUsers;
	}

	@Override
	public void resetOriginalValues() {
		_typeTaskUsers.resetOriginalValues();
	}

	private TypeTaskUsers _typeTaskUsers;
}