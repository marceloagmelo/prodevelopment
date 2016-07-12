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

package br.com.prodevelopment.pesquisaopiniao.service.base;

import br.com.prodevelopment.pesquisaopiniao.model.Resposta;
import br.com.prodevelopment.pesquisaopiniao.service.PerguntaLocalService;
import br.com.prodevelopment.pesquisaopiniao.service.PesquisaLocalService;
import br.com.prodevelopment.pesquisaopiniao.service.Pesquisa_UsuarioLocalService;
import br.com.prodevelopment.pesquisaopiniao.service.RespostaLocalService;
import br.com.prodevelopment.pesquisaopiniao.service.Resposta_UsuarioLocalService;
import br.com.prodevelopment.pesquisaopiniao.service.persistence.PerguntaPersistence;
import br.com.prodevelopment.pesquisaopiniao.service.persistence.PesquisaPersistence;
import br.com.prodevelopment.pesquisaopiniao.service.persistence.Pesquisa_UsuarioPersistence;
import br.com.prodevelopment.pesquisaopiniao.service.persistence.RespostaPersistence;
import br.com.prodevelopment.pesquisaopiniao.service.persistence.Resposta_UsuarioPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the resposta local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link br.com.prodevelopment.pesquisaopiniao.service.impl.RespostaLocalServiceImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.pesquisaopiniao.service.impl.RespostaLocalServiceImpl
 * @see br.com.prodevelopment.pesquisaopiniao.service.RespostaLocalServiceUtil
 * @generated
 */
