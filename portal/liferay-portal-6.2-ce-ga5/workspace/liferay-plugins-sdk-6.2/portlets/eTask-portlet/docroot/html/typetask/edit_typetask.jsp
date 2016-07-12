<%@ include file="init.jsp"%>

<%
	String tabs1 = ParamUtil.getString(request, TypeTaskConstants.TABS1, "edit");
	String tabs2 = ParamUtil.getString(request, TypeTaskConstants.TABS2, "current");
	String tabs3 = ParamUtil.getString(request, TypeTaskConstants.TABS3, "current");
	String keywords = ParamUtil.getString(request, TypeTaskConstants.KEYWORDS);
	
	if (Validator.isNull(redirect)) {
		redirect = PortalUtil.getCurrentURL(request);
	}

	TypeTask typeTask = (TypeTask) request
			.getAttribute(TypeTaskConstants.TYPE_TASK);

	long typeTaskId = BeanParamUtil.getLong(typeTask, request,
			TypeTaskConstants.TYPE_TASK_ID);

	boolean approved = false;
	boolean pending = false;

	String labelName = "label-add-typetask";
	long DDMStructureId = 0;
	String description = StringPool.BLANK;
	String saveButtonLabel = LanguageUtil.get(pageContext, "save");
	if ((WorkflowDefinitionLinkLocalServiceUtil
			.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(),
					scopeGroupId, TypeTask.class.getName()))
			&& (typeTaskId == 0)) {
		saveButtonLabel = "submit-for-publish";
	}
	if (Validator.isNotNull(typeTask)) {
		DDMStructureId = BeanParamUtil.getLong(typeTask, request,
				TypeTaskConstants.DDM_STRUCTURE_ID,
				typeTask.getDDMStructureId());
		if (TypeTaskConstants.VIEW.equals(action)) {
			labelName = HtmlUtil.escape(typeTask.getName(locale));
		} else {
			labelName = LanguageUtil.format(pageContext,
					"label-update-typetask.x",
					HtmlUtil.escape(typeTask.getName(locale)));
		}
		description = typeTask.getDescription();

		approved = typeTask.isApproved();

		if (WorkflowDefinitionLinkLocalServiceUtil
				.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(),
						scopeGroupId, TypeTask.class.getName())) {
			pending = typeTask.isPending();
		}
	}
	long groupId = BeanParamUtil.getLong(typeTask, request,
			TypeTaskConstants.GROUP_ID, scopeGroupId);
	long companyId = BeanParamUtil.getLong(typeTask, request,
			TypeTaskConstants.COMPANY_ID, themeDisplay.getCompanyId());
%>
<div class="typetask-portlet" id="<portlet:namespace/>">

	<div id="breadcrumb">
		<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
			showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
			showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
	</div>

	<portlet:renderURL var="renderURL" />

	<liferay-ui:header backURL="<%=renderURL%>" escapeXml="<%=false%>"
		localizeTitle="<%=(typeTask == null)%>" title='<%=labelName%>' />

	<liferay-portlet:renderURL var="portletURL">
		<portlet:param name="<%=TypeTaskConstants.MVC_PATH %>" value="<%=TypeTaskConstants.PATH_JSP_EDIT %>" />
		<portlet:param name="<%=TypeTaskConstants.TABS1 %>" value="<%=tabs1%>" />
		<portlet:param name="<%=TypeTaskConstants.TABS2 %>" value="<%=tabs2%>" />
		<portlet:param name="<%=TypeTaskConstants.TABS3 %>" value="<%=tabs3%>" />
		<portlet:param name="<%=TypeTaskConstants.REDIRECT %>" value="<%=redirect%>" />
		<portlet:param name="<%=TypeTaskConstants.BACK_URL %>" value="<%=backURL%>" />
		<portlet:param name="<%=TypeTaskConstants.KEYWORDS %>" value="<%=keywords%>" />
		<portlet:param name="<%=TypeTaskConstants.TYPE_TASK_ID %>"
			value="<%=(typeTask != null) ? String.valueOf(typeTask
						.getTypeTaskId()) : StringPool.BLANK%>" />
	</liferay-portlet:renderURL>

	<%@ include file="message.jspf"%>

	<liferay-ui:tabs
		names='<%=(typeTask == null) ? "edit"
					: "edit,tab-managers,tab-executors"%>'
		param="tabs1" url="<%=portletURL%>" />

	<c:choose>
		<c:when test='<%=tabs1.equals("edit")%>'>
			<%@ include file="edit_typetask_edit.jsp"%>
		</c:when>
		<c:when test='<%=tabs1.equals("tab-managers")%>'>
			<%@ include file="edit_typetask_managers.jsp"%>
		</c:when>
		<c:when test='<%=tabs1.equals("tab-executors")%>'>
			<%@ include file="edit_typetask_executors.jsp"%>
		</c:when>
	</c:choose>
</div>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />updateManagers',
		function() {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'update_users';
			document.<portlet:namespace />fm.<portlet:namespace />addUserIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
			document.<portlet:namespace />fm.<portlet:namespace />removeUserIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />updateExecutors',
		function() {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'update_users';
			document.<portlet:namespace />fm.<portlet:namespace />addUserIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
			document.<portlet:namespace />fm.<portlet:namespace />removeUserIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);
</aui:script>
