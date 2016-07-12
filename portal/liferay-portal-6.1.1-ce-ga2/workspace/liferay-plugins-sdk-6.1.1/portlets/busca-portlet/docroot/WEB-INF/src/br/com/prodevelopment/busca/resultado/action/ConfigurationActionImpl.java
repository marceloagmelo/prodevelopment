package br.com.prodevelopment.busca.resultado.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.busca.resultado.Constantes;
import br.com.prodevelopment.busca.util.BuscaUtil;

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

		String prefCategoriaServico = preferences.getValue(Constantes.PREF_CATEGORIA_SERVICO, StringPool.SPACE);
		String prefCategoriaCliente = preferences.getValue(Constantes.PREF_CATEGORIA_CLIENTE, StringPool.SPACE);
		String prefCategoriaVideo = preferences.getValue(Constantes.PREF_CATEGORIA_VIDEO, StringPool.SPACE);
		String prefCategoriaNoticia = preferences.getValue(Constantes.PREF_CATEGORIA_NOTICIA, StringPool.SPACE);
		String prefCategoriaOutro = preferences.getValue(Constantes.PREF_CATEGORIA_OUTRO, StringPool.SPACE);
		String prefPaginaDestinoServico = preferences.getValue(Constantes.PREF_PAGINA_DESTINO_SERVICO, StringPool.SPACE);
		String prefPaginaDestinoCliente = preferences.getValue(Constantes.PREF_PAGINA_DESTINO_CLIENTE, StringPool.SPACE);
		String prefPaginaDestinoNoticia = preferences.getValue(Constantes.PREF_PAGINA_DESTINO_NOTICIA, StringPool.SPACE);
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
		renderRequest.setAttribute("prefCategoriaServico", prefCategoriaServico);
		renderRequest.setAttribute("prefCategoriaCliente", prefCategoriaCliente);
		renderRequest.setAttribute("prefCategoriaVideo", prefCategoriaVideo);
		renderRequest.setAttribute("prefCategoriaNoticia", prefCategoriaNoticia);
		renderRequest.setAttribute("prefCategoriaOutro", prefCategoriaOutro);
		renderRequest.setAttribute("prefPaginaDestinoServico", prefPaginaDestinoServico);
		renderRequest.setAttribute("prefPaginaDestinoCliente", prefPaginaDestinoCliente);
		renderRequest.setAttribute("prefPaginaDestinoNoticia", prefPaginaDestinoNoticia);
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

		String prefCategoriaServico = actionRequest.getParameter("prefCategoriaServico");
		String prefCategoriaCliente = actionRequest.getParameter("prefCategoriaCliente");
		String prefCategoriaVideo = actionRequest.getParameter("prefCategoriaVideo");
		String prefCategoriaNoticia = actionRequest.getParameter("prefCategoriaNoticia");
		String prefCategoriaOutro = actionRequest.getParameter("prefCategoriaOutro");
		String prefPaginaDestinoServico = actionRequest.getParameter("prefPaginaDestinoServico");
		String prefPaginaDestinoCliente = actionRequest.getParameter("prefPaginaDestinoCliente");
		String prefPaginaDestinoNoticia = actionRequest.getParameter("prefPaginaDestinoNoticia");
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
		portletPreferences.setValue(Constantes.PREF_CATEGORIA_SERVICO, prefCategoriaServico);
		portletPreferences.setValue(Constantes.PREF_CATEGORIA_CLIENTE, prefCategoriaCliente);
		portletPreferences.setValue(Constantes.PREF_CATEGORIA_VIDEO, prefCategoriaVideo);
		portletPreferences.setValue(Constantes.PREF_CATEGORIA_NOTICIA, prefCategoriaNoticia);
		portletPreferences.setValue(Constantes.PREF_CATEGORIA_OUTRO, prefCategoriaOutro);
		portletPreferences.setValue(Constantes.PREF_PAGINA_DESTINO_SERVICO, prefPaginaDestinoServico);
		portletPreferences.setValue(Constantes.PREF_PAGINA_DESTINO_CLIENTE, prefPaginaDestinoCliente);
		portletPreferences.setValue(Constantes.PREF_PAGINA_DESTINO_NOTICIA, prefPaginaDestinoNoticia);
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
