/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package br.com.prodevelopment.pesquisaopiniao.service.persistence;

import br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;
import br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaImpl;
import br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the pesquisa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see PesquisaPersistence
 * @see PesquisaUtil
 * @generated
 */
public class PesquisaPersistenceImpl extends BasePersistenceImpl<Pesquisa>
	implements PesquisaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PesquisaUtil} to access the pesquisa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PesquisaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PesquisaModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PesquisaModelImpl.UUID_COLUMN_BITMASK |
			PesquisaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			PesquisaModelImpl.COMPANYID_COLUMN_BITMASK |
			PesquisaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			PesquisaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			PesquisaModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, PesquisaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the pesquisa in the entity cache if it is enabled.
	 *
	 * @param pesquisa the pesquisa
	 */
	public void cacheResult(Pesquisa pesquisa) {
		EntityCacheUtil.putResult(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaImpl.class, pesquisa.getPrimaryKey(), pesquisa);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { pesquisa.getUuid(), Long.valueOf(
					pesquisa.getGroupId()) }, pesquisa);

		pesquisa.resetOriginalValues();
	}

	/**
	 * Caches the pesquisas in the entity cache if it is enabled.
	 *
	 * @param pesquisas the pesquisas
	 */
	public void cacheResult(List<Pesquisa> pesquisas) {
		for (Pesquisa pesquisa : pesquisas) {
			if (EntityCacheUtil.getResult(
						PesquisaModelImpl.ENTITY_CACHE_ENABLED,
						PesquisaImpl.class, pesquisa.getPrimaryKey()) == null) {
				cacheResult(pesquisa);
			}
			else {
				pesquisa.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pesquisas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PesquisaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PesquisaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pesquisa.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Pesquisa pesquisa) {
		EntityCacheUtil.removeResult(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaImpl.class, pesquisa.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(pesquisa);
	}

	@Override
	public void clearCache(List<Pesquisa> pesquisas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Pesquisa pesquisa : pesquisas) {
			EntityCacheUtil.removeResult(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
				PesquisaImpl.class, pesquisa.getPrimaryKey());

			clearUniqueFindersCache(pesquisa);
		}
	}

	protected void clearUniqueFindersCache(Pesquisa pesquisa) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { pesquisa.getUuid(), Long.valueOf(
					pesquisa.getGroupId()) });
	}

	/**
	 * Creates a new pesquisa with the primary key. Does not add the pesquisa to the database.
	 *
	 * @param id the primary key for the new pesquisa
	 * @return the new pesquisa
	 */
	public Pesquisa create(long id) {
		Pesquisa pesquisa = new PesquisaImpl();

		pesquisa.setNew(true);
		pesquisa.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		pesquisa.setUuid(uuid);

		return pesquisa;
	}

	/**
	 * Removes the pesquisa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pesquisa
	 * @return the pesquisa that was removed
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa remove(long id)
		throws NoSuchPesquisaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the pesquisa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pesquisa
	 * @return the pesquisa that was removed
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pesquisa remove(Serializable primaryKey)
		throws NoSuchPesquisaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Pesquisa pesquisa = (Pesquisa)session.get(PesquisaImpl.class,
					primaryKey);

			if (pesquisa == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPesquisaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pesquisa);
		}
		catch (NoSuchPesquisaException nsee) {
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
	protected Pesquisa removeImpl(Pesquisa pesquisa) throws SystemException {
		pesquisa = toUnwrappedModel(pesquisa);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, pesquisa);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(pesquisa);

		return pesquisa;
	}

	@Override
	public Pesquisa updateImpl(
		br.com.prodevelopment.pesquisaopiniao.model.Pesquisa pesquisa,
		boolean merge) throws SystemException {
		pesquisa = toUnwrappedModel(pesquisa);

		boolean isNew = pesquisa.isNew();

		PesquisaModelImpl pesquisaModelImpl = (PesquisaModelImpl)pesquisa;

		if (Validator.isNull(pesquisa.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			pesquisa.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pesquisa, merge);

			pesquisa.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PesquisaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((pesquisaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { pesquisaModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { pesquisaModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((pesquisaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pesquisaModelImpl.getOriginalCompanyId()),
						Long.valueOf(pesquisaModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						Long.valueOf(pesquisaModelImpl.getCompanyId()),
						Long.valueOf(pesquisaModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((pesquisaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pesquisaModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(pesquisaModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((pesquisaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pesquisaModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(pesquisaModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
			PesquisaImpl.class, pesquisa.getPrimaryKey(), pesquisa);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					pesquisa.getUuid(), Long.valueOf(pesquisa.getGroupId())
				}, pesquisa);
		}
		else {
			if ((pesquisaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pesquisaModelImpl.getOriginalUuid(),
						Long.valueOf(pesquisaModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
					new Object[] {
						pesquisa.getUuid(), Long.valueOf(pesquisa.getGroupId())
					}, pesquisa);
			}
		}

		return pesquisa;
	}

	protected Pesquisa toUnwrappedModel(Pesquisa pesquisa) {
		if (pesquisa instanceof PesquisaImpl) {
			return pesquisa;
		}

		PesquisaImpl pesquisaImpl = new PesquisaImpl();

		pesquisaImpl.setNew(pesquisa.isNew());
		pesquisaImpl.setPrimaryKey(pesquisa.getPrimaryKey());

		pesquisaImpl.setUuid(pesquisa.getUuid());
		pesquisaImpl.setId(pesquisa.getId());
		pesquisaImpl.setTitulo(pesquisa.getTitulo());
		pesquisaImpl.setDescricao(pesquisa.getDescricao());
		pesquisaImpl.setDataInclusao(pesquisa.getDataInclusao());
		pesquisaImpl.setDataAlteracao(pesquisa.getDataAlteracao());
		pesquisaImpl.setAtiva(pesquisa.isAtiva());
		pesquisaImpl.setCompanyId(pesquisa.getCompanyId());
		pesquisaImpl.setGroupId(pesquisa.getGroupId());
		pesquisaImpl.setUserIdInclusao(pesquisa.getUserIdInclusao());
		pesquisaImpl.setUserIdAlteracao(pesquisa.getUserIdAlteracao());

		return pesquisaImpl;
	}

	/**
	 * Returns the pesquisa with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pesquisa
	 * @return the pesquisa
	 * @throws com.liferay.portal.NoSuchModelException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pesquisa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the pesquisa with the primary key or throws a {@link br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException} if it could not be found.
	 *
	 * @param id the primary key of the pesquisa
	 * @return the pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByPrimaryKey(long id)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByPrimaryKey(id);

		if (pesquisa == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchPesquisaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return pesquisa;
	}

	/**
	 * Returns the pesquisa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pesquisa
	 * @return the pesquisa, or <code>null</code> if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Pesquisa fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the pesquisa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pesquisa
	 * @return the pesquisa, or <code>null</code> if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByPrimaryKey(long id) throws SystemException {
		Pesquisa pesquisa = (Pesquisa)EntityCacheUtil.getResult(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
				PesquisaImpl.class, id);

		if (pesquisa == _nullPesquisa) {
			return null;
		}

		if (pesquisa == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				pesquisa = (Pesquisa)session.get(PesquisaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (pesquisa != null) {
					cacheResult(pesquisa);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PesquisaModelImpl.ENTITY_CACHE_ENABLED,
						PesquisaImpl.class, id, _nullPesquisa);
				}

				closeSession(session);
			}
		}

		return pesquisa;
	}

	/**
	 * Returns all the pesquisas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pesquisas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @return the range of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pesquisas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Pesquisa> list = (List<Pesquisa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Pesquisa pesquisa : list) {
				if (!Validator.equals(uuid, pesquisa.getUuid())) {
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

			query.append(_SQL_SELECT_PESQUISA_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PesquisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Pesquisa>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first pesquisa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByUuid_First(uuid, orderByComparator);

		if (pesquisa != null) {
			return pesquisa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisaException(msg.toString());
	}

	/**
	 * Returns the first pesquisa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Pesquisa> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pesquisa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByUuid_Last(uuid, orderByComparator);

		if (pesquisa != null) {
			return pesquisa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisaException(msg.toString());
	}

	/**
	 * Returns the last pesquisa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		List<Pesquisa> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pesquisas before and after the current pesquisa in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current pesquisa
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Pesquisa[] array = new PesquisaImpl[3];

			array[0] = getByUuid_PrevAndNext(session, pesquisa, uuid,
					orderByComparator, true);

			array[1] = pesquisa;

			array[2] = getByUuid_PrevAndNext(session, pesquisa, uuid,
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

	protected Pesquisa getByUuid_PrevAndNext(Session session,
		Pesquisa pesquisa, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PESQUISA_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
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
			query.append(PesquisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pesquisa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Pesquisa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the pesquisa where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByUUID_G(String uuid, long groupId)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByUUID_G(uuid, groupId);

		if (pesquisa == null) {
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

			throw new NoSuchPesquisaException(msg.toString());
		}

		return pesquisa;
	}

	/**
	 * Returns the pesquisa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the pesquisa where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Pesquisa) {
			Pesquisa pesquisa = (Pesquisa)result;

			if (!Validator.equals(uuid, pesquisa.getUuid()) ||
					(groupId != pesquisa.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PESQUISA_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(PesquisaModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Pesquisa> list = q.list();

				result = list;

				Pesquisa pesquisa = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					pesquisa = list.get(0);

					cacheResult(pesquisa);

					if ((pesquisa.getUuid() == null) ||
							!pesquisa.getUuid().equals(uuid) ||
							(pesquisa.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, pesquisa);
					}
				}

				return pesquisa;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Pesquisa)result;
			}
		}
	}

	/**
	 * Returns all the pesquisas where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pesquisas where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @return the range of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pesquisas where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
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

		List<Pesquisa> list = (List<Pesquisa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Pesquisa pesquisa : list) {
				if ((companyId != pesquisa.getCompanyId()) ||
						(groupId != pesquisa.getGroupId())) {
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

			query.append(_SQL_SELECT_PESQUISA_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PesquisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				list = (List<Pesquisa>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByC_G_First(companyId, groupId,
				orderByComparator);

		if (pesquisa != null) {
			return pesquisa;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisaException(msg.toString());
	}

	/**
	 * Returns the first pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Pesquisa> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByC_G_Last(companyId, groupId,
				orderByComparator);

		if (pesquisa != null) {
			return pesquisa;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisaException(msg.toString());
	}

	/**
	 * Returns the last pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		List<Pesquisa> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pesquisas before and after the current pesquisa in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current pesquisa
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa[] findByC_G_PrevAndNext(long id, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Pesquisa[] array = new PesquisaImpl[3];

			array[0] = getByC_G_PrevAndNext(session, pesquisa, companyId,
					groupId, orderByComparator, true);

			array[1] = pesquisa;

			array[2] = getByC_G_PrevAndNext(session, pesquisa, companyId,
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

	protected Pesquisa getByC_G_PrevAndNext(Session session, Pesquisa pesquisa,
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

		query.append(_SQL_SELECT_PESQUISA_WHERE);

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
			query.append(PesquisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pesquisa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Pesquisa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pesquisas that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching pesquisas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pesquisas that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @return the range of matching pesquisas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> filterFindByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pesquisas that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pesquisas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> filterFindByC_G(long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_PESQUISA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PesquisaModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PesquisaModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Pesquisa.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PesquisaImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PesquisaImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<Pesquisa>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the pesquisas before and after the current pesquisa in the ordered set of pesquisas that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current pesquisa
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa[] filterFindByC_G_PrevAndNext(long id, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(id, companyId, groupId,
				orderByComparator);
		}

		Pesquisa pesquisa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Pesquisa[] array = new PesquisaImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, pesquisa, companyId,
					groupId, orderByComparator, true);

			array[1] = pesquisa;

			array[2] = filterGetByC_G_PrevAndNext(session, pesquisa, companyId,
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

	protected Pesquisa filterGetByC_G_PrevAndNext(Session session,
		Pesquisa pesquisa, long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_PESQUISA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PesquisaModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PesquisaModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Pesquisa.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PesquisaImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PesquisaImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pesquisa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Pesquisa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pesquisas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pesquisas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @return the range of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pesquisas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Pesquisa> list = (List<Pesquisa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Pesquisa pesquisa : list) {
				if ((groupId != pesquisa.getGroupId())) {
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

			query.append(_SQL_SELECT_PESQUISA_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PesquisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Pesquisa>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first pesquisa in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByGroupId_First(groupId, orderByComparator);

		if (pesquisa != null) {
			return pesquisa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisaException(msg.toString());
	}

	/**
	 * Returns the first pesquisa in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Pesquisa> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pesquisa in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByGroupId_Last(groupId, orderByComparator);

		if (pesquisa != null) {
			return pesquisa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisaException(msg.toString());
	}

	/**
	 * Returns the last pesquisa in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<Pesquisa> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pesquisas before and after the current pesquisa in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current pesquisa
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa[] findByGroupId_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Pesquisa[] array = new PesquisaImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, pesquisa, groupId,
					orderByComparator, true);

			array[1] = pesquisa;

			array[2] = getByGroupId_PrevAndNext(session, pesquisa, groupId,
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

	protected Pesquisa getByGroupId_PrevAndNext(Session session,
		Pesquisa pesquisa, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PESQUISA_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(PesquisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pesquisa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Pesquisa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pesquisas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching pesquisas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pesquisas that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @return the range of matching pesquisas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pesquisas that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pesquisas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PESQUISA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PesquisaModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PesquisaModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Pesquisa.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PesquisaImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PesquisaImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Pesquisa>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the pesquisas before and after the current pesquisa in the ordered set of pesquisas that the user has permission to view where groupId = &#63;.
	 *
	 * @param id the primary key of the current pesquisa
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa[] filterFindByGroupId_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(id, groupId, orderByComparator);
		}

		Pesquisa pesquisa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Pesquisa[] array = new PesquisaImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, pesquisa,
					groupId, orderByComparator, true);

			array[1] = pesquisa;

			array[2] = filterGetByGroupId_PrevAndNext(session, pesquisa,
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

	protected Pesquisa filterGetByGroupId_PrevAndNext(Session session,
		Pesquisa pesquisa, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_PESQUISA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PesquisaModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PesquisaModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Pesquisa.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PesquisaImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PesquisaImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pesquisa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Pesquisa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pesquisas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the pesquisas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @return the range of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pesquisas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Pesquisa> list = (List<Pesquisa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Pesquisa pesquisa : list) {
				if ((companyId != pesquisa.getCompanyId())) {
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

			query.append(_SQL_SELECT_PESQUISA_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PesquisaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Pesquisa>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first pesquisa in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByCompanyId_First(companyId, orderByComparator);

		if (pesquisa != null) {
			return pesquisa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisaException(msg.toString());
	}

	/**
	 * Returns the first pesquisa in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Pesquisa> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pesquisa in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = fetchByCompanyId_Last(companyId, orderByComparator);

		if (pesquisa != null) {
			return pesquisa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPesquisaException(msg.toString());
	}

	/**
	 * Returns the last pesquisa in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pesquisa, or <code>null</code> if a matching pesquisa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<Pesquisa> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pesquisas before and after the current pesquisa in the ordered set where companyId = &#63;.
	 *
	 * @param id the primary key of the current pesquisa
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pesquisa
	 * @throws br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException if a pesquisa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa[] findByCompanyId_PrevAndNext(long id, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Pesquisa[] array = new PesquisaImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, pesquisa, companyId,
					orderByComparator, true);

			array[1] = pesquisa;

			array[2] = getByCompanyId_PrevAndNext(session, pesquisa, companyId,
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

	protected Pesquisa getByCompanyId_PrevAndNext(Session session,
		Pesquisa pesquisa, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PESQUISA_WHERE);

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
			query.append(PesquisaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pesquisa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Pesquisa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pesquisas.
	 *
	 * @return the pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pesquisas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @return the range of pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pesquisas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of pesquisas
	 * @param end the upper bound of the range of pesquisas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pesquisa> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Pesquisa> list = (List<Pesquisa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PESQUISA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PESQUISA.concat(PesquisaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Pesquisa>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Pesquisa>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the pesquisas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Pesquisa pesquisa : findByUuid(uuid)) {
			remove(pesquisa);
		}
	}

	/**
	 * Removes the pesquisa where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pesquisa that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Pesquisa removeByUUID_G(String uuid, long groupId)
		throws NoSuchPesquisaException, SystemException {
		Pesquisa pesquisa = findByUUID_G(uuid, groupId);

		return remove(pesquisa);
	}

	/**
	 * Removes all the pesquisas where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (Pesquisa pesquisa : findByC_G(companyId, groupId)) {
			remove(pesquisa);
		}
	}

	/**
	 * Removes all the pesquisas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Pesquisa pesquisa : findByGroupId(groupId)) {
			remove(pesquisa);
		}
	}

	/**
	 * Removes all the pesquisas where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Pesquisa pesquisa : findByCompanyId(companyId)) {
			remove(pesquisa);
		}
	}

	/**
	 * Removes all the pesquisas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Pesquisa pesquisa : findAll()) {
			remove(pesquisa);
		}
	}

	/**
	 * Returns the number of pesquisas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PESQUISA_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pesquisas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PESQUISA_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pesquisas where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PESQUISA_WHERE);

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
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pesquisas that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching pesquisas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PESQUISA_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Pesquisa.class.getName(),
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

	/**
	 * Returns the number of pesquisas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PESQUISA_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pesquisas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching pesquisas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PESQUISA_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Pesquisa.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

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

	/**
	 * Returns the number of pesquisas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PESQUISA_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pesquisas.
	 *
	 * @return the number of pesquisas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PESQUISA);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the pesquisa persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.pesquisaopiniao.model.Pesquisa")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Pesquisa>> listenersList = new ArrayList<ModelListener<Pesquisa>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Pesquisa>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PesquisaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PerguntaPersistence.class)
	protected PerguntaPersistence perguntaPersistence;
	@BeanReference(type = PesquisaPersistence.class)
	protected PesquisaPersistence pesquisaPersistence;
	@BeanReference(type = Pesquisa_UsuarioPersistence.class)
	protected Pesquisa_UsuarioPersistence pesquisa_UsuarioPersistence;
	@BeanReference(type = RespostaPersistence.class)
	protected RespostaPersistence respostaPersistence;
	@BeanReference(type = Resposta_UsuarioPersistence.class)
	protected Resposta_UsuarioPersistence resposta_UsuarioPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	private static final String _SQL_SELECT_PESQUISA = "SELECT pesquisa FROM Pesquisa pesquisa";
	private static final String _SQL_SELECT_PESQUISA_WHERE = "SELECT pesquisa FROM Pesquisa pesquisa WHERE ";
	private static final String _SQL_COUNT_PESQUISA = "SELECT COUNT(pesquisa) FROM Pesquisa pesquisa";
	private static final String _SQL_COUNT_PESQUISA_WHERE = "SELECT COUNT(pesquisa) FROM Pesquisa pesquisa WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "pesquisa.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "pesquisa.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(pesquisa.uuid IS NULL OR pesquisa.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "pesquisa.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "pesquisa.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(pesquisa.uuid IS NULL OR pesquisa.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "pesquisa.groupId = ?";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "pesquisa.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "pesquisa.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "pesquisa.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "pesquisa.companyId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "pesquisa.id_";
	private static final String _FILTER_SQL_SELECT_PESQUISA_WHERE = "SELECT DISTINCT {pesquisa.*} FROM PO_Pesquisa pesquisa WHERE ";
	private static final String _FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {PO_Pesquisa.*} FROM (SELECT DISTINCT pesquisa.id_ FROM PO_Pesquisa pesquisa WHERE ";
	private static final String _FILTER_SQL_SELECT_PESQUISA_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN PO_Pesquisa ON TEMP_TABLE.id_ = PO_Pesquisa.id_";
	private static final String _FILTER_SQL_COUNT_PESQUISA_WHERE = "SELECT COUNT(DISTINCT pesquisa.id_) AS COUNT_VALUE FROM PO_Pesquisa pesquisa WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "pesquisa";
	private static final String _FILTER_ENTITY_TABLE = "PO_Pesquisa";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pesquisa.";
	private static final String _ORDER_BY_ENTITY_TABLE = "PO_Pesquisa.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Pesquisa exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Pesquisa exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PesquisaPersistenceImpl.class);
	private static Pesquisa _nullPesquisa = new PesquisaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Pesquisa> toCacheModel() {
				return _nullPesquisaCacheModel;
			}
		};

	private static CacheModel<Pesquisa> _nullPesquisaCacheModel = new CacheModel<Pesquisa>() {
			public Pesquisa toEntityModel() {
				return _nullPesquisa;
			}
		};
}