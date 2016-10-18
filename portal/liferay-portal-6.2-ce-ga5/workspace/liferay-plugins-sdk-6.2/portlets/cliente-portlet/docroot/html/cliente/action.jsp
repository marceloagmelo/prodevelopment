<%@ include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	Cliente cliente = (Cliente) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=(permissionChecker.hasPermission(
							cliente.getGroupId(),
							Cliente.class.getName(),
							cliente.getClienteId(), ActionKeys.UPDATE) || permissaoUpdateCliente)%>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/cliente/cadastro.jsp" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="clienteId"
				value="<%=String.valueOf(cliente.getClienteId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							cliente.getGroupId(),
							Cliente.class.getName(),
							cliente.getClienteId(), ActionKeys.PERMISSIONS))%>">

		<liferay-security:permissionsURL
			modelResource="<%=Cliente.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(cliente.getNome())%>"
			resourcePrimKey="<%=String.valueOf(cliente.getClienteId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />
	
		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							cliente.getGroupId(),
							Cliente.class.getName(),
							cliente.getClienteId(), ActionKeys.DELETE) || permissaoDeleteCliente)%>">

		<portlet:actionURL var="deleteURL" name="deletar">
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="clienteId"
				value="<%=String.valueOf(cliente.getClienteId())%>" />
			<portlet:param name="deleteTagIds" value="" />
		</portlet:actionURL>
	
		<liferay-ui:icon-delete url="<%=deleteURL%>" />

	</c:if>
</liferay-ui:icon-menu>
