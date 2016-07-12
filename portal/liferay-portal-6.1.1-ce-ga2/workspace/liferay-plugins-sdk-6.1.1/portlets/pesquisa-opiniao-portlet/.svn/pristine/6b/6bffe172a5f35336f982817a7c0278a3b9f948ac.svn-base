<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="titulo" scope="request" />

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="operacaoResposta"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idPesquisa" scope="request" />
<jsp:useBean class="java.lang.String" id="idPergunta" scope="request" />
<jsp:useBean class="java.lang.String" id="groupId" scope="request" />

<%
	RespostaVO respostaVO = (RespostaVO) request
			.getAttribute(Constantes.NOME_PARAM_RESPOSTA_VO);
%>

<%@ include file="/html/cadastroportlet/resposta/mensagens.jspf"%>

<div class="pesquisa_titulo"><liferay-ui:message key="<%=titulo %>" /></div>

<aui:form name="fm" action="<%=confirmarURL%>"
	method="POST">
	<aui:fieldset>
		<aui:field-wrapper cssClass="lfr-textarea-container"
			label="label.resposta.descricao">
			<liferay-ui:input-localized name="descricao" type="textarea"
				xml="<%=respostaVO.getDescricao()%>" />
		</aui:field-wrapper>
	</aui:fieldset>
<input type="hidden" name="operacaoResposta" id="operacaoResposta"
	value="<%=operacaoResposta%>" /> <input type="hidden"
	name="idResposta" id="idResposta" value="<%=respostaVO.getId()%>" /> <input
	type="hidden" name="idPesquisa" id="idPesquisa" value="<%=idPesquisa%>" />
<input type="hidden" name="idPergunta" id="idPergunta"
	value="<%=idPergunta%>" /> <input type="hidden" name="groupId"
	id="groupId" value="<%=groupId%>" /> <input type="submit"
	value="<liferay-ui:message key="botao.confirmar" />" />&nbsp; <input
	type="button" value="<liferay-ui:message key="botao.cancelar" />"
	onClick="self.location = '<%=cancelarURL%>';" /></aui:form>

