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

import br.com.prodevelopment.contato.model.Telefone;
import br.com.prodevelopment.contato.service.TelefoneLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Marcelo Melo
 * @generated
 */
public abstract class TelefoneActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public TelefoneActionableDynamicQuery() throws SystemException {
		setBaseLocalService(TelefoneLocalServiceUtil.getService());
		setClass(Telefone.class);

		setClassLoader(br.com.prodevelopment.contato.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("telefoneId");
	}
}