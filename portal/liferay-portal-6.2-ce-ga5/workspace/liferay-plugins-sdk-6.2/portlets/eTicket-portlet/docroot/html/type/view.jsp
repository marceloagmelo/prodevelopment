<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");

	PortletURL portletURL = renderResponse.createRenderURL();

	pageContext.setAttribute("portletURL", portletURL);

	String portletURLString = portletURL.toString();
%>

<%@ include file="mensagens.jspf"%>

<aui:form action="<%=portletURLString%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:input name="deleteTagIds" type="hidden" />

<%
TypeTicketSearch searchContainer = new TypeTicketSearch(
		renderRequest, portletURL);

List headerNames = searchContainer.getHeaderNames();

headerNames.add(StringPool.BLANK);
%>

	<aui:nav-bar>
		<aui:nav>
			<c:if test='<%= permissaoAddTypeTicket %>'>
				<portlet:renderURL var="addURL">
					<portlet:param name="jspPage" value="/html/funcionario/cadastro.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:renderURL>

				<aui:nav-item href="<%=addURL%>"
					iconCssClass="icon-plus" label="add" />
			</c:if>
			<c:if test='<%= permissaoConfigTypeTicket %>'>
				<liferay-security:permissionsURL
					modelResource="br.com.prodevelopment.funcionario"
					modelResourceDescription="<%=HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
					resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
					var="permissionsURL"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>"
				/>
				
				<aui:nav-item href="<%= permissionsURL %>" label="permissions" title="edit-permissions" useDialog="<%= true %>" />
			</c:if>
			
			<c:if test='<%= permissaoDeleteTypeTicket %>'>
				<aui:nav-item cssClass="hide" dropdown="<%=true%>"
					id="tagsActionsButton" label="actions">
					<aui:nav-item cssClass="item-remove" iconCssClass="icon-remove"
						id="deleteSelectedTags" label="delete" />
				</aui:nav-item>
				
				<aui:script use="aui-base,liferay-util-list-fields">
					A.one('#<portlet:namespace /><%=searchContainerReference.getId()%>SearchContainer').delegate(
						'click',
						function() {
							var hide = (Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace /><%=RowChecker.ALL_ROW_IDS%>').length == 0);
				
							A.one('#<portlet:namespace />tagsActionsButton').toggle(!hide);
						},
						'input[type=checkbox]'
					);
				
					A.one('#<portlet:namespace />deleteSelectedTags').on(
						'click',
						function() {
							if (confirm('<liferay-ui:message
						key="are-you-sure-you-want-to-delete-this" />')) {
								<portlet:actionURL var="deleteURL">
						<portlet:param name="<%=TypeTicketConstants.PORTLET_ACTION %>" value="deletarSelecionados" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
					</portlet:actionURL>
				
								document.<portlet:namespace />fm.method = "post";
								document.<portlet:namespace />fm.<portlet:namespace />deleteTagIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
								
								submitForm(document.<portlet:namespace />fm, '<%=deleteURL%>');
							}
						}
					);
				</aui:script>
				
			</c:if>

		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right"
			searchContainer="<%= searchContainer %>">
			<div class="form-search">
				<liferay-ui:input-search
					autoFocus="<%=windowState.equals(WindowState.MAXIMIZED)%>"
					name="<%=TypeTicketConstants.NAME %>"
					placeholder='<%=LanguageUtil.get(locale, "keywords")%>' />
			</div>

		</aui:nav-bar-search>
	</aui:nav-bar>

	<%
		TypeTicketDisplayTerms searchTerms = (TypeTicketDisplayTerms) searchContainer
					.getSearchTerms();

		List<TypeTicket> results = TypeTicketUtil.search(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
				searchTerms.getName(), searchContainer.getOrderByComparator(), themeDisplay.getPermissionChecker());

		int total = results.size();

		searchContainer.setTotal(total);

		searchContainer.setResults(results);
		
		searchContainer.setRowChecker(new RowChecker(renderResponse));

		List resultRows = searchContainer.getResultRows();

		for (int i = 0; i < results.size(); i++) {
			TypeTicket typeTicket = (TypeTicket) results.get(i);

			ResultRow row = new ResultRow(typeTicket,
					typeTicket.getTypeTicketId(), i);
			
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setParameter("jspPage", "/html/funcionario/cadastro.jsp");
			rowURL.setParameter(TypeTicketConstants.TYPE_TICKET_ID, String.valueOf(typeTicket.getTypeTicketId()));
			rowURL.setParameter(TypeTicketConstants.ACAO, ActionKeys.VIEW);
			rowURL.setParameter("backURL", currentURL);
			
			// Nome
			row.addText(HtmlUtil.escape(typeTicket.getName()),
					rowURL);

			row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/type/action.jsp");

			// Add result row

			resultRows.add(row);
		}
	%>

	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</aui:form>