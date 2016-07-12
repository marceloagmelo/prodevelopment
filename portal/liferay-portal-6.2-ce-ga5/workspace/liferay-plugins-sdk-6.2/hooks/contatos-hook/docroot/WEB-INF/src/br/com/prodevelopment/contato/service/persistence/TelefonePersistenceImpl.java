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

package br.com.prodevelopment.contato.service.persistence;

import br.com.prodevelopment.contato.NoSuchTelefoneException;
import br.com.prodevelopment.contato.model.Telefone;
import br.com.prodevelopment.contato.model.impl.TelefoneImpl;
import br.com.prodevelopment.contato.model.impl.TelefoneModelImpl;

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
 * The persistence implementation for the telefone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TelefonePersistence
 * @see TelefoneUtil
 * @generated
 */
public class TelefonePersistenceImpl extends BasePersistenceImpl<Telefone>
	implements TelefonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TelefoneUtil} to access the telefone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TelefoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TelefoneModelImpl.UUID_COLUMN_BITMASK |
			TelefoneModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the telefones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the telefones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @return the range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the telefones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByUuid(String uuid, int start, int end,
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

		List<Telefone> list = (List<Telefone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Telefone telefone : list) {
				if (!Validator.equals(uuid, telefone.getUuid())) {
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

			query.append(_SQL_SELECT_TELEFONE_WHERE);

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
				query.append(TelefoneModelImpl.ORDER_BY_JPQL);
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
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Telefone>(list);
				}
				else {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first telefone in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByUuid_First(uuid, orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the first telefone in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Telefone> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last telefone in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByUuid_Last(uuid, orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the last telefone in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Telefone> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the telefones before and after the current telefone in the ordered set where uuid = &#63;.
	 *
	 * @param telefoneId the primary key of the current telefone
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone[] findByUuid_PrevAndNext(long telefoneId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = findByPrimaryKey(telefoneId);

		Session session = null;

		try {
			session = openSession();

			Telefone[] array = new TelefoneImpl[3];

			array[0] = getByUuid_PrevAndNext(session, telefone, uuid,
					orderByComparator, true);

			array[1] = telefone;

			array[2] = getByUuid_PrevAndNext(session, telefone, uuid,
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

	protected Telefone getByUuid_PrevAndNext(Session session,
		Telefone telefone, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TELEFONE_WHERE);

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
			query.append(TelefoneModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(telefone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Telefone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the telefones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Telefone telefone : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(telefone);
		}
	}

	/**
	 * Returns the number of telefones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching telefones
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

			query.append(_SQL_COUNT_TELEFONE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "telefone.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "telefone.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(telefone.uuid IS NULL OR telefone.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TelefoneModelImpl.UUID_COLUMN_BITMASK |
			TelefoneModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the telefone where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchTelefoneException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByUUID_G(String uuid, long groupId)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByUUID_G(uuid, groupId);

		if (telefone == null) {
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

			throw new NoSuchTelefoneException(msg.toString());
		}

		return telefone;
	}

	/**
	 * Returns the telefone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the telefone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Telefone) {
			Telefone telefone = (Telefone)result;

			if (!Validator.equals(uuid, telefone.getUuid()) ||
					(groupId != telefone.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TELEFONE_WHERE);

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

				List<Telefone> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Telefone telefone = list.get(0);

					result = telefone;

					cacheResult(telefone);

					if ((telefone.getUuid() == null) ||
							!telefone.getUuid().equals(uuid) ||
							(telefone.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, telefone);
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
			return (Telefone)result;
		}
	}

	/**
	 * Removes the telefone where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the telefone that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone removeByUUID_G(String uuid, long groupId)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = findByUUID_G(uuid, groupId);

		return remove(telefone);
	}

	/**
	 * Returns the number of telefones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching telefones
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

			query.append(_SQL_COUNT_TELEFONE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "telefone.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "telefone.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(telefone.uuid IS NULL OR telefone.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "telefone.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TelefoneModelImpl.UUID_COLUMN_BITMASK |
			TelefoneModelImpl.COMPANYID_COLUMN_BITMASK |
			TelefoneModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the telefones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the telefones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @return the range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the telefones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByUuid_C(String uuid, long companyId, int start,
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

		List<Telefone> list = (List<Telefone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Telefone telefone : list) {
				if (!Validator.equals(uuid, telefone.getUuid()) ||
						(companyId != telefone.getCompanyId())) {
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

			query.append(_SQL_SELECT_TELEFONE_WHERE);

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
				query.append(TelefoneModelImpl.ORDER_BY_JPQL);
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
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Telefone>(list);
				}
				else {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the first telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Telefone> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the last telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Telefone> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the telefones before and after the current telefone in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param telefoneId the primary key of the current telefone
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone[] findByUuid_C_PrevAndNext(long telefoneId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = findByPrimaryKey(telefoneId);

		Session session = null;

		try {
			session = openSession();

			Telefone[] array = new TelefoneImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, telefone, uuid,
					companyId, orderByComparator, true);

			array[1] = telefone;

			array[2] = getByUuid_C_PrevAndNext(session, telefone, uuid,
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

	protected Telefone getByUuid_C_PrevAndNext(Session session,
		Telefone telefone, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TELEFONE_WHERE);

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
			query.append(TelefoneModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(telefone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Telefone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the telefones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Telefone telefone : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(telefone);
		}
	}

	/**
	 * Returns the number of telefones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching telefones
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

			query.append(_SQL_COUNT_TELEFONE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "telefone.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "telefone.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(telefone.uuid IS NULL OR telefone.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "telefone.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			TelefoneModelImpl.COMPANYID_COLUMN_BITMASK |
			TelefoneModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the telefones where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the telefones where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @return the range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the telefones where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Telefone> list = (List<Telefone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Telefone telefone : list) {
				if ((companyId != telefone.getCompanyId())) {
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

			query.append(_SQL_SELECT_TELEFONE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TelefoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Telefone>(list);
				}
				else {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first telefone in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByCompanyId_First(companyId, orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the first telefone in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Telefone> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last telefone in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByCompanyId_Last(companyId, orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the last telefone in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Telefone> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the telefones before and after the current telefone in the ordered set where companyId = &#63;.
	 *
	 * @param telefoneId the primary key of the current telefone
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone[] findByCompanyId_PrevAndNext(long telefoneId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = findByPrimaryKey(telefoneId);

		Session session = null;

		try {
			session = openSession();

			Telefone[] array = new TelefoneImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, telefone, companyId,
					orderByComparator, true);

			array[1] = telefone;

			array[2] = getByCompanyId_PrevAndNext(session, telefone, companyId,
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

	protected Telefone getByCompanyId_PrevAndNext(Session session,
		Telefone telefone, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TELEFONE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(TelefoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(telefone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Telefone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the telefones where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Telefone telefone : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(telefone);
		}
	}

	/**
	 * Returns the number of telefones where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TELEFONE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "telefone.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			TelefoneModelImpl.COMPANYID_COLUMN_BITMASK |
			TelefoneModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			TelefoneModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the telefones where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C(long companyId, long classNameId)
		throws SystemException {
		return findByC_C(companyId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the telefones where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @return the range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C(long companyId, long classNameId,
		int start, int end) throws SystemException {
		return findByC_C(companyId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C(long companyId, long classNameId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C;
			finderArgs = new Object[] { companyId, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C;
			finderArgs = new Object[] {
					companyId, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<Telefone> list = (List<Telefone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Telefone telefone : list) {
				if ((companyId != telefone.getCompanyId()) ||
						(classNameId != telefone.getClassNameId())) {
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

			query.append(_SQL_SELECT_TELEFONE_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TelefoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Telefone>(list);
				}
				else {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByC_C_First(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByC_C_First(companyId, classNameId,
				orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByC_C_First(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Telefone> list = findByC_C(companyId, classNameId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByC_C_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByC_C_Last(companyId, classNameId,
				orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByC_C_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_C(companyId, classNameId);

		if (count == 0) {
			return null;
		}

		List<Telefone> list = findByC_C(companyId, classNameId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param telefoneId the primary key of the current telefone
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone[] findByC_C_PrevAndNext(long telefoneId, long companyId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = findByPrimaryKey(telefoneId);

		Session session = null;

		try {
			session = openSession();

			Telefone[] array = new TelefoneImpl[3];

			array[0] = getByC_C_PrevAndNext(session, telefone, companyId,
					classNameId, orderByComparator, true);

			array[1] = telefone;

			array[2] = getByC_C_PrevAndNext(session, telefone, companyId,
					classNameId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Telefone getByC_C_PrevAndNext(Session session, Telefone telefone,
		long companyId, long classNameId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TELEFONE_WHERE);

		query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

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
			query.append(TelefoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(telefone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Telefone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the telefones where companyId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C(long companyId, long classNameId)
		throws SystemException {
		for (Telefone telefone : findByC_C(companyId, classNameId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(telefone);
		}
	}

	/**
	 * Returns the number of telefones where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the number of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C(long companyId, long classNameId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C;

		Object[] finderArgs = new Object[] { companyId, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TELEFONE_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_C_C_COMPANYID_2 = "telefone.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 = "telefone.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TelefoneModelImpl.COMPANYID_COLUMN_BITMASK |
			TelefoneModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			TelefoneModelImpl.CLASSPK_COLUMN_BITMASK |
			TelefoneModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C_C(long companyId, long classNameId,
		long classPK) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @return the range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C_C(long companyId, long classNameId,
		long classPK, int start, int end) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C_C(long companyId, long classNameId,
		long classPK, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C;
			finderArgs = new Object[] { companyId, classNameId, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C;
			finderArgs = new Object[] {
					companyId, classNameId, classPK,
					
					start, end, orderByComparator
				};
		}

		List<Telefone> list = (List<Telefone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Telefone telefone : list) {
				if ((companyId != telefone.getCompanyId()) ||
						(classNameId != telefone.getClassNameId()) ||
						(classPK != telefone.getClassPK())) {
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

			query.append(_SQL_SELECT_TELEFONE_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TelefoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				if (!pagination) {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Telefone>(list);
				}
				else {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByC_C_C_First(companyId, classNameId, classPK,
				orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<Telefone> list = findByC_C_C(companyId, classNameId, classPK, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByC_C_C_Last(companyId, classNameId, classPK,
				orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C(companyId, classNameId, classPK);

		if (count == 0) {
			return null;
		}

		List<Telefone> list = findByC_C_C(companyId, classNameId, classPK,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param telefoneId the primary key of the current telefone
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone[] findByC_C_C_PrevAndNext(long telefoneId, long companyId,
		long classNameId, long classPK, OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = findByPrimaryKey(telefoneId);

		Session session = null;

		try {
			session = openSession();

			Telefone[] array = new TelefoneImpl[3];

			array[0] = getByC_C_C_PrevAndNext(session, telefone, companyId,
					classNameId, classPK, orderByComparator, true);

			array[1] = telefone;

			array[2] = getByC_C_C_PrevAndNext(session, telefone, companyId,
					classNameId, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Telefone getByC_C_C_PrevAndNext(Session session,
		Telefone telefone, long companyId, long classNameId, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TELEFONE_WHERE);

		query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

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
			query.append(TelefoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(telefone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Telefone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws SystemException {
		for (Telefone telefone : findByC_C_C(companyId, classNameId, classPK,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(telefone);
		}
	}

	/**
	 * Returns the number of telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_C;

		Object[] finderArgs = new Object[] { companyId, classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TELEFONE_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

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

	private static final String _FINDER_COLUMN_C_C_C_COMPANYID_2 = "telefone.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSNAMEID_2 = "telefone.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSPK_2 = "telefone.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_P = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P =
		new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, TelefoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			TelefoneModelImpl.COMPANYID_COLUMN_BITMASK |
			TelefoneModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			TelefoneModelImpl.CLASSPK_COLUMN_BITMASK |
			TelefoneModelImpl.PRINCIPAL_COLUMN_BITMASK |
			TelefoneModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C_P = new FinderPath(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @return the matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal) throws SystemException {
		return findByC_C_C_P(companyId, classNameId, classPK, principal,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @return the range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal, int start, int end)
		throws SystemException {
		return findByC_C_C_P(companyId, classNameId, classPK, principal, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P;
			finderArgs = new Object[] { companyId, classNameId, classPK, principal };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_P;
			finderArgs = new Object[] {
					companyId, classNameId, classPK, principal,
					
					start, end, orderByComparator
				};
		}

		List<Telefone> list = (List<Telefone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Telefone telefone : list) {
				if ((companyId != telefone.getCompanyId()) ||
						(classNameId != telefone.getClassNameId()) ||
						(classPK != telefone.getClassPK()) ||
						(principal != telefone.getPrincipal())) {
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

			query.append(_SQL_SELECT_TELEFONE_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_P_CLASSPK_2);

			query.append(_FINDER_COLUMN_C_C_C_P_PRINCIPAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TelefoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(principal);

				if (!pagination) {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Telefone>(list);
				}
				else {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByC_C_C_P_First(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByC_C_C_P_First(companyId, classNameId,
				classPK, principal, orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", principal=");
		msg.append(principal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the first telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByC_C_C_P_First(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws SystemException {
		List<Telefone> list = findByC_C_C_P(companyId, classNameId, classPK,
				principal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByC_C_C_P_Last(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByC_C_C_P_Last(companyId, classNameId,
				classPK, principal, orderByComparator);

		if (telefone != null) {
			return telefone;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", principal=");
		msg.append(principal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTelefoneException(msg.toString());
	}

	/**
	 * Returns the last telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching telefone, or <code>null</code> if a matching telefone could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByC_C_C_P_Last(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C_P(companyId, classNameId, classPK, principal);

		if (count == 0) {
			return null;
		}

		List<Telefone> list = findByC_C_C_P(companyId, classNameId, classPK,
				principal, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the telefones before and after the current telefone in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param telefoneId the primary key of the current telefone
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone[] findByC_C_C_P_PrevAndNext(long telefoneId,
		long companyId, long classNameId, long classPK, boolean principal,
		OrderByComparator orderByComparator)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = findByPrimaryKey(telefoneId);

		Session session = null;

		try {
			session = openSession();

			Telefone[] array = new TelefoneImpl[3];

			array[0] = getByC_C_C_P_PrevAndNext(session, telefone, companyId,
					classNameId, classPK, principal, orderByComparator, true);

			array[1] = telefone;

			array[2] = getByC_C_C_P_PrevAndNext(session, telefone, companyId,
					classNameId, classPK, principal, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Telefone getByC_C_C_P_PrevAndNext(Session session,
		Telefone telefone, long companyId, long classNameId, long classPK,
		boolean principal, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TELEFONE_WHERE);

		query.append(_FINDER_COLUMN_C_C_C_P_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_C_P_CLASSPK_2);

		query.append(_FINDER_COLUMN_C_C_C_P_PRINCIPAL_2);

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
			query.append(TelefoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		qPos.add(classPK);

		qPos.add(principal);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(telefone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Telefone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean principal) throws SystemException {
		for (Telefone telefone : findByC_C_C_P(companyId, classNameId, classPK,
				principal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(telefone);
		}
	}

	/**
	 * Returns the number of telefones where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @return the number of matching telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean principal) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_C_P;

		Object[] finderArgs = new Object[] {
				companyId, classNameId, classPK, principal
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TELEFONE_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_P_CLASSPK_2);

			query.append(_FINDER_COLUMN_C_C_C_P_PRINCIPAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(principal);

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

	private static final String _FINDER_COLUMN_C_C_C_P_COMPANYID_2 = "telefone.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2 = "telefone.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_CLASSPK_2 = "telefone.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_PRINCIPAL_2 = "telefone.principal = ?";

	public TelefonePersistenceImpl() {
		setModelClass(Telefone.class);
	}

	/**
	 * Caches the telefone in the entity cache if it is enabled.
	 *
	 * @param telefone the telefone
	 */
	@Override
	public void cacheResult(Telefone telefone) {
		EntityCacheUtil.putResult(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneImpl.class, telefone.getPrimaryKey(), telefone);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { telefone.getUuid(), telefone.getGroupId() }, telefone);

		telefone.resetOriginalValues();
	}

	/**
	 * Caches the telefones in the entity cache if it is enabled.
	 *
	 * @param telefones the telefones
	 */
	@Override
	public void cacheResult(List<Telefone> telefones) {
		for (Telefone telefone : telefones) {
			if (EntityCacheUtil.getResult(
						TelefoneModelImpl.ENTITY_CACHE_ENABLED,
						TelefoneImpl.class, telefone.getPrimaryKey()) == null) {
				cacheResult(telefone);
			}
			else {
				telefone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all telefones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TelefoneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TelefoneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the telefone.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Telefone telefone) {
		EntityCacheUtil.removeResult(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneImpl.class, telefone.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(telefone);
	}

	@Override
	public void clearCache(List<Telefone> telefones) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Telefone telefone : telefones) {
			EntityCacheUtil.removeResult(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
				TelefoneImpl.class, telefone.getPrimaryKey());

			clearUniqueFindersCache(telefone);
		}
	}

	protected void cacheUniqueFindersCache(Telefone telefone) {
		if (telefone.isNew()) {
			Object[] args = new Object[] {
					telefone.getUuid(), telefone.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				telefone);
		}
		else {
			TelefoneModelImpl telefoneModelImpl = (TelefoneModelImpl)telefone;

			if ((telefoneModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						telefone.getUuid(), telefone.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					telefone);
			}
		}
	}

	protected void clearUniqueFindersCache(Telefone telefone) {
		TelefoneModelImpl telefoneModelImpl = (TelefoneModelImpl)telefone;

		Object[] args = new Object[] { telefone.getUuid(), telefone.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((telefoneModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					telefoneModelImpl.getOriginalUuid(),
					telefoneModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new telefone with the primary key. Does not add the telefone to the database.
	 *
	 * @param telefoneId the primary key for the new telefone
	 * @return the new telefone
	 */
	@Override
	public Telefone create(long telefoneId) {
		Telefone telefone = new TelefoneImpl();

		telefone.setNew(true);
		telefone.setPrimaryKey(telefoneId);

		String uuid = PortalUUIDUtil.generate();

		telefone.setUuid(uuid);

		return telefone;
	}

	/**
	 * Removes the telefone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param telefoneId the primary key of the telefone
	 * @return the telefone that was removed
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone remove(long telefoneId)
		throws NoSuchTelefoneException, SystemException {
		return remove((Serializable)telefoneId);
	}

	/**
	 * Removes the telefone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the telefone
	 * @return the telefone that was removed
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone remove(Serializable primaryKey)
		throws NoSuchTelefoneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Telefone telefone = (Telefone)session.get(TelefoneImpl.class,
					primaryKey);

			if (telefone == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTelefoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(telefone);
		}
		catch (NoSuchTelefoneException nsee) {
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
	protected Telefone removeImpl(Telefone telefone) throws SystemException {
		telefone = toUnwrappedModel(telefone);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(telefone)) {
				telefone = (Telefone)session.get(TelefoneImpl.class,
						telefone.getPrimaryKeyObj());
			}

			if (telefone != null) {
				session.delete(telefone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (telefone != null) {
			clearCache(telefone);
		}

		return telefone;
	}

	@Override
	public Telefone updateImpl(
		br.com.prodevelopment.contato.model.Telefone telefone)
		throws SystemException {
		telefone = toUnwrappedModel(telefone);

		boolean isNew = telefone.isNew();

		TelefoneModelImpl telefoneModelImpl = (TelefoneModelImpl)telefone;

		if (Validator.isNull(telefone.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			telefone.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (telefone.isNew()) {
				session.save(telefone);

				telefone.setNew(false);
			}
			else {
				session.merge(telefone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TelefoneModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((telefoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { telefoneModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { telefoneModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((telefoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						telefoneModelImpl.getOriginalUuid(),
						telefoneModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						telefoneModelImpl.getUuid(),
						telefoneModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((telefoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						telefoneModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { telefoneModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((telefoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						telefoneModelImpl.getOriginalCompanyId(),
						telefoneModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);

				args = new Object[] {
						telefoneModelImpl.getCompanyId(),
						telefoneModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);
			}

			if ((telefoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						telefoneModelImpl.getOriginalCompanyId(),
						telefoneModelImpl.getOriginalClassNameId(),
						telefoneModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);

				args = new Object[] {
						telefoneModelImpl.getCompanyId(),
						telefoneModelImpl.getClassNameId(),
						telefoneModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);
			}

			if ((telefoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						telefoneModelImpl.getOriginalCompanyId(),
						telefoneModelImpl.getOriginalClassNameId(),
						telefoneModelImpl.getOriginalClassPK(),
						telefoneModelImpl.getOriginalPrincipal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P,
					args);

				args = new Object[] {
						telefoneModelImpl.getCompanyId(),
						telefoneModelImpl.getClassNameId(),
						telefoneModelImpl.getClassPK(),
						telefoneModelImpl.getPrincipal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P,
					args);
			}
		}

		EntityCacheUtil.putResult(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
			TelefoneImpl.class, telefone.getPrimaryKey(), telefone);

		clearUniqueFindersCache(telefone);
		cacheUniqueFindersCache(telefone);

		return telefone;
	}

	protected Telefone toUnwrappedModel(Telefone telefone) {
		if (telefone instanceof TelefoneImpl) {
			return telefone;
		}

		TelefoneImpl telefoneImpl = new TelefoneImpl();

		telefoneImpl.setNew(telefone.isNew());
		telefoneImpl.setPrimaryKey(telefone.getPrimaryKey());

		telefoneImpl.setUuid(telefone.getUuid());
		telefoneImpl.setTelefoneId(telefone.getTelefoneId());
		telefoneImpl.setCompanyId(telefone.getCompanyId());
		telefoneImpl.setGroupId(telefone.getGroupId());
		telefoneImpl.setCreateUserId(telefone.getCreateUserId());
		telefoneImpl.setModifiedUserId(telefone.getModifiedUserId());
		telefoneImpl.setCreateDate(telefone.getCreateDate());
		telefoneImpl.setModifiedDate(telefone.getModifiedDate());
		telefoneImpl.setClassNameId(telefone.getClassNameId());
		telefoneImpl.setClassPK(telefone.getClassPK());
		telefoneImpl.setDdi(telefone.getDdi());
		telefoneImpl.setDdd(telefone.getDdd());
		telefoneImpl.setNumero(telefone.getNumero());
		telefoneImpl.setRamal(telefone.getRamal());
		telefoneImpl.setTipo(telefone.getTipo());
		telefoneImpl.setPrincipal(telefone.isPrincipal());

		return telefoneImpl;
	}

	/**
	 * Returns the telefone with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the telefone
	 * @return the telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTelefoneException, SystemException {
		Telefone telefone = fetchByPrimaryKey(primaryKey);

		if (telefone == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTelefoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return telefone;
	}

	/**
	 * Returns the telefone with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchTelefoneException} if it could not be found.
	 *
	 * @param telefoneId the primary key of the telefone
	 * @return the telefone
	 * @throws br.com.prodevelopment.contato.NoSuchTelefoneException if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone findByPrimaryKey(long telefoneId)
		throws NoSuchTelefoneException, SystemException {
		return findByPrimaryKey((Serializable)telefoneId);
	}

	/**
	 * Returns the telefone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the telefone
	 * @return the telefone, or <code>null</code> if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Telefone telefone = (Telefone)EntityCacheUtil.getResult(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
				TelefoneImpl.class, primaryKey);

		if (telefone == _nullTelefone) {
			return null;
		}

		if (telefone == null) {
			Session session = null;

			try {
				session = openSession();

				telefone = (Telefone)session.get(TelefoneImpl.class, primaryKey);

				if (telefone != null) {
					cacheResult(telefone);
				}
				else {
					EntityCacheUtil.putResult(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
						TelefoneImpl.class, primaryKey, _nullTelefone);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TelefoneModelImpl.ENTITY_CACHE_ENABLED,
					TelefoneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return telefone;
	}

	/**
	 * Returns the telefone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param telefoneId the primary key of the telefone
	 * @return the telefone, or <code>null</code> if a telefone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Telefone fetchByPrimaryKey(long telefoneId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)telefoneId);
	}

	/**
	 * Returns all the telefones.
	 *
	 * @return the telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the telefones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @return the range of telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the telefones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.TelefoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of telefones
	 * @param end the upper bound of the range of telefones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of telefones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Telefone> findAll(int start, int end,
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

		List<Telefone> list = (List<Telefone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TELEFONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TELEFONE;

				if (pagination) {
					sql = sql.concat(TelefoneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Telefone>(list);
				}
				else {
					list = (List<Telefone>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the telefones from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Telefone telefone : findAll()) {
			remove(telefone);
		}
	}

	/**
	 * Returns the number of telefones.
	 *
	 * @return the number of telefones
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

				Query q = session.createQuery(_SQL_COUNT_TELEFONE);

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
	 * Initializes the telefone persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.contato.model.Telefone")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Telefone>> listenersList = new ArrayList<ModelListener<Telefone>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Telefone>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TelefoneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TELEFONE = "SELECT telefone FROM Telefone telefone";
	private static final String _SQL_SELECT_TELEFONE_WHERE = "SELECT telefone FROM Telefone telefone WHERE ";
	private static final String _SQL_COUNT_TELEFONE = "SELECT COUNT(telefone) FROM Telefone telefone";
	private static final String _SQL_COUNT_TELEFONE_WHERE = "SELECT COUNT(telefone) FROM Telefone telefone WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "telefone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Telefone exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Telefone exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TelefonePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Telefone _nullTelefone = new TelefoneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Telefone> toCacheModel() {
				return _nullTelefoneCacheModel;
			}
		};

	private static CacheModel<Telefone> _nullTelefoneCacheModel = new CacheModel<Telefone>() {
			@Override
			public Telefone toEntityModel() {
				return _nullTelefone;
			}
		};
}