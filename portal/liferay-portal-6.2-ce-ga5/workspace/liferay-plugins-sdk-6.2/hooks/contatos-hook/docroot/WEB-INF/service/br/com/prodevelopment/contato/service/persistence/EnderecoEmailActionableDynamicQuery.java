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

package br.com.prodevelopment.contato.service.persistence;

import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Marcelo Melo
 * @generated
 */
public abstract class EnderecoEmailActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public EnderecoEmailActionableDynamicQuery() throws SystemException {
		setBaseLocalService(EnderecoEmailLocalServiceUtil.getService());
		setClass(EnderecoEmail.class);

		setClassLoader(br.com.prodevelopment.contato.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("enderecoEmailId");
	}
}