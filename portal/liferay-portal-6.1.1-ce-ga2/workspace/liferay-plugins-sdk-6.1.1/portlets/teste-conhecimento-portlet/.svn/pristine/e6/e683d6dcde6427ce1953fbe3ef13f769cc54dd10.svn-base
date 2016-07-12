package br.com.prodevelopment.testeconhecimento.cadastro.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.testeconhecimento.Constantes;
import br.com.prodevelopment.testeconhecimento.cadastro.validacao.TesteValidator;
import br.com.prodevelopment.testeconhecimento.model.Pergunta;
import br.com.prodevelopment.testeconhecimento.model.Resposta;
import br.com.prodevelopment.testeconhecimento.model.Teste;
import br.com.prodevelopment.testeconhecimento.model.impl.TesteImpl;
import br.com.prodevelopment.testeconhecimento.service.PerguntaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.RespostaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.TesteLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.util.Helper;
import br.com.prodevelopment.testeconhecimento.vo.PerguntaVO;
import br.com.prodevelopment.testeconhecimento.vo.RespostaVO;
import br.com.prodevelopment.testeconhecimento.vo.TesteVO;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class TesteAction {

	public static List<Teste> buscar(RenderRequest req, RenderResponse res,
			ThemeDisplay themeDisplay, String filtro) throws Exception {

		req.getPortletSession().removeAttribute(Constantes.NOME_PARAM_METODO);
		req.getPortletSession().removeAttribute(
				Constantes.NOME_PARAM_FILTRO_TESTE);
		req.getPortletSession().removeAttribute(Constantes.NOME_PARAM_ID_TESTE);

		// Recuperar a companhia e grupo
		long idGroup = themeDisplay.getScopeGroupId();
		long idCompany = themeDisplay.getCompanyId();

		List<String> errors = new ArrayList<String>();
		List<Teste> listaTeste = null;
		try {
			// Recuperar testes
			DynamicQuery testeQuery = DynamicQueryFactoryUtil
					.forClass(Teste.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq("companyId",
					idCompany);
			testeQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq("groupId",
					idGroup);
			testeQuery.add(criteriaGroup);
			if (Validator.isNotNull(filtro)) {
				Criterion criteriaTitulo = RestrictionsFactoryUtil.like(
						"titulo", Constantes.PERCENTE + filtro
								+ Constantes.PERCENTE);
				testeQuery.add(criteriaTitulo);
			}
			testeQuery.addOrder(OrderFactoryUtil.asc("titulo"));

			listaTeste = (List<Teste>) TesteLocalServiceUtil
					.dynamicQuery(testeQuery);
		} catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
		return listaTeste;
	}

	public static void prepararNovo(RenderRequest req, RenderResponse res)
			throws Exception {
		// Recupera o objeto de erro se tiver
		TesteVO testeError = (TesteVO) req
				.getAttribute(Constantes.NOME_PARAM_TESTE_ERROR);

		// Inicia a testeVO
		TesteVO testeVO = null;
		if (Validator.isNotNull(testeError)) {
			testeVO = testeError;
		} else {
			// Recuperar testeVO com teste
			testeVO = getTesteVOFromTeste(null);
		}

		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_TESTE);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_TESTE_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_TESTE);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_TESTE_URL,
				cancelarURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_TESTE,
				Constantes.VALOR_PARAM_NOVA_TESTE);
		req.setAttribute(Constantes.NOME_PARAM_TITULO,
				Constantes.VALOR_PARAM_TITULO_TESTE_NOVO);

		req.setAttribute(Constantes.NOME_PARAM_TESTE_VO, testeVO);
	}

	public static void prepararAlteracao(RenderRequest req, RenderResponse res,
			String id, String metodo) throws Exception {
		// Recupera o objeto de erro se tiver
		TesteVO testeError = (TesteVO) req
				.getAttribute(Constantes.NOME_PARAM_TESTE_ERROR);

		// Recupera testeVO
		TesteVO testeVO = (TesteVO) req
				.getAttribute(Constantes.NOME_PARAM_TESTE_VO);

		Teste teste = null;
		if (Validator.isNotNull(testeError)) {
			testeVO = testeError;
			teste = getTesteFromTesteVO(testeVO, teste);
		} else {
			// Recuperar a teste
			if (!Constantes.VAZIO.equals(id)) {
				long idTeste = Long.parseLong(id);
				teste = TesteLocalServiceUtil.getTeste(idTeste);
				// Recuperar testeVO com teste
				testeVO = getTesteVOFromTeste(teste);
			} else {
				// Recuperar testeVO com teste
				testeVO = getTesteVOFromTeste(null);
			}
		}

		// Recuperar perguntas
		List<Pergunta> listaPergunta = PerguntaAction.buscar(req, res, null, testeVO.getId());
		req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA, listaPergunta);

		if (Constantes.VALOR_PARAM_VISUALIZAR_TESTE.equals(metodo)) {
			// Recuperar a lista de resposta
			Map<Long, RespostaVO> mapRespostas = recuperarRespostasVO();

			// Recuperar perguntas com respostas
			List<PerguntaVO> listaPerguntasVO = recuperarPerguntasVO(
					listaPergunta, mapRespostas);
			req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA_VO,
					listaPerguntasVO);
		}		

		// Preparar botões de chamadas
		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_TESTE);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_TESTE_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_TESTE);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_TESTE_URL,
				cancelarURL.toString());

		PortletURL novoURL = res.createActionURL();
		novoURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_PREPARAR_NOVA_PERGUNTA);
		novoURL.setParameter(Constantes.NOME_PARAM_ID_TESTE, testeVO.getId());
		req.setAttribute(Constantes.NOME_PARAM_NOVA_PERGUNTA_URL,
				novoURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_TESTE,
				Constantes.VALOR_PARAM_ALTERAR_TESTE);

		req.setAttribute(Constantes.NOME_PARAM_TESTE_VO, testeVO);
	}

	public static void prepararExclusao(RenderRequest req, RenderResponse res,
			String id) throws Exception {
		// Recupera o objeto de erro se tiver
		TesteVO testeError = (TesteVO) req
				.getAttribute(Constantes.NOME_PARAM_TESTE_ERROR);

		// Recupera testeVO
		TesteVO testeVO = (TesteVO) req
				.getAttribute(Constantes.NOME_PARAM_TESTE_VO);

		if (Validator.isNotNull(testeError)) {
			testeVO = testeError;
		} else {
			// Recuperar a teste
			Teste teste = null;
			if (!Constantes.VAZIO.equals(id)) {
				long idTeste = Long.parseLong(id);
				teste = TesteLocalServiceUtil.getTeste(idTeste);
				// Recuperar testeVO com teste
				testeVO = getTesteVOFromTeste(teste);
			} else {
				// Recuperar testeVO com teste
				testeVO = getTesteVOFromTeste(null);
			}
		}

		// Recuperar perguntas
		List<Pergunta> listaPergunta = PerguntaAction.buscar(req, res, null,
				testeVO.getId());
		req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA, listaPergunta);

		// Recuperar a lista de resposta
		Map<Long, RespostaVO> mapRespostas = recuperarRespostasVO();
		
		// Recuperar perguntas com respostas
		List<PerguntaVO> listaPerguntasVO = recuperarPerguntasVO(listaPergunta,
				mapRespostas);
		req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA_VO,
				listaPerguntasVO);
		
		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_TESTE);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_TESTE_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_TESTE);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_TESTE_URL,
				cancelarURL.toString());
		PortletURL novoURL = res.createActionURL();
		novoURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_PREPARAR_NOVA_PERGUNTA);
		novoURL.setParameter(Constantes.NOME_PARAM_ID_TESTE, testeVO.getId());
		req.setAttribute(Constantes.NOME_PARAM_NOVA_PERGUNTA_URL,
				novoURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_TESTE,
				Constantes.VALOR_PARAM_EXCLUIR_TESTE);
		req.setAttribute(Constantes.NOME_PARAM_TITULO,
				Constantes.VALOR_PARAM_TITULO_TESTE_EXCLUIR);

		req.setAttribute(Constantes.NOME_PARAM_TESTE_VO, testeVO);
	}

	public static void cancelar(ActionRequest req, ActionResponse res)
			throws Exception {
	}

	public static void confirmar(ActionRequest request, ActionResponse response)
			throws Exception {
		String id = ParamUtil
				.getString(request, Constantes.NOME_PARAM_ID_TESTE);
		String operacao = ParamUtil.getString(request,
				Constantes.NOME_PARAM_OPERACAO_TESTE);

		List<String> errors = new ArrayList<String>();
		TesteVO testeVO = getTesteVOFromRequest(request, id);

		try {
			if (Constantes.VALOR_PARAM_EXCLUIR_TESTE.equals(operacao)) {
				// Verificar se existem registros filhos cadastradas
				DynamicQuery perguntaQuery = DynamicQueryFactoryUtil
						.forClass(Pergunta.class);
				Criterion criteriaTeste = RestrictionsFactoryUtil.eq(
						"testeId", Long.parseLong(id));
				perguntaQuery.add(criteriaTeste);

				List<Pergunta> registrosFilhos = (List<Pergunta>) PerguntaLocalServiceUtil
						.dynamicQuery(perguntaQuery);
				if (registrosFilhos.size() > 0) {
					errors.add("mensagem.teste.existe.perguntaCadastrada");
					for (String error : errors) {
						SessionErrors.add(request, error);
					}
					response.setRenderParameter(Constantes.NOME_PARAM_ID_TESTE,
							id);
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_EXCLUIR_TESTE);
				} else {
					TesteLocalServiceUtil.deleteTeste(Long.parseLong(id));

					// Salvar objetos na sessão
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_FILTRO_TESTE, null);

					SessionMessages.add(request,
							"mensagem.teste.excluido.sucesso");
				}
			} else {
				if (TesteValidator.validar(testeVO, errors)) {
					if (Constantes.VALOR_PARAM_NOVA_TESTE.equals(operacao)) {
						Teste teste = new TesteImpl();
						teste = getTesteFromTesteVO(testeVO, teste);
						teste.setDataInclusao(new Date());
						teste.setUserIdInclusao(getDadosPortal(request)
								.getRealUser().getUserId());
						teste.setCompanyId(getDadosPortal(request)
								.getCompanyId());
						teste.setGroupId(getDadosPortal(request)
								.getScopeGroupId());
						teste = TesteLocalServiceUtil.addTeste(teste);

						String filtro = "";

						// Salvar objetos na sessão
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_FILTRO_TESTE, filtro);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_TESTE);

						// Salvar objetos no rquest
						response.setRenderParameter(
								Constantes.NOME_PARAM_ID_TESTE,
								String.valueOf(teste.getId()));

						SessionMessages.add(request,
								"mensagem.teste.criado.sucesso");
					} else if (Constantes.VALOR_PARAM_ALTERAR_TESTE
							.equals(operacao)) {
						Teste teste = TesteLocalServiceUtil.getTeste(Long
								.parseLong(id));
						teste = getTesteFromTesteVO(testeVO, teste);
						teste.setDataAlteracao(Helper.getDataAtual().getTime());
						teste.setUserIdAlteracao(getDadosPortal(request)
								.getRealUser().getUserId());
						teste = TesteLocalServiceUtil.updateTeste(teste);

						String filtro = "";

						// Salvar objetos na sessão
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_FILTRO_TESTE, filtro);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_TESTE);

						// Salvar objetos no rquest
						response.setRenderParameter(
								Constantes.NOME_PARAM_ID_TESTE, id);

						SessionMessages.add(request,
								"mensagem.teste.alterado.sucesso");
					}
				} else {
					for (String error : errors) {
						SessionErrors.add(request, error);
					}
					request.setAttribute(Constantes.NOME_PARAM_TESTE_ERROR,
							testeVO);
					response.setRenderParameter(Constantes.NOME_PARAM_ID_TESTE,
							id);
					if (Constantes.VALOR_PARAM_ALTERAR_TESTE.equals(operacao)) {
						response.setRenderParameter(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_TESTE);
					} else {
						response.setRenderParameter(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_NOVA_TESTE);
					}
				}
			}
		} catch (Exception e) {
			errors.add("mensagem.erro.gravar.bancoDados");
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			request.setAttribute(Constantes.NOME_PARAM_TESTE_ERROR, testeVO);
			response.setRenderParameter(Constantes.NOME_PARAM_ID_TESTE, id);
			if (Constantes.VALOR_PARAM_ALTERAR_TESTE.equals(operacao)) {
				response.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_ALTERAR_TESTE);
			} else {
				response.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_NOVA_TESTE);
			}

		}
	}

	private static TesteVO getTesteVOFromTeste(Teste teste) {
		TesteVO testeVO = new TesteVO();

		if (teste != null) {
			testeVO.setId(String.valueOf(teste.getId()));
			testeVO.setTitulo(teste.getTitulo());
			testeVO.setDescricao(teste.getDescricao());
			testeVO.setAtivo(teste.getAtivo() == true ? Constantes.S
					: Constantes.N);
			testeVO.setTituloCorrente(teste.getTituloCurrentValue());
			testeVO
					.setDescricaoCorrente(teste.getDescricaoCurrentValue());
		}
		return testeVO;
	}

	private static TesteVO getTesteVOFromRequest(ActionRequest request, String id) throws Exception {
		TesteVO testeVO = new TesteVO();

		String languageId = LocaleUtil.toLanguageId(LocaleUtil.getDefault());
		String defaultLanguageId = LocaleUtil.toLanguageId(LocaleUtil
				.getDefault());

		String campoTitulo = Constantes.PROP_TESTE_TITULO
				+ StringPool.UNDERLINE + defaultLanguageId;
		String campoDescricao = Constantes.PROP_TESTE_DESCRICAO
				+ StringPool.UNDERLINE + defaultLanguageId;

		testeVO.setId(ParamUtil.getString(request, Constantes.PROP_TESTE_ID));
		testeVO.setTitulo(ParamUtil.getString(request,
				campoTitulo));
		testeVO.setTituloMap(LocalizationUtil.getLocalizationMap(request,
				Constantes.PROP_TESTE_TITULO));
		testeVO.setDescricao(ParamUtil.getString(request,
				campoDescricao));
		testeVO.setDescricaoMap(LocalizationUtil.getLocalizationMap(request,
				Constantes.PROP_TESTE_DESCRICAO));
		testeVO.setAtivo(ParamUtil.getString(request,
				Constantes.PROP_TESTE_ATIVO));

		if (!Constantes.VAZIO.equals(id)) {
			Teste teste = TesteLocalServiceUtil.getTeste(Long
					.valueOf(id));
			String titulo = LocalizationUtil.updateLocalization(
					teste.getTitulo(), Constantes.PROP_TESTE_TITULO,
					testeVO.getTitulo(), languageId, defaultLanguageId);
			String descricao = LocalizationUtil.updateLocalization(
					teste.getDescricao(),
					Constantes.PROP_TESTE_DESCRICAO,
					testeVO.getDescricao(), languageId, defaultLanguageId);
			testeVO.setTitulo(titulo);
			testeVO.setDescricao(descricao);
		}
		
		return testeVO;
	}

	private static Teste getTesteFromTesteVO(TesteVO testeVO, Teste teste) {
		try {
			teste.setTituloMap(testeVO.getTituloMap());
			teste.setDescricaoMap(testeVO.getDescricaoMap());
			teste.setAtivo(Constantes.S.equals(testeVO.getAtivo()));
		} catch (Exception e) {
			e.getMessage();
		}
		return teste;
	}

	private static ThemeDisplay getDadosPortal(ActionRequest request) {
		// Objeto do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		// return themeDisplay.getRealUser().getScreenName();
		return themeDisplay;
	}
	
	private static Map<Long, RespostaVO> recuperarRespostasVO()
			throws Exception {
		Map<Long, RespostaVO> mapRespostas = new LinkedHashMap<Long, RespostaVO>();

		List<Resposta> listaResposta = (List<Resposta>) RespostaAction
				.buscarTodas();
		for (Resposta resposta : listaResposta) {
			RespostaVO respostaVO = new RespostaVO();
			respostaVO
					.setDescricaoCorrente(resposta.getDescricaoCurrentValue());
			respostaVO.setId(String.valueOf(resposta.getId()));
			// Recuperar a pergunta
			PerguntaVO perguntaVO = new PerguntaVO();
			Pergunta pergunta = PerguntaLocalServiceUtil.getPergunta(resposta
					.getPerguntaId());
			if (Validator.isNotNull(pergunta)) {
				perguntaVO.setId(String.valueOf(pergunta.getId()));
				perguntaVO.setDescricaoCorrente(pergunta
						.getDescricaoCurrentValue().replaceAll("\n",
								Constantes.BR));
			}
			respostaVO.setPerguntaVO(perguntaVO);
			mapRespostas.put(Long.valueOf(respostaVO.getId()), respostaVO);
		}

		return mapRespostas;
	}
	

	private static List<PerguntaVO> recuperarPerguntasVO(
			List<Pergunta> listaPerguntas, Map<Long, RespostaVO> mapRespostas)
			throws Exception {
		List<PerguntaVO> lista = new ArrayList<PerguntaVO>(
				listaPerguntas.size());

		for (Pergunta pergunta : listaPerguntas) {
			PerguntaVO perguntaVO = new PerguntaVO();
			perguntaVO.setDescricaoCorrente(pergunta.getDescricaoCurrentValue()
					.replaceAll("\n", Constantes.BR));
			perguntaVO.setId(String.valueOf(pergunta.getId()));

			// Recuperar a resposta
			DynamicQuery respostaQuery = DynamicQueryFactoryUtil
					.forClass(Resposta.class);
			Criterion criteriaPergunta = RestrictionsFactoryUtil.eq(
					Constantes.PERGUNTA_ID, pergunta.getId());
			respostaQuery.add(criteriaPergunta);
			respostaQuery.addOrder(OrderFactoryUtil.asc(Constantes.ID));

			List<Resposta> listaRespostas = (List<Resposta>) RespostaLocalServiceUtil
					.dynamicQuery(respostaQuery);

			if (listaRespostas.size() > 0) {
				List<RespostaVO> listaRespostasVO = new ArrayList<RespostaVO>(
						listaRespostas.size());

				for (Resposta resposta : listaRespostas) {
					if (mapRespostas
							.containsKey(Long.valueOf(resposta.getId()))) {
						RespostaVO respostaVO = (RespostaVO) mapRespostas
								.get(Long.valueOf(resposta.getId()));

						listaRespostasVO.add(respostaVO);
					} else {
						RespostaVO respostaVO = new RespostaVO();
						respostaVO.setId(String.valueOf(resposta.getId()));
						respostaVO.setDescricaoCorrente(resposta
								.getDescricaoCurrentValue());
						listaRespostasVO.add(respostaVO);
					}
				}
				perguntaVO.setRespostas(listaRespostasVO);
			}
			lista.add(perguntaVO);
		}

		return lista;
	}
}