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

package br.com.prodevelopment.funcionario.model.impl;

import br.com.prodevelopment.portlet.funcionario.util.FuncionarioUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The extended model implementation for the Funcionario service. Represents a row in the &quot;Funcionario&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.funcionario.model.Funcionario} interface.
 * </p>
 *
 * @author marcelo
 */
public class FuncionarioImpl extends FuncionarioBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a funcionario model instance should use the {@link br.com.prodevelopment.funcionario.model.Funcionario} interface instead.
	 */
	public FuncionarioImpl() {
	}
	
	public String getFotoURL(ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		return FuncionarioUtil.getFotoURL(
			themeDisplay.getPathImage(), getSexo(), getFotoId());
	}
	
}