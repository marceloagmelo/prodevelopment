<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(TypeTaskConstants.SEARCH_CONTAINER_RESULT_ROW);

	TypeTask typeTask = (TypeTask) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%= (permissionChecker.hasPermission(
							typeTask.getGroupId(),
							TypeTask.class.getName(),
							typeTask.getTypeTaskId(), ActionKeys.UPDATE) || permissaoUpdateTypeTask) %>">

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/typetask/edit_typetask.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="typeTaskId"
				value="<%= String.valueOf(typeTask.getTypeTaskId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%= editURL %>" />

	</c:if>

	<c:if
		test="<%= (permissionChecker.hasPermission(
							typeTask.getGroupId(),
							TypeTask.class.getName(),
							typeTask.getTypeTaskId(), ActionKeys.PERMISSIONS)) %>">

		<liferay-security:permissionsURL
			modelResource="<%= TypeTask.class.getName() %>"
			modelResourceDescription="<%= HtmlUtil.escape(typeTask.getName(locale)) %>"
			resourcePrimKey="<%= String.valueOf(typeTask.getTypeTaskId()) %>"
			var="permissionsURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>" />

		<liferay-ui:icon image="permissions" method="get"
			url="<%= permissionsURL %>" useDialog="<%= true %>" />

	</c:if>

	<c:if
		test="<%= (permissionChecker.hasPermission(
							typeTask.getGroupId(),
							TypeTask.class.getName(),
							typeTask.getTypeTaskId(), ActionKeys.DELETE) || permissaoDeleteTypeTask) %>">

		<portlet:actionURL name="deletar" var="deleteURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="typeTaskId"
				value="<%= String.valueOf(typeTask.getTypeTaskId()) %>" />
			<portlet:param name="deleteTagIds" value="" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete
			trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>"
			url="<%= deleteURL %>"
		/>

	</c:if>
</liferay-ui:icon-menu>