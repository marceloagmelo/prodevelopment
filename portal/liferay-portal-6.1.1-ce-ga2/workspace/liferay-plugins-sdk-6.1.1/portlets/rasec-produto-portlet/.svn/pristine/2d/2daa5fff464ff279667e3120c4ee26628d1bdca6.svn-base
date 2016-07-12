<%@include file="init.jsp"%>
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL" />
<jsp:useBean class="java.lang.String" id="exibirTitulo" scope="request" />
<!-- inicio codigo portlet -->
<div id="lista_produtos">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="tit_portlets">${portletTitulo }</div>
	</c:if>
	<%@ include file="mensagem.jspf"%>

	<c:if test="${totalRegistros > 0}">
		<c:forEach var="produto" items="${listaProdutos}" varStatus="i">
			<%
			ProdutoVO produtoVO = (ProdutoVO)pageContext.getAttribute("produto");
			%>
			<c:set var="urlImagemPequena" value="${produto.urlImagemPequena }" />
			<div class="lista_produto produtos">
				<div class="titulo">${produto.titulo }</div>
				<c:choose>
					<c:when test="${produto.existeImagemPequena == 'S'}">

						<div class="imagem">
							<c:choose>
								<c:when test="${produto.urlImagemPequena != '' }">
									<img
										src="<%=themeDisplay.getPathImage()%><%=(String) pageContext
											.getAttribute("urlImagemPequena")%>" />
								</c:when>
								<c:otherwise>
									<img
										src="/image/journal/article?img_id=${produto.idImagemPequena }" />

								</c:otherwise>
							</c:choose>
						</div>

					</c:when>
				</c:choose>
				<c:if test="${produto.existeImagemPequena == 'S'}">
					<div class="info_img">
				</c:if>
				<c:if test="${produto.existeImagemPequena != 'S'}">
					<div class="info">
				</c:if>
				<div class="texto">${produto.descricao }</div>
				<div class="leia_mais">
					<a href="${prefUrlDestino}?id=${produto.id }&estrutura=${estrutura }"><liferay-ui:message
							key="label.leiaMais" />&nbsp;&raquo;</a>
				</div>
				<c:choose>
					<c:when test="<%= themeDisplay.isSignedIn() %>">
						<liferay-portlet:renderURL
							windowState="<%=WindowState.MAXIMIZED.toString()%>"
							var="editURL" portletName="<%=PortletKeys.JOURNAL%>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="redirect" value="<%=currentURL%>" />
							<portlet:param name="originalRedirect"
								value="<%=currentURL%>" />
							<portlet:param name="groupId" value="${produto.groupId }" />
							<portlet:param name="articleId" value="${produto.id }" />
							<portlet:param name="version" value="${produto.versao }" />
						</liferay-portlet:renderURL>

						<liferay-portlet:renderURL
							windowState="<%=WindowState.MAXIMIZED.toString()%>"
							var="addArticleURL" portletName="<%=PortletKeys.JOURNAL%>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="portletResource"
								value="<%=portletDisplay.getId()%>" />
							<portlet:param name="redirect" value="<%=currentURL%>" />
							<portlet:param name="structureId" value="${estrutura }" />
							<portlet:param name="groupId" value="${produto.groupId }" />
						</liferay-portlet:renderURL>

						<c:if
							test="<%= permissionChecker.hasPermission(Long.valueOf(produtoVO.getGroupId()), JournalArticle.class.getName(), Long.valueOf(produtoVO.getId()), ActionKeys.UPDATE) %>">

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