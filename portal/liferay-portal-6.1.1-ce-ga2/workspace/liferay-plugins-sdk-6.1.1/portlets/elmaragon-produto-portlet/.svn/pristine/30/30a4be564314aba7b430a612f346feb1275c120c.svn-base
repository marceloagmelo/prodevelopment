<%@include file="init.jsp"%>
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL" />
<jsp:useBean class="java.lang.String" id="exibirTitulo" scope="request" />
<!-- inicio codigo portlet -->
<%@ include file="mensagem.jspf"%>
<%
boolean showEditArticleIcon = true;
boolean showAddArticleIcon = true;


int contador = 0;
boolean fecheiDiv = false;
%>
<c:choose>
<c:when test="${totalRegistros > 0}">
	<c:forEach var="produto" items="${listaProdutos}" varStatus="rowCounter">
<%
		if (contador == 0) {
			fecheiDiv = false;
%>
		<div class="linha_lista_produtos">
<%
		}
%>
		<div class="produto">
			<a href="${prefUrlDestino}?id=${produto.id }&estrutura=${estrutura }">
				<span class="produto_img"><img alt="${produto.titulo }" src="${produto.urlImagemPequena }"></span>
				<span class="produto_info">
					<span class="nome">${produto.titulo }</span>
					<span class="preco">
						<span class="preco_valor">${produto.preco }</span>
						<span class="preco_unidade">${produto.unidade }</span>
					</span>
				</span>
			</a>
		</div>
<%
		contador++;
		if (contador == 3) {
			contador = 0;
			fecheiDiv = true;
%>
		</div>
<%
		} 
%>
	</c:forEach>
<%
	if (!fecheiDiv) {
%>
		</div>
<%
	}
%>
	<div class="paginacao">
		<liferay-ui:page-iterator cur="${page}" curParam="page"
			delta="${pageSize}" deltaConfigurable="false" maxPages="50"
			total="${total}" url="<%=renderURL%>" />
	</div>
</c:when>
</c:choose>
<!-- fim codigo portlet -->