<%@include file="/html/init.jsp"%>

<%@ page import="br.com.prodevelopment.portlet.conteudoweb.lista.Constantes"%>
<%@ page import="br.com.prodevelopment.portlet.conteudoweb.util.Search"%>
<%@ page import="br.com.prodevelopment.portlet.conteudoweb.util.JournalUtil"%>

<%
	Map<Long, String> listaEstrutura = (Map<Long, String>) request
			.getAttribute(Constantes.LISTA_ESTRUTURA);

	String articleId = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_ARTICLE_ID);
	if (Validator.isNull(articleId)) {
		articleId = (String)request.getAttribute(Constantes.NOME_PARAM_ARTICLE_ID);
	}
	
	String categoryId = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_CATEGORIA);
	String tag = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_TAG);
	String structureId = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_ESTRUTURA);
	String portletTitulo = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_TITULO_PORTLET);
	
	String keywords = ParamUtil.getString(request, "keywords");	

	// Recuperar preferências do portlet caso não tenha encontrado no request
	if (Validator.isNull(categoryId)) {
		categoryId = preferences.getValue(Constantes.PREF_CATEGORIA,
				StringPool.BLANK);
	}
	long[] allCategoryIds = null;
	if (Validator.isNotNull(categoryId)) {
		String[] aCategorias = new String[] { categoryId };
		if (aCategorias.length > 0) {
			allCategoryIds = new long[aCategorias.length];
			int contador = 0;
			for (String valor : aCategorias) {
				allCategoryIds[contador] = Long.valueOf(valor);
				contador++;
			}
		}
	}
	
	if (Validator.isNull(structureId)) {
		structureId = preferences.getValue(Constantes.PREF_ESTRUTURA,
				StringPool.BLANK);

	}
	if (Validator.isNull(tag)) {
		tag = preferences.getValue(Constantes.PREF_TAG, StringPool.BLANK);
	}
	
	String prefQtdeRegistros = preferences.getValue(Constantes.PREF_QTDE_REGISTROS,
			StringPool.BLANK);
	String prefTamanhoCaracteres = preferences.getValue(Constantes.PREF_TAMANHO_CARACTERES,
			StringPool.BLANK);
	String prefEstrutura = preferences.getValue(Constantes.PREF_ESTRUTURA,
			StringPool.BLANK);
	
	String prefPaginacao = preferences.getValue(Constantes.PREF_PAGINACAO,
			Constantes.N);
	String prefExibirTitulo = preferences.getValue(
			Constantes.PREF_EXIBIR_TITULO, Constantes.N);
	String prefOrdenacao = preferences.getValue(Constantes.PREF_ORDENACAO,
			StringPool.BLANK);
	String prefExibir = preferences.getValue(Constantes.PREF_EXIBIR,
			StringPool.BLANK);
	boolean prefExibirDataAlteracao = GetterUtil.getBoolean(preferences
			.getValue(Constantes.PREF_EXIBIR_DATA_ALTERACAO, null));
	boolean prefExibirLeiaMais = GetterUtil.getBoolean(preferences
			.getValue(Constantes.PREF_EXIBIR_LEIA_MAIS, null));
	boolean prefVoltar = GetterUtil.getBoolean(preferences.getValue(
			Constantes.PREF_VOLTAR, null));
	boolean prefEmail = GetterUtil.getBoolean(preferences.getValue(
			Constantes.PREF_EMAIL, null));
	boolean prefImprimir = GetterUtil.getBoolean(preferences.getValue(
			Constantes.PREF_IMPRIMIR, null));
	boolean acoes = (prefVoltar || prefEmail || prefImprimir);


	/*
	boolean showEditArticleIcon = PortletPermissionUtil.contains(
			permissionChecker, layout, portletDisplay.getId(),
			ActionKeys.UPDATE);
	boolean showAddArticleIcon = PortletPermissionUtil.contains(
			permissionChecker, layout, portletDisplay.getId(),
			ActionKeys.ADD_ARTICLE);
	*/
	boolean showEditArticleIcon = true;
	boolean showAddArticleIcon = true;
	
	long[] classTypeIds = null;
	if (Validator.isNotNull(structureId)) {
		classTypeIds = new long[] { GetterUtil.getLong(structureId) };
	}
	
	Map<String, PortletURL> addPortletURLs = null;
%>
