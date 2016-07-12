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

import br.com.prodevelopment.testeconhecimento.model.Pergunta;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Pergunta in entity cache.
 *
 * @author Marcelo Melo
 * @see Pergunta
 * @generated
 */
public class PerguntaCacheModel implements CacheModel<Pergunta>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", descricao=");
		sb.append(descricao);
		sb.append(", justificativaResposta=");
		sb.append(justificativaResposta);
		sb.append(", pontuacao=");
		sb.append(pontuacao);
		sb.append(", dataInclusao=");
		sb.append(dataInclusao);
		sb.append(", dataAlteracao=");
		sb.append(dataAlteracao);
		sb.append(", testeId=");
		sb.append(testeId);
		sb.append(", userIdInclusao=");
		sb.append(userIdInclusao);
		sb.append(", userIdAlteracao=");
		sb.append(userIdAlteracao);
		sb.append("}");

		return sb.toString();
	}

	public Pergunta toEntityModel() {
		PerguntaImpl perguntaImpl = new PerguntaImpl();

		perguntaImpl.setId(id);

		if (descricao == null) {
			perguntaImpl.setDescricao(StringPool.BLANK);
		}
		else {
			perguntaImpl.setDescricao(descricao);
		}

		if (justificativaResposta == null) {
			perguntaImpl.setJustificativaResposta(StringPool.BLANK);
		}
		else {
			perguntaImpl.setJustificativaResposta(justificativaResposta);
		}

		perguntaImpl.setPontuacao(pontuacao);

		if (dataInclusao == Long.MIN_VALUE) {
			perguntaImpl.setDataInclusao(null);
		}
		else {
			perguntaImpl.setDataInclusao(new Date(dataInclusao));
		}

		if (dataAlteracao == Long.MIN_VALUE) {
			perguntaImpl.setDataAlteracao(null);
		}
		else {
			perguntaImpl.setDataAlteracao(new Date(dataAlteracao));
		}

		perguntaImpl.setTesteId(testeId);
		perguntaImpl.setUserIdInclusao(userIdInclusao);
		perguntaImpl.setUserIdAlteracao(userIdAlteracao);

		perguntaImpl.resetOriginalValues();

		return perguntaImpl;
	}

	public long id;
	public String descricao;
	public String justificativaResposta;
	public double pontuacao;
	public long dataInclusao;
	public long dataAlteracao;
	public long testeId;
	public long userIdInclusao;
	public long userIdAlteracao;
}