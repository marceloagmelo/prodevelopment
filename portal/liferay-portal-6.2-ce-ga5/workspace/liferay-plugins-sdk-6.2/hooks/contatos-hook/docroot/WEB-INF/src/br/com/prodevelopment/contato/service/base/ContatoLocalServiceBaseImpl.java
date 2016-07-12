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

package br.com.prodevelopment.contato.service.base;

import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.service.ContatoLocalService;
import br.com.prodevelopment.contato.service.persistence.ContatoPersistence;
import br.com.prodevelopment.contato.service.persistence.EnderecoEmailPersistence;
import br.com.prodevelopment.contato.service.persistence.EnderecoPersistence;
import br.com.prodevelopment.contato.service.persistence.TelefonePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the contato local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link br.com.prodevelopment.contato.service.impl.ContatoLocalServiceImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.contato.service.impl.ContatoLocalServiceImpl
 * @see br.com.prodevelopment.contato.service.ContatoLocalServiceUtil
 * @generated
 */
public abstract class ContatoLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ContatoLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link br.com.prodevelopment.contato.service.ContatoLocalServiceUtil} to access the contato local service.
	 */

	/**
	 * Adds the contato to the database. Also notifies the appropriate model listeners.
	 *
	 * @param contato the contato
	 * @return the contato that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Contato addContato(Contato contato) throws SystemException {
		contato.setNew(true);

		return contatoPersistence.update(contato);
	}

	/**
	 * Creates a new contato with the primary key. Does not add the contato to the database.
	 *
	 * @param contatoId the primary key for the new contato
	 * @return the new contato
	 */
	@Override
	public Contato createContato(long contatoId) {
		return contatoPersistence.create(contatoId);
	}

	/**
	 * Deletes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contatoId the primary key of the contato
	 * @return the contato that was removed
	 * @throws PortalException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Contato deleteContato(long contatoId)
		throws PortalException, SystemException {
		return contatoPersistence.remove(contatoId);
	}

	/**
	 * Deletes the contato from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contato the contato
	 * @return the contato that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Contato deleteContato(Contato contato) throws SystemException {
		return contatoPersistence.remove(contato);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Contato.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return contatoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return contatoPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.prodevelopment.contato.model.impl.ContatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return contatoPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return contatoPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return contatoPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Contato fetchContato(long contatoId) throws SystemException {
		return contatoPersistence.fetchByPrimaryKey(contatoId);
	}

	/**
	 * Returns the contato with the primary key.
	 *
	 * @param contatoId the primary key of the contato
	 * @return the contato
	 * @throws PortalException if a contato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contato getContato(long contatoId)
		throws PortalException, SystemException {
		return contatoPersistence.findByPrimaryKey(contatoId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return contatoPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Contato> getContatos(int start, int end)
		throws SystemException {
		return contatoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of contatos.
	 *
	 * @return the number of contatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getContatosCount() throws SystemException {
		return contatoPersistence.countAll();
	}

	/**
	 * Updates the contato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param contato the contato
	 * @return the contato that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Contato updateContato(Contato contato) throws SystemException {
		return contatoPersistence.update(contato);
	}

	/**
	 * Returns the contato local service.
	 *
	 * @return the contato local service
	 */
	public br.com.prodevelopment.contato.service.ContatoLocalService getContatoLocalService() {
		return contatoLocalService;
	}

	/**
	 * Sets the contato local service.
	 *
	 * @param contatoLocalService the contato local service
	 */
	public void setContatoLocalService(
		br.com.prodevelopment.contato.service.ContatoLocalService contatoLocalService) {
		this.contatoLocalService = contatoLocalService;
	}

	/**
	 * Returns the contato remote service.
	 *
	 * @return the contato remote service
	 */
	public br.com.prodevelopment.contato.service.ContatoService getContatoService() {
		return contatoService;
	}

	/**
	 * Sets the contato remote service.
	 *
	 * @param contatoService the contato remote service
	 */
	public void setContatoService(
		br.com.prodevelopment.contato.service.ContatoService contatoService) {
		this.contatoService = contatoService;
	}

	/**
	 * Returns the contato persistence.
	 *
	 * @return the contato persistence
	 */
	public ContatoPersistence getContatoPersistence() {
		return contatoPersistence;
	}

	/**
	 * Sets the contato persistence.
	 *
	 * @param contatoPersistence the contato persistence
	 */
	public void setContatoPersistence(ContatoPersistence contatoPersistence) {
		this.contatoPersistence = contatoPersistence;
	}

	/**
	 * Returns the endereco local service.
	 *
	 * @return the endereco local service
	 */
	public br.com.prodevelopment.contato.service.EnderecoLocalService getEnderecoLocalService() {
		return enderecoLocalService;
	}

	/**
	 * Sets the endereco local service.
	 *
	 * @param enderecoLocalService the endereco local service
	 */
	public void setEnderecoLocalService(
		br.com.prodevelopment.contato.service.EnderecoLocalService enderecoLocalService) {
		this.enderecoLocalService = enderecoLocalService;
	}

	/**
	 * Returns the endereco remote service.
	 *
	 * @return the endereco remote service
	 */
	public br.com.prodevelopment.contato.service.EnderecoService getEnderecoService() {
		return enderecoService;
	}

	/**
	 * Sets the endereco remote service.
	 *
	 * @param enderecoService the endereco remote service
	 */
	public void setEnderecoService(
		br.com.prodevelopment.contato.service.EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	/**
	 * Returns the endereco persistence.
	 *
	 * @return the endereco persistence
	 */
	public EnderecoPersistence getEnderecoPersistence() {
		return enderecoPersistence;
	}

	/**
	 * Sets the endereco persistence.
	 *
	 * @param enderecoPersistence the endereco persistence
	 */
	public void setEnderecoPersistence(EnderecoPersistence enderecoPersistence) {
		this.enderecoPersistence = enderecoPersistence;
	}

	/**
	 * Returns the endereco email local service.
	 *
	 * @return the endereco email local service
	 */
	public br.com.prodevelopment.contato.service.EnderecoEmailLocalService getEnderecoEmailLocalService() {
		return enderecoEmailLocalService;
	}

	/**
	 * Sets the endereco email local service.
	 *
	 * @param enderecoEmailLocalService the endereco email local service
	 */
	public void setEnderecoEmailLocalService(
		br.com.prodevelopment.contato.service.EnderecoEmailLocalService enderecoEmailLocalService) {
		this.enderecoEmailLocalService = enderecoEmailLocalService;
	}

	/**
	 * Returns the endereco email remote service.
	 *
	 * @return the endereco email remote service
	 */
	public br.com.prodevelopment.contato.service.EnderecoEmailService getEnderecoEmailService() {
		return enderecoEmailService;
	}

	/**
	 * Sets the endereco email remote service.
	 *
	 * @param enderecoEmailService the endereco email remote service
	 */
	public void setEnderecoEmailService(
		br.com.prodevelopment.contato.service.EnderecoEmailService enderecoEmailService) {
		this.enderecoEmailService = enderecoEmailService;
	}

	/**
	 * Returns the endereco email persistence.
	 *
	 * @return the endereco email persistence
	 */
	public EnderecoEmailPersistence getEnderecoEmailPersistence() {
		return enderecoEmailPersistence;
	}

	/**
	 * Sets the endereco email persistence.
	 *
	 * @param enderecoEmailPersistence the endereco email persistence
	 */
	public void setEnderecoEmailPersistence(
		EnderecoEmailPersistence enderecoEmailPersistence) {
		this.enderecoEmailPersistence = enderecoEmailPersistence;
	}

	/**
	 * Returns the telefone local service.
	 *
	 * @return the telefone local service
	 */
	public br.com.prodevelopment.contato.service.TelefoneLocalService getTelefoneLocalService() {
		return telefoneLocalService;
	}

	/**
	 * Sets the telefone local service.
	 *
	 * @param telefoneLocalService the telefone local service
	 */
	public void setTelefoneLocalService(
		br.com.prodevelopment.contato.service.TelefoneLocalService telefoneLocalService) {
		this.telefoneLocalService = telefoneLocalService;
	}

	/**
	 * Returns the telefone remote service.
	 *
	 * @return the telefone remote service
	 */
	public br.com.prodevelopment.contato.service.TelefoneService getTelefoneService() {
		return telefoneService;
	}

	/**
	 * Sets the telefone remote service.
	 *
	 * @param telefoneService the telefone remote service
	 */
	public void setTelefoneService(
		br.com.prodevelopment.contato.service.TelefoneService telefoneService) {
		this.telefoneService = telefoneService;
	}

	/**
	 * Returns the telefone persistence.
	 *
	 * @return the telefone persistence
	 */
	public TelefonePersistence getTelefonePersistence() {
		return telefonePersistence;
	}

	/**
	 * Sets the telefone persistence.
	 *
	 * @param telefonePersistence the telefone persistence
	 */
	public void setTelefonePersistence(TelefonePersistence telefonePersistence) {
		this.telefonePersistence = telefonePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("br.com.prodevelopment.contato.model.Contato",
			contatoLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"br.com.prodevelopment.contato.model.Contato");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Contato.class;
	}

	protected String getModelClassName() {
		return Contato.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = contatoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = br.com.prodevelopment.contato.service.ContatoLocalService.class)
	protected br.com.prodevelopment.contato.service.ContatoLocalService contatoLocalService;
	@BeanReference(type = br.com.prodevelopment.contato.service.ContatoService.class)
	protected br.com.prodevelopment.contato.service.ContatoService contatoService;
	@BeanReference(type = ContatoPersistence.class)
	protected ContatoPersistence contatoPersistence;
	@BeanReference(type = br.com.prodevelopment.contato.service.EnderecoLocalService.class)
	protected br.com.prodevelopment.contato.service.EnderecoLocalService enderecoLocalService;
	@BeanReference(type = br.com.prodevelopment.contato.service.EnderecoService.class)
	protected br.com.prodevelopment.contato.service.EnderecoService enderecoService;
	@BeanReference(type = EnderecoPersistence.class)
	protected EnderecoPersistence enderecoPersistence;
	@BeanReference(type = br.com.prodevelopment.contato.service.EnderecoEmailLocalService.class)
	protected br.com.prodevelopment.contato.service.EnderecoEmailLocalService enderecoEmailLocalService;
	@BeanReference(type = br.com.prodevelopment.contato.service.EnderecoEmailService.class)
	protected br.com.prodevelopment.contato.service.EnderecoEmailService enderecoEmailService;
	@BeanReference(type = EnderecoEmailPersistence.class)
	protected EnderecoEmailPersistence enderecoEmailPersistence;
	@BeanReference(type = br.com.prodevelopment.contato.service.TelefoneLocalService.class)
	protected br.com.prodevelopment.contato.service.TelefoneLocalService telefoneLocalService;
	@BeanReference(type = br.com.prodevelopment.contato.service.TelefoneService.class)
	protected br.com.prodevelopment.contato.service.TelefoneService telefoneService;
	@BeanReference(type = TelefonePersistence.class)
	protected TelefonePersistence telefonePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ContatoLocalServiceClpInvoker _clpInvoker = new ContatoLocalServiceClpInvoker();
}