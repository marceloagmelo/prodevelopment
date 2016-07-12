<%@ include file="/init.jsp"%>
<jsp:useBean class="java.lang.String" id="comentario" scope="request" />
<jsp:useBean class="java.lang.String" id="assunto" scope="request" />
<jsp:useBean class="java.lang.String" id="configurado" scope="request" />
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	FaleConoscoVO faleConosco = (FaleConoscoVO) request
			.getAttribute("faleConoscoVO");
%>

<liferay-ui:success key="mensagem.faleConosco.naoConfigurado"
	message="mensagem.faleConosco.naoConfigurado" />
<liferay-ui:success key="mensagem.faleConosco.enviado"
	message="mensagem.faleConosco.enviado" />
<liferay-ui:error key="mensagem.faleConosco.tipo.obrigatorio"
	message="mensagem.faleConosco.tipo.obrigatorio" />
<liferay-ui:error key="mensagem.faleConosco.nomeUsuario.obrigatorio"
	message="mensagem.faleConosco.nomeUsuario.obrigatorio" />
<liferay-ui:error key="mensagem.faleConosco.email.obrigatorio"
	message="mensagem.faleConosco.email.obrigatorio" />
<liferay-ui:error key="mensagem.faleConosco.email.invalido"
	message="mensagem.faleConosco.email.invalido" />
<liferay-ui:error key="mensagem.faleConosco.cidade.obrigatorio"
	message="mensagem.faleConosco.cidade.obrigatorio" />
<liferay-ui:error key="mensagem.faleConosco.estado.obrigatorio"
	message="mensagem.faleConosco.estado.obrigatorio" />
<liferay-ui:error key="mensagem.faleConosco.ddd.obrigatorio"
	message="mensagem.faleConosco.ddd.obrigatorio" />
<liferay-ui:error key="mensagem.faleConosco.telefone.obrigatorio"
	message="mensagem.faleConosco.telefone.obrigatorio" />
<liferay-ui:error key="mensagem.faleConosco.assunto.obrigatorio"
	message="mensagem.faleConosco.assunto.obrigatorio" />
<liferay-ui:error key="mensagem.faleConosco.mensagem.obrigatoria"
	message="mensagem.faleConosco.mensagem.obrigatoria" />

<form name="formFaleConosco"
	action="<portlet:actionURL name="enviar" />" method="POST">
	<div class="fale_conosco_desc_titulo">
		<liferay-ui:message key="label.faleConosco.tituloPortlet" />
	</div>

	<table cellspacing="0" class="fale_conosco">
		<c:choose>
			<c:when test="<%= !themeDisplay.isSignedIn() %>">
				<tr>
					<td class="secao" colspan="2"><span><liferay-ui:message
								key="label.faleConosco.titulo.contato" /> </span></td>
				</tr>
				<tr>
					<td class="label"><span class="required">*</span> <liferay-ui:message
							key="label.faleConosco.nome" />:</td>
					<td><input type="text" class="texto" name="nomeUsuario"
						value="${faleConoscoVO.nomeUsuario }" /></td>
				</tr>
				<tr>
					<td class="label"><span class="required">*</span> <liferay-ui:message
							key="label.faleConosco.email" />:</td>
					<td><input type="text" class="texto" name="emailUsuario"
						value="${faleConoscoVO.emailUsuario }" /></td>
				</tr>
			</c:when>
		</c:choose>
		<tr>
			<td class="secao" colspan="2"><span><liferay-ui:message
						key="label.faleConosco.titulo.mensagem" /> </span></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span> <liferay-ui:message
					key="label.faleConosco.assunto" />:</td>
			<td><select class="combo" name="assunto" id="assunto">
					<option value="">
						<liferay-ui:message key="label.selecione" />
					</option>
					<%
						List<AssuntoVO> listaAssuntos = (List) request
								.getAttribute("listaAssuntos");
						if (listaAssuntos == null) {
							listaAssuntos = new ArrayList<AssuntoVO>();
						}
						for (AssuntoVO assuntoVO : listaAssuntos) {
							if (faleConosco.getAssunto()
									.equalsIgnoreCase(assuntoVO.getId())) {
					%>
					<option value="<%=assuntoVO.getId()%>" selected="selected"><%=assuntoVO.getDescricao()%></option>
					<%
						} else {
					%>
					<option value="<%=assuntoVO.getId()%>"><%=assuntoVO.getDescricao()%></option>
					<%
						}
						}
					%>
			</select></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span> <liferay-ui:message
					key="label.faleConosco.mensagem" />:</td>
			<td><textarea class="mensagem" name="mensagem">${faleConoscoVO.mensagem }</textarea>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td class="required"><span class="required">(*)</span> <liferay-ui:message
					key="label.faleConosco.preenchimento.obrigatorio" />
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" class="botao"
				value="<liferay-ui:message key="botao.enviar" />" /></td>
		</tr>
	</table>
</form>