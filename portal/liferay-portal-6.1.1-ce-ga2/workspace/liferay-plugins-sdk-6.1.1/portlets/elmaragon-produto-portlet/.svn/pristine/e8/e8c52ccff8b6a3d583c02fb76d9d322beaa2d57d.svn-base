package br.com.elmaragon.produto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.elmaragon.produto.lista.Constantes;
import br.com.elmaragon.produto.vo.ProdutoVO;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.StringQueryImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class Search {

	private Hits hits;
	private SimpleDateFormat format;

	public Search() {
		format = new SimpleDateFormat("yyyyMMddHHmmss");
	}

	public List<ProdutoVO> buscarProdutosById(String[] ids, RenderRequest request, boolean showDisplayable)
			throws PortalException, SystemException, ParseException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		if(Validator.isNull(ids))
			return null;


		StringBuilder idsBusca = new StringBuilder();

		for(String id : ids)
		{
			idsBusca.append(id + " ");
		}

		long companyId = PortalUtil.getCompanyId(request);

		List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();

		StringBuilder sb = new StringBuilder();

		sb.append(" +" + Constantes.ARTICLE_ID + ":");
		sb.append("(");
		sb.append(idsBusca.toString());
		sb.append(")");
		sb.append(" +"+Field.ENTRY_CLASS_NAME + ":com.liferay.portlet.journal.model.JournalArticle");
		sb.append(" +"+Field.APPROVED+":true");
		sb.append(" +"+Field.EXPIRED+":false");

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		hits = SearchEngineUtil.search(indexer.getSearchEngineId(), companyId,
				new StringQueryImpl(sb.toString()), QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		Document[] docs = hits.getDocs();

		String tamanhoCaracteres = GetterUtil.getString(request
				.getPreferences().getValue(
						Constantes.PREF_TAMANHO_CARACTERES,
						Constantes.DEFAULT_TAMAMHO_CARACTERES));
		if (tamanhoCaracteres == "0") {
			tamanhoCaracteres = Constantes.DEFAULT_TAMAMHO_CARACTERES;
		}


		for (Document doc : docs) {

			String dateString = doc.get(Field.MODIFIED_DATE);
			Date displayDate = null;

			if(Validator.isNotNull(dateString)) {
				displayDate = format.parse(dateString);
			}

			if(!showDisplayable && !isDisplayableArt(displayDate, new Date())) {
				continue;
			}

			ProdutoVO produto = new ProdutoVO();

			produto.setId(doc.get(Constantes.ARTICLE_ID));
			produto.setTitulo(doc.get(Constantes.TITULO).replace("[", "")
					.replace("]", ""));
			produto.setDescricao(Helper.trataTextoLongo(
					doc.get(Field.DESCRIPTION), Integer.valueOf(tamanhoCaracteres)));
			produto.setDescricao(doc.get(Field.DESCRIPTION));
			produto.setDataAlteracao(DateUtil.getFormatDate(doc.get(Field.MODIFIED_DATE)));
			produto.setPreco(doc.get(Constantes.PRECO).replace("[", "")
					.replace("]", ""));
			produto.setUnidade(doc.get(Constantes.UNIDADE).replace("[", "")
					.replace("]", ""));
			
			JournalArticleDisplay artigoDisplay = JournalArticleLocalServiceUtil
			.getArticleDisplay(themeDisplay.getScopeGroupId(),
					produto.getId(), "normal", "",
					themeDisplay);
			produto.setExisteImagemPequena(Constantes.N);
			if (artigoDisplay.isSmallImage()) {
				produto.setExisteImagemPequena(Constantes.S);
				produto.setIdImagemPequena(String.valueOf(artigoDisplay
						.getSmallImageId()));
				produto.setUrlImagemPequena(ImageUtil.getURLImage(doc, themeDisplay));
			}

			produtos.add(produto);
		}

		return produtos;
	}

	private boolean isDisplayableArt(Date articleDate, Date now) {

        boolean isDisplayable = true;

        if(Validator.isNull(articleDate)) {
        	return false;
        }


        if(articleDate != null){
        	isDisplayable = articleDate.compareTo(now) > 0 ? false : true;
        }

        return isDisplayable;
    }

	public List<ProdutoVO> buscarProdutos(String estrutura,
			String idsCategorias, String order, String tags, int inicio, int fim,
			PortletRequest request, String urlDestino)
			throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		StringBuilder sb = new StringBuilder();

		// groupId
		sb.append(" +" + Field.GROUP_ID + ":");
		sb.append(PortalUtil.getScopeGroupId(request));

		// categorias
		if (idsCategorias != null && !idsCategorias.isEmpty()) {

			idsCategorias = idsCategorias.replace(",", " ");

			sb.append(" +" + Field.ASSET_CATEGORY_IDS + ":");
			sb.append("(");
			sb.append(idsCategorias);
			sb.append(")");
		}

		// tags
		if (tags != null && !tags.isEmpty()) {

			tags = tags.replace(",", " ");

			sb.append(" +" + Field.ASSET_TAG_NAMES + ":");
			sb.append("(");
			sb.append(tags);
			sb.append(")");
		}

		// estrutura
		if (estrutura != null && !estrutura.isEmpty()) {
			sb.append(" +" + Constantes.STRUCTURE_ID + ":");
			sb.append(estrutura);
		}
		sb.append(" +" + Field.ENTRY_CLASS_NAME
				+ ":com.liferay.portlet.journal.model.JournalArticle");

		//outros campos
		sb.append(" +"+Field.APPROVED+":true");
		sb.append(" +"+Field.EXPIRED+":false");

		long companyId = PortalUtil.getCompanyId(request);

		if(Validator.isNull(order)) {
			order = Field.MODIFIED_DATE;
		}

		Sort sort = new Sort(order, false);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		hits = SearchEngineUtil.search(indexer.getSearchEngineId(), companyId,
				new StringQueryImpl(sb.toString()), sort, inicio, fim);

		Document[] docs = hits.getDocs();
		List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();

		for (Document doc : docs) {

			ProdutoVO produto = new ProdutoVO();

			produto.setId(doc.get(Constantes.ARTICLE_ID));
			produto.setTitulo(doc.get(Constantes.TITULO).replace("[", "")
					.replace("]", ""));
			produto.setDescricao(doc.get(Field.DESCRIPTION));
			produto.setDataAlteracao(DateUtil.getFormatDate(doc.get(Field.MODIFIED_DATE)));
			produto.setUrl(urlDestino);
			produto.setPreco(doc.get(Constantes.PRECO).replace("[", "")
					.replace("]", ""));
			produto.setUnidade(doc.get(Constantes.UNIDADE).replace("[", "")
					.replace("]", ""));
			
			JournalArticleDisplay artigoDisplay = JournalArticleLocalServiceUtil
			.getArticleDisplay(themeDisplay.getScopeGroupId(),
					produto.getId(), "normal", "",
					themeDisplay);
			produto.setExisteImagemPequena(Constantes.N);
			if (artigoDisplay.isSmallImage()) {
				produto.setExisteImagemPequena(Constantes.S);
				produto.setIdImagemPequena(String.valueOf(artigoDisplay
						.getSmallImageId()));
				produto.setUrlImagemPequena(ImageUtil.getURLImage(doc, themeDisplay));
			}
			produto.setGroupId(String.valueOf(artigoDisplay
					.getGroupId()));
			produto
					.setVersao(String.valueOf(artigoDisplay.getVersion()));

			produtos.add(produto);
		}

		return produtos;
	}

	public int getTotal(){

		return hits.getLength();
	}


	public static int getPage(HttpServletRequest httpReq) {
		int page = 1;

		if (httpReq.getParameter("page") != null
				&& !"".equals(httpReq.getParameter("page"))) {
			page = Integer.valueOf(httpReq.getParameter("page"));
		}

		return page;
	}
}
