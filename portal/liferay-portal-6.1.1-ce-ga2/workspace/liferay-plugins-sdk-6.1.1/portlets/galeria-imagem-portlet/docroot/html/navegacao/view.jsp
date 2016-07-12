<%@ include file="init.jsp"%>
<%
List<Folder> listaPastas = (List<Folder>) request.getAttribute("listaPastas");
if (listaPastas == null) {
	listaPastas = new ArrayList<Folder>();
}
%>
<!-- Essa div cerca tudo -->
<liferay-ui:success key="mensagem.nao.existem.pastas"
	message="mensagem.nao.existem.pastas" />
<liferay-portlet:actionURL name="renderiza" var="voltarURL">
	<liferay-portlet:param name="folderId"
		value="<%=String.valueOf(folderIdAnterior)%>" />
</liferay-portlet:actionURL>
<div class="galeria_imagem_navegacao">
	<%
	if (prefExibirTituloPortlet) {
	%>
	<h3>${tituloPortlet }</h3>
	<%	
	}
	%>
	<div class="conteudo">
		<%if (prefFolderId != folderId) {%>
		<div class="nomePasta">${folderNome }</div>
		<%} %>
		<div class="conteudoTexto">
			<ul>
			<%
				for (Folder pasta : listaPastas) {
			%>
			<liferay-portlet:actionURL name="renderiza" var="renderizaURL">
				<liferay-portlet:param name="folderId"
					value="<%=String.valueOf(pasta.getFolderId())%>" />
			</liferay-portlet:actionURL>
			<li>
				<a href="<%=renderizaURL%>"><%=pasta.getName()%></a>
			</li>
			<%
				}
			%>
			</ul>
		</div>
		<%if (prefFolderId != folderId) {%>
		<a class="voltar" href="<%=voltarURL%>"><liferay-ui:message key="label.voltar" /></a>
		<%}%>
		
	</div>
</div>
