package br.com.prodevelopment.conteudo.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.StringQueryImpl;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;

public class Search {

	public static List<AssetTag> getTags(long groupId) throws SystemException {
		List<AssetTag> lista = AssetTagLocalServiceUtil.getGroupTags(groupId);
		return lista;
	}

	public static Hits busca(long groupId, String chave, String tipo,
			String estrutura, String categoria, String tag, int inicio,
			int fim,String ordenacao)
			throws SearchException, ParseException {

		StringBuilder sb = new StringBuilder();

		sb.append(" +" + Field.GROUP_ID + ":" + groupId);

		if (Validator.isNotNull(tipo)) {
			sb.append(" +" + Field.TYPE + ":(" + tipo + ")");
		}
		if (Validator.isNotNull(tag)) {
			sb.append(" +" + Field.ASSET_TAG_NAMES + ":(" + tag + ")");
		}
		if (Validator.isNotNull(categoria)) {
			sb.append(" +" + Field.ASSET_CATEGORY_IDS + ":(" + categoria + ")");
		}
		if (Validator.isNotNull(estrutura)) {
			sb.append(" +structureId:(" + estrutura + ")");
		}
		if (Validator.isNotNull(chave)) {
			String chaveEsc = escape(chave);
			sb.append(" +(" + Field.CONTENT + ":(" + chaveEsc + ") "
					+ Field.TITLE + ":(" + chaveEsc + "))");
		}

		sb.append(" +"+Field.ENTRY_CLASS_NAME + ":com.liferay.portlet.journal.model.JournalArticle");
		sb.append(" +"+Field.APPROVED+":true");
		sb.append(" +"+Field.EXPIRED+":false");

		Query query = new StringQueryImpl(sb.toString());

		Sort sort = null;
		if (Field.TITLE.equals(ordenacao)) {
			sort = new Sort(Field.TITLE, false);
		}
		else {
			sort = new Sort(Field.MODIFIED_DATE, true);
		}
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		return SearchEngineUtil.search(indexer.getSearchEngineId(), CompanyThreadLocal.getCompanyId(),
				query, sort, inicio, fim);
/*
		return SearchEngineUtil.search(CompanyThreadLocal.getCompanyId(),
				query, sort, inicio, fim);

		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create();
		BooleanQuery contentQuery = BooleanQueryFactoryUtil.create();
		booleanQuery.addRequiredTerm(Field.GROUP_ID, groupId);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				"com.liferay.portlet.journal.model.JournalArticle");

		if (Validator.isNotNull(chave)) {
			String chaveEsc = escape(chave);
			contentQuery.addTerm(Field.CONTENT, chaveEsc);
			contentQuery.addTerm(Field.TITLE, chaveEsc);
		}
		if (Validator.isNotNull(tipo)) {
			contentQuery.addTerm(Field.TYPE, tipo);
		}
		if (Validator.isNotNull(categoria)) {
			booleanQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, categoria, true);
		}
		if (Validator.isNotNull(tag)) {
			booleanQuery.addRequiredTerm(Field.ASSET_TAG_NAMES, tag, true);
		}
		if (Validator.isNotNull(estrutura)) {
			booleanQuery.addExactTerm("structureId", estrutura);
		}

		try {
			fullQuery.add(booleanQuery,BooleanClauseOccur.MUST);
			if (contentQuery.clauses().size() > 0) {
				fullQuery.add(contentQuery, BooleanClauseOccur.MUST);
			}
		} catch (Exception e) {
			e.getMessage();
		}

		// Cria o criterio de ordenação
		Sort sort = new Sort(Field.MODIFIED, true);

		// Executa a busca return
		return SearchEngineUtil.search(CompanyThreadLocal.getCompanyId(), fullQuery,
				sort, inicio, fim);
		*/
	}

	private static String escape(String str) {
		return str.replaceAll("[\\+|\\-|\\*|\\(|\\)|\\\\|\\?|\\:]", "");
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
