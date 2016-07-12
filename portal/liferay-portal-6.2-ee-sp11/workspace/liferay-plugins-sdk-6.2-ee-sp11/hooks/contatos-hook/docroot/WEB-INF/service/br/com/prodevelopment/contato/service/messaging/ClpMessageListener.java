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
 * @author Marcelo Melo
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