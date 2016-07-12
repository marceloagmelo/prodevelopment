package br.com.prodevelopment.testeconhecimento.cadastro.portlet;

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

import br.com.prodevelopment.testeconhecimento.Constantes;
import br.com.prodevelopment.testeconhecimento.cadastro.action.PerguntaAction;
import br.com.prodevelopment.testeconhecimento.cadastro.action.RespostaAction;
import br.com.prodevelopment.testeconhecimento.cadastro.action.TesteAction;
import br.com.prodevelopment.testeconhecimento.model.Pergunta;
import br.com.prodevelopment.testeconhecimento.model.Teste;
import br.com.prodevelopment.testeconhecimento.util.Helper;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CadastroPortlet extends MVCPortlet {

	protected String cadastroTesteJSP;
	protected String visualizarTesteJSP;
	protected String cadastroPerguntaJSP;
	protected String visualizarPerguntaJSP;
	protected String cadastroRespostaJSP;
	protected String visualizarRespostaJSP;
	protected String naoConfiguradoJSP;
	protected String usuarioNaoLogadoJSP;
	
	@Override
	public void init() throws PortletException {
		cadastroTesteJSP = getInitParameter(Constantes.JSP_CADASTRO_TESTE);
		visualizarTesteJSP = getInitParameter(Constantes.JSP_VISUALIZAR_TESTE);
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
							.getAttribute(Constantes.NOME_PARAM_FILTRO_TESTE);
					String idTeste = (String) req.getPortletSession()
							.getAttribute(Constantes.NOME_PARAM_ID_TESTE);
					if (idTeste == null) {
						idTeste = ParamUtil.getString(req,
								Constantes.NOME_PARAM_ID_TESTE);
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
							Constantes.ADD_TESTE);

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
					req.setAttribute(Constantes.NOME_PARAM_ID_TESTE,
							idTeste);
					req.setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
							idPergunta);
					req.setAttribute(Constantes.GROUP_ID,
							String.valueOf(groupId));
					req.setAttribute(Constantes.NOME_PARAM_ID_RESPOSTA,
							idResposta);

					String portletTitulo = Helper.getTituloPortlet(req, res, themeDisplay);
					
					req.setAttribute(Constantes.NOME_PARAM_TITULO_PORTLET,
							portletTitulo);
					req.setAttribute(Constantes.NOME_PARAM_EXIBIR_TITULO,
							exibirTitulo);

					// Preparar botões de chamadas
					PortletURL novoURL = res.createActionURL();
					novoURL.setParameter(Constantes.PORTLET_ACTION,
							Constantes.URL_METODO_PREPARAR_NOVA_TESTE);
					req.setAttribute(Constantes.NOME_PARAM_NOVA_TESTE_URL,
							novoURL.toString());

					PortletURL filtrarURL = res.createActionURL();
					filtrarURL.setParameter(Constantes.PORTLET_ACTION,
							Constantes.URL_METODO_FILTRAR_TESTE);
					req.setAttribute(
							Constantes.NOME_PARAM_FILTRAR_TESTE_URL,
							filtrarURL.toString());

					/*
					 * Teste
					 */
					if (Constantes.VALOR_PARAM_ALTERAR_TESTE.equals(metodo)) {
						TesteAction.prepararAlteracao(req, res, idTeste,
								metodo);
						req.setAttribute(Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_TESTE_ALTERAR);
						include(cadastroTesteJSP, req, res);
					} else if (Constantes.VALOR_PARAM_VISUALIZAR_TESTE
							.equals(metodo)) {
						TesteAction.prepararAlteracao(req, res, idTeste,
								metodo);
						req.setAttribute(
								Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_TESTE_VISUALIZAR);
						include(visualizarTesteJSP, req, res);
					} else if (Constantes.VALOR_PARAM_EXCLUIR_TESTE
							.equals(metodo)) {
						TesteAction.prepararExclusao(req, res, idTeste);
						include(visualizarTesteJSP, req, res);
					} else if (Constantes.VALOR_PARAM_NOVA_TESTE
							.equals(metodo)) {
						TesteAction.prepararNovo(req, res);
						include(cadastroTesteJSP, req, res);
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
						PerguntaAction.prepararNovo(req, res, idTeste);
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
					} else if (Constantes.VALOR_PARAM_FILTRAR_TESTE
							.equals(metodo)) {
						List<Pergunta> listaPergunta = PerguntaAction.buscar(
								req, res, filtro, idTeste);
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
						List<Teste> listaTeste = TesteAction.buscar(
								req, res, themeDisplay, filtro);
						req.setAttribute(
								Constantes.NOME_PARAM_TITULO,
								Constantes.VALOR_PARAM_TITULO_TESTE_PRINCIPAL);
						req.setAttribute(Constantes.NOME_PARAM_LISTA_TESTE,
								listaTeste);

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

	public void prepararNovaTeste(ActionRequest req, ActionResponse res)
			throws Exception {
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_NOVA_TESTE);
	}

	public void prepararAlteracaoTeste(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_ALTERAR_TESTE);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_TESTE,
				id);
	}

	public void prepararVisualizacaoTeste(ActionRequest req,
			ActionResponse res) throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_VISUALIZAR_TESTE);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_TESTE,
				id);
	}

	public void prepararExclusaoTeste(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = ParamUtil.getString(req, Constantes.NOME_PARAM_ID);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VALOR_PARAM_EXCLUIR_TESTE);
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_TESTE,
				id);
	}

	public void confirmarTeste(ActionRequest request, ActionResponse response)
			throws Exception {
		TesteAction.confirmar(request, response);
	}

	public void cancelarTeste(ActionRequest request, ActionResponse response)
			throws Exception {
		request.getPortletSession().setAttribute(Constantes.NOME_PARAM_METODO,
				Constantes.VAZIO);
		request.getPortletSession().setAttribute(
				Constantes.NOME_PARAM_FILTRO_TESTE, null);
		request.getPortletSession().setAttribute(
				Constantes.NOME_PARAM_ID_TESTE, null);

	}

	public void filtrarTeste(ActionRequest request, ActionResponse response)
			throws Exception {
		String filtro = ParamUtil.getString(request,
				Constantes.NOME_PARAM_FILTRO_TESTE);
		List<String> errors = new ArrayList<String>();

		try {
			if (Validator.isNotNull(filtro)) {
				// Salvar objetos na sessão
				request.getPortletSession().setAttribute(
						Constantes.NOME_PARAM_METODO,
						Constantes.MTH_FILTRAR_TESTE_POR_TITULO);
			} else {
				request.getPortletSession().setAttribute(
						Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
			}
			// Salvar objetos na sessão
			request.getPortletSession().setAttribute(
					Constantes.NOME_PARAM_FILTRO_TESTE, filtro);
		} catch (Exception e) {
			errors.add(Constantes.MSG_TESTE_ERRO);
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
		}
	}

	public void prepararNovaPergunta(ActionRequest req, ActionResponse res)
			throws Exception {
		String idTeste = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_TESTE);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_TESTE,
				idTeste);
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
				Constantes.VALOR_PARAM_ALTERAR_TESTE);
		request.getPortletSession().setAttribute(
				Constantes.NOME_PARAM_FILTRO_PERGUNTA, null);
	}

	public void prepararNovaResposta(ActionRequest req, ActionResponse res)
			throws Exception {
		String idTeste = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_TESTE);
		String idPergunta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PERGUNTA);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_TESTE,
				idTeste);
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

	public void prepararNovaTesteResultado(ActionRequest req,
			ActionResponse res) throws Exception {
		String idTeste = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_TESTE);

		// Salvar objetos na sessão
		req.getPortletSession().setAttribute(Constantes.NOME_PARAM_ID_TESTE,
				idTeste);
	}
}
