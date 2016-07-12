<%@ include file="/html/init.jsp"%>
<%
	PortletPreferences prefs = renderRequest.getPreferences();
%>
<jsp:useBean class="java.lang.String" id="operacao" scope="request" />
<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />
<form action="<%=configuracaoURL%>" method="post" name="fm">

	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><liferay-ui:message key="label.trabalheConosco.cargos" />
				<p>
					<textarea rows="10" cols="80" name="prefCargos">${prefCargos }</textarea>
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.trabalheConosco.emails" /><br>
				<textarea rows="10" cols="80" name="prefEmails">${prefEmails }</textarea>
			</td>
		</tr>
	</table>
	<br> <input type="submit"
		value="<liferay-ui:message key="botao.salvar" />" />
</form>