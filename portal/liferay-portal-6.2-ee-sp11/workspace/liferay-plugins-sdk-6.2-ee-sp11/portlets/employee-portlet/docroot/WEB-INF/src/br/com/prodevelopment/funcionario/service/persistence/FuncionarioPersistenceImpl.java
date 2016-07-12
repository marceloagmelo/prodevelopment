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

import br.com.prodevelopment.funcionario.NoSuchFuncionarioException;
import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.funcionario.model.impl.FuncionarioImpl;
import br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl;

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
 * The persistence implementation for the funcionario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see FuncionarioPersistence
 * @see FuncionarioUtil
 * @generated
 */
public class FuncionarioPersistenceImpl extends BasePersistenceImpl<Funcionario>
	implements FuncionarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FuncionarioUtil} to access the funcionario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FuncionarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FuncionarioModelImpl.UUID_COLUMN_BITMASK |
			FuncionarioModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the funcionarios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByUuid(String uuid, int start, int end,
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

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if (!Validator.equals(uuid, funcionario.getUuid())) {
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByUuid_First(uuid, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByUuid_Last(uuid, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where uuid = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByUuid_PrevAndNext(long funcionarioId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByUuid_PrevAndNext(session, funcionario, uuid,
					orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByUuid_PrevAndNext(session, funcionario, uuid,
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

	protected Funcionario getByUuid_PrevAndNext(Session session,
		Funcionario funcionario, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Funcionario funcionario : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching funcionarios
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

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "funcionario.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "funcionario.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(funcionario.uuid IS NULL OR funcionario.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			FuncionarioModelImpl.UUID_COLUMN_BITMASK |
			FuncionarioModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the funcionario where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByUUID_G(String uuid, long groupId)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByUUID_G(uuid, groupId);

		if (funcionario == null) {
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

			throw new NoSuchFuncionarioException(msg.toString());
		}

		return funcionario;
	}

	/**
	 * Returns the funcionario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the funcionario where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Funcionario) {
			Funcionario funcionario = (Funcionario)result;

			if (!Validator.equals(uuid, funcionario.getUuid()) ||
					(groupId != funcionario.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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

				List<Funcionario> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Funcionario funcionario = list.get(0);

					result = funcionario;

					cacheResult(funcionario);

					if ((funcionario.getUuid() == null) ||
							!funcionario.getUuid().equals(uuid) ||
							(funcionario.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, funcionario);
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
			return (Funcionario)result;
		}
	}

	/**
	 * Removes the funcionario where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the funcionario that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario removeByUUID_G(String uuid, long groupId)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByUUID_G(uuid, groupId);

		return remove(funcionario);
	}

	/**
	 * Returns the number of funcionarios where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching funcionarios
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

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "funcionario.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "funcionario.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(funcionario.uuid IS NULL OR funcionario.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "funcionario.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			FuncionarioModelImpl.UUID_COLUMN_BITMASK |
			FuncionarioModelImpl.COMPANYID_COLUMN_BITMASK |
			FuncionarioModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the funcionarios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByUuid_C(String uuid, long companyId,
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

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if (!Validator.equals(uuid, funcionario.getUuid()) ||
						(companyId != funcionario.getCompanyId())) {
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByUuid_C_PrevAndNext(long funcionarioId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, funcionario, uuid,
					companyId, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByUuid_C_PrevAndNext(session, funcionario, uuid,
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

	protected Funcionario getByUuid_C_PrevAndNext(Session session,
		Funcionario funcionario, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Funcionario funcionario : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching funcionarios
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

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "funcionario.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "funcionario.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(funcionario.uuid IS NULL OR funcionario.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "funcionario.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			FuncionarioModelImpl.COMPANYID_COLUMN_BITMASK |
			FuncionarioModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the funcionarios where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the funcionarios where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByCompany(long companyId, int start, int end,
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

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if ((companyId != funcionario.getCompanyId())) {
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByCompany_First(companyId,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByCompany_Last(companyId,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByCompany_PrevAndNext(long funcionarioId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByCompany_PrevAndNext(session, funcionario,
					companyId, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByCompany_PrevAndNext(session, funcionario,
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

	protected Funcionario getByCompany_PrevAndNext(Session session,
		Funcionario funcionario, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Funcionario funcionario : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching funcionarios
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

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "funcionario.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			FuncionarioModelImpl.COMPANYID_COLUMN_BITMASK |
			FuncionarioModelImpl.GROUPID_COLUMN_BITMASK |
			FuncionarioModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the funcionarios where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G(long companyId, long groupId, int start,
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

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if ((companyId != funcionario.getCompanyId()) ||
						(groupId != funcionario.getGroupId())) {
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_G_First(companyId, groupId,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_G_Last(companyId, groupId,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByC_G(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByC_G_PrevAndNext(long funcionarioId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByC_G_PrevAndNext(session, funcionario, companyId,
					groupId, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByC_G_PrevAndNext(session, funcionario, companyId,
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

	protected Funcionario getByC_G_PrevAndNext(Session session,
		Funcionario funcionario, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G(long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(FuncionarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Funcionario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, FuncionarioImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, FuncionarioImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<Funcionario>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] filterFindByC_G_PrevAndNext(long funcionarioId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(funcionarioId, companyId, groupId,
				orderByComparator);
		}

		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, funcionario,
					companyId, groupId, orderByComparator, true);

			array[1] = funcionario;

			array[2] = filterGetByC_G_PrevAndNext(session, funcionario,
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

	protected Funcionario filterGetByC_G_PrevAndNext(Session session,
		Funcionario funcionario, long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(FuncionarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Funcionario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, FuncionarioImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, FuncionarioImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (Funcionario funcionario : findByC_G(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching funcionarios
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

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

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
	 * Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_FUNCIONARIO_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Funcionario.class.getName(),
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

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "funcionario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "funcionario.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_NOME",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOME = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NOME",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_NOME(long companyId, String nome)
		throws SystemException {
		return findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_NOME(long companyId, String nome,
		int start, int end) throws SystemException {
		return findByC_NOME(companyId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_NOME(long companyId, String nome,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME;
		finderArgs = new Object[] { companyId, nome, start, end, orderByComparator };

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if ((companyId != funcionario.getCompanyId()) ||
						!StringUtil.wildcardMatches(funcionario.getNome(),
							nome, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_NOME_First(companyId, nome,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> list = findByC_NOME(companyId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_NOME_Last(companyId, nome,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_NOME(companyId, nome);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByC_NOME(companyId, nome, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByC_NOME_PrevAndNext(long funcionarioId,
		long companyId, String nome, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByC_NOME_PrevAndNext(session, funcionario, companyId,
					nome, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByC_NOME_PrevAndNext(session, funcionario, companyId,
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

	protected Funcionario getByC_NOME_PrevAndNext(Session session,
		Funcionario funcionario, long companyId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where companyId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_NOME(long companyId, String nome)
		throws SystemException {
		for (Funcionario funcionario : findByC_NOME(companyId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the number of matching funcionarios
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

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

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

	private static final String _FINDER_COLUMN_C_NOME_COMPANYID_2 = "funcionario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_NOME_NOME_1 = "funcionario.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_NOME_NOME_2 = "funcionario.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_NOME_NOME_3 = "(funcionario.nome IS NULL OR funcionario.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_NOME = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_NOME =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G_NOME(long companyId, long groupId,
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

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if ((companyId != funcionario.getCompanyId()) ||
						(groupId != funcionario.getGroupId()) ||
						!StringUtil.wildcardMatches(funcionario.getNome(),
							nome, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_G_NOME_First(companyId, groupId,
				nome, orderByComparator);

		if (funcionario != null) {
			return funcionario;
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

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funcionario> list = findByC_G_NOME(companyId, groupId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_G_NOME_Last(companyId, groupId,
				nome, orderByComparator);

		if (funcionario != null) {
			return funcionario;
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

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_NOME(companyId, groupId, nome);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByC_G_NOME(companyId, groupId, nome,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByC_G_NOME_PrevAndNext(long funcionarioId,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByC_G_NOME_PrevAndNext(session, funcionario,
					companyId, groupId, nome, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByC_G_NOME_PrevAndNext(session, funcionario,
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

	protected Funcionario getByC_G_NOME_PrevAndNext(Session session,
		Funcionario funcionario, long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return filterFindByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios that the user has permissions to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G_NOME(long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_1);
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
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(FuncionarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Funcionario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, FuncionarioImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, FuncionarioImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindNome) {
				qPos.add(nome);
			}

			return (List<Funcionario>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] filterFindByC_G_NOME_PrevAndNext(long funcionarioId,
		long companyId, long groupId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_NOME_PrevAndNext(funcionarioId, companyId,
				groupId, nome, orderByComparator);
		}

		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = filterGetByC_G_NOME_PrevAndNext(session, funcionario,
					companyId, groupId, nome, orderByComparator, true);

			array[1] = funcionario;

			array[2] = filterGetByC_G_NOME_PrevAndNext(session, funcionario,
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

	protected Funcionario filterGetByC_G_NOME_PrevAndNext(Session session,
		Funcionario funcionario, long companyId, long groupId, String nome,
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
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_1);
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
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(FuncionarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Funcionario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, FuncionarioImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, FuncionarioImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		for (Funcionario funcionario : findByC_G_NOME(companyId, groupId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching funcionarios
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

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

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
	 * Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G_NOME(companyId, groupId, nome);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_FUNCIONARIO_WHERE);

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
				Funcionario.class.getName(),
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

	private static final String _FINDER_COLUMN_C_G_NOME_COMPANYID_2 = "funcionario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_GROUPID_2 = "funcionario.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_1 = "funcionario.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_2 = "funcionario.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_3 = "(funcionario.nome IS NULL OR funcionario.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N_REDUZIDO =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_N_REDUZIDO",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N_REDUZIDO =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_N_REDUZIDO",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_N_REDUZIDO(long companyId,
		String nomeReduzido) throws SystemException {
		return findByC_N_REDUZIDO(companyId, nomeReduzido, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_N_REDUZIDO(long companyId,
		String nomeReduzido, int start, int end) throws SystemException {
		return findByC_N_REDUZIDO(companyId, nomeReduzido, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_N_REDUZIDO(long companyId,
		String nomeReduzido, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N_REDUZIDO;
		finderArgs = new Object[] {
				companyId, nomeReduzido,
				
				start, end, orderByComparator
			};

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if ((companyId != funcionario.getCompanyId()) ||
						!StringUtil.wildcardMatches(
							funcionario.getNomeReduzido(), nomeReduzido,
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_C_N_REDUZIDO_COMPANYID_2);

			boolean bindNomeReduzido = false;

			if (nomeReduzido == null) {
				query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_1);
			}
			else if (nomeReduzido.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_3);
			}
			else {
				bindNomeReduzido = true;

				query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindNomeReduzido) {
					qPos.add(nomeReduzido);
				}

				if (!pagination) {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_N_REDUZIDO_First(long companyId,
		String nomeReduzido, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_N_REDUZIDO_First(companyId,
				nomeReduzido, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nomeReduzido=");
		msg.append(nomeReduzido);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_N_REDUZIDO_First(long companyId,
		String nomeReduzido, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funcionario> list = findByC_N_REDUZIDO(companyId, nomeReduzido, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_N_REDUZIDO_Last(long companyId,
		String nomeReduzido, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_N_REDUZIDO_Last(companyId,
				nomeReduzido, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nomeReduzido=");
		msg.append(nomeReduzido);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_N_REDUZIDO_Last(long companyId,
		String nomeReduzido, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_N_REDUZIDO(companyId, nomeReduzido);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByC_N_REDUZIDO(companyId, nomeReduzido,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByC_N_REDUZIDO_PrevAndNext(long funcionarioId,
		long companyId, String nomeReduzido, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByC_N_REDUZIDO_PrevAndNext(session, funcionario,
					companyId, nomeReduzido, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByC_N_REDUZIDO_PrevAndNext(session, funcionario,
					companyId, nomeReduzido, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funcionario getByC_N_REDUZIDO_PrevAndNext(Session session,
		Funcionario funcionario, long companyId, String nomeReduzido,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

		query.append(_FINDER_COLUMN_C_N_REDUZIDO_COMPANYID_2);

		boolean bindNomeReduzido = false;

		if (nomeReduzido == null) {
			query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_1);
		}
		else if (nomeReduzido.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_3);
		}
		else {
			bindNomeReduzido = true;

			query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_2);
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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindNomeReduzido) {
			qPos.add(nomeReduzido);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where companyId = &#63; and nomeReduzido LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_N_REDUZIDO(long companyId, String nomeReduzido)
		throws SystemException {
		for (Funcionario funcionario : findByC_N_REDUZIDO(companyId,
				nomeReduzido, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where companyId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nomeReduzido the nome reduzido
	 * @return the number of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_N_REDUZIDO(long companyId, String nomeReduzido)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N_REDUZIDO;

		Object[] finderArgs = new Object[] { companyId, nomeReduzido };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_C_N_REDUZIDO_COMPANYID_2);

			boolean bindNomeReduzido = false;

			if (nomeReduzido == null) {
				query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_1);
			}
			else if (nomeReduzido.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_3);
			}
			else {
				bindNomeReduzido = true;

				query.append(_FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindNomeReduzido) {
					qPos.add(nomeReduzido);
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

	private static final String _FINDER_COLUMN_C_N_REDUZIDO_COMPANYID_2 = "funcionario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_1 = "funcionario.nomeReduzido LIKE NULL";
	private static final String _FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_2 = "funcionario.nomeReduzido LIKE ?";
	private static final String _FINDER_COLUMN_C_N_REDUZIDO_NOMEREDUZIDO_3 = "(funcionario.nomeReduzido IS NULL OR funcionario.nomeReduzido LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_N_REDUZIDO =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_N_REDUZIDO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_N_REDUZIDO =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_N_REDUZIDO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G_N_REDUZIDO(long companyId, long groupId,
		String nomeReduzido) throws SystemException {
		return findByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G_N_REDUZIDO(long companyId, long groupId,
		String nomeReduzido, int start, int end) throws SystemException {
		return findByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByC_G_N_REDUZIDO(long companyId, long groupId,
		String nomeReduzido, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_N_REDUZIDO;
		finderArgs = new Object[] {
				companyId, groupId, nomeReduzido,
				
				start, end, orderByComparator
			};

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if ((companyId != funcionario.getCompanyId()) ||
						(groupId != funcionario.getGroupId()) ||
						!StringUtil.wildcardMatches(
							funcionario.getNomeReduzido(), nomeReduzido,
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_GROUPID_2);

			boolean bindNomeReduzido = false;

			if (nomeReduzido == null) {
				query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_1);
			}
			else if (nomeReduzido.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_3);
			}
			else {
				bindNomeReduzido = true;

				query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNomeReduzido) {
					qPos.add(nomeReduzido);
				}

				if (!pagination) {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_G_N_REDUZIDO_First(long companyId, long groupId,
		String nomeReduzido, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_G_N_REDUZIDO_First(companyId,
				groupId, nomeReduzido, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", nomeReduzido=");
		msg.append(nomeReduzido);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_G_N_REDUZIDO_First(long companyId,
		long groupId, String nomeReduzido, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funcionario> list = findByC_G_N_REDUZIDO(companyId, groupId,
				nomeReduzido, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByC_G_N_REDUZIDO_Last(long companyId, long groupId,
		String nomeReduzido, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByC_G_N_REDUZIDO_Last(companyId,
				groupId, nomeReduzido, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", nomeReduzido=");
		msg.append(nomeReduzido);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByC_G_N_REDUZIDO_Last(long companyId, long groupId,
		String nomeReduzido, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByC_G_N_REDUZIDO(companyId, groupId,
				nomeReduzido, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByC_G_N_REDUZIDO_PrevAndNext(long funcionarioId,
		long companyId, long groupId, String nomeReduzido,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByC_G_N_REDUZIDO_PrevAndNext(session, funcionario,
					companyId, groupId, nomeReduzido, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByC_G_N_REDUZIDO_PrevAndNext(session, funcionario,
					companyId, groupId, nomeReduzido, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funcionario getByC_G_N_REDUZIDO_PrevAndNext(Session session,
		Funcionario funcionario, long companyId, long groupId,
		String nomeReduzido, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

		query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_GROUPID_2);

		boolean bindNomeReduzido = false;

		if (nomeReduzido == null) {
			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_1);
		}
		else if (nomeReduzido.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_3);
		}
		else {
			bindNomeReduzido = true;

			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_2);
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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNomeReduzido) {
			qPos.add(nomeReduzido);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @return the matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G_N_REDUZIDO(long companyId,
		long groupId, String nomeReduzido) throws SystemException {
		return filterFindByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G_N_REDUZIDO(long companyId,
		long groupId, String nomeReduzido, int start, int end)
		throws SystemException {
		return filterFindByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios that the user has permissions to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> filterFindByC_G_N_REDUZIDO(long companyId,
		long groupId, String nomeReduzido, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido,
				start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_GROUPID_2);

		boolean bindNomeReduzido = false;

		if (nomeReduzido == null) {
			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_1);
		}
		else if (nomeReduzido.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_3);
		}
		else {
			bindNomeReduzido = true;

			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(FuncionarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Funcionario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, FuncionarioImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, FuncionarioImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			if (bindNomeReduzido) {
				qPos.add(nomeReduzido);
			}

			return (List<Funcionario>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] filterFindByC_G_N_REDUZIDO_PrevAndNext(
		long funcionarioId, long companyId, long groupId, String nomeReduzido,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_N_REDUZIDO_PrevAndNext(funcionarioId, companyId,
				groupId, nomeReduzido, orderByComparator);
		}

		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = filterGetByC_G_N_REDUZIDO_PrevAndNext(session,
					funcionario, companyId, groupId, nomeReduzido,
					orderByComparator, true);

			array[1] = funcionario;

			array[2] = filterGetByC_G_N_REDUZIDO_PrevAndNext(session,
					funcionario, companyId, groupId, nomeReduzido,
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

	protected Funcionario filterGetByC_G_N_REDUZIDO_PrevAndNext(
		Session session, Funcionario funcionario, long companyId, long groupId,
		String nomeReduzido, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_GROUPID_2);

		boolean bindNomeReduzido = false;

		if (nomeReduzido == null) {
			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_1);
		}
		else if (nomeReduzido.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_3);
		}
		else {
			bindNomeReduzido = true;

			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(FuncionarioModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Funcionario.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, FuncionarioImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, FuncionarioImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindNomeReduzido) {
			qPos.add(nomeReduzido);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_N_REDUZIDO(long companyId, long groupId,
		String nomeReduzido) throws SystemException {
		for (Funcionario funcionario : findByC_G_N_REDUZIDO(companyId, groupId,
				nomeReduzido, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @return the number of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_N_REDUZIDO(long companyId, long groupId,
		String nomeReduzido) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_N_REDUZIDO;

		Object[] finderArgs = new Object[] { companyId, groupId, nomeReduzido };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_GROUPID_2);

			boolean bindNomeReduzido = false;

			if (nomeReduzido == null) {
				query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_1);
			}
			else if (nomeReduzido.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_3);
			}
			else {
				bindNomeReduzido = true;

				query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindNomeReduzido) {
					qPos.add(nomeReduzido);
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
	 * Returns the number of funcionarios that the user has permission to view where companyId = &#63; and groupId = &#63; and nomeReduzido LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nomeReduzido the nome reduzido
	 * @return the number of matching funcionarios that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G_N_REDUZIDO(long companyId, long groupId,
		String nomeReduzido) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G_N_REDUZIDO(companyId, groupId, nomeReduzido);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_FUNCIONARIO_WHERE);

		query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_GROUPID_2);

		boolean bindNomeReduzido = false;

		if (nomeReduzido == null) {
			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_1);
		}
		else if (nomeReduzido.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_3);
		}
		else {
			bindNomeReduzido = true;

			query.append(_FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Funcionario.class.getName(),
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

			if (bindNomeReduzido) {
				qPos.add(nomeReduzido);
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

	private static final String _FINDER_COLUMN_C_G_N_REDUZIDO_COMPANYID_2 = "funcionario.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_N_REDUZIDO_GROUPID_2 = "funcionario.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_1 = "funcionario.nomeReduzido LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_2 = "funcionario.nomeReduzido LIKE ?";
	private static final String _FINDER_COLUMN_C_G_N_REDUZIDO_NOMEREDUZIDO_3 = "(funcionario.nomeReduzido IS NULL OR funcionario.nomeReduzido LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CPF = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCPF",
			new String[] { String.class.getName() },
			FuncionarioModelImpl.CPF_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CPF = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCPF",
			new String[] { String.class.getName() });

	/**
	 * Returns the funcionario where cpf = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	 *
	 * @param cpf the cpf
	 * @return the matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByCPF(String cpf)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByCPF(cpf);

		if (funcionario == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cpf=");
			msg.append(cpf);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFuncionarioException(msg.toString());
		}

		return funcionario;
	}

	/**
	 * Returns the funcionario where cpf = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cpf the cpf
	 * @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByCPF(String cpf) throws SystemException {
		return fetchByCPF(cpf, true);
	}

	/**
	 * Returns the funcionario where cpf = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cpf the cpf
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByCPF(String cpf, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cpf };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CPF,
					finderArgs, this);
		}

		if (result instanceof Funcionario) {
			Funcionario funcionario = (Funcionario)result;

			if (!Validator.equals(cpf, funcionario.getCpf())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			boolean bindCpf = false;

			if (cpf == null) {
				query.append(_FINDER_COLUMN_CPF_CPF_1);
			}
			else if (cpf.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CPF_CPF_3);
			}
			else {
				bindCpf = true;

				query.append(_FINDER_COLUMN_CPF_CPF_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpf) {
					qPos.add(cpf);
				}

				List<Funcionario> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FuncionarioPersistenceImpl.fetchByCPF(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Funcionario funcionario = list.get(0);

					result = funcionario;

					cacheResult(funcionario);

					if ((funcionario.getCpf() == null) ||
							!funcionario.getCpf().equals(cpf)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF,
							finderArgs, funcionario);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF,
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
			return (Funcionario)result;
		}
	}

	/**
	 * Removes the funcionario where cpf = &#63; from the database.
	 *
	 * @param cpf the cpf
	 * @return the funcionario that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario removeByCPF(String cpf)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByCPF(cpf);

		return remove(funcionario);
	}

	/**
	 * Returns the number of funcionarios where cpf = &#63;.
	 *
	 * @param cpf the cpf
	 * @return the number of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCPF(String cpf) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CPF;

		Object[] finderArgs = new Object[] { cpf };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			boolean bindCpf = false;

			if (cpf == null) {
				query.append(_FINDER_COLUMN_CPF_CPF_1);
			}
			else if (cpf.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CPF_CPF_3);
			}
			else {
				bindCpf = true;

				query.append(_FINDER_COLUMN_CPF_CPF_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpf) {
					qPos.add(cpf);
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

	private static final String _FINDER_COLUMN_CPF_CPF_1 = "funcionario.cpf IS NULL";
	private static final String _FINDER_COLUMN_CPF_CPF_2 = "funcionario.cpf = ?";
	private static final String _FINDER_COLUMN_CPF_CPF_3 = "(funcionario.cpf IS NULL OR funcionario.cpf = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_RG = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRG",
			new String[] { String.class.getName() },
			FuncionarioModelImpl.RG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RG = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRG",
			new String[] { String.class.getName() });

	/**
	 * Returns the funcionario where rg = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	 *
	 * @param rg the rg
	 * @return the matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByRG(String rg)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByRG(rg);

		if (funcionario == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rg=");
			msg.append(rg);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFuncionarioException(msg.toString());
		}

		return funcionario;
	}

	/**
	 * Returns the funcionario where rg = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rg the rg
	 * @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByRG(String rg) throws SystemException {
		return fetchByRG(rg, true);
	}

	/**
	 * Returns the funcionario where rg = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rg the rg
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByRG(String rg, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { rg };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RG,
					finderArgs, this);
		}

		if (result instanceof Funcionario) {
			Funcionario funcionario = (Funcionario)result;

			if (!Validator.equals(rg, funcionario.getRg())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			boolean bindRg = false;

			if (rg == null) {
				query.append(_FINDER_COLUMN_RG_RG_1);
			}
			else if (rg.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RG_RG_3);
			}
			else {
				bindRg = true;

				query.append(_FINDER_COLUMN_RG_RG_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRg) {
					qPos.add(rg);
				}

				List<Funcionario> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FuncionarioPersistenceImpl.fetchByRG(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Funcionario funcionario = list.get(0);

					result = funcionario;

					cacheResult(funcionario);

					if ((funcionario.getRg() == null) ||
							!funcionario.getRg().equals(rg)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG,
							finderArgs, funcionario);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG, finderArgs);

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
			return (Funcionario)result;
		}
	}

	/**
	 * Removes the funcionario where rg = &#63; from the database.
	 *
	 * @param rg the rg
	 * @return the funcionario that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario removeByRG(String rg)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByRG(rg);

		return remove(funcionario);
	}

	/**
	 * Returns the number of funcionarios where rg = &#63;.
	 *
	 * @param rg the rg
	 * @return the number of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRG(String rg) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RG;

		Object[] finderArgs = new Object[] { rg };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			boolean bindRg = false;

			if (rg == null) {
				query.append(_FINDER_COLUMN_RG_RG_1);
			}
			else if (rg.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RG_RG_3);
			}
			else {
				bindRg = true;

				query.append(_FINDER_COLUMN_RG_RG_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRg) {
					qPos.add(rg);
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

	private static final String _FINDER_COLUMN_RG_RG_1 = "funcionario.rg IS NULL";
	private static final String _FINDER_COLUMN_RG_RG_2 = "funcionario.rg = ?";
	private static final String _FINDER_COLUMN_RG_RG_3 = "(funcionario.rg IS NULL OR funcionario.rg = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DT_NASCIMENTO =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDT_NASCIMENTO",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO =
		new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDT_NASCIMENTO",
			new String[] { Date.class.getName() },
			FuncionarioModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			FuncionarioModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DT_NASCIMENTO = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDT_NASCIMENTO",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the funcionarios where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByDT_NASCIMENTO(Date dataNascimento)
		throws SystemException {
		return findByDT_NASCIMENTO(dataNascimento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByDT_NASCIMENTO(Date dataNascimento,
		int start, int end) throws SystemException {
		return findByDT_NASCIMENTO(dataNascimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByDT_NASCIMENTO(Date dataNascimento,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if (!Validator.equals(dataNascimento,
							funcionario.getDataNascimento())) {
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByDT_NASCIMENTO_First(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByDT_NASCIMENTO_First(dataNascimento,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByDT_NASCIMENTO_First(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> list = findByDT_NASCIMENTO(dataNascimento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByDT_NASCIMENTO_Last(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByDT_NASCIMENTO_Last(dataNascimento,
				orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByDT_NASCIMENTO_Last(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDT_NASCIMENTO(dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByDT_NASCIMENTO(dataNascimento, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where dataNascimento = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByDT_NASCIMENTO_PrevAndNext(long funcionarioId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByDT_NASCIMENTO_PrevAndNext(session, funcionario,
					dataNascimento, orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByDT_NASCIMENTO_PrevAndNext(session, funcionario,
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

	protected Funcionario getByDT_NASCIMENTO_PrevAndNext(Session session,
		Funcionario funcionario, Date dataNascimento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where dataNascimento = &#63; from the database.
	 *
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDT_NASCIMENTO(Date dataNascimento)
		throws SystemException {
		for (Funcionario funcionario : findByDT_NASCIMENTO(dataNascimento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the number of matching funcionarios
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

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

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

	private static final String _FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_1 = "funcionario.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_DT_NASCIMENTO_DATANASCIMENTO_2 = "funcionario.dataNascimento = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CARGO = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCARGO",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCARGO",
			new String[] { Long.class.getName() },
			FuncionarioModelImpl.CARGOID_COLUMN_BITMASK |
			FuncionarioModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARGO = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCARGO",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the funcionarios where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @return the matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByCARGO(long cargoId)
		throws SystemException {
		return findByCARGO(cargoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios where cargoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cargoId the cargo ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByCARGO(long cargoId, int start, int end)
		throws SystemException {
		return findByCARGO(cargoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios where cargoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cargoId the cargo ID
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findByCARGO(long cargoId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO;
			finderArgs = new Object[] { cargoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CARGO;
			finderArgs = new Object[] { cargoId, start, end, orderByComparator };
		}

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funcionario funcionario : list) {
				if ((cargoId != funcionario.getCargoId())) {
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

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_CARGO_CARGOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cargoId);

				if (!pagination) {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funcionario in the ordered set where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByCARGO_First(long cargoId,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByCARGO_First(cargoId, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cargoId=");
		msg.append(cargoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the first funcionario in the ordered set where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByCARGO_First(long cargoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funcionario> list = findByCARGO(cargoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funcionario in the ordered set where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByCARGO_Last(long cargoId,
		OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByCARGO_Last(cargoId, orderByComparator);

		if (funcionario != null) {
			return funcionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cargoId=");
		msg.append(cargoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFuncionarioException(msg.toString());
	}

	/**
	 * Returns the last funcionario in the ordered set where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByCARGO_Last(long cargoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCARGO(cargoId);

		if (count == 0) {
			return null;
		}

		List<Funcionario> list = findByCARGO(cargoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funcionarios before and after the current funcionario in the ordered set where cargoId = &#63;.
	 *
	 * @param funcionarioId the primary key of the current funcionario
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario[] findByCARGO_PrevAndNext(long funcionarioId,
		long cargoId, OrderByComparator orderByComparator)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByPrimaryKey(funcionarioId);

		Session session = null;

		try {
			session = openSession();

			Funcionario[] array = new FuncionarioImpl[3];

			array[0] = getByCARGO_PrevAndNext(session, funcionario, cargoId,
					orderByComparator, true);

			array[1] = funcionario;

			array[2] = getByCARGO_PrevAndNext(session, funcionario, cargoId,
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

	protected Funcionario getByCARGO_PrevAndNext(Session session,
		Funcionario funcionario, long cargoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

		query.append(_FINDER_COLUMN_CARGO_CARGOID_2);

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
			query.append(FuncionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cargoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funcionario);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funcionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funcionarios where cargoId = &#63; from the database.
	 *
	 * @param cargoId the cargo ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCARGO(long cargoId) throws SystemException {
		for (Funcionario funcionario : findByCARGO(cargoId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @return the number of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCARGO(long cargoId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARGO;

		Object[] finderArgs = new Object[] { cargoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_CARGO_CARGOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cargoId);

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

	private static final String _FINDER_COLUMN_CARGO_CARGOID_2 = "funcionario.cargoId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USUARIO = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, FuncionarioImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUSUARIO",
			new String[] { Long.class.getName() },
			FuncionarioModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USUARIO = new FinderPath(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSUARIO",
			new String[] { Long.class.getName() });

	/**
	 * Returns the funcionario where userId = &#63; or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByUSUARIO(long userId)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByUSUARIO(userId);

		if (funcionario == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFuncionarioException(msg.toString());
		}

		return funcionario;
	}

	/**
	 * Returns the funcionario where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByUSUARIO(long userId) throws SystemException {
		return fetchByUSUARIO(userId, true);
	}

	/**
	 * Returns the funcionario where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching funcionario, or <code>null</code> if a matching funcionario could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByUSUARIO(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USUARIO,
					finderArgs, this);
		}

		if (result instanceof Funcionario) {
			Funcionario funcionario = (Funcionario)result;

			if ((userId != funcionario.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_USUARIO_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Funcionario> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FuncionarioPersistenceImpl.fetchByUSUARIO(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Funcionario funcionario = list.get(0);

					result = funcionario;

					cacheResult(funcionario);

					if ((funcionario.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
							finderArgs, funcionario);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO,
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
			return (Funcionario)result;
		}
	}

	/**
	 * Removes the funcionario where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the funcionario that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario removeByUSUARIO(long userId)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = findByUSUARIO(userId);

		return remove(funcionario);
	}

	/**
	 * Returns the number of funcionarios where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUSUARIO(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USUARIO;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNCIONARIO_WHERE);

			query.append(_FINDER_COLUMN_USUARIO_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USUARIO_USERID_2 = "funcionario.userId = ?";

	public FuncionarioPersistenceImpl() {
		setModelClass(Funcionario.class);
	}

	/**
	 * Caches the funcionario in the entity cache if it is enabled.
	 *
	 * @param funcionario the funcionario
	 */
	@Override
	public void cacheResult(Funcionario funcionario) {
		EntityCacheUtil.putResult(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioImpl.class, funcionario.getPrimaryKey(), funcionario);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { funcionario.getUuid(), funcionario.getGroupId() },
			funcionario);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF,
			new Object[] { funcionario.getCpf() }, funcionario);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG,
			new Object[] { funcionario.getRg() }, funcionario);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
			new Object[] { funcionario.getUserId() }, funcionario);

		funcionario.resetOriginalValues();
	}

	/**
	 * Caches the funcionarios in the entity cache if it is enabled.
	 *
	 * @param funcionarios the funcionarios
	 */
	@Override
	public void cacheResult(List<Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			if (EntityCacheUtil.getResult(
						FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
						FuncionarioImpl.class, funcionario.getPrimaryKey()) == null) {
				cacheResult(funcionario);
			}
			else {
				funcionario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all funcionarios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FuncionarioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FuncionarioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the funcionario.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Funcionario funcionario) {
		EntityCacheUtil.removeResult(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioImpl.class, funcionario.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(funcionario);
	}

	@Override
	public void clearCache(List<Funcionario> funcionarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Funcionario funcionario : funcionarios) {
			EntityCacheUtil.removeResult(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
				FuncionarioImpl.class, funcionario.getPrimaryKey());

			clearUniqueFindersCache(funcionario);
		}
	}

	protected void cacheUniqueFindersCache(Funcionario funcionario) {
		if (funcionario.isNew()) {
			Object[] args = new Object[] {
					funcionario.getUuid(), funcionario.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				funcionario);

			args = new Object[] { funcionario.getCpf() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CPF, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF, args,
				funcionario);

			args = new Object[] { funcionario.getRg() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RG, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG, args, funcionario);

			args = new Object[] { funcionario.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USUARIO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO, args,
				funcionario);
		}
		else {
			FuncionarioModelImpl funcionarioModelImpl = (FuncionarioModelImpl)funcionario;

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funcionario.getUuid(), funcionario.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					funcionario);
			}

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CPF.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { funcionario.getCpf() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CPF, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPF, args,
					funcionario);
			}

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { funcionario.getRg() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RG, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RG, args,
					funcionario);
			}

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USUARIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { funcionario.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USUARIO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO, args,
					funcionario);
			}
		}
	}

	protected void clearUniqueFindersCache(Funcionario funcionario) {
		FuncionarioModelImpl funcionarioModelImpl = (FuncionarioModelImpl)funcionario;

		Object[] args = new Object[] {
				funcionario.getUuid(), funcionario.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((funcionarioModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					funcionarioModelImpl.getOriginalUuid(),
					funcionarioModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { funcionario.getCpf() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CPF, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF, args);

		if ((funcionarioModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CPF.getColumnBitmask()) != 0) {
			args = new Object[] { funcionarioModelImpl.getOriginalCpf() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CPF, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPF, args);
		}

		args = new Object[] { funcionario.getRg() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RG, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG, args);

		if ((funcionarioModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RG.getColumnBitmask()) != 0) {
			args = new Object[] { funcionarioModelImpl.getOriginalRg() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RG, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RG, args);
		}

		args = new Object[] { funcionario.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USUARIO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO, args);

		if ((funcionarioModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USUARIO.getColumnBitmask()) != 0) {
			args = new Object[] { funcionarioModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USUARIO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO, args);
		}
	}

	/**
	 * Creates a new funcionario with the primary key. Does not add the funcionario to the database.
	 *
	 * @param funcionarioId the primary key for the new funcionario
	 * @return the new funcionario
	 */
	@Override
	public Funcionario create(long funcionarioId) {
		Funcionario funcionario = new FuncionarioImpl();

		funcionario.setNew(true);
		funcionario.setPrimaryKey(funcionarioId);

		String uuid = PortalUUIDUtil.generate();

		funcionario.setUuid(uuid);

		return funcionario;
	}

	/**
	 * Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario that was removed
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario remove(long funcionarioId)
		throws NoSuchFuncionarioException, SystemException {
		return remove((Serializable)funcionarioId);
	}

	/**
	 * Removes the funcionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the funcionario
	 * @return the funcionario that was removed
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario remove(Serializable primaryKey)
		throws NoSuchFuncionarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Funcionario funcionario = (Funcionario)session.get(FuncionarioImpl.class,
					primaryKey);

			if (funcionario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFuncionarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(funcionario);
		}
		catch (NoSuchFuncionarioException nsee) {
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
	protected Funcionario removeImpl(Funcionario funcionario)
		throws SystemException {
		funcionario = toUnwrappedModel(funcionario);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(funcionario)) {
				funcionario = (Funcionario)session.get(FuncionarioImpl.class,
						funcionario.getPrimaryKeyObj());
			}

			if (funcionario != null) {
				session.delete(funcionario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (funcionario != null) {
			clearCache(funcionario);
		}

		return funcionario;
	}

	@Override
	public Funcionario updateImpl(
		br.com.prodevelopment.funcionario.model.Funcionario funcionario)
		throws SystemException {
		funcionario = toUnwrappedModel(funcionario);

		boolean isNew = funcionario.isNew();

		FuncionarioModelImpl funcionarioModelImpl = (FuncionarioModelImpl)funcionario;

		if (Validator.isNull(funcionario.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			funcionario.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (funcionario.isNew()) {
				session.save(funcionario);

				funcionario.setNew(false);
			}
			else {
				session.merge(funcionario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FuncionarioModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funcionarioModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { funcionarioModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funcionarioModelImpl.getOriginalUuid(),
						funcionarioModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						funcionarioModelImpl.getUuid(),
						funcionarioModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funcionarioModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { funcionarioModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funcionarioModelImpl.getOriginalCompanyId(),
						funcionarioModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						funcionarioModelImpl.getCompanyId(),
						funcionarioModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funcionarioModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DT_NASCIMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO,
					args);

				args = new Object[] { funcionarioModelImpl.getDataNascimento() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DT_NASCIMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DT_NASCIMENTO,
					args);
			}

			if ((funcionarioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funcionarioModelImpl.getOriginalCargoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARGO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO,
					args);

				args = new Object[] { funcionarioModelImpl.getCargoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARGO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO,
					args);
			}
		}

		EntityCacheUtil.putResult(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
			FuncionarioImpl.class, funcionario.getPrimaryKey(), funcionario);

		clearUniqueFindersCache(funcionario);
		cacheUniqueFindersCache(funcionario);

		return funcionario;
	}

	protected Funcionario toUnwrappedModel(Funcionario funcionario) {
		if (funcionario instanceof FuncionarioImpl) {
			return funcionario;
		}

		FuncionarioImpl funcionarioImpl = new FuncionarioImpl();

		funcionarioImpl.setNew(funcionario.isNew());
		funcionarioImpl.setPrimaryKey(funcionario.getPrimaryKey());

		funcionarioImpl.setUuid(funcionario.getUuid());
		funcionarioImpl.setFuncionarioId(funcionario.getFuncionarioId());
		funcionarioImpl.setCompanyId(funcionario.getCompanyId());
		funcionarioImpl.setGroupId(funcionario.getGroupId());
		funcionarioImpl.setCreateUserId(funcionario.getCreateUserId());
		funcionarioImpl.setModifiedUserId(funcionario.getModifiedUserId());
		funcionarioImpl.setCreateDate(funcionario.getCreateDate());
		funcionarioImpl.setModifiedDate(funcionario.getModifiedDate());
		funcionarioImpl.setNome(funcionario.getNome());
		funcionarioImpl.setNomeReduzido(funcionario.getNomeReduzido());
		funcionarioImpl.setObservacao(funcionario.getObservacao());
		funcionarioImpl.setRg(funcionario.getRg());
		funcionarioImpl.setRgOrgaoEmissor(funcionario.getRgOrgaoEmissor());
		funcionarioImpl.setRgDataEmissao(funcionario.getRgDataEmissao());
		funcionarioImpl.setCpf(funcionario.getCpf());
		funcionarioImpl.setSexo(funcionario.getSexo());
		funcionarioImpl.setEstadoCivil(funcionario.getEstadoCivil());
		funcionarioImpl.setDataNascimento(funcionario.getDataNascimento());
		funcionarioImpl.setEndComLogradouro(funcionario.getEndComLogradouro());
		funcionarioImpl.setEndComNumero(funcionario.getEndComNumero());
		funcionarioImpl.setEndComComplemento(funcionario.getEndComComplemento());
		funcionarioImpl.setEndComCep(funcionario.getEndComCep());
		funcionarioImpl.setEndComBairro(funcionario.getEndComBairro());
		funcionarioImpl.setEndComCidade(funcionario.getEndComCidade());
		funcionarioImpl.setEndComUf(funcionario.getEndComUf());
		funcionarioImpl.setEndComPais(funcionario.getEndComPais());
		funcionarioImpl.setEndResLogradouro(funcionario.getEndResLogradouro());
		funcionarioImpl.setEndResNumero(funcionario.getEndResNumero());
		funcionarioImpl.setEndResComplemento(funcionario.getEndResComplemento());
		funcionarioImpl.setEndResCep(funcionario.getEndResCep());
		funcionarioImpl.setEndResBairro(funcionario.getEndResBairro());
		funcionarioImpl.setEndResCidade(funcionario.getEndResCidade());
		funcionarioImpl.setEndResUf(funcionario.getEndResUf());
		funcionarioImpl.setEndResPais(funcionario.getEndResPais());
		funcionarioImpl.setDataEntrada(funcionario.getDataEntrada());
		funcionarioImpl.setDataSaida(funcionario.getDataSaida());
		funcionarioImpl.setExisteUser(funcionario.getExisteUser());
		funcionarioImpl.setUserId(funcionario.getUserId());
		funcionarioImpl.setVersao(funcionario.getVersao());
		funcionarioImpl.setCargoId(funcionario.getCargoId());
		funcionarioImpl.setFotoId(funcionario.getFotoId());
		funcionarioImpl.setAtivo(funcionario.getAtivo());
		funcionarioImpl.setSalario(funcionario.getSalario());

		return funcionarioImpl;
	}

	/**
	 * Returns the funcionario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the funcionario
	 * @return the funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFuncionarioException, SystemException {
		Funcionario funcionario = fetchByPrimaryKey(primaryKey);

		if (funcionario == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFuncionarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return funcionario;
	}

	/**
	 * Returns the funcionario with the primary key or throws a {@link br.com.prodevelopment.funcionario.NoSuchFuncionarioException} if it could not be found.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario
	 * @throws br.com.prodevelopment.funcionario.NoSuchFuncionarioException if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario findByPrimaryKey(long funcionarioId)
		throws NoSuchFuncionarioException, SystemException {
		return findByPrimaryKey((Serializable)funcionarioId);
	}

	/**
	 * Returns the funcionario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the funcionario
	 * @return the funcionario, or <code>null</code> if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Funcionario funcionario = (Funcionario)EntityCacheUtil.getResult(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
				FuncionarioImpl.class, primaryKey);

		if (funcionario == _nullFuncionario) {
			return null;
		}

		if (funcionario == null) {
			Session session = null;

			try {
				session = openSession();

				funcionario = (Funcionario)session.get(FuncionarioImpl.class,
						primaryKey);

				if (funcionario != null) {
					cacheResult(funcionario);
				}
				else {
					EntityCacheUtil.putResult(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
						FuncionarioImpl.class, primaryKey, _nullFuncionario);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FuncionarioModelImpl.ENTITY_CACHE_ENABLED,
					FuncionarioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return funcionario;
	}

	/**
	 * Returns the funcionario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param funcionarioId the primary key of the funcionario
	 * @return the funcionario, or <code>null</code> if a funcionario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funcionario fetchByPrimaryKey(long funcionarioId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)funcionarioId);
	}

	/**
	 * Returns all the funcionarios.
	 *
	 * @return the funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funcionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @return the range of funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the funcionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.funcionario.model.impl.FuncionarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of funcionarios
	 * @param end the upper bound of the range of funcionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of funcionarios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funcionario> findAll(int start, int end,
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

		List<Funcionario> list = (List<Funcionario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FUNCIONARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUNCIONARIO;

				if (pagination) {
					sql = sql.concat(FuncionarioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funcionario>(list);
				}
				else {
					list = (List<Funcionario>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the funcionarios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Funcionario funcionario : findAll()) {
			remove(funcionario);
		}
	}

	/**
	 * Returns the number of funcionarios.
	 *
	 * @return the number of funcionarios
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

				Query q = session.createQuery(_SQL_COUNT_FUNCIONARIO);

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
	 * Initializes the funcionario persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.funcionario.model.Funcionario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Funcionario>> listenersList = new ArrayList<ModelListener<Funcionario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Funcionario>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FuncionarioImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FUNCIONARIO = "SELECT funcionario FROM Funcionario funcionario";
	private static final String _SQL_SELECT_FUNCIONARIO_WHERE = "SELECT funcionario FROM Funcionario funcionario WHERE ";
	private static final String _SQL_COUNT_FUNCIONARIO = "SELECT COUNT(funcionario) FROM Funcionario funcionario";
	private static final String _SQL_COUNT_FUNCIONARIO_WHERE = "SELECT COUNT(funcionario) FROM Funcionario funcionario WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "funcionario.funcionarioId";
	private static final String _FILTER_SQL_SELECT_FUNCIONARIO_WHERE = "SELECT DISTINCT {funcionario.*} FROM Funcionario funcionario WHERE ";
	private static final String _FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Funcionario.*} FROM (SELECT DISTINCT funcionario.funcionarioId FROM Funcionario funcionario WHERE ";
	private static final String _FILTER_SQL_SELECT_FUNCIONARIO_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Funcionario ON TEMP_TABLE.funcionarioId = Funcionario.funcionarioId";
	private static final String _FILTER_SQL_COUNT_FUNCIONARIO_WHERE = "SELECT COUNT(DISTINCT funcionario.funcionarioId) AS COUNT_VALUE FROM Funcionario funcionario WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "funcionario";
	private static final String _FILTER_ENTITY_TABLE = "Funcionario";
	private static final String _ORDER_BY_ENTITY_ALIAS = "funcionario.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Funcionario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Funcionario exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Funcionario exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FuncionarioPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Funcionario _nullFuncionario = new FuncionarioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Funcionario> toCacheModel() {
				return _nullFuncionarioCacheModel;
			}
		};

	private static CacheModel<Funcionario> _nullFuncionarioCacheModel = new CacheModel<Funcionario>() {
			@Override
			public Funcionario toEntityModel() {
				return _nullFuncionario;
			}
		};
}