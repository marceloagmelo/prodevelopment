package br.com.prodevelopment.pesquisaopiniao.cadastro.portlet;

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
import br.com.prodevelopment.pesquisaopiniao.cadastro.action.PerguntaAction;
import br.com.prodevelopment.pesquisaopiniao.cadastro.action.PesquisaAction;
import br.com.prodevelopment.pesquisaopiniao.cadastro.action.RespostaAction;
import br.com.prodevelopment.pesquisaopiniao.model.Pergunta;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;
import br.com.prodevelopment.pesquisaopiniao.util.Helper;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CadastroPortlet
 */
public class CadastroPortlet extends MVCPortlet {

	protected String cadastroPesquisaJSP;
	protected String visualizarPesquisaJSP;
	protected String cadastroPerguntaJSP;
	protected String visualizarPerguntaJSP;
	protected String cadastroRespostaJSP;
	protected String visualizarRespostaJSP;
	protected String naoConfiguradoJSP;
	protected String usuarioNaoLogadoJSP;
	
	@Override
	public void init() throws PortletException {
		cadastroPesquisaJSP = getInitParameter(Constantes.JSP_CADASTRO_PESQUISA);
		visualizarPesquisaJSP = getInitParameter(Constantes.JSP_VISUALIZAR_PESQUISA);
		cadastroPerguntaJSP = getInitParameter(Constantes.JSP_CADASTRO_PERGUNTA);
		visualizarPerguntaJSP = getInitParameter(Constantes.JSP_VISUALIZAR_PERGUNTA);
		cadastroRespostaJSP = getInitParameter(Constantes.JSP_CADASTRO_RESPOSTA);
		visualizarRespostaJSP = getInitParameter(Constantes.JSP_VISUALIZAR_RESPOSTA);
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		usuarioNaoLogadoJSP = getInitParameter(Constantes.JSP_USUARIO_NAO_LOGADO);
		super.init();
	}

