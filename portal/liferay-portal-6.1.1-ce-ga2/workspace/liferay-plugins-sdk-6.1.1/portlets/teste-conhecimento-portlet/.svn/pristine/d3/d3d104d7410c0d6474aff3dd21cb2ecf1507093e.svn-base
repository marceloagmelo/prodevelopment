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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the pergunta service. This utility wraps {@link PerguntaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see PerguntaPersistence
 * @see PerguntaPersistenceImpl
 * @generated
 */
public class PerguntaUtil {
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
	public static void clearCache(Pergunta pergunta) {
		getPersistence().clearCache(pergunta);
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
	public static List<Pergunta> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Pergunta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Pergunta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Pergunta update(Pergunta pergunta, boolean merge)
		throws SystemException {
		return getPersistence().update(pergunta, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Pergunta update(Pergunta pergunta, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(pergunta, merge, serviceContext);
	}

	/**
	* Caches the pergunta in the entity cache if it is enabled.
	*
	* @param pergunta the pergunta
	*/
	public static void cacheResult(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta) {
		getPersistence().cacheResult(pergunta);
	}

	/**
	* Caches the perguntas in the entity cache if it is enabled.
	*
	* @param perguntas the perguntas
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> perguntas) {
		getPersistence().cacheResult(perguntas);
	}

	/**
	* Creates a new pergunta with the primary key. Does not add the pergunta to the database.
	*
	* @param id the primary key for the new pergunta
	* @return the new pergunta
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the pergunta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the pergunta
	* @return the pergunta that was removed
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta remove(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static br.com.prodevelopment.testeconhecimento.model.Pergunta updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(pergunta, merge);
	}

	/**
	* Returns the pergunta with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException} if it could not be found.
	*
	* @param id the primary key of the pergunta
	* @return the pergunta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the pergunta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the pergunta
	* @return the pergunta, or <code>null</code> if a pergunta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the perguntas where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @return the matching perguntas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findByTeste(
		long testeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTeste(testeId);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findByTeste(
		long testeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTeste(testeId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findByTeste(
		long testeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTeste(testeId, start, end, orderByComparator);
	}

	/**
	* Returns the first pergunta in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pergunta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a matching pergunta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta findByTeste_First(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTeste_First(testeId, orderByComparator);
	}

	/**
	* Returns the first pergunta in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pergunta, or <code>null</code> if a matching pergunta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta fetchByTeste_First(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTeste_First(testeId, orderByComparator);
	}

	/**
	* Returns the last pergunta in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pergunta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a matching pergunta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta findByTeste_Last(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTeste_Last(testeId, orderByComparator);
	}

	/**
	* Returns the last pergunta in the ordered set where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pergunta, or <code>null</code> if a matching pergunta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta fetchByTeste_Last(
		long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTeste_Last(testeId, orderByComparator);
	}

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
	public static br.com.prodevelopment.testeconhecimento.model.Pergunta[] findByTeste_PrevAndNext(
		long id, long testeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTeste_PrevAndNext(id, testeId, orderByComparator);
	}

	/**
	* Returns all the perguntas.
	*
	* @return the perguntas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Pergunta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the perguntas where testeId = &#63; from the database.
	*
	* @param testeId the teste ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTeste(long testeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTeste(testeId);
	}

	/**
	* Removes all the perguntas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of perguntas where testeId = &#63;.
	*
	* @param testeId the teste ID
	* @return the number of matching perguntas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTeste(long testeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTeste(testeId);
	}

	/**
	* Returns the number of perguntas.
	*
	* @return the number of perguntas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PerguntaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PerguntaPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.testeconhecimento.service.ClpSerializer.getServletContextName(),
					PerguntaPersistence.class.getName());

			ReferenceRegistry.registerReference(PerguntaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PerguntaPersistence persistence) {
	}

	private static PerguntaPersistence _persistence;
}