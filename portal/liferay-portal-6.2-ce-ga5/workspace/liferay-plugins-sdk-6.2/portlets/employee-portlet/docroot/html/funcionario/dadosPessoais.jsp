<%@ include file="init.jsp"%>

<%
Funcionario funcionario = (Funcionario)request.getAttribute(Constantes.FUNCIONARIO);
long funcionarioId = BeanParamUtil.getLong(funcionario, request, Constantes.FUNCIONARIO_ID);

// Data de nascimento
String sDataNascimento = ParamUtil.getString(request, Constantes.CAMPO_DATA_NASCIMENTO);
if ( (Validator.isNull(sDataNascimento)) && (funcionario != null) ) {
	if (Validator.isNotNull(funcionario.getDataNascimento())) {
		sDataNascimento = DateUtil.dateToString(funcionario.getDataNascimento());
	}
}

//Data emissão RG
String sDataRgDtEmissao = ParamUtil.getString(request, Constantes.CAMPO_RG_DATA_EMISSAO);
if ( (Validator.isNull(sDataRgDtEmissao)) && (funcionario != null) ) {
	if (Validator.isNotNull(funcionario.getRgDataEmissao())) {
		sDataRgDtEmissao = DateUtil.dateToString(funcionario.getRgDataEmissao());
	}
}

String sexo = StringPool.BLANK;
String estadoCivil = StringPool.BLANK;
if (Validator.isNotNull(funcionario)) {
	sexo = funcionario.getSexo();
	estadoCivil = funcionario.getEstadoCivil();
}

%>
<liferay-ui:error-marker key="errorSection" value="dadosPessoais" />

<aui:model-context bean="<%= funcionario %>" model="<%= Funcionario.class %>" />

<aui:input name="versao" type="hidden"/>

<h3><liferay-ui:message key="dadosPessoais" /></h3>
<liferay-ui:error exception="<%= FuncionarioAlteradoOutroUsuarioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.reg.alterado.outroUsuario" />
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= FuncionarioNomeObrigatorioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.nome.obrigatorio" />
		<aui:input name="<%=Constantes.CAMPO_NOME %>" label="label.nome">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="<%=Constantes.CAMPO_NOME_REDUZIDO %>" label="label.nomeReduzido"/>

		<liferay-ui:error exception="<%= FuncionarioDataNascimentoInvalidaException.class %>" focusField="dataNascimento" message="mensagem.dataNascimento.invalida" />
		<aui:field-wrapper label="label.dataNascimento">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace />dataNascimento" id="<portlet:namespace />dataNascimento" value="<%=sDataNascimento%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace />dtNascimento" value="<%=sDataNascimento%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
		
		<liferay-ui:error exception="<%= FuncionarioCPFInvalidoException.class %>" focusField="<%=Constantes.CAMPO_CPF %>" message="mensagem.cpf.invalido" />
		<liferay-ui:error exception="<%= FuncionarioCPFDuplicadoException.class %>" focusField="<%=Constantes.CAMPO_CPF %>" message="mensagem.cpf.duplicado" />
		<aui:input name="<%=Constantes.CAMPO_CPF %>" label="label.cpf" max="">
			<aui:validator name="minLength">11</aui:validator>
			<aui:validator name="maxLength">11</aui:validator>
			<aui:validator name="number"></aui:validator>
		</aui:input>
		<liferay-ui:error exception="<%= FuncionarioRGDuplicadoException.class %>" focusField="<%=Constantes.CAMPO_RG %>" message="mensagem.rg.duplicado" />
		<aui:input name="<%=Constantes.CAMPO_RG %>" label="label.rg" />
		<aui:input name="<%=Constantes.CAMPO_RG_ORGAO_EMISSOR %>" label="label.orgaoEmissor" />

		<liferay-ui:error exception="<%= FuncionarioRGDataEmissaoInvalidaException.class %>" focusField="rgDataEmissao" message="mensagem.rdDataEmissao.invalida" />
		<aui:field-wrapper label="label.dataEmissao">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace />rgDataEmissao" id="<portlet:namespace />rgDataEmissao" value="<%=sDataRgDtEmissao%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace />rgDtEmissao" value="<%=sDataRgDtEmissao%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
	</aui:fieldset>
	<aui:fieldset cssClass="span5">
		<div>
			<c:if test="<%= ((funcionario != null) && (!Constantes.VIEW.equals(acao)) )%>">
				<portlet:renderURL var="editFotoURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="jspPage" value="/html/funcionario/editarFoto.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="funcionarioId" value="<%= String.valueOf(funcionario.getFuncionarioId()) %>" />
					<portlet:param name="fotoId" value="<%= String.valueOf(funcionario.getFotoId()) %>" />
				</portlet:renderURL>

				<liferay-ui:logo-selector
					defaultLogoURL="<%= FuncionarioUtil.getFotoURL(themeDisplay.getPathImage(), funcionario.getSexo(), 0) %>"
					editLogoURL="<%= editFotoURL %>"
					imageId="<%= funcionario.getFotoId() %>"
					logoDisplaySelector=".user-logo"
				/>
			</c:if>
		</div>
	
		<aui:select label="label.sexo" name="<%=Constantes.CAMPO_SEXO %>">
			<aui:option label=""
				selected='<%=Validator.isNull(sexo)%>' value="" />
			<aui:option label="label.sexo.feminino" selected='<%=Constantes.FEMININO.equals(sexo)%>'
				value="<%=Constantes.FEMININO %>" />
			<aui:option label="label.sexo.masculino" selected='<%=Constantes.MASCULINO.equals(sexo)%>'
				value="<%=Constantes.MASCULINO %>" />
		</aui:select>
		<aui:select label="label.estadoCivil" name="<%=Constantes.CAMPO_ESTADO_CIVIL %>">
			<aui:option label=""
				selected='<%=Validator.isNull(estadoCivil)%>' value="" />
			<aui:option label="label.casado" selected='<%=Constantes.CASADO.equals(sexo)%>'
				value="<%=Constantes.CASADO %>" />
			<aui:option label="label.divorciado" selected='<%=Constantes.DIVORCIADO.equals(sexo)%>'
				value="<%=Constantes.DIVORCIADO %>" />
			<aui:option label="label.separado" selected='<%=Constantes.SEPARADO.equals(sexo)%>'
				value="<%=Constantes.SEPARADO %>" />
			<aui:option label="label.solteiro" selected='<%=Constantes.SOLTEIRO.equals(sexo)%>'
				value="<%=Constantes.SOLTEIRO %>" />
			<aui:option label="label.viuvo" selected='<%=Constantes.VIUVO.equals(sexo)%>'
				value="<%=Constantes.VIUVO %>" />
		</aui:select>
		<aui:input type="textarea" name="<%=Constantes.CAMPO_OBSERVACAO %>" label="label.observacao" />
	</aui:fieldset>
</div>
<aui:script use="aui-base">
	var verSeDesabilitaCamposDadosPessoais = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_NOME %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_NOME_REDUZIDO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_CPF %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_RG %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_RG_ORGAO_EMISSOR %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_SEXO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_ESTADO_CIVIL %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_OBSERVACAO %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposDadosPessoais(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>
<script>
jQuery(document).ready(
		function() {
			jQuery("#<portlet:namespace />rgDataEmissao")
				.datepicker({
					showOn: 'button', 
					buttonImage: '/employee-portlet/images/calendario.png', 
					buttonImageOnly: true,
					dateFormat: 'dd/mm/yy',  
					dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sabado','Domingo'],  
					dayNamesMin: ['D','S','T','Q','Q','S','S','D'],  
					dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab','Dom'],  
					monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
					monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],  
					nextText: 'Próximo',
					prevText: 'Anterior',
					startDate: '01/01/1901'
				})
				.mask("99/99/9999");

			jQuery("#<portlet:namespace />dataNascimento")
			.datepicker({
				showOn: 'button', 
				buttonImage: '/employee-portlet/images/calendario.png', 
				buttonImageOnly: true,
				dateFormat: 'dd/mm/yy',  
				dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sabado','Domingo'],  
				dayNamesMin: ['D','S','T','Q','Q','S','S','D'],  
				dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab','Dom'],  
				monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
				monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],  
				nextText: 'Próximo',
				prevText: 'Anterior',
				startDate: '01/01/1901'
			})
			.mask("99/99/9999");
});
</script>