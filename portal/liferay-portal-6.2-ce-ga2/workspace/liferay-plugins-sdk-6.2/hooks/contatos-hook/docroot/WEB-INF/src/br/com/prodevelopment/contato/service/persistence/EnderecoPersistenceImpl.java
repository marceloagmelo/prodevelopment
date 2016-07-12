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

import br.com.prodevelopment.contato.NoSuchEnderecoException;
import br.com.prodevelopment.contato.model.Endereco;
import br.com.prodevelopment.contato.model.impl.EnderecoImpl;
import br.com.prodevelopment.contato.model.impl.EnderecoModelImpl;

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
 * The persistence implementation for the endereco service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcelo
 * @see EnderecoPersistence
 * @see EnderecoUtil
 * @generated
 */
public class EnderecoPersistenceImpl extends BasePersistenceImpl<Endereco>
	implements EnderecoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnderecoUtil} to access the endereco persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnderecoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EnderecoModelImpl.UUID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the enderecos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUuid(String uuid, int start, int end,
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

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if (!Validator.equals(uuid, endereco.getUuid())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

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
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByUuid_First(uuid, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByUuid_Last(uuid, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where uuid = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByUuid_PrevAndNext(long enderecoId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, endereco, uuid,
					orderByComparator, true);

			array[1] = endereco;

			array[2] = getByUuid_PrevAndNext(session, endereco, uuid,
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

	protected Endereco getByUuid_PrevAndNext(Session session,
		Endereco endereco, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Endereco endereco : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching enderecos
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

			query.append(_SQL_COUNT_ENDERECO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "endereco.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "endereco.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(endereco.uuid IS NULL OR endereco.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EnderecoModelImpl.UUID_COLUMN_BITMASK |
			EnderecoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the endereco where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByUUID_G(String uuid, long groupId)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByUUID_G(uuid, groupId);

		if (endereco == null) {
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

			throw new NoSuchEnderecoException(msg.toString());
		}

		return endereco;
	}

	/**
	 * Returns the endereco where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the endereco where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Endereco) {
			Endereco endereco = (Endereco)result;

			if (!Validator.equals(uuid, endereco.getUuid()) ||
					(groupId != endereco.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ENDERECO_WHERE);

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

				List<Endereco> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Endereco endereco = list.get(0);

					result = endereco;

					cacheResult(endereco);

					if ((endereco.getUuid() == null) ||
							!endereco.getUuid().equals(uuid) ||
							(endereco.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, endereco);
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
			return (Endereco)result;
		}
	}

	/**
	 * Removes the endereco where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the endereco that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco removeByUUID_G(String uuid, long groupId)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByUUID_G(uuid, groupId);

		return remove(endereco);
	}

	/**
	 * Returns the number of enderecos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching enderecos
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

			query.append(_SQL_COUNT_ENDERECO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "endereco.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "endereco.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(endereco.uuid IS NULL OR endereco.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "endereco.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EnderecoModelImpl.UUID_COLUMN_BITMASK |
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the enderecos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUuid_C(String uuid, long companyId, int start,
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

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if (!Validator.equals(uuid, endereco.getUuid()) ||
						(companyId != endereco.getCompanyId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

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
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByUuid_C_PrevAndNext(long enderecoId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, endereco, uuid,
					companyId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByUuid_C_PrevAndNext(session, endereco, uuid,
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

	protected Endereco getByUuid_C_PrevAndNext(Session session,
		Endereco endereco, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Endereco endereco : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching enderecos
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

			query.append(_SQL_COUNT_ENDERECO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "endereco.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "endereco.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(endereco.uuid IS NULL OR endereco.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "endereco.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the enderecos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCompanyId(long companyId, int start, int end,
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

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByCompanyId_First(companyId, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByCompanyId_Last(companyId, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByCompanyId_PrevAndNext(long enderecoId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, endereco, companyId,
					orderByComparator, true);

			array[1] = endereco;

			array[2] = getByCompanyId_PrevAndNext(session, endereco, companyId,
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

	protected Endereco getByCompanyId_PrevAndNext(Session session,
		Endereco endereco, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Endereco endereco : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching enderecos
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

			query.append(_SQL_COUNT_ENDERECO_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "endereco.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_U = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_U = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the enderecos where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_U(long companyId, long classNameId)
		throws SystemException {
		return findByC_U(companyId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_U(long companyId, long classNameId,
		int start, int end) throws SystemException {
		return findByC_U(companyId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_U(long companyId, long classNameId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U;
			finderArgs = new Object[] { companyId, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_U;
			finderArgs = new Object[] {
					companyId, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(classNameId != endereco.getClassNameId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_U_First(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_U_First(companyId, classNameId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_U_First(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByC_U(companyId, classNameId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_U_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_U_Last(companyId, classNameId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_U_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_U(companyId, classNameId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_U(companyId, classNameId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_U_PrevAndNext(long enderecoId, long companyId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_U_PrevAndNext(session, endereco, companyId,
					classNameId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_U_PrevAndNext(session, endereco, companyId,
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

	protected Endereco getByC_U_PrevAndNext(Session session, Endereco endereco,
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

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_U_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_U_CLASSNAMEID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_U(long companyId, long classNameId)
		throws SystemException {
		for (Endereco endereco : findByC_U(companyId, classNameId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_U(long companyId, long classNameId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_U;

		Object[] finderArgs = new Object[] { companyId, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_CLASSNAMEID_2);

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

	private static final String _FINDER_COLUMN_C_U_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_U_CLASSNAMEID_2 = "endereco.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_U = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.GROUPID_COLUMN_BITMASK |
			EnderecoModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_U = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_U(long companyId, long groupId,
		long classNameId) throws SystemException {
		return findByC_G_U(companyId, groupId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_U(long companyId, long groupId,
		long classNameId, int start, int end) throws SystemException {
		return findByC_G_U(companyId, groupId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_U(long companyId, long groupId,
		long classNameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U;
			finderArgs = new Object[] { companyId, groupId, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_U;
			finderArgs = new Object[] {
					companyId, groupId, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(groupId != endereco.getGroupId()) ||
						(classNameId != endereco.getClassNameId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_U_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_U_First(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_U_First(companyId, groupId, classNameId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
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

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_U_First(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_G_U(companyId, groupId, classNameId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_U_Last(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_U_Last(companyId, groupId, classNameId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
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

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_U_Last(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_U(companyId, groupId, classNameId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_G_U(companyId, groupId, classNameId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_G_U_PrevAndNext(long enderecoId, long companyId,
		long groupId, long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_G_U_PrevAndNext(session, endereco, companyId,
					groupId, classNameId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_G_U_PrevAndNext(session, endereco, companyId,
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

	protected Endereco getByC_G_U_PrevAndNext(Session session,
		Endereco endereco, long companyId, long groupId, long classNameId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_U_CLASSNAMEID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_U(long companyId, long groupId, long classNameId)
		throws SystemException {
		for (Endereco endereco : findByC_G_U(companyId, groupId, classNameId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_U(long companyId, long groupId, long classNameId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_U;

		Object[] finderArgs = new Object[] { companyId, groupId, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_U_CLASSNAMEID_2);

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

	private static final String _FINDER_COLUMN_C_G_U_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_U_GROUPID_2 = "endereco.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_U_CLASSNAMEID_2 = "endereco.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the enderecos where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C(long companyId, long classNameId)
		throws SystemException {
		return findByC_C(companyId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C(long companyId, long classNameId,
		int start, int end) throws SystemException {
		return findByC_C(companyId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C(long companyId, long classNameId,
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

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(classNameId != endereco.getClassNameId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_C_First(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_C_First(companyId, classNameId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_C_First(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByC_C(companyId, classNameId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_C_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_C_Last(companyId, classNameId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_C_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_C(companyId, classNameId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_C(companyId, classNameId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_C_PrevAndNext(long enderecoId, long companyId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_C_PrevAndNext(session, endereco, companyId,
					classNameId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_C_PrevAndNext(session, endereco, companyId,
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

	protected Endereco getByC_C_PrevAndNext(Session session, Endereco endereco,
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

		query.append(_SQL_SELECT_ENDERECO_WHERE);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C(long companyId, long classNameId)
		throws SystemException {
		for (Endereco endereco : findByC_C(companyId, classNameId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the number of matching enderecos
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

			query.append(_SQL_COUNT_ENDERECO_WHERE);

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

	private static final String _FINDER_COLUMN_C_C_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 = "endereco.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_G = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_G",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_G = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_G",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.GROUPID_COLUMN_BITMASK |
			EnderecoModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_G = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_G",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_G(long companyId, long groupId,
		long classNameId) throws SystemException {
		return findByC_C_G(companyId, groupId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_G(long companyId, long groupId,
		long classNameId, int start, int end) throws SystemException {
		return findByC_C_G(companyId, groupId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_G(long companyId, long groupId,
		long classNameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_G;
			finderArgs = new Object[] { companyId, groupId, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_G;
			finderArgs = new Object[] {
					companyId, groupId, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(groupId != endereco.getGroupId()) ||
						(classNameId != endereco.getClassNameId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_G_GROUPID_2);

			query.append(_FINDER_COLUMN_C_C_G_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_C_G_First(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_C_G_First(companyId, groupId, classNameId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
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

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_C_G_First(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_C_G(companyId, groupId, classNameId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_C_G_Last(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_C_G_Last(companyId, groupId, classNameId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
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

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_C_G_Last(long companyId, long groupId,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_G(companyId, groupId, classNameId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_C_G(companyId, groupId, classNameId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_C_G_PrevAndNext(long enderecoId, long companyId,
		long groupId, long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_C_G_PrevAndNext(session, endereco, companyId,
					groupId, classNameId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_C_G_PrevAndNext(session, endereco, companyId,
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

	protected Endereco getByC_C_G_PrevAndNext(Session session,
		Endereco endereco, long companyId, long groupId, long classNameId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_G_GROUPID_2);

		query.append(_FINDER_COLUMN_C_C_G_CLASSNAMEID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_G(long companyId, long groupId, long classNameId)
		throws SystemException {
		for (Endereco endereco : findByC_C_G(companyId, groupId, classNameId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and groupId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_G(long companyId, long groupId, long classNameId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_G;

		Object[] finderArgs = new Object[] { companyId, groupId, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_G_GROUPID_2);

			query.append(_FINDER_COLUMN_C_C_G_CLASSNAMEID_2);

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

	private static final String _FINDER_COLUMN_C_C_G_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_G_GROUPID_2 = "endereco.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_G_CLASSNAMEID_2 = "endereco.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoModelImpl.CLASSPK_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_C(long companyId, long classNameId,
		long classPK) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_C(long companyId, long classNameId,
		long classPK, int start, int end) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_C(long companyId, long classNameId,
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

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(classNameId != endereco.getClassNameId()) ||
						(classPK != endereco.getClassPK())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_C_C_First(companyId, classNameId, classPK,
				orderByComparator);

		if (endereco != null) {
			return endereco;
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

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_C_C(companyId, classNameId, classPK, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_C_C_Last(companyId, classNameId, classPK,
				orderByComparator);

		if (endereco != null) {
			return endereco;
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

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C(companyId, classNameId, classPK);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_C_C(companyId, classNameId, classPK,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_C_C_PrevAndNext(long enderecoId, long companyId,
		long classNameId, long classPK, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_C_C_PrevAndNext(session, endereco, companyId,
					classNameId, classPK, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_C_C_PrevAndNext(session, endereco, companyId,
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

	protected Endereco getByC_C_C_PrevAndNext(Session session,
		Endereco endereco, long companyId, long classNameId, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws SystemException {
		for (Endereco endereco : findByC_C_C(companyId, classNameId, classPK,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching enderecos
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

			query.append(_SQL_COUNT_ENDERECO_WHERE);

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

	private static final String _FINDER_COLUMN_C_C_C_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSNAMEID_2 = "endereco.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSPK_2 = "endereco.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_P = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoModelImpl.CLASSPK_COLUMN_BITMASK |
			EnderecoModelImpl.PRINCIPAL_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C_P = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal) throws SystemException {
		return findByC_C_C_P(companyId, classNameId, classPK, principal,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal, int start, int end)
		throws SystemException {
		return findByC_C_C_P(companyId, classNameId, classPK, principal, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_C_C_P(long companyId, long classNameId,
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

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(classNameId != endereco.getClassNameId()) ||
						(classPK != endereco.getClassPK()) ||
						(principal != endereco.getPrincipal())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

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
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_C_C_P_First(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_C_C_P_First(companyId, classNameId,
				classPK, principal, orderByComparator);

		if (endereco != null) {
			return endereco;
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

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_C_C_P_First(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_C_C_P(companyId, classNameId, classPK,
				principal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_C_C_P_Last(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_C_C_P_Last(companyId, classNameId,
				classPK, principal, orderByComparator);

		if (endereco != null) {
			return endereco;
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

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_C_C_P_Last(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C_P(companyId, classNameId, classPK, principal);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_C_C_P(companyId, classNameId, classPK,
				principal, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_C_C_P_PrevAndNext(long enderecoId,
		long companyId, long classNameId, long classPK, boolean principal,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_C_C_P_PrevAndNext(session, endereco, companyId,
					classNameId, classPK, principal, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_C_C_P_PrevAndNext(session, endereco, companyId,
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

	protected Endereco getByC_C_C_P_PrevAndNext(Session session,
		Endereco endereco, long companyId, long classNameId, long classPK,
		boolean principal, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
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
		for (Endereco endereco : findByC_C_C_P(companyId, classNameId, classPK,
				principal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @return the number of matching enderecos
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

			query.append(_SQL_COUNT_ENDERECO_WHERE);

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

	private static final String _FINDER_COLUMN_C_C_C_P_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2 = "endereco.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_CLASSPK_2 = "endereco.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_PRINCIPAL_2 = "endereco.principal = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_CEP = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_CEP",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CEP = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_CEP",
			new String[] { Long.class.getName(), String.class.getName() },
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.CEP_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_CEP = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_CEP",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the enderecos where companyId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_CEP(long companyId, String cep)
		throws SystemException {
		return findByC_CEP(companyId, cep, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and cep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_CEP(long companyId, String cep, int start,
		int end) throws SystemException {
		return findByC_CEP(companyId, cep, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and cep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_CEP(long companyId, String cep, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CEP;
			finderArgs = new Object[] { companyId, cep };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_CEP;
			finderArgs = new Object[] {
					companyId, cep,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						!Validator.equals(cep, endereco.getCep())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_CEP_COMPANYID_2);

			boolean bindCep = false;

			if (cep == null) {
				query.append(_FINDER_COLUMN_C_CEP_CEP_1);
			}
			else if (cep.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_CEP_CEP_3);
			}
			else {
				bindCep = true;

				query.append(_FINDER_COLUMN_C_CEP_CEP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindCep) {
					qPos.add(cep);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_CEP_First(long companyId, String cep,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_CEP_First(companyId, cep, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", cep=");
		msg.append(cep);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_CEP_First(long companyId, String cep,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByC_CEP(companyId, cep, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_CEP_Last(long companyId, String cep,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_CEP_Last(companyId, cep, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", cep=");
		msg.append(cep);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_CEP_Last(long companyId, String cep,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_CEP(companyId, cep);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_CEP(companyId, cep, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and cep = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_CEP_PrevAndNext(long enderecoId, long companyId,
		String cep, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_CEP_PrevAndNext(session, endereco, companyId,
					cep, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_CEP_PrevAndNext(session, endereco, companyId,
					cep, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_CEP_PrevAndNext(Session session,
		Endereco endereco, long companyId, String cep,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_CEP_COMPANYID_2);

		boolean bindCep = false;

		if (cep == null) {
			query.append(_FINDER_COLUMN_C_CEP_CEP_1);
		}
		else if (cep.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_CEP_CEP_3);
		}
		else {
			bindCep = true;

			query.append(_FINDER_COLUMN_C_CEP_CEP_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindCep) {
			qPos.add(cep);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and cep = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_CEP(long companyId, String cep)
		throws SystemException {
		for (Endereco endereco : findByC_CEP(companyId, cep, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cep the cep
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_CEP(long companyId, String cep)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_CEP;

		Object[] finderArgs = new Object[] { companyId, cep };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_CEP_COMPANYID_2);

			boolean bindCep = false;

			if (cep == null) {
				query.append(_FINDER_COLUMN_C_CEP_CEP_1);
			}
			else if (cep.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_CEP_CEP_3);
			}
			else {
				bindCep = true;

				query.append(_FINDER_COLUMN_C_CEP_CEP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindCep) {
					qPos.add(cep);
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

	private static final String _FINDER_COLUMN_C_CEP_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_CEP_CEP_1 = "endereco.cep IS NULL";
	private static final String _FINDER_COLUMN_C_CEP_CEP_2 = "endereco.cep = ?";
	private static final String _FINDER_COLUMN_C_CEP_CEP_3 = "(endereco.cep IS NULL OR endereco.cep = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_CEP = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_CEP",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CEP =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_CEP",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.GROUPID_COLUMN_BITMASK |
			EnderecoModelImpl.CEP_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_CEP = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_CEP",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_CEP(long companyId, long groupId, String cep)
		throws SystemException {
		return findByC_G_CEP(companyId, groupId, cep, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_CEP(long companyId, long groupId,
		String cep, int start, int end) throws SystemException {
		return findByC_G_CEP(companyId, groupId, cep, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_CEP(long companyId, long groupId,
		String cep, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CEP;
			finderArgs = new Object[] { companyId, groupId, cep };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_CEP;
			finderArgs = new Object[] {
					companyId, groupId, cep,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(groupId != endereco.getGroupId()) ||
						!Validator.equals(cep, endereco.getCep())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_CEP_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_CEP_GROUPID_2);

			boolean bindCep = false;

			if (cep == null) {
				query.append(_FINDER_COLUMN_C_G_CEP_CEP_1);
			}
			else if (cep.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_CEP_CEP_3);
			}
			else {
				bindCep = true;

				query.append(_FINDER_COLUMN_C_G_CEP_CEP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindCep) {
					qPos.add(cep);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_CEP_First(long companyId, long groupId,
		String cep, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_CEP_First(companyId, groupId, cep,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", cep=");
		msg.append(cep);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_CEP_First(long companyId, long groupId,
		String cep, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_G_CEP(companyId, groupId, cep, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_CEP_Last(long companyId, long groupId,
		String cep, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_CEP_Last(companyId, groupId, cep,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", cep=");
		msg.append(cep);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_CEP_Last(long companyId, long groupId,
		String cep, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_CEP(companyId, groupId, cep);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_G_CEP(companyId, groupId, cep, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_G_CEP_PrevAndNext(long enderecoId,
		long companyId, long groupId, String cep,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_G_CEP_PrevAndNext(session, endereco, companyId,
					groupId, cep, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_G_CEP_PrevAndNext(session, endereco, companyId,
					groupId, cep, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_G_CEP_PrevAndNext(Session session,
		Endereco endereco, long companyId, long groupId, String cep,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_G_CEP_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_CEP_GROUPID_2);

		boolean bindCep = false;

		if (cep == null) {
			query.append(_FINDER_COLUMN_C_G_CEP_CEP_1);
		}
		else if (cep.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_CEP_CEP_3);
		}
		else {
			bindCep = true;

			query.append(_FINDER_COLUMN_C_G_CEP_CEP_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindCep) {
			qPos.add(cep);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and groupId = &#63; and cep = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_CEP(long companyId, long groupId, String cep)
		throws SystemException {
		for (Endereco endereco : findByC_G_CEP(companyId, groupId, cep,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and groupId = &#63; and cep = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cep the cep
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_CEP(long companyId, long groupId, String cep)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_CEP;

		Object[] finderArgs = new Object[] { companyId, groupId, cep };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_CEP_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_CEP_GROUPID_2);

			boolean bindCep = false;

			if (cep == null) {
				query.append(_FINDER_COLUMN_C_G_CEP_CEP_1);
			}
			else if (cep.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_CEP_CEP_3);
			}
			else {
				bindCep = true;

				query.append(_FINDER_COLUMN_C_G_CEP_CEP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindCep) {
					qPos.add(cep);
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

	private static final String _FINDER_COLUMN_C_G_CEP_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_CEP_GROUPID_2 = "endereco.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_CEP_CEP_1 = "endereco.cep IS NULL";
	private static final String _FINDER_COLUMN_C_G_CEP_CEP_2 = "endereco.cep = ?";
	private static final String _FINDER_COLUMN_C_G_CEP_CEP_3 = "(endereco.cep IS NULL OR endereco.cep = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CEP = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCEP",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CEP = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCEP",
			new String[] { String.class.getName() },
			EnderecoModelImpl.CEP_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CEP = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCEP",
			new String[] { String.class.getName() });

	/**
	 * Returns all the enderecos where cep = &#63;.
	 *
	 * @param cep the cep
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCEP(String cep) throws SystemException {
		return findByCEP(cep, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where cep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cep the cep
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCEP(String cep, int start, int end)
		throws SystemException {
		return findByCEP(cep, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where cep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cep the cep
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCEP(String cep, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CEP;
			finderArgs = new Object[] { cep };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CEP;
			finderArgs = new Object[] { cep, start, end, orderByComparator };
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if (!Validator.equals(cep, endereco.getCep())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			boolean bindCep = false;

			if (cep == null) {
				query.append(_FINDER_COLUMN_CEP_CEP_1);
			}
			else if (cep.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CEP_CEP_3);
			}
			else {
				bindCep = true;

				query.append(_FINDER_COLUMN_CEP_CEP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCep) {
					qPos.add(cep);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where cep = &#63;.
	 *
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByCEP_First(String cep,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByCEP_First(cep, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cep=");
		msg.append(cep);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where cep = &#63;.
	 *
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByCEP_First(String cep,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByCEP(cep, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where cep = &#63;.
	 *
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByCEP_Last(String cep,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByCEP_Last(cep, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cep=");
		msg.append(cep);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where cep = &#63;.
	 *
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByCEP_Last(String cep,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCEP(cep);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByCEP(cep, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where cep = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param cep the cep
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByCEP_PrevAndNext(long enderecoId, String cep,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByCEP_PrevAndNext(session, endereco, cep,
					orderByComparator, true);

			array[1] = endereco;

			array[2] = getByCEP_PrevAndNext(session, endereco, cep,
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

	protected Endereco getByCEP_PrevAndNext(Session session, Endereco endereco,
		String cep, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		boolean bindCep = false;

		if (cep == null) {
			query.append(_FINDER_COLUMN_CEP_CEP_1);
		}
		else if (cep.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CEP_CEP_3);
		}
		else {
			bindCep = true;

			query.append(_FINDER_COLUMN_CEP_CEP_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCep) {
			qPos.add(cep);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where cep = &#63; from the database.
	 *
	 * @param cep the cep
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCEP(String cep) throws SystemException {
		for (Endereco endereco : findByCEP(cep, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where cep = &#63;.
	 *
	 * @param cep the cep
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCEP(String cep) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CEP;

		Object[] finderArgs = new Object[] { cep };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			boolean bindCep = false;

			if (cep == null) {
				query.append(_FINDER_COLUMN_CEP_CEP_1);
			}
			else if (cep.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CEP_CEP_3);
			}
			else {
				bindCep = true;

				query.append(_FINDER_COLUMN_CEP_CEP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCep) {
					qPos.add(cep);
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

	private static final String _FINDER_COLUMN_CEP_CEP_1 = "endereco.cep IS NULL";
	private static final String _FINDER_COLUMN_CEP_CEP_2 = "endereco.cep = ?";
	private static final String _FINDER_COLUMN_CEP_CEP_3 = "(endereco.cep IS NULL OR endereco.cep = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_BAIRRO = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_BAIRRO",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_BAIRRO =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_BAIRRO",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the enderecos where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_BAIRRO(long companyId, String bairro)
		throws SystemException {
		return findByC_BAIRRO(companyId, bairro, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_BAIRRO(long companyId, String bairro,
		int start, int end) throws SystemException {
		return findByC_BAIRRO(companyId, bairro, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_BAIRRO(long companyId, String bairro,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_BAIRRO;
		finderArgs = new Object[] {
				companyId, bairro,
				
				start, end, orderByComparator
			};

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						!StringUtil.wildcardMatches(endereco.getBairro(),
							bairro, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_BAIRRO_COMPANYID_2);

			boolean bindBairro = false;

			if (bairro == null) {
				query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_1);
			}
			else if (bairro.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_3);
			}
			else {
				bindBairro = true;

				query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindBairro) {
					qPos.add(bairro);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_BAIRRO_First(long companyId, String bairro,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_BAIRRO_First(companyId, bairro,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", bairro=");
		msg.append(bairro);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_BAIRRO_First(long companyId, String bairro,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByC_BAIRRO(companyId, bairro, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_BAIRRO_Last(long companyId, String bairro,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_BAIRRO_Last(companyId, bairro,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", bairro=");
		msg.append(bairro);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_BAIRRO_Last(long companyId, String bairro,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_BAIRRO(companyId, bairro);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_BAIRRO(companyId, bairro, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_BAIRRO_PrevAndNext(long enderecoId,
		long companyId, String bairro, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_BAIRRO_PrevAndNext(session, endereco, companyId,
					bairro, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_BAIRRO_PrevAndNext(session, endereco, companyId,
					bairro, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_BAIRRO_PrevAndNext(Session session,
		Endereco endereco, long companyId, String bairro,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_BAIRRO_COMPANYID_2);

		boolean bindBairro = false;

		if (bairro == null) {
			query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_1);
		}
		else if (bairro.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_3);
		}
		else {
			bindBairro = true;

			query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindBairro) {
			qPos.add(bairro);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and bairro LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_BAIRRO(long companyId, String bairro)
		throws SystemException {
		for (Endereco endereco : findByC_BAIRRO(companyId, bairro,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param bairro the bairro
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_BAIRRO(long companyId, String bairro)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_BAIRRO;

		Object[] finderArgs = new Object[] { companyId, bairro };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_BAIRRO_COMPANYID_2);

			boolean bindBairro = false;

			if (bairro == null) {
				query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_1);
			}
			else if (bairro.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_3);
			}
			else {
				bindBairro = true;

				query.append(_FINDER_COLUMN_C_BAIRRO_BAIRRO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindBairro) {
					qPos.add(bairro);
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

	private static final String _FINDER_COLUMN_C_BAIRRO_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_BAIRRO_BAIRRO_1 = "endereco.bairro LIKE NULL";
	private static final String _FINDER_COLUMN_C_BAIRRO_BAIRRO_2 = "endereco.bairro LIKE ?";
	private static final String _FINDER_COLUMN_C_BAIRRO_BAIRRO_3 = "(endereco.bairro IS NULL OR endereco.bairro LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_BAIRRO =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_BAIRRO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_BAIRRO =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_BAIRRO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_BAIRRO(long companyId, long groupId,
		String bairro) throws SystemException {
		return findByC_G_BAIRRO(companyId, groupId, bairro, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_BAIRRO(long companyId, long groupId,
		String bairro, int start, int end) throws SystemException {
		return findByC_G_BAIRRO(companyId, groupId, bairro, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_BAIRRO(long companyId, long groupId,
		String bairro, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_BAIRRO;
		finderArgs = new Object[] {
				companyId, groupId, bairro,
				
				start, end, orderByComparator
			};

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(groupId != endereco.getGroupId()) ||
						!StringUtil.wildcardMatches(endereco.getBairro(),
							bairro, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_BAIRRO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_BAIRRO_GROUPID_2);

			boolean bindBairro = false;

			if (bairro == null) {
				query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_1);
			}
			else if (bairro.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_3);
			}
			else {
				bindBairro = true;

				query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindBairro) {
					qPos.add(bairro);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_BAIRRO_First(long companyId, long groupId,
		String bairro, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_BAIRRO_First(companyId, groupId, bairro,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", bairro=");
		msg.append(bairro);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_BAIRRO_First(long companyId, long groupId,
		String bairro, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_G_BAIRRO(companyId, groupId, bairro, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_BAIRRO_Last(long companyId, long groupId,
		String bairro, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_BAIRRO_Last(companyId, groupId, bairro,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", bairro=");
		msg.append(bairro);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_BAIRRO_Last(long companyId, long groupId,
		String bairro, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_BAIRRO(companyId, groupId, bairro);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_G_BAIRRO(companyId, groupId, bairro,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_G_BAIRRO_PrevAndNext(long enderecoId,
		long companyId, long groupId, String bairro,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_G_BAIRRO_PrevAndNext(session, endereco,
					companyId, groupId, bairro, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_G_BAIRRO_PrevAndNext(session, endereco,
					companyId, groupId, bairro, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_G_BAIRRO_PrevAndNext(Session session,
		Endereco endereco, long companyId, long groupId, String bairro,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_G_BAIRRO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_BAIRRO_GROUPID_2);

		boolean bindBairro = false;

		if (bairro == null) {
			query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_1);
		}
		else if (bairro.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_3);
		}
		else {
			bindBairro = true;

			query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindBairro) {
			qPos.add(bairro);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_BAIRRO(long companyId, long groupId, String bairro)
		throws SystemException {
		for (Endereco endereco : findByC_G_BAIRRO(companyId, groupId, bairro,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and groupId = &#63; and bairro LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param bairro the bairro
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_BAIRRO(long companyId, long groupId, String bairro)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_BAIRRO;

		Object[] finderArgs = new Object[] { companyId, groupId, bairro };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_BAIRRO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_BAIRRO_GROUPID_2);

			boolean bindBairro = false;

			if (bairro == null) {
				query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_1);
			}
			else if (bairro.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_3);
			}
			else {
				bindBairro = true;

				query.append(_FINDER_COLUMN_C_G_BAIRRO_BAIRRO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindBairro) {
					qPos.add(bairro);
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

	private static final String _FINDER_COLUMN_C_G_BAIRRO_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_BAIRRO_GROUPID_2 = "endereco.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_BAIRRO_BAIRRO_1 = "endereco.bairro LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_BAIRRO_BAIRRO_2 = "endereco.bairro LIKE ?";
	private static final String _FINDER_COLUMN_C_G_BAIRRO_BAIRRO_3 = "(endereco.bairro IS NULL OR endereco.bairro LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BAIRRO = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBAIRRO",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_BAIRRO = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByBAIRRO",
			new String[] { String.class.getName() });

	/**
	 * Returns all the enderecos where bairro LIKE &#63;.
	 *
	 * @param bairro the bairro
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByBAIRRO(String bairro) throws SystemException {
		return findByBAIRRO(bairro, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where bairro LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bairro the bairro
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByBAIRRO(String bairro, int start, int end)
		throws SystemException {
		return findByBAIRRO(bairro, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where bairro LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bairro the bairro
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByBAIRRO(String bairro, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BAIRRO;
		finderArgs = new Object[] { bairro, start, end, orderByComparator };

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if (!StringUtil.wildcardMatches(endereco.getBairro(), bairro,
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
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			boolean bindBairro = false;

			if (bairro == null) {
				query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_1);
			}
			else if (bairro.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_3);
			}
			else {
				bindBairro = true;

				query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBairro) {
					qPos.add(bairro);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where bairro LIKE &#63;.
	 *
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByBAIRRO_First(String bairro,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByBAIRRO_First(bairro, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bairro=");
		msg.append(bairro);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where bairro LIKE &#63;.
	 *
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByBAIRRO_First(String bairro,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByBAIRRO(bairro, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where bairro LIKE &#63;.
	 *
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByBAIRRO_Last(String bairro,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByBAIRRO_Last(bairro, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bairro=");
		msg.append(bairro);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where bairro LIKE &#63;.
	 *
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByBAIRRO_Last(String bairro,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBAIRRO(bairro);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByBAIRRO(bairro, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where bairro LIKE &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param bairro the bairro
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByBAIRRO_PrevAndNext(long enderecoId, String bairro,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByBAIRRO_PrevAndNext(session, endereco, bairro,
					orderByComparator, true);

			array[1] = endereco;

			array[2] = getByBAIRRO_PrevAndNext(session, endereco, bairro,
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

	protected Endereco getByBAIRRO_PrevAndNext(Session session,
		Endereco endereco, String bairro, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		boolean bindBairro = false;

		if (bairro == null) {
			query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_1);
		}
		else if (bairro.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_3);
		}
		else {
			bindBairro = true;

			query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBairro) {
			qPos.add(bairro);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where bairro LIKE &#63; from the database.
	 *
	 * @param bairro the bairro
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBAIRRO(String bairro) throws SystemException {
		for (Endereco endereco : findByBAIRRO(bairro, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where bairro LIKE &#63;.
	 *
	 * @param bairro the bairro
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBAIRRO(String bairro) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_BAIRRO;

		Object[] finderArgs = new Object[] { bairro };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			boolean bindBairro = false;

			if (bairro == null) {
				query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_1);
			}
			else if (bairro.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_3);
			}
			else {
				bindBairro = true;

				query.append(_FINDER_COLUMN_BAIRRO_BAIRRO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBairro) {
					qPos.add(bairro);
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

	private static final String _FINDER_COLUMN_BAIRRO_BAIRRO_1 = "endereco.bairro LIKE NULL";
	private static final String _FINDER_COLUMN_BAIRRO_BAIRRO_2 = "endereco.bairro LIKE ?";
	private static final String _FINDER_COLUMN_BAIRRO_BAIRRO_3 = "(endereco.bairro IS NULL OR endereco.bairro LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_CIDADE = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_CIDADE",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CIDADE =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_CIDADE",
			new String[] { Long.class.getName(), Long.class.getName() },
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.CIDADEID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_CIDADE = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_CIDADE",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the enderecos where companyId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_CIDADE(long companyId, long cidadeId)
		throws SystemException {
		return findByC_CIDADE(companyId, cidadeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and cidadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_CIDADE(long companyId, long cidadeId,
		int start, int end) throws SystemException {
		return findByC_CIDADE(companyId, cidadeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and cidadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_CIDADE(long companyId, long cidadeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CIDADE;
			finderArgs = new Object[] { companyId, cidadeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_CIDADE;
			finderArgs = new Object[] {
					companyId, cidadeId,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(cidadeId != endereco.getCidadeId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_CIDADE_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_CIDADE_CIDADEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(cidadeId);

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_CIDADE_First(long companyId, long cidadeId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_CIDADE_First(companyId, cidadeId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", cidadeId=");
		msg.append(cidadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_CIDADE_First(long companyId, long cidadeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByC_CIDADE(companyId, cidadeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_CIDADE_Last(long companyId, long cidadeId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_CIDADE_Last(companyId, cidadeId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", cidadeId=");
		msg.append(cidadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_CIDADE_Last(long companyId, long cidadeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_CIDADE(companyId, cidadeId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_CIDADE(companyId, cidadeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and cidadeId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_CIDADE_PrevAndNext(long enderecoId,
		long companyId, long cidadeId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_CIDADE_PrevAndNext(session, endereco, companyId,
					cidadeId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_CIDADE_PrevAndNext(session, endereco, companyId,
					cidadeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_CIDADE_PrevAndNext(Session session,
		Endereco endereco, long companyId, long cidadeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_CIDADE_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_CIDADE_CIDADEID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(cidadeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and cidadeId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_CIDADE(long companyId, long cidadeId)
		throws SystemException {
		for (Endereco endereco : findByC_CIDADE(companyId, cidadeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cidadeId the cidade ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_CIDADE(long companyId, long cidadeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_CIDADE;

		Object[] finderArgs = new Object[] { companyId, cidadeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_CIDADE_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_CIDADE_CIDADEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(cidadeId);

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

	private static final String _FINDER_COLUMN_C_CIDADE_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_CIDADE_CIDADEID_2 = "endereco.cidadeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_CIDADE =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_CIDADE",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CIDADE =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_CIDADE",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.GROUPID_COLUMN_BITMASK |
			EnderecoModelImpl.CIDADEID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_CIDADE = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_CIDADE",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_CIDADE(long companyId, long groupId,
		long cidadeId) throws SystemException {
		return findByC_G_CIDADE(companyId, groupId, cidadeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_CIDADE(long companyId, long groupId,
		long cidadeId, int start, int end) throws SystemException {
		return findByC_G_CIDADE(companyId, groupId, cidadeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_CIDADE(long companyId, long groupId,
		long cidadeId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CIDADE;
			finderArgs = new Object[] { companyId, groupId, cidadeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_CIDADE;
			finderArgs = new Object[] {
					companyId, groupId, cidadeId,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(groupId != endereco.getGroupId()) ||
						(cidadeId != endereco.getCidadeId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_CIDADE_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_CIDADE_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_CIDADE_CIDADEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(cidadeId);

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_CIDADE_First(long companyId, long groupId,
		long cidadeId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_CIDADE_First(companyId, groupId,
				cidadeId, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", cidadeId=");
		msg.append(cidadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_CIDADE_First(long companyId, long groupId,
		long cidadeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_G_CIDADE(companyId, groupId, cidadeId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_CIDADE_Last(long companyId, long groupId,
		long cidadeId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_CIDADE_Last(companyId, groupId,
				cidadeId, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", cidadeId=");
		msg.append(cidadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_CIDADE_Last(long companyId, long groupId,
		long cidadeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_CIDADE(companyId, groupId, cidadeId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_G_CIDADE(companyId, groupId, cidadeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_G_CIDADE_PrevAndNext(long enderecoId,
		long companyId, long groupId, long cidadeId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_G_CIDADE_PrevAndNext(session, endereco,
					companyId, groupId, cidadeId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_G_CIDADE_PrevAndNext(session, endereco,
					companyId, groupId, cidadeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_G_CIDADE_PrevAndNext(Session session,
		Endereco endereco, long companyId, long groupId, long cidadeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_G_CIDADE_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_CIDADE_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_CIDADE_CIDADEID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(cidadeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_CIDADE(long companyId, long groupId, long cidadeId)
		throws SystemException {
		for (Endereco endereco : findByC_G_CIDADE(companyId, groupId, cidadeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and groupId = &#63; and cidadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cidadeId the cidade ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_CIDADE(long companyId, long groupId, long cidadeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_CIDADE;

		Object[] finderArgs = new Object[] { companyId, groupId, cidadeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_CIDADE_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_CIDADE_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_CIDADE_CIDADEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(cidadeId);

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

	private static final String _FINDER_COLUMN_C_G_CIDADE_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_CIDADE_GROUPID_2 = "endereco.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_CIDADE_CIDADEID_2 = "endereco.cidadeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CIDADE = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCIDADE",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CIDADE =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCIDADE",
			new String[] { Long.class.getName() },
			EnderecoModelImpl.CIDADEID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CIDADE = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCIDADE",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the enderecos where cidadeId = &#63;.
	 *
	 * @param cidadeId the cidade ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCIDADE(long cidadeId) throws SystemException {
		return findByCIDADE(cidadeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where cidadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cidadeId the cidade ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCIDADE(long cidadeId, int start, int end)
		throws SystemException {
		return findByCIDADE(cidadeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where cidadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cidadeId the cidade ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByCIDADE(long cidadeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CIDADE;
			finderArgs = new Object[] { cidadeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CIDADE;
			finderArgs = new Object[] { cidadeId, start, end, orderByComparator };
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((cidadeId != endereco.getCidadeId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_CIDADE_CIDADEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cidadeId);

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where cidadeId = &#63;.
	 *
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByCIDADE_First(long cidadeId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByCIDADE_First(cidadeId, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cidadeId=");
		msg.append(cidadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where cidadeId = &#63;.
	 *
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByCIDADE_First(long cidadeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByCIDADE(cidadeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where cidadeId = &#63;.
	 *
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByCIDADE_Last(long cidadeId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByCIDADE_Last(cidadeId, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cidadeId=");
		msg.append(cidadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where cidadeId = &#63;.
	 *
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByCIDADE_Last(long cidadeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCIDADE(cidadeId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByCIDADE(cidadeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where cidadeId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param cidadeId the cidade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByCIDADE_PrevAndNext(long enderecoId, long cidadeId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByCIDADE_PrevAndNext(session, endereco, cidadeId,
					orderByComparator, true);

			array[1] = endereco;

			array[2] = getByCIDADE_PrevAndNext(session, endereco, cidadeId,
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

	protected Endereco getByCIDADE_PrevAndNext(Session session,
		Endereco endereco, long cidadeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_CIDADE_CIDADEID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cidadeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where cidadeId = &#63; from the database.
	 *
	 * @param cidadeId the cidade ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCIDADE(long cidadeId) throws SystemException {
		for (Endereco endereco : findByCIDADE(cidadeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where cidadeId = &#63;.
	 *
	 * @param cidadeId the cidade ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCIDADE(long cidadeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CIDADE;

		Object[] finderArgs = new Object[] { cidadeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_CIDADE_CIDADEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cidadeId);

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

	private static final String _FINDER_COLUMN_CIDADE_CIDADEID_2 = "endereco.cidadeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_UF = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_UF",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_UF = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_UF",
			new String[] { Long.class.getName(), String.class.getName() },
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.UF_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_UF = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_UF",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the enderecos where companyId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_UF(long companyId, String uf)
		throws SystemException {
		return findByC_UF(companyId, uf, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and uf = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_UF(long companyId, String uf, int start,
		int end) throws SystemException {
		return findByC_UF(companyId, uf, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and uf = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_UF(long companyId, String uf, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_UF;
			finderArgs = new Object[] { companyId, uf };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_UF;
			finderArgs = new Object[] {
					companyId, uf,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						!Validator.equals(uf, endereco.getUf())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_UF_COMPANYID_2);

			boolean bindUf = false;

			if (uf == null) {
				query.append(_FINDER_COLUMN_C_UF_UF_1);
			}
			else if (uf.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_UF_UF_3);
			}
			else {
				bindUf = true;

				query.append(_FINDER_COLUMN_C_UF_UF_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindUf) {
					qPos.add(uf);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_UF_First(long companyId, String uf,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_UF_First(companyId, uf, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", uf=");
		msg.append(uf);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_UF_First(long companyId, String uf,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByC_UF(companyId, uf, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_UF_Last(long companyId, String uf,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_UF_Last(companyId, uf, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", uf=");
		msg.append(uf);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_UF_Last(long companyId, String uf,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_UF(companyId, uf);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_UF(companyId, uf, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and uf = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_UF_PrevAndNext(long enderecoId, long companyId,
		String uf, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_UF_PrevAndNext(session, endereco, companyId, uf,
					orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_UF_PrevAndNext(session, endereco, companyId, uf,
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

	protected Endereco getByC_UF_PrevAndNext(Session session,
		Endereco endereco, long companyId, String uf,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_UF_COMPANYID_2);

		boolean bindUf = false;

		if (uf == null) {
			query.append(_FINDER_COLUMN_C_UF_UF_1);
		}
		else if (uf.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_UF_UF_3);
		}
		else {
			bindUf = true;

			query.append(_FINDER_COLUMN_C_UF_UF_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindUf) {
			qPos.add(uf);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and uf = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_UF(long companyId, String uf)
		throws SystemException {
		for (Endereco endereco : findByC_UF(companyId, uf, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param uf the uf
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_UF(long companyId, String uf) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_UF;

		Object[] finderArgs = new Object[] { companyId, uf };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_UF_COMPANYID_2);

			boolean bindUf = false;

			if (uf == null) {
				query.append(_FINDER_COLUMN_C_UF_UF_1);
			}
			else if (uf.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_UF_UF_3);
			}
			else {
				bindUf = true;

				query.append(_FINDER_COLUMN_C_UF_UF_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindUf) {
					qPos.add(uf);
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

	private static final String _FINDER_COLUMN_C_UF_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_UF_UF_1 = "endereco.uf IS NULL";
	private static final String _FINDER_COLUMN_C_UF_UF_2 = "endereco.uf = ?";
	private static final String _FINDER_COLUMN_C_UF_UF_3 = "(endereco.uf IS NULL OR endereco.uf = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_UF = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_UF",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_UF =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_UF",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.GROUPID_COLUMN_BITMASK |
			EnderecoModelImpl.UF_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_UF = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_UF",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_UF(long companyId, long groupId, String uf)
		throws SystemException {
		return findByC_G_UF(companyId, groupId, uf, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_UF(long companyId, long groupId, String uf,
		int start, int end) throws SystemException {
		return findByC_G_UF(companyId, groupId, uf, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_UF(long companyId, long groupId, String uf,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_UF;
			finderArgs = new Object[] { companyId, groupId, uf };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_UF;
			finderArgs = new Object[] {
					companyId, groupId, uf,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(groupId != endereco.getGroupId()) ||
						!Validator.equals(uf, endereco.getUf())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_UF_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_UF_GROUPID_2);

			boolean bindUf = false;

			if (uf == null) {
				query.append(_FINDER_COLUMN_C_G_UF_UF_1);
			}
			else if (uf.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_UF_UF_3);
			}
			else {
				bindUf = true;

				query.append(_FINDER_COLUMN_C_G_UF_UF_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindUf) {
					qPos.add(uf);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_UF_First(long companyId, long groupId, String uf,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_UF_First(companyId, groupId, uf,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", uf=");
		msg.append(uf);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_UF_First(long companyId, long groupId,
		String uf, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_G_UF(companyId, groupId, uf, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_UF_Last(long companyId, long groupId, String uf,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_UF_Last(companyId, groupId, uf,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", uf=");
		msg.append(uf);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_UF_Last(long companyId, long groupId, String uf,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G_UF(companyId, groupId, uf);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_G_UF(companyId, groupId, uf, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_G_UF_PrevAndNext(long enderecoId, long companyId,
		long groupId, String uf, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_G_UF_PrevAndNext(session, endereco, companyId,
					groupId, uf, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_G_UF_PrevAndNext(session, endereco, companyId,
					groupId, uf, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_G_UF_PrevAndNext(Session session,
		Endereco endereco, long companyId, long groupId, String uf,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_G_UF_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_UF_GROUPID_2);

		boolean bindUf = false;

		if (uf == null) {
			query.append(_FINDER_COLUMN_C_G_UF_UF_1);
		}
		else if (uf.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_UF_UF_3);
		}
		else {
			bindUf = true;

			query.append(_FINDER_COLUMN_C_G_UF_UF_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindUf) {
			qPos.add(uf);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and groupId = &#63; and uf = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_UF(long companyId, long groupId, String uf)
		throws SystemException {
		for (Endereco endereco : findByC_G_UF(companyId, groupId, uf,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and groupId = &#63; and uf = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param uf the uf
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_UF(long companyId, long groupId, String uf)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_UF;

		Object[] finderArgs = new Object[] { companyId, groupId, uf };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_UF_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_UF_GROUPID_2);

			boolean bindUf = false;

			if (uf == null) {
				query.append(_FINDER_COLUMN_C_G_UF_UF_1);
			}
			else if (uf.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_UF_UF_3);
			}
			else {
				bindUf = true;

				query.append(_FINDER_COLUMN_C_G_UF_UF_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindUf) {
					qPos.add(uf);
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

	private static final String _FINDER_COLUMN_C_G_UF_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_UF_GROUPID_2 = "endereco.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_UF_UF_1 = "endereco.uf IS NULL";
	private static final String _FINDER_COLUMN_C_G_UF_UF_2 = "endereco.uf = ?";
	private static final String _FINDER_COLUMN_C_G_UF_UF_3 = "(endereco.uf IS NULL OR endereco.uf = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UF = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUF",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUF",
			new String[] { String.class.getName() },
			EnderecoModelImpl.UF_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UF = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUF",
			new String[] { String.class.getName() });

	/**
	 * Returns all the enderecos where uf = &#63;.
	 *
	 * @param uf the uf
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUF(String uf) throws SystemException {
		return findByUF(uf, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where uf = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uf the uf
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUF(String uf, int start, int end)
		throws SystemException {
		return findByUF(uf, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where uf = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uf the uf
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByUF(String uf, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF;
			finderArgs = new Object[] { uf };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UF;
			finderArgs = new Object[] { uf, start, end, orderByComparator };
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if (!Validator.equals(uf, endereco.getUf())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			boolean bindUf = false;

			if (uf == null) {
				query.append(_FINDER_COLUMN_UF_UF_1);
			}
			else if (uf.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UF_UF_3);
			}
			else {
				bindUf = true;

				query.append(_FINDER_COLUMN_UF_UF_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUf) {
					qPos.add(uf);
				}

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where uf = &#63;.
	 *
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByUF_First(String uf,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByUF_First(uf, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uf=");
		msg.append(uf);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where uf = &#63;.
	 *
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByUF_First(String uf,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByUF(uf, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where uf = &#63;.
	 *
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByUF_Last(String uf, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByUF_Last(uf, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uf=");
		msg.append(uf);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where uf = &#63;.
	 *
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByUF_Last(String uf,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUF(uf);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByUF(uf, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where uf = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByUF_PrevAndNext(long enderecoId, String uf,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByUF_PrevAndNext(session, endereco, uf,
					orderByComparator, true);

			array[1] = endereco;

			array[2] = getByUF_PrevAndNext(session, endereco, uf,
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

	protected Endereco getByUF_PrevAndNext(Session session, Endereco endereco,
		String uf, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		boolean bindUf = false;

		if (uf == null) {
			query.append(_FINDER_COLUMN_UF_UF_1);
		}
		else if (uf.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UF_UF_3);
		}
		else {
			bindUf = true;

			query.append(_FINDER_COLUMN_UF_UF_2);
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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUf) {
			qPos.add(uf);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where uf = &#63; from the database.
	 *
	 * @param uf the uf
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUF(String uf) throws SystemException {
		for (Endereco endereco : findByUF(uf, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where uf = &#63;.
	 *
	 * @param uf the uf
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUF(String uf) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UF;

		Object[] finderArgs = new Object[] { uf };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			boolean bindUf = false;

			if (uf == null) {
				query.append(_FINDER_COLUMN_UF_UF_1);
			}
			else if (uf.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UF_UF_3);
			}
			else {
				bindUf = true;

				query.append(_FINDER_COLUMN_UF_UF_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUf) {
					qPos.add(uf);
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

	private static final String _FINDER_COLUMN_UF_UF_1 = "endereco.uf IS NULL";
	private static final String _FINDER_COLUMN_UF_UF_2 = "endereco.uf = ?";
	private static final String _FINDER_COLUMN_UF_UF_3 = "(endereco.uf IS NULL OR endereco.uf = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_PAIS = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_PAIS",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_PAIS =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_PAIS",
			new String[] { Long.class.getName(), Long.class.getName() },
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.PAISID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_PAIS = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_PAIS",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the enderecos where companyId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_PAIS(long companyId, long paisId)
		throws SystemException {
		return findByC_PAIS(companyId, paisId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and paisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_PAIS(long companyId, long paisId, int start,
		int end) throws SystemException {
		return findByC_PAIS(companyId, paisId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and paisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_PAIS(long companyId, long paisId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_PAIS;
			finderArgs = new Object[] { companyId, paisId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_PAIS;
			finderArgs = new Object[] {
					companyId, paisId,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(paisId != endereco.getPaisId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_PAIS_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_PAIS_PAISID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(paisId);

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_PAIS_First(long companyId, long paisId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_PAIS_First(companyId, paisId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", paisId=");
		msg.append(paisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_PAIS_First(long companyId, long paisId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByC_PAIS(companyId, paisId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_PAIS_Last(long companyId, long paisId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_PAIS_Last(companyId, paisId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", paisId=");
		msg.append(paisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_PAIS_Last(long companyId, long paisId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_PAIS(companyId, paisId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_PAIS(companyId, paisId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and paisId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_PAIS_PrevAndNext(long enderecoId, long companyId,
		long paisId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_PAIS_PrevAndNext(session, endereco, companyId,
					paisId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_PAIS_PrevAndNext(session, endereco, companyId,
					paisId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_PAIS_PrevAndNext(Session session,
		Endereco endereco, long companyId, long paisId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_PAIS_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_PAIS_PAISID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(paisId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and paisId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_PAIS(long companyId, long paisId)
		throws SystemException {
		for (Endereco endereco : findByC_PAIS(companyId, paisId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param paisId the pais ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_PAIS(long companyId, long paisId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_PAIS;

		Object[] finderArgs = new Object[] { companyId, paisId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_PAIS_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_PAIS_PAISID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(paisId);

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

	private static final String _FINDER_COLUMN_C_PAIS_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_PAIS_PAISID_2 = "endereco.paisId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_PAIS = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_PAIS",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_PAIS =
		new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_PAIS",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EnderecoModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoModelImpl.GROUPID_COLUMN_BITMASK |
			EnderecoModelImpl.PAISID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_PAIS = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_PAIS",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_PAIS(long companyId, long groupId,
		long paisId) throws SystemException {
		return findByC_G_PAIS(companyId, groupId, paisId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_PAIS(long companyId, long groupId,
		long paisId, int start, int end) throws SystemException {
		return findByC_G_PAIS(companyId, groupId, paisId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByC_G_PAIS(long companyId, long groupId,
		long paisId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_PAIS;
			finderArgs = new Object[] { companyId, groupId, paisId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_PAIS;
			finderArgs = new Object[] {
					companyId, groupId, paisId,
					
					start, end, orderByComparator
				};
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((companyId != endereco.getCompanyId()) ||
						(groupId != endereco.getGroupId()) ||
						(paisId != endereco.getPaisId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_PAIS_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_PAIS_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_PAIS_PAISID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(paisId);

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_PAIS_First(long companyId, long groupId,
		long paisId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_PAIS_First(companyId, groupId, paisId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", paisId=");
		msg.append(paisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_PAIS_First(long companyId, long groupId,
		long paisId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Endereco> list = findByC_G_PAIS(companyId, groupId, paisId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByC_G_PAIS_Last(long companyId, long groupId,
		long paisId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByC_G_PAIS_Last(companyId, groupId, paisId,
				orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", paisId=");
		msg.append(paisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByC_G_PAIS_Last(long companyId, long groupId,
		long paisId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_PAIS(companyId, groupId, paisId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByC_G_PAIS(companyId, groupId, paisId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByC_G_PAIS_PrevAndNext(long enderecoId,
		long companyId, long groupId, long paisId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByC_G_PAIS_PrevAndNext(session, endereco, companyId,
					groupId, paisId, orderByComparator, true);

			array[1] = endereco;

			array[2] = getByC_G_PAIS_PrevAndNext(session, endereco, companyId,
					groupId, paisId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Endereco getByC_G_PAIS_PrevAndNext(Session session,
		Endereco endereco, long companyId, long groupId, long paisId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_C_G_PAIS_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_PAIS_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_PAIS_PAISID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(paisId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_PAIS(long companyId, long groupId, long paisId)
		throws SystemException {
		for (Endereco endereco : findByC_G_PAIS(companyId, groupId, paisId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where companyId = &#63; and groupId = &#63; and paisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param paisId the pais ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_PAIS(long companyId, long groupId, long paisId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_PAIS;

		Object[] finderArgs = new Object[] { companyId, groupId, paisId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_C_G_PAIS_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_PAIS_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_PAIS_PAISID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(paisId);

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

	private static final String _FINDER_COLUMN_C_G_PAIS_COMPANYID_2 = "endereco.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_PAIS_GROUPID_2 = "endereco.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_PAIS_PAISID_2 = "endereco.paisId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PAIS = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPAIS",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAIS = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, EnderecoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPAIS",
			new String[] { Long.class.getName() },
			EnderecoModelImpl.PAISID_COLUMN_BITMASK |
			EnderecoModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PAIS = new FinderPath(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPAIS",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the enderecos where paisId = &#63;.
	 *
	 * @param paisId the pais ID
	 * @return the matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByPAIS(long paisId) throws SystemException {
		return findByPAIS(paisId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos where paisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paisId the pais ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByPAIS(long paisId, int start, int end)
		throws SystemException {
		return findByPAIS(paisId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos where paisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paisId the pais ID
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findByPAIS(long paisId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAIS;
			finderArgs = new Object[] { paisId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PAIS;
			finderArgs = new Object[] { paisId, start, end, orderByComparator };
		}

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Endereco endereco : list) {
				if ((paisId != endereco.getPaisId())) {
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

			query.append(_SQL_SELECT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_PAIS_PAISID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(paisId);

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco in the ordered set where paisId = &#63;.
	 *
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByPAIS_First(long paisId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByPAIS_First(paisId, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paisId=");
		msg.append(paisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the first endereco in the ordered set where paisId = &#63;.
	 *
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByPAIS_First(long paisId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Endereco> list = findByPAIS(paisId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco in the ordered set where paisId = &#63;.
	 *
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByPAIS_Last(long paisId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByPAIS_Last(paisId, orderByComparator);

		if (endereco != null) {
			return endereco;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paisId=");
		msg.append(paisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoException(msg.toString());
	}

	/**
	 * Returns the last endereco in the ordered set where paisId = &#63;.
	 *
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco, or <code>null</code> if a matching endereco could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByPAIS_Last(long paisId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPAIS(paisId);

		if (count == 0) {
			return null;
		}

		List<Endereco> list = findByPAIS(paisId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enderecos before and after the current endereco in the ordered set where paisId = &#63;.
	 *
	 * @param enderecoId the primary key of the current endereco
	 * @param paisId the pais ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco[] findByPAIS_PrevAndNext(long enderecoId, long paisId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = findByPrimaryKey(enderecoId);

		Session session = null;

		try {
			session = openSession();

			Endereco[] array = new EnderecoImpl[3];

			array[0] = getByPAIS_PrevAndNext(session, endereco, paisId,
					orderByComparator, true);

			array[1] = endereco;

			array[2] = getByPAIS_PrevAndNext(session, endereco, paisId,
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

	protected Endereco getByPAIS_PrevAndNext(Session session,
		Endereco endereco, long paisId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECO_WHERE);

		query.append(_FINDER_COLUMN_PAIS_PAISID_2);

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
			query.append(EnderecoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(paisId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(endereco);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Endereco> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enderecos where paisId = &#63; from the database.
	 *
	 * @param paisId the pais ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPAIS(long paisId) throws SystemException {
		for (Endereco endereco : findByPAIS(paisId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos where paisId = &#63;.
	 *
	 * @param paisId the pais ID
	 * @return the number of matching enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPAIS(long paisId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PAIS;

		Object[] finderArgs = new Object[] { paisId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENDERECO_WHERE);

			query.append(_FINDER_COLUMN_PAIS_PAISID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(paisId);

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

	private static final String _FINDER_COLUMN_PAIS_PAISID_2 = "endereco.paisId = ?";

	public EnderecoPersistenceImpl() {
		setModelClass(Endereco.class);
	}

	/**
	 * Caches the endereco in the entity cache if it is enabled.
	 *
	 * @param endereco the endereco
	 */
	@Override
	public void cacheResult(Endereco endereco) {
		EntityCacheUtil.putResult(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoImpl.class, endereco.getPrimaryKey(), endereco);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { endereco.getUuid(), endereco.getGroupId() }, endereco);

		endereco.resetOriginalValues();
	}

	/**
	 * Caches the enderecos in the entity cache if it is enabled.
	 *
	 * @param enderecos the enderecos
	 */
	@Override
	public void cacheResult(List<Endereco> enderecos) {
		for (Endereco endereco : enderecos) {
			if (EntityCacheUtil.getResult(
						EnderecoModelImpl.ENTITY_CACHE_ENABLED,
						EnderecoImpl.class, endereco.getPrimaryKey()) == null) {
				cacheResult(endereco);
			}
			else {
				endereco.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all enderecos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnderecoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnderecoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the endereco.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Endereco endereco) {
		EntityCacheUtil.removeResult(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoImpl.class, endereco.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(endereco);
	}

	@Override
	public void clearCache(List<Endereco> enderecos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Endereco endereco : enderecos) {
			EntityCacheUtil.removeResult(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
				EnderecoImpl.class, endereco.getPrimaryKey());

			clearUniqueFindersCache(endereco);
		}
	}

	protected void cacheUniqueFindersCache(Endereco endereco) {
		if (endereco.isNew()) {
			Object[] args = new Object[] {
					endereco.getUuid(), endereco.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				endereco);
		}
		else {
			EnderecoModelImpl enderecoModelImpl = (EnderecoModelImpl)endereco;

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						endereco.getUuid(), endereco.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					endereco);
			}
		}
	}

	protected void clearUniqueFindersCache(Endereco endereco) {
		EnderecoModelImpl enderecoModelImpl = (EnderecoModelImpl)endereco;

		Object[] args = new Object[] { endereco.getUuid(), endereco.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((enderecoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					enderecoModelImpl.getOriginalUuid(),
					enderecoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new endereco with the primary key. Does not add the endereco to the database.
	 *
	 * @param enderecoId the primary key for the new endereco
	 * @return the new endereco
	 */
	@Override
	public Endereco create(long enderecoId) {
		Endereco endereco = new EnderecoImpl();

		endereco.setNew(true);
		endereco.setPrimaryKey(enderecoId);

		String uuid = PortalUUIDUtil.generate();

		endereco.setUuid(uuid);

		return endereco;
	}

	/**
	 * Removes the endereco with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enderecoId the primary key of the endereco
	 * @return the endereco that was removed
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco remove(long enderecoId)
		throws NoSuchEnderecoException, SystemException {
		return remove((Serializable)enderecoId);
	}

	/**
	 * Removes the endereco with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the endereco
	 * @return the endereco that was removed
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco remove(Serializable primaryKey)
		throws NoSuchEnderecoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Endereco endereco = (Endereco)session.get(EnderecoImpl.class,
					primaryKey);

			if (endereco == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnderecoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(endereco);
		}
		catch (NoSuchEnderecoException nsee) {
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
	protected Endereco removeImpl(Endereco endereco) throws SystemException {
		endereco = toUnwrappedModel(endereco);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(endereco)) {
				endereco = (Endereco)session.get(EnderecoImpl.class,
						endereco.getPrimaryKeyObj());
			}

			if (endereco != null) {
				session.delete(endereco);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (endereco != null) {
			clearCache(endereco);
		}

		return endereco;
	}

	@Override
	public Endereco updateImpl(
		br.com.prodevelopment.contato.model.Endereco endereco)
		throws SystemException {
		endereco = toUnwrappedModel(endereco);

		boolean isNew = endereco.isNew();

		EnderecoModelImpl enderecoModelImpl = (EnderecoModelImpl)endereco;

		if (Validator.isNull(endereco.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			endereco.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (endereco.isNew()) {
				session.save(endereco);

				endereco.setNew(false);
			}
			else {
				session.merge(endereco);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EnderecoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { enderecoModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { enderecoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalUuid(),
						enderecoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						enderecoModelImpl.getUuid(),
						enderecoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { enderecoModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalGroupId(),
						enderecoModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getGroupId(),
						enderecoModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalGroupId(),
						enderecoModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_G,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getGroupId(),
						enderecoModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_G,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalClassNameId(),
						enderecoModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getClassNameId(),
						enderecoModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalClassNameId(),
						enderecoModelImpl.getOriginalClassPK(),
						enderecoModelImpl.getOriginalPrincipal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getClassNameId(),
						enderecoModelImpl.getClassPK(),
						enderecoModelImpl.getPrincipal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CEP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalCep()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_CEP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CEP,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getCep()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_CEP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CEP,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CEP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalGroupId(),
						enderecoModelImpl.getOriginalCep()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_CEP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CEP,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getGroupId(),
						enderecoModelImpl.getCep()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_CEP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CEP,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CEP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { enderecoModelImpl.getOriginalCep() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CEP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CEP,
					args);

				args = new Object[] { enderecoModelImpl.getCep() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CEP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CEP,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CIDADE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalCidadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_CIDADE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CIDADE,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getCidadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_CIDADE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CIDADE,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CIDADE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalGroupId(),
						enderecoModelImpl.getOriginalCidadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_CIDADE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CIDADE,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getGroupId(),
						enderecoModelImpl.getCidadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_CIDADE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CIDADE,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CIDADE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCidadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CIDADE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CIDADE,
					args);

				args = new Object[] { enderecoModelImpl.getCidadeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CIDADE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CIDADE,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_UF.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalUf()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_UF, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_UF,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getUf()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_UF, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_UF,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_UF.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalGroupId(),
						enderecoModelImpl.getOriginalUf()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_UF, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_UF,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getGroupId(),
						enderecoModelImpl.getUf()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_UF, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_UF,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { enderecoModelImpl.getOriginalUf() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UF, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF,
					args);

				args = new Object[] { enderecoModelImpl.getUf() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UF, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_PAIS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalPaisId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_PAIS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_PAIS,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getPaisId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_PAIS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_PAIS,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_PAIS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalCompanyId(),
						enderecoModelImpl.getOriginalGroupId(),
						enderecoModelImpl.getOriginalPaisId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_PAIS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_PAIS,
					args);

				args = new Object[] {
						enderecoModelImpl.getCompanyId(),
						enderecoModelImpl.getGroupId(),
						enderecoModelImpl.getPaisId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_PAIS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_PAIS,
					args);
			}

			if ((enderecoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAIS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoModelImpl.getOriginalPaisId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PAIS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAIS,
					args);

				args = new Object[] { enderecoModelImpl.getPaisId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PAIS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAIS,
					args);
			}
		}

		EntityCacheUtil.putResult(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoImpl.class, endereco.getPrimaryKey(), endereco);

		clearUniqueFindersCache(endereco);
		cacheUniqueFindersCache(endereco);

		return endereco;
	}

	protected Endereco toUnwrappedModel(Endereco endereco) {
		if (endereco instanceof EnderecoImpl) {
			return endereco;
		}

		EnderecoImpl enderecoImpl = new EnderecoImpl();

		enderecoImpl.setNew(endereco.isNew());
		enderecoImpl.setPrimaryKey(endereco.getPrimaryKey());

		enderecoImpl.setUuid(endereco.getUuid());
		enderecoImpl.setEnderecoId(endereco.getEnderecoId());
		enderecoImpl.setCompanyId(endereco.getCompanyId());
		enderecoImpl.setGroupId(endereco.getGroupId());
		enderecoImpl.setCreateUserId(endereco.getCreateUserId());
		enderecoImpl.setModifiedUserId(endereco.getModifiedUserId());
		enderecoImpl.setCreateDate(endereco.getCreateDate());
		enderecoImpl.setModifiedDate(endereco.getModifiedDate());
		enderecoImpl.setClassNameId(endereco.getClassNameId());
		enderecoImpl.setClassPK(endereco.getClassPK());
		enderecoImpl.setLogradouro(endereco.getLogradouro());
		enderecoImpl.setNumero(endereco.getNumero());
		enderecoImpl.setComplemento(endereco.getComplemento());
		enderecoImpl.setCep(endereco.getCep());
		enderecoImpl.setBairro(endereco.getBairro());
		enderecoImpl.setCidadeId(endereco.getCidadeId());
		enderecoImpl.setUf(endereco.getUf());
		enderecoImpl.setPaisId(endereco.getPaisId());
		enderecoImpl.setPrincipal(endereco.isPrincipal());
		enderecoImpl.setTipo(endereco.getTipo());

		return enderecoImpl;
	}

	/**
	 * Returns the endereco with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the endereco
	 * @return the endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEnderecoException, SystemException {
		Endereco endereco = fetchByPrimaryKey(primaryKey);

		if (endereco == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEnderecoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return endereco;
	}

	/**
	 * Returns the endereco with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoException} if it could not be found.
	 *
	 * @param enderecoId the primary key of the endereco
	 * @return the endereco
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoException if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco findByPrimaryKey(long enderecoId)
		throws NoSuchEnderecoException, SystemException {
		return findByPrimaryKey((Serializable)enderecoId);
	}

	/**
	 * Returns the endereco with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the endereco
	 * @return the endereco, or <code>null</code> if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Endereco endereco = (Endereco)EntityCacheUtil.getResult(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
				EnderecoImpl.class, primaryKey);

		if (endereco == _nullEndereco) {
			return null;
		}

		if (endereco == null) {
			Session session = null;

			try {
				session = openSession();

				endereco = (Endereco)session.get(EnderecoImpl.class, primaryKey);

				if (endereco != null) {
					cacheResult(endereco);
				}
				else {
					EntityCacheUtil.putResult(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
						EnderecoImpl.class, primaryKey, _nullEndereco);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EnderecoModelImpl.ENTITY_CACHE_ENABLED,
					EnderecoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return endereco;
	}

	/**
	 * Returns the endereco with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enderecoId the primary key of the endereco
	 * @return the endereco, or <code>null</code> if a endereco with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Endereco fetchByPrimaryKey(long enderecoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)enderecoId);
	}

	/**
	 * Returns all the enderecos.
	 *
	 * @return the enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enderecos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @return the range of enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enderecos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enderecos
	 * @param end the upper bound of the range of enderecos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enderecos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Endereco> findAll(int start, int end,
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

		List<Endereco> list = (List<Endereco>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENDERECO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENDERECO;

				if (pagination) {
					sql = sql.concat(EnderecoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Endereco>(list);
				}
				else {
					list = (List<Endereco>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the enderecos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Endereco endereco : findAll()) {
			remove(endereco);
		}
	}

	/**
	 * Returns the number of enderecos.
	 *
	 * @return the number of enderecos
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

				Query q = session.createQuery(_SQL_COUNT_ENDERECO);

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
	 * Initializes the endereco persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.contato.model.Endereco")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Endereco>> listenersList = new ArrayList<ModelListener<Endereco>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Endereco>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EnderecoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ENDERECO = "SELECT endereco FROM Endereco endereco";
	private static final String _SQL_SELECT_ENDERECO_WHERE = "SELECT endereco FROM Endereco endereco WHERE ";
	private static final String _SQL_COUNT_ENDERECO = "SELECT COUNT(endereco) FROM Endereco endereco";
	private static final String _SQL_COUNT_ENDERECO_WHERE = "SELECT COUNT(endereco) FROM Endereco endereco WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "endereco.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Endereco exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Endereco exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnderecoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Endereco _nullEndereco = new EnderecoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Endereco> toCacheModel() {
				return _nullEnderecoCacheModel;
			}
		};

	private static CacheModel<Endereco> _nullEnderecoCacheModel = new CacheModel<Endereco>() {
			@Override
			public Endereco toEntityModel() {
				return _nullEndereco;
			}
		};
}