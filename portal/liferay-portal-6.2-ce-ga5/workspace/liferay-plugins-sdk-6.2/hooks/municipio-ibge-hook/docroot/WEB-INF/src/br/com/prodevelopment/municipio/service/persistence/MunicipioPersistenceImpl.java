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

package br.com.prodevelopment.municipio.service.persistence;

import br.com.prodevelopment.municipio.NoSuchMunicipioException;
import br.com.prodevelopment.municipio.model.Municipio;
import br.com.prodevelopment.municipio.model.impl.MunicipioImpl;
import br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl;

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
 * The persistence implementation for the municipio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see MunicipioPersistence
 * @see MunicipioUtil
 * @generated
 */
public class MunicipioPersistenceImpl extends BasePersistenceImpl<Municipio>
	implements MunicipioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MunicipioUtil} to access the municipio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MunicipioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioModelImpl.FINDER_CACHE_ENABLED, MunicipioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioModelImpl.FINDER_CACHE_ENABLED, MunicipioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UF = new FinderPath(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioModelImpl.FINDER_CACHE_ENABLED, MunicipioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUF",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF = new FinderPath(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioModelImpl.FINDER_CACHE_ENABLED, MunicipioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUF",
			new String[] { String.class.getName() },
			MunicipioModelImpl.UF_COLUMN_BITMASK |
			MunicipioModelImpl.CIDADE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UF = new FinderPath(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUF",
			new String[] { String.class.getName() });

	/**
	 * Returns all the municipios where uf = &#63;.
	 *
	 * @param uf the uf
	 * @return the matching municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findByUF(String uf) throws SystemException {
		return findByUF(uf, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the municipios where uf = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uf the uf
	 * @param start the lower bound of the range of municipios
	 * @param end the upper bound of the range of municipios (not inclusive)
	 * @return the range of matching municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findByUF(String uf, int start, int end)
		throws SystemException {
		return findByUF(uf, start, end, null);
	}

	/**
	 * Returns an ordered range of all the municipios where uf = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uf the uf
	 * @param start the lower bound of the range of municipios
	 * @param end the upper bound of the range of municipios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findByUF(String uf, int start, int end,
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

		List<Municipio> list = (List<Municipio>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Municipio municipio : list) {
				if (!Validator.equals(uf, municipio.getUf())) {
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

			query.append(_SQL_SELECT_MUNICIPIO_WHERE);

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
				query.append(MunicipioModelImpl.ORDER_BY_JPQL);
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
					list = (List<Municipio>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Municipio>(list);
				}
				else {
					list = (List<Municipio>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first municipio in the ordered set where uf = &#63;.
	 *
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching municipio
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a matching municipio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio findByUF_First(String uf,
		OrderByComparator orderByComparator)
		throws NoSuchMunicipioException, SystemException {
		Municipio municipio = fetchByUF_First(uf, orderByComparator);

		if (municipio != null) {
			return municipio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uf=");
		msg.append(uf);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMunicipioException(msg.toString());
	}

	/**
	 * Returns the first municipio in the ordered set where uf = &#63;.
	 *
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching municipio, or <code>null</code> if a matching municipio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio fetchByUF_First(String uf,
		OrderByComparator orderByComparator) throws SystemException {
		List<Municipio> list = findByUF(uf, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last municipio in the ordered set where uf = &#63;.
	 *
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching municipio
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a matching municipio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio findByUF_Last(String uf,
		OrderByComparator orderByComparator)
		throws NoSuchMunicipioException, SystemException {
		Municipio municipio = fetchByUF_Last(uf, orderByComparator);

		if (municipio != null) {
			return municipio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uf=");
		msg.append(uf);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMunicipioException(msg.toString());
	}

	/**
	 * Returns the last municipio in the ordered set where uf = &#63;.
	 *
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching municipio, or <code>null</code> if a matching municipio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio fetchByUF_Last(String uf,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUF(uf);

		if (count == 0) {
			return null;
		}

		List<Municipio> list = findByUF(uf, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the municipios before and after the current municipio in the ordered set where uf = &#63;.
	 *
	 * @param codigo the primary key of the current municipio
	 * @param uf the uf
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next municipio
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio[] findByUF_PrevAndNext(long codigo, String uf,
		OrderByComparator orderByComparator)
		throws NoSuchMunicipioException, SystemException {
		Municipio municipio = findByPrimaryKey(codigo);

		Session session = null;

		try {
			session = openSession();

			Municipio[] array = new MunicipioImpl[3];

			array[0] = getByUF_PrevAndNext(session, municipio, uf,
					orderByComparator, true);

			array[1] = municipio;

			array[2] = getByUF_PrevAndNext(session, municipio, uf,
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

	protected Municipio getByUF_PrevAndNext(Session session,
		Municipio municipio, String uf, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MUNICIPIO_WHERE);

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
			query.append(MunicipioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(municipio);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Municipio> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the municipios where uf = &#63; from the database.
	 *
	 * @param uf the uf
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUF(String uf) throws SystemException {
		for (Municipio municipio : findByUF(uf, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(municipio);
		}
	}

	/**
	 * Returns the number of municipios where uf = &#63;.
	 *
	 * @param uf the uf
	 * @return the number of matching municipios
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

			query.append(_SQL_COUNT_MUNICIPIO_WHERE);

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

	private static final String _FINDER_COLUMN_UF_UF_1 = "municipio.uf IS NULL";
	private static final String _FINDER_COLUMN_UF_UF_2 = "municipio.uf = ?";
	private static final String _FINDER_COLUMN_UF_UF_3 = "(municipio.uf IS NULL OR municipio.uf = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CIDADE = new FinderPath(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioModelImpl.FINDER_CACHE_ENABLED, MunicipioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCIDADE",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CIDADE = new FinderPath(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCIDADE",
			new String[] { String.class.getName() });

	/**
	 * Returns all the municipios where cidade LIKE &#63;.
	 *
	 * @param cidade the cidade
	 * @return the matching municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findByCIDADE(String cidade)
		throws SystemException {
		return findByCIDADE(cidade, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the municipios where cidade LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cidade the cidade
	 * @param start the lower bound of the range of municipios
	 * @param end the upper bound of the range of municipios (not inclusive)
	 * @return the range of matching municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findByCIDADE(String cidade, int start, int end)
		throws SystemException {
		return findByCIDADE(cidade, start, end, null);
	}

	/**
	 * Returns an ordered range of all the municipios where cidade LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cidade the cidade
	 * @param start the lower bound of the range of municipios
	 * @param end the upper bound of the range of municipios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findByCIDADE(String cidade, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CIDADE;
		finderArgs = new Object[] { cidade, start, end, orderByComparator };

		List<Municipio> list = (List<Municipio>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Municipio municipio : list) {
				if (!StringUtil.wildcardMatches(municipio.getCidade(), cidade,
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

			query.append(_SQL_SELECT_MUNICIPIO_WHERE);

			boolean bindCidade = false;

			if (cidade == null) {
				query.append(_FINDER_COLUMN_CIDADE_CIDADE_1);
			}
			else if (cidade.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CIDADE_CIDADE_3);
			}
			else {
				bindCidade = true;

				query.append(_FINDER_COLUMN_CIDADE_CIDADE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MunicipioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCidade) {
					qPos.add(cidade);
				}

				if (!pagination) {
					list = (List<Municipio>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Municipio>(list);
				}
				else {
					list = (List<Municipio>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first municipio in the ordered set where cidade LIKE &#63;.
	 *
	 * @param cidade the cidade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching municipio
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a matching municipio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio findByCIDADE_First(String cidade,
		OrderByComparator orderByComparator)
		throws NoSuchMunicipioException, SystemException {
		Municipio municipio = fetchByCIDADE_First(cidade, orderByComparator);

		if (municipio != null) {
			return municipio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cidade=");
		msg.append(cidade);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMunicipioException(msg.toString());
	}

	/**
	 * Returns the first municipio in the ordered set where cidade LIKE &#63;.
	 *
	 * @param cidade the cidade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching municipio, or <code>null</code> if a matching municipio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio fetchByCIDADE_First(String cidade,
		OrderByComparator orderByComparator) throws SystemException {
		List<Municipio> list = findByCIDADE(cidade, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last municipio in the ordered set where cidade LIKE &#63;.
	 *
	 * @param cidade the cidade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching municipio
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a matching municipio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio findByCIDADE_Last(String cidade,
		OrderByComparator orderByComparator)
		throws NoSuchMunicipioException, SystemException {
		Municipio municipio = fetchByCIDADE_Last(cidade, orderByComparator);

		if (municipio != null) {
			return municipio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cidade=");
		msg.append(cidade);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMunicipioException(msg.toString());
	}

	/**
	 * Returns the last municipio in the ordered set where cidade LIKE &#63;.
	 *
	 * @param cidade the cidade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching municipio, or <code>null</code> if a matching municipio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio fetchByCIDADE_Last(String cidade,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCIDADE(cidade);

		if (count == 0) {
			return null;
		}

		List<Municipio> list = findByCIDADE(cidade, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the municipios before and after the current municipio in the ordered set where cidade LIKE &#63;.
	 *
	 * @param codigo the primary key of the current municipio
	 * @param cidade the cidade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next municipio
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio[] findByCIDADE_PrevAndNext(long codigo, String cidade,
		OrderByComparator orderByComparator)
		throws NoSuchMunicipioException, SystemException {
		Municipio municipio = findByPrimaryKey(codigo);

		Session session = null;

		try {
			session = openSession();

			Municipio[] array = new MunicipioImpl[3];

			array[0] = getByCIDADE_PrevAndNext(session, municipio, cidade,
					orderByComparator, true);

			array[1] = municipio;

			array[2] = getByCIDADE_PrevAndNext(session, municipio, cidade,
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

	protected Municipio getByCIDADE_PrevAndNext(Session session,
		Municipio municipio, String cidade,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MUNICIPIO_WHERE);

		boolean bindCidade = false;

		if (cidade == null) {
			query.append(_FINDER_COLUMN_CIDADE_CIDADE_1);
		}
		else if (cidade.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CIDADE_CIDADE_3);
		}
		else {
			bindCidade = true;

			query.append(_FINDER_COLUMN_CIDADE_CIDADE_2);
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
			query.append(MunicipioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCidade) {
			qPos.add(cidade);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(municipio);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Municipio> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the municipios where cidade LIKE &#63; from the database.
	 *
	 * @param cidade the cidade
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCIDADE(String cidade) throws SystemException {
		for (Municipio municipio : findByCIDADE(cidade, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(municipio);
		}
	}

	/**
	 * Returns the number of municipios where cidade LIKE &#63;.
	 *
	 * @param cidade the cidade
	 * @return the number of matching municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCIDADE(String cidade) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CIDADE;

		Object[] finderArgs = new Object[] { cidade };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MUNICIPIO_WHERE);

			boolean bindCidade = false;

			if (cidade == null) {
				query.append(_FINDER_COLUMN_CIDADE_CIDADE_1);
			}
			else if (cidade.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CIDADE_CIDADE_3);
			}
			else {
				bindCidade = true;

				query.append(_FINDER_COLUMN_CIDADE_CIDADE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCidade) {
					qPos.add(cidade);
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

	private static final String _FINDER_COLUMN_CIDADE_CIDADE_1 = "municipio.cidade LIKE NULL";
	private static final String _FINDER_COLUMN_CIDADE_CIDADE_2 = "municipio.cidade LIKE ?";
	private static final String _FINDER_COLUMN_CIDADE_CIDADE_3 = "(municipio.cidade IS NULL OR municipio.cidade LIKE '')";

	public MunicipioPersistenceImpl() {
		setModelClass(Municipio.class);
	}

	/**
	 * Caches the municipio in the entity cache if it is enabled.
	 *
	 * @param municipio the municipio
	 */
	@Override
	public void cacheResult(Municipio municipio) {
		EntityCacheUtil.putResult(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioImpl.class, municipio.getPrimaryKey(), municipio);

		municipio.resetOriginalValues();
	}

	/**
	 * Caches the municipios in the entity cache if it is enabled.
	 *
	 * @param municipios the municipios
	 */
	@Override
	public void cacheResult(List<Municipio> municipios) {
		for (Municipio municipio : municipios) {
			if (EntityCacheUtil.getResult(
						MunicipioModelImpl.ENTITY_CACHE_ENABLED,
						MunicipioImpl.class, municipio.getPrimaryKey()) == null) {
				cacheResult(municipio);
			}
			else {
				municipio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all municipios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MunicipioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MunicipioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the municipio.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Municipio municipio) {
		EntityCacheUtil.removeResult(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioImpl.class, municipio.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Municipio> municipios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Municipio municipio : municipios) {
			EntityCacheUtil.removeResult(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
				MunicipioImpl.class, municipio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new municipio with the primary key. Does not add the municipio to the database.
	 *
	 * @param codigo the primary key for the new municipio
	 * @return the new municipio
	 */
	@Override
	public Municipio create(long codigo) {
		Municipio municipio = new MunicipioImpl();

		municipio.setNew(true);
		municipio.setPrimaryKey(codigo);

		return municipio;
	}

	/**
	 * Removes the municipio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codigo the primary key of the municipio
	 * @return the municipio that was removed
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio remove(long codigo)
		throws NoSuchMunicipioException, SystemException {
		return remove((Serializable)codigo);
	}

	/**
	 * Removes the municipio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the municipio
	 * @return the municipio that was removed
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio remove(Serializable primaryKey)
		throws NoSuchMunicipioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Municipio municipio = (Municipio)session.get(MunicipioImpl.class,
					primaryKey);

			if (municipio == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMunicipioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(municipio);
		}
		catch (NoSuchMunicipioException nsee) {
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
	protected Municipio removeImpl(Municipio municipio)
		throws SystemException {
		municipio = toUnwrappedModel(municipio);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(municipio)) {
				municipio = (Municipio)session.get(MunicipioImpl.class,
						municipio.getPrimaryKeyObj());
			}

			if (municipio != null) {
				session.delete(municipio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (municipio != null) {
			clearCache(municipio);
		}

		return municipio;
	}

	@Override
	public Municipio updateImpl(
		br.com.prodevelopment.municipio.model.Municipio municipio)
		throws SystemException {
		municipio = toUnwrappedModel(municipio);

		boolean isNew = municipio.isNew();

		MunicipioModelImpl municipioModelImpl = (MunicipioModelImpl)municipio;

		Session session = null;

		try {
			session = openSession();

			if (municipio.isNew()) {
				session.save(municipio);

				municipio.setNew(false);
			}
			else {
				session.merge(municipio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MunicipioModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((municipioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { municipioModelImpl.getOriginalUf() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UF, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF,
					args);

				args = new Object[] { municipioModelImpl.getUf() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UF, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UF,
					args);
			}
		}

		EntityCacheUtil.putResult(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
			MunicipioImpl.class, municipio.getPrimaryKey(), municipio);

		return municipio;
	}

	protected Municipio toUnwrappedModel(Municipio municipio) {
		if (municipio instanceof MunicipioImpl) {
			return municipio;
		}

		MunicipioImpl municipioImpl = new MunicipioImpl();

		municipioImpl.setNew(municipio.isNew());
		municipioImpl.setPrimaryKey(municipio.getPrimaryKey());

		municipioImpl.setCodigo(municipio.getCodigo());
		municipioImpl.setUf(municipio.getUf());
		municipioImpl.setCidade(municipio.getCidade());
		municipioImpl.setBairro(municipio.getBairro());
		municipioImpl.setLogradouro(municipio.getLogradouro());
		municipioImpl.setCep(municipio.getCep());

		return municipioImpl;
	}

	/**
	 * Returns the municipio with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the municipio
	 * @return the municipio
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMunicipioException, SystemException {
		Municipio municipio = fetchByPrimaryKey(primaryKey);

		if (municipio == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMunicipioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return municipio;
	}

	/**
	 * Returns the municipio with the primary key or throws a {@link br.com.prodevelopment.municipio.NoSuchMunicipioException} if it could not be found.
	 *
	 * @param codigo the primary key of the municipio
	 * @return the municipio
	 * @throws br.com.prodevelopment.municipio.NoSuchMunicipioException if a municipio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio findByPrimaryKey(long codigo)
		throws NoSuchMunicipioException, SystemException {
		return findByPrimaryKey((Serializable)codigo);
	}

	/**
	 * Returns the municipio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the municipio
	 * @return the municipio, or <code>null</code> if a municipio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Municipio municipio = (Municipio)EntityCacheUtil.getResult(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
				MunicipioImpl.class, primaryKey);

		if (municipio == _nullMunicipio) {
			return null;
		}

		if (municipio == null) {
			Session session = null;

			try {
				session = openSession();

				municipio = (Municipio)session.get(MunicipioImpl.class,
						primaryKey);

				if (municipio != null) {
					cacheResult(municipio);
				}
				else {
					EntityCacheUtil.putResult(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
						MunicipioImpl.class, primaryKey, _nullMunicipio);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MunicipioModelImpl.ENTITY_CACHE_ENABLED,
					MunicipioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return municipio;
	}

	/**
	 * Returns the municipio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codigo the primary key of the municipio
	 * @return the municipio, or <code>null</code> if a municipio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Municipio fetchByPrimaryKey(long codigo) throws SystemException {
		return fetchByPrimaryKey((Serializable)codigo);
	}

	/**
	 * Returns all the municipios.
	 *
	 * @return the municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the municipios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of municipios
	 * @param end the upper bound of the range of municipios (not inclusive)
	 * @return the range of municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the municipios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.municipio.model.impl.MunicipioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of municipios
	 * @param end the upper bound of the range of municipios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of municipios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Municipio> findAll(int start, int end,
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

		List<Municipio> list = (List<Municipio>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MUNICIPIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MUNICIPIO;

				if (pagination) {
					sql = sql.concat(MunicipioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Municipio>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Municipio>(list);
				}
				else {
					list = (List<Municipio>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the municipios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Municipio municipio : findAll()) {
			remove(municipio);
		}
	}

	/**
	 * Returns the number of municipios.
	 *
	 * @return the number of municipios
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

				Query q = session.createQuery(_SQL_COUNT_MUNICIPIO);

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
	 * Initializes the municipio persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.municipio.model.Municipio")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Municipio>> listenersList = new ArrayList<ModelListener<Municipio>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Municipio>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MunicipioImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MUNICIPIO = "SELECT municipio FROM Municipio municipio";
	private static final String _SQL_SELECT_MUNICIPIO_WHERE = "SELECT municipio FROM Municipio municipio WHERE ";
	private static final String _SQL_COUNT_MUNICIPIO = "SELECT COUNT(municipio) FROM Municipio municipio";
	private static final String _SQL_COUNT_MUNICIPIO_WHERE = "SELECT COUNT(municipio) FROM Municipio municipio WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "municipio.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Municipio exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Municipio exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MunicipioPersistenceImpl.class);
	private static Municipio _nullMunicipio = new MunicipioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Municipio> toCacheModel() {
				return _nullMunicipioCacheModel;
			}
		};

	private static CacheModel<Municipio> _nullMunicipioCacheModel = new CacheModel<Municipio>() {
			@Override
			public Municipio toEntityModel() {
				return _nullMunicipio;
			}
		};
}