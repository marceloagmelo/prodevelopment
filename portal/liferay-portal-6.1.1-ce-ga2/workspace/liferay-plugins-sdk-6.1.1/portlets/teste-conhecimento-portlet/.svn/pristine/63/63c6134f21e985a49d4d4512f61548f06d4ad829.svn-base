package br.com.prodevelopment.testeconhecimento.cadastro.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.testeconhecimento.Constantes;
import br.com.prodevelopment.testeconhecimento.cadastro.validacao.RespostaValidator;
import br.com.prodevelopment.testeconhecimento.model.Resposta;
import br.com.prodevelopment.testeconhecimento.model.impl.RespostaImpl;
import br.com.prodevelopment.testeconhecimento.service.RespostaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.util.Helper;
import br.com.prodevelopment.testeconhecimento.vo.RespostaVO;

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

public class RespostaAction {

	public static void buscar(RenderRequest req, RenderResponse res,
			String filtro, String idPergunta) throws Exception {

		List<String> errors = new ArrayList<String>();
		try {
			DynamicQuery respostaQuery = DynamicQueryFactoryUtil
					.forClass(Resposta.class);
			Criterion criteriaPergunta = RestrictionsFactoryUtil.eq(
					"perguntaId", Long.parseLong(idPergunta));
			respostaQuery.add(criteriaPergunta);
			respostaQuery.addOrder(OrderFactoryUtil.asc("id"));

			List<Resposta> listaResposta = (List<Resposta>) RespostaLocalServiceUtil
					.dynamicQuery(respostaQuery);
			req.setAttribute(Constantes.NOME_PARAM_LISTA_RESPOSTA,
					listaResposta);
		} catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	public static void prepararNovo(RenderRequest req, RenderResponse res)
			throws Exception {
		// Recupera o objeto de erro se tiver
		RespostaVO respostaErrorVO = (RespostaVO) req
				.getAttribute(Constantes.NOME_PARAM_RESPOSTA_ERROR);

		// Inicia a respostaVO
		RespostaVO respostaVO = null;
		if (respostaErrorVO != null) {
			respostaVO = respostaErrorVO;
		} else {
			// Recuperar respostaVO com resposta
			respostaVO = getRespostaVOFromResposta(null);
		}

		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_RESPOSTA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_RESPOSTA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_RESPOSTA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_RESPOSTA_URL,
				cancelarURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_RESPOSTA,
				Constantes.VALOR_PARAM_NOVA_RESPOSTA);
		req.setAttribute(Constantes.NOME_PARAM_TITULO,
				Constantes.VALOR_PARAM_TITULO_RESPOSTA_NOVO);

		req.setAttribute(Constantes.NOME_PARAM_RESPOSTA_VO, respostaVO);
	}

	public static void prepararAlteracao(RenderRequest req, RenderResponse res,
			String id) throws Exception {
		// Recupera o objeto de erro se tiver
		RespostaVO respostaErrorVO = (RespostaVO) req
				.getAttribute(Constantes.NOME_PARAM_RESPOSTA_ERROR);

		// Recupera respostaVO
		RespostaVO respostaVO = (RespostaVO) req
				.getAttribute(Constantes.NOME_PARAM_RESPOSTA_VO);

		if (Validator.isNotNull(respostaErrorVO)) {
			respostaVO = respostaErrorVO;
		} else {
			// Recuperar a resposta
			Resposta resposta = null;
			if (!Constantes.VAZIO.equals(id)) {
				long idResposta = Long.parseLong(id);
				resposta = RespostaLocalServiceUtil.getResposta(idResposta);
				// Recuperar respostaVO com resposta
				respostaVO = getRespostaVOFromResposta(resposta);
			} else {
				// Recuperar respostaVO com resposta
				respostaVO = getRespostaVOFromResposta(null);
			}
		}

		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_RESPOSTA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_RESPOSTA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_RESPOSTA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_RESPOSTA_URL,
				cancelarURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_RESPOSTA,
				Constantes.VALOR_PARAM_ALTERAR_RESPOSTA);

