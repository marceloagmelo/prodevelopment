<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoTeste"
	scope="request" />
<%
	TesteVO testeVO = (TesteVO) request
			.getAttribute(Constantes.NOME_PARAM_TESTE_VO);
	int linhasPorPagina = Integer
			.valueOf(Constantes.DEFAULT_LINHAS_PAGINA);
	List<Pergunta> listaPergunta = (List<Pergunta>) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA);
	if (listaPergunta == null) {
		listaPergunta = new ArrayList<Pergunta>();
	}
	String btnCancelarVoltar = "botao.voltar";
	if (Constantes.VALOR_PARAM_EXCLUIR_TESTE
			.equals(operacaoTeste)) {
		btnCancelarVoltar = "botao.cancelar";
	}
	List<PerguntaVO> listaPerguntaVO = (List<PerguntaVO>) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA_VO);
%>

<%@ include file="/html/cadastroportlet/mensagens.jspf"%>

<c:if test="${exibirTitulo == 'S' }">
	<div class="teste_titulo">
		<liferay-ui:message key="${portletTitulo }" />
	</div>
</c:if>

<aui:form name="<portlet:namespace />visualizar"
	action="<%=confirmarURL%>" method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-input-text-container"
			label="label.teste.titulo">
			<input type="text" name="tituloTeste" size="80"
				value="<%=testeVO.getTituloCorrente()%>" disabled="disabled" />
		</aui:field-wrapper>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.teste.descricao">
			<textarea name="descricaoTeste" disabled="disabled"><%=testeVO.getDescricaoCorrente()%></textarea>
		</aui:field-wrapper>
		<aui:field-wrapper cssClass="lfr-input-text-container"
			label="label.teste.ativo">
			<%
				if (Constantes.S.equals(testeVO.getAtivo())) {
			%>
			<input type="text" name="<%=Constantes.PROP_TESTE_ATIVO%>"
				size="10" value="<liferay-ui:message key="label.sim" />"
				disabled="disabled" />
			<%
				} else {
			%>
			<input type="text" name="<%=Constantes.PROP_TESTE_ATIVO%>"
				size="10" value="<liferay-ui:message key="label.nao" />"
				disabled="disabled" />
			<%
				}
			%>
		</aui:field-wrapper>

	</aui:fieldset>
	<input type="hidden" name="operacaoTeste" id="operacaoTeste"
		value="<%=operacaoTeste%>" />
	<input type="hidden" name="idTeste" id="idTeste"
		value="<%=testeVO.getId()%>" />
	<c:if
		test="<%=Constantes.VALOR_PARAM_EXCLUIR_TESTE
							.equals(operacaoTeste)%>">
		<input type="submit"
			value="<liferay-ui:message key="botao.confirmar" />" />&nbsp;
</c:if>
	<input type="button"
		value="<liferay-ui:message key="<%=btnCancelarVoltar%>" />"
		onClick="self.location = '<%=cancelarURL%>';" />
	<liferay-ui:panel-container id="panel-container-teste"
		extended="true">
		<div class="separator"></div>

		<%@ include file="/html/cadastroportlet/visualizarPerguntas.jspf"%>
	</liferay-ui:panel-container>
</aui:form>
