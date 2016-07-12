<%@include file="init.jsp"%>
<jsp:useBean class="java.lang.String" id="exibirTitulo" scope="request" />
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL" />
<!-- inicio codigo portlet -->
<%
	List<FornecedorVO> fornecedores = (List<FornecedorVO>) request
			.getAttribute(Constantes.FORNECEDORES);
	if (fornecedores == null) {
		fornecedores = new ArrayList<FornecedorVO>();
	}

	pageContext.setAttribute("linhasPorPagina",
			request.getAttribute("pageSize"));
%>

<div id="fornecedores">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="tit_portlets">${portletTitulo }</div>
	</c:if>
	<%@ include file="mensagem.jspf"%>

	<c:if test="${totalRegistros > 0}">
		<c:forEach var="fornecedor" items="${fornecedores}" varStatus="i">
			<%
				FornecedorVO fornecedorVO = (FornecedorVO) pageContext
								.getAttribute("fornecedor");
			%>
			<c:set var="urlImagemPequena" value="${fornecedor.urlImagemPequena }" />
			<div class="fornecedores conteudos">
				<div class="titulo">${fornecedor.titulo }</div>
				<c:choose>
					<c:when test="${fornecedor.existeImagemPequena == 'S'}">

						<div class="imagem">
							<c:choose>
								<c:when test="${fornecedor.urlImagemPequena != '' }">
									<img
										src="<%=themeDisplay.getPathImage()%><%=(String) pageContext
											.getAttribute("urlImagemPequena")%>" />
								</c:when>
								<c:otherwise>
									<img
										src="/image/journal/article?img_id=${fornecedor.idImagemPequena }" />

								</c:otherwise>
							</c:choose>
						</div>

					</c:when>
				</c:choose>
				<c:if test="${fornecedor.existeImagemPequena == 'S'}">
					<div class="info_img">
				</c:if>
				<c:if test="${fornecedor.existeImagemPequena != 'S'}">
					<div class="info">
				</c:if>
				<div class="texto">${fornecedor.descricao }</div>
				<c:choose>
					<c:when test="<%= themeDisplay.isSignedIn() %>">
						<liferay-portlet:renderURL
							windowState="<%=WindowState.MAXIMIZED.toString()%>"
							var="editURL" portletName="<%=PortletKeys.JOURNAL%>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="redirect" value="<%=currentURL%>" />
							<portlet:param name="originalRedirect"
								value="<%=currentURL%>" />
							<portlet:param name="groupId" value="${fornecedor.groupId }" />
							<portlet:param name="articleId" value="${fornecedor.id }" />
							<portlet:param name="version" value="${fornecedor.versao }" />
						</liferay-portlet:renderURL>

						<liferay-portlet:renderURL
							windowState="<%=WindowState.MAXIMIZED.toString()%>"
							var="addArticleURL" portletName="<%=PortletKeys.JOURNAL%>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="portletResource"
								value="<%=portletDisplay.getId()%>" />
							<portlet:param name="redirect" value="<%=currentURL%>" />
							<portlet:param name="structureId" value="${estrutura }" />
							<portlet:param name="groupId" value="${fornecedor.groupId }" />
						</liferay-portlet:renderURL>

						<c:if
							test="<%= permissionChecker.hasPermission(Long.valueOf(fornecedorVO.getGroupId()), JournalArticle.class.getName(), Long.valueOf(fornecedorVO.getId()), ActionKeys.UPDATE) %>">

							<div class="acoes">
								<div class="acao">
									<liferay-ui:icon image="edit" message="edit-web-content"
										url="<%= editURL %>" />


									<liferay-ui:icon image="add_article" message="add-web-content"
										url="<%= addArticleURL %>" />
								</div>
							</div>
						</c:if>

					</c:when>
				</c:choose>
			</div>
</div>
</c:forEach>
</div>
<div class="paginacao">
	<liferay-ui:page-iterator cur="${page}" curParam="page"
		delta="${pageSize}" deltaConfigurable="false" maxPages="50"
		total="${total}" url="<%=renderURL%>" />

</div>
</c:if>

<!-- fim codigo portlet -->