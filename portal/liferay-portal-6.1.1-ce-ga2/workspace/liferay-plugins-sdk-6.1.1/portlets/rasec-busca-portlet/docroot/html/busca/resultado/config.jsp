<%@ include file="init.jsp"%>

<jsp:useBean class="java.lang.String" id="prefProdutoEstrutura" scope="request" />
<jsp:useBean class="java.lang.String" id="prefFornecedorEstrutura" scope="request" />
<jsp:useBean class="java.lang.String" id="prefVideoEstrutura" scope="request" />

<%
List<JournalStructure> listaEstrutura = (List) request.getAttribute(Constantes.LISTA_ESTRUTURA);

%>

<liferay-portlet:actionURL portletConfiguration="true" var="configuracaoURL" />


<form action="<%=configuracaoURL%>" method="post">

	<fieldset>
		<legend>
			<liferay-ui:message key="produto" />
		</legend>

		<liferay-ui:message key="Estrutura" />
				<br>
					<select name="<%=Constantes.PREF_PRODUTO_ESTRUTURA%>">
						<option value="" selected="selected"/>
						<%
							if (listaEstrutura != null) {
							for (Iterator it = listaEstrutura.iterator(); it.hasNext();) {
									JournalStructure estrutura = (JournalStructure) it.next();
									if (estrutura.getStructureId().equals(prefProdutoEstrutura)) {
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
							}
						%>
					</select>
				<br>
				<liferay-ui:message key="pagina-destino" />
				<br>
				<input type="text" size="30px" name="<%=Constantes.PREF_PRODUTO_PAGINA_DESTINO%>" value="${prefProdutoPaginaDestino}">
	</fieldset>
	<fieldset>
		<legend>
			<liferay-ui:message key="fornecedor" />
		</legend>

		<liferay-ui:message key="Estrutura" />
				<br>
					<select name="<%=Constantes.PREF_FORNECEDOR_ESTRUTURA%>">
						<option value="" selected="selected"/>
						<%
							if (listaEstrutura != null) {
							for (Iterator it = listaEstrutura.iterator(); it.hasNext();) {
									JournalStructure estrutura = (JournalStructure) it.next();
									if (estrutura.getStructureId().equals(prefFornecedorEstrutura)) {
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
							}
						%>
					</select>
				<br>
				<liferay-ui:message key="pagina-destino" />
				<br>
				<input type="text" size="30px" name="<%=Constantes.PREF_FORNECEDOR_PAGINA_DESTINO%>" value="${prefFornecedorPaginaDestino}">
	</fieldset>
	<fieldset>
		<legend>
			<liferay-ui:message key="video" />
		</legend>

		<liferay-ui:message key="Estrutura" />
				<br>
					<select name="<%=Constantes.PREF_VIDEO_ESTRUTURA%>">
						<option value="" selected="selected"/>
						<%
							if (listaEstrutura != null) {
							for (Iterator it = listaEstrutura.iterator(); it.hasNext();) {
									JournalStructure estrutura = (JournalStructure) it.next();
									if (estrutura.getStructureId().equals(prefVideoEstrutura)) {
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
							}
						%>
					</select>
	</fieldset>
	<fieldset>
		<legend>
			<liferay-ui:message key="config-palavras-relevantes" />
		</legend>


		<div style="float:left">
			<liferay-ui:message key="palavras-default" />
			<br>
			<select size="20" id="listaStopWords">
				<c:forEach var="itemLista" items="${listaStopWords}">
					<option>${itemLista}</option>
				</c:forEach>
			</select>
		</div>
		<div style="float:left;margin-left:10px">
			<liferay-ui:message key="lista-do-usuario" />
			<br>
			<textarea rows="18" cols="7" name="listaUsuario">${listaUsuario}</textarea>
		</div>
	</fieldset>
	<br> <input type="submit" value="<liferay-ui:message key="salvar" />">
</form>
