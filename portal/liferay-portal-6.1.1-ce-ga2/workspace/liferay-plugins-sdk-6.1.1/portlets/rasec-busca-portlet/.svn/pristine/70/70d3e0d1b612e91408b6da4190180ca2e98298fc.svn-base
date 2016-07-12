<%@ include file="init.jsp" %>

<script type="text/javascript">

function executaBuscaEnter(obj,paramBusca) {

	var key;
	if(window.event){
		key = event.keyCode;
		if(key == 13){
			executaBusca(paramBusca);
		} else{
			window.event.returnValue=false;
		}
	} else{
		key = obj.which;
		if(key == 13){
			executaBusca(paramBusca);
		} else{
			return true;
		}
	}
}

function executaBusca(paramBusca) {

	var prefUrlDestino = document.forms[0].prefUrlDestino.value;
	var tconteudo = document.forms[0].tconteudo.value;

	if(paramBusca == null || paramBusca == 'Pesquisar...' || paramBusca == '') {
		alert("A busca n„o pode estar vazia");
		return;
	}

	document.forms[0].action = prefUrlDestino+"?tconteudo="+tconteudo+"&parambusca="+paramBusca;

	document.forms[0].submit();
}
</script>

<div>
	<div class="bg-4">
		<form id="form-2" action="/web/guest/resultado-busca" method="post" enctype="multipart/form-data">
			<input type="hidden" name="prefUrlDestino" id="prefUrlDestino" value="${prefUrlDestino}">
			<fieldset class="fieldBusca">
				<%String tconteudo = (String)request.getAttribute("tconteudo"); %>
				<select name="tconteudo" style="float: left; margin-right: 5px; width: 100px; height: 24px;">
					<option value=""/>
					<option value="<%=Constantes.TIPO_CONTEUDO_PRODUTO%>" <%=Constantes.TIPO_CONTEUDO_PRODUTO.equals(tconteudo)?"selected":""%>><liferay-ui:message key="label.tipoConteudo.produto"/></option>
					<option value="<%=Constantes.TIPO_CONTEUDO_FORNECEDOR%>" <%=Constantes.TIPO_CONTEUDO_FORNECEDOR.equals(tconteudo)?"selected":""%>><liferay-ui:message key="label.tipoConteudo.fornecedor"/></option>
					<option value="<%=Constantes.TIPO_CONTEUDO_VIDEOS%>" <%=Constantes.TIPO_CONTEUDO_VIDEOS.equals(tconteudo)?"selected":""%>><liferay-ui:message key="label.tipoConteudo.video"/></option>
					<option value="<%=Constantes.TIPO_CONTEUDO_OUTROS%>" <%=Constantes.TIPO_CONTEUDO_OUTROS.equals(tconteudo)?"selected":""%>><liferay-ui:message key="label.tipoConteudo.outros"/></option>
				</select>
				&nbsp;&nbsp;
				<label class="wrapper">
				<span class="input-1">
						<c:choose>
							<c:when test="${parambusca == null}">
								<c:set var="textoTermo" value="Pesquisar..."/>
							</c:when>
							<c:otherwise>
								<c:set var="textoTermo" value="${parambusca}"/>
							</c:otherwise>
						</c:choose>
						<input name="parambusca" value="${textoTermo }"
						id="parambusca" onkeyup="javascript:executaBuscaEnter(event,document.getElementById('parambusca').value)" onBlur="if(this.value=='') this.value='Pesquisar...'"
						onFocus="if(this.value =='Pesquisar...' ) this.value=''">
				</span> <a href="#" class="form2_btn"
					onClick="executaBusca(document.getElementById('parambusca').value);">Search</a> </label>
			</fieldset>
		</form>
	</div>
</div>