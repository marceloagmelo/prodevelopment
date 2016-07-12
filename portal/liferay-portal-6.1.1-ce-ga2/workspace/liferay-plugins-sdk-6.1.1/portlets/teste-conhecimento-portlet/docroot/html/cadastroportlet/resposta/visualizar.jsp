<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoResposta"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idTeste" scope="request" />
<jsp:useBean class="java.lang.String" id="idPergunta" scope="request" />

<%
	RespostaVO respostaVO = (RespostaVO) request
			.getAttribute(Constantes.NOME_PARAM_RESPOSTA_VO);
%>

<div class="desc_operacao"><liferay-ui:message key="<%=titulo %>" /></div>

<aui:form name="<portlet:namespace />respostavisualizar"
	action="<%=confirmarURL%>" method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.resposta.descricao">
			<textarea name="<%=Constantes.PROP_RESPOSTA_DESCRICAO%>"
				disabled="disabled"><%=respostaVO.getDescricaoCorrente()%></textarea>
		</aui:field-wrapper>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.resposta.correta">
		<%
			if (Constantes.S.equals(respostaVO.getCorreta())) {
		%><input type="text" name="<%=Constantes.PROP_RESPOSTA_CORRETA%>" size="10" value="<liferay-ui:message key="label.sim" />" disabled="disabled" />
		 <%
 	} else {
 %> <input type="text" name="<%=Constantes.PROP_RESPOSTA_CORRETA%>" size="10" value="<liferay-ui:message key="label.nao" />" disabled="disabled" /> <%
 	}
%>		
		</aui:field-wrapper>
	</aui:fieldset>
<input type="hidden" name="operacaoResposta" id="operacaoResposta"
	value="<%=operacaoResposta%>" /> <input type="hidden"
	name="idResposta" id="idResposta" value="<%=respostaVO.getId()%>" /> <input
	type="hidden" name="idTeste" id="idTeste" value="<%=idTeste%>" />
<input type="hidden" name="idPergunta" id="idPergunta"
	value="<%=idPergunta%>" /> <c:if
	test="<%= Constantes.VALOR_PARAM_EXCLUIR_RESPOSTA.equals(operacaoResposta) %>">
	<input type="submit"
		value="<liferay-ui:message key="botao.confirmar" />" />&nbsp;
</c:if> <input type="button"
	value="<liferay-ui:message key="botao.cancelar" />"
	onClick="self.location = '<%=cancelarURL%>';" />
</aui:form>	
