<%@include file="init.jsp"%>
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL" />
<!-- inicio codigo portlet -->
<%
	List<VideoVO> videos = (List<VideoVO>) request
			.getAttribute(Constantes.VIDEOS);
	if (videos == null) {
		videos = new ArrayList<VideoVO>();
	}

	pageContext.setAttribute("linhasPorPagina",
			request.getAttribute("pageSize"));
%>

<div id="videos">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="tit_portlets">${portletTitulo }</div>
	</c:if>
	<%@ include file="mensagem.jspf"%>

	<c:if test="${totalRegistros > 0}">
		<c:forEach var="video" items="${videos}" varStatus="i">
			<%
				VideoVO videoVO = (VideoVO) pageContext
								.getAttribute("video");
			%>
			<c:set var="urlImagemPequena" value="${video.urlImagemPequena }" />
			<div class="videos conteudos">
				<div class="titulo">${video.titulo }</div>
				<div class="imagem">
					<a href="javascript:abrir('${video.urlVideo}');"> <img
						src="${video.urlTumb}" />
					</a>
				</div>
				<div class="info_img">
					<div class="texto">${video.descricao }</div>
					<c:choose>
						<c:when test="<%= themeDisplay.isSignedIn() %>">
						<liferay-portlet:renderURL
							windowState="<%=WindowState.MAXIMIZED.toString()%>"
							var="editURL" portletName="<%=PortletKeys.JOURNAL%>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="redirect" value="<%=currentURL%>" />
							<portlet:param name="originalRedirect"
								value="<%=currentURL%>" />
							<portlet:param name="groupId" value="${video.groupId }" />
							<portlet:param name="articleId" value="${video.idVideo }" />
							<portlet:param name="version" value="${video.versao }" />
						</liferay-portlet:renderURL>

						<liferay-portlet:renderURL
							windowState="<%=WindowState.MAXIMIZED.toString()%>"
							var="addArticleURL" portletName="<%=PortletKeys.JOURNAL%>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="portletResource"
								value="<%=portletDisplay.getId()%>" />
							<portlet:param name="redirect" value="<%=currentURL%>" />
							<portlet:param name="structureId" value="${estrutura }" />
							<portlet:param name="groupId" value="${video.groupId }" />
						</liferay-portlet:renderURL>

							<c:if
								test="<%= permissionChecker.hasPermission(Long.valueOf(videoVO.getGroupId()), JournalArticle.class.getName(), Long.valueOf(videoVO.getIdVideo()), ActionKeys.UPDATE) %>">

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