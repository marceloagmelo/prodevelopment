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

package br.com.prodevelopment.eticket.service.persistence;

import br.com.prodevelopment.eticket.NoSuchTypeTicketException;
import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.model.impl.TypeTicketImpl;
import br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl;

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
 * The persistence implementation for the type ticket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTicketPersistence
 * @see TypeTicketUtil
 * @generated
 */
public class TypeTicketPersistenceImpl extends BasePersistenceImpl<TypeTicket>
	implements TypeTicketPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TypeTicketUtil} to access the type ticket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TypeTicketImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TypeTicketModelImpl.UUID_COLUMN_BITMASK |
			TypeTicketModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the type tickets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tickets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @return the range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tickets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByUuid(String uuid, int start, int end,
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

		List<TypeTicket> list = (List<TypeTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTicket typeTicket : list) {
				if (!Validator.equals(uuid, typeTicket.getUuid())) {
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

			query.append(_SQL_SELECT_TYPETICKET_WHERE);

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
				query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
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
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicket>(list);
				}
				else {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type ticket in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByUuid_First(uuid, orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the first type ticket in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTicket> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type ticket in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByUuid_Last(uuid, orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the last type ticket in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TypeTicket> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tickets before and after the current type ticket in the ordered set where uuid = &#63;.
	 *
	 * @param typeTicketId the primary key of the current type ticket
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket[] findByUuid_PrevAndNext(long typeTicketId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = findByPrimaryKey(typeTicketId);

		Session session = null;

		try {
			session = openSession();

			TypeTicket[] array = new TypeTicketImpl[3];

			array[0] = getByUuid_PrevAndNext(session, typeTicket, uuid,
					orderByComparator, true);

			array[1] = typeTicket;

			array[2] = getByUuid_PrevAndNext(session, typeTicket, uuid,
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

	protected TypeTicket getByUuid_PrevAndNext(Session session,
		TypeTicket typeTicket, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETICKET_WHERE);

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
			query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(typeTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tickets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (TypeTicket typeTicket : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(typeTicket);
		}
	}

	/**
	 * Returns the number of type tickets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching type tickets
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

			query.append(_SQL_COUNT_TYPETICKET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "typeTicket.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "typeTicket.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(typeTicket.uuid IS NULL OR typeTicket.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TypeTicketModelImpl.UUID_COLUMN_BITMASK |
			TypeTicketModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the type ticket where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByUUID_G(String uuid, long groupId)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByUUID_G(uuid, groupId);

		if (typeTicket == null) {
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

			throw new NoSuchTypeTicketException(msg.toString());
		}

		return typeTicket;
	}

	/**
	 * Returns the type ticket where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the type ticket where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof TypeTicket) {
			TypeTicket typeTicket = (TypeTicket)result;

			if (!Validator.equals(uuid, typeTicket.getUuid()) ||
					(groupId != typeTicket.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TYPETICKET_WHERE);

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

				List<TypeTicket> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					TypeTicket typeTicket = list.get(0);

					result = typeTicket;

					cacheResult(typeTicket);

					if ((typeTicket.getUuid() == null) ||
							!typeTicket.getUuid().equals(uuid) ||
							(typeTicket.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, typeTicket);
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
			return (TypeTicket)result;
		}
	}

	/**
	 * Removes the type ticket where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the type ticket that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket removeByUUID_G(String uuid, long groupId)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = findByUUID_G(uuid, groupId);

		return remove(typeTicket);
	}

	/**
	 * Returns the number of type tickets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching type tickets
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

			query.append(_SQL_COUNT_TYPETICKET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "typeTicket.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "typeTicket.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(typeTicket.uuid IS NULL OR typeTicket.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "typeTicket.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TypeTicketModelImpl.UUID_COLUMN_BITMASK |
			TypeTicketModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTicketModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the type tickets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tickets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @return the range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tickets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<TypeTicket> list = (List<TypeTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTicket typeTicket : list) {
				if (!Validator.equals(uuid, typeTicket.getUuid()) ||
						(companyId != typeTicket.getCompanyId())) {
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

			query.append(_SQL_SELECT_TYPETICKET_WHERE);

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
				query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
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
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicket>(list);
				}
				else {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the first type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTicket> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the last type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TypeTicket> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tickets before and after the current type ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param typeTicketId the primary key of the current type ticket
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket[] findByUuid_C_PrevAndNext(long typeTicketId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = findByPrimaryKey(typeTicketId);

		Session session = null;

		try {
			session = openSession();

			TypeTicket[] array = new TypeTicketImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, typeTicket, uuid,
					companyId, orderByComparator, true);

			array[1] = typeTicket;

			array[2] = getByUuid_C_PrevAndNext(session, typeTicket, uuid,
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

	protected TypeTicket getByUuid_C_PrevAndNext(Session session,
		TypeTicket typeTicket, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETICKET_WHERE);

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
			query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(typeTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tickets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (TypeTicket typeTicket : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTicket);
		}
	}

	/**
	 * Returns the number of type tickets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching type tickets
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

			query.append(_SQL_COUNT_TYPETICKET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "typeTicket.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "typeTicket.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(typeTicket.uuid IS NULL OR typeTicket.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "typeTicket.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_LIKENAME =
		new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_LikeName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_LIKENAME =
		new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_LikeName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the type tickets where companyId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByC_LikeName(long companyId, String name)
		throws SystemException {
		return findByC_LikeName(companyId, name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tickets where companyId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @return the range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByC_LikeName(long companyId, String name,
		int start, int end) throws SystemException {
		return findByC_LikeName(companyId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tickets where companyId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByC_LikeName(long companyId, String name,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_LIKENAME;
		finderArgs = new Object[] { companyId, name, start, end, orderByComparator };

		List<TypeTicket> list = (List<TypeTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTicket typeTicket : list) {
				if ((companyId != typeTicket.getCompanyId()) ||
						!StringUtil.wildcardMatches(typeTicket.getName(), name,
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

			query.append(_SQL_SELECT_TYPETICKET_WHERE);

			query.append(_FINDER_COLUMN_C_LIKENAME_COMPANYID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_C_LIKENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_LIKENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_C_LIKENAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicket>(list);
				}
				else {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByC_LikeName_First(long companyId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByC_LikeName_First(companyId, name,
				orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the first type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByC_LikeName_First(long companyId, String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTicket> list = findByC_LikeName(companyId, name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByC_LikeName_Last(long companyId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByC_LikeName_Last(companyId, name,
				orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the last type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByC_LikeName_Last(long companyId, String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_LikeName(companyId, name);

		if (count == 0) {
			return null;
		}

		List<TypeTicket> list = findByC_LikeName(companyId, name, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tickets before and after the current type ticket in the ordered set where companyId = &#63; and name LIKE &#63;.
	 *
	 * @param typeTicketId the primary key of the current type ticket
	 * @param companyId the company ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket[] findByC_LikeName_PrevAndNext(long typeTicketId,
		long companyId, String name, OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = findByPrimaryKey(typeTicketId);

		Session session = null;

		try {
			session = openSession();

			TypeTicket[] array = new TypeTicketImpl[3];

			array[0] = getByC_LikeName_PrevAndNext(session, typeTicket,
					companyId, name, orderByComparator, true);

			array[1] = typeTicket;

			array[2] = getByC_LikeName_PrevAndNext(session, typeTicket,
					companyId, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTicket getByC_LikeName_PrevAndNext(Session session,
		TypeTicket typeTicket, long companyId, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETICKET_WHERE);

		query.append(_FINDER_COLUMN_C_LIKENAME_COMPANYID_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_C_LIKENAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_LIKENAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_C_LIKENAME_NAME_2);
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
			query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tickets where companyId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_LikeName(long companyId, String name)
		throws SystemException {
		for (TypeTicket typeTicket : findByC_LikeName(companyId, name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTicket);
		}
	}

	/**
	 * Returns the number of type tickets where companyId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the number of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_LikeName(long companyId, String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_LIKENAME;

		Object[] finderArgs = new Object[] { companyId, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TYPETICKET_WHERE);

			query.append(_FINDER_COLUMN_C_LIKENAME_COMPANYID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_C_LIKENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_LIKENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_C_LIKENAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_C_LIKENAME_COMPANYID_2 = "typeTicket.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_LIKENAME_NAME_1 = "typeTicket.name LIKE NULL";
	private static final String _FINDER_COLUMN_C_LIKENAME_NAME_2 = "typeTicket.name LIKE ?";
	private static final String _FINDER_COLUMN_C_LIKENAME_NAME_3 = "(typeTicket.name IS NULL OR typeTicket.name LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			TypeTicketModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTicketModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the type tickets where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the type tickets where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @return the range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tickets where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCompany(long companyId, int start, int end,
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

		List<TypeTicket> list = (List<TypeTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTicket typeTicket : list) {
				if ((companyId != typeTicket.getCompanyId())) {
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

			query.append(_SQL_SELECT_TYPETICKET_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicket>(list);
				}
				else {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type ticket in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByCompany_First(companyId,
				orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the first type ticket in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTicket> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type ticket in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByCompany_Last(companyId, orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the last type ticket in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<TypeTicket> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tickets before and after the current type ticket in the ordered set where companyId = &#63;.
	 *
	 * @param typeTicketId the primary key of the current type ticket
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket[] findByCompany_PrevAndNext(long typeTicketId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = findByPrimaryKey(typeTicketId);

		Session session = null;

		try {
			session = openSession();

			TypeTicket[] array = new TypeTicketImpl[3];

			array[0] = getByCompany_PrevAndNext(session, typeTicket, companyId,
					orderByComparator, true);

			array[1] = typeTicket;

			array[2] = getByCompany_PrevAndNext(session, typeTicket, companyId,
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

	protected TypeTicket getByCompany_PrevAndNext(Session session,
		TypeTicket typeTicket, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETICKET_WHERE);

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
			query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tickets where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (TypeTicket typeTicket : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTicket);
		}
	}

	/**
	 * Returns the number of type tickets where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching type tickets
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

			query.append(_SQL_COUNT_TYPETICKET_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "typeTicket.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCG",
			new String[] { Long.class.getName(), Long.class.getName() },
			TypeTicketModelImpl.COMPANYID_COLUMN_BITMASK |
			TypeTicketModelImpl.GROUPID_COLUMN_BITMASK |
			TypeTicketModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CG = new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCG",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the type tickets where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCG(long companyId, long groupId)
		throws SystemException {
		return findByCG(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tickets where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @return the range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCG(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByCG(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tickets where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCG(long companyId, long groupId, int start,
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

		List<TypeTicket> list = (List<TypeTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTicket typeTicket : list) {
				if ((companyId != typeTicket.getCompanyId()) ||
						(groupId != typeTicket.getGroupId())) {
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

			query.append(_SQL_SELECT_TYPETICKET_WHERE);

			query.append(_FINDER_COLUMN_CG_COMPANYID_2);

			query.append(_FINDER_COLUMN_CG_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
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
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicket>(list);
				}
				else {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByCG_First(companyId, groupId,
				orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByCG_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTicket> list = findByCG(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByCG_Last(companyId, groupId,
				orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByCG_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCG(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<TypeTicket> list = findByCG(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tickets before and after the current type ticket in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param typeTicketId the primary key of the current type ticket
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket[] findByCG_PrevAndNext(long typeTicketId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = findByPrimaryKey(typeTicketId);

		Session session = null;

		try {
			session = openSession();

			TypeTicket[] array = new TypeTicketImpl[3];

			array[0] = getByCG_PrevAndNext(session, typeTicket, companyId,
					groupId, orderByComparator, true);

			array[1] = typeTicket;

			array[2] = getByCG_PrevAndNext(session, typeTicket, companyId,
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

	protected TypeTicket getByCG_PrevAndNext(Session session,
		TypeTicket typeTicket, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETICKET_WHERE);

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
			query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tickets where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG(long companyId, long groupId)
		throws SystemException {
		for (TypeTicket typeTicket : findByCG(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTicket);
		}
	}

	/**
	 * Returns the number of type tickets where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching type tickets
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

			query.append(_SQL_COUNT_TYPETICKET_WHERE);

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

	private static final String _FINDER_COLUMN_CG_COMPANYID_2 = "typeTicket.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_GROUPID_2 = "typeTicket.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CG_LIKENAME =
		new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, TypeTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCG_LikeName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CG_LIKENAME =
		new FinderPath(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCG_LikeName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCG_LikeName(long companyId, long groupId,
		String name) throws SystemException {
		return findByCG_LikeName(companyId, groupId, name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @return the range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCG_LikeName(long companyId, long groupId,
		String name, int start, int end) throws SystemException {
		return findByCG_LikeName(companyId, groupId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findByCG_LikeName(long companyId, long groupId,
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

		List<TypeTicket> list = (List<TypeTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTicket typeTicket : list) {
				if ((companyId != typeTicket.getCompanyId()) ||
						(groupId != typeTicket.getGroupId()) ||
						!StringUtil.wildcardMatches(typeTicket.getName(), name,
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

			query.append(_SQL_SELECT_TYPETICKET_WHERE);

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
				query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
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
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicket>(list);
				}
				else {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByCG_LikeName_First(long companyId, long groupId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByCG_LikeName_First(companyId, groupId,
				name, orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
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

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the first type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByCG_LikeName_First(long companyId, long groupId,
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		List<TypeTicket> list = findByCG_LikeName(companyId, groupId, name, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByCG_LikeName_Last(long companyId, long groupId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByCG_LikeName_Last(companyId, groupId,
				name, orderByComparator);

		if (typeTicket != null) {
			return typeTicket;
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

		throw new NoSuchTypeTicketException(msg.toString());
	}

	/**
	 * Returns the last type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket, or <code>null</code> if a matching type ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByCG_LikeName_Last(long companyId, long groupId,
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCG_LikeName(companyId, groupId, name);

		if (count == 0) {
			return null;
		}

		List<TypeTicket> list = findByCG_LikeName(companyId, groupId, name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type tickets before and after the current type ticket in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param typeTicketId the primary key of the current type ticket
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket[] findByCG_LikeName_PrevAndNext(long typeTicketId,
		long companyId, long groupId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = findByPrimaryKey(typeTicketId);

		Session session = null;

		try {
			session = openSession();

			TypeTicket[] array = new TypeTicketImpl[3];

			array[0] = getByCG_LikeName_PrevAndNext(session, typeTicket,
					companyId, groupId, name, orderByComparator, true);

			array[1] = typeTicket;

			array[2] = getByCG_LikeName_PrevAndNext(session, typeTicket,
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

	protected TypeTicket getByCG_LikeName_PrevAndNext(Session session,
		TypeTicket typeTicket, long companyId, long groupId, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETICKET_WHERE);

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
			query.append(TypeTicketModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(typeTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCG_LikeName(long companyId, long groupId, String name)
		throws SystemException {
		for (TypeTicket typeTicket : findByCG_LikeName(companyId, groupId,
				name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTicket);
		}
	}

	/**
	 * Returns the number of type tickets where companyId = &#63; and groupId = &#63; and name LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching type tickets
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

			query.append(_SQL_COUNT_TYPETICKET_WHERE);

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

	private static final String _FINDER_COLUMN_CG_LIKENAME_COMPANYID_2 = "typeTicket.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LIKENAME_GROUPID_2 = "typeTicket.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CG_LIKENAME_NAME_1 = "typeTicket.name LIKE NULL";
	private static final String _FINDER_COLUMN_CG_LIKENAME_NAME_2 = "typeTicket.name LIKE ?";
	private static final String _FINDER_COLUMN_CG_LIKENAME_NAME_3 = "(typeTicket.name IS NULL OR typeTicket.name LIKE '')";

	public TypeTicketPersistenceImpl() {
		setModelClass(TypeTicket.class);
	}

	/**
	 * Caches the type ticket in the entity cache if it is enabled.
	 *
	 * @param typeTicket the type ticket
	 */
	@Override
	public void cacheResult(TypeTicket typeTicket) {
		EntityCacheUtil.putResult(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketImpl.class, typeTicket.getPrimaryKey(), typeTicket);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { typeTicket.getUuid(), typeTicket.getGroupId() },
			typeTicket);

		typeTicket.resetOriginalValues();
	}

	/**
	 * Caches the type tickets in the entity cache if it is enabled.
	 *
	 * @param typeTickets the type tickets
	 */
	@Override
	public void cacheResult(List<TypeTicket> typeTickets) {
		for (TypeTicket typeTicket : typeTickets) {
			if (EntityCacheUtil.getResult(
						TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
						TypeTicketImpl.class, typeTicket.getPrimaryKey()) == null) {
				cacheResult(typeTicket);
			}
			else {
				typeTicket.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all type tickets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TypeTicketImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TypeTicketImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the type ticket.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TypeTicket typeTicket) {
		EntityCacheUtil.removeResult(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketImpl.class, typeTicket.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(typeTicket);
	}

	@Override
	public void clearCache(List<TypeTicket> typeTickets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TypeTicket typeTicket : typeTickets) {
			EntityCacheUtil.removeResult(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
				TypeTicketImpl.class, typeTicket.getPrimaryKey());

			clearUniqueFindersCache(typeTicket);
		}
	}

	protected void cacheUniqueFindersCache(TypeTicket typeTicket) {
		if (typeTicket.isNew()) {
			Object[] args = new Object[] {
					typeTicket.getUuid(), typeTicket.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				typeTicket);
		}
		else {
			TypeTicketModelImpl typeTicketModelImpl = (TypeTicketModelImpl)typeTicket;

			if ((typeTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTicket.getUuid(), typeTicket.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					typeTicket);
			}
		}
	}

	protected void clearUniqueFindersCache(TypeTicket typeTicket) {
		TypeTicketModelImpl typeTicketModelImpl = (TypeTicketModelImpl)typeTicket;

		Object[] args = new Object[] {
				typeTicket.getUuid(), typeTicket.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((typeTicketModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					typeTicketModelImpl.getOriginalUuid(),
					typeTicketModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new type ticket with the primary key. Does not add the type ticket to the database.
	 *
	 * @param typeTicketId the primary key for the new type ticket
	 * @return the new type ticket
	 */
	@Override
	public TypeTicket create(long typeTicketId) {
		TypeTicket typeTicket = new TypeTicketImpl();

		typeTicket.setNew(true);
		typeTicket.setPrimaryKey(typeTicketId);

		String uuid = PortalUUIDUtil.generate();

		typeTicket.setUuid(uuid);

		return typeTicket;
	}

	/**
	 * Removes the type ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeTicketId the primary key of the type ticket
	 * @return the type ticket that was removed
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket remove(long typeTicketId)
		throws NoSuchTypeTicketException, SystemException {
		return remove((Serializable)typeTicketId);
	}

	/**
	 * Removes the type ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the type ticket
	 * @return the type ticket that was removed
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket remove(Serializable primaryKey)
		throws NoSuchTypeTicketException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TypeTicket typeTicket = (TypeTicket)session.get(TypeTicketImpl.class,
					primaryKey);

			if (typeTicket == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeTicketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(typeTicket);
		}
		catch (NoSuchTypeTicketException nsee) {
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
	protected TypeTicket removeImpl(TypeTicket typeTicket)
		throws SystemException {
		typeTicket = toUnwrappedModel(typeTicket);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(typeTicket)) {
				typeTicket = (TypeTicket)session.get(TypeTicketImpl.class,
						typeTicket.getPrimaryKeyObj());
			}

			if (typeTicket != null) {
				session.delete(typeTicket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (typeTicket != null) {
			clearCache(typeTicket);
		}

		return typeTicket;
	}

	@Override
	public TypeTicket updateImpl(
		br.com.prodevelopment.eticket.model.TypeTicket typeTicket)
		throws SystemException {
		typeTicket = toUnwrappedModel(typeTicket);

		boolean isNew = typeTicket.isNew();

		TypeTicketModelImpl typeTicketModelImpl = (TypeTicketModelImpl)typeTicket;

		if (Validator.isNull(typeTicket.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			typeTicket.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (typeTicket.isNew()) {
				session.save(typeTicket);

				typeTicket.setNew(false);
			}
			else {
				session.merge(typeTicket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TypeTicketModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((typeTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTicketModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { typeTicketModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((typeTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTicketModelImpl.getOriginalUuid(),
						typeTicketModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						typeTicketModelImpl.getUuid(),
						typeTicketModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((typeTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTicketModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { typeTicketModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((typeTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTicketModelImpl.getOriginalCompanyId(),
						typeTicketModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);

				args = new Object[] {
						typeTicketModelImpl.getCompanyId(),
						typeTicketModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CG,
					args);
			}
		}

		EntityCacheUtil.putResult(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketImpl.class, typeTicket.getPrimaryKey(), typeTicket);

		clearUniqueFindersCache(typeTicket);
		cacheUniqueFindersCache(typeTicket);

		return typeTicket;
	}

	protected TypeTicket toUnwrappedModel(TypeTicket typeTicket) {
		if (typeTicket instanceof TypeTicketImpl) {
			return typeTicket;
		}

		TypeTicketImpl typeTicketImpl = new TypeTicketImpl();

		typeTicketImpl.setNew(typeTicket.isNew());
		typeTicketImpl.setPrimaryKey(typeTicket.getPrimaryKey());

		typeTicketImpl.setUuid(typeTicket.getUuid());
		typeTicketImpl.setTypeTicketId(typeTicket.getTypeTicketId());
		typeTicketImpl.setGroupId(typeTicket.getGroupId());
		typeTicketImpl.setCompanyId(typeTicket.getCompanyId());
		typeTicketImpl.setUserIdCreate(typeTicket.getUserIdCreate());
		typeTicketImpl.setUserIdModified(typeTicket.getUserIdModified());
		typeTicketImpl.setCreateDate(typeTicket.getCreateDate());
		typeTicketImpl.setModifiedDate(typeTicket.getModifiedDate());
		typeTicketImpl.setName(typeTicket.getName());
		typeTicketImpl.setDescription(typeTicket.getDescription());
		typeTicketImpl.setXsd(typeTicket.getXsd());

		return typeTicketImpl;
	}

	/**
	 * Returns the type ticket with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the type ticket
	 * @return the type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeTicketException, SystemException {
		TypeTicket typeTicket = fetchByPrimaryKey(primaryKey);

		if (typeTicket == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeTicketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return typeTicket;
	}

	/**
	 * Returns the type ticket with the primary key or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketException} if it could not be found.
	 *
	 * @param typeTicketId the primary key of the type ticket
	 * @return the type ticket
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketException if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket findByPrimaryKey(long typeTicketId)
		throws NoSuchTypeTicketException, SystemException {
		return findByPrimaryKey((Serializable)typeTicketId);
	}

	/**
	 * Returns the type ticket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the type ticket
	 * @return the type ticket, or <code>null</code> if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TypeTicket typeTicket = (TypeTicket)EntityCacheUtil.getResult(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
				TypeTicketImpl.class, primaryKey);

		if (typeTicket == _nullTypeTicket) {
			return null;
		}

		if (typeTicket == null) {
			Session session = null;

			try {
				session = openSession();

				typeTicket = (TypeTicket)session.get(TypeTicketImpl.class,
						primaryKey);

				if (typeTicket != null) {
					cacheResult(typeTicket);
				}
				else {
					EntityCacheUtil.putResult(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
						TypeTicketImpl.class, primaryKey, _nullTypeTicket);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TypeTicketModelImpl.ENTITY_CACHE_ENABLED,
					TypeTicketImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return typeTicket;
	}

	/**
	 * Returns the type ticket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeTicketId the primary key of the type ticket
	 * @return the type ticket, or <code>null</code> if a type ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicket fetchByPrimaryKey(long typeTicketId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)typeTicketId);
	}

	/**
	 * Returns all the type tickets.
	 *
	 * @return the type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @return the range of type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the type tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of type tickets
	 * @param end the upper bound of the range of type tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicket> findAll(int start, int end,
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

		List<TypeTicket> list = (List<TypeTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TYPETICKET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TYPETICKET;

				if (pagination) {
					sql = sql.concat(TypeTicketModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicket>(list);
				}
				else {
					list = (List<TypeTicket>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the type tickets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TypeTicket typeTicket : findAll()) {
			remove(typeTicket);
		}
	}

	/**
	 * Returns the number of type tickets.
	 *
	 * @return the number of type tickets
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

				Query q = session.createQuery(_SQL_COUNT_TYPETICKET);

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
	 * Initializes the type ticket persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.eticket.model.TypeTicket")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TypeTicket>> listenersList = new ArrayList<ModelListener<TypeTicket>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TypeTicket>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TypeTicketImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TYPETICKET = "SELECT typeTicket FROM TypeTicket typeTicket";
	private static final String _SQL_SELECT_TYPETICKET_WHERE = "SELECT typeTicket FROM TypeTicket typeTicket WHERE ";
	private static final String _SQL_COUNT_TYPETICKET = "SELECT COUNT(typeTicket) FROM TypeTicket typeTicket";
	private static final String _SQL_COUNT_TYPETICKET_WHERE = "SELECT COUNT(typeTicket) FROM TypeTicket typeTicket WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "typeTicket.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TypeTicket exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TypeTicket exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TypeTicketPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static TypeTicket _nullTypeTicket = new TypeTicketImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TypeTicket> toCacheModel() {
				return _nullTypeTicketCacheModel;
			}
		};

	private static CacheModel<TypeTicket> _nullTypeTicketCacheModel = new CacheModel<TypeTicket>() {
			@Override
			public TypeTicket toEntityModel() {
				return _nullTypeTicket;
			}
		};
}