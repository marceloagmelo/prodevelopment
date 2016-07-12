<%@ include file="/html/init.jsp"%>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Pesquisa pesquisa = (Pesquisa) row.getObject();

	long groupId = pesquisa.getGroupId();
	String name = Pesquisa.class.getName();
	String primKey = String.valueOf(pesquisa.getId());
%>

<liferay-ui:icon-menu cssClass="">

		<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.VIEW) %>">
		<portlet:actionURL name="prepararVisualizacaoPesquisa" var="visualizarURL">
			<portlet:param name="id" value="<%= String.valueOf(pesquisa.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="view" method="post" url="<%=visualizarURL.toString() %>" />
		</c:if>

		<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="prepararAlteracaoPesquisa" var="editURL">
			<portlet:param name="id" value="<%= String.valueOf(pesquisa.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="edit" method="post" url="<%=editURL.toString() %>" />
		</c:if>
		
		<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>">
		<portlet:actionURL name="prepararExclusaoPesquisa" var="deleteURL">
			<portlet:param name="id" value="<%= String.valueOf(pesquisa.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="delete" method="post" url="<%=deleteURL.toString() %>" />
		</c:if>
		
	<!--Permissions Action-->
	<c:if
		test="<%= permissionChecker.hasPermission(groupId, name, pesquisa.getId(), ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Pesquisa.class.getName() %>"
			modelResourceDescription="<%= pesquisa.getTitulo(locale) %>"
			resourcePrimKey="<%= String.valueOf(pesquisa.getId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
		
</liferay-ui:icon-menu>