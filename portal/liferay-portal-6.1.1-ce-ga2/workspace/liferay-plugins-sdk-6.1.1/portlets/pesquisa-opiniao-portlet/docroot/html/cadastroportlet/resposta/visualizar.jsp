<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoResposta"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idPesquisa" scope="request" />
<jsp:useBean class="java.lang.String" id="idPergunta" scope="request" />

<%
	RespostaVO respostaVO = (RespostaVO) request
			.getAttribute(Constantes.NOME_PARAM_RESPOSTA_VO);
	String btnCancelarVoltar = "botao.voltar";
	if (Constantes.VALOR_PARAM_EXCLUIR_RESPOSTA
			.equals(operacaoResposta)) {
		btnCancelarVoltar = "botao.cancelar";
	}
%>

<%@ include file="/html/cadastroportlet/resposta/mensagens.jspf"%>

<div class="pesquisa_titulo">
	<liferay-ui:message key="<%=titulo%>" />
</div>

<aui:form name="<portlet:namespace />respostavisualizar"
	action="<%=confirmarURL%>" method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.resposta.descricao">
			<textarea name="<%=Constantes.PROP_RESPOSTA_DESCRICAO%>"
				disabled="disabled"><%=respostaVO.getDescricaoCorrente()%></textarea>
		</aui:field-wrapper>
	</aui:fieldset>
	<input type="hidden" name="operacaoResposta" id="operacaoResposta"
		value="<%=operacaoResposta%>" />
	<input type="hidden" name="idResposta" id="idResposta"
		value="<%=respostaVO.getId()%>" />
	<input type="hidden" name="idPesquisa" id="idPesquisa"
		value="<%=idPesquisa%>" />
	<input type="hidden" name="idPergunta" id="idPergunta"
		value="<%=idPergunta%>" />
	<c:if
		test="<%=Constantes.VALOR_PARAM_EXCLUIR_RESPOSTA
							.equals(operacaoResposta)%>">
		<input type="submit"
			value="<liferay-ui:message key="botao.confirmar" />" />&nbsp;
</c:if>
	<input type="button"
		value="<liferay-ui:message key="<%=btnCancelarVoltar%>" />"
		onClick="self.location = '<%=cancelarURL%>';" />
</aui:form>