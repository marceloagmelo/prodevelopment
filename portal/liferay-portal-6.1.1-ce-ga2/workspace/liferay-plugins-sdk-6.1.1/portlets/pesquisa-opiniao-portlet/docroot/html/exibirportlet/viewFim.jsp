<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="voltarInicioURL"
	scope="request" />

<%
	PesquisaVO pesquisaVO = (PesquisaVO) request
			.getAttribute(Constantes.NOME_PARAM_PESQUISA_VO);
%>
<form name="<portlet:namespace />fim" action="<%=voltarInicioURL%>"
	method="POST">
	<div class="pesquisa">
		<c:if test="${exibirTitulo == 'S' }">
			<div class="pesquisa_titulo">
				<liferay-ui:message key="${portletTitulo }" />
			</div>
		</c:if>
		<h3><%=pesquisaVO.getTituloCorrente()%></h3>

		<liferay-ui:success key="mensagem.pesquisaUsuario.finalizada.sucesso"
			message="mensagem.pesquisaUsuario.finalizada.sucesso" />

		<div class="naveg"></div>
		<input type="button" value="<liferay-ui:message key="botao.voltar" />"
			onClick="self.location = '<%=voltarInicioURL%>';" />
	</div>
</form>