<%@ include file="init.jsp"%>
<%
	PortletPreferences prefs = renderRequest.getPreferences();
%>
<jsp:useBean class="java.lang.String" id="operacao" scope="request" />
<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />
<aui:form method="post" action="<%=configuracaoURL%>" name="fm">

	<aui:input label="label.orcamento.emails"
		name="<%=Constantes.PREF_EMAILS%>" type="textarea" value="${prefEmails }"/>
	
	<aui:input label="label.orcamento.remetente" name="<%=Constantes.PREF_REMETENTE %>" value="${prefRemetente }"/>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>