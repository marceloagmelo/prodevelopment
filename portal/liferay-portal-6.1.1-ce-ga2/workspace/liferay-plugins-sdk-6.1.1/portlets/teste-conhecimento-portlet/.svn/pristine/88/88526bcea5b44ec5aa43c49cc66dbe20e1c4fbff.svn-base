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

import br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException;
import br.com.prodevelopment.testeconhecimento.model.Teste_Usuario;
import br.com.prodevelopment.testeconhecimento.model.impl.Teste_UsuarioImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.Teste_UsuarioModelImpl;

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
 * The persistence implementation for the teste_ usuario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see Teste_UsuarioPersistence
 * @see Teste_UsuarioUtil
 * @generated
 */
public class Teste_UsuarioPersistenceImpl extends BasePersistenceImpl<Teste_Usuario>
	implements Teste_UsuarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Teste_UsuarioUtil} to access the teste_ usuario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Teste_UsuarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TESTE = new FinderPath(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Teste_UsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTeste",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE = new FinderPath(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Teste_UsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTeste", new String[] { Long.class.getName() },
			Teste_UsuarioModelImpl.TESTEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TESTE = new FinderPath(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTeste",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Teste_UsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioModelImpl.FINDER_CACHE_ENABLED,
			Teste_UsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the teste_ usuario in the entity cache if it is enabled.
	 *
	 * @param teste_Usuario the teste_ usuario
	 */
	public void cacheResult(Teste_Usuario teste_Usuario) {
		EntityCacheUtil.putResult(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioImpl.class, teste_Usuario.getPrimaryKey(),
			teste_Usuario);

		teste_Usuario.resetOriginalValues();
	}

	/**
	 * Caches the teste_ usuarios in the entity cache if it is enabled.
	 *
	 * @param teste_Usuarios the teste_ usuarios
	 */
	public void cacheResult(List<Teste_Usuario> teste_Usuarios) {
		for (Teste_Usuario teste_Usuario : teste_Usuarios) {
			if (EntityCacheUtil.getResult(
						Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
						Teste_UsuarioImpl.class, teste_Usuario.getPrimaryKey()) == null) {
				cacheResult(teste_Usuario);
			}
			else {
				teste_Usuario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all teste_ usuarios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Teste_UsuarioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Teste_UsuarioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the teste_ usuario.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Teste_Usuario teste_Usuario) {
		EntityCacheUtil.removeResult(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioImpl.class, teste_Usuario.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Teste_Usuario> teste_Usuarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Teste_Usuario teste_Usuario : teste_Usuarios) {
			EntityCacheUtil.removeResult(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
				Teste_UsuarioImpl.class, teste_Usuario.getPrimaryKey());
		}
	}

	/**
	 * Creates a new teste_ usuario with the primary key. Does not add the teste_ usuario to the database.
	 *
	 * @param id the primary key for the new teste_ usuario
	 * @return the new teste_ usuario
	 */
	public Teste_Usuario create(long id) {
		Teste_Usuario teste_Usuario = new Teste_UsuarioImpl();

		teste_Usuario.setNew(true);
		teste_Usuario.setPrimaryKey(id);

		return teste_Usuario;
	}

	/**
	 * Removes the teste_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the teste_ usuario
	 * @return the teste_ usuario that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a teste_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste_Usuario remove(long id)
		throws NoSuchTeste_UsuarioException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the teste_ usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the teste_ usuario
	 * @return the teste_ usuario that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a teste_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Teste_Usuario remove(Serializable primaryKey)
		throws NoSuchTeste_UsuarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Teste_Usuario teste_Usuario = (Teste_Usuario)session.get(Teste_UsuarioImpl.class,
					primaryKey);

			if (teste_Usuario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeste_UsuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(teste_Usuario);
		}
		catch (NoSuchTeste_UsuarioException nsee) {
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
	protected Teste_Usuario removeImpl(Teste_Usuario teste_Usuario)
		throws SystemException {
		teste_Usuario = toUnwrappedModel(teste_Usuario);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, teste_Usuario);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(teste_Usuario);

		return teste_Usuario;
	}

	@Override
	public Teste_Usuario updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Teste_Usuario teste_Usuario,
		boolean merge) throws SystemException {
		teste_Usuario = toUnwrappedModel(teste_Usuario);

		boolean isNew = teste_Usuario.isNew();

		Teste_UsuarioModelImpl teste_UsuarioModelImpl = (Teste_UsuarioModelImpl)teste_Usuario;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, teste_Usuario, merge);

			teste_Usuario.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Teste_UsuarioModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((teste_UsuarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(teste_UsuarioModelImpl.getOriginalTesteId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TESTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE,
					args);

				args = new Object[] {
						Long.valueOf(teste_UsuarioModelImpl.getTesteId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TESTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TESTE,
					args);
			}
		}

		EntityCacheUtil.putResult(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
			Teste_UsuarioImpl.class, teste_Usuario.getPrimaryKey(),
			teste_Usuario);

		return teste_Usuario;
	}

	protected Teste_Usuario toUnwrappedModel(Teste_Usuario teste_Usuario) {
		if (teste_Usuario instanceof Teste_UsuarioImpl) {
			return teste_Usuario;
		}

		Teste_UsuarioImpl teste_UsuarioImpl = new Teste_UsuarioImpl();

		teste_UsuarioImpl.setNew(teste_Usuario.isNew());
		teste_UsuarioImpl.setPrimaryKey(teste_Usuario.getPrimaryKey());

		teste_UsuarioImpl.setId(teste_Usuario.getId());
		teste_UsuarioImpl.setNome(teste_Usuario.getNome());
		teste_UsuarioImpl.setEmail(teste_Usuario.getEmail());
		teste_UsuarioImpl.setDataInclusao(teste_Usuario.getDataInclusao());
		teste_UsuarioImpl.setDataFinalizacao(teste_Usuario.getDataFinalizacao());
		teste_UsuarioImpl.setTotalRespostaCorreta(teste_Usuario.getTotalRespostaCorreta());
		teste_UsuarioImpl.setTotalRespostaErrada(teste_Usuario.getTotalRespostaErrada());
		teste_UsuarioImpl.setTotalPontuacao(teste_Usuario.getTotalPontuacao());
		teste_UsuarioImpl.setTesteId(teste_Usuario.getTesteId());
		teste_UsuarioImpl.setUserId(teste_Usuario.getUserId());

		return teste_UsuarioImpl;
	}

	/**
	 * Returns the teste_ usuario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the teste_ usuario
	 * @return the teste_ usuario
	 * @throws com.liferay.portal.NoSuchModelException if a teste_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Teste_Usuario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the teste_ usuario with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException} if it could not be found.
	 *
	 * @param id the primary key of the teste_ usuario
	 * @return the teste_ usuario
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a teste_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste_Usuario findByPrimaryKey(long id)
		throws NoSuchTeste_UsuarioException, SystemException {
		Teste_Usuario teste_Usuario = fetchByPrimaryKey(id);

		if (teste_Usuario == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTeste_UsuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return teste_Usuario;
	}

	/**
	 * Returns the teste_ usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the teste_ usuario
	 * @return the teste_ usuario, or <code>null</code> if a teste_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Teste_Usuario fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the teste_ usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the teste_ usuario
	 * @return the teste_ usuario, or <code>null</code> if a teste_ usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste_Usuario fetchByPrimaryKey(long id) throws SystemException {
		Teste_Usuario teste_Usuario = (Teste_Usuario)EntityCacheUtil.getResult(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
				Teste_UsuarioImpl.class, id);

		if (teste_Usuario == _nullTeste_Usuario) {
			return null;
		}

		if (teste_Usuario == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				teste_Usuario = (Teste_Usuario)session.get(Teste_UsuarioImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (teste_Usuario != null) {
					cacheResult(teste_Usuario);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Teste_UsuarioModelImpl.ENTITY_CACHE_ENABLED,
						Teste_UsuarioImpl.class, id, _nullTeste_Usuario);
				}

				closeSession(session);
			}
		}

		return teste_Usuario;
	}

	/**
	 * Returns all the teste_ usuarios where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @return the matching teste_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste_Usuario> findByTeste(long testeId)
		throws SystemException {
		return findByTeste(testeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Teste_Usuario> findByTeste(long testeId, int start, int end)
		throws SystemException {
		return findByTeste(testeId, start, end, null);
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
	public List<Teste_Usuario> findByTeste(long testeId, int start, int end,
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

		List<Teste_Usuario> list = (List<Teste_Usuario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Teste_Usuario teste_Usuario : list) {
				if ((testeId != teste_Usuario.getTesteId())) {
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

			query.append(_SQL_SELECT_TESTE_USUARIO_WHERE);

			query.append(_FINDER_COLUMN_TESTE_TESTEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(Teste_UsuarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(testeId);

				list = (List<Teste_Usuario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first teste_ usuario in the ordered set where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste_ usuario
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTeste_UsuarioException if a matching teste_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste_Usuario findByTeste_First(long testeId,
		OrderByComparator orderByComparator)
		throws NoSuchTeste_UsuarioException, SystemException {
		Teste_Usuario teste_Usuario = fetchByTeste_First(testeId,
				orderByComparator);

		if (teste_Usuario != null) {
			return teste_Usuario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("testeId=");
		msg.append(testeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTeste_UsuarioException(msg.toString());
	}

	/**
	 * Returns the first teste_ usuario in the ordered set where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste_ usuario, or <code>null</code> if a matching teste_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste_Usuario fetchByTeste_First(long testeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Teste_Usuario> list = findByTeste(testeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Teste_Usuario findByTeste_Last(long testeId,
		OrderByComparator orderByComparator)
		throws NoSuchTeste_UsuarioException, SystemException {
		Teste_Usuario teste_Usuario = fetchByTeste_Last(testeId,
				orderByComparator);

		if (teste_Usuario != null) {
			return teste_Usuario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("testeId=");
		msg.append(testeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTeste_UsuarioException(msg.toString());
	}

	/**
	 * Returns the last teste_ usuario in the ordered set where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste_ usuario, or <code>null</code> if a matching teste_ usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste_Usuario fetchByTeste_Last(long testeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTeste(testeId);

		List<Teste_Usuario> list = findByTeste(testeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Teste_Usuario[] findByTeste_PrevAndNext(long id, long testeId,
		OrderByComparator orderByComparator)
		throws NoSuchTeste_UsuarioException, SystemException {
		Teste_Usuario teste_Usuario = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Teste_Usuario[] array = new Teste_UsuarioImpl[3];

			array[0] = getByTeste_PrevAndNext(session, teste_Usuario, testeId,
					orderByComparator, true);

			array[1] = teste_Usuario;

			array[2] = getByTeste_PrevAndNext(session, teste_Usuario, testeId,
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

	protected Teste_Usuario getByTeste_PrevAndNext(Session session,
		Teste_Usuario teste_Usuario, long testeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTE_USUARIO_WHERE);

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
			query.append(Teste_UsuarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(testeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(teste_Usuario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Teste_Usuario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the teste_ usuarios.
	 *
	 * @return the teste_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste_Usuario> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Teste_Usuario> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<Teste_Usuario> findAll(int start, int end,
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

		List<Teste_Usuario> list = (List<Teste_Usuario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TESTE_USUARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTE_USUARIO.concat(Teste_UsuarioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Teste_Usuario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Teste_Usuario>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the teste_ usuarios where testeId = &#63; from the database.
	 *
	 * @param testeId the teste ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTeste(long testeId) throws SystemException {
		for (Teste_Usuario teste_Usuario : findByTeste(testeId)) {
			remove(teste_Usuario);
		}
	}

	/**
	 * Removes all the teste_ usuarios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Teste_Usuario teste_Usuario : findAll()) {
			remove(teste_Usuario);
		}
	}

	/**
	 * Returns the number of teste_ usuarios where testeId = &#63;.
	 *
	 * @param testeId the teste ID
	 * @return the number of matching teste_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTeste(long testeId) throws SystemException {
		Object[] finderArgs = new Object[] { testeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TESTE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TESTE_USUARIO_WHERE);

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
	 * Returns the number of teste_ usuarios.
	 *
	 * @return the number of teste_ usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TESTE_USUARIO);

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
	 * Initializes the teste_ usuario persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.testeconhecimento.model.Teste_Usuario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Teste_Usuario>> listenersList = new ArrayList<ModelListener<Teste_Usuario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Teste_Usuario>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Teste_UsuarioImpl.class.getName());
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
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	private static final String _SQL_SELECT_TESTE_USUARIO = "SELECT teste_Usuario FROM Teste_Usuario teste_Usuario";
	private static final String _SQL_SELECT_TESTE_USUARIO_WHERE = "SELECT teste_Usuario FROM Teste_Usuario teste_Usuario WHERE ";
	private static final String _SQL_COUNT_TESTE_USUARIO = "SELECT COUNT(teste_Usuario) FROM Teste_Usuario teste_Usuario";
	private static final String _SQL_COUNT_TESTE_USUARIO_WHERE = "SELECT COUNT(teste_Usuario) FROM Teste_Usuario teste_Usuario WHERE ";
	private static final String _FINDER_COLUMN_TESTE_TESTEID_2 = "teste_Usuario.testeId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "teste_Usuario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Teste_Usuario exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Teste_Usuario exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Teste_UsuarioPersistenceImpl.class);
	private static Teste_Usuario _nullTeste_Usuario = new Teste_UsuarioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Teste_Usuario> toCacheModel() {
				return _nullTeste_UsuarioCacheModel;
			}
		};

	private static CacheModel<Teste_Usuario> _nullTeste_UsuarioCacheModel = new CacheModel<Teste_Usuario>() {
			public Teste_Usuario toEntityModel() {
				return _nullTeste_Usuario;
			}
		};
}