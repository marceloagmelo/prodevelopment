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

import br.com.prodevelopment.testeconhecimento.model.Teste;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Teste in entity cache.
 *
 * @author Marcelo Melo
 * @see Teste
 * @generated
 */
public class TesteCacheModel implements CacheModel<Teste>, Serializable {
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
		sb.append(", ativo=");
		sb.append(ativo);
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

	public Teste toEntityModel() {
		TesteImpl testeImpl = new TesteImpl();

		if (uuid == null) {
			testeImpl.setUuid(StringPool.BLANK);
		}
		else {
			testeImpl.setUuid(uuid);
		}

		testeImpl.setId(id);

		if (titulo == null) {
			testeImpl.setTitulo(StringPool.BLANK);
		}
		else {
			testeImpl.setTitulo(titulo);
		}

		if (descricao == null) {
			testeImpl.setDescricao(StringPool.BLANK);
		}
		else {
			testeImpl.setDescricao(descricao);
		}

		if (dataInclusao == Long.MIN_VALUE) {
			testeImpl.setDataInclusao(null);
		}
		else {
			testeImpl.setDataInclusao(new Date(dataInclusao));
		}

		if (dataAlteracao == Long.MIN_VALUE) {
			testeImpl.setDataAlteracao(null);
		}
		else {
			testeImpl.setDataAlteracao(new Date(dataAlteracao));
		}

		testeImpl.setAtivo(ativo);
		testeImpl.setCompanyId(companyId);
		testeImpl.setGroupId(groupId);
		testeImpl.setUserIdInclusao(userIdInclusao);
		testeImpl.setUserIdAlteracao(userIdAlteracao);

		testeImpl.resetOriginalValues();

		return testeImpl;
	}

	public String uuid;
	public long id;
	public String titulo;
	public String descricao;
	public long dataInclusao;
	public long dataAlteracao;
	public boolean ativo;
	public long companyId;
	public long groupId;
	public long userIdInclusao;
	public long userIdAlteracao;
}