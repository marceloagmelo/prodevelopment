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

import br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the resposta_ usuario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see Resposta_UsuarioPersistenceImpl
 * @see Resposta_UsuarioUtil
 * @generated
 */
public interface Resposta_UsuarioPersistence extends BasePersistence<Resposta_Usuario> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Resposta_UsuarioUtil} to access the resposta_ usuario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the resposta_ usuario in the entity cache if it is enabled.
	*
	* @param resposta_Usuario the resposta_ usuario
	*/
	public void cacheResult(
		br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario resposta_Usuario);

	/**
	* Caches the resposta_ usuarios in the entity cache if it is enabled.
	*
	* @param resposta_Usuarios the resposta_ usuarios
	*/
	public void cacheResult(
		java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> resposta_Usuarios);

	/**
	* Creates a new resposta_ usuario with the primary key. Does not add the resposta_ usuario to the database.
	*
	* @param id the primary key for the new resposta_ usuario
	* @return the new resposta_ usuario
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario create(
		long id);

	/**
	* Removes the resposta_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the resposta_ usuario
	* @return the resposta_ usuario that was removed
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario remove(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario resposta_Usuario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resposta_ usuario with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException} if it could not be found.
	*
	* @param id the primary key of the resposta_ usuario
	* @return the resposta_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resposta_ usuario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the resposta_ usuario
	* @return the resposta_ usuario, or <code>null</code> if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the resposta_ usuarios where testeUsuarioId = &#63;.
	*
	* @param testeUsuarioId the teste usuario ID
	* @return the matching resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> findByTesteUsuario(
		long testeUsuarioId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the resposta_ usuarios where testeUsuarioId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param testeUsuarioId the teste usuario ID
	* @param start the lower bound of the range of resposta_ usuarios
	* @param end the upper bound of the range of resposta_ usuarios (not inclusive)
	* @return the range of matching resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> findByTesteUsuario(
		long testeUsuarioId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the resposta_ usuarios where testeUsuarioId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param testeUsuarioId the teste usuario ID
	* @param start the lower bound of the range of resposta_ usuarios
	* @param end the upper bound of the range of resposta_ usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> findByTesteUsuario(
		long testeUsuarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	*
	* @param testeUsuarioId the teste usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resposta_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a matching resposta_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario findByTesteUsuario_First(
		long testeUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	*
	* @param testeUsuarioId the teste usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resposta_ usuario, or <code>null</code> if a matching resposta_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario fetchByTesteUsuario_First(
		long testeUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	*
	* @param testeUsuarioId the teste usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resposta_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a matching resposta_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario findByTesteUsuario_Last(
		long testeUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	*
	* @param testeUsuarioId the teste usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resposta_ usuario, or <code>null</code> if a matching resposta_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario fetchByTesteUsuario_Last(
		long testeUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resposta_ usuarios before and after the current resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	*
	* @param id the primary key of the current resposta_ usuario
	* @param testeUsuarioId the teste usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next resposta_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario[] findByTesteUsuario_PrevAndNext(
		long id, long testeUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the resposta_ usuarios.
	*
	* @return the resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the resposta_ usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resposta_ usuarios
	* @param end the upper bound of the range of resposta_ usuarios (not inclusive)
	* @return the range of resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the resposta_ usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resposta_ usuarios
	* @param end the upper bound of the range of resposta_ usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the resposta_ usuarios where testeUsuarioId = &#63; from the database.
	*
	* @param testeUsuarioId the teste usuario ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTesteUsuario(long testeUsuarioId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the resposta_ usuarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of resposta_ usuarios where testeUsuarioId = &#63;.
	*
	* @param testeUsuarioId the teste usuario ID
	* @return the number of matching resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByTesteUsuario(long testeUsuarioId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of resposta_ usuarios.
	*
	* @return the number of resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}