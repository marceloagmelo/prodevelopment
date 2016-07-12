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

package br.com.prodevelopment.contato.service.base;

import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.service.ContatoService;
import br.com.prodevelopment.contato.service.persistence.ContatoPersistence;
import br.com.prodevelopment.contato.service.persistence.EnderecoEmailPersistence;
import br.com.prodevelopment.contato.service.persistence.EnderecoPersistence;
import br.com.prodevelopment.contato.service.persistence.TelefonePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the contato remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link br.com.prodevelopment.contato.service.impl.ContatoServiceImpl}.
 * </p>
 *
 * @author Marcelo Melo
 * @see br.com.prodevelopment.contato.service.impl.ContatoServiceImpl
 * @see br.com.prodevelopment.contato.service.ContatoServiceUtil
 * @generated
 */
public abstract class ContatoServiceBaseImpl extends BaseServiceImpl
	implements ContatoService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link br.com.prodevelopment.contato.service.ContatoServiceUtil} to access the contato remote service.
	 */

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
	}

	public void destroy() {
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
	private ContatoServiceClpInvoker _clpInvoker = new ContatoServiceClpInvoker();
}