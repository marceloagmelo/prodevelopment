<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoPergunta"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idPesquisa" scope="request" />
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
	PortletPreferences prefs = renderRequest.getPreferences();
	int linhasPorPagina = Integer.valueOf(Constantes.DEFAULT_LINHAS_PAGINA);
	String toolbarItem = ParamUtil.getString(request, "toolbarItem",
			"view-all");
%>

<%@ include file="/html/cadastroportlet/pergunta/mensagens.jspf"%>
<%@ include file="/html/cadastroportlet/resposta/mensagens.jspf"%>

<div class="pesquisa_titulo">
	<liferay-ui:message key="<%=titulo%>" />
</div>

<aui:form name="fm"
	action="<%=confirmarURL%>" method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.pergunta.descricao">
			<liferay-ui:input-localized name="descricao" type="textarea"
				xml="<%=perguntaVO.getDescricao()%>" />
		</aui:field-wrapper>
	</aui:fieldset>
	<input type="hidden" name="operacaoPergunta" id="operacaoPergunta"
		value="<%=operacaoPergunta%>" />
	<input type="hidden" name="idPergunta" id="idPergunta"
		value="<%=perguntaVO.getId()%>" />
	<input type="hidden" name="idPesquisa" id="idPesquisa"
		value="<%=idPesquisa%>" />
	<input type="hidden" name="groupId" id="groupId" value="<%=groupId%>" />
	<input type="submit"
		value="<liferay-ui:message key="botao.confirmar" />" />&nbsp; <input
		type="button"
		value="<liferay-ui:message key="<%=btnCancelarVoltar%>" />"
		onClick="self.location = '<%=cancelarURL%>';" />
</aui:form>
<c:if
	test="<%=(Constantes.VALOR_PARAM_ALTERAR_PERGUNTA
						.equals(operacaoPergunta))%>">
	<liferay-ui:panel-container id="panel-container-pergunta"
		extended="true" accordion="false">
		<div class="separator"></div>
		<%@ include file="/html/cadastroportlet/resposta/view.jspf"%>
	</liferay-ui:panel-container>
</c:if>

