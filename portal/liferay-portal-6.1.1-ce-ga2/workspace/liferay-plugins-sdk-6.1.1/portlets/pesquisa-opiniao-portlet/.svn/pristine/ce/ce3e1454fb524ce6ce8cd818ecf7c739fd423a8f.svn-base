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

import br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario;
import br.com.prodevelopment.pesquisaopiniao.service.base.Resposta_UsuarioLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the resposta_ usuario local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.pesquisaopiniao.service.Resposta_UsuarioLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.pesquisaopiniao.service.base.Resposta_UsuarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.pesquisaopiniao.service.Resposta_UsuarioLocalServiceUtil
 */
public class Resposta_UsuarioLocalServiceImpl
	extends Resposta_UsuarioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.pesquisaopiniao.service.Resposta_UsuarioLocalServiceUtil} to access the resposta_ usuario local service.
	 */
	@Override
	public Resposta_Usuario addResposta_Usuario(Resposta_Usuario respostaUsuario) throws SystemException {
		// Criar objeto incrementando um novo ID
		Resposta_Usuario novaRespostaUsuario =	resposta_UsuarioPersistence.create(counterLocalService.increment(Resposta_Usuario.class.getName()));
		
		// Atribui novos valores
		novaRespostaUsuario.setDataInclusao(respostaUsuario.getDataInclusao());
		novaRespostaUsuario.setPesquisaUsuarioId(respostaUsuario.getPesquisaUsuarioId());
		novaRespostaUsuario.setRespostaId(respostaUsuario.getRespostaId());
		
		// Executa a alteração de registro com os novos valores
		return resposta_UsuarioPersistence.update(novaRespostaUsuario, false);
	}
}