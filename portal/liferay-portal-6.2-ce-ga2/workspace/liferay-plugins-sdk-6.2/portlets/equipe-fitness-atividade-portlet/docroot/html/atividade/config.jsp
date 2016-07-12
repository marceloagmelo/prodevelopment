<%@include file="init.jsp"%>
<%@ include file="mensagens.jspf"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<aui:form method="post" action="${configuracaoURL}" name="fm">
	<aui:fieldset>
		<aui:select name="<%=Constantes.PREF_QUANTIDADE_ITENS%>" label="label.pref.quantidade.itens">
			<%
				for (int i = 1; i <= 6; i++) {
			%>
				<aui:option label="<%=i %>" selected="<%=i == prefQuantidadeItens %>" value="<%=i %>"/>
			<%
				}
			%>
		</aui:select>
		<aui:select name="<%=Constantes.PREF_INTERVALO_SEGUNDOS%>" label="label.pref.intervalo.segundos">
			<%
				for (int i = 1; i <= 10; i++) {
			%>
				<aui:option label="<%=i %>" selected="<%=i == prefIntervaloSegundos %>" value="<%=i %>"/>
			<%
				}
			%>
		</aui:select>
		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>

	</aui:fieldset>
</aui:form>