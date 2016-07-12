package br.com.prodevelopment.pesquisaopiniao.exibir.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.pesquisaopiniao.Constantes;
import br.com.prodevelopment.pesquisaopiniao.exibir.action.ExibirAction;
import br.com.prodevelopment.pesquisaopiniao.util.Helper;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ExibirPortlet
 */
public class ExibirPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;
	protected String viewFimJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		viewFimJSP = getInitParameter(Constantes.JSP_VIEW_FIM);
		super.init();
	}

	@Override
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Recuperar objetos request
		String metodo = ParamUtil.getString(req, Constantes.NOME_PARAM_METODO);
		String strPagina = ParamUtil.getString(req,
				Constantes.NOME_PARAM_PAGINA);
		String strPerguntasLidas = ParamUtil.getString(req,
				Constantes.NOME_PARAM_PERGUNTAS_LIDAS);
		String strTotalPaginas = ParamUtil.getString(req,
				Constantes.NOME_PARAM_TOTAL_PAGINAS);
		String nome = ParamUtil.getString(req, Constantes.PROP_PESQUISA_NOME);
		String email = ParamUtil.getString(req, Constantes.PROP_PESQUISA_EMAIL);

		// Recuperar dados do usuário
		User usuario = ExibirAction.recuperarUsuario(req);
		String usuarioLogado = (usuario.isDefaultUser() ? Constantes.N
				: Constantes.S);
		if (!usuario.isDefaultUser()) {
			nome = usuario.getFullName();
			email = usuario.getEmailAddress();
		}

		// Recuperar preferencias
		PortletPreferences prefs = req.getPreferences();
		String idPesquisa = prefs.getValue(Constantes.PREF_ID_PESQUISA,
				Constantes.VAZIO);
		String prefAnonima = prefs.getValue(Constantes.PREF_ANONIMA,
				Constantes.S);
		String prefEnviarEmail = prefs.getValue(Constantes.PREF_ENVIAR_EMAIL,
				Constantes.S);
		String prefConfigurado = prefs.getValue(Constantes.PREF_CONFIGURADO,
				Constantes.N);
		String exibirTitulo = prefs.getValue(Constantes.PREF_EXIBIR_TITULO,
				Constantes.VAZIO);

		// Salvar id no request
		req.setAttribute(Constantes.NOME_PARAM_ID_PESQUISA, idPesquisa);
		req.setAttribute(Constantes.PREF_ANONIMA, prefAnonima);
		req.setAttribute(Constantes.PREF_ENVIAR_EMAIL, prefEnviarEmail);
		req.setAttribute(Constantes.PROP_PESQUISA_NOME, nome);
		req.setAttribute(Constantes.PROP_PESQUISA_EMAIL, email);
		req.setAttribute(Constantes.PROP_PESQUISA_USUARIO_LOGADO, usuarioLogado);
		req.setAttribute(Constantes.EXIBIR_TITULO, exibirTitulo);

		Portlet portlet = (Portlet) req.getAttribute(WebKeys.RENDER_PORTLET);
		String resourceBundle = portlet.getResourceBundle();
		req.setAttribute(Constantes.RESOURCE_BUNDLE, resourceBundle);
		
		try {
			// Recuperar título do portlet
			String portletTitulo = Helper.getTituloPortlet(req, res,themeDisplay);
			req.setAttribute(Constantes.TITULO_PORTLET,	portletTitulo);
			
			if (Constantes.S.equals(prefConfigurado)) {
				if (Constantes.VALOR_PARAM_ANTERIOR.equals(metodo)) {
					ExibirAction.perguntasLidas = Integer
							.parseInt(strPerguntasLidas) - 2;
					ExibirAction.totalPaginas = Integer
							.parseInt(strTotalPaginas);
					ExibirAction.renderiza(req, res,
							Integer.parseInt(idPesquisa),
							Integer.parseInt(strPagina) - 1);
					super.doView(req, res);
				} else if (Constantes.VALOR_PARAM_PROXIMA.equals(metodo)) {
					ExibirAction.perguntasLidas = Integer
							.parseInt(strPerguntasLidas);
					ExibirAction.totalPaginas = Integer
							.parseInt(strTotalPaginas);
					ExibirAction.renderiza(req, res,
							Integer.parseInt(idPesquisa),
							Integer.parseInt(strPagina) + 1);
					super.doView(req, res);
				} else if (Constantes.VALOR_PARAM_ERRO.equals(metodo)) {
					ExibirAction.perguntasLidas = Integer
							.parseInt(strPerguntasLidas) - 1;
					ExibirAction.totalPaginas = Integer
							.parseInt(strTotalPaginas);
					ExibirAction.renderiza(req, res,
							Integer.parseInt(idPesquisa),
							Integer.parseInt(strPagina));
					super.doView(req, res);
				} else if (Constantes.VALOR_PARAM_FIM.equals(metodo)) {
					ExibirAction.renderiza(req, res,
							Integer.parseInt(idPesquisa),
							Integer.parseInt(strPagina) + 1);

		    		PortletURL voltarInicioURL = res.createActionURL();
		    		voltarInicioURL.setParameter(Constantes.PORTLET_ACTION, Constantes.URL_METODO_VOLTAR_INICIO);
		    		req.setAttribute(Constantes.NOME_PARAM_VOTLAR_INICIO_URL, voltarInicioURL.toString());
					include(viewFimJSP, req, res);
				} else {
					ExibirAction.inicio(req, res,
							Integer.parseInt(idPesquisa));
					super.doView(req, res);
				}
			} else {
				SessionMessages.add(req,
						Constantes.MSG_PORTLET_NAO_CONFIGURADO);
				include(naoConfiguradoJSP, req, res);
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

	public void acao(ActionRequest req, ActionResponse res) throws Exception {
		// Recuperar preferencias
		PortletPreferences prefs = req.getPreferences();
		String prefAnonima = prefs.getValue(Constantes.PREF_ANONIMA,
				Constantes.VAZIO);
		String prefEnviarEmail = prefs.getValue(Constantes.PREF_ENVIAR_EMAIL,
				Constantes.VAZIO);

		String idPesquisa = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PESQUISA);
		String pagina = ParamUtil.getString(req, Constantes.NOME_PARAM_PAGINA);
		String perguntasLidas = ParamUtil.getString(req,
				Constantes.NOME_PARAM_PERGUNTAS_LIDAS);
		String totalPaginas = ParamUtil.getString(req,
				Constantes.NOME_PARAM_TOTAL_PAGINAS);
		String acao = ParamUtil.getString(req, Constantes.NOME_PARAM_ACAO);
		String idResposta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_RESPOSTA);
		String nome = ParamUtil.getString(req, Constantes.PROP_PESQUISA_NOME);
		String email = ParamUtil.getString(req, Constantes.PROP_PESQUISA_EMAIL);
		String resourceBundle = ParamUtil.getString(req, Constantes.RESOURCE_BUNDLE);
		
		List<String> errors = new ArrayList<String>();

		// Recuperar dados do usuário
		User usuario = ExibirAction.recuperarUsuario(req);
		String usuarioLogado = (usuario.isDefaultUser() ? Constantes.ZERO
				: Constantes.UM);

		if ((Constantes.VALOR_PARAM_ENVIAR.equals(acao))
				|| (Constantes.VALOR_PARAM_PROXIMA.equals(acao))) {
			if (Constantes.N.equals(prefAnonima)) {
				if ((Integer.parseInt(pagina) == 1) && (Validator.isNull(nome))) {
					errors.add(Constantes.MSG_PESQUISA_NOME_OBRIGATORIO);
					for (String error : errors) {
						SessionErrors.add(req, error);
					}
					res.setRenderParameter(Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_ERRO);
				}
				if ((Integer.parseInt(pagina) == 1) && (Validator.isNull(email))) {
					errors.add(Constantes.MSG_PESQUISA_EMAIL_OBRIGATORIO);
					for (String error : errors) {
						SessionErrors.add(req, error);
					}
					res.setRenderParameter(Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_ERRO);
				} else if ((Integer.parseInt(pagina) == 1)
						&& (Constantes.ZERO.equals(usuarioLogado))
						&& (ExibirAction.jaRespondeu(idPesquisa, email))) {
					errors.add("mensagem.pesquisaUsuario.jaRespondeu");
					for (String error : errors) {
						SessionErrors.add(req, error);
					}
					res.setRenderParameter(Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_ERRO);
				} else if ((Integer.parseInt(pagina) == 1)
						&& (Constantes.UM.equals(usuarioLogado))
						&& (ExibirAction.jaRespondeu(idPesquisa,
								usuario.getUserId()))) {
					errors.add(Constantes.MSG_PESQUISA_USUARIO_RESPONDEU);
					for (String error : errors) {
						SessionErrors.add(req, error);
					}
					res.setRenderParameter(Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_ERRO);
				}
			}
			if (Validator.isNull(idResposta)) {
				errors.add(Constantes.MSG_PESQUISA_SELECIONE_RESPOSTA);
				for (String error : errors) {
					SessionErrors.add(req, error);
				}
				res.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_ERRO);
			}
			if (errors.size() == 0) {
				ExibirAction.gravarMaps(req, res, idPesquisa, prefAnonima);
				if ((Constantes.VALOR_PARAM_ENVIAR.equals(acao))) {
					ExibirAction.enviar(req, res, prefAnonima, prefEnviarEmail, resourceBundle);
					res.setRenderParameter(Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_FIM);
				} else {
					res.setRenderParameter(Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_PROXIMA);
				}
			}
		} else {
			res.setRenderParameter(Constantes.NOME_PARAM_METODO,
					Constantes.VALOR_PARAM_ANTERIOR);
		}
		res.setRenderParameter(Constantes.NOME_PARAM_ID_PESQUISA, idPesquisa);
		res.setRenderParameter(Constantes.NOME_PARAM_PAGINA, pagina);
		res.setRenderParameter(Constantes.NOME_PARAM_PERGUNTAS_LIDAS,
				perguntasLidas);
		res.setRenderParameter(Constantes.NOME_PARAM_TOTAL_PAGINAS,
				totalPaginas);
		res.setRenderParameter(Constantes.PROP_PESQUISA_NOME, nome);
		res.setRenderParameter(Constantes.PROP_PESQUISA_EMAIL, email);
	}

	public void voltarInicio(ActionRequest req, ActionResponse res) throws Exception {
		res.setRenderParameter(Constantes.NOME_PARAM_METODO,
				Constantes.VAZIO);
	}


}
