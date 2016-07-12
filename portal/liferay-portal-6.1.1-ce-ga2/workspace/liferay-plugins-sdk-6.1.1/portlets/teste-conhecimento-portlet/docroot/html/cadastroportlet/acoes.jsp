<%@ include file="/html/init.jsp"%>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Teste teste = (Teste) row.getObject();

	long groupId = teste.getGroupId();
	String name = Teste.class.getName();
	String primKey = String.valueOf(teste.getId());
%>

<liferay-ui:icon-menu cssClass="">

		<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.VIEW) %>">
		<portlet:actionURL name="prepararVisualizacaoTeste" var="visualizarURL">
			<portlet:param name="id" value="<%= String.valueOf(teste.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="view" method="post" url="<%=visualizarURL.toString() %>" />
		</c:if>

		<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="prepararAlteracaoTeste" var="editURL">
			<portlet:param name="id" value="<%= String.valueOf(teste.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="edit" method="post" url="<%=editURL.toString() %>" />
		</c:if>

		<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>">
		<portlet:actionURL name="prepararExclusaoTeste" var="deleteURL">
			<portlet:param name="id" value="<%= String.valueOf(teste.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="delete" method="post" url="<%=deleteURL.toString() %>" />
		</c:if>

	<!--Permissions Action-->
	<c:if
		test="<%= permissionChecker.hasPermission(groupId, name, teste.getId(), ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Teste.class.getName() %>"
			modelResourceDescription="<%= teste.getTitulo(locale) %>"
			resourcePrimKey="<%= String.valueOf(teste.getId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>

</liferay-ui:icon-menu>