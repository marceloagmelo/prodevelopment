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
%>

<div id="ultimos_conteudos_2colunas">
	<c:if test="${exibirTitulo == 'S' }">
		<h3>${portletTitulo }</h3>
	</c:if>
	<%@ include file="mensagem.jspf"%>

	<c:if test="${totalRegistros > 0}">
		<div class="conteudos">
			<c:forEach var="conteudo" items="${listaConteudos}" varStatus="i">
				<%
					ConteudoVO conteudoVO = (ConteudoVO) pageContext
									.getAttribute("conteudo");
				%>
				<c:set var="urlImagemPequena" value="${conteudo.urlImagemPequena }" />
				<div class="indice_conteudo">
					<div class="conteudo_left">
						<c:choose>
							<c:when test="${conteudo.existeImagemPequena == 'S'}">
								<c:choose>
									<c:when test="${conteudo.urlImagemPequena != '' }">
										<img
											src="<%=themeDisplay.getPathImage()%><%=(String) pageContext
											.getAttribute("urlImagemPequena")%>"
											alt="${conteudo.titulo }" title="${conteudo.titulo }"
											style="float: left; padding-right: 15px; padding-bottom: 10px; width: 127px; height: 77px;" />
									</c:when>
									<c:otherwise>
										<img
											src="/image/journal/article?img_id=${conteudo.idImagemPequena }"
											alt="${conteudo.titulo }" title="${conteudo.titulo }"
											style="float: left; padding-right: 15px; padding-bottom: 10px; width: 127px; height: 77px;" />

									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
						<div class="titulo">${conteudo.titulo}</div>
						${conteudo.descricao }
						<span class="leia_mais">
							<a href="${prefUrlDestino}?id=${conteudo.id }"><liferay-ui:message
									key="label.leiaMais" />&nbsp;&raquo;</a>
						</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>
</div>
<!-- fim codigo portlet -->