<%@ include file="/html/init.jsp"%>

<%
	List<Organization> orgs = OrganizacaoUtil.listaSite(themeDisplay
			.getCompanyId());
%>
		<div id="mi-slider" class="mi-slider">
			<ul>
<%
	for (Organization org : orgs) {
		long logoId = org.getLogoId();
%>
		<liferay-portlet:actionURL portletName="<%= PortletKeys.SITE_REDIRECTOR %>" var="publicPagesURL">
			<portlet:param name="struts_action" value="/my_sites/view" />
			<portlet:param name="groupId" value="<%= String.valueOf(org.getGroup().getGroupId()) %>" />
			<portlet:param name="privateLayout" value="<%= Boolean.FALSE.toString() %>" />
		</liferay-portlet:actionURL>

		<li><a href="<%=publicPagesURL.toString() %>"><img alt="<%= HtmlUtil.escape(org.getName()) %>" src="<%= themeDisplay.getPathImage() %>/organization_logo?img_id=<%= logoId %>&t=<%= WebServerServletTokenUtil.getToken(logoId) %>" /><h4><%= HtmlUtil.escape(org.getName()) %></h4></a></li>
<%
	}
%>
			</ul>
			<nav>
				<liferay-ui:message key="label.unidades"/>
			</nav>
		</div>
<script>
	jQuery(function() {

		jQuery( '#mi-slider' ).catslider();

	});
</script>
