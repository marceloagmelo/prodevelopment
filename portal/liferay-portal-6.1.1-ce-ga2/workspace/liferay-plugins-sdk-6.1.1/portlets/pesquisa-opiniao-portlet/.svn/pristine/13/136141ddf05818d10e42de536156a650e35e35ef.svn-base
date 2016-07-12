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

import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Pesquisa in entity cache.
 *
 * @author Marcelo Melo
 * @see Pesquisa
 * @generated
 */
public class PesquisaCacheModel implements CacheModel<Pesquisa>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", titulo=");
		sb.append(titulo);
		sb.append(", descricao=");
		sb.append(descricao);
		sb.append(", dataInclusao=");
		sb.append(dataInclusao);
		sb.append(", dataAlteracao=");
		sb.append(dataAlteracao);
		sb.append(", ativa=");
		sb.append(ativa);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userIdInclusao=");
		sb.append(userIdInclusao);
		sb.append(", userIdAlteracao=");
		sb.append(userIdAlteracao);
		sb.append("}");

		return sb.toString();
	}

	public Pesquisa toEntityModel() {
		PesquisaImpl pesquisaImpl = new PesquisaImpl();

		if (uuid == null) {
			pesquisaImpl.setUuid(StringPool.BLANK);
		}
		else {
			pesquisaImpl.setUuid(uuid);
		}

		pesquisaImpl.setId(id);

		if (titulo == null) {
			pesquisaImpl.setTitulo(StringPool.BLANK);
		}
		else {
			pesquisaImpl.setTitulo(titulo);
		}

		if (descricao == null) {
			pesquisaImpl.setDescricao(StringPool.BLANK);
		}
		else {
			pesquisaImpl.setDescricao(descricao);
		}

		if (dataInclusao == Long.MIN_VALUE) {
			pesquisaImpl.setDataInclusao(null);
		}
		else {
			pesquisaImpl.setDataInclusao(new Date(dataInclusao));
		}

		if (dataAlteracao == Long.MIN_VALUE) {
			pesquisaImpl.setDataAlteracao(null);
		}
		else {
			pesquisaImpl.setDataAlteracao(new Date(dataAlteracao));
		}

		pesquisaImpl.setAtiva(ativa);
		pesquisaImpl.setCompanyId(companyId);
		pesquisaImpl.setGroupId(groupId);
		pesquisaImpl.setUserIdInclusao(userIdInclusao);
		pesquisaImpl.setUserIdAlteracao(userIdAlteracao);

		pesquisaImpl.resetOriginalValues();

		return pesquisaImpl;
	}

	public String uuid;
	public long id;
	public String titulo;
	public String descricao;
	public long dataInclusao;
	public long dataAlteracao;
	public boolean ativa;
	public long companyId;
	public long groupId;
	public long userIdInclusao;
	public long userIdAlteracao;
}