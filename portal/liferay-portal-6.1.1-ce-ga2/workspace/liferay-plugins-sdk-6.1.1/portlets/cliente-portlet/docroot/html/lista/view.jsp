<%@include file="init.jsp"%>
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL" />
<jsp:useBean class="java.lang.String" id="exibirTitulo" scope="request" />
<!-- inicio codigo portlet -->
<div id="lista_clientes">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="tit_portlets">${portletTitulo }</div>
	</c:if>
	<%@ include file="mensagem.jspf"%>

	<c:if test="${totalRegistros > 0}">
		<c:forEach var="cliente" items="${listaClientes}" varStatus="i">
			<%
			ClienteVO clienteVO = (ClienteVO)pageContext.getAttribute("cliente");
			%>
			<c:set var="urlImagemPequena" value="${cliente.urlImagemPequena }" />
			<div class="lista_cliente clientes">
				<div class="titulo">${cliente.titulo }</div>
				<c:choose>
					<c:when test="${cliente.existeImagemPequena == 'S'}">

						<div class="imagem">
							<c:choose>
								<c:when test="${cliente.urlImagemPequena != '' }">
									<img
										src="<%=themeDisplay.getPathImage()%><%=(String) pageContext
											.getAttribute("urlImagemPequena")%>" />
								</c:when>
								<c:otherwise>
									<img
										src="/image/journal/article?img_id=${cliente.idImagemPequena }" />

								</c:otherwise>
							</c:choose>
						</div>

					</c:when>
				</c:choose>
				<c:if test="${cliente.existeImagemPequena == 'S'}">
					<div class="info_img">
				</c:if>
				<c:if test="${cliente.existeImagemPequena != 'S'}">
					<div class="info">
				</c:if>
				<div class="texto">${cliente.descricao }</div>
				<div class="leia_mais">
					<a href="${prefUrlDestino}?id=${cliente.id }&estrutura=${prefEstrutura }"><liferay-ui:message
							key="label.leiaMais" />&nbsp;&raquo;</a>
				</div>
				<c:choose>
					<c:when test="<%= themeDisplay.isSignedIn() %>">
						<liferay-portlet:renderURL
							windowState="<%= WindowState.MAXIMIZED.toString() %>"
							var="editURL" portletName="<%= PortletKeys.JOURNAL %>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="referringPortletResource"
								value="<%= PortletKeys.JOURNAL_CONTENT %>" />
							<portlet:param name="groupId" value="${cliente.groupId }" />
							<portlet:param name="articleId" value="${cliente.id }" />
							<portlet:param name="version" value="${cliente.versao }" />
						</liferay-portlet:renderURL>

						<liferay-portlet:renderURL
							windowState="<%= WindowState.MAXIMIZED.toString() %>"
							var="addArticleURL" portletName="<%= PortletKeys.JOURNAL %>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="portletResource"
								value="<%= portletDisplay.getId() %>" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="structureId" value="${prefEstrutura }" />
							<portlet:param name="referringPortletResource"
								value="<%= PortletKeys.JOURNAL_CONTENT %>" />
						</liferay-portlet:renderURL>

						<c:if
							test="<%= permissionChecker.hasPermission(Long.valueOf(clienteVO.getGroupId()), JournalArticle.class.getName(), Long.valueOf(clienteVO.getId()), ActionKeys.UPDATE) %>">

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