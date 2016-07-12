package br.com.rasecmadeiras.busca.resultado.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.rasecmadeiras.busca.resultado.Constantes;
import br.com.rasecmadeiras.busca.util.BuscaUtil;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletResource);

		String prefProdutoEstrutura = preferences.getValue(Constantes.PREF_PRODUTO_ESTRUTURA, "");
		String prefFornecedorEstrutura = preferences.getValue(Constantes.PREF_FORNECEDOR_ESTRUTURA, "");
		String prefVideoEstrutura = preferences.getValue(Constantes.PREF_VIDEO_ESTRUTURA, "");
		String prefProdutoPaginaDestino = preferences.getValue(Constantes.PREF_PRODUTO_PAGINA_DESTINO, "");
		String prefFornecedorPaginaDestino = preferences.getValue(Constantes.PREF_FORNECEDOR_PAGINA_DESTINO, "");

		String[] palavrasUser = preferences.getValues(
				Constantes.APPEND_STOP_WORDS, null);

		StringBuilder sb = new StringBuilder();

		if (palavrasUser != null) {
			for (String palavra : palavrasUser) {
				sb.append(palavra);
				sb.append("\n");
			}
		}


		List<JournalStructure> listaEstrutura = JournalStructureLocalServiceUtil.getStructures(PortalUtil.getScopeGroupId(renderRequest));

		if (listaEstrutura.size() > 0) {
			renderRequest.setAttribute(Constantes.LISTA_ESTRUTURA,
					listaEstrutura);
		}

		renderRequest.setAttribute("listaUsuario", sb.toString());
		renderRequest.setAttribute("listaStopWords", BuscaUtil.proibidas);
		renderRequest.setAttribute("prefProdutoEstrutura", prefProdutoEstrutura);
		renderRequest.setAttribute("prefFornecedorEstrutura", prefFornecedorEstrutura);
		renderRequest.setAttribute("prefVideoEstrutura", prefVideoEstrutura);
		renderRequest.setAttribute("prefProdutoPaginaDestino", prefProdutoPaginaDestino);
		renderRequest.setAttribute("prefFornecedorPaginaDestino", prefFornecedorPaginaDestino);

		return "/html/busca/resultado/config.jsp";
	}

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(themeDisplay.getPermissionChecker(),
				themeDisplay.getLayout(), portletResource,
				ActionKeys.CONFIGURATION);

		String prefProdutoEstrutura = actionRequest.getParameter("prefProdutoEstrutura");
		String prefFornecedorEstrutura = actionRequest.getParameter("prefFornecedorEstrutura");
		String prefVideoEstrutura = actionRequest.getParameter("prefVideoEstrutura");
		String prefProdutoPaginaDestino = actionRequest.getParameter("prefProdutoPaginaDestino");
		String prefFornecedorPaginaDestino = actionRequest.getParameter("prefFornecedorPaginaDestino");
		String listaUsuario = actionRequest.getParameter("listaUsuario");

		// retirando palavras repetidas
		String[] newPalavras = StringUtil.split(listaUsuario, "\n");
		List<String> aux = new ArrayList<String>();

		for (String palavra : newPalavras) {
			if (!BuscaUtil.proibidas.contains(palavra)) {
				aux.add(palavra.trim());
			}
		}

		BuscaUtil.adicionarNaLista(aux);

		newPalavras = aux.toArray(newPalavras);

		portletPreferences.setValues(Constantes.APPEND_STOP_WORDS, newPalavras);
		portletPreferences.setValue(Constantes.PREF_PRODUTO_ESTRUTURA, prefProdutoEstrutura);
		portletPreferences.setValue(Constantes.PREF_FORNECEDOR_ESTRUTURA, prefFornecedorEstrutura);
		portletPreferences.setValue(Constantes.PREF_VIDEO_ESTRUTURA, prefVideoEstrutura);
		portletPreferences.setValue(Constantes.PREF_PRODUTO_PAGINA_DESTINO, prefProdutoPaginaDestino);
		portletPreferences.setValue(Constantes.PREF_FORNECEDOR_PAGINA_DESTINO, prefFornecedorPaginaDestino);
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
}
