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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Contact service. Represents a row in the &quot;Contact_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ContactModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ContactImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @see com.liferay.portal.model.impl.ContactImpl
 * @see com.liferay.portal.model.impl.ContactModelImpl
 * @generated
 */
public interface ContactModel extends AuditedModel, BaseModel<Contact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a contact model instance should use the {@link Contact} interface instead.
	 */

	/**
	 * Returns the primary key of this contact.
	 *
	 * @return the primary key of this contact
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this contact.
	 *
	 * @param primaryKey the primary key of this contact
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the contact ID of this contact.
	 *
	 * @return the contact ID of this contact
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this contact.
	 *
	 * @param contactId the contact ID of this contact
	 */
	public void setContactId(long contactId);

	/**
	 * Returns the company ID of this contact.
	 *
	 * @return the company ID of this contact
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this contact.
	 *
	 * @param companyId the company ID of this contact
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this contact.
	 *
	 * @return the user ID of this contact
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this contact.
	 *
	 * @param userId the user ID of this contact
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this contact.
	 *
	 * @return the user uuid of this contact
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this contact.
	 *
	 * @param userUuid the user uuid of this contact
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this contact.
	 *
	 * @return the user name of this contact
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this contact.
	 *
	 * @param userName the user name of this contact
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this contact.
	 *
	 * @return the create date of this contact
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this contact.
	 *
	 * @param createDate the create date of this contact
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this contact.
	 *
	 * @return the modified date of this contact
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this contact.
	 *
	 * @param modifiedDate the modified date of this contact
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the account ID of this contact.
	 *
	 * @return the account ID of this contact
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this contact.
	 *
	 * @param accountId the account ID of this contact
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the parent contact ID of this contact.
	 *
	 * @return the parent contact ID of this contact
	 */
	public long getParentContactId();

	/**
	 * Sets the parent contact ID of this contact.
	 *
	 * @param parentContactId the parent contact ID of this contact
	 */
	public void setParentContactId(long parentContactId);

	/**
	 * Returns the first name of this contact.
	 *
	 * @return the first name of this contact
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this contact.
	 *
	 * @param firstName the first name of this contact
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the middle name of this contact.
	 *
	 * @return the middle name of this contact
	 */
	@AutoEscape
	public String getMiddleName();

	/**
	 * Sets the middle name of this contact.
	 *
	 * @param middleName the middle name of this contact
	 */
	public void setMiddleName(String middleName);

	/**
	 * Returns the last name of this contact.
	 *
	 * @return the last name of this contact
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this contact.
	 *
	 * @param lastName the last name of this contact
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the prefix ID of this contact.
	 *
	 * @return the prefix ID of this contact
	 */
	public int getPrefixId();

	/**
	 * Sets the prefix ID of this contact.
	 *
	 * @param prefixId the prefix ID of this contact
	 */
	public void setPrefixId(int prefixId);

	/**
	 * Returns the suffix ID of this contact.
	 *
	 * @return the suffix ID of this contact
	 */
	public int getSuffixId();

	/**
	 * Sets the suffix ID of this contact.
	 *
	 * @param suffixId the suffix ID of this contact
	 */
	public void setSuffixId(int suffixId);

	/**
	 * Returns the male of this contact.
	 *
	 * @return the male of this contact
	 */
	public boolean getMale();

	/**
	 * Returns <code>true</code> if this contact is male.
	 *
	 * @return <code>true</code> if this contact is male; <code>false</code> otherwise
	 */
	public boolean isMale();

	/**
	 * Sets whether this contact is male.
	 *
	 * @param male the male of this contact
	 */
	public void setMale(boolean male);

	/**
	 * Returns the birthday of this contact.
	 *
	 * @return the birthday of this contact
	 */
	public Date getBirthday();

	/**
	 * Sets the birthday of this contact.
	 *
	 * @param birthday the birthday of this contact
	 */
	public void setBirthday(Date birthday);

	/**
	 * Returns the sms sn of this contact.
	 *
	 * @return the sms sn of this contact
	 */
	@AutoEscape
	public String getSmsSn();

	/**
	 * Sets the sms sn of this contact.
	 *
	 * @param smsSn the sms sn of this contact
	 */
	public void setSmsSn(String smsSn);

	/**
	 * Returns the aim sn of this contact.
	 *
	 * @return the aim sn of this contact
	 */
	@AutoEscape
	public String getAimSn();

	/**
	 * Sets the aim sn of this contact.
	 *
	 * @param aimSn the aim sn of this contact
	 */
	public void setAimSn(String aimSn);

	/**
	 * Returns the facebook sn of this contact.
	 *
	 * @return the facebook sn of this contact
	 */
	@AutoEscape
	public String getFacebookSn();

	/**
	 * Sets the facebook sn of this contact.
	 *
	 * @param facebookSn the facebook sn of this contact
	 */
	public void setFacebookSn(String facebookSn);

	/**
	 * Returns the icq sn of this contact.
	 *
	 * @return the icq sn of this contact
	 */
	@AutoEscape
	public String getIcqSn();

	/**
	 * Sets the icq sn of this contact.
	 *
	 * @param icqSn the icq sn of this contact
	 */
	public void setIcqSn(String icqSn);

	/**
	 * Returns the jabber sn of this contact.
	 *
	 * @return the jabber sn of this contact
	 */
	@AutoEscape
	public String getJabberSn();

	/**
	 * Sets the jabber sn of this contact.
	 *
	 * @param jabberSn the jabber sn of this contact
	 */
	public void setJabberSn(String jabberSn);

	/**
	 * Returns the msn sn of this contact.
	 *
	 * @return the msn sn of this contact
	 */
	@AutoEscape
	public String getMsnSn();

	/**
	 * Sets the msn sn of this contact.
	 *
	 * @param msnSn the msn sn of this contact
	 */
	public void setMsnSn(String msnSn);

	/**
	 * Returns the my space sn of this contact.
	 *
	 * @return the my space sn of this contact
	 */
	@AutoEscape
	public String getMySpaceSn();

	/**
	 * Sets the my space sn of this contact.
	 *
	 * @param mySpaceSn the my space sn of this contact
	 */
	public void setMySpaceSn(String mySpaceSn);

	/**
	 * Returns the skype sn of this contact.
	 *
	 * @return the skype sn of this contact
	 */
	@AutoEscape
	public String getSkypeSn();

	/**
	 * Sets the skype sn of this contact.
	 *
	 * @param skypeSn the skype sn of this contact
	 */
	public void setSkypeSn(String skypeSn);

	/**
	 * Returns the twitter sn of this contact.
	 *
	 * @return the twitter sn of this contact
	 */
	@AutoEscape
	public String getTwitterSn();

	/**
	 * Sets the twitter sn of this contact.
	 *
	 * @param twitterSn the twitter sn of this contact
	 */
	public void setTwitterSn(String twitterSn);

	/**
	 * Returns the ym sn of this contact.
	 *
	 * @return the ym sn of this contact
	 */
	@AutoEscape
	public String getYmSn();

	/**
	 * Sets the ym sn of this contact.
	 *
	 * @param ymSn the ym sn of this contact
	 */
	public void setYmSn(String ymSn);

	/**
	 * Returns the employee status ID of this contact.
	 *
	 * @return the employee status ID of this contact
	 */
	@AutoEscape
	public String getEmployeeStatusId();

	/**
	 * Sets the employee status ID of this contact.
	 *
	 * @param employeeStatusId the employee status ID of this contact
	 */
	public void setEmployeeStatusId(String employeeStatusId);

	/**
	 * Returns the employee number of this contact.
	 *
	 * @return the employee number of this contact
	 */
	@AutoEscape
	public String getEmployeeNumber();

	/**
	 * Sets the employee number of this contact.
	 *
	 * @param employeeNumber the employee number of this contact
	 */
	public void setEmployeeNumber(String employeeNumber);

	/**
	 * Returns the job title of this contact.
	 *
	 * @return the job title of this contact
	 */
	@AutoEscape
	public String getJobTitle();

	/**
	 * Sets the job title of this contact.
	 *
	 * @param jobTitle the job title of this contact
	 */
	public void setJobTitle(String jobTitle);

	/**
	 * Returns the job class of this contact.
	 *
	 * @return the job class of this contact
	 */
	@AutoEscape
	public String getJobClass();

	/**
	 * Sets the job class of this contact.
	 *
	 * @param jobClass the job class of this contact
	 */
	public void setJobClass(String jobClass);

	/**
	 * Returns the hours of operation of this contact.
	 *
	 * @return the hours of operation of this contact
	 */
	@AutoEscape
	public String getHoursOfOperation();

	/**
	 * Sets the hours of operation of this contact.
	 *
	 * @param hoursOfOperation the hours of operation of this contact
	 */
	public void setHoursOfOperation(String hoursOfOperation);

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

	public int compareTo(Contact contact);

	public int hashCode();

	public CacheModel<Contact> toCacheModel();

	public Contact toEscapedModel();

	public String toString();

	public String toXmlString();
}