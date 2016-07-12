<%@include file="/html/init.jsp"%>
<div id="video_destaque">
	<c:forEach var="video" items="${videos}">
		<div class="conteudos">
			<div class="imagem">
				<a href="javascript:abrir('${video.urlVideo}');"> <img
					src="${video.urlTumb}" alt="${video.titulo }" /> </a>
			</div>
			<div class="info_img">
				<div class="titulo">${video.titulo}</div>
			</div>
		</div>
	</c:forEach>
	<div class="veja_mais">
		&raquo;&nbsp;<a
			href="${urlDestino}?categoria=${categoria}&tag=${tag}&estrutura=${estrutura}"><liferay-ui:message
				key="label.vejaMais" /> </a>
	</div>
</div>
