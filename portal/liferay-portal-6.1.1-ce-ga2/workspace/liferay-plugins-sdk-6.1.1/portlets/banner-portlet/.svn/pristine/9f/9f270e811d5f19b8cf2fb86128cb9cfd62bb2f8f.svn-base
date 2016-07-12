<%@ include file="/html/init.jsp"%>

<div id="lista_banner">
	<c:forEach var="banners" items="${lista}">
		<div class="imagem">
		<c:choose>
			<c:when test="${banners.linkDestino != ''}">
				<a href="${banners.linkDestino}"><img src="${banners.imagem}"
					title="${banners.titulo}" alt="${banners.titulo}"
					id="${banners.idBanner}" /> </a>
			</c:when>
			<c:otherwise>
				<img src="${banners.imagem}" title="${banners.titulo}"
					alt="${banners.titulo}" id="${banners.idBanner}" />
			</c:otherwise>
		</c:choose>
		</div>
	</c:forEach>
</div>
