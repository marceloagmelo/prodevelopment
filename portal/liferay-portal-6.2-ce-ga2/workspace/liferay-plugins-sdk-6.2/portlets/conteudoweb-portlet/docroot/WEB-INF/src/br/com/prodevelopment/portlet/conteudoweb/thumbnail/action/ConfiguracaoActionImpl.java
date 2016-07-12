package br.com.prodevelopment.portlet.conteudoweb.thumbnail.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import br.com.prodevelopment.portlet.conteudoweb.thumbnail.Constantes;
import br.com.prodevelopment.portlet.conteudoweb.util.JournalUtil;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

    	PortletPreferences prefs = actionRequest.getPreferences();
		String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");
		
		String prefPaginacao = ParamUtil.getString(actionRequest,
				Constantes.PREF_PAGINACAO);
		String prefExibirTitulo = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_TITULO);
		String prefQtdeRegistros = ParamUtil.getString(actionRequest,
				Constantes.PREF_QTDE_REGISTROS);
		String prefQtdeRegistrosLinha = ParamUtil.getString(actionRequest,
				Constantes.PREF_QTDE_REGISTROS_LINHA);
		String prefCategoria = ParamUtil.getString(actionRequest,
				Constantes.CATEGORIAS_IDS);
		String prefTag = ParamUtil.getString(actionRequest,
				Constantes.TAG_NAMES);
		String prefEstrutura = ParamUtil.getString(actionRequest,
				Constantes.PREF_ESTRUTURA);
		String prefOrdenacao = ParamUtil.getString(actionRequest,
				Constantes.PREF_ORDENACAO);
		String prefExibirPesquisa = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_PESQUISA);
		String prefImprimir = ParamUtil.getString(actionRequest,
				Constantes.PREF_IMPRIMIR);
		String prefVoltar = ParamUtil.getString(actionRequest,
				Constantes.PREF_VOLTAR);
		
		prefs.setValue(Constantes.PREF_PAGINACAO, prefPaginacao);
		prefs.setValue(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		prefs.setValue(Constantes.PREF_QTDE_REGISTROS, prefQtdeRegistros);
		prefs.setValue(Constantes.PREF_QTDE_REGISTROS_LINHA, prefQtdeRegistrosLinha);
		prefs.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);
		prefs.setValue(Constantes.PREF_TAG, prefTag);
		prefs.setValue(Constantes.PREF_ESTRUTURA, prefEstrutura);
		prefs.setValue(Constantes.PREF_CATEGORIA, prefCategoria);
		prefs.setValue(Constantes.PREF_ORDENACAO, prefOrdenacao);
		prefs.setValue(Constantes.PREF_EXIBIR_PESQUISA, prefExibirPesquisa);
		prefs.setValue(Constantes.PREF_IMPRIMIR, prefImprimir);
		prefs.setValue(Constantes.PREF_VOLTAR, prefVoltar);

		if (SessionErrors.isEmpty(actionRequest)) {
			try {
				prefs.store();
		        SessionMessages.add(actionRequest, Constantes.PORTLET_CONFIGURADO_SUCESSO);
			}
			catch (ValidatorException ve) {
				SessionErrors.add(
					actionRequest, ValidatorException.class.getName(), ve);

				return;
			}

			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
				portletResource);

			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		PortletPreferences portletPreferences = renderRequest.getPreferences();
		
		String prefPaginacao = portletPreferences.getValue(Constantes.PREF_PAGINACAO,
				Constantes.N);
		String prefExibirTitulo = portletPreferences.getValue(
				Constantes.PREF_EXIBIR_TITULO, Constantes.N);
		String prefQtdeRegistros = portletPreferences.getValue(
				Constantes.PREF_QTDE_REGISTROS,
				Constantes.DEFAULT_QTDE_REGISTROS);
		String prefQtdeRegistrosLinha = portletPreferences.getValue(
				Constantes.PREF_QTDE_REGISTROS_LINHA,
				Constantes.DEFAULT_QTDE_REGISTROS);
		String prefTag = portletPreferences.getValue(Constantes.PREF_TAG,
				Constantes.VAZIO);
		String prefCategoria = portletPreferences.getValue(Constantes.PREF_CATEGORIA,
				Constantes.VAZIO);
		String prefEstrutura = portletPreferences.getValue(Constantes.PREF_ESTRUTURA,
				Constantes.VAZIO);
		String prefOrdenacao = portletPreferences.getValue(Constantes.PREF_ORDENACAO,
				Constantes.VAZIO);
		boolean prefExibirPesquisa = GetterUtil.getBoolean(portletPreferences.getValue(Constantes.PREF_EXIBIR_PESQUISA, null));
		boolean prefImprimir = GetterUtil.getBoolean(portletPreferences.getValue(
				Constantes.PREF_IMPRIMIR, null));
		boolean prefVoltar = GetterUtil.getBoolean(portletPreferences.getValue(
				Constantes.PREF_VOLTAR, null));

		renderRequest.setAttribute(Constantes.PREF_PAGINACAO, prefPaginacao);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO,
				prefExibirTitulo);
		renderRequest.setAttribute(Constantes.PREF_QTDE_REGISTROS,
				prefQtdeRegistros);
		renderRequest.setAttribute(Constantes.PREF_QTDE_REGISTROS_LINHA,
				prefQtdeRegistrosLinha);
		renderRequest.setAttribute(Constantes.PREF_TAG, prefTag);
		renderRequest.setAttribute(Constantes.PREF_ESTRUTURA, prefEstrutura);
		renderRequest.setAttribute(Constantes.PREF_CATEGORIA, prefCategoria);
		renderRequest.setAttribute(Constantes.PREF_ORDENACAO, prefOrdenacao);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_PESQUISA, prefExibirPesquisa);
		renderRequest.setAttribute(Constantes.PREF_IMPRIMIR, prefImprimir);
		renderRequest.setAttribute(Constantes.PREF_VOLTAR, prefVoltar);

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
