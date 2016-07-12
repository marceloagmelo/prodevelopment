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

package br.com.prodevelopment.testeconhecimento.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Teste_Usuario}.
 * </p>
 *
 * @author    Marcelo Melo
 * @see       Teste_Usuario
 * @generated
 */
public class Teste_UsuarioWrapper implements Teste_Usuario,
	ModelWrapper<Teste_Usuario> {
	public Teste_UsuarioWrapper(Teste_Usuario teste_Usuario) {
		_teste_Usuario = teste_Usuario;
	}

	public Class<?> getModelClass() {
		return Teste_Usuario.class;
	}

	public String getModelClassName() {
		return Teste_Usuario.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("email", getEmail());
		attributes.put("dataInclusao", getDataInclusao());
		attributes.put("dataFinalizacao", getDataFinalizacao());
		attributes.put("totalRespostaCorreta", getTotalRespostaCorreta());
		attributes.put("totalRespostaErrada", getTotalRespostaErrada());
		attributes.put("totalPontuacao", getTotalPontuacao());
		attributes.put("testeId", getTesteId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date dataInclusao = (Date)attributes.get("dataInclusao");

		if (dataInclusao != null) {
			setDataInclusao(dataInclusao);
		}

		Date dataFinalizacao = (Date)attributes.get("dataFinalizacao");

		if (dataFinalizacao != null) {
			setDataFinalizacao(dataFinalizacao);
		}

		Integer totalRespostaCorreta = (Integer)attributes.get(
				"totalRespostaCorreta");

		if (totalRespostaCorreta != null) {
			setTotalRespostaCorreta(totalRespostaCorreta);
		}

		Integer totalRespostaErrada = (Integer)attributes.get(
				"totalRespostaErrada");

		if (totalRespostaErrada != null) {
			setTotalRespostaErrada(totalRespostaErrada);
		}

		Double totalPontuacao = (Double)attributes.get("totalPontuacao");

		if (totalPontuacao != null) {
			setTotalPontuacao(totalPontuacao);
		}

		Long testeId = (Long)attributes.get("testeId");

		if (testeId != null) {
			setTesteId(testeId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this teste_ usuario.
	*
	* @return the primary key of this teste_ usuario
	*/
	public long getPrimaryKey() {
		return _teste_Usuario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this teste_ usuario.
	*
	* @param primaryKey the primary key of this teste_ usuario
	*/
	public void setPrimaryKey(long primaryKey) {
		_teste_Usuario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this teste_ usuario.
	*
	* @return the ID of this teste_ usuario
	*/
	public long getId() {
		return _teste_Usuario.getId();
	}

	/**
	* Sets the ID of this teste_ usuario.
	*
	* @param id the ID of this teste_ usuario
	*/
	public void setId(long id) {
		_teste_Usuario.setId(id);
	}

	/**
	* Returns the nome of this teste_ usuario.
	*
	* @return the nome of this teste_ usuario
	*/
	public java.lang.String getNome() {
		return _teste_Usuario.getNome();
	}

	/**
	* Sets the nome of this teste_ usuario.
	*
	* @param nome the nome of this teste_ usuario
	*/
	public void setNome(java.lang.String nome) {
		_teste_Usuario.setNome(nome);
	}

	/**
	* Returns the email of this teste_ usuario.
	*
	* @return the email of this teste_ usuario
	*/
	public java.lang.String getEmail() {
		return _teste_Usuario.getEmail();
	}

	/**
	* Sets the email of this teste_ usuario.
	*
	* @param email the email of this teste_ usuario
	*/
	public void setEmail(java.lang.String email) {
		_teste_Usuario.setEmail(email);
	}

	/**
	* Returns the data inclusao of this teste_ usuario.
	*
	* @return the data inclusao of this teste_ usuario
	*/
	public java.util.Date getDataInclusao() {
		return _teste_Usuario.getDataInclusao();
	}

	/**
	* Sets the data inclusao of this teste_ usuario.
	*
	* @param dataInclusao the data inclusao of this teste_ usuario
	*/
	public void setDataInclusao(java.util.Date dataInclusao) {
		_teste_Usuario.setDataInclusao(dataInclusao);
	}

	/**
	* Returns the data finalizacao of this teste_ usuario.
	*
	* @return the data finalizacao of this teste_ usuario
	*/
	public java.util.Date getDataFinalizacao() {
		return _teste_Usuario.getDataFinalizacao();
	}

	/**
	* Sets the data finalizacao of this teste_ usuario.
	*
	* @param dataFinalizacao the data finalizacao of this teste_ usuario
	*/
	public void setDataFinalizacao(java.util.Date dataFinalizacao) {
		_teste_Usuario.setDataFinalizacao(dataFinalizacao);
	}

	/**
	* Returns the total resposta correta of this teste_ usuario.
	*
	* @return the total resposta correta of this teste_ usuario
	*/
	public int getTotalRespostaCorreta() {
		return _teste_Usuario.getTotalRespostaCorreta();
	}

	/**
	* Sets the total resposta correta of this teste_ usuario.
	*
	* @param totalRespostaCorreta the total resposta correta of this teste_ usuario
	*/
	public void setTotalRespostaCorreta(int totalRespostaCorreta) {
		_teste_Usuario.setTotalRespostaCorreta(totalRespostaCorreta);
	}

	/**
	* Returns the total resposta errada of this teste_ usuario.
	*
	* @return the total resposta errada of this teste_ usuario
	*/
	public int getTotalRespostaErrada() {
		return _teste_Usuario.getTotalRespostaErrada();
	}

	/**
	* Sets the total resposta errada of this teste_ usuario.
	*
	* @param totalRespostaErrada the total resposta errada of this teste_ usuario
	*/
	public void setTotalRespostaErrada(int totalRespostaErrada) {
		_teste_Usuario.setTotalRespostaErrada(totalRespostaErrada);
	}

	/**
	* Returns the total pontuacao of this teste_ usuario.
	*
	* @return the total pontuacao of this teste_ usuario
	*/
	public double getTotalPontuacao() {
		return _teste_Usuario.getTotalPontuacao();
	}

	/**
	* Sets the total pontuacao of this teste_ usuario.
	*
	* @param totalPontuacao the total pontuacao of this teste_ usuario
	*/
	public void setTotalPontuacao(double totalPontuacao) {
		_teste_Usuario.setTotalPontuacao(totalPontuacao);
	}

	/**
	* Returns the teste ID of this teste_ usuario.
	*
	* @return the teste ID of this teste_ usuario
	*/
	public long getTesteId() {
		return _teste_Usuario.getTesteId();
	}

	/**
	* Sets the teste ID of this teste_ usuario.
	*
	* @param testeId the teste ID of this teste_ usuario
	*/
	public void setTesteId(long testeId) {
		_teste_Usuario.setTesteId(testeId);
	}

	/**
	* Returns the user ID of this teste_ usuario.
	*
	* @return the user ID of this teste_ usuario
	*/
	public long getUserId() {
		return _teste_Usuario.getUserId();
	}

	/**
	* Sets the user ID of this teste_ usuario.
	*
	* @param userId the user ID of this teste_ usuario
	*/
	public void setUserId(long userId) {
		_teste_Usuario.setUserId(userId);
	}

	/**
	* Returns the user uuid of this teste_ usuario.
	*
	* @return the user uuid of this teste_ usuario
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _teste_Usuario.getUserUuid();
	}

	/**
	* Sets the user uuid of this teste_ usuario.
	*
	* @param userUuid the user uuid of this teste_ usuario
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_teste_Usuario.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _teste_Usuario.isNew();
	}

	public void setNew(boolean n) {
		_teste_Usuario.setNew(n);
	}

	public boolean isCachedModel() {
		return _teste_Usuario.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_teste_Usuario.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _teste_Usuario.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _teste_Usuario.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_teste_Usuario.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _teste_Usuario.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_teste_Usuario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Teste_UsuarioWrapper((Teste_Usuario)_teste_Usuario.clone());
	}

	public int compareTo(
		br.com.prodevelopment.testeconhecimento.model.Teste_Usuario teste_Usuario) {
		return _teste_Usuario.compareTo(teste_Usuario);
	}

	@Override
	public int hashCode() {
		return _teste_Usuario.hashCode();
	}

	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> toCacheModel() {
		return _teste_Usuario.toCacheModel();
	}

	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario toEscapedModel() {
		return new Teste_UsuarioWrapper(_teste_Usuario.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _teste_Usuario.toString();
	}

	public java.lang.String toXmlString() {
		return _teste_Usuario.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_teste_Usuario.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Teste_Usuario getWrappedTeste_Usuario() {
		return _teste_Usuario;
	}

	public Teste_Usuario getWrappedModel() {
		return _teste_Usuario;
	}

	public void resetOriginalValues() {
		_teste_Usuario.resetOriginalValues();
	}

	private Teste_Usuario _teste_Usuario;
}