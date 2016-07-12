package br.com.prodevelopment.pesquisaopiniao.consulta.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.pesquisaopiniao.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String prefExibirTitulo = ParamUtil.getString(actionRequest, Constantes.PREF_EXIBIR_TITULO);
		String somenteUsuarioLogado = ParamUtil.getString(actionRequest, Constantes.SOMENTE_USUARIO_LOGADO);

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		preferences.setValue(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		preferences.setValue(Constantes.SOMENTE_USUARIO_LOGADO, somenteUsuarioLogado);
		preferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);

		preferences.store();

		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);

		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
	}

	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(
				renderRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
					renderRequest, portletResource);

		String prefExibirTitulo = preferences.getValue(Constantes.PREF_EXIBIR_TITULO, Constantes.VAZIO);
		String somenteUsuarioLogado = preferences.getValue(Constantes.SOMENTE_USUARIO_LOGADO, Constantes.S);

		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		renderRequest.setAttribute(Constantes.SOMENTE_USUARIO_LOGADO, somenteUsuarioLogado);
		
		return Constantes.JSP_CONSULTA_CONFIG;
	}
}
