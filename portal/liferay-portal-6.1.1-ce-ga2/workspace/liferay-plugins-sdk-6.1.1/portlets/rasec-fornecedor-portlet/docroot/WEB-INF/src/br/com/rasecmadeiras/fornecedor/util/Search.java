package br.com.rasecmadeiras.fornecedor.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.rasecmadeiras.fornecedor.destaque.Constantes;
import br.com.rasecmadeiras.fornecedor.vo.FornecedorVO;

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
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class Search {

	private Hits hits;

	public List<FornecedorVO> buscarById(String ids[], RenderRequest request, boolean showDisplayable)
			throws PortalException, SystemException {

		if(Validator.isNull(ids))
			return null;

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		StringBuilder idsBusca = new StringBuilder();

		for(String id : ids)
		{
			idsBusca.append(id + " ");
		}

		long companyId = PortalUtil.getCompanyId(request);

		List<FornecedorVO> fornecedores = new ArrayList<FornecedorVO>();

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

			if(!showDisplayable && !isDisplayableArt(doc.get(Constantes.ARTICLE_ID), themeDisplay.getScopeGroupId(), new Date())) {
				continue;
			}

			FornecedorVO fornecedor = new FornecedorVO();
			fornecedor.setId(doc.get(Constantes.ARTICLE_ID));
			fornecedor.setTitulo(doc.get(Constantes.TITULO).replace("[", "")
					.replace("]", ""));
			fornecedor.setUrlExterna(doc.get(Constantes.URL_EXTERNA).replace("[", "")
					.replace("]", ""));
			fornecedor.setDataAlteracao(DateUtil.getFormatDate(doc.get(Field.MODIFIED_DATE)));
			fornecedor.setDescricao(Helper.trataTextoLongo(
					doc.get(Field.DESCRIPTION), Integer.valueOf(tamanhoCaracteres)));

			JournalArticleDisplay artigoDisplay = JournalArticleLocalServiceUtil
			.getArticleDisplay(themeDisplay.getScopeGroupId(),
					fornecedor.getId(), "normal", "",
					themeDisplay);
			fornecedor.setExisteImagemPequena(Constantes.N);
			if (artigoDisplay.isSmallImage()) {
				fornecedor.setExisteImagemPequena(Constantes.S);
				fornecedor.setIdImagemPequena(String.valueOf(artigoDisplay
						.getSmallImageId()));
				fornecedor.setUrlImagemPequena(artigoDisplay
						.getSmallImageURL());
			}

			fornecedores.add(fornecedor);
		}

		return fornecedores;
	}

	private boolean isDisplayableArt(String contentId, long groupId, Date now) {

		Date displayDate = null;
		JournalArticle ja = null;
        boolean isDisplayable = true;

        if(Validator.isNull(contentId)) {
        	return false;
        }

        try {
			ja = JournalArticleLocalServiceUtil.getArticle(groupId, contentId);
			displayDate = ja.getDisplayDate();

		} catch (Exception e) {
			e.printStackTrace();
		}

        if(displayDate != null){
        	isDisplayable = displayDate.compareTo(now) > 0 ? false : true;
        }

        return isDisplayable;
    }

	public List<FornecedorVO> buscar(String estrutura,
			String idsCategorias, String order, String tags, int inicio, int fim,
			PortletRequest request)
			throws PortalException, SystemException {

		HttpServletRequest httpReq = PortalUtil
		.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(request));

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

		Sort sort = new Sort(order, true);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		hits = SearchEngineUtil.search(indexer.getSearchEngineId(), companyId,
				new StringQueryImpl(sb.toString()), sort, inicio, fim);

		String tamanhoCaracteres = GetterUtil.getString(request
				.getPreferences().getValue(
						Constantes.PREF_TAMANHO_CARACTERES,
						Constantes.DEFAULT_TAMAMHO_CARACTERES));
		if (tamanhoCaracteres == "0") {
			tamanhoCaracteres = Constantes.DEFAULT_TAMAMHO_CARACTERES;
		}

		Document[] docs = hits.getDocs();
		List<FornecedorVO> fornecedores = new ArrayList<FornecedorVO>();

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		for (Document doc : docs) {

			FornecedorVO fornecedor = new FornecedorVO();
			fornecedor.setId(doc.get(Constantes.ARTICLE_ID));
			fornecedor.setTitulo(doc.get(Constantes.TITULO).replace("[", "")
					.replace("]", ""));
			fornecedor.setUrlExterna(doc.get(Constantes.URL_EXTERNA).replace("[", "")
					.replace("]", ""));
			fornecedor.setDataAlteracao(DateUtil.getFormatDate(doc.get(Field.MODIFIED_DATE)));

			JournalArticleDisplay artigoDisplay = JournalArticleLocalServiceUtil
			.getArticleDisplay(themeDisplay.getScopeGroupId(),
					fornecedor.getId(), "normal", "",
					themeDisplay);
			fornecedor.setExisteImagemPequena(Constantes.N);
			if (artigoDisplay.isSmallImage()) {
				fornecedor.setExisteImagemPequena(Constantes.S);
				fornecedor.setIdImagemPequena(String.valueOf(artigoDisplay
						.getSmallImageId()));
				fornecedor.setUrlImagemPequena(artigoDisplay
						.getSmallImageURL());
			}
			fornecedor.setVersao(String.valueOf(artigoDisplay.getVersion()));
			fornecedor.setAutor(doc.get(Field.USER_NAME));
			fornecedor.setGroupId(String.valueOf(artigoDisplay.getGroupId()));
			fornecedor.setDescricao(doc.get(Field.DESCRIPTION));

			fornecedores.add(fornecedor);
		}

		return fornecedores;
	}

	public int getTotalFornecedores() {

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
