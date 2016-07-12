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

package br.com.prodevelopment.municipio.model.impl;

import br.com.prodevelopment.municipio.model.Municipio;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Municipio in entity cache.
 *
 * @author marcelo
 * @see Municipio
 * @generated
 */
public class MunicipioCacheModel implements CacheModel<Municipio>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{codigo=");
		sb.append(codigo);
		sb.append(", uf=");
		sb.append(uf);
		sb.append(", cidade=");
		sb.append(cidade);
		sb.append(", bairro=");
		sb.append(bairro);
		sb.append(", logradouro=");
		sb.append(logradouro);
		sb.append(", cep=");
		sb.append(cep);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Municipio toEntityModel() {
		MunicipioImpl municipioImpl = new MunicipioImpl();

		municipioImpl.setCodigo(codigo);

		if (uf == null) {
			municipioImpl.setUf(StringPool.BLANK);
		}
		else {
			municipioImpl.setUf(uf);
		}

		if (cidade == null) {
			municipioImpl.setCidade(StringPool.BLANK);
		}
		else {
			municipioImpl.setCidade(cidade);
		}

		if (bairro == null) {
			municipioImpl.setBairro(StringPool.BLANK);
		}
		else {
			municipioImpl.setBairro(bairro);
		}

		if (logradouro == null) {
			municipioImpl.setLogradouro(StringPool.BLANK);
		}
		else {
			municipioImpl.setLogradouro(logradouro);
		}

		if (cep == null) {
			municipioImpl.setCep(StringPool.BLANK);
		}
		else {
			municipioImpl.setCep(cep);
		}

		municipioImpl.resetOriginalValues();

		return municipioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codigo = objectInput.readLong();
		uf = objectInput.readUTF();
		cidade = objectInput.readUTF();
		bairro = objectInput.readUTF();
		logradouro = objectInput.readUTF();
		cep = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(codigo);

		if (uf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uf);
		}

		if (cidade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cidade);
		}

		if (bairro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bairro);
		}

		if (logradouro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logradouro);
		}

		if (cep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cep);
		}
	}

	public long codigo;
	public String uf;
	public String cidade;
	public String bairro;
	public String logradouro;
	public String cep;
}