<%@ include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<%
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/portlet_configuration/edit_configuration");
portletURL.setParameter("portletResource", portletResource);

folderId=0;

String folderName = LanguageUtil.get(pageContext, "label.inicio");
Folder folder = (Folder)request.getAttribute("FOLDER");
if (folder != null) {
	folderName = folder.getName();
	folderId=folder.getFolderId();

	portletURL.setParameter(Constantes.FOLDER_ID, "0");
	
	Map<String, Object> data = new HashMap<String, Object>();

	data.put("direction-right", Boolean.TRUE.toString());
	data.put(Constantes.FOLDER_ID, 0);

	PortalUtil.addPortletBreadcrumbEntry(
			request, themeDisplay.translate(Constantes.HOME), portletURL.toString(),
			data);

	portletURL.setParameter(Constantes.FOLDER_ID, String.valueOf(folderId));

	DLUtil.addPortletBreadcrumbEntries(folder, request, portletURL);
}
%>
<aui:form method="post" id="fm" name="fm" action="<%=configuracaoURL%>">
	<%
if (folder != null) {
%>
	<liferay-ui:breadcrumb showCurrentGroup="<%= false %>"
		showCurrentPortlet="<%= false %>" showGuestGroup="<%= false %>"
		showLayout="<%= false %>" showParentGroups="<%= false %>" />
	<%
}
StringBuilder sbBotao = new StringBuilder();

sbBotao.append("javascript: ");
sbBotao.append("formSubmit('");
sbBotao.append(folderId);
sbBotao.append("');");
%>
	<aui:input name="folderIdSelecionado" id="folderIdSelecionado"
		type="hidden" value="${folderId }" />
	<aui:input name="folderId" id="folderId" type="hidden"
		value="${folderId }" />

	<!-- Essa div cerca tudo -->
	<div class="documentos_config">
		<%
		List<Folder> listaPastas = (List<Folder>) request
				.getAttribute(Constantes.LISTA_PASTAS);
		if (listaPastas == null) {
			listaPastas = new ArrayList<Folder>();
		}
	%>

		<p>
			<aui:button onClick="<%= sbBotao.toString() %>"
				value="botao.selecionar.esta.pasta" />
		</p>
		<liferay-ui:search-container
			emptyResultsMessage="mensagem.nao.existem.pastas"
			delta="<%=pageSize %>">
			<liferay-ui:search-container-results>
				<%
				results = ListUtil.subList(listaPastas,
									searchContainer.getStart(),
									searchContainer.getEnd());
							total = listaPastas.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.liferay.portal.kernel.repository.model.Folder"
				keyProperty="folderId" modelVar="pasta">
				<%@ include file="colunas.jsp"%>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>

		<fieldset>
			<aui:input label="label.quantidade.registro.pagina"
				name="<%=Constantes.PREF_QTDE_REGISTROS %>" type="input"
				value="${prefQtdeRegistros }" />
			<aui:input label="label.lagura.imagem"
				name="<%=Constantes.PREF_LARGURA_IMAGEM %>" type="input"
				value="${prefLarguraImagem }" />
			<aui:input label="label.altura.imagem"
				name="<%=Constantes.PREF_ALTURA_IMAGEM %>" type="input"
				value="${prefAlturaImagem }" />
		</fieldset>
		<fieldset>
			<aui:input inlineLabel="left" label="label.exibir.titulo.portlet"
				name="<%=Constantes.PREF_EXIBIR_TITULO_PORTLET %>" type="checkbox"
				value="${prefExibirTituloPortlet }" />
			<aui:input inlineLabel="left" label="label.exibir.titulo.pasta"
				name="<%=Constantes.PREF_EXIBIR_TITULO_PASTA %>" type="checkbox"
				value="${prefExibirTituloPasta }" />
		</fieldset>
		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>

	</div>
	<div class="clear"></div>
</aui:form>

<script>
	function formSubmit(folderId) {
		document.getElementById("_86_folderIdSelecionado").value = folderId;
		document.getElementById("_86_fm").submit();
	}
</script>