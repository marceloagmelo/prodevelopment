package br.com.elmaragon.busca.resultado.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.elmaragon.busca.resultado.Constantes;
import br.com.elmaragon.busca.util.BuscaUtil;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletResource);

		String prefCategoriaProduto = preferences.getValue(Constantes.PREF_CATEGORIA_PRODUTO, StringPool.SPACE);
		String prefCategoriaOutro = preferences.getValue(Constantes.PREF_CATEGORIA_OUTRO, StringPool.SPACE);
		String prefPaginaDestinoProduto = preferences.getValue(Constantes.PREF_PAGINA_DESTINO_PRODUTO, StringPool.SPACE);
		String prefPaginaDestinoOutro = preferences.getValue(Constantes.PREF_PAGINA_DESTINO_OUTRO, StringPool.SPACE);

		String[] palavrasUser = preferences.getValues(
				Constantes.APPEND_STOP_WORDS, null);

		StringBuilder sb = new StringBuilder();

		if (palavrasUser != null) {
			for (String palavra : palavrasUser) {
				sb.append(palavra);
				sb.append("\n");
			}
		}

		renderRequest.setAttribute("listaUsuario", sb.toString());
		renderRequest.setAttribute("listaStopWords", BuscaUtil.proibidas);
		renderRequest.setAttribute("prefCategoriaProduto", prefCategoriaProduto);
		renderRequest.setAttribute("prefCategoriaOutro", prefCategoriaOutro);
		renderRequest.setAttribute("prefPaginaDestinoProduto", prefPaginaDestinoProduto);
		renderRequest.setAttribute("prefPaginaDestinoOutro", prefPaginaDestinoOutro);

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

		String prefCategoriaProduto = actionRequest.getParameter("prefCategoriaProduto");
		String prefCategoriaOutro = actionRequest.getParameter("prefCategoriaOutro");
		String prefPaginaDestinoProduto = actionRequest.getParameter("prefPaginaDestinoProduto");
		String prefPaginaDestinoOutro = actionRequest.getParameter("prefPaginaDestinoOutro");
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
		portletPreferences.setValue(Constantes.PREF_CATEGORIA_PRODUTO, prefCategoriaProduto);
		portletPreferences.setValue(Constantes.PREF_CATEGORIA_OUTRO, prefCategoriaOutro);
		portletPreferences.setValue(Constantes.PREF_PAGINA_DESTINO_PRODUTO, prefPaginaDestinoProduto);
		portletPreferences.setValue(Constantes.PREF_PAGINA_DESTINO_OUTRO, prefPaginaDestinoOutro);
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
