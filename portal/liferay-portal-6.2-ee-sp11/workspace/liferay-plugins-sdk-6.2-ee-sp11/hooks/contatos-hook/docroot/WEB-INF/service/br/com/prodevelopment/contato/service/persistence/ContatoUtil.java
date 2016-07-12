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

import br.com.prodevelopment.contato.model.Contato;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contato service. This utility wraps {@link ContatoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcelo Melo
 * @see ContatoPersistence
 * @see ContatoPersistenceImpl
 * @generated
 */
public class ContatoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Contato contato) {
		getPersistence().clearCache(contato);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Contato> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Contato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Contato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Contato update(Contato contato) throws SystemException {
		return getPersistence().update(contato);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Contato update(Contato contato, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(contato, serviceContext);
	}

	/**
	* Returns all the contatos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first contato in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last contato in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByCompanyId_PrevAndNext(
		long contatoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(contatoId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of contatos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, groupId, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_First(companyId, groupId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, groupId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_Last(companyId, groupId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, groupId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_G_PrevAndNext(
		long contatoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_PrevAndNext(contatoId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G(companyId, groupId);
	}

	/**
	* Returns the number of contatos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, groupId);
	}

	/**
	* Returns all the contatos where accountId = &#63;.
	*
	* @param accountId the account ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByAccountId(
		long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAccountId(accountId);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByAccountId(
		long accountId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAccountId(accountId, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByAccountId(
		long accountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAccountId(accountId, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByAccountId_First(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAccountId_First(accountId, orderByComparator);
	}

	/**
	* Returns the first contato in the ordered set where accountId = &#63;.
	*
	* @param accountId the account ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByAccountId_First(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAccountId_First(accountId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByAccountId_Last(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAccountId_Last(accountId, orderByComparator);
	}

	/**
	* Returns the last contato in the ordered set where accountId = &#63;.
	*
	* @param accountId the account ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByAccountId_Last(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAccountId_Last(accountId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByAccountId_PrevAndNext(
		long contatoId, long accountId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAccountId_PrevAndNext(contatoId, accountId,
			orderByComparator);
	}

	/**
	* Removes all the contatos where accountId = &#63; from the database.
	*
	* @param accountId the account ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAccountId(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAccountId(accountId);
	}

	/**
	* Returns the number of contatos where accountId = &#63;.
	*
	* @param accountId the account ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAccountId(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAccountId(accountId);
	}

	/**
	* Returns the contato where classNameId = &#63; and classPK = &#63; or throws a {@link br.com.prodevelopment.contato.NoSuchContatoException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato findByContato(
		long classNameId, long classPK)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContato(classNameId, classPK);
	}

	/**
	* Returns the contato where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByContato(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByContato(classNameId, classPK);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByContato(
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContato(classNameId, classPK, retrieveFromCache);
	}

	/**
	* Removes the contato where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the contato that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato removeByContato(
		long classNameId, long classPK)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByContato(classNameId, classPK);
	}

	/**
	* Returns the number of contatos where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContato(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContato(classNameId, classPK);
	}

	/**
	* Returns all the contatos where companyId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_CARGO(
		long companyId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_CARGO(companyId, cargoId);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_CARGO(
		long companyId, long cargoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_CARGO(companyId, cargoId, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_CARGO(
		long companyId, long cargoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CARGO(companyId, cargoId, start, end,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_CARGO_First(
		long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CARGO_First(companyId, cargoId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_CARGO_First(
		long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_CARGO_First(companyId, cargoId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_CARGO_Last(
		long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CARGO_Last(companyId, cargoId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_CARGO_Last(
		long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_CARGO_Last(companyId, cargoId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_CARGO_PrevAndNext(
		long contatoId, long companyId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_CARGO_PrevAndNext(contatoId, companyId, cargoId,
			orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and cargoId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_CARGO(long companyId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_CARGO(companyId, cargoId);
	}

	/**
	* Returns the number of contatos where companyId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param cargoId the cargo ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_CARGO(long companyId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_CARGO(companyId, cargoId);
	}

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_CARGO(
		long companyId, long groupId, long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_CARGO(companyId, groupId, cargoId);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_CARGO(
		long companyId, long groupId, long cargoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CARGO(companyId, groupId, cargoId, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_CARGO(
		long companyId, long groupId, long cargoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CARGO(companyId, groupId, cargoId, start, end,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_CARGO_First(
		long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CARGO_First(companyId, groupId, cargoId,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_CARGO_First(
		long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_CARGO_First(companyId, groupId, cargoId,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_CARGO_Last(
		long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CARGO_Last(companyId, groupId, cargoId,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_CARGO_Last(
		long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_CARGO_Last(companyId, groupId, cargoId,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_G_CARGO_PrevAndNext(
		long contatoId, long companyId, long groupId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_CARGO_PrevAndNext(contatoId, companyId, groupId,
			cargoId, orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and cargoId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param cargoId the cargo ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_CARGO(long companyId, long groupId,
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_CARGO(companyId, groupId, cargoId);
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
	public static int countByC_G_CARGO(long companyId, long groupId,
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_CARGO(companyId, groupId, cargoId);
	}

	/**
	* Returns all the contatos where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByCARGO(
		long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCARGO(cargoId);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByCARGO(
		long cargoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCARGO(cargoId, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByCARGO(
		long cargoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCARGO(cargoId, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByCARGO_First(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCARGO_First(cargoId, orderByComparator);
	}

	/**
	* Returns the first contato in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByCARGO_First(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCARGO_First(cargoId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByCARGO_Last(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCARGO_Last(cargoId, orderByComparator);
	}

	/**
	* Returns the last contato in the ordered set where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByCARGO_Last(
		long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCARGO_Last(cargoId, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByCARGO_PrevAndNext(
		long contatoId, long cargoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCARGO_PrevAndNext(contatoId, cargoId,
			orderByComparator);
	}

	/**
	* Removes all the contatos where cargoId = &#63; from the database.
	*
	* @param cargoId the cargo ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCARGO(long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCARGO(cargoId);
	}

	/**
	* Returns the number of contatos where cargoId = &#63;.
	*
	* @param cargoId the cargo ID
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCARGO(long cargoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCARGO(cargoId);
	}

	/**
	* Returns all the contatos where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_NOME(
		long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_NOME(companyId, nome);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_NOME(companyId, nome, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_NOME(
		long companyId, java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME(companyId, nome, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_First(companyId, nome, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_NOME_First(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_NOME_First(companyId, nome, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_Last(companyId, nome, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_NOME_Last(
		long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_NOME_Last(companyId, nome, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_NOME_PrevAndNext(
		long contatoId, long companyId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_NOME_PrevAndNext(contatoId, companyId, nome,
			orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_NOME(companyId, nome);
	}

	/**
	* Returns the number of contatos where companyId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param nome the nome
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_NOME(long companyId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_NOME(companyId, nome);
	}

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_NOME(companyId, groupId, nome);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME(companyId, groupId, nome, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_NOME(
		long companyId, long groupId, java.lang.String nome, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME(companyId, groupId, nome, start, end,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_First(companyId, groupId, nome,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_NOME_First(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_NOME_First(companyId, groupId, nome,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_Last(companyId, groupId, nome,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_NOME_Last(
		long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_NOME_Last(companyId, groupId, nome,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_G_NOME_PrevAndNext(
		long contatoId, long companyId, long groupId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_NOME_PrevAndNext(contatoId, companyId, groupId,
			nome, orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and nome LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_NOME(companyId, groupId, nome);
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
	public static int countByC_G_NOME(long companyId, long groupId,
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_NOME(companyId, groupId, nome);
	}

	/**
	* Returns all the contatos where nome LIKE &#63;.
	*
	* @param nome the nome
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByNOME(
		java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNOME(nome);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByNOME(
		java.lang.String nome, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNOME(nome, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByNOME(
		java.lang.String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNOME(nome, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByNOME_First(
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNOME_First(nome, orderByComparator);
	}

	/**
	* Returns the first contato in the ordered set where nome LIKE &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByNOME_First(
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNOME_First(nome, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByNOME_Last(
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNOME_Last(nome, orderByComparator);
	}

	/**
	* Returns the last contato in the ordered set where nome LIKE &#63;.
	*
	* @param nome the nome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByNOME_Last(
		java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNOME_Last(nome, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByNOME_PrevAndNext(
		long contatoId, java.lang.String nome,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNOME_PrevAndNext(contatoId, nome, orderByComparator);
	}

	/**
	* Removes all the contatos where nome LIKE &#63; from the database.
	*
	* @param nome the nome
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNOME(java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNOME(nome);
	}

	/**
	* Returns the number of contatos where nome LIKE &#63;.
	*
	* @param nome the nome
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNOME(java.lang.String nome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNOME(nome);
	}

	/**
	* Returns all the contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_DTN(
		long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_DTN(companyId, dataNascimento);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_DTN(
		long companyId, java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DTN(companyId, dataNascimento, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_DTN(
		long companyId, java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DTN(companyId, dataNascimento, start, end,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_DTN_First(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DTN_First(companyId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_DTN_First(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_DTN_First(companyId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_DTN_Last(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DTN_Last(companyId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_DTN_Last(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_DTN_Last(companyId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_DTN_PrevAndNext(
		long contatoId, long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_DTN_PrevAndNext(contatoId, companyId,
			dataNascimento, orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and dataNascimento = &#63; from the database.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_DTN(long companyId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_DTN(companyId, dataNascimento);
	}

	/**
	* Returns the number of contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_DTN(long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_DTN(companyId, dataNascimento);
	}

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_DTN(
		long companyId, long groupId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_DTN(companyId, groupId, dataNascimento);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_DTN(
		long companyId, long groupId, java.util.Date dataNascimento, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DTN(companyId, groupId, dataNascimento, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_DTN(
		long companyId, long groupId, java.util.Date dataNascimento, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DTN(companyId, groupId, dataNascimento, start,
			end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_DTN_First(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DTN_First(companyId, groupId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_DTN_First(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_DTN_First(companyId, groupId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_DTN_Last(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DTN_Last(companyId, groupId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_DTN_Last(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_DTN_Last(companyId, groupId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_G_DTN_PrevAndNext(
		long contatoId, long companyId, long groupId,
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_DTN_PrevAndNext(contatoId, companyId, groupId,
			dataNascimento, orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_DTN(long companyId, long groupId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_DTN(companyId, groupId, dataNascimento);
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
	public static int countByC_G_DTN(long companyId, long groupId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_DTN(companyId, groupId, dataNascimento);
	}

	/**
	* Returns all the contatos where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByDTN(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDTN(dataNascimento);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByDTN(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDTN(dataNascimento, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByDTN(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDTN(dataNascimento, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByDTN_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDTN_First(dataNascimento, orderByComparator);
	}

	/**
	* Returns the first contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByDTN_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDTN_First(dataNascimento, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByDTN_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDTN_Last(dataNascimento, orderByComparator);
	}

	/**
	* Returns the last contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByDTN_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDTN_Last(dataNascimento, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByDTN_PrevAndNext(
		long contatoId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDTN_PrevAndNext(contatoId, dataNascimento,
			orderByComparator);
	}

	/**
	* Removes all the contatos where dataNascimento = &#63; from the database.
	*
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDTN(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDTN(dataNascimento);
	}

	/**
	* Returns the number of contatos where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDTN(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDTN(dataNascimento);
	}

	/**
	* Returns all the contatos where companyId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_EMAIL(
		long companyId, java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_EMAIL(companyId, endEmail);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_EMAIL(
		long companyId, java.lang.String endEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_EMAIL(companyId, endEmail, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_EMAIL(
		long companyId, java.lang.String endEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_EMAIL(companyId, endEmail, start, end,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_EMAIL_First(
		long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_EMAIL_First(companyId, endEmail, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_EMAIL_First(
		long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_EMAIL_First(companyId, endEmail, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_EMAIL_Last(
		long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_EMAIL_Last(companyId, endEmail, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_EMAIL_Last(
		long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_EMAIL_Last(companyId, endEmail, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_EMAIL_PrevAndNext(
		long contatoId, long companyId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_EMAIL_PrevAndNext(contatoId, companyId, endEmail,
			orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and endEmail = &#63; from the database.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_EMAIL(long companyId, java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_EMAIL(companyId, endEmail);
	}

	/**
	* Returns the number of contatos where companyId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param endEmail the end email
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_EMAIL(long companyId, java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_EMAIL(companyId, endEmail);
	}

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_EMAIL(
		long companyId, long groupId, java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_EMAIL(companyId, groupId, endEmail);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_EMAIL(
		long companyId, long groupId, java.lang.String endEmail, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_EMAIL(companyId, groupId, endEmail, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_EMAIL(
		long companyId, long groupId, java.lang.String endEmail, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_EMAIL(companyId, groupId, endEmail, start, end,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_EMAIL_First(
		long companyId, long groupId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_EMAIL_First(companyId, groupId, endEmail,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_EMAIL_First(
		long companyId, long groupId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_EMAIL_First(companyId, groupId, endEmail,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_EMAIL_Last(
		long companyId, long groupId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_EMAIL_Last(companyId, groupId, endEmail,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_EMAIL_Last(
		long companyId, long groupId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_EMAIL_Last(companyId, groupId, endEmail,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_G_EMAIL_PrevAndNext(
		long contatoId, long companyId, long groupId,
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_EMAIL_PrevAndNext(contatoId, companyId, groupId,
			endEmail, orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and endEmail = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param endEmail the end email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_EMAIL(long companyId, long groupId,
		java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_EMAIL(companyId, groupId, endEmail);
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
	public static int countByC_G_EMAIL(long companyId, long groupId,
		java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_EMAIL(companyId, groupId, endEmail);
	}

	/**
	* Returns all the contatos where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByEMAIL(
		java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEMAIL(endEmail);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByEMAIL(
		java.lang.String endEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEMAIL(endEmail, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByEMAIL(
		java.lang.String endEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEMAIL(endEmail, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByEMAIL_First(
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEMAIL_First(endEmail, orderByComparator);
	}

	/**
	* Returns the first contato in the ordered set where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByEMAIL_First(
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEMAIL_First(endEmail, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByEMAIL_Last(
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEMAIL_Last(endEmail, orderByComparator);
	}

	/**
	* Returns the last contato in the ordered set where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByEMAIL_Last(
		java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEMAIL_Last(endEmail, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByEMAIL_PrevAndNext(
		long contatoId, java.lang.String endEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEMAIL_PrevAndNext(contatoId, endEmail,
			orderByComparator);
	}

	/**
	* Removes all the contatos where endEmail = &#63; from the database.
	*
	* @param endEmail the end email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEMAIL(java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEMAIL(endEmail);
	}

	/**
	* Returns the number of contatos where endEmail = &#63;.
	*
	* @param endEmail the end email
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEMAIL(java.lang.String endEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEMAIL(endEmail);
	}

	/**
	* Returns all the contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_SEXO(
		long companyId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_SEXO(companyId, dataNascimento);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_SEXO(
		long companyId, java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_SEXO(companyId, dataNascimento, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_SEXO(
		long companyId, java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_SEXO(companyId, dataNascimento, start, end,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_SEXO_First(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_SEXO_First(companyId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_SEXO_First(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_SEXO_First(companyId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_SEXO_Last(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_SEXO_Last(companyId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_SEXO_Last(
		long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_SEXO_Last(companyId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_SEXO_PrevAndNext(
		long contatoId, long companyId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_SEXO_PrevAndNext(contatoId, companyId,
			dataNascimento, orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and dataNascimento = &#63; from the database.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_SEXO(long companyId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_SEXO(companyId, dataNascimento);
	}

	/**
	* Returns the number of contatos where companyId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_SEXO(long companyId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_SEXO(companyId, dataNascimento);
	}

	/**
	* Returns all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_SEXO(
		long companyId, long groupId, java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_SEXO(companyId, groupId, dataNascimento);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_SEXO(
		long companyId, long groupId, java.util.Date dataNascimento, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_SEXO(companyId, groupId, dataNascimento, start,
			end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findByC_G_SEXO(
		long companyId, long groupId, java.util.Date dataNascimento, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_SEXO(companyId, groupId, dataNascimento, start,
			end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_SEXO_First(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_SEXO_First(companyId, groupId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_SEXO_First(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_SEXO_First(companyId, groupId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findByC_G_SEXO_Last(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_SEXO_Last(companyId, groupId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato fetchByC_G_SEXO_Last(
		long companyId, long groupId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_SEXO_Last(companyId, groupId, dataNascimento,
			orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findByC_G_SEXO_PrevAndNext(
		long contatoId, long companyId, long groupId,
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_SEXO_PrevAndNext(contatoId, companyId, groupId,
			dataNascimento, orderByComparator);
	}

	/**
	* Removes all the contatos where companyId = &#63; and groupId = &#63; and dataNascimento = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_SEXO(long companyId, long groupId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_SEXO(companyId, groupId, dataNascimento);
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
	public static int countByC_G_SEXO(long companyId, long groupId,
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_SEXO(companyId, groupId, dataNascimento);
	}

	/**
	* Returns all the contatos where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findBySEXO(
		java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySEXO(dataNascimento);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findBySEXO(
		java.util.Date dataNascimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySEXO(dataNascimento, start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findBySEXO(
		java.util.Date dataNascimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySEXO(dataNascimento, start, end, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findBySEXO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySEXO_First(dataNascimento, orderByComparator);
	}

	/**
	* Returns the first contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchBySEXO_First(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySEXO_First(dataNascimento, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato findBySEXO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySEXO_Last(dataNascimento, orderByComparator);
	}

	/**
	* Returns the last contato in the ordered set where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contato, or <code>null</code> if a matching contato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchBySEXO_Last(
		java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySEXO_Last(dataNascimento, orderByComparator);
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
	public static br.com.prodevelopment.contato.model.Contato[] findBySEXO_PrevAndNext(
		long contatoId, java.util.Date dataNascimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySEXO_PrevAndNext(contatoId, dataNascimento,
			orderByComparator);
	}

	/**
	* Removes all the contatos where dataNascimento = &#63; from the database.
	*
	* @param dataNascimento the data nascimento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySEXO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySEXO(dataNascimento);
	}

	/**
	* Returns the number of contatos where dataNascimento = &#63;.
	*
	* @param dataNascimento the data nascimento
	* @return the number of matching contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySEXO(java.util.Date dataNascimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySEXO(dataNascimento);
	}

	/**
	* Caches the contato in the entity cache if it is enabled.
	*
	* @param contato the contato
	*/
	public static void cacheResult(
		br.com.prodevelopment.contato.model.Contato contato) {
		getPersistence().cacheResult(contato);
	}

	/**
	* Caches the contatos in the entity cache if it is enabled.
	*
	* @param contatos the contatos
	*/
	public static void cacheResult(
		java.util.List<br.com.prodevelopment.contato.model.Contato> contatos) {
		getPersistence().cacheResult(contatos);
	}

	/**
	* Creates a new contato with the primary key. Does not add the contato to the database.
	*
	* @param contatoId the primary key for the new contato
	* @return the new contato
	*/
	public static br.com.prodevelopment.contato.model.Contato create(
		long contatoId) {
		return getPersistence().create(contatoId);
	}

	/**
	* Removes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contatoId the primary key of the contato
	* @return the contato that was removed
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato remove(
		long contatoId)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(contatoId);
	}

	public static br.com.prodevelopment.contato.model.Contato updateImpl(
		br.com.prodevelopment.contato.model.Contato contato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contato);
	}

	/**
	* Returns the contato with the primary key or throws a {@link br.com.prodevelopment.contato.NoSuchContatoException} if it could not be found.
	*
	* @param contatoId the primary key of the contato
	* @return the contato
	* @throws br.com.prodevelopment.contato.NoSuchContatoException if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato findByPrimaryKey(
		long contatoId)
		throws br.com.prodevelopment.contato.NoSuchContatoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(contatoId);
	}

	/**
	* Returns the contato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contatoId the primary key of the contato
	* @return the contato, or <code>null</code> if a contato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.prodevelopment.contato.model.Contato fetchByPrimaryKey(
		long contatoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contatoId);
	}

	/**
	* Returns all the contatos.
	*
	* @return the contatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<br.com.prodevelopment.contato.model.Contato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contatos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contatos.
	*
	* @return the number of contatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContatoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContatoPersistence)PortletBeanLocatorUtil.locate(br.com.prodevelopment.contato.service.ClpSerializer.getServletContextName(),
					ContatoPersistence.class.getName());

			ReferenceRegistry.registerReference(ContatoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ContatoPersistence persistence) {
	}

	private static ContatoPersistence _persistence;
}