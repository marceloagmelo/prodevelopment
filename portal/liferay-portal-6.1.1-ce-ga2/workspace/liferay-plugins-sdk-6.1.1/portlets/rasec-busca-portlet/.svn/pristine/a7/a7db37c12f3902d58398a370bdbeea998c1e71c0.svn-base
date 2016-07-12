<%@include file="init.jsp"%>
<%@ include file="mensagem.jspf"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />
<form action="<%=configuracaoURL%>" method="post" name="fm">

	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><liferay-ui:message key="label.pref.urlDestino" />
				<p>
					<input type="text" name="<%=Constantes.PREF_URL_DESTINO%>"
						value="${prefUrlDestino }" size="100" />
				</p></td>
		</tr>
	</table>
	<br> <input type="submit"
		value="<liferay-ui:message key="botao.salvar" />" />
</form>