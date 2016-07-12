package br.com.prodevelopment.pesquisaopiniao.exibir.action;

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

		String idPesquisa = ParamUtil.getString(actionRequest, Constantes.PREF_ID_PESQUISA);
		String prefAnonima = ParamUtil.getString(actionRequest, Constantes.PREF_ANONIMA);
		String prefEnviarEmail = ParamUtil.getString(actionRequest, Constantes.PREF_ENVIAR_EMAIL);
		String prefExibirTitulo = ParamUtil.getString(actionRequest, Constantes.PREF_EXIBIR_TITULO);

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		preferences.setValue(Constantes.PREF_ID_PESQUISA, idPesquisa);
		preferences.setValue(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		preferences.setValue(Constantes.PREF_ANONIMA, prefAnonima);
		preferences.setValue(Constantes.PREF_ENVIAR_EMAIL, prefEnviarEmail);
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

		String idPesquisa = preferences.getValue(Constantes.PREF_ID_PESQUISA, Constantes.VAZIO);
		String prefAnonima = preferences.getValue(Constantes.PREF_ANONIMA, Constantes.VAZIO);
		String prefEnviarEmail = preferences.getValue(Constantes.PREF_ENVIAR_EMAIL, Constantes.S);
		String prefExibirTitulo = preferences.getValue(Constantes.PREF_EXIBIR_TITULO, Constantes.VAZIO);

		ExibirAction.buscarPesquisa(renderRequest, renderResponse);

		renderRequest.setAttribute(Constantes.PREF_ID_PESQUISA, idPesquisa);
		renderRequest.setAttribute(Constantes.PREF_ANONIMA, prefAnonima);
		renderRequest.setAttribute(Constantes.PREF_ENVIAR_EMAIL, prefEnviarEmail);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);

		return Constantes.JSP_EXIBIR_CONFIG;
	}
}
