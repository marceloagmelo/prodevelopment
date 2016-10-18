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

import br.com.prodevelopment.cliente.NoSuchClienteException;
import br.com.prodevelopment.cliente.model.Cliente;
import br.com.prodevelopment.cliente.model.impl.ClienteImpl;
import br.com.prodevelopment.cliente.model.impl.ClienteModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the cliente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see ClientePersistence
 * @see ClienteUtil
 * @generated
 */
public class ClientePersistenceImpl extends BasePersistenceImpl<Cliente>
	implements ClientePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClienteUtil} to access the cliente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClienteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ClienteModelImpl.UUID_COLUMN_BITMASK |
			ClienteModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the clientes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Cliente> list = (List<Cliente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cliente cliente : list) {
				if (!Validator.equals(uuid, cliente.getUuid())) {
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

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cliente>(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first cliente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByUuid_First(uuid, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the first cliente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cliente> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByUuid_Last(uuid, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the last cliente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Cliente> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set where uuid = &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] findByUuid_PrevAndNext(long clienteId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = getByUuid_PrevAndNext(session, cliente, uuid,
					orderByComparator, true);

			array[1] = cliente;

			array[2] = getByUuid_PrevAndNext(session, cliente, uuid,
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

	protected Cliente getByUuid_PrevAndNext(Session session, Cliente cliente,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLIENTE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			query.append(ClienteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clientes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Cliente cliente : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "cliente.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "cliente.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(cliente.uuid IS NULL OR cliente.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ClienteModelImpl.UUID_COLUMN_BITMASK |
			ClienteModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the cliente where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByUUID_G(String uuid, long groupId)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByUUID_G(uuid, groupId);

		if (cliente == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchClienteException(msg.toString());
		}

		return cliente;
	}

	/**
	 * Returns the cliente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the cliente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Cliente) {
			Cliente cliente = (Cliente)result;

			if (!Validator.equals(uuid, cliente.getUuid()) ||
					(groupId != cliente.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Cliente> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Cliente cliente = list.get(0);

					result = cliente;

					cacheResult(cliente);

					if ((cliente.getUuid() == null) ||
							!cliente.getUuid().equals(uuid) ||
							(cliente.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, cliente);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (Cliente)result;
		}
	}

	/**
	 * Removes the cliente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cliente that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente removeByUUID_G(String uuid, long groupId)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByUUID_G(uuid, groupId);

		return remove(cliente);
	}

	/**
	 * Returns the number of clientes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "cliente.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "cliente.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(cliente.uuid IS NULL OR cliente.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "cliente.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ClienteModelImpl.UUID_COLUMN_BITMASK |
			ClienteModelImpl.COMPANYID_COLUMN_BITMASK |
			ClienteModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the clientes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Cliente> list = (List<Cliente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cliente cliente : list) {
				if (!Validator.equals(uuid, cliente.getUuid()) ||
						(companyId != cliente.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cliente>(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the first cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cliente> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the last cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Cliente> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] findByUuid_C_PrevAndNext(long clienteId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, cliente, uuid,
					companyId, orderByComparator, true);

			array[1] = cliente;

			array[2] = getByUuid_C_PrevAndNext(session, cliente, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cliente getByUuid_C_PrevAndNext(Session session, Cliente cliente,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLIENTE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(ClienteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clientes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Cliente cliente : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "cliente.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "cliente.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(cliente.uuid IS NULL OR cliente.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "cliente.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			ClienteModelImpl.COMPANYID_COLUMN_BITMASK |
			ClienteModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the clientes where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the clientes where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByCompany(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Cliente> list = (List<Cliente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cliente cliente : list) {
				if ((companyId != cliente.getCompanyId())) {
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

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cliente>(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first cliente in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByCompany_First(companyId, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the first cliente in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cliente> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByCompany_Last(companyId, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the last cliente in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Cliente> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set where companyId = &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] findByCompany_PrevAndNext(long clienteId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = getByCompany_PrevAndNext(session, cliente, companyId,
					orderByComparator, true);

			array[1] = cliente;

			array[2] = getByCompany_PrevAndNext(session, cliente, companyId,
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

	protected Cliente getByCompany_PrevAndNext(Session session,
		Cliente cliente, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLIENTE_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			query.append(ClienteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clientes where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Cliente cliente : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompany(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANY;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "cliente.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			ClienteModelImpl.COMPANYID_COLUMN_BITMASK |
			ClienteModelImpl.GROUPID_COLUMN_BITMASK |
			ClienteModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the clientes where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Cliente> list = (List<Cliente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cliente cliente : list) {
				if ((companyId != cliente.getCompanyId()) ||
						(groupId != cliente.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cliente>(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByC_G_First(companyId, groupId, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the first cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cliente> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByC_G_Last(companyId, groupId, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the last cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Cliente> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] findByC_G_PrevAndNext(long clienteId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = getByC_G_PrevAndNext(session, cliente, companyId,
					groupId, orderByComparator, true);

			array[1] = cliente;

			array[2] = getByC_G_PrevAndNext(session, cliente, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cliente getByC_G_PrevAndNext(Session session, Cliente cliente,
		long companyId, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLIENTE_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

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
			query.append(ClienteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the clientes that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching clientes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> filterFindByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> filterFindByC_G(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G(companyId, groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CLIENTE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ClienteModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cliente.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ClienteImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ClienteImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<Cliente>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set of clientes that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] filterFindByC_G_PrevAndNext(long clienteId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(clienteId, companyId, groupId,
				orderByComparator);
		}

		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, cliente, companyId,
					groupId, orderByComparator, true);

			array[1] = cliente;

			array[2] = filterGetByC_G_PrevAndNext(session, cliente, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cliente filterGetByC_G_PrevAndNext(Session session,
		Cliente cliente, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CLIENTE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ClienteModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cliente.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ClienteImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ClienteImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clientes where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (Cliente cliente : findByC_G(companyId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	/**
	 * Returns the number of clientes that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching clientes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CLIENTE_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cliente.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "cliente.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "cliente.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_NOME",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOME = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NOME",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the clientes where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_NOME(long companyId, String nome)
		throws SystemException {
		return findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_NOME(long companyId, String nome, int start,
		int end) throws SystemException {
		return findByC_NOME(companyId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_NOME(long companyId, String nome, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME;
		finderArgs = new Object[] { companyId, nome, start, end, orderByComparator };

		List<Cliente> list = (List<Cliente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cliente cliente : list) {
				if ((companyId != cliente.getCompanyId()) ||
						!StringUtil.wildcardMatches(cliente.getNome(), nome,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_C_NOME_COMPANYID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_C_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_C_NOME_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindNome) {
					qPos.add(nome);
				}

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cliente>(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByC_NOME_First(companyId, nome, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the first cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cliente> list = findByC_NOME(companyId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByC_NOME_Last(companyId, nome, orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the last cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_NOME(companyId, nome);

		if (count == 0) {
			return null;
		}

		List<Cliente> list = findByC_NOME(companyId, nome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] findByC_NOME_PrevAndNext(long clienteId, long companyId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = getByC_NOME_PrevAndNext(session, cliente, companyId,
					nome, orderByComparator, true);

			array[1] = cliente;

			array[2] = getByC_NOME_PrevAndNext(session, cliente, companyId,
					nome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cliente getByC_NOME_PrevAndNext(Session session, Cliente cliente,
		long companyId, String nome, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLIENTE_WHERE);

		query.append(_FINDER_COLUMN_C_NOME_COMPANYID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_NOME_NOME_2);
		}

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
			query.append(ClienteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clientes where companyId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_NOME(long companyId, String nome)
		throws SystemException {
		for (Cliente cliente : findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_NOME(long companyId, String nome)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOME;

		Object[] finderArgs = new Object[] { companyId, nome };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_C_NOME_COMPANYID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_C_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_C_NOME_NOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindNome) {
					qPos.add(nome);
				}

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

	private static final String _FINDER_COLUMN_C_NOME_COMPANYID_2 = "cliente.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_NOME_NOME_1 = "cliente.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_NOME_NOME_2 = "cliente.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_NOME_NOME_3 = "(cliente.nome IS NULL OR cliente.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_NOME = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_NOME =
		new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_NOME;
		finderArgs = new Object[] {
				companyId, groupId, nome,
				
				start, end, orderByComparator
			};

		List<Cliente> list = (List<Cliente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cliente cliente : list) {
				if ((companyId != cliente.getCompanyId()) ||
						(groupId != cliente.getGroupId()) ||
						!StringUtil.wildcardMatches(cliente.getNome(), nome,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNome) {
					qPos.add(nome);
				}

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cliente>(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByC_G_NOME_First(companyId, groupId, nome,
				orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the first cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		List<Cliente> list = findByC_G_NOME(companyId, groupId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByC_G_NOME_Last(companyId, groupId, nome,
				orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the last cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_NOME(companyId, groupId, nome);

		if (count == 0) {
			return null;
		}

		List<Cliente> list = findByC_G_NOME(companyId, groupId, nome,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] findByC_G_NOME_PrevAndNext(long clienteId, long companyId,
		long groupId, String nome, OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = getByC_G_NOME_PrevAndNext(session, cliente, companyId,
					groupId, nome, orderByComparator, true);

			array[1] = cliente;

			array[2] = getByC_G_NOME_PrevAndNext(session, cliente, companyId,
					groupId, nome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cliente getByC_G_NOME_PrevAndNext(Session session,
		Cliente cliente, long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLIENTE_WHERE);

		query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
		}

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
			query.append(ClienteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the clientes that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching clientes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> filterFindByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> filterFindByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> filterFindByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_NOME(companyId, groupId, nome, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CLIENTE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ClienteModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cliente.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ClienteImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ClienteImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindNome) {
				qPos.add(nome);
			}

			return (List<Cliente>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set of clientes that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] filterFindByC_G_NOME_PrevAndNext(long clienteId,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_NOME_PrevAndNext(clienteId, companyId, groupId,
				nome, orderByComparator);
		}

		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = filterGetByC_G_NOME_PrevAndNext(session, cliente,
					companyId, groupId, nome, orderByComparator, true);

			array[1] = cliente;

			array[2] = filterGetByC_G_NOME_PrevAndNext(session, cliente,
					companyId, groupId, nome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cliente filterGetByC_G_NOME_PrevAndNext(Session session,
		Cliente cliente, long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CLIENTE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ClienteModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cliente.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ClienteImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ClienteImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		for (Cliente cliente : findByC_G_NOME(companyId, groupId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_NOME;

		Object[] finderArgs = new Object[] { companyId, groupId, nome };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNome) {
					qPos.add(nome);
				}

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

	/**
	 * Returns the number of clientes that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching clientes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G_NOME(companyId, groupId, nome);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CLIENTE_WHERE);

		query.append(_FINDER_COLUMN_C_G_NOME_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_NOME_GROUPID_2);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_C_G_NOME_NOME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cliente.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindNome) {
				qPos.add(nome);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_C_G_NOME_COMPANYID_2 = "cliente.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_GROUPID_2 = "cliente.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_1 = "cliente.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_2 = "cliente.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_3 = "(cliente.nome IS NULL OR cliente.nome LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CPF_CNPJ = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCPF_CNPJ",
			new String[] { String.class.getName() },
			ClienteModelImpl.CPFCNPJ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CPF_CNPJ = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCPF_CNPJ",
			new String[] { String.class.getName() });

	/**
	 * Returns the cliente where cpfCnpj = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteException} if it could not be found.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByCPF_CNPJ(String cpfCnpj)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByCPF_CNPJ(cpfCnpj);

		if (cliente == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cpfCnpj=");
			msg.append(cpfCnpj);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchClienteException(msg.toString());
		}

		return cliente;
	}

	/**
	 * Returns the cliente where cpfCnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByCPF_CNPJ(String cpfCnpj) throws SystemException {
		return fetchByCPF_CNPJ(cpfCnpj, true);
	}

	/**
	 * Returns the cliente where cpfCnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByCPF_CNPJ(String cpfCnpj, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cpfCnpj };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
					finderArgs, this);
		}

		if (result instanceof Cliente) {
			Cliente cliente = (Cliente)result;

			if (!Validator.equals(cpfCnpj, cliente.getCpfCnpj())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			boolean bindCpfCnpj = false;

			if (cpfCnpj == null) {
				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_1);
			}
			else if (cpfCnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_3);
			}
			else {
				bindCpfCnpj = true;

				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpfCnpj) {
					qPos.add(cpfCnpj);
				}

				List<Cliente> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ClientePersistenceImpl.fetchByCPF_CNPJ(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Cliente cliente = list.get(0);

					result = cliente;

					cacheResult(cliente);

					if ((cliente.getCpfCnpj() == null) ||
							!cliente.getCpfCnpj().equals(cpfCnpj)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
							finderArgs, cliente);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
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
			return (Cliente)result;
		}
	}

	/**
	 * Removes the cliente where cpfCnpj = &#63; from the database.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the cliente that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente removeByCPF_CNPJ(String cpfCnpj)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByCPF_CNPJ(cpfCnpj);

		return remove(cliente);
	}

	/**
	 * Returns the number of clientes where cpfCnpj = &#63;.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCPF_CNPJ(String cpfCnpj) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CPF_CNPJ;

		Object[] finderArgs = new Object[] { cpfCnpj };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			boolean bindCpfCnpj = false;

			if (cpfCnpj == null) {
				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_1);
			}
			else if (cpfCnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_3);
			}
			else {
				bindCpfCnpj = true;

				query.append(_FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpfCnpj) {
					qPos.add(cpfCnpj);
				}

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

	private static final String _FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_1 = "cliente.cpfCnpj IS NULL";
	private static final String _FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_2 = "cliente.cpfCnpj = ?";
	private static final String _FINDER_COLUMN_CPF_CNPJ_CPFCNPJ_3 = "(cliente.cpfCnpj IS NULL OR cliente.cpfCnpj = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_RG_INSCRICAO = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRG_INSCRICAO",
			new String[] { String.class.getName() },
			ClienteModelImpl.RGINSCRICAOMUN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RG_INSCRICAO = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRG_INSCRICAO",
			new String[] { String.class.getName() });

	/**
	 * Returns the cliente where rgInscricaoMun = &#63; or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteException} if it could not be found.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @return the matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByRG_INSCRICAO(String rgInscricaoMun)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByRG_INSCRICAO(rgInscricaoMun);

		if (cliente == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rgInscricaoMun=");
			msg.append(rgInscricaoMun);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchClienteException(msg.toString());
		}

		return cliente;
	}

	/**
	 * Returns the cliente where rgInscricaoMun = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByRG_INSCRICAO(String rgInscricaoMun)
		throws SystemException {
		return fetchByRG_INSCRICAO(rgInscricaoMun, true);
	}

	/**
	 * Returns the cliente where rgInscricaoMun = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByRG_INSCRICAO(String rgInscricaoMun,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { rgInscricaoMun };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
					finderArgs, this);
		}

		if (result instanceof Cliente) {
			Cliente cliente = (Cliente)result;

			if (!Validator.equals(rgInscricaoMun, cliente.getRgInscricaoMun())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			boolean bindRgInscricaoMun = false;

			if (rgInscricaoMun == null) {
				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_1);
			}
			else if (rgInscricaoMun.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_3);
			}
			else {
				bindRgInscricaoMun = true;

				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRgInscricaoMun) {
					qPos.add(rgInscricaoMun);
				}

				List<Cliente> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ClientePersistenceImpl.fetchByRG_INSCRICAO(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Cliente cliente = list.get(0);

					result = cliente;

					cacheResult(cliente);

					if ((cliente.getRgInscricaoMun() == null) ||
							!cliente.getRgInscricaoMun().equals(rgInscricaoMun)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
							finderArgs, cliente);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
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
			return (Cliente)result;
		}
	}

	/**
	 * Removes the cliente where rgInscricaoMun = &#63; from the database.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @return the cliente that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente removeByRG_INSCRICAO(String rgInscricaoMun)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByRG_INSCRICAO(rgInscricaoMun);

		return remove(cliente);
	}

	/**
	 * Returns the number of clientes where rgInscricaoMun = &#63;.
	 *
	 * @param rgInscricaoMun the rg inscricao mun
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRG_INSCRICAO(String rgInscricaoMun)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RG_INSCRICAO;

		Object[] finderArgs = new Object[] { rgInscricaoMun };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			boolean bindRgInscricaoMun = false;

			if (rgInscricaoMun == null) {
				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_1);
			}
			else if (rgInscricaoMun.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_3);
			}
			else {
				bindRgInscricaoMun = true;

				query.append(_FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRgInscricaoMun) {
					qPos.add(rgInscricaoMun);
				}

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

	private static final String _FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_1 = "cliente.rgInscricaoMun IS NULL";
	private static final String _FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_2 = "cliente.rgInscricaoMun = ?";
	private static final String _FINDER_COLUMN_RG_INSCRICAO_RGINSCRICAOMUN_3 = "(cliente.rgInscricaoMun IS NULL OR cliente.rgInscricaoMun = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DT_NASCIMENTO =
		new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDT_NASCIMENTO",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO =
		new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDT_NASCIMENTO",
			new String[] { Date.class.getName() },
			ClienteModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			ClienteModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DT_NASCIMENTO = new FinderPath(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDT_NASCIMENTO",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the clientes where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByDT_NASCIMENTO(Date dataNascimento)
		throws SystemException {
		return findByDT_NASCIMENTO(dataNascimento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByDT_NASCIMENTO(Date dataNascimento, int start,
		int end) throws SystemException {
		return findByDT_NASCIMENTO(dataNascimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findByDT_NASCIMENTO(Date dataNascimento, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO;
			finderArgs = new Object[] { dataNascimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DT_NASCIMENTO;
			finderArgs = new Object[] {
					dataNascimento,
					
					start, end, orderByComparator
				};
		}

		List<Cliente> list = (List<Cliente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cliente cliente : list) {
				if (!Validator.equals(dataNascimento,
							cliente.getDataNascimento())) {
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

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClienteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDataNascimento) {
					qPos.add(CalendarUtil.getTimestamp(dataNascimento));
				}

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cliente>(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first cliente in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByDT_NASCIMENTO_First(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByDT_NASCIMENTO_First(dataNascimento,
				orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the first cliente in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByDT_NASCIMENTO_First(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cliente> list = findByDT_NASCIMENTO(dataNascimento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByDT_NASCIMENTO_Last(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByDT_NASCIMENTO_Last(dataNascimento,
				orderByComparator);

		if (cliente != null) {
			return cliente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClienteException(msg.toString());
	}

	/**
	 * Returns the last cliente in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente, or <code>null</code> if a matching cliente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByDT_NASCIMENTO_Last(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDT_NASCIMENTO(dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Cliente> list = findByDT_NASCIMENTO(dataNascimento, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clientes before and after the current cliente in the ordered set where dataNascimento = &#63;.
	 *
	 * @param clienteId the primary key of the current cliente
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente[] findByDT_NASCIMENTO_PrevAndNext(long clienteId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Cliente[] array = new ClienteImpl[3];

			array[0] = getByDT_NASCIMENTO_PrevAndNext(session, cliente,
					dataNascimento, orderByComparator, true);

			array[1] = cliente;

			array[2] = getByDT_NASCIMENTO_PrevAndNext(session, cliente,
					dataNascimento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cliente getByDT_NASCIMENTO_PrevAndNext(Session session,
		Cliente cliente, Date dataNascimento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLIENTE_WHERE);

		boolean bindDataNascimento = false;

		if (dataNascimento == null) {
			query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1);
		}
		else {
			bindDataNascimento = true;

			query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2);
		}

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
			query.append(ClienteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDataNascimento) {
			qPos.add(CalendarUtil.getTimestamp(dataNascimento));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cliente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cliente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clientes where dataNascimento = &#63; from the database.
	 *
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDT_NASCIMENTO(Date dataNascimento)
		throws SystemException {
		for (Cliente cliente : findByDT_NASCIMENTO(dataNascimento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the number of matching clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDT_NASCIMENTO(Date dataNascimento)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DT_NASCIMENTO;

		Object[] finderArgs = new Object[] { dataNascimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDataNascimento) {
					qPos.add(CalendarUtil.getTimestamp(dataNascimento));
				}

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

	private static final String _FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1 = "cliente.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2 = "cliente.dataNascimento = ?";

	public ClientePersistenceImpl() {
		setModelClass(Cliente.class);
	}

	/**
	 * Caches the cliente in the entity cache if it is enabled.
	 *
	 * @param cliente the cliente
	 */
	@Override
	public void cacheResult(Cliente cliente) {
		EntityCacheUtil.putResult(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteImpl.class, cliente.getPrimaryKey(), cliente);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { cliente.getUuid(), cliente.getGroupId() }, cliente);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ,
			new Object[] { cliente.getCpfCnpj() }, cliente);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
			new Object[] { cliente.getRgInscricaoMun() }, cliente);

		cliente.resetOriginalValues();
	}

	/**
	 * Caches the clientes in the entity cache if it is enabled.
	 *
	 * @param clientes the clientes
	 */
	@Override
	public void cacheResult(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			if (EntityCacheUtil.getResult(
						ClienteModelImpl.ENTITY_CACHE_ENABLED,
						ClienteImpl.class, cliente.getPrimaryKey()) == null) {
				cacheResult(cliente);
			}
			else {
				cliente.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all clientes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ClienteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ClienteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cliente.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cliente cliente) {
		EntityCacheUtil.removeResult(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteImpl.class, cliente.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cliente);
	}

	@Override
	public void clearCache(List<Cliente> clientes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cliente cliente : clientes) {
			EntityCacheUtil.removeResult(ClienteModelImpl.ENTITY_CACHE_ENABLED,
				ClienteImpl.class, cliente.getPrimaryKey());

			clearUniqueFindersCache(cliente);
		}
	}

	protected void cacheUniqueFindersCache(Cliente cliente) {
		if (cliente.isNew()) {
			Object[] args = new Object[] { cliente.getUuid(), cliente.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, cliente);

			args = new Object[] { cliente.getCpfCnpj() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CPF_CNPJ, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ, args,
				cliente);

			args = new Object[] { cliente.getRgInscricaoMun() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RG_INSCRICAO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO, args,
				cliente);
		}
		else {
			ClienteModelImpl clienteModelImpl = (ClienteModelImpl)cliente;

			if ((clienteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cliente.getUuid(), cliente.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					cliente);
			}

			if ((clienteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CPF_CNPJ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cliente.getCpfCnpj() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CPF_CNPJ, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF_CNPJ, args,
					cliente);
			}

			if ((clienteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RG_INSCRICAO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cliente.getRgInscricaoMun() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RG_INSCRICAO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO,
					args, cliente);
			}
		}
	}

	protected void clearUniqueFindersCache(Cliente cliente) {
		ClienteModelImpl clienteModelImpl = (ClienteModelImpl)cliente;

		Object[] args = new Object[] { cliente.getUuid(), cliente.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((clienteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					clienteModelImpl.getOriginalUuid(),
					clienteModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { cliente.getCpfCnpj() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CPF_CNPJ, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF_CNPJ, args);

		if ((clienteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CPF_CNPJ.getColumnBitmask()) != 0) {
			args = new Object[] { clienteModelImpl.getOriginalCpfCnpj() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CPF_CNPJ, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF_CNPJ, args);
		}

		args = new Object[] { cliente.getRgInscricaoMun() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RG_INSCRICAO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO, args);

		if ((clienteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RG_INSCRICAO.getColumnBitmask()) != 0) {
			args = new Object[] { clienteModelImpl.getOriginalRgInscricaoMun() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RG_INSCRICAO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG_INSCRICAO, args);
		}
	}

	/**
	 * Creates a new cliente with the primary key. Does not add the cliente to the database.
	 *
	 * @param clienteId the primary key for the new cliente
	 * @return the new cliente
	 */
	@Override
	public Cliente create(long clienteId) {
		Cliente cliente = new ClienteImpl();

		cliente.setNew(true);
		cliente.setPrimaryKey(clienteId);

		String uuid = PortalUUIDUtil.generate();

		cliente.setUuid(uuid);

		return cliente;
	}

	/**
	 * Removes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente that was removed
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente remove(long clienteId)
		throws NoSuchClienteException, SystemException {
		return remove((Serializable)clienteId);
	}

	/**
	 * Removes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cliente
	 * @return the cliente that was removed
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente remove(Serializable primaryKey)
		throws NoSuchClienteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Cliente cliente = (Cliente)session.get(ClienteImpl.class, primaryKey);

			if (cliente == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClienteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cliente);
		}
		catch (NoSuchClienteException nsee) {
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
	protected Cliente removeImpl(Cliente cliente) throws SystemException {
		cliente = toUnwrappedModel(cliente);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cliente)) {
				cliente = (Cliente)session.get(ClienteImpl.class,
						cliente.getPrimaryKeyObj());
			}

			if (cliente != null) {
				session.delete(cliente);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cliente != null) {
			clearCache(cliente);
		}

		return cliente;
	}

	@Override
	public Cliente updateImpl(
		br.com.prodevelopment.cliente.model.Cliente cliente)
		throws SystemException {
		cliente = toUnwrappedModel(cliente);

		boolean isNew = cliente.isNew();

		ClienteModelImpl clienteModelImpl = (ClienteModelImpl)cliente;

		if (Validator.isNull(cliente.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cliente.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (cliente.isNew()) {
				session.save(cliente);

				cliente.setNew(false);
			}
			else {
				session.merge(cliente);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ClienteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((clienteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { clienteModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { clienteModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((clienteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						clienteModelImpl.getOriginalUuid(),
						clienteModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						clienteModelImpl.getUuid(),
						clienteModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((clienteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						clienteModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { clienteModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((clienteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						clienteModelImpl.getOriginalCompanyId(),
						clienteModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						clienteModelImpl.getCompanyId(),
						clienteModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((clienteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						clienteModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DT_NASCIMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO,
					args);

				args = new Object[] { clienteModelImpl.getDataNascimento() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DT_NASCIMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(ClienteModelImpl.ENTITY_CACHE_ENABLED,
			ClienteImpl.class, cliente.getPrimaryKey(), cliente);

		clearUniqueFindersCache(cliente);
		cacheUniqueFindersCache(cliente);

		return cliente;
	}

	protected Cliente toUnwrappedModel(Cliente cliente) {
		if (cliente instanceof ClienteImpl) {
			return cliente;
		}

		ClienteImpl clienteImpl = new ClienteImpl();

		clienteImpl.setNew(cliente.isNew());
		clienteImpl.setPrimaryKey(cliente.getPrimaryKey());

		clienteImpl.setUuid(cliente.getUuid());
		clienteImpl.setClienteId(cliente.getClienteId());
		clienteImpl.setCompanyId(cliente.getCompanyId());
		clienteImpl.setGroupId(cliente.getGroupId());
		clienteImpl.setCreateUserId(cliente.getCreateUserId());
		clienteImpl.setModifiedUserId(cliente.getModifiedUserId());
		clienteImpl.setCreateDate(cliente.getCreateDate());
		clienteImpl.setModifiedDate(cliente.getModifiedDate());
		clienteImpl.setNome(cliente.getNome());
		clienteImpl.setRgInscricaoMun(cliente.getRgInscricaoMun());
		clienteImpl.setRgOrgaoEmissor(cliente.getRgOrgaoEmissor());
		clienteImpl.setRgDataEmissao(cliente.getRgDataEmissao());
		clienteImpl.setTipoPessoa(cliente.getTipoPessoa());
		clienteImpl.setCpfCnpj(cliente.getCpfCnpj());
		clienteImpl.setSexo(cliente.getSexo());
		clienteImpl.setEstadoCivil(cliente.getEstadoCivil());
		clienteImpl.setDataNascimento(cliente.getDataNascimento());
		clienteImpl.setEndComLogradouro(cliente.getEndComLogradouro());
		clienteImpl.setEndComNumero(cliente.getEndComNumero());
		clienteImpl.setEndComComplemento(cliente.getEndComComplemento());
		clienteImpl.setEndComCep(cliente.getEndComCep());
		clienteImpl.setEndComBairro(cliente.getEndComBairro());
		clienteImpl.setEndComCidade(cliente.getEndComCidade());
		clienteImpl.setEndComUf(cliente.getEndComUf());
		clienteImpl.setEndComPais(cliente.getEndComPais());
		clienteImpl.setEndResLogradouro(cliente.getEndResLogradouro());
		clienteImpl.setEndResNumero(cliente.getEndResNumero());
		clienteImpl.setEndResComplemento(cliente.getEndResComplemento());
		clienteImpl.setEndResCep(cliente.getEndResCep());
		clienteImpl.setEndResBairro(cliente.getEndResBairro());
		clienteImpl.setEndResCidade(cliente.getEndResCidade());
		clienteImpl.setEndResUf(cliente.getEndResUf());
		clienteImpl.setEndResPais(cliente.getEndResPais());
		clienteImpl.setTelComDdd(cliente.getTelComDdd());
		clienteImpl.setVersao(cliente.getVersao());
		clienteImpl.setLogoTipoId(cliente.getLogoTipoId());
		clienteImpl.setObservacao(cliente.getObservacao());

		return clienteImpl;
	}

	/**
	 * Returns the cliente with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente
	 * @return the cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClienteException, SystemException {
		Cliente cliente = fetchByPrimaryKey(primaryKey);

		if (cliente == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClienteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cliente;
	}

	/**
	 * Returns the cliente with the primary key or throws a {@link br.com.prodevelopment.cliente.NoSuchClienteException} if it could not be found.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente
	 * @throws br.com.prodevelopment.cliente.NoSuchClienteException if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente findByPrimaryKey(long clienteId)
		throws NoSuchClienteException, SystemException {
		return findByPrimaryKey((Serializable)clienteId);
	}

	/**
	 * Returns the cliente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente
	 * @return the cliente, or <code>null</code> if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Cliente cliente = (Cliente)EntityCacheUtil.getResult(ClienteModelImpl.ENTITY_CACHE_ENABLED,
				ClienteImpl.class, primaryKey);

		if (cliente == _nullCliente) {
			return null;
		}

		if (cliente == null) {
			Session session = null;

			try {
				session = openSession();

				cliente = (Cliente)session.get(ClienteImpl.class, primaryKey);

				if (cliente != null) {
					cacheResult(cliente);
				}
				else {
					EntityCacheUtil.putResult(ClienteModelImpl.ENTITY_CACHE_ENABLED,
						ClienteImpl.class, primaryKey, _nullCliente);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ClienteModelImpl.ENTITY_CACHE_ENABLED,
					ClienteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cliente;
	}

	/**
	 * Returns the cliente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente, or <code>null</code> if a cliente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cliente fetchByPrimaryKey(long clienteId) throws SystemException {
		return fetchByPrimaryKey((Serializable)clienteId);
	}

	/**
	 * Returns all the clientes.
	 *
	 * @return the clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.cliente.model.impl.ClienteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clientes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cliente> findAll(int start, int end,
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

		List<Cliente> list = (List<Cliente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CLIENTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTE;

				if (pagination) {
					sql = sql.concat(ClienteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cliente>(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the clientes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Cliente cliente : findAll()) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes.
	 *
	 * @return the number of clientes
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

				Query q = session.createQuery(_SQL_COUNT_CLIENTE);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the cliente persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.cliente.model.Cliente")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Cliente>> listenersList = new ArrayList<ModelListener<Cliente>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Cliente>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ClienteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CLIENTE = "SELECT cliente FROM Cliente cliente";
	private static final String _SQL_SELECT_CLIENTE_WHERE = "SELECT cliente FROM Cliente cliente WHERE ";
	private static final String _SQL_COUNT_CLIENTE = "SELECT COUNT(cliente) FROM Cliente cliente";
	private static final String _SQL_COUNT_CLIENTE_WHERE = "SELECT COUNT(cliente) FROM Cliente cliente WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "cliente.clienteId";
	private static final String _FILTER_SQL_SELECT_CLIENTE_WHERE = "SELECT DISTINCT {cliente.*} FROM Cliente cliente WHERE ";
	private static final String _FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Cliente.*} FROM (SELECT DISTINCT cliente.clienteId FROM Cliente cliente WHERE ";
	private static final String _FILTER_SQL_SELECT_CLIENTE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Cliente ON TEMP_TABLE.clienteId = Cliente.clienteId";
	private static final String _FILTER_SQL_COUNT_CLIENTE_WHERE = "SELECT COUNT(DISTINCT cliente.clienteId) AS COUNT_VALUE FROM Cliente cliente WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "cliente";
	private static final String _FILTER_ENTITY_TABLE = "Cliente";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cliente.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Cliente.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Cliente exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Cliente exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ClientePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Cliente _nullCliente = new ClienteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Cliente> toCacheModel() {
				return _nullClienteCacheModel;
			}
		};

	private static CacheModel<Cliente> _nullClienteCacheModel = new CacheModel<Cliente>() {
			@Override
			public Cliente toEntityModel() {
				return _nullCliente;
			}
		};
}