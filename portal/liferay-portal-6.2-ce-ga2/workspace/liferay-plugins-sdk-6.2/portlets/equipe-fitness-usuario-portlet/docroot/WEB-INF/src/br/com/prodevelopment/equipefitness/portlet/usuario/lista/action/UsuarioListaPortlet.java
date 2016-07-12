package br.com.prodevelopment.equipefitness.portlet.usuario.lista.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.equipefitness.portlet.usuario.lista.Constantes;
import br.com.prodevelopment.equipefitness.portlet.usuario.util.Helper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UsuarioListaPortlet
 */
public class UsuarioListaPortlet extends MVCPortlet {
 
	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);

		addProcessActionSuccessMessage = GetterUtil.getBoolean(
				getInitParameter("add-process-action-success-action"), false);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			// Recuperar preferencias
			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);

			if (Constantes.S.equals(prefConfigurado)) {
				String portletTitulo = Helper.getTituloPortlet(renderRequest,
						renderResponse, themeDisplay);

				renderRequest
						.setAttribute(Constantes.PORTLET_TITULO, portletTitulo);

				super.render(renderRequest, renderResponse);
			} else {
				include(naoConfiguradoJSP, renderRequest, renderResponse);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
