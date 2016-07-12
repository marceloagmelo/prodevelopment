package br.com.studiniz.busca.resultado.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.studiniz.busca.resultado.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletResource);

		String prefPaginaDestinoConteudo = preferences.getValue(Constantes.PREF_PAGINA_DESTINO_CONTEUDO, StringPool.BLANK);
		String prefQuatidadeResultado = preferences.getValue(Constantes.PREF_QUANTIDADE_RESULTADO, Constantes.QUANTIDADE_RESULTADO_DEFAULT);

		renderRequest.setAttribute("prefPaginaDestinoConteudo", prefPaginaDestinoConteudo);
		renderRequest.setAttribute("prefQuatidadeResultado", prefQuatidadeResultado);

		return Constantes.JSP_CONFIG;
	}

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(themeDisplay.getPermissionChecker(),
				themeDisplay.getLayout(), portletResource,
				ActionKeys.CONFIGURATION);

		String prefPaginaDestinoConteudo = actionRequest.getParameter("prefPaginaDestinoConteudo");
		String prefQuatidadeResultado = actionRequest.getParameter("prefQuatidadeResultado");

		portletPreferences.setValue(Constantes.PREF_PAGINA_DESTINO_CONTEUDO, prefPaginaDestinoConteudo);
		portletPreferences.setValue(Constantes.PREF_QUANTIDADE_RESULTADO, prefQuatidadeResultado);
		portletPreferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);

		if (SessionErrors.isEmpty(actionRequest)) {
			portletPreferences.store();

			SessionMessages.add(actionRequest, portletConfig.getPortletName()
					+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
					portletResource);

			SessionMessages.add(actionRequest, portletConfig.getPortletName()
					+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

}
