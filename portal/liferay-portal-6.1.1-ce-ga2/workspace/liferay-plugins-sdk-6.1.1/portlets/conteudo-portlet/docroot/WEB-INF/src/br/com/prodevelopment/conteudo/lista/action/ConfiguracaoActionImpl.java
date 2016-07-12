package br.com.prodevelopment.conteudo.lista.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.conteudo.lista.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String prefPaginacao = ParamUtil.getString(actionRequest,
				Constantes.PREF_PAGINACAO);
		String prefExibirTitulo = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_TITULO);
		String prefQtdeRegistros = ParamUtil.getString(actionRequest,
				Constantes.PREF_QTDE_REGISTROS);
		String prefUrlDestino = ParamUtil.getString(actionRequest,
				Constantes.PREF_URL_DESTINO);
		String prefCategoria = ParamUtil.getString(actionRequest,
				Constantes.CATEGORIAS_IDS);
		String prefTag = ParamUtil.getString(actionRequest,
				Constantes.TAG_NAMES);
		String prefEstrutura = ParamUtil.getString(actionRequest,
				Constantes.PREF_ESTRUTURA);
		String prefTamanhoCaracteres = ParamUtil.getString(actionRequest,
				Constantes.PREF_TAMANHO_CARACTERES);
		String prefOrdenacao = ParamUtil.getString(actionRequest,
				Constantes.PREF_ORDENACAO);
		String prefExibirDataAlteracao = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_DATA_ALTERACAO);
		String prefExibirLeiaMais = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_LEIA_MAIS);
		String prefExibir = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR);

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(
				themeDisplay.getPermissionChecker(), themeDisplay.getLayout(),
				portletResource, ActionKeys.CONFIGURATION);

		portletPreferences.setValue(Constantes.PREF_PAGINACAO, prefPaginacao);
		portletPreferences.setValue(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		portletPreferences.setValue(Constantes.PREF_QTDE_REGISTROS, prefQtdeRegistros);
		portletPreferences.setValue(Constantes.PREF_URL_DESTINO, prefUrlDestino);
		portletPreferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);
		portletPreferences.setValue(Constantes.PREF_TAMANHO_CARACTERES,
				prefTamanhoCaracteres);
		portletPreferences.setValue(Constantes.PREF_TAG, prefTag);
		portletPreferences.setValue(Constantes.PREF_ESTRUTURA, prefEstrutura);
		portletPreferences.setValue(Constantes.PREF_CATEGORIA, prefCategoria);
		portletPreferences.setValue(Constantes.PREF_ORDENACAO, prefOrdenacao);
		portletPreferences.setValue(Constantes.PREF_EXIBIR_DATA_ALTERACAO, prefExibirDataAlteracao);
		portletPreferences.setValue(Constantes.PREF_EXIBIR_LEIA_MAIS, prefExibirLeiaMais);
		portletPreferences.setValue(Constantes.PREF_EXIBIR, prefExibir);

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

		String prefPaginacao = preferences.getValue(Constantes.PREF_PAGINACAO,
				Constantes.N);
		String prefExibirTitulo = preferences.getValue(
				Constantes.PREF_EXIBIR_TITULO, Constantes.N);
		String prefQtdeRegistros = preferences.getValue(
				Constantes.PREF_QTDE_REGISTROS,
				Constantes.DEFAULT_QTDE_REGISTROS);
		String prefUrlDestino = preferences.getValue(
				Constantes.PREF_URL_DESTINO, Constantes.TRALHA);
		String prefTamanhoCaracteres = preferences.getValue(
				Constantes.PREF_TAMANHO_CARACTERES,
				Constantes.DEFAULT_TAMAMHO_CARACTERES);
		String prefTag = preferences.getValue(Constantes.PREF_TAG,
				Constantes.VAZIO);
		String prefCategoria = preferences.getValue(Constantes.PREF_CATEGORIA,
				Constantes.VAZIO);
		String prefEstrutura = preferences.getValue(Constantes.PREF_ESTRUTURA,
				Constantes.VAZIO);
		String prefOrdenacao = preferences.getValue(Constantes.PREF_ORDENACAO,
				Constantes.VAZIO);
		boolean prefExibirDataAlteracao = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_EXIBIR_DATA_ALTERACAO, null));
		boolean prefExibirLeiaMais = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_EXIBIR_LEIA_MAIS, null));	
		String prefExibir = preferences.getValue(Constantes.PREF_EXIBIR, Constantes.VAZIO);

		renderRequest.setAttribute(Constantes.PREF_PAGINACAO, prefPaginacao);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO,
				prefExibirTitulo);
		renderRequest.setAttribute(Constantes.PREF_QTDE_REGISTROS,
				prefQtdeRegistros);
		renderRequest.setAttribute(Constantes.PREF_URL_DESTINO, prefUrlDestino);
		renderRequest.setAttribute(Constantes.PREF_TAMANHO_CARACTERES,
				prefTamanhoCaracteres);
		renderRequest.setAttribute(Constantes.PREF_TAG, prefTag);
		renderRequest.setAttribute(Constantes.PREF_ESTRUTURA, prefEstrutura);
		renderRequest.setAttribute(Constantes.PREF_CATEGORIA, prefCategoria);
		renderRequest.setAttribute(Constantes.PREF_ORDENACAO, prefOrdenacao);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_DATA_ALTERACAO, prefExibirDataAlteracao);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_LEIA_MAIS, prefExibirLeiaMais);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR, prefExibir);

		List<JournalStructure> listaEstrutura = JournalStructureLocalServiceUtil.getStructures(PortalUtil.getScopeGroupId(renderRequest));

		if (listaEstrutura.size() > 0) {
			renderRequest.setAttribute(Constantes.LISTA_ESTRUTURA,
					listaEstrutura);
		}

		return "/html/listaconteudo/config.jsp";
	}
}
