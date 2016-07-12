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

import br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException;
import br.com.prodevelopment.testeconhecimento.model.Pergunta;
import br.com.prodevelopment.testeconhecimento.model.impl.PerguntaImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.PerguntaModelImpl;

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
 * The persistence implementation for the pergunta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see PerguntaPersistence
 * @see PerguntaUtil
 * @generated
 */
public class PerguntaPersistenceImpl extends BasePersistenceImpl<Pergunta>
	implements PerguntaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PerguntaUtil} to access the pergunta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PerguntaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TESTE = new FinderPath(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaModelImpl.FINDER_CACHE_ENABLED, PerguntaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTeste",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE = new FinderPath(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaModelImpl.FINDER_CACHE_ENABLED, PerguntaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTeste",
			new String[] { Long.class.getName() },
			PerguntaModelImpl.TESTEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TESTE = new FinderPath(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTeste",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaModelImpl.FINDER_CACHE_ENABLED, PerguntaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaModelImpl.FINDER_CACHE_ENABLED, PerguntaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the pergunta in the entity cache if it is enabled.
	 *
	 * @param pergunta the pergunta
	 */
	public void cacheResult(Pergunta pergunta) {
		EntityCacheUtil.putResult(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaImpl.class, pergunta.getPrimaryKey(), pergunta);

		pergunta.resetOriginalValues();
	}

	/**
	 * Caches the perguntas in the entity cache if it is enabled.
	 *
	 * @param perguntas the perguntas
	 */
	public void cacheResult(List<Pergunta> perguntas) {
		for (Pergunta pergunta : perguntas) {
			if (EntityCacheUtil.getResult(
						PerguntaModelImpl.ENTITY_CACHE_ENABLED,
						PerguntaImpl.class, pergunta.getPrimaryKey()) == null) {
				cacheResult(pergunta);
			}
			else {
				pergunta.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all perguntas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PerguntaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PerguntaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pergunta.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Pergunta pergunta) {
		EntityCacheUtil.removeResult(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaImpl.class, pergunta.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Pergunta> perguntas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Pergunta pergunta : perguntas) {
			EntityCacheUtil.removeResult(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
				PerguntaImpl.class, pergunta.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pergunta with the primary key. Does not add the pergunta to the database.
	 *
	 * @param id the primary key for the new pergunta
	 * @return the new pergunta
	 */
	public Pergunta create(long id) {
		Pergunta pergunta = new PerguntaImpl();

		pergunta.setNew(true);
		pergunta.setPrimaryKey(id);

		return pergunta;
	}

	/**
	 * Removes the pergunta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pergunta
	 * @return the pergunta that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a pergunta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pergunta remove(long id)
		throws NoSuchPerguntaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the pergunta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pergunta
	 * @return the pergunta that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a pergunta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pergunta remove(Serializable primaryKey)
		throws NoSuchPerguntaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Pergunta pergunta = (Pergunta)session.get(PerguntaImpl.class,
					primaryKey);

			if (pergunta == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPerguntaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pergunta);
		}
		catch (NoSuchPerguntaException nsee) {
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
	protected Pergunta removeImpl(Pergunta pergunta) throws SystemException {
		pergunta = toUnwrappedModel(pergunta);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, pergunta);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(pergunta);

		return pergunta;
	}

	@Override
	public Pergunta updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Pergunta pergunta,
		boolean merge) throws SystemException {
		pergunta = toUnwrappedModel(pergunta);

		boolean isNew = pergunta.isNew();

		PerguntaModelImpl perguntaModelImpl = (PerguntaModelImpl)pergunta;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pergunta, merge);

			pergunta.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PerguntaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((perguntaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(perguntaModelImpl.getOriginalTesteId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TESTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE,
					args);

				args = new Object[] { Long.valueOf(perguntaModelImpl.getTesteId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TESTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE,
					args);
			}
		}

		EntityCacheUtil.putResult(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
			PerguntaImpl.class, pergunta.getPrimaryKey(), pergunta);

		return pergunta;
	}

	protected Pergunta toUnwrappedModel(Pergunta pergunta) {
		if (pergunta instanceof PerguntaImpl) {
			return pergunta;
		}

		PerguntaImpl perguntaImpl = new PerguntaImpl();

		perguntaImpl.setNew(pergunta.isNew());
		perguntaImpl.setPrimaryKey(pergunta.getPrimaryKey());

		perguntaImpl.setId(pergunta.getId());
		perguntaImpl.setDescricao(pergunta.getDescricao());
		perguntaImpl.setJustificativaResposta(pergunta.getJustificativaResposta());
		perguntaImpl.setPontuacao(pergunta.getPontuacao());
		perguntaImpl.setDataInclusao(pergunta.getDataInclusao());
		perguntaImpl.setDataAlteracao(pergunta.getDataAlteracao());
		perguntaImpl.setTesteId(pergunta.getTesteId());
		perguntaImpl.setUserIdInclusao(pergunta.getUserIdInclusao());
		perguntaImpl.setUserIdAlteracao(pergunta.getUserIdAlteracao());

		return perguntaImpl;
	}

	/**
	 * Returns the pergunta with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pergunta
	 * @return the pergunta
	 * @throws com.liferay.portal.NoSuchModelException if a pergunta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pergunta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the pergunta with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException} if it could not be found.
	 *
	 * @param id the primary key of the pergunta
	 * @return the pergunta
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a pergunta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pergunta findByPrimaryKey(long id)
		throws NoSuchPerguntaException, SystemException {
		Pergunta pergunta = fetchByPrimaryKey(id);

		if (pergunta == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchPerguntaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return pergunta;
	}

	/**
	 * Returns the pergunta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pergunta
	 * @return the pergunta, or <code>null</code> if a pergunta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pergunta fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the pergunta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pergunta
	 * @return the pergunta, or <code>null</code> if a pergunta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pergunta fetchByPrimaryKey(long id) throws SystemException {
		Pergunta pergunta = (Pergunta)EntityCacheUtil.getResult(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
				PerguntaImpl.class, id);

		if (pergunta == _nullPergunta) {
			return null;
		}

		if (pergunta == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				pergunta = (Pergunta)session.get(PerguntaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (pergunta != null) {
					cacheResult(pergunta);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PerguntaModelImpl.ENTITY_CACHE_ENABLED,
						PerguntaImpl.class, id, _nullPergunta);
				}

				closeSession(session);
			}
		}

		return pergunta;
	}

	/**
	 * Returns all the perguntas where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @return the matching perguntas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pergunta> findByTeste(long testeId) throws SystemException {
		return findByTeste(testeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Pergunta> findByTeste(long testeId, int start, int end)
		throws SystemException {
		return findByTeste(testeId, start, end, null);
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
	public List<Pergunta> findByTeste(long testeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE;
			finderArgs = new Object[] { testeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TESTE;
			finderArgs = new Object[] { testeId, start, end, orderByComparator };
		}

		List<Pergunta> list = (List<Pergunta>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Pergunta pergunta : list) {
				if ((testeId != pergunta.getTesteId())) {
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

			query.append(_SQL_SELECT_PERGUNTA_WHERE);

			query.append(_FINDER_COLUMN_TESTE_TESTEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PerguntaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(testeId);

				list = (List<Pergunta>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first pergunta in the ordered set where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pergunta
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchPerguntaException if a matching pergunta could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pergunta findByTeste_First(long testeId,
		OrderByComparator orderByComparator)
		throws NoSuchPerguntaException, SystemException {
		Pergunta pergunta = fetchByTeste_First(testeId, orderByComparator);

		if (pergunta != null) {
			return pergunta;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("testeId=");
		msg.append(testeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPerguntaException(msg.toString());
	}

	/**
	 * Returns the first pergunta in the ordered set where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pergunta, or <code>null</code> if a matching pergunta could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pergunta fetchByTeste_First(long testeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Pergunta> list = findByTeste(testeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Pergunta findByTeste_Last(long testeId,
		OrderByComparator orderByComparator)
		throws NoSuchPerguntaException, SystemException {
		Pergunta pergunta = fetchByTeste_Last(testeId, orderByComparator);

		if (pergunta != null) {
			return pergunta;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("testeId=");
		msg.append(testeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPerguntaException(msg.toString());
	}

	/**
	 * Returns the last pergunta in the ordered set where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pergunta, or <code>null</code> if a matching pergunta could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pergunta fetchByTeste_Last(long testeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTeste(testeId);

		List<Pergunta> list = findByTeste(testeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Pergunta[] findByTeste_PrevAndNext(long id, long testeId,
		OrderByComparator orderByComparator)
		throws NoSuchPerguntaException, SystemException {
		Pergunta pergunta = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Pergunta[] array = new PerguntaImpl[3];

			array[0] = getByTeste_PrevAndNext(session, pergunta, testeId,
					orderByComparator, true);

			array[1] = pergunta;

			array[2] = getByTeste_PrevAndNext(session, pergunta, testeId,
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

	protected Pergunta getByTeste_PrevAndNext(Session session,
		Pergunta pergunta, long testeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERGUNTA_WHERE);

		query.append(_FINDER_COLUMN_TESTE_TESTEID_2);

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
			query.append(PerguntaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(testeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pergunta);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Pergunta> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the perguntas.
	 *
	 * @return the perguntas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pergunta> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Pergunta> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Pergunta> findAll(int start, int end,
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

		List<Pergunta> list = (List<Pergunta>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PERGUNTA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERGUNTA.concat(PerguntaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Pergunta>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Pergunta>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the perguntas where testeId = &#63; from the database.
	 *
	 * @param testeId the teste ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTeste(long testeId) throws SystemException {
		for (Pergunta pergunta : findByTeste(testeId)) {
			remove(pergunta);
		}
	}

	/**
	 * Removes all the perguntas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Pergunta pergunta : findAll()) {
			remove(pergunta);
		}
	}

	/**
	 * Returns the number of perguntas where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @return the number of matching perguntas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTeste(long testeId) throws SystemException {
		Object[] finderArgs = new Object[] { testeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TESTE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERGUNTA_WHERE);

			query.append(_FINDER_COLUMN_TESTE_TESTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(testeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TESTE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of perguntas.
	 *
	 * @return the number of perguntas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERGUNTA);

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
	 * Initializes the pergunta persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.testeconhecimento.model.Pergunta")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Pergunta>> listenersList = new ArrayList<ModelListener<Pergunta>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Pergunta>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PerguntaImpl.class.getName());
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
	private static final String _SQL_SELECT_PERGUNTA = "SELECT pergunta FROM Pergunta pergunta";
	private static final String _SQL_SELECT_PERGUNTA_WHERE = "SELECT pergunta FROM Pergunta pergunta WHERE ";
	private static final String _SQL_COUNT_PERGUNTA = "SELECT COUNT(pergunta) FROM Pergunta pergunta";
	private static final String _SQL_COUNT_PERGUNTA_WHERE = "SELECT COUNT(pergunta) FROM Pergunta pergunta WHERE ";
	private static final String _FINDER_COLUMN_TESTE_TESTEID_2 = "pergunta.testeId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pergunta.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Pergunta exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Pergunta exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PerguntaPersistenceImpl.class);
	private static Pergunta _nullPergunta = new PerguntaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Pergunta> toCacheModel() {
				return _nullPerguntaCacheModel;
			}
		};

	private static CacheModel<Pergunta> _nullPerguntaCacheModel = new CacheModel<Pergunta>() {
			public Pergunta toEntityModel() {
				return _nullPergunta;
			}
		};
}