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

package br.com.prodevelopment.pesquisaopiniao.model.impl;

import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario;
import br.com.prodevelopment.pesquisaopiniao.service.Pesquisa_UsuarioLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Pesquisa_Usuario service. Represents a row in the &quot;PO_Pesquisa_Usuario&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Pesquisa_UsuarioImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Pesquisa_UsuarioImpl
 * @see br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario
 * @generated
 */
public abstract class Pesquisa_UsuarioBaseImpl extends Pesquisa_UsuarioModelImpl
	implements Pesquisa_Usuario {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pesquisa_ usuario model instance should use the {@link Pesquisa_Usuario} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			Pesquisa_UsuarioLocalServiceUtil.addPesquisa_Usuario(this);
		}
		else {
			Pesquisa_UsuarioLocalServiceUtil.updatePesquisa_Usuario(this);
		}
	}
}