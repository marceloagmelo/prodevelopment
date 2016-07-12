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

import br.com.prodevelopment.municipio.model.Municipio;
import br.com.prodevelopment.municipio.service.MunicipioLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Marcelo Melo
 * @generated
 */
public abstract class MunicipioActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public MunicipioActionableDynamicQuery() throws SystemException {
		setBaseLocalService(MunicipioLocalServiceUtil.getService());
		setClass(Municipio.class);

		setClassLoader(br.com.prodevelopment.municipio.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("codigo");
	}
}