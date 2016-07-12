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

package br.com.prodevelopment.eticket.service.base;

import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.service.TypeTicketService;
import br.com.prodevelopment.eticket.service.persistence.TypeTicketPersistence;
import br.com.prodevelopment.eticket.service.persistence.TypeTicketUsersPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.social.service.persistence.SocialActivityCounterPersistence;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;
import com.liferay.portlet.trash.service.persistence.TrashEntryPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the type ticket remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link br.com.prodevelopment.eticket.service.impl.TypeTicketServiceImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.eticket.service.impl.TypeTicketServiceImpl
 * @see br.com.prodevelopment.eticket.service.TypeTicketServiceUtil
 * @generated
 */
public abstract class TypeTicketServiceBaseImpl extends BaseServiceImpl
	implements TypeTicketService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link br.com.prodevelopment.eticket.service.TypeTicketServiceUtil} to access the type ticket remote service.
	 */

	/**
	 * Returns the type ticket local service.
	 *
	 * @return the type ticket local service
	 */
	public br.com.prodevelopment.eticket.service.TypeTicketLocalService getTypeTicketLocalService() {
		return typeTicketLocalService;
	}

	/**
	 * Sets the type ticket local service.
	 *
	 * @param typeTicketLocalService the type ticket local service
	 */
	public void setTypeTicketLocalService(
		br.com.prodevelopment.eticket.service.TypeTicketLocalService typeTicketLocalService) {
		this.typeTicketLocalService = typeTicketLocalService;
	}

	/**
	 * Returns the type ticket remote service.
	 *
	 * @return the type ticket remote service
	 */
	public br.com.prodevelopment.eticket.service.TypeTicketService getTypeTicketService() {
		return typeTicketService;
	}

	/**
	 * Sets the type ticket remote service.
	 *
	 * @param typeTicketService the type ticket remote service
	 */
	public void setTypeTicketService(
		br.com.prodevelopment.eticket.service.TypeTicketService typeTicketService) {
		this.typeTicketService = typeTicketService;
	}

	/**
	 * Returns the type ticket persistence.
	 *
	 * @return the type ticket persistence
	 */
	public TypeTicketPersistence getTypeTicketPersistence() {
		return typeTicketPersistence;
	}

	/**
	 * Sets the type ticket persistence.
	 *
	 * @param typeTicketPersistence the type ticket persistence
	 */
	public void setTypeTicketPersistence(
		TypeTicketPersistence typeTicketPersistence) {
		this.typeTicketPersistence = typeTicketPersistence;
	}

	/**
	 * Returns the type ticket users local service.
	 *
	 * @return the type ticket users local service
	 */
	public br.com.prodevelopment.eticket.service.TypeTicketUsersLocalService getTypeTicketUsersLocalService() {
		return typeTicketUsersLocalService;
	}

	/**
	 * Sets the type ticket users local service.
	 *
	 * @param typeTicketUsersLocalService the type ticket users local service
	 */
	public void setTypeTicketUsersLocalService(
		br.com.prodevelopment.eticket.service.TypeTicketUsersLocalService typeTicketUsersLocalService) {
		this.typeTicketUsersLocalService = typeTicketUsersLocalService;
	}

	/**
	 * Returns the type ticket users remote service.
	 *
	 * @return the type ticket users remote service
	 */
	public br.com.prodevelopment.eticket.service.TypeTicketUsersService getTypeTicketUsersService() {
		return typeTicketUsersService;
	}

	/**
	 * Sets the type ticket users remote service.
	 *
	 * @param typeTicketUsersService the type ticket users remote service
	 */
	public void setTypeTicketUsersService(
		br.com.prodevelopment.eticket.service.TypeTicketUsersService typeTicketUsersService) {
		this.typeTicketUsersService = typeTicketUsersService;
	}

	/**
	 * Returns the type ticket users persistence.
	 *
	 * @return the type ticket users persistence
	 */
	public TypeTicketUsersPersistence getTypeTicketUsersPersistence() {
		return typeTicketUsersPersistence;
	}

	/**
	 * Sets the type ticket users persistence.
	 *
	 * @param typeTicketUsersPersistence the type ticket users persistence
	 */
	public void setTypeTicketUsersPersistence(
		TypeTicketUsersPersistence typeTicketUsersPersistence) {
		this.typeTicketUsersPersistence = typeTicketUsersPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the social activity local service.
	 *
	 * @return the social activity local service
	 */
	public com.liferay.portlet.social.service.SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	/**
	 * Sets the social activity local service.
	 *
	 * @param socialActivityLocalService the social activity local service
	 */
	public void setSocialActivityLocalService(
		com.liferay.portlet.social.service.SocialActivityLocalService socialActivityLocalService) {
		this.socialActivityLocalService = socialActivityLocalService;
	}

	/**
	 * Returns the social activity remote service.
	 *
	 * @return the social activity remote service
	 */
	public com.liferay.portlet.social.service.SocialActivityService getSocialActivityService() {
		return socialActivityService;
	}

	/**
	 * Sets the social activity remote service.
	 *
	 * @param socialActivityService the social activity remote service
	 */
	public void setSocialActivityService(
		com.liferay.portlet.social.service.SocialActivityService socialActivityService) {
		this.socialActivityService = socialActivityService;
	}

	/**
	 * Returns the social activity persistence.
	 *
	 * @return the social activity persistence
	 */
	public SocialActivityPersistence getSocialActivityPersistence() {
		return socialActivityPersistence;
	}

	/**
	 * Sets the social activity persistence.
	 *
	 * @param socialActivityPersistence the social activity persistence
	 */
	public void setSocialActivityPersistence(
		SocialActivityPersistence socialActivityPersistence) {
		this.socialActivityPersistence = socialActivityPersistence;
	}

	/**
	 * Returns the social activity counter local service.
	 *
	 * @return the social activity counter local service
	 */
	public com.liferay.portlet.social.service.SocialActivityCounterLocalService getSocialActivityCounterLocalService() {
		return socialActivityCounterLocalService;
	}

	/**
	 * Sets the social activity counter local service.
	 *
	 * @param socialActivityCounterLocalService the social activity counter local service
	 */
	public void setSocialActivityCounterLocalService(
		com.liferay.portlet.social.service.SocialActivityCounterLocalService socialActivityCounterLocalService) {
		this.socialActivityCounterLocalService = socialActivityCounterLocalService;
	}

	/**
	 * Returns the social activity counter persistence.
	 *
	 * @return the social activity counter persistence
	 */
	public SocialActivityCounterPersistence getSocialActivityCounterPersistence() {
		return socialActivityCounterPersistence;
	}

	/**
	 * Sets the social activity counter persistence.
	 *
	 * @param socialActivityCounterPersistence the social activity counter persistence
	 */
	public void setSocialActivityCounterPersistence(
		SocialActivityCounterPersistence socialActivityCounterPersistence) {
		this.socialActivityCounterPersistence = socialActivityCounterPersistence;
	}

	/**
	 * Returns the trash entry local service.
	 *
	 * @return the trash entry local service
	 */
	public com.liferay.portlet.trash.service.TrashEntryLocalService getTrashEntryLocalService() {
		return trashEntryLocalService;
	}

	/**
	 * Sets the trash entry local service.
	 *
	 * @param trashEntryLocalService the trash entry local service
	 */
	public void setTrashEntryLocalService(
		com.liferay.portlet.trash.service.TrashEntryLocalService trashEntryLocalService) {
		this.trashEntryLocalService = trashEntryLocalService;
	}

	/**
	 * Returns the trash entry remote service.
	 *
	 * @return the trash entry remote service
	 */
	public com.liferay.portlet.trash.service.TrashEntryService getTrashEntryService() {
		return trashEntryService;
	}

	/**
	 * Sets the trash entry remote service.
	 *
	 * @param trashEntryService the trash entry remote service
	 */
	public void setTrashEntryService(
		com.liferay.portlet.trash.service.TrashEntryService trashEntryService) {
		this.trashEntryService = trashEntryService;
	}

	/**
	 * Returns the trash entry persistence.
	 *
	 * @return the trash entry persistence
	 */
	public TrashEntryPersistence getTrashEntryPersistence() {
		return trashEntryPersistence;
	}

	/**
	 * Sets the trash entry persistence.
	 *
	 * @param trashEntryPersistence the trash entry persistence
	 */
	public void setTrashEntryPersistence(
		TrashEntryPersistence trashEntryPersistence) {
		this.trashEntryPersistence = trashEntryPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TypeTicket.class;
	}

	protected String getModelClassName() {
		return TypeTicket.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = typeTicketPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = br.com.prodevelopment.eticket.service.TypeTicketLocalService.class)
	protected br.com.prodevelopment.eticket.service.TypeTicketLocalService typeTicketLocalService;
	@BeanReference(type = br.com.prodevelopment.eticket.service.TypeTicketService.class)
	protected br.com.prodevelopment.eticket.service.TypeTicketService typeTicketService;
	@BeanReference(type = TypeTicketPersistence.class)
	protected TypeTicketPersistence typeTicketPersistence;
	@BeanReference(type = br.com.prodevelopment.eticket.service.TypeTicketUsersLocalService.class)
	protected br.com.prodevelopment.eticket.service.TypeTicketUsersLocalService typeTicketUsersLocalService;
	@BeanReference(type = br.com.prodevelopment.eticket.service.TypeTicketUsersService.class)
	protected br.com.prodevelopment.eticket.service.TypeTicketUsersService typeTicketUsersService;
	@BeanReference(type = TypeTicketUsersPersistence.class)
	protected TypeTicketUsersPersistence typeTicketUsersPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.portlet.social.service.SocialActivityLocalService.class)
	protected com.liferay.portlet.social.service.SocialActivityLocalService socialActivityLocalService;
	@BeanReference(type = com.liferay.portlet.social.service.SocialActivityService.class)
	protected com.liferay.portlet.social.service.SocialActivityService socialActivityService;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	@BeanReference(type = com.liferay.portlet.social.service.SocialActivityCounterLocalService.class)
	protected com.liferay.portlet.social.service.SocialActivityCounterLocalService socialActivityCounterLocalService;
	@BeanReference(type = SocialActivityCounterPersistence.class)
	protected SocialActivityCounterPersistence socialActivityCounterPersistence;
	@BeanReference(type = com.liferay.portlet.trash.service.TrashEntryLocalService.class)
	protected com.liferay.portlet.trash.service.TrashEntryLocalService trashEntryLocalService;
	@BeanReference(type = com.liferay.portlet.trash.service.TrashEntryService.class)
	protected com.liferay.portlet.trash.service.TrashEntryService trashEntryService;
	@BeanReference(type = TrashEntryPersistence.class)
	protected TrashEntryPersistence trashEntryPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TypeTicketServiceClpInvoker _clpInvoker = new TypeTicketServiceClpInvoker();
}