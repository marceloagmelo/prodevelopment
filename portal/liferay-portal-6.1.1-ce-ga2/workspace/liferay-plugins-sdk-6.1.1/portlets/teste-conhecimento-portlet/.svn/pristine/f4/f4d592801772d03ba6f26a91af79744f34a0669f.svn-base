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

package br.com.prodevelopment.testeconhecimento.service.persistence;

import br.com.prodevelopment.testeconhecimento.model.Pergunta;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the pergunta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see PerguntaPersistenceImpl
 * @see PerguntaUtil
 * @generated
 */
public interface PerguntaPersistence extends BasePersistence<Pergunta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PerguntaUtil} to access the pergunta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the pergunta in the entity cache if it is enabled.
	*
	* @param pergunta the pergunta
	*/
	public void cacheResult(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta);

	/**
	* Caches the perguntas in the entity cache if it is enabled.
	*
	* @param perguntas the perguntas
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> perguntas);

	/**
	* Creates a new pergunta with the primary key. Does not add the pergunta to the database.
	*
	* @param id the primary key for the new pergunta
	* @return the new pergunta
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta create(
		long id);

	/**
	* Removes the pergunta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the pergunta
	* @return the pergunta that was removed
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta remove(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.testeconhecimento.model.Pergunta updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pergunta with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException} if it could not be found.
	*
	* @param id the primary key of the pergunta
	* @return the pergunta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pergunta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the pergunta
	* @return the pergunta, or <code>null</code> if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the perguntas where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @return the matching perguntas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findByTeste(
		long testeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the perguntas where testeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param testeId the teste ID
	* @param start the lower bound of the range of perguntas
	* @param end the upper bound of the range of perguntas (not inclusive)
	* @return the range of matching perguntas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findByTeste(
		long testeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the perguntas where testeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param testeId the teste ID
	* @param start the lower bound of the range of perguntas
	* @param end the upper bound of the range of perguntas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching perguntas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findByTeste(
		long testeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pergunta in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pergunta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a matching pergunta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta findByTeste_First(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first pergunta in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pergunta, or <code>null</code> if a matching pergunta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta fetchByTeste_First(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pergunta in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pergunta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a matching pergunta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta findByTeste_Last(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last pergunta in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pergunta, or <code>null</code> if a matching pergunta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta fetchByTeste_Last(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the perguntas before and after the current pergunta in the ordered set where testeId = &#63;.
	*
	* @param id the primary key of the current pergunta
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pergunta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Pergunta[] findByTeste_PrevAndNext(
		long id, long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the perguntas.
	*
	* @return the perguntas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the perguntas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of perguntas
	* @param end the upper bound of the range of perguntas (not inclusive)
	* @return the range of perguntas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the perguntas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of perguntas
	* @param end the upper bound of the range of perguntas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of perguntas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the perguntas where testeId = &#63; from the database.
	*
	* @param testeId the teste ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTeste(long testeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the perguntas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of perguntas where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @return the number of matching perguntas
	* @throws SystemException if a system exception occurred
	*/
	public int countByTeste(long testeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of perguntas.
	*
	* @return the number of perguntas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}