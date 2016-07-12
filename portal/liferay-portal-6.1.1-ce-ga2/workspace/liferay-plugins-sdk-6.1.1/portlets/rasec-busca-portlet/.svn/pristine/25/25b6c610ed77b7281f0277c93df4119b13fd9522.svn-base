package br.com.rasecmadeiras.busca.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.rasecmadeiras.busca.resultado.Constantes;
import br.com.rasecmadeiras.busca.resultado.vo.ResultadoVO;

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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class Search {

	public List<ResultadoVO> realizaBusca(PortletRequest request,
			String termosBusca, String estrutura,
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

		// estrutura
		if (Validator.isNotNull(estrutura)) {
			sb.append(" +" + Constantes.STRUCTURE_ID + ":");
			sb.append(estrutura);
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
		//palavras = StringUtil.split(termosBusca, " ");

		// verificando a estrutura que sera utilizada na busca
		PortletPreferences preferences = request.getPreferences();

		Constantes.PAGINA_DESTINO_PRODUTO = preferences.getValue(
				Constantes.PREF_PRODUTO_PAGINA_DESTINO, "");
		Constantes.PAGINA_DESTINO_FORNECEDOR = preferences.getValue(
				Constantes.PREF_FORNECEDOR_PAGINA_DESTINO, "");

		sb.append(" +(");
		for (String palavra : palavras) {
			sb.append(Field.ASSET_TAG_NAMES);
			sb.append(":");
			sb.append(asterisco);
			sb.append(palavra);
			sb.append(asterisco);
			sb.append(" OR ");

			sb.append(Field.ASSET_CATEGORY_NAMES);
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

			if (tipoConteudo == null
					|| tipoConteudo.equals(Constantes.TIPO_CONTEUDO_PRODUTO)) {
				tipoConteudo = Constantes.TIPO_CONTEUDO_PRODUTO;
				// ----- produto --------
				paginaDestino.append(Constantes.PAGINA_DESTINO_PRODUTO);
				sb.append(Constantes.PRODUTO_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_BENEFICIOS);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_CAPACIDADES);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_CARACTERISTICA);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_DICAS);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_CAPACIDADE);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_IMAGEM_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_IMAGEM_DIMENSOES);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");
			} else if (tipoConteudo.equals(Constantes.TIPO_CONTEUDO_FORNECEDOR)) {
				// ----- fonecedor -----
				paginaDestino.append(Constantes.PAGINA_DESTINO_FORNECEDOR);
				sb.append(Constantes.FORNECEDOR_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");
			} else if (tipoConteudo.equals(Constantes.TIPO_CONTEUDO_VIDEOS)) {
				// ----- vídeo -----
				sb.append(Constantes.VIDEO_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");
			} else {
				// ----- outros -----
				paginaDestino.append(Constantes.PAGINA_DESTINO_CONTEUDO);
				sb.append(Constantes.OUTROS_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.OUTROS_TEXTO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.OUTROS_CONTEUDO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");
			}
		}
		sb.append(")");

		String query = sb.toString();

		// retirando o ultimo OR
		query = query.replace("OR )", ")");

		long companyId = PortalUtil.getCompanyId(request);
		Sort sort = new Sort(ordenacao, direcao);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		Hits hits =  SearchEngineUtil.search(indexer.getSearchEngineId(), companyId,
				new StringQueryImpl(query), sort, inicio, fim);

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
			paginaDestinoParametro.append("&");
			paginaDestinoParametro.append(Constantes.NOME_PARAM_ESTRUTURA);
			paginaDestinoParametro.append("=");
			paginaDestinoParametro.append(resultado.getEstrutura());

			resultado.setPaginaDestino("/web"+resultado.getGroupFriendlyURL()+paginaDestino.toString()+paginaDestinoParametro);
			if (tipoConteudo.equals(Constantes.TIPO_CONTEUDO_VIDEOS)) {
				String urlVideo = "javascript:abrirVideo('"+URLUtil.parseToIframe(doc.get(Constantes.VIDEO_URL), httpReq)+"');";
				resultado.setPaginaDestino(urlVideo);
			/*
			} else if (Constantes.ESTRUTURA_FORNECEDOR.equals(estrutura)) {
				resultado.setPaginaDestino("");
			*/
			}

			resultados.add(resultado);
		}

		return resultados;
	}

	public  int getTotalConteudos(PortletRequest request,
			String termosBusca, String estrutura,
			String ordenacao, boolean direcao, int inicio, int fim, String tipoConteudo) throws PortalException,
			SystemException {

		if (termosBusca == null || termosBusca.isEmpty()) {
			return 0;
		}

		StringBuilder paginaDestino = new StringBuilder();

		termosBusca = termosBusca.toLowerCase();

		StringBuilder sb = new StringBuilder();

		// estrutura
		if (Validator.isNotNull(estrutura)) {
			sb.append(" +" + Constantes.STRUCTURE_ID + ":");
			sb.append(estrutura);
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

			sb.append(Field.ASSET_CATEGORY_NAMES);
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

			if (tipoConteudo == null
					|| tipoConteudo.equals(Constantes.TIPO_CONTEUDO_PRODUTO)) {
				// ----- produto --------
				paginaDestino.append(Constantes.PAGINA_DESTINO_PRODUTO);
				sb.append(Constantes.PRODUTO_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_BENEFICIOS);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_CAPACIDADES);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_CARACTERISTICA);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_DICAS);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_CAPACIDADE);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_IMAGEM_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.PRODUTO_IMAGEM_DIMENSOES);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");
			} else if (tipoConteudo.equals(Constantes.TIPO_CONTEUDO_FORNECEDOR)) {
				// ----- fonecedor -----
				paginaDestino.append(Constantes.PAGINA_DESTINO_FORNECEDOR);
				sb.append(Constantes.FORNECEDOR_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");
			} else if (tipoConteudo.equals(Constantes.TIPO_CONTEUDO_VIDEOS)) {
				// ----- vídeo -----
				sb.append(Constantes.VIDEO_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");
			} else {
				// ----- outros -----
				paginaDestino.append(Constantes.PAGINA_DESTINO_CONTEUDO);
				sb.append(Constantes.OUTROS_TITULO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.OUTROS_TEXTO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");

				sb.append(Constantes.OUTROS_CONTEUDO);
				sb.append(":");
				sb.append(asterisco);
				sb.append(palavra);
				sb.append(asterisco);
				sb.append(" OR ");
			}
		}

		sb.append(")");

		String query = sb.toString();

		// retirando o ultimo OR
		query = query.replace("OR )", ")");

		long companyId = PortalUtil.getCompanyId(request);
		Sort sort = new Sort(ordenacao, direcao);

		// realizando a busca
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		Hits hits =  SearchEngineUtil.search(indexer.getSearchEngineId(), companyId,
				new StringQueryImpl(query), sort, inicio, fim);
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
