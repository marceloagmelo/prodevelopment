package br.com.prodevelopment.ultimasnoticiasrss.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.ultimasnoticiasrss.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		// Google
		String prefUrlGoogleUltimasNoticias = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GOOGLE_ULTIMAS_NOTICIAS);
		String prefUrlGoogleInternacional = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GOOGLE_INTERNACIONAL);
		String prefUrlGoogleNegocio = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GOOGLE_NEGOCIO);
		String prefUrlGoogleSaude = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GOOGLE_SAUDE);
		String prefUrlGoogleEsporte = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GOOGLE_ESPORTE);
		// Globo
		String prefUrlGloboUltimasNoticias = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GLOBO_ULTIMAS_NOTICIAS);
		String prefUrlGloboInternacional = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GLOBO_INTERNACIONAL);
		String prefUrlGloboNegocio = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GLOBO_NEGOCIO);
		String prefUrlGloboSaude = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GLOBO_SAUDE);
		String prefUrlGloboEsporte = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_GLOBO_ESPORTE);

		// Uol
		String prefUrlUolUltimasNoticias = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_UOL_ULTIMAS_NOTICIAS);
		String prefUrlUolInternacional = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_UOL_INTERNACIONAL);
		String prefUrlUolNegocio = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_UOL_NEGOCIO);
		String prefUrlUolSaude = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_UOL_SAUDE);
		String prefUrlUolEsporte = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_UOL_ESPORTE);

		// Terra
		String prefUrlTerraUltimasNoticias = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_TERRA_ULTIMAS_NOTICIAS);
		String prefUrlTerraInternacional = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_TERRA_INTERNACIONAL);
		String prefUrlTerraNegocio = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_TERRA_NEGOCIO);
		String prefUrlTerraSaude = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_TERRA_SAUDE);
		String prefUrlTerraEsporte = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_TERRA_ESPORTE);

		String prefServico = ParamUtil.getString(actionRequest,
				Constantes.PREF_SERVICO);

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(themeDisplay.getPermissionChecker(),
				themeDisplay.getLayout(), portletResource,
				ActionKeys.CONFIGURATION);

		// Google
		portletPreferences.setValue(Constantes.PREF_URL_GOOGLE_ULTIMAS_NOTICIAS, prefUrlGoogleUltimasNoticias);
		portletPreferences.setValue(Constantes.PREF_URL_GOOGLE_INTERNACIONAL, prefUrlGoogleInternacional);
		portletPreferences.setValue(Constantes.PREF_URL_GOOGLE_NEGOCIO, prefUrlGoogleNegocio);
		portletPreferences.setValue(Constantes.PREF_URL_GOOGLE_SAUDE, prefUrlGoogleSaude);
		portletPreferences.setValue(Constantes.PREF_URL_GOOGLE_ESPORTE, prefUrlGoogleEsporte);
		portletPreferences.setValue(Constantes.PREF_SERVICO, prefServico);
		portletPreferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);

		// Globo
		portletPreferences.setValue(Constantes.PREF_URL_GLOBO_ULTIMAS_NOTICIAS, prefUrlGloboUltimasNoticias);
		portletPreferences.setValue(Constantes.PREF_URL_GLOBO_INTERNACIONAL, prefUrlGloboInternacional);
		portletPreferences.setValue(Constantes.PREF_URL_GLOBO_NEGOCIO, prefUrlGloboNegocio);
		portletPreferences.setValue(Constantes.PREF_URL_GLOBO_SAUDE, prefUrlGloboSaude);
		portletPreferences.setValue(Constantes.PREF_URL_GLOBO_ESPORTE, prefUrlGloboEsporte);

		// Uol
		portletPreferences.setValue(Constantes.PREF_URL_UOL_ULTIMAS_NOTICIAS, prefUrlUolUltimasNoticias);
		portletPreferences.setValue(Constantes.PREF_URL_UOL_INTERNACIONAL, prefUrlUolInternacional);
		portletPreferences.setValue(Constantes.PREF_URL_UOL_NEGOCIO, prefUrlUolNegocio);
		portletPreferences.setValue(Constantes.PREF_URL_UOL_SAUDE, prefUrlUolSaude);
		portletPreferences.setValue(Constantes.PREF_URL_UOL_ESPORTE, prefUrlUolEsporte);

		// Terra
		portletPreferences.setValue(Constantes.PREF_URL_TERRA_ULTIMAS_NOTICIAS, prefUrlTerraUltimasNoticias);
		portletPreferences.setValue(Constantes.PREF_URL_TERRA_INTERNACIONAL, prefUrlTerraInternacional);
		portletPreferences.setValue(Constantes.PREF_URL_TERRA_NEGOCIO, prefUrlTerraNegocio);
		portletPreferences.setValue(Constantes.PREF_URL_TERRA_SAUDE, prefUrlTerraSaude);
		portletPreferences.setValue(Constantes.PREF_URL_TERRA_ESPORTE, prefUrlTerraEsporte);

		portletPreferences.setValue(Constantes.PREF_SERVICO, prefServico);
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

	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletResource);

		// Google
		String prefUrlGoogleUltimasNoticias = preferences.getValue(Constantes.PREF_URL_GOOGLE_ULTIMAS_NOTICIAS,
				Constantes.VAZIO);
		String prefUrlGoogleInternacional = preferences.getValue(Constantes.PREF_URL_GOOGLE_INTERNACIONAL,
				Constantes.VAZIO);
		String prefUrlGoogleNegocio = preferences.getValue(Constantes.PREF_URL_GOOGLE_NEGOCIO,
				Constantes.VAZIO);
		String prefUrlGoogleSaude = preferences.getValue(Constantes.PREF_URL_GOOGLE_SAUDE,
				Constantes.VAZIO);
		String prefUrlGoogleEsporte = preferences.getValue(Constantes.PREF_URL_GOOGLE_ESPORTE,
				Constantes.VAZIO);
		// Globo
		String prefUrlGloboUltimasNoticias = preferences.getValue(Constantes.PREF_URL_GLOBO_ULTIMAS_NOTICIAS,
				Constantes.VAZIO);
		String prefUrlGloboInternacional = preferences.getValue(Constantes.PREF_URL_GLOBO_INTERNACIONAL,
				Constantes.VAZIO);
		String prefUrlGloboNegocio = preferences.getValue(Constantes.PREF_URL_GLOBO_NEGOCIO,
				Constantes.VAZIO);
		String prefUrlGloboSaude = preferences.getValue(Constantes.PREF_URL_GLOBO_SAUDE,
				Constantes.VAZIO);
		String prefUrlGloboEsporte = preferences.getValue(Constantes.PREF_URL_GLOBO_ESPORTE,
				Constantes.VAZIO);

		// Uol
		String prefUrlUolUltimasNoticias = preferences.getValue(Constantes.PREF_URL_UOL_ULTIMAS_NOTICIAS,
				Constantes.VAZIO);
		String prefUrlUolInternacional = preferences.getValue(Constantes.PREF_URL_UOL_INTERNACIONAL,
				Constantes.VAZIO);
		String prefUrlUolNegocio = preferences.getValue(Constantes.PREF_URL_UOL_NEGOCIO,
				Constantes.VAZIO);
		String prefUrlUolSaude = preferences.getValue(Constantes.PREF_URL_UOL_SAUDE,
				Constantes.VAZIO);
		String prefUrlUolEsporte = preferences.getValue(Constantes.PREF_URL_UOL_ESPORTE,
				Constantes.VAZIO);

		// Terra
		String prefUrlTerraUltimasNoticias = preferences.getValue(Constantes.PREF_URL_TERRA_ULTIMAS_NOTICIAS,
				Constantes.VAZIO);
		String prefUrlTerraInternacional = preferences.getValue(Constantes.PREF_URL_TERRA_INTERNACIONAL,
				Constantes.VAZIO);
		String prefUrlTerraNegocio = preferences.getValue(Constantes.PREF_URL_TERRA_NEGOCIO,
				Constantes.VAZIO);
		String prefUrlTerraSaude = preferences.getValue(Constantes.PREF_URL_TERRA_SAUDE,
				Constantes.VAZIO);
		String prefUrlTerraEsporte = preferences.getValue(Constantes.PREF_URL_TERRA_ESPORTE,
				Constantes.VAZIO);

		String prefServico = preferences.getValue(Constantes.PREF_SERVICO,
				Constantes.VAZIO);

		// Google
		renderRequest.setAttribute(Constantes.PREF_URL_GOOGLE_ULTIMAS_NOTICIAS, prefUrlGoogleUltimasNoticias);
		renderRequest.setAttribute(Constantes.PREF_URL_GOOGLE_INTERNACIONAL, prefUrlGoogleInternacional);
		renderRequest.setAttribute(Constantes.PREF_URL_GOOGLE_NEGOCIO, prefUrlGoogleNegocio);
		renderRequest.setAttribute(Constantes.PREF_URL_GOOGLE_SAUDE, prefUrlGoogleSaude);
		renderRequest.setAttribute(Constantes.PREF_URL_GOOGLE_ESPORTE, prefUrlGoogleEsporte);

		// Globo
		renderRequest.setAttribute(Constantes.PREF_URL_GLOBO_ULTIMAS_NOTICIAS, prefUrlGloboUltimasNoticias);
		renderRequest.setAttribute(Constantes.PREF_URL_GLOBO_INTERNACIONAL, prefUrlGloboInternacional);
		renderRequest.setAttribute(Constantes.PREF_URL_GLOBO_NEGOCIO, prefUrlGloboNegocio);
		renderRequest.setAttribute(Constantes.PREF_URL_GLOBO_SAUDE, prefUrlGloboSaude);
		renderRequest.setAttribute(Constantes.PREF_URL_GLOBO_ESPORTE, prefUrlGloboEsporte);

		// Uol
		renderRequest.setAttribute(Constantes.PREF_URL_UOL_ULTIMAS_NOTICIAS, prefUrlUolUltimasNoticias);
		renderRequest.setAttribute(Constantes.PREF_URL_UOL_INTERNACIONAL, prefUrlUolInternacional);
		renderRequest.setAttribute(Constantes.PREF_URL_UOL_NEGOCIO, prefUrlUolNegocio);
		renderRequest.setAttribute(Constantes.PREF_URL_UOL_SAUDE, prefUrlUolSaude);
		renderRequest.setAttribute(Constantes.PREF_URL_UOL_ESPORTE, prefUrlUolEsporte);

		// Terra
		renderRequest.setAttribute(Constantes.PREF_URL_TERRA_ULTIMAS_NOTICIAS, prefUrlTerraUltimasNoticias);
		renderRequest.setAttribute(Constantes.PREF_URL_TERRA_INTERNACIONAL, prefUrlTerraInternacional);
		renderRequest.setAttribute(Constantes.PREF_URL_TERRA_NEGOCIO, prefUrlTerraNegocio);
		renderRequest.setAttribute(Constantes.PREF_URL_TERRA_SAUDE, prefUrlTerraSaude);
		renderRequest.setAttribute(Constantes.PREF_URL_TERRA_ESPORTE, prefUrlTerraEsporte);

		renderRequest.setAttribute(Constantes.PREF_SERVICO, prefServico);

		return "/html/config.jsp";
	}
}
