<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoTeste"
	scope="request" />
<jsp:useBean class="java.lang.String" id="groupId" scope="request" />
<%
	TesteVO testeVO = (TesteVO) request
			.getAttribute(Constantes.NOME_PARAM_TESTE_VO);

	List<Pergunta> listaPergunta = (List<Pergunta>) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA);
	String btnCancelarVoltar = "botao.voltar";
	if (listaPergunta == null) {
		listaPergunta = new ArrayList<Pergunta>();
		btnCancelarVoltar = "botao.cancelar";
	}
	int linhasPorPagina = Integer.valueOf(Constantes.DEFAULT_LINHAS_PAGINA);
	String toolbarItem = ParamUtil.getString(request, "toolbarItem",
			"view-all");
%>

<%@ include file="/html/cadastroportlet/mensagens.jspf"%>

<div class="teste_titulo">
	<liferay-ui:message key="<%=titulo%>" />
</div>

<aui:form name="fm" action="<%=confirmarURL%>" method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-input-text-container" label="label.teste.titulo">
			<liferay-ui:input-localized name="titulo" xml="<%= testeVO.getTitulo() %>" />
		</aui:field-wrapper>
		<aui:field-wrapper cssClass="lfr-textarea-container" label="label.teste.descricao">
		<liferay-ui:input-localized name="descricao" type="textarea" xml="<%=testeVO.getDescricao() %>"/>
		</aui:field-wrapper>
		<aui:select label="label.teste.ativo"
			name="<%=Constantes.PROP_TESTE_ATIVO%>">
			<%
				if (Constantes.N.equals(testeVO.getAtivo())) {
			%>
			<option value="S">
				<liferay-ui:message key="label.sim" />
			</option>
			<option value="N" selected="true">
				<liferay-ui:message key="label.nao" />
			</option>
			<%
				} else {
			%>
			<option value="S" selected="true">
				<liferay-ui:message key="label.sim" />
			</option>
			<option value="N">
				<liferay-ui:message key="label.nao" />
			</option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	<div class="separator"></div>
	<input type="hidden" name="operacaoTeste" id="operacaoTeste"
		value="<%=operacaoTeste%>" />
	<input type="hidden" name="idTeste" id="idTeste"
		value="<%=testeVO.getId()%>" />
	<input type="hidden" name="groupId" id="groupId" value="<%=groupId%>" />
	<input type="submit"
		value="<liferay-ui:message key="botao.confirmar" />" />&nbsp; <input
		type="button"
		value="<liferay-ui:message key="<%=btnCancelarVoltar%>" />"
		onClick="self.location = '<%=cancelarURL%>';" />
</aui:form>
<c:if
	test="<%=(Constantes.VALOR_PARAM_ALTERAR_TESTE
						.equals(operacaoTeste))%>">
	<liferay-ui:panel-container id="panel-container-teste"
		extended="true" accordion="false">
		<div class="separator"></div>

		<%@ include file="/html/cadastroportlet/pergunta/view.jspf"%>
	</liferay-ui:panel-container>
</c:if>

