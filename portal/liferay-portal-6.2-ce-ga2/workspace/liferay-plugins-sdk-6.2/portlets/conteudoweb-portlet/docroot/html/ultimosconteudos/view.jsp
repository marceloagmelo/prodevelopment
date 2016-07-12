<%@include file="init.jsp"%>
<!-- inicio codigo portlet -->
<%
	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setParameter("categoryId", categoryId);
	renderURL.setParameter("tag", tag);

	SearchContainer searchContainer = new SearchContainer(
			renderRequest, new DisplayTerms(renderRequest), null,
			SearchContainer.DEFAULT_CUR_PARAM, 2, renderURL, null, null);

	DisplayTerms displayTerms = searchContainer.getDisplayTerms();

	List<JournalArticle> results = Search.buscarConteudos(
			StringPool.BLANK, themeDisplay.getCompanyId(),
			themeDisplay.getScopeGroupId(), GetterUtil.getLong(structureId),
			searchContainer.getStart(), searchContainer.getEnd(),
			categoryId, tag, Field.MODIFIED_DATE);

	int total = Search.getTotalConteudo(StringPool.BLANK,
			themeDisplay.getCompanyId(),
			themeDisplay.getScopeGroupId(), 0, categoryId, tag);

	searchContainer.setTotal(total);

	searchContainer.setResults(results);
%>
<div class="conteudos">
	<%
		if (Constantes.S.equals(prefExibirTitulo)) {
	%>
	<liferay-ui:header escapeXml="<%=false%>"
		title="${portletTitulo }" />
	<%
		}
		for (int i = 0; i < results.size(); i++) {

			JournalArticle article = (JournalArticle) results.get(i);

			String titulo = article.getTitle(locale);
			String dataAlteracao = dateFormatDate.format(article
					.getModifiedDate());
			String urlImagem = StringPool.BLANK;
			if (article.isSmallImage()) {
				if (Validator.isNotNull(article.getSmallImageURL())) {
					urlImagem = themeDisplay.getPathImage()
							+ article.getSmallImageURL();
				} else {
					urlImagem = "/image/journal/article?img_id="
							+ article.getSmallImageId();
				}
			}
	%>
	<div class="conteudo">
		<h5 class="titulo"><a href="<%=prefUrlDestino %>?articleId=<%=article.getArticleId() %>"><%=HtmlUtil.escape(titulo)%></a></h5>
	</div>
	<%
		}
		if (results.size() > 0) {
	%>
	<p class="ver_todos">
		[<a
			href="<%=prefUrlVerTodos %>?categoria=<%=categoryId %>&amp;tag=<%=tag %>&estrutura=<%=structureId%>"><liferay-ui:message
				key="label.verTodos" /></a>]
	</p>
	<%
		}
	%>
	
</div>
<!-- fim codigo portlet -->