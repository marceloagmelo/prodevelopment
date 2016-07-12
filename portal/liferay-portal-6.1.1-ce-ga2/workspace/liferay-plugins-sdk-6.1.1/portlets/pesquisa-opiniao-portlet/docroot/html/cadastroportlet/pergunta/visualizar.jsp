<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoPergunta"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idPesquisa" scope="request" />

<%
	PerguntaVO perguntaVO = (PerguntaVO) request
			.getAttribute(Constantes.NOME_PARAM_PERGUNTA_VO);
	String btnCancelarVoltar = "botao.voltar";
	if (Constantes.VALOR_PARAM_EXCLUIR_PERGUNTA
			.equals(operacaoPergunta)) {
		btnCancelarVoltar = "botao.cancelar";
	}
	List<Resposta> listaResposta = (List<Resposta>) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_RESPOSTA);
%>

<%@ include file="/html/cadastroportlet/pergunta/mensagens.jspf"%>

<div class="pesquisa_titulo">
	<liferay-ui:message key="<%=titulo%>" />
</div>

<aui:form name="<portlet:namespace />perguntavisualizar"
	action="<%=confirmarURL%>" method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.pergunta.descricao">
			<textarea name="<%=Constantes.PROP_PERGUNTA_DESCRICAO%>"
				disabled="disabled"><%=perguntaVO.getDescricaoCorrente()%></textarea>
		</aui:field-wrapper>
	</aui:fieldset>
	<input type="hidden" name="operacaoPergunta" id="operacaoPesquisa"
		value="<%=operacaoPergunta%>" />
	<input type="hidden" name="idPergunta" id="idPergunta"
		value="<%=perguntaVO.getId()%>" />
	<input type="hidden" name="idPesquisa" id="idPesquisa"
		value="<%=idPesquisa%>" />

	<c:if
		test="<%=Constantes.VALOR_PARAM_EXCLUIR_PERGUNTA
							.equals(operacaoPergunta)%>">
		<input type="submit"
			value="<liferay-ui:message key="botao.confirmar" />" />&nbsp;
</c:if>
	<input type="button"
		value="<liferay-ui:message key="<%=btnCancelarVoltar%>" />"
		onClick="self.location = '<%=cancelarURL%>';" />
	<liferay-ui:panel-container id="panel-container-pergunta"
		extended="true" accordion="false">
		<div class="separator"></div>
		<%@ include
			file="/html/cadastroportlet/pergunta/visualizarRespostas.jspf"%>
	</liferay-ui:panel-container>
</aui:form>