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

import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the pesquisa_ usuario service. This utility wraps {@link Pesquisa_UsuarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see Pesquisa_UsuarioPersistence
 * @see Pesquisa_UsuarioPersistenceImpl
 * @generated
 */
public class Pesquisa_UsuarioUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Pesquisa_Usuario pesquisa_Usuario) {
		getPersistence().clearCache(pesquisa_Usuario);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Pesquisa_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Pesquisa_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Pesquisa_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Pesquisa_Usuario update(Pesquisa_Usuario pesquisa_Usuario,
		boolean merge) throws SystemException {
		return getPersistence().update(pesquisa_Usuario, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Pesquisa_Usuario update(Pesquisa_Usuario pesquisa_Usuario,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(pesquisa_Usuario, merge, serviceContext);
	}

	/**
	* Caches the pesquisa_ usuario in the entity cache if it is enabled.
	*
	* @param pesquisa_Usuario the pesquisa_ usuario
	*/
	public static void cacheResult(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario pesquisa_Usuario) {
		getPersistence().cacheResult(pesquisa_Usuario);
	}

	/**
	* Caches the pesquisa_ usuarios in the entity cache if it is enabled.
	*
	* @param pesquisa_Usuarios the pesquisa_ usuarios
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario> pesquisa_Usuarios) {
		getPersistence().cacheResult(pesquisa_Usuarios);
	}

	/**
	* Creates a new pesquisa_ usuario with the primary key. Does not add the pesquisa_ usuario to the database.
	*
	* @param id the primary key for the new pesquisa_ usuario
	* @return the new pesquisa_ usuario
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the pesquisa_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the pesquisa_ usuario
	* @return the pesquisa_ usuario that was removed
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a pesquisa_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario remove(
		long id)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario updateImpl(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario pesquisa_Usuario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(pesquisa_Usuario, merge);
	}

	/**
	* Returns the pesquisa_ usuario with the primary key or throws a {@link br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException} if it could not be found.
	*
	* @param id the primary key of the pesquisa_ usuario
	* @return the pesquisa_ usuario
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a pesquisa_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the pesquisa_ usuario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the pesquisa_ usuario
	* @return the pesquisa_ usuario, or <code>null</code> if a pesquisa_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the pesquisa_ usuarios where pesquisaId = &#63;.
	*
	* @param pesquisaId the pesquisa ID
	* @return the matching pesquisa_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario> findByPesquisaId(
		long pesquisaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPesquisaId(pesquisaId);
	}

	/**
	* Returns a range of all the pesquisa_ usuarios where pesquisaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pesquisaId the pesquisa ID
	* @param start the lower bound of the range of pesquisa_ usuarios
	* @param end the upper bound of the range of pesquisa_ usuarios (not inclusive)
	* @return the range of matching pesquisa_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario> findByPesquisaId(
		long pesquisaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPesquisaId(pesquisaId, start, end);
	}

	/**
	* Returns an ordered range of all the pesquisa_ usuarios where pesquisaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pesquisaId the pesquisa ID
	* @param start the lower bound of the range of pesquisa_ usuarios
	* @param end the upper bound of the range of pesquisa_ usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pesquisa_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario> findByPesquisaId(
		long pesquisaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaId(pesquisaId, start, end, orderByComparator);
	}

	/**
	* Returns the first pesquisa_ usuario in the ordered set where pesquisaId = &#63;.
	*
	* @param pesquisaId the pesquisa ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa_ usuario
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a matching pesquisa_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario findByPesquisaId_First(
		long pesquisaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaId_First(pesquisaId, orderByComparator);
	}

	/**
	* Returns the first pesquisa_ usuario in the ordered set where pesquisaId = &#63;.
	*
	* @param pesquisaId the pesquisa ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pesquisa_ usuario, or <code>null</code> if a matching pesquisa_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario fetchByPesquisaId_First(
		long pesquisaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPesquisaId_First(pesquisaId, orderByComparator);
	}

	/**
	* Returns the last pesquisa_ usuario in the ordered set where pesquisaId = &#63;.
	*
	* @param pesquisaId the pesquisa ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa_ usuario
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a matching pesquisa_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario findByPesquisaId_Last(
		long pesquisaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaId_Last(pesquisaId, orderByComparator);
	}

	/**
	* Returns the last pesquisa_ usuario in the ordered set where pesquisaId = &#63;.
	*
	* @param pesquisaId the pesquisa ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pesquisa_ usuario, or <code>null</code> if a matching pesquisa_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario fetchByPesquisaId_Last(
		long pesquisaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPesquisaId_Last(pesquisaId, orderByComparator);
	}

	/**
	* Returns the pesquisa_ usuarios before and after the current pesquisa_ usuario in the ordered set where pesquisaId = &#63;.
	*
	* @param id the primary key of the current pesquisa_ usuario
	* @param pesquisaId the pesquisa ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pesquisa_ usuario
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a pesquisa_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario[] findByPesquisaId_PrevAndNext(
		long id, long pesquisaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaId_PrevAndNext(id, pesquisaId,
			orderByComparator);
	}

	/**
	* Returns all the pesquisa_ usuarios.
	*
	* @return the pesquisa_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the pesquisa_ usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pesquisa_ usuarios
	* @param end the upper bound of the range of pesquisa_ usuarios (not inclusive)
	* @return the range of pesquisa_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the pesquisa_ usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pesquisa_ usuarios
	* @param end the upper bound of the range of pesquisa_ usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pesquisa_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the pesquisa_ usuarios where pesquisaId = &#63; from the database.
	*
	* @param pesquisaId the pesquisa ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPesquisaId(long pesquisaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPesquisaId(pesquisaId);
	}

	/**
	* Removes all the pesquisa_ usuarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of pesquisa_ usuarios where pesquisaId = &#63;.
	*
	* @param pesquisaId the pesquisa ID
	* @return the number of matching pesquisa_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPesquisaId(long pesquisaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPesquisaId(pesquisaId);
	}

	/**
	* Returns the number of pesquisa_ usuarios.
	*
	* @return the number of pesquisa_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Pesquisa_UsuarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Pesquisa_UsuarioPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.pesquisaopiniao.service.ClpSerializer.getServletContextName(),
					Pesquisa_UsuarioPersistence.class.getName());

			ReferenceRegistry.registerReference(Pesquisa_UsuarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(Pesquisa_UsuarioPersistence persistence) {
	}

	private static Pesquisa_UsuarioPersistence _persistence;
}