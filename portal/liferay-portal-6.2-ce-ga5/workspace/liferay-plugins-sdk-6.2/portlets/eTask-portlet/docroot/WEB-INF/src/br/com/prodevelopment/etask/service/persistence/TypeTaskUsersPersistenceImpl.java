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

import br.com.prodevelopment.etask.NoSuchTypeTaskUsersException;
import br.com.prodevelopment.etask.model.TypeTaskUsers;
import br.com.prodevelopment.etask.model.impl.TypeTaskUsersImpl;
import br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the type task users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTaskUsersPersistence
 * @see TypeTaskUsersUtil
 * @generated
 */
public class TypeTaskUsersPersistenceImpl extends BasePersistenceImpl<TypeTaskUsers>
	implements TypeTaskUsersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TypeTaskUsersUtil} to access the type task users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TypeTaskUsersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPETASK = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeTask",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASK =
		new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeTask", new String[] { Long.class.getName() },
			TypeTaskUsersModelImpl.TYPETASKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPETASK = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeTask",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the type task userses where typeTaskId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @return the matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTask(long typeTaskId)
		throws SystemException {
		return findByTypeTask(typeTaskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the type task userses where typeTaskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeTaskId the type task ID
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @return the range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTask(long typeTaskId, int start,
		int end) throws SystemException {
		return findByTypeTask(typeTaskId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type task userses where typeTaskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeTaskId the type task ID
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTask(long typeTaskId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASK;
			finderArgs = new Object[] { typeTaskId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPETASK;
			finderArgs = new Object[] { typeTaskId, start, end, orderByComparator };
		}

		List<TypeTaskUsers> list = (List<TypeTaskUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTaskUsers typeTaskUsers : list) {
				if ((typeTaskId != typeTaskUsers.getTypeTaskId())) {
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

			query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETASK_TYPETASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTaskId);

				if (!pagination) {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTaskUsers>(list);
				}
				else {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task users in the ordered set where typeTaskId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByTypeTask_First(long typeTaskId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByTypeTask_First(typeTaskId,
				orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeTaskId=");
		msg.append(typeTaskId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the first type task users in the ordered set where typeTaskId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByTypeTask_First(long typeTaskId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTaskUsers> list = findByTypeTask(typeTaskId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task users in the ordered set where typeTaskId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByTypeTask_Last(long typeTaskId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByTypeTask_Last(typeTaskId,
				orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeTaskId=");
		msg.append(typeTaskId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the last type task users in the ordered set where typeTaskId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByTypeTask_Last(long typeTaskId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeTask(typeTaskId);

		if (count == 0) {
			return null;
		}

		List<TypeTaskUsers> list = findByTypeTask(typeTaskId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type task userses before and after the current type task users in the ordered set where typeTaskId = &#63;.
	 *
	 * @param typeTaskUsersId the primary key of the current type task users
	 * @param typeTaskId the type task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers[] findByTypeTask_PrevAndNext(long typeTaskUsersId,
		long typeTaskId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = findByPrimaryKey(typeTaskUsersId);

		Session session = null;

		try {
			session = openSession();

			TypeTaskUsers[] array = new TypeTaskUsersImpl[3];

			array[0] = getByTypeTask_PrevAndNext(session, typeTaskUsers,
					typeTaskId, orderByComparator, true);

			array[1] = typeTaskUsers;

			array[2] = getByTypeTask_PrevAndNext(session, typeTaskUsers,
					typeTaskId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTaskUsers getByTypeTask_PrevAndNext(Session session,
		TypeTaskUsers typeTaskUsers, long typeTaskId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

		query.append(_FINDER_COLUMN_TYPETASK_TYPETASKID_2);

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
			query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeTaskId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTaskUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTaskUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type task userses where typeTaskId = &#63; from the database.
	 *
	 * @param typeTaskId the type task ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeTask(long typeTaskId) throws SystemException {
		for (TypeTaskUsers typeTaskUsers : findByTypeTask(typeTaskId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTaskUsers);
		}
	}

	/**
	 * Returns the number of type task userses where typeTaskId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @return the number of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeTask(long typeTaskId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPETASK;

		Object[] finderArgs = new Object[] { typeTaskId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETASK_TYPETASKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTaskId);

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

	private static final String _FINDER_COLUMN_TYPETASK_TYPETASKID_2 = "typeTaskUsers.typeTaskId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPETASKUSER =
		new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeTaskUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKUSER =
		new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeTaskUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			TypeTaskUsersModelImpl.TYPETASKID_COLUMN_BITMASK |
			TypeTaskUsersModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPETASKUSER = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeTaskUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the type task userses where typeTaskId = &#63; and userId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @return the matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTaskUser(long typeTaskId, long userId)
		throws SystemException {
		return findByTypeTaskUser(typeTaskId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type task userses where typeTaskId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @return the range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTaskUser(long typeTaskId, long userId,
		int start, int end) throws SystemException {
		return findByTypeTaskUser(typeTaskId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type task userses where typeTaskId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTaskUser(long typeTaskId, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKUSER;
			finderArgs = new Object[] { typeTaskId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPETASKUSER;
			finderArgs = new Object[] {
					typeTaskId, userId,
					
					start, end, orderByComparator
				};
		}

		List<TypeTaskUsers> list = (List<TypeTaskUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTaskUsers typeTaskUsers : list) {
				if ((typeTaskId != typeTaskUsers.getTypeTaskId()) ||
						(userId != typeTaskUsers.getUserId())) {
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

			query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETASKUSER_TYPETASKID_2);

			query.append(_FINDER_COLUMN_TYPETASKUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTaskId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTaskUsers>(list);
				}
				else {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByTypeTaskUser_First(long typeTaskId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByTypeTaskUser_First(typeTaskId,
				userId, orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeTaskId=");
		msg.append(typeTaskId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the first type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByTypeTaskUser_First(long typeTaskId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TypeTaskUsers> list = findByTypeTaskUser(typeTaskId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByTypeTaskUser_Last(long typeTaskId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByTypeTaskUser_Last(typeTaskId,
				userId, orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeTaskId=");
		msg.append(typeTaskId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the last type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByTypeTaskUser_Last(long typeTaskId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeTaskUser(typeTaskId, userId);

		if (count == 0) {
			return null;
		}

		List<TypeTaskUsers> list = findByTypeTaskUser(typeTaskId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type task userses before and after the current type task users in the ordered set where typeTaskId = &#63; and userId = &#63;.
	 *
	 * @param typeTaskUsersId the primary key of the current type task users
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers[] findByTypeTaskUser_PrevAndNext(
		long typeTaskUsersId, long typeTaskId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = findByPrimaryKey(typeTaskUsersId);

		Session session = null;

		try {
			session = openSession();

			TypeTaskUsers[] array = new TypeTaskUsersImpl[3];

			array[0] = getByTypeTaskUser_PrevAndNext(session, typeTaskUsers,
					typeTaskId, userId, orderByComparator, true);

			array[1] = typeTaskUsers;

			array[2] = getByTypeTaskUser_PrevAndNext(session, typeTaskUsers,
					typeTaskId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTaskUsers getByTypeTaskUser_PrevAndNext(Session session,
		TypeTaskUsers typeTaskUsers, long typeTaskId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

		query.append(_FINDER_COLUMN_TYPETASKUSER_TYPETASKID_2);

		query.append(_FINDER_COLUMN_TYPETASKUSER_USERID_2);

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
			query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeTaskId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTaskUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTaskUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type task userses where typeTaskId = &#63; and userId = &#63; from the database.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeTaskUser(long typeTaskId, long userId)
		throws SystemException {
		for (TypeTaskUsers typeTaskUsers : findByTypeTaskUser(typeTaskId,
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTaskUsers);
		}
	}

	/**
	 * Returns the number of type task userses where typeTaskId = &#63; and userId = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @return the number of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeTaskUser(long typeTaskId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPETASKUSER;

		Object[] finderArgs = new Object[] { typeTaskId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETASKUSER_TYPETASKID_2);

			query.append(_FINDER_COLUMN_TYPETASKUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTaskId);

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

	private static final String _FINDER_COLUMN_TYPETASKUSER_TYPETASKID_2 = "typeTaskUsers.typeTaskId = ? AND ";
	private static final String _FINDER_COLUMN_TYPETASKUSER_USERID_2 = "typeTaskUsers.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPETASKTYPEUSER =
		new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeTaskTypeUser",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKTYPEUSER =
		new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeTaskTypeUser",
			new String[] { Long.class.getName(), String.class.getName() },
			TypeTaskUsersModelImpl.TYPETASKID_COLUMN_BITMASK |
			TypeTaskUsersModelImpl.TYPEUSER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPETASKTYPEUSER = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeTaskTypeUser",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the type task userses where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @return the matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTaskTypeUser(long typeTaskId,
		String typeUser) throws SystemException {
		return findByTypeTaskTypeUser(typeTaskId, typeUser, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type task userses where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @return the range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTaskTypeUser(long typeTaskId,
		String typeUser, int start, int end) throws SystemException {
		return findByTypeTaskTypeUser(typeTaskId, typeUser, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type task userses where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByTypeTaskTypeUser(long typeTaskId,
		String typeUser, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKTYPEUSER;
			finderArgs = new Object[] { typeTaskId, typeUser };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPETASKTYPEUSER;
			finderArgs = new Object[] {
					typeTaskId, typeUser,
					
					start, end, orderByComparator
				};
		}

		List<TypeTaskUsers> list = (List<TypeTaskUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTaskUsers typeTaskUsers : list) {
				if ((typeTaskId != typeTaskUsers.getTypeTaskId()) ||
						!Validator.equals(typeUser, typeTaskUsers.getTypeUser())) {
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

			query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPETASKID_2);

			boolean bindTypeUser = false;

			if (typeUser == null) {
				query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_1);
			}
			else if (typeUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_3);
			}
			else {
				bindTypeUser = true;

				query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTaskId);

				if (bindTypeUser) {
					qPos.add(typeUser);
				}

				if (!pagination) {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTaskUsers>(list);
				}
				else {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByTypeTaskTypeUser_First(long typeTaskId,
		String typeUser, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByTypeTaskTypeUser_First(typeTaskId,
				typeUser, orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeTaskId=");
		msg.append(typeTaskId);

		msg.append(", typeUser=");
		msg.append(typeUser);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the first type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByTypeTaskTypeUser_First(long typeTaskId,
		String typeUser, OrderByComparator orderByComparator)
		throws SystemException {
		List<TypeTaskUsers> list = findByTypeTaskTypeUser(typeTaskId, typeUser,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByTypeTaskTypeUser_Last(long typeTaskId,
		String typeUser, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByTypeTaskTypeUser_Last(typeTaskId,
				typeUser, orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeTaskId=");
		msg.append(typeTaskId);

		msg.append(", typeUser=");
		msg.append(typeUser);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the last type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByTypeTaskTypeUser_Last(long typeTaskId,
		String typeUser, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypeTaskTypeUser(typeTaskId, typeUser);

		if (count == 0) {
			return null;
		}

		List<TypeTaskUsers> list = findByTypeTaskTypeUser(typeTaskId, typeUser,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type task userses before and after the current type task users in the ordered set where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskUsersId the primary key of the current type task users
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers[] findByTypeTaskTypeUser_PrevAndNext(
		long typeTaskUsersId, long typeTaskId, String typeUser,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = findByPrimaryKey(typeTaskUsersId);

		Session session = null;

		try {
			session = openSession();

			TypeTaskUsers[] array = new TypeTaskUsersImpl[3];

			array[0] = getByTypeTaskTypeUser_PrevAndNext(session,
					typeTaskUsers, typeTaskId, typeUser, orderByComparator, true);

			array[1] = typeTaskUsers;

			array[2] = getByTypeTaskTypeUser_PrevAndNext(session,
					typeTaskUsers, typeTaskId, typeUser, orderByComparator,
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

	protected TypeTaskUsers getByTypeTaskTypeUser_PrevAndNext(Session session,
		TypeTaskUsers typeTaskUsers, long typeTaskId, String typeUser,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

		query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPETASKID_2);

		boolean bindTypeUser = false;

		if (typeUser == null) {
			query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_1);
		}
		else if (typeUser.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_3);
		}
		else {
			bindTypeUser = true;

			query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_2);
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
			query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeTaskId);

		if (bindTypeUser) {
			qPos.add(typeUser);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTaskUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTaskUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type task userses where typeTaskId = &#63; and typeUser = &#63; from the database.
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeTaskTypeUser(long typeTaskId, String typeUser)
		throws SystemException {
		for (TypeTaskUsers typeTaskUsers : findByTypeTaskTypeUser(typeTaskId,
				typeUser, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTaskUsers);
		}
	}

	/**
	 * Returns the number of type task userses where typeTaskId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param typeUser the type user
	 * @return the number of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeTaskTypeUser(long typeTaskId, String typeUser)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPETASKTYPEUSER;

		Object[] finderArgs = new Object[] { typeTaskId, typeUser };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPETASKID_2);

			boolean bindTypeUser = false;

			if (typeUser == null) {
				query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_1);
			}
			else if (typeUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_3);
			}
			else {
				bindTypeUser = true;

				query.append(_FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTaskId);

				if (bindTypeUser) {
					qPos.add(typeUser);
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

	private static final String _FINDER_COLUMN_TYPETASKTYPEUSER_TYPETASKID_2 = "typeTaskUsers.typeTaskId = ? AND ";
	private static final String _FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_1 = "typeTaskUsers.typeUser IS NULL";
	private static final String _FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_2 = "typeTaskUsers.typeUser = ?";
	private static final String _FINDER_COLUMN_TYPETASKTYPEUSER_TYPEUSER_3 = "(typeTaskUsers.typeUser IS NULL OR typeTaskUsers.typeUser = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUser", new String[] { Long.class.getName() },
			TypeTaskUsersModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the type task userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByUser(long userId)
		throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type task userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @return the range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type task userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByUser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<TypeTaskUsers> list = (List<TypeTaskUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTaskUsers typeTaskUsers : list) {
				if ((userId != typeTaskUsers.getUserId())) {
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

			query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTaskUsers>(list);
				}
				else {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByUser_First(userId,
				orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the first type task users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTaskUsers> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByUser_Last(userId, orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the last type task users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<TypeTaskUsers> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type task userses before and after the current type task users in the ordered set where userId = &#63;.
	 *
	 * @param typeTaskUsersId the primary key of the current type task users
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers[] findByUser_PrevAndNext(long typeTaskUsersId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = findByPrimaryKey(typeTaskUsersId);

		Session session = null;

		try {
			session = openSession();

			TypeTaskUsers[] array = new TypeTaskUsersImpl[3];

			array[0] = getByUser_PrevAndNext(session, typeTaskUsers, userId,
					orderByComparator, true);

			array[1] = typeTaskUsers;

			array[2] = getByUser_PrevAndNext(session, typeTaskUsers, userId,
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

	protected TypeTaskUsers getByUser_PrevAndNext(Session session,
		TypeTaskUsers typeTaskUsers, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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
			query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTaskUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTaskUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type task userses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (TypeTaskUsers typeTaskUsers : findByUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTaskUsers);
		}
	}

	/**
	 * Returns the number of type task userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "typeTaskUsers.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERTYPEUSER =
		new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserTypeUser",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEUSER =
		new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserTypeUser",
			new String[] { Long.class.getName(), String.class.getName() },
			TypeTaskUsersModelImpl.USERID_COLUMN_BITMASK |
			TypeTaskUsersModelImpl.TYPEUSER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERTYPEUSER = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserTypeUser",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the type task userses where userId = &#63; and typeUser = &#63;.
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @return the matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByUserTypeUser(long userId, String typeUser)
		throws SystemException {
		return findByUserTypeUser(userId, typeUser, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type task userses where userId = &#63; and typeUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @return the range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByUserTypeUser(long userId, String typeUser,
		int start, int end) throws SystemException {
		return findByUserTypeUser(userId, typeUser, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type task userses where userId = &#63; and typeUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findByUserTypeUser(long userId, String typeUser,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEUSER;
			finderArgs = new Object[] { userId, typeUser };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERTYPEUSER;
			finderArgs = new Object[] {
					userId, typeUser,
					
					start, end, orderByComparator
				};
		}

		List<TypeTaskUsers> list = (List<TypeTaskUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTaskUsers typeTaskUsers : list) {
				if ((userId != typeTaskUsers.getUserId()) ||
						!Validator.equals(typeUser, typeTaskUsers.getTypeUser())) {
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

			query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_USERTYPEUSER_USERID_2);

			boolean bindTypeUser = false;

			if (typeUser == null) {
				query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_1);
			}
			else if (typeUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_3);
			}
			else {
				bindTypeUser = true;

				query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindTypeUser) {
					qPos.add(typeUser);
				}

				if (!pagination) {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTaskUsers>(list);
				}
				else {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByUserTypeUser_First(long userId, String typeUser,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByUserTypeUser_First(userId,
				typeUser, orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", typeUser=");
		msg.append(typeUser);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the first type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByUserTypeUser_First(long userId,
		String typeUser, OrderByComparator orderByComparator)
		throws SystemException {
		List<TypeTaskUsers> list = findByUserTypeUser(userId, typeUser, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByUserTypeUser_Last(long userId, String typeUser,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByUserTypeUser_Last(userId,
				typeUser, orderByComparator);

		if (typeTaskUsers != null) {
			return typeTaskUsers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", typeUser=");
		msg.append(typeUser);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTaskUsersException(msg.toString());
	}

	/**
	 * Returns the last type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByUserTypeUser_Last(long userId, String typeUser,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserTypeUser(userId, typeUser);

		if (count == 0) {
			return null;
		}

		List<TypeTaskUsers> list = findByUserTypeUser(userId, typeUser,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type task userses before and after the current type task users in the ordered set where userId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskUsersId the primary key of the current type task users
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers[] findByUserTypeUser_PrevAndNext(
		long typeTaskUsersId, long userId, String typeUser,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = findByPrimaryKey(typeTaskUsersId);

		Session session = null;

		try {
			session = openSession();

			TypeTaskUsers[] array = new TypeTaskUsersImpl[3];

			array[0] = getByUserTypeUser_PrevAndNext(session, typeTaskUsers,
					userId, typeUser, orderByComparator, true);

			array[1] = typeTaskUsers;

			array[2] = getByUserTypeUser_PrevAndNext(session, typeTaskUsers,
					userId, typeUser, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTaskUsers getByUserTypeUser_PrevAndNext(Session session,
		TypeTaskUsers typeTaskUsers, long userId, String typeUser,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

		query.append(_FINDER_COLUMN_USERTYPEUSER_USERID_2);

		boolean bindTypeUser = false;

		if (typeUser == null) {
			query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_1);
		}
		else if (typeUser.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_3);
		}
		else {
			bindTypeUser = true;

			query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_2);
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
			query.append(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindTypeUser) {
			qPos.add(typeUser);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTaskUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTaskUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type task userses where userId = &#63; and typeUser = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserTypeUser(long userId, String typeUser)
		throws SystemException {
		for (TypeTaskUsers typeTaskUsers : findByUserTypeUser(userId, typeUser,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTaskUsers);
		}
	}

	/**
	 * Returns the number of type task userses where userId = &#63; and typeUser = &#63;.
	 *
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @return the number of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserTypeUser(long userId, String typeUser)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERTYPEUSER;

		Object[] finderArgs = new Object[] { userId, typeUser };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_USERTYPEUSER_USERID_2);

			boolean bindTypeUser = false;

			if (typeUser == null) {
				query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_1);
			}
			else if (typeUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_3);
			}
			else {
				bindTypeUser = true;

				query.append(_FINDER_COLUMN_USERTYPEUSER_TYPEUSER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindTypeUser) {
					qPos.add(typeUser);
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

	private static final String _FINDER_COLUMN_USERTYPEUSER_USERID_2 = "typeTaskUsers.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERTYPEUSER_TYPEUSER_1 = "typeTaskUsers.typeUser IS NULL";
	private static final String _FINDER_COLUMN_USERTYPEUSER_TYPEUSER_2 = "typeTaskUsers.typeUser = ?";
	private static final String _FINDER_COLUMN_USERTYPEUSER_TYPEUSER_3 = "(typeTaskUsers.typeUser IS NULL OR typeTaskUsers.typeUser = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTaskUsersImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTypeTaskUserType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			TypeTaskUsersModelImpl.TYPETASKID_COLUMN_BITMASK |
			TypeTaskUsersModelImpl.USERID_COLUMN_BITMASK |
			TypeTaskUsersModelImpl.TYPEUSER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPETASKUSERTYPE = new FinderPath(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeTaskUserType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskUsersException} if it could not be found.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @return the matching type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByTypeTaskUserType(long typeTaskId, long userId,
		String typeUser) throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByTypeTaskUserType(typeTaskId,
				userId, typeUser);

		if (typeTaskUsers == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("typeTaskId=");
			msg.append(typeTaskId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", typeUser=");
			msg.append(typeUser);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTypeTaskUsersException(msg.toString());
		}

		return typeTaskUsers;
	}

	/**
	 * Returns the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @return the matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByTypeTaskUserType(long typeTaskId, long userId,
		String typeUser) throws SystemException {
		return fetchByTypeTaskUserType(typeTaskId, userId, typeUser, true);
	}

	/**
	 * Returns the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching type task users, or <code>null</code> if a matching type task users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByTypeTaskUserType(long typeTaskId, long userId,
		String typeUser, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { typeTaskId, userId, typeUser };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE,
					finderArgs, this);
		}

		if (result instanceof TypeTaskUsers) {
			TypeTaskUsers typeTaskUsers = (TypeTaskUsers)result;

			if ((typeTaskId != typeTaskUsers.getTypeTaskId()) ||
					(userId != typeTaskUsers.getUserId()) ||
					!Validator.equals(typeUser, typeTaskUsers.getTypeUser())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_TYPETASKID_2);

			query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_USERID_2);

			boolean bindTypeUser = false;

			if (typeUser == null) {
				query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_1);
			}
			else if (typeUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_3);
			}
			else {
				bindTypeUser = true;

				query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTaskId);

				qPos.add(userId);

				if (bindTypeUser) {
					qPos.add(typeUser);
				}

				List<TypeTaskUsers> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE,
						finderArgs, list);
				}
				else {
					TypeTaskUsers typeTaskUsers = list.get(0);

					result = typeTaskUsers;

					cacheResult(typeTaskUsers);

					if ((typeTaskUsers.getTypeTaskId() != typeTaskId) ||
							(typeTaskUsers.getUserId() != userId) ||
							(typeTaskUsers.getTypeUser() == null) ||
							!typeTaskUsers.getTypeUser().equals(typeUser)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE,
							finderArgs, typeTaskUsers);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE,
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
			return (TypeTaskUsers)result;
		}
	}

	/**
	 * Removes the type task users where typeTaskId = &#63; and userId = &#63; and typeUser = &#63; from the database.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @return the type task users that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers removeByTypeTaskUserType(long typeTaskId, long userId,
		String typeUser) throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = findByTypeTaskUserType(typeTaskId,
				userId, typeUser);

		return remove(typeTaskUsers);
	}

	/**
	 * Returns the number of type task userses where typeTaskId = &#63; and userId = &#63; and typeUser = &#63;.
	 *
	 * @param typeTaskId the type task ID
	 * @param userId the user ID
	 * @param typeUser the type user
	 * @return the number of matching type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeTaskUserType(long typeTaskId, long userId,
		String typeUser) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPETASKUSERTYPE;

		Object[] finderArgs = new Object[] { typeTaskId, userId, typeUser };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TYPETASKUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_TYPETASKID_2);

			query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_USERID_2);

			boolean bindTypeUser = false;

			if (typeUser == null) {
				query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_1);
			}
			else if (typeUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_3);
			}
			else {
				bindTypeUser = true;

				query.append(_FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTaskId);

				qPos.add(userId);

				if (bindTypeUser) {
					qPos.add(typeUser);
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

	private static final String _FINDER_COLUMN_TYPETASKUSERTYPE_TYPETASKID_2 = "typeTaskUsers.typeTaskId = ? AND ";
	private static final String _FINDER_COLUMN_TYPETASKUSERTYPE_USERID_2 = "typeTaskUsers.userId = ? AND ";
	private static final String _FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_1 = "typeTaskUsers.typeUser IS NULL";
	private static final String _FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_2 = "typeTaskUsers.typeUser = ?";
	private static final String _FINDER_COLUMN_TYPETASKUSERTYPE_TYPEUSER_3 = "(typeTaskUsers.typeUser IS NULL OR typeTaskUsers.typeUser = '')";

	public TypeTaskUsersPersistenceImpl() {
		setModelClass(TypeTaskUsers.class);
	}

	/**
	 * Caches the type task users in the entity cache if it is enabled.
	 *
	 * @param typeTaskUsers the type task users
	 */
	@Override
	public void cacheResult(TypeTaskUsers typeTaskUsers) {
		EntityCacheUtil.putResult(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersImpl.class, typeTaskUsers.getPrimaryKey(),
			typeTaskUsers);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE,
			new Object[] {
				typeTaskUsers.getTypeTaskId(), typeTaskUsers.getUserId(),
				typeTaskUsers.getTypeUser()
			}, typeTaskUsers);

		typeTaskUsers.resetOriginalValues();
	}

	/**
	 * Caches the type task userses in the entity cache if it is enabled.
	 *
	 * @param typeTaskUserses the type task userses
	 */
	@Override
	public void cacheResult(List<TypeTaskUsers> typeTaskUserses) {
		for (TypeTaskUsers typeTaskUsers : typeTaskUserses) {
			if (EntityCacheUtil.getResult(
						TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
						TypeTaskUsersImpl.class, typeTaskUsers.getPrimaryKey()) == null) {
				cacheResult(typeTaskUsers);
			}
			else {
				typeTaskUsers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all type task userses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TypeTaskUsersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TypeTaskUsersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the type task users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TypeTaskUsers typeTaskUsers) {
		EntityCacheUtil.removeResult(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersImpl.class, typeTaskUsers.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(typeTaskUsers);
	}

	@Override
	public void clearCache(List<TypeTaskUsers> typeTaskUserses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TypeTaskUsers typeTaskUsers : typeTaskUserses) {
			EntityCacheUtil.removeResult(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
				TypeTaskUsersImpl.class, typeTaskUsers.getPrimaryKey());

			clearUniqueFindersCache(typeTaskUsers);
		}
	}

	protected void cacheUniqueFindersCache(TypeTaskUsers typeTaskUsers) {
		if (typeTaskUsers.isNew()) {
			Object[] args = new Object[] {
					typeTaskUsers.getTypeTaskId(), typeTaskUsers.getUserId(),
					typeTaskUsers.getTypeUser()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPETASKUSERTYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE,
				args, typeTaskUsers);
		}
		else {
			TypeTaskUsersModelImpl typeTaskUsersModelImpl = (TypeTaskUsersModelImpl)typeTaskUsers;

			if ((typeTaskUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskUsers.getTypeTaskId(), typeTaskUsers.getUserId(),
						typeTaskUsers.getTypeUser()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPETASKUSERTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE,
					args, typeTaskUsers);
			}
		}
	}

	protected void clearUniqueFindersCache(TypeTaskUsers typeTaskUsers) {
		TypeTaskUsersModelImpl typeTaskUsersModelImpl = (TypeTaskUsersModelImpl)typeTaskUsers;

		Object[] args = new Object[] {
				typeTaskUsers.getTypeTaskId(), typeTaskUsers.getUserId(),
				typeTaskUsers.getTypeUser()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASKUSERTYPE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE, args);

		if ((typeTaskUsersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					typeTaskUsersModelImpl.getOriginalTypeTaskId(),
					typeTaskUsersModelImpl.getOriginalUserId(),
					typeTaskUsersModelImpl.getOriginalTypeUser()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASKUSERTYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPETASKUSERTYPE,
				args);
		}
	}

	/**
	 * Creates a new type task users with the primary key. Does not add the type task users to the database.
	 *
	 * @param typeTaskUsersId the primary key for the new type task users
	 * @return the new type task users
	 */
	@Override
	public TypeTaskUsers create(long typeTaskUsersId) {
		TypeTaskUsers typeTaskUsers = new TypeTaskUsersImpl();

		typeTaskUsers.setNew(true);
		typeTaskUsers.setPrimaryKey(typeTaskUsersId);

		return typeTaskUsers;
	}

	/**
	 * Removes the type task users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeTaskUsersId the primary key of the type task users
	 * @return the type task users that was removed
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers remove(long typeTaskUsersId)
		throws NoSuchTypeTaskUsersException, SystemException {
		return remove((Serializable)typeTaskUsersId);
	}

	/**
	 * Removes the type task users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the type task users
	 * @return the type task users that was removed
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers remove(Serializable primaryKey)
		throws NoSuchTypeTaskUsersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TypeTaskUsers typeTaskUsers = (TypeTaskUsers)session.get(TypeTaskUsersImpl.class,
					primaryKey);

			if (typeTaskUsers == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeTaskUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(typeTaskUsers);
		}
		catch (NoSuchTypeTaskUsersException nsee) {
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
	protected TypeTaskUsers removeImpl(TypeTaskUsers typeTaskUsers)
		throws SystemException {
		typeTaskUsers = toUnwrappedModel(typeTaskUsers);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(typeTaskUsers)) {
				typeTaskUsers = (TypeTaskUsers)session.get(TypeTaskUsersImpl.class,
						typeTaskUsers.getPrimaryKeyObj());
			}

			if (typeTaskUsers != null) {
				session.delete(typeTaskUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (typeTaskUsers != null) {
			clearCache(typeTaskUsers);
		}

		return typeTaskUsers;
	}

	@Override
	public TypeTaskUsers updateImpl(
		br.com.prodevelopment.etask.model.TypeTaskUsers typeTaskUsers)
		throws SystemException {
		typeTaskUsers = toUnwrappedModel(typeTaskUsers);

		boolean isNew = typeTaskUsers.isNew();

		TypeTaskUsersModelImpl typeTaskUsersModelImpl = (TypeTaskUsersModelImpl)typeTaskUsers;

		Session session = null;

		try {
			session = openSession();

			if (typeTaskUsers.isNew()) {
				session.save(typeTaskUsers);

				typeTaskUsers.setNew(false);
			}
			else {
				session.merge(typeTaskUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TypeTaskUsersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((typeTaskUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskUsersModelImpl.getOriginalTypeTaskId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASK,
					args);

				args = new Object[] { typeTaskUsersModelImpl.getTypeTaskId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASK,
					args);
			}

			if ((typeTaskUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskUsersModelImpl.getOriginalTypeTaskId(),
						typeTaskUsersModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASKUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKUSER,
					args);

				args = new Object[] {
						typeTaskUsersModelImpl.getTypeTaskId(),
						typeTaskUsersModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASKUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKUSER,
					args);
			}

			if ((typeTaskUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKTYPEUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskUsersModelImpl.getOriginalTypeTaskId(),
						typeTaskUsersModelImpl.getOriginalTypeUser()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASKTYPEUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKTYPEUSER,
					args);

				args = new Object[] {
						typeTaskUsersModelImpl.getTypeTaskId(),
						typeTaskUsersModelImpl.getTypeUser()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETASKTYPEUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETASKTYPEUSER,
					args);
			}

			if ((typeTaskUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskUsersModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { typeTaskUsersModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((typeTaskUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTaskUsersModelImpl.getOriginalUserId(),
						typeTaskUsersModelImpl.getOriginalTypeUser()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEUSER,
					args);

				args = new Object[] {
						typeTaskUsersModelImpl.getUserId(),
						typeTaskUsersModelImpl.getTypeUser()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTaskUsersImpl.class, typeTaskUsers.getPrimaryKey(),
			typeTaskUsers);

		clearUniqueFindersCache(typeTaskUsers);
		cacheUniqueFindersCache(typeTaskUsers);

		return typeTaskUsers;
	}

	protected TypeTaskUsers toUnwrappedModel(TypeTaskUsers typeTaskUsers) {
		if (typeTaskUsers instanceof TypeTaskUsersImpl) {
			return typeTaskUsers;
		}

		TypeTaskUsersImpl typeTaskUsersImpl = new TypeTaskUsersImpl();

		typeTaskUsersImpl.setNew(typeTaskUsers.isNew());
		typeTaskUsersImpl.setPrimaryKey(typeTaskUsers.getPrimaryKey());

		typeTaskUsersImpl.setTypeTaskUsersId(typeTaskUsers.getTypeTaskUsersId());
		typeTaskUsersImpl.setUserIdCreate(typeTaskUsers.getUserIdCreate());
		typeTaskUsersImpl.setCreateDate(typeTaskUsers.getCreateDate());
		typeTaskUsersImpl.setTypeTaskId(typeTaskUsers.getTypeTaskId());
		typeTaskUsersImpl.setUserId(typeTaskUsers.getUserId());
		typeTaskUsersImpl.setTypeUser(typeTaskUsers.getTypeUser());

		return typeTaskUsersImpl;
	}

	/**
	 * Returns the type task users with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the type task users
	 * @return the type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeTaskUsersException, SystemException {
		TypeTaskUsers typeTaskUsers = fetchByPrimaryKey(primaryKey);

		if (typeTaskUsers == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeTaskUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return typeTaskUsers;
	}

	/**
	 * Returns the type task users with the primary key or throws a {@link br.com.prodevelopment.etask.NoSuchTypeTaskUsersException} if it could not be found.
	 *
	 * @param typeTaskUsersId the primary key of the type task users
	 * @return the type task users
	 * @throws br.com.prodevelopment.etask.NoSuchTypeTaskUsersException if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers findByPrimaryKey(long typeTaskUsersId)
		throws NoSuchTypeTaskUsersException, SystemException {
		return findByPrimaryKey((Serializable)typeTaskUsersId);
	}

	/**
	 * Returns the type task users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the type task users
	 * @return the type task users, or <code>null</code> if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TypeTaskUsers typeTaskUsers = (TypeTaskUsers)EntityCacheUtil.getResult(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
				TypeTaskUsersImpl.class, primaryKey);

		if (typeTaskUsers == _nullTypeTaskUsers) {
			return null;
		}

		if (typeTaskUsers == null) {
			Session session = null;

			try {
				session = openSession();

				typeTaskUsers = (TypeTaskUsers)session.get(TypeTaskUsersImpl.class,
						primaryKey);

				if (typeTaskUsers != null) {
					cacheResult(typeTaskUsers);
				}
				else {
					EntityCacheUtil.putResult(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
						TypeTaskUsersImpl.class, primaryKey, _nullTypeTaskUsers);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TypeTaskUsersModelImpl.ENTITY_CACHE_ENABLED,
					TypeTaskUsersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return typeTaskUsers;
	}

	/**
	 * Returns the type task users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeTaskUsersId the primary key of the type task users
	 * @return the type task users, or <code>null</code> if a type task users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTaskUsers fetchByPrimaryKey(long typeTaskUsersId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)typeTaskUsersId);
	}

	/**
	 * Returns all the type task userses.
	 *
	 * @return the type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type task userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @return the range of type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the type task userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.etask.model.impl.TypeTaskUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of type task userses
	 * @param end the upper bound of the range of type task userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type task userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTaskUsers> findAll(int start, int end,
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

		List<TypeTaskUsers> list = (List<TypeTaskUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TYPETASKUSERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TYPETASKUSERS;

				if (pagination) {
					sql = sql.concat(TypeTaskUsersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTaskUsers>(list);
				}
				else {
					list = (List<TypeTaskUsers>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the type task userses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TypeTaskUsers typeTaskUsers : findAll()) {
			remove(typeTaskUsers);
		}
	}

	/**
	 * Returns the number of type task userses.
	 *
	 * @return the number of type task userses
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

				Query q = session.createQuery(_SQL_COUNT_TYPETASKUSERS);

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
	 * Initializes the type task users persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.etask.model.TypeTaskUsers")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TypeTaskUsers>> listenersList = new ArrayList<ModelListener<TypeTaskUsers>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TypeTaskUsers>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TypeTaskUsersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TYPETASKUSERS = "SELECT typeTaskUsers FROM TypeTaskUsers typeTaskUsers";
	private static final String _SQL_SELECT_TYPETASKUSERS_WHERE = "SELECT typeTaskUsers FROM TypeTaskUsers typeTaskUsers WHERE ";
	private static final String _SQL_COUNT_TYPETASKUSERS = "SELECT COUNT(typeTaskUsers) FROM TypeTaskUsers typeTaskUsers";
	private static final String _SQL_COUNT_TYPETASKUSERS_WHERE = "SELECT COUNT(typeTaskUsers) FROM TypeTaskUsers typeTaskUsers WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "typeTaskUsers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TypeTaskUsers exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TypeTaskUsers exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TypeTaskUsersPersistenceImpl.class);
	private static TypeTaskUsers _nullTypeTaskUsers = new TypeTaskUsersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TypeTaskUsers> toCacheModel() {
				return _nullTypeTaskUsersCacheModel;
			}
		};

	private static CacheModel<TypeTaskUsers> _nullTypeTaskUsersCacheModel = new CacheModel<TypeTaskUsers>() {
			@Override
			public TypeTaskUsers toEntityModel() {
				return _nullTypeTaskUsers;
			}
		};
}