	@Override
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) req
					.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getScopeGroupId();

			// Recuperar preferencias
			PortletPreferences prefs = req.getPreferences();
			String exibirTitulo = prefs.getValue(Constantes.PREF_EXIBIR_TITULO,
					Constantes.VAZIO);
			String somenteUsuarioLogado = prefs.getValue(
					Constantes.SOMENTE_USUARIO_LOGADO, Constantes.S);
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);

			if ( (Constantes.S.equals(somenteUsuarioLogado)) && (!themeDisplay.isSignedIn()) ) {
				SessionMessages.add(req,
						"mensagem.testeUsuario.usuarioNaoLogado");
				include(usuarioNaoLogadoJSP, req, res);
			} else {

				if (Constantes.S.equals(prefConfigurado)) {
					// Recuperar objetos da sessão
					String metodo = (String) req.getPortletSession()
							.getAttribute(Constantes.NOME_PARAM_METODO);
					String filtro = (String) req
							.getPortletSession()
							.getAttribute(Constantes.NOME_PARAM_FILTRO_PESQUISA);
					String idPesquisa = (String) req.getPortletSession()
							.getAttribute(Constantes.NOME_PARAM_ID_PESQUISA);
					if (idPesquisa == null) {
						idPesquisa = ParamUtil.getString(req,
								Constantes.NOME_PARAM_ID_PESQUISA);
					}
					String idPergunta = (String) req.getPortletSession()
							.getAttribute(Constantes.NOME_PARAM_ID_PERGUNTA);
					if (idPergunta == null) {
						idPergunta = ParamUtil.getString(req,
								Constantes.NOME_PARAM_ID_PERGUNTA);
					}

					// Recuperar objetos ids do request
					String idResposta = ParamUtil.getString(req,
							Constantes.NOME_PARAM_ID_RESPOSTA);

					// Preparar as permissoes de modelo
					PermissionChecker permissionChecker = themeDisplay
							.getPermissionChecker();

					// Permissao de adicionar
					boolean hasAddPermission = permissionChecker.hasPermission(
							groupId, Constantes.PACKAGE_MODELO, groupId,
							Constantes.ADD_PESQUISA);

					// Permissao de configuracao
					boolean hasConfigurePermission = permissionChecker
							.hasPermission(groupId, Constantes.PACKAGE_MODELO,
									groupId, ActionKeys.PERMISSIONS);

					// Adiciona permissoes no objeto de request
					req.setAttribute(Constantes.NOME_PARAM_ADD_PERMISSAO,
							hasAddPermission);
					req.setAttribute(Constantes.NOME_PARAM_CONFIG_PERMISSAO,
							hasConfigurePermission);

					// Salvar id no request
					req.setAttribute(Constantes.NOME_PARAM_ID_PESQUISA,
							idPesquisa);
					req.setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
							idPergunta);
					req.setAttribute(Constantes.GROUP_ID,
							String.valueOf(groupId));
					req.setAttribute(Constantes.NOME_PARAM_ID_RESPOSTA,
							idResposta);

					String portletTitulo = Helper.getTituloPortlet(req, res,
							themeDisplay);
					req.setAttribute(Constantes.NOME_PARAM_TITULO_PORTLET,
							portletTitulo);
					req.setAttribute(Constantes.NOME_PARAM_EXIBIR_TITULO,
							exibirTitulo);

					// Preparar botões de chamadas
					PortletURL novoURL = res.createActionURL();
					novoURL.setParameter(Constantes.PORTLET_ACTION,
							Constantes.URL_METODO_PREPARAR_NOVA_PESQUISA);
					req.setAttribute(Constantes.NOME_PARAM_NOVA_PESQUISA_URL,
							novoURL.toString());

					PortletURL filtrarURL = res.createActionURL();
					filtrarURL.setParameter(Constantes.PORTLET_ACTION,
							Constantes.URL_METODO_FILTRAR_PESQUISA);
					req.setAttribute(
							Constantes.NOME_PARAM_FILTRAR_PESQUISA_URL,
							filtrarURL.toString());

					/*
					 * Pesquisa
					 */
					if (Constantes.VALOR_PARAM_ALTERAR_PESQUISA.equals(metodo)) {
						PesquisaAction.prepararAlteracao(req, res, idPesquisa,
								metodo);
						req.setAttribute(Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_PESQUISA_ALTERAR);
						include(cadastroPesquisaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_VISUALIZAR_PESQUISA
							.equals(metodo)) {
						PesquisaAction.prepararAlteracao(req, res, idPesquisa,
								metodo);
						req.setAttribute(
								Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_PESQUISA_VISUALIZAR);
						include(visualizarPesquisaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_EXCLUIR_PESQUISA
							.equals(metodo)) {
						PesquisaAction.prepararExclusao(req, res, idPesquisa);
						include(visualizarPesquisaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_NOVA_PESQUISA
							.equals(metodo)) {
						PesquisaAction.prepararNovo(req, res);
						include(cadastroPesquisaJSP, req, res);
						/*
						 * Pergunta
						 */
					} else if (Constantes.VALOR_PARAM_ALTERAR_PERGUNTA
							.equals(metodo)) {
						PerguntaAction.prepararAlteracao(req, res, idPergunta);
						req.setAttribute(Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_PERGUNTA_ALTERAR);
						include(cadastroPerguntaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_VISUALIZAR_PERGUNTA
							.equals(metodo)) {
						PerguntaAction.prepararAlteracao(req, res, idPergunta);
						req.setAttribute(
								Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_PERGUNTA_VISUALIZAR);
						include(visualizarPerguntaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_EXCLUIR_PERGUNTA
							.equals(metodo)) {
						PerguntaAction.prepararExclusao(req, res, idPergunta);
						include(visualizarPerguntaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_NOVA_PERGUNTA
							.equals(metodo)) {
						PerguntaAction.prepararNovo(req, res, idPesquisa);
						include(cadastroPerguntaJSP, req, res);
						/*
						 * Resposta
						 */

					} else if (Constantes.VALOR_PARAM_ALTERAR_RESPOSTA
							.equals(metodo)) {
						RespostaAction.prepararAlteracao(req, res, idResposta);
						req.setAttribute(Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_RESPOSTA_ALTERAR);
						include(cadastroRespostaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_VISUALIZAR_RESPOSTA
							.equals(metodo)) {
						RespostaAction.prepararAlteracao(req, res, idResposta);
						req.setAttribute(
								Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_RESPOSTA_VISUALIZAR);
						include(visualizarRespostaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_EXCLUIR_RESPOSTA
							.equals(metodo)) {
						RespostaAction.prepararExclusao(req, res, idResposta);
						include(visualizarRespostaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_NOVA_RESPOSTA
							.equals(metodo)) {
						RespostaAction.prepararNovo(req, res);
						include(cadastroRespostaJSP, req, res);
						/*
						 * Busca
						 */
					} else if (Constantes.VALOR_PARAM_FILTRAR_PESQUISA
							.equals(metodo)) {
						List<Pergunta> listaPergunta = PerguntaAction.buscar(
								req, res, filtro, idPesquisa);
						req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA,
								listaPergunta);
						include(cadastroPerguntaJSP, req, res);
					} else if (Constantes.VALOR_PARAM_FILTRAR_PERGUNTA
							.equals(metodo)) {
						List<Pergunta> listaPergunta = PerguntaAction.buscar(
								req, res, filtro, idPergunta);
						req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA,
								listaPergunta);
						include(cadastroPerguntaJSP, req, res);
					} else {
						List<Pesquisa> listaPesquisa = PesquisaAction.buscar(
								req, res, themeDisplay, filtro);
						req.setAttribute(
								Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_PESQUISA_PRINCIPAL);
						req.setAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA,
								listaPesquisa);

						super.doView(req, res);
					}

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

	public void prepararNovaPesquisa(ActionRequest req, ActionResponse res)
			throws Exception {
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_NOVA_PESQUISA);
	}

	public void prepararAlteracaoPesquisa(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_ALTERAR_PESQUISA);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PESQUISA,
				id);
	}

	public void prepararVisualizacaoPesquisa(ActionRequest req,
			ActionResponse res) throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_VISUALIZAR_PESQUISA);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PESQUISA,
				id);
	}

	public void prepararExclusaoPesquisa(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_EXCLUIR_PESQUISA);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PESQUISA,
				id);
	}

	public void confirmarPesquisa(ActionRequest request, ActionResponse response)
			throws Exception {
		PesquisaAction.confirmar(request, response);
	}

	public void cancelarPesquisa(ActionRequest request, ActionResponse response)
			throws Exception {
		request.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VAZIO);
		request.getPortletSession().setAttribute(
				Constantes.NOME_PARAM_FILTRO_PESQUISA, null);
		request.getPortletSession().setAttribute(
				Constantes.NOME_PARAM_ID_PESQUISA, null);

	}

	public void filtrarPesquisa(ActionRequest request, ActionResponse response)
			throws Exception {
		String filtro = ParamUtil.getString(request,
				Constantes.NOME_PARAM_FILTRO_PESQUISA);
		List<String> errors = new ArrayList<String>();

		try {
			if (Validator.isNotNull(filtro)) {
				// Salvar objetos na sessão
				request.getPortletSession().setAttribute(
						Constantes.NOME_PARAM_METODO,
						Constantes.MTH_FILTRAR_PESQUISA_POR_TITULO);
			} else {
				request.getPortletSession().setAttribute(
						Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
			}
			// Salvar objetos na sessão
			request.getPortletSession().setAttribute(
					Constantes.NOME_PARAM_FILTRO_PESQUISA, filtro);
		} catch (Exception e) {
			errors.add(Constantes.MSG_PESQUISA_ERRO);
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
		}
	}

	public void prepararNovaPergunta(ActionRequest req, ActionResponse res)
			throws Exception {
		String idPesquisa = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PESQUISA);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PESQUISA,
				idPesquisa);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_NOVA_PERGUNTA);
	}

	public void prepararAlteracaoPergunta(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
				id);
	}

	public void prepararVisualizacaoPergunta(ActionRequest req,
			ActionResponse res) throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_VISUALIZAR_PERGUNTA);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
				id);
	}

	public void prepararExclusaoPergunta(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_EXCLUIR_PERGUNTA);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
				id);
	}

	public void confirmarPergunta(ActionRequest request, ActionResponse response)
			throws Exception {
		PerguntaAction.confirmar(request, response);
	}

	public void cancelarPergunta(ActionRequest request, ActionResponse response)
			throws Exception {
		request.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_ALTERAR_PESQUISA);
		request.getPortletSession().setAttribute(
				Constantes.NOME_PARAM_FILTRO_PERGUNTA, null);
	}

	public void prepararNovaResposta(ActionRequest req, ActionResponse res)
			throws Exception {
		String idPesquisa = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PESQUISA);
		String idPergunta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PERGUNTA);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PESQUISA,
				idPesquisa);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
				idPergunta);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_NOVA_RESPOSTA);
	}

	public void prepararAlteracaoResposta(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		res.setRenderParameter(Constantes.NOME_PARAM_ID_RESPOSTA, id);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_ALTERAR_RESPOSTA);
	}

	public void prepararVisualizacaoResposta(ActionRequest req,
			ActionResponse res) throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		res.setRenderParameter(Constantes.NOME_PARAM_ID_RESPOSTA, id);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_VISUALIZAR_RESPOSTA);
	}

	public void prepararExclusaoResposta(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		res.setRenderParameter(Constantes.NOME_PARAM_ID_RESPOSTA, id);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_EXCLUIR_RESPOSTA);
	}

	public void confirmarResposta(ActionRequest request, ActionResponse response)
			throws Exception {
		RespostaAction.confirmar(request, response);
	}

	public void cancelarResposta(ActionRequest request, ActionResponse response)
			throws Exception {
		request.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);
		request.getPortletSession().setAttribute(
				Constantes.NOME_PARAM_FILTRO_RESPOSTA, null);
	}

	public void prepararNovaPesquisaResultado(ActionRequest req,
			ActionResponse res) throws Exception {
		String idPesquisa = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PESQUISA);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_PESQUISA,
				idPesquisa);
	}
}
