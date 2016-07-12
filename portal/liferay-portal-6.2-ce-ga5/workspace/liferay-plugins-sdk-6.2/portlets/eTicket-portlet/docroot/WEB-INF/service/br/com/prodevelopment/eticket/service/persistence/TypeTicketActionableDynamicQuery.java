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

package br.com.prodevelopment.eticket.service.persistence;

import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.service.TypeTicketLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Marcelo Melo
 * @generated
 */
public abstract class TypeTicketActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public TypeTicketActionableDynamicQuery() throws SystemException {
		setBaseLocalService(TypeTicketLocalServiceUtil.getService());
		setClass(TypeTicket.class);

		setClassLoader(br.com.prodevelopment.eticket.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("typeTicketId");
	}
}