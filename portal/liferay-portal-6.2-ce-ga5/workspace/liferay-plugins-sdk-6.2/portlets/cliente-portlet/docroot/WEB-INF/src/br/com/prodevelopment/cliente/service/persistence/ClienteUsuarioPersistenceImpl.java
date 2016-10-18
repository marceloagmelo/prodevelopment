/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package br.com.prodevelopment.cliente.service.persistence;

import br.com.prodevelopment.cliente.NoSuchClienteUsuarioException;
import br.com.prodevelopment.cliente.model.ClienteUsuario;
import br.com.prodevelopment.cliente.model.impl.ClienteUsuarioImpl;
import br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl;

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
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cliente usuario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see ClienteUsuarioPersistence
 * @see ClienteUsuarioUtil
 * @generated
 */
public class ClienteUsuarioPersistenceImpl extends BasePersistenceImpl<ClienteUsuario>
	implements ClienteUsuarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClienteUsuarioUtil} to access the cliente usuario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClienteUsuarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
			ClienteUsuarioModelImpl.FINDER_CACHE_ENABLED,
			ClienteUsuarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
			ClienteUsuarioModelImpl.FINDER_CACHE_ENABLED,
			ClienteUsuarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
			ClienteUsuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CLIENTEUSUARIO = new FinderPath(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
			ClienteUsuarioModelImpl.FINDER_CACHE_ENABLED,
			ClienteUsuarioImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByClienteUsuario",
			new String[] { Long.class.getName(), Long.class.getName() },
			ClienteUsuarioModelImpl.USERID_COLUMN_BITMASK |
			ClienteUsuarioModelImpl.CLIENTEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTEUSUARIO = new FinderPath(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
			ClienteUsuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClienteUsuario",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the cliente usuario where userId = &#63; and clienteId = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteUsuarioException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param clienteId the cliente ID
	 * @return the matching cliente usuario
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException if a matching cliente usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario findByClienteUsuario(long userId, long clienteId)
		throws NoSuchClienteUsuarioException, SystemException {
		ClienteUsuario clienteUsuario = fetchByClienteUsuario(userId, clienteId);

		if (clienteUsuario == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", clienteId=");
			msg.append(clienteId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchClienteUsuarioException(msg.toString());
		}

		return clienteUsuario;
	}

	/**
	 * Returns the cliente usuario where userId = &#63; and clienteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param clienteId the cliente ID
	 * @return the matching cliente usuario, or <code>null</code> if a matching cliente usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario fetchByClienteUsuario(long userId, long clienteId)
		throws SystemException {
		return fetchByClienteUsuario(userId, clienteId, true);
	}

	/**
	 * Returns the cliente usuario where userId = &#63; and clienteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param clienteId the cliente ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cliente usuario, or <code>null</code> if a matching cliente usuario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario fetchByClienteUsuario(long userId, long clienteId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, clienteId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO,
					finderArgs, this);
		}

		if (result instanceof ClienteUsuario) {
			ClienteUsuario clienteUsuario = (ClienteUsuario)result;

			if ((userId != clienteUsuario.getUserId()) ||
					(clienteId != clienteUsuario.getClienteId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CLIENTEUSUARIO_WHERE);

			query.append(_FINDER_COLUMN_CLIENTEUSUARIO_USERID_2);

			query.append(_FINDER_COLUMN_CLIENTEUSUARIO_CLIENTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(clienteId);

				List<ClienteUsuario> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO,
						finderArgs, list);
				}
				else {
					ClienteUsuario clienteUsuario = list.get(0);

					result = clienteUsuario;

					cacheResult(clienteUsuario);

					if ((clienteUsuario.getUserId() != userId) ||
							(clienteUsuario.getClienteId() != clienteId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO,
							finderArgs, clienteUsuario);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ClienteUsuario)result;
		}
	}

	/**
	 * Removes the cliente usuario where userId = &#63; and clienteId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param clienteId the cliente ID
	 * @return the cliente usuario that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario removeByClienteUsuario(long userId, long clienteId)
		throws NoSuchClienteUsuarioException, SystemException {
		ClienteUsuario clienteUsuario = findByClienteUsuario(userId, clienteId);

		return remove(clienteUsuario);
	}

	/**
	 * Returns the number of cliente usuarios where userId = &#63; and clienteId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clienteId the cliente ID
	 * @return the number of matching cliente usuarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClienteUsuario(long userId, long clienteId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTEUSUARIO;

		Object[] finderArgs = new Object[] { userId, clienteId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CLIENTEUSUARIO_WHERE);

			query.append(_FINDER_COLUMN_CLIENTEUSUARIO_USERID_2);

			query.append(_FINDER_COLUMN_CLIENTEUSUARIO_CLIENTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(clienteId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLIENTEUSUARIO_USERID_2 = "clienteUsuario.userId = ? AND ";
	private static final String _FINDER_COLUMN_CLIENTEUSUARIO_CLIENTEID_2 = "clienteUsuario.clienteId = ?";

	public ClienteUsuarioPersistenceImpl() {
		setModelClass(ClienteUsuario.class);
	}

	/**
	 * Caches the cliente usuario in the entity cache if it is enabled.
	 *
	 * @param clienteUsuario the cliente usuario
	 */
	@Override
	public void cacheResult(ClienteUsuario clienteUsuario) {
		EntityCacheUtil.putResult(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
			ClienteUsuarioImpl.class, clienteUsuario.getPrimaryKey(),
			clienteUsuario);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO,
			new Object[] {
				clienteUsuario.getUserId(), clienteUsuario.getClienteId()
			}, clienteUsuario);

		clienteUsuario.resetOriginalValues();
	}

	/**
	 * Caches the cliente usuarios in the entity cache if it is enabled.
	 *
	 * @param clienteUsuarios the cliente usuarios
	 */
	@Override
	public void cacheResult(List<ClienteUsuario> clienteUsuarios) {
		for (ClienteUsuario clienteUsuario : clienteUsuarios) {
			if (EntityCacheUtil.getResult(
						ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
						ClienteUsuarioImpl.class, clienteUsuario.getPrimaryKey()) == null) {
				cacheResult(clienteUsuario);
			}
			else {
				clienteUsuario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cliente usuarios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ClienteUsuarioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ClienteUsuarioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cliente usuario.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClienteUsuario clienteUsuario) {
		EntityCacheUtil.removeResult(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
			ClienteUsuarioImpl.class, clienteUsuario.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(clienteUsuario);
	}

	@Override
	public void clearCache(List<ClienteUsuario> clienteUsuarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClienteUsuario clienteUsuario : clienteUsuarios) {
			EntityCacheUtil.removeResult(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
				ClienteUsuarioImpl.class, clienteUsuario.getPrimaryKey());

			clearUniqueFindersCache(clienteUsuario);
		}
	}

	protected void cacheUniqueFindersCache(ClienteUsuario clienteUsuario) {
		if (clienteUsuario.isNew()) {
			Object[] args = new Object[] {
					clienteUsuario.getUserId(), clienteUsuario.getClienteId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLIENTEUSUARIO,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO,
				args, clienteUsuario);
		}
		else {
			ClienteUsuarioModelImpl clienteUsuarioModelImpl = (ClienteUsuarioModelImpl)clienteUsuario;

			if ((clienteUsuarioModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CLIENTEUSUARIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						clienteUsuario.getUserId(),
						clienteUsuario.getClienteId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLIENTEUSUARIO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO,
					args, clienteUsuario);
			}
		}
	}

	protected void clearUniqueFindersCache(ClienteUsuario clienteUsuario) {
		ClienteUsuarioModelImpl clienteUsuarioModelImpl = (ClienteUsuarioModelImpl)clienteUsuario;

		Object[] args = new Object[] {
				clienteUsuario.getUserId(), clienteUsuario.getClienteId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLIENTEUSUARIO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO, args);

		if ((clienteUsuarioModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CLIENTEUSUARIO.getColumnBitmask()) != 0) {
			args = new Object[] {
					clienteUsuarioModelImpl.getOriginalUserId(),
					clienteUsuarioModelImpl.getOriginalClienteId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLIENTEUSUARIO,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTEUSUARIO,
				args);
		}
	}

	/**
	 * Creates a new cliente usuario with the primary key. Does not add the cliente usuario to the database.
	 *
	 * @param clienteUsuarioId the primary key for the new cliente usuario
	 * @return the new cliente usuario
	 */
	@Override
	public ClienteUsuario create(long clienteUsuarioId) {
		ClienteUsuario clienteUsuario = new ClienteUsuarioImpl();

		clienteUsuario.setNew(true);
		clienteUsuario.setPrimaryKey(clienteUsuarioId);

		return clienteUsuario;
	}

	/**
	 * Removes the cliente usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteUsuarioId the primary key of the cliente usuario
	 * @return the cliente usuario that was removed
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException if a cliente usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario remove(long clienteUsuarioId)
		throws NoSuchClienteUsuarioException, SystemException {
		return remove((Serializable)clienteUsuarioId);
	}

	/**
	 * Removes the cliente usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cliente usuario
	 * @return the cliente usuario that was removed
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException if a cliente usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario remove(Serializable primaryKey)
		throws NoSuchClienteUsuarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ClienteUsuario clienteUsuario = (ClienteUsuario)session.get(ClienteUsuarioImpl.class,
					primaryKey);

			if (clienteUsuario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClienteUsuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(clienteUsuario);
		}
		catch (NoSuchClienteUsuarioException nsee) {
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
	protected ClienteUsuario removeImpl(ClienteUsuario clienteUsuario)
		throws SystemException {
		clienteUsuario = toUnwrappedModel(clienteUsuario);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clienteUsuario)) {
				clienteUsuario = (ClienteUsuario)session.get(ClienteUsuarioImpl.class,
						clienteUsuario.getPrimaryKeyObj());
			}

			if (clienteUsuario != null) {
				session.delete(clienteUsuario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (clienteUsuario != null) {
			clearCache(clienteUsuario);
		}

		return clienteUsuario;
	}

	@Override
	public ClienteUsuario updateImpl(
		br.com.prodevelopment.cliente.model.ClienteUsuario clienteUsuario)
		throws SystemException {
		clienteUsuario = toUnwrappedModel(clienteUsuario);

		boolean isNew = clienteUsuario.isNew();

		Session session = null;

		try {
			session = openSession();

			if (clienteUsuario.isNew()) {
				session.save(clienteUsuario);

				clienteUsuario.setNew(false);
			}
			else {
				session.merge(clienteUsuario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ClienteUsuarioModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
			ClienteUsuarioImpl.class, clienteUsuario.getPrimaryKey(),
			clienteUsuario);

		clearUniqueFindersCache(clienteUsuario);
		cacheUniqueFindersCache(clienteUsuario);

		return clienteUsuario;
	}

	protected ClienteUsuario toUnwrappedModel(ClienteUsuario clienteUsuario) {
		if (clienteUsuario instanceof ClienteUsuarioImpl) {
			return clienteUsuario;
		}

		ClienteUsuarioImpl clienteUsuarioImpl = new ClienteUsuarioImpl();

		clienteUsuarioImpl.setNew(clienteUsuario.isNew());
		clienteUsuarioImpl.setPrimaryKey(clienteUsuario.getPrimaryKey());

		clienteUsuarioImpl.setClienteUsuarioId(clienteUsuario.getClienteUsuarioId());
		clienteUsuarioImpl.setUserId(clienteUsuario.getUserId());
		clienteUsuarioImpl.setClienteId(clienteUsuario.getClienteId());

		return clienteUsuarioImpl;
	}

	/**
	 * Returns the cliente usuario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente usuario
	 * @return the cliente usuario
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException if a cliente usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClienteUsuarioException, SystemException {
		ClienteUsuario clienteUsuario = fetchByPrimaryKey(primaryKey);

		if (clienteUsuario == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClienteUsuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return clienteUsuario;
	}

	/**
	 * Returns the cliente usuario with the primary key or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteUsuarioException} if it could not be found.
	 *
	 * @param clienteUsuarioId the primary key of the cliente usuario
	 * @return the cliente usuario
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteUsuarioException if a cliente usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario findByPrimaryKey(long clienteUsuarioId)
		throws NoSuchClienteUsuarioException, SystemException {
		return findByPrimaryKey((Serializable)clienteUsuarioId);
	}

	/**
	 * Returns the cliente usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente usuario
	 * @return the cliente usuario, or <code>null</code> if a cliente usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ClienteUsuario clienteUsuario = (ClienteUsuario)EntityCacheUtil.getResult(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
				ClienteUsuarioImpl.class, primaryKey);

		if (clienteUsuario == _nullClienteUsuario) {
			return null;
		}

		if (clienteUsuario == null) {
			Session session = null;

			try {
				session = openSession();

				clienteUsuario = (ClienteUsuario)session.get(ClienteUsuarioImpl.class,
						primaryKey);

				if (clienteUsuario != null) {
					cacheResult(clienteUsuario);
				}
				else {
					EntityCacheUtil.putResult(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
						ClienteUsuarioImpl.class, primaryKey,
						_nullClienteUsuario);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ClienteUsuarioModelImpl.ENTITY_CACHE_ENABLED,
					ClienteUsuarioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return clienteUsuario;
	}

	/**
	 * Returns the cliente usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteUsuarioId the primary key of the cliente usuario
	 * @return the cliente usuario, or <code>null</code> if a cliente usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteUsuario fetchByPrimaryKey(long clienteUsuarioId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)clienteUsuarioId);
	}

	/**
	 * Returns all the cliente usuarios.
	 *
	 * @return the cliente usuarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClienteUsuario> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cliente usuarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente usuarios
	 * @param end the upper bound of the range of cliente usuarios (not inclusive)
	 * @return the range of cliente usuarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClienteUsuario> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cliente usuarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteUsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente usuarios
	 * @param end the upper bound of the range of cliente usuarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cliente usuarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClienteUsuario> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ClienteUsuario> list = (List<ClienteUsuario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CLIENTEUSUARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTEUSUARIO;

				if (pagination) {
					sql = sql.concat(ClienteUsuarioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ClienteUsuario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ClienteUsuario>(list);
				}
				else {
					list = (List<ClienteUsuario>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cliente usuarios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ClienteUsuario clienteUsuario : findAll()) {
			remove(clienteUsuario);
		}
	}

	/**
	 * Returns the number of cliente usuarios.
	 *
	 * @return the number of cliente usuarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CLIENTEUSUARIO);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the cliente usuario persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.cliente.model.ClienteUsuario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ClienteUsuario>> listenersList = new ArrayList<ModelListener<ClienteUsuario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ClienteUsuario>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ClienteUsuarioImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CLIENTEUSUARIO = "SELECT clienteUsuario FROM ClienteUsuario clienteUsuario";
	private static final String _SQL_SELECT_CLIENTEUSUARIO_WHERE = "SELECT clienteUsuario FROM ClienteUsuario clienteUsuario WHERE ";
	private static final String _SQL_COUNT_CLIENTEUSUARIO = "SELECT COUNT(clienteUsuario) FROM ClienteUsuario clienteUsuario";
	private static final String _SQL_COUNT_CLIENTEUSUARIO_WHERE = "SELECT COUNT(clienteUsuario) FROM ClienteUsuario clienteUsuario WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "clienteUsuario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ClienteUsuario exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ClienteUsuario exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ClienteUsuarioPersistenceImpl.class);
	private static ClienteUsuario _nullClienteUsuario = new ClienteUsuarioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ClienteUsuario> toCacheModel() {
				return _nullClienteUsuarioCacheModel;
			}
		};

	private static CacheModel<ClienteUsuario> _nullClienteUsuarioCacheModel = new CacheModel<ClienteUsuario>() {
			@Override
			public ClienteUsuario toEntityModel() {
				return _nullClienteUsuario;
			}
		};
}