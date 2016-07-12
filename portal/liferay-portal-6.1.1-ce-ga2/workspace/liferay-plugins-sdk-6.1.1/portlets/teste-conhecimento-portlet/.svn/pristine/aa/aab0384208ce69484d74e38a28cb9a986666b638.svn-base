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

package br.com.prodevelopment.testeconhecimento.service.persistence;

import br.com.prodevelopment.testeconhecimento.NoSuchTesteException;
import br.com.prodevelopment.testeconhecimento.model.Teste;
import br.com.prodevelopment.testeconhecimento.model.impl.TesteImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.TesteModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
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
 * The persistence implementation for the teste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see TestePersistence
 * @see TesteUtil
 * @generated
 */
public class TestePersistenceImpl extends BasePersistenceImpl<Teste>
	implements TestePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TesteUtil} to access the teste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TesteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TesteModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TesteModelImpl.UUID_COLUMN_BITMASK |
			TesteModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TesteModelImpl.COMPANYID_COLUMN_BITMASK |
			TesteModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			TesteModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			TesteModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, TesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the teste in the entity cache if it is enabled.
	 *
	 * @param teste the teste
	 */
	public void cacheResult(Teste teste) {
		EntityCacheUtil.putResult(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteImpl.class, teste.getPrimaryKey(), teste);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { teste.getUuid(), Long.valueOf(teste.getGroupId()) },
			teste);

		teste.resetOriginalValues();
	}

	/**
	 * Caches the testes in the entity cache if it is enabled.
	 *
	 * @param testes the testes
	 */
	public void cacheResult(List<Teste> testes) {
		for (Teste teste : testes) {
			if (EntityCacheUtil.getResult(TesteModelImpl.ENTITY_CACHE_ENABLED,
						TesteImpl.class, teste.getPrimaryKey()) == null) {
				cacheResult(teste);
			}
			else {
				teste.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all testes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TesteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TesteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the teste.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Teste teste) {
		EntityCacheUtil.removeResult(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteImpl.class, teste.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(teste);
	}

	@Override
	public void clearCache(List<Teste> testes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Teste teste : testes) {
			EntityCacheUtil.removeResult(TesteModelImpl.ENTITY_CACHE_ENABLED,
				TesteImpl.class, teste.getPrimaryKey());

			clearUniqueFindersCache(teste);
		}
	}

	protected void clearUniqueFindersCache(Teste teste) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { teste.getUuid(), Long.valueOf(teste.getGroupId()) });
	}

	/**
	 * Creates a new teste with the primary key. Does not add the teste to the database.
	 *
	 * @param id the primary key for the new teste
	 * @return the new teste
	 */
	public Teste create(long id) {
		Teste teste = new TesteImpl();

		teste.setNew(true);
		teste.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		teste.setUuid(uuid);

		return teste;
	}

	/**
	 * Removes the teste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the teste
	 * @return the teste that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste remove(long id) throws NoSuchTesteException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the teste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the teste
	 * @return the teste that was removed
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Teste remove(Serializable primaryKey)
		throws NoSuchTesteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Teste teste = (Teste)session.get(TesteImpl.class, primaryKey);

			if (teste == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(teste);
		}
		catch (NoSuchTesteException nsee) {
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
	protected Teste removeImpl(Teste teste) throws SystemException {
		teste = toUnwrappedModel(teste);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, teste);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(teste);

		return teste;
	}

	@Override
	public Teste updateImpl(
		br.com.prodevelopment.testeconhecimento.model.Teste teste, boolean merge)
		throws SystemException {
		teste = toUnwrappedModel(teste);

		boolean isNew = teste.isNew();

		TesteModelImpl testeModelImpl = (TesteModelImpl)teste;

		if (Validator.isNull(teste.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			teste.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, teste, merge);

			teste.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TesteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((testeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { testeModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { testeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((testeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(testeModelImpl.getOriginalCompanyId()),
						Long.valueOf(testeModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						Long.valueOf(testeModelImpl.getCompanyId()),
						Long.valueOf(testeModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((testeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(testeModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { Long.valueOf(testeModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((testeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(testeModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { Long.valueOf(testeModelImpl.getCompanyId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}
		}

		EntityCacheUtil.putResult(TesteModelImpl.ENTITY_CACHE_ENABLED,
			TesteImpl.class, teste.getPrimaryKey(), teste);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] { teste.getUuid(), Long.valueOf(teste.getGroupId()) },
				teste);
		}
		else {
			if ((testeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testeModelImpl.getOriginalUuid(),
						Long.valueOf(testeModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
					new Object[] {
						teste.getUuid(), Long.valueOf(teste.getGroupId())
					}, teste);
			}
		}

		return teste;
	}

	protected Teste toUnwrappedModel(Teste teste) {
		if (teste instanceof TesteImpl) {
			return teste;
		}

		TesteImpl testeImpl = new TesteImpl();

		testeImpl.setNew(teste.isNew());
		testeImpl.setPrimaryKey(teste.getPrimaryKey());

		testeImpl.setUuid(teste.getUuid());
		testeImpl.setId(teste.getId());
		testeImpl.setTitulo(teste.getTitulo());
		testeImpl.setDescricao(teste.getDescricao());
		testeImpl.setDataInclusao(teste.getDataInclusao());
		testeImpl.setDataAlteracao(teste.getDataAlteracao());
		testeImpl.setAtivo(teste.isAtivo());
		testeImpl.setCompanyId(teste.getCompanyId());
		testeImpl.setGroupId(teste.getGroupId());
		testeImpl.setUserIdInclusao(teste.getUserIdInclusao());
		testeImpl.setUserIdAlteracao(teste.getUserIdAlteracao());

		return testeImpl;
	}

	/**
	 * Returns the teste with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the teste
	 * @return the teste
	 * @throws com.liferay.portal.NoSuchModelException if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Teste findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the teste with the primary key or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchTesteException} if it could not be found.
	 *
	 * @param id the primary key of the teste
	 * @return the teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByPrimaryKey(long id)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByPrimaryKey(id);

		if (teste == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return teste;
	}

	/**
	 * Returns the teste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the teste
	 * @return the teste, or <code>null</code> if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Teste fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the teste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the teste
	 * @return the teste, or <code>null</code> if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByPrimaryKey(long id) throws SystemException {
		Teste teste = (Teste)EntityCacheUtil.getResult(TesteModelImpl.ENTITY_CACHE_ENABLED,
				TesteImpl.class, id);

		if (teste == _nullTeste) {
			return null;
		}

		if (teste == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				teste = (Teste)session.get(TesteImpl.class, Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (teste != null) {
					cacheResult(teste);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TesteModelImpl.ENTITY_CACHE_ENABLED,
						TesteImpl.class, id, _nullTeste);
				}

				closeSession(session);
			}
		}

		return teste;
	}

	/**
	 * Returns all the testes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @return the range of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByUuid(String uuid, int start, int end,
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

		List<Teste> list = (List<Teste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Teste teste : list) {
				if (!Validator.equals(uuid, teste.getUuid())) {
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

			query.append(_SQL_SELECT_TESTE_WHERE);

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
				query.append(TesteModelImpl.ORDER_BY_JPQL);
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

				list = (List<Teste>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first teste in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByUuid_First(uuid, orderByComparator);

		if (teste != null) {
			return teste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTesteException(msg.toString());
	}

	/**
	 * Returns the first teste in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Teste> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last teste in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByUuid_Last(uuid, orderByComparator);

		if (teste != null) {
			return teste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTesteException(msg.toString());
	}

	/**
	 * Returns the last teste in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		List<Teste> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testes before and after the current teste in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current teste
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Teste[] array = new TesteImpl[3];

			array[0] = getByUuid_PrevAndNext(session, teste, uuid,
					orderByComparator, true);

			array[1] = teste;

			array[2] = getByUuid_PrevAndNext(session, teste, uuid,
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

	protected Teste getByUuid_PrevAndNext(Session session, Teste teste,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTE_WHERE);

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
			query.append(TesteModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(teste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Teste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the teste where uuid = &#63; and groupId = &#63; or throws a {@link br.com.prodevelopment.testeconhecimento.NoSuchTesteException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByUUID_G(String uuid, long groupId)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByUUID_G(uuid, groupId);

		if (teste == null) {
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

			throw new NoSuchTesteException(msg.toString());
		}

		return teste;
	}

	/**
	 * Returns the teste where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the teste where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Teste) {
			Teste teste = (Teste)result;

			if (!Validator.equals(uuid, teste.getUuid()) ||
					(groupId != teste.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TESTE_WHERE);

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

			query.append(TesteModelImpl.ORDER_BY_JPQL);

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

				List<Teste> list = q.list();

				result = list;

				Teste teste = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					teste = list.get(0);

					cacheResult(teste);

					if ((teste.getUuid() == null) ||
							!teste.getUuid().equals(uuid) ||
							(teste.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, teste);
					}
				}

				return teste;
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
				return (Teste)result;
			}
		}
	}

	/**
	 * Returns all the testes where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testes where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @return the range of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByCompanyGroup(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testes where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Teste> list = (List<Teste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Teste teste : list) {
				if ((companyId != teste.getCompanyId()) ||
						(groupId != teste.getGroupId())) {
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

			query.append(_SQL_SELECT_TESTE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TesteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				list = (List<Teste>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first teste in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (teste != null) {
			return teste;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTesteException(msg.toString());
	}

	/**
	 * Returns the first teste in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Teste> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last teste in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (teste != null) {
			return teste;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTesteException(msg.toString());
	}

	/**
	 * Returns the last teste in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		List<Teste> list = findByCompanyGroup(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testes before and after the current teste in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param id the primary key of the current teste
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste[] findByCompanyGroup_PrevAndNext(long id, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Teste[] array = new TesteImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, teste, companyId,
					groupId, orderByComparator, true);

			array[1] = teste;

			array[2] = getByCompanyGroup_PrevAndNext(session, teste, companyId,
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

	protected Teste getByCompanyGroup_PrevAndNext(Session session, Teste teste,
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

		query.append(_SQL_SELECT_TESTE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

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
			query.append(TesteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(teste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Teste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the testes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @return the range of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Teste> list = (List<Teste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Teste teste : list) {
				if ((groupId != teste.getGroupId())) {
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

			query.append(_SQL_SELECT_TESTE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TesteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Teste>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first teste in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByGroup_First(groupId, orderByComparator);

		if (teste != null) {
			return teste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTesteException(msg.toString());
	}

	/**
	 * Returns the first teste in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Teste> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last teste in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByGroup_Last(groupId, orderByComparator);

		if (teste != null) {
			return teste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTesteException(msg.toString());
	}

	/**
	 * Returns the last teste in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<Teste> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testes before and after the current teste in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current teste
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste[] findByGroup_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Teste[] array = new TesteImpl[3];

			array[0] = getByGroup_PrevAndNext(session, teste, groupId,
					orderByComparator, true);

			array[1] = teste;

			array[2] = getByGroup_PrevAndNext(session, teste, groupId,
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

	protected Teste getByGroup_PrevAndNext(Session session, Teste teste,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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
			query.append(TesteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(teste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Teste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the testes where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByCompany(long companyId) throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the testes where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @return the range of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testes where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findByCompany(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Teste> list = (List<Teste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Teste teste : list) {
				if ((companyId != teste.getCompanyId())) {
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

			query.append(_SQL_SELECT_TESTE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TesteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Teste>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first teste in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByCompany_First(companyId, orderByComparator);

		if (teste != null) {
			return teste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTesteException(msg.toString());
	}

	/**
	 * Returns the first teste in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Teste> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last teste in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = fetchByCompany_Last(companyId, orderByComparator);

		if (teste != null) {
			return teste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTesteException(msg.toString());
	}

	/**
	 * Returns the last teste in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching teste, or <code>null</code> if a matching teste could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<Teste> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testes before and after the current teste in the ordered set where companyId = &#63;.
	 *
	 * @param id the primary key of the current teste
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next teste
	 * @throws br.com.prodevelopment.testeconhecimento.NoSuchTesteException if a teste with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Teste[] findByCompany_PrevAndNext(long id, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTesteException, SystemException {
		Teste teste = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Teste[] array = new TesteImpl[3];

			array[0] = getByCompany_PrevAndNext(session, teste, companyId,
					orderByComparator, true);

			array[1] = teste;

			array[2] = getByCompany_PrevAndNext(session, teste, companyId,
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

	protected Teste getByCompany_PrevAndNext(Session session, Teste teste,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTE_WHERE);

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
			query.append(TesteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(teste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Teste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the testes.
	 *
	 * @return the testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @return the range of testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the testes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of testes
	 * @param end the upper bound of the range of testes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of testes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Teste> findAll(int start, int end,
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

		List<Teste> list = (List<Teste>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TESTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTE.concat(TesteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Teste>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Teste>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the testes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Teste teste : findByUuid(uuid)) {
			remove(teste);
		}
	}

	/**
	 * Removes the teste where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the teste that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Teste removeByUUID_G(String uuid, long groupId)
		throws NoSuchTesteException, SystemException {
		Teste teste = findByUUID_G(uuid, groupId);

		return remove(teste);
	}

	/**
	 * Removes all the testes where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (Teste teste : findByCompanyGroup(companyId, groupId)) {
			remove(teste);
		}
	}

	/**
	 * Removes all the testes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (Teste teste : findByGroup(groupId)) {
			remove(teste);
		}
	}

	/**
	 * Removes all the testes where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (Teste teste : findByCompany(companyId)) {
			remove(teste);
		}
	}

	/**
	 * Removes all the testes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Teste teste : findAll()) {
			remove(teste);
		}
	}

	/**
	 * Returns the number of testes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TESTE_WHERE);

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
	 * Returns the number of testes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TESTE_WHERE);

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
	 * Returns the number of testes where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TESTE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of testes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TESTE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of testes where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching testes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TESTE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of testes.
	 *
	 * @return the number of testes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TESTE);

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
	 * Initializes the teste persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.prodevelopment.testeconhecimento.model.Teste")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Teste>> listenersList = new ArrayList<ModelListener<Teste>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Teste>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TesteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PerguntaPersistence.class)
	protected PerguntaPersistence perguntaPersistence;
	@BeanReference(type = RespostaPersistence.class)
	protected RespostaPersistence respostaPersistence;
	@BeanReference(type = Resposta_UsuarioPersistence.class)
	protected Resposta_UsuarioPersistence resposta_UsuarioPersistence;
	@BeanReference(type = TestePersistence.class)
	protected TestePersistence testePersistence;
	@BeanReference(type = Teste_UsuarioPersistence.class)
	protected Teste_UsuarioPersistence teste_UsuarioPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	private static final String _SQL_SELECT_TESTE = "SELECT teste FROM Teste teste";
	private static final String _SQL_SELECT_TESTE_WHERE = "SELECT teste FROM Teste teste WHERE ";
	private static final String _SQL_COUNT_TESTE = "SELECT COUNT(teste) FROM Teste teste";
	private static final String _SQL_COUNT_TESTE_WHERE = "SELECT COUNT(teste) FROM Teste teste WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "teste.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "teste.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(teste.uuid IS NULL OR teste.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "teste.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "teste.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(teste.uuid IS NULL OR teste.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "teste.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "teste.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "teste.groupId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "teste.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "teste.companyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "teste.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Teste exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Teste exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TestePersistenceImpl.class);
	private static Teste _nullTeste = new TesteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Teste> toCacheModel() {
				return _nullTesteCacheModel;
			}
		};

	private static CacheModel<Teste> _nullTesteCacheModel = new CacheModel<Teste>() {
			public Teste toEntityModel() {
				return _nullTeste;
			}
		};
}