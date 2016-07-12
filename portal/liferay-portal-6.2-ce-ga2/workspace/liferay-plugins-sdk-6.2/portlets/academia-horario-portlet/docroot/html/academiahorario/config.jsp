<%@include file="init.jsp"%>
<%@ include file="mensagens.jspf"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<aui:form method="post" action="${configuracaoURL}" name="fm">
	<aui:fieldset>
		<aui:input inlineLabel="left" label="label.pref.somente.esse.site"
			name="<%=Constantes.PREF_SOMENTE_ESSE_SITE %>"
			type="checkbox" value="<%=prefSomenteEsseSite %>" />
		<aui:select name="<%=Constantes.PREF_INTERVALO_MINUTO%>" label="label.pref.intervalo.minuto">
			<%
				for (int i = 1; i <= 30; i++) {
			%>
				<aui:option label="<%=i %>" selected="<%=i == prefIntervaloMinuto %>" value="<%=i %>"/>
			<%
				}
			%>
		</aui:select>
		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>

	</aui:fieldset>
</aui:form>