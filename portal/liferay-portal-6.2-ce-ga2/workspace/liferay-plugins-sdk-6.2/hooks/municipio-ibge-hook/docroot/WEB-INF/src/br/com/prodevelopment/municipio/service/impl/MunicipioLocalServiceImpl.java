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

package br.com.prodevelopment.municipio.service.impl;

import java.util.List;

import br.com.prodevelopment.municipio.model.Municipio;
import br.com.prodevelopment.municipio.model.impl.MunicipioImpl;
import br.com.prodevelopment.municipio.service.base.MunicipioLocalServiceBaseImpl;
import br.com.prodevelopment.municipio.util.WebServiceCep;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the municipio local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.com.prodevelopment.municipio.service.MunicipioLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author marcelo
 * @see br.com.prodevelopment.municipio.service.base.MunicipioLocalServiceBaseImpl
 * @see br.com.prodevelopment.municipio.service.MunicipioLocalServiceUtil
 */
public class MunicipioLocalServiceImpl extends MunicipioLocalServiceBaseImpl {
	private static Log _log = LogFactoryUtil.getLog(MunicipioLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.com.prodevelopment.municipio.service.MunicipioLocalServiceUtil} to
	 * access the municipio local service.
	 */
	public List<Municipio> search(String uf) throws SystemException {
		return municipioPersistence.findByUF(uf);

	}

	public int searchCount(String uf) throws SystemException {
		return municipioPersistence.findByUF(uf).size();

	}

	public List<Municipio> search(String uf, int start, int end)
			throws SystemException {
		return municipioPersistence.findByUF(uf, start, end);

	}

	public int searchCount(String uf, int start, int end)
			throws SystemException {
		return municipioPersistence.findByUF(uf, start, end).size();

	}

	public List<Municipio> search(String uf, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return municipioPersistence.findByUF(uf, start, end, orderByComparator);

	}

	public int searchCount(String uf, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return municipioPersistence.findByUF(uf, start, end, orderByComparator)
				.size();

	}

	public Municipio getDadosCep(String cep) throws SystemException {
		Municipio municipio = null;

		// Faz a busca para o cep
		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
		// A ferramenta de busca ignora qualquer caracter que não seja número.

		// caso a busca ocorra bem, imprime os resultados.
		if (webServiceCep.wasSuccessful()) {
			municipio = new MunicipioImpl();

			municipio.setCep(webServiceCep.getCep());
			municipio.setLogradouro(webServiceCep.getLogradouroFull());
			municipio.setBairro(webServiceCep.getBairro());
			municipio.setUf(webServiceCep.getUf());

			// caso haja problemas imprime as exceções.
		} else {
			if (_log.isWarnEnabled()) {
				_log.warn("Erro numero: " + webServiceCep.getResulCode());
				_log.warn("Descrição do erro: " + webServiceCep.getResultText());
			}
			
		}
		return municipio;
	}

}