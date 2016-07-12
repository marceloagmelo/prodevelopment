<%@ include file="init.jsp" %>

<%
UserSearch searchContainer = (UserSearch)request.getAttribute("liferay-ui:search:searchContainer");

UserDisplayTerms displayTerms = (UserDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>"
	buttonLabel="search"
	displayTerms="<%= displayTerms %>"
	id="toggle_id_users_admin_user_search"
>
	<aui:fieldset>
		<%@ include file="user_search_user_name.jspf" %>

		<aui:input name="<%= displayTerms.SCREEN_NAME %>" size="20" value="<%= displayTerms.getScreenName() %>" />

		<aui:input name="<%= displayTerms.EMAIL_ADDRESS %>" size="20" value="<%= displayTerms.getEmailAddress() %>" />
	</aui:fieldset>
</liferay-ui:search-toggle>