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
 * Provides a wrapper for {@link TelefoneService}.
 *
 * @author Marcelo Melo
 * @see TelefoneService
 * @generated
 */
public class TelefoneServiceWrapper implements TelefoneService,
	ServiceWrapper<TelefoneService> {
	public TelefoneServiceWrapper(TelefoneService telefoneService) {
		_telefoneService = telefoneService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _telefoneService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_telefoneService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _telefoneService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TelefoneService getWrappedTelefoneService() {
		return _telefoneService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTelefoneService(TelefoneService telefoneService) {
		_telefoneService = telefoneService;
	}

	@Override
	public TelefoneService getWrappedService() {
		return _telefoneService;
	}

	@Override
	public void setWrappedService(TelefoneService telefoneService) {
		_telefoneService = telefoneService;
	}

	private TelefoneService _telefoneService;
}