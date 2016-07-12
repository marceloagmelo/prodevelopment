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

package br.com.prodevelopment.municipio.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.com.prodevelopment.municipio.service.http.MunicipioServiceSoap}.
 *
 * @author marcelo
 * @see br.com.prodevelopment.municipio.service.http.MunicipioServiceSoap
 * @generated
 */
public class MunicipioSoap implements Serializable {
	public static MunicipioSoap toSoapModel(Municipio model) {
		MunicipioSoap soapModel = new MunicipioSoap();

		soapModel.setCodigo(model.getCodigo());
		soapModel.setUf(model.getUf());
		soapModel.setCidade(model.getCidade());
		soapModel.setBairro(model.getBairro());
		soapModel.setLogradouro(model.getLogradouro());
		soapModel.setCep(model.getCep());

		return soapModel;
	}

	public static MunicipioSoap[] toSoapModels(Municipio[] models) {
		MunicipioSoap[] soapModels = new MunicipioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MunicipioSoap[][] toSoapModels(Municipio[][] models) {
		MunicipioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MunicipioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MunicipioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MunicipioSoap[] toSoapModels(List<Municipio> models) {
		List<MunicipioSoap> soapModels = new ArrayList<MunicipioSoap>(models.size());

		for (Municipio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MunicipioSoap[soapModels.size()]);
	}

	public MunicipioSoap() {
	}

	public long getPrimaryKey() {
		return _codigo;
	}

	public void setPrimaryKey(long pk) {
		setCodigo(pk);
	}

	public long getCodigo() {
		return _codigo;
	}

	public void setCodigo(long codigo) {
		_codigo = codigo;
	}

	public String getUf() {
		return _uf;
	}

	public void setUf(String uf) {
		_uf = uf;
	}

	public String getCidade() {
		return _cidade;
	}

	public void setCidade(String cidade) {
		_cidade = cidade;
	}

	public String getBairro() {
		return _bairro;
	}

	public void setBairro(String bairro) {
		_bairro = bairro;
	}

	public String getLogradouro() {
		return _logradouro;
	}

	public void setLogradouro(String logradouro) {
		_logradouro = logradouro;
	}

	public String getCep() {
		return _cep;
	}

	public void setCep(String cep) {
		_cep = cep;
	}

	private long _codigo;
	private String _uf;
	private String _cidade;
	private String _bairro;
	private String _logradouro;
	private String _cep;
}