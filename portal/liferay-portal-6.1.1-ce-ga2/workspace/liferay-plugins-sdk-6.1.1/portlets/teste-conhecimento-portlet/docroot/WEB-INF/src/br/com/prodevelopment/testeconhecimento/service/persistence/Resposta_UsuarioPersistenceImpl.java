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

import br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException;
import br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario;
import br.com.prodevelopment.testeconhecimento.model.impl.Resposta_UsuarioImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.Resposta_UsuarioModelImpl;

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
 * The persistence implementation for the resposta_ usuario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see Resposta_UsuarioPersistence
 * @see Resposta_UsuarioUtil
 * @generated
 */
public class Resposta_UsuarioPersistenceImpl extends BasePersistenceImpl<Resposta_Usuario>
	implements Resposta_UsuarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Resposta_UsuarioUtil} to access the resposta_ usuario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Resposta_UsuarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TESTEUSUARIO =
		new FinderPath(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Resposta_UsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTesteUsuario",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTEUSUARIO =
		new FinderPath(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Resposta_UsuarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTesteUsuario",
			new String[] { Long.class.getName() },
			Resposta_UsuarioModelImpl.TESTEUSUARIOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TESTEUSUARIO = new FinderPath(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTesteUsuario",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Resposta_UsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Resposta_UsuarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the resposta_ usuario in the entity cache if it is enabled.
	 *
	 * @param resposta_Usuario the resposta_ usuario
	 */
	public void cacheResult(Resposta_Usuario resposta_Usuario) {
		EntityCacheUtil.putResult(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioImpl.class, resposta_Usuario.getPrimaryKey(),
			resposta_Usuario);

		resposta_Usuario.resetOriginalValues();
	}

	/**
	 * Caches the resposta_ usuarios in the entity cache if it is enabled.
	 *
	 * @param resposta_Usuarios the resposta_ usuarios
	 */
	public void cacheResult(List<Resposta_Usuario> resposta_Usuarios) {
		for (Resposta_Usuario resposta_Usuario : resposta_Usuarios) {
			if (EntityCacheUtil.getResult(
						Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
						Resposta_UsuarioImpl.class,
						resposta_Usuario.getPrimaryKey()) == null) {
				cacheResult(resposta_Usuario);
			}
			else {
				resposta_Usuario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all resposta_ usuarios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Resposta_UsuarioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Resposta_UsuarioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the resposta_ usuario.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Resposta_Usuario resposta_Usuario) {
		EntityCacheUtil.removeResult(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioImpl.class, resposta_Usuario.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Resposta_Usuario> resposta_Usuarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Resposta_Usuario resposta_Usuario : resposta_Usuarios) {
			EntityCacheUtil.removeResult(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
				Resposta_UsuarioImpl.class, resposta_Usuario.getPrimaryKey());
		}
	}

	/**
	 * Creates a new resposta_ usuario with the primary key. Does not add the resposta_ usuario to the database.
	 *
	 * @param id the primary key for the new resposta_ usuario
	 * @return the new resposta_ usuario
	 */
	public Resposta_Usuario create(long id) {
		Resposta_Usuario resposta_Usuario = new Resposta_UsuarioImpl();

		resposta_Usuario.setNew(true);
		resposta_Usuario.setPrimaryKey(id);

		return resposta_Usuario;
	}

	/**
	 * Removes the resposta_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the resposta_ usuario
	 * @return the resposta_ usuario that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta_Usuario remove(long id)
		throws NoSuchResposta_UsuarioException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the resposta_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resposta_ usuario
	 * @return the resposta_ usuario that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Resposta_Usuario remove(Serializable primaryKey)
		throws NoSuchResposta_UsuarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Resposta_Usuario resposta_Usuario = (Resposta_Usuario)session.get(Resposta_UsuarioImpl.class,
					primaryKey);

			if (resposta_Usuario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResposta_UsuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(resposta_Usuario);
		}
		catch (NoSuchResposta_UsuarioException nsee) {
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
	protected Resposta_Usuario removeImpl(Resposta_Usuario resposta_Usuario)
		throws SystemException {
		resposta_Usuario = toUnwrappedModel(resposta_Usuario);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, resposta_Usuario);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(resposta_Usuario);

		return resposta_Usuario;
	}

	@Override
	public Resposta_Usuario updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario resposta_Usuario,
		boolean merge) throws SystemException {
		resposta_Usuario = toUnwrappedModel(resposta_Usuario);

		boolean isNew = resposta_Usuario.isNew();

		Resposta_UsuarioModelImpl resposta_UsuarioModelImpl = (Resposta_UsuarioModelImpl)resposta_Usuario;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, resposta_Usuario, merge);

			resposta_Usuario.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Resposta_UsuarioModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((resposta_UsuarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTEUSUARIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(resposta_UsuarioModelImpl.getOriginalTesteUsuarioId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TESTEUSUARIO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTEUSUARIO,
					args);

				args = new Object[] {
						Long.valueOf(resposta_UsuarioModelImpl.getTesteUsuarioId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TESTEUSUARIO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTEUSUARIO,
					args);
			}
		}

		EntityCacheUtil.putResult(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Resposta_UsuarioImpl.class, resposta_Usuario.getPrimaryKey(),
			resposta_Usuario);

		return resposta_Usuario;
	}

	protected Resposta_Usuario toUnwrappedModel(
		Resposta_Usuario resposta_Usuario) {
		if (resposta_Usuario instanceof Resposta_UsuarioImpl) {
			return resposta_Usuario;
		}

		Resposta_UsuarioImpl resposta_UsuarioImpl = new Resposta_UsuarioImpl();

		resposta_UsuarioImpl.setNew(resposta_Usuario.isNew());
		resposta_UsuarioImpl.setPrimaryKey(resposta_Usuario.getPrimaryKey());

		resposta_UsuarioImpl.setId(resposta_Usuario.getId());
		resposta_UsuarioImpl.setCorreta(resposta_Usuario.isCorreta());
		resposta_UsuarioImpl.setDataInclusao(resposta_Usuario.getDataInclusao());
		resposta_UsuarioImpl.setTesteUsuarioId(resposta_Usuario.getTesteUsuarioId());
		resposta_UsuarioImpl.setRespostaId(resposta_Usuario.getRespostaId());

		return resposta_UsuarioImpl;
	}

	/**
	 * Returns the resposta_ usuario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the resposta_ usuario
	 * @return the resposta_ usuario
	 * @throws com.liferay.portal.NoSuchModelException if a resposta_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Resposta_Usuario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the resposta_ usuario with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException} if it could not be found.
	 *
	 * @param id the primary key of the resposta_ usuario
	 * @return the resposta_ usuario
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a resposta_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta_Usuario findByPrimaryKey(long id)
		throws NoSuchResposta_UsuarioException, SystemException {
		Resposta_Usuario resposta_Usuario = fetchByPrimaryKey(id);

		if (resposta_Usuario == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchResposta_UsuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return resposta_Usuario;
	}

	/**
	 * Returns the resposta_ usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resposta_ usuario
	 * @return the resposta_ usuario, or <code>null</code> if a resposta_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Resposta_Usuario fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the resposta_ usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the resposta_ usuario
	 * @return the resposta_ usuario, or <code>null</code> if a resposta_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta_Usuario fetchByPrimaryKey(long id)
		throws SystemException {
		Resposta_Usuario resposta_Usuario = (Resposta_Usuario)EntityCacheUtil.getResult(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
				Resposta_UsuarioImpl.class, id);

		if (resposta_Usuario == _nullResposta_Usuario) {
			return null;
		}

		if (resposta_Usuario == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				resposta_Usuario = (Resposta_Usuario)session.get(Resposta_UsuarioImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (resposta_Usuario != null) {
					cacheResult(resposta_Usuario);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Resposta_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
						Resposta_UsuarioImpl.class, id, _nullResposta_Usuario);
				}

				closeSession(session);
			}
		}

		return resposta_Usuario;
	}

	/**
	 * Returns all the resposta_ usuarios where testeUsuarioId = &#63;.
	 *
	 * @param testeUsuarioId the teste usuario ID
	 * @return the matching resposta_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<Resposta_Usuario> findByTesteUsuario(long testeUsuarioId)
		throws SystemException {
		return findByTesteUsuario(testeUsuarioId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Resposta_Usuario> findByTesteUsuario(long testeUsuarioId,
		int start, int end) throws SystemException {
		return findByTesteUsuario(testeUsuarioId, start, end, null);
	}

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
	public List<Resposta_Usuario> findByTesteUsuario(long testeUsuarioId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTEUSUARIO;
			finderArgs = new Object[] { testeUsuarioId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TESTEUSUARIO;
			finderArgs = new Object[] {
					testeUsuarioId,
					
					start, end, orderByComparator
				};
		}

		List<Resposta_Usuario> list = (List<Resposta_Usuario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Resposta_Usuario resposta_Usuario : list) {
				if ((testeUsuarioId != resposta_Usuario.getTesteUsuarioId())) {
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

			query.append(_SQL_SELECT_RESPOSTA_USUARIO_WHERE);

			query.append(_FINDER_COLUMN_TESTEUSUARIO_TESTEUSUARIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(Resposta_UsuarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(testeUsuarioId);

				list = (List<Resposta_Usuario>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	 *
	 * @param testeUsuarioId the teste usuario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resposta_ usuario
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a matching resposta_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta_Usuario findByTesteUsuario_First(long testeUsuarioId,
		OrderByComparator orderByComparator)
		throws NoSuchResposta_UsuarioException, SystemException {
		Resposta_Usuario resposta_Usuario = fetchByTesteUsuario_First(testeUsuarioId,
				orderByComparator);

		if (resposta_Usuario != null) {
			return resposta_Usuario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("testeUsuarioId=");
		msg.append(testeUsuarioId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResposta_UsuarioException(msg.toString());
	}

	/**
	 * Returns the first resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	 *
	 * @param testeUsuarioId the teste usuario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resposta_ usuario, or <code>null</code> if a matching resposta_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta_Usuario fetchByTesteUsuario_First(long testeUsuarioId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Resposta_Usuario> list = findByTesteUsuario(testeUsuarioId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	 *
	 * @param testeUsuarioId the teste usuario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resposta_ usuario
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchResposta_UsuarioException if a matching resposta_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta_Usuario findByTesteUsuario_Last(long testeUsuarioId,
		OrderByComparator orderByComparator)
		throws NoSuchResposta_UsuarioException, SystemException {
		Resposta_Usuario resposta_Usuario = fetchByTesteUsuario_Last(testeUsuarioId,
				orderByComparator);

		if (resposta_Usuario != null) {
			return resposta_Usuario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("testeUsuarioId=");
		msg.append(testeUsuarioId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResposta_UsuarioException(msg.toString());
	}

	/**
	 * Returns the last resposta_ usuario in the ordered set where testeUsuarioId = &#63;.
	 *
	 * @param testeUsuarioId the teste usuario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resposta_ usuario, or <code>null</code> if a matching resposta_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta_Usuario fetchByTesteUsuario_Last(long testeUsuarioId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTesteUsuario(testeUsuarioId);

		List<Resposta_Usuario> list = findByTesteUsuario(testeUsuarioId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Resposta_Usuario[] findByTesteUsuario_PrevAndNext(long id,
		long testeUsuarioId, OrderByComparator orderByComparator)
		throws NoSuchResposta_UsuarioException, SystemException {
		Resposta_Usuario resposta_Usuario = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Resposta_Usuario[] array = new Resposta_UsuarioImpl[3];

			array[0] = getByTesteUsuario_PrevAndNext(session, resposta_Usuario,
					testeUsuarioId, orderByComparator, true);

			array[1] = resposta_Usuario;

			array[2] = getByTesteUsuario_PrevAndNext(session, resposta_Usuario,
					testeUsuarioId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Resposta_Usuario getByTesteUsuario_PrevAndNext(Session session,
		Resposta_Usuario resposta_Usuario, long testeUsuarioId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESPOSTA_USUARIO_WHERE);

		query.append(_FINDER_COLUMN_TESTEUSUARIO_TESTEUSUARIOID_2);

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
			query.append(Resposta_UsuarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(testeUsuarioId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(resposta_Usuario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Resposta_Usuario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the resposta_ usuarios.
	 *
	 * @return the resposta_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<Resposta_Usuario> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Resposta_Usuario> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<Resposta_Usuario> findAll(int start, int end,
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

		List<Resposta_Usuario> list = (List<Resposta_Usuario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESPOSTA_USUARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESPOSTA_USUARIO.concat(Resposta_UsuarioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Resposta_Usuario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Resposta_Usuario>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the resposta_ usuarios where testeUsuarioId = &#63; from the database.
	 *
	 * @param testeUsuarioId the teste usuario ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTesteUsuario(long testeUsuarioId)
		throws SystemException {
		for (Resposta_Usuario resposta_Usuario : findByTesteUsuario(
				testeUsuarioId)) {
			remove(resposta_Usuario);
		}
	}

	/**
	 * Removes all the resposta_ usuarios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Resposta_Usuario resposta_Usuario : findAll()) {
			remove(resposta_Usuario);
		}
	}

	/**
	 * Returns the number of resposta_ usuarios where testeUsuarioId = &#63;.
	 *
	 * @param testeUsuarioId the teste usuario ID
	 * @return the number of matching resposta_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTesteUsuario(long testeUsuarioId)
		throws SystemException {
		Object[] finderArgs = new Object[] { testeUsuarioId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TESTEUSUARIO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESPOSTA_USUARIO_WHERE);

			query.append(_FINDER_COLUMN_TESTEUSUARIO_TESTEUSUARIOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(testeUsuarioId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TESTEUSUARIO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of resposta_ usuarios.
	 *
	 * @return the number of resposta_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESPOSTA_USUARIO);

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
	 * Initializes the resposta_ usuario persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Resposta_Usuario>> listenersList = new ArrayList<ModelListener<Resposta_Usuario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Resposta_Usuario>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Resposta_UsuarioImpl.class.getName());
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
	private static final String _SQL_SELECT_RESPOSTA_USUARIO = "SELECT resposta_Usuario FROM Resposta_Usuario resposta_Usuario";
	private static final String _SQL_SELECT_RESPOSTA_USUARIO_WHERE = "SELECT resposta_Usuario FROM Resposta_Usuario resposta_Usuario WHERE ";
	private static final String _SQL_COUNT_RESPOSTA_USUARIO = "SELECT COUNT(resposta_Usuario) FROM Resposta_Usuario resposta_Usuario";
	private static final String _SQL_COUNT_RESPOSTA_USUARIO_WHERE = "SELECT COUNT(resposta_Usuario) FROM Resposta_Usuario resposta_Usuario WHERE ";
	private static final String _FINDER_COLUMN_TESTEUSUARIO_TESTEUSUARIOID_2 = "resposta_Usuario.testeUsuarioId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "resposta_Usuario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Resposta_Usuario exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Resposta_Usuario exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Resposta_UsuarioPersistenceImpl.class);
	private static Resposta_Usuario _nullResposta_Usuario = new Resposta_UsuarioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Resposta_Usuario> toCacheModel() {
				return _nullResposta_UsuarioCacheModel;
			}
		};

	private static CacheModel<Resposta_Usuario> _nullResposta_UsuarioCacheModel = new CacheModel<Resposta_Usuario>() {
			public Resposta_Usuario toEntityModel() {
				return _nullResposta_Usuario;
			}
		};
}