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

package br.com.prodevelopment.contato.service.persistence;

import br.com.prodevelopment.contato.NoSuchContatoException;
import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.model.impl.ContatoImpl;
import br.com.prodevelopment.contato.model.impl.ContatoModelImpl;

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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.CharPool;
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
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the contato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see ContatoPersistence
 * @see ContatoUtil
 * @generated
 */
public class ContatoPersistenceImpl extends BasePersistenceImpl<Contato>
	implements ContatoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContatoUtil} to access the contato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContatoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contatos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByCompanyId(long companyId, int start, int end,
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

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByCompanyId_First(companyId, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByCompanyId_Last(companyId, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByCompanyId_PrevAndNext(long contatoId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, contato, companyId,
					orderByComparator, true);

			array[1] = contato;

			array[2] = getByCompanyId_PrevAndNext(session, contato, companyId,
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

	protected Contato getByCompanyId_PrevAndNext(Session session,
		Contato contato, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Contato contato : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching contatos
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

			query.append(_SQL_COUNT_CONTATO_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "contato.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.GROUPID_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contatos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G(long companyId, long groupId, int start,
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

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						(groupId != contato.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_First(companyId, groupId, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_Last(companyId, groupId, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_G_PrevAndNext(long contatoId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_G_PrevAndNext(session, contato, companyId,
					groupId, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_G_PrevAndNext(session, contato, companyId,
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

	protected Contato getByC_G_PrevAndNext(Session session, Contato contato,
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

		query.append(_SQL_SELECT_CONTATO_WHERE);

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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (Contato contato : findByC_G(companyId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching contatos
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

			query.append(_SQL_COUNT_CONTATO_WHERE);

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

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "contato.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACCOUNTID =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccountId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCOUNTID =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAccountId",
			new String[] { Long.class.getName() },
			ContatoModelImpl.ACCOUNTID_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACCOUNTID = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAccountId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contatos where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByAccountId(long accountId)
		throws SystemException {
		return findByAccountId(accountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contatos where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByAccountId(long accountId, int start, int end)
		throws SystemException {
		return findByAccountId(accountId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByAccountId(long accountId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCOUNTID;
			finderArgs = new Object[] { accountId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACCOUNTID;
			finderArgs = new Object[] { accountId, start, end, orderByComparator };
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((accountId != contato.getAccountId())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(accountId);

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByAccountId_First(long accountId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByAccountId_First(accountId, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accountId=");
		msg.append(accountId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByAccountId_First(long accountId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByAccountId(accountId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByAccountId_Last(long accountId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByAccountId_Last(accountId, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accountId=");
		msg.append(accountId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByAccountId_Last(long accountId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAccountId(accountId);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByAccountId(accountId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where accountId = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByAccountId_PrevAndNext(long contatoId,
		long accountId, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByAccountId_PrevAndNext(session, contato, accountId,
					orderByComparator, true);

			array[1] = contato;

			array[2] = getByAccountId_PrevAndNext(session, contato, accountId,
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

	protected Contato getByAccountId_PrevAndNext(Session session,
		Contato contato, long accountId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(accountId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAccountId(long accountId) throws SystemException {
		for (Contato contato : findByAccountId(accountId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAccountId(long accountId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACCOUNTID;

		Object[] finderArgs = new Object[] { accountId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(accountId);

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

	private static final String _FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2 = "contato.accountId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CONTATO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByContato",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContatoModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			ContatoModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTATO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContato",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the contato where classNameId = &#63; and classPK = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchContatoException} if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByContato(long classNameId, long classPK)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByContato(classNameId, classPK);

		if (contato == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContatoException(msg.toString());
		}

		return contato;
	}

	/**
	 * Returns the contato where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByContato(long classNameId, long classPK)
		throws SystemException {
		return fetchByContato(classNameId, classPK, true);
	}

	/**
	 * Returns the contato where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByContato(long classNameId, long classPK,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTATO,
					finderArgs, this);
		}

		if (result instanceof Contato) {
			Contato contato = (Contato)result;

			if ((classNameId != contato.getClassNameId()) ||
					(classPK != contato.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_CONTATO_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CONTATO_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<Contato> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTATO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ContatoPersistenceImpl.fetchByContato(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Contato contato = list.get(0);

					result = contato;

					cacheResult(contato);

					if ((contato.getClassNameId() != classNameId) ||
							(contato.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTATO,
							finderArgs, contato);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTATO,
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
			return (Contato)result;
		}
	}

	/**
	 * Removes the contato where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the contato that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato removeByContato(long classNameId, long classPK)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByContato(classNameId, classPK);

		return remove(contato);
	}

	/**
	 * Returns the number of contatos where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContato(long classNameId, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTATO;

		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_CONTATO_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CONTATO_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_CONTATO_CLASSNAMEID_2 = "contato.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_CONTATO_CLASSPK_2 = "contato.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_CARGO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_CARGO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CARGO =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_CARGO",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.CARGOID_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_CARGO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_CARGO",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contatos where companyId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_CARGO(long companyId, long cargoId)
		throws SystemException {
		return findByC_CARGO(companyId, cargoId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and cargoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_CARGO(long companyId, long cargoId, int start,
		int end) throws SystemException {
		return findByC_CARGO(companyId, cargoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and cargoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_CARGO(long companyId, long cargoId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CARGO;
			finderArgs = new Object[] { companyId, cargoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_CARGO;
			finderArgs = new Object[] {
					companyId, cargoId,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						(cargoId != contato.getCargoId())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_CARGO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_CARGO_CARGOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(cargoId);

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_CARGO_First(long companyId, long cargoId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_CARGO_First(companyId, cargoId,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", cargoId=");
		msg.append(cargoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_CARGO_First(long companyId, long cargoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByC_CARGO(companyId, cargoId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_CARGO_Last(long companyId, long cargoId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_CARGO_Last(companyId, cargoId,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", cargoId=");
		msg.append(cargoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_CARGO_Last(long companyId, long cargoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_CARGO(companyId, cargoId);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_CARGO(companyId, cargoId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and cargoId = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_CARGO_PrevAndNext(long contatoId, long companyId,
		long cargoId, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_CARGO_PrevAndNext(session, contato, companyId,
					cargoId, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_CARGO_PrevAndNext(session, contato, companyId,
					cargoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contato getByC_CARGO_PrevAndNext(Session session,
		Contato contato, long companyId, long cargoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_C_CARGO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_CARGO_CARGOID_2);

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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(cargoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and cargoId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_CARGO(long companyId, long cargoId)
		throws SystemException {
		for (Contato contato : findByC_CARGO(companyId, cargoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param cargoId the cargo ID
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_CARGO(long companyId, long cargoId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_CARGO;

		Object[] finderArgs = new Object[] { companyId, cargoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_CARGO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_CARGO_CARGOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_C_CARGO_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_CARGO_CARGOID_2 = "contato.cargoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_CARGO =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_CARGO",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CARGO =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_CARGO",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.GROUPID_COLUMN_BITMASK |
			ContatoModelImpl.CARGOID_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_CARGO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_CARGO",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_CARGO(long companyId, long groupId,
		long cargoId) throws SystemException {
		return findByC_G_CARGO(companyId, groupId, cargoId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_CARGO(long companyId, long groupId,
		long cargoId, int start, int end) throws SystemException {
		return findByC_G_CARGO(companyId, groupId, cargoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_CARGO(long companyId, long groupId,
		long cargoId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CARGO;
			finderArgs = new Object[] { companyId, groupId, cargoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_CARGO;
			finderArgs = new Object[] {
					companyId, groupId, cargoId,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						(groupId != contato.getGroupId()) ||
						(cargoId != contato.getCargoId())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_CARGO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_CARGO_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_CARGO_CARGOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(cargoId);

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_CARGO_First(long companyId, long groupId,
		long cargoId, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_CARGO_First(companyId, groupId, cargoId,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", cargoId=");
		msg.append(cargoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_CARGO_First(long companyId, long groupId,
		long cargoId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contato> list = findByC_G_CARGO(companyId, groupId, cargoId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_CARGO_Last(long companyId, long groupId,
		long cargoId, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_CARGO_Last(companyId, groupId, cargoId,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", cargoId=");
		msg.append(cargoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_CARGO_Last(long companyId, long groupId,
		long cargoId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_CARGO(companyId, groupId, cargoId);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_G_CARGO(companyId, groupId, cargoId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_G_CARGO_PrevAndNext(long contatoId,
		long companyId, long groupId, long cargoId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_G_CARGO_PrevAndNext(session, contato, companyId,
					groupId, cargoId, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_G_CARGO_PrevAndNext(session, contato, companyId,
					groupId, cargoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contato getByC_G_CARGO_PrevAndNext(Session session,
		Contato contato, long companyId, long groupId, long cargoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_C_G_CARGO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_CARGO_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_CARGO_CARGOID_2);

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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(cargoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_CARGO(long companyId, long groupId, long cargoId)
		throws SystemException {
		for (Contato contato : findByC_G_CARGO(companyId, groupId, cargoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param cargoId the cargo ID
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_CARGO(long companyId, long groupId, long cargoId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_CARGO;

		Object[] finderArgs = new Object[] { companyId, groupId, cargoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_CARGO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_CARGO_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_CARGO_CARGOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_C_G_CARGO_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_CARGO_GROUPID_2 = "contato.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_CARGO_CARGOID_2 = "contato.cargoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CARGO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCARGO",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCARGO",
			new String[] { Long.class.getName() },
			ContatoModelImpl.CARGOID_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARGO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCARGO",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contatos where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByCARGO(long cargoId) throws SystemException {
		return findByCARGO(cargoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where cargoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cargoId the cargo ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByCARGO(long cargoId, int start, int end)
		throws SystemException {
		return findByCARGO(cargoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where cargoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cargoId the cargo ID
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByCARGO(long cargoId, int start, int end,
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

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((cargoId != contato.getCargoId())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_CARGO_CARGOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cargoId);

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByCARGO_First(long cargoId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByCARGO_First(cargoId, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cargoId=");
		msg.append(cargoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByCARGO_First(long cargoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByCARGO(cargoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByCARGO_Last(long cargoId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByCARGO_Last(cargoId, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cargoId=");
		msg.append(cargoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByCARGO_Last(long cargoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCARGO(cargoId);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByCARGO(cargoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where cargoId = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param cargoId the cargo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByCARGO_PrevAndNext(long contatoId, long cargoId,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByCARGO_PrevAndNext(session, contato, cargoId,
					orderByComparator, true);

			array[1] = contato;

			array[2] = getByCARGO_PrevAndNext(session, contato, cargoId,
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

	protected Contato getByCARGO_PrevAndNext(Session session, Contato contato,
		long cargoId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cargoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where cargoId = &#63; from the database.
	 *
	 * @param cargoId the cargo ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCARGO(long cargoId) throws SystemException {
		for (Contato contato : findByCARGO(cargoId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where cargoId = &#63;.
	 *
	 * @param cargoId the cargo ID
	 * @return the number of matching contatos
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

			query.append(_SQL_COUNT_CONTATO_WHERE);

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

	private static final String _FINDER_COLUMN_CARGO_CARGOID_2 = "contato.cargoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_NOME",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOME = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NOME",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the contatos where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_NOME(long companyId, String nome)
		throws SystemException {
		return findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_NOME(long companyId, String nome, int start,
		int end) throws SystemException {
		return findByC_NOME(companyId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_NOME(long companyId, String nome, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOME;
		finderArgs = new Object[] { companyId, nome, start, end, orderByComparator };

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						!StringUtil.wildcardMatches(contato.getNome(), nome,
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

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
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_NOME_First(companyId, nome, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_NOME_First(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByC_NOME(companyId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_NOME_Last(companyId, nome, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_NOME_Last(long companyId, String nome,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_NOME(companyId, nome);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_NOME(companyId, nome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_NOME_PrevAndNext(long contatoId, long companyId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_NOME_PrevAndNext(session, contato, companyId,
					nome, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_NOME_PrevAndNext(session, contato, companyId,
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

	protected Contato getByC_NOME_PrevAndNext(Session session, Contato contato,
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

		query.append(_SQL_SELECT_CONTATO_WHERE);

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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_NOME(long companyId, String nome)
		throws SystemException {
		for (Contato contato : findByC_NOME(companyId, nome, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param nome the nome
	 * @return the number of matching contatos
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

			query.append(_SQL_COUNT_CONTATO_WHERE);

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

	private static final String _FINDER_COLUMN_C_NOME_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_NOME_NOME_1 = "contato.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_NOME_NOME_2 = "contato.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_NOME_NOME_3 = "(contato.nome IS NULL OR contato.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_NOME = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_NOME =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_NOME",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_NOME(long companyId, long groupId,
		String nome) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_NOME(long companyId, long groupId,
		String nome, int start, int end) throws SystemException {
		return findByC_G_NOME(companyId, groupId, nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_NOME(long companyId, long groupId,
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

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						(groupId != contato.getGroupId()) ||
						!StringUtil.wildcardMatches(contato.getNome(), nome,
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

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
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_NOME_First(companyId, groupId, nome,
				orderByComparator);

		if (contato != null) {
			return contato;
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

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_NOME_First(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contato> list = findByC_G_NOME(companyId, groupId, nome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_NOME_Last(companyId, groupId, nome,
				orderByComparator);

		if (contato != null) {
			return contato;
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

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_NOME_Last(long companyId, long groupId,
		String nome, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_NOME(companyId, groupId, nome);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_G_NOME(companyId, groupId, nome,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_G_NOME_PrevAndNext(long contatoId, long companyId,
		long groupId, String nome, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_G_NOME_PrevAndNext(session, contato, companyId,
					groupId, nome, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_G_NOME_PrevAndNext(session, contato, companyId,
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

	protected Contato getByC_G_NOME_PrevAndNext(Session session,
		Contato contato, long companyId, long groupId, String nome,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_NOME(long companyId, long groupId, String nome)
		throws SystemException {
		for (Contato contato : findByC_G_NOME(companyId, groupId, nome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param nome the nome
	 * @return the number of matching contatos
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

			query.append(_SQL_COUNT_CONTATO_WHERE);

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

	private static final String _FINDER_COLUMN_C_G_NOME_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_GROUPID_2 = "contato.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_1 = "contato.nome LIKE NULL";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_2 = "contato.nome LIKE ?";
	private static final String _FINDER_COLUMN_C_G_NOME_NOME_3 = "(contato.nome IS NULL OR contato.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOME = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNOME",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOME = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNOME",
			new String[] { String.class.getName() });

	/**
	 * Returns all the contatos where nome LIKE &#63;.
	 *
	 * @param nome the nome
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByNOME(String nome) throws SystemException {
		return findByNOME(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByNOME(String nome, int start, int end)
		throws SystemException {
		return findByNOME(nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where nome LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByNOME(String nome, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOME;
		finderArgs = new Object[] { nome, start, end, orderByComparator };

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if (!StringUtil.wildcardMatches(contato.getNome(), nome,
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_NOME_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNome) {
					qPos.add(nome);
				}

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where nome LIKE &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByNOME_First(String nome,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByNOME_First(nome, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where nome LIKE &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByNOME_First(String nome,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByNOME(nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where nome LIKE &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByNOME_Last(String nome,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByNOME_Last(nome, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where nome LIKE &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByNOME_Last(String nome,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNOME(nome);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByNOME(nome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where nome LIKE &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByNOME_PrevAndNext(long contatoId, String nome,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByNOME_PrevAndNext(session, contato, nome,
					orderByComparator, true);

			array[1] = contato;

			array[2] = getByNOME_PrevAndNext(session, contato, nome,
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

	protected Contato getByNOME_PrevAndNext(Session session, Contato contato,
		String nome, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		boolean bindNome = false;

		if (nome == null) {
			query.append(_FINDER_COLUMN_NOME_NOME_1);
		}
		else if (nome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_NOME_NOME_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where nome LIKE &#63; from the database.
	 *
	 * @param nome the nome
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNOME(String nome) throws SystemException {
		for (Contato contato : findByNOME(nome, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where nome LIKE &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNOME(String nome) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOME;

		Object[] finderArgs = new Object[] { nome };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			boolean bindNome = false;

			if (nome == null) {
				query.append(_FINDER_COLUMN_NOME_NOME_1);
			}
			else if (nome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_NOME_NOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_NOME_NOME_1 = "contato.nome LIKE NULL";
	private static final String _FINDER_COLUMN_NOME_NOME_2 = "contato.nome LIKE ?";
	private static final String _FINDER_COLUMN_NOME_NOME_3 = "(contato.nome IS NULL OR contato.nome LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_DTN = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_DTN",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_DTN = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_DTN",
			new String[] { Long.class.getName(), Date.class.getName() },
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_DTN = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_DTN",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the contatos where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_DTN(long companyId, Date dataNascimento)
		throws SystemException {
		return findByC_DTN(companyId, dataNascimento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_DTN(long companyId, Date dataNascimento,
		int start, int end) throws SystemException {
		return findByC_DTN(companyId, dataNascimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_DTN(long companyId, Date dataNascimento,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_DTN;
			finderArgs = new Object[] { companyId, dataNascimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_DTN;
			finderArgs = new Object[] {
					companyId, dataNascimento,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						!Validator.equals(dataNascimento,
							contato.getDataNascimento())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_DTN_COMPANYID_2);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_C_DTN_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_C_DTN_DATANASCIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindDataNascimento) {
					qPos.add(CalendarUtil.getTimestamp(dataNascimento));
				}

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_DTN_First(long companyId, Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_DTN_First(companyId, dataNascimento,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_DTN_First(long companyId, Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByC_DTN(companyId, dataNascimento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_DTN_Last(long companyId, Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_DTN_Last(companyId, dataNascimento,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_DTN_Last(long companyId, Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_DTN(companyId, dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_DTN(companyId, dataNascimento, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_DTN_PrevAndNext(long contatoId, long companyId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_DTN_PrevAndNext(session, contato, companyId,
					dataNascimento, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_DTN_PrevAndNext(session, contato, companyId,
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

	protected Contato getByC_DTN_PrevAndNext(Session session, Contato contato,
		long companyId, Date dataNascimento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_C_DTN_COMPANYID_2);

		boolean bindDataNascimento = false;

		if (dataNascimento == null) {
			query.append(_FINDER_COLUMN_C_DTN_DATANASCIMENTO_1);
		}
		else {
			bindDataNascimento = true;

			query.append(_FINDER_COLUMN_C_DTN_DATANASCIMENTO_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindDataNascimento) {
			qPos.add(CalendarUtil.getTimestamp(dataNascimento));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and dataNascimento = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_DTN(long companyId, Date dataNascimento)
		throws SystemException {
		for (Contato contato : findByC_DTN(companyId, dataNascimento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_DTN(long companyId, Date dataNascimento)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_DTN;

		Object[] finderArgs = new Object[] { companyId, dataNascimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_DTN_COMPANYID_2);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_C_DTN_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_C_DTN_DATANASCIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_C_DTN_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_DTN_DATANASCIMENTO_1 = "contato.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_C_DTN_DATANASCIMENTO_2 = "contato.dataNascimento = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_DTN = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_DTN",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_DTN =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_DTN",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.GROUPID_COLUMN_BITMASK |
			ContatoModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_DTN = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_DTN",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_DTN(long companyId, long groupId,
		Date dataNascimento) throws SystemException {
		return findByC_G_DTN(companyId, groupId, dataNascimento,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_DTN(long companyId, long groupId,
		Date dataNascimento, int start, int end) throws SystemException {
		return findByC_G_DTN(companyId, groupId, dataNascimento, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_DTN(long companyId, long groupId,
		Date dataNascimento, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_DTN;
			finderArgs = new Object[] { companyId, groupId, dataNascimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_DTN;
			finderArgs = new Object[] {
					companyId, groupId, dataNascimento,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						(groupId != contato.getGroupId()) ||
						!Validator.equals(dataNascimento,
							contato.getDataNascimento())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_DTN_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_DTN_GROUPID_2);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_C_G_DTN_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_C_G_DTN_DATANASCIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindDataNascimento) {
					qPos.add(CalendarUtil.getTimestamp(dataNascimento));
				}

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_DTN_First(long companyId, long groupId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_DTN_First(companyId, groupId,
				dataNascimento, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_DTN_First(long companyId, long groupId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contato> list = findByC_G_DTN(companyId, groupId, dataNascimento,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_DTN_Last(long companyId, long groupId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_DTN_Last(companyId, groupId,
				dataNascimento, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_DTN_Last(long companyId, long groupId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_DTN(companyId, groupId, dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_G_DTN(companyId, groupId, dataNascimento,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_G_DTN_PrevAndNext(long contatoId, long companyId,
		long groupId, Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_G_DTN_PrevAndNext(session, contato, companyId,
					groupId, dataNascimento, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_G_DTN_PrevAndNext(session, contato, companyId,
					groupId, dataNascimento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contato getByC_G_DTN_PrevAndNext(Session session,
		Contato contato, long companyId, long groupId, Date dataNascimento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_C_G_DTN_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_DTN_GROUPID_2);

		boolean bindDataNascimento = false;

		if (dataNascimento == null) {
			query.append(_FINDER_COLUMN_C_G_DTN_DATANASCIMENTO_1);
		}
		else {
			bindDataNascimento = true;

			query.append(_FINDER_COLUMN_C_G_DTN_DATANASCIMENTO_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindDataNascimento) {
			qPos.add(CalendarUtil.getTimestamp(dataNascimento));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_DTN(long companyId, long groupId,
		Date dataNascimento) throws SystemException {
		for (Contato contato : findByC_G_DTN(companyId, groupId,
				dataNascimento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_DTN(long companyId, long groupId, Date dataNascimento)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_DTN;

		Object[] finderArgs = new Object[] { companyId, groupId, dataNascimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_DTN_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_DTN_GROUPID_2);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_C_G_DTN_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_C_G_DTN_DATANASCIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_C_G_DTN_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_DTN_GROUPID_2 = "contato.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_DTN_DATANASCIMENTO_1 = "contato.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_C_G_DTN_DATANASCIMENTO_2 = "contato.dataNascimento = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DTN = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDTN",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DTN = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDTN",
			new String[] { Date.class.getName() },
			ContatoModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DTN = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDTN",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the contatos where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByDTN(Date dataNascimento)
		throws SystemException {
		return findByDTN(dataNascimento, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contatos where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByDTN(Date dataNascimento, int start, int end)
		throws SystemException {
		return findByDTN(dataNascimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByDTN(Date dataNascimento, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DTN;
			finderArgs = new Object[] { dataNascimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DTN;
			finderArgs = new Object[] {
					dataNascimento,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if (!Validator.equals(dataNascimento,
							contato.getDataNascimento())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_DTN_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_DTN_DATANASCIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByDTN_First(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByDTN_First(dataNascimento, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByDTN_First(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByDTN(dataNascimento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByDTN_Last(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByDTN_Last(dataNascimento, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByDTN_Last(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDTN(dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByDTN(dataNascimento, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByDTN_PrevAndNext(long contatoId, Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByDTN_PrevAndNext(session, contato, dataNascimento,
					orderByComparator, true);

			array[1] = contato;

			array[2] = getByDTN_PrevAndNext(session, contato, dataNascimento,
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

	protected Contato getByDTN_PrevAndNext(Session session, Contato contato,
		Date dataNascimento, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		boolean bindDataNascimento = false;

		if (dataNascimento == null) {
			query.append(_FINDER_COLUMN_DTN_DATANASCIMENTO_1);
		}
		else {
			bindDataNascimento = true;

			query.append(_FINDER_COLUMN_DTN_DATANASCIMENTO_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where dataNascimento = &#63; from the database.
	 *
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDTN(Date dataNascimento) throws SystemException {
		for (Contato contato : findByDTN(dataNascimento, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDTN(Date dataNascimento) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DTN;

		Object[] finderArgs = new Object[] { dataNascimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_DTN_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_DTN_DATANASCIMENTO_2);
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

	private static final String _FINDER_COLUMN_DTN_DATANASCIMENTO_1 = "contato.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_DTN_DATANASCIMENTO_2 = "contato.dataNascimento = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_EMAIL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_EMAIL",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_EMAIL =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_EMAIL",
			new String[] { Long.class.getName(), String.class.getName() },
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.ENDEMAIL_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_EMAIL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_EMAIL",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the contatos where companyId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_EMAIL(long companyId, String endEmail)
		throws SystemException {
		return findByC_EMAIL(companyId, endEmail, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and endEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_EMAIL(long companyId, String endEmail,
		int start, int end) throws SystemException {
		return findByC_EMAIL(companyId, endEmail, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and endEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_EMAIL(long companyId, String endEmail,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_EMAIL;
			finderArgs = new Object[] { companyId, endEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_EMAIL;
			finderArgs = new Object[] {
					companyId, endEmail,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						!Validator.equals(endEmail, contato.getEndEmail())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_EMAIL_COMPANYID_2);

			boolean bindEndEmail = false;

			if (endEmail == null) {
				query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_1);
			}
			else if (endEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_3);
			}
			else {
				bindEndEmail = true;

				query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindEndEmail) {
					qPos.add(endEmail);
				}

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_EMAIL_First(long companyId, String endEmail,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_EMAIL_First(companyId, endEmail,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", endEmail=");
		msg.append(endEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_EMAIL_First(long companyId, String endEmail,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByC_EMAIL(companyId, endEmail, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_EMAIL_Last(long companyId, String endEmail,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_EMAIL_Last(companyId, endEmail,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", endEmail=");
		msg.append(endEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_EMAIL_Last(long companyId, String endEmail,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_EMAIL(companyId, endEmail);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_EMAIL(companyId, endEmail, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and endEmail = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_EMAIL_PrevAndNext(long contatoId, long companyId,
		String endEmail, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_EMAIL_PrevAndNext(session, contato, companyId,
					endEmail, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_EMAIL_PrevAndNext(session, contato, companyId,
					endEmail, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contato getByC_EMAIL_PrevAndNext(Session session,
		Contato contato, long companyId, String endEmail,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_C_EMAIL_COMPANYID_2);

		boolean bindEndEmail = false;

		if (endEmail == null) {
			query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_1);
		}
		else if (endEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_3);
		}
		else {
			bindEndEmail = true;

			query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindEndEmail) {
			qPos.add(endEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and endEmail = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_EMAIL(long companyId, String endEmail)
		throws SystemException {
		for (Contato contato : findByC_EMAIL(companyId, endEmail,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param endEmail the end email
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_EMAIL(long companyId, String endEmail)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_EMAIL;

		Object[] finderArgs = new Object[] { companyId, endEmail };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_EMAIL_COMPANYID_2);

			boolean bindEndEmail = false;

			if (endEmail == null) {
				query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_1);
			}
			else if (endEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_3);
			}
			else {
				bindEndEmail = true;

				query.append(_FINDER_COLUMN_C_EMAIL_ENDEMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindEndEmail) {
					qPos.add(endEmail);
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

	private static final String _FINDER_COLUMN_C_EMAIL_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_EMAIL_ENDEMAIL_1 = "contato.endEmail IS NULL";
	private static final String _FINDER_COLUMN_C_EMAIL_ENDEMAIL_2 = "contato.endEmail = ?";
	private static final String _FINDER_COLUMN_C_EMAIL_ENDEMAIL_3 = "(contato.endEmail IS NULL OR contato.endEmail = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_EMAIL =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_EMAIL",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_EMAIL =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_EMAIL",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.GROUPID_COLUMN_BITMASK |
			ContatoModelImpl.ENDEMAIL_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_EMAIL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_EMAIL",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_EMAIL(long companyId, long groupId,
		String endEmail) throws SystemException {
		return findByC_G_EMAIL(companyId, groupId, endEmail, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_EMAIL(long companyId, long groupId,
		String endEmail, int start, int end) throws SystemException {
		return findByC_G_EMAIL(companyId, groupId, endEmail, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_EMAIL(long companyId, long groupId,
		String endEmail, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_EMAIL;
			finderArgs = new Object[] { companyId, groupId, endEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_EMAIL;
			finderArgs = new Object[] {
					companyId, groupId, endEmail,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						(groupId != contato.getGroupId()) ||
						!Validator.equals(endEmail, contato.getEndEmail())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_EMAIL_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_EMAIL_GROUPID_2);

			boolean bindEndEmail = false;

			if (endEmail == null) {
				query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_1);
			}
			else if (endEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_3);
			}
			else {
				bindEndEmail = true;

				query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindEndEmail) {
					qPos.add(endEmail);
				}

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_EMAIL_First(long companyId, long groupId,
		String endEmail, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_EMAIL_First(companyId, groupId, endEmail,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", endEmail=");
		msg.append(endEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_EMAIL_First(long companyId, long groupId,
		String endEmail, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contato> list = findByC_G_EMAIL(companyId, groupId, endEmail, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_EMAIL_Last(long companyId, long groupId,
		String endEmail, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_EMAIL_Last(companyId, groupId, endEmail,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", endEmail=");
		msg.append(endEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_EMAIL_Last(long companyId, long groupId,
		String endEmail, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_EMAIL(companyId, groupId, endEmail);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_G_EMAIL(companyId, groupId, endEmail,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_G_EMAIL_PrevAndNext(long contatoId,
		long companyId, long groupId, String endEmail,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_G_EMAIL_PrevAndNext(session, contato, companyId,
					groupId, endEmail, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_G_EMAIL_PrevAndNext(session, contato, companyId,
					groupId, endEmail, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contato getByC_G_EMAIL_PrevAndNext(Session session,
		Contato contato, long companyId, long groupId, String endEmail,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_C_G_EMAIL_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_EMAIL_GROUPID_2);

		boolean bindEndEmail = false;

		if (endEmail == null) {
			query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_1);
		}
		else if (endEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_3);
		}
		else {
			bindEndEmail = true;

			query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindEndEmail) {
			qPos.add(endEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_EMAIL(long companyId, long groupId, String endEmail)
		throws SystemException {
		for (Contato contato : findByC_G_EMAIL(companyId, groupId, endEmail,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param endEmail the end email
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_EMAIL(long companyId, long groupId, String endEmail)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_EMAIL;

		Object[] finderArgs = new Object[] { companyId, groupId, endEmail };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_EMAIL_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_EMAIL_GROUPID_2);

			boolean bindEndEmail = false;

			if (endEmail == null) {
				query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_1);
			}
			else if (endEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_3);
			}
			else {
				bindEndEmail = true;

				query.append(_FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindEndEmail) {
					qPos.add(endEmail);
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

	private static final String _FINDER_COLUMN_C_G_EMAIL_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_EMAIL_GROUPID_2 = "contato.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_1 = "contato.endEmail IS NULL";
	private static final String _FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_2 = "contato.endEmail = ?";
	private static final String _FINDER_COLUMN_C_G_EMAIL_ENDEMAIL_3 = "(contato.endEmail IS NULL OR contato.endEmail = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEMAIL",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEMAIL",
			new String[] { String.class.getName() },
			ContatoModelImpl.ENDEMAIL_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEMAIL",
			new String[] { String.class.getName() });

	/**
	 * Returns all the contatos where endEmail = &#63;.
	 *
	 * @param endEmail the end email
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByEMAIL(String endEmail) throws SystemException {
		return findByEMAIL(endEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where endEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endEmail the end email
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByEMAIL(String endEmail, int start, int end)
		throws SystemException {
		return findByEMAIL(endEmail, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where endEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endEmail the end email
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByEMAIL(String endEmail, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { endEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { endEmail, start, end, orderByComparator };
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if (!Validator.equals(endEmail, contato.getEndEmail())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			boolean bindEndEmail = false;

			if (endEmail == null) {
				query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_1);
			}
			else if (endEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_3);
			}
			else {
				bindEndEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndEmail) {
					qPos.add(endEmail);
				}

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where endEmail = &#63;.
	 *
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByEMAIL_First(String endEmail,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByEMAIL_First(endEmail, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endEmail=");
		msg.append(endEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where endEmail = &#63;.
	 *
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByEMAIL_First(String endEmail,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByEMAIL(endEmail, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where endEmail = &#63;.
	 *
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByEMAIL_Last(String endEmail,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByEMAIL_Last(endEmail, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endEmail=");
		msg.append(endEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where endEmail = &#63;.
	 *
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByEMAIL_Last(String endEmail,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEMAIL(endEmail);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByEMAIL(endEmail, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where endEmail = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param endEmail the end email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByEMAIL_PrevAndNext(long contatoId, String endEmail,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByEMAIL_PrevAndNext(session, contato, endEmail,
					orderByComparator, true);

			array[1] = contato;

			array[2] = getByEMAIL_PrevAndNext(session, contato, endEmail,
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

	protected Contato getByEMAIL_PrevAndNext(Session session, Contato contato,
		String endEmail, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		boolean bindEndEmail = false;

		if (endEmail == null) {
			query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_1);
		}
		else if (endEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_3);
		}
		else {
			bindEndEmail = true;

			query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEndEmail) {
			qPos.add(endEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where endEmail = &#63; from the database.
	 *
	 * @param endEmail the end email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEMAIL(String endEmail) throws SystemException {
		for (Contato contato : findByEMAIL(endEmail, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where endEmail = &#63;.
	 *
	 * @param endEmail the end email
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEMAIL(String endEmail) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { endEmail };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			boolean bindEndEmail = false;

			if (endEmail == null) {
				query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_1);
			}
			else if (endEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_3);
			}
			else {
				bindEndEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_ENDEMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndEmail) {
					qPos.add(endEmail);
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

	private static final String _FINDER_COLUMN_EMAIL_ENDEMAIL_1 = "contato.endEmail IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_ENDEMAIL_2 = "contato.endEmail = ?";
	private static final String _FINDER_COLUMN_EMAIL_ENDEMAIL_3 = "(contato.endEmail IS NULL OR contato.endEmail = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_SEXO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_SEXO",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_SEXO =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_SEXO",
			new String[] { Long.class.getName(), Date.class.getName() },
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_SEXO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_SEXO",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the contatos where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_SEXO(long companyId, Date dataNascimento)
		throws SystemException {
		return findByC_SEXO(companyId, dataNascimento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_SEXO(long companyId, Date dataNascimento,
		int start, int end) throws SystemException {
		return findByC_SEXO(companyId, dataNascimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_SEXO(long companyId, Date dataNascimento,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_SEXO;
			finderArgs = new Object[] { companyId, dataNascimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_SEXO;
			finderArgs = new Object[] {
					companyId, dataNascimento,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						!Validator.equals(dataNascimento,
							contato.getDataNascimento())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_SEXO_COMPANYID_2);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_C_SEXO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_C_SEXO_DATANASCIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindDataNascimento) {
					qPos.add(CalendarUtil.getTimestamp(dataNascimento));
				}

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_SEXO_First(long companyId, Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_SEXO_First(companyId, dataNascimento,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_SEXO_First(long companyId, Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findByC_SEXO(companyId, dataNascimento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_SEXO_Last(long companyId, Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_SEXO_Last(companyId, dataNascimento,
				orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_SEXO_Last(long companyId, Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_SEXO(companyId, dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_SEXO(companyId, dataNascimento, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_SEXO_PrevAndNext(long contatoId, long companyId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_SEXO_PrevAndNext(session, contato, companyId,
					dataNascimento, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_SEXO_PrevAndNext(session, contato, companyId,
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

	protected Contato getByC_SEXO_PrevAndNext(Session session, Contato contato,
		long companyId, Date dataNascimento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_C_SEXO_COMPANYID_2);

		boolean bindDataNascimento = false;

		if (dataNascimento == null) {
			query.append(_FINDER_COLUMN_C_SEXO_DATANASCIMENTO_1);
		}
		else {
			bindDataNascimento = true;

			query.append(_FINDER_COLUMN_C_SEXO_DATANASCIMENTO_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindDataNascimento) {
			qPos.add(CalendarUtil.getTimestamp(dataNascimento));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and dataNascimento = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_SEXO(long companyId, Date dataNascimento)
		throws SystemException {
		for (Contato contato : findByC_SEXO(companyId, dataNascimento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param dataNascimento the data nascimento
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_SEXO(long companyId, Date dataNascimento)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_SEXO;

		Object[] finderArgs = new Object[] { companyId, dataNascimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_SEXO_COMPANYID_2);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_C_SEXO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_C_SEXO_DATANASCIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_C_SEXO_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_SEXO_DATANASCIMENTO_1 = "contato.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_C_SEXO_DATANASCIMENTO_2 = "contato.dataNascimento = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_SEXO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_SEXO",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_SEXO =
		new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_SEXO",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			ContatoModelImpl.COMPANYID_COLUMN_BITMASK |
			ContatoModelImpl.GROUPID_COLUMN_BITMASK |
			ContatoModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_SEXO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_SEXO",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_SEXO(long companyId, long groupId,
		Date dataNascimento) throws SystemException {
		return findByC_G_SEXO(companyId, groupId, dataNascimento,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_SEXO(long companyId, long groupId,
		Date dataNascimento, int start, int end) throws SystemException {
		return findByC_G_SEXO(companyId, groupId, dataNascimento, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findByC_G_SEXO(long companyId, long groupId,
		Date dataNascimento, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_SEXO;
			finderArgs = new Object[] { companyId, groupId, dataNascimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_SEXO;
			finderArgs = new Object[] {
					companyId, groupId, dataNascimento,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if ((companyId != contato.getCompanyId()) ||
						(groupId != contato.getGroupId()) ||
						!Validator.equals(dataNascimento,
							contato.getDataNascimento())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_SEXO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_SEXO_GROUPID_2);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_C_G_SEXO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_C_G_SEXO_DATANASCIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindDataNascimento) {
					qPos.add(CalendarUtil.getTimestamp(dataNascimento));
				}

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_SEXO_First(long companyId, long groupId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_SEXO_First(companyId, groupId,
				dataNascimento, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_SEXO_First(long companyId, long groupId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contato> list = findByC_G_SEXO(companyId, groupId, dataNascimento,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByC_G_SEXO_Last(long companyId, long groupId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByC_G_SEXO_Last(companyId, groupId,
				dataNascimento, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByC_G_SEXO_Last(long companyId, long groupId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_SEXO(companyId, groupId, dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findByC_G_SEXO(companyId, groupId, dataNascimento,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findByC_G_SEXO_PrevAndNext(long contatoId, long companyId,
		long groupId, Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getByC_G_SEXO_PrevAndNext(session, contato, companyId,
					groupId, dataNascimento, orderByComparator, true);

			array[1] = contato;

			array[2] = getByC_G_SEXO_PrevAndNext(session, contato, companyId,
					groupId, dataNascimento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contato getByC_G_SEXO_PrevAndNext(Session session,
		Contato contato, long companyId, long groupId, Date dataNascimento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		query.append(_FINDER_COLUMN_C_G_SEXO_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_SEXO_GROUPID_2);

		boolean bindDataNascimento = false;

		if (dataNascimento == null) {
			query.append(_FINDER_COLUMN_C_G_SEXO_DATANASCIMENTO_1);
		}
		else {
			bindDataNascimento = true;

			query.append(_FINDER_COLUMN_C_G_SEXO_DATANASCIMENTO_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindDataNascimento) {
			qPos.add(CalendarUtil.getTimestamp(dataNascimento));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_SEXO(long companyId, long groupId,
		Date dataNascimento) throws SystemException {
		for (Contato contato : findByC_G_SEXO(companyId, groupId,
				dataNascimento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param dataNascimento the data nascimento
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_SEXO(long companyId, long groupId, Date dataNascimento)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_SEXO;

		Object[] finderArgs = new Object[] { companyId, groupId, dataNascimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			query.append(_FINDER_COLUMN_C_G_SEXO_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_SEXO_GROUPID_2);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_C_G_SEXO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_C_G_SEXO_DATANASCIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_C_G_SEXO_COMPANYID_2 = "contato.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_SEXO_GROUPID_2 = "contato.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_SEXO_DATANASCIMENTO_1 = "contato.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_C_G_SEXO_DATANASCIMENTO_2 = "contato.dataNascimento = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEXO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySEXO",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEXO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySEXO",
			new String[] { Date.class.getName() },
			ContatoModelImpl.DATANASCIMENTO_COLUMN_BITMASK |
			ContatoModelImpl.NOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEXO = new FinderPath(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySEXO",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the contatos where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findBySEXO(Date dataNascimento)
		throws SystemException {
		return findBySEXO(dataNascimento, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contatos where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findBySEXO(Date dataNascimento, int start, int end)
		throws SystemException {
		return findBySEXO(dataNascimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos where dataNascimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataNascimento the data nascimento
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findBySEXO(Date dataNascimento, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEXO;
			finderArgs = new Object[] { dataNascimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEXO;
			finderArgs = new Object[] {
					dataNascimento,
					
					start, end, orderByComparator
				};
		}

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contato contato : list) {
				if (!Validator.equals(dataNascimento,
							contato.getDataNascimento())) {
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

			query.append(_SQL_SELECT_CONTATO_WHERE);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_SEXO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_SEXO_DATANASCIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findBySEXO_First(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchBySEXO_First(dataNascimento, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the first contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchBySEXO_First(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contato> list = findBySEXO(dataNascimento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findBySEXO_Last(Date dataNascimento,
		OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchBySEXO_Last(dataNascimento, orderByComparator);

		if (contato != null) {
			return contato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataNascimento=");
		msg.append(dataNascimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContatoException(msg.toString());
	}

	/**
	 * Returns the last contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contato, or <code>null</code> if a matching contato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchBySEXO_Last(Date dataNascimento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySEXO(dataNascimento);

		if (count == 0) {
			return null;
		}

		List<Contato> list = findBySEXO(dataNascimento, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contatos before and after the current contato in the ordered set where dataNascimento = &#63;.
	 *
	 * @param contatoId the primary key of the current contato
	 * @param dataNascimento the data nascimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato[] findBySEXO_PrevAndNext(long contatoId,
		Date dataNascimento, OrderByComparator orderByComparator)
		throws NoSuchContatoException, SystemException {
		Contato contato = findByPrimaryKey(contatoId);

		Session session = null;

		try {
			session = openSession();

			Contato[] array = new ContatoImpl[3];

			array[0] = getBySEXO_PrevAndNext(session, contato, dataNascimento,
					orderByComparator, true);

			array[1] = contato;

			array[2] = getBySEXO_PrevAndNext(session, contato, dataNascimento,
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

	protected Contato getBySEXO_PrevAndNext(Session session, Contato contato,
		Date dataNascimento, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTATO_WHERE);

		boolean bindDataNascimento = false;

		if (dataNascimento == null) {
			query.append(_FINDER_COLUMN_SEXO_DATANASCIMENTO_1);
		}
		else {
			bindDataNascimento = true;

			query.append(_FINDER_COLUMN_SEXO_DATANASCIMENTO_2);
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
			query.append(ContatoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(contato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contatos where dataNascimento = &#63; from the database.
	 *
	 * @param dataNascimento the data nascimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySEXO(Date dataNascimento) throws SystemException {
		for (Contato contato : findBySEXO(dataNascimento, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos where dataNascimento = &#63;.
	 *
	 * @param dataNascimento the data nascimento
	 * @return the number of matching contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySEXO(Date dataNascimento) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEXO;

		Object[] finderArgs = new Object[] { dataNascimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTATO_WHERE);

			boolean bindDataNascimento = false;

			if (dataNascimento == null) {
				query.append(_FINDER_COLUMN_SEXO_DATANASCIMENTO_1);
			}
			else {
				bindDataNascimento = true;

				query.append(_FINDER_COLUMN_SEXO_DATANASCIMENTO_2);
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

	private static final String _FINDER_COLUMN_SEXO_DATANASCIMENTO_1 = "contato.dataNascimento IS NULL";
	private static final String _FINDER_COLUMN_SEXO_DATANASCIMENTO_2 = "contato.dataNascimento = ?";

	public ContatoPersistenceImpl() {
		setModelClass(Contato.class);
	}

	/**
	 * Caches the contato in the entity cache if it is enabled.
	 *
	 * @param contato the contato
	 */
	@Override
	public void cacheResult(Contato contato) {
		EntityCacheUtil.putResult(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoImpl.class, contato.getPrimaryKey(), contato);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTATO,
			new Object[] { contato.getClassNameId(), contato.getClassPK() },
			contato);

		contato.resetOriginalValues();
	}

	/**
	 * Caches the contatos in the entity cache if it is enabled.
	 *
	 * @param contatos the contatos
	 */
	@Override
	public void cacheResult(List<Contato> contatos) {
		for (Contato contato : contatos) {
			if (EntityCacheUtil.getResult(
						ContatoModelImpl.ENTITY_CACHE_ENABLED,
						ContatoImpl.class, contato.getPrimaryKey()) == null) {
				cacheResult(contato);
			}
			else {
				contato.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contatos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContatoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContatoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contato.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Contato contato) {
		EntityCacheUtil.removeResult(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoImpl.class, contato.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(contato);
	}

	@Override
	public void clearCache(List<Contato> contatos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Contato contato : contatos) {
			EntityCacheUtil.removeResult(ContatoModelImpl.ENTITY_CACHE_ENABLED,
				ContatoImpl.class, contato.getPrimaryKey());

			clearUniqueFindersCache(contato);
		}
	}

	protected void cacheUniqueFindersCache(Contato contato) {
		if (contato.isNew()) {
			Object[] args = new Object[] {
					contato.getClassNameId(), contato.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTATO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTATO, args,
				contato);
		}
		else {
			ContatoModelImpl contatoModelImpl = (ContatoModelImpl)contato;

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONTATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contato.getClassNameId(), contato.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTATO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTATO, args,
					contato);
			}
		}
	}

	protected void clearUniqueFindersCache(Contato contato) {
		ContatoModelImpl contatoModelImpl = (ContatoModelImpl)contato;

		Object[] args = new Object[] {
				contato.getClassNameId(), contato.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTATO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTATO, args);

		if ((contatoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONTATO.getColumnBitmask()) != 0) {
			args = new Object[] {
					contatoModelImpl.getOriginalClassNameId(),
					contatoModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTATO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTATO, args);
		}
	}

	/**
	 * Creates a new contato with the primary key. Does not add the contato to the database.
	 *
	 * @param contatoId the primary key for the new contato
	 * @return the new contato
	 */
	@Override
	public Contato create(long contatoId) {
		Contato contato = new ContatoImpl();

		contato.setNew(true);
		contato.setPrimaryKey(contatoId);

		return contato;
	}

	/**
	 * Removes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contatoId the primary key of the contato
	 * @return the contato that was removed
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato remove(long contatoId)
		throws NoSuchContatoException, SystemException {
		return remove((Serializable)contatoId);
	}

	/**
	 * Removes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contato
	 * @return the contato that was removed
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato remove(Serializable primaryKey)
		throws NoSuchContatoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Contato contato = (Contato)session.get(ContatoImpl.class, primaryKey);

			if (contato == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contato);
		}
		catch (NoSuchContatoException nsee) {
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
	protected Contato removeImpl(Contato contato) throws SystemException {
		contato = toUnwrappedModel(contato);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contato)) {
				contato = (Contato)session.get(ContatoImpl.class,
						contato.getPrimaryKeyObj());
			}

			if (contato != null) {
				session.delete(contato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contato != null) {
			clearCache(contato);
		}

		return contato;
	}

	@Override
	public Contato updateImpl(
		br.com.prodevelopment.contato.model.Contato contato)
		throws SystemException {
		contato = toUnwrappedModel(contato);

		boolean isNew = contato.isNew();

		ContatoModelImpl contatoModelImpl = (ContatoModelImpl)contato;

		Session session = null;

		try {
			session = openSession();

			if (contato.isNew()) {
				session.save(contato);

				contato.setNew(false);
			}
			else {
				session.merge(contato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContatoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { contatoModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCOUNTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalAccountId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACCOUNTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCOUNTID,
					args);

				args = new Object[] { contatoModelImpl.getAccountId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACCOUNTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCOUNTID,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CARGO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalCargoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_CARGO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CARGO,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getCargoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_CARGO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_CARGO,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CARGO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalGroupId(),
						contatoModelImpl.getOriginalCargoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_CARGO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CARGO,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getGroupId(),
						contatoModelImpl.getCargoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_CARGO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CARGO,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCargoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARGO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO,
					args);

				args = new Object[] { contatoModelImpl.getCargoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARGO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARGO,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_DTN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_DTN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_DTN,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_DTN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_DTN,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_DTN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalGroupId(),
						contatoModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_DTN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_DTN,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getGroupId(),
						contatoModelImpl.getDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_DTN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_DTN,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DTN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DTN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DTN,
					args);

				args = new Object[] { contatoModelImpl.getDataNascimento() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DTN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DTN,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalEndEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_EMAIL,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getEndEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_EMAIL,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalGroupId(),
						contatoModelImpl.getOriginalEndEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_EMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_EMAIL,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getGroupId(),
						contatoModelImpl.getEndEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_EMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_EMAIL,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalEndEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] { contatoModelImpl.getEndEmail() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_SEXO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_SEXO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_SEXO,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_SEXO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_SEXO,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_SEXO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalCompanyId(),
						contatoModelImpl.getOriginalGroupId(),
						contatoModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_SEXO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_SEXO,
					args);

				args = new Object[] {
						contatoModelImpl.getCompanyId(),
						contatoModelImpl.getGroupId(),
						contatoModelImpl.getDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_SEXO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_SEXO,
					args);
			}

			if ((contatoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEXO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contatoModelImpl.getOriginalDataNascimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEXO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEXO,
					args);

				args = new Object[] { contatoModelImpl.getDataNascimento() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEXO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEXO,
					args);
			}
		}

		EntityCacheUtil.putResult(ContatoModelImpl.ENTITY_CACHE_ENABLED,
			ContatoImpl.class, contato.getPrimaryKey(), contato);

		clearUniqueFindersCache(contato);
		cacheUniqueFindersCache(contato);

		return contato;
	}

	protected Contato toUnwrappedModel(Contato contato) {
		if (contato instanceof ContatoImpl) {
			return contato;
		}

		ContatoImpl contatoImpl = new ContatoImpl();

		contatoImpl.setNew(contato.isNew());
		contatoImpl.setPrimaryKey(contato.getPrimaryKey());

		contatoImpl.setContatoId(contato.getContatoId());
		contatoImpl.setCompanyId(contato.getCompanyId());
		contatoImpl.setGroupId(contato.getGroupId());
		contatoImpl.setCreateUserId(contato.getCreateUserId());
		contatoImpl.setModifiedUserId(contato.getModifiedUserId());
		contatoImpl.setCreateDate(contato.getCreateDate());
		contatoImpl.setModifiedDate(contato.getModifiedDate());
		contatoImpl.setClassNameId(contato.getClassNameId());
		contatoImpl.setClassPK(contato.getClassPK());
		contatoImpl.setAccountId(contato.getAccountId());
		contatoImpl.setEndEmail(contato.getEndEmail());
		contatoImpl.setNome(contato.getNome());
		contatoImpl.setSexo(contato.getSexo());
		contatoImpl.setDataNascimento(contato.getDataNascimento());
		contatoImpl.setCargoId(contato.getCargoId());
		contatoImpl.setSkype(contato.getSkype());
		contatoImpl.setFacebook(contato.getFacebook());
		contatoImpl.setTwitter(contato.getTwitter());

		return contatoImpl;
	}

	/**
	 * Returns the contato with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contato
	 * @return the contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContatoException, SystemException {
		Contato contato = fetchByPrimaryKey(primaryKey);

		if (contato == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contato;
	}

	/**
	 * Returns the contato with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchContatoException} if it could not be found.
	 *
	 * @param contatoId the primary key of the contato
	 * @return the contato
	 * @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato findByPrimaryKey(long contatoId)
		throws NoSuchContatoException, SystemException {
		return findByPrimaryKey((Serializable)contatoId);
	}

	/**
	 * Returns the contato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contato
	 * @return the contato, or <code>null</code> if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Contato contato = (Contato)EntityCacheUtil.getResult(ContatoModelImpl.ENTITY_CACHE_ENABLED,
				ContatoImpl.class, primaryKey);

		if (contato == _nullContato) {
			return null;
		}

		if (contato == null) {
			Session session = null;

			try {
				session = openSession();

				contato = (Contato)session.get(ContatoImpl.class, primaryKey);

				if (contato != null) {
					cacheResult(contato);
				}
				else {
					EntityCacheUtil.putResult(ContatoModelImpl.ENTITY_CACHE_ENABLED,
						ContatoImpl.class, primaryKey, _nullContato);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContatoModelImpl.ENTITY_CACHE_ENABLED,
					ContatoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contato;
	}

	/**
	 * Returns the contato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contatoId the primary key of the contato
	 * @return the contato, or <code>null</code> if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato fetchByPrimaryKey(long contatoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)contatoId);
	}

	/**
	 * Returns all the contatos.
	 *
	 * @return the contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contato> findAll(int start, int end,
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

		List<Contato> list = (List<Contato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTATO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTATO;

				if (pagination) {
					sql = sql.concat(ContatoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contato>(list);
				}
				else {
					list = (List<Contato>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the contatos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Contato contato : findAll()) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos.
	 *
	 * @return the number of contatos
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

				Query q = session.createQuery(_SQL_COUNT_CONTATO);

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
	 * Initializes the contato persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.contato.model.Contato")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Contato>> listenersList = new ArrayList<ModelListener<Contato>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Contato>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContatoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTATO = "SELECT contato FROM Contato contato";
	private static final String _SQL_SELECT_CONTATO_WHERE = "SELECT contato FROM Contato contato WHERE ";
	private static final String _SQL_COUNT_CONTATO = "SELECT COUNT(contato) FROM Contato contato";
	private static final String _SQL_COUNT_CONTATO_WHERE = "SELECT COUNT(contato) FROM Contato contato WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contato.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contato exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contato exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContatoPersistenceImpl.class);
	private static Contato _nullContato = new ContatoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Contato> toCacheModel() {
				return _nullContatoCacheModel;
			}
		};

	private static CacheModel<Contato> _nullContatoCacheModel = new CacheModel<Contato>() {
			@Override
			public Contato toEntityModel() {
				return _nullContato;
			}
		};
}