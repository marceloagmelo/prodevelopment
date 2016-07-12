<%@include file="init.jsp"%>
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL" />
<jsp:useBean class="java.lang.String" id="exibirTitulo" scope="request" />
<!-- inicio codigo portlet -->
<%
	List<ConteudoVO> listaConteudos = (List<ConteudoVO>) request
			.getAttribute(Constantes.LISTA_CONTEUDOS);
	if (listaConteudos == null) {
		listaConteudos = new ArrayList<ConteudoVO>();
	}

	pageContext.setAttribute("linhasPorPagina",
			request.getAttribute("pageSize"));

	boolean showEditArticleIcon = PortletPermissionUtil.contains(
			permissionChecker, layout, portletDisplay.getId(),
			Constantes.UPDATE_CONTENT);
	boolean showAddArticleIcon = PortletPermissionUtil.contains(
			permissionChecker, layout, portletDisplay.getId(),
			Constantes.ADD_CONTENT);
	String estrutura = (String) request
			.getAttribute(Constantes.NOME_PARAM_ESTRUTURA);
	String categoria = (String) request
			.getAttribute(Constantes.NOME_PARAM_CATEGORIA);
	String[] categorias = StringUtil.split(categoria, ",");
%>

<div id="lista_conteudos">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="tit_portlets">${portletTitulo }</div>
	</c:if>
	<%@ include file="mensagem.jspf"%>
<c:if test="<%=showAddArticleIcon%>">
	<div class="adicionar">
<%
long groupId = themeDisplay.getScopeGroup().getGroupId();

String taglibId = "addNew";
taglibId = taglibId.concat("In");

%>
	<liferay-ui:icon-menu
		align="left"
		icon='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>'
		id='<%= taglibId %>'
		message='<%= LanguageUtil.format(pageContext, "add-new", new Object[] {(GroupLocalServiceUtil.getGroup(groupId)).getDescriptiveName(locale)}) %>'
		showWhenSingleIcon="<%= true %>"
	>
<%
Map<String, String> mapEstruturas = Helper.getEstruturas(liferayPortletRequest, liferayPortletResponse, estrutura);
for (Map.Entry<String, String> estrut : mapEstruturas.entrySet()) {
%>
	<liferay-portlet:renderURL
		windowState="<%=WindowState.MAXIMIZED.toString()%>"
		var="addArticleURL" portletName="<%=PortletKeys.JOURNAL%>">
		<portlet:param name="struts_action" value="/journal/edit_article" />
		<portlet:param name="portletResource"
			value="<%=portletDisplay.getId()%>" />
		<portlet:param name="redirect" value="<%=currentURL%>" />
		<portlet:param name="groupId"
			value="<%=String.valueOf(themeDisplay.getScopeGroup()
								.getGroupId())%>" />
		<portlet:param name="structureId" value="<%=estrut.getKey() %>" />
<%
Map<String, String> mapParamCategorias = Helper.getParametroCategoria(liferayPortletRequest, categorias);
for (Map.Entry<String, String> param : mapParamCategorias.entrySet()) {
%>
								<portlet:param name="<%=param.getKey() %>" value="<%=param.getValue() %>" />
<%
}
%>								
	</liferay-portlet:renderURL>
		<liferay-ui:icon image="add_article" message="<%=estrut.getValue() %>"
			url="<%=addArticleURL%>" />
<%	
}
%>		
	</liferay-ui:icon-menu>	

	</div>
</c:if>
	<c:choose>
		<c:when test="${totalRegistros > 0}">
			<c:forEach var="conteudo" items="${listaConteudos}" varStatus="i">
				<%
					ConteudoVO conteudoVO = (ConteudoVO) pageContext
										.getAttribute("conteudo");
				%>
				<c:set var="urlImagemPequena" value="${conteudo.urlImagemPequena }" />
				<div class="lista_conteudos conteudos">
					<div class="titulo">${conteudo.titulo }</div>
					<c:choose>
						<c:when test="${conteudo.existeImagemPequena == 'S'}">

							<div class="imagem">
								<c:choose>
									<c:when test="${conteudo.urlImagemPequena != '' }">
										<img
											src="<%=themeDisplay.getPathImage()%><%=(String) pageContext
												.getAttribute("urlImagemPequena")%>" />
									</c:when>
									<c:otherwise>
										<img
											src="/image/journal/article?img_id=${conteudo.idImagemPequena }" />

									</c:otherwise>
								</c:choose>
							</div>

						</c:when>
					</c:choose>
					<c:if test="${conteudo.existeImagemPequena == 'S'}">
						<div class="info_img">
					</c:if>
					<c:if test="${conteudo.existeImagemPequena != 'S'}">
						<div class="info">
					</c:if>
<%
if (prefExibirDataAlteracao) {
%>					
					<div class="data_alteracao"><liferay-ui:message key="label.dataAtualizacao" />: ${conteudo.dataAlteracao}</div>
<%
}
%>
					<div class="texto">${conteudo.descricao }</div>
<%
if (prefExibirLeiaMais) {
%>					
					<div class="leia_mais">
						<a href="${prefUrlDestino}?id=${conteudo.id }&estrutura=${estrutura}"><liferay-ui:message
								key="label.leiaMais" />&nbsp;&raquo;</a>
					</div>
<%
}
%>

					<c:choose>
						<c:when test="<%=themeDisplay.isSignedIn()%>">
							<liferay-portlet:renderURL
								windowState="<%=WindowState.MAXIMIZED.toString()%>"
								var="editURL" portletName="<%=PortletKeys.JOURNAL%>">
								<portlet:param name="struts_action"
									value="/journal/edit_article" />
								<portlet:param name="redirect" value="<%=currentURL%>" />
								<portlet:param name="originalRedirect" value="<%=currentURL%>" />
								<portlet:param name="groupId" value="${conteudo.groupId }" />
								<portlet:param name="articleId" value="${conteudo.id }" />
								<portlet:param name="version" value="${conteudo.versao }" />
							</liferay-portlet:renderURL>

							<div class="acoes">
								<div class="acao">
									<c:if test="<%=showEditArticleIcon%>">
										<liferay-ui:icon image="edit" message="edit-web-content"
											url="<%=editURL%>" />
									</c:if>
								</div>
							</div>
						</c:when>
					</c:choose>
				</div>
</div>
</c:forEach>
<div class="paginacao">
	<liferay-ui:page-iterator cur="${page}" curParam="page"
		delta="${pageSize}" deltaConfigurable="false" maxPages="50"
		total="${total}" url="<%=renderURL%>" />

</div>
</c:when>
</c:choose>
</div>
<!-- fim codigo portlet -->
