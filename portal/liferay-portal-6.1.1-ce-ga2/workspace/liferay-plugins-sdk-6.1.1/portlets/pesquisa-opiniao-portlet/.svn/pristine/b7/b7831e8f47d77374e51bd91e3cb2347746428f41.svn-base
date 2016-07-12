package br.com.prodevelopment.pesquisaopiniao.resultado.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.pesquisaopiniao.Constantes;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;
import br.com.prodevelopment.pesquisaopiniao.resultado.action.ResultadoAction;
import br.com.prodevelopment.pesquisaopiniao.util.Helper;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ResultadoPortlet
 */
public class ResultadoPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;
	protected String usuarioNaoLogadoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		usuarioNaoLogadoJSP = getInitParameter(Constantes.JSP_USUARIO_NAO_LOGADO);
		super.init();
	}

	@Override
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		// Recuperar objetos request
		String idPesquisa = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PESQUISA);

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			// Recuperar preferencias
			PortletPreferences prefs = req.getPreferences();
			String exibirTitulo = prefs.getValue(Constantes.PREF_EXIBIR_TITULO,
					Constantes.VAZIO);
			String prefConfigurado = prefs.getValue(Constantes.PREF_CONFIGURADO,
					Constantes.N);
			String somenteUsuarioLogado = prefs.getValue(
					Constantes.SOMENTE_USUARIO_LOGADO, Constantes.S);

			if ( (Constantes.S.equals(somenteUsuarioLogado)) && (!themeDisplay.isSignedIn()) ) {
				SessionMessages.add(req,
						"mensagem.testeUsuario.usuarioNaoLogado");
				include(usuarioNaoLogadoJSP, req, res);
			}
			else {
				if (Constantes.S.equals(prefConfigurado)) {
					// Recuperar título do portlet
					String portletTitulo = Helper.getTituloPortlet(req, res,
							themeDisplay);
					req.setAttribute(Constantes.TITULO_PORTLET, portletTitulo);

					// Salvar id no request
					req.setAttribute(Constantes.NOME_PARAM_ID_PESQUISA, idPesquisa);

					PortletURL gerarURL = res.createActionURL();
					gerarURL.setParameter(Constantes.PORTLET_ACTION,
							Constantes.URL_METODO_GERAR);
					req.setAttribute(Constantes.NOME_PARAM_GERAR_URL,
							gerarURL.toString());

					req.setAttribute(Constantes.NOME_PARAM_ID_PESQUISA, idPesquisa);
					req.setAttribute(Constantes.EXIBIR_TITULO, exibirTitulo);

					List<Pesquisa> listaPesquisa = ResultadoAction.buscar(req, res);
					req.setAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA, listaPesquisa);

					super.doView(req, res);
					
				} else {
					SessionMessages.add(req,
							Constantes.MSG_PORTLET_NAO_CONFIGURADO);
					include(naoConfiguradoJSP, req, res);
				}
			}
		} catch (Exception e) {
			SessionErrors.add(req, Constantes.MSG_ERRO_PORTLET);
		}
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		try {
			if (!isProcessActionRequest(actionRequest)) {
				return;
			}

			if (!callActionMethod(actionRequest, actionResponse)) {
				return;
			}

			if (!SessionErrors.isEmpty(actionRequest)) {
				return;
			}

			if (!SessionMessages.isEmpty(actionRequest)) {
				return;
			}

			sendRedirect(actionRequest, actionResponse);
		} catch (PortletException pe) {
			Throwable cause = pe.getCause();

			if (isSessionErrorException(cause)) {
				SessionErrors.add(actionRequest, cause.getClass().getName(),
						cause);
			} else {
				throw pe;
			}
		}
	}

	public void gerar(ActionRequest req, ActionResponse res) throws Exception {
		String idPesquisa = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PESQUISA);
		res.setRenderParameter(Constantes.NOME_PARAM_ID_PESQUISA, idPesquisa);
		ResultadoAction.gerar(req, res, idPesquisa);
	}

}
