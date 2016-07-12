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

package br.com.prodevelopment.atividade.service.persistence;

import br.com.prodevelopment.atividade.NoSuchAtividadeException;
import br.com.prodevelopment.atividade.model.Atividade;
import br.com.prodevelopment.atividade.model.impl.AtividadeImpl;
import br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl;

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
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the atividade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo
 * @see AtividadePersistence
 * @see AtividadeUtil
 * @generated
 */
public class AtividadePersistenceImpl extends BasePersistenceImpl<Atividade>
	implements AtividadePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AtividadeUtil} to access the atividade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AtividadeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AtividadeModelImpl.UUID_COLUMN_BITMASK |
			AtividadeModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the atividades where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByUuid(String uuid, int start, int end,
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

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Atividade atividade : list) {
				if (!Validator.equals(uuid, atividade.getUuid())) {
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

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first atividade in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByUuid_First(uuid, orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the first atividade in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Atividade> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last atividade in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByUuid_Last(uuid, orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the last atividade in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Atividade> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set where uuid = &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] findByUuid_PrevAndNext(long atividadeId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, atividade, uuid,
					orderByComparator, true);

			array[1] = atividade;

			array[2] = getByUuid_PrevAndNext(session, atividade, uuid,
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

	protected Atividade getByUuid_PrevAndNext(Session session,
		Atividade atividade, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
			query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the atividades where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Atividade atividade : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching atividades
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

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "atividade.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "atividade.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(atividade.uuid IS NULL OR atividade.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			AtividadeModelImpl.UUID_COLUMN_BITMASK |
			AtividadeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the atividade where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.atividade.NoSuchAtividadeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByUUID_G(String uuid, long groupId)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByUUID_G(uuid, groupId);

		if (atividade == null) {
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

			throw new NoSuchAtividadeException(msg.toString());
		}

		return atividade;
	}

	/**
	 * Returns the atividade where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the atividade where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Atividade) {
			Atividade atividade = (Atividade)result;

			if (!Validator.equals(uuid, atividade.getUuid()) ||
					(groupId != atividade.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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

				List<Atividade> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Atividade atividade = list.get(0);

					result = atividade;

					cacheResult(atividade);

					if ((atividade.getUuid() == null) ||
							!atividade.getUuid().equals(uuid) ||
							(atividade.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, atividade);
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
			return (Atividade)result;
		}
	}

	/**
	 * Removes the atividade where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the atividade that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade removeByUUID_G(String uuid, long groupId)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByUUID_G(uuid, groupId);

		return remove(atividade);
	}

	/**
	 * Returns the number of atividades where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching atividades
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

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "atividade.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "atividade.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(atividade.uuid IS NULL OR atividade.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "atividade.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AtividadeModelImpl.UUID_COLUMN_BITMASK |
			AtividadeModelImpl.COMPANYID_COLUMN_BITMASK |
			AtividadeModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the atividades where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByUuid_C(String uuid, long companyId, int start,
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

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Atividade atividade : list) {
				if (!Validator.equals(uuid, atividade.getUuid()) ||
						(companyId != atividade.getCompanyId())) {
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

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the first atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Atividade> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the last atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Atividade> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] findByUuid_C_PrevAndNext(long atividadeId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, atividade, uuid,
					companyId, orderByComparator, true);

			array[1] = atividade;

			array[2] = getByUuid_C_PrevAndNext(session, atividade, uuid,
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

	protected Atividade getByUuid_C_PrevAndNext(Session session,
		Atividade atividade, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
			query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the atividades where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Atividade atividade : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching atividades
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

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "atividade.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "atividade.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(atividade.uuid IS NULL OR atividade.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "atividade.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			AtividadeModelImpl.COMPANYID_COLUMN_BITMASK |
			AtividadeModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the atividades where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the atividades where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByCompany(long companyId, int start, int end,
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

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Atividade atividade : list) {
				if ((companyId != atividade.getCompanyId())) {
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

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first atividade in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByCompany_First(companyId, orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the first atividade in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Atividade> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByCompany_Last(companyId, orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Atividade> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set where companyId = &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] findByCompany_PrevAndNext(long atividadeId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = getByCompany_PrevAndNext(session, atividade, companyId,
					orderByComparator, true);

			array[1] = atividade;

			array[2] = getByCompany_PrevAndNext(session, atividade, companyId,
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

	protected Atividade getByCompany_PrevAndNext(Session session,
		Atividade atividade, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
			query.append(AtividadeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the atividades where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Atividade atividade : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching atividades
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

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "atividade.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			AtividadeModelImpl.COMPANYID_COLUMN_BITMASK |
			AtividadeModelImpl.GROUPID_COLUMN_BITMASK |
			AtividadeModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the atividades where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G(long companyId, long groupId, int start,
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

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Atividade atividade : list) {
				if ((companyId != atividade.getCompanyId()) ||
						(groupId != atividade.getGroupId())) {
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

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_G_First(companyId, groupId,
				orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Atividade> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_G_Last(companyId, groupId,
				orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Atividade> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] findByC_G_PrevAndNext(long atividadeId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = getByC_G_PrevAndNext(session, atividade, companyId,
					groupId, orderByComparator, true);

			array[1] = atividade;

			array[2] = getByC_G_PrevAndNext(session, atividade, companyId,
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

	protected Atividade getByC_G_PrevAndNext(Session session,
		Atividade atividade, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
			query.append(AtividadeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G(long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AtividadeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AtividadeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AtividadeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<Atividade>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] filterFindByC_G_PrevAndNext(long atividadeId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(atividadeId, companyId, groupId,
				orderByComparator);
		}

		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, atividade,
					companyId, groupId, orderByComparator, true);

			array[1] = atividade;

			array[2] = filterGetByC_G_PrevAndNext(session, atividade,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Atividade filterGetByC_G_PrevAndNext(Session session,
		Atividade atividade, long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AtividadeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AtividadeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AtividadeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the atividades where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (Atividade atividade : findByC_G(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching atividades
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

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

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
	 * Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_ATIVIDADE_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

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

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "atividade.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "atividade.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_NOME",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOME = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NOME",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the atividades where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_NOME(long companyId, String nome)
		throws SystemException {
		return findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_NOME(long companyId, String nome, int start,
		int end) throws SystemException {
		return findByC_NOME(companyId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_NOME(long companyId, String nome, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME;
		finderArgs = new Object[] { companyId, nome, start, end, orderByComparator };

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Atividade atividade : list) {
				if ((companyId != atividade.getCompanyId()) ||
						!StringUtil.wildcardMatches(atividade.getNome(), nome,
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

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_NOME_First(companyId, nome,
				orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the first atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		List<Atividade> list = findByC_NOME(companyId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_NOME_Last(companyId, nome,
				orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_NOME(companyId, nome);

		if (count == 0) {
			return null;
		}

		List<Atividade> list = findByC_NOME(companyId, nome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] findByC_NOME_PrevAndNext(long atividadeId,
		long companyId, String nome, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = getByC_NOME_PrevAndNext(session, atividade, companyId,
					nome, orderByComparator, true);

			array[1] = atividade;

			array[2] = getByC_NOME_PrevAndNext(session, atividade, companyId,
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

	protected Atividade getByC_NOME_PrevAndNext(Session session,
		Atividade atividade, long companyId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
			query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the atividades where companyId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_NOME(long companyId, String nome)
		throws SystemException {
		for (Atividade atividade : findByC_NOME(companyId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the number of matching atividades
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

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

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

	private static final String _FINDER_COLUMN_C_NOME_COMPANYID_2 = "atividade.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_NOME_NOME_1 = "atividade.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_NOME_NOME_2 = "atividade.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_NOME_NOME_3 = "(atividade.nome IS NULL OR atividade.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_NOME = new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_NOME =
		new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G_NOME(long companyId, long groupId,
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

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Atividade atividade : list) {
				if ((companyId != atividade.getCompanyId()) ||
						(groupId != atividade.getGroupId()) ||
						!StringUtil.wildcardMatches(atividade.getNome(), nome,
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

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_G_NOME_First(companyId, groupId, nome,
				orderByComparator);

		if (atividade != null) {
			return atividade;
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

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		List<Atividade> list = findByC_G_NOME(companyId, groupId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_G_NOME_Last(companyId, groupId, nome,
				orderByComparator);

		if (atividade != null) {
			return atividade;
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

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_NOME(companyId, groupId, nome);

		if (count == 0) {
			return null;
		}

		List<Atividade> list = findByC_G_NOME(companyId, groupId, nome,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] findByC_G_NOME_PrevAndNext(long atividadeId,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = getByC_G_NOME_PrevAndNext(session, atividade, companyId,
					groupId, nome, orderByComparator, true);

			array[1] = atividade;

			array[2] = getByC_G_NOME_PrevAndNext(session, atividade, companyId,
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

	protected Atividade getByC_G_NOME_PrevAndNext(Session session,
		Atividade atividade, long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATIVIDADE_WHERE);

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
			query.append(AtividadeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G_NOME(long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_1);
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
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AtividadeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AtividadeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AtividadeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindNome) {
				qPos.add(nome);
			}

			return (List<Atividade>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] filterFindByC_G_NOME_PrevAndNext(long atividadeId,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_NOME_PrevAndNext(atividadeId, companyId, groupId,
				nome, orderByComparator);
		}

		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = filterGetByC_G_NOME_PrevAndNext(session, atividade,
					companyId, groupId, nome, orderByComparator, true);

			array[1] = atividade;

			array[2] = filterGetByC_G_NOME_PrevAndNext(session, atividade,
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

	protected Atividade filterGetByC_G_NOME_PrevAndNext(Session session,
		Atividade atividade, long companyId, long groupId, String nome,
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
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_1);
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
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AtividadeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AtividadeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AtividadeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		for (Atividade atividade : findByC_G_NOME(companyId, groupId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching atividades
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

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

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
	 * Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G_NOME(companyId, groupId, nome);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_ATIVIDADE_WHERE);

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
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

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

	private static final String _FINDER_COLUMN_C_G_NOME_COMPANYID_2 = "atividade.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_GROUPID_2 = "atividade.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_1 = "atividade.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_2 = "atividade.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_3 = "(atividade.nome IS NULL OR atividade.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_DESCRICAO =
		new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_DESCRICAO",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_DESCRICAO =
		new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_DESCRICAO",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the atividades where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @return the matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_DESCRICAO(long companyId, String descricao)
		throws SystemException {
		return findByC_DESCRICAO(companyId, descricao, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_DESCRICAO(long companyId, String descricao,
		int start, int end) throws SystemException {
		return findByC_DESCRICAO(companyId, descricao, start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_DESCRICAO(long companyId, String descricao,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_DESCRICAO;
		finderArgs = new Object[] {
				companyId, descricao,
				
				start, end, orderByComparator
			};

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Atividade atividade : list) {
				if ((companyId != atividade.getCompanyId()) ||
						!StringUtil.wildcardMatches(atividade.getDescricao(),
							descricao, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

			query.append(_FINDER_COLUMN_C_DESCRICAO_COMPANYID_2);

			boolean bindDescricao = false;

			if (descricao == null) {
				query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_1);
			}
			else if (descricao.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_3);
			}
			else {
				bindDescricao = true;

				query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindDescricao) {
					qPos.add(descricao);
				}

				if (!pagination) {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_DESCRICAO_First(long companyId, String descricao,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_DESCRICAO_First(companyId, descricao,
				orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", descricao=");
		msg.append(descricao);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the first atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_DESCRICAO_First(long companyId, String descricao,
		OrderByComparator orderByComparator) throws SystemException {
		List<Atividade> list = findByC_DESCRICAO(companyId, descricao, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_DESCRICAO_Last(long companyId, String descricao,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_DESCRICAO_Last(companyId, descricao,
				orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", descricao=");
		msg.append(descricao);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_DESCRICAO_Last(long companyId, String descricao,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_DESCRICAO(companyId, descricao);

		if (count == 0) {
			return null;
		}

		List<Atividade> list = findByC_DESCRICAO(companyId, descricao,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] findByC_DESCRICAO_PrevAndNext(long atividadeId,
		long companyId, String descricao, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = getByC_DESCRICAO_PrevAndNext(session, atividade,
					companyId, descricao, orderByComparator, true);

			array[1] = atividade;

			array[2] = getByC_DESCRICAO_PrevAndNext(session, atividade,
					companyId, descricao, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Atividade getByC_DESCRICAO_PrevAndNext(Session session,
		Atividade atividade, long companyId, String descricao,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATIVIDADE_WHERE);

		query.append(_FINDER_COLUMN_C_DESCRICAO_COMPANYID_2);

		boolean bindDescricao = false;

		if (descricao == null) {
			query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_1);
		}
		else if (descricao.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_3);
		}
		else {
			bindDescricao = true;

			query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_2);
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
			query.append(AtividadeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindDescricao) {
			qPos.add(descricao);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the atividades where companyId = &#63; and descricao LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_DESCRICAO(long companyId, String descricao)
		throws SystemException {
		for (Atividade atividade : findByC_DESCRICAO(companyId, descricao,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades where companyId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param descricao the descricao
	 * @return the number of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_DESCRICAO(long companyId, String descricao)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_DESCRICAO;

		Object[] finderArgs = new Object[] { companyId, descricao };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

			query.append(_FINDER_COLUMN_C_DESCRICAO_COMPANYID_2);

			boolean bindDescricao = false;

			if (descricao == null) {
				query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_1);
			}
			else if (descricao.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_3);
			}
			else {
				bindDescricao = true;

				query.append(_FINDER_COLUMN_C_DESCRICAO_DESCRICAO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindDescricao) {
					qPos.add(descricao);
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

	private static final String _FINDER_COLUMN_C_DESCRICAO_COMPANYID_2 = "atividade.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_DESCRICAO_DESCRICAO_1 = "atividade.descricao LIKE NULL";
	private static final String _FINDER_COLUMN_C_DESCRICAO_DESCRICAO_2 = "atividade.descricao LIKE ?";
	private static final String _FINDER_COLUMN_C_DESCRICAO_DESCRICAO_3 = "(atividade.descricao IS NULL OR atividade.descricao LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_DESCRICAO =
		new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, AtividadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_DESCRICAO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_DESCRICAO =
		new FinderPath(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_DESCRICAO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @return the matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G_DESCRICAO(long companyId, long groupId,
		String descricao) throws SystemException {
		return findByC_G_DESCRICAO(companyId, groupId, descricao,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G_DESCRICAO(long companyId, long groupId,
		String descricao, int start, int end) throws SystemException {
		return findByC_G_DESCRICAO(companyId, groupId, descricao, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findByC_G_DESCRICAO(long companyId, long groupId,
		String descricao, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_DESCRICAO;
		finderArgs = new Object[] {
				companyId, groupId, descricao,
				
				start, end, orderByComparator
			};

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Atividade atividade : list) {
				if ((companyId != atividade.getCompanyId()) ||
						(groupId != atividade.getGroupId()) ||
						!StringUtil.wildcardMatches(atividade.getDescricao(),
							descricao, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_ATIVIDADE_WHERE);

			query.append(_FINDER_COLUMN_C_G_DESCRICAO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_DESCRICAO_GROUPID_2);

			boolean bindDescricao = false;

			if (descricao == null) {
				query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_1);
			}
			else if (descricao.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_3);
			}
			else {
				bindDescricao = true;

				query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindDescricao) {
					qPos.add(descricao);
				}

				if (!pagination) {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_G_DESCRICAO_First(long companyId, long groupId,
		String descricao, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_G_DESCRICAO_First(companyId, groupId,
				descricao, orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", descricao=");
		msg.append(descricao);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the first atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_G_DESCRICAO_First(long companyId, long groupId,
		String descricao, OrderByComparator orderByComparator)
		throws SystemException {
		List<Atividade> list = findByC_G_DESCRICAO(companyId, groupId,
				descricao, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByC_G_DESCRICAO_Last(long companyId, long groupId,
		String descricao, OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByC_G_DESCRICAO_Last(companyId, groupId,
				descricao, orderByComparator);

		if (atividade != null) {
			return atividade;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", descricao=");
		msg.append(descricao);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAtividadeException(msg.toString());
	}

	/**
	 * Returns the last atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching atividade, or <code>null</code> if a matching atividade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByC_G_DESCRICAO_Last(long companyId, long groupId,
		String descricao, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_DESCRICAO(companyId, groupId, descricao);

		if (count == 0) {
			return null;
		}

		List<Atividade> list = findByC_G_DESCRICAO(companyId, groupId,
				descricao, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] findByC_G_DESCRICAO_PrevAndNext(long atividadeId,
		long companyId, long groupId, String descricao,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = getByC_G_DESCRICAO_PrevAndNext(session, atividade,
					companyId, groupId, descricao, orderByComparator, true);

			array[1] = atividade;

			array[2] = getByC_G_DESCRICAO_PrevAndNext(session, atividade,
					companyId, groupId, descricao, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Atividade getByC_G_DESCRICAO_PrevAndNext(Session session,
		Atividade atividade, long companyId, long groupId, String descricao,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATIVIDADE_WHERE);

		query.append(_FINDER_COLUMN_C_G_DESCRICAO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_DESCRICAO_GROUPID_2);

		boolean bindDescricao = false;

		if (descricao == null) {
			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_1);
		}
		else if (descricao.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_3);
		}
		else {
			bindDescricao = true;

			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_2);
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
			query.append(AtividadeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindDescricao) {
			qPos.add(descricao);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @return the matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G_DESCRICAO(long companyId,
		long groupId, String descricao) throws SystemException {
		return filterFindByC_G_DESCRICAO(companyId, groupId, descricao,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G_DESCRICAO(long companyId,
		long groupId, String descricao, int start, int end)
		throws SystemException {
		return filterFindByC_G_DESCRICAO(companyId, groupId, descricao, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the atividades that the user has permissions to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> filterFindByC_G_DESCRICAO(long companyId,
		long groupId, String descricao, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_DESCRICAO(companyId, groupId, descricao, start,
				end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_DESCRICAO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_DESCRICAO_GROUPID_2);

		boolean bindDescricao = false;

		if (descricao == null) {
			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_1);
		}
		else if (descricao.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_3);
		}
		else {
			bindDescricao = true;

			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AtividadeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AtividadeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AtividadeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindDescricao) {
				qPos.add(descricao);
			}

			return (List<Atividade>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the atividades before and after the current atividade in the ordered set of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param atividadeId the primary key of the current atividade
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade[] filterFindByC_G_DESCRICAO_PrevAndNext(long atividadeId,
		long companyId, long groupId, String descricao,
		OrderByComparator orderByComparator)
		throws NoSuchAtividadeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_DESCRICAO_PrevAndNext(atividadeId, companyId,
				groupId, descricao, orderByComparator);
		}

		Atividade atividade = findByPrimaryKey(atividadeId);

		Session session = null;

		try {
			session = openSession();

			Atividade[] array = new AtividadeImpl[3];

			array[0] = filterGetByC_G_DESCRICAO_PrevAndNext(session, atividade,
					companyId, groupId, descricao, orderByComparator, true);

			array[1] = atividade;

			array[2] = filterGetByC_G_DESCRICAO_PrevAndNext(session, atividade,
					companyId, groupId, descricao, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Atividade filterGetByC_G_DESCRICAO_PrevAndNext(Session session,
		Atividade atividade, long companyId, long groupId, String descricao,
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
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_DESCRICAO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_DESCRICAO_GROUPID_2);

		boolean bindDescricao = false;

		if (descricao == null) {
			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_1);
		}
		else if (descricao.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_3);
		}
		else {
			bindDescricao = true;

			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AtividadeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AtividadeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AtividadeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AtividadeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindDescricao) {
			qPos.add(descricao);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atividade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Atividade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_DESCRICAO(long companyId, long groupId,
		String descricao) throws SystemException {
		for (Atividade atividade : findByC_G_DESCRICAO(companyId, groupId,
				descricao, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @return the number of matching atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_DESCRICAO(long companyId, long groupId,
		String descricao) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_DESCRICAO;

		Object[] finderArgs = new Object[] { companyId, groupId, descricao };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ATIVIDADE_WHERE);

			query.append(_FINDER_COLUMN_C_G_DESCRICAO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_DESCRICAO_GROUPID_2);

			boolean bindDescricao = false;

			if (descricao == null) {
				query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_1);
			}
			else if (descricao.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_3);
			}
			else {
				bindDescricao = true;

				query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindDescricao) {
					qPos.add(descricao);
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
	 * Returns the number of atividades that the user has permission to view where companyId = &#63; and groupId = &#63; and descricao LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param descricao the descricao
	 * @return the number of matching atividades that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G_DESCRICAO(long companyId, long groupId,
		String descricao) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G_DESCRICAO(companyId, groupId, descricao);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_ATIVIDADE_WHERE);

		query.append(_FINDER_COLUMN_C_G_DESCRICAO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_DESCRICAO_GROUPID_2);

		boolean bindDescricao = false;

		if (descricao == null) {
			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_1);
		}
		else if (descricao.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_3);
		}
		else {
			bindDescricao = true;

			query.append(_FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Atividade.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindDescricao) {
				qPos.add(descricao);
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

	private static final String _FINDER_COLUMN_C_G_DESCRICAO_COMPANYID_2 = "atividade.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_DESCRICAO_GROUPID_2 = "atividade.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_1 = "atividade.descricao LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_2 = "atividade.descricao LIKE ?";
	private static final String _FINDER_COLUMN_C_G_DESCRICAO_DESCRICAO_3 = "(atividade.descricao IS NULL OR atividade.descricao LIKE '')";

	public AtividadePersistenceImpl() {
		setModelClass(Atividade.class);
	}

	/**
	 * Caches the atividade in the entity cache if it is enabled.
	 *
	 * @param atividade the atividade
	 */
	@Override
	public void cacheResult(Atividade atividade) {
		EntityCacheUtil.putResult(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeImpl.class, atividade.getPrimaryKey(), atividade);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { atividade.getUuid(), atividade.getGroupId() },
			atividade);

		atividade.resetOriginalValues();
	}

	/**
	 * Caches the atividades in the entity cache if it is enabled.
	 *
	 * @param atividades the atividades
	 */
	@Override
	public void cacheResult(List<Atividade> atividades) {
		for (Atividade atividade : atividades) {
			if (EntityCacheUtil.getResult(
						AtividadeModelImpl.ENTITY_CACHE_ENABLED,
						AtividadeImpl.class, atividade.getPrimaryKey()) == null) {
				cacheResult(atividade);
			}
			else {
				atividade.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all atividades.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AtividadeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AtividadeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the atividade.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Atividade atividade) {
		EntityCacheUtil.removeResult(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeImpl.class, atividade.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(atividade);
	}

	@Override
	public void clearCache(List<Atividade> atividades) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Atividade atividade : atividades) {
			EntityCacheUtil.removeResult(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
				AtividadeImpl.class, atividade.getPrimaryKey());

			clearUniqueFindersCache(atividade);
		}
	}

	protected void cacheUniqueFindersCache(Atividade atividade) {
		if (atividade.isNew()) {
			Object[] args = new Object[] {
					atividade.getUuid(), atividade.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				atividade);
		}
		else {
			AtividadeModelImpl atividadeModelImpl = (AtividadeModelImpl)atividade;

			if ((atividadeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atividade.getUuid(), atividade.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					atividade);
			}
		}
	}

	protected void clearUniqueFindersCache(Atividade atividade) {
		AtividadeModelImpl atividadeModelImpl = (AtividadeModelImpl)atividade;

		Object[] args = new Object[] { atividade.getUuid(), atividade.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((atividadeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					atividadeModelImpl.getOriginalUuid(),
					atividadeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new atividade with the primary key. Does not add the atividade to the database.
	 *
	 * @param atividadeId the primary key for the new atividade
	 * @return the new atividade
	 */
	@Override
	public Atividade create(long atividadeId) {
		Atividade atividade = new AtividadeImpl();

		atividade.setNew(true);
		atividade.setPrimaryKey(atividadeId);

		String uuid = PortalUUIDUtil.generate();

		atividade.setUuid(uuid);

		return atividade;
	}

	/**
	 * Removes the atividade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param atividadeId the primary key of the atividade
	 * @return the atividade that was removed
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade remove(long atividadeId)
		throws NoSuchAtividadeException, SystemException {
		return remove((Serializable)atividadeId);
	}

	/**
	 * Removes the atividade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the atividade
	 * @return the atividade that was removed
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade remove(Serializable primaryKey)
		throws NoSuchAtividadeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Atividade atividade = (Atividade)session.get(AtividadeImpl.class,
					primaryKey);

			if (atividade == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAtividadeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(atividade);
		}
		catch (NoSuchAtividadeException nsee) {
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
	protected Atividade removeImpl(Atividade atividade)
		throws SystemException {
		atividade = toUnwrappedModel(atividade);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(atividade)) {
				atividade = (Atividade)session.get(AtividadeImpl.class,
						atividade.getPrimaryKeyObj());
			}

			if (atividade != null) {
				session.delete(atividade);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (atividade != null) {
			clearCache(atividade);
		}

		return atividade;
	}

	@Override
	public Atividade updateImpl(
		br.com.prodevelopment.atividade.model.Atividade atividade)
		throws SystemException {
		atividade = toUnwrappedModel(atividade);

		boolean isNew = atividade.isNew();

		AtividadeModelImpl atividadeModelImpl = (AtividadeModelImpl)atividade;

		if (Validator.isNull(atividade.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			atividade.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (atividade.isNew()) {
				session.save(atividade);

				atividade.setNew(false);
			}
			else {
				session.merge(atividade);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AtividadeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((atividadeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atividadeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { atividadeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((atividadeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atividadeModelImpl.getOriginalUuid(),
						atividadeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						atividadeModelImpl.getUuid(),
						atividadeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((atividadeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atividadeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { atividadeModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((atividadeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atividadeModelImpl.getOriginalCompanyId(),
						atividadeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						atividadeModelImpl.getCompanyId(),
						atividadeModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}
		}

		EntityCacheUtil.putResult(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
			AtividadeImpl.class, atividade.getPrimaryKey(), atividade);

		clearUniqueFindersCache(atividade);
		cacheUniqueFindersCache(atividade);

		return atividade;
	}

	protected Atividade toUnwrappedModel(Atividade atividade) {
		if (atividade instanceof AtividadeImpl) {
			return atividade;
		}

		AtividadeImpl atividadeImpl = new AtividadeImpl();

		atividadeImpl.setNew(atividade.isNew());
		atividadeImpl.setPrimaryKey(atividade.getPrimaryKey());

		atividadeImpl.setUuid(atividade.getUuid());
		atividadeImpl.setAtividadeId(atividade.getAtividadeId());
		atividadeImpl.setCompanyId(atividade.getCompanyId());
		atividadeImpl.setGroupId(atividade.getGroupId());
		atividadeImpl.setCreateUserId(atividade.getCreateUserId());
		atividadeImpl.setModifiedUserId(atividade.getModifiedUserId());
		atividadeImpl.setCreateDate(atividade.getCreateDate());
		atividadeImpl.setModifiedDate(atividade.getModifiedDate());
		atividadeImpl.setNome(atividade.getNome());
		atividadeImpl.setDescricao(atividade.getDescricao());
		atividadeImpl.setImagemId(atividade.getImagemId());
		atividadeImpl.setExisteImagem(atividade.isExisteImagem());
		atividadeImpl.setVersao(atividade.getVersao());

		return atividadeImpl;
	}

	/**
	 * Returns the atividade with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the atividade
	 * @return the atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAtividadeException, SystemException {
		Atividade atividade = fetchByPrimaryKey(primaryKey);

		if (atividade == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAtividadeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return atividade;
	}

	/**
	 * Returns the atividade with the primary key or throws a {@link br.com.prodevelopment.atividade.NoSuchAtividadeException} if it could not be found.
	 *
	 * @param atividadeId the primary key of the atividade
	 * @return the atividade
	 * @throws br.com.prodevelopment.atividade.NoSuchAtividadeException if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade findByPrimaryKey(long atividadeId)
		throws NoSuchAtividadeException, SystemException {
		return findByPrimaryKey((Serializable)atividadeId);
	}

	/**
	 * Returns the atividade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the atividade
	 * @return the atividade, or <code>null</code> if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Atividade atividade = (Atividade)EntityCacheUtil.getResult(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
				AtividadeImpl.class, primaryKey);

		if (atividade == _nullAtividade) {
			return null;
		}

		if (atividade == null) {
			Session session = null;

			try {
				session = openSession();

				atividade = (Atividade)session.get(AtividadeImpl.class,
						primaryKey);

				if (atividade != null) {
					cacheResult(atividade);
				}
				else {
					EntityCacheUtil.putResult(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
						AtividadeImpl.class, primaryKey, _nullAtividade);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AtividadeModelImpl.ENTITY_CACHE_ENABLED,
					AtividadeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return atividade;
	}

	/**
	 * Returns the atividade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param atividadeId the primary key of the atividade
	 * @return the atividade, or <code>null</code> if a atividade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Atividade fetchByPrimaryKey(long atividadeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)atividadeId);
	}

	/**
	 * Returns all the atividades.
	 *
	 * @return the atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atividades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @return the range of atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the atividades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.atividade.model.impl.AtividadeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of atividades
	 * @param end the upper bound of the range of atividades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of atividades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Atividade> findAll(int start, int end,
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

		List<Atividade> list = (List<Atividade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ATIVIDADE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATIVIDADE;

				if (pagination) {
					sql = sql.concat(AtividadeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Atividade>(list);
				}
				else {
					list = (List<Atividade>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the atividades from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Atividade atividade : findAll()) {
			remove(atividade);
		}
	}

	/**
	 * Returns the number of atividades.
	 *
	 * @return the number of atividades
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

				Query q = session.createQuery(_SQL_COUNT_ATIVIDADE);

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
	 * Initializes the atividade persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.atividade.model.Atividade")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Atividade>> listenersList = new ArrayList<ModelListener<Atividade>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Atividade>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AtividadeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ATIVIDADE = "SELECT atividade FROM Atividade atividade";
	private static final String _SQL_SELECT_ATIVIDADE_WHERE = "SELECT atividade FROM Atividade atividade WHERE ";
	private static final String _SQL_COUNT_ATIVIDADE = "SELECT COUNT(atividade) FROM Atividade atividade";
	private static final String _SQL_COUNT_ATIVIDADE_WHERE = "SELECT COUNT(atividade) FROM Atividade atividade WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "atividade.atividadeId";
	private static final String _FILTER_SQL_SELECT_ATIVIDADE_WHERE = "SELECT DISTINCT {atividade.*} FROM Atividade atividade WHERE ";
	private static final String _FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Atividade.*} FROM (SELECT DISTINCT atividade.atividadeId FROM Atividade atividade WHERE ";
	private static final String _FILTER_SQL_SELECT_ATIVIDADE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Atividade ON TEMP_TABLE.atividadeId = Atividade.atividadeId";
	private static final String _FILTER_SQL_COUNT_ATIVIDADE_WHERE = "SELECT COUNT(DISTINCT atividade.atividadeId) AS COUNT_VALUE FROM Atividade atividade WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "atividade";
	private static final String _FILTER_ENTITY_TABLE = "Atividade";
	private static final String _ORDER_BY_ENTITY_ALIAS = "atividade.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Atividade.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Atividade exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Atividade exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AtividadePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Atividade _nullAtividade = new AtividadeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Atividade> toCacheModel() {
				return _nullAtividadeCacheModel;
			}
		};

	private static CacheModel<Atividade> _nullAtividadeCacheModel = new CacheModel<Atividade>() {
			@Override
			public Atividade toEntityModel() {
				return _nullAtividade;
			}
		};
}