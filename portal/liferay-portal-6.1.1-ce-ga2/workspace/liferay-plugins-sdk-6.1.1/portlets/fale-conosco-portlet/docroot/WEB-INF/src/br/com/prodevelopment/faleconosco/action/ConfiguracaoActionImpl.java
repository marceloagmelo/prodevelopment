package br.com.prodevelopment.faleconosco.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.faleconosco.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String assuntos = ParamUtil.getString(actionRequest, Constantes.PREF_ASSUNTOS);
		String emails = ParamUtil.getString(actionRequest, Constantes.PREF_EMAILS);

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(
				themeDisplay.getPermissionChecker(), themeDisplay.getLayout(),
				portletResource, ActionKeys.CONFIGURATION);


		portletPreferences.setValue(Constantes.PREF_ASSUNTOS, assuntos);
		portletPreferences.setValue(Constantes.PREF_EMAILS, emails);
		portletPreferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);

		if (SessionErrors.isEmpty(actionRequest)) {
			portletPreferences.store();

			SessionMessages.add(
				actionRequest,
				portletConfig.getPortletName() +
					SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
				portletResource);

			SessionMessages.add(
				actionRequest,
				portletConfig.getPortletName() +
					SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(
				renderRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
					renderRequest, portletResource);


		String assuntos = preferences.getValue(Constantes.PREF_ASSUNTOS,Constantes.VAZIO);
		String emails = preferences.getValue(Constantes.PREF_EMAILS,Constantes.VAZIO);

		renderRequest.setAttribute(Constantes.PREF_ASSUNTOS, assuntos);
		renderRequest.setAttribute(Constantes.PREF_EMAILS, emails);

		return "/configuracao.jsp";
	}
}
