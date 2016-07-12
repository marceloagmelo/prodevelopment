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

import br.com.prodevelopment.pesquisaopiniao.model.Resposta;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Resposta in entity cache.
 *
 * @author Marcelo Melo
 * @see Resposta
 * @generated
 */
public class RespostaCacheModel implements CacheModel<Resposta>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", descricao=");
		sb.append(descricao);
		sb.append(", dataInclusao=");
		sb.append(dataInclusao);
		sb.append(", dataAlteracao=");
		sb.append(dataAlteracao);
		sb.append(", perguntaId=");
		sb.append(perguntaId);
		sb.append(", userIdInclusao=");
		sb.append(userIdInclusao);
		sb.append(", userIdAlteracao=");
		sb.append(userIdAlteracao);
		sb.append("}");

		return sb.toString();
	}

	public Resposta toEntityModel() {
		RespostaImpl respostaImpl = new RespostaImpl();

		respostaImpl.setId(id);

		if (descricao == null) {
			respostaImpl.setDescricao(StringPool.BLANK);
		}
		else {
			respostaImpl.setDescricao(descricao);
		}

		if (dataInclusao == Long.MIN_VALUE) {
			respostaImpl.setDataInclusao(null);
		}
		else {
			respostaImpl.setDataInclusao(new Date(dataInclusao));
		}

		if (dataAlteracao == Long.MIN_VALUE) {
			respostaImpl.setDataAlteracao(null);
		}
		else {
			respostaImpl.setDataAlteracao(new Date(dataAlteracao));
		}

		respostaImpl.setPerguntaId(perguntaId);
		respostaImpl.setUserIdInclusao(userIdInclusao);
		respostaImpl.setUserIdAlteracao(userIdAlteracao);

		respostaImpl.resetOriginalValues();

		return respostaImpl;
	}

	public long id;
	public String descricao;
	public long dataInclusao;
	public long dataAlteracao;
	public long perguntaId;
	public long userIdInclusao;
	public long userIdAlteracao;
}