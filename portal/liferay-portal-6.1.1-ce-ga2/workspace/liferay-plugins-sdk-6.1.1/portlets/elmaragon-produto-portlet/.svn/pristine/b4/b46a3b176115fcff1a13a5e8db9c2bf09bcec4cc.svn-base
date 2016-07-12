<%@include file="init.jsp"%>
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL" />
<jsp:useBean class="java.lang.String" id="exibirTitulo" scope="request" />
<!-- inicio codigo portlet -->
<%@ include file="mensagem.jspf"%>
<%
boolean showEditArticleIcon = PortletPermissionUtil.contains(
		permissionChecker, layout, portletDisplay.getId(),
		Constantes.UPDATE_CONTENT);
boolean showAddArticleIcon = PortletPermissionUtil.contains(
		permissionChecker, layout, portletDisplay.getId(),
		Constantes.ADD_CONTENT);
%>
<c:choose>
<c:when test="${totalRegistros > 0}">
	<div class="linha_lista_produtos">
	<c:forEach var="produto" items="${listaProdutos}" varStatus="rowCounter">
		<div class="produto">
			<a href="#">
				<span class="produto_img"><img alt="${produto.titulo }" src="${produto.urlImagemPequena }"></span>
				<span class="produto_info">
					<span class="nome">${produto.titulo }</span>
					<span class="preco">
						<span class="preco_valor">${rowCounter.count }</span>
						<span class="preco_unidade">${produto.unidade }</span>
					</span>
				</span>
			</a>
			<c:choose>
				<c:when test="<%=themeDisplay.isSignedIn()%>">
					<liferay-portlet:renderURL
						windowState="<%=WindowState.MAXIMIZED.toString()%>"
						var="editURL" portletName="<%=PortletKeys.JOURNAL%>">
						<portlet:param name="struts_action"
							value="/journal/edit_article" />
						<portlet:param name="redirect" value="<%=currentURL%>" />
						<portlet:param name="originalRedirect" value="<%=currentURL%>" />
						<portlet:param name="groupId" value="${produto.groupId }" />
						<portlet:param name="articleId" value="${produto.id }" />
						<portlet:param name="version" value="${produto.versao }" />
					</liferay-portlet:renderURL>

					<liferay-portlet:renderURL
						windowState="<%=WindowState.MAXIMIZED.toString()%>"
						var="addArticleURL" portletName="<%=PortletKeys.JOURNAL%>">
						<portlet:param name="struts_action"
							value="/journal/edit_article" />
						<portlet:param name="portletResource"
							value="<%=portletDisplay.getId()%>" />
						<portlet:param name="redirect" value="<%=currentURL%>" />
						<portlet:param name="structureId" value="${estrutura }" />
						<portlet:param name="groupId" value="${produto.groupId }" />
					</liferay-portlet:renderURL>


					<div class="acoes">
						<div class="acao">
							<c:if test="<%=showEditArticleIcon%>">
								<liferay-ui:icon image="edit" message="edit-web-content"
									url="<%=editURL%>" />
							</c:if>
							<c:if test="<%=showAddArticleIcon%>">

								<liferay-ui:icon image="add_article" message="add-web-content"
									url="<%=addArticleURL%>" />

							</c:if>

						</div>
					</div>
				</c:when>
			</c:choose>
		</div>
	</c:forEach>
	<div class="paginacao">
		<liferay-ui:page-iterator cur="${page}" curParam="page"
			delta="${pageSize}" deltaConfigurable="false" maxPages="50"
			total="${total}" url="<%=renderURL%>" />
	</div>
	</div>	
</c:when>
<c:otherwise>
	<liferay-portlet:renderURL
		windowState="<%=WindowState.MAXIMIZED.toString()%>"
		var="addArticleURL" portletName="<%=PortletKeys.JOURNAL%>">
		<portlet:param name="struts_action" value="/journal/edit_article" />
		<portlet:param name="portletResource"
			value="<%=portletDisplay.getId()%>" />
		<portlet:param name="redirect" value="<%=currentURL%>" />
		<portlet:param name="structureId" value="${estrutura }" />
		<portlet:param name="groupId"
			value="<%=String.valueOf(themeDisplay.getScopeGroup()
								.getGroupId())%>" />
	</liferay-portlet:renderURL>

	<c:if test="<%=showAddArticleIcon%>">

		<liferay-ui:icon image="add_article" message="add-web-content"
			url="<%=addArticleURL%>" />

	</c:if>
</c:otherwise>
</c:choose>
<!-- fim codigo portlet -->