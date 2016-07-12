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
import br.com.prodevelopment.pesquisaopiniao.service.base.PesquisaLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the pesquisa local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.pesquisaopiniao.service.PesquisaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.pesquisaopiniao.service.base.PesquisaLocalServiceBaseImpl
 * @see br.com.prodevelopment.pesquisaopiniao.service.PesquisaLocalServiceUtil
 */
public class PesquisaLocalServiceImpl extends PesquisaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.pesquisaopiniao.service.PesquisaLocalServiceUtil} to access the pesquisa local service.
	 */
	@Override
	public Pesquisa addPesquisa(Pesquisa pesquisa) throws SystemException {
		// Criar objeto incrementando um novo ID
		Pesquisa novaPesquisa =	pesquisaPersistence.create(counterLocalService.increment(Pesquisa.class.getName()));
		
		// Atribui novos valores
		novaPesquisa.setAtiva(pesquisa.getAtiva());
		novaPesquisa.setCompanyId(pesquisa.getCompanyId());
		novaPesquisa.setDataInclusao(pesquisa.getDataInclusao());
		novaPesquisa.setDescricaoMap(pesquisa.getDescricaoMap());
		novaPesquisa.setGroupId(pesquisa.getGroupId());
		novaPesquisa.setTituloMap(pesquisa.getTituloMap());
		novaPesquisa.setUserIdInclusao(pesquisa.getUserIdInclusao());
		
		try {
	        resourceLocalService.addResources(
	        		pesquisa.getCompanyId(), pesquisa.getGroupId(),
	                Pesquisa.class.getName(), false);
			

	        // Social

	        // try to get the user from the pruser for social
	        // there will be no link if the user wasn't logged in

	        User user = UserLocalServiceUtil.getUser(pesquisa.getUserIdInclusao());

	        if (user != null) {
	            socialActivityLocalService.addActivity(
	                user.getUserId(), pesquisa.getGroupId(),
	                Pesquisa.class.getName(), pesquisa.getPrimaryKey(),
	                1, StringPool.BLANK, 0);
	        }
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}

		// Executa a alteração de registro com os novos valores
		return pesquisaPersistence.update(novaPesquisa, false);
	}
}