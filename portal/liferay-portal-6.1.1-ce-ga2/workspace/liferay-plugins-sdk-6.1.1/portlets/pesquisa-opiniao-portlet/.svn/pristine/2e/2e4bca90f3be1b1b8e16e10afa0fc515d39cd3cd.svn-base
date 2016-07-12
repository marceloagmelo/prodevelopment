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

package br.com.prodevelopment.pesquisaopiniao.service.impl;

import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario;
import br.com.prodevelopment.pesquisaopiniao.service.base.Pesquisa_UsuarioLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the pesquisa_ usuario local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.pesquisaopiniao.service.Pesquisa_UsuarioLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.pesquisaopiniao.service.base.Pesquisa_UsuarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.pesquisaopiniao.service.Pesquisa_UsuarioLocalServiceUtil
 */
public class Pesquisa_UsuarioLocalServiceImpl
	extends Pesquisa_UsuarioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.pesquisaopiniao.service.Pesquisa_UsuarioLocalServiceUtil} to access the pesquisa_ usuario local service.
	 */
	@Override
	public Pesquisa_Usuario addPesquisa_Usuario(Pesquisa_Usuario pesquisaUsuario) throws SystemException {
		// Criar objeto incrementando um novo ID
		Pesquisa_Usuario novaPesquisaUsuario =	pesquisa_UsuarioPersistence.create(counterLocalService.increment(Pesquisa_Usuario.class.getName()));
		
		// Atribui novos valores
		novaPesquisaUsuario.setDataInclusao(pesquisaUsuario.getDataInclusao());
		novaPesquisaUsuario.setEmail(pesquisaUsuario.getEmail());
		novaPesquisaUsuario.setNome(pesquisaUsuario.getNome());
		novaPesquisaUsuario.setPesquisaId(pesquisaUsuario.getPesquisaId());
		novaPesquisaUsuario.setUserId(pesquisaUsuario.getUserId());
		
		try {
			Pesquisa pesquisa = pesquisaPersistence.fetchByPrimaryKey(pesquisaUsuario.getPesquisaId());
	        resourceLocalService.addResources(
	        		pesquisa.getCompanyId(), pesquisa.getGroupId(),
	        		Pesquisa_Usuario.class.getName(), false);
			

	        // Social
	        User user = UserLocalServiceUtil.getUser(pesquisaUsuario.getUserId());

	        if (user != null) {
	            socialActivityLocalService.addActivity(
	                user.getUserId(), pesquisa.getGroupId(),
	                Pesquisa_Usuario.class.getName(), pesquisaUsuario.getPrimaryKey(),
	                1, StringPool.BLANK, 0);
	        }
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}

		// Executa a alteração de registro com os novos valores
		return pesquisa_UsuarioPersistence.update(novaPesquisaUsuario, false);
	}

}