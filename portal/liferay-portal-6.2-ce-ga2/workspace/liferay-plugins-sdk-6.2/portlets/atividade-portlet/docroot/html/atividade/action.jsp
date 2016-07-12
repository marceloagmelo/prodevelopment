<%@ include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	Atividade atividade = (Atividade) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=(permissionChecker.hasPermission(
							atividade.getGroupId(), Atividade.class.getName(),
							atividade.getAtividadeId(), ActionKeys.UPDATE) || permissaoUpdate)%>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/atividade/cadastro.jsp" />
			<portlet:param name="atividadeId"
				value="<%=String.valueOf(atividade.getAtividadeId())%>" />
			<portlet:param name="backURL"
				value="<%=currentURL %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							atividade.getGroupId(), Atividade.class.getName(),
							atividade.getAtividadeId(), ActionKeys.PERMISSIONS))%>">

		<liferay-security:permissionsURL
			modelResource="<%=Atividade.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(atividade.getNome(locale))%>"
			resourcePrimKey="<%=String.valueOf(atividade.getAtividadeId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							atividade.getGroupId(), Atividade.class.getName(),
							atividade.getAtividadeId(), ActionKeys.DELETE) || permissaoDelete)%>">

		<portlet:actionURL var="deleteURL" name="<%=Constantes.DELETAR %>">
			<portlet:param name="jspPage" value="/html/atividade/view.jsp" />
			<portlet:param name="atividadeId"
				value="<%=String.valueOf(atividade.getAtividadeId())%>" />
			<portlet:param name="backURL"
				value="<%=currentURL %>" />
			<portlet:param name="deleteTagIds" value="" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL%>" />

	</c:if>
</liferay-ui:icon-menu>