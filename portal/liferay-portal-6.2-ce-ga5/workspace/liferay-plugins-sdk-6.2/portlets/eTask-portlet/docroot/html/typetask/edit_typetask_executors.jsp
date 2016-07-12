<aui:input name="addUserExecutorsIds" type="hidden" />
<aui:input name="removeUserExecutorsIds" type="hidden" />

<liferay-ui:tabs
	names="current,available"
	param="tabs3"
	url="<%= portletURL.toString() %>"
/>
<%
PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setParameter(TypeTaskConstants.MVC_PATH, TypeTaskConstants.PATH_JSP_EDIT);
searchURL.setParameter(TypeTaskConstants.TABS3, tabs3);
searchURL.setParameter(TypeTaskConstants.TABS1, tabs1);
searchURL.setParameter(TypeTaskConstants.REDIRECT, redirect);
searchURL.setParameter(TypeTaskConstants.BACK_URL, backURL);
searchURL.setParameter(TypeTaskConstants.TYPE_TASK_ID, (typeTask != null) ? String.valueOf(typeTask.getTypeTaskId()) : StringPool.BLANK);

String typeUser = TypeTaskConstants.TYPE_USER_EXECUTOR;
%>
<portlet:actionURL var="saveExecutorsURL"/>
<aui:form action="<%= saveExecutorsURL %>" method="post" name="fm">
<aui:input name="<%=TypeTaskConstants.ADD_USERS_IDS %>" type="hidden" />
<aui:input name="<%=TypeTaskConstants.REMOVE_USERS_IDS %>" type="hidden" />
<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=TypeTaskConstants.USER_SEARCH_DELETE_ACTION %>" />
<aui:input name="redirect" type="hidden" value="<%=redirect%>" />
<aui:input name="backURL" type="hidden" value="<%=backURL%>" />
<aui:input name="typeTaskId" type="hidden" value="<%=typeTaskId%>" />
<aui:input name="userId" type="hidden" value="<%=String.valueOf(themeDisplay.getRealUser().getUserId())%>" />
<aui:input name="<%=TypeTaskConstants.TYPE_USER%>" type="hidden" value="<%=TypeTaskConstants.TYPE_USER_EXECUTOR%>" />
<aui:input name="<%=TypeTaskConstants.TABS3 %>" type="hidden" value="<%=tabs3%>" />
<aui:input name="<%=TypeTaskConstants.TABS1 %>" type="hidden" value="<%=tabs1%>" />

<liferay-ui:search-container
	rowChecker="<%= new UserTypeTaskChecker(renderResponse, typeTask, TypeTaskConstants.TYPE_USER_EXECUTOR) %>"
	searchContainer="<%= new UserSearch(renderRequest, searchURL) %>"
	var="userSearchContainer">
		<liferay-ui:search-form
		page="/html/typetask/user_search.jsp" servletContext="<%= this.getServletContext()%>"/>
	
	<%
	UserSearchTerms searchTerms = (UserSearchTerms)userSearchContainer.getSearchTerms();

	LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();
	%>
	
	<liferay-ui:search-container-results>
<%
if (tabs3.equals("current")) {
%>	
		<%@ include file="type_task_user_search_results.jspf" %>
<%

} else {
%>		
		<%@ include file="user_search_results.jspf" %>
<%
}
%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.User"
		escapedModel="<%= true %>"
		keyProperty="userId"
		modelVar="user2"
		rowIdProperty="screenName"
	>
		<liferay-ui:search-container-column-text
			name="name"
			property="fullName"
		/>

		<liferay-ui:search-container-column-text
			name="screen-name"
			property="screenName"
		/>

		<liferay-ui:search-container-column-text
			name="email-address"
			property="emailAddress"
		/>
	</liferay-ui:search-container-row>

	<div class="separator"><!-- --></div>
	
	<%
	String taglibOnClick = renderResponse.getNamespace() + "updateExecutors();";
	if (userSearchContainer.getTotal() > 0) {
	%>
	<aui:button onClick="<%= taglibOnClick %>" value="update-associations" />
	<%
	}
	%>	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>
</aui:form>
