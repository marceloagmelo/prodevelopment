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

import br.com.prodevelopment.testeconhecimento.NoSuchRespostaException;
import br.com.prodevelopment.testeconhecimento.model.Resposta;
import br.com.prodevelopment.testeconhecimento.model.impl.RespostaImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.RespostaModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the resposta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see RespostaPersistence
 * @see RespostaUtil
 * @generated
 */
public class RespostaPersistenceImpl extends BasePersistenceImpl<Resposta>
	implements RespostaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RespostaUtil} to access the resposta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RespostaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERGUNTA = new FinderPath(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaModelImpl.FINDER_CACHE_ENABLED, RespostaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPergunta",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERGUNTA =
		new FinderPath(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaModelImpl.FINDER_CACHE_ENABLED, RespostaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPergunta",
			new String[] { Long.class.getName() },
			RespostaModelImpl.PERGUNTAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERGUNTA = new FinderPath(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPergunta",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaModelImpl.FINDER_CACHE_ENABLED, RespostaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaModelImpl.FINDER_CACHE_ENABLED, RespostaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the resposta in the entity cache if it is enabled.
	 *
	 * @param resposta the resposta
	 */
	public void cacheResult(Resposta resposta) {
		EntityCacheUtil.putResult(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaImpl.class, resposta.getPrimaryKey(), resposta);

		resposta.resetOriginalValues();
	}

	/**
	 * Caches the respostas in the entity cache if it is enabled.
	 *
	 * @param respostas the respostas
	 */
	public void cacheResult(List<Resposta> respostas) {
		for (Resposta resposta : respostas) {
			if (EntityCacheUtil.getResult(
						RespostaModelImpl.ENTITY_CACHE_ENABLED,
						RespostaImpl.class, resposta.getPrimaryKey()) == null) {
				cacheResult(resposta);
			}
			else {
				resposta.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all respostas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RespostaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RespostaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the resposta.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Resposta resposta) {
		EntityCacheUtil.removeResult(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaImpl.class, resposta.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Resposta> respostas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Resposta resposta : respostas) {
			EntityCacheUtil.removeResult(RespostaModelImpl.ENTITY_CACHE_ENABLED,
				RespostaImpl.class, resposta.getPrimaryKey());
		}
	}

	/**
	 * Creates a new resposta with the primary key. Does not add the resposta to the database.
	 *
	 * @param id the primary key for the new resposta
	 * @return the new resposta
	 */
	public Resposta create(long id) {
		Resposta resposta = new RespostaImpl();

		resposta.setNew(true);
		resposta.setPrimaryKey(id);

		return resposta;
	}

	/**
	 * Removes the resposta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the resposta
	 * @return the resposta that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException if a resposta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta remove(long id)
		throws NoSuchRespostaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the resposta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resposta
	 * @return the resposta that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException if a resposta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Resposta remove(Serializable primaryKey)
		throws NoSuchRespostaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Resposta resposta = (Resposta)session.get(RespostaImpl.class,
					primaryKey);

			if (resposta == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRespostaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(resposta);
		}
		catch (NoSuchRespostaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Resposta removeImpl(Resposta resposta) throws SystemException {
		resposta = toUnwrappedModel(resposta);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, resposta);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(resposta);

		return resposta;
	}

	@Override
	public Resposta updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Resposta resposta,
		boolean merge) throws SystemException {
		resposta = toUnwrappedModel(resposta);

		boolean isNew = resposta.isNew();

		RespostaModelImpl respostaModelImpl = (RespostaModelImpl)resposta;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, resposta, merge);

			resposta.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RespostaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((respostaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERGUNTA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(respostaModelImpl.getOriginalPerguntaId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERGUNTA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERGUNTA,
					args);

				args = new Object[] {
						Long.valueOf(respostaModelImpl.getPerguntaId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERGUNTA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERGUNTA,
					args);
			}
		}

		EntityCacheUtil.putResult(RespostaModelImpl.ENTITY_CACHE_ENABLED,
			RespostaImpl.class, resposta.getPrimaryKey(), resposta);

		return resposta;
	}

	protected Resposta toUnwrappedModel(Resposta resposta) {
		if (resposta instanceof RespostaImpl) {
			return resposta;
		}

		RespostaImpl respostaImpl = new RespostaImpl();

		respostaImpl.setNew(resposta.isNew());
		respostaImpl.setPrimaryKey(resposta.getPrimaryKey());

		respostaImpl.setId(resposta.getId());
		respostaImpl.setDescricao(resposta.getDescricao());
		respostaImpl.setCorreta(resposta.isCorreta());
		respostaImpl.setDataInclusao(resposta.getDataInclusao());
		respostaImpl.setDataAlteracao(resposta.getDataAlteracao());
		respostaImpl.setPerguntaId(resposta.getPerguntaId());
		respostaImpl.setUserIdInclusao(resposta.getUserIdInclusao());
		respostaImpl.setUserIdAlteracao(resposta.getUserIdAlteracao());

		return respostaImpl;
	}

	/**
	 * Returns the resposta with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the resposta
	 * @return the resposta
	 * @throws com.liferay.portal.NoSuchModelException if a resposta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Resposta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the resposta with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchRespostaException} if it could not be found.
	 *
	 * @param id the primary key of the resposta
	 * @return the resposta
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchRespostaException if a resposta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta findByPrimaryKey(long id)
		throws NoSuchRespostaException, SystemException {
		Resposta resposta = fetchByPrimaryKey(id);

		if (resposta == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchRespostaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return resposta;
	}

	/**
	 * Returns the resposta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resposta
	 * @return the resposta, or <code>null</code> if a resposta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Resposta fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the resposta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the resposta
	 * @return the resposta, or <code>null</code> if a resposta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta fetchByPrimaryKey(long id) throws SystemException {
		Resposta resposta = (Resposta)EntityCacheUtil.getResult(RespostaModelImpl.ENTITY_CACHE_ENABLED,
				RespostaImpl.class, id);

		if (resposta == _nullResposta) {
			return null;
		}

		if (resposta == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				resposta = (Resposta)session.get(RespostaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (resposta != null) {
					cacheResult(resposta);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RespostaModelImpl.ENTITY_CACHE_ENABLED,
						RespostaImpl.class, id, _nullResposta);
				}

				closeSession(session);
			}
		}

		return resposta;
	}

	/**
	 * Returns all the respostas where perguntaId = &#63;.
	 *
	 * @param perguntaId the pergunta ID
	 * @return the matching respostas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Resposta> findByPergunta(long perguntaId)
		throws SystemException {
		return findByPergunta(perguntaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<Resposta> findByPergunta(long perguntaId, int start, int end)
		throws SystemException {
		return findByPergunta(perguntaId, start, end, null);
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
	public List<Resposta> findByPergunta(long perguntaId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERGUNTA;
			finderArgs = new Object[] { perguntaId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERGUNTA;
			finderArgs = new Object[] { perguntaId, start, end, orderByComparator };
		}

		List<Resposta> list = (List<Resposta>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Resposta resposta : list) {
				if ((perguntaId != resposta.getPerguntaId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RESPOSTA_WHERE);

			query.append(_FINDER_COLUMN_PERGUNTA_PERGUNTAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RespostaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perguntaId);

				list = (List<Resposta>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Resposta findByPergunta_First(long perguntaId,
		OrderByComparator orderByComparator)
		throws NoSuchRespostaException, SystemException {
		Resposta resposta = fetchByPergunta_First(perguntaId, orderByComparator);

		if (resposta != null) {
			return resposta;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perguntaId=");
		msg.append(perguntaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRespostaException(msg.toString());
	}

	/**
	 * Returns the first resposta in the ordered set where perguntaId = &#63;.
	 *
	 * @param perguntaId the pergunta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resposta, or <code>null</code> if a matching resposta could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta fetchByPergunta_First(long perguntaId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Resposta> list = findByPergunta(perguntaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Resposta findByPergunta_Last(long perguntaId,
		OrderByComparator orderByComparator)
		throws NoSuchRespostaException, SystemException {
		Resposta resposta = fetchByPergunta_Last(perguntaId, orderByComparator);

		if (resposta != null) {
			return resposta;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perguntaId=");
		msg.append(perguntaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRespostaException(msg.toString());
	}

	/**
	 * Returns the last resposta in the ordered set where perguntaId = &#63;.
	 *
	 * @param perguntaId the pergunta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resposta, or <code>null</code> if a matching resposta could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta fetchByPergunta_Last(long perguntaId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPergunta(perguntaId);

		List<Resposta> list = findByPergunta(perguntaId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Resposta[] findByPergunta_PrevAndNext(long id, long perguntaId,
		OrderByComparator orderByComparator)
		throws NoSuchRespostaException, SystemException {
		Resposta resposta = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Resposta[] array = new RespostaImpl[3];

			array[0] = getByPergunta_PrevAndNext(session, resposta, perguntaId,
					orderByComparator, true);

			array[1] = resposta;

			array[2] = getByPergunta_PrevAndNext(session, resposta, perguntaId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Resposta getByPergunta_PrevAndNext(Session session,
		Resposta resposta, long perguntaId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESPOSTA_WHERE);

		query.append(_FINDER_COLUMN_PERGUNTA_PERGUNTAID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(RespostaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(perguntaId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(resposta);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Resposta> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the respostas.
	 *
	 * @return the respostas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Resposta> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Resposta> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Resposta> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Resposta> list = (List<Resposta>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESPOSTA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESPOSTA.concat(RespostaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Resposta>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Resposta>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the respostas where perguntaId = &#63; from the database.
	 *
	 * @param perguntaId the pergunta ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPergunta(long perguntaId) throws SystemException {
		for (Resposta resposta : findByPergunta(perguntaId)) {
			remove(resposta);
		}
	}

	/**
	 * Removes all the respostas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Resposta resposta : findAll()) {
			remove(resposta);
		}
	}

	/**
	 * Returns the number of respostas where perguntaId = &#63;.
	 *
	 * @param perguntaId the pergunta ID
	 * @return the number of matching respostas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPergunta(long perguntaId) throws SystemException {
		Object[] finderArgs = new Object[] { perguntaId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PERGUNTA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESPOSTA_WHERE);

			query.append(_FINDER_COLUMN_PERGUNTA_PERGUNTAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perguntaId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PERGUNTA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of respostas.
	 *
	 * @return the number of respostas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESPOSTA);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the resposta persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.testeconhecimento.model.Resposta")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Resposta>> listenersList = new ArrayList<ModelListener<Resposta>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Resposta>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(RespostaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PerguntaPersistence.class)
	protected PerguntaPersistence perguntaPersistence;
	@BeanReference(type = RespostaPersistence.class)
	protected RespostaPersistence respostaPersistence;
	@BeanReference(type = Resposta_UsuarioPersistence.class)
	protected Resposta_UsuarioPersistence resposta_UsuarioPersistence;
	@BeanReference(type = TestePersistence.class)
	protected TestePersistence testePersistence;
	@BeanReference(type = Teste_UsuarioPersistence.class)
	protected Teste_UsuarioPersistence teste_UsuarioPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_RESPOSTA = "SELECT resposta FROM Resposta resposta";
	private static final String _SQL_SELECT_RESPOSTA_WHERE = "SELECT resposta FROM Resposta resposta WHERE ";
	private static final String _SQL_COUNT_RESPOSTA = "SELECT COUNT(resposta) FROM Resposta resposta";
	private static final String _SQL_COUNT_RESPOSTA_WHERE = "SELECT COUNT(resposta) FROM Resposta resposta WHERE ";
	private static final String _FINDER_COLUMN_PERGUNTA_PERGUNTAID_2 = "resposta.perguntaId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "resposta.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Resposta exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Resposta exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RespostaPersistenceImpl.class);
	private static Resposta _nullResposta = new RespostaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Resposta> toCacheModel() {
				return _nullRespostaCacheModel;
			}
		};

	private static CacheModel<Resposta> _nullRespostaCacheModel = new CacheModel<Resposta>() {
			public Resposta toEntityModel() {
				return _nullResposta;
			}
		};
}