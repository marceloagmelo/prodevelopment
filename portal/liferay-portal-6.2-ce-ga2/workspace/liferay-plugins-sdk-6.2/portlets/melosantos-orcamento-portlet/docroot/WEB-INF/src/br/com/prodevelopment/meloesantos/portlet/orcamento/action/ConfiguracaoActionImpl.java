package br.com.prodevelopment.meloesantos.portlet.orcamento.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import br.com.prodevelopment.meloesantos.portlet.orcamento.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String emails = ParamUtil.getString(actionRequest,
				Constantes.PREF_EMAILS);
		String remetente = ParamUtil.getString(actionRequest,
				Constantes.PREF_REMETENTE);

		PortletPermissionUtil.check(themeDisplay.getPermissionChecker(),
				themeDisplay.getLayout(), portletResource,
				ActionKeys.CONFIGURATION);

		portletPreferences.setValue(Constantes.PREF_EMAILS, emails);
		portletPreferences.setValue(Constantes.PREF_REMETENTE, remetente);
		portletPreferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);

		if (SessionErrors.isEmpty(actionRequest)) {
			try {
				portletPreferences.store();
				SessionMessages.add(actionRequest,
						Constantes.PORTLET_CONFIGURADO_SUCESSO);
			} catch (ValidatorException ve) {
				SessionErrors.add(actionRequest,
						ValidatorException.class.getName(), ve);

				return;
			}

			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
					portletResource);

			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletResource);

		String emails = preferences.getValue(Constantes.PREF_EMAILS,
				Constantes.VAZIO);
		String remetente = preferences.getValue(Constantes.PREF_REMETENTE,
				Constantes.VAZIO);

		renderRequest.setAttribute(Constantes.PREF_EMAILS, emails);
		renderRequest.setAttribute(Constantes.PREF_REMETENTE, remetente);

		return "/html/orcamento/configuracao.jsp";
	}
}
