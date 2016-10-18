package br.com.prodevelopment.portlet.cliente.util;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.portlet.cliente.Constantes;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ContatoUtil {

	public static Contato getContato(long contatoId) throws SystemException {
		return ContatoLocalServiceUtil.fetchContato(contatoId);
	}

	public static Contato getContato(HttpServletRequest request)
			throws PortalException, SystemException {

		long contatoId = ParamUtil.getLong(request, Constantes.CONTATO_ID);

		Contato contato = null;
		if (contatoId > 0) {
			contato = ContatoLocalServiceUtil.getContato(contatoId);
		}

		request.setAttribute(Constantes.CONTATO, contato);
		request.setAttribute(Constantes.CONTATO_ID, contatoId);

		return contato;
	}

	public static Contato getContato(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getContato(request);
	}

	public static Contato getContato(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getContato(request);
	}

	public static Contato getContato() throws SystemException {
		
		return ContatoLocalServiceUtil.createContato();
	}
}
