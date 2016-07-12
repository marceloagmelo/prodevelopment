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

package br.com.prodevelopment.funcionario.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FuncionarioService}.
 *
 * @author Marcelo Melo
 * @see FuncionarioService
 * @generated
 */
public class FuncionarioServiceWrapper implements FuncionarioService,
	ServiceWrapper<FuncionarioService> {
	public FuncionarioServiceWrapper(FuncionarioService funcionarioService) {
		_funcionarioService = funcionarioService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _funcionarioService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_funcionarioService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _funcionarioService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FuncionarioService getWrappedFuncionarioService() {
		return _funcionarioService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFuncionarioService(
		FuncionarioService funcionarioService) {
		_funcionarioService = funcionarioService;
	}

	@Override
	public FuncionarioService getWrappedService() {
		return _funcionarioService;
	}

	@Override
	public void setWrappedService(FuncionarioService funcionarioService) {
		_funcionarioService = funcionarioService;
	}

	private FuncionarioService _funcionarioService;
}