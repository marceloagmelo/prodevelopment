package br.com.rasecmadeiras.busca.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.rasecmadeiras.busca.Constantes;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BuscaPortlet
 */
public class BuscaPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		Constantes.NOME_PARAM = getInitParameter(Constantes.NOME_PARAM_INIT);
		Constantes.NOME_PARAM_ID = getInitParameter(Constantes.NOME_PARAM_ID_INIT);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		HttpServletRequest httpReq = PortalUtil
		.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(renderRequest));

		try {
    		String termosBusca = httpReq.getParameter(Constantes.NOME_PARAM);
    		if (Validator.isNull(termosBusca)) {
    			HttpServletRequest httpReq1 = PortalUtil
    					.getOriginalServletRequest(PortalUtil
    							.getHttpServletRequest(renderRequest));
    			termosBusca = httpReq1.getParameter(Constantes.NOME_PARAM);
    		}
    		String tipoConteudo = httpReq.getParameter(Constantes.TIPO_CONTEUDO);
    		if (Validator.isNull(termosBusca)) {
    			HttpServletRequest httpReq1 = PortalUtil
    					.getOriginalServletRequest(PortalUtil
    							.getHttpServletRequest(renderRequest));
    			tipoConteudo = httpReq1.getParameter(Constantes.TIPO_CONTEUDO);
    		}

    		String prefConfigurado = renderRequest.getPreferences().getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);
			String prefUrlDestino = renderRequest.getPreferences().getValue(
					Constantes.PREF_URL_DESTINO, Constantes.TRALHA);

			if (Constantes.S.equals(prefConfigurado)) {
				renderRequest.setAttribute(Constantes.PREF_URL_DESTINO,
						prefUrlDestino);
				renderRequest.setAttribute(Constantes.NOME_PARAM, termosBusca);
				renderRequest.setAttribute(Constantes.TIPO_CONTEUDO, tipoConteudo);

				super.render(renderRequest, renderResponse);
			} else {
				SessionMessages.add(renderRequest,
						"mensagem.portletNaoConfigurado");
				include(naoConfiguradoJSP, renderRequest, renderResponse);

			}
		} catch (Exception e) {

		}
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		try {
			if (!isProcessActionRequest(actionRequest)) {
				return;
			}

			if (!callActionMethod(actionRequest, actionResponse)) {
				return;
			}

			if (!SessionErrors.isEmpty(actionRequest)) {
				return;
			}

			if (!SessionMessages.isEmpty(actionRequest)) {
				return;
			}

			sendRedirect(actionRequest, actionResponse);
		} catch (PortletException pe) {
			Throwable cause = pe.getCause();

			if (isSessionErrorException(cause)) {
				SessionErrors.add(actionRequest, cause.getClass().getName(),
						cause);
			} else {
				throw pe;
			}
		}
	}
}
