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

import br.com.prodevelopment.pesquisaopiniao.model.Pergunta;
import br.com.prodevelopment.pesquisaopiniao.service.base.PerguntaLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the pergunta local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.pesquisaopiniao.service.PerguntaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.pesquisaopiniao.service.base.PerguntaLocalServiceBaseImpl
 * @see br.com.prodevelopment.pesquisaopiniao.service.PerguntaLocalServiceUtil
 */
public class PerguntaLocalServiceImpl extends PerguntaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.pesquisaopiniao.service.PerguntaLocalServiceUtil} to access the pergunta local service.
	 */
	@Override
	public Pergunta addPergunta(Pergunta pergunta) throws SystemException {
		// Criar objeto incrementando um novo ID
		Pergunta novaPergunta =	perguntaPersistence.create(counterLocalService.increment(Pergunta.class.getName()));
		
		// Atribui novos valores
		novaPergunta.setDataInclusao(pergunta.getDataInclusao());
		novaPergunta.setDescricaoMap(pergunta.getDescricaoMap());
		novaPergunta.setPesquisaId(pergunta.getPesquisaId());
		novaPergunta.setUserIdInclusao(pergunta.getUserIdInclusao());
		
		// Executa a alteração de registro com os novos valores
		return perguntaPersistence.update(novaPergunta, false);
	}
}