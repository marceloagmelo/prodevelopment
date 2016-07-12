<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoPergunta" scope="request" />
<jsp:useBean class="java.lang.String" id="idTeste" scope="request" />

<%
	PerguntaVO perguntaVO = (PerguntaVO) request
			.getAttribute(Constantes.NOME_PARAM_PERGUNTA_VO);
%>

<div class="desc_operacao"><liferay-ui:message key="<%=titulo %>" /></div>

<aui:form name="<portlet:namespace />perguntavisualizar"
	action="<%=confirmarURL%>" method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.pergunta.descricao">
			<textarea name="<%=Constantes.PROP_PERGUNTA_DESCRICAO%>"
				disabled="disabled"><%=perguntaVO.getDescricaoCorrente()%></textarea>
		</aui:field-wrapper>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.pergunta.justificativaResposta">
			<textarea name="<%=Constantes.PROP_PERGUNTA_JUSTIFICATIVA_RESPOSTA%>"
				disabled="disabled"><%=perguntaVO.getJustificativaRespostaCorrente()%></textarea>
		</aui:field-wrapper>
	</aui:fieldset>

<input type="hidden" name="operacaoPergunta" id="operacaoTeste" value="<%=operacaoPergunta%>" />
<input type="hidden" name="idPergunta" id="idPergunta" value="<%=perguntaVO.getId()%>" />
<input type="hidden" name="idTeste" id="idTeste" value="<%=idTeste%>" />
<input type="hidden" name="formatoRespostaPergunta" id="formatoRespostaPergunta" value="1" />

<c:if test="<%= Constantes.VALOR_PARAM_EXCLUIR_PERGUNTA.equals(operacaoPergunta) %>">
	<input type="submit"
		value="<liferay-ui:message key="botao.confirmar" />" />&nbsp;
</c:if> <input type="button"
	value="<liferay-ui:message key="botao.cancelar" />"
	onClick="self.location = '<%=cancelarURL%>';" />
</aui:form>
