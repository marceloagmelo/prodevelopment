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

package br.com.prodevelopment.contato.service.messaging;

import br.com.prodevelopment.contato.service.ClpSerializer;
import br.com.prodevelopment.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.contato.service.ContatoServiceUtil;
import br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil;
import br.com.prodevelopment.contato.service.EnderecoEmailServiceUtil;
import br.com.prodevelopment.contato.service.EnderecoLocalServiceUtil;
import br.com.prodevelopment.contato.service.EnderecoServiceUtil;
import br.com.prodevelopment.contato.service.TelefoneLocalServiceUtil;
import br.com.prodevelopment.contato.service.TelefoneServiceUtil;

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
			ContatoLocalServiceUtil.clearService();

			ContatoServiceUtil.clearService();
			EnderecoLocalServiceUtil.clearService();

			EnderecoServiceUtil.clearService();
			EnderecoEmailLocalServiceUtil.clearService();

			EnderecoEmailServiceUtil.clearService();
			TelefoneLocalServiceUtil.clearService();

			TelefoneServiceUtil.clearService();
		}
	}
}