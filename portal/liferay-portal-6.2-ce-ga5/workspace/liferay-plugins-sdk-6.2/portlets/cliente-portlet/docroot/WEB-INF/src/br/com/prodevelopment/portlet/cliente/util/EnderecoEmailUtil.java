package br.com.prodevelopment.portlet.cliente.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.service.EnderecoEmailLocalServiceUtil;
import br.com.prodevelopment.portlet.cliente.Constantes;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PortalUtil;

public class EnderecoEmailUtil {

	public static EnderecoEmail getEnderecoEmail(long enderecoEmailId) throws SystemException {
		return EnderecoEmailLocalServiceUtil.fetchEnderecoEmail(enderecoEmailId);
	}

	public static EnderecoEmail getEnderecoEmail(HttpServletRequest request)
			throws PortalException, SystemException {

		long enderecoEmailId = ParamUtil.getLong(request, Constantes.ENDERECO_EMAIL_ID);

		EnderecoEmail enderecoEmail = null;
		if (enderecoEmailId > 0) {
			enderecoEmail = EnderecoEmailLocalServiceUtil.getEnderecoEmail(enderecoEmailId);
		}

		request.setAttribute(Constantes.ENDERECO_EMAIL, enderecoEmail);
		request.setAttribute(Constantes.ENDERECO_EMAIL_ID, enderecoEmailId);

		return enderecoEmail;
	}

	public static EnderecoEmail getEnderecoEmail(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getEnderecoEmail(request);
	}

	public static EnderecoEmail getEnderecoEmail(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getEnderecoEmail(request);
	}

	public static EnderecoEmail getEnderecoEmail() throws SystemException {
		return EnderecoEmailLocalServiceUtil.createEnderecoEmail();
	}

	public static List<EnderecoEmail> getEnderecosEmail(long companyId, long classPK)
			throws SystemException {
		return EnderecoEmailLocalServiceUtil.getEnderecosEmail(companyId,
				Contato.class.getName(), classPK);
	}

	public static List<EnderecoEmail> getEnderecosEmail(ActionRequest actionRequest) {
		return getEnderecosEmail(actionRequest, Collections.<EnderecoEmail> emptyList());
	}

	public static List<EnderecoEmail> getEnderecosEmail(ActionRequest actionRequest,
			List<EnderecoEmail> defaultEnderecosEmail) {

		String enderecosEmailIndexesString = actionRequest
				.getParameter("enderecosEmailIndexes");

		if (enderecosEmailIndexesString == null) {
			return defaultEnderecosEmail;
		}

		List<EnderecoEmail> enderecosEmail = new ArrayList<EnderecoEmail>();

		int[] enderecosEmailIndexes = StringUtil.split(enderecosEmailIndexesString, 0);

		int principal = ParamUtil.getInteger(actionRequest,
				Constantes.CAMPO_ENDERECO_EMAIL_PRINCIPAL);

		for (int enderecosEmailIndex : enderecosEmailIndexes) {
			long enderecoEmailId = ParamUtil.getLong(actionRequest,
					Constantes.ENDERECO_EMAIL_ID + enderecosEmailIndex);

			int tipo = ParamUtil.getInteger(actionRequest,
					Constantes.CAMPO_TIPO_ENDERECO_EMAIL + enderecosEmailIndex);
			String endereco = ParamUtil.getString(actionRequest,
					Constantes.CAMPO_ENDERECO_EMAIL_ENDERECO + enderecosEmailIndex);

			if (tipo == 0) {
				continue;
			}

			boolean bPrincipal = false;

			if (enderecosEmailIndex == principal) {
				bPrincipal = true;
			}

			EnderecoEmail enderecoEmail = EnderecoEmailLocalServiceUtil
					.createEnderecoEmail(enderecoEmailId);

			enderecoEmail.setEndereco(endereco);
			enderecoEmail.setTipo(tipo);
			enderecoEmail.setPrincipal(bPrincipal);

			enderecosEmail.add(enderecoEmail);
		}

		return enderecosEmail;
	}
}
