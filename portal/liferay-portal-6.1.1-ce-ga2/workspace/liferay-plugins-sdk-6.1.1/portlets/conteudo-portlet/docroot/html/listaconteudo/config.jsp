<%@include file="init.jsp"%>
<%@ include file="mensagem.jspf"%>

<jsp:useBean class="java.lang.String" id="prefTipo" scope="request" />
<jsp:useBean class="java.lang.String" id="prefEstrutura" scope="request" />

<%
	List<JournalStructure> listaEstrutura = (List) request
			.getAttribute(Constantes.LISTA_ESTRUTURA);
	String paginacao = (String) request
			.getAttribute(Constantes.PREF_PAGINACAO);
	String ordenacao = (String) request
			.getAttribute(Constantes.PREF_ORDENACAO);
	String exibirTitulo = (String) request
			.getAttribute(Constantes.PREF_EXIBIR_TITULO);
	String exibir = (String) request
			.getAttribute(Constantes.PREF_EXIBIR);
%>
<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />
<form action="<%=configuracaoURL%>" method="post" name="fm">

	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><liferay-ui:message key="label.pref.exibirTitulo" />
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
				</p></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.pref.paginacao" />
				<p>
					<select name="<%=Constantes.PREF_PAGINACAO%>">
						<%
							if (Constantes.S.equals(paginacao)) {
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
				</p></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.pref.ordenacao" />
				<p>
					<select name="<%=Constantes.PREF_ORDENACAO%>">
						<%
							if (Field.TITLE.equals(ordenacao)) {
						%>
						<option value="title" selected="true"><liferay-ui:message key="label.ordenacao.titulo" /></option>
						<option value="modified"><liferay-ui:message key="label.ordenacao.dataAlteracao" /></option>
						<%
							} else {
						%>
						<option value="title"><liferay-ui:message key="label.ordenacao.titulo" /></option>
						<option value="modified" selected="true"><liferay-ui:message key="label.ordenacao.dataAlteracao" /></option>
						<%
							}
						%>
					</select>
				</p></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.pref.exibir" />
				<p>
					<select name="<%=Constantes.PREF_EXIBIR%>">
						<%
							if (Constantes.CONTEUDO.equals(exibir)) {
						%>
						<option value="conteudo" selected="true"><liferay-ui:message key="label.exibir.conteudo" /></option>
						<option value="resumo"><liferay-ui:message key="label.exibir.resumo" /></option>
						<%
							} else {
						%>
						<option value="conteudo"><liferay-ui:message key="label.exibir.conteudo" /></option>
						<option value="resumo" selected="true"><liferay-ui:message key="label.exibir.resumo" /></option>
						<%
							}
						%>
					</select>
				</p></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.pref.qtdeRegistros" />
				<p>
					<input type="text" name="<%=Constantes.PREF_QTDE_REGISTROS%>"
						value="${prefQtdeRegistros }" size="10" maxlength="2"
						onkeypress="return SomenteNumero(event)" />
				</p></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.pref.urlDestino" />
				<p>
					<input type="text" name="<%=Constantes.PREF_URL_DESTINO%>"
						value="${prefUrlDestino }" size="100" />
				</p></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.pref.tamanhoCaracteres" />
				<p>
					<input type="text" name="<%=Constantes.PREF_TAMANHO_CARACTERES%>"
						value="${prefTamanhoCaracteres }" size="10" maxlength="3"
						onkeypress="return SomenteNumero(event)" />
				</p></td>
		</tr>
		<%
			if (listaEstrutura != null) {
		%>
		<tr>
			<td><liferay-ui:message key="label.pref.estrutura" />
				<p>
					<select name="<%=Constantes.PREF_ESTRUTURA%>">
						<option value="" selected="selected">
							<liferay-ui:message key="label.todas" />
						</option>
						<%
							for (Iterator it = listaEstrutura.iterator(); it.hasNext();) {
									JournalStructure estrutura = (JournalStructure) it.next();
									if (estrutura.getStructureId().equals(prefEstrutura)) {
						%>
						<option value="<%=estrutura.getStructureId()%>"
							selected="selected"><%=estrutura.getName()%></option>
						<%
							} else {
						%>
						<option value="<%=estrutura.getStructureId()%>"><%=estrutura.getName()%></option>
						<%
							}
								}
						%>
					</select>
				</p>
			</td>
		</tr>
		<%
			}
		%>
		<tr>
			<td><liferay-ui:message key="label.pref.categoria" /> <liferay-ui:asset-categories-selector
					curCategoryIds="${prefCategoria}" /></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="label.pref.tag" /> <liferay-ui:asset-tags-selector curTags="${prefTag}" /></td>
		</tr>
		<tr>
			<td><aui:input inlineLabel="left" label="label.pref.exibirDataAlteracao"
				name="<%=Constantes.PREF_EXIBIR_DATA_ALTERACAO %>" type="checkbox" value="${prefExibirDataAlteracao }" /></td>
		</tr>
		<tr>
			<td><aui:input inlineLabel="left" label="label.pref.exibirLeiaMais"
				name="<%=Constantes.PREF_EXIBIR_LEIA_MAIS %>" type="checkbox" value="${prefExibirLeiaMais }" /></td>
		</tr>
	</table>
	<br> <input type="submit"
		value="<liferay-ui:message key="botao.salvar" />" />
</form>