public abstract class RespostaLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements RespostaLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link br.com.prodevelopment.pesquisaopiniao.service.RespostaLocalServiceUtil} to access the resposta local service.
	 */

	/**
	 * Adds the resposta to the database. Also notifies the appropriate model listeners.
	 *
	 * @param resposta the resposta
	 * @return the resposta that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Resposta addResposta(Resposta resposta) throws SystemException {
		resposta.setNew(true);

		return respostaPersistence.update(resposta, false);
	}

	/**
	 * Creates a new resposta with the primary key. Does not add the resposta to the database.
	 *
	 * @param id the primary key for the new resposta
	 * @return the new resposta
	 */
	public Resposta createResposta(long id) {
		return respostaPersistence.create(id);
	}

	/**
	 * Deletes the resposta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the resposta
	 * @return the resposta that was removed
	 * @throws PortalException if a resposta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Resposta deleteResposta(long id)
		throws PortalException, SystemException {
		return respostaPersistence.remove(id);
	}

	/**
	 * Deletes the resposta from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resposta the resposta
	 * @return the resposta that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Resposta deleteResposta(Resposta resposta) throws SystemException {
		return respostaPersistence.remove(resposta);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Resposta.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return respostaPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return respostaPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return respostaPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return respostaPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Resposta fetchResposta(long id) throws SystemException {
		return respostaPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the resposta with the primary key.
	 *
	 * @param id the primary key of the resposta
	 * @return the resposta
	 * @throws PortalException if a resposta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Resposta getResposta(long id)
		throws PortalException, SystemException {
		return respostaPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return respostaPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the respostas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of respostas
	 * @param end the upper bound of the range of respostas (not inclusive)
	 * @return the range of respostas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Resposta> getRespostas(int start, int end)
		throws SystemException {
		return respostaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of respostas.
	 *
	 * @return the number of respostas
	 * @throws SystemException if a system exception occurred
	 */
	public int getRespostasCount() throws SystemException {
		return respostaPersistence.countAll();
	}

	/**
	 * Updates the resposta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param resposta the resposta
	 * @return the resposta that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Resposta updateResposta(Resposta resposta) throws SystemException {
		return updateResposta(resposta, true);
	}

	/**
	 * Updates the resposta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param resposta the resposta
	 * @param merge whether to merge the resposta with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the resposta that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Resposta updateResposta(Resposta resposta, boolean merge)
		throws SystemException {
		resposta.setNew(false);

		return respostaPersistence.update(resposta, merge);
	}

	/**
	 * Returns the pergunta local service.
	 *
	 * @return the pergunta local service
	 */
	public PerguntaLocalService getPerguntaLocalService() {
		return perguntaLocalService;
	}

	/**
	 * Sets the pergunta local service.
	 *
	 * @param perguntaLocalService the pergunta local service
	 */
	public void setPerguntaLocalService(
		PerguntaLocalService perguntaLocalService) {
		this.perguntaLocalService = perguntaLocalService;
	}

	/**
	 * Returns the pergunta persistence.
	 *
	 * @return the pergunta persistence
	 */
	public PerguntaPersistence getPerguntaPersistence() {
		return perguntaPersistence;
	}

	/**
	 * Sets the pergunta persistence.
	 *
	 * @param perguntaPersistence the pergunta persistence
	 */
	public void setPerguntaPersistence(PerguntaPersistence perguntaPersistence) {
		this.perguntaPersistence = perguntaPersistence;
	}

	/**
	 * Returns the pesquisa local service.
	 *
	 * @return the pesquisa local service
	 */
	public PesquisaLocalService getPesquisaLocalService() {
		return pesquisaLocalService;
	}

	/**
	 * Sets the pesquisa local service.
	 *
	 * @param pesquisaLocalService the pesquisa local service
	 */
	public void setPesquisaLocalService(
		PesquisaLocalService pesquisaLocalService) {
		this.pesquisaLocalService = pesquisaLocalService;
	}

	/**
	 * Returns the pesquisa persistence.
	 *
	 * @return the pesquisa persistence
	 */
	public PesquisaPersistence getPesquisaPersistence() {
		return pesquisaPersistence;
	}

	/**
	 * Sets the pesquisa persistence.
	 *
	 * @param pesquisaPersistence the pesquisa persistence
	 */
	public void setPesquisaPersistence(PesquisaPersistence pesquisaPersistence) {
		this.pesquisaPersistence = pesquisaPersistence;
	}

	/**
	 * Returns the pesquisa_ usuario local service.
	 *
	 * @return the pesquisa_ usuario local service
	 */
	public Pesquisa_UsuarioLocalService getPesquisa_UsuarioLocalService() {
		return pesquisa_UsuarioLocalService;
	}

	/**
	 * Sets the pesquisa_ usuario local service.
	 *
	 * @param pesquisa_UsuarioLocalService the pesquisa_ usuario local service
	 */
	public void setPesquisa_UsuarioLocalService(
		Pesquisa_UsuarioLocalService pesquisa_UsuarioLocalService) {
		this.pesquisa_UsuarioLocalService = pesquisa_UsuarioLocalService;
	}

	/**
	 * Returns the pesquisa_ usuario persistence.
	 *
	 * @return the pesquisa_ usuario persistence
	 */
	public Pesquisa_UsuarioPersistence getPesquisa_UsuarioPersistence() {
		return pesquisa_UsuarioPersistence;
	}

	/**
	 * Sets the pesquisa_ usuario persistence.
	 *
	 * @param pesquisa_UsuarioPersistence the pesquisa_ usuario persistence
	 */
	public void setPesquisa_UsuarioPersistence(
		Pesquisa_UsuarioPersistence pesquisa_UsuarioPersistence) {
		this.pesquisa_UsuarioPersistence = pesquisa_UsuarioPersistence;
	}

	/**
	 * Returns the resposta local service.
	 *
	 * @return the resposta local service
	 */
	public RespostaLocalService getRespostaLocalService() {
		return respostaLocalService;
	}

	/**
	 * Sets the resposta local service.
	 *
	 * @param respostaLocalService the resposta local service
	 */
	public void setRespostaLocalService(
		RespostaLocalService respostaLocalService) {
		this.respostaLocalService = respostaLocalService;
	}

	/**
	 * Returns the resposta persistence.
	 *
	 * @return the resposta persistence
	 */
	public RespostaPersistence getRespostaPersistence() {
		return respostaPersistence;
	}

	/**
	 * Sets the resposta persistence.
	 *
	 * @param respostaPersistence the resposta persistence
	 */
	public void setRespostaPersistence(RespostaPersistence respostaPersistence) {
		this.respostaPersistence = respostaPersistence;
	}

	/**
	 * Returns the resposta_ usuario local service.
	 *
	 * @return the resposta_ usuario local service
	 */
	public Resposta_UsuarioLocalService getResposta_UsuarioLocalService() {
		return resposta_UsuarioLocalService;
	}

	/**
	 * Sets the resposta_ usuario local service.
	 *
	 * @param resposta_UsuarioLocalService the resposta_ usuario local service
	 */
	public void setResposta_UsuarioLocalService(
		Resposta_UsuarioLocalService resposta_UsuarioLocalService) {
		this.resposta_UsuarioLocalService = resposta_UsuarioLocalService;
	}

	/**
	 * Returns the resposta_ usuario persistence.
	 *
	 * @return the resposta_ usuario persistence
	 */
	public Resposta_UsuarioPersistence getResposta_UsuarioPersistence() {
		return resposta_UsuarioPersistence;
	}

	/**
	 * Sets the resposta_ usuario persistence.
	 *
	 * @param resposta_UsuarioPersistence the resposta_ usuario persistence
	 */
	public void setResposta_UsuarioPersistence(
		Resposta_UsuarioPersistence resposta_UsuarioPersistence) {
		this.resposta_UsuarioPersistence = resposta_UsuarioPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
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
		PersistedModelLocalServiceRegistryUtil.register("br.com.prodevelopment.pesquisaopiniao.model.Resposta",
			respostaLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"br.com.prodevelopment.pesquisaopiniao.model.Resposta");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return Resposta.class;
	}

	protected String getModelClassName() {
		return Resposta.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = respostaPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = PerguntaLocalService.class)
	protected PerguntaLocalService perguntaLocalService;
	@BeanReference(type = PerguntaPersistence.class)
	protected PerguntaPersistence perguntaPersistence;
	@BeanReference(type = PesquisaLocalService.class)
	protected PesquisaLocalService pesquisaLocalService;
	@BeanReference(type = PesquisaPersistence.class)
	protected PesquisaPersistence pesquisaPersistence;
	@BeanReference(type = Pesquisa_UsuarioLocalService.class)
	protected Pesquisa_UsuarioLocalService pesquisa_UsuarioLocalService;
	@BeanReference(type = Pesquisa_UsuarioPersistence.class)
	protected Pesquisa_UsuarioPersistence pesquisa_UsuarioPersistence;
	@BeanReference(type = RespostaLocalService.class)
	protected RespostaLocalService respostaLocalService;
	@BeanReference(type = RespostaPersistence.class)
	protected RespostaPersistence respostaPersistence;
	@BeanReference(type = Resposta_UsuarioLocalService.class)
	protected Resposta_UsuarioLocalService resposta_UsuarioLocalService;
	@BeanReference(type = Resposta_UsuarioPersistence.class)
	protected Resposta_UsuarioPersistence resposta_UsuarioPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private RespostaLocalServiceClpInvoker _clpInvoker = new RespostaLocalServiceClpInvoker();
}