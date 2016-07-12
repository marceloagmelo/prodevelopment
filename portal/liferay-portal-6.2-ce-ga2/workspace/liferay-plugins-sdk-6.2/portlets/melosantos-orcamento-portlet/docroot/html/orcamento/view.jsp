<%@ include file="init.jsp"%>
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	OrcamentoVO orcamento = (OrcamentoVO) request
			.getAttribute("orcamentoVO");
	List<String> listaEstados = (List) request
			.getAttribute("listaEstados");
	if (listaEstados == null) {
		listaEstados = new ArrayList<String>();
	}
	List<String> listaTipoResposta = (List) request
			.getAttribute("listaTipoResposta");
	if (listaTipoResposta == null) {
		listaTipoResposta = new ArrayList<String>();
	}
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

<form name="fm" action="<portlet:actionURL name="enviar" />"
	method="POST">
	<aui:input type="hidden" name="resourceBundle"
		value="${resourceBundle}" />

	<liferay-ui:header title="${portletTitulo}" />
	
	<div class="row-fluid">
		<aui:fieldset cssClass="span4" label="label.orcamento.titulo.pessoais">
			<aui:input name="nomeEmpresa" value="${orcamentoVO.nomeEmpresa}"
				label="label.orcamento.nomeEmpresa" />
			<aui:input name="nomeUsuario" value="${orcamentoVO.nomeUsuario}"
				label="label.orcamento.nome" />
			<aui:input name="emailUsuario" value="${orcamentoVO.emailUsuario}"
				label="label.orcamento.email" />
			<aui:input name="telefone" value="${orcamentoVO.telefone}"
				label="label.orcamento.telefone"
				onkeypress="return SomenteNumero(event)" />
		</aui:fieldset>

		<aui:fieldset cssClass="span4" label="label.orcamento.titulo.endereco">
			<aui:input name="endereco" value="${orcamentoVO.endereco}"
				label="label.orcamento.endereco" />
			<aui:input name="cep" value="${orcamentoVO.cep}"
				label="label.orcamento.cep" maxlength="8"
				onkeypress="return SomenteNumero(event)" />
			<aui:input name="cidade" value="${orcamentoVO.cidade}"
				label="label.orcamento.cidade" />
			<aui:select label="label.orcamento.estado" name="estado">
				<%
					for (String uf : listaEstados) {
				%>
				<aui:option label="<%=uf%>"
					selected='<%=uf.equals(orcamento.getEstado())%>' value="<%=uf%>" />
				<%
					}
				%>
			</aui:select>
		</aui:fieldset>
		<aui:fieldset cssClass="span4" label="label.orcamento.titulo.dados.solicitacao">
			<aui:select label="label.orcamento.tipoResposta" name="tipoResposta">
				<%
					for (String tipoResposta : listaTipoResposta) {
				%>
				<aui:option label="<%=tipoResposta%>"
					selected='<%=tipoResposta.equals(orcamento
									.getTipoResposta())%>'
					value="<%=tipoResposta%>" />
				<%
					}
				%>
			</aui:select>
			<aui:input type="textarea" name="solicitacao"
				value="${orcamentoVO.solicitacao}"
				label="label.orcamento.solicitacao" rows="10" cols="80" />
		</aui:fieldset>
	</div>
	<div class="separator"><!-- --></div>
	<aui:button-row>
		<aui:button type="submit" value="botao.enviar" />
	</aui:button-row>

</form>