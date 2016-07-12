<%@ include file="/html/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configuracaoURL" />
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL"/>

<script type="text/javascript">

var alteracao = 0;

function enviarForm() {
	document.forms[0].inner.value = document.getElementById("layoutIdsBox").innerHTML;

	document.forms[0].submit();
}


function removeElement(id) {

var lista = document.getElementById('layoutIdsBox');

var elemento = document.getElementById(id);

	for(var i=lista.options.length-1;i>=0;i--) {
		if(lista.options[i].value == elemento.name)
		lista.remove(i);
	}

}

function adiciona(texto,name) {
    linha = document.createElement("OPTION");
    linha.text = texto;
    linha.value = name;
    linha.name = name;
    document.forms[0].layoutIdsBox.add(linha);
}

function ckeckChange(texto,name,id) {
	if(document.getElementById(id).checked == false) {
		removeElement(id);
	} else {
		adiciona(texto,name);
	}
}


function filtrar() {

	document.forms[0].passei.value = 'sim';

	if(alteracao == 1) {
		if (!confirm("Deseja salvar alterações antes de filtrar?")) {
			document.forms[0].action = '<%=renderURL%>';
		}
	} else {
		document.forms[0].action = '<%=renderURL%>';
	}

	enviarForm();
}

function alterarRef() {

	var spans = document.getElementsByTagName("span");

	for(var i=0;i<spans.length;i++) {
		if(spans[i].className == 'result-column-name') {
			var a = spans[i].getElementsByTagName("a");
			var texto = a[0].innerHTML;

			var ref = '<%=renderURL%>';

			if(texto.indexOf("Nome") != -1) {
				ref = ref + "?orderByColumn=title";
			} else if(texto.indexOf("Data")) {
				ref = ref + "?orderByColumn=modified";
			}

			var na = "<a href='"+ref+"'>"+texto+"</a>";
			spans[i].innerHTML = na;
		}
	}
}

</script>

<form action="<%=configuracaoURL%>" method="post">

	<input type="hidden" name="inner" />
	<input type="hidden" name="passei" value='${passei}'/>

	<fieldset>
	<legend>
		<liferay-ui:message key="escolha-dos-videos" />
	</legend>

	<liferay-ui:message key="categoria"/>
	<liferay-ui:asset-categories-selector curCategoryIds="${curCategoryIds}"/>

	<liferay-ui:message key="tags"/>
	<liferay-ui:asset-tags-selector curTags="${curTags}"/>

	<input type="button" value="<liferay-ui:message key="filtrar"/>" onclick="javascript:filtrar()">
	<div style="border-bottom:1px solid gray; margin-top:4px;margin-bottom:4px;"></div>

		<%
			List banners = (List) request.getAttribute("banners");
				if (banners == null) {
					banners = new ArrayList();
				}

				int linhasPorPagina = 15;
		%>

		<liferay-ui:search-container
			emptyResultsMessage="mensagem.lista.registos.nao.encontrados"
			delta="<%=linhasPorPagina %>">
			<liferay-ui:search-container-results >
				<%
					results = ListUtil.subList(banners,
													searchContainer.getStart(),
													searchContainer.getEnd());
											pageContext.setAttribute("results", results);
											pageContext.setAttribute("total", request.getAttribute("total"));
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="br.com.prodevelopment.banner.vo.BannerVO" keyProperty="idBanner" modelVar="banner">
			<liferay-ui:search-container-column-text name="exibir-banner">

			<c:set var="id" value="${banner.idBanner}"/>
			<c:set var="idss" value="${meusBannersId}"/>
				<c:choose>
					<c:when test="${fn:contains(idss,id)}">
						<c:set var="ch" value="checked" />
					</c:when>
					<c:otherwise>
						<c:set var="ch" value="" />
					</c:otherwise>
				</c:choose>
				<input onclick="javascript:ckeckChange('${banner.titulo}','${banner.idBanner}',this.id);" id="${banner.idBanner}" type="checkbox" name="${banner.idBanner}" ${ch}>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="id-banner" property="idBanner" />
				<liferay-ui:search-container-column-text orderable="true" name="titulo-banner" property="titulo" />
				<liferay-ui:search-container-column-text orderable="true" name="dataCriacao" property="dataCriacao" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false"/>
		</liferay-ui:search-container>
		<liferay-ui:page-iterator cur="${page}" curParam="page"
	delta="${pageSize}" deltaConfigurable="false" maxPages="50"
	total="${total}" url="<%=renderURL%>" />

	</fieldset>
	<fieldset>
		<legend>
			<liferay-ui:message key="ordenacao" />
		</legend>
		<table>
			<tr>
				<td><select id="layoutIdsBox" name="layoutIdsBox" size="7">
						<c:forEach var="banner" items="${meusBanners}">
							<option value='${banner.idBanner}'>${banner.titulo}</option>
						</c:forEach>
				</select></td>
				<td><a
					href="javascript:Liferay.Util.reorder(document.forms[0].layoutIdsBox, 0);"><img
						border="0" height="16" hspace="0"
						src="<%=themeDisplay.getPathThemeImages()%>/arrows/02_up.png"
						vspace="2" width="16" /> </a><br /> <a
					href="javascript:Liferay.Util.reorder(document.forms[0].layoutIdsBox, 1);"><img
						border="0" height="16" hspace="0"
						src="<%=themeDisplay.getPathThemeImages()%>/arrows/02_down.png"
						vspace="2" width="16" /> </a><br /></td>
			</tr>
		</table>
	</fieldset>

		<br>
	<input type="button" onclick="javascript:enviarForm();"
		value="<liferay-ui:message key="salvar" />">
</form>
<script type="text/javascript">
	alterarRef();
</script>


