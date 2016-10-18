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

package br.com.prodevelopment.cliente.service.messaging;

import br.com.prodevelopment.cliente.service.ClienteLimCreditoLocalServiceUtil;
import br.com.prodevelopment.cliente.service.ClienteLimCreditoServiceUtil;
import br.com.prodevelopment.cliente.service.ClienteLocalServiceUtil;
import br.com.prodevelopment.cliente.service.ClienteServiceUtil;
import br.com.prodevelopment.cliente.service.ClienteUsuarioLocalServiceUtil;
import br.com.prodevelopment.cliente.service.ClienteUsuarioServiceUtil;
import br.com.prodevelopment.cliente.service.ClpSerializer;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author marcelo
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ClienteLocalServiceUtil.clearService();

			ClienteServiceUtil.clearService();
			ClienteLimCreditoLocalServiceUtil.clearService();

			ClienteLimCreditoServiceUtil.clearService();
			ClienteUsuarioLocalServiceUtil.clearService();

			ClienteUsuarioServiceUtil.clearService();
		}
	}
}