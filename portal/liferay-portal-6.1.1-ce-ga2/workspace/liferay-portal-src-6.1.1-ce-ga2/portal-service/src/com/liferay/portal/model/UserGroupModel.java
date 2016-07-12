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

package com.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UserGroup service. Represents a row in the &quot;UserGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.UserGroupModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.UserGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroup
 * @see com.liferay.portal.model.impl.UserGroupImpl
 * @see com.liferay.portal.model.impl.UserGroupModelImpl
 * @generated
 */
public interface UserGroupModel extends BaseModel<UserGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user group model instance should use the {@link UserGroup} interface instead.
	 */

	/**
	 * Returns the primary key of this user group.
	 *
	 * @return the primary key of this user group
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user group.
	 *
	 * @param primaryKey the primary key of this user group
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user group ID of this user group.
	 *
	 * @return the user group ID of this user group
	 */
	public long getUserGroupId();

	/**
	 * Sets the user group ID of this user group.
	 *
	 * @param userGroupId the user group ID of this user group
	 */
	public void setUserGroupId(long userGroupId);

	/**
	 * Returns the company ID of this user group.
	 *
	 * @return the company ID of this user group
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this user group.
	 *
	 * @param companyId the company ID of this user group
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the parent user group ID of this user group.
	 *
	 * @return the parent user group ID of this user group
	 */
	public long getParentUserGroupId();

	/**
	 * Sets the parent user group ID of this user group.
	 *
	 * @param parentUserGroupId the parent user group ID of this user group
	 */
	public void setParentUserGroupId(long parentUserGroupId);

	/**
	 * Returns the name of this user group.
	 *
	 * @return the name of this user group
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this user group.
	 *
	 * @param name the name of this user group
	 */
	public void setName(String name);

	/**
	 * Returns the description of this user group.
	 *
	 * @return the description of this user group
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this user group.
	 *
	 * @param description the description of this user group
	 */
	public void setDescription(String description);

	/**
	 * Returns the added by l d a p import of this user group.
	 *
	 * @return the added by l d a p import of this user group
	 */
	public boolean getAddedByLDAPImport();

	/**
	 * Returns <code>true</code> if this user group is added by l d a p import.
	 *
	 * @return <code>true</code> if this user group is added by l d a p import; <code>false</code> otherwise
	 */
	public boolean isAddedByLDAPImport();

	/**
	 * Sets whether this user group is added by l d a p import.
	 *
	 * @param addedByLDAPImport the added by l d a p import of this user group
	 */
	public void setAddedByLDAPImport(boolean addedByLDAPImport);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(UserGroup userGroup);

	public int hashCode();

	public CacheModel<UserGroup> toCacheModel();

	public UserGroup toEscapedModel();

	public String toString();

	public String toXmlString();
}