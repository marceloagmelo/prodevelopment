package br.com.prodevelopment.pesquisaopiniao.cadastro.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.pesquisaopiniao.Constantes;
import br.com.prodevelopment.pesquisaopiniao.cadastro.validacao.PesquisaValidator;
import br.com.prodevelopment.pesquisaopiniao.model.Pergunta;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;
import br.com.prodevelopment.pesquisaopiniao.model.Resposta;
import br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaImpl;
import br.com.prodevelopment.pesquisaopiniao.service.PerguntaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.PesquisaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.RespostaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.util.Helper;
import br.com.prodevelopment.pesquisaopiniao.vo.PerguntaVO;
import br.com.prodevelopment.pesquisaopiniao.vo.PesquisaVO;
import br.com.prodevelopment.pesquisaopiniao.vo.RespostaVO;

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

public class PesquisaAction {

	public static List<Pesquisa> buscar(RenderRequest req, RenderResponse res,
			ThemeDisplay themeDisplay, String filtro) throws Exception {

		req.getPortletSession().removeAttribute(Constantes.NOME_PARAM_METODO);
		req.getPortletSession().removeAttribute(
				Constantes.NOME_PARAM_FILTRO_PESQUISA);
		req.getPortletSession().removeAttribute(
				Constantes.NOME_PARAM_ID_PESQUISA);

		// Recuperar a companhia e grupo
		long idGroup = themeDisplay.getScopeGroupId();
		long idCompany = themeDisplay.getCompanyId();

		List<String> errors = new ArrayList<String>();
		List<Pesquisa> listaPesquisa = null;
		try {
			// Recuperar pesquisas
			DynamicQuery pesquisaQuery = DynamicQueryFactoryUtil
					.forClass(Pesquisa.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq(
					Constantes.COMPANY_ID, idCompany);
			pesquisaQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq(
					Constantes.GROUP_ID, idGroup);
			pesquisaQuery.add(criteriaGroup);
			if (Validator.isNotNull(filtro)) {
				Criterion criteriaTitulo = RestrictionsFactoryUtil.like(
						Constantes.TITULO, Constantes.PERCENTE + filtro
								+ Constantes.PERCENTE);
				pesquisaQuery.add(criteriaTitulo);
			}
			pesquisaQuery.addOrder(OrderFactoryUtil.asc(Constantes.ID));

			listaPesquisa = (List<Pesquisa>) PesquisaLocalServiceUtil
					.dynamicQuery(pesquisaQuery);
			
		} catch (Exception e) {
			errors.add(Constantes.MSG_ERRO_BANCO_DADOS);
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
		return listaPesquisa;
	}

	public static void prepararNovo(RenderRequest req, RenderResponse res)
			throws Exception {
		// Recupera o objeto de erro se tiver
		PesquisaVO pesquisaError = (PesquisaVO) req
				.getAttribute(Constantes.NOME_PARAM_PESQUISA_ERROR);

		// Inicia a pesquisaVO
		PesquisaVO pesquisaVO = null;
		if (Validator.isNotNull(pesquisaError)) {
			pesquisaVO = pesquisaError;
		} else {
			// Recuperar pesquisaVO com pesquisa
			pesquisaVO = getPesquisaVOFromPesquisa(null);
		}

		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_PESQUISA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_PESQUISA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_PESQUISA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_PESQUISA_URL,
				cancelarURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_PESQUISA,
				Constantes.VALOR_PARAM_NOVA_PESQUISA);
		req.setAttribute(Constantes.NOME_PARAM_TITULO,
				Constantes.VALOR_PARAM_TITULO_PESQUISA_NOVO);

		req.setAttribute(Constantes.NOME_PARAM_PESQUISA_VO, pesquisaVO);
	}

	public static void prepararAlteracao(RenderRequest req, RenderResponse res,
			String id, String metodo) throws Exception {
		// Recupera o objeto de erro se tiver
		PesquisaVO pesquisaError = (PesquisaVO) req
				.getAttribute(Constantes.NOME_PARAM_PESQUISA_ERROR);

		// Recupera pesquisaVO
		PesquisaVO pesquisaVO = (PesquisaVO) req
				.getAttribute(Constantes.NOME_PARAM_PESQUISA_VO);

		Pesquisa pesquisa = null;
		if (Validator.isNotNull(pesquisaError)) {
			pesquisaVO = pesquisaError;
			pesquisa = getPesquisaFromPesquisaVO(pesquisaVO, pesquisa);
		} else {
			// Recuperar a pesquisa
			if (!Constantes.VAZIO.equals(id)) {
				long idPesquisa = Long.parseLong(id);
				pesquisa = PesquisaLocalServiceUtil.getPesquisa(idPesquisa);
				// Recuperar pesquisaVO com pesquisa
				pesquisaVO = getPesquisaVOFromPesquisa(pesquisa);
			} else {
				// Recuperar pesquisaVO com pesquisa
				pesquisaVO = getPesquisaVOFromPesquisa(null);
			}
		}

		// Recuperar perguntas
		List<Pergunta> listaPergunta = PerguntaAction.buscar(req, res, null,
				pesquisaVO.getId());
		req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA, listaPergunta);

		if (Constantes.VALOR_PARAM_VISUALIZAR_PESQUISA.equals(metodo)) {
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
				Constantes.URL_METODO_CONFIRMAR_PESQUISA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_PESQUISA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_PESQUISA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_PESQUISA_URL,
				cancelarURL.toString());

		PortletURL novoURL = res.createActionURL();
		novoURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_PREPARAR_NOVA_PERGUNTA);
		novoURL.setParameter(Constantes.NOME_PARAM_ID_PESQUISA,
				pesquisaVO.getId());
		req.setAttribute(Constantes.NOME_PARAM_NOVA_PERGUNTA_URL,
				novoURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_PESQUISA,
				Constantes.VALOR_PARAM_ALTERAR_PESQUISA);

		req.setAttribute(Constantes.NOME_PARAM_PESQUISA_VO, pesquisaVO);

		req.setAttribute(Constantes.PESQUISA, pesquisa);
	}

	public static void prepararExclusao(RenderRequest req, RenderResponse res,
			String id) throws Exception {
		// Recupera o objeto de erro se tiver
		PesquisaVO pesquisaError = (PesquisaVO) req
				.getAttribute(Constantes.NOME_PARAM_PESQUISA_ERROR);

		// Recupera pesquisaVO
		PesquisaVO pesquisaVO = (PesquisaVO) req
				.getAttribute(Constantes.NOME_PARAM_PESQUISA_VO);

		if (Validator.isNotNull(pesquisaError)) {
			pesquisaVO = pesquisaError;
		} else {
			// Recuperar a pesquisa
			Pesquisa pesquisa = null;
			if (!Constantes.VAZIO.equals(id)) {
				long idPesquisa = Long.parseLong(id);
				pesquisa = PesquisaLocalServiceUtil.getPesquisa(idPesquisa);
				// Recuperar pesquisaVO com pesquisa
				pesquisaVO = getPesquisaVOFromPesquisa(pesquisa);
			} else {
				// Recuperar pesquisaVO com pesquisa
				pesquisaVO = getPesquisaVOFromPesquisa(null);
			}
		}

		// Recuperar perguntas
		List<Pergunta> listaPergunta = PerguntaAction.buscar(req, res, null,
				pesquisaVO.getId());
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
				Constantes.URL_METODO_CONFIRMAR_PESQUISA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_PESQUISA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_PESQUISA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_PESQUISA_URL,
				cancelarURL.toString());
		PortletURL novoURL = res.createActionURL();
		novoURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_PREPARAR_NOVA_PERGUNTA);
		novoURL.setParameter(Constantes.NOME_PARAM_ID_PESQUISA,
				pesquisaVO.getId());
		req.setAttribute(Constantes.NOME_PARAM_NOVA_PERGUNTA_URL,
				novoURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_PESQUISA,
				Constantes.VALOR_PARAM_EXCLUIR_PESQUISA);
		req.setAttribute(Constantes.NOME_PARAM_TITULO,
				Constantes.VALOR_PARAM_TITULO_PESQUISA_EXCLUIR);

		req.setAttribute(Constantes.NOME_PARAM_PESQUISA_VO, pesquisaVO);
	}

	public static void cancelar(ActionRequest req, ActionResponse res)
			throws Exception {
	}

	public static void confirmar(ActionRequest request, ActionResponse response)
			throws Exception {
		String id = ParamUtil.getString(request,
				Constantes.NOME_PARAM_ID_PESQUISA);
		String operacao = ParamUtil.getString(request,
				Constantes.NOME_PARAM_OPERACAO_PESQUISA);

		List<String> errors = new ArrayList<String>();
		PesquisaVO pesquisaVO = getPesquisaVOFromRequest(request, id);

		try {
			if (Constantes.VALOR_PARAM_EXCLUIR_PESQUISA.equals(operacao)) {
				// Verificar se existem registros filhos cadastradas
				DynamicQuery perguntaQuery = DynamicQueryFactoryUtil
						.forClass(Pergunta.class);
				Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq(
						Constantes.PESQUISA_ID, Long.parseLong(id));
				perguntaQuery.add(criteriaPesquisa);

				List<Pergunta> registrosFilhos = (List<Pergunta>) PerguntaLocalServiceUtil
						.dynamicQuery(perguntaQuery);
				if (registrosFilhos.size() > 0) {
					errors.add(Constantes.MSG_EXISTE_PERGUNTA_CADASTRADA);
					for (String error : errors) {
						SessionErrors.add(request, error);
					}
					response.setRenderParameter(
							Constantes.NOME_PARAM_ID_PESQUISA, id);
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_METODO,
							Constantes.VALOR_PARAM_EXCLUIR_PESQUISA);
				} else {
					PesquisaLocalServiceUtil.deletePesquisa(Long.parseLong(id));

					// Salvar objetos na sessão
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
					request.getPortletSession().setAttribute(
							Constantes.NOME_PARAM_FILTRO_PESQUISA, null);

					SessionMessages.add(request,
							Constantes.MSG_PESQUISA_EXCLUIDA_SUCESSO);
				}
			} else {
				if (PesquisaValidator.validar(pesquisaVO, errors)) {
					if (Constantes.VALOR_PARAM_NOVA_PESQUISA.equals(operacao)) {
						Pesquisa pesquisa = new PesquisaImpl();

						pesquisa = getPesquisaFromPesquisaVO(pesquisaVO,
								pesquisa);
						pesquisa.setDataInclusao(Helper.getDataAtual()
								.getTime());
						pesquisa.setUserIdInclusao(getDadosPortal(request)
								.getRealUser().getUserId());
						pesquisa.setCompanyId(getDadosPortal(request)
								.getCompanyId());
						pesquisa.setGroupId(getDadosPortal(request)
								.getScopeGroupId());
						pesquisa = PesquisaLocalServiceUtil
								.addPesquisa(pesquisa);

						String filtro = StringPool.BLANK;

						// Salvar objetos na sessão
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_FILTRO_PESQUISA, filtro);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_PESQUISA);

						// Salvar objetos no rquest
						response.setRenderParameter(
								Constantes.NOME_PARAM_ID_PESQUISA,
								String.valueOf(pesquisa.getId()));

						SessionMessages.add(request,
								Constantes.MSG_PESQUISA_CRIADA_SUCESSO);
					} else if (Constantes.VALOR_PARAM_ALTERAR_PESQUISA
							.equals(operacao)) {
						Pesquisa pesquisa = PesquisaLocalServiceUtil
								.getPesquisa(Long.parseLong(id));
						pesquisa = getPesquisaFromPesquisaVO(pesquisaVO,
								pesquisa);
						pesquisa.setDataAlteracao(Helper.getDataAtual()
								.getTime());
						pesquisa.setUserIdAlteracao(getDadosPortal(request)
								.getRealUser().getUserId());
						pesquisa = PesquisaLocalServiceUtil
								.updatePesquisa(pesquisa);

						String filtro = StringPool.BLANK;

						// Salvar objetos na sessão
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_FILTRO_PESQUISA, filtro);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_PESQUISA);

						// Salvar objetos no rquest
						response.setRenderParameter(
								Constantes.NOME_PARAM_ID_PESQUISA, id);

						SessionMessages.add(request,
								Constantes.MSG_PESQUISA_ALTERADA_SUCESSO);
					}
				} else {
					for (String error : errors) {
						SessionErrors.add(request, error);
					}
					request.setAttribute(Constantes.NOME_PARAM_PESQUISA_ERROR,
							pesquisaVO);
					response.setRenderParameter(
							Constantes.NOME_PARAM_ID_PESQUISA, id);
					if (Constantes.VALOR_PARAM_ALTERAR_PESQUISA
							.equals(operacao)) {
						response.setRenderParameter(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_PESQUISA);
					} else {
						response.setRenderParameter(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_NOVA_PESQUISA);
					}
				}
			}
		} catch (Exception e) {
			errors.add(Constantes.MSG_ERRO_BANCO_DADOS);
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			request.setAttribute(Constantes.NOME_PARAM_PESQUISA_ERROR,
					pesquisaVO);
			response.setRenderParameter(Constantes.NOME_PARAM_ID_PESQUISA, id);
			if (Constantes.VALOR_PARAM_ALTERAR_PESQUISA.equals(operacao)) {
				response.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_ALTERAR_PESQUISA);
			} else {
				response.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_NOVA_PESQUISA);
			}
		}
	}

	private static PesquisaVO getPesquisaVOFromPesquisa(Pesquisa pesquisa) {
		PesquisaVO pesquisaVO = new PesquisaVO();

		if (Validator.isNotNull(pesquisa)) {
			pesquisaVO.setId(String.valueOf(pesquisa.getId()));
			pesquisaVO.setTitulo(pesquisa.getTitulo());
			pesquisaVO.setDescricao(pesquisa.getDescricao());
			pesquisaVO.setAtiva(pesquisa.getAtiva() == true ? Constantes.S
					: Constantes.N);
			pesquisaVO.setTituloCorrente(pesquisa.getTituloCurrentValue());
			pesquisaVO
					.setDescricaoCorrente(pesquisa.getDescricaoCurrentValue());
		}
		return pesquisaVO;
	}

	private static PesquisaVO getPesquisaVOFromRequest(ActionRequest request,
			String id) throws Exception {
		PesquisaVO pesquisaVO = new PesquisaVO();

		String languageId = LocaleUtil.toLanguageId(LocaleUtil.getDefault());
		String defaultLanguageId = LocaleUtil.toLanguageId(LocaleUtil
				.getDefault());

		String campoTitulo = Constantes.PROP_PESQUISA_TITULO
				+ StringPool.UNDERLINE + defaultLanguageId;
		String campoDescricao = Constantes.PROP_PESQUISA_DESCRICAO
				+ StringPool.UNDERLINE + defaultLanguageId;
		pesquisaVO.setId(ParamUtil.getString(request,
				Constantes.PROP_PESQUISA_ID));
		pesquisaVO.setTituloMap(LocalizationUtil.getLocalizationMap(request,
				Constantes.PROP_PESQUISA_TITULO));
		pesquisaVO.setTitulo(ParamUtil.getString(request, campoTitulo));
		pesquisaVO.setDescricaoMap(LocalizationUtil.getLocalizationMap(request,
				Constantes.PROP_PESQUISA_DESCRICAO));
		pesquisaVO.setDescricao(ParamUtil.getString(request, campoDescricao));
		pesquisaVO.setAtiva(ParamUtil.getString(request,
				Constantes.PROP_PESQUISA_ATIVA));

		if (!Constantes.VAZIO.equals(id)) {
			Pesquisa pesquisa = PesquisaLocalServiceUtil.getPesquisa(Long
					.valueOf(id));
			String titulo = LocalizationUtil.updateLocalization(
					pesquisa.getTitulo(), Constantes.PROP_PESQUISA_TITULO,
					pesquisaVO.getTitulo(), languageId, defaultLanguageId);
			String descricao = LocalizationUtil.updateLocalization(
					pesquisa.getDescricao(),
					Constantes.PROP_PESQUISA_DESCRICAO,
					pesquisaVO.getDescricao(), languageId, defaultLanguageId);
			pesquisaVO.setTitulo(titulo);
			pesquisaVO.setDescricao(descricao);
		}

		return pesquisaVO;
	}

	private static Pesquisa getPesquisaFromPesquisaVO(PesquisaVO pesquisaVO,
			Pesquisa pesquisa) {
		try {
			if (pesquisa == null) {
				pesquisa = new PesquisaImpl();
			}
			pesquisa.setTituloMap(pesquisaVO.getTituloMap());
			pesquisa.setDescricaoMap(pesquisaVO.getDescricaoMap());
			pesquisa.setAtiva(Constantes.S.equals(pesquisaVO.getAtiva()));

		} catch (Exception e) {
			e.getMessage();
		}
		return pesquisa;
	}

	private static ThemeDisplay getDadosPortal(ActionRequest request) {
		// Objeto do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

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