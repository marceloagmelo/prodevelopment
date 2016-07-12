package br.com.prodevelopment.testeconhecimento.exibir.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.testeconhecimento.Constantes;
import br.com.prodevelopment.testeconhecimento.cadastro.action.PerguntaAction;
import br.com.prodevelopment.testeconhecimento.cadastro.action.RespostaAction;
import br.com.prodevelopment.testeconhecimento.exibir.action.ExibirAction;
import br.com.prodevelopment.testeconhecimento.model.Pergunta;
import br.com.prodevelopment.testeconhecimento.model.Resposta;
import br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario;
import br.com.prodevelopment.testeconhecimento.model.Teste_Usuario;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ExibirPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;
	protected String viewFimJSP;
	protected String usuarioNaoLogadoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		viewFimJSP = getInitParameter(Constantes.JSP_VIEW_FIM);
		usuarioNaoLogadoJSP = getInitParameter(Constantes.JSP_USUARIO_NAO_LOGADO);
		super.init();
	}

	@Override
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		// Recuperar objetos request
		String metodo = ParamUtil.getString(req, Constantes.NOME_PARAM_METODO);
		String precisaResponder = ParamUtil.getString(req,
				Constantes.NOME_PARAM_PRECISA_RESPONDER);
		String strPagina = ParamUtil.getString(req,
				Constantes.NOME_PARAM_PAGINA);
		String strPerguntasLidas = ParamUtil.getString(req,
				Constantes.NOME_PARAM_PERGUNTAS_LIDAS);
		String strTotalPaginas = ParamUtil.getString(req,
				Constantes.NOME_PARAM_TOTAL_PAGINAS);
		String justificativa = ParamUtil.getString(req,
				Constantes.NOME_PARAM_JUSTIFICATIVA);
		String usuarioRespondeu = ParamUtil.getString(req,
				Constantes.NOME_PARAM_USUARIO_RESPONDEU);
		String respostaCerta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_RESPOSTA_CERTA);

		// Recuperar dados do usuário
		User usuario = ExibirAction.recuperarUsuario(req);
		String usuarioLogado = (usuario.isDefaultUser() ? Constantes.N
				: Constantes.S);

		// Recuperar preferencias
		PortletPreferences prefs = req.getPreferences();
		String idTeste = prefs.getValue(Constantes.PREF_ID_TESTE,
				Constantes.VAZIO);
		String prefConfigurado = prefs.getValue(Constantes.PREF_CONFIGURADO,
				Constantes.N);
		String prefEnviarEmail = prefs.getValue(Constantes.PREF_ENVIAR_EMAIL,
				Constantes.S);
		String prefExibirAcerto = prefs.getValue(Constantes.PREF_EXIBIR_ACERTO,
				Constantes.S);

		// Salvar id no request
		req.setAttribute(Constantes.NOME_PARAM_ID_TESTE, idTeste);
		req.setAttribute(Constantes.PREF_ENVIAR_EMAIL, prefEnviarEmail);
		req.setAttribute(Constantes.PREF_EXIBIR_ACERTO, prefExibirAcerto);
		req.setAttribute(Constantes.PROP_TESTE_USUARIO_LOGADO, usuarioLogado);
		if (Validator.isNull(precisaResponder)) {
			req.setAttribute(Constantes.NOME_PARAM_PRECISA_RESPONDER,
					Constantes.UM);
		} else {
			req.setAttribute(Constantes.NOME_PARAM_PRECISA_RESPONDER,
					precisaResponder);
		}
		req.setAttribute(Constantes.NOME_PARAM_JUSTIFICATIVA, justificativa);
		req.setAttribute(Constantes.NOME_PARAM_USUARIO_RESPONDEU,
				usuarioRespondeu);
		req.setAttribute(Constantes.NOME_PARAM_RESPOSTA_CERTA, respostaCerta);

		Portlet portlet = (Portlet) req.getAttribute(WebKeys.RENDER_PORTLET);
		String resourceBundle = portlet.getResourceBundle();
		req.setAttribute(Constantes.RESOURCE_BUNDLE, resourceBundle);

		try {
			// Verificar se o usuário esta logado
			ThemeDisplay themeDisplay = (ThemeDisplay) req
					.getAttribute(WebKeys.THEME_DISPLAY);
			if (themeDisplay.isSignedIn()) {
				if (Constantes.S.equals(prefConfigurado)) {
					if (Validator.isNull(strPagina)) {
						// Verificar se o usuário já comeceu responder
						List<Teste_Usuario> lista = ExibirAction
								.recuperarListaTesteUsuarioPorUsuario(
										Long.parseLong(idTeste),
										usuario.getUserId());

						for (Teste_Usuario testeUsuario : lista) {
							if (testeUsuario.getDataFinalizacao() == null) {
								metodo = Constantes.VALOR_PARAM_PROXIMA;

								// Recuperar as respostas
								List<Resposta_Usuario> listaRespostaUsuario = ExibirAction
										.recuperarListaRespostaUsuarioPorTesteUsuario(testeUsuario
												.getId());

								strPagina = String.valueOf(listaRespostaUsuario
										.size());
								strPerguntasLidas = strPagina;
								// Recuperar o total de perguntas
								List<Pergunta> listaPerguntas = PerguntaAction
										.recuperarListaPorTeste(Long
												.parseLong(idTeste));
								strTotalPaginas = String.valueOf(listaPerguntas
										.size());

								if (strPagina.equals(strTotalPaginas)) {
									metodo = Constantes.VALOR_PARAM_FIM;
									for (Resposta_Usuario respostaUsuario : listaRespostaUsuario) {
										// Recuperar o objeto resposta
										Resposta resposta = RespostaAction
												.recuperarResposta(respostaUsuario
														.getRespostaId());

										// Recuperar o objeto pergunta
										Pergunta pergunta = PerguntaAction
												.recuperarPergunta(resposta
														.getPerguntaId());

										req.setAttribute(
												Constantes.NOME_PARAM_JUSTIFICATIVA,
												pergunta.getJustificativaResposta());
										req.setAttribute(
												Constantes.NOME_PARAM_USUARIO_RESPONDEU,
												resposta.getDescricao());
										req.setAttribute(
												Constantes.NOME_PARAM_RESPOSTA_CERTA,
												respostaCerta);
										if (Constantes.S.equals(respostaUsuario
												.getCorreta())) {
											SessionMessages
													.add(req,
															"mensagem.testeUsuario.respostaCerta");
											req.setAttribute(
													Constantes.NOME_PARAM_RESPOSTA_CERTA,
													Constantes.S);
										} else {
											req.setAttribute(
													Constantes.NOME_PARAM_RESPOSTA_CERTA,
													Constantes.N);
										}
									}

									SessionMessages
											.add(req,
													"mensagem.testeUsuario.testeRespondido");
									req.setAttribute(
											Constantes.NOME_PARAM_PRECISA_RESPONDER,
											Constantes.ZERO);
								}
							}
						}
					}
					if (Constantes.VALOR_PARAM_PROXIMA.equals(metodo)) {
						ExibirAction.perguntasLidas = Integer
								.parseInt(strPerguntasLidas);
						ExibirAction.totalPaginas = Integer
								.parseInt(strTotalPaginas);
						ExibirAction.renderiza(req, res,
								Integer.parseInt(idTeste),
								Integer.parseInt(strPagina) + 1);
						super.doView(req, res);
					} else if (Constantes.VALOR_PARAM_ERRO.equals(metodo)) {
						ExibirAction.perguntasLidas = Integer
								.parseInt(strPerguntasLidas) - 1;
						ExibirAction.totalPaginas = Integer
								.parseInt(strTotalPaginas);
						ExibirAction.renderiza(req, res,
								Integer.parseInt(idTeste),
								Integer.parseInt(strPagina));
						super.doView(req, res);
					} else if (Constantes.VALOR_PARAM_CONFIRMAR.equals(metodo)) {
						ExibirAction.perguntasLidas = Integer
								.parseInt(strPerguntasLidas) - 1;
						ExibirAction.totalPaginas = Integer
								.parseInt(strTotalPaginas);
						ExibirAction.renderiza(req, res,
								Integer.parseInt(idTeste),
								Integer.parseInt(strPagina));
						super.doView(req, res);
					} else if (Constantes.VALOR_PARAM_FIM.equals(metodo)) {
						ExibirAction.perguntasLidas = Integer
								.parseInt(strPerguntasLidas);
						ExibirAction.totalPaginas = Integer
								.parseInt(strTotalPaginas);
						ExibirAction.renderiza(req, res,
								Integer.parseInt(idTeste),
								Integer.parseInt(strPagina));

						PortletURL voltarInicioURL = res.createActionURL();
						voltarInicioURL.setParameter(Constantes.PORTLET_ACTION,
								Constantes.URL_METODO_VOLTAR_INICIO);
						req.setAttribute(
								Constantes.NOME_PARAM_VOTLAR_INICIO_URL,
								voltarInicioURL.toString());
						include(viewFimJSP, req, res);

					} else {
						ExibirAction
								.inicio(req, res, Integer.parseInt(idTeste));
						super.doView(req, res);
					}

				} else {
					SessionMessages.add(req,
							"mensagem.testeUsuario.naoConfigurado");
					include(naoConfiguradoJSP, req, res);
				}
			} else {
				SessionMessages
						.add(req, "mensagem.testeUsuario.usuarioNaoLogado");
				include(usuarioNaoLogadoJSP, req, res);

			}
		} catch (Exception e) {
			SessionErrors.add(req, Constantes.MSG_ERRO_PORTLET);
			super.doView(req, res);
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

	@ProcessAction(name = "acao")
	public void acao(ActionRequest req, ActionResponse res) throws Exception {
		// Recuperar preferencias
		PortletPreferences prefs = req.getPreferences();
		String prefExibirAcerto = prefs.getValue(Constantes.PREF_EXIBIR_ACERTO,
				Constantes.VAZIO);
		String prefEnviarEmail = prefs.getValue(Constantes.PREF_ENVIAR_EMAIL,
				Constantes.VAZIO);

		String idTeste = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_TESTE);
		String pagina = ParamUtil.getString(req, Constantes.NOME_PARAM_PAGINA);
		String perguntasLidas = ParamUtil.getString(req,
				Constantes.NOME_PARAM_PERGUNTAS_LIDAS);
		String totalPaginas = ParamUtil.getString(req,
				Constantes.NOME_PARAM_TOTAL_PAGINAS);
		String acao = ParamUtil.getString(req, Constantes.NOME_PARAM_ACAO);
		String idResposta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_RESPOSTA);
		String resourceBundle = ParamUtil.getString(req, Constantes.RESOURCE_BUNDLE);

		List<String> errors = new ArrayList<String>();

		// Recuperar dados do usuário
		User usuario = ExibirAction.recuperarUsuario(req);

		if ((Constantes.VALOR_PARAM_ENVIAR.equals(acao))
				|| (Constantes.VALOR_PARAM_PROXIMA.equals(acao))) {
			if ((Constantes.VALOR_PARAM_ENVIAR.equals(acao))) {
				ExibirAction.enviar(req, res, idTeste, prefEnviarEmail, resourceBundle);
			} else {
				res.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_PROXIMA);
				res.setRenderParameter(Constantes.NOME_PARAM_PRECISA_RESPONDER,
						Constantes.UM);
			}
		} else if (Constantes.VALOR_PARAM_CONFIRMAR.equals(acao)) {
			if ((Integer.parseInt(pagina) == 1)
					&& (ExibirAction.jaRespondeu(idTeste, usuario.getUserId()))) {
				errors.add("mensagem.testeUsuario.jaRespondeu");
				for (String error : errors) {
					SessionErrors.add(req, error);
				}
				res.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_ERRO);
			}
			if (Validator.isNull(idResposta)) {
				errors.add("mensagem.testeUsuario.selecione.resposta");
				for (String error : errors) {
					SessionErrors.add(req, error);
				}
				res.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_ERRO);
				res.setRenderParameter(Constantes.NOME_PARAM_PRECISA_RESPONDER,
						Constantes.UM);
			}
			if (errors.size() == 0) {
				ExibirAction.confirmar(req, res, idTeste, pagina,
						prefExibirAcerto);
				res.setRenderParameter(Constantes.NOME_PARAM_PRECISA_RESPONDER,
						Constantes.ZERO);
				res.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_CONFIRMAR);
			}
		}
		res.setRenderParameter(Constantes.NOME_PARAM_ID_TESTE, idTeste);
		res.setRenderParameter(Constantes.NOME_PARAM_PAGINA, pagina);
		res.setRenderParameter(Constantes.NOME_PARAM_PERGUNTAS_LIDAS,
				perguntasLidas);
		res.setRenderParameter(Constantes.NOME_PARAM_TOTAL_PAGINAS,
				totalPaginas);
	}

	@ProcessAction(name = "voltarInicio")
	public void voltarInicio(ActionRequest req, ActionResponse res)
			throws Exception {
		res.setRenderParameter(Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
	}
}
