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

package br.com.prodevelopment.funcionario.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Funcionario service. Represents a row in the &quot;Funcionario&quot; database table, with each column mapped to a property of this class.
 *
 * @author Marcelo Melo
 * @see FuncionarioModel
 * @see br.com.prodevelopment.funcionario.model.impl.FuncionarioImpl
 * @see br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl
 * @generated
 */
public interface Funcionario extends FuncionarioModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getFotoURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}