<%@ include file="init.jsp"%>

<%
long funcionarioId = ParamUtil.getLong(request, Constantes.FUNCIONARIO_ID);
Funcionario funcionario = FuncionarioUtil.getFuncionario(funcionarioId);
long maxFileSize = PrefsPropsUtil.getLong(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE) / 1024;
%>

<c:choose>
	<c:when test='<%= SessionMessages.contains(renderRequest, "requestProcessed") %>'>
		<aui:script>
			Liferay.Util.getOpener().<portlet:namespace />changeLogo('<%= funcionario.getFotoURL(themeDisplay) %>');

			Liferay.Util.getWindow().hide();
		</aui:script>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="editFotoURL" name="atualizarFoto">
			<portlet:param name="<%=Constantes.FUNCIONARIO_ID %>" value="<%= String.valueOf(funcionario.getFuncionarioId()) %>" />
		</portlet:actionURL>

		<aui:form action="<%= editFotoURL %>" enctype="multipart/form-data" method="post" name="fm">
			<aui:input name="cropRegion" type="hidden" />

			<liferay-ui:error exception="<%= FotoFuncionarioTamanhoException.class %>">
				<liferay-ui:message arguments="<%= PrefsPropsUtil.getLong(PropsKeys.USERS_IMAGE_MAX_SIZE) / 1024 %>" key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x" />
			</liferay-ui:error>

			<aui:fieldset cssClass="lfr-portrait-editor">
				<aui:input autoFocus="<= windowState.equals(WindowState.MAXIMIZED) %>" label='<%= LanguageUtil.format(pageContext, "upload-images-no-larger-than-x-k", maxFileSize, false) %>' name="fileName" size="50" type="file" />

				<div class="lfr-change-logo lfr-portrait-preview" id="<portlet:namespace />portraitPreview">
					<img class="lfr-portrait-preview-img" id="<portlet:namespace />portraitPreviewImg" src="<%= HtmlUtil.escape(funcionario.getFotoURL(themeDisplay)) %>" />
				</div>

				<aui:button-row>
					<aui:button name="submitButton" type="submit" />

					<aui:button onClick="window.close();" type="cancel" value="close" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>

		<aui:script use="liferay-logo-editor">
			var logoEditor = new Liferay.LogoEditor(
				{
					maxFileSize: '<%= maxFileSize %>',
					namespace: '<portlet:namespace />',
					previewURL: '<portlet:resourceURL><portlet:param name="javax.portlet.action" value="atualizarFoto" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.GET_TEMP %>" /><portlet:param name="<%=Constantes.FUNCIONARIO_ID %>" value="<%= String.valueOf(funcionario.getFuncionarioId()) %>" /></portlet:resourceURL>',
					uploadURL: '<portlet:actionURL><portlet:param name="javax.portlet.action" value="atualizarFoto" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="<%=Constantes.FUNCIONARIO_ID %>" value="<%= String.valueOf(funcionario.getFuncionarioId()) %>" /></portlet:actionURL>'
				}
			);

			if (Liferay.Util.getTop() !== A.config.win) {
				var dialog = Liferay.Util.getWindow();

				if (dialog) {
					dialog.on('resize:end', logoEditor.resize, logoEditor);
					dialog.on('resize:resize', logoEditor.resize, logoEditor);
					dialog.on('resize:start', logoEditor.resize, logoEditor);
				}
			}
		</aui:script>
	</c:otherwise>
</c:choose>