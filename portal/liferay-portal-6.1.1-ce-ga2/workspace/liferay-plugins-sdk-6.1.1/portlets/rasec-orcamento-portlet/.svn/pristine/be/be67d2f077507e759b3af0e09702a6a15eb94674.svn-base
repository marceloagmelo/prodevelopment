<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="configurado" scope="request" />
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	OrcamentoVO orcamento = (OrcamentoVO) request
			.getAttribute("orcamentoVO");
%>

<liferay-ui:success key="mensagem.orcamento.naoConfigurado"
	message="mensagem.orcamento.naoConfigurado" />
<liferay-ui:success key="mensagem.orcamento.enviado"
	message="mensagem.orcamento.enviado" />
<liferay-ui:error key="mensagem.orcamento.nomeUsuario.obrigatorio"
	message="mensagem.orcamento.nomeUsuario.obrigatorio" />
<liferay-ui:error key="mensagem.orcamento.email.obrigatorio"
	message="mensagem.orcamento.email.obrigatorio" />
<liferay-ui:error key="mensagem.orcamento.email.invalido"
	message="mensagem.orcamento.email.invalido" />
<liferay-ui:error key="mensagem.orcamento.endereco.obrigatorio"
	message="mensagem.orcamento.endereco.obrigatorio" />
<liferay-ui:error key="mensagem.orcamento.cidade.obrigatoria"
	message="mensagem.orcamento.cidade.obrigatoria" />
<liferay-ui:error key="mensagem.orcamento.estado.obrigatorio"
	message="mensagem.orcamento.estado.obrigatorio" />
<liferay-ui:error key="mensagem.orcamento.ddd.obrigatorio"
	message="mensagem.orcamento.ddd.obrigatorio" />
<liferay-ui:error key="mensagem.orcamento.telefone.obrigatorio"
	message="mensagem.orcamento.telefone.obrigatorio" />
<liferay-ui:error key="mensagem.orcamento.tipoReposta.obrigatoria"
	message="mensagem.orcamento.tipoReposta.obrigatoria" />
<liferay-ui:error key="mensagem.orcamento.solicitacao.obrigatoria"
	message="mensagem.orcamento.solicitacao.obrigatoria" />

<form name="formOrcamento"
	action="<portlet:actionURL name="enviar" />" method="POST">
	<div class="orcamento_desc_titulo">
		<liferay-ui:message key="label.orcamento.tituloPortlet" />
	</div>

	<table cellspacing="0" class="orcamento">
		<tr>
			<td class="secao" colspan="2"><span><liferay-ui:message
						key="label.orcamento.titulo.contato" /> </span></td>
		</tr>
		<tr>
			<td class="label"><liferay-ui:message
					key="label.orcamento.nomeEmpresa" />:</td>
			<td><input type="text" class="texto" name="nomeEmpresa"
				value="${orcamentoVO.nomeEmpresa }" /></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span> <liferay-ui:message
					key="label.orcamento.nome" />:</td>
			<td><input type="text" class="texto" name="nomeUsuario"
				value="${orcamentoVO.nomeUsuario }" /></td>
		</tr>
		<tr>
			<td class="label"><liferay-ui:message
					key="label.orcamento.email" />:</td>
			<td><input type="text" class="texto" name="emailUsuario"
				value="${orcamentoVO.emailUsuario }" /></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span><liferay-ui:message
				key="label.orcamento.endereco" />:</td>
			<td><input type="text" class="texto" name="endereco"
				value="${orcamentoVO.endereco }" /></td>
		</tr>
		<tr>
			<td class="label"><liferay-ui:message
				key="label.orcamento.cep" />:</td>
			<td><input type="text" class="texto" name="cep"
				value="${orcamentoVO.cep }" maxlength="8" onkeypress="return SomenteNumero(event)"/></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span><liferay-ui:message
				key="label.orcamento.cidade" />:</td>
			<td><input type="text" class="texto" name="cidade"
				value="${orcamentoVO.cidade }" /></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span><liferay-ui:message
				key="label.orcamento.estado" />:</td>
			<td><select class="combo" name="estado" id="estado">
					<option value=""><liferay-ui:message
							key="label.selecione" /></option>
				<%
					List<String> listaEstados = (List) request
										.getAttribute("listaEstados");
								if (listaEstados == null) {
									listaEstados = new ArrayList<String>();
								}
								for (String uf : listaEstados) {
					if (uf.equalsIgnoreCase(orcamento.getEstado())) {
					%>
						<option value="<%=uf%>" selected="selected"><%=uf%></option>
					<%}
					else {
					%>
						<option value="<%=uf%>"><%=uf%></option>
						<%
					}
					}
				%>
			</select></td>
		</tr>
		<tr>
			<td class="label"><liferay-ui:message
				key="label.orcamento.telefone" />:</td>
			<td><input type="text" class="texto tel1" name="ddd"
				value="${orcamentoVO.ddd }" maxlength="2" onkeypress="return SomenteNumero(event)"/><input type="text"
				class="texto tel2" name="telefone"
				value="${orcamentoVO.telefone }" maxlength="9"/></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span><liferay-ui:message
				key="label.orcamento.tipoResposta" />:</td>
			<td><select class="combo" name="tipoResposta" id="tipoResposta">
					<option value=""><liferay-ui:message
							key="label.selecione" /></option>
				<%
					List<String> listaTipoResposta = (List) request
										.getAttribute("listaTipoResposta");
								if (listaTipoResposta == null) {
									listaTipoResposta = new ArrayList<String>();
								}
								for (String tipoResposta : listaTipoResposta) {
					if (tipoResposta.equalsIgnoreCase(orcamento.getTipoResposta())) {
					%>
						<option value="<%=tipoResposta%>" selected="selected"><%=tipoResposta%></option>
					<%}
					else {
					%>
						<option value="<%=tipoResposta%>"><%=tipoResposta%></option>
						<%
					}
					}
				%>
			</select></td>
		</tr>
		<tr>
			<td class="secao" colspan="2"><span><liferay-ui:message
						key="label.orcamento.titulo.dados.solicitacao" /> </span></td>
		</tr>
		<tr>
			<td colspan="2"><span class="required">*</span><textarea class="solicitacao" name="solicitacao">${orcamentoVO.solicitacao }</textarea>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td class="required"><span class="required">(*)</span> <liferay-ui:message
					key="label.orcamento.preenchimento.obrigatorio" />
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" class="botao"
				value="<liferay-ui:message key="botao.enviar" />" /></td>
		</tr>
	</table>
	<input type="hidden" name="resourceBundle" value="${resourceBundle }"/>
</form>