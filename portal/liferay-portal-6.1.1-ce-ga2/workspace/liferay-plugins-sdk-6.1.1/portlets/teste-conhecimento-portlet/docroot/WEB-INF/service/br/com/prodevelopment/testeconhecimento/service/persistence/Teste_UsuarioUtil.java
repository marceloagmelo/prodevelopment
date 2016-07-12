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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the teste_ usuario service. This utility wraps {@link Teste_UsuarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see Teste_UsuarioPersistence
 * @see Teste_UsuarioPersistenceImpl
 * @generated
 */
public class Teste_UsuarioUtil {
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
	public static void clearCache(Teste_Usuario teste_Usuario) {
		getPersistence().clearCache(teste_Usuario);
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
	public static List<Teste_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Teste_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Teste_Usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Teste_Usuario update(Teste_Usuario teste_Usuario,
		boolean merge) throws SystemException {
		return getPersistence().update(teste_Usuario, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Teste_Usuario update(Teste_Usuario teste_Usuario,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(teste_Usuario, merge, serviceContext);
	}

	/**
	* Caches the teste_ usuario in the entity cache if it is enabled.
	*
	* @param teste_Usuario the teste_ usuario
	*/
	public static void cacheResult(
		br.com.prodevelopment.testeconhecimento.model.Teste_Usuario teste_Usuario) {
		getPersistence().cacheResult(teste_Usuario);
	}

	/**
	* Caches the teste_ usuarios in the entity cache if it is enabled.
	*
	* @param teste_Usuarios the teste_ usuarios
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> teste_Usuarios) {
		getPersistence().cacheResult(teste_Usuarios);
	}

	/**
	* Creates a new teste_ usuario with the primary key. Does not add the teste_ usuario to the database.
	*
	* @param id the primary key for the new teste_ usuario
	* @return the new teste_ usuario
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the teste_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the teste_ usuario
	* @return the teste_ usuario that was removed
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a teste_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario remove(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Teste_Usuario teste_Usuario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(teste_Usuario, merge);
	}

	/**
	* Returns the teste_ usuario with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException} if it could not be found.
	*
	* @param id the primary key of the teste_ usuario
	* @return the teste_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a teste_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the teste_ usuario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the teste_ usuario
	* @return the teste_ usuario, or <code>null</code> if a teste_ usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the teste_ usuarios where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @return the matching teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findByTeste(
		long testeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTeste(testeId);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findByTeste(
		long testeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTeste(testeId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findByTeste(
		long testeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTeste(testeId, start, end, orderByComparator);
	}

	/**
	* Returns the first teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a matching teste_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario findByTeste_First(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTeste_First(testeId, orderByComparator);
	}

	/**
	* Returns the first teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching teste_ usuario, or <code>null</code> if a matching teste_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario fetchByTeste_First(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTeste_First(testeId, orderByComparator);
	}

	/**
	* Returns the last teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste_ usuario
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a matching teste_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario findByTeste_Last(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTeste_Last(testeId, orderByComparator);
	}

	/**
	* Returns the last teste_ usuario in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching teste_ usuario, or <code>null</code> if a matching teste_ usuario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario fetchByTeste_Last(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTeste_Last(testeId, orderByComparator);
	}

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
	public static br.com.prodevelopment.testeconhecimento.model.Teste_Usuario[] findByTeste_PrevAndNext(
		long id, long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTeste_PrevAndNext(id, testeId, orderByComparator);
	}

	/**
	* Returns all the teste_ usuarios.
	*
	* @return the teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Teste_Usuario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the teste_ usuarios where testeId = &#63; from the database.
	*
	* @param testeId the teste ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTeste(long testeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTeste(testeId);
	}

	/**
	* Removes all the teste_ usuarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of teste_ usuarios where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @return the number of matching teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTeste(long testeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTeste(testeId);
	}

	/**
	* Returns the number of teste_ usuarios.
	*
	* @return the number of teste_ usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Teste_UsuarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Teste_UsuarioPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.testeconhecimento.service.ClpSerializer.getServletContextName(),
					Teste_UsuarioPersistence.class.getName());

			ReferenceRegistry.registerReference(Teste_UsuarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(Teste_UsuarioPersistence persistence) {
	}

	private static Teste_UsuarioPersistence _persistence;
}