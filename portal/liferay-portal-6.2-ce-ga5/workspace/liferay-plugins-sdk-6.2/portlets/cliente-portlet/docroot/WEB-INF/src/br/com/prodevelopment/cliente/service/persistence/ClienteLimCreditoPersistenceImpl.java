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

import br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException;
import br.com.prodevelopment.cliente.model.ClienteLimCredito;
import br.com.prodevelopment.cliente.model.impl.ClienteLimCreditoImpl;
import br.com.prodevelopment.cliente.model.impl.ClienteLimCreditoModelImpl;

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
 * The persistence implementation for the cliente lim credito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see ClienteLimCreditoPersistence
 * @see ClienteLimCreditoUtil
 * @generated
 */
public class ClienteLimCreditoPersistenceImpl extends BasePersistenceImpl<ClienteLimCredito>
	implements ClienteLimCreditoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClienteLimCreditoUtil} to access the cliente lim credito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClienteLimCreditoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
			ClienteLimCreditoModelImpl.FINDER_CACHE_ENABLED,
			ClienteLimCreditoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
			ClienteLimCreditoModelImpl.FINDER_CACHE_ENABLED,
			ClienteLimCreditoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
			ClienteLimCreditoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CLIENTE = new FinderPath(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
			ClienteLimCreditoModelImpl.FINDER_CACHE_ENABLED,
			ClienteLimCreditoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCliente", new String[] { Long.class.getName() },
			ClienteLimCreditoModelImpl.CLIENTEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTE = new FinderPath(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
			ClienteLimCreditoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCliente",
			new String[] { Long.class.getName() });

	/**
	 * Returns the cliente lim credito where clienteId = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException} if it could not be found.
	 *
	 * @param clienteId the cliente ID
	 * @return the matching cliente lim credito
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException if a matching cliente lim credito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito findByCliente(long clienteId)
		throws NoSuchClienteLimCreditoException, SystemException {
		ClienteLimCredito clienteLimCredito = fetchByCliente(clienteId);

		if (clienteLimCredito == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("clienteId=");
			msg.append(clienteId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchClienteLimCreditoException(msg.toString());
		}

		return clienteLimCredito;
	}

	/**
	 * Returns the cliente lim credito where clienteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clienteId the cliente ID
	 * @return the matching cliente lim credito, or <code>null</code> if a matching cliente lim credito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito fetchByCliente(long clienteId)
		throws SystemException {
		return fetchByCliente(clienteId, true);
	}

	/**
	 * Returns the cliente lim credito where clienteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clienteId the cliente ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cliente lim credito, or <code>null</code> if a matching cliente lim credito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito fetchByCliente(long clienteId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { clienteId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CLIENTE,
					finderArgs, this);
		}

		if (result instanceof ClienteLimCredito) {
			ClienteLimCredito clienteLimCredito = (ClienteLimCredito)result;

			if ((clienteId != clienteLimCredito.getClienteId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CLIENTELIMCREDITO_WHERE);

			query.append(_FINDER_COLUMN_CLIENTE_CLIENTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clienteId);

				List<ClienteLimCredito> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ClienteLimCreditoPersistenceImpl.fetchByCliente(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ClienteLimCredito clienteLimCredito = list.get(0);

					result = clienteLimCredito;

					cacheResult(clienteLimCredito);

					if ((clienteLimCredito.getClienteId() != clienteId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTE,
							finderArgs, clienteLimCredito);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTE,
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
			return (ClienteLimCredito)result;
		}
	}

	/**
	 * Removes the cliente lim credito where clienteId = &#63; from the database.
	 *
	 * @param clienteId the cliente ID
	 * @return the cliente lim credito that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito removeByCliente(long clienteId)
		throws NoSuchClienteLimCreditoException, SystemException {
		ClienteLimCredito clienteLimCredito = findByCliente(clienteId);

		return remove(clienteLimCredito);
	}

	/**
	 * Returns the number of cliente lim creditos where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @return the number of matching cliente lim creditos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCliente(long clienteId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTE;

		Object[] finderArgs = new Object[] { clienteId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTELIMCREDITO_WHERE);

			query.append(_FINDER_COLUMN_CLIENTE_CLIENTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_CLIENTE_CLIENTEID_2 = "clienteLimCredito.clienteId = ?";

	public ClienteLimCreditoPersistenceImpl() {
		setModelClass(ClienteLimCredito.class);
	}

	/**
	 * Caches the cliente lim credito in the entity cache if it is enabled.
	 *
	 * @param clienteLimCredito the cliente lim credito
	 */
	@Override
	public void cacheResult(ClienteLimCredito clienteLimCredito) {
		EntityCacheUtil.putResult(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
			ClienteLimCreditoImpl.class, clienteLimCredito.getPrimaryKey(),
			clienteLimCredito);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTE,
			new Object[] { clienteLimCredito.getClienteId() }, clienteLimCredito);

		clienteLimCredito.resetOriginalValues();
	}

	/**
	 * Caches the cliente lim creditos in the entity cache if it is enabled.
	 *
	 * @param clienteLimCreditos the cliente lim creditos
	 */
	@Override
	public void cacheResult(List<ClienteLimCredito> clienteLimCreditos) {
		for (ClienteLimCredito clienteLimCredito : clienteLimCreditos) {
			if (EntityCacheUtil.getResult(
						ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
						ClienteLimCreditoImpl.class,
						clienteLimCredito.getPrimaryKey()) == null) {
				cacheResult(clienteLimCredito);
			}
			else {
				clienteLimCredito.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cliente lim creditos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ClienteLimCreditoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ClienteLimCreditoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cliente lim credito.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClienteLimCredito clienteLimCredito) {
		EntityCacheUtil.removeResult(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
			ClienteLimCreditoImpl.class, clienteLimCredito.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(clienteLimCredito);
	}

	@Override
	public void clearCache(List<ClienteLimCredito> clienteLimCreditos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClienteLimCredito clienteLimCredito : clienteLimCreditos) {
			EntityCacheUtil.removeResult(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
				ClienteLimCreditoImpl.class, clienteLimCredito.getPrimaryKey());

			clearUniqueFindersCache(clienteLimCredito);
		}
	}

	protected void cacheUniqueFindersCache(ClienteLimCredito clienteLimCredito) {
		if (clienteLimCredito.isNew()) {
			Object[] args = new Object[] { clienteLimCredito.getClienteId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLIENTE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTE, args,
				clienteLimCredito);
		}
		else {
			ClienteLimCreditoModelImpl clienteLimCreditoModelImpl = (ClienteLimCreditoModelImpl)clienteLimCredito;

			if ((clienteLimCreditoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CLIENTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { clienteLimCredito.getClienteId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLIENTE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTE, args,
					clienteLimCredito);
			}
		}
	}

	protected void clearUniqueFindersCache(ClienteLimCredito clienteLimCredito) {
		ClienteLimCreditoModelImpl clienteLimCreditoModelImpl = (ClienteLimCreditoModelImpl)clienteLimCredito;

		Object[] args = new Object[] { clienteLimCredito.getClienteId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLIENTE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTE, args);

		if ((clienteLimCreditoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CLIENTE.getColumnBitmask()) != 0) {
			args = new Object[] {
					clienteLimCreditoModelImpl.getOriginalClienteId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLIENTE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTE, args);
		}
	}

	/**
	 * Creates a new cliente lim credito with the primary key. Does not add the cliente lim credito to the database.
	 *
	 * @param clienteLimCreditoId the primary key for the new cliente lim credito
	 * @return the new cliente lim credito
	 */
	@Override
	public ClienteLimCredito create(long clienteLimCreditoId) {
		ClienteLimCredito clienteLimCredito = new ClienteLimCreditoImpl();

		clienteLimCredito.setNew(true);
		clienteLimCredito.setPrimaryKey(clienteLimCreditoId);

		return clienteLimCredito;
	}

	/**
	 * Removes the cliente lim credito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteLimCreditoId the primary key of the cliente lim credito
	 * @return the cliente lim credito that was removed
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException if a cliente lim credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito remove(long clienteLimCreditoId)
		throws NoSuchClienteLimCreditoException, SystemException {
		return remove((Serializable)clienteLimCreditoId);
	}

	/**
	 * Removes the cliente lim credito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cliente lim credito
	 * @return the cliente lim credito that was removed
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException if a cliente lim credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito remove(Serializable primaryKey)
		throws NoSuchClienteLimCreditoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ClienteLimCredito clienteLimCredito = (ClienteLimCredito)session.get(ClienteLimCreditoImpl.class,
					primaryKey);

			if (clienteLimCredito == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClienteLimCreditoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(clienteLimCredito);
		}
		catch (NoSuchClienteLimCreditoException nsee) {
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
	protected ClienteLimCredito removeImpl(ClienteLimCredito clienteLimCredito)
		throws SystemException {
		clienteLimCredito = toUnwrappedModel(clienteLimCredito);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clienteLimCredito)) {
				clienteLimCredito = (ClienteLimCredito)session.get(ClienteLimCreditoImpl.class,
						clienteLimCredito.getPrimaryKeyObj());
			}

			if (clienteLimCredito != null) {
				session.delete(clienteLimCredito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (clienteLimCredito != null) {
			clearCache(clienteLimCredito);
		}

		return clienteLimCredito;
	}

	@Override
	public ClienteLimCredito updateImpl(
		br.com.prodevelopment.cliente.model.ClienteLimCredito clienteLimCredito)
		throws SystemException {
		clienteLimCredito = toUnwrappedModel(clienteLimCredito);

		boolean isNew = clienteLimCredito.isNew();

		Session session = null;

		try {
			session = openSession();

			if (clienteLimCredito.isNew()) {
				session.save(clienteLimCredito);

				clienteLimCredito.setNew(false);
			}
			else {
				session.merge(clienteLimCredito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ClienteLimCreditoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
			ClienteLimCreditoImpl.class, clienteLimCredito.getPrimaryKey(),
			clienteLimCredito);

		clearUniqueFindersCache(clienteLimCredito);
		cacheUniqueFindersCache(clienteLimCredito);

		return clienteLimCredito;
	}

	protected ClienteLimCredito toUnwrappedModel(
		ClienteLimCredito clienteLimCredito) {
		if (clienteLimCredito instanceof ClienteLimCreditoImpl) {
			return clienteLimCredito;
		}

		ClienteLimCreditoImpl clienteLimCreditoImpl = new ClienteLimCreditoImpl();

		clienteLimCreditoImpl.setNew(clienteLimCredito.isNew());
		clienteLimCreditoImpl.setPrimaryKey(clienteLimCredito.getPrimaryKey());

		clienteLimCreditoImpl.setClienteLimCreditoId(clienteLimCredito.getClienteLimCreditoId());
		clienteLimCreditoImpl.setValorLimiteMaximoCredito(clienteLimCredito.getValorLimiteMaximoCredito());
		clienteLimCreditoImpl.setDataLimiteMaximoCredito(clienteLimCredito.getDataLimiteMaximoCredito());
		clienteLimCreditoImpl.setValorLimiteMaximoCheque(clienteLimCredito.getValorLimiteMaximoCheque());
		clienteLimCreditoImpl.setQtdeLimiteMaximoCheque(clienteLimCredito.getQtdeLimiteMaximoCheque());
		clienteLimCreditoImpl.setClienteId(clienteLimCredito.getClienteId());

		return clienteLimCreditoImpl;
	}

	/**
	 * Returns the cliente lim credito with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente lim credito
	 * @return the cliente lim credito
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException if a cliente lim credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClienteLimCreditoException, SystemException {
		ClienteLimCredito clienteLimCredito = fetchByPrimaryKey(primaryKey);

		if (clienteLimCredito == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClienteLimCreditoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return clienteLimCredito;
	}

	/**
	 * Returns the cliente lim credito with the primary key or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException} if it could not be found.
	 *
	 * @param clienteLimCreditoId the primary key of the cliente lim credito
	 * @return the cliente lim credito
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException if a cliente lim credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito findByPrimaryKey(long clienteLimCreditoId)
		throws NoSuchClienteLimCreditoException, SystemException {
		return findByPrimaryKey((Serializable)clienteLimCreditoId);
	}

	/**
	 * Returns the cliente lim credito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente lim credito
	 * @return the cliente lim credito, or <code>null</code> if a cliente lim credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ClienteLimCredito clienteLimCredito = (ClienteLimCredito)EntityCacheUtil.getResult(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
				ClienteLimCreditoImpl.class, primaryKey);

		if (clienteLimCredito == _nullClienteLimCredito) {
			return null;
		}

		if (clienteLimCredito == null) {
			Session session = null;

			try {
				session = openSession();

				clienteLimCredito = (ClienteLimCredito)session.get(ClienteLimCreditoImpl.class,
						primaryKey);

				if (clienteLimCredito != null) {
					cacheResult(clienteLimCredito);
				}
				else {
					EntityCacheUtil.putResult(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
						ClienteLimCreditoImpl.class, primaryKey,
						_nullClienteLimCredito);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ClienteLimCreditoModelImpl.ENTITY_CACHE_ENABLED,
					ClienteLimCreditoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return clienteLimCredito;
	}

	/**
	 * Returns the cliente lim credito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteLimCreditoId the primary key of the cliente lim credito
	 * @return the cliente lim credito, or <code>null</code> if a cliente lim credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClienteLimCredito fetchByPrimaryKey(long clienteLimCreditoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)clienteLimCreditoId);
	}

	/**
	 * Returns all the cliente lim creditos.
	 *
	 * @return the cliente lim creditos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClienteLimCredito> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cliente lim creditos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteLimCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente lim creditos
	 * @param end the upper bound of the range of cliente lim creditos (not inclusive)
	 * @return the range of cliente lim creditos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClienteLimCredito> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cliente lim creditos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteLimCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente lim creditos
	 * @param end the upper bound of the range of cliente lim creditos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cliente lim creditos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClienteLimCredito> findAll(int start, int end,
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

		List<ClienteLimCredito> list = (List<ClienteLimCredito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CLIENTELIMCREDITO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTELIMCREDITO;

				if (pagination) {
					sql = sql.concat(ClienteLimCreditoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ClienteLimCredito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ClienteLimCredito>(list);
				}
				else {
					list = (List<ClienteLimCredito>)QueryUtil.list(q,
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
	 * Removes all the cliente lim creditos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ClienteLimCredito clienteLimCredito : findAll()) {
			remove(clienteLimCredito);
		}
	}

	/**
	 * Returns the number of cliente lim creditos.
	 *
	 * @return the number of cliente lim creditos
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

				Query q = session.createQuery(_SQL_COUNT_CLIENTELIMCREDITO);

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
	 * Initializes the cliente lim credito persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.cliente.model.ClienteLimCredito")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ClienteLimCredito>> listenersList = new ArrayList<ModelListener<ClienteLimCredito>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ClienteLimCredito>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ClienteLimCreditoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CLIENTELIMCREDITO = "SELECT clienteLimCredito FROM ClienteLimCredito clienteLimCredito";
	private static final String _SQL_SELECT_CLIENTELIMCREDITO_WHERE = "SELECT clienteLimCredito FROM ClienteLimCredito clienteLimCredito WHERE ";
	private static final String _SQL_COUNT_CLIENTELIMCREDITO = "SELECT COUNT(clienteLimCredito) FROM ClienteLimCredito clienteLimCredito";
	private static final String _SQL_COUNT_CLIENTELIMCREDITO_WHERE = "SELECT COUNT(clienteLimCredito) FROM ClienteLimCredito clienteLimCredito WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "clienteLimCredito.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ClienteLimCredito exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ClienteLimCredito exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ClienteLimCreditoPersistenceImpl.class);
	private static ClienteLimCredito _nullClienteLimCredito = new ClienteLimCreditoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ClienteLimCredito> toCacheModel() {
				return _nullClienteLimCreditoCacheModel;
			}
		};

	private static CacheModel<ClienteLimCredito> _nullClienteLimCreditoCacheModel =
		new CacheModel<ClienteLimCredito>() {
			@Override
			public ClienteLimCredito toEntityModel() {
				return _nullClienteLimCredito;
			}
		};
}