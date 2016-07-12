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
 * Provides a wrapper for {@link EnderecoService}.
 *
 * @author Marcelo Melo
 * @see EnderecoService
 * @generated
 */
public class EnderecoServiceWrapper implements EnderecoService,
	ServiceWrapper<EnderecoService> {
	public EnderecoServiceWrapper(EnderecoService enderecoService) {
		_enderecoService = enderecoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _enderecoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_enderecoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _enderecoService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EnderecoService getWrappedEnderecoService() {
		return _enderecoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEnderecoService(EnderecoService enderecoService) {
		_enderecoService = enderecoService;
	}

	@Override
	public EnderecoService getWrappedService() {
		return _enderecoService;
	}

	@Override
	public void setWrappedService(EnderecoService enderecoService) {
		_enderecoService = enderecoService;
	}

	private EnderecoService _enderecoService;
}