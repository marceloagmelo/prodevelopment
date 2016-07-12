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

package br.com.prodevelopment.etask.service.persistence;

import br.com.prodevelopment.etask.NoSuchTypeTaskException;
import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.model.impl.TypeTaskImpl;
import br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl;

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
import com.liferay.portal.kernel.util.ArrayUtil;
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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the type task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTaskPersistence
 * @see TypeTaskUtil
 * @generated
 */
public class TypeTaskPersistenceImpl extends BasePersistenceImpl<TypeTask>
	implements TypeTaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TypeTaskUtil} to access the type task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TypeTaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TypeTaskModelImpl.UUID_COLUMN_BITMASK |
			TypeTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the type tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByUuid(String uuid, int start, int end,
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

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if (!Validator.equals(uuid, typeTask.getUuid())) {
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

			query.append(_SQL_SELECT_TYPETASK_WHERE);

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
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
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
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByUuid_First(uuid, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTask> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByUuid_Last(uuid, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where uuid = &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByUuid_PrevAndNext(long typeTaskId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByUuid_PrevAndNext(session, typeTask, uuid,
					orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByUuid_PrevAndNext(session, typeTask, uuid,
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

	protected TypeTask getByUuid_PrevAndNext(Session session,
		TypeTask typeTask, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (TypeTask typeTask : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching type tasks
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

			query.append(_SQL_COUNT_TYPETASK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "typeTask.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "typeTask.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(typeTask.uuid IS NULL OR typeTask.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TypeTaskModelImpl.UUID_COLUMN_BITMASK |
			TypeTaskModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the type task where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByUUID_G(String uuid, long groupId)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByUUID_G(uuid, groupId);

		if (typeTask == null) {
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

			throw new NoSuchTypeTaskException(msg.toString());
		}

		return typeTask;
	}

	/**
	 * Returns the type task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the type task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof TypeTask) {
			TypeTask typeTask = (TypeTask)result;

			if (!Validator.equals(uuid, typeTask.getUuid()) ||
					(groupId != typeTask.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TYPETASK_WHERE);

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

				List<TypeTask> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					TypeTask typeTask = list.get(0);

					result = typeTask;

					cacheResult(typeTask);

					if ((typeTask.getUuid() == null) ||
							!typeTask.getUuid().equals(uuid) ||
							(typeTask.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, typeTask);
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
			return (TypeTask)result;
		}
	}

	/**
	 * Removes the type task where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the type task that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask removeByUUID_G(String uuid, long groupId)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByUUID_G(uuid, groupId);

		return remove(typeTask);
	}

	/**
	 * Returns the number of type tasks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching type tasks
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

			query.append(_SQL_COUNT_TYPETASK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "typeTask.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "typeTask.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(typeTask.uuid IS NULL OR typeTask.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "typeTask.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TypeTaskModelImpl.UUID_COLUMN_BITMASK |
			TypeTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the type tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByUuid_C(String uuid, long companyId, int start,
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

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if (!Validator.equals(uuid, typeTask.getUuid()) ||
						(companyId != typeTask.getCompanyId())) {
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

			query.append(_SQL_SELECT_TYPETASK_WHERE);

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
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
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
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTask> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByUuid_C_PrevAndNext(long typeTaskId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, typeTask, uuid,
					companyId, orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByUuid_C_PrevAndNext(session, typeTask, uuid,
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

	protected TypeTask getByUuid_C_PrevAndNext(Session session,
		TypeTask typeTask, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tasks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (TypeTask typeTask : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching type tasks
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

			query.append(_SQL_COUNT_TYPETASK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "typeTask.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "typeTask.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(typeTask.uuid IS NULL OR typeTask.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "typeTask.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			TypeTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the type tasks where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCompany(long companyId, int start, int end,
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

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId())) {
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

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCompany_First(companyId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTask> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCompany_Last(companyId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where companyId = &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByCompany_PrevAndNext(long typeTaskId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByCompany_PrevAndNext(session, typeTask, companyId,
					orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByCompany_PrevAndNext(session, typeTask, companyId,
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

	protected TypeTask getByCompany_PrevAndNext(Session session,
		TypeTask typeTask, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tasks where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (TypeTask typeTask : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching type tasks
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

			query.append(_SQL_COUNT_TYPETASK_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "typeTask.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG",
			new String[] { Long.class.getName(), Long.class.getName() },
			TypeTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTaskModelImpl.GROUPID_COLUMN_BITMASK |
			TypeTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG(long companyId, long groupId)
		throws SystemException {
		return findByCG(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByCG(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId())) {
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

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
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
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_First(companyId, groupId,
				orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTask> list = findByCG(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_Last(companyId, groupId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByCG(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByCG_PrevAndNext(long typeTaskId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByCG_PrevAndNext(session, typeTask, companyId,
					groupId, orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByCG_PrevAndNext(session, typeTask, companyId,
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

	protected TypeTask getByCG_PrevAndNext(Session session, TypeTask typeTask,
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

		query.append(_SQL_SELECT_TYPETASK_WHERE);

		query.append(_FINDER_COLUMN_CG_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_GROUPID_2);

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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tasks where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG(long companyId, long groupId)
		throws SystemException {
		for (TypeTask typeTask : findByCG(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

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

	private static final String _FINDER_COLUMN_CG_COMPANYID_2 = "typeTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_GROUPID_2 = "typeTask.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TypeTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTaskModelImpl.GROUPID_COLUMN_BITMASK |
			TypeTaskModelImpl.STATUS_COLUMN_BITMASK |
			TypeTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_S = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S(long companyId, long groupId, int status)
		throws SystemException {
		return findByCG_S(companyId, groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S(long companyId, long groupId, int status,
		int start, int end) throws SystemException {
		return findByCG_S(companyId, groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S(long companyId, long groupId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S;
			finderArgs = new Object[] { companyId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S;
			finderArgs = new Object[] {
					companyId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						(status != typeTask.getStatus())) {
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

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_S_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_S_First(long companyId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_S_First(companyId, groupId, status,
				orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_S_First(long companyId, long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTask> list = findByCG_S(companyId, groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_S_Last(long companyId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_S_Last(companyId, groupId, status,
				orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_S_Last(long companyId, long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG_S(companyId, groupId, status);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByCG_S(companyId, groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByCG_S_PrevAndNext(long typeTaskId, long companyId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByCG_S_PrevAndNext(session, typeTask, companyId,
					groupId, status, orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByCG_S_PrevAndNext(session, typeTask, companyId,
					groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTask getByCG_S_PrevAndNext(Session session,
		TypeTask typeTask, long companyId, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

		query.append(_FINDER_COLUMN_CG_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_S_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_S_STATUS_2);

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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S(long companyId, long groupId,
		int[] statuses) throws SystemException {
		return findByCG_S(companyId, groupId, statuses, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S(long companyId, long groupId,
		int[] statuses, int start, int end) throws SystemException {
		return findByCG_S(companyId, groupId, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S(long companyId, long groupId,
		int[] statuses, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_S(companyId, groupId, statuses[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses),
					
					start, end, orderByComparator
				};
		}

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						!ArrayUtil.contains(statuses, typeTask.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_S_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_S(long companyId, long groupId, int status)
		throws SystemException {
		for (TypeTask typeTask : findByCG_S(companyId, groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_S(long companyId, long groupId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_S;

		Object[] finderArgs = new Object[] { companyId, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_S_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

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
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_S(long companyId, long groupId, int[] statuses)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, StringUtil.merge(statuses)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_S_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_S_COMPANYID_2 = "typeTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_GROUPID_2 = "typeTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_STATUS_2 = "typeTask.status = ?";
	private static final String _FINDER_COLUMN_CG_S_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_STATUS_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LIKENAME =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_LikeName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LIKENAME =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_LikeName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_LikeName(long companyId, long groupId,
		String name) throws SystemException {
		return findByCG_LikeName(companyId, groupId, name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_LikeName(long companyId, long groupId,
		String name, int start, int end) throws SystemException {
		return findByCG_LikeName(companyId, groupId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_LikeName(long companyId, long groupId,
		String name, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LIKENAME;
		finderArgs = new Object[] {
				companyId, groupId, name,
				
				start, end, orderByComparator
			};

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						!StringUtil.wildcardMatches(typeTask.getName(), name,
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

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_LIKENAME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_LIKENAME_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_LikeName_First(long companyId, long groupId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_LikeName_First(companyId, groupId, name,
				orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_LikeName_First(long companyId, long groupId,
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		List<TypeTask> list = findByCG_LikeName(companyId, groupId, name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_LikeName_Last(long companyId, long groupId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_LikeName_Last(companyId, groupId, name,
				orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_LikeName_Last(long companyId, long groupId,
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_LikeName(companyId, groupId, name);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByCG_LikeName(companyId, groupId, name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByCG_LikeName_PrevAndNext(long typeTaskId,
		long companyId, long groupId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByCG_LikeName_PrevAndNext(session, typeTask,
					companyId, groupId, name, orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByCG_LikeName_PrevAndNext(session, typeTask,
					companyId, groupId, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTask getByCG_LikeName_PrevAndNext(Session session,
		TypeTask typeTask, long companyId, long groupId, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

		query.append(_FINDER_COLUMN_CG_LIKENAME_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_LIKENAME_GROUPID_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_2);
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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_LikeName(long companyId, long groupId, String name)
		throws SystemException {
		for (TypeTask typeTask : findByCG_LikeName(companyId, groupId, name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_LikeName(long companyId, long groupId, String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LIKENAME;

		Object[] finderArgs = new Object[] { companyId, groupId, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_LIKENAME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_LIKENAME_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_LIKENAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_CG_LIKENAME_COMPANYID_2 = "typeTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LIKENAME_GROUPID_2 = "typeTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LIKENAME_NAME_1 = "typeTask.name LIKE NULL";
	private static final String _FINDER_COLUMN_CG_LIKENAME_NAME_2 = "typeTask.name LIKE ?";
	private static final String _FINDER_COLUMN_CG_LIKENAME_NAME_3 = "(typeTask.name IS NULL OR typeTask.name LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASS = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASS =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TypeTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTaskModelImpl.GROUPID_COLUMN_BITMASK |
			TypeTaskModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			TypeTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_CLASS = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_Class(long companyId, long groupId,
		long classNameId) throws SystemException {
		return findByCG_Class(companyId, groupId, classNameId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_Class(long companyId, long groupId,
		long classNameId, int start, int end) throws SystemException {
		return findByCG_Class(companyId, groupId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_Class(long companyId, long groupId,
		long classNameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASS;
			finderArgs = new Object[] { companyId, groupId, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_CLASS;
			finderArgs = new Object[] {
					companyId, groupId, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						(classNameId != typeTask.getClassNameId())) {
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

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_CLASS_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_CLASS_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_CLASS_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_Class_First(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_Class_First(companyId, groupId,
				classNameId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_Class_First(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TypeTask> list = findByCG_Class(companyId, groupId, classNameId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_Class_Last(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_Class_Last(companyId, groupId,
				classNameId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_Class_Last(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_Class(companyId, groupId, classNameId);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByCG_Class(companyId, groupId, classNameId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByCG_Class_PrevAndNext(long typeTaskId,
		long companyId, long groupId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByCG_Class_PrevAndNext(session, typeTask, companyId,
					groupId, classNameId, orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByCG_Class_PrevAndNext(session, typeTask, companyId,
					groupId, classNameId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTask getByCG_Class_PrevAndNext(Session session,
		TypeTask typeTask, long companyId, long groupId, long classNameId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

		query.append(_FINDER_COLUMN_CG_CLASS_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_CLASS_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_CLASS_CLASSNAMEID_2);

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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_Class(long companyId, long groupId, long classNameId)
		throws SystemException {
		for (TypeTask typeTask : findByCG_Class(companyId, groupId,
				classNameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_Class(long companyId, long groupId, long classNameId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_CLASS;

		Object[] finderArgs = new Object[] { companyId, groupId, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_CLASS_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_CLASS_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_CLASS_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

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

	private static final String _FINDER_COLUMN_CG_CLASS_COMPANYID_2 = "typeTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASS_GROUPID_2 = "typeTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_CLASS_CLASSNAMEID_2 = "typeTask.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_S_LikeName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_S_LikeName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName(long companyId, long groupId,
		int status, String name) throws SystemException {
		return findByCG_S_LikeName(companyId, groupId, status, name,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName(long companyId, long groupId,
		int status, String name, int start, int end) throws SystemException {
		return findByCG_S_LikeName(companyId, groupId, status, name, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName(long companyId, long groupId,
		int status, String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME;
		finderArgs = new Object[] {
				companyId, groupId, status, name,
				
				start, end, orderByComparator
			};

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						(status != typeTask.getStatus()) ||
						!StringUtil.wildcardMatches(typeTask.getName(), name,
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
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_STATUS_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_S_LikeName_First(long companyId, long groupId,
		int status, String name, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_S_LikeName_First(companyId, groupId,
				status, name, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_S_LikeName_First(long companyId, long groupId,
		int status, String name, OrderByComparator orderByComparator)
		throws SystemException {
		List<TypeTask> list = findByCG_S_LikeName(companyId, groupId, status,
				name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_S_LikeName_Last(long companyId, long groupId,
		int status, String name, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_S_LikeName_Last(companyId, groupId,
				status, name, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_S_LikeName_Last(long companyId, long groupId,
		int status, String name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_S_LikeName(companyId, groupId, status, name);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByCG_S_LikeName(companyId, groupId, status,
				name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByCG_S_LikeName_PrevAndNext(long typeTaskId,
		long companyId, long groupId, int status, String name,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByCG_S_LikeName_PrevAndNext(session, typeTask,
					companyId, groupId, status, name, orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByCG_S_LikeName_PrevAndNext(session, typeTask,
					companyId, groupId, status, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTask getByCG_S_LikeName_PrevAndNext(Session session,
		TypeTask typeTask, long companyId, long groupId, int status,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

		query.append(_FINDER_COLUMN_CG_S_LIKENAME_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_S_LIKENAME_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_S_LIKENAME_STATUS_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_2);
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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(status);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param name the name
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName(long companyId, long groupId,
		int[] statuses, String name) throws SystemException {
		return findByCG_S_LikeName(companyId, groupId, statuses, name,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param name the name
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName(long companyId, long groupId,
		int[] statuses, String name, int start, int end)
		throws SystemException {
		return findByCG_S_LikeName(companyId, groupId, statuses, name, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param name the name
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName(long companyId, long groupId,
		int[] statuses, String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_S_LikeName(companyId, groupId, statuses[0], name,
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses), name
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses), name,
					
					start, end, orderByComparator
				};
		}

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						!ArrayUtil.contains(statuses, typeTask.getStatus()) ||
						!StringUtil.wildcardMatches(typeTask.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_S_LIKENAME_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_4);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_6);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_5);
			}

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_S_LikeName(long companyId, long groupId, int status,
		String name) throws SystemException {
		for (TypeTask typeTask : findByCG_S_LikeName(companyId, groupId,
				status, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_S_LikeName(long companyId, long groupId, int status,
		String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME;

		Object[] finderArgs = new Object[] { companyId, groupId, status, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_STATUS_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				if (bindName) {
					qPos.add(name);
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
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param name the name
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_S_LikeName(long companyId, long groupId,
		int[] statuses, String name) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, StringUtil.merge(statuses), name
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_S_LIKENAME_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_4);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_6);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_S_LIKENAME_NAME_5);
			}

			conjunctionable = true;

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_S_LIKENAME_COMPANYID_2 = "typeTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_GROUPID_2 = "typeTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_STATUS_2 = "typeTask.status = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_STATUS_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_NAME_1 = "typeTask.name LIKE NULL";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_NAME_2 = "typeTask.name LIKE ?";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_NAME_3 = "(typeTask.name IS NULL OR typeTask.name LIKE '')";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_NAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_NAME_1) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_NAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_NAME_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_NAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_NAME_3) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_CLASS =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_S_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S_CLASS =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG_S_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName()
			},
			TypeTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTaskModelImpl.GROUPID_COLUMN_BITMASK |
			TypeTaskModelImpl.STATUS_COLUMN_BITMASK |
			TypeTaskModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			TypeTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG_S_CLASS = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG_S_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_CLASS =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_S_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_Class(long companyId, long groupId,
		int status, long classNameId) throws SystemException {
		return findByCG_S_Class(companyId, groupId, status, classNameId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_Class(long companyId, long groupId,
		int status, long classNameId, int start, int end)
		throws SystemException {
		return findByCG_S_Class(companyId, groupId, status, classNameId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_Class(long companyId, long groupId,
		int status, long classNameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S_CLASS;
			finderArgs = new Object[] { companyId, groupId, status, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_CLASS;
			finderArgs = new Object[] {
					companyId, groupId, status, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						(status != typeTask.getStatus()) ||
						(classNameId != typeTask.getClassNameId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_S_CLASS_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_S_CLASS_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_S_CLASS_STATUS_2);

			query.append(_FINDER_COLUMN_CG_S_CLASS_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_S_Class_First(long companyId, long groupId,
		int status, long classNameId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_S_Class_First(companyId, groupId, status,
				classNameId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_S_Class_First(long companyId, long groupId,
		int status, long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TypeTask> list = findByCG_S_Class(companyId, groupId, status,
				classNameId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_S_Class_Last(long companyId, long groupId,
		int status, long classNameId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_S_Class_Last(companyId, groupId, status,
				classNameId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_S_Class_Last(long companyId, long groupId,
		int status, long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_S_Class(companyId, groupId, status, classNameId);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByCG_S_Class(companyId, groupId, status,
				classNameId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByCG_S_Class_PrevAndNext(long typeTaskId,
		long companyId, long groupId, int status, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByCG_S_Class_PrevAndNext(session, typeTask,
					companyId, groupId, status, classNameId, orderByComparator,
					true);

			array[1] = typeTask;

			array[2] = getByCG_S_Class_PrevAndNext(session, typeTask,
					companyId, groupId, status, classNameId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTask getByCG_S_Class_PrevAndNext(Session session,
		TypeTask typeTask, long companyId, long groupId, int status,
		long classNameId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

		query.append(_FINDER_COLUMN_CG_S_CLASS_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_S_CLASS_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_S_CLASS_STATUS_2);

		query.append(_FINDER_COLUMN_CG_S_CLASS_CLASSNAMEID_2);

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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(status);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param classNameId the class name ID
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_Class(long companyId, long groupId,
		int[] statuses, long classNameId) throws SystemException {
		return findByCG_S_Class(companyId, groupId, statuses, classNameId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_Class(long companyId, long groupId,
		int[] statuses, long classNameId, int start, int end)
		throws SystemException {
		return findByCG_S_Class(companyId, groupId, statuses, classNameId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_Class(long companyId, long groupId,
		int[] statuses, long classNameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_S_Class(companyId, groupId, statuses[0],
				classNameId, start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses), classNameId
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses), classNameId,
					
					start, end, orderByComparator
				};
		}

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_CLASS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						!ArrayUtil.contains(statuses, typeTask.getStatus()) ||
						(classNameId != typeTask.getClassNameId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_CLASS_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_CLASS_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_S_CLASS_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_CLASS_CLASSNAMEID_5);

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_CLASS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_CLASS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_S_Class(long companyId, long groupId, int status,
		long classNameId) throws SystemException {
		for (TypeTask typeTask : findByCG_S_Class(companyId, groupId, status,
				classNameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param classNameId the class name ID
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_S_Class(long companyId, long groupId, int status,
		long classNameId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CG_S_CLASS;

		Object[] finderArgs = new Object[] {
				companyId, groupId, status, classNameId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_S_CLASS_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_S_CLASS_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_S_CLASS_STATUS_2);

			query.append(_FINDER_COLUMN_CG_S_CLASS_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				qPos.add(classNameId);

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
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param classNameId the class name ID
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_S_Class(long companyId, long groupId, int[] statuses,
		long classNameId) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, StringUtil.merge(statuses), classNameId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_CLASS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_CLASS_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_CLASS_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_S_CLASS_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_CLASS_CLASSNAMEID_5);

			conjunctionable = true;

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				qPos.add(classNameId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_CLASS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_CLASS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_S_CLASS_COMPANYID_2 = "typeTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_CLASS_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_CLASS_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_CLASS_GROUPID_2 = "typeTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_CLASS_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_CLASS_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_CLASS_STATUS_2 = "typeTask.status = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_CLASS_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_CLASS_STATUS_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_CLASS_CLASSNAMEID_2 = "typeTask.classNameId = ?";
	private static final String _FINDER_COLUMN_CG_S_CLASS_CLASSNAMEID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_CLASS_CLASSNAMEID_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME_CLASS =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCG_S_LikeName_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME_CLASS =
		new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCG_S_LikeName_Class",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName_Class(long companyId,
		long groupId, int status, String name, long classNameId)
		throws SystemException {
		return findByCG_S_LikeName_Class(companyId, groupId, status, name,
			classNameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName_Class(long companyId,
		long groupId, int status, String name, long classNameId, int start,
		int end) throws SystemException {
		return findByCG_S_LikeName_Class(companyId, groupId, status, name,
			classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName_Class(long companyId,
		long groupId, int status, String name, long classNameId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME_CLASS;
		finderArgs = new Object[] {
				companyId, groupId, status, name, classNameId,
				
				start, end, orderByComparator
			};

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						(status != typeTask.getStatus()) ||
						!StringUtil.wildcardMatches(typeTask.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(classNameId != typeTask.getClassNameId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_STATUS_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_2);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_S_LikeName_Class_First(long companyId,
		long groupId, int status, String name, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_S_LikeName_Class_First(companyId,
				groupId, status, name, classNameId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", name=");
		msg.append(name);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the first type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_S_LikeName_Class_First(long companyId,
		long groupId, int status, String name, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTask> list = findByCG_S_LikeName_Class(companyId, groupId,
				status, name, classNameId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByCG_S_LikeName_Class_Last(long companyId,
		long groupId, int status, String name, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByCG_S_LikeName_Class_Last(companyId, groupId,
				status, name, classNameId, orderByComparator);

		if (typeTask != null) {
			return typeTask;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", name=");
		msg.append(name);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskException(msg.toString());
	}

	/**
	 * Returns the last type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByCG_S_LikeName_Class_Last(long companyId,
		long groupId, int status, String name, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG_S_LikeName_Class(companyId, groupId, status,
				name, classNameId);

		if (count == 0) {
			return null;
		}

		List<TypeTask> list = findByCG_S_LikeName_Class(companyId, groupId,
				status, name, classNameId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tasks before and after the current type task in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * @param typeTaskId the primary key of the current type task
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask[] findByCG_S_LikeName_Class_PrevAndNext(long typeTaskId,
		long companyId, long groupId, int status, String name,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByPrimaryKey(typeTaskId);

		Session session = null;

		try {
			session = openSession();

			TypeTask[] array = new TypeTaskImpl[3];

			array[0] = getByCG_S_LikeName_Class_PrevAndNext(session, typeTask,
					companyId, groupId, status, name, classNameId,
					orderByComparator, true);

			array[1] = typeTask;

			array[2] = getByCG_S_LikeName_Class_PrevAndNext(session, typeTask,
					companyId, groupId, status, name, classNameId,
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

	protected TypeTask getByCG_S_LikeName_Class_PrevAndNext(Session session,
		TypeTask typeTask, long companyId, long groupId, int status,
		String name, long classNameId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASK_WHERE);

		query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_COMPANYID_2);

		query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_GROUPID_2);

		query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_STATUS_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_2);
		}

		query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_CLASSNAMEID_2);

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
			query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(status);

		if (bindName) {
			qPos.add(name);
		}

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param name the name
	 * @param classNameId the class name ID
	 * @return the matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName_Class(long companyId,
		long groupId, int[] statuses, String name, long classNameId)
		throws SystemException {
		return findByCG_S_LikeName_Class(companyId, groupId, statuses, name,
			classNameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName_Class(long companyId,
		long groupId, int[] statuses, String name, long classNameId, int start,
		int end) throws SystemException {
		return findByCG_S_LikeName_Class(companyId, groupId, statuses, name,
			classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param name the name
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findByCG_S_LikeName_Class(long companyId,
		long groupId, int[] statuses, String name, long classNameId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((statuses != null) && (statuses.length == 1)) {
			return findByCG_S_LikeName_Class(companyId, groupId, statuses[0],
				name, classNameId, start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses), name,
					classNameId
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(statuses), name,
					classNameId,
					
					start, end, orderByComparator
				};
		}

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME_CLASS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTask typeTask : list) {
				if ((companyId != typeTask.getCompanyId()) ||
						(groupId != typeTask.getGroupId()) ||
						!ArrayUtil.contains(statuses, typeTask.getStatus()) ||
						!StringUtil.wildcardMatches(typeTask.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(classNameId != typeTask.getClassNameId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_4);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_6);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_5);
			}

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_CLASSNAMEID_5);

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME_CLASS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_S_LIKENAME_CLASS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_S_LikeName_Class(long companyId, long groupId,
		int status, String name, long classNameId) throws SystemException {
		for (TypeTask typeTask : findByCG_S_LikeName_Class(companyId, groupId,
				status, name, classNameId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param name the name
	 * @param classNameId the class name ID
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_S_LikeName_Class(long companyId, long groupId,
		int status, String name, long classNameId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME_CLASS;

		Object[] finderArgs = new Object[] {
				companyId, groupId, status, name, classNameId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_GROUPID_2);

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_STATUS_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_2);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(classNameId);

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
	 * Returns the number of type tasks where companyId = &#63; and groupId = &#63; and status = any &#63; and name LIKE &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param name the name
	 * @param classNameId the class name ID
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCG_S_LikeName_Class(long companyId, long groupId,
		int[] statuses, String name, long classNameId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, StringUtil.merge(statuses), name,
				classNameId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME_CLASS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_GROUPID_5);

			conjunctionable = true;

			if ((statuses == null) || (statuses.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statuses.length; i++) {
					query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_STATUS_5);

					if ((i + 1) < statuses.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_4);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_6);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_5);
			}

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_CLASSNAMEID_5);

			conjunctionable = true;

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (statuses != null) {
					qPos.add(statuses);
				}

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(classNameId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME_CLASS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_S_LIKENAME_CLASS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_COMPANYID_2 = "typeTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_COMPANYID_2) +
		")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_GROUPID_2 = "typeTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_STATUS_2 = "typeTask.status = ? AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_STATUS_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_1 = "typeTask.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_2 = "typeTask.name LIKE ? AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_3 = "(typeTask.name IS NULL OR typeTask.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_1) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_2) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_NAME_3) + ")";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_CLASSNAMEID_2 =
		"typeTask.classNameId = ?";
	private static final String _FINDER_COLUMN_CG_S_LIKENAME_CLASS_CLASSNAMEID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_CG_S_LIKENAME_CLASS_CLASSNAMEID_2) +
		")";
	public static final FinderPath FINDER_PATH_FETCH_BY_TYPETASKCLASSPK = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, TypeTaskImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTypeTaskClassPK",
			new String[] { Long.class.getName() },
			TypeTaskModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPETASKCLASSPK = new FinderPath(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeTaskClassPK", new String[] { Long.class.getName() });

	/**
	 * Returns the type task where classPK = &#63; or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	 *
	 * @param classPK the class p k
	 * @return the matching type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByTypeTaskClassPK(long classPK)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByTypeTaskClassPK(classPK);

		if (typeTask == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTypeTaskException(msg.toString());
		}

		return typeTask;
	}

	/**
	 * Returns the type task where classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classPK the class p k
	 * @return the matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByTypeTaskClassPK(long classPK)
		throws SystemException {
		return fetchByTypeTaskClassPK(classPK, true);
	}

	/**
	 * Returns the type task where classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching type task, or <code>null</code> if a matching type task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByTypeTaskClassPK(long classPK,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK,
					finderArgs, this);
		}

		if (result instanceof TypeTask) {
			TypeTask typeTask = (TypeTask)result;

			if ((classPK != typeTask.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_TYPETASKCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classPK);

				List<TypeTask> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TypeTaskPersistenceImpl.fetchByTypeTaskClassPK(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TypeTask typeTask = list.get(0);

					result = typeTask;

					cacheResult(typeTask);

					if ((typeTask.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK,
							finderArgs, typeTask);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK,
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
			return (TypeTask)result;
		}
	}

	/**
	 * Removes the type task where classPK = &#63; from the database.
	 *
	 * @param classPK the class p k
	 * @return the type task that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask removeByTypeTaskClassPK(long classPK)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = findByTypeTaskClassPK(classPK);

		return remove(typeTask);
	}

	/**
	 * Returns the number of type tasks where classPK = &#63;.
	 *
	 * @param classPK the class p k
	 * @return the number of matching type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeTaskClassPK(long classPK) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPETASKCLASSPK;

		Object[] finderArgs = new Object[] { classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TYPETASK_WHERE);

			query.append(_FINDER_COLUMN_TYPETASKCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_TYPETASKCLASSPK_CLASSPK_2 = "typeTask.classPK = ?";

	public TypeTaskPersistenceImpl() {
		setModelClass(TypeTask.class);
	}

	/**
	 * Caches the type task in the entity cache if it is enabled.
	 *
	 * @param typeTask the type task
	 */
	@Override
	public void cacheResult(TypeTask typeTask) {
		EntityCacheUtil.putResult(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskImpl.class, typeTask.getPrimaryKey(), typeTask);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { typeTask.getUuid(), typeTask.getGroupId() }, typeTask);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK,
			new Object[] { typeTask.getClassPK() }, typeTask);

		typeTask.resetOriginalValues();
	}

	/**
	 * Caches the type tasks in the entity cache if it is enabled.
	 *
	 * @param typeTasks the type tasks
	 */
	@Override
	public void cacheResult(List<TypeTask> typeTasks) {
		for (TypeTask typeTask : typeTasks) {
			if (EntityCacheUtil.getResult(
						TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
						TypeTaskImpl.class, typeTask.getPrimaryKey()) == null) {
				cacheResult(typeTask);
			}
			else {
				typeTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all type tasks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TypeTaskImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TypeTaskImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the type task.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TypeTask typeTask) {
		EntityCacheUtil.removeResult(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskImpl.class, typeTask.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(typeTask);
	}

	@Override
	public void clearCache(List<TypeTask> typeTasks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TypeTask typeTask : typeTasks) {
			EntityCacheUtil.removeResult(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
				TypeTaskImpl.class, typeTask.getPrimaryKey());

			clearUniqueFindersCache(typeTask);
		}
	}

	protected void cacheUniqueFindersCache(TypeTask typeTask) {
		if (typeTask.isNew()) {
			Object[] args = new Object[] {
					typeTask.getUuid(), typeTask.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				typeTask);

			args = new Object[] { typeTask.getClassPK() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPETASKCLASSPK,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK,
				args, typeTask);
		}
		else {
			TypeTaskModelImpl typeTaskModelImpl = (TypeTaskModelImpl)typeTask;

			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTask.getUuid(), typeTask.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					typeTask);
			}

			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TYPETASKCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { typeTask.getClassPK() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPETASKCLASSPK,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK,
					args, typeTask);
			}
		}
	}

	protected void clearUniqueFindersCache(TypeTask typeTask) {
		TypeTaskModelImpl typeTaskModelImpl = (TypeTaskModelImpl)typeTask;

		Object[] args = new Object[] { typeTask.getUuid(), typeTask.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((typeTaskModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					typeTaskModelImpl.getOriginalUuid(),
					typeTaskModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { typeTask.getClassPK() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASKCLASSPK, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK, args);

		if ((typeTaskModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TYPETASKCLASSPK.getColumnBitmask()) != 0) {
			args = new Object[] { typeTaskModelImpl.getOriginalClassPK() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASKCLASSPK,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPETASKCLASSPK,
				args);
		}
	}

	/**
	 * Creates a new type task with the primary key. Does not add the type task to the database.
	 *
	 * @param typeTaskId the primary key for the new type task
	 * @return the new type task
	 */
	@Override
	public TypeTask create(long typeTaskId) {
		TypeTask typeTask = new TypeTaskImpl();

		typeTask.setNew(true);
		typeTask.setPrimaryKey(typeTaskId);

		String uuid = PortalUUIDUtil.generate();

		typeTask.setUuid(uuid);

		return typeTask;
	}

	/**
	 * Removes the type task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeTaskId the primary key of the type task
	 * @return the type task that was removed
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask remove(long typeTaskId)
		throws NoSuchTypeTaskException, SystemException {
		return remove((Serializable)typeTaskId);
	}

	/**
	 * Removes the type task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the type task
	 * @return the type task that was removed
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask remove(Serializable primaryKey)
		throws NoSuchTypeTaskException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TypeTask typeTask = (TypeTask)session.get(TypeTaskImpl.class,
					primaryKey);

			if (typeTask == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(typeTask);
		}
		catch (NoSuchTypeTaskException nsee) {
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
	protected TypeTask removeImpl(TypeTask typeTask) throws SystemException {
		typeTask = toUnwrappedModel(typeTask);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(typeTask)) {
				typeTask = (TypeTask)session.get(TypeTaskImpl.class,
						typeTask.getPrimaryKeyObj());
			}

			if (typeTask != null) {
				session.delete(typeTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (typeTask != null) {
			clearCache(typeTask);
		}

		return typeTask;
	}

	@Override
	public TypeTask updateImpl(
		br.com.prodevelopment.etask.model.TypeTask typeTask)
		throws SystemException {
		typeTask = toUnwrappedModel(typeTask);

		boolean isNew = typeTask.isNew();

		TypeTaskModelImpl typeTaskModelImpl = (TypeTaskModelImpl)typeTask;

		if (Validator.isNull(typeTask.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			typeTask.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (typeTask.isNew()) {
				session.save(typeTask);

				typeTask.setNew(false);
			}
			else {
				session.merge(typeTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TypeTaskModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { typeTaskModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { typeTaskModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskModelImpl.getOriginalUuid(),
						typeTaskModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						typeTaskModelImpl.getUuid(),
						typeTaskModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { typeTaskModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskModelImpl.getOriginalCompanyId(),
						typeTaskModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);

				args = new Object[] {
						typeTaskModelImpl.getCompanyId(),
						typeTaskModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);
			}

			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskModelImpl.getOriginalCompanyId(),
						typeTaskModelImpl.getOriginalGroupId(),
						typeTaskModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S,
					args);

				args = new Object[] {
						typeTaskModelImpl.getCompanyId(),
						typeTaskModelImpl.getGroupId(),
						typeTaskModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S,
					args);
			}

			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskModelImpl.getOriginalCompanyId(),
						typeTaskModelImpl.getOriginalGroupId(),
						typeTaskModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_CLASS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASS,
					args);

				args = new Object[] {
						typeTaskModelImpl.getCompanyId(),
						typeTaskModelImpl.getGroupId(),
						typeTaskModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_CLASS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_CLASS,
					args);
			}

			if ((typeTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S_CLASS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskModelImpl.getOriginalCompanyId(),
						typeTaskModelImpl.getOriginalGroupId(),
						typeTaskModelImpl.getOriginalStatus(),
						typeTaskModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_S_CLASS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S_CLASS,
					args);

				args = new Object[] {
						typeTaskModelImpl.getCompanyId(),
						typeTaskModelImpl.getGroupId(),
						typeTaskModelImpl.getStatus(),
						typeTaskModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG_S_CLASS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG_S_CLASS,
					args);
			}
		}

		EntityCacheUtil.putResult(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskImpl.class, typeTask.getPrimaryKey(), typeTask);

		clearUniqueFindersCache(typeTask);
		cacheUniqueFindersCache(typeTask);

		return typeTask;
	}

	protected TypeTask toUnwrappedModel(TypeTask typeTask) {
		if (typeTask instanceof TypeTaskImpl) {
			return typeTask;
		}

		TypeTaskImpl typeTaskImpl = new TypeTaskImpl();

		typeTaskImpl.setNew(typeTask.isNew());
		typeTaskImpl.setPrimaryKey(typeTask.getPrimaryKey());

		typeTaskImpl.setUuid(typeTask.getUuid());
		typeTaskImpl.setTypeTaskId(typeTask.getTypeTaskId());
		typeTaskImpl.setGroupId(typeTask.getGroupId());
		typeTaskImpl.setCompanyId(typeTask.getCompanyId());
		typeTaskImpl.setUserIdCreate(typeTask.getUserIdCreate());
		typeTaskImpl.setUserIdModified(typeTask.getUserIdModified());
		typeTaskImpl.setCreateDate(typeTask.getCreateDate());
		typeTaskImpl.setModifiedDate(typeTask.getModifiedDate());
		typeTaskImpl.setName(typeTask.getName());
		typeTaskImpl.setDescription(typeTask.getDescription());
		typeTaskImpl.setDDMStructureId(typeTask.getDDMStructureId());
		typeTaskImpl.setStatus(typeTask.getStatus());
		typeTaskImpl.setStatusByUserId(typeTask.getStatusByUserId());
		typeTaskImpl.setStatusByUserName(typeTask.getStatusByUserName());
		typeTaskImpl.setStatusDate(typeTask.getStatusDate());
		typeTaskImpl.setCustomFieldsActive(typeTask.isCustomFieldsActive());
		typeTaskImpl.setClassNameId(typeTask.getClassNameId());
		typeTaskImpl.setClassPK(typeTask.getClassPK());

		return typeTaskImpl;
	}

	/**
	 * Returns the type task with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the type task
	 * @return the type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeTaskException, SystemException {
		TypeTask typeTask = fetchByPrimaryKey(primaryKey);

		if (typeTask == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return typeTask;
	}

	/**
	 * Returns the type task with the primary key or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskException} if it could not be found.
	 *
	 * @param typeTaskId the primary key of the type task
	 * @return the type task
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskException if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask findByPrimaryKey(long typeTaskId)
		throws NoSuchTypeTaskException, SystemException {
		return findByPrimaryKey((Serializable)typeTaskId);
	}

	/**
	 * Returns the type task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the type task
	 * @return the type task, or <code>null</code> if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TypeTask typeTask = (TypeTask)EntityCacheUtil.getResult(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
				TypeTaskImpl.class, primaryKey);

		if (typeTask == _nullTypeTask) {
			return null;
		}

		if (typeTask == null) {
			Session session = null;

			try {
				session = openSession();

				typeTask = (TypeTask)session.get(TypeTaskImpl.class, primaryKey);

				if (typeTask != null) {
					cacheResult(typeTask);
				}
				else {
					EntityCacheUtil.putResult(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
						TypeTaskImpl.class, primaryKey, _nullTypeTask);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TypeTaskModelImpl.ENTITY_CACHE_ENABLED,
					TypeTaskImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return typeTask;
	}

	/**
	 * Returns the type task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeTaskId the primary key of the type task
	 * @return the type task, or <code>null</code> if a type task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTask fetchByPrimaryKey(long typeTaskId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)typeTaskId);
	}

	/**
	 * Returns all the type tasks.
	 *
	 * @return the type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @return the range of type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of type tasks
	 * @param end the upper bound of the range of type tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTask> findAll(int start, int end,
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

		List<TypeTask> list = (List<TypeTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TYPETASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TYPETASK;

				if (pagination) {
					sql = sql.concat(TypeTaskModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTask>(list);
				}
				else {
					list = (List<TypeTask>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the type tasks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TypeTask typeTask : findAll()) {
			remove(typeTask);
		}
	}

	/**
	 * Returns the number of type tasks.
	 *
	 * @return the number of type tasks
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

				Query q = session.createQuery(_SQL_COUNT_TYPETASK);

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
	 * Initializes the type task persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.etask.model.TypeTask")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TypeTask>> listenersList = new ArrayList<ModelListener<TypeTask>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TypeTask>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TypeTaskImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TYPETASK = "SELECT typeTask FROM TypeTask typeTask";
	private static final String _SQL_SELECT_TYPETASK_WHERE = "SELECT typeTask FROM TypeTask typeTask WHERE ";
	private static final String _SQL_COUNT_TYPETASK = "SELECT COUNT(typeTask) FROM TypeTask typeTask";
	private static final String _SQL_COUNT_TYPETASK_WHERE = "SELECT COUNT(typeTask) FROM TypeTask typeTask WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "typeTask.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TypeTask exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TypeTask exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TypeTaskPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static TypeTask _nullTypeTask = new TypeTaskImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TypeTask> toCacheModel() {
				return _nullTypeTaskCacheModel;
			}
		};

	private static CacheModel<TypeTask> _nullTypeTaskCacheModel = new CacheModel<TypeTask>() {
			@Override
			public TypeTask toEntityModel() {
				return _nullTypeTask;
			}
		};
}