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

package br.com.prodevelopment.testeconhecimento.model.impl;

import br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Resposta_Usuario in entity cache.
 *
 * @author Marcelo Melo
 * @see Resposta_Usuario
 * @generated
 */
public class Resposta_UsuarioCacheModel implements CacheModel<Resposta_Usuario>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", correta=");
		sb.append(correta);
		sb.append(", dataInclusao=");
		sb.append(dataInclusao);
		sb.append(", testeUsuarioId=");
		sb.append(testeUsuarioId);
		sb.append(", respostaId=");
		sb.append(respostaId);
		sb.append("}");

		return sb.toString();
	}

	public Resposta_Usuario toEntityModel() {
		Resposta_UsuarioImpl resposta_UsuarioImpl = new Resposta_UsuarioImpl();

		resposta_UsuarioImpl.setId(id);
		resposta_UsuarioImpl.setCorreta(correta);

		if (dataInclusao == Long.MIN_VALUE) {
			resposta_UsuarioImpl.setDataInclusao(null);
		}
		else {
			resposta_UsuarioImpl.setDataInclusao(new Date(dataInclusao));
		}

		resposta_UsuarioImpl.setTesteUsuarioId(testeUsuarioId);
		resposta_UsuarioImpl.setRespostaId(respostaId);

		resposta_UsuarioImpl.resetOriginalValues();

		return resposta_UsuarioImpl;
	}

	public long id;
	public boolean correta;
	public long dataInclusao;
	public long testeUsuarioId;
	public long respostaId;
}