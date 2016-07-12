<%@ include file="/html/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configuracaoURL"/>
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL"/>

<script type="text/javascript">

var alteracao = 0;

function enviarForm() {

	var lista = document.getElementById("layoutIdsBox");

	for(var i = 0;i<lista.options.length;i++) {
		lista.options[i].selected = true;
	}

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

function removeElementAll(id) {

var lista = document.getElementById('layoutIdsBox');

	for(var i=lista.options.length-1;i>=0;i--) {
		lista.remove(i);
	}
}

function adiciona(texto,name) {
    linha = document.createElement("OPTION");
    linha.text = texto;
    linha.value = name;
    linha.name = name;

    try {
    	document.forms[0].layoutIdsBox.add(linha);
    }catch (e) {
    	document.forms[0].layoutIdsBox.options.add(linha);
	}
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
	document.forms[0].filtro.value = 'sim';

	if(alteracao == 1) {
		if (!confirm("Deseja salvar alterações antes de filtrar?")) {
			document.forms[0].action = '<%=renderURL%>';
		}
	} else {
		document.forms[0].action = '<%=renderURL%>';
	}

	removeElementAll();
	enviarForm();
}

function alterarTransacao() {

	var div = document.getElementById("intervaloTransacoes");
	var check = document.getElementById("ckeckTransacao");


	if(check.checked == false) {
		div.style.display = "none";
	} else {
		div.style.display = "block";
	}
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

$(document).ready(function() {

	var j<portlet:namespace/> = jQuery.noConflict();

	j<portlet:namespace/>('a.last').attr('target',"");
	j<portlet:namespace/>('a.next').attr('target',"");
	j<portlet:namespace/>('a.first').attr('target',"");
	j<portlet:namespace/>('a.previous').attr('target',"");

	var firstLink = "";
	firstLink += j<portlet:namespace/>('a.first').attr('href');

	if(firstLink == "undefined")
		firstLink = j<portlet:namespace/>('a.last').attr('href');

	var link = firstLink;

	j<portlet:namespace/>('select#<portlet:namespace />page').attr('onChange', "<portlet:namespace />paginateInCombo('"+link+"', this)");

	j<portlet:namespace/>('a.last').attr('onClick',"<portlet:namespace />paginate('"+j<portlet:namespace/>('a.last').attr('href')+"')");
	j<portlet:namespace/>('a.next').attr('onClick',"<portlet:namespace />paginate('"+j<portlet:namespace/>('a.next').attr('href')+"')");
	j<portlet:namespace/>('a.first').attr('onClick',"<portlet:namespace />paginate('"+j<portlet:namespace/>('a.first').attr('href')+"')");
	j<portlet:namespace/>('a.previous').attr('onClick',"<portlet:namespace />paginate('"+j<portlet:namespace/>('a.previous').attr('href')+"')");

	j<portlet:namespace/>('a.last').attr('href',"javascript:void(0)");
	j<portlet:namespace/>('a.next').attr('href',"javascript:void(0)");
	j<portlet:namespace/>('a.first').attr('href',"javascript:void(0)");
	j<portlet:namespace/>('a.previous').attr('href',"javascript:void(0)");
});

function <portlet:namespace />paginate(url)
{

	var j<portlet:namespace/> = jQuery.noConflict();
	var list = "";

	j<portlet:namespace/>("#layoutIdsBox>option").map(function() {
		list += j<portlet:namespace/>(this).val()+",";
	});


	window.location.href= url + "&ordem="+ list;
}
function <portlet:namespace />paginateInCombo(url, value)
{
	var j<portlet:namespace/> = jQuery.noConflict();
	var list = "";

	j<portlet:namespace/>("#layoutIdsBox>option").map(function() {
		list += j<portlet:namespace/>(this).val()+",";
	});

	url = url.replace(/page=\d+/,"page="+value.options[value.selectedIndex].value);

	window.location.href= url + "&ordem="+ list;
}
</script>

<form action="<%=configuracaoURL%>" method="post">

	<input type="hidden" name="inner" />
	<input type="hidden" name="passei" value='${passei}'/>
	<input type="hidden" name="filtro" value='nao'/>

	<input type="hidden" name="bannersOrdemFromRequest" id="bannersOrdemFromRequest" value='${bannersOrdemFromRequest}'/>

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
			<c:set var="idss" value="${meusBannersIdString}"/>
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
				<td><select id="layoutIdsBox" name="layoutIdsBox" size="7" multiple="multiple">
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

	<fieldset>
	<legend><liferay-ui:message key="config-gerais"/></legend>


		<liferay-ui:message key="intervalo-entre-banners"/>
		<input type="text" name="intervalo" size="1px" value="${intervalo}">
		<liferay-ui:message key="segundos"/>

		<br><br>

		<%String duracao = (String)request.getAttribute("duracao"); %>

		<liferay-ui:message key="duracao-da-transacao"/>
		<select name="duracao">
			<option value="<%=Constantes.DURACAO_LENTA%>" <%=duracao.equals(Constantes.DURACAO_LENTA)?"selected":""%> ><liferay-ui:message key="lenta"/></option>
			<option value="<%=Constantes.DURACAO_NORMAL%>" <%=duracao.equals(Constantes.DURACAO_NORMAL)?"selected":""%> ><liferay-ui:message key="normal"/></option>
			<option value="<%=Constantes.DURACAO_RAPIDA%>" <%=duracao.equals(Constantes.DURACAO_RAPIDA)?"selected":""%> ><liferay-ui:message key="rapido"/></option>
			<option value="<%=Constantes.DURACAO_MUITO_RAPIDA%>" <%=duracao.equals(Constantes.DURACAO_MUITO_RAPIDA)?"selected":""%> ><liferay-ui:message key="muito-rapida"/></option>
		</select>

		<%String tipoBanner = (String)request.getAttribute("tipoBanner"); %>
		<br><br>
		<liferay-ui:message key="tipo-de-banner"/>
		<select name="tipoBanner">
			<option value="<%=Constantes.TIPO_BANNER_GRANDE_1%>" <%=tipoBanner.equals(Constantes.TIPO_BANNER_GRANDE_1)?"selected":""%> ><liferay-ui:message key="grande-1"/></option>
			<option value="<%=Constantes.TIPO_BANNER_GRANDE_2%>" <%=tipoBanner.equals(Constantes.TIPO_BANNER_GRANDE_2)?"selected":""%> ><liferay-ui:message key="grande-2"/></option>
			<option value="<%=Constantes.TIPO_BANNER_GRANDE_3%>" <%=tipoBanner.equals(Constantes.TIPO_BANNER_GRANDE_3)?"selected":""%> ><liferay-ui:message key="grande-3"/></option>
			<option value="<%=Constantes.TIPO_BANNER_PEQUENO_1%>" <%=tipoBanner.equals(Constantes.TIPO_BANNER_PEQUENO_1)?"selected":""%> ><liferay-ui:message key="pequeno-1"/></option>
		</select>

		<br><br>
		<input type="checkbox" name="exibirTitulo" ${exibirTitulo}><liferay-ui:message key="exibir-titulo"/>
		<br><br>
		<input type="checkbox" name="exibirControles" ${exibirControles}><liferay-ui:message key="exibir-controles"/>

	</fieldset>
		<br>
	<input type="button" onclick="javascript:enviarForm();"
		value="<liferay-ui:message key="salvar" />">
</form>
<script type="text/javascript">
	alterarRef();
</script>
