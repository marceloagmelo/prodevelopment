<%@ include file="init.jsp" %>

<%
renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
%>

<div class="portlet-configuration portlet-msg-info">
	<a href="<%= portletDisplay.getURLConfiguration() %>" onClick="<%= portletDisplay.getURLConfigurationJS() %>">
		<liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
	</a>
</div>