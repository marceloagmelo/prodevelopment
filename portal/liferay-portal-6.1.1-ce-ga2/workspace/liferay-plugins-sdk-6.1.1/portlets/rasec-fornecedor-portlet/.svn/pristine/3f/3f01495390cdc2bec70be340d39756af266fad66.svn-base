package br.com.rasecmadeiras.fornecedor.lista.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.rasecmadeiras.fornecedor.lista.Constantes;
import br.com.rasecmadeiras.fornecedor.util.Helper;
import br.com.rasecmadeiras.fornecedor.util.Search;
import br.com.rasecmadeiras.fornecedor.vo.FornecedorVO;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FornecedorListaPortlet
 */
public class FornecedorListaPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(renderRequest));

			String categoria = ParamUtil.getString(renderRequest,
					Constantes.NOME_PARAM_CATEGORIA);
			if (Validator.isNull(categoria)) {
				categoria = httpReq
						.getParameter(Constantes.NOME_PARAM_CATEGORIA);
			}
			String tag = ParamUtil.getString(renderRequest,
					Constantes.NOME_PARAM_TAG);
			if (Validator.isNull(tag)) {
				tag = httpReq.getParameter(Constantes.NOME_PARAM_TAG);
			}
			String estrutura = ParamUtil.getString(renderRequest,
					Constantes.NOME_PARAM_ESTRUTURA);
			if (Validator.isNull(estrutura)) {
				estrutura = httpReq
						.getParameter(Constantes.NOME_PARAM_ESTRUTURA);
			}
			String portletTitulo = ParamUtil.getString(renderRequest,
					Constantes.NOME_PARAM_TITULO_PORTLET);
			if (Validator.isNull(portletTitulo)) {
				portletTitulo = httpReq
						.getParameter(Constantes.NOME_PARAM_TITULO_PORTLET);
			}

			String page = httpReq.getParameter("page");
			if (page == null || page.isEmpty()) {
				jogandoParametrosNaSessao(httpReq);
			} else {
				HttpSession sessao = httpReq.getSession();

				categoria = (String) sessao
						.getAttribute(Constantes.NOME_SESSAO_CATEGORIA);
				estrutura = (String) sessao
						.getAttribute(Constantes.NOME_SESSAO_ESTRUTURA);
				tag = (String) sessao.getAttribute(Constantes.NOME_SESSAO_TAG);
				portletTitulo = (String) sessao
						.getAttribute(Constantes.NOME_SESSAO_TITULO_PORTLET);
			}

			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);
			String prefPaginacao = prefs.getValue(Constantes.PREF_PAGINACAO,
					Constantes.N);
			String prefExibirTitulo = prefs.getValue(
					Constantes.PREF_EXIBIR_TITULO, Constantes.N);

			if (Constantes.S.equals(prefConfigurado)) {
				String sPagina = ParamUtil.getString(renderRequest,
						Constantes.NOME_PARAM_PAGINA);
				String metodo = ParamUtil.getString(renderRequest,
						Constantes.NOME_PARAM_METODO);
				String chave = ParamUtil.getString(renderRequest,
						Constantes.NOME_PARAM_CHAVE);
				if (Validator.isNull(chave)) {
					chave = httpReq.getParameter(Constantes.NOME_PARAM_CHAVE);
					if (Validator.isNull(chave)) {
						chave = (String) renderRequest.getPortletSession()
								.getAttribute(Constantes.NOME_PARAM_CHAVE);
					}
				}

				PortletURL voltarURL = renderResponse.createRenderURL();
				if (Validator.isNotNull(chave)) {
					voltarURL.setParameter(Constantes.NOME_PARAM_CHAVE, chave);
				}

				int pagina = getPagina(sPagina);

				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

				if ((Validator.isNull(metodo))
						|| (Constantes.URL_METODO_ANTERIOR.equals(metodo))
						|| (Constantes.URL_METODO_PROXIMO.equals(metodo))) {
					// Recuperar preferências do portlet
					if (Validator.isNull(categoria)) {
						categoria = prefs.getValue(Constantes.PREF_CATEGORIA,
								Constantes.VAZIO);
					}
					if (Validator.isNull(estrutura)) {
						estrutura = prefs.getValue(Constantes.PREF_ESTRUTURA,
								Constantes.VAZIO);

					}
					if (Validator.isNull(tag)) {
						tag = prefs.getValue(Constantes.PREF_TAG,
								Constantes.VAZIO);
					}

					int paginaTamanho = GetterUtil.getInteger(renderRequest
							.getPreferences().getValue(
									Constantes.PREF_QTDE_REGISTROS,
									Constantes.DEFAULT_QTDE_REGISTROS));
					if (paginaTamanho == 0) {
						paginaTamanho = Integer
								.parseInt(Constantes.DEFAULT_QTDE_REGISTROS);
					}

					String tamanhoCaracteres = GetterUtil
							.getString(renderRequest.getPreferences().getValue(
									Constantes.PREF_TAMANHO_CARACTERES,
									Constantes.DEFAULT_TAMAMHO_CARACTERES));
					if (tamanhoCaracteres == "0") {
						tamanhoCaracteres = Constantes.DEFAULT_TAMAMHO_CARACTERES;
					}

					pagina = Search.getPage(httpReq);
					int inicioPag = (pagina * paginaTamanho) - paginaTamanho;
					int fimPag = inicioPag + paginaTamanho;

					Search busca = new Search();

					List<FornecedorVO> fornecedores = busca.buscar(estrutura, categoria, Field.MODIFIED_DATE, tag, inicioPag, fimPag, renderRequest);

					renderRequest.setAttribute(
							Constantes.NOME_PARAM_TOTAL_REGISTROS,
							busca.getTotalFornecedores());
					renderRequest.setAttribute(Constantes.NOME_PARAM_PAGINACAO,
							prefPaginacao);
					renderRequest.setAttribute(Constantes.FORNECEDORES,
							fornecedores);
					renderRequest.setAttribute(Constantes.NOME_PARAM_PAGINA,
							pagina);
					renderRequest
							.setAttribute(Constantes.TOTAL, busca.getTotalFornecedores());
					renderRequest.setAttribute("page", pagina);
					renderRequest.setAttribute("pageSize", paginaTamanho);
					renderRequest.setAttribute(Constantes.NOME_PARAM_METODO,
							metodo);
					renderRequest.setAttribute(Constantes.NOME_PARAM_CHAVE,
							chave);
					renderRequest.setAttribute(Constantes.NOME_PARAM_CATEGORIA,
							categoria);
					renderRequest.setAttribute(Constantes.NOME_PARAM_TAG, tag);
					renderRequest.setAttribute(Constantes.NOME_PARAM_ESTRUTURA,
							estrutura);
					renderRequest.setAttribute(Constantes.NOME_PARAM_EXIBIR_TITULO,
							prefExibirTitulo);

					if (Validator.isNull(portletTitulo)) {
						portletTitulo = Helper.getTituloPortlet(renderRequest, renderResponse, themeDisplay);
					}
					renderRequest
							.setAttribute(Constantes.NOME_PARAM_TITULO_PORTLET,
									portletTitulo);

					if (busca.getTotalFornecedores() == 0) {
						SessionMessages.add(renderRequest,
								"mensagem.registros.naoEncontrados");
					}

				}
				super.render(renderRequest, renderResponse);
			} else {
				SessionMessages.add(renderRequest,
						"mensagem.portletNaoConfigurado");
				include(naoConfiguradoJSP, renderRequest, renderResponse);

			}
		} catch (Exception e) {
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

	private int getPagina(String pagina) {
		// representa a página a ser exibida
		int page = 1;

		if (Validator.isNotNull(pagina)) {
			page = Integer.valueOf(pagina);
		}

		return page;
	}

	@ProcessAction(name = "proximo")
	public void proximo(ActionRequest request, ActionResponse response)
			throws Exception {
		String pagina = ParamUtil.getString(request,
				Constantes.NOME_PARAM_PAGINA);
		String chave = ParamUtil
				.getString(request, Constantes.NOME_PARAM_CHAVE);

		response.setRenderParameter(Constantes.NOME_PARAM_PAGINA, pagina);
		response.setRenderParameter(Constantes.NOME_PARAM_CHAVE, chave);
		response.setRenderParameter(Constantes.NOME_PARAM_METODO,
				Constantes.URL_METODO_PROXIMO);
	}

	@ProcessAction(name = "anterior")
	public void anterior(ActionRequest request, ActionResponse response)
			throws Exception {
		String pagina = ParamUtil.getString(request,
				Constantes.NOME_PARAM_PAGINA);
		String chave = ParamUtil
				.getString(request, Constantes.NOME_PARAM_CHAVE);

		response.setRenderParameter(Constantes.NOME_PARAM_PAGINA, pagina);
		response.setRenderParameter(Constantes.NOME_PARAM_CHAVE, chave);
		response.setRenderParameter(Constantes.NOME_PARAM_METODO,
				Constantes.URL_METODO_ANTERIOR);
	}

	private void jogandoParametrosNaSessao(HttpServletRequest httpReq) {

		String categoria = httpReq
				.getParameter(Constantes.NOME_PARAM_CATEGORIA);
		String tag = httpReq.getParameter(Constantes.NOME_PARAM_TAG);
		String estrutura = httpReq
				.getParameter(Constantes.NOME_PARAM_ESTRUTURA);

		HttpSession sessao = httpReq.getSession();

		sessao.setAttribute(Constantes.NOME_SESSAO_CATEGORIA, categoria);
		sessao.setAttribute(Constantes.NOME_SESSAO_TAG, tag);
		sessao.setAttribute(Constantes.NOME_SESSAO_ESTRUTURA, estrutura);
	}
}