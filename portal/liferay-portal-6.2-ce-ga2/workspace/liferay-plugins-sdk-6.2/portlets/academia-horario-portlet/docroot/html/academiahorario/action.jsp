<%@ include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(Constantes.SEARCH_CONTAINER_RESULT_ROW);

	AcademiaHorario academiaHorario = (AcademiaHorario) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=(permissionChecker.hasPermission(
							academiaHorario.getGroupId(), AcademiaHorario.class.getName(),
							academiaHorario.getAcademiaHorarioId(), ActionKeys.UPDATE) || permissaoUpdate)%>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/academiahorario/cadastro.jsp" />
			<portlet:param name="<%=Constantes.CAMPO_ACADEMIA_HORARIO_ID %>"
				value="<%=String.valueOf(academiaHorario.getAcademiaHorarioId())%>" />
			<portlet:param name="backURL"
				value="<%=currentURL %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							academiaHorario.getGroupId(), AcademiaHorario.class.getName(),
							academiaHorario.getAcademiaHorarioId(), ActionKeys.PERMISSIONS))%>">

		<liferay-security:permissionsURL
			modelResource="<%=AcademiaHorario.class.getName()%>"
			modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(academiaHorario.getAcademiaHorarioId())%>"
			var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" method="get"
			url="<%=permissionsURL%>" useDialog="<%=true%>" />

	</c:if>

	<c:if
		test="<%=(permissionChecker.hasPermission(
							academiaHorario.getGroupId(), AcademiaHorario.class.getName(),
							academiaHorario.getAcademiaHorarioId(), ActionKeys.DELETE) || permissaoDelete)%>">

		<portlet:actionURL var="deleteURL" name="<%=Constantes.DELETAR %>">
			<portlet:param name="jspPage" value="/html/academiahorario/view.jsp" />
			<portlet:param name="<%=Constantes.CAMPO_ACADEMIA_HORARIO_ID %>"
				value="<%=String.valueOf(academiaHorario.getAcademiaHorarioId())%>" />
			<portlet:param name="backURL"
				value="<%=currentURL %>" />
			<portlet:param name="deleteTagIds" value="" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL%>" />

	</c:if>
</liferay-ui:icon-menu>