<%@include file="init.jsp"%>
<%@ include file="mensagens.jspf"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<aui:form method="post" action="${configuracaoURL}" name="fm">
	<aui:input inlineLabel="left" label="label.pref.atividade.somente.esse.site"
		name="<%=Constantes.PREF_SOMENTE_ESSE_SITE %>" type="checkbox"
		value="${prefSomenteEsseSite }" />
	<aui:button type="submit" />
</aui:form>