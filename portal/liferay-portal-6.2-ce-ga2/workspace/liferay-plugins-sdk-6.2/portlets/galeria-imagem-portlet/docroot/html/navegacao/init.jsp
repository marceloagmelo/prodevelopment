<%@ include file="../init.jsp"%>

<%@page import="br.com.prodevelopment.portlet.galeriaimagem.navegacao.Constantes"%>

<%
String portletResource = ParamUtil.getString(request, Constantes.PORTLET_RESOURCE);
long folderId = ParamUtil.getLong(request, Constantes.FOLDER_ID);
int pageSize = ParamUtil.getInteger(request, Constantes.PAGE_SIZE);
String folderIdAnterior = (String)request.getAttribute(Constantes.FOLDER_ID_ANTERIOR);

boolean prefExibirTituloPortlet = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_EXIBIR_TITULO_PORTLET, Constantes.DEFAULT_PREF_EXIBIR_TITULO));
long prefFolderId = GetterUtil.getLong(preferences.getValue(Constantes.PREF_FOLDER_ID, Constantes.ZERO));

if (Validator.isNull(folderId)) {
	folderId = prefFolderId;
}
%>
