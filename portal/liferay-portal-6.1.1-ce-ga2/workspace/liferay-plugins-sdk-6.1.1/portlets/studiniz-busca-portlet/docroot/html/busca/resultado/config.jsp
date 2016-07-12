<%@ include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<script type="text/javascript">
	function enviarForm() {
		document.<portlet:namespace />fm_config.submit();
	}
</script>


<form action="<%=configuracaoURL%>" method="post"
	name="<portlet:namespace />fm_config">

	<fieldset>
		<legend>
			<liferay-ui:message key="config-gerais" />
		</legend>

		<br>
		<liferay-ui:message key="resultado-por-pagina" />
		<br> <input type="text"
			name="<%=Constantes.PREF_QUANTIDADE_RESULTADO%>"
			value="${prefQuatidadeResultado }" size="10" maxlength="2"
			onkeypress="return SomenteNumero(event)" /> <br>
		<liferay-ui:message key="pagina-destino" />
		<br> <input type="text" size="30px"
			name="<%=Constantes.PREF_PAGINA_DESTINO_CONTEUDO%>"
			value="${prefPaginaDestinoConteudo}">
	</fieldset>
	<br> <input type="button"
		value="<liferay-ui:message key="salvar" />"
		onclick="javascript:enviarForm();">
</form>
