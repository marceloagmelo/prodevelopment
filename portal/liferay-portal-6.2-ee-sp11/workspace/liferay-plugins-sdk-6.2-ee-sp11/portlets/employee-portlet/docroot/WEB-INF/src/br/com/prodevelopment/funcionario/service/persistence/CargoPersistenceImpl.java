/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.prodevelopment.funcionario.service.persistence;

import br.com.prodevelopment.funcionario.NoSuchCargoException;
import br.com.prodevelopment.funcionario.model.Cargo;
import br.com.prodevelopment.funcionario.model.impl.CargoImpl;
import br.com.prodevelopment.funcionario.model.impl.CargoModelImpl;

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
 * The persistence implementation for the cargo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see CargoPersistence
 * @see CargoUtil
 * @generated
 */
public class CargoPersistenceImpl extends BasePersistenceImpl<Cargo>
	implements CargoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CargoUtil} to access the cargo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CargoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CargoModelImpl.UUID_COLUMN_BITMASK |
			CargoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the cargos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByUuid(String uuid, int start, int end,
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

		List<Cargo> list = (List<Cargo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cargo cargo : list) {
				if (!Validator.equals(uuid, cargo.getUuid())) {
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

			query.append(_SQL_SELECT_CARGO_WHERE);

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
				query.append(CargoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cargo>(list);
				}
				else {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first cargo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByUuid_First(uuid, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the first cargo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cargo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cargo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByUuid_Last(uuid, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the last cargo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Cargo> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cargos before and after the current cargo in the ordered set where uuid = &#63;.
	 *
	 * @param cargoId the primary key of the current cargo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo[] findByUuid_PrevAndNext(long cargoId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = findByPrimaryKey(cargoId);

		Session session = null;

		try {
			session = openSession();

			Cargo[] array = new CargoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, cargo, uuid,
					orderByComparator, true);

			array[1] = cargo;

			array[2] = getByUuid_PrevAndNext(session, cargo, uuid,
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

	protected Cargo getByUuid_PrevAndNext(Session session, Cargo cargo,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CARGO_WHERE);

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
			query.append(CargoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(cargo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cargo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cargos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Cargo cargo : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cargo);
		}
	}

	/**
	 * Returns the number of cargos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cargos
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

			query.append(_SQL_COUNT_CARGO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "cargo.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "cargo.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(cargo.uuid IS NULL OR cargo.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			CargoModelImpl.UUID_COLUMN_BITMASK |
			CargoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the cargo where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchCargoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByUUID_G(String uuid, long groupId)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByUUID_G(uuid, groupId);

		if (cargo == null) {
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

			throw new NoSuchCargoException(msg.toString());
		}

		return cargo;
	}

	/**
	 * Returns the cargo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the cargo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Cargo) {
			Cargo cargo = (Cargo)result;

			if (!Validator.equals(uuid, cargo.getUuid()) ||
					(groupId != cargo.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CARGO_WHERE);

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

				List<Cargo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Cargo cargo = list.get(0);

					result = cargo;

					cacheResult(cargo);

					if ((cargo.getUuid() == null) ||
							!cargo.getUuid().equals(uuid) ||
							(cargo.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, cargo);
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
			return (Cargo)result;
		}
	}

	/**
	 * Removes the cargo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cargo that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo removeByUUID_G(String uuid, long groupId)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = findByUUID_G(uuid, groupId);

		return remove(cargo);
	}

	/**
	 * Returns the number of cargos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cargos
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

			query.append(_SQL_COUNT_CARGO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "cargo.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "cargo.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(cargo.uuid IS NULL OR cargo.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "cargo.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			CargoModelImpl.UUID_COLUMN_BITMASK |
			CargoModelImpl.COMPANYID_COLUMN_BITMASK |
			CargoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the cargos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByUuid_C(String uuid, long companyId, int start,
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

		List<Cargo> list = (List<Cargo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cargo cargo : list) {
				if (!Validator.equals(uuid, cargo.getUuid()) ||
						(companyId != cargo.getCompanyId())) {
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

			query.append(_SQL_SELECT_CARGO_WHERE);

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
				query.append(CargoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cargo>(list);
				}
				else {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the first cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cargo> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the last cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Cargo> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cargos before and after the current cargo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cargoId the primary key of the current cargo
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo[] findByUuid_C_PrevAndNext(long cargoId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = findByPrimaryKey(cargoId);

		Session session = null;

		try {
			session = openSession();

			Cargo[] array = new CargoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, cargo, uuid, companyId,
					orderByComparator, true);

			array[1] = cargo;

			array[2] = getByUuid_C_PrevAndNext(session, cargo, uuid, companyId,
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

	protected Cargo getByUuid_C_PrevAndNext(Session session, Cargo cargo,
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

		query.append(_SQL_SELECT_CARGO_WHERE);

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
			query.append(CargoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(cargo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cargo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cargos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Cargo cargo : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cargo);
		}
	}

	/**
	 * Returns the number of cargos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cargos
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

			query.append(_SQL_COUNT_CARGO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "cargo.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "cargo.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(cargo.uuid IS NULL OR cargo.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "cargo.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CargoModelImpl.COMPANYID_COLUMN_BITMASK |
			CargoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cargos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByCompany(long companyId) throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the cargos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByCompany(long companyId, int start, int end,
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

		List<Cargo> list = (List<Cargo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cargo cargo : list) {
				if ((companyId != cargo.getCompanyId())) {
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

			query.append(_SQL_SELECT_CARGO_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CargoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cargo>(list);
				}
				else {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first cargo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByCompany_First(companyId, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the first cargo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cargo> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cargo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByCompany_Last(companyId, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the last cargo in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Cargo> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cargos before and after the current cargo in the ordered set where companyId = &#63;.
	 *
	 * @param cargoId the primary key of the current cargo
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo[] findByCompany_PrevAndNext(long cargoId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = findByPrimaryKey(cargoId);

		Session session = null;

		try {
			session = openSession();

			Cargo[] array = new CargoImpl[3];

			array[0] = getByCompany_PrevAndNext(session, cargo, companyId,
					orderByComparator, true);

			array[1] = cargo;

			array[2] = getByCompany_PrevAndNext(session, cargo, companyId,
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

	protected Cargo getByCompany_PrevAndNext(Session session, Cargo cargo,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CARGO_WHERE);

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
			query.append(CargoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cargo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cargo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cargos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Cargo cargo : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cargo);
		}
	}

	/**
	 * Returns the number of cargos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching cargos
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

			query.append(_SQL_COUNT_CARGO_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "cargo.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			CargoModelImpl.COMPANYID_COLUMN_BITMASK |
			CargoModelImpl.GROUPID_COLUMN_BITMASK |
			CargoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the cargos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_G(long companyId, long groupId, int start,
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

		List<Cargo> list = (List<Cargo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cargo cargo : list) {
				if ((companyId != cargo.getCompanyId()) ||
						(groupId != cargo.getGroupId())) {
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

			query.append(_SQL_SELECT_CARGO_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CargoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cargo>(list);
				}
				else {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByC_G_First(companyId, groupId, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cargo> list = findByC_G(companyId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByC_G_Last(companyId, groupId, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Cargo> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cargos before and after the current cargo in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param cargoId the primary key of the current cargo
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo[] findByC_G_PrevAndNext(long cargoId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = findByPrimaryKey(cargoId);

		Session session = null;

		try {
			session = openSession();

			Cargo[] array = new CargoImpl[3];

			array[0] = getByC_G_PrevAndNext(session, cargo, companyId, groupId,
					orderByComparator, true);

			array[1] = cargo;

			array[2] = getByC_G_PrevAndNext(session, cargo, companyId, groupId,
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

	protected Cargo getByC_G_PrevAndNext(Session session, Cargo cargo,
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

		query.append(_SQL_SELECT_CARGO_WHERE);

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
			query.append(CargoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cargo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cargo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching cargos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of matching cargos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> filterFindByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cargos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> filterFindByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_CARGO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CargoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CargoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cargo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CargoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CargoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<Cargo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the cargos before and after the current cargo in the ordered set of cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param cargoId the primary key of the current cargo
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo[] filterFindByC_G_PrevAndNext(long cargoId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(cargoId, companyId, groupId,
				orderByComparator);
		}

		Cargo cargo = findByPrimaryKey(cargoId);

		Session session = null;

		try {
			session = openSession();

			Cargo[] array = new CargoImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, cargo, companyId,
					groupId, orderByComparator, true);

			array[1] = cargo;

			array[2] = filterGetByC_G_PrevAndNext(session, cargo, companyId,
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

	protected Cargo filterGetByC_G_PrevAndNext(Session session, Cargo cargo,
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

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CARGO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CargoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CargoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cargo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CargoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CargoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cargo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cargo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cargos where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (Cargo cargo : findByC_G(companyId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cargo);
		}
	}

	/**
	 * Returns the number of cargos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching cargos
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

			query.append(_SQL_COUNT_CARGO_WHERE);

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
	 * Returns the number of cargos that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching cargos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CARGO_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cargo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
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

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "cargo.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "cargo.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_NOME",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOME = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NOME",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the cargos where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_NOME(long companyId, String nome)
		throws SystemException {
		return findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_NOME(long companyId, String nome, int start,
		int end) throws SystemException {
		return findByC_NOME(companyId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_NOME(long companyId, String nome, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME;
		finderArgs = new Object[] { companyId, nome, start, end, orderByComparator };

		List<Cargo> list = (List<Cargo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cargo cargo : list) {
				if ((companyId != cargo.getCompanyId()) ||
						!StringUtil.wildcardMatches(cargo.getNome(), nome,
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

			query.append(_SQL_SELECT_CARGO_WHERE);

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
				query.append(CargoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cargo>(list);
				}
				else {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByC_NOME_First(companyId, nome, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the first cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cargo> list = findByC_NOME(companyId, nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByC_NOME_Last(companyId, nome, orderByComparator);

		if (cargo != null) {
			return cargo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the last cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_NOME(companyId, nome);

		if (count == 0) {
			return null;
		}

		List<Cargo> list = findByC_NOME(companyId, nome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cargos before and after the current cargo in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param cargoId the primary key of the current cargo
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo[] findByC_NOME_PrevAndNext(long cargoId, long companyId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = findByPrimaryKey(cargoId);

		Session session = null;

		try {
			session = openSession();

			Cargo[] array = new CargoImpl[3];

			array[0] = getByC_NOME_PrevAndNext(session, cargo, companyId, nome,
					orderByComparator, true);

			array[1] = cargo;

			array[2] = getByC_NOME_PrevAndNext(session, cargo, companyId, nome,
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

	protected Cargo getByC_NOME_PrevAndNext(Session session, Cargo cargo,
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

		query.append(_SQL_SELECT_CARGO_WHERE);

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
			query.append(CargoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(cargo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cargo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cargos where companyId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_NOME(long companyId, String nome)
		throws SystemException {
		for (Cargo cargo : findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cargo);
		}
	}

	/**
	 * Returns the number of cargos where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the number of matching cargos
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

			query.append(_SQL_COUNT_CARGO_WHERE);

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

	private static final String _FINDER_COLUMN_C_NOME_COMPANYID_2 = "cargo.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_NOME_NOME_1 = "cargo.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_NOME_NOME_2 = "cargo.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_NOME_NOME_3 = "(cargo.nome IS NULL OR cargo.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_NOME = new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, CargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_NOME =
		new FinderPath(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findByC_G_NOME(long companyId, long groupId,
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

		List<Cargo> list = (List<Cargo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cargo cargo : list) {
				if ((companyId != cargo.getCompanyId()) ||
						(groupId != cargo.getGroupId()) ||
						!StringUtil.wildcardMatches(cargo.getNome(), nome,
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

			query.append(_SQL_SELECT_CARGO_WHERE);

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
				query.append(CargoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cargo>(list);
				}
				else {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByC_G_NOME_First(companyId, groupId, nome,
				orderByComparator);

		if (cargo != null) {
			return cargo;
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

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the first cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		List<Cargo> list = findByC_G_NOME(companyId, groupId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByC_G_NOME_Last(long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByC_G_NOME_Last(companyId, groupId, nome,
				orderByComparator);

		if (cargo != null) {
			return cargo;
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

		throw new NoSuchCargoException(msg.toString());
	}

	/**
	 * Returns the last cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cargo, or <code>null</code> if a matching cargo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_NOME(companyId, groupId, nome);

		if (count == 0) {
			return null;
		}

		List<Cargo> list = findByC_G_NOME(companyId, groupId, nome, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cargos before and after the current cargo in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param cargoId the primary key of the current cargo
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo[] findByC_G_NOME_PrevAndNext(long cargoId, long companyId,
		long groupId, String nome, OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = findByPrimaryKey(cargoId);

		Session session = null;

		try {
			session = openSession();

			Cargo[] array = new CargoImpl[3];

			array[0] = getByC_G_NOME_PrevAndNext(session, cargo, companyId,
					groupId, nome, orderByComparator, true);

			array[1] = cargo;

			array[2] = getByC_G_NOME_PrevAndNext(session, cargo, companyId,
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

	protected Cargo getByC_G_NOME_PrevAndNext(Session session, Cargo cargo,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CARGO_WHERE);

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
			query.append(CargoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(cargo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cargo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching cargos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> filterFindByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of matching cargos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> filterFindByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cargos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> filterFindByC_G_NOME(long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CARGO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_1);
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
			query.append(_FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CargoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CargoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cargo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CargoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CargoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindNome) {
				qPos.add(nome);
			}

			return (List<Cargo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the cargos before and after the current cargo in the ordered set of cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param cargoId the primary key of the current cargo
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo[] filterFindByC_G_NOME_PrevAndNext(long cargoId,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchCargoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_NOME_PrevAndNext(cargoId, companyId, groupId,
				nome, orderByComparator);
		}

		Cargo cargo = findByPrimaryKey(cargoId);

		Session session = null;

		try {
			session = openSession();

			Cargo[] array = new CargoImpl[3];

			array[0] = filterGetByC_G_NOME_PrevAndNext(session, cargo,
					companyId, groupId, nome, orderByComparator, true);

			array[1] = cargo;

			array[2] = filterGetByC_G_NOME_PrevAndNext(session, cargo,
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

	protected Cargo filterGetByC_G_NOME_PrevAndNext(Session session,
		Cargo cargo, long companyId, long groupId, String nome,
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
			query.append(_FILTER_SQL_SELECT_CARGO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_1);
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
			query.append(_FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CargoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CargoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Cargo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CargoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CargoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cargo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cargo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		for (Cargo cargo : findByC_G_NOME(companyId, groupId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cargo);
		}
	}

	/**
	 * Returns the number of cargos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching cargos
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

			query.append(_SQL_COUNT_CARGO_WHERE);

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
	 * Returns the number of cargos that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching cargos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G_NOME(companyId, groupId, nome);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CARGO_WHERE);

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
				Cargo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
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

	private static final String _FINDER_COLUMN_C_G_NOME_COMPANYID_2 = "cargo.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_GROUPID_2 = "cargo.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_1 = "cargo.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_2 = "cargo.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_3 = "(cargo.nome IS NULL OR cargo.nome LIKE '')";

	public CargoPersistenceImpl() {
		setModelClass(Cargo.class);
	}

	/**
	 * Caches the cargo in the entity cache if it is enabled.
	 *
	 * @param cargo the cargo
	 */
	@Override
	public void cacheResult(Cargo cargo) {
		EntityCacheUtil.putResult(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoImpl.class, cargo.getPrimaryKey(), cargo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { cargo.getUuid(), cargo.getGroupId() }, cargo);

		cargo.resetOriginalValues();
	}

	/**
	 * Caches the cargos in the entity cache if it is enabled.
	 *
	 * @param cargos the cargos
	 */
	@Override
	public void cacheResult(List<Cargo> cargos) {
		for (Cargo cargo : cargos) {
			if (EntityCacheUtil.getResult(CargoModelImpl.ENTITY_CACHE_ENABLED,
						CargoImpl.class, cargo.getPrimaryKey()) == null) {
				cacheResult(cargo);
			}
			else {
				cargo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cargos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CargoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CargoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cargo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cargo cargo) {
		EntityCacheUtil.removeResult(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoImpl.class, cargo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cargo);
	}

	@Override
	public void clearCache(List<Cargo> cargos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cargo cargo : cargos) {
			EntityCacheUtil.removeResult(CargoModelImpl.ENTITY_CACHE_ENABLED,
				CargoImpl.class, cargo.getPrimaryKey());

			clearUniqueFindersCache(cargo);
		}
	}

	protected void cacheUniqueFindersCache(Cargo cargo) {
		if (cargo.isNew()) {
			Object[] args = new Object[] { cargo.getUuid(), cargo.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, cargo);
		}
		else {
			CargoModelImpl cargoModelImpl = (CargoModelImpl)cargo;

			if ((cargoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cargo.getUuid(), cargo.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					cargo);
			}
		}
	}

	protected void clearUniqueFindersCache(Cargo cargo) {
		CargoModelImpl cargoModelImpl = (CargoModelImpl)cargo;

		Object[] args = new Object[] { cargo.getUuid(), cargo.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((cargoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					cargoModelImpl.getOriginalUuid(),
					cargoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new cargo with the primary key. Does not add the cargo to the database.
	 *
	 * @param cargoId the primary key for the new cargo
	 * @return the new cargo
	 */
	@Override
	public Cargo create(long cargoId) {
		Cargo cargo = new CargoImpl();

		cargo.setNew(true);
		cargo.setPrimaryKey(cargoId);

		String uuid = PortalUUIDUtil.generate();

		cargo.setUuid(uuid);

		return cargo;
	}

	/**
	 * Removes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cargoId the primary key of the cargo
	 * @return the cargo that was removed
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo remove(long cargoId)
		throws NoSuchCargoException, SystemException {
		return remove((Serializable)cargoId);
	}

	/**
	 * Removes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cargo
	 * @return the cargo that was removed
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo remove(Serializable primaryKey)
		throws NoSuchCargoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Cargo cargo = (Cargo)session.get(CargoImpl.class, primaryKey);

			if (cargo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCargoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cargo);
		}
		catch (NoSuchCargoException nsee) {
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
	protected Cargo removeImpl(Cargo cargo) throws SystemException {
		cargo = toUnwrappedModel(cargo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cargo)) {
				cargo = (Cargo)session.get(CargoImpl.class,
						cargo.getPrimaryKeyObj());
			}

			if (cargo != null) {
				session.delete(cargo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cargo != null) {
			clearCache(cargo);
		}

		return cargo;
	}

	@Override
	public Cargo updateImpl(br.com.prodevelopment.funcionario.model.Cargo cargo)
		throws SystemException {
		cargo = toUnwrappedModel(cargo);

		boolean isNew = cargo.isNew();

		CargoModelImpl cargoModelImpl = (CargoModelImpl)cargo;

		if (Validator.isNull(cargo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cargo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (cargo.isNew()) {
				session.save(cargo);

				cargo.setNew(false);
			}
			else {
				session.merge(cargo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CargoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cargoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cargoModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { cargoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((cargoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cargoModelImpl.getOriginalUuid(),
						cargoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						cargoModelImpl.getUuid(), cargoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((cargoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cargoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { cargoModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((cargoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cargoModelImpl.getOriginalCompanyId(),
						cargoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						cargoModelImpl.getCompanyId(),
						cargoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}
		}

		EntityCacheUtil.putResult(CargoModelImpl.ENTITY_CACHE_ENABLED,
			CargoImpl.class, cargo.getPrimaryKey(), cargo);

		clearUniqueFindersCache(cargo);
		cacheUniqueFindersCache(cargo);

		return cargo;
	}

	protected Cargo toUnwrappedModel(Cargo cargo) {
		if (cargo instanceof CargoImpl) {
			return cargo;
		}

		CargoImpl cargoImpl = new CargoImpl();

		cargoImpl.setNew(cargo.isNew());
		cargoImpl.setPrimaryKey(cargo.getPrimaryKey());

		cargoImpl.setUuid(cargo.getUuid());
		cargoImpl.setCargoId(cargo.getCargoId());
		cargoImpl.setCompanyId(cargo.getCompanyId());
		cargoImpl.setGroupId(cargo.getGroupId());
		cargoImpl.setCreateUserId(cargo.getCreateUserId());
		cargoImpl.setModifiedUserId(cargo.getModifiedUserId());
		cargoImpl.setCreateDate(cargo.getCreateDate());
		cargoImpl.setModifiedDate(cargo.getModifiedDate());
		cargoImpl.setNome(cargo.getNome());
		cargoImpl.setVersao(cargo.getVersao());

		return cargoImpl;
	}

	/**
	 * Returns the cargo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cargo
	 * @return the cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCargoException, SystemException {
		Cargo cargo = fetchByPrimaryKey(primaryKey);

		if (cargo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCargoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cargo;
	}

	/**
	 * Returns the cargo with the primary key or throws a {@link br.com.prodevelopment.funcionario.NoSuchCargoException} if it could not be found.
	 *
	 * @param cargoId the primary key of the cargo
	 * @return the cargo
	 * @throws br.com.prodevelopment.funcionario.NoSuchCargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo findByPrimaryKey(long cargoId)
		throws NoSuchCargoException, SystemException {
		return findByPrimaryKey((Serializable)cargoId);
	}

	/**
	 * Returns the cargo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cargo
	 * @return the cargo, or <code>null</code> if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Cargo cargo = (Cargo)EntityCacheUtil.getResult(CargoModelImpl.ENTITY_CACHE_ENABLED,
				CargoImpl.class, primaryKey);

		if (cargo == _nullCargo) {
			return null;
		}

		if (cargo == null) {
			Session session = null;

			try {
				session = openSession();

				cargo = (Cargo)session.get(CargoImpl.class, primaryKey);

				if (cargo != null) {
					cacheResult(cargo);
				}
				else {
					EntityCacheUtil.putResult(CargoModelImpl.ENTITY_CACHE_ENABLED,
						CargoImpl.class, primaryKey, _nullCargo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CargoModelImpl.ENTITY_CACHE_ENABLED,
					CargoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cargo;
	}

	/**
	 * Returns the cargo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cargoId the primary key of the cargo
	 * @return the cargo, or <code>null</code> if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cargo fetchByPrimaryKey(long cargoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)cargoId);
	}

	/**
	 * Returns all the cargos.
	 *
	 * @return the cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.CargoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cargos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cargo> findAll(int start, int end,
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

		List<Cargo> list = (List<Cargo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CARGO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CARGO;

				if (pagination) {
					sql = sql.concat(CargoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cargo>(list);
				}
				else {
					list = (List<Cargo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the cargos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Cargo cargo : findAll()) {
			remove(cargo);
		}
	}

	/**
	 * Returns the number of cargos.
	 *
	 * @return the number of cargos
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

				Query q = session.createQuery(_SQL_COUNT_CARGO);

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
	 * Initializes the cargo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.funcionario.model.Cargo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Cargo>> listenersList = new ArrayList<ModelListener<Cargo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Cargo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CargoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CARGO = "SELECT cargo FROM Cargo cargo";
	private static final String _SQL_SELECT_CARGO_WHERE = "SELECT cargo FROM Cargo cargo WHERE ";
	private static final String _SQL_COUNT_CARGO = "SELECT COUNT(cargo) FROM Cargo cargo";
	private static final String _SQL_COUNT_CARGO_WHERE = "SELECT COUNT(cargo) FROM Cargo cargo WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "cargo.cargoId";
	private static final String _FILTER_SQL_SELECT_CARGO_WHERE = "SELECT DISTINCT {cargo.*} FROM Cargo cargo WHERE ";
	private static final String _FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Cargo.*} FROM (SELECT DISTINCT cargo.cargoId FROM Cargo cargo WHERE ";
	private static final String _FILTER_SQL_SELECT_CARGO_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Cargo ON TEMP_TABLE.cargoId = Cargo.cargoId";
	private static final String _FILTER_SQL_COUNT_CARGO_WHERE = "SELECT COUNT(DISTINCT cargo.cargoId) AS COUNT_VALUE FROM Cargo cargo WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "cargo";
	private static final String _FILTER_ENTITY_TABLE = "Cargo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cargo.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Cargo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Cargo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Cargo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CargoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Cargo _nullCargo = new CargoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Cargo> toCacheModel() {
				return _nullCargoCacheModel;
			}
		};

	private static CacheModel<Cargo> _nullCargoCacheModel = new CacheModel<Cargo>() {
			@Override
			public Cargo toEntityModel() {
				return _nullCargo;
			}
		};
}