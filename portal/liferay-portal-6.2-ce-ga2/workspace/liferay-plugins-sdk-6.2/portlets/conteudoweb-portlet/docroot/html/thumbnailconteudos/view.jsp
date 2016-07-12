<%@include file="init.jsp"%>
<!-- inicio codigo portlet -->
<%
PortletURL portletURL = renderResponse.createRenderURL();

%>
<%@ include file="/html/common/mensagem.jspf"%>
<%
	if (Validator.isNull(articleId)) {
		if (Constantes.S.equals(prefExibirTitulo)) {
%>
	<liferay-ui:header escapeXml="<%=false%>"
		title="${portletTitulo }" />

<%
		}
%>
<%@ include file="listaConteudo.jspf"%>
<%
	} else {
%>
<%@ include file="/html/common/exibirConteudo.jspf"%>
<%
	}
%>
<!-- fim codigo portlet -->