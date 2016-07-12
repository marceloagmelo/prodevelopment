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

package br.com.prodevelopment.pesquisaopiniao.service.persistence;

import br.com.prodevelopment.pesquisaopiniao.model.Resposta;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the resposta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see RespostaPersistenceImpl
 * @see RespostaUtil
 * @generated
 */
public interface RespostaPersistence extends BasePersistence<Resposta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RespostaUtil} to access the resposta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the resposta in the entity cache if it is enabled.
	*
	* @param resposta the resposta
	*/
	public void cacheResult(
		br.com.prodevelopment.pesquisaopiniao.model.Resposta resposta);

	/**
	* Caches the respostas in the entity cache if it is enabled.
	*
	* @param respostas the respostas
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta> respostas);

	/**
	* Creates a new resposta with the primary key. Does not add the resposta to the database.
	*
	* @param id the primary key for the new resposta
	* @return the new resposta
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta create(long id);

	/**
	* Removes the resposta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the resposta
	* @return the resposta that was removed
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta remove(long id)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.pesquisaopiniao.model.Resposta updateImpl(
		br.com.prodevelopment.pesquisaopiniao.model.Resposta resposta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resposta with the primary key or throws a {@link br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException} if it could not be found.
	*
	* @param id the primary key of the resposta
	* @return the resposta
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resposta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the resposta
	* @return the resposta, or <code>null</code> if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the respostas where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @return the matching respostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta> findByPerguntaId(
		long perguntaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the respostas where perguntaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param perguntaId the pergunta ID
	* @param start the lower bound of the range of respostas
	* @param end the upper bound of the range of respostas (not inclusive)
	* @return the range of matching respostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta> findByPerguntaId(
		long perguntaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the respostas where perguntaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param perguntaId the pergunta ID
	* @param start the lower bound of the range of respostas
	* @param end the upper bound of the range of respostas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching respostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta> findByPerguntaId(
		long perguntaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first resposta in the ordered set where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resposta
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException if a matching resposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta findByPerguntaId_First(
		long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first resposta in the ordered set where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resposta, or <code>null</code> if a matching resposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta fetchByPerguntaId_First(
		long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last resposta in the ordered set where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resposta
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException if a matching resposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta findByPerguntaId_Last(
		long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last resposta in the ordered set where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resposta, or <code>null</code> if a matching resposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta fetchByPerguntaId_Last(
		long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the respostas before and after the current resposta in the ordered set where perguntaId = &#63;.
	*
	* @param id the primary key of the current resposta
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next resposta
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.pesquisaopiniao.model.Resposta[] findByPerguntaId_PrevAndNext(
		long id, long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the respostas.
	*
	* @return the respostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the respostas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of respostas
	* @param end the upper bound of the range of respostas (not inclusive)
	* @return the range of respostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the respostas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of respostas
	* @param end the upper bound of the range of respostas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of respostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the respostas where perguntaId = &#63; from the database.
	*
	* @param perguntaId the pergunta ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPerguntaId(long perguntaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the respostas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of respostas where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @return the number of matching respostas
	* @throws SystemException if a system exception occurred
	*/
	public int countByPerguntaId(long perguntaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of respostas.
	*
	* @return the number of respostas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}