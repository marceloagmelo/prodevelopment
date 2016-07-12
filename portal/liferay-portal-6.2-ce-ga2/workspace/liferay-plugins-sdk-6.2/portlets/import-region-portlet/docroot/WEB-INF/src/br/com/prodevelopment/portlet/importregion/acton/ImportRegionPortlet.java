package br.com.prodevelopment.portlet.importregion.acton;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.portlet.importregion.Constantes;
import br.com.prodevelopment.portlet.importregion.util.Helper;
import br.com.prodevelopment.portlet.importregion.util.ImportRegionUtil;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ImportRegionPortlet
 */
public class ImportRegionPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
						.getAttribute(WebKeys.THEME_DISPLAY);

				String portletTitulo = Helper.getTituloPortlet(renderRequest,
						renderResponse, themeDisplay);

				renderRequest.setAttribute(Constantes.PORTLET_TITULO,
						portletTitulo);
				
				super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}
	}


	public void confirmar(ActionRequest request,
			ActionResponse response) throws Exception {
		ImportRegionUtil.importar(request, response);
	}

}
