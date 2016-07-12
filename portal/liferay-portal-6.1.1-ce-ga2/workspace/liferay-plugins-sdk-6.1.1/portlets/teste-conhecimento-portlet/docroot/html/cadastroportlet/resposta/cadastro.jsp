<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoResposta"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idTeste" scope="request" />
<jsp:useBean class="java.lang.String" id="idPergunta" scope="request" />
<jsp:useBean class="java.lang.String" id="groupId" scope="request" />

<%
	RespostaVO respostaVO = (RespostaVO) request
			.getAttribute(Constantes.NOME_PARAM_RESPOSTA_VO);
%>

<liferay-ui:error key="mensagem.erro.gravar.bancoDados"
	message="mensagem.erro.gravar.bancoDados" />
<liferay-ui:success key="mensagem.erro.bancoDados"
	message="mensagem.erro.bancoDados" />
<%@ include file="/html/cadastroportlet/resposta/mensagens.jspf"%>

<div class="desc_operacao">
	<liferay-ui:message key="<%=titulo%>" />
</div>

<aui:form name="fm" action="<%=confirmarURL%>" method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.resposta.descricao">
			<liferay-ui:input-localized
				name="<%=Constantes.PROP_RESPOSTA_DESCRICAO%>" type="textarea"
				xml="<%=respostaVO.getDescricao()%>" />
		</aui:field-wrapper>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.resposta.correta">
			<select name="<%=Constantes.PROP_RESPOSTA_CORRETA%>"
				id="<%=Constantes.PROP_RESPOSTA_CORRETA%>">
				<option value="">
					<liferay-ui:message key="label.selecione" />
				</option>
				<%
					if (Constantes.S.equals(respostaVO.getCorreta())) {
				%>
				<option value="S" selected="selected">
					<liferay-ui:message key="label.sim" />
				</option>
				<%
					} else {
				%>
				<option value="S">
					<liferay-ui:message key="label.sim" />
				</option>
				<%
					}
				%>
				<%
					if (Constantes.N.equals(respostaVO.getCorreta())) {
				%>
				<option value="N" selected="selected">
					<liferay-ui:message key="label.nao" />
				</option>
				<%
					} else {
				%>
				<option value="N">
					<liferay-ui:message key="label.nao" />
				</option>
				<%
					}
				%>
			</select>
		</aui:field-wrapper>
	</aui:fieldset>
	<input type="hidden" name="operacaoResposta" id="operacaoResposta"
		value="<%=operacaoResposta%>" />
	<input type="hidden" name="idResposta" id="idResposta"
		value="<%=respostaVO.getId()%>" />
	<input type="hidden" name="idTeste" id="idTeste" value="<%=idTeste%>" />
	<input type="hidden" name="idPergunta" id="idPergunta"
		value="<%=idPergunta%>" />
	<input type="hidden" name="groupId" id="groupId" value="<%=groupId%>" />
	<input type="hidden" name="tipoResposta" id="tipoResposta" value="1" />
	<input type="hidden" name="comentarioResposta" id="comentarioResposta"
		value="0" />
	<input type="submit"
		value="<liferay-ui:message key="botao.confirmar" />" />&nbsp; <input
		type="button" value="<liferay-ui:message key="botao.cancelar" />"
		onClick="self.location = '<%=cancelarURL%>';" />
</aui:form>