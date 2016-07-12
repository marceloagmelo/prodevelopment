<%@include file="/html/init.jsp"%>
<div id="fornecedor_destaque">
	<c:forEach var="fornecedor" items="${lista}">
		<c:set var="urlImagemPequena" value="${fornecedor.urlImagemPequena }" />
		<div class="conteudos">
			<c:choose>
				<c:when test="${fornecedor.existeImagemPequena == 'S'}">

					<div class="imagem">
						<c:choose>
							<c:when test="${fornecedor.urlImagemPequena != '' }">
								<img
									src="<%=themeDisplay.getPathImage()%><%=(String) pageContext
										.getAttribute("urlImagemPequena")%>"
									alt="${fornecedor.titulo }" />
							</c:when>
							<c:otherwise>
								<img
									src="/image/journal/article?img_id=${fornecedor.idImagemPequena }"
									alt="${fornecedor.titulo }" />

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
			<div class="titulo">${fornecedor.titulo}</div>
			</div>
		</div>
	</c:forEach>
	<div class="veja_mais">
		&raquo;&nbsp;<a
			href="${urlDestino}?portletTitulo=<liferay-ui:message key="label.titulo"/>&categoria=${categoria}&estrutura=${estrutura}"><liferay-ui:message
				key="label.vejaMais" /> </a>
	</div>
</div>
