<%@ include file="/html/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configuracaoURL"/>
<liferay-portlet:renderURL portletConfiguration="true" var="renderURL"/>

<script type="text/javascript">

var count = ${count};
var max = 3;

function marqueiCheck(checkId) {

	if(document.getElementsByName(checkId)[0].checked == true) {
		count++;
	} else {
		count--;
	}
	if(count > max) {
		count--;
		alert("Não é permitido associar mais do que "+max+" fornecedores");
	}
}

function incrementaCount() {
	count++;
}

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

function removeElementAll() {

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
		count--;
		removeElement(id);
	} else {
		count++;
		if(count > max) {
			count--;
			document.getElementById(id).checked = false;
			alert("Não é permitido associar mais do que "+max+" fornecedores");
		} else {
			adiciona(texto,name);
		}
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
	<input type="hidden" name="filtro" value=''/>
	<input type="hidden" name="fornecedoresOrdemFromRequest" id="fornecedoresOrdemFromRequest" value='${fornecedoresOrdemFromRequest}'/>

	<fieldset>
	<legend>
		<liferay-ui:message key="escolha-dos-conteudos" />
	</legend>

	<liferay-ui:message key="categoria"/>
	<liferay-ui:asset-categories-selector curCategoryIds="${curCategoryIds}"/>

	<liferay-ui:message key="tags"/>
	<liferay-ui:asset-tags-selector curTags="${curTags}"/>

	<input type="button" value="<liferay-ui:message key="filtrar"/>" onclick="javascript:filtrar()">
	<div style="border-bottom:1px solid gray; margin-top:4px;margin-bottom:4px;"></div>

		<%
			List<FornecedorVO> fornecedores = (List<FornecedorVO>) request.getAttribute("fornecedores");
			if (fornecedores == null) {
				fornecedores = new ArrayList<FornecedorVO>();
			}

			int linhasPorPagina = 15;
		%>

		<liferay-ui:search-container
			emptyResultsMessage="mensagem.lista.registos.nao.encontrados"
			delta="<%=linhasPorPagina %>">
			<liferay-ui:search-container-results >
				<%
					results = ListUtil.subList(fornecedores,
									searchContainer.getStart(),
									searchContainer.getEnd());
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", request.getAttribute("total"));
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="br.com.rasecmadeiras.fornecedor.vo.FornecedorVO" keyProperty="id" modelVar="fornecedor">
			<liferay-ui:search-container-column-text name="exibir">

			<c:set var="id" value="${fornecedor.id}"/>
			<c:set var="idss" value="${meusFornecedoresIdString}"/>
				<c:choose>
					<c:when test="${fn:contains(idss,id)}">
						<c:set var="ch" value="checked" />
					</c:when>
					<c:otherwise>
						<c:set var="ch" value="" />
					</c:otherwise>
				</c:choose>
				<input onclick="javascript:ckeckChange('${fornecedor.titulo}','${fornecedor.id}',this.id);" id="${fornecedor.id}" type="checkbox" name="${fornecedor.id}" ${ch}>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="id" property="id" />
				<liferay-ui:search-container-column-text orderable="true" name="titulo" property="titulo" />
				<liferay-ui:search-container-column-text orderable="true" name="dataAlteracao" property="dataAlteracao" />
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
						<c:forEach var="fornecedor" items="${meusFornecedores}">
							<option value='${fornecedor.id}'>${fornecedor.titulo}</option>
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

	<legend>
		<liferay-ui:message key="config-gerais"/>
	</legend>

	<liferay-ui:message key="url-destino"/>
	<input type="text" name="urlDestino" size="32" value="${urlDestino}">
</fieldset>

		<br>
	<input type="button" onclick="javascript:enviarForm();"
		value="<liferay-ui:message key="salvar" />">
</form>
<script type="text/javascript">
	alterarRef();
</script>
