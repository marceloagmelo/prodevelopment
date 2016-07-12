<%@ include file="/html/init.jsp"%>
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String exibirTitulo = (String) request.getAttribute(Constantes.PREF_EXIBIR_TITULO);
	
	List<Pesquisa> listaPesquisa = (List<Pesquisa>) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA);
	if (listaPesquisa == null) {
		listaPesquisa = new ArrayList<Pesquisa>();
	}
	String prefAnonima = (String) request
			.getAttribute(Constantes.PREF_ANONIMA);
	String prefEnviarEmail = (String) request
			.getAttribute(Constantes.PREF_ENVIAR_EMAIL);
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
			<td><liferay-ui:message key="label.pesquisaUsuario.pesquisa" />
				<p>
					<select name="prefIdPesquisa" id="prefIdPesquisa">
						<%
							if (listaPesquisa != null) {
								for (Iterator<Pesquisa> it = listaPesquisa.iterator(); it
										.hasNext();) {
									Pesquisa pesquisa = (Pesquisa) it.next();
									String id = String.valueOf(pesquisa.getId());
						%>
						<option value="<%=id%>"><%=pesquisa.getTituloCurrentValue()%></option>
						<%
							}
							}
						%>
					</select>
				</p>
			</td>
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
		<tr>
			<td><liferay-ui:message key="label.pesquisaUsuario.anonima" />
				<p>
					<select name="<%=Constantes.PREF_ANONIMA%>">
						<%
							if (Constantes.N.equals(prefAnonima)) {
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
				</p>
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.pesquisaUsuario.enviarEmail" />
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
				</p>
			</td>
		</tr>
	</table>
	<br> <input type="submit"
		value="<liferay-ui:message key="botao.salvar" />" /></fieldset>

</form>