<%@ include file="init.jsp"%>

<%
PortletURL portletURL = renderResponse.createRenderURL();

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 2, portletURL, null, null);

int total = UsuarioUtil.searchCount(prefCategorias);

searchContainer.setTotal(total);

List<User> results = UsuarioUtil.search(prefCategorias, searchContainer.getStart(), searchContainer.getEnd());

searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	User friend = results.get(i);

	ResultRow row = new ResultRow(friend, friend.getUserId(), i);

	// User display

	row.addJSP("/html/lista/exibirUsuario.jsp", config.getServletContext(), request, response);

	// Add result row

	resultRows.add(row);
}
%>
<liferay-ui:search-iterator paginate="<%= false %>" searchContainer="<%= searchContainer %>" />

<c:if test="<%= results.size() > 0 %>">
	<div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />searchMembers">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="article" />
	</div>

	<aui:script use="aui-io-plugin-deprecated">
		var searchMembers = A.one('#<portlet:namespace />searchMembers');

		if (searchMembers) {
			var parent = searchMembers.ancestor();

			parent.plug(
				A.Plugin.IO,
				{
					autoLoad: false
				}
			);

			searchMembers.delegate(
				'click',
				function(event) {
					var anchor = event.currentTarget;

					if (!anchor.ancestor().hasClass('disabled')) {
						var uri = anchor.get('href').replace(/p_p_state=normal/i, 'p_p_state=exclusive');

						parent.io.set('uri', uri);
						parent.io.start();
					}

					event.preventDefault();
				},
				'a'
			);
		}
	</aui:script>
</c:if>