<%
	int foldersCount = 0;
	List<Long> subfolderIds = DLAppServiceUtil.getSubfolderIds(
			pasta.getRepositoryId(), pasta.getFolderId(), false);

	foldersCount = subfolderIds.size();

	subfolderIds.clear();
	subfolderIds.add(pasta.getFolderId());

	int fileEntriesCount = 0;
	fileEntriesCount = DLAppServiceUtil.getFoldersFileEntriesCount(
			pasta.getRepositoryId(), subfolderIds,
			WorkflowConstants.STATUS_APPROVED);
%>
<liferay-portlet:renderURL portletConfiguration="true"
	var="renderizaURL">
	<liferay-portlet:param name="folderId"
		value="<%=String.valueOf(pasta.getFolderId())%>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container-column-text name="folder" buffer="buffer">
	<%
		StringBuilder sbIconPastaUrl = new StringBuilder();

			sbIconPastaUrl.append(themeDisplay.getPathThemeImages());
			sbIconPastaUrl.append("/common/");
			sbIconPastaUrl.append("folder_full_document.png");

			buffer.append("<img src=\"");
			buffer.append(sbIconPastaUrl.toString());
			buffer.append("\">");
			buffer.append("<a href=\"");
			buffer.append(renderizaURL);
			buffer.append("\">");
			buffer.append(pasta.getName());
	%>
</liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="num-of-folders"
	buffer="buffer">
	<%
		buffer.append(String.valueOf(foldersCount));
	%>
</liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="num-of-documents"
	buffer="buffer">
	<%
		buffer.append(String.valueOf(fileEntriesCount));
	%>
</liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="<%=StringPool.BLANK%>"
	buffer="buffer">

	<%
	StringBuilder sb = new StringBuilder();

			sb.append("javascript: ");
			sb.append("formSubmit('");
			sb.append(pasta.getFolderId());
			sb.append("');");

			buffer.append("<a href=\"");
			buffer.append(sb.toString());
			buffer.append("\">");
			buffer.append(LanguageUtil.get(pageContext, "choose"));
	%>
</liferay-ui:search-container-column-text>
