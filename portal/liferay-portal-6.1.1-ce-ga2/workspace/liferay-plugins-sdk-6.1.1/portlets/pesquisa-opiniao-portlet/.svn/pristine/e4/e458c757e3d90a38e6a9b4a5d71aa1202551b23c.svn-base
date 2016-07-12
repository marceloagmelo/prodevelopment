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

import br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario;
import br.com.prodevelopment.pesquisaopiniao.model.impl.Pesquisa_UsuarioImpl;
import br.com.prodevelopment.pesquisaopiniao.model.impl.Pesquisa_UsuarioModelImpl;

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

import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the pesquisa_ usuario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see Pesquisa_UsuarioPersistence
 * @see Pesquisa_UsuarioUtil
 * @generated
 */
public class Pesquisa_UsuarioPersistenceImpl extends BasePersistenceImpl<Pesquisa_Usuario>
	implements Pesquisa_UsuarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Pesquisa_UsuarioUtil} to access the pesquisa_ usuario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Pesquisa_UsuarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PESQUISAID =
		new FinderPath(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Pesquisa_UsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPesquisaId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PESQUISAID =
		new FinderPath(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Pesquisa_UsuarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPesquisaId",
			new String[] { Long.class.getName() },
			Pesquisa_UsuarioModelImpl.PESQUISAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PESQUISAID = new FinderPath(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPesquisaId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Pesquisa_UsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Pesquisa_UsuarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the pesquisa_ usuario in the entity cache if it is enabled.
	 *
	 * @param pesquisa_Usuario the pesquisa_ usuario
	 */
	public void cacheResult(Pesquisa_Usuario pesquisa_Usuario) {
		EntityCacheUtil.putResult(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioImpl.class, pesquisa_Usuario.getPrimaryKey(),
			pesquisa_Usuario);

		pesquisa_Usuario.resetOriginalValues();
	}

	/**
	 * Caches the pesquisa_ usuarios in the entity cache if it is enabled.
	 *
	 * @param pesquisa_Usuarios the pesquisa_ usuarios
	 */
	public void cacheResult(List<Pesquisa_Usuario> pesquisa_Usuarios) {
		for (Pesquisa_Usuario pesquisa_Usuario : pesquisa_Usuarios) {
			if (EntityCacheUtil.getResult(
						Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
						Pesquisa_UsuarioImpl.class,
						pesquisa_Usuario.getPrimaryKey()) == null) {
				cacheResult(pesquisa_Usuario);
			}
			else {
				pesquisa_Usuario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pesquisa_ usuarios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Pesquisa_UsuarioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Pesquisa_UsuarioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pesquisa_ usuario.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Pesquisa_Usuario pesquisa_Usuario) {
		EntityCacheUtil.removeResult(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioImpl.class, pesquisa_Usuario.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Pesquisa_Usuario> pesquisa_Usuarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Pesquisa_Usuario pesquisa_Usuario : pesquisa_Usuarios) {
			EntityCacheUtil.removeResult(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
				Pesquisa_UsuarioImpl.class, pesquisa_Usuario.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pesquisa_ usuario with the primary key. Does not add the pesquisa_ usuario to the database.
	 *
	 * @param id the primary key for the new pesquisa_ usuario
	 * @return the new pesquisa_ usuario
	 */
	public Pesquisa_Usuario create(long id) {
		Pesquisa_Usuario pesquisa_Usuario = new Pesquisa_UsuarioImpl();

		pesquisa_Usuario.setNew(true);
		pesquisa_Usuario.setPrimaryKey(id);

		return pesquisa_Usuario;
	}

	/**
	 * Removes the pesquisa_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pesquisa_ usuario
	 * @return the pesquisa_ usuario that was removed
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a pesquisa_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa_Usuario remove(long id)
		throws NoSuchPesquisa_UsuarioException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the pesquisa_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pesquisa_ usuario
	 * @return the pesquisa_ usuario that was removed
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a pesquisa_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pesquisa_Usuario remove(Serializable primaryKey)
		throws NoSuchPesquisa_UsuarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Pesquisa_Usuario pesquisa_Usuario = (Pesquisa_Usuario)session.get(Pesquisa_UsuarioImpl.class,
					primaryKey);

			if (pesquisa_Usuario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPesquisa_UsuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pesquisa_Usuario);
		}
		catch (NoSuchPesquisa_UsuarioException nsee) {
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
	protected Pesquisa_Usuario removeImpl(Pesquisa_Usuario pesquisa_Usuario)
		throws SystemException {
		pesquisa_Usuario = toUnwrappedModel(pesquisa_Usuario);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, pesquisa_Usuario);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(pesquisa_Usuario);

		return pesquisa_Usuario;
	}

	@Override
	public Pesquisa_Usuario updateImpl(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario pesquisa_Usuario,
		boolean merge) throws SystemException {
		pesquisa_Usuario = toUnwrappedModel(pesquisa_Usuario);

		boolean isNew = pesquisa_Usuario.isNew();

		Pesquisa_UsuarioModelImpl pesquisa_UsuarioModelImpl = (Pesquisa_UsuarioModelImpl)pesquisa_Usuario;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pesquisa_Usuario, merge);

			pesquisa_Usuario.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Pesquisa_UsuarioModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((pesquisa_UsuarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PESQUISAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pesquisa_UsuarioModelImpl.getOriginalPesquisaId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PESQUISAID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PESQUISAID,
					args);

				args = new Object[] {
						Long.valueOf(pesquisa_UsuarioModelImpl.getPesquisaId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PESQUISAID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PESQUISAID,
					args);
			}
		}

		EntityCacheUtil.putResult(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Pesquisa_UsuarioImpl.class, pesquisa_Usuario.getPrimaryKey(),
			pesquisa_Usuario);

		return pesquisa_Usuario;
	}

	protected Pesquisa_Usuario toUnwrappedModel(
		Pesquisa_Usuario pesquisa_Usuario) {
		if (pesquisa_Usuario instanceof Pesquisa_UsuarioImpl) {
			return pesquisa_Usuario;
		}

		Pesquisa_UsuarioImpl pesquisa_UsuarioImpl = new Pesquisa_UsuarioImpl();

		pesquisa_UsuarioImpl.setNew(pesquisa_Usuario.isNew());
		pesquisa_UsuarioImpl.setPrimaryKey(pesquisa_Usuario.getPrimaryKey());

		pesquisa_UsuarioImpl.setId(pesquisa_Usuario.getId());
		pesquisa_UsuarioImpl.setNome(pesquisa_Usuario.getNome());
		pesquisa_UsuarioImpl.setEmail(pesquisa_Usuario.getEmail());
		pesquisa_UsuarioImpl.setDataInclusao(pesquisa_Usuario.getDataInclusao());
		pesquisa_UsuarioImpl.setPesquisaId(pesquisa_Usuario.getPesquisaId());
		pesquisa_UsuarioImpl.setUserId(pesquisa_Usuario.getUserId());

		return pesquisa_UsuarioImpl;
	}

	/**
	 * Returns the pesquisa_ usuario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pesquisa_ usuario
	 * @return the pesquisa_ usuario
	 * @throws com.liferay.portal.NoSuchModelException if a pesquisa_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pesquisa_Usuario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the pesquisa_ usuario with the primary key or throws a {@link br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException} if it could not be found.
	 *
	 * @param id the primary key of the pesquisa_ usuario
	 * @return the pesquisa_ usuario
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a pesquisa_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa_Usuario findByPrimaryKey(long id)
		throws NoSuchPesquisa_UsuarioException, SystemException {
		Pesquisa_Usuario pesquisa_Usuario = fetchByPrimaryKey(id);

		if (pesquisa_Usuario == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchPesquisa_UsuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return pesquisa_Usuario;
	}

	/**
	 * Returns the pesquisa_ usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pesquisa_ usuario
	 * @return the pesquisa_ usuario, or <code>null</code> if a pesquisa_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pesquisa_Usuario fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the pesquisa_ usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pesquisa_ usuario
	 * @return the pesquisa_ usuario, or <code>null</code> if a pesquisa_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa_Usuario fetchByPrimaryKey(long id)
		throws SystemException {
		Pesquisa_Usuario pesquisa_Usuario = (Pesquisa_Usuario)EntityCacheUtil.getResult(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
				Pesquisa_UsuarioImpl.class, id);

		if (pesquisa_Usuario == _nullPesquisa_Usuario) {
			return null;
		}

		if (pesquisa_Usuario == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				pesquisa_Usuario = (Pesquisa_Usuario)session.get(Pesquisa_UsuarioImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (pesquisa_Usuario != null) {
					cacheResult(pesquisa_Usuario);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Pesquisa_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
						Pesquisa_UsuarioImpl.class, id, _nullPesquisa_Usuario);
				}

				closeSession(session);
			}
		}

		return pesquisa_Usuario;
	}

	/**
	 * Returns all the pesquisa_ usuarios where pesquisaId = &#63;.
	 *
	 * @param pesquisaId the pesquisa ID
	 * @return the matching pesquisa_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa_Usuario> findByPesquisaId(long pesquisaId)
		throws SystemException {
		return findByPesquisaId(pesquisaId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Pesquisa_Usuario> findByPesquisaId(long pesquisaId, int start,
		int end) throws SystemException {
		return findByPesquisaId(pesquisaId, start, end, null);
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
	public List<Pesquisa_Usuario> findByPesquisaId(long pesquisaId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PESQUISAID;
			finderArgs = new Object[] { pesquisaId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PESQUISAID;
			finderArgs = new Object[] { pesquisaId, start, end, orderByComparator };
		}

		List<Pesquisa_Usuario> list = (List<Pesquisa_Usuario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Pesquisa_Usuario pesquisa_Usuario : list) {
				if ((pesquisaId != pesquisa_Usuario.getPesquisaId())) {
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

			query.append(_SQL_SELECT_PESQUISA_USUARIO_WHERE);

			query.append(_FINDER_COLUMN_PESQUISAID_PESQUISAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(Pesquisa_UsuarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pesquisaId);

				list = (List<Pesquisa_Usuario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first pesquisa_ usuario in the ordered set where pesquisaId = &#63;.
	 *
	 * @param pesquisaId the pesquisa ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa_ usuario
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException if a matching pesquisa_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa_Usuario findByPesquisaId_First(long pesquisaId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisa_UsuarioException, SystemException {
		Pesquisa_Usuario pesquisa_Usuario = fetchByPesquisaId_First(pesquisaId,
				orderByComparator);

		if (pesquisa_Usuario != null) {
			return pesquisa_Usuario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pesquisaId=");
		msg.append(pesquisaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisa_UsuarioException(msg.toString());
	}

	/**
	 * Returns the first pesquisa_ usuario in the ordered set where pesquisaId = &#63;.
	 *
	 * @param pesquisaId the pesquisa ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa_ usuario, or <code>null</code> if a matching pesquisa_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa_Usuario fetchByPesquisaId_First(long pesquisaId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Pesquisa_Usuario> list = findByPesquisaId(pesquisaId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Pesquisa_Usuario findByPesquisaId_Last(long pesquisaId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisa_UsuarioException, SystemException {
		Pesquisa_Usuario pesquisa_Usuario = fetchByPesquisaId_Last(pesquisaId,
				orderByComparator);

		if (pesquisa_Usuario != null) {
			return pesquisa_Usuario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pesquisaId=");
		msg.append(pesquisaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisa_UsuarioException(msg.toString());
	}

	/**
	 * Returns the last pesquisa_ usuario in the ordered set where pesquisaId = &#63;.
	 *
	 * @param pesquisaId the pesquisa ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa_ usuario, or <code>null</code> if a matching pesquisa_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa_Usuario fetchByPesquisaId_Last(long pesquisaId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPesquisaId(pesquisaId);

		List<Pesquisa_Usuario> list = findByPesquisaId(pesquisaId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Pesquisa_Usuario[] findByPesquisaId_PrevAndNext(long id,
		long pesquisaId, OrderByComparator orderByComparator)
		throws NoSuchPesquisa_UsuarioException, SystemException {
		Pesquisa_Usuario pesquisa_Usuario = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Pesquisa_Usuario[] array = new Pesquisa_UsuarioImpl[3];

			array[0] = getByPesquisaId_PrevAndNext(session, pesquisa_Usuario,
					pesquisaId, orderByComparator, true);

			array[1] = pesquisa_Usuario;

			array[2] = getByPesquisaId_PrevAndNext(session, pesquisa_Usuario,
					pesquisaId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pesquisa_Usuario getByPesquisaId_PrevAndNext(Session session,
		Pesquisa_Usuario pesquisa_Usuario, long pesquisaId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PESQUISA_USUARIO_WHERE);

		query.append(_FINDER_COLUMN_PESQUISAID_PESQUISAID_2);

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
			query.append(Pesquisa_UsuarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(pesquisaId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pesquisa_Usuario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Pesquisa_Usuario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pesquisa_ usuarios.
	 *
	 * @return the pesquisa_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa_Usuario> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Pesquisa_Usuario> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<Pesquisa_Usuario> findAll(int start, int end,
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

		List<Pesquisa_Usuario> list = (List<Pesquisa_Usuario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PESQUISA_USUARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PESQUISA_USUARIO.concat(Pesquisa_UsuarioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Pesquisa_Usuario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Pesquisa_Usuario>)QueryUtil.list(q,
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
	 * Removes all the pesquisa_ usuarios where pesquisaId = &#63; from the database.
	 *
	 * @param pesquisaId the pesquisa ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPesquisaId(long pesquisaId) throws SystemException {
		for (Pesquisa_Usuario pesquisa_Usuario : findByPesquisaId(pesquisaId)) {
			remove(pesquisa_Usuario);
		}
	}

	/**
	 * Removes all the pesquisa_ usuarios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Pesquisa_Usuario pesquisa_Usuario : findAll()) {
			remove(pesquisa_Usuario);
		}
	}

	/**
	 * Returns the number of pesquisa_ usuarios where pesquisaId = &#63;.
	 *
	 * @param pesquisaId the pesquisa ID
	 * @return the number of matching pesquisa_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPesquisaId(long pesquisaId) throws SystemException {
		Object[] finderArgs = new Object[] { pesquisaId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PESQUISAID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PESQUISA_USUARIO_WHERE);

			query.append(_FINDER_COLUMN_PESQUISAID_PESQUISAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pesquisaId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PESQUISAID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pesquisa_ usuarios.
	 *
	 * @return the number of pesquisa_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PESQUISA_USUARIO);

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
	 * Initializes the pesquisa_ usuario persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Pesquisa_Usuario>> listenersList = new ArrayList<ModelListener<Pesquisa_Usuario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Pesquisa_Usuario>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Pesquisa_UsuarioImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PerguntaPersistence.class)
	protected PerguntaPersistence perguntaPersistence;
	@BeanReference(type = PesquisaPersistence.class)
	protected PesquisaPersistence pesquisaPersistence;
	@BeanReference(type = Pesquisa_UsuarioPersistence.class)
	protected Pesquisa_UsuarioPersistence pesquisa_UsuarioPersistence;
	@BeanReference(type = RespostaPersistence.class)
	protected RespostaPersistence respostaPersistence;
	@BeanReference(type = Resposta_UsuarioPersistence.class)
	protected Resposta_UsuarioPersistence resposta_UsuarioPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	private static final String _SQL_SELECT_PESQUISA_USUARIO = "SELECT pesquisa_Usuario FROM Pesquisa_Usuario pesquisa_Usuario";
	private static final String _SQL_SELECT_PESQUISA_USUARIO_WHERE = "SELECT pesquisa_Usuario FROM Pesquisa_Usuario pesquisa_Usuario WHERE ";
	private static final String _SQL_COUNT_PESQUISA_USUARIO = "SELECT COUNT(pesquisa_Usuario) FROM Pesquisa_Usuario pesquisa_Usuario";
	private static final String _SQL_COUNT_PESQUISA_USUARIO_WHERE = "SELECT COUNT(pesquisa_Usuario) FROM Pesquisa_Usuario pesquisa_Usuario WHERE ";
	private static final String _FINDER_COLUMN_PESQUISAID_PESQUISAID_2 = "pesquisa_Usuario.pesquisaId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pesquisa_Usuario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Pesquisa_Usuario exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Pesquisa_Usuario exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Pesquisa_UsuarioPersistenceImpl.class);
	private static Pesquisa_Usuario _nullPesquisa_Usuario = new Pesquisa_UsuarioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Pesquisa_Usuario> toCacheModel() {
				return _nullPesquisa_UsuarioCacheModel;
			}
		};

	private static CacheModel<Pesquisa_Usuario> _nullPesquisa_UsuarioCacheModel = new CacheModel<Pesquisa_Usuario>() {
			public Pesquisa_Usuario toEntityModel() {
				return _nullPesquisa_Usuario;
			}
		};
}