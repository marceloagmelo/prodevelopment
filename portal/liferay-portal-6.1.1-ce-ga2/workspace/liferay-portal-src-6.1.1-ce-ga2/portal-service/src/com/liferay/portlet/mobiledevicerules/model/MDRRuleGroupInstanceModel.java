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

package com.liferay.portlet.mobiledevicerules.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MDRRuleGroupInstance service. Represents a row in the &quot;MDRRuleGroupInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.mobiledevicerules.model.impl.MDRRuleGroupInstanceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.mobiledevicerules.model.impl.MDRRuleGroupInstanceImpl}.
 * </p>
 *
 * @author Edward C. Han
 * @see MDRRuleGroupInstance
 * @see com.liferay.portlet.mobiledevicerules.model.impl.MDRRuleGroupInstanceImpl
 * @see com.liferay.portlet.mobiledevicerules.model.impl.MDRRuleGroupInstanceModelImpl
 * @generated
 */
public interface MDRRuleGroupInstanceModel extends AttachedModel,
	BaseModel<MDRRuleGroupInstance>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a m d r rule group instance model instance should use the {@link MDRRuleGroupInstance} interface instead.
	 */

	/**
	 * Returns the primary key of this m d r rule group instance.
	 *
	 * @return the primary key of this m d r rule group instance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this m d r rule group instance.
	 *
	 * @param primaryKey the primary key of this m d r rule group instance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this m d r rule group instance.
	 *
	 * @return the uuid of this m d r rule group instance
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this m d r rule group instance.
	 *
	 * @param uuid the uuid of this m d r rule group instance
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the rule group instance ID of this m d r rule group instance.
	 *
	 * @return the rule group instance ID of this m d r rule group instance
	 */
	public long getRuleGroupInstanceId();

	/**
	 * Sets the rule group instance ID of this m d r rule group instance.
	 *
	 * @param ruleGroupInstanceId the rule group instance ID of this m d r rule group instance
	 */
	public void setRuleGroupInstanceId(long ruleGroupInstanceId);

	/**
	 * Returns the group ID of this m d r rule group instance.
	 *
	 * @return the group ID of this m d r rule group instance
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this m d r rule group instance.
	 *
	 * @param groupId the group ID of this m d r rule group instance
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this m d r rule group instance.
	 *
	 * @return the company ID of this m d r rule group instance
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this m d r rule group instance.
	 *
	 * @param companyId the company ID of this m d r rule group instance
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this m d r rule group instance.
	 *
	 * @return the user ID of this m d r rule group instance
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this m d r rule group instance.
	 *
	 * @param userId the user ID of this m d r rule group instance
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this m d r rule group instance.
	 *
	 * @return the user uuid of this m d r rule group instance
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this m d r rule group instance.
	 *
	 * @param userUuid the user uuid of this m d r rule group instance
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this m d r rule group instance.
	 *
	 * @return the user name of this m d r rule group instance
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this m d r rule group instance.
	 *
	 * @param userName the user name of this m d r rule group instance
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this m d r rule group instance.
	 *
	 * @return the create date of this m d r rule group instance
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this m d r rule group instance.
	 *
	 * @param createDate the create date of this m d r rule group instance
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this m d r rule group instance.
	 *
	 * @return the modified date of this m d r rule group instance
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this m d r rule group instance.
	 *
	 * @param modifiedDate the modified date of this m d r rule group instance
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this m d r rule group instance.
	 *
	 * @return the fully qualified class name of this m d r rule group instance
	 */
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this m d r rule group instance.
	 *
	 * @return the class name ID of this m d r rule group instance
	 */
	public long getClassNameId();

	/**
	 * Sets the class name ID of this m d r rule group instance.
	 *
	 * @param classNameId the class name ID of this m d r rule group instance
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this m d r rule group instance.
	 *
	 * @return the class p k of this m d r rule group instance
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this m d r rule group instance.
	 *
	 * @param classPK the class p k of this m d r rule group instance
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the rule group ID of this m d r rule group instance.
	 *
	 * @return the rule group ID of this m d r rule group instance
	 */
	public long getRuleGroupId();

	/**
	 * Sets the rule group ID of this m d r rule group instance.
	 *
	 * @param ruleGroupId the rule group ID of this m d r rule group instance
	 */
	public void setRuleGroupId(long ruleGroupId);

	/**
	 * Returns the priority of this m d r rule group instance.
	 *
	 * @return the priority of this m d r rule group instance
	 */
	public int getPriority();

	/**
	 * Sets the priority of this m d r rule group instance.
	 *
	 * @param priority the priority of this m d r rule group instance
	 */
	public void setPriority(int priority);

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

	public int compareTo(MDRRuleGroupInstance mdrRuleGroupInstance);

	public int hashCode();

	public CacheModel<MDRRuleGroupInstance> toCacheModel();

	public MDRRuleGroupInstance toEscapedModel();

	public String toString();

	public String toXmlString();
}