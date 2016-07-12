package br.com.prodevelopment.equipefitness.portlet.atividade.horario.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.equipefitness.portlet.atividade.Constantes;
import br.com.prodevelopment.equipefitness.portlet.atividade.util.Helper;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class HorarioPortlet
 */
public class HorarioPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String portletTitulo = Helper.getTituloPortlet(renderRequest,
					renderResponse, themeDisplay);

			renderRequest
					.setAttribute(Constantes.PORTLET_TITULO, portletTitulo);

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