		req.setAttribute(Constantes.NOME_PARAM_RESPOSTA_VO, respostaVO);
	}

	public static void prepararExclusao(RenderRequest req, RenderResponse res,
			String id) throws Exception {
		// Recupera o objeto de erro se tiver
		RespostaVO respostaErrorVO = (RespostaVO) req
				.getAttribute(Constantes.NOME_PARAM_RESPOSTA_ERROR);

		// Recupera respostaVO
		RespostaVO respostaVO = (RespostaVO) req
				.getAttribute(Constantes.NOME_PARAM_RESPOSTA_VO);

		if (Validator.isNotNull(respostaErrorVO)) {
			respostaVO = respostaErrorVO;
		} else {
			// Recuperar a resposta
			Resposta resposta = null;
			if (!Constantes.VAZIO.equals(id)) {
				long idResposta = Long.parseLong(id);
				resposta = RespostaLocalServiceUtil.getResposta(idResposta);
				// Recuperar respostaVO com resposta
				respostaVO = getRespostaVOFromResposta(resposta);
			} else {
				// Recuperar respostaVO com resposta
				respostaVO = getRespostaVOFromResposta(null);
			}
		}

		PortletURL confirmarURL = res.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR_RESPOSTA);
		req.setAttribute(Constantes.NOME_PARAM_CONFIRMAR_RESPOSTA_URL,
				confirmarURL.toString());
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CANCELAR_RESPOSTA);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_RESPOSTA_URL,
				cancelarURL.toString());

		req.setAttribute(Constantes.NOME_PARAM_OPERACAO_RESPOSTA,
				Constantes.VALOR_PARAM_EXCLUIR_RESPOSTA);
		req.setAttribute(Constantes.NOME_PARAM_TITULO,
				Constantes.VALOR_PARAM_TITULO_RESPOSTA_EXCLUIR);

		req.setAttribute(Constantes.NOME_PARAM_RESPOSTA_VO, respostaVO);
	}

	public static void confirmar(ActionRequest request, ActionResponse response)
			throws Exception {
		String id = ParamUtil.getString(request,
				Constantes.NOME_PARAM_ID_RESPOSTA);
		String idPergunta = ParamUtil.getString(request,
				Constantes.NOME_PARAM_ID_PERGUNTA);
		String operacao = ParamUtil.getString(request,
				Constantes.NOME_PARAM_OPERACAO_RESPOSTA);

		List<String> errors = new ArrayList<String>();
		RespostaVO respostaVO = getRespostaVOFromRequest(request, id);

		try {
			if (Constantes.VALOR_PARAM_EXCLUIR_RESPOSTA.equals(operacao)) {
				RespostaLocalServiceUtil.deleteResposta(Long.parseLong(id));

				// Salvar objetos na sessão
				request.getPortletSession().setAttribute(
						Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);
				request.getPortletSession().setAttribute(
						Constantes.NOME_PARAM_FILTRO_RESPOSTA, null);

				SessionMessages.add(request,
						"mensagem.resposta.excluida.sucesso");
			} else {
				if (RespostaValidator.validar(respostaVO, errors)) {
					if (Constantes.VALOR_PARAM_NOVA_RESPOSTA.equals(operacao)) {
						Resposta resposta = new RespostaImpl();
						resposta = getRespostaFromRespostaVO(respostaVO,
								resposta);
						resposta.setDataInclusao(Helper.getDataAtual()
								.getTime());
						resposta.setUserIdInclusao(getDadosPortal(request)
								.getRealUser().getUserId());
						resposta.setPerguntaId(Long.parseLong(idPergunta));
						resposta = RespostaLocalServiceUtil
								.addResposta(resposta);

						String filtro = "";

						// Salvar objetos na sessão
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_FILTRO_RESPOSTA, filtro);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);

						// Salvar objetos no rquest
						response.setRenderParameter(
								Constantes.NOME_PARAM_ID_RESPOSTA,
								String.valueOf(resposta.getId()));
						response.setRenderParameter(
								Constantes.NOME_PARAM_ID_PERGUNTA,
								String.valueOf(idPergunta));

						SessionMessages.add(request,
								"mensagem.resposta.criada.sucesso");
					} else if (Constantes.VALOR_PARAM_ALTERAR_RESPOSTA
							.equals(operacao)) {
						Resposta resposta = RespostaLocalServiceUtil
								.getResposta(Long.parseLong(id));
						resposta = getRespostaFromRespostaVO(respostaVO,
								resposta);
						resposta.setDataAlteracao(Helper.getDataAtual()
								.getTime());
						resposta.setUserIdAlteracao(getDadosPortal(request)
								.getRealUser().getUserId());
						resposta = RespostaLocalServiceUtil
								.updateResposta(resposta);

						String filtro = "";

						// Salvar objetos na sessão
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_FILTRO_RESPOSTA, filtro);
						request.getPortletSession().setAttribute(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_PERGUNTA);

						// Salvar objetos no rquest
						response.setRenderParameter(
								Constantes.NOME_PARAM_ID_RESPOSTA, id);
						response.setRenderParameter(
								Constantes.NOME_PARAM_ID_PERGUNTA,
								String.valueOf(idPergunta));

						SessionMessages.add(request,
								"mensagem.resposta.alterada.sucesso");
					}
				} else {
					for (String error : errors) {
						SessionErrors.add(request, error);
					}
					request.setAttribute(Constantes.NOME_PARAM_RESPOSTA_ERROR,
							respostaVO);
					response.setRenderParameter(
							Constantes.NOME_PARAM_ID_RESPOSTA, id);
					if (Constantes.VALOR_PARAM_ALTERAR_RESPOSTA
							.equals(operacao)) {
						response.setRenderParameter(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_ALTERAR_RESPOSTA);
					} else {
						response.setRenderParameter(
								Constantes.NOME_PARAM_METODO,
								Constantes.VALOR_PARAM_NOVA_RESPOSTA);
					}
				}
			}
		} catch (Exception e) {
			errors.add("mensagem.erro.gravar.bancoDados");
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			request.setAttribute(Constantes.NOME_PARAM_RESPOSTA_ERROR,
					respostaVO);
			response.setRenderParameter(Constantes.NOME_PARAM_ID_RESPOSTA, id);
			if (Constantes.VALOR_PARAM_ALTERAR_RESPOSTA.equals(operacao)) {
				response.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_ALTERAR_RESPOSTA);
			} else {
				response.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_NOVA_RESPOSTA);
			}
		}
	}

	private static RespostaVO getRespostaVOFromResposta(Resposta resposta) {
		RespostaVO respostaVO = new RespostaVO();

		if (resposta != null) {
			respostaVO.setId(String.valueOf(resposta.getId()));
			respostaVO.setDescricao(resposta.getDescricao());
			respostaVO
					.setDescricaoCorrente(resposta.getDescricaoCurrentValue());
			respostaVO.setCorreta(resposta.getCorreta() ? Constantes.S
					: Constantes.N);
		}

		return respostaVO;
	}

	private static RespostaVO getRespostaVOFromRequest(ActionRequest request, String id) throws Exception {
		RespostaVO respostaVO = new RespostaVO();

		String languageId = LocaleUtil.toLanguageId(LocaleUtil.getDefault());
		String defaultLanguageId = LocaleUtil.toLanguageId(LocaleUtil
				.getDefault());

		String campoDescricao = Constantes.PROP_RESPOSTA_DESCRICAO
				+ StringPool.UNDERLINE + defaultLanguageId;

		respostaVO.setId(ParamUtil.getString(request,
				Constantes.PROP_RESPOSTA_ID));
		respostaVO.setDescricao(ParamUtil.getString(request,
				campoDescricao));
		respostaVO.setDescricaoMap(LocalizationUtil.getLocalizationMap(request,
				Constantes.PROP_RESPOSTA_DESCRICAO));
		respostaVO.setCorreta(ParamUtil.getString(request,
				Constantes.PROP_RESPOSTA_CORRETA));

		if (!Constantes.VAZIO.equals(id)) {
			Resposta resposta = RespostaLocalServiceUtil.getResposta(Long
					.valueOf(id));
			String descricao = LocalizationUtil.updateLocalization(
					resposta.getDescricao(),
					Constantes.PROP_RESPOSTA_DESCRICAO,
					respostaVO.getDescricao(), languageId, defaultLanguageId);
			respostaVO.setDescricao(descricao);
		}

		return respostaVO;
	}

	private static Resposta getRespostaFromRespostaVO(RespostaVO respostaVO,
			Resposta resposta) {
		try {
			
			if (resposta == null) {
				resposta = new RespostaImpl();
			}
			resposta.setDescricaoMap(respostaVO.getDescricaoMap());
			resposta.setCorreta(Constantes.S.equals(respostaVO.getCorreta()) ? Boolean.TRUE
					: Boolean.FALSE);
		} catch (Exception e) {
			e.getMessage();
		}
		return resposta;
	}

	private static ThemeDisplay getDadosPortal(ActionRequest request) {
		// Objeto do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		// return themeDisplay.getRealUser().getScreenName();
		return themeDisplay;
	}

	public static Resposta recuperarResposta(long id) {
		Resposta resposta = new RespostaImpl();
		try {
			// Localiza resposta
			resposta = RespostaLocalServiceUtil.getResposta(id);
		} catch (Exception e) {
			e.getMessage();
		}
		return resposta;
	}

	public static List<Resposta> buscarTodas() throws Exception {

		List<Resposta> listaResposta = null;
		try {
			DynamicQuery respostaQuery = DynamicQueryFactoryUtil
					.forClass(Resposta.class);
			respostaQuery.addOrder(OrderFactoryUtil.asc(Constantes.ID));

			listaResposta = (List<Resposta>) RespostaLocalServiceUtil
					.dynamicQuery(respostaQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaResposta;
	}
}
