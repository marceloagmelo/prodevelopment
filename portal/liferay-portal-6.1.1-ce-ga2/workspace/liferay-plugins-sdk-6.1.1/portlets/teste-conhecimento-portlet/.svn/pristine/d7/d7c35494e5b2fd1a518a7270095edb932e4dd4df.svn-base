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

import br.com.prodevelopment.testeconhecimento.model.Teste_Usuario;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Teste_Usuario in entity cache.
 *
 * @author Marcelo Melo
 * @see Teste_Usuario
 * @generated
 */
public class Teste_UsuarioCacheModel implements CacheModel<Teste_Usuario>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", email=");
		sb.append(email);
		sb.append(", dataInclusao=");
		sb.append(dataInclusao);
		sb.append(", dataFinalizacao=");
		sb.append(dataFinalizacao);
		sb.append(", totalRespostaCorreta=");
		sb.append(totalRespostaCorreta);
		sb.append(", totalRespostaErrada=");
		sb.append(totalRespostaErrada);
		sb.append(", totalPontuacao=");
		sb.append(totalPontuacao);
		sb.append(", testeId=");
		sb.append(testeId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public Teste_Usuario toEntityModel() {
		Teste_UsuarioImpl teste_UsuarioImpl = new Teste_UsuarioImpl();

		teste_UsuarioImpl.setId(id);

		if (nome == null) {
			teste_UsuarioImpl.setNome(StringPool.BLANK);
		}
		else {
			teste_UsuarioImpl.setNome(nome);
		}

		if (email == null) {
			teste_UsuarioImpl.setEmail(StringPool.BLANK);
		}
		else {
			teste_UsuarioImpl.setEmail(email);
		}

		if (dataInclusao == Long.MIN_VALUE) {
			teste_UsuarioImpl.setDataInclusao(null);
		}
		else {
			teste_UsuarioImpl.setDataInclusao(new Date(dataInclusao));
		}

		if (dataFinalizacao == Long.MIN_VALUE) {
			teste_UsuarioImpl.setDataFinalizacao(null);
		}
		else {
			teste_UsuarioImpl.setDataFinalizacao(new Date(dataFinalizacao));
		}

		teste_UsuarioImpl.setTotalRespostaCorreta(totalRespostaCorreta);
		teste_UsuarioImpl.setTotalRespostaErrada(totalRespostaErrada);
		teste_UsuarioImpl.setTotalPontuacao(totalPontuacao);
		teste_UsuarioImpl.setTesteId(testeId);
		teste_UsuarioImpl.setUserId(userId);

		teste_UsuarioImpl.resetOriginalValues();

		return teste_UsuarioImpl;
	}

	public long id;
	public String nome;
	public String email;
	public long dataInclusao;
	public long dataFinalizacao;
	public int totalRespostaCorreta;
	public int totalRespostaErrada;
	public double totalPontuacao;
	public long testeId;
	public long userId;
}