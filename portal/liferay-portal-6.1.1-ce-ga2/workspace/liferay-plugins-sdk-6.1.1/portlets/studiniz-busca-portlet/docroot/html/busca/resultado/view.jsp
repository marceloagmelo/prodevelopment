<%@ include file="init.jsp"%>

<portlet:renderURL var="renderURL" />

<script type="text/javascript">

function alterarAba(form, tipo) {
	
	form.tconteudo.value = tipo;

	executaBuscaResultado(form);
}


function executaBuscaResultado(form) {

	var paramBusca = form.parambusca.value;

	if(paramBusca == null || paramBusca == 'Pesquisar...' || paramBusca == '') {
		alert("A busca n„o pode estar vazia");
		return;
	}

	var render = "<%=renderURL%>";


	var pos = render.indexOf(" ");
	while (pos > -1){
		render = render.replace(" ","+");
		pos = render.indexOf(" ");
	}

	form.submit();
}
</script>


<form name="<portlet:namespace />fm" action="<%=renderURL%>" method="get">

		<input type="hidden" name="tconteudo">
		<input type="hidden" name="parambusca" id="parambusca" value="${termosBusca}">
		<div class="termo_buscado">
			<label for="termo"><liferay-ui:message key="termo-buscado"/></label>
			<span class="termo_buscado_texto">${termosBusca}</span>
		</div>
</form>
<div id="resultadoBusca" class=resultadoBusca>
<ul class="resultado_busca_tabs">
	<c:choose>
		<c:when test="${tconteudo == tipoConteudo || tconteudo == null}">
			<li style="z-index: 99;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 99;">
		</c:otherwise>
	</c:choose>
		<a href="#tab1" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoConteudo}');">
			<span><span><liferay-ui:message key='conteudo'/></span>
			</span>
		</a>
	</li>
	<c:choose>
		<c:when test="${tconteudo == tipoDocumento}">
			<li style="z-index: 99;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 99;">
		</c:otherwise>
	</c:choose>
		<a href="#tab2" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoDocumento}');">
			<span><span><liferay-ui:message key='documento'/></span>
			</span>
		</a>
	</li>
</ul>
<div class="resultado_busca_tab_container">
	<c:choose>
		<c:when test="${tconteudo == tipoConteudo || tconteudo == null}">
			<div class="resultado_busca_tab_content" id="tab1" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab1" style="display: none;">
		</c:otherwise>
	</c:choose>
	<c:forEach var="resultadoItem" items="${resultados}">
		<span class="categoriaResultadoItem"><liferay-ui:message key='label.categorias'/>: ${resultadoItem.categorias}</span>
		<%@ include file="detalheConteudo.jspf"%>
	</c:forEach>
    </div>
	<c:choose>
		<c:when test="${tconteudo == tipoDocumento}">
			<div class="resultado_busca_tab_content" id="tab2" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab2" style="display: none;">
		</c:otherwise>
	</c:choose>
	<c:forEach var="resultadoItem" items="${resultados}">
		<span class="categoriaResultadoItem"><liferay-ui:message key='label.categorias'/>: ${resultadoItem.categorias}</span>
		<%@ include file="detalheDocumento.jspf"%>
	</c:forEach>
    </div>
	<br>
	<liferay-ui:page-iterator cur="${page}" curParam="page"
	delta="${pageSize}" deltaConfigurable="false" maxPages="50"
	total="${total}" url="<%=renderURL%>" />
</div>
</div>

