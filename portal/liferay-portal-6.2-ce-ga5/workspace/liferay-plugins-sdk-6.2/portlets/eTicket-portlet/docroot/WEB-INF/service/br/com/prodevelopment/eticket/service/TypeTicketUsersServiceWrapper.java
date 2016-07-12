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

package br.com.prodevelopment.eticket.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TypeTicketUsersService}.
 *
 * @author Marcelo Melo
 * @see TypeTicketUsersService
 * @generated
 */
public class TypeTicketUsersServiceWrapper implements TypeTicketUsersService,
	ServiceWrapper<TypeTicketUsersService> {
	public TypeTicketUsersServiceWrapper(
		TypeTicketUsersService typeTicketUsersService) {
		_typeTicketUsersService = typeTicketUsersService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _typeTicketUsersService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_typeTicketUsersService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _typeTicketUsersService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TypeTicketUsersService getWrappedTypeTicketUsersService() {
		return _typeTicketUsersService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTypeTicketUsersService(
		TypeTicketUsersService typeTicketUsersService) {
		_typeTicketUsersService = typeTicketUsersService;
	}

	@Override
	public TypeTicketUsersService getWrappedService() {
		return _typeTicketUsersService;
	}

	@Override
	public void setWrappedService(TypeTicketUsersService typeTicketUsersService) {
		_typeTicketUsersService = typeTicketUsersService;
	}

	private TypeTicketUsersService _typeTicketUsersService;
}