package br.com.studiniz.busca.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.studiniz.busca.resultado.Constantes;
import br.com.studiniz.busca.resultado.vo.ResultadoVO;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.StringQueryImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryConstants;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class Search {

	public List<ResultadoVO> buscaConteudos(RenderRequest renderRequest,
			String termosBusca, int inicio,
			int fim) throws PortalException,
			SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		if (termosBusca == null || termosBusca.isEmpty()) {
			return null;
		}

		StringBuilder paginaDestino = new StringBuilder();
		boolean hasAddPermission = false; 


		termosBusca = termosBusca.toLowerCase();

		StringBuilder sb = new StringBuilder();

		sb.append(" +" + Field.ENTRY_CLASS_NAME + ":"
					+ Constantes.CONTEUDO_CLASSE);
		// outros campos
		sb.append(" +" + Field.GROUP_ID + ":" + themeDisplay.getScopeGroupId());
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
		PortletPreferences preferences = renderRequest.getPreferences();

		String paginaConteudo = preferences.getValue(
				Constantes.PREF_PAGINA_DESTINO_CONTEUDO, StringPool.BLANK);
		String tipoConteudo = Constantes.TIPO_CONTEUDO;
		paginaDestino.append(paginaConteudo);
		String nomeClasse = Constantes.CONTEUDO_CLASSE;

		sb.append(" +(");
		for (String palavra : palavras) {
			sb.append(Field.ASSET_CATEGORY_NAMES);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

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

			sb.append(Constantes.BUSCA_TITULO);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Constantes.BUSCA_DESCRICAO);
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

		long companyId = PortalUtil.getCompanyId(renderRequest);
		Sort sort = new Sort(Field.MODIFIED_DATE, true);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil
					.getIndexer(com.liferay.portlet.documentlibrary.model.DLFileEntry.class);
		Hits hits = SearchEngineUtil.search(indexer.getSearchEngineId(),
				companyId, new StringQueryImpl(query), sort, inicio, fim);

		Document[] docs = hits.getDocs();

		List<ResultadoVO> resultados = new ArrayList<ResultadoVO>();
		
		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		for (Document doc : docs) {

			ResultadoVO resultado = new ResultadoVO();
			resultado.setCategorias(AssetCategoryUtil.getNameById(doc
					.get(Field.ASSET_CATEGORY_IDS)));
			resultado.setTagsNames(doc.get(Field.ASSET_TAG_NAMES));

			Group comunidade = null;

			comunidade = GroupLocalServiceUtil.getGroup(GetterUtil.getLong(doc
					.get(Field.GROUP_ID)));

			resultado.setGroupFriendlyURL(comunidade.getFriendlyURL());

			if (Constantes.TIPO_CONTEUDO.equals(tipoConteudo)) {
				resultado.setId(doc.get(Field.ARTICLE_ID));
				
				JournalArticle artigo = JournalArticleLocalServiceUtil
						.getLatestArticle(themeDisplay.getScopeGroup()
								.getGroupId(), resultado.getId(),
								WorkflowConstants.STATUS_APPROVED);

				// Permissao de adicionar
				hasAddPermission = permissionChecker
						.hasPermission(themeDisplay.getScopeGroupId(), nomeClasse,
								artigo.getArticleId(),
								ActionKeys.VIEW);
				hasAddPermission = true;
				
				resultado.setTitulo(doc.get(Constantes.BUSCA_TITULO)
						.replace("[", "").replace("]", ""));
				if (Validator.isNull(resultado.getTitulo())) {
					resultado.setTitulo(doc.get(Field.TITLE).replace("[", "")
							.replace("]", ""));
				}
				resultado.setDescricao(Helper.trataTextoLongo(doc.get(Constantes.BUSCA_DESCRICAO).replace("[", "").replace("]", ""), 200));
				if (Validator.isNull(resultado.getDescricao())) {
					resultado.setDescricao(Helper.trataTextoLongo(doc.get(Constantes.BUSCA_TEXTO).replace("[", "").replace("]", ""), 200));
					if (Validator.isNull(resultado.getDescricao())) {
						resultado.setDescricao(Helper.trataTextoLongo(doc.get(Field.DESCRIPTION).replace("[", "").replace("]", ""), 200));
					}
				}
				resultado.setDescricao(StringUtil.highlight(
						resultado.getDescricao(), palavras));
				resultado.setEstrutura(artigo.getStructureId());
				/*
				resultado.setUrlPagina(URLUtil.getURLsById(
						resultado.getId(), themeDisplay));
				*/
				resultado.setDataCriacao(DateUtil.getFormatDate(doc
						.get(Field.MODIFIED_DATE)));

				resultado.setDataCriacao(DateUtil
						.dateToStringWithHour(artigo.getCreateDate()));
				
				StringBuilder paginaDestinoParametro = new StringBuilder();

				paginaDestinoParametro.append("?");
				paginaDestinoParametro.append(Constantes.NOME_PARAM_ID);
				paginaDestinoParametro.append("=");
				paginaDestinoParametro.append(resultado.getId());
				paginaDestinoParametro.append("&");
				paginaDestinoParametro.append(Constantes.NOME_PARAM_ESTRUTURA);
				paginaDestinoParametro.append("=");
				paginaDestinoParametro.append(resultado.getEstrutura());
				
				resultado.setPaginaDestino("/web"+resultado.getGroupFriendlyURL()
						+ paginaDestino.toString().trim()+paginaDestinoParametro.toString().trim());
			} else {
				resultado.setId(doc.get(Field.ENTRY_CLASS_PK));

				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
						.getDLFileEntry(Long.parseLong(resultado.getId()));
				
				// Permissao de adicionar
				hasAddPermission = permissionChecker
						.hasPermission(themeDisplay.getScopeGroupId(), nomeClasse,
								fileEntry.getFileEntryId(),
								ActionKeys.VIEW);

				resultado.setDescricao(fileEntry.getDescription());
				resultado.setTitulo(fileEntry.getTitle());
				resultado.setIconeUrl(DocumentUtil.getDocIconUrl(
						fileEntry.getExtension(), themeDisplay));
				resultado.setDownloadUrl(DocumentUtil.getDocDownloadUrl(
						String.valueOf(fileEntry.getGroupId()),
						fileEntry.getUuid(), themeDisplay));

				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
						DLFileEntry.class.getName(), fileEntry.getPrimaryKey());
				resultado.setAssetEntryId(String.valueOf(assetEntry
						.getEntryId()));

				resultado.setDataAlteracao(DateUtil
						.dateToStringWithHour(fileEntry.getModifiedDate()));

				resultado.setDataCriacao(DateUtil
						.dateToStringWithHour(fileEntry.getCreateDate()));
			}
			if (hasAddPermission) {
				resultados.add(resultado);
			}
		}

		return resultados;
	}

	public int getTotalConteudos(PortletRequest request, String termosBusca,
			int inicio, int fim) throws PortalException, SystemException {

		if (termosBusca == null || termosBusca.isEmpty()) {
			return 0;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		termosBusca = termosBusca.toLowerCase();

		StringBuilder sb = new StringBuilder();

		sb.append(" +" + Field.ENTRY_CLASS_NAME + ":"
					+ Constantes.CONTEUDO_CLASSE);

		// outros campos
		sb.append(" +" + Field.GROUP_ID + ":" + themeDisplay.getScopeGroupId());
		sb.append(" +" + Field.APPROVED + ":true");
		sb.append(" +" + Field.EXPIRED + ":false");

		// conteudo
		sb.append(" +(");
		String[] palavras = null;
		String asterisco = "";

		// remontando o termoBusca
		palavras = new String[] { termosBusca };
		asterisco = "";
		// palavras = StringUtil.split(termosBusca, " ");

		for (String palavra : palavras) {
			sb.append(Field.ASSET_CATEGORY_NAMES);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

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

			sb.append(Constantes.BUSCA_TITULO);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Constantes.BUSCA_DESCRICAO);
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
		Sort sort = new Sort(Field.MODIFIED_DATE, true);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil
					.getIndexer(com.liferay.portlet.documentlibrary.model.DLFileEntry.class);

		Hits hits = SearchEngineUtil.search(indexer.getSearchEngineId(),
				companyId, new StringQueryImpl(query), sort, inicio, fim);

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

	public List<ResultadoVO> buscaDocumentos(RenderRequest renderRequest, String termosBusca,
			int inicio, int fim)
			throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		SearchContext searchContext = new SearchContext();
		
		searchContext.setCompanyId(themeDisplay.getCompanyId());
		searchContext.setEnd(fim);
		searchContext.setEntryClassNames(
			new String[] {DLFileEntryConstants.getClassName()});
		searchContext.setGroupIds(new long[] {themeDisplay.getScopeGroup().getGroupId()});

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			DLFileEntryConstants.getClassName());

		searchContext.setSearchEngineId(indexer.getSearchEngineId());

		searchContext.setStart(inicio);
		searchContext.setUserId(themeDisplay.getUserId());
		

		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery contentQuery = BooleanQueryFactoryUtil.create(searchContext);
		
		booleanQuery.addRequiredTerm(Field.GROUP_ID, themeDisplay.getScopeGroup().getGroupId());
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				"com.liferay.portlet.documentlibrary.model.DLFileEntry");

		String chaveEsc = escape(termosBusca);
		contentQuery.addTerm(Field.CONTENT, chaveEsc);
		contentQuery.addTerm(Field.TITLE, chaveEsc);

		contentQuery.addTerm(Field.ASSET_CATEGORY_IDS, termosBusca);
		contentQuery.addTerm(Field.ASSET_TAG_NAMES, termosBusca);

		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			if (contentQuery.clauses().size() > 0) {
				fullQuery.add(contentQuery, BooleanClauseOccur.MUST);
			}
		} catch (Exception e) {
			e.getMessage();
		}

		// Cria o criterio de ordenação
		Sort sort = new Sort(Field.MODIFIED_DATE, true);

		// Executa a busca return
		Hits hits =  SearchEngineUtil.search(searchContext, fullQuery);

		Document[] docs = hits.getDocs();

		List<ResultadoVO> resultados = new ArrayList<ResultadoVO>();
		
		String nomeClasse = Constantes.DOCUMENTO_CLASSE;
		
		for (Document doc : docs) {

			ResultadoVO resultado = new ResultadoVO();
			resultado.setCategorias(AssetCategoryUtil.getNameById(doc
					.get(Field.ASSET_CATEGORY_IDS)));
			resultado.setTagsNames(doc.get(Field.ASSET_TAG_NAMES));

			Group comunidade = null;

			comunidade = GroupLocalServiceUtil.getGroup(GetterUtil.getLong(doc
					.get(Field.GROUP_ID)));

			resultado.setGroupFriendlyURL(comunidade.getFriendlyURL());

			resultado.setId(doc.get(Field.ENTRY_CLASS_PK));

			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
					.getDLFileEntry(Long.parseLong(resultado.getId()));
			
			// Permissao de adicionar
			PermissionChecker permissionChecker = themeDisplay
					.getPermissionChecker();

			boolean hasAddPermission = permissionChecker
					.hasPermission(themeDisplay.getScopeGroupId(), nomeClasse,
							fileEntry.getFileEntryId(),
							ActionKeys.VIEW);

			resultado.setDescricao(fileEntry.getDescription());
			resultado.setTitulo(fileEntry.getTitle());
			resultado.setIconeUrl(DocumentUtil.getDocIconUrl(
					fileEntry.getExtension(), themeDisplay));
			resultado.setDownloadUrl(DocumentUtil.getDocDownloadUrl(
					String.valueOf(fileEntry.getGroupId()),
					fileEntry.getUuid(), themeDisplay));

			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
					DLFileEntry.class.getName(), fileEntry.getPrimaryKey());
			resultado.setAssetEntryId(String.valueOf(assetEntry
					.getEntryId()));

			resultado.setDataAlteracao(DateUtil
					.dateToStringWithHour(fileEntry.getModifiedDate()));

			resultado.setDataCriacao(DateUtil
					.dateToStringWithHour(fileEntry.getCreateDate()));

			if (hasAddPermission) {
				resultados.add(resultado);
			}
		}

		return resultados;
	}

	public int totalDocumentos(RenderRequest renderRequest, String termosBusca,
			int inicio, int fim)
			throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		SearchContext searchContext = new SearchContext();
		
		searchContext.setCompanyId(themeDisplay.getCompanyId());
		searchContext.setEnd(fim);
		searchContext.setEntryClassNames(
			new String[] {DLFileEntryConstants.getClassName()});
		searchContext.setGroupIds(new long[] {themeDisplay.getScopeGroup().getGroupId()});

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			DLFileEntryConstants.getClassName());

		searchContext.setSearchEngineId(indexer.getSearchEngineId());

		searchContext.setStart(inicio);
		searchContext.setUserId(themeDisplay.getUserId());
		

		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery contentQuery = BooleanQueryFactoryUtil.create(searchContext);
		
		booleanQuery.addRequiredTerm(Field.GROUP_ID, themeDisplay.getScopeGroup().getGroupId());
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				"com.liferay.portlet.documentlibrary.model.DLFileEntry");

		String chaveEsc = escape(termosBusca);
		contentQuery.addTerm(Field.CONTENT, chaveEsc);
		contentQuery.addTerm(Field.TITLE, chaveEsc);

		contentQuery.addTerm(Field.ASSET_CATEGORY_IDS, termosBusca);
		contentQuery.addTerm(Field.ASSET_TAG_NAMES, termosBusca);

		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			if (contentQuery.clauses().size() > 0) {
				fullQuery.add(contentQuery, BooleanClauseOccur.MUST);
			}
		} catch (Exception e) {
			e.getMessage();
		}

		// Cria o criterio de ordenação
		Sort sort = new Sort(Field.MODIFIED_DATE, true);

		// Executa a busca return
		Hits hits =  SearchEngineUtil.search(searchContext, fullQuery);

		return hits.getDocs().length;
	}

	private static String escape(String str) {
		return str.replaceAll("[\\+|\\-|\\*|\\(|\\)|\\\\|\\?|\\:]", "");
	}
}
