<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="idTeste" scope="request" />
<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Pergunta pergunta = (Pergunta) row.getObject();

	String grupoId = (String) request.getAttribute(Constantes.GROUP_ID);
	long groupId = Long.parseLong(grupoId);
	String name = Teste.class.getName();
	String primKey = idTeste;
%>

<liferay-ui:icon-menu cssClass="">

	<c:if
		test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.VIEW) %>">
		<portlet:actionURL name="prepararVisualizacaoPergunta" var="visualizarURL">
			<portlet:param name="id"
				value="<%= String.valueOf(pergunta.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="view" method="post"
			url="<%=visualizarURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="prepararAlteracaoPergunta" var="editURL">
			<portlet:param name="id"
				value="<%= String.valueOf(pergunta.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="edit" method="post"
			url="<%=editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>">
		<portlet:actionURL name="prepararExclusaoPergunta" var="deleteURL">
			<portlet:param name="id"
				value="<%= String.valueOf(pergunta.getId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon image="delete" method="post"
			url="<%=deleteURL.toString() %>" />
	</c:if>

</liferay-ui:icon-menu>