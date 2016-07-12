package br.com.elmaragon.busca.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.elmaragon.busca.resultado.Constantes;
import br.com.elmaragon.busca.resultado.vo.ResultadoVO;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class Search {

	public List<ResultadoVO> realizaBusca(PortletRequest request,
			String termosBusca, String categoria,
			String ordenacao, boolean direcao, int inicio, int fim, String tipoConteudo) throws PortalException,
			SystemException {

		HttpServletRequest httpReq = PortalUtil
		.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(request));

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		if (termosBusca == null || termosBusca.isEmpty()) {
			return null;
		}

		StringBuilder paginaDestino = new StringBuilder();

		termosBusca = termosBusca.toLowerCase();

		StringBuilder sb = new StringBuilder();

		// categoria
		if (Validator.isNotNull(categoria)) {
			sb.append(" +" + Field.ASSET_CATEGORY_IDS + ":");
			sb.append(categoria);
		}
		sb.append(" +" + Field.ENTRY_CLASS_NAME
				+ ":com.liferay.portlet.journal.model.JournalArticle");
		// outros campos
		sb.append(" +" + Field.APPROVED + ":true");
		sb.append(" +" + Field.EXPIRED + ":false");

		// conteudo
		String[] palavras = null;
		String asterisco = "";

		// remontando o termoBusca
		palavras = new String[] { termosBusca };
		asterisco = "";
		palavras = StringUtil.split(termosBusca, " ");

		// verificando a estrutura que sera utilizada na busca
		PortletPreferences preferences = request.getPreferences();

		String paginaDestinoProduto = preferences.getValue(
				Constantes.PREF_PAGINA_DESTINO_PRODUTO, "");
		String paginaDestinoOutro = preferences.getValue(
				Constantes.PREF_PAGINA_DESTINO_OUTRO, "");

		if (tipoConteudo == null
				|| tipoConteudo.equals(Constantes.TIPO_CONTEUDO_OUTROS)) {
			// ----- outros -----
			tipoConteudo = Constantes.TIPO_CONTEUDO_OUTROS;
			paginaDestino.append(paginaDestinoOutro);
		} else if (tipoConteudo.equals(Constantes.TIPO_CONTEUDO_PRODUTO)) {
			// ----- produto -----
			paginaDestino.append(paginaDestinoProduto);
		}
		
		sb.append(" +(");
		for (String palavra : palavras) {
			sb.append(Field.ASSET_TAG_NAMES);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Field.TITLE);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Field.CONTENT);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Field.DESCRIPTION);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");
		}
		sb.append(")");

		String query = sb.toString();

		// retirando o ultimo OR
		query = query.replace("OR )", ")");

		long companyId = PortalUtil.getCompanyId(request);
		Sort sort = new Sort(ordenacao, direcao);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);

		Hits hits = SearchEngineUtil.search(indexer.getSearchEngineId(), companyId, new StringQueryImpl(query), sort, inicio, fim);	
		
		Document[] docs = hits.getDocs();

		List<ResultadoVO> resultados = new ArrayList<ResultadoVO>();

		for (Document doc : docs) {

			ResultadoVO resultado = new ResultadoVO();

			resultado.setIdConteudo(doc.get(Field.ARTICLE_ID));

            JournalArticle artigo = JournalArticleLocalServiceUtil.getLatestArticle(
            		themeDisplay.getScopeGroup().getGroupId(), resultado.getIdConteudo(), WorkflowConstants.STATUS_APPROVED);
            
			resultado.setTitulo(doc.get(Constantes.TITULO).replace("[", "")
					.replace("]", ""));
			if (Validator.isNull(resultado.getTitulo())) {
				resultado.setTitulo(doc.get(Field.TITLE).replace("[", "").replace("]", ""));
			}
			resultado.setDescricao(doc.get(Constantes.DESCRICAO).replace("[", "")
					.replace("]", ""));
			if (Validator.isNull(resultado.getDescricao())) {
				resultado.setDescricao(doc.get(Field.DESCRIPTION).replace("[", "").replace("]", ""));
			}
			resultado.setDescricao(StringUtil.highlight(resultado.getDescricao(), palavras));

			resultado.setCategorias(AssetCategoryUtil.getNameById(doc
					.get(Field.ASSET_CATEGORY_IDS)));
			resultado.setDataCriacao(DateUtil.getFormatDate(doc
					.get(Field.MODIFIED_DATE)));
			resultado.setTagsNames(doc.get(Field.ASSET_TAG_NAMES));
			resultado.setEstrutura(artigo.getStructureId());
			resultado.setUrlPagina(URLUtil.getURLsById(
					resultado.getIdConteudo(), themeDisplay));
			Group comunidade = null;

			comunidade= GroupLocalServiceUtil.getGroup(GetterUtil.getLong(doc.get(Field.GROUP_ID)));

			resultado.setGroupFriendlyURL(comunidade.getFriendlyURL());

			StringBuilder paginaDestinoParametro = new StringBuilder();

			paginaDestinoParametro.append("?");
			paginaDestinoParametro.append(Constantes.NOME_PARAM_ID);
			paginaDestinoParametro.append("=");
			paginaDestinoParametro.append(resultado.getIdConteudo());
			/*
			paginaDestinoParametro.append("&");
			paginaDestinoParametro.append(Constantes.NOME_PARAM_CATEGORIA);
			paginaDestinoParametro.append("=");
			paginaDestinoParametro.append(doc.get(Field.ASSET_CATEGORY_IDS));
			paginaDestinoParametro.append("&");
			paginaDestinoParametro.append(Constantes.NOME_PARAM_TERMO_BUSCA);
			paginaDestinoParametro.append("=");
			paginaDestinoParametro.append(termosBusca);
			*/

			resultado.setPaginaDestino("/web"+resultado.getGroupFriendlyURL()+paginaDestino.toString().trim()+paginaDestinoParametro.toString());

			resultados.add(resultado);
		}

		return resultados;
	}

	public  int getTotalConteudos(PortletRequest request,
			String termosBusca, String categoria,
			String ordenacao, boolean direcao, int inicio, int fim, String tipoConteudo) throws PortalException,
			SystemException {

		if (termosBusca == null || termosBusca.isEmpty()) {
			return 0;
		}

		termosBusca = termosBusca.toLowerCase();

		StringBuilder sb = new StringBuilder();

		// categoria
		if (Validator.isNotNull(categoria)) {
			sb.append(" +" + Field.ASSET_CATEGORY_IDS + ":");
			sb.append(categoria);
		}
		sb.append(" +" + Field.ENTRY_CLASS_NAME
				+ ":com.liferay.portlet.journal.model.JournalArticle");
		// outros campos
		sb.append(" +" + Field.APPROVED + ":true");
		sb.append(" +" + Field.EXPIRED + ":false");

		// conteudo
		sb.append(" +(");
		String[] palavras = null;
		String asterisco = "";

		// remontando o termoBusca
		palavras = new String[] { termosBusca };
		asterisco = "";
		//palavras = StringUtil.split(termosBusca, " ");

		for (String palavra : palavras) {
			sb.append(Field.ASSET_TAG_NAMES);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Field.TITLE);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Field.CONTENT);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Field.DESCRIPTION);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");
		}

		sb.append(")");

		String query = sb.toString();

		// retirando o ultimo OR
		query = query.replace("OR )", ")");

		long companyId = PortalUtil.getCompanyId(request);
		Sort sort = new Sort(ordenacao, direcao);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);

		Hits hits = SearchEngineUtil.search(indexer.getSearchEngineId(), companyId, new StringQueryImpl(query), sort, inicio, fim);	

		return hits.getDocs().length;
	}

	public int getPage(HttpServletRequest httpReq) {
		int page = 1;

		if (httpReq.getParameter("page") != null
				&& !"".equals(httpReq.getParameter("page"))) {
			page = Integer.valueOf(httpReq.getParameter("page"));
		}

		return page;
	}
}
