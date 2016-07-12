<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="voltarInicioURL"
	scope="request" />

<%
	TesteVO pesquisaVO = (TesteVO) request
			.getAttribute(Constantes.NOME_PARAM_TESTE_VO);
%>
<form name="formExibirTeste" action="<%=voltarInicioURL%>" method="POST">
	<div class="pesquisa">
		<h3><%=pesquisaVO.getTituloCorrente()%></h3>

		<liferay-ui:success key="mensagem.testeaUsuario.finalizado.sucesso"
			message="mensagem.testeaUsuario.finalizado.sucesso" />
		<div class="naveg">
			<a class="botao"
				href="javascript: document.formExibirTeste.submit();"
				title=<liferay-ui:message key="botao.voltar" />><liferay-ui:message
					key="botao.voltar" /> </a>
		</div>
	</div>
</form>
