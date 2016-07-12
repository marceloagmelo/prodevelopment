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

import br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException;
import br.com.prodevelopment.eticket.model.TypeTicketUsers;
import br.com.prodevelopment.eticket.model.impl.TypeTicketUsersImpl;
import br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the type ticket users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TypeTicketUsersPersistence
 * @see TypeTicketUsersUtil
 * @generated
 */
public class TypeTicketUsersPersistenceImpl extends BasePersistenceImpl<TypeTicketUsers>
	implements TypeTicketUsersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TypeTicketUsersUtil} to access the type ticket users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TypeTicketUsersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTicketUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTicketUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPETICKET =
		new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTicketUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeTicket",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETICKET =
		new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTicketUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypeTicket",
			new String[] { Long.class.getName() },
			TypeTicketUsersModelImpl.TYPETICKETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPETICKET = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeTicket",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the type ticket userses where typeTicketId = &#63;.
	 *
	 * @param typeTicketId the type ticket ID
	 * @return the matching type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findByTypeTicket(long typeTicketId)
		throws SystemException {
		return findByTypeTicket(typeTicketId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type ticket userses where typeTicketId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeTicketId the type ticket ID
	 * @param start the lower bound of the range of type ticket userses
	 * @param end the upper bound of the range of type ticket userses (not inclusive)
	 * @return the range of matching type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findByTypeTicket(long typeTicketId, int start,
		int end) throws SystemException {
		return findByTypeTicket(typeTicketId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type ticket userses where typeTicketId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeTicketId the type ticket ID
	 * @param start the lower bound of the range of type ticket userses
	 * @param end the upper bound of the range of type ticket userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findByTypeTicket(long typeTicketId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETICKET;
			finderArgs = new Object[] { typeTicketId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPETICKET;
			finderArgs = new Object[] {
					typeTicketId,
					
					start, end, orderByComparator
				};
		}

		List<TypeTicketUsers> list = (List<TypeTicketUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTicketUsers typeTicketUsers : list) {
				if ((typeTicketId != typeTicketUsers.getTypeTicketId())) {
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

			query.append(_SQL_SELECT_TYPETICKETUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETICKET_TYPETICKETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTicketUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTicketId);

				if (!pagination) {
					list = (List<TypeTicketUsers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicketUsers>(list);
				}
				else {
					list = (List<TypeTicketUsers>)QueryUtil.list(q,
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
	 * Returns the first type ticket users in the ordered set where typeTicketId = &#63;.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers findByTypeTicket_First(long typeTicketId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = fetchByTypeTicket_First(typeTicketId,
				orderByComparator);

		if (typeTicketUsers != null) {
			return typeTicketUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeTicketId=");
		msg.append(typeTicketId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketUsersException(msg.toString());
	}

	/**
	 * Returns the first type ticket users in the ordered set where typeTicketId = &#63;.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers fetchByTypeTicket_First(long typeTicketId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTicketUsers> list = findByTypeTicket(typeTicketId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type ticket users in the ordered set where typeTicketId = &#63;.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers findByTypeTicket_Last(long typeTicketId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = fetchByTypeTicket_Last(typeTicketId,
				orderByComparator);

		if (typeTicketUsers != null) {
			return typeTicketUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeTicketId=");
		msg.append(typeTicketId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketUsersException(msg.toString());
	}

	/**
	 * Returns the last type ticket users in the ordered set where typeTicketId = &#63;.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers fetchByTypeTicket_Last(long typeTicketId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeTicket(typeTicketId);

		if (count == 0) {
			return null;
		}

		List<TypeTicketUsers> list = findByTypeTicket(typeTicketId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type ticket userses before and after the current type ticket users in the ordered set where typeTicketId = &#63;.
	 *
	 * @param typeTicketUsersId the primary key of the current type ticket users
	 * @param typeTicketId the type ticket ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers[] findByTypeTicket_PrevAndNext(
		long typeTicketUsersId, long typeTicketId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = findByPrimaryKey(typeTicketUsersId);

		Session session = null;

		try {
			session = openSession();

			TypeTicketUsers[] array = new TypeTicketUsersImpl[3];

			array[0] = getByTypeTicket_PrevAndNext(session, typeTicketUsers,
					typeTicketId, orderByComparator, true);

			array[1] = typeTicketUsers;

			array[2] = getByTypeTicket_PrevAndNext(session, typeTicketUsers,
					typeTicketId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeTicketUsers getByTypeTicket_PrevAndNext(Session session,
		TypeTicketUsers typeTicketUsers, long typeTicketId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETICKETUSERS_WHERE);

		query.append(_FINDER_COLUMN_TYPETICKET_TYPETICKETID_2);

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
			query.append(TypeTicketUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeTicketId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTicketUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTicketUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type ticket userses where typeTicketId = &#63; from the database.
	 *
	 * @param typeTicketId the type ticket ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeTicket(long typeTicketId) throws SystemException {
		for (TypeTicketUsers typeTicketUsers : findByTypeTicket(typeTicketId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTicketUsers);
		}
	}

	/**
	 * Returns the number of type ticket userses where typeTicketId = &#63;.
	 *
	 * @param typeTicketId the type ticket ID
	 * @return the number of matching type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeTicket(long typeTicketId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPETICKET;

		Object[] finderArgs = new Object[] { typeTicketId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TYPETICKETUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPETICKET_TYPETICKETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTicketId);

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

	private static final String _FINDER_COLUMN_TYPETICKET_TYPETICKETID_2 = "typeTicketUsers.typeTicketId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTicketUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTicketUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			TypeTicketUsersModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the type ticket userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findByUser(long userId)
		throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type ticket userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type ticket userses
	 * @param end the upper bound of the range of type ticket userses (not inclusive)
	 * @return the range of matching type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type ticket userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type ticket userses
	 * @param end the upper bound of the range of type ticket userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findByUser(long userId, int start, int end,
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

		List<TypeTicketUsers> list = (List<TypeTicketUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TypeTicketUsers typeTicketUsers : list) {
				if ((userId != typeTicketUsers.getUserId())) {
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

			query.append(_SQL_SELECT_TYPETICKETUSERS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TypeTicketUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TypeTicketUsers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicketUsers>(list);
				}
				else {
					list = (List<TypeTicketUsers>)QueryUtil.list(q,
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
	 * Returns the first type ticket users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = fetchByUser_First(userId,
				orderByComparator);

		if (typeTicketUsers != null) {
			return typeTicketUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketUsersException(msg.toString());
	}

	/**
	 * Returns the first type ticket users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TypeTicketUsers> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type ticket users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = fetchByUser_Last(userId,
				orderByComparator);

		if (typeTicketUsers != null) {
			return typeTicketUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeTicketUsersException(msg.toString());
	}

	/**
	 * Returns the last type ticket users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<TypeTicketUsers> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type ticket userses before and after the current type ticket users in the ordered set where userId = &#63;.
	 *
	 * @param typeTicketUsersId the primary key of the current type ticket users
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers[] findByUser_PrevAndNext(long typeTicketUsersId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = findByPrimaryKey(typeTicketUsersId);

		Session session = null;

		try {
			session = openSession();

			TypeTicketUsers[] array = new TypeTicketUsersImpl[3];

			array[0] = getByUser_PrevAndNext(session, typeTicketUsers, userId,
					orderByComparator, true);

			array[1] = typeTicketUsers;

			array[2] = getByUser_PrevAndNext(session, typeTicketUsers, userId,
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

	protected TypeTicketUsers getByUser_PrevAndNext(Session session,
		TypeTicketUsers typeTicketUsers, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TYPETICKETUSERS_WHERE);

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
			query.append(TypeTicketUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(typeTicketUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TypeTicketUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type ticket userses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (TypeTicketUsers typeTicketUsers : findByUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(typeTicketUsers);
		}
	}

	/**
	 * Returns the number of type ticket userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching type ticket userses
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

			query.append(_SQL_COUNT_TYPETICKETUSERS_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "typeTicketUsers.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TYPEUSER = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED,
			TypeTicketUsersImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTypeUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			TypeTicketUsersModelImpl.TYPETICKETID_COLUMN_BITMASK |
			TypeTicketUsersModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEUSER = new FinderPath(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the type ticket users where typeTicketId = &#63; and userId = &#63; or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException} if it could not be found.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param userId the user ID
	 * @return the matching type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers findByTypeUser(long typeTicketId, long userId)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = fetchByTypeUser(typeTicketId, userId);

		if (typeTicketUsers == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("typeTicketId=");
			msg.append(typeTicketId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTypeTicketUsersException(msg.toString());
		}

		return typeTicketUsers;
	}

	/**
	 * Returns the type ticket users where typeTicketId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param userId the user ID
	 * @return the matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers fetchByTypeUser(long typeTicketId, long userId)
		throws SystemException {
		return fetchByTypeUser(typeTicketId, userId, true);
	}

	/**
	 * Returns the type ticket users where typeTicketId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching type ticket users, or <code>null</code> if a matching type ticket users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers fetchByTypeUser(long typeTicketId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { typeTicketId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TYPEUSER,
					finderArgs, this);
		}

		if (result instanceof TypeTicketUsers) {
			TypeTicketUsers typeTicketUsers = (TypeTicketUsers)result;

			if ((typeTicketId != typeTicketUsers.getTypeTicketId()) ||
					(userId != typeTicketUsers.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TYPETICKETUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPEUSER_TYPETICKETID_2);

			query.append(_FINDER_COLUMN_TYPEUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTicketId);

				qPos.add(userId);

				List<TypeTicketUsers> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEUSER,
						finderArgs, list);
				}
				else {
					TypeTicketUsers typeTicketUsers = list.get(0);

					result = typeTicketUsers;

					cacheResult(typeTicketUsers);

					if ((typeTicketUsers.getTypeTicketId() != typeTicketId) ||
							(typeTicketUsers.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEUSER,
							finderArgs, typeTicketUsers);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEUSER,
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
			return (TypeTicketUsers)result;
		}
	}

	/**
	 * Removes the type ticket users where typeTicketId = &#63; and userId = &#63; from the database.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param userId the user ID
	 * @return the type ticket users that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers removeByTypeUser(long typeTicketId, long userId)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = findByTypeUser(typeTicketId, userId);

		return remove(typeTicketUsers);
	}

	/**
	 * Returns the number of type ticket userses where typeTicketId = &#63; and userId = &#63;.
	 *
	 * @param typeTicketId the type ticket ID
	 * @param userId the user ID
	 * @return the number of matching type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeUser(long typeTicketId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEUSER;

		Object[] finderArgs = new Object[] { typeTicketId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TYPETICKETUSERS_WHERE);

			query.append(_FINDER_COLUMN_TYPEUSER_TYPETICKETID_2);

			query.append(_FINDER_COLUMN_TYPEUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeTicketId);

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

	private static final String _FINDER_COLUMN_TYPEUSER_TYPETICKETID_2 = "typeTicketUsers.typeTicketId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEUSER_USERID_2 = "typeTicketUsers.userId = ?";

	public TypeTicketUsersPersistenceImpl() {
		setModelClass(TypeTicketUsers.class);
	}

	/**
	 * Caches the type ticket users in the entity cache if it is enabled.
	 *
	 * @param typeTicketUsers the type ticket users
	 */
	@Override
	public void cacheResult(TypeTicketUsers typeTicketUsers) {
		EntityCacheUtil.putResult(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersImpl.class, typeTicketUsers.getPrimaryKey(),
			typeTicketUsers);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEUSER,
			new Object[] {
				typeTicketUsers.getTypeTicketId(), typeTicketUsers.getUserId()
			}, typeTicketUsers);

		typeTicketUsers.resetOriginalValues();
	}

	/**
	 * Caches the type ticket userses in the entity cache if it is enabled.
	 *
	 * @param typeTicketUserses the type ticket userses
	 */
	@Override
	public void cacheResult(List<TypeTicketUsers> typeTicketUserses) {
		for (TypeTicketUsers typeTicketUsers : typeTicketUserses) {
			if (EntityCacheUtil.getResult(
						TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
						TypeTicketUsersImpl.class,
						typeTicketUsers.getPrimaryKey()) == null) {
				cacheResult(typeTicketUsers);
			}
			else {
				typeTicketUsers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all type ticket userses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TypeTicketUsersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TypeTicketUsersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the type ticket users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TypeTicketUsers typeTicketUsers) {
		EntityCacheUtil.removeResult(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersImpl.class, typeTicketUsers.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(typeTicketUsers);
	}

	@Override
	public void clearCache(List<TypeTicketUsers> typeTicketUserses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TypeTicketUsers typeTicketUsers : typeTicketUserses) {
			EntityCacheUtil.removeResult(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
				TypeTicketUsersImpl.class, typeTicketUsers.getPrimaryKey());

			clearUniqueFindersCache(typeTicketUsers);
		}
	}

	protected void cacheUniqueFindersCache(TypeTicketUsers typeTicketUsers) {
		if (typeTicketUsers.isNew()) {
			Object[] args = new Object[] {
					typeTicketUsers.getTypeTicketId(),
					typeTicketUsers.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPEUSER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEUSER, args,
				typeTicketUsers);
		}
		else {
			TypeTicketUsersModelImpl typeTicketUsersModelImpl = (TypeTicketUsersModelImpl)typeTicketUsers;

			if ((typeTicketUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TYPEUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTicketUsers.getTypeTicketId(),
						typeTicketUsers.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPEUSER, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEUSER, args,
					typeTicketUsers);
			}
		}
	}

	protected void clearUniqueFindersCache(TypeTicketUsers typeTicketUsers) {
		TypeTicketUsersModelImpl typeTicketUsersModelImpl = (TypeTicketUsersModelImpl)typeTicketUsers;

		Object[] args = new Object[] {
				typeTicketUsers.getTypeTicketId(), typeTicketUsers.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEUSER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEUSER, args);

		if ((typeTicketUsersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TYPEUSER.getColumnBitmask()) != 0) {
			args = new Object[] {
					typeTicketUsersModelImpl.getOriginalTypeTicketId(),
					typeTicketUsersModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEUSER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEUSER, args);
		}
	}

	/**
	 * Creates a new type ticket users with the primary key. Does not add the type ticket users to the database.
	 *
	 * @param typeTicketUsersId the primary key for the new type ticket users
	 * @return the new type ticket users
	 */
	@Override
	public TypeTicketUsers create(long typeTicketUsersId) {
		TypeTicketUsers typeTicketUsers = new TypeTicketUsersImpl();

		typeTicketUsers.setNew(true);
		typeTicketUsers.setPrimaryKey(typeTicketUsersId);

		return typeTicketUsers;
	}

	/**
	 * Removes the type ticket users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeTicketUsersId the primary key of the type ticket users
	 * @return the type ticket users that was removed
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers remove(long typeTicketUsersId)
		throws NoSuchTypeTicketUsersException, SystemException {
		return remove((Serializable)typeTicketUsersId);
	}

	/**
	 * Removes the type ticket users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the type ticket users
	 * @return the type ticket users that was removed
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers remove(Serializable primaryKey)
		throws NoSuchTypeTicketUsersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TypeTicketUsers typeTicketUsers = (TypeTicketUsers)session.get(TypeTicketUsersImpl.class,
					primaryKey);

			if (typeTicketUsers == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeTicketUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(typeTicketUsers);
		}
		catch (NoSuchTypeTicketUsersException nsee) {
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
	protected TypeTicketUsers removeImpl(TypeTicketUsers typeTicketUsers)
		throws SystemException {
		typeTicketUsers = toUnwrappedModel(typeTicketUsers);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(typeTicketUsers)) {
				typeTicketUsers = (TypeTicketUsers)session.get(TypeTicketUsersImpl.class,
						typeTicketUsers.getPrimaryKeyObj());
			}

			if (typeTicketUsers != null) {
				session.delete(typeTicketUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (typeTicketUsers != null) {
			clearCache(typeTicketUsers);
		}

		return typeTicketUsers;
	}

	@Override
	public TypeTicketUsers updateImpl(
		br.com.prodevelopment.eticket.model.TypeTicketUsers typeTicketUsers)
		throws SystemException {
		typeTicketUsers = toUnwrappedModel(typeTicketUsers);

		boolean isNew = typeTicketUsers.isNew();

		TypeTicketUsersModelImpl typeTicketUsersModelImpl = (TypeTicketUsersModelImpl)typeTicketUsers;

		Session session = null;

		try {
			session = openSession();

			if (typeTicketUsers.isNew()) {
				session.save(typeTicketUsers);

				typeTicketUsers.setNew(false);
			}
			else {
				session.merge(typeTicketUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TypeTicketUsersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((typeTicketUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETICKET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTicketUsersModelImpl.getOriginalTypeTicketId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETICKET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETICKET,
					args);

				args = new Object[] { typeTicketUsersModelImpl.getTypeTicketId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPETICKET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPETICKET,
					args);
			}

			if ((typeTicketUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						typeTicketUsersModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { typeTicketUsersModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}
		}

		EntityCacheUtil.putResult(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
			TypeTicketUsersImpl.class, typeTicketUsers.getPrimaryKey(),
			typeTicketUsers);

		clearUniqueFindersCache(typeTicketUsers);
		cacheUniqueFindersCache(typeTicketUsers);

		return typeTicketUsers;
	}

	protected TypeTicketUsers toUnwrappedModel(TypeTicketUsers typeTicketUsers) {
		if (typeTicketUsers instanceof TypeTicketUsersImpl) {
			return typeTicketUsers;
		}

		TypeTicketUsersImpl typeTicketUsersImpl = new TypeTicketUsersImpl();

		typeTicketUsersImpl.setNew(typeTicketUsers.isNew());
		typeTicketUsersImpl.setPrimaryKey(typeTicketUsers.getPrimaryKey());

		typeTicketUsersImpl.setTypeTicketUsersId(typeTicketUsers.getTypeTicketUsersId());
		typeTicketUsersImpl.setUserIdCreate(typeTicketUsers.getUserIdCreate());
		typeTicketUsersImpl.setUserIdModified(typeTicketUsers.getUserIdModified());
		typeTicketUsersImpl.setCreateDate(typeTicketUsers.getCreateDate());
		typeTicketUsersImpl.setModifiedDate(typeTicketUsers.getModifiedDate());
		typeTicketUsersImpl.setTypeTicketId(typeTicketUsers.getTypeTicketId());
		typeTicketUsersImpl.setUserId(typeTicketUsers.getUserId());

		return typeTicketUsersImpl;
	}

	/**
	 * Returns the type ticket users with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the type ticket users
	 * @return the type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeTicketUsersException, SystemException {
		TypeTicketUsers typeTicketUsers = fetchByPrimaryKey(primaryKey);

		if (typeTicketUsers == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeTicketUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return typeTicketUsers;
	}

	/**
	 * Returns the type ticket users with the primary key or throws a {@link br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException} if it could not be found.
	 *
	 * @param typeTicketUsersId the primary key of the type ticket users
	 * @return the type ticket users
	 * @throws br.com.prodevelopment.eticket.NoSuchTypeTicketUsersException if a type ticket users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers findByPrimaryKey(long typeTicketUsersId)
		throws NoSuchTypeTicketUsersException, SystemException {
		return findByPrimaryKey((Serializable)typeTicketUsersId);
	}

	/**
	 * Returns the type ticket users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the type ticket users
	 * @return the type ticket users, or <code>null</code> if a type ticket users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TypeTicketUsers typeTicketUsers = (TypeTicketUsers)EntityCacheUtil.getResult(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
				TypeTicketUsersImpl.class, primaryKey);

		if (typeTicketUsers == _nullTypeTicketUsers) {
			return null;
		}

		if (typeTicketUsers == null) {
			Session session = null;

			try {
				session = openSession();

				typeTicketUsers = (TypeTicketUsers)session.get(TypeTicketUsersImpl.class,
						primaryKey);

				if (typeTicketUsers != null) {
					cacheResult(typeTicketUsers);
				}
				else {
					EntityCacheUtil.putResult(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
						TypeTicketUsersImpl.class, primaryKey,
						_nullTypeTicketUsers);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TypeTicketUsersModelImpl.ENTITY_CACHE_ENABLED,
					TypeTicketUsersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return typeTicketUsers;
	}

	/**
	 * Returns the type ticket users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeTicketUsersId the primary key of the type ticket users
	 * @return the type ticket users, or <code>null</code> if a type ticket users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TypeTicketUsers fetchByPrimaryKey(long typeTicketUsersId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)typeTicketUsersId);
	}

	/**
	 * Returns all the type ticket userses.
	 *
	 * @return the type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type ticket userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of type ticket userses
	 * @param end the upper bound of the range of type ticket userses (not inclusive)
	 * @return the range of type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the type ticket userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.eticket.model.impl.TypeTicketUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of type ticket userses
	 * @param end the upper bound of the range of type ticket userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type ticket userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TypeTicketUsers> findAll(int start, int end,
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

		List<TypeTicketUsers> list = (List<TypeTicketUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TYPETICKETUSERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TYPETICKETUSERS;

				if (pagination) {
					sql = sql.concat(TypeTicketUsersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TypeTicketUsers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TypeTicketUsers>(list);
				}
				else {
					list = (List<TypeTicketUsers>)QueryUtil.list(q,
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
	 * Removes all the type ticket userses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TypeTicketUsers typeTicketUsers : findAll()) {
			remove(typeTicketUsers);
		}
	}

	/**
	 * Returns the number of type ticket userses.
	 *
	 * @return the number of type ticket userses
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

				Query q = session.createQuery(_SQL_COUNT_TYPETICKETUSERS);

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
	 * Initializes the type ticket users persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.eticket.model.TypeTicketUsers")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TypeTicketUsers>> listenersList = new ArrayList<ModelListener<TypeTicketUsers>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TypeTicketUsers>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TypeTicketUsersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TYPETICKETUSERS = "SELECT typeTicketUsers FROM TypeTicketUsers typeTicketUsers";
	private static final String _SQL_SELECT_TYPETICKETUSERS_WHERE = "SELECT typeTicketUsers FROM TypeTicketUsers typeTicketUsers WHERE ";
	private static final String _SQL_COUNT_TYPETICKETUSERS = "SELECT COUNT(typeTicketUsers) FROM TypeTicketUsers typeTicketUsers";
	private static final String _SQL_COUNT_TYPETICKETUSERS_WHERE = "SELECT COUNT(typeTicketUsers) FROM TypeTicketUsers typeTicketUsers WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "typeTicketUsers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TypeTicketUsers exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TypeTicketUsers exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TypeTicketUsersPersistenceImpl.class);
	private static TypeTicketUsers _nullTypeTicketUsers = new TypeTicketUsersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TypeTicketUsers> toCacheModel() {
				return _nullTypeTicketUsersCacheModel;
			}
		};

	private static CacheModel<TypeTicketUsers> _nullTypeTicketUsersCacheModel = new CacheModel<TypeTicketUsers>() {
			@Override
			public TypeTicketUsers toEntityModel() {
				return _nullTypeTicketUsers;
			}
		};
}