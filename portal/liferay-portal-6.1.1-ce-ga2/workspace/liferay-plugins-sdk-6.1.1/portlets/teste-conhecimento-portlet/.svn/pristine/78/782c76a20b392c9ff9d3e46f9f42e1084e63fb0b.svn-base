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

package br.com.prodevelopment.testeconhecimento.service.impl;

import br.com.prodevelopment.testeconhecimento.model.Teste;
import br.com.prodevelopment.testeconhecimento.model.Teste_Usuario;
import br.com.prodevelopment.testeconhecimento.service.base.Teste_UsuarioLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the teste_ usuario local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.testeconhecimento.service.Teste_UsuarioLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.testeconhecimento.service.base.Teste_UsuarioLocalServiceBaseImpl
 * @see br.com.prodevelopment.testeconhecimento.service.Teste_UsuarioLocalServiceUtil
 */
public class Teste_UsuarioLocalServiceImpl
	extends Teste_UsuarioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.testeconhecimento.service.Teste_UsuarioLocalServiceUtil} to access the teste_ usuario local service.
	 */
	@Override
	public Teste_Usuario addTeste_Usuario(Teste_Usuario testeUsuario) throws SystemException {
		Teste_Usuario novoTesteUsuario = teste_UsuarioPersistence.create(counterLocalService.increment(Teste_Usuario.class.getName()));

		novoTesteUsuario.setDataInclusao(testeUsuario.getDataInclusao());
		novoTesteUsuario.setEmail(testeUsuario.getEmail());
		novoTesteUsuario.setNome(testeUsuario.getNome());
		novoTesteUsuario.setTesteId(testeUsuario.getTesteId());
		novoTesteUsuario.setUserId(testeUsuario.getUserId());
		novoTesteUsuario.setTotalRespostaCorreta(testeUsuario.getTotalRespostaCorreta());
		novoTesteUsuario.setTotalRespostaErrada(testeUsuario.getTotalRespostaErrada());
		novoTesteUsuario.setDataFinalizacao(testeUsuario.getDataFinalizacao());
		novoTesteUsuario.setTotalPontuacao(testeUsuario.getTotalPontuacao());

		try {
			Teste teste = testePersistence.fetchByPrimaryKey(testeUsuario.getTesteId());
	        resourceLocalService.addResources(
	        		teste.getCompanyId(), teste.getGroupId(),
	        		Teste_Usuario.class.getName(), false);
			

	        // Social
	        User user = UserLocalServiceUtil.getUser(testeUsuario.getUserId());

	        if (user != null) {
	            socialActivityLocalService.addActivity(
	                user.getUserId(), teste.getGroupId(),
	                Teste_Usuario.class.getName(), testeUsuario.getPrimaryKey(),
	                1, StringPool.BLANK, 0);
	        }
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}

		// Executa a alteração de registro com os novos valores
		return teste_UsuarioPersistence.update(novoTesteUsuario, false);
	}
}