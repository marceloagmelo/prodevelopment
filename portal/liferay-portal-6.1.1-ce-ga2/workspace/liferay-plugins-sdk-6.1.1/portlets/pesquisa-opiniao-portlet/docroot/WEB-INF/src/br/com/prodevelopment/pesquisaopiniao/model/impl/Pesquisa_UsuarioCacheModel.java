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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Pesquisa_Usuario in entity cache.
 *
 * @author Marcelo Melo
 * @see Pesquisa_Usuario
 * @generated
 */
public class Pesquisa_UsuarioCacheModel implements CacheModel<Pesquisa_Usuario>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", email=");
		sb.append(email);
		sb.append(", dataInclusao=");
		sb.append(dataInclusao);
		sb.append(", pesquisaId=");
		sb.append(pesquisaId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public Pesquisa_Usuario toEntityModel() {
		Pesquisa_UsuarioImpl pesquisa_UsuarioImpl = new Pesquisa_UsuarioImpl();

		pesquisa_UsuarioImpl.setId(id);

		if (nome == null) {
			pesquisa_UsuarioImpl.setNome(StringPool.BLANK);
		}
		else {
			pesquisa_UsuarioImpl.setNome(nome);
		}

		if (email == null) {
			pesquisa_UsuarioImpl.setEmail(StringPool.BLANK);
		}
		else {
			pesquisa_UsuarioImpl.setEmail(email);
		}

		if (dataInclusao == Long.MIN_VALUE) {
			pesquisa_UsuarioImpl.setDataInclusao(null);
		}
		else {
			pesquisa_UsuarioImpl.setDataInclusao(new Date(dataInclusao));
		}

		pesquisa_UsuarioImpl.setPesquisaId(pesquisaId);
		pesquisa_UsuarioImpl.setUserId(userId);

		pesquisa_UsuarioImpl.resetOriginalValues();

		return pesquisa_UsuarioImpl;
	}

	public long id;
	public String nome;
	public String email;
	public long dataInclusao;
	public long pesquisaId;
	public long userId;
}