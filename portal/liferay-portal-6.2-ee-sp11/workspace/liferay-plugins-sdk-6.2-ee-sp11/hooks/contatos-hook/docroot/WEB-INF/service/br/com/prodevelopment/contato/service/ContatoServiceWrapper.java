/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.prodevelopment.contato.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContatoService}.
 *
 * @author Marcelo Melo
 * @see ContatoService
 * @generated
 */
public class ContatoServiceWrapper implements ContatoService,
	ServiceWrapper<ContatoService> {
	public ContatoServiceWrapper(ContatoService contatoService) {
		_contatoService = contatoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contatoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contatoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contatoService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContatoService getWrappedContatoService() {
		return _contatoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContatoService(ContatoService contatoService) {
		_contatoService = contatoService;
	}

	@Override
	public ContatoService getWrappedService() {
		return _contatoService;
	}

	@Override
	public void setWrappedService(ContatoService contatoService) {
		_contatoService = contatoService;
	}

	private ContatoService _contatoService;
}