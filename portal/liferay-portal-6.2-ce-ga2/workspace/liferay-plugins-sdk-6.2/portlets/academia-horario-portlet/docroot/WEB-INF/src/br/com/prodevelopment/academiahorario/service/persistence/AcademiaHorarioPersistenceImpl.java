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

package br.com.prodevelopment.academiahorario.service.persistence;

import br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException;
import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioImpl;
import br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl;

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
 * The persistence implementation for the academia horario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo
 * @see AcademiaHorarioPersistence
 * @see AcademiaHorarioUtil
 * @generated
 */
public class AcademiaHorarioPersistenceImpl extends BasePersistenceImpl<AcademiaHorario>
	implements AcademiaHorarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AcademiaHorarioUtil} to access the academia horario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AcademiaHorarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AcademiaHorarioModelImpl.UUID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADENOME_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.DIASEMANA_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.HORAINICIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the academia horarios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academia horarios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the academia horarios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByUuid(String uuid, int start, int end,
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

		List<AcademiaHorario> list = (List<AcademiaHorario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AcademiaHorario academiaHorario : list) {
				if (!Validator.equals(uuid, academiaHorario.getUuid())) {
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

			query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

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
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<AcademiaHorario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AcademiaHorario>(list);
				}
				else {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
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
	 * Returns the first academia horario in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByUuid_First(uuid,
				orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the first academia horario in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<AcademiaHorario> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last academia horario in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByUuid_Last(uuid,
				orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the last academia horario in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AcademiaHorario> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the academia horarios before and after the current academia horario in the ordered set where uuid = &#63;.
	 *
	 * @param academiaHorarioId the primary key of the current academia horario
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario[] findByUuid_PrevAndNext(long academiaHorarioId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = findByPrimaryKey(academiaHorarioId);

		Session session = null;

		try {
			session = openSession();

			AcademiaHorario[] array = new AcademiaHorarioImpl[3];

			array[0] = getByUuid_PrevAndNext(session, academiaHorario, uuid,
					orderByComparator, true);

			array[1] = academiaHorario;

			array[2] = getByUuid_PrevAndNext(session, academiaHorario, uuid,
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

	protected AcademiaHorario getByUuid_PrevAndNext(Session session,
		AcademiaHorario academiaHorario, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

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
			query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(academiaHorario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AcademiaHorario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the academia horarios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (AcademiaHorario academiaHorario : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(academiaHorario);
		}
	}

	/**
	 * Returns the number of academia horarios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching academia horarios
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

			query.append(_SQL_COUNT_ACADEMIAHORARIO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "academiaHorario.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "academiaHorario.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(academiaHorario.uuid IS NULL OR academiaHorario.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			AcademiaHorarioModelImpl.UUID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the academia horario where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByUUID_G(String uuid, long groupId)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByUUID_G(uuid, groupId);

		if (academiaHorario == null) {
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

			throw new NoSuchAcademiaHorarioException(msg.toString());
		}

		return academiaHorario;
	}

	/**
	 * Returns the academia horario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the academia horario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof AcademiaHorario) {
			AcademiaHorario academiaHorario = (AcademiaHorario)result;

			if (!Validator.equals(uuid, academiaHorario.getUuid()) ||
					(groupId != academiaHorario.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

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

				List<AcademiaHorario> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					AcademiaHorario academiaHorario = list.get(0);

					result = academiaHorario;

					cacheResult(academiaHorario);

					if ((academiaHorario.getUuid() == null) ||
							!academiaHorario.getUuid().equals(uuid) ||
							(academiaHorario.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, academiaHorario);
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
			return (AcademiaHorario)result;
		}
	}

	/**
	 * Removes the academia horario where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the academia horario that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario removeByUUID_G(String uuid, long groupId)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = findByUUID_G(uuid, groupId);

		return remove(academiaHorario);
	}

	/**
	 * Returns the number of academia horarios where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching academia horarios
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

			query.append(_SQL_COUNT_ACADEMIAHORARIO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "academiaHorario.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "academiaHorario.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(academiaHorario.uuid IS NULL OR academiaHorario.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "academiaHorario.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AcademiaHorarioModelImpl.UUID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.COMPANYID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADENOME_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.DIASEMANA_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.HORAINICIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the academia horarios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academia horarios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the academia horarios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByUuid_C(String uuid, long companyId,
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

		List<AcademiaHorario> list = (List<AcademiaHorario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AcademiaHorario academiaHorario : list) {
				if (!Validator.equals(uuid, academiaHorario.getUuid()) ||
						(companyId != academiaHorario.getCompanyId())) {
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

			query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

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
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<AcademiaHorario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AcademiaHorario>(list);
				}
				else {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
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
	 * Returns the first academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the first academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AcademiaHorario> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the last academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AcademiaHorario> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the academia horarios before and after the current academia horario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param academiaHorarioId the primary key of the current academia horario
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario[] findByUuid_C_PrevAndNext(long academiaHorarioId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = findByPrimaryKey(academiaHorarioId);

		Session session = null;

		try {
			session = openSession();

			AcademiaHorario[] array = new AcademiaHorarioImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, academiaHorario, uuid,
					companyId, orderByComparator, true);

			array[1] = academiaHorario;

			array[2] = getByUuid_C_PrevAndNext(session, academiaHorario, uuid,
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

	protected AcademiaHorario getByUuid_C_PrevAndNext(Session session,
		AcademiaHorario academiaHorario, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

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
			query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(academiaHorario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AcademiaHorario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the academia horarios where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (AcademiaHorario academiaHorario : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(academiaHorario);
		}
	}

	/**
	 * Returns the number of academia horarios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching academia horarios
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

			query.append(_SQL_COUNT_ACADEMIAHORARIO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "academiaHorario.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "academiaHorario.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(academiaHorario.uuid IS NULL OR academiaHorario.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "academiaHorario.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			AcademiaHorarioModelImpl.COMPANYID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADENOME_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.DIASEMANA_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.HORAINICIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the academia horarios where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the academia horarios where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the academia horarios where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByCompany(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<AcademiaHorario> list = (List<AcademiaHorario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AcademiaHorario academiaHorario : list) {
				if ((companyId != academiaHorario.getCompanyId())) {
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

			query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AcademiaHorario>(list);
				}
				else {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
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
	 * Returns the first academia horario in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByCompany_First(companyId,
				orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the first academia horario in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AcademiaHorario> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last academia horario in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByCompany_Last(companyId,
				orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the last academia horario in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<AcademiaHorario> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the academia horarios before and after the current academia horario in the ordered set where companyId = &#63;.
	 *
	 * @param academiaHorarioId the primary key of the current academia horario
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario[] findByCompany_PrevAndNext(long academiaHorarioId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = findByPrimaryKey(academiaHorarioId);

		Session session = null;

		try {
			session = openSession();

			AcademiaHorario[] array = new AcademiaHorarioImpl[3];

			array[0] = getByCompany_PrevAndNext(session, academiaHorario,
					companyId, orderByComparator, true);

			array[1] = academiaHorario;

			array[2] = getByCompany_PrevAndNext(session, academiaHorario,
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

	protected AcademiaHorario getByCompany_PrevAndNext(Session session,
		AcademiaHorario academiaHorario, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

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
			query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(academiaHorario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AcademiaHorario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the academia horarios where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (AcademiaHorario academiaHorario : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(academiaHorario);
		}
	}

	/**
	 * Returns the number of academia horarios where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching academia horarios
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

			query.append(_SQL_COUNT_ACADEMIAHORARIO_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "academiaHorario.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			AcademiaHorarioModelImpl.COMPANYID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.GROUPID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADENOME_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.DIASEMANA_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.HORAINICIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the academia horarios where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academia horarios where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the academia horarios where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_G(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<AcademiaHorario> list = (List<AcademiaHorario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AcademiaHorario academiaHorario : list) {
				if ((companyId != academiaHorario.getCompanyId()) ||
						(groupId != academiaHorario.getGroupId())) {
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

			query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<AcademiaHorario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AcademiaHorario>(list);
				}
				else {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
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
	 * Returns the first academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByC_G_First(companyId, groupId,
				orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the first academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AcademiaHorario> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByC_G_Last(companyId, groupId,
				orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the last academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<AcademiaHorario> list = findByC_G(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the academia horarios before and after the current academia horario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param academiaHorarioId the primary key of the current academia horario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario[] findByC_G_PrevAndNext(long academiaHorarioId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = findByPrimaryKey(academiaHorarioId);

		Session session = null;

		try {
			session = openSession();

			AcademiaHorario[] array = new AcademiaHorarioImpl[3];

			array[0] = getByC_G_PrevAndNext(session, academiaHorario,
					companyId, groupId, orderByComparator, true);

			array[1] = academiaHorario;

			array[2] = getByC_G_PrevAndNext(session, academiaHorario,
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

	protected AcademiaHorario getByC_G_PrevAndNext(Session session,
		AcademiaHorario academiaHorario, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

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
			query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(academiaHorario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AcademiaHorario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching academia horarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of matching academia horarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> filterFindByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the academia horarios that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching academia horarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> filterFindByC_G(long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AcademiaHorarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AcademiaHorario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AcademiaHorarioImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AcademiaHorarioImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<AcademiaHorario>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the academia horarios before and after the current academia horario in the ordered set of academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param academiaHorarioId the primary key of the current academia horario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario[] filterFindByC_G_PrevAndNext(
		long academiaHorarioId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(academiaHorarioId, companyId, groupId,
				orderByComparator);
		}

		AcademiaHorario academiaHorario = findByPrimaryKey(academiaHorarioId);

		Session session = null;

		try {
			session = openSession();

			AcademiaHorario[] array = new AcademiaHorarioImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, academiaHorario,
					companyId, groupId, orderByComparator, true);

			array[1] = academiaHorario;

			array[2] = filterGetByC_G_PrevAndNext(session, academiaHorario,
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

	protected AcademiaHorario filterGetByC_G_PrevAndNext(Session session,
		AcademiaHorario academiaHorario, long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AcademiaHorarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AcademiaHorario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AcademiaHorarioImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AcademiaHorarioImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(academiaHorario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AcademiaHorario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the academia horarios where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (AcademiaHorario academiaHorario : findByC_G(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(academiaHorario);
		}
	}

	/**
	 * Returns the number of academia horarios where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching academia horarios
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

			query.append(_SQL_COUNT_ACADEMIAHORARIO_WHERE);

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
	 * Returns the number of academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching academia horarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_ACADEMIAHORARIO_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AcademiaHorario.class.getName(),
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

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "academiaHorario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "academiaHorario.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_ATIVIDADE =
		new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_ATIVIDADE",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_ATIVIDADE =
		new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_ATIVIDADE",
			new String[] { Long.class.getName(), Long.class.getName() },
			AcademiaHorarioModelImpl.COMPANYID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADEID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADENOME_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.DIASEMANA_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.HORAINICIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_ATIVIDADE = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ATIVIDADE",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the academia horarios where companyId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @return the matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_ATIVIDADE(long companyId,
		long atividadeId) throws SystemException {
		return findByC_ATIVIDADE(companyId, atividadeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academia horarios where companyId = &#63; and atividadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_ATIVIDADE(long companyId,
		long atividadeId, int start, int end) throws SystemException {
		return findByC_ATIVIDADE(companyId, atividadeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the academia horarios where companyId = &#63; and atividadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_ATIVIDADE(long companyId,
		long atividadeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_ATIVIDADE;
			finderArgs = new Object[] { companyId, atividadeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_ATIVIDADE;
			finderArgs = new Object[] {
					companyId, atividadeId,
					
					start, end, orderByComparator
				};
		}

		List<AcademiaHorario> list = (List<AcademiaHorario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AcademiaHorario academiaHorario : list) {
				if ((companyId != academiaHorario.getCompanyId()) ||
						(atividadeId != academiaHorario.getAtividadeId())) {
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

			query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

			query.append(_FINDER_COLUMN_C_ATIVIDADE_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_ATIVIDADE_ATIVIDADEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(atividadeId);

				if (!pagination) {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AcademiaHorario>(list);
				}
				else {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
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
	 * Returns the first academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByC_ATIVIDADE_First(long companyId,
		long atividadeId, OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByC_ATIVIDADE_First(companyId,
				atividadeId, orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", atividadeId=");
		msg.append(atividadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the first academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByC_ATIVIDADE_First(long companyId,
		long atividadeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AcademiaHorario> list = findByC_ATIVIDADE(companyId, atividadeId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByC_ATIVIDADE_Last(long companyId,
		long atividadeId, OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByC_ATIVIDADE_Last(companyId,
				atividadeId, orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", atividadeId=");
		msg.append(atividadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the last academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByC_ATIVIDADE_Last(long companyId,
		long atividadeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_ATIVIDADE(companyId, atividadeId);

		if (count == 0) {
			return null;
		}

		List<AcademiaHorario> list = findByC_ATIVIDADE(companyId, atividadeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the academia horarios before and after the current academia horario in the ordered set where companyId = &#63; and atividadeId = &#63;.
	 *
	 * @param academiaHorarioId the primary key of the current academia horario
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario[] findByC_ATIVIDADE_PrevAndNext(
		long academiaHorarioId, long companyId, long atividadeId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = findByPrimaryKey(academiaHorarioId);

		Session session = null;

		try {
			session = openSession();

			AcademiaHorario[] array = new AcademiaHorarioImpl[3];

			array[0] = getByC_ATIVIDADE_PrevAndNext(session, academiaHorario,
					companyId, atividadeId, orderByComparator, true);

			array[1] = academiaHorario;

			array[2] = getByC_ATIVIDADE_PrevAndNext(session, academiaHorario,
					companyId, atividadeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AcademiaHorario getByC_ATIVIDADE_PrevAndNext(Session session,
		AcademiaHorario academiaHorario, long companyId, long atividadeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

		query.append(_FINDER_COLUMN_C_ATIVIDADE_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_ATIVIDADE_ATIVIDADEID_2);

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
			query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(atividadeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(academiaHorario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AcademiaHorario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the academia horarios where companyId = &#63; and atividadeId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_ATIVIDADE(long companyId, long atividadeId)
		throws SystemException {
		for (AcademiaHorario academiaHorario : findByC_ATIVIDADE(companyId,
				atividadeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(academiaHorario);
		}
	}

	/**
	 * Returns the number of academia horarios where companyId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param atividadeId the atividade ID
	 * @return the number of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_ATIVIDADE(long companyId, long atividadeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_ATIVIDADE;

		Object[] finderArgs = new Object[] { companyId, atividadeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACADEMIAHORARIO_WHERE);

			query.append(_FINDER_COLUMN_C_ATIVIDADE_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_ATIVIDADE_ATIVIDADEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(atividadeId);

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

	private static final String _FINDER_COLUMN_C_ATIVIDADE_COMPANYID_2 = "academiaHorario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_ATIVIDADE_ATIVIDADEID_2 = "academiaHorario.atividadeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_ATIVIDADE =
		new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_G_ATIVIDADE",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_ATIVIDADE =
		new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_ATIVIDADE",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			AcademiaHorarioModelImpl.COMPANYID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.GROUPID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADEID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADENOME_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.DIASEMANA_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.HORAINICIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_ATIVIDADE = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_ATIVIDADE",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @return the matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_G_ATIVIDADE(long companyId,
		long groupId, long atividadeId) throws SystemException {
		return findByC_G_ATIVIDADE(companyId, groupId, atividadeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_G_ATIVIDADE(long companyId,
		long groupId, long atividadeId, int start, int end)
		throws SystemException {
		return findByC_G_ATIVIDADE(companyId, groupId, atividadeId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findByC_G_ATIVIDADE(long companyId,
		long groupId, long atividadeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_ATIVIDADE;
			finderArgs = new Object[] { companyId, groupId, atividadeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_ATIVIDADE;
			finderArgs = new Object[] {
					companyId, groupId, atividadeId,
					
					start, end, orderByComparator
				};
		}

		List<AcademiaHorario> list = (List<AcademiaHorario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AcademiaHorario academiaHorario : list) {
				if ((companyId != academiaHorario.getCompanyId()) ||
						(groupId != academiaHorario.getGroupId()) ||
						(atividadeId != academiaHorario.getAtividadeId())) {
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

			query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

			query.append(_FINDER_COLUMN_C_G_ATIVIDADE_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_ATIVIDADE_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_ATIVIDADE_ATIVIDADEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(atividadeId);

				if (!pagination) {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AcademiaHorario>(list);
				}
				else {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
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
	 * Returns the first academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByC_G_ATIVIDADE_First(long companyId,
		long groupId, long atividadeId, OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByC_G_ATIVIDADE_First(companyId,
				groupId, atividadeId, orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", atividadeId=");
		msg.append(atividadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the first academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByC_G_ATIVIDADE_First(long companyId,
		long groupId, long atividadeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AcademiaHorario> list = findByC_G_ATIVIDADE(companyId, groupId,
				atividadeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByC_G_ATIVIDADE_Last(long companyId,
		long groupId, long atividadeId, OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByC_G_ATIVIDADE_Last(companyId,
				groupId, atividadeId, orderByComparator);

		if (academiaHorario != null) {
			return academiaHorario;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", atividadeId=");
		msg.append(atividadeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAcademiaHorarioException(msg.toString());
	}

	/**
	 * Returns the last academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByC_G_ATIVIDADE_Last(long companyId,
		long groupId, long atividadeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_ATIVIDADE(companyId, groupId, atividadeId);

		if (count == 0) {
			return null;
		}

		List<AcademiaHorario> list = findByC_G_ATIVIDADE(companyId, groupId,
				atividadeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the academia horarios before and after the current academia horario in the ordered set where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param academiaHorarioId the primary key of the current academia horario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario[] findByC_G_ATIVIDADE_PrevAndNext(
		long academiaHorarioId, long companyId, long groupId, long atividadeId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = findByPrimaryKey(academiaHorarioId);

		Session session = null;

		try {
			session = openSession();

			AcademiaHorario[] array = new AcademiaHorarioImpl[3];

			array[0] = getByC_G_ATIVIDADE_PrevAndNext(session, academiaHorario,
					companyId, groupId, atividadeId, orderByComparator, true);

			array[1] = academiaHorario;

			array[2] = getByC_G_ATIVIDADE_PrevAndNext(session, academiaHorario,
					companyId, groupId, atividadeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AcademiaHorario getByC_G_ATIVIDADE_PrevAndNext(Session session,
		AcademiaHorario academiaHorario, long companyId, long groupId,
		long atividadeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_ATIVIDADEID_2);

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
			query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(atividadeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(academiaHorario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AcademiaHorario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @return the matching academia horarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> filterFindByC_G_ATIVIDADE(long companyId,
		long groupId, long atividadeId) throws SystemException {
		return filterFindByC_G_ATIVIDADE(companyId, groupId, atividadeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of matching academia horarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> filterFindByC_G_ATIVIDADE(long companyId,
		long groupId, long atividadeId, int start, int end)
		throws SystemException {
		return filterFindByC_G_ATIVIDADE(companyId, groupId, atividadeId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the academia horarios that the user has permissions to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching academia horarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> filterFindByC_G_ATIVIDADE(long companyId,
		long groupId, long atividadeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_ATIVIDADE(companyId, groupId, atividadeId, start,
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
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_ATIVIDADEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AcademiaHorarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AcademiaHorario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AcademiaHorarioImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AcademiaHorarioImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(atividadeId);

			return (List<AcademiaHorario>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the academia horarios before and after the current academia horario in the ordered set of academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param academiaHorarioId the primary key of the current academia horario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario[] filterFindByC_G_ATIVIDADE_PrevAndNext(
		long academiaHorarioId, long companyId, long groupId, long atividadeId,
		OrderByComparator orderByComparator)
		throws NoSuchAcademiaHorarioException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_ATIVIDADE_PrevAndNext(academiaHorarioId,
				companyId, groupId, atividadeId, orderByComparator);
		}

		AcademiaHorario academiaHorario = findByPrimaryKey(academiaHorarioId);

		Session session = null;

		try {
			session = openSession();

			AcademiaHorario[] array = new AcademiaHorarioImpl[3];

			array[0] = filterGetByC_G_ATIVIDADE_PrevAndNext(session,
					academiaHorario, companyId, groupId, atividadeId,
					orderByComparator, true);

			array[1] = academiaHorario;

			array[2] = filterGetByC_G_ATIVIDADE_PrevAndNext(session,
					academiaHorario, companyId, groupId, atividadeId,
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

	protected AcademiaHorario filterGetByC_G_ATIVIDADE_PrevAndNext(
		Session session, AcademiaHorario academiaHorario, long companyId,
		long groupId, long atividadeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_ATIVIDADEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(AcademiaHorarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AcademiaHorario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AcademiaHorarioImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AcademiaHorarioImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(atividadeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(academiaHorario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AcademiaHorario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_ATIVIDADE(long companyId, long groupId,
		long atividadeId) throws SystemException {
		for (AcademiaHorario academiaHorario : findByC_G_ATIVIDADE(companyId,
				groupId, atividadeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(academiaHorario);
		}
	}

	/**
	 * Returns the number of academia horarios where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @return the number of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_ATIVIDADE(long companyId, long groupId,
		long atividadeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_ATIVIDADE;

		Object[] finderArgs = new Object[] { companyId, groupId, atividadeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ACADEMIAHORARIO_WHERE);

			query.append(_FINDER_COLUMN_C_G_ATIVIDADE_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_ATIVIDADE_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_ATIVIDADE_ATIVIDADEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(atividadeId);

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
	 * Returns the number of academia horarios that the user has permission to view where companyId = &#63; and groupId = &#63; and atividadeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param atividadeId the atividade ID
	 * @return the number of matching academia horarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G_ATIVIDADE(long companyId, long groupId,
		long atividadeId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G_ATIVIDADE(companyId, groupId, atividadeId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_ACADEMIAHORARIO_WHERE);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_ATIVIDADE_ATIVIDADEID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AcademiaHorario.class.getName(),
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

			qPos.add(atividadeId);

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

	private static final String _FINDER_COLUMN_C_G_ATIVIDADE_COMPANYID_2 = "academiaHorario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_ATIVIDADE_GROUPID_2 = "academiaHorario.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_ATIVIDADE_ATIVIDADEID_2 = "academiaHorario.atividadeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_D_A_HI = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED,
			AcademiaHorarioImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_G_D_A_HI",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			AcademiaHorarioModelImpl.COMPANYID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.GROUPID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.DIASEMANA_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.ATIVIDADEID_COLUMN_BITMASK |
			AcademiaHorarioModelImpl.HORAINICIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_D_A_HI = new FinderPath(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_D_A_HI",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the academia horario where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63; or throws a {@link br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param diaSemana the dia semana
	 * @param atividadeId the atividade ID
	 * @param horaInicial the hora inicial
	 * @return the matching academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByC_G_D_A_HI(long companyId, long groupId,
		int diaSemana, long atividadeId, String horaInicial)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByC_G_D_A_HI(companyId, groupId,
				diaSemana, atividadeId, horaInicial);

		if (academiaHorario == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", diaSemana=");
			msg.append(diaSemana);

			msg.append(", atividadeId=");
			msg.append(atividadeId);

			msg.append(", horaInicial=");
			msg.append(horaInicial);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAcademiaHorarioException(msg.toString());
		}

		return academiaHorario;
	}

	/**
	 * Returns the academia horario where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param diaSemana the dia semana
	 * @param atividadeId the atividade ID
	 * @param horaInicial the hora inicial
	 * @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByC_G_D_A_HI(long companyId, long groupId,
		int diaSemana, long atividadeId, String horaInicial)
		throws SystemException {
		return fetchByC_G_D_A_HI(companyId, groupId, diaSemana, atividadeId,
			horaInicial, true);
	}

	/**
	 * Returns the academia horario where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param diaSemana the dia semana
	 * @param atividadeId the atividade ID
	 * @param horaInicial the hora inicial
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching academia horario, or <code>null</code> if a matching academia horario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByC_G_D_A_HI(long companyId, long groupId,
		int diaSemana, long atividadeId, String horaInicial,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, diaSemana, atividadeId, horaInicial
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI,
					finderArgs, this);
		}

		if (result instanceof AcademiaHorario) {
			AcademiaHorario academiaHorario = (AcademiaHorario)result;

			if ((companyId != academiaHorario.getCompanyId()) ||
					(groupId != academiaHorario.getGroupId()) ||
					(diaSemana != academiaHorario.getDiaSemana()) ||
					(atividadeId != academiaHorario.getAtividadeId()) ||
					!Validator.equals(horaInicial,
						academiaHorario.getHoraInicial())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_ACADEMIAHORARIO_WHERE);

			query.append(_FINDER_COLUMN_C_G_D_A_HI_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_D_A_HI_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_D_A_HI_DIASEMANA_2);

			query.append(_FINDER_COLUMN_C_G_D_A_HI_ATIVIDADEID_2);

			boolean bindHoraInicial = false;

			if (horaInicial == null) {
				query.append(_FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_1);
			}
			else if (horaInicial.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_3);
			}
			else {
				bindHoraInicial = true;

				query.append(_FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(diaSemana);

				qPos.add(atividadeId);

				if (bindHoraInicial) {
					qPos.add(horaInicial);
				}

				List<AcademiaHorario> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI,
						finderArgs, list);
				}
				else {
					AcademiaHorario academiaHorario = list.get(0);

					result = academiaHorario;

					cacheResult(academiaHorario);

					if ((academiaHorario.getCompanyId() != companyId) ||
							(academiaHorario.getGroupId() != groupId) ||
							(academiaHorario.getDiaSemana() != diaSemana) ||
							(academiaHorario.getAtividadeId() != atividadeId) ||
							(academiaHorario.getHoraInicial() == null) ||
							!academiaHorario.getHoraInicial().equals(horaInicial)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI,
							finderArgs, academiaHorario);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI,
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
			return (AcademiaHorario)result;
		}
	}

	/**
	 * Removes the academia horario where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param diaSemana the dia semana
	 * @param atividadeId the atividade ID
	 * @param horaInicial the hora inicial
	 * @return the academia horario that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario removeByC_G_D_A_HI(long companyId, long groupId,
		int diaSemana, long atividadeId, String horaInicial)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = findByC_G_D_A_HI(companyId, groupId,
				diaSemana, atividadeId, horaInicial);

		return remove(academiaHorario);
	}

	/**
	 * Returns the number of academia horarios where companyId = &#63; and groupId = &#63; and diaSemana = &#63; and atividadeId = &#63; and horaInicial = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param diaSemana the dia semana
	 * @param atividadeId the atividade ID
	 * @param horaInicial the hora inicial
	 * @return the number of matching academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_D_A_HI(long companyId, long groupId, int diaSemana,
		long atividadeId, String horaInicial) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_D_A_HI;

		Object[] finderArgs = new Object[] {
				companyId, groupId, diaSemana, atividadeId, horaInicial
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_ACADEMIAHORARIO_WHERE);

			query.append(_FINDER_COLUMN_C_G_D_A_HI_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_D_A_HI_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_D_A_HI_DIASEMANA_2);

			query.append(_FINDER_COLUMN_C_G_D_A_HI_ATIVIDADEID_2);

			boolean bindHoraInicial = false;

			if (horaInicial == null) {
				query.append(_FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_1);
			}
			else if (horaInicial.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_3);
			}
			else {
				bindHoraInicial = true;

				query.append(_FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(diaSemana);

				qPos.add(atividadeId);

				if (bindHoraInicial) {
					qPos.add(horaInicial);
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

	private static final String _FINDER_COLUMN_C_G_D_A_HI_COMPANYID_2 = "academiaHorario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_D_A_HI_GROUPID_2 = "academiaHorario.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_D_A_HI_DIASEMANA_2 = "academiaHorario.diaSemana = ? AND ";
	private static final String _FINDER_COLUMN_C_G_D_A_HI_ATIVIDADEID_2 = "academiaHorario.atividadeId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_1 = "academiaHorario.horaInicial IS NULL";
	private static final String _FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_2 = "academiaHorario.horaInicial = ?";
	private static final String _FINDER_COLUMN_C_G_D_A_HI_HORAINICIAL_3 = "(academiaHorario.horaInicial IS NULL OR academiaHorario.horaInicial = '')";

	public AcademiaHorarioPersistenceImpl() {
		setModelClass(AcademiaHorario.class);
	}

	/**
	 * Caches the academia horario in the entity cache if it is enabled.
	 *
	 * @param academiaHorario the academia horario
	 */
	@Override
	public void cacheResult(AcademiaHorario academiaHorario) {
		EntityCacheUtil.putResult(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioImpl.class, academiaHorario.getPrimaryKey(),
			academiaHorario);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { academiaHorario.getUuid(), academiaHorario.getGroupId() },
			academiaHorario);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI,
			new Object[] {
				academiaHorario.getCompanyId(), academiaHorario.getGroupId(),
				academiaHorario.getDiaSemana(), academiaHorario.getAtividadeId(),
				academiaHorario.getHoraInicial()
			}, academiaHorario);

		academiaHorario.resetOriginalValues();
	}

	/**
	 * Caches the academia horarios in the entity cache if it is enabled.
	 *
	 * @param academiaHorarios the academia horarios
	 */
	@Override
	public void cacheResult(List<AcademiaHorario> academiaHorarios) {
		for (AcademiaHorario academiaHorario : academiaHorarios) {
			if (EntityCacheUtil.getResult(
						AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
						AcademiaHorarioImpl.class,
						academiaHorario.getPrimaryKey()) == null) {
				cacheResult(academiaHorario);
			}
			else {
				academiaHorario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all academia horarios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AcademiaHorarioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AcademiaHorarioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the academia horario.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AcademiaHorario academiaHorario) {
		EntityCacheUtil.removeResult(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioImpl.class, academiaHorario.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(academiaHorario);
	}

	@Override
	public void clearCache(List<AcademiaHorario> academiaHorarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AcademiaHorario academiaHorario : academiaHorarios) {
			EntityCacheUtil.removeResult(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
				AcademiaHorarioImpl.class, academiaHorario.getPrimaryKey());

			clearUniqueFindersCache(academiaHorario);
		}
	}

	protected void cacheUniqueFindersCache(AcademiaHorario academiaHorario) {
		if (academiaHorario.isNew()) {
			Object[] args = new Object[] {
					academiaHorario.getUuid(), academiaHorario.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				academiaHorario);

			args = new Object[] {
					academiaHorario.getCompanyId(), academiaHorario.getGroupId(),
					academiaHorario.getDiaSemana(),
					academiaHorario.getAtividadeId(),
					academiaHorario.getHoraInicial()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_D_A_HI, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI, args,
				academiaHorario);
		}
		else {
			AcademiaHorarioModelImpl academiaHorarioModelImpl = (AcademiaHorarioModelImpl)academiaHorario;

			if ((academiaHorarioModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						academiaHorario.getUuid(), academiaHorario.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					academiaHorario);
			}

			if ((academiaHorarioModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_D_A_HI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						academiaHorario.getCompanyId(),
						academiaHorario.getGroupId(),
						academiaHorario.getDiaSemana(),
						academiaHorario.getAtividadeId(),
						academiaHorario.getHoraInicial()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_D_A_HI,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI,
					args, academiaHorario);
			}
		}
	}

	protected void clearUniqueFindersCache(AcademiaHorario academiaHorario) {
		AcademiaHorarioModelImpl academiaHorarioModelImpl = (AcademiaHorarioModelImpl)academiaHorario;

		Object[] args = new Object[] {
				academiaHorario.getUuid(), academiaHorario.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((academiaHorarioModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					academiaHorarioModelImpl.getOriginalUuid(),
					academiaHorarioModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				academiaHorario.getCompanyId(), academiaHorario.getGroupId(),
				academiaHorario.getDiaSemana(), academiaHorario.getAtividadeId(),
				academiaHorario.getHoraInicial()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_D_A_HI, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI, args);

		if ((academiaHorarioModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_D_A_HI.getColumnBitmask()) != 0) {
			args = new Object[] {
					academiaHorarioModelImpl.getOriginalCompanyId(),
					academiaHorarioModelImpl.getOriginalGroupId(),
					academiaHorarioModelImpl.getOriginalDiaSemana(),
					academiaHorarioModelImpl.getOriginalAtividadeId(),
					academiaHorarioModelImpl.getOriginalHoraInicial()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_D_A_HI, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_D_A_HI, args);
		}
	}

	/**
	 * Creates a new academia horario with the primary key. Does not add the academia horario to the database.
	 *
	 * @param academiaHorarioId the primary key for the new academia horario
	 * @return the new academia horario
	 */
	@Override
	public AcademiaHorario create(long academiaHorarioId) {
		AcademiaHorario academiaHorario = new AcademiaHorarioImpl();

		academiaHorario.setNew(true);
		academiaHorario.setPrimaryKey(academiaHorarioId);

		String uuid = PortalUUIDUtil.generate();

		academiaHorario.setUuid(uuid);

		return academiaHorario;
	}

	/**
	 * Removes the academia horario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param academiaHorarioId the primary key of the academia horario
	 * @return the academia horario that was removed
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario remove(long academiaHorarioId)
		throws NoSuchAcademiaHorarioException, SystemException {
		return remove((Serializable)academiaHorarioId);
	}

	/**
	 * Removes the academia horario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the academia horario
	 * @return the academia horario that was removed
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario remove(Serializable primaryKey)
		throws NoSuchAcademiaHorarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AcademiaHorario academiaHorario = (AcademiaHorario)session.get(AcademiaHorarioImpl.class,
					primaryKey);

			if (academiaHorario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAcademiaHorarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(academiaHorario);
		}
		catch (NoSuchAcademiaHorarioException nsee) {
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
	protected AcademiaHorario removeImpl(AcademiaHorario academiaHorario)
		throws SystemException {
		academiaHorario = toUnwrappedModel(academiaHorario);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(academiaHorario)) {
				academiaHorario = (AcademiaHorario)session.get(AcademiaHorarioImpl.class,
						academiaHorario.getPrimaryKeyObj());
			}

			if (academiaHorario != null) {
				session.delete(academiaHorario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (academiaHorario != null) {
			clearCache(academiaHorario);
		}

		return academiaHorario;
	}

	@Override
	public AcademiaHorario updateImpl(
		br.com.prodevelopment.academiahorario.model.AcademiaHorario academiaHorario)
		throws SystemException {
		academiaHorario = toUnwrappedModel(academiaHorario);

		boolean isNew = academiaHorario.isNew();

		AcademiaHorarioModelImpl academiaHorarioModelImpl = (AcademiaHorarioModelImpl)academiaHorario;

		if (Validator.isNull(academiaHorario.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			academiaHorario.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (academiaHorario.isNew()) {
				session.save(academiaHorario);

				academiaHorario.setNew(false);
			}
			else {
				session.merge(academiaHorario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AcademiaHorarioModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((academiaHorarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						academiaHorarioModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { academiaHorarioModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((academiaHorarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						academiaHorarioModelImpl.getOriginalUuid(),
						academiaHorarioModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						academiaHorarioModelImpl.getUuid(),
						academiaHorarioModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((academiaHorarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						academiaHorarioModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { academiaHorarioModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((academiaHorarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						academiaHorarioModelImpl.getOriginalCompanyId(),
						academiaHorarioModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						academiaHorarioModelImpl.getCompanyId(),
						academiaHorarioModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((academiaHorarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_ATIVIDADE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						academiaHorarioModelImpl.getOriginalCompanyId(),
						academiaHorarioModelImpl.getOriginalAtividadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_ATIVIDADE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_ATIVIDADE,
					args);

				args = new Object[] {
						academiaHorarioModelImpl.getCompanyId(),
						academiaHorarioModelImpl.getAtividadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_ATIVIDADE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_ATIVIDADE,
					args);
			}

			if ((academiaHorarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_ATIVIDADE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						academiaHorarioModelImpl.getOriginalCompanyId(),
						academiaHorarioModelImpl.getOriginalGroupId(),
						academiaHorarioModelImpl.getOriginalAtividadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_ATIVIDADE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_ATIVIDADE,
					args);

				args = new Object[] {
						academiaHorarioModelImpl.getCompanyId(),
						academiaHorarioModelImpl.getGroupId(),
						academiaHorarioModelImpl.getAtividadeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_ATIVIDADE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_ATIVIDADE,
					args);
			}
		}

		EntityCacheUtil.putResult(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
			AcademiaHorarioImpl.class, academiaHorario.getPrimaryKey(),
			academiaHorario);

		clearUniqueFindersCache(academiaHorario);
		cacheUniqueFindersCache(academiaHorario);

		return academiaHorario;
	}

	protected AcademiaHorario toUnwrappedModel(AcademiaHorario academiaHorario) {
		if (academiaHorario instanceof AcademiaHorarioImpl) {
			return academiaHorario;
		}

		AcademiaHorarioImpl academiaHorarioImpl = new AcademiaHorarioImpl();

		academiaHorarioImpl.setNew(academiaHorario.isNew());
		academiaHorarioImpl.setPrimaryKey(academiaHorario.getPrimaryKey());

		academiaHorarioImpl.setUuid(academiaHorario.getUuid());
		academiaHorarioImpl.setAcademiaHorarioId(academiaHorario.getAcademiaHorarioId());
		academiaHorarioImpl.setCompanyId(academiaHorario.getCompanyId());
		academiaHorarioImpl.setGroupId(academiaHorario.getGroupId());
		academiaHorarioImpl.setCreateUserId(academiaHorario.getCreateUserId());
		academiaHorarioImpl.setModifiedUserId(academiaHorario.getModifiedUserId());
		academiaHorarioImpl.setCreateDate(academiaHorario.getCreateDate());
		academiaHorarioImpl.setModifiedDate(academiaHorario.getModifiedDate());
		academiaHorarioImpl.setDiaSemana(academiaHorario.getDiaSemana());
		academiaHorarioImpl.setHoraInicial(academiaHorario.getHoraInicial());
		academiaHorarioImpl.setHoraFinal(academiaHorario.getHoraFinal());
		academiaHorarioImpl.setAtividadeId(academiaHorario.getAtividadeId());
		academiaHorarioImpl.setAtividadeNome(academiaHorario.getAtividadeNome());
		academiaHorarioImpl.setVersao(academiaHorario.getVersao());

		return academiaHorarioImpl;
	}

	/**
	 * Returns the academia horario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the academia horario
	 * @return the academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAcademiaHorarioException, SystemException {
		AcademiaHorario academiaHorario = fetchByPrimaryKey(primaryKey);

		if (academiaHorario == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAcademiaHorarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return academiaHorario;
	}

	/**
	 * Returns the academia horario with the primary key or throws a {@link br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException} if it could not be found.
	 *
	 * @param academiaHorarioId the primary key of the academia horario
	 * @return the academia horario
	 * @throws br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario findByPrimaryKey(long academiaHorarioId)
		throws NoSuchAcademiaHorarioException, SystemException {
		return findByPrimaryKey((Serializable)academiaHorarioId);
	}

	/**
	 * Returns the academia horario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the academia horario
	 * @return the academia horario, or <code>null</code> if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AcademiaHorario academiaHorario = (AcademiaHorario)EntityCacheUtil.getResult(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
				AcademiaHorarioImpl.class, primaryKey);

		if (academiaHorario == _nullAcademiaHorario) {
			return null;
		}

		if (academiaHorario == null) {
			Session session = null;

			try {
				session = openSession();

				academiaHorario = (AcademiaHorario)session.get(AcademiaHorarioImpl.class,
						primaryKey);

				if (academiaHorario != null) {
					cacheResult(academiaHorario);
				}
				else {
					EntityCacheUtil.putResult(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
						AcademiaHorarioImpl.class, primaryKey,
						_nullAcademiaHorario);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AcademiaHorarioModelImpl.ENTITY_CACHE_ENABLED,
					AcademiaHorarioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return academiaHorario;
	}

	/**
	 * Returns the academia horario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param academiaHorarioId the primary key of the academia horario
	 * @return the academia horario, or <code>null</code> if a academia horario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AcademiaHorario fetchByPrimaryKey(long academiaHorarioId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)academiaHorarioId);
	}

	/**
	 * Returns all the academia horarios.
	 *
	 * @return the academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the academia horarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @return the range of academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the academia horarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.academiahorario.model.impl.AcademiaHorarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of academia horarios
	 * @param end the upper bound of the range of academia horarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of academia horarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AcademiaHorario> findAll(int start, int end,
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

		List<AcademiaHorario> list = (List<AcademiaHorario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ACADEMIAHORARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACADEMIAHORARIO;

				if (pagination) {
					sql = sql.concat(AcademiaHorarioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AcademiaHorario>(list);
				}
				else {
					list = (List<AcademiaHorario>)QueryUtil.list(q,
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
	 * Removes all the academia horarios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AcademiaHorario academiaHorario : findAll()) {
			remove(academiaHorario);
		}
	}

	/**
	 * Returns the number of academia horarios.
	 *
	 * @return the number of academia horarios
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

				Query q = session.createQuery(_SQL_COUNT_ACADEMIAHORARIO);

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
	 * Initializes the academia horario persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.academiahorario.model.AcademiaHorario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AcademiaHorario>> listenersList = new ArrayList<ModelListener<AcademiaHorario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AcademiaHorario>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AcademiaHorarioImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ACADEMIAHORARIO = "SELECT academiaHorario FROM AcademiaHorario academiaHorario";
	private static final String _SQL_SELECT_ACADEMIAHORARIO_WHERE = "SELECT academiaHorario FROM AcademiaHorario academiaHorario WHERE ";
	private static final String _SQL_COUNT_ACADEMIAHORARIO = "SELECT COUNT(academiaHorario) FROM AcademiaHorario academiaHorario";
	private static final String _SQL_COUNT_ACADEMIAHORARIO_WHERE = "SELECT COUNT(academiaHorario) FROM AcademiaHorario academiaHorario WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "academiaHorario.academiaHorarioId";
	private static final String _FILTER_SQL_SELECT_ACADEMIAHORARIO_WHERE = "SELECT DISTINCT {academiaHorario.*} FROM AcademiaHorario academiaHorario WHERE ";
	private static final String _FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {AcademiaHorario.*} FROM (SELECT DISTINCT academiaHorario.academiaHorarioId FROM AcademiaHorario academiaHorario WHERE ";
	private static final String _FILTER_SQL_SELECT_ACADEMIAHORARIO_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN AcademiaHorario ON TEMP_TABLE.academiaHorarioId = AcademiaHorario.academiaHorarioId";
	private static final String _FILTER_SQL_COUNT_ACADEMIAHORARIO_WHERE = "SELECT COUNT(DISTINCT academiaHorario.academiaHorarioId) AS COUNT_VALUE FROM AcademiaHorario academiaHorario WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "academiaHorario";
	private static final String _FILTER_ENTITY_TABLE = "AcademiaHorario";
	private static final String _ORDER_BY_ENTITY_ALIAS = "academiaHorario.";
	private static final String _ORDER_BY_ENTITY_TABLE = "AcademiaHorario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AcademiaHorario exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AcademiaHorario exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AcademiaHorarioPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static AcademiaHorario _nullAcademiaHorario = new AcademiaHorarioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AcademiaHorario> toCacheModel() {
				return _nullAcademiaHorarioCacheModel;
			}
		};

	private static CacheModel<AcademiaHorario> _nullAcademiaHorarioCacheModel = new CacheModel<AcademiaHorario>() {
			@Override
			public AcademiaHorario toEntityModel() {
				return _nullAcademiaHorario;
			}
		};
}