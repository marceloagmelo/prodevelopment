package br.com.prodevelopment.testeconhecimento.cadastro.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.testeconhecimento.Constantes;
import br.com.prodevelopment.testeconhecimento.cadastro.validacao.PerguntaValidator;
import br.com.prodevelopment.testeconhecimento.model.Pergunta;
import br.com.prodevelopment.testeconhecimento.model.Resposta;
import br.com.prodevelopment.testeconhecimento.model.Teste;
import br.com.prodevelopment.testeconhecimento.model.impl.PerguntaImpl;
import br.com.prodevelopment.testeconhecimento.service.PerguntaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.RespostaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.TesteLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.util.Helper;
import br.com.prodevelopment.testeconhecimento.vo.PerguntaVO;
import br.com.prodevelopment.testeconhecimento.vo.TesteVO;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class PerguntaAction {

	public static List<Pergunta> buscar(RenderRequest req, RenderResponse res,
			String filtro, String idTeste) throws Exception {

		List<String> errors = new ArrayList<String>();
		List<Pergunta> listaPergunta = null;
		try {
			DynamicQuery perguntaQuery = DynamicQueryFactoryUtil
					.forClass(Pergunta.class);
			Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq("testeId",
					Long.parseLong(idTeste));
			perguntaQuery.add(criteriaPesquisa);
			perguntaQuery.addOrder(OrderFactoryUtil.asc("id"));

			listaPergunta = (List<Pergunta>) PerguntaLocalServiceUtil
					.dynamicQuery(perguntaQuery);
		} catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
		return listaPergunta;
	}

	public static List<Pergunta> buscar(ActionRequest req,	ActionResponse res,
			String filtro, String idTeste) throws Exception {

		List<String> errors = new ArrayList<String>();
		List<Pergunta> listaPergunta = null;
		try {
			DynamicQuery perguntaQuery = DynamicQueryFactoryUtil
					.forClass(Pergunta.class);
			Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq(
					Constantes.TESTE_ID, Long.parseLong(idTeste));
			perguntaQuery.add(criteriaPesquisa);
			perguntaQuery.addOrder(OrderFactoryUtil.asc(Constantes.ID));

			listaPergunta = (List<Pergunta>) PerguntaLocalServiceUtil
					.dynamicQuery(perguntaQuery);
		} catch (Exception e) {
			errors.add(Constantes.MSG_ERRO_BANCO_DADOS);
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
		return listaPergunta;
	}
	
	public static void prepararNovo(RenderRequest req, RenderResponse res, String idTeste)
			throws Exception {
		// Recupera o objeto de erro se tiver
		PerguntaVO perguntaErrorVO = (PerguntaVO) req
				.getAttribute(Constantes.NOME_PARAM_PERGUNTA_ERROR);

		// Inicia a perguntaVO
		PerguntaVO perguntaVO = null;
		if (perguntaErrorVO != null) {
			perguntaVO = perguntaErrorVO;
		} else {
			// Recuperar perguntaVO com pergunta
			perguntaVO = getPerguntaVOFromPergunta(null);
			
			// Recuperar teste
			Teste teste = TesteLocalServiceUtil.getTeste(Long
					.parseLong(idTeste));
			if (Validator.isNotNull(teste)) {
				TesteVO testeVO = new TesteVO();
				testeVO.setId(String.valueOf(teste.getId()));
				testeVO.setDescricao(teste.getDescricao());
				perguntaVO.setTesteVO(testeVO);
			}
		}

		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_PERGUNTA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_PERGUNTA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_PERGUNTA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_PERGUNTA_URL,
				cancelarURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_PERGUNTA,
				Constantes.VALOR_PARAM_NOVA_PERGUNTA);
		req.setAttribute(Constantes.NOME_PARAM_TITULO,
				Constantes.VALOR_PARAM_TITULO_PERGUNTA_NOVO);

		req.setAttribute(Constantes.NOME_PARAM_PERGUNTA_VO, perguntaVO);
	}

	public static void prepararAlteracao(RenderRequest req, RenderResponse res,
			String id) throws Exception {
		// Recupera o objeto de erro se tiver
		PerguntaVO perguntaErrorVO = (PerguntaVO) req
				.getAttribute(Constantes.NOME_PARAM_PERGUNTA_ERROR);

		// Recupera perguntaVO
		PerguntaVO perguntaVO = (PerguntaVO) req
				.getAttribute(Constantes.NOME_PARAM_PERGUNTA_VO);

		if (perguntaErrorVO != null) {
			perguntaVO = perguntaErrorVO;
		} else {
			// Recuperar a pergunta
			Pergunta pergunta = null;
			if (!Constantes.VAZIO.equals(id)) {
				long idPergunta = Long.parseLong(id);
				pergunta = PerguntaLocalServiceUtil.getPergunta(idPergunta);
				// Recuperar perguntaVO com pergunta
				perguntaVO = getPerguntaVOFromPergunta(pergunta);
			} else {
				// Recuperar perguntaVO com pergunta
				perguntaVO = getPerguntaVOFromPergunta(null);
			}
		}

		// Recuperar respostas
		RespostaAction.buscar(req, res, null, perguntaVO.getId());

		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_PERGUNTA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_PERGUNTA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_PERGUNTA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_PERGUNTA_URL,
				cancelarURL.toString());

		PortletURL novoURL = res.createActionURL();
		novoURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_PREPARAR_NOVA_RESPOSTA);
		novoURL.setParameter(Constantes.NOME_PARAM_ID_PERGUNTA,
				perguntaVO.getId());
		novoURL.setParameter(Constantes.NOME_PARAM_ID_TESTE, perguntaVO
				.getTesteVO().getId());
		req.setAttribute(Constantes.NOME_PARAM_NOVA_RESPOSTA_URL,
				novoURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_PERGUNTA,
				Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);

		req.setAttribute(Constantes.NOME_PARAM_PERGUNTA_VO, perguntaVO);
	}

	public static void prepararExclusao(RenderRequest req, RenderResponse res,
			String id) throws Exception {
		// Recupera o objeto de erro se tiver
		PerguntaVO perguntaErrorVO = (PerguntaVO) req
				.getAttribute(Constantes.NOME_PARAM_PERGUNTA_ERROR);

		// Recupera perguntaVO
		PerguntaVO perguntaVO = (PerguntaVO) req
				.getAttribute(Constantes.NOME_PARAM_PERGUNTA_VO);

		if (perguntaErrorVO != null) {
			perguntaVO = perguntaErrorVO;
		} else {
			// Recuperar a pergunta
			Pergunta pergunta = null;
			if (!Constantes.VAZIO.equals(id)) {
				long idPergunta = Long.parseLong(id);
				pergunta = PerguntaLocalServiceUtil.getPergunta(idPergunta);
				// Recuperar perguntaVO com pergunta
				perguntaVO = getPerguntaVOFromPergunta(pergunta);
			} else {
				// Recuperar perguntaVO com pergunta
				perguntaVO = getPerguntaVOFromPergunta(null);
			}
		}

		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_PERGUNTA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_PERGUNTA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_PERGUNTA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_PERGUNTA_URL,
				cancelarURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_PERGUNTA,
				Constantes.VALOR_PARAM_EXCLUIR_PERGUNTA);
		req.setAttribute(Constantes.NOME_PARAM_TITULO,
				Constantes.VALOR_PARAM_TITULO_PERGUNTA_EXCLUIR);

		req.setAttribute(Constantes.NOME_PARAM_PERGUNTA_VO, perguntaVO);
	}

	public static void confirmar(ActionRequest request, ActionResponse response)
			throws Exception {
		String id = ParamUtil.getString(request,
				Constantes.NOME_PARAM_ID_PERGUNTA);
		String idTeste = ParamUtil.getString(request,
				Constantes.NOME_PARAM_ID_TESTE);
		String operacao = ParamUtil.getString(request,
				Constantes.NOME_PARAM_OPERACAO_PERGUNTA);

		List<String> errors = new ArrayList<String>();
		PerguntaVO perguntaVO = getPerguntaVOFromRequest(request, id, idTeste);

		try {
			if (Constantes.VALOR_PARAM_EXCLUIR_PERGUNTA.equals(operacao)) {

				// Verificar se existem registros filhos cadastradas
				DynamicQuery respostaQuery = DynamicQueryFactoryUtil
						.forClass(Resposta.class);
				Criterion criteriaPergunta = RestrictionsFactoryUtil.eq(
						"perguntaId", Long.parseLong(id));
				respostaQuery.add(criteriaPergunta);

				List<Resposta> registrosFilhos = (List<Resposta>) RespostaLocalServiceUtil
						.dynamicQuery(respostaQuery);
				if (registrosFilhos.size() > 0) {
					errors.add("mensagem.pergunta.existe.respostaCadastrada");
					for (String error : errors) {
						SessionErrors.add(request, error);
					}

					// Salvar objetos na sessão
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_EXCLUIR_PERGUNTA);
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_ID_PERGUNTA, id);
				} else {
					PerguntaLocalServiceUtil.deletePergunta(Long.parseLong(id));

					// Salvar objetos na sessão
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_ALTERAR_TESTE);
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_FILTRO_PERGUNTA, null);
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_ID_PERGUNTA, id);

					SessionMessages.add(request,
							"mensagem.pergunta.excluida.sucesso");
				}
			} else {
				if (PerguntaValidator.validar(perguntaVO, errors)) {
					if (Constantes.VALOR_PARAM_NOVA_PERGUNTA.equals(operacao)) {
						Pergunta pergunta = new PerguntaImpl();
						pergunta = getPerguntaFromPerguntaVO(perguntaVO,
								pergunta);
						pergunta.setDataInclusao(Helper.getDataAtual()
								.getTime());
						pergunta.setUserIdInclusao(getDadosPortal(request)
								.getRealUser().getUserId());
						pergunta.setTesteId(Long.parseLong(idTeste));
						pergunta = PerguntaLocalServiceUtil
								.addPergunta(pergunta);

						String filtro = "";

						// Salvar objetos na sessão
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_FILTRO_PERGUNTA, filtro);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_ID_PERGUNTA,
								String.valueOf(pergunta.getId()));

						SessionMessages.add(request,
								"mensagem.pergunta.criada.sucesso");
					} else if (Constantes.VALOR_PARAM_ALTERAR_PERGUNTA
							.equals(operacao)) {
						Pergunta pergunta = PerguntaLocalServiceUtil
								.getPergunta(Long.parseLong(id));
						pergunta = getPerguntaFromPerguntaVO(perguntaVO,
								pergunta);
						pergunta.setDataAlteracao(Helper.getDataAtual()
								.getTime());
						pergunta.setUserIdAlteracao(getDadosPortal(request)
								.getRealUser().getUserId());
						pergunta = PerguntaLocalServiceUtil
								.updatePergunta(pergunta);

						String filtro = "";

						// Salvar objetos na sessão
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_FILTRO_PERGUNTA, filtro);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_ID_PERGUNTA, id);

						SessionMessages.add(request,
								"mensagem.pergunta.alterada.sucesso");
					}
				} else {
					for (String error : errors) {
						SessionErrors.add(request, error);
					}
					request.setAttribute(Constantes.NOME_PARAM_PERGUNTA_ERROR,
							perguntaVO);
					response.setRenderParameter(
							Constantes.NOME_PARAM_ID_PERGUNTA, id);
					if (Constantes.VALOR_PARAM_ALTERAR_PERGUNTA
							.equals(operacao)) {
						response.setRenderParameter(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);
					} else {
						response.setRenderParameter(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_NOVA_PERGUNTA);
					}
				}
			}
		} catch (Exception e) {
			errors.add("mensagem.erro.gravar.bancoDados");
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			request.setAttribute(Constantes.NOME_PARAM_PERGUNTA_ERROR,
					perguntaVO);
			response.setRenderParameter(Constantes.NOME_PARAM_ID_PERGUNTA, id);
			if (Constantes.VALOR_PARAM_ALTERAR_PERGUNTA.equals(operacao)) {
				response.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);
			} else {
				response.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_NOVA_PERGUNTA);
			}
		}
	}

	private static PerguntaVO getPerguntaVOFromPergunta(Pergunta pergunta) {
		PerguntaVO perguntaVO = new PerguntaVO();

		if (pergunta != null) {
			perguntaVO.setId(String.valueOf(pergunta.getId()));
			perguntaVO.setDescricao(pergunta.getDescricao());
			perguntaVO
					.setDescricaoCorrente(pergunta.getDescricaoCurrentValue());
			perguntaVO.setJustificativaResposta(pergunta
					.getJustificativaResposta());
			perguntaVO.setJustificativaRespostaCorrente(pergunta
					.getJustificativaRespostaCurrentValue());
			perguntaVO.setPontuacao(String.valueOf(pergunta.getPontuacao()));
			TesteVO pesquisaVO = new TesteVO();
			pesquisaVO.setId(String.valueOf(pergunta.getTesteId()));
			perguntaVO.setTesteVO(pesquisaVO);
		}

		return perguntaVO;
	}

	private static PerguntaVO getPerguntaVOFromRequest(ActionRequest request,
			String id, String idTeste) throws Exception {
		PerguntaVO perguntaVO = new PerguntaVO();

		String languageId = LocaleUtil.toLanguageId(LocaleUtil.getDefault());
		String defaultLanguageId = LocaleUtil.toLanguageId(LocaleUtil
				.getDefault());

		String campoDescricao = Constantes.PROP_PERGUNTA_DESCRICAO
				+ StringPool.UNDERLINE + defaultLanguageId;

		perguntaVO.setId(ParamUtil.getString(request,
				Constantes.PROP_PERGUNTA_ID));
		perguntaVO.setDescricao(ParamUtil.getString(request,
				campoDescricao));
		perguntaVO.setDescricaoMap(LocalizationUtil.getLocalizationMap(request,
				Constantes.PROP_PERGUNTA_DESCRICAO));
		perguntaVO.setJustificativaResposta(ParamUtil.getString(request,
				Constantes.PROP_PERGUNTA_JUSTIFICATIVA_RESPOSTA));
		perguntaVO.setJustificativaRespostaMap(LocalizationUtil
				.getLocalizationMap(request,
						Constantes.PROP_PERGUNTA_JUSTIFICATIVA_RESPOSTA));
		perguntaVO.setPontuacao(ParamUtil.getString(request,
				Constantes.PROP_PERGUNTA_PONTUACAO));

		TesteVO testeVO = new TesteVO();
		testeVO.setId(String.valueOf(idTeste));
		perguntaVO.setTesteVO(testeVO);

		if (!Constantes.VAZIO.equals(id)) {
			Pergunta pergunta = PerguntaLocalServiceUtil.getPergunta(Long
					.valueOf(id));
			String descricao = LocalizationUtil.updateLocalization(
					pergunta.getDescricao(),
					Constantes.PROP_PERGUNTA_DESCRICAO,
					perguntaVO.getDescricao(), languageId, defaultLanguageId);
			perguntaVO.setDescricao(descricao);
		}

		return perguntaVO;
	}

	private static Pergunta getPerguntaFromPerguntaVO(PerguntaVO perguntaVO,
			Pergunta pergunta) {
		try {
			pergunta.setDescricaoMap(perguntaVO.getDescricaoMap());
			pergunta.setJustificativaRespostaMap(perguntaVO
					.getJustificativaRespostaMap());
			pergunta.setPontuacao(GetterUtil.getDouble(perguntaVO
					.getPontuacao()));
		} catch (Exception e) {
			e.getMessage();
		}
		return pergunta;
	}

	private static ThemeDisplay getDadosPortal(ActionRequest request) {
		// Objeto do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		// return themeDisplay.getRealUser().getScreenName();
		return themeDisplay;
	}

	public static List<Pergunta> recuperarListaPorTeste(long idTeste)
			throws Exception {

		DynamicQuery perguntaQuery = DynamicQueryFactoryUtil
				.forClass(Pergunta.class);
		Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq("testeId",
				idTeste);
		perguntaQuery.add(criteriaPesquisa);
		perguntaQuery.addOrder(OrderFactoryUtil.asc("id"));

		List<Pergunta> lista = (List<Pergunta>) PerguntaLocalServiceUtil
				.dynamicQuery(perguntaQuery);

		return lista;
	}

	public static Pergunta recuperarPergunta(long id) {
		Pergunta pergunta = new PerguntaImpl();
		try {
			// Localiza pergunta
			pergunta = PerguntaLocalServiceUtil.getPergunta(id);
		} catch (Exception e) {
			e.getMessage();
		}
		return pergunta;
	}
}