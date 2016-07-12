<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

User usuario = (User)row.getObject();
%>

<liferay-ui:user-display
	userId="<%= usuario.getUserId() %>"
	userName="<%= usuario.getFullName() %>"
/>