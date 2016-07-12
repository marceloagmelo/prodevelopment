package br.com.prodevelopment.portlet.conteudoweb.lista.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import br.com.prodevelopment.portlet.conteudoweb.lista.Constantes;
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
		String prefImprimir = ParamUtil.getString(actionRequest,
				Constantes.PREF_IMPRIMIR);
		String prefEmail = ParamUtil.getString(actionRequest,
				Constantes.PREF_EMAIL);
		String prefVoltar = ParamUtil.getString(actionRequest,
				Constantes.PREF_VOLTAR);
		
		prefs.setValue(Constantes.PREF_PAGINACAO, prefPaginacao);
		prefs.setValue(Constantes.PREF_EXIBIR_TITULO, prefExibirTitulo);
		prefs.setValue(Constantes.PREF_QTDE_REGISTROS, prefQtdeRegistros);
		prefs.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);
		prefs.setValue(Constantes.PREF_TAMANHO_CARACTERES,
				prefTamanhoCaracteres);
		prefs.setValue(Constantes.PREF_TAG, prefTag);
		prefs.setValue(Constantes.PREF_ESTRUTURA, prefEstrutura);
		prefs.setValue(Constantes.PREF_CATEGORIA, prefCategoria);
		prefs.setValue(Constantes.PREF_ORDENACAO, prefOrdenacao);
		prefs.setValue(Constantes.PREF_EXIBIR_DATA_ALTERACAO, prefExibirDataAlteracao);
		prefs.setValue(Constantes.PREF_EXIBIR_LEIA_MAIS, prefExibirLeiaMais);
		prefs.setValue(Constantes.PREF_EXIBIR, prefExibir);
		prefs.setValue(Constantes.PREF_IMPRIMIR, prefImprimir);
		prefs.setValue(Constantes.PREF_EMAIL, prefEmail);
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
		String prefTamanhoCaracteres = portletPreferences.getValue(
				Constantes.PREF_TAMANHO_CARACTERES,
				Constantes.DEFAULT_TAMAMHO_CARACTERES);
		String prefTag = portletPreferences.getValue(Constantes.PREF_TAG,
				Constantes.VAZIO);
		String prefCategoria = portletPreferences.getValue(Constantes.PREF_CATEGORIA,
				Constantes.VAZIO);
		String prefEstrutura = portletPreferences.getValue(Constantes.PREF_ESTRUTURA,
				Constantes.VAZIO);
		String prefOrdenacao = portletPreferences.getValue(Constantes.PREF_ORDENACAO,
				Constantes.VAZIO);
		boolean prefExibirDataAlteracao = GetterUtil.getBoolean(portletPreferences.getValue(Constantes.PREF_EXIBIR_DATA_ALTERACAO, null));
		boolean prefExibirLeiaMais = GetterUtil.getBoolean(portletPreferences.getValue(Constantes.PREF_EXIBIR_LEIA_MAIS, null));	
		String prefExibir = portletPreferences.getValue(Constantes.PREF_EXIBIR, Constantes.VAZIO);
		boolean prefImprimir = GetterUtil.getBoolean(portletPreferences.getValue(
				Constantes.PREF_IMPRIMIR, null));
		boolean prefEmail = GetterUtil.getBoolean(portletPreferences.getValue(
				Constantes.PREF_EMAIL, null));
		boolean prefVoltar = GetterUtil.getBoolean(portletPreferences.getValue(
				Constantes.PREF_VOLTAR, null));

		renderRequest.setAttribute(Constantes.PREF_PAGINACAO, prefPaginacao);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO,
				prefExibirTitulo);
		renderRequest.setAttribute(Constantes.PREF_QTDE_REGISTROS,
				prefQtdeRegistros);
		renderRequest.setAttribute(Constantes.PREF_TAMANHO_CARACTERES,
				prefTamanhoCaracteres);
		renderRequest.setAttribute(Constantes.PREF_TAG, prefTag);
		renderRequest.setAttribute(Constantes.PREF_ESTRUTURA, prefEstrutura);
		renderRequest.setAttribute(Constantes.PREF_CATEGORIA, prefCategoria);
		renderRequest.setAttribute(Constantes.PREF_ORDENACAO, prefOrdenacao);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_DATA_ALTERACAO, prefExibirDataAlteracao);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_LEIA_MAIS, prefExibirLeiaMais);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR, prefExibir);
		renderRequest.setAttribute(Constantes.PREF_IMPRIMIR, prefImprimir);
		renderRequest.setAttribute(Constantes.PREF_EMAIL, prefEmail);
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
