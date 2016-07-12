package br.com.prodevelopment.portlet.conteudoweb.ultimos.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.portlet.conteudoweb.ultimos.Constantes;
import br.com.prodevelopment.portlet.conteudoweb.util.JournalUtil;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String prefExibirTitulo = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_TITULO);
		String prefQtdeRegistros = ParamUtil.getString(actionRequest,
				Constantes.PREF_QTDE_REGISTROS);
		String prefCategoria = ParamUtil.getString(actionRequest,
				Constantes.CATEGORIAS_IDS);
		String prefTag = ParamUtil.getString(actionRequest,
				Constantes.TAG_NAMES);
		String prefEstrutura = ParamUtil.getString(actionRequest,
				Constantes.PREF_ESTRUTURA);
		String prefExibir = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR);
		String prefUrlVerTodos = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_VER_TODOS);
		String prefUrlDestino = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_DESTINO);
		
		
		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(
				themeDisplay.getPermissionChecker(), themeDisplay.getLayout(),
				portletResource, ActionKeys.CONFIGURATION);

		portletPreferences.setValue(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		portletPreferences.setValue(Constantes.PREF_QTDE_REGISTROS, prefQtdeRegistros);
		portletPreferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);
		portletPreferences.setValue(Constantes.PREF_TAG, prefTag);
		portletPreferences.setValue(Constantes.PREF_ESTRUTURA, prefEstrutura);
		portletPreferences.setValue(Constantes.PREF_CATEGORIA, prefCategoria);
		portletPreferences.setValue(Constantes.PREF_EXIBIR, prefExibir);
		portletPreferences.setValue(Constantes.PREF_URL_VER_TODOS, prefUrlVerTodos);
		portletPreferences.setValue(Constantes.PREF_URL_DESTINO, prefUrlDestino);

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

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletResource);

		String prefExibirTitulo = preferences.getValue(
				Constantes.PREF_EXIBIR_TITULO, Constantes.N);
		String prefQtdeRegistros = preferences.getValue(
				Constantes.PREF_QTDE_REGISTROS,
				Constantes.DEFAULT_QTDE_REGISTROS);
		String prefTag = preferences.getValue(Constantes.PREF_TAG,
				Constantes.VAZIO);
		String prefCategoria = preferences.getValue(Constantes.PREF_CATEGORIA,
				Constantes.VAZIO);
		String prefEstrutura = preferences.getValue(Constantes.PREF_ESTRUTURA,
				Constantes.VAZIO);
		String prefUrlVerTodos = preferences.getValue(Constantes.PREF_URL_VER_TODOS, Constantes.VAZIO);
		String prefUrlDestino = preferences.getValue(
				Constantes.PREF_URL_DESTINO, Constantes.TRALHA);

		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO,
				prefExibirTitulo);
		renderRequest.setAttribute(Constantes.PREF_QTDE_REGISTROS,
				prefQtdeRegistros);
		renderRequest.setAttribute(Constantes.PREF_TAG, prefTag);
		renderRequest.setAttribute(Constantes.PREF_ESTRUTURA, prefEstrutura);
		renderRequest.setAttribute(Constantes.PREF_CATEGORIA, prefCategoria);
		renderRequest.setAttribute(Constantes.PREF_URL_VER_TODOS, prefUrlVerTodos);
		renderRequest.setAttribute(Constantes.PREF_URL_DESTINO, prefUrlDestino);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		Map<Long, String> listaEstrutura = JournalUtil.getEstruturas(themeDisplay);
		if ( (Validator.isNotNull(listaEstrutura)) && (listaEstrutura.size() > 0) ) {
			renderRequest.setAttribute(Constantes.LISTA_ESTRUTURA,
					listaEstrutura);
		}
		
		return Constantes.JSP_CONFIG;
	}
}
