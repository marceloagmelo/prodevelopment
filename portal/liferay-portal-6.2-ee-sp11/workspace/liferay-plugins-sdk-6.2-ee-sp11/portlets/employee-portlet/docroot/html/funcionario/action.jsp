<%@ include file="init.jsp"%>

<%
	//PessoaSearch searchContainer = (PessoaSearch)request.getAttribute("liferay-ui:search:searchContainer");

	//String redirect = ParamUtil.getString(request, "redirect");

	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	Funcionario funcionario = (Funcionario) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=(permissionChecker.hasPermission(
							funcionario.getGroupId(),
							Funcionario.class.getName(),
							funcionario.getFuncionarioId(), ActionKeys.UPDATE) || permissaoUpdateFuncionario)%>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/funcionario/cadastro.jsp" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="funcionarioId"
				value="<%=String.valueOf(funcionario.getFuncionarioId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							funcionario.getGroupId(),
							Funcionario.class.getName(),
							funcionario.getFuncionarioId(), ActionKeys.PERMISSIONS))%>">

		<liferay-security:permissionsURL
			modelResource="<%=Funcionario.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(funcionario.getNome())%>"
			resourcePrimKey="<%=String.valueOf(funcionario.getFuncionarioId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />
	
		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							funcionario.getGroupId(),
							Funcionario.class.getName(),
							funcionario.getFuncionarioId(), ActionKeys.DELETE) || permissaoDeleteFuncionario)%>">

		<portlet:actionURL var="deleteURL" name="deletar">
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="funcionarioId"
				value="<%=String.valueOf(funcionario.getFuncionarioId())%>" />
			<portlet:param name="deleteTagIds" value="" />
		</portlet:actionURL>
	
		<liferay-ui:icon-delete url="<%=deleteURL%>" />

	</c:if>
</liferay-ui:icon-menu>
