<%@ include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configuracaoURL" />

<script type="text/javascript">
	function enviarForm() {

		document.<portlet:namespace />fm_config_99.prefCategoriaProduto.value = document.<portlet:namespace />fm_config_01.<portlet:namespace />prefCategoriaProduto.value;
		document.<portlet:namespace />fm_config_99.prefPaginaDestinoProduto.value = document.<portlet:namespace />fm_config_01.prefPaginaDestinoProduto.value;
		document.<portlet:namespace />fm_config_99.prefPaginaDestinoOutro.value = document.<portlet:namespace />fm_config_02.prefPaginaDestinoOutro.value;
		document.<portlet:namespace />fm_config_99.prefCategoriaOutro.value = document.<portlet:namespace />fm_config_02.<portlet:namespace />prefCategoriaOutro.value;

		document.<portlet:namespace />fm_config_99.submit();
	}
</script>


<form name="<portlet:namespace />fm_config_01">

	<fieldset>
		<legend>
			<liferay-ui:message key="produto" />
		</legend>

		<liferay-ui:message key="label.categoria" />
				<br>
				<liferay-ui:asset-categories-selector curCategoryIds="${prefCategoriaProduto}" hiddenInput="prefCategoriaProduto"/>

				<br>
				<liferay-ui:message key="pagina-destino" />
				<br>
				<input type="text" size="30px" name="<%=Constantes.PREF_PAGINA_DESTINO_PRODUTO%>" value="${prefPaginaDestinoProduto}">
	</fieldset>
</form>
<form name="<portlet:namespace />fm_config_02">
	<fieldset>
		<legend>
			<liferay-ui:message key="outra" />
		</legend>

		<liferay-ui:message key="label.categoria" />
				<br>
				<liferay-ui:asset-categories-selector curCategoryIds="${prefCategoriaOutro}" hiddenInput="prefCategoriaOutro"/>
				<br>
				<liferay-ui:message key="pagina-destino" />
				<br>
				<input type="text" size="30px" name="<%=Constantes.PREF_PAGINA_DESTINO_OUTRO%>" value="${prefPaginaDestinoOutro}">
	</fieldset>
</form>

<form action="<%=configuracaoURL%>" method="post" name="<portlet:namespace />fm_config_99">
	<input type="hidden" name="prefCategoriaProduto">
	<input type="hidden" name="prefPaginaDestinoProduto">
	<input type="hidden" name="prefPaginaDestinoOutro">
	<input type="hidden" name="prefCategoriaOutro">

	<fieldset>
		<legend>
			<liferay-ui:message key="config-palavras-relevantes" />
		</legend>


		<div style="float:left">
			<liferay-ui:message key="palavras-default" />
			<br>
			<select size="20" id="listaStopWords">
				<c:forEach var="itemLista" items="${listaStopWords}">
					<option>${itemLista}</option>
				</c:forEach>
			</select>
		</div>
		<div style="float:left;margin-left:10px">
			<liferay-ui:message key="lista-do-usuario" />
			<br>
			<textarea rows="18" cols="7" name="listaUsuario">${listaUsuario}</textarea>
		</div>
	</fieldset>
	<br> <input type="button" value="<liferay-ui:message key="salvar" />" onclick="javascript:enviarForm();">
</form>
