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

import br.com.prodevelopment.contato.NoSuchEnderecoEmailException;
import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.model.impl.EnderecoEmailImpl;
import br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl;

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
 * The persistence implementation for the endereco email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see EnderecoEmailPersistence
 * @see EnderecoEmailUtil
 * @generated
 */
public class EnderecoEmailPersistenceImpl extends BasePersistenceImpl<EnderecoEmail>
	implements EnderecoEmailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnderecoEmailUtil} to access the endereco email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnderecoEmailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			EnderecoEmailModelImpl.UUID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the endereco emails where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the endereco emails where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @return the range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the endereco emails where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByUuid(String uuid, int start, int end,
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

		List<EnderecoEmail> list = (List<EnderecoEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EnderecoEmail enderecoEmail : list) {
				if (!Validator.equals(uuid, enderecoEmail.getUuid())) {
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

			query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
				query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnderecoEmail>(list);
				}
				else {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco email in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByUuid_First(uuid, orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the first endereco email in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<EnderecoEmail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco email in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByUuid_Last(uuid, orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the last endereco email in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EnderecoEmail> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the endereco emails before and after the current endereco email in the ordered set where uuid = &#63;.
	 *
	 * @param enderecoEmailId the primary key of the current endereco email
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail[] findByUuid_PrevAndNext(long enderecoEmailId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = findByPrimaryKey(enderecoEmailId);

		Session session = null;

		try {
			session = openSession();

			EnderecoEmail[] array = new EnderecoEmailImpl[3];

			array[0] = getByUuid_PrevAndNext(session, enderecoEmail, uuid,
					orderByComparator, true);

			array[1] = enderecoEmail;

			array[2] = getByUuid_PrevAndNext(session, enderecoEmail, uuid,
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

	protected EnderecoEmail getByUuid_PrevAndNext(Session session,
		EnderecoEmail enderecoEmail, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
			query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(enderecoEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EnderecoEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the endereco emails where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (EnderecoEmail enderecoEmail : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(enderecoEmail);
		}
	}

	/**
	 * Returns the number of endereco emails where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching endereco emails
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

			query.append(_SQL_COUNT_ENDERECOEMAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "enderecoEmail.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "enderecoEmail.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(enderecoEmail.uuid IS NULL OR enderecoEmail.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EnderecoEmailModelImpl.UUID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the endereco email where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoEmailException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByUUID_G(String uuid, long groupId)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByUUID_G(uuid, groupId);

		if (enderecoEmail == null) {
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

			throw new NoSuchEnderecoEmailException(msg.toString());
		}

		return enderecoEmail;
	}

	/**
	 * Returns the endereco email where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the endereco email where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof EnderecoEmail) {
			EnderecoEmail enderecoEmail = (EnderecoEmail)result;

			if (!Validator.equals(uuid, enderecoEmail.getUuid()) ||
					(groupId != enderecoEmail.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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

				List<EnderecoEmail> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					EnderecoEmail enderecoEmail = list.get(0);

					result = enderecoEmail;

					cacheResult(enderecoEmail);

					if ((enderecoEmail.getUuid() == null) ||
							!enderecoEmail.getUuid().equals(uuid) ||
							(enderecoEmail.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, enderecoEmail);
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
			return (EnderecoEmail)result;
		}
	}

	/**
	 * Removes the endereco email where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the endereco email that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail removeByUUID_G(String uuid, long groupId)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = findByUUID_G(uuid, groupId);

		return remove(enderecoEmail);
	}

	/**
	 * Returns the number of endereco emails where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching endereco emails
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

			query.append(_SQL_COUNT_ENDERECOEMAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "enderecoEmail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "enderecoEmail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(enderecoEmail.uuid IS NULL OR enderecoEmail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "enderecoEmail.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EnderecoEmailModelImpl.UUID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the endereco emails where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the endereco emails where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @return the range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the endereco emails where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByUuid_C(String uuid, long companyId,
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

		List<EnderecoEmail> list = (List<EnderecoEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EnderecoEmail enderecoEmail : list) {
				if (!Validator.equals(uuid, enderecoEmail.getUuid()) ||
						(companyId != enderecoEmail.getCompanyId())) {
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

			query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
				query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnderecoEmail>(list);
				}
				else {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the first endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EnderecoEmail> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the last endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EnderecoEmail> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the endereco emails before and after the current endereco email in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param enderecoEmailId the primary key of the current endereco email
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail[] findByUuid_C_PrevAndNext(long enderecoEmailId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = findByPrimaryKey(enderecoEmailId);

		Session session = null;

		try {
			session = openSession();

			EnderecoEmail[] array = new EnderecoEmailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, enderecoEmail, uuid,
					companyId, orderByComparator, true);

			array[1] = enderecoEmail;

			array[2] = getByUuid_C_PrevAndNext(session, enderecoEmail, uuid,
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

	protected EnderecoEmail getByUuid_C_PrevAndNext(Session session,
		EnderecoEmail enderecoEmail, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
			query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(enderecoEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EnderecoEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the endereco emails where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (EnderecoEmail enderecoEmail : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(enderecoEmail);
		}
	}

	/**
	 * Returns the number of endereco emails where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching endereco emails
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

			query.append(_SQL_COUNT_ENDERECOEMAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "enderecoEmail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "enderecoEmail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(enderecoEmail.uuid IS NULL OR enderecoEmail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "enderecoEmail.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId", new String[] { Long.class.getName() },
			EnderecoEmailModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the endereco emails where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the endereco emails where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @return the range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the endereco emails where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<EnderecoEmail> list = (List<EnderecoEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EnderecoEmail enderecoEmail : list) {
				if ((companyId != enderecoEmail.getCompanyId())) {
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

			query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnderecoEmail>(list);
				}
				else {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco email in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the first endereco email in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EnderecoEmail> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco email in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the last endereco email in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<EnderecoEmail> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63;.
	 *
	 * @param enderecoEmailId the primary key of the current endereco email
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail[] findByCompanyId_PrevAndNext(long enderecoEmailId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = findByPrimaryKey(enderecoEmailId);

		Session session = null;

		try {
			session = openSession();

			EnderecoEmail[] array = new EnderecoEmailImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, enderecoEmail,
					companyId, orderByComparator, true);

			array[1] = enderecoEmail;

			array[2] = getByCompanyId_PrevAndNext(session, enderecoEmail,
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

	protected EnderecoEmail getByCompanyId_PrevAndNext(Session session,
		EnderecoEmail enderecoEmail, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
			query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(enderecoEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EnderecoEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the endereco emails where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (EnderecoEmail enderecoEmail : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(enderecoEmail);
		}
	}

	/**
	 * Returns the number of endereco emails where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching endereco emails
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

			query.append(_SQL_COUNT_ENDERECOEMAIL_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "enderecoEmail.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			EnderecoEmailModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the endereco emails where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C(long companyId, long classNameId)
		throws SystemException {
		return findByC_C(companyId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @return the range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C(long companyId, long classNameId,
		int start, int end) throws SystemException {
		return findByC_C(companyId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C(long companyId, long classNameId,
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

		List<EnderecoEmail> list = (List<EnderecoEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EnderecoEmail enderecoEmail : list) {
				if ((companyId != enderecoEmail.getCompanyId()) ||
						(classNameId != enderecoEmail.getClassNameId())) {
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

			query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnderecoEmail>(list);
				}
				else {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByC_C_First(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByC_C_First(companyId, classNameId,
				orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByC_C_First(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EnderecoEmail> list = findByC_C(companyId, classNameId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByC_C_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByC_C_Last(companyId, classNameId,
				orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByC_C_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_C(companyId, classNameId);

		if (count == 0) {
			return null;
		}

		List<EnderecoEmail> list = findByC_C(companyId, classNameId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param enderecoEmailId the primary key of the current endereco email
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail[] findByC_C_PrevAndNext(long enderecoEmailId,
		long companyId, long classNameId, OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = findByPrimaryKey(enderecoEmailId);

		Session session = null;

		try {
			session = openSession();

			EnderecoEmail[] array = new EnderecoEmailImpl[3];

			array[0] = getByC_C_PrevAndNext(session, enderecoEmail, companyId,
					classNameId, orderByComparator, true);

			array[1] = enderecoEmail;

			array[2] = getByC_C_PrevAndNext(session, enderecoEmail, companyId,
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

	protected EnderecoEmail getByC_C_PrevAndNext(Session session,
		EnderecoEmail enderecoEmail, long companyId, long classNameId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
			query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(enderecoEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EnderecoEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the endereco emails where companyId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C(long companyId, long classNameId)
		throws SystemException {
		for (EnderecoEmail enderecoEmail : findByC_C(companyId, classNameId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(enderecoEmail);
		}
	}

	/**
	 * Returns the number of endereco emails where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the number of matching endereco emails
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

			query.append(_SQL_COUNT_ENDERECOEMAIL_WHERE);

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

	private static final String _FINDER_COLUMN_C_C_COMPANYID_2 = "enderecoEmail.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 = "enderecoEmail.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EnderecoEmailModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CLASSPK_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C_C(long companyId, long classNameId,
		long classPK) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @return the range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C_C(long companyId, long classNameId,
		long classPK, int start, int end) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C_C(long companyId, long classNameId,
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

		List<EnderecoEmail> list = (List<EnderecoEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EnderecoEmail enderecoEmail : list) {
				if ((companyId != enderecoEmail.getCompanyId()) ||
						(classNameId != enderecoEmail.getClassNameId()) ||
						(classPK != enderecoEmail.getClassPK())) {
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

			query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnderecoEmail>(list);
				}
				else {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByC_C_C_First(companyId,
				classNameId, classPK, orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
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

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<EnderecoEmail> list = findByC_C_C(companyId, classNameId, classPK,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByC_C_C_Last(companyId, classNameId,
				classPK, orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
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

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C(companyId, classNameId, classPK);

		if (count == 0) {
			return null;
		}

		List<EnderecoEmail> list = findByC_C_C(companyId, classNameId, classPK,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param enderecoEmailId the primary key of the current endereco email
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail[] findByC_C_C_PrevAndNext(long enderecoEmailId,
		long companyId, long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = findByPrimaryKey(enderecoEmailId);

		Session session = null;

		try {
			session = openSession();

			EnderecoEmail[] array = new EnderecoEmailImpl[3];

			array[0] = getByC_C_C_PrevAndNext(session, enderecoEmail,
					companyId, classNameId, classPK, orderByComparator, true);

			array[1] = enderecoEmail;

			array[2] = getByC_C_C_PrevAndNext(session, enderecoEmail,
					companyId, classNameId, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EnderecoEmail getByC_C_C_PrevAndNext(Session session,
		EnderecoEmail enderecoEmail, long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
			query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(enderecoEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EnderecoEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws SystemException {
		for (EnderecoEmail enderecoEmail : findByC_C_C(companyId, classNameId,
				classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(enderecoEmail);
		}
	}

	/**
	 * Returns the number of endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching endereco emails
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

			query.append(_SQL_COUNT_ENDERECOEMAIL_WHERE);

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

	private static final String _FINDER_COLUMN_C_C_C_COMPANYID_2 = "enderecoEmail.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSNAMEID_2 = "enderecoEmail.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSPK_2 = "enderecoEmail.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_P = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P =
		new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED,
			EnderecoEmailImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			EnderecoEmailModelImpl.COMPANYID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CLASSPK_COLUMN_BITMASK |
			EnderecoEmailModelImpl.PRINCIPAL_COLUMN_BITMASK |
			EnderecoEmailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C_P = new FinderPath(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @return the matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal) throws SystemException {
		return findByC_C_C_P(companyId, classNameId, classPK, principal,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @return the range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean principal, int start, int end)
		throws SystemException {
		return findByC_C_C_P(companyId, classNameId, classPK, principal, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findByC_C_C_P(long companyId, long classNameId,
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

		List<EnderecoEmail> list = (List<EnderecoEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EnderecoEmail enderecoEmail : list) {
				if ((companyId != enderecoEmail.getCompanyId()) ||
						(classNameId != enderecoEmail.getClassNameId()) ||
						(classPK != enderecoEmail.getClassPK()) ||
						(principal != enderecoEmail.getPrincipal())) {
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

			query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
				query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnderecoEmail>(list);
				}
				else {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByC_C_C_P_First(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByC_C_C_P_First(companyId,
				classNameId, classPK, principal, orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
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

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the first endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByC_C_C_P_First(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws SystemException {
		List<EnderecoEmail> list = findByC_C_C_P(companyId, classNameId,
				classPK, principal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByC_C_C_P_Last(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByC_C_C_P_Last(companyId,
				classNameId, classPK, principal, orderByComparator);

		if (enderecoEmail != null) {
			return enderecoEmail;
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

		throw new NoSuchEnderecoEmailException(msg.toString());
	}

	/**
	 * Returns the last endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching endereco email, or <code>null</code> if a matching endereco email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByC_C_C_P_Last(long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C_P(companyId, classNameId, classPK, principal);

		if (count == 0) {
			return null;
		}

		List<EnderecoEmail> list = findByC_C_C_P(companyId, classNameId,
				classPK, principal, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the endereco emails before and after the current endereco email in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param enderecoEmailId the primary key of the current endereco email
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail[] findByC_C_C_P_PrevAndNext(long enderecoEmailId,
		long companyId, long classNameId, long classPK, boolean principal,
		OrderByComparator orderByComparator)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = findByPrimaryKey(enderecoEmailId);

		Session session = null;

		try {
			session = openSession();

			EnderecoEmail[] array = new EnderecoEmailImpl[3];

			array[0] = getByC_C_C_P_PrevAndNext(session, enderecoEmail,
					companyId, classNameId, classPK, principal,
					orderByComparator, true);

			array[1] = enderecoEmail;

			array[2] = getByC_C_C_P_PrevAndNext(session, enderecoEmail,
					companyId, classNameId, classPK, principal,
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

	protected EnderecoEmail getByC_C_C_P_PrevAndNext(Session session,
		EnderecoEmail enderecoEmail, long companyId, long classNameId,
		long classPK, boolean principal, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENDERECOEMAIL_WHERE);

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
			query.append(EnderecoEmailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(enderecoEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EnderecoEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63; from the database.
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
		for (EnderecoEmail enderecoEmail : findByC_C_C_P(companyId,
				classNameId, classPK, principal, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(enderecoEmail);
		}
	}

	/**
	 * Returns the number of endereco emails where companyId = &#63; and classNameId = &#63; and classPK = &#63; and principal = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param principal the principal
	 * @return the number of matching endereco emails
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

			query.append(_SQL_COUNT_ENDERECOEMAIL_WHERE);

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

	private static final String _FINDER_COLUMN_C_C_C_P_COMPANYID_2 = "enderecoEmail.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2 = "enderecoEmail.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_CLASSPK_2 = "enderecoEmail.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_PRINCIPAL_2 = "enderecoEmail.principal = ?";

	public EnderecoEmailPersistenceImpl() {
		setModelClass(EnderecoEmail.class);
	}

	/**
	 * Caches the endereco email in the entity cache if it is enabled.
	 *
	 * @param enderecoEmail the endereco email
	 */
	@Override
	public void cacheResult(EnderecoEmail enderecoEmail) {
		EntityCacheUtil.putResult(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailImpl.class, enderecoEmail.getPrimaryKey(),
			enderecoEmail);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { enderecoEmail.getUuid(), enderecoEmail.getGroupId() },
			enderecoEmail);

		enderecoEmail.resetOriginalValues();
	}

	/**
	 * Caches the endereco emails in the entity cache if it is enabled.
	 *
	 * @param enderecoEmails the endereco emails
	 */
	@Override
	public void cacheResult(List<EnderecoEmail> enderecoEmails) {
		for (EnderecoEmail enderecoEmail : enderecoEmails) {
			if (EntityCacheUtil.getResult(
						EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
						EnderecoEmailImpl.class, enderecoEmail.getPrimaryKey()) == null) {
				cacheResult(enderecoEmail);
			}
			else {
				enderecoEmail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all endereco emails.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnderecoEmailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnderecoEmailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the endereco email.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EnderecoEmail enderecoEmail) {
		EntityCacheUtil.removeResult(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailImpl.class, enderecoEmail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(enderecoEmail);
	}

	@Override
	public void clearCache(List<EnderecoEmail> enderecoEmails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EnderecoEmail enderecoEmail : enderecoEmails) {
			EntityCacheUtil.removeResult(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
				EnderecoEmailImpl.class, enderecoEmail.getPrimaryKey());

			clearUniqueFindersCache(enderecoEmail);
		}
	}

	protected void cacheUniqueFindersCache(EnderecoEmail enderecoEmail) {
		if (enderecoEmail.isNew()) {
			Object[] args = new Object[] {
					enderecoEmail.getUuid(), enderecoEmail.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				enderecoEmail);
		}
		else {
			EnderecoEmailModelImpl enderecoEmailModelImpl = (EnderecoEmailModelImpl)enderecoEmail;

			if ((enderecoEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoEmail.getUuid(), enderecoEmail.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					enderecoEmail);
			}
		}
	}

	protected void clearUniqueFindersCache(EnderecoEmail enderecoEmail) {
		EnderecoEmailModelImpl enderecoEmailModelImpl = (EnderecoEmailModelImpl)enderecoEmail;

		Object[] args = new Object[] {
				enderecoEmail.getUuid(), enderecoEmail.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((enderecoEmailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					enderecoEmailModelImpl.getOriginalUuid(),
					enderecoEmailModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new endereco email with the primary key. Does not add the endereco email to the database.
	 *
	 * @param enderecoEmailId the primary key for the new endereco email
	 * @return the new endereco email
	 */
	@Override
	public EnderecoEmail create(long enderecoEmailId) {
		EnderecoEmail enderecoEmail = new EnderecoEmailImpl();

		enderecoEmail.setNew(true);
		enderecoEmail.setPrimaryKey(enderecoEmailId);

		String uuid = PortalUUIDUtil.generate();

		enderecoEmail.setUuid(uuid);

		return enderecoEmail;
	}

	/**
	 * Removes the endereco email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enderecoEmailId the primary key of the endereco email
	 * @return the endereco email that was removed
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail remove(long enderecoEmailId)
		throws NoSuchEnderecoEmailException, SystemException {
		return remove((Serializable)enderecoEmailId);
	}

	/**
	 * Removes the endereco email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the endereco email
	 * @return the endereco email that was removed
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail remove(Serializable primaryKey)
		throws NoSuchEnderecoEmailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EnderecoEmail enderecoEmail = (EnderecoEmail)session.get(EnderecoEmailImpl.class,
					primaryKey);

			if (enderecoEmail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnderecoEmailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(enderecoEmail);
		}
		catch (NoSuchEnderecoEmailException nsee) {
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
	protected EnderecoEmail removeImpl(EnderecoEmail enderecoEmail)
		throws SystemException {
		enderecoEmail = toUnwrappedModel(enderecoEmail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(enderecoEmail)) {
				enderecoEmail = (EnderecoEmail)session.get(EnderecoEmailImpl.class,
						enderecoEmail.getPrimaryKeyObj());
			}

			if (enderecoEmail != null) {
				session.delete(enderecoEmail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (enderecoEmail != null) {
			clearCache(enderecoEmail);
		}

		return enderecoEmail;
	}

	@Override
	public EnderecoEmail updateImpl(
		br.com.prodevelopment.contato.model.EnderecoEmail enderecoEmail)
		throws SystemException {
		enderecoEmail = toUnwrappedModel(enderecoEmail);

		boolean isNew = enderecoEmail.isNew();

		EnderecoEmailModelImpl enderecoEmailModelImpl = (EnderecoEmailModelImpl)enderecoEmail;

		if (Validator.isNull(enderecoEmail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			enderecoEmail.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (enderecoEmail.isNew()) {
				session.save(enderecoEmail);

				enderecoEmail.setNew(false);
			}
			else {
				session.merge(enderecoEmail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EnderecoEmailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((enderecoEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoEmailModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { enderecoEmailModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((enderecoEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoEmailModelImpl.getOriginalUuid(),
						enderecoEmailModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						enderecoEmailModelImpl.getUuid(),
						enderecoEmailModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((enderecoEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoEmailModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { enderecoEmailModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((enderecoEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoEmailModelImpl.getOriginalCompanyId(),
						enderecoEmailModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);

				args = new Object[] {
						enderecoEmailModelImpl.getCompanyId(),
						enderecoEmailModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);
			}

			if ((enderecoEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoEmailModelImpl.getOriginalCompanyId(),
						enderecoEmailModelImpl.getOriginalClassNameId(),
						enderecoEmailModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);

				args = new Object[] {
						enderecoEmailModelImpl.getCompanyId(),
						enderecoEmailModelImpl.getClassNameId(),
						enderecoEmailModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);
			}

			if ((enderecoEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enderecoEmailModelImpl.getOriginalCompanyId(),
						enderecoEmailModelImpl.getOriginalClassNameId(),
						enderecoEmailModelImpl.getOriginalClassPK(),
						enderecoEmailModelImpl.getOriginalPrincipal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P,
					args);

				args = new Object[] {
						enderecoEmailModelImpl.getCompanyId(),
						enderecoEmailModelImpl.getClassNameId(),
						enderecoEmailModelImpl.getClassPK(),
						enderecoEmailModelImpl.getPrincipal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P,
					args);
			}
		}

		EntityCacheUtil.putResult(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
			EnderecoEmailImpl.class, enderecoEmail.getPrimaryKey(),
			enderecoEmail);

		clearUniqueFindersCache(enderecoEmail);
		cacheUniqueFindersCache(enderecoEmail);

		return enderecoEmail;
	}

	protected EnderecoEmail toUnwrappedModel(EnderecoEmail enderecoEmail) {
		if (enderecoEmail instanceof EnderecoEmailImpl) {
			return enderecoEmail;
		}

		EnderecoEmailImpl enderecoEmailImpl = new EnderecoEmailImpl();

		enderecoEmailImpl.setNew(enderecoEmail.isNew());
		enderecoEmailImpl.setPrimaryKey(enderecoEmail.getPrimaryKey());

		enderecoEmailImpl.setUuid(enderecoEmail.getUuid());
		enderecoEmailImpl.setEnderecoEmailId(enderecoEmail.getEnderecoEmailId());
		enderecoEmailImpl.setCompanyId(enderecoEmail.getCompanyId());
		enderecoEmailImpl.setGroupId(enderecoEmail.getGroupId());
		enderecoEmailImpl.setCreateUserId(enderecoEmail.getCreateUserId());
		enderecoEmailImpl.setModifiedUserId(enderecoEmail.getModifiedUserId());
		enderecoEmailImpl.setCreateDate(enderecoEmail.getCreateDate());
		enderecoEmailImpl.setModifiedDate(enderecoEmail.getModifiedDate());
		enderecoEmailImpl.setClassNameId(enderecoEmail.getClassNameId());
		enderecoEmailImpl.setClassPK(enderecoEmail.getClassPK());
		enderecoEmailImpl.setEndereco(enderecoEmail.getEndereco());
		enderecoEmailImpl.setTipo(enderecoEmail.getTipo());
		enderecoEmailImpl.setPrincipal(enderecoEmail.isPrincipal());

		return enderecoEmailImpl;
	}

	/**
	 * Returns the endereco email with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the endereco email
	 * @return the endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEnderecoEmailException, SystemException {
		EnderecoEmail enderecoEmail = fetchByPrimaryKey(primaryKey);

		if (enderecoEmail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEnderecoEmailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return enderecoEmail;
	}

	/**
	 * Returns the endereco email with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchEnderecoEmailException} if it could not be found.
	 *
	 * @param enderecoEmailId the primary key of the endereco email
	 * @return the endereco email
	 * @throws br.com.prodevelopment.contato.NoSuchEnderecoEmailException if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail findByPrimaryKey(long enderecoEmailId)
		throws NoSuchEnderecoEmailException, SystemException {
		return findByPrimaryKey((Serializable)enderecoEmailId);
	}

	/**
	 * Returns the endereco email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the endereco email
	 * @return the endereco email, or <code>null</code> if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EnderecoEmail enderecoEmail = (EnderecoEmail)EntityCacheUtil.getResult(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
				EnderecoEmailImpl.class, primaryKey);

		if (enderecoEmail == _nullEnderecoEmail) {
			return null;
		}

		if (enderecoEmail == null) {
			Session session = null;

			try {
				session = openSession();

				enderecoEmail = (EnderecoEmail)session.get(EnderecoEmailImpl.class,
						primaryKey);

				if (enderecoEmail != null) {
					cacheResult(enderecoEmail);
				}
				else {
					EntityCacheUtil.putResult(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
						EnderecoEmailImpl.class, primaryKey, _nullEnderecoEmail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EnderecoEmailModelImpl.ENTITY_CACHE_ENABLED,
					EnderecoEmailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return enderecoEmail;
	}

	/**
	 * Returns the endereco email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enderecoEmailId the primary key of the endereco email
	 * @return the endereco email, or <code>null</code> if a endereco email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnderecoEmail fetchByPrimaryKey(long enderecoEmailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)enderecoEmailId);
	}

	/**
	 * Returns all the endereco emails.
	 *
	 * @return the endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the endereco emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @return the range of endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the endereco emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.EnderecoEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of endereco emails
	 * @param end the upper bound of the range of endereco emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of endereco emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnderecoEmail> findAll(int start, int end,
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

		List<EnderecoEmail> list = (List<EnderecoEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENDERECOEMAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENDERECOEMAIL;

				if (pagination) {
					sql = sql.concat(EnderecoEmailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnderecoEmail>(list);
				}
				else {
					list = (List<EnderecoEmail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the endereco emails from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EnderecoEmail enderecoEmail : findAll()) {
			remove(enderecoEmail);
		}
	}

	/**
	 * Returns the number of endereco emails.
	 *
	 * @return the number of endereco emails
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

				Query q = session.createQuery(_SQL_COUNT_ENDERECOEMAIL);

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
	 * Initializes the endereco email persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.contato.model.EnderecoEmail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EnderecoEmail>> listenersList = new ArrayList<ModelListener<EnderecoEmail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EnderecoEmail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EnderecoEmailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ENDERECOEMAIL = "SELECT enderecoEmail FROM EnderecoEmail enderecoEmail";
	private static final String _SQL_SELECT_ENDERECOEMAIL_WHERE = "SELECT enderecoEmail FROM EnderecoEmail enderecoEmail WHERE ";
	private static final String _SQL_COUNT_ENDERECOEMAIL = "SELECT COUNT(enderecoEmail) FROM EnderecoEmail enderecoEmail";
	private static final String _SQL_COUNT_ENDERECOEMAIL_WHERE = "SELECT COUNT(enderecoEmail) FROM EnderecoEmail enderecoEmail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enderecoEmail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EnderecoEmail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EnderecoEmail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnderecoEmailPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static EnderecoEmail _nullEnderecoEmail = new EnderecoEmailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EnderecoEmail> toCacheModel() {
				return _nullEnderecoEmailCacheModel;
			}
		};

	private static CacheModel<EnderecoEmail> _nullEnderecoEmailCacheModel = new CacheModel<EnderecoEmail>() {
			@Override
			public EnderecoEmail toEntityModel() {
				return _nullEnderecoEmail;
			}
		};
}