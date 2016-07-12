package br.com.prodevelopment.testeconhecimento.exibir.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.testeconhecimento.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String idTeste = ParamUtil.getString(actionRequest, Constantes.PREF_ID_TESTE);
		String prefEnviarEmail = ParamUtil.getString(actionRequest, Constantes.PREF_ENVIAR_EMAIL);
		String prefExibirAcerto = ParamUtil.getString(actionRequest, Constantes.PREF_EXIBIR_ACERTO);
		String prefExibirTitulo = ParamUtil.getString(actionRequest, Constantes.PREF_EXIBIR_TITULO);

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		preferences.setValue(Constantes.PREF_ID_TESTE, idTeste);
		preferences.setValue(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		preferences.setValue(Constantes.PREF_ENVIAR_EMAIL, prefEnviarEmail);
		preferences.setValue(Constantes.PREF_EXIBIR_ACERTO, prefExibirAcerto);
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

		String idTeste = preferences.getValue(Constantes.PREF_ID_TESTE, Constantes.VAZIO);
		String prefEnviarEmail = preferences.getValue(Constantes.PREF_ENVIAR_EMAIL, Constantes.S);
		String prefExibirAcerto = preferences.getValue(Constantes.PREF_EXIBIR_ACERTO, Constantes.S);
		String prefExibirTitulo = preferences.getValue(Constantes.PREF_EXIBIR_TITULO, Constantes.VAZIO);

		ExibirAction.buscarTeste(renderRequest, renderResponse);

		renderRequest.setAttribute(Constantes.PREF_ID_TESTE, idTeste);
		renderRequest.setAttribute(Constantes.PREF_ENVIAR_EMAIL, prefEnviarEmail);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_ACERTO, prefExibirAcerto);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);

		return "/html/exibirportlet/configuracao.jsp";
	}
}
