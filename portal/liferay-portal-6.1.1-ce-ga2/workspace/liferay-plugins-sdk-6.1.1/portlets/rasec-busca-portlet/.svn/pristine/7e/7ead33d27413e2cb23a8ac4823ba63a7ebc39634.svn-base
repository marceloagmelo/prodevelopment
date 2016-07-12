<%@ include file="init.jsp"%>

<portlet:renderURL var="renderURL" />

<script type="text/javascript">

function alterarAba(form, tipoConteudo) {

	form.tconteudo.value = tipoConteudo;

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
		<c:when test="${tconteudo == tipoProduto || tconteudo == null}">
			<li style="z-index: 100;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 100;">
		</c:otherwise>
	</c:choose>
		<a href="#tab1" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoProduto}');">
			<span><span><liferay-ui:message key='produto'/></span>
			</span>
		</a>
	</li>
	<c:choose>
		<c:when test="${tconteudo == tipoFornecedor}">
			<li style="z-index: 99;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 99;">
		</c:otherwise>
	</c:choose>
		<a href="#tab2" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoFornecedor}');">
			<span><span><liferay-ui:message key='fornecedor'/></span>
			</span>
		</a>
	</li>
	<c:choose>
		<c:when test="${tconteudo == tipoVideo}">
			<li style="z-index: 99;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 99;">
		</c:otherwise>
	</c:choose>
		<a href="#tab3" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoVideo}');">
			<span><span><liferay-ui:message key='video'/></span>
			</span>
		</a>
	</li>
	<c:choose>
		<c:when test="${tconteudo == tipoOutros}">
			<li style="z-index: 99;" class="active">
		</c:when>
		<c:otherwise>
			<li style="z-index: 99;">
		</c:otherwise>
	</c:choose>
		<a href="#tab4" onclick="javascript:alterarAba(document.<portlet:namespace />fm, '${tipoOutros}');">
			<span><span><liferay-ui:message key='outros'/></span>
			</span>
		</a>
	</li>
</ul>

<div class="resultado_busca_tab_container">
	<c:choose>
		<c:when test="${tconteudo == tipoProduto || tconteudo == null}">
			<div class="resultado_busca_tab_content" id="tab1" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab1" style="display: none;">
		</c:otherwise>
	</c:choose>
		<c:forEach var="resultadoItem" items="${resultados}" >
			<div class="resultadoItem">
				<c:set var="pipe" value=""/>

				<c:if test="${not empty resultadoItem.categorias}">
					<c:set var="pipe" value="|"/>
				</c:if>

				<span class="tagResultadoItem"><liferay-ui:message key="label.categorias"/>: ${resultadoItem.categorias}</span>
				<div class="tituloResultadoItem"><a href="${resultadoItem.paginaDestino}">${resultadoItem.titulo}</a></div>
				<div class="descricaoResultadoItem">${resultadoItem.descricao}</div>
			</div>
		</c:forEach>
    </div>
	<c:choose>
		<c:when test="${tconteudo == tipoFornecedor}">
			<div class="resultado_busca_tab_content" id="tab2" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab2" style="display: none;">
		</c:otherwise>
	</c:choose>
		<c:forEach var="resultadoItem" items="${resultados}" >
			<div class="resultadoItem">
				<c:set var="pipe" value=""/>

				<c:if test="${not empty resultadoItem.categorias}">
					<c:set var="pipe" value="|"/>
				</c:if>

				<span class="tagResultadoItem"><liferay-ui:message key="label.categorias"/>: ${resultadoItem.categorias}</span>
				<div class="tituloResultadoItem"><a href="${resultadoItem.paginaDestino}">${resultadoItem.titulo}</a></div>
				<div class="descricaoResultadoItem">${resultadoItem.descricao}</div>
			</div>
		</c:forEach>
    </div>
	<c:choose>
		<c:when test="${tconteudo == tipoVideo}">
			<div class="resultado_busca_tab_content" id="tab3" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab3" style="display: none;">
		</c:otherwise>
	</c:choose>
		<c:forEach var="resultadoItem" items="${resultados}" >
			<div class="resultadoItem">
				<c:set var="pipe" value=""/>

				<c:if test="${not empty resultadoItem.categorias}">
					<c:set var="pipe" value="|"/>
				</c:if>

				<span class="tagResultadoItem"><liferay-ui:message key="label.categorias"/>: ${resultadoItem.categorias}</span>
				<div class="tituloResultadoItem"><a href="${resultadoItem.paginaDestino}">${resultadoItem.titulo}</a></div>
				<div class="descricaoResultadoItem">${resultadoItem.descricao}</div>
			</div>
		</c:forEach>
    </div>
	<c:choose>
		<c:when test="${tconteudo == tipoOutros}">
			<div class="resultado_busca_tab_content" id="tab4" style="display: block;">
		</c:when>
		<c:otherwise>
			<div class="resultado_busca_tab_content" id="tab4" style="display: none;">
		</c:otherwise>
	</c:choose>
		<c:forEach var="resultadoItem" items="${resultados}" >
			<div class="resultadoItem">
				<c:set var="pipe" value=""/>

				<c:if test="${not empty resultadoItem.categorias}">
					<c:set var="pipe" value="|"/>
				</c:if>

				<span class="tagResultadoItem"><liferay-ui:message key="label.categorias"/>: ${resultadoItem.categorias}</span>
				<div class="tituloResultadoItem"><a href="${resultadoItem.paginaDestino}">${resultadoItem.titulo}</a></div>
				<div class="descricaoResultadoItem">${resultadoItem.descricao}</div>
			</div>
		</c:forEach>
    </div>
		<br>
		<liferay-ui:page-iterator cur="${page}" curParam="page"
		delta="${pageSize}" deltaConfigurable="false" maxPages="50"
		total="${total}" url="<%=renderURL%>" />
</div>
