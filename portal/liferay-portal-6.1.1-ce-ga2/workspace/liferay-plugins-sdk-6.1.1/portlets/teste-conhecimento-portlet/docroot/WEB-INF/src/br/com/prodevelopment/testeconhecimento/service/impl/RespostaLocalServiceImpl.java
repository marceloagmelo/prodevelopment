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

import br.com.prodevelopment.testeconhecimento.model.Resposta;
import br.com.prodevelopment.testeconhecimento.service.base.RespostaLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the resposta local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.prodevelopment.testeconhecimento.service.RespostaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.testeconhecimento.service.base.RespostaLocalServiceBaseImpl
 * @see br.com.prodevelopment.testeconhecimento.service.RespostaLocalServiceUtil
 */
public class RespostaLocalServiceImpl extends RespostaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.prodevelopment.testeconhecimento.service.RespostaLocalServiceUtil} to access the resposta local service.
	 */
	@Override
	public Resposta addResposta(Resposta resposta) throws SystemException {
		// Criar objeto incrementando um novo ID
		Resposta novaResposta =	respostaPersistence.create(counterLocalService.increment(Resposta.class.getName()));

		// Atribui novos valores
		novaResposta.setDataInclusao(resposta.getDataInclusao());
		novaResposta.setDescricao(resposta.getDescricao());
		novaResposta.setDescricaoMap(resposta.getDescricaoMap());
		novaResposta.setPerguntaId(resposta.getPerguntaId());
		novaResposta.setUserIdInclusao(resposta.getUserIdInclusao());
		novaResposta.setCorreta(resposta.getCorreta());

		// Executa a alteração de registro com os novos valores
		return respostaPersistence.update(novaResposta, false);
	}
}