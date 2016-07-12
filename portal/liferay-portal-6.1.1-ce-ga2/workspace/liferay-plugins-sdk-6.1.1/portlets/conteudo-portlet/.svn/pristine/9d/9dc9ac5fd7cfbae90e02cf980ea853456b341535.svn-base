package br.com.prodevelopment.conteudo.lista.portlet;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.prodevelopment.conteudo.lista.Constantes;
import br.com.prodevelopment.conteudo.util.DateUtil;
import br.com.prodevelopment.conteudo.util.Helper;
import br.com.prodevelopment.conteudo.util.Search;
import br.com.prodevelopment.conteudo.vo.ConteudoVO;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ListaConteudoPortlet
 */
public class ListaConteudoPortlet extends MVCPortlet {

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
				tag = (String) sessao.getAttribute(Constantes.NOME_SESSAO_TAG);
				estrutura = (String) sessao
						.getAttribute(Constantes.NOME_SESSAO_ESTRUTURA);
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
			String prefOrdenacao = prefs.getValue(
					Constantes.PREF_ORDENACAO, Constantes.VAZIO);
			String prefExibir = prefs.getValue(
					Constantes.PREF_EXIBIR, Constantes.VAZIO);

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

				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
						.getAttribute(WebKeys.THEME_DISPLAY);

				long groupId = themeDisplay.getScopeGroup().getGroupId();

				int pagina = getPagina(sPagina);

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

					String prefUrlDestino = prefs.getValue(
							Constantes.PREF_URL_DESTINO, Constantes.VAZIO);

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

					Hits hits = Search.busca(groupId, chave, null,
							estrutura, categoria, tag, inicioPag, fimPag, prefOrdenacao);

					List<ConteudoVO> listaConteudos = new ArrayList<ConteudoVO>();

					int totalRegistros = hits != null ? hits.getLength() : 0;

					for (int i = 0; hits != null && hits.getDocs() != null
							&& i < hits.getDocs().length; i++) {

						Document doc = hits.getDocs()[i];

						ConteudoVO conteudoVO = new ConteudoVO();
						conteudoVO.setId(doc.get("articleId"));
						conteudoVO.setUrl(doc.get(Field.URL));
						
						conteudoVO.setTitulo(doc.get(Constantes.TITULO)
								.replace("[", "").replace("]", ""));
						if (Validator.isNull(conteudoVO.getTitulo())) {
							conteudoVO.setTitulo(doc.get(Constantes.NOME)
									.replace("[", "").replace("]", ""));
							if (Validator.isNull(conteudoVO.getTitulo())) {
								conteudoVO.setTitulo(doc.get(Field.TITLE).replace("[", "")
										.replace("]", ""));
							}
						}
		                JournalArticle artigo = JournalArticleLocalServiceUtil.getLatestArticle(
								groupId, conteudoVO.getId(), WorkflowConstants.STATUS_APPROVED);

						AssetEntry assetEntry = AssetEntryLocalServiceUtil
								.getEntry(JournalArticle.class.getName(),
										artigo.getResourcePrimKey());
						conteudoVO.setAssetEntryId(String.valueOf(assetEntry
								.getEntryId()));

						try {
							JournalArticleDisplay artigoDisplay = JournalArticleLocalServiceUtil
									.getArticleDisplay(groupId,
											artigo.getArticleId(), "normal",
											"", themeDisplay);
							conteudoVO.setConteudo(artigoDisplay.getContent());
							if (Constantes.CONTEUDO.equals(prefExibir)) {
								conteudoVO.setDescricao(artigoDisplay.getContent());
							}
							conteudoVO.setDescricao(Helper.trataTextoLongo(
									artigoDisplay.getDescription(),
									GetterUtil.getInteger(tamanhoCaracteres)));
						} catch (Exception e) {
							e.getMessage();
						}

						conteudoVO.setUrl(artigo.getUrlTitle());
						conteudoVO
								.setDataAlteracao(DateUtil
										.dateToString(artigo
												.getModifiedDate()));
						conteudoVO.setAutor(artigo.getUserName());
						conteudoVO.setExisteImagemPequena(Constantes.N);
						if (artigo.isSmallImage()) {
							conteudoVO.setExisteImagemPequena(Constantes.S);
							conteudoVO.setIdImagemPequena(String.valueOf(artigo
									.getSmallImageId()));
							conteudoVO.setUrlImagemPequena(artigo
									.getSmallImageURL());
						}
						conteudoVO.setGroupId(String.valueOf(artigo
								.getGroupId()));
						conteudoVO
								.setVersao(String.valueOf(artigo.getVersion()));

						listaConteudos.add(conteudoVO);
					}

					renderRequest.setAttribute(
							Constantes.NOME_PARAM_TOTAL_REGISTROS,
							totalRegistros);
					renderRequest.setAttribute(Constantes.NOME_PARAM_PAGINACAO,
							prefPaginacao);
					renderRequest.setAttribute(
							Constantes.NOME_PARAM_EXIBIR_TITULO,
							prefExibirTitulo);
					renderRequest.setAttribute(Constantes.LISTA_CONTEUDOS,
							listaConteudos);
					renderRequest.setAttribute(Constantes.NOME_PARAM_PAGINA,
							pagina);
					renderRequest
							.setAttribute(Constantes.TOTAL, totalRegistros);
					renderRequest.setAttribute(Constantes.LISTA_CONTEUDOS,
							listaConteudos);
					renderRequest.setAttribute("page", pagina);
					renderRequest.setAttribute("pageSize", paginaTamanho);
					renderRequest.setAttribute(Constantes.NOME_PARAM_METODO,
							metodo);
					renderRequest.setAttribute(Constantes.PREF_URL_DESTINO,
							prefUrlDestino);
					renderRequest.setAttribute(Constantes.NOME_PARAM_CHAVE,
							chave);
					renderRequest.setAttribute(Constantes.NOME_PARAM_CATEGORIA,
							categoria);
					renderRequest.setAttribute(Constantes.NOME_PARAM_TAG, tag);
					renderRequest.setAttribute(Constantes.NOME_PARAM_ESTRUTURA,
							estrutura);
					renderRequest.setAttribute(Constantes.GROUP_ID,
							groupId);
					if (Validator.isNull(portletTitulo)) {
						portletTitulo = Helper.getTituloPortlet(renderRequest, renderResponse, themeDisplay);
					}
					renderRequest
							.setAttribute(Constantes.NOME_PARAM_TITULO_PORTLET,
									portletTitulo);

					if (totalRegistros == 0) {
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
			e.getMessage();
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
