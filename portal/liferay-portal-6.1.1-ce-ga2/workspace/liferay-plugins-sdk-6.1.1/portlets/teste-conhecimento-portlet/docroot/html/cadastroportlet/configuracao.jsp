<%@ include file="/html/init.jsp"%>
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String exibirTitulo = (String) request.getAttribute(Constantes.PREF_EXIBIR_TITULO);
	String somenteUsuarioLogado = (String) request.getAttribute(Constantes.SOMENTE_USUARIO_LOGADO);
%>

<liferay-ui:error key="erro.portlet" message="erro.portlet" />

<jsp:useBean class="java.lang.String" id="operacao" scope="request" />
<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />
<form action="<%=configuracaoURL%>" method="post" name="<portlet:namespace />configuracao">
<fieldset>
	<legend>
		<liferay-ui:message key="label.configuracao" />
	</legend>
	<table border="0" cellpadding="0" cellspacing="0" class="form_portlet">
		<tr>
			<td><liferay-ui:message key="label.exibir.titulo" />
				<p>
					<select name="<%=Constantes.PREF_EXIBIR_TITULO%>">
						<%
							if (Constantes.S.equals(exibirTitulo)) {
						%>
						<option value="S" selected="true"><liferay-ui:message key="label.sim" /></option>
						<option value="N"><liferay-ui:message key="label.nao" /></option>
						<%
							} else {
						%>
						<option value="S"><liferay-ui:message key="label.sim" /></option>
						<option value="N" selected="true"><liferay-ui:message key="label.nao" /></option>
						<%
							}
						%>
					</select>
				</p>
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.somenteLogado" />
				<p>
					<select name="<%=Constantes.SOMENTE_USUARIO_LOGADO%>">
						<%
							if (Constantes.S.equals(somenteUsuarioLogado)) {
						%>
						<option value="S" selected="true"><liferay-ui:message key="label.sim" /></option>
						<option value="N"><liferay-ui:message key="label.nao" /></option>
						<%
							} else {
						%>
						<option value="S"><liferay-ui:message key="label.sim" /></option>
						<option value="N" selected="true"><liferay-ui:message key="label.nao" /></option>
						<%
							}
						%>
					</select>
				</p>
			</td>
		</tr>
	</table>
	<br> <input type="submit"
		value="<liferay-ui:message key="botao.salvar" />" /></fieldset>

</form>