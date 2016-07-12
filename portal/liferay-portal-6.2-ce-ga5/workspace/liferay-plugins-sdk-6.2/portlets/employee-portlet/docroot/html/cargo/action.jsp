<%@ include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	Cargo cargo = (Cargo) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=(permissionChecker.hasPermission(
							cargo.getGroupId(), Cargo.class.getName(),
							cargo.getCargoId(), ActionKeys.UPDATE) || permissaoUpdateCargo)%>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/cargo/cadastro.jsp" />
			<portlet:param name="<%=Constantes.REDIRECT %>" value="<%=Constantes.REDIRECT_VIEW_CARGO%>" />
			<portlet:param name="cargoId"
				value="<%=String.valueOf(cargo.getCargoId())%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							cargo.getGroupId(), Cargo.class.getName(),
							cargo.getCargoId(), ActionKeys.PERMISSIONS))%>">

		<liferay-security:permissionsURL
			modelResource="<%=Cargo.class.getName()%>"
			modelResourceDescription="<%=HtmlUtil.escape(cargo.getNome(locale))%>"
			resourcePrimKey="<%=String.valueOf(cargo.getCargoId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							cargo.getGroupId(), Cargo.class.getName(),
							cargo.getCargoId(), ActionKeys.DELETE) || permissaoDeleteCargo)%>">

		<portlet:actionURL var="deleteURL" name="deletarCargo">
			<portlet:param name="jspPage" value="/html/cargo/view.jsp" />
			<portlet:param name="direciona" value="<%=Constantes.REDIRECT_VIEW_CARGO%>" />
			<portlet:param name="cargoId"
				value="<%=String.valueOf(cargo.getCargoId())%>" />
			<portlet:param name="deleteTagIds" value="" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL%>" />

	</c:if>
</liferay-ui:icon-menu>
