<%@ include file="/html/init.jsp"%>

<%
	PortletPreferences prefs = renderRequest.getPreferences();

	List<Teste> listaTeste = (List<Teste>) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_TESTE);
	if (listaTeste == null) {
		listaTeste = new ArrayList<Teste>();
	}
	String prefEnviarEmail = (String) request
			.getAttribute(Constantes.PREF_ENVIAR_EMAIL);
	String prefExibirAcerto = (String) request
			.getAttribute(Constantes.PREF_EXIBIR_ACERTO);
	String exibirTitulo = (String) request.getAttribute(Constantes.PREF_EXIBIR_TITULO);
%>

<liferay-ui:error key="erro.portlet" message="erro.portlet" />

<jsp:useBean class="java.lang.String" id="operacao" scope="request" />
<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />
<form action="<%=configuracaoURL%>" method="post" name="fm">
	<table border="0" cellpadding="0" cellspacing="0" class="form_portlet">
		<tr>
			<td><liferay-ui:message key="label.testeUsuario.teste" />
				<p>
					<select name="prefIdTeste" id="prefIdTeste">
						<%
							if (listaTeste != null) {
								for (Iterator<Teste> it = listaTeste.iterator(); it.hasNext();) {
									Teste teste = (Teste) it.next();
									String id = String.valueOf(teste.getId());
						%>
						<option value="<%=id%>"><%=teste.getTituloCurrentValue()%></option>
						<%
							}
							}
						%>
					</select>
				</p>
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.testeUsuario.enviarEmail" />
				<p>
					<select name="<%=Constantes.PREF_ENVIAR_EMAIL%>">
						<%
							if (Constantes.N.equals(prefEnviarEmail)) {
						%>
						<option value="S"><liferay-ui:message key="label.sim" /></option>
						<option value="N" selected="true"><liferay-ui:message key="label.nao" /></option>
						<%
							} else {
						%>
						<option value="S" selected="true"><liferay-ui:message key="label.sim" /></option>
						<option value="N"><liferay-ui:message key="label.nao" /></option>
						<%
							}
						%>
					</select>
				</p></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.testeUsuario.exibirAcerto" />
				<p>
					<select name="<%=Constantes.PREF_EXIBIR_ACERTO%>">
						<%
							if (Constantes.N.equals(prefExibirAcerto)) {
						%>
						<option value="S"><liferay-ui:message key="label.sim" /></option>
						<option value="N" selected="true"><liferay-ui:message key="label.nao" /></option>
						<%
							} else {
						%>
						<option value="S" selected="true"><liferay-ui:message key="label.sim" /></option>
						<option value="N"><liferay-ui:message key="label.nao" /></option>
						<%
							}
						%>
					</select>
				</p></td>
		</tr>
		</tr>
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
	</table>
	<br> <input type="submit"
		value="<liferay-ui:message key="botao.salvar" />" />
</form>