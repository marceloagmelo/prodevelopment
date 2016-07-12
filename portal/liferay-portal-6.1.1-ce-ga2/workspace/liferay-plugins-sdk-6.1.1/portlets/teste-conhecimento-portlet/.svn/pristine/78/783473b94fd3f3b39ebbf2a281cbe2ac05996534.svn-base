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

import br.com.prodevelopment.testeconhecimento.model.Teste_Usuario;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the teste_ usuario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see Teste_UsuarioPersistenceImpl
 * @see Teste_UsuarioUtil
 * @generated
 */
public interface Teste_UsuarioPersistence extends BasePersistence<Teste_Usuario> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Teste_UsuarioUtil} to access the teste_ usuario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the teste_ usuario in the entity cache if it is enabled.
	*
	* @param teste_Usuario the teste_ usuario
	*/
	public void cacheResult(
		br.com.prodevelopment.testeconhecimento.model.Teste_Usuario teste_Usuario);

	/**
	* Caches the teste_ usuarios in the entity cache if it is enabled.
	*
	* @param teste_Usuarios the teste_ usuarios
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> teste_Usuarios);

	/**
	* Creates a new teste_ usuario with the primary key. Does not add the teste_ usuario to the database.
	*
	* @param id the primary key for the new teste_ usuario
	* @return the new teste_ usuario
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario create(
		long id);

	/**
	* Removes the teste_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the teste_ usuario
	* @return the teste_ usuario that was removed
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a teste_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario remove(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Teste_Usuario teste_Usuario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the teste_ usuario with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException} if it could not be found.
	*
	* @param id the primary key of the teste_ usuario
	* @return the teste_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a teste_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the teste_ usuario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the teste_ usuario
	* @return the teste_ usuario, or <code>null</code> if a teste_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the teste_ usuarios where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @return the matching teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findByTeste(
		long testeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the teste_ usuarios where testeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param testeId the teste ID
	* @param start the lower bound of the range of teste_ usuarios
	* @param end the upper bound of the range of teste_ usuarios (not inclusive)
	* @return the range of matching teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findByTeste(
		long testeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the teste_ usuarios where testeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param testeId the teste ID
	* @param start the lower bound of the range of teste_ usuarios
	* @param end the upper bound of the range of teste_ usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findByTeste(
		long testeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a matching teste_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario findByTeste_First(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste_ usuario, or <code>null</code> if a matching teste_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario fetchByTeste_First(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a matching teste_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario findByTeste_Last(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste_ usuario, or <code>null</code> if a matching teste_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario fetchByTeste_Last(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the teste_ usuarios before and after the current teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param id the primary key of the current teste_ usuario
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next teste_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a teste_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Teste_Usuario[] findByTeste_PrevAndNext(
		long id, long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the teste_ usuarios.
	*
	* @return the teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the teste_ usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of teste_ usuarios
	* @param end the upper bound of the range of teste_ usuarios (not inclusive)
	* @return the range of teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the teste_ usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of teste_ usuarios
	* @param end the upper bound of the range of teste_ usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the teste_ usuarios where testeId = &#63; from the database.
	*
	* @param testeId the teste ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTeste(long testeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the teste_ usuarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of teste_ usuarios where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @return the number of matching teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByTeste(long testeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of teste_ usuarios.
	*
	* @return the number of teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}