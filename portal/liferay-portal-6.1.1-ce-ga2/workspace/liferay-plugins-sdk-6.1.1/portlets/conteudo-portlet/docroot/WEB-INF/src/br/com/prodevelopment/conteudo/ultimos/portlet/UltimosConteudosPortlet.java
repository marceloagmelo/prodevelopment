package br.com.prodevelopment.conteudo.ultimos.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.conteudo.ultimos.Constantes;
import br.com.prodevelopment.conteudo.util.AssetCategoryUtil;
import br.com.prodevelopment.conteudo.util.DateUtil;
import br.com.prodevelopment.conteudo.util.Helper;
import br.com.prodevelopment.conteudo.util.Search;
import br.com.prodevelopment.conteudo.vo.ConteudoVO;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UltimosConteudosPortlet
 */
public class UltimosConteudosPortlet extends MVCPortlet {
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
			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);
			String prefExibirTitulo = prefs.getValue(
					Constantes.PREF_EXIBIR_TITULO, Constantes.N);

			if (Constantes.S.equals(prefConfigurado)) {

				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
						.getAttribute(WebKeys.THEME_DISPLAY);

				long groupId = themeDisplay.getScopeGroup().getGroupId();

				// Recuperar preferências do portlet
				String prefTipo = prefs.getValue(Constantes.PREF_TIPO,
						Constantes.VAZIO);
				String prefTag = prefs.getValue(Constantes.PREF_TAG,
						Constantes.VAZIO);
				String prefCategoria = prefs.getValue(
						Constantes.PREF_CATEGORIA, Constantes.VAZIO);
				String prefEstrutura = prefs.getValue(
						Constantes.PREF_ESTRUTURA, Constantes.VAZIO);
				String prefUrlDestino = prefs.getValue(
						Constantes.PREF_URL_DESTINO, Constantes.VAZIO);
				String prefUrlVerTodos = prefs.getValue(
						Constantes.PREF_URL_VER_TODOS, Constantes.VAZIO);

				int paginaTamanho = GetterUtil.getInteger(renderRequest
						.getPreferences().getValue(
								Constantes.PREF_QTDE_REGISTROS,
								Constantes.DEFAULT_QTDE_REGISTROS));
				if (paginaTamanho == 0) {

					paginaTamanho = Integer
							.parseInt(Constantes.DEFAULT_QTDE_REGISTROS);

				}

				String tamanhoCaracteres = GetterUtil.getString(renderRequest
						.getPreferences().getValue(
								Constantes.PREF_TAMANHO_CARACTERES,
								Constantes.DEFAULT_TAMAMHO_CARACTERES));
				if (tamanhoCaracteres == "0") {
					tamanhoCaracteres = Constantes.DEFAULT_TAMAMHO_CARACTERES;
				}

				// realizando a busca
				Hits hits = Search.busca(groupId, null, prefTipo,
						prefEstrutura, prefCategoria, prefTag,
						Integer.valueOf(Constantes.ZERO), paginaTamanho, null);

				Document docs[] = hits.getDocs();

				List<ConteudoVO> listaConteudos = new ArrayList<ConteudoVO>();

				int totalRegistros = hits != null ? hits.getLength() : 0;

				for (Document doc : docs) {
					ConteudoVO conteudoVO = new ConteudoVO();

					conteudoVO.setId(doc.get("articleId"));
					conteudoVO.setUrl(doc.get(Field.URL));
					conteudoVO.setDescricao(Helper.trataTextoLongo(
							doc.get(Field.DESCRIPTION), Integer.valueOf(tamanhoCaracteres)).replace("[", "").replace("]", ""));
					conteudoVO.setTitulo(doc.get(Constantes.TITULO).replace("[", "")
							.replace("]", ""));
					if (Validator.isNull(conteudoVO.getTitulo())) {
						conteudoVO.setTitulo(doc.get(Field.TITLE).replace("[", "").replace("]", ""));
					}
					conteudoVO.setCategorias(AssetCategoryUtil.getNameById(doc
							.get(Field.ASSET_CATEGORY_IDS)));

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
										artigo.getArticleId(), "normal", "",
										themeDisplay);
						conteudoVO.setConteudo(artigoDisplay.getContent());

						if (Validator.isNull(conteudoVO.getTitulo())) {
							conteudoVO.setTitulo(artigoDisplay.getTitle());
						}
						if (Validator.isNull(conteudoVO.getDescricao())) {
							conteudoVO.setDescricao(artigoDisplay.getDescription());
						}
					} catch (Exception e) {
						e.getMessage();
					}

					conteudoVO.setUrl(artigo.getUrlTitle());
					conteudoVO.setDataAlteracao(DateUtil
							.dateToStringWithHour(artigo.getModifiedDate()));
					conteudoVO.setAutor(artigo.getUserName());
					conteudoVO.setExisteImagemPequena(Constantes.N);
					if (artigo.isSmallImage()) {
						conteudoVO.setExisteImagemPequena(Constantes.S);
						conteudoVO.setIdImagemPequena(String.valueOf(artigo
								.getSmallImageId()));
						conteudoVO.setUrlImagemPequena(artigo
								.getSmallImageURL());
					}

					listaConteudos.add(conteudoVO);
				}

				renderRequest.setAttribute(
						Constantes.NOME_PARAM_TOTAL_REGISTROS, totalRegistros);
				renderRequest.setAttribute(Constantes.LISTA_CONTEUDOS,
						listaConteudos);
				renderRequest.setAttribute(Constantes.PREF_URL_DESTINO,
						prefUrlDestino);
				renderRequest.setAttribute(Constantes.PREF_URL_VER_TODOS,
						prefUrlVerTodos);
				renderRequest.setAttribute(Constantes.PARAM_TAG, prefTag);
				renderRequest.setAttribute(Constantes.PARAM_CATEGORIA,
						prefCategoria);
				renderRequest.setAttribute(Constantes.PARAM_ESTRUTURA,
						prefEstrutura);
				renderRequest.setAttribute(Constantes.NOME_PARAM_EXIBIR_TITULO,
						prefExibirTitulo);
				String portletTitulo = Helper.getTituloPortlet(renderRequest, renderResponse, themeDisplay);
				renderRequest
						.setAttribute(Constantes.NOME_PARAM_TITULO_PORTLET,
								portletTitulo);

				if (totalRegistros == 0) {
					SessionMessages.add(renderRequest,
							"mensagem.registros.naoEncontrados");
				}

				super.render(renderRequest, renderResponse);
			} else {
				SessionMessages.add(renderRequest,
						"mensagem.portletNaoConfigurado");
				include(naoConfiguradoJSP, renderRequest, renderResponse);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
