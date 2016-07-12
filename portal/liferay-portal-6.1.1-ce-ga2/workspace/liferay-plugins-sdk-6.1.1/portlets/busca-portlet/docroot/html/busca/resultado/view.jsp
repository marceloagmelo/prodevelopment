<%@ include file="init.jsp"%>

<portlet:renderURL var="renderURL" />

<form name="<portlet:namespace />fm" action="<%=renderURL%>" method="get">

		<input type="hidden" name="tconteudo">
		<div class="termo_buscado">
			<label for="termo"><liferay-ui:message key="termo-buscado"/></label>
			<span class="termo_buscado_texto">${termosBusca}</span>
		</div>
</form>

<div id="resultadoBusca" class=resultadoBusca>
<ul class="resultado_busca_tabs">
	<c:choose>
		<c:when test="${tconteudo == tipoOutros}">
			<li style="z-index: 99;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 99;">
		</c:otherwise>
	</c:choose>
		<a href="#tab1" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoOutros}');">
			<span><span><liferay-ui:message key='todos'/></span>
			</span>
		</a>
	</li>
	<c:choose>
		<c:when test="${tconteudo == tipoCliente}">
			<li style="z-index: 99;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 99;">
		</c:otherwise>
	</c:choose>
		<a href="#tab2" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoNoticia}');">
			<span><span><liferay-ui:message key='noticia'/></span>
			</span>
		</a>
	</li>
	<c:choose>
		<c:when test="${tconteudo == tipoCliente}">
			<li style="z-index: 99;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 99;">
		</c:otherwise>
	</c:choose>
		<a href="#tab3" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoCliente}');">
			<span><span><liferay-ui:message key='cliente'/></span>
			</span>
		</a>
	</li>
	<c:choose>
		<c:when test="${tconteudo == tipoServico || tconteudo == null}">
			<li style="z-index: 100;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 100;">
		</c:otherwise>
	</c:choose>
		<a href="#tab4" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoServico}');">
			<span><span><liferay-ui:message key='servico'/></span>
			</span>
		</a>
	</li>
</ul>

<div class="resultado_busca_tab_container">
	<c:choose>
		<c:when test="${tconteudo == tipoOutros || tconteudo == null}">
			<div class="resultado_busca_tab_content" id="tab1" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab1" style="display: none;">
		</c:otherwise>
	</c:choose>
	<c:forEach var="resultadoItem" items="${resultados}">
		<span class="categoriaResultadoItem">Categoria: ${resultadoItem.categorias}</span>
		<%@ include file="detalhe.jspf"%>
	</c:forEach>
    </div>
	<c:choose>
		<c:when test="${tconteudo == tipoNoticia}">
			<div class="resultado_busca_tab_content" id="tab2" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab2" style="display: none;">
		</c:otherwise>
	</c:choose>
	<c:forEach var="resultadoItem" items="${resultados}">
		<%@ include file="detalhe.jspf"%>
	</c:forEach>
    </div>
	<c:choose>
		<c:when test="${tconteudo == tipoCliente}">
			<div class="resultado_busca_tab_content" id="tab3" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab3" style="display: none;">
		</c:otherwise>
	</c:choose>
	<c:forEach var="resultadoItem" items="${resultados}">
		<%@ include file="detalhe.jspf"%>
	</c:forEach>
    </div>
	<c:choose>
		<c:when test="${tconteudo == tipoServico}">
			<div class="resultado_busca_tab_content" id="tab4" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab4" style="display: none;">
		</c:otherwise>
	</c:choose>
	<c:forEach var="resultadoItem" items="${resultados}">
		<%@ include file="detalhe.jspf"%>
	</c:forEach>
    </div>
	<br>
	<liferay-ui:page-iterator cur="${page}" curParam="page"
	delta="${pageSize}" deltaConfigurable="false" maxPages="50"
	total="${total}" url="<%=renderURL%>" />
</div>
