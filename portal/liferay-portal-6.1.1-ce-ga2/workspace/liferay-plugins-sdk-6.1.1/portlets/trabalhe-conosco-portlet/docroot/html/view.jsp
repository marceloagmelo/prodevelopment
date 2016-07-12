<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="comentario" scope="request" />
<jsp:useBean class="java.lang.String" id="cargo" scope="request" />
<jsp:useBean class="java.lang.String" id="configurado" scope="request" />
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	TrabalheConoscoVO trabalheConosco = (TrabalheConoscoVO) request
			.getAttribute("trabalheConoscoVO");
%>

<liferay-ui:success key="mensagem.trabalheConosco.naoConfigurado"
	message="mensagem.trabalheConosco.naoConfigurado" />
<liferay-ui:success key="mensagem.trabalheConosco.enviado"
	message="mensagem.trabalheConosco.enviado" />
<liferay-ui:error key="mensagem.trabalheConosco.nomeUsuario.obrigatorio"
	message="mensagem.trabalheConosco.nomeUsuario.obrigatorio" />
<liferay-ui:error key="mensagem.trabalheConosco.email.obrigatorio"
	message="mensagem.trabalheConosco.email.obrigatorio" />
<liferay-ui:error key="mensagem.trabalheConosco.email.invalido"
	message="mensagem.trabalheConosco.email.invalido" />
<liferay-ui:error key="mensagem.trabalheConosco.endereco.obrigatorio"
	message="mensagem.trabalheConosco.endereco.obrigatorio" />
<liferay-ui:error key="mensagem.trabalheConosco.cidade.obrigatoria"
	message="mensagem.trabalheConosco.cidade.obrigatoria" />
<liferay-ui:error key="mensagem.trabalheConosco.estado.obrigatorio"
	message="mensagem.trabalheConosco.estado.obrigatorio" />
<liferay-ui:error key="mensagem.trabalheConosco.ddd.obrigatorio"
	message="mensagem.trabalheConosco.ddd.obrigatorio" />
<liferay-ui:error key="mensagem.trabalheConosco.telefone.obrigatorio"
	message="mensagem.trabalheConosco.telefone.obrigatorio" />
<liferay-ui:error key="mensagem.trabalheConosco.cargo.obrigatorio"
	message="mensagem.trabalheConosco.cargo.obrigatorio" />
<liferay-ui:error key="mensagem.trabalheConosco.objetivo.obrigatorio"
	message="mensagem.trabalheConosco.objetivo.obrigatorio" />

<form name="formTrabalheConosco"
	action="<portlet:actionURL name="enviar" />" method="POST">
	<div class="trabalhe_conosco_desc_titulo">
		<liferay-ui:message key="label.trabalheConosco.tituloPortlet" />
	</div>

	<table cellspacing="0" class="trabalhe_conosco">
		<tr>
			<td class="secao" colspan="2"><span><liferay-ui:message
						key="label.trabalheConosco.titulo.contato" /> </span></td>
		</tr>
		<c:choose>
			<c:when test="<%= !themeDisplay.isSignedIn() %>">
				<tr>
					<td class="label"><span class="required">*</span> <liferay-ui:message
							key="label.trabalheConosco.nome" />:</td>
					<td><input type="text" class="texto" name="nomeUsuario"
						value="${trabalheConoscoVO.nomeUsuario }" /></td>
				</tr>
				<tr>
					<td class="label"><span class="required">*</span> <liferay-ui:message
							key="label.trabalheConosco.email" />:</td>
					<td><input type="text" class="texto" name="emailUsuario"
						value="${trabalheConoscoVO.emailUsuario }" /></td>
				</tr>
			</c:when>
		</c:choose>
		<tr>
			<td class="label"><span class="required">*</span><liferay-ui:message
				key="label.trabalheConosco.endereco" />:</td>
			<td><input type="text" class="texto" name="endereco"
				value="${trabalheConoscoVO.endereco }" /></td>
		</tr>
		<tr>
			<td class="label"><liferay-ui:message
				key="label.trabalheConosco.cep" />:</td>
			<td><input type="text" class="texto" name="cep"
				value="${trabalheConoscoVO.cep }" maxlength="8" onkeypress="return SomenteNumero(event)"/></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span><liferay-ui:message
				key="label.trabalheConosco.cidade" />:</td>
			<td><input type="text" class="texto" name="cidade"
				value="${trabalheConoscoVO.cidade }" /></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span><liferay-ui:message
				key="label.trabalheConosco.estado" />:</td>
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
					if (uf.equalsIgnoreCase(trabalheConosco.getEstado())) {
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
			<td class="label"><span class="required">*</span><liferay-ui:message
				key="label.trabalheConosco.telefone" />:</td>
			<td><input type="text" class="texto tel1" name="ddd"
				value="${trabalheConoscoVO.ddd }" maxlength="2" onkeypress="return SomenteNumero(event)"/><input type="text"
				class="texto tel2" name="telefone"
				value="${trabalheConoscoVO.telefone }" maxlength="9"/></td>
		</tr>
		<tr>
			<td class="secao" colspan="2"><span><liferay-ui:message
						key="label.trabalheConosco.titulo.dados.profissionais" /> </span></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span> <liferay-ui:message
					key="label.trabalheConosco.cargo" />:</td>
			<td><select class="combo" name="cargo" id="cargo">
					<option value="">
						<liferay-ui:message key="label.selecione" />
					</option>
					<%
						List<CargoVO> listaCargos = (List) request
								.getAttribute("listaCargos");
						if (listaCargos == null) {
							listaCargos = new ArrayList<CargoVO>();
						}
						for (CargoVO cargoVO : listaCargos) {
							if (trabalheConosco.getCargo()
									.equalsIgnoreCase(cargoVO.getId())) {
					%>
					<option value="<%=cargoVO.getId()%>" selected="selected"><%=cargoVO.getDescricao()%></option>
					<%
						} else {
					%>
					<option value="<%=cargoVO.getId()%>"><%=cargoVO.getDescricao()%></option>
					<%
						}
						}
					%>
			</select></td>
		</tr>
		<tr>
			<td class="label"><span class="required">*</span> <liferay-ui:message
					key="label.trabalheConosco.objetivo" />:</td>
			<td><textarea class="resumo" name="resumo">${trabalheConoscoVO.resumo }</textarea>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td class="required"><span class="required">(*)</span> <liferay-ui:message
					key="label.trabalheConosco.preenchimento.obrigatorio" />
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