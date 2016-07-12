package br.com.prodevelopment.portlet.conteudoweb.thumbnail.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.portlet.conteudoweb.lista.Constantes;
import br.com.prodevelopment.portlet.conteudoweb.util.Helper;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ThumbnailConteudosPortlet
 */
public class ThumbnailConteudosPortlet extends MVCPortlet {
	protected String naoConfiguradoJSP;
	protected String exibirConteudoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		exibirConteudoJSP = getInitParameter(Constantes.JSP_EXIBIR_CONTEUDO);

		addProcessActionSuccessMessage = GetterUtil.getBoolean(
				getInitParameter("add-process-action-success-action"), false);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(renderRequest));
	
			String articleId = httpReq.getParameter(Constantes.NOME_PARAM_ARTICLE_ID);

			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);

			if (Constantes.S.equals(prefConfigurado)) {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
						.getAttribute(WebKeys.THEME_DISPLAY);
				
				String portletTitulo = ParamUtil.getString(renderRequest,
						Constantes.NOME_PARAM_TITULO_PORTLET);
				
				String keywords = ParamUtil.getString(renderRequest, "keywords");

				if (Validator.isNull(portletTitulo)) {
					portletTitulo = Helper.getTituloPortlet(renderRequest,
							renderResponse, themeDisplay);
				}
				renderRequest.setAttribute(
						Constantes.NOME_PARAM_TITULO_PORTLET, portletTitulo);
				renderRequest.setAttribute(
						Constantes.NOME_PARAM_ARTICLE_ID, articleId);
				renderRequest.setAttribute("keywords", keywords);

				super.render(renderRequest, renderResponse);
			} else {
				SessionMessages.add(renderRequest,
						"mensagem.portletNaoConfigurado");
				include(naoConfiguradoJSP, renderRequest, renderResponse);

			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void pesquisar(ActionRequest request, ActionResponse response) throws Exception {
		String keywords = ParamUtil.getString(request,
				"keywords");
		
		response.setRenderParameter("keywords", keywords);
	}
 

}
