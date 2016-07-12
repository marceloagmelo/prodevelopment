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

import br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the resposta_ usuario service. This utility wraps {@link Resposta_UsuarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see Resposta_UsuarioPersistence
 * @see Resposta_UsuarioPersistenceImpl
 * @generated
 */
public class Resposta_UsuarioUtil {
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
	public static void clearCache(Resposta_Usuario resposta_Usuario) {
		getPersistence().clearCache(resposta_Usuario);
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
	public static List<Resposta_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Resposta_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Resposta_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Resposta_Usuario update(Resposta_Usuario resposta_Usuario,
		boolean merge) throws SystemException {
		return getPersistence().update(resposta_Usuario, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Resposta_Usuario update(Resposta_Usuario resposta_Usuario,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(resposta_Usuario, merge, serviceContext);
	}

	/**
	* Caches the resposta_ usuario in the entity cache if it is enabled.
	*
	* @param resposta_Usuario the resposta_ usuario
	*/
	public static void cacheResult(
		br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario resposta_Usuario) {
		getPersistence().cacheResult(resposta_Usuario);
	}

	/**
	* Caches the resposta_ usuarios in the entity cache if it is enabled.
	*
	* @param resposta_Usuarios the resposta_ usuarios
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario> resposta_Usuarios) {
		getPersistence().cacheResult(resposta_Usuarios);
	}

	/**
	* Creates a new resposta_ usuario with the primary key. Does not add the resposta_ usuario to the database.
	*
	* @param id the primary key for the new resposta_ usuario
	* @return the new resposta_ usuario
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the resposta_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the resposta_ usuario
	* @return the resposta_ usuario that was removed
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario remove(
		long id)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario updateImpl(
		br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario resposta_Usuario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(resposta_Usuario, merge);
	}

	/**
	* Returns the resposta_ usuario with the primary key or throws a {@link br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException} if it could not be found.
	*
	* @param id the primary key of the resposta_ usuario
	* @return the resposta_ usuario
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the resposta_ usuario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the resposta_ usuario
	* @return the resposta_ usuario, or <code>null</code> if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the resposta_ usuarios where pesquisaUsuarioId = &#63;.
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @return the matching resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario> findByPesquisaUsuarioId(
		long pesquisaUsuarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPesquisaUsuarioId(pesquisaUsuarioId);
	}

	/**
	* Returns a range of all the resposta_ usuarios where pesquisaUsuarioId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @param start the lower bound of the range of resposta_ usuarios
	* @param end the upper bound of the range of resposta_ usuarios (not inclusive)
	* @return the range of matching resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario> findByPesquisaUsuarioId(
		long pesquisaUsuarioId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaUsuarioId(pesquisaUsuarioId, start, end);
	}

	/**
	* Returns an ordered range of all the resposta_ usuarios where pesquisaUsuarioId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @param start the lower bound of the range of resposta_ usuarios
	* @param end the upper bound of the range of resposta_ usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario> findByPesquisaUsuarioId(
		long pesquisaUsuarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaUsuarioId(pesquisaUsuarioId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first resposta_ usuario in the ordered set where pesquisaUsuarioId = &#63;.
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resposta_ usuario
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException if a matching resposta_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario findByPesquisaUsuarioId_First(
		long pesquisaUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaUsuarioId_First(pesquisaUsuarioId,
			orderByComparator);
	}

	/**
	* Returns the first resposta_ usuario in the ordered set where pesquisaUsuarioId = &#63;.
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resposta_ usuario, or <code>null</code> if a matching resposta_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario fetchByPesquisaUsuarioId_First(
		long pesquisaUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPesquisaUsuarioId_First(pesquisaUsuarioId,
			orderByComparator);
	}

	/**
	* Returns the last resposta_ usuario in the ordered set where pesquisaUsuarioId = &#63;.
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resposta_ usuario
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException if a matching resposta_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario findByPesquisaUsuarioId_Last(
		long pesquisaUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaUsuarioId_Last(pesquisaUsuarioId,
			orderByComparator);
	}

	/**
	* Returns the last resposta_ usuario in the ordered set where pesquisaUsuarioId = &#63;.
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resposta_ usuario, or <code>null</code> if a matching resposta_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario fetchByPesquisaUsuarioId_Last(
		long pesquisaUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPesquisaUsuarioId_Last(pesquisaUsuarioId,
			orderByComparator);
	}

	/**
	* Returns the resposta_ usuarios before and after the current resposta_ usuario in the ordered set where pesquisaUsuarioId = &#63;.
	*
	* @param id the primary key of the current resposta_ usuario
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next resposta_ usuario
	* @throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario[] findByPesquisaUsuarioId_PrevAndNext(
		long id, long pesquisaUsuarioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPesquisaUsuarioId_PrevAndNext(id, pesquisaUsuarioId,
			orderByComparator);
	}

	/**
	* Returns all the resposta_ usuarios.
	*
	* @return the resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the resposta_ usuarios where pesquisaUsuarioId = &#63; from the database.
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPesquisaUsuarioId(long pesquisaUsuarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPesquisaUsuarioId(pesquisaUsuarioId);
	}

	/**
	* Removes all the resposta_ usuarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of resposta_ usuarios where pesquisaUsuarioId = &#63;.
	*
	* @param pesquisaUsuarioId the pesquisa usuario ID
	* @return the number of matching resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPesquisaUsuarioId(long pesquisaUsuarioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPesquisaUsuarioId(pesquisaUsuarioId);
	}

	/**
	* Returns the number of resposta_ usuarios.
	*
	* @return the number of resposta_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Resposta_UsuarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Resposta_UsuarioPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.pesquisaopiniao.service.ClpSerializer.getServletContextName(),
					Resposta_UsuarioPersistence.class.getName());

			ReferenceRegistry.registerReference(Resposta_UsuarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(Resposta_UsuarioPersistence persistence) {
	}

	private static Resposta_UsuarioPersistence _persistence;
}