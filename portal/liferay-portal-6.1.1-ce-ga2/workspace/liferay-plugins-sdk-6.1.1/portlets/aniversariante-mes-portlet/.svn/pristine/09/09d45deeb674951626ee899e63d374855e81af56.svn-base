<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="enviarMensagemURL" scope="request" />
<jsp:useBean class="java.lang.String" id="cancelarURL" scope="request" />
<%
	UsuarioVO usuarioVO = (UsuarioVO) request
			.getAttribute(Constantes.NOME_PARAM_USUARIO_VO);
%>
<liferay-ui:error key="mensagem.aniversariante.mensagem.obrigatoria"
	message="mensagem.aniversariante.mensagem.obrigatoria" />
<liferay-ui:success key="mensagem.aniversario.mensagem.enviada.sucesso"
	message="mensagem.aniversario.mensagem.enviada.sucesso" />

<div class="desc_titulo"><liferay-ui:message
	key="label.aniversariante.mensagem" />&nbsp; <%=usuarioVO.getNome()%></div>

<form name="formUsuarioEnviarMensagem" action="<%=enviarMensagemURL%>"
	method="POST">
<table border="0" cellpadding="0" cellspacing="0" class="form_portlet">
	<tr>
		<td><textarea rows="5" cols="80" name="mensagem"></textarea></td>
	</tr>
</table>
<input type="hidden" name="resourceBundle" value="${resourceBundle }"/>
<input type="hidden" name="id" id="id" value="<%=usuarioVO.getId()%>" />
<div class="separator"></div>
<input type="submit" value="<liferay-ui:message key="botao.enviar" />" />&nbsp;
<input type="button" value="<liferay-ui:message key="botao.cancelar" />"
	onClick="self.location = '<%=cancelarURL%>';" /></form>