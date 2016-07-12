<portlet:actionURL var="saveURL"/>

<aui:form action="<%=saveURL%>" method="post" name="fmEdit"
	onSubmit='<%="event.preventDefault(); "
						+ renderResponse.getNamespace() + "saveTypeTask();"%>'>
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=(typeTaskId == 0) ? Constants.ADD
						: Constants.UPDATE%>" />
	<aui:input name="redirect" type="hidden" value="<%=redirect%>" />
	<aui:input name="backURL" type="hidden" value="<%=backURL%>" />
	<aui:input name="typeTaskId" type="hidden" value="<%=typeTaskId%>" />
	<aui:input name="groupId" type="hidden" value="<%=groupId%>" />
	<aui:input name="companyId" type="hidden" value="<%=companyId%>" />
	<aui:input name="xsd" type="hidden" />
	<aui:input name="userId" type="hidden"
		value="<%=String
						.valueOf(themeDisplay.getRealUser().getUserId())%>" />
	<aui:input name="DDMStructureId" type="hidden"
		value="<%=String.valueOf(DDMStructureId)%>" />
	<aui:input name="<%=TypeTaskConstants.TABS1 %>" type="hidden" value="<%=tabs1%>" />

	<%
		request.setAttribute(TypeTaskConstants.TYPE_TASK_ID, typeTaskId);
	%>

	<aui:model-context bean="<%=typeTask%>" model="<%=TypeTask.class%>" />

	<aui:fieldset>
		<aui:input label="label-name" name="<%=TypeTaskConstants.NAME%>">
			<aui:validator name="required" />
		</aui:input>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label-description">
			<liferay-ui:input-localized
				name="<%=TypeTaskConstants.DESCRIPTION%>" type="textarea" xml="<%=description %>" />
		</aui:field-wrapper>
		<aui:input name="customFieldsActive" />
	</aui:fieldset>
</aui:form>

<div id="<portlet:namespace />customFieldsSettings">
<%@ include file="edit_typetask_custom-fields.jsp"%>
</div>

<div class="separator">
	<!-- -->
</div>

<aui:button-row>
	<aui:button
		onClick='<%=renderResponse.getNamespace() + "saveTypeTask();"%>'
		primary="<%=true%>"
		value='<%=saveButtonLabel%>' />

	<aui:button href="<%=renderURL%>" type="cancel" />
</aui:button-row>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />saveTypeTask',
		function() {
			document.<portlet:namespace />fmEdit.<portlet:namespace />xsd.value = window.<portlet:namespace />formBuilder.getContentXSD();

			submitForm(document.<portlet:namespace />fmEdit);
		},
		['aui-base', 'liferay-portlet-dynamic-data-mapping']
	);
	Liferay.Util.toggleBoxes('<portlet:namespace />customFieldsActiveCheckbox', '<portlet:namespace />customFieldsSettings');
</aui:script>
