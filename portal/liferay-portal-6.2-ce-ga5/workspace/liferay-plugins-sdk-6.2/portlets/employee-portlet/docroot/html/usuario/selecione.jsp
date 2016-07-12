<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "openUsuarioSelector");
	String target = ParamUtil.getString(request, "target");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("eventName", eventName);
	portletURL.setParameter("target", target);
	portletURL.setParameter("jspPage", "/html/usuario/selecione.jsp");
	portletURL.setParameter("redirect", currentURL);

	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	
	LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();

	long companyId = themeDisplay.getCompanyId();
	Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
	
	Organization organization = null;

	if (group.isOrganization()) {
		organization = OrganizationLocalServiceUtil.getOrganization(group.getClassPK());
	}

	userParams.put("inherit", Boolean.TRUE);

	if (organization != null) {
		userParams.put("usersOrgs", new Long(organization.getOrganizationId()));
	}
	else {
		userParams.put("usersGroups", new Long(group.getGroupId()));
	}

	List<User> usuarios = UsuarioUtil.listarUsuarios(companyId, userParams, keywords);
%>


<aui:form action="<%=portletURLString%>"  method="post" name="openUsuarioSelectorFm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />

	<liferay-ui:search-container emptyResultsMessage="mensagem.naoExistem.usuarios" iteratorURL="<%=portletURL %>">

		<aui:nav-bar>
			<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					<liferay-ui:input-search
						autoFocus="<%=windowState.equals(WindowState.MAXIMIZED)%>"
						placeholder='<%=LanguageUtil.get(locale, "keywords")%>' />
				</div>

			</aui:nav-bar-search>
		</aui:nav-bar>


		<liferay-ui:search-container-results>

			<%
				results = ListUtil.subList(usuarios, searchContainer.getStart(), searchContainer.getEnd());
				total = usuarios.size();
				
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
				
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row className="com.liferay.portal.model.User" keyProperty="userId" modelVar="user">

			<liferay-ui:search-container-column-text name="label.nome" property="fullName"/>

			<liferay-ui:search-container-column-text>
				<%
				Map<String, Object> data = new HashMap<String, Object>();

				data.put("userid", user.getUserId());
				data.put("nome", HtmlUtil.escapeAttribute(user.getFullName()));
				%>

				<aui:button cssClass="selector-button" data="<%= data %>" value="choose" />
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	var Util = Liferay.Util;

	A.one('#<portlet:namespace />openUsuarioSelectorFm').delegate(
		'click',
		function(event) {
			var result = Util.getAttributes(event.currentTarget, 'data-');

			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);
			
			Util.getWindow().hide();
		},
		'.selector-button'
	);
</aui:script>