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

			pageContext.setAttribute("linhasPorPagina", request.getAttribute("pageSize"));
		%>

<div id="ultimos_conteudos">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="tit_portlets">${portletTitulo }</div>
	</c:if>
	<%@ include file="mensagem.jspf"%>

	<c:if test="${totalRegistros > 0}">
		<c:forEach var="conteudo" items="${listaConteudos}" varStatus="i">
			<%
			ConteudoVO conteudoVO = (ConteudoVO)pageContext.getAttribute("conteudo");
			%>
			<c:set var="urlImagemPequena" value="${conteudo.urlImagemPequena }" />
			<div class="conteudos">
				<c:choose>
					<c:when test="${conteudo.existeImagemPequena == 'S'}">

						<div class="imagem">
							<c:choose>
								<c:when test="${conteudo.urlImagemPequena != '' }">
									<img
										src="<%=themeDisplay.getPathImage()%><%=(String) pageContext
											.getAttribute("urlImagemPequena")%>" alt="${conteudo.titulo }"/>
								</c:when>
								<c:otherwise>
									<img
										src="/image/journal/article?img_id=${conteudo.idImagemPequena }" alt="${conteudo.titulo }"/>

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
				<div class="data_alteracao">${conteudo.titulo}</div>
				<div class="texto">${conteudo.descricao }</div>
				<div class="leia_mais">
					<a href="${prefUrlDestino}?id=${conteudo.id }"><liferay-ui:message
							key="label.leiaMais" />&nbsp;&raquo;</a>
				</div>
			</div>
</div>
</c:forEach>
<div class="veja_mais">
	&raquo;&nbsp;<a href="${prefUrlVerTodos}?categoria=${categoria}&tag=${tag}&estrutura=${estrutura}"><liferay-ui:message
			key="label.vejaMais" />
	</a>
</div>

</div>
</c:if>
<!-- fim codigo portlet -->