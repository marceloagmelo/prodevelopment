package br.com.prodevelopment.video.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.video.lista.Constantes;
import br.com.prodevelopment.video.vo.VideoVO;

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

	public List<VideoVO> buscarVideosById(String[] ids, RenderRequest request, boolean showDisplayable)
			throws PortalException, SystemException, ParseException {

		HttpServletRequest httpReq = PortalUtil
		.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(request));

		if(Validator.isNull(ids))
			return null;

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		StringBuilder idsBusca = new StringBuilder();

		for(String id : ids)
		{
			idsBusca.append(id + " ");
		}

		long companyId = PortalUtil.getCompanyId(request);

		List<VideoVO> videos = new ArrayList<VideoVO>();

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

			VideoVO video = new VideoVO();

			video.setIdVideo(doc.get(Constantes.ARTICLE_ID));
			video.setTitulo(doc.get(Constantes.TITULO).replace("[", "")
					.replace("]", ""));
			video.setDataAlteracao(DateUtil.getFormatDate(doc.get(Field.MODIFIED_DATE)));

			JournalArticleDisplay artigoDisplay = JournalArticleLocalServiceUtil
			.getArticleDisplay(themeDisplay.getScopeGroupId(),
					video.getIdVideo(), "normal", "",
					themeDisplay);
			video.setExisteImagemPequena(Constantes.N);
			if (artigoDisplay.isSmallImage()) {
				video.setExisteImagemPequena(Constantes.S);
				video.setIdImagemPequena(String.valueOf(artigoDisplay
						.getSmallImageId()));
				video.setUrlImagemPequena(artigoDisplay
						.getSmallImageURL());
			}
			video.setVersao(String.valueOf(artigoDisplay.getVersion()));
			video.setAutor(doc.get(Field.USER_NAME));
			video.setGroupId(String.valueOf(artigoDisplay.getGroupId()));
			video.setDescricao(doc.get(Field.DESCRIPTION));

			video.setUrlVideo(URLUtil.parseToIframe(doc.get(Constantes.URL), httpReq));
			video.setUrlTumb(URLUtil.parseToTumb(doc.get(Constantes.URL)));
			video.setDataCriacao(DateUtil.getFormatDate(doc.get(Field.MODIFIED_DATE)));

			videos.add(video);
		}

		return videos;
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

	public List<VideoVO> buscarVideos(String estrutura,
			String idsCategorias, String order, String tags, int inicio, int fim,
			PortletRequest request)
			throws PortalException, SystemException {

		HttpServletRequest httpReq = PortalUtil
		.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(request));

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

		Sort sort = new Sort(order, true);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		hits = SearchEngineUtil.search(indexer.getSearchEngineId(), companyId,
				new StringQueryImpl(sb.toString()), sort, inicio, fim);

		Document[] docs = hits.getDocs();
		List<VideoVO> videos = new ArrayList<VideoVO>();

		String tamanhoCaracteres = GetterUtil.getString(request
				.getPreferences().getValue(
						Constantes.PREF_TAMANHO_CARACTERES,
						Constantes.DEFAULT_TAMAMHO_CARACTERES));
		if (tamanhoCaracteres == "0") {
			tamanhoCaracteres = Constantes.DEFAULT_TAMAMHO_CARACTERES;
		}

		for (Document doc : docs) {

			VideoVO video = new VideoVO();

			video.setIdVideo(doc.get(Constantes.ARTICLE_ID));
			video.setTitulo(doc.get(Constantes.TITULO).replace("[", "")
					.replace("]", ""));
			video.setDataAlteracao(DateUtil.getFormatDate(doc.get(Field.MODIFIED_DATE)));

			JournalArticleDisplay artigoDisplay = JournalArticleLocalServiceUtil
			.getArticleDisplay(themeDisplay.getScopeGroupId(),
					video.getIdVideo(), "normal", "",
					themeDisplay);
			video.setExisteImagemPequena(Constantes.N);
			if (artigoDisplay.isSmallImage()) {
				video.setExisteImagemPequena(Constantes.S);
				video.setIdImagemPequena(String.valueOf(artigoDisplay
						.getSmallImageId()));
				video.setUrlImagemPequena(artigoDisplay
						.getSmallImageURL());
			}
			video.setVersao(String.valueOf(artigoDisplay.getVersion()));
			video.setAutor(doc.get(Field.USER_NAME));
			video.setGroupId(String.valueOf(artigoDisplay.getGroupId()));
			video.setDescricao(doc.get(Field.DESCRIPTION));

			video.setUrlVideo(URLUtil.parseToIframe(doc.get(Constantes.URL), httpReq));
			video.setUrlTumb(URLUtil.parseToTumb(doc.get(Constantes.URL)));
			video.setDataCriacao(DateUtil.getFormatDate(doc.get(Field.MODIFIED_DATE)));

			videos.add(video);
		}

		return videos;
	}

	public int getTotalVideos(){

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
