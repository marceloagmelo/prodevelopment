<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoPergunta"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idTeste" scope="request" />
<jsp:useBean class="java.lang.String" id="groupId" scope="request" />

<%
	PerguntaVO perguntaVO = (PerguntaVO) request
			.getAttribute(Constantes.NOME_PARAM_PERGUNTA_VO);

	List listaResposta = (List) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_RESPOSTA);
	String btnCancelarVoltar = "botao.voltar";
	if (listaResposta == null) {
		listaResposta = new ArrayList();
		btnCancelarVoltar = "botao.cancelar";
	}
	int linhasPorPagina = 15;
	String toolbarItem = ParamUtil.getString(request, "toolbarItem",
			"view-all");
%>

<%@ include file="/html/cadastroportlet/pergunta/mensagens.jspf"%>
<%@ include file="/html/cadastroportlet/resposta/mensagens.jspf"%>

<div class="desc_operacao">
	<liferay-ui:message key="<%=titulo %>" />
</div>

<aui:form name="fm" action="<%=confirmarURL%>"
	method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.pergunta.descricao">
			<liferay-ui:input-localized name="<%=Constantes.PROP_PERGUNTA_DESCRICAO%>" type="textarea"
				xml="<%=perguntaVO.getDescricao()%>" />
		</aui:field-wrapper>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.pergunta.justificativaResposta">
			<liferay-ui:input-localized name="<%=Constantes.PROP_PERGUNTA_JUSTIFICATIVA_RESPOSTA%>" type="textarea"
				xml="<%=perguntaVO.getJustificativaResposta()%>" />
		</aui:field-wrapper>
		<aui:field-wrapper cssClass="lfr-input-text-container" label="label.pergunta.pontuacao">
			<input size="20" maxlength="5" value="<%=perguntaVO.getPontuacao() %>"
						name="<%=Constantes.PROP_PERGUNTA_PONTUACAO%>" onkeypress="javascript:mascara(this,valorDecimal);"/>
		</aui:field-wrapper>
	</aui:fieldset>

	<input type="hidden" name="operacaoPergunta" id="operacaoPergunta"
		value="<%=operacaoPergunta%>" /> <input type="hidden"
		name="idPergunta" id="idPergunta" value="<%=perguntaVO.getId()%>" />
	<input type="hidden" name="idTeste" id="idTeste" value="<%=idTeste%>" />
	<input type="hidden" name="groupId" id="groupId" value="<%=groupId%>" />
	<input type="hidden" name="formatoRespostaPergunta"
		id="formatoRespostaPergunta" value="1" /> <input type="submit"
		value="<liferay-ui:message key="botao.confirmar" />" />&nbsp; <input
		type="button" value="<liferay-ui:message key="<%=btnCancelarVoltar %>" />"
		onClick="self.location = '<%=cancelarURL%>';" />
</aui:form>
<c:if
	test="<%=(Constantes.VALOR_PARAM_ALTERAR_PERGUNTA.equals(operacaoPergunta))%>">
	<liferay-ui:panel-container id="panel-container-pergunta"
		extended="true" accordion="false">
		<div class="separator"></div>
		<%@ include file="/html/cadastroportlet/resposta/view.jspf"%>
	</liferay-ui:panel-container>
</c:if>

