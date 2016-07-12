<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="filtrarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="novoURL" scope="request" />
<jsp:useBean class="java.lang.String" id="filtroPesquisa"
	scope="request" />
<%
	List listaPesquisa = (List) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA);
	if (listaPesquisa == null) {
		listaPesquisa = new ArrayList();
	}
	PortletPreferences prefs = renderRequest.getPreferences();
	int linhasPorPagina = Integer
			.valueOf(Constantes.DEFAULT_LINHAS_PAGINA);
	String toolbarItem = ParamUtil.getString(request, "toolbarItem",
			"view-all");
%>

<jsp:useBean class="java.lang.String" id="filtroTitulo" scope="request" />

<%@ include file="/html/cadastroportlet/mensagens.jspf"%>

<c:if test="${exibirTitulo == 'S' }">
	<div class="pesquisa_titulo">
		<liferay-ui:message key="${portletTitulo }" />
	</div>
</c:if>

<c:if
	test='<%=(Boolean) request
						.getAttribute("hasConfigurePermission")
						|| (Boolean) request.getAttribute("hasAddPermission")%>'>
	<div class="lfr-portlet-toolbar">
		<c:choose>
			<c:when
				test='<%=(Boolean) request
								.getAttribute("hasAddPermission")%>'>
				<span
					class="lfr-toolbar-button add-button <%=toolbarItem.equals("add") ? "current"
								: StringPool.BLANK%>"><a
					href="<%=novoURL%>"><liferay-ui:message key="add" /> </a> </span>
			</c:when>
		</c:choose>
		<c:if
			test='<%=(Boolean) request
							.getAttribute("hasConfigurePermission")%>'>
			<liferay-security:permissionsURL
				modelResource="<%=Constantes.PACKAGE_MODELO%>"
				modelResourceDescription="Pesquisa"
				resourcePrimKey="<%=String.valueOf(scopeGroupId)%>"
				var="permissionsURL" />

			<input type="button"
				value="<liferay-ui:message key="botao.permissoes" />"
				onClick="self.location = '<%=permissionsURL%>';">
		</c:if>
	</div>
</c:if>

<form name="<portlet:namespace />fm" action="<%=filtrarURL%>"
	method="POST">
	<table border="0" cellpadding="0" cellspacing="0"
		class="form_portlet_pesquisa">
		<tr>
			<td><liferay-ui:message key="label.pesquisa.titulo" />
				<p>
					<input type="text" name="filtroPesquisa" size="80" maxlength="100"
						value="<%=filtroPesquisa%>" />&nbsp;<input type="submit"
						class="search_bt_form" value="" />
				</p></td>
		</tr>
	</table>
	<input type="hidden" name="filtroPesquisa" value="filtrar" />
	<liferay-ui:search-container
		emptyResultsMessage="mensagem.lista.registos.nao.encontrados"
		delta="<%=linhasPorPagina%>">
		<liferay-ui:search-container-results>
			<%
				results = ListUtil.subList(listaPesquisa,
								searchContainer.getStart(),
								searchContainer.getEnd());
						total = listaPesquisa.size();
						pageContext.setAttribute("results", results);
						pageContext.setAttribute("total", total);
			%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="br.com.prodevelopment.pesquisaopiniao.model.Pesquisa"
			keyProperty="id" modelVar="pesquisa">
			<%@ include file="/html/cadastroportlet/colunas.jspf"%>
			<liferay-ui:search-container-column-jsp align="right"
				path="/html/cadastroportlet/acoes.jsp" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</form>