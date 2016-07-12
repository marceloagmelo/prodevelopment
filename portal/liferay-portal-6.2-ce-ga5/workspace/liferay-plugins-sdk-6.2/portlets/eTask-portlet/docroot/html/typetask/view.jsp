<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");

	PortletURL portletURL = renderResponse.createRenderURL();

	pageContext.setAttribute("portletURL", portletURL);

	String portletURLString = portletURL.toString();
	String message = (TrashUtil.isTrashEnabled(scopeGroupId) ? UnicodeLanguageUtil
			.get(pageContext, "are-you-sure-you-want-to-recycle-this")
			: UnicodeLanguageUtil
					.get(pageContext,
							"are-you-sure-you-want-to-delete-the-selected-entries"));
	String moveTrashAction = ParamUtil.getString(request, TypeTaskConstants.MOVE_TRASH_ACTION);
	String restoreAction = ParamUtil.getString(request, TypeTaskConstants.RESTORE_ACTION);
	String deleteAction = ParamUtil.getString(request, TypeTaskConstants.DELETE_ACTION);
	long typeTaskId = ParamUtil.getLong(request, TypeTaskConstants.TYPE_TASK_ID);
	String restoreTypeTaskIds = ParamUtil.getString(request, TypeTaskConstants.RESTORE_TYPE_TASK_IDS);
	String deleteTypeTaskNames = ParamUtil.getString(request, TypeTaskConstants.DELETE_TYPE_TASK_NAMES);
	String restoreTypeTaskNames = ParamUtil.getString(request, TypeTaskConstants.RESTORE_TYPE_TASK_NAMES);
	if (TypeTaskConstants.UM.equals(moveTrashAction)) {
%>
	    <portlet:actionURL var="restoreURL"/>
<%
		for (String retval: deleteTypeTaskNames.split(StringPool.SEMICOLON)){
%>		
			<div class="alert alert-success">
				<liferay-ui:message arguments="<%= new Object[] {retval} %>" key="the-x-was-moved-to-recycle-bin" />
			</div>
<%
		}
%>			
		<aui:form action="<%= restoreURL %>" name="undoForm">
			<aui:input name="<%=Constants.CMD %>" type="hidden" value="<%=Constants.RESTORE %>"/>
			<aui:input name="<%=TypeTaskConstants.RESTORE_TYPE_TASK_IDS %>" type="hidden" value="<%=restoreTypeTaskIds %>"/>
			<aui:button cssClass="trash-undo-button" type="submit" value="undo" />
		</aui:form>
<%
	}
	else if (TypeTaskConstants.UM.equals(restoreAction)) {
		for (String retval: restoreTypeTaskNames.split(StringPool.SEMICOLON)){
%>		
			<div class="alert alert-success">
				<liferay-ui:message arguments="<%= new Object[] {retval} %>" key="the-x-was-restored" />
			</div>
<%
		}
	}
	else if (TypeTaskConstants.UM.equals(deleteAction)) {
		for (String retval: deleteTypeTaskNames.split(StringPool.SEMICOLON)){
%>		
		<div class="alert alert-success">
			<liferay-ui:message arguments="<%= new Object[] {retval} %>" key="the-x-was-removed" />
		</div>
<%
		}
	}
%>

<%@include file="message.jspf"%>

<div class="typetask-portlet" id="<portlet:namespace/>">
	<aui:form action="<%=portletURLString%>" method="get" name="fm">
		<liferay-portlet:renderURLParams varImpl="portletURL" />
		<aui:input name="deleteTagIds" type="hidden" />

		<%
			List<String> headerNames = new ArrayList<String>();
				headerNames.add(TypeTaskConstants.NAME);
				if (WorkflowDefinitionLinkLocalServiceUtil
						.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(),
								scopeGroupId, TypeTask.class.getName())) {
					headerNames.add(TypeTaskConstants.STATUS);
				}
				headerNames.add(StringPool.BLANK);
				TypeTaskSearch searchContainer = new TypeTaskSearch(
						renderRequest, portletURL, headerNames);
		%>

		<aui:nav-bar>
			<aui:nav>
				<c:if test="<%=permissaoAddTypeTask%>">
					<portlet:renderURL var="addURL">
						<portlet:param name="jspPage"
							value="/html/typetask/edit_typetask.jsp" />
						<portlet:param name="redirect" value="<%=currentURL%>" />
					</portlet:renderURL>

					<aui:nav-item href="<%=addURL%>" iconCssClass="icon-plus"
						label="add" />
				</c:if>
				<c:if test="<%=permissaoConfigTypeTask%>">
					<liferay-security:permissionsURL
						modelResource="<%=TypeTaskConstants.RESOURCE_TYPE_TICKET%>"
						modelResourceDescription="<%=HtmlUtil.escape(themeDisplay
									.getScopeGroupName())%>"
						resourcePrimKey="<%=String.valueOf(scopeGroupId)%>"
						var="permissionsURL"
						windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

					<aui:nav-item href="<%=permissionsURL%>" label="permissions"
						title="edit-permissions" useDialog="<%=true%>" />
				</c:if>

				<c:if test="<%=permissaoDeleteTypeTask%>">
					<aui:nav-item cssClass="hide" dropdown="<%=true%>"
						id="tagsActionsButton" label="actions">
						<aui:nav-item id='deleteSelectedTags'
							iconCssClass='<%=TrashUtil
										.isTrashEnabled(scopeGroupId) ? "icon-trash"
										: "icon-remove"%>'
							label='<%=TrashUtil
										.isTrashEnabled(scopeGroupId) ? "move-to-the-recycle-bin"
										: "delete"%>' />
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
							if (confirm('<%=message%>')) {
								<portlet:actionURL var="deleteURL">
							<portlet:param name="<%=TypeTaskConstants.PORTLET_ACTION%>"
								value="deletarSelecionados" />
							<portlet:param name="redirect" value="<%=currentURL%>" />
							<portlet:param name="<%=Constants.CMD%>"
								value="<%=TrashUtil
											.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH
											: Constants.DELETE%>" />
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
				searchContainer="<%=searchContainer%>">
				<div class="form-search">
					<liferay-ui:input-search
						autoFocus="<%=windowState.equals(WindowState.MAXIMIZED)%>"
						name="<%=TypeTaskConstants.NAME%>"
						placeholder='<%=LanguageUtil.get(locale, "keywords")%>' />
				</div>

			</aui:nav-bar-search>
		</aui:nav-bar>

		<%
				TypeTaskDisplayTerms searchTerms = (TypeTaskDisplayTerms) searchContainer
							.getSearchTerms();
	
				List<TypeTask> results = null;
				int total = 0;
				if (WorkflowDefinitionLinkLocalServiceUtil
						.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(),
								scopeGroupId, TypeTask.class.getName())) {
					int[ ] status = {WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_PENDING};
					results = TypeTaskUtil.search(
							themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId(), searchTerms.getName(),
							status,
							searchContainer.getStart(), searchContainer.getEnd(),
							searchContainer.getOrderByComparator(),
							themeDisplay.getPermissionChecker());

					total = TypeTaskUtil.searchCount(
							themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId(), searchTerms.getName(),
							status,
							themeDisplay.getPermissionChecker());
					
				} else {
					int[ ] status = {WorkflowConstants.STATUS_APPROVED};
					results = TypeTaskUtil.search(
							themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId(), searchTerms.getName(),
							status,
							searchContainer.getStart(), searchContainer.getEnd(),
							searchContainer.getOrderByComparator(),
							themeDisplay.getPermissionChecker());

					total = TypeTaskUtil.searchCount(
							themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId(), searchTerms.getName(),
							status,
							themeDisplay.getPermissionChecker());
				}

				searchContainer.setTotal(total);

				searchContainer.setResults(results);

				searchContainer.setRowChecker(new RowChecker(renderResponse));

				List resultRows = searchContainer.getResultRows();

				for (int i = 0; i < results.size(); i++) {
					TypeTask typeTask = (TypeTask) results.get(i);

					ResultRow row = new ResultRow(typeTask,
							typeTask.getTypeTaskId(), i);

					PortletURL rowURL = renderResponse.createRenderURL();
					rowURL.setParameter("jspPage",
							"/html/typetask/edit_typetask.jsp");
					rowURL.setParameter(TypeTaskConstants.TYPE_TASK_ID,
							String.valueOf(typeTask.getTypeTaskId()));
					rowURL.setParameter(TypeTaskConstants.ACTION,
							ActionKeys.VIEW);
					rowURL.setParameter("backURL", currentURL);

					// Nome
					row.addText(typeTask.getName(locale), rowURL);

					if (WorkflowDefinitionLinkLocalServiceUtil
							.hasWorkflowDefinitionLink(
									themeDisplay.getCompanyId(), scopeGroupId,
									TypeTask.class.getName())) {
						// Status
						String statusLabel = WorkflowConstants.getStatusLabel(typeTask.getStatus());
						String statusName = (typeTask.isPending() ? LanguageUtil
								.get(locale, WorkflowConstants.LABEL_PENDING) : LanguageUtil
								.get(locale, statusLabel));
						StringBundler sb = new StringBundler();
						sb.append("<span class='taglib-workflow-status'>");
						sb.append("<span class=''workflow-status'>");
						sb.append("<strong class='label workflow-status-");
						sb.append(WorkflowConstants.getStatusLabel(typeTask.getStatus()));
						sb.append(StringPool.SPACE);
						sb.append(WorkflowConstants.getStatusCssClass(typeTask.getStatus()));
						sb.append(" workflow-value'>");
						sb.append(statusName);
						sb.append("</span>");
						sb.append("</span>");
						sb.append("</strong>");
						row.addText(sb.toString());
						
					}

					row.addJSP("right", SearchEntry.DEFAULT_VALIGN,
							"/html/typetask/action.jsp",
							this.getServletContext(), request, response);

					// Add result row
					resultRows.add(row);
				}
		%>

		<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	</aui:form>
</div>
