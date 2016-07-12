<%@ include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configuracaoURL" />

<script type="text/javascript">
	function enviarForm() {

		document.<portlet:namespace />fm_config_99.prefCategoriaServico.value = document.<portlet:namespace />fm_config_01.<portlet:namespace />prefCategoriaServico.value;
		document.<portlet:namespace />fm_config_99.prefPaginaDestinoServico.value = document.<portlet:namespace />fm_config_01.prefPaginaDestinoServico.value;
		document.<portlet:namespace />fm_config_99.prefCategoriaCliente.value = document.<portlet:namespace />fm_config_02.<portlet:namespace />prefCategoriaCliente.value;
		document.<portlet:namespace />fm_config_99.prefPaginaDestinoCliente.value = document.<portlet:namespace />fm_config_02.prefPaginaDestinoCliente.value;
		document.<portlet:namespace />fm_config_99.prefCategoriaNoticia.value = document.<portlet:namespace />fm_config_03.<portlet:namespace />prefCategoriaNoticia.value;
		document.<portlet:namespace />fm_config_99.prefPaginaDestinoNoticia.value = document.<portlet:namespace />fm_config_03.prefPaginaDestinoNoticia.value;
		document.<portlet:namespace />fm_config_99.prefPaginaDestinoOutro.value = document.<portlet:namespace />fm_config_04.prefPaginaDestinoOutro.value;
		document.<portlet:namespace />fm_config_99.prefCategoriaOutro.value = document.<portlet:namespace />fm_config_04.<portlet:namespace />prefCategoriaOutro.value;
		document.<portlet:namespace />fm_config_99.prefCategoriaVideo.value = document.<portlet:namespace />fm_config_05.<portlet:namespace />prefCategoriaVideo.value;

		document.<portlet:namespace />fm_config_99.submit();
	}
</script>


<form name="<portlet:namespace />fm_config_01">

	<fieldset>
		<legend>
			<liferay-ui:message key="servico" />
		</legend>

		<liferay-ui:message key="label.categoria" />
				<br>
				<liferay-ui:asset-categories-selector curCategoryIds="${prefCategoriaServico}" hiddenInput="prefCategoriaServico"/>

				<br>
				<liferay-ui:message key="pagina-destino" />
				<br>
				<input type="text" size="30px" name="<%=Constantes.PREF_PAGINA_DESTINO_SERVICO%>" value="${prefPaginaDestinoServico}">
	</fieldset>
</form>
<form name="<portlet:namespace />fm_config_02">
	<fieldset>
		<legend>
			<liferay-ui:message key="cliente" />
		</legend>

		<liferay-ui:message key="label.categoria" />
				<br>
				<liferay-ui:asset-categories-selector curCategoryIds="${prefCategoriaCliente}" hiddenInput="prefCategoriaCliente"/>
				<br>
				<liferay-ui:message key="pagina-destino" />
				<br>
				<input type="text" size="30px" name="<%=Constantes.PREF_PAGINA_DESTINO_CLIENTE%>" value="${prefPaginaDestinoCliente}">
	</fieldset>
</form>
<form name="<portlet:namespace />fm_config_03">
	<fieldset>
		<legend>
			<liferay-ui:message key="noticia" />
		</legend>

		<liferay-ui:message key="label.categoria" />
				<br>
				<liferay-ui:asset-categories-selector curCategoryIds="${prefCategoriaNoticia}" hiddenInput="prefCategoriaNoticia"/>
				<br>
				<liferay-ui:message key="pagina-destino" />
				<br>
				<input type="text" size="30px" name="<%=Constantes.PREF_PAGINA_DESTINO_NOTICIA%>" value="${prefPaginaDestinoNoticia}">
	</fieldset>
</form>
<form name="<portlet:namespace />fm_config_04">
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
<form name="<portlet:namespace />fm_config_05">
	<fieldset>
		<legend>
			<liferay-ui:message key="video" />
		</legend>

		<liferay-ui:message key="label.categoria" />
				<br>
				<liferay-ui:asset-categories-selector curCategoryIds="${prefCategoriaVideo}" hiddenInput="prefCategoriaVideo"/>
	</fieldset>
</form>
<form action="<%=configuracaoURL%>" method="post" name="<portlet:namespace />fm_config_99">
	<input type="hidden" name="prefCategoriaServico">
	<input type="hidden" name="prefPaginaDestinoServico">
	<input type="hidden" name="prefCategoriaCliente">
	<input type="hidden" name="prefPaginaDestinoCliente">
	<input type="hidden" name="prefCategoriaNoticia">
	<input type="hidden" name="prefPaginaDestinoNoticia">
	<input type="hidden" name="prefCategoriaVideo">
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
