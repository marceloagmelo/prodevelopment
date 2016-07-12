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
import br.com.prodevelopment.testeconhecimento.service.base.TesteLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the teste local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.testeconhecimento.service.TesteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.testeconhecimento.service.base.TesteLocalServiceBaseImpl
 * @see br.com.prodevelopment.testeconhecimento.service.TesteLocalServiceUtil
 */
public class TesteLocalServiceImpl extends TesteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.testeconhecimento.service.TesteLocalServiceUtil} to access the teste local service.
	 */
	@Override
	public Teste addTeste(Teste teste) throws SystemException {
		Teste novoTeste =	testePersistence.create(counterLocalService.increment(Teste.class.getName()));

		novoTeste.setAtivo(teste.getAtivo());
		novoTeste.setCompanyId(teste.getCompanyId());
		novoTeste.setDataInclusao(teste.getDataInclusao());
		novoTeste.setDescricao(teste.getDescricao());
		novoTeste.setDescricaoMap(teste.getDescricaoMap());
		novoTeste.setGroupId(teste.getGroupId());
		novoTeste.setTitulo(teste.getTitulo());
		novoTeste.setTituloMap(teste.getTituloMap());
		novoTeste.setUserIdInclusao(teste.getUserIdInclusao());

		try {
	        resourceLocalService.addResources(
	        		teste.getCompanyId(), teste.getGroupId(),
	                Teste.class.getName(), false);
			

	        // Social

	        // try to get the user from the pruser for social
	        // there will be no link if the user wasn't logged in

	        User user = UserLocalServiceUtil.getUser(teste.getUserIdInclusao());

	        if (user != null) {
	            socialActivityLocalService.addActivity(
	                user.getUserId(), teste.getGroupId(),
	                Teste.class.getName(), teste.getPrimaryKey(),
	                1, StringPool.BLANK, 0);
	        }
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}

		return testePersistence.update(novoTeste, false);
	}
}