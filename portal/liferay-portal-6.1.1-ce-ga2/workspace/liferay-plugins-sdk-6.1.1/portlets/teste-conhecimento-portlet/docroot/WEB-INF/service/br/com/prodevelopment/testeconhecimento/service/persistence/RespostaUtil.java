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

import br.com.prodevelopment.testeconhecimento.model.Resposta;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the resposta service. This utility wraps {@link RespostaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see RespostaPersistence
 * @see RespostaPersistenceImpl
 * @generated
 */
public class RespostaUtil {
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
	public static void clearCache(Resposta resposta) {
		getPersistence().clearCache(resposta);
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
	public static List<Resposta> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Resposta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Resposta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Resposta update(Resposta resposta, boolean merge)
		throws SystemException {
		return getPersistence().update(resposta, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Resposta update(Resposta resposta, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(resposta, merge, serviceContext);
	}

	/**
	* Caches the resposta in the entity cache if it is enabled.
	*
	* @param resposta the resposta
	*/
	public static void cacheResult(
		br.com.prodevelopment.testeconhecimento.model.Resposta resposta) {
		getPersistence().cacheResult(resposta);
	}

	/**
	* Caches the respostas in the entity cache if it is enabled.
	*
	* @param respostas the respostas
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta> respostas) {
		getPersistence().cacheResult(respostas);
	}

	/**
	* Creates a new resposta with the primary key. Does not add the resposta to the database.
	*
	* @param id the primary key for the new resposta
	* @return the new resposta
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the resposta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the resposta
	* @return the resposta that was removed
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta remove(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static br.com.prodevelopment.testeconhecimento.model.Resposta updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Resposta resposta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(resposta, merge);
	}

	/**
	* Returns the resposta with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchRespostaException} if it could not be found.
	*
	* @param id the primary key of the resposta
	* @return the resposta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta findByPrimaryKey(
		long id)
		throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the resposta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the resposta
	* @return the resposta, or <code>null</code> if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the respostas where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @return the matching respostas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta> findByPergunta(
		long perguntaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPergunta(perguntaId);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta> findByPergunta(
		long perguntaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPergunta(perguntaId, start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta> findByPergunta(
		long perguntaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPergunta(perguntaId, start, end, orderByComparator);
	}

	/**
	* Returns the first resposta in the ordered set where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resposta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException if a matching resposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta findByPergunta_First(
		long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPergunta_First(perguntaId, orderByComparator);
	}

	/**
	* Returns the first resposta in the ordered set where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resposta, or <code>null</code> if a matching resposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta fetchByPergunta_First(
		long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPergunta_First(perguntaId, orderByComparator);
	}

	/**
	* Returns the last resposta in the ordered set where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resposta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException if a matching resposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta findByPergunta_Last(
		long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPergunta_Last(perguntaId, orderByComparator);
	}

	/**
	* Returns the last resposta in the ordered set where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resposta, or <code>null</code> if a matching resposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta fetchByPergunta_Last(
		long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPergunta_Last(perguntaId, orderByComparator);
	}

	/**
	* Returns the respostas before and after the current resposta in the ordered set where perguntaId = &#63;.
	*
	* @param id the primary key of the current resposta
	* @param perguntaId the pergunta ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next resposta
	* @throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException if a resposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.testeconhecimento.model.Resposta[] findByPergunta_PrevAndNext(
		long id, long perguntaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPergunta_PrevAndNext(id, perguntaId, orderByComparator);
	}

	/**
	* Returns all the respostas.
	*
	* @return the respostas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.prodevelopment.testeconhecimento.model.Resposta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the respostas where perguntaId = &#63; from the database.
	*
	* @param perguntaId the pergunta ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPergunta(long perguntaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPergunta(perguntaId);
	}

	/**
	* Removes all the respostas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of respostas where perguntaId = &#63;.
	*
	* @param perguntaId the pergunta ID
	* @return the number of matching respostas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPergunta(long perguntaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPergunta(perguntaId);
	}

	/**
	* Returns the number of respostas.
	*
	* @return the number of respostas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RespostaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RespostaPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.testeconhecimento.service.ClpSerializer.getServletContextName(),
					RespostaPersistence.class.getName());

			ReferenceRegistry.registerReference(RespostaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(RespostaPersistence persistence) {
	}

	private static RespostaPersistence _persistence;
}