<%@ include file="init.jsp"%>

<%
Cliente cliente = (Cliente)request.getAttribute(Constantes.CLIENTE);
long clienteId = BeanParamUtil.getLong(cliente, request, Constantes.CLIENTE_ID);

// Data de nascimento
String sDataNascimento = ParamUtil.getString(request, Constantes.CAMPO_DATA_NASCIMENTO);
if ( (Validator.isNull(sDataNascimento)) && (cliente != null) ) {
	if (Validator.isNotNull(cliente.getDataNascimento())) {
		sDataNascimento = DateUtil.dateToString(cliente.getDataNascimento());
	}
}

//Data emissão RG
String sDataRgDtEmissao = ParamUtil.getString(request, Constantes.CAMPO_RG_DATA_EMISSAO);
if ( (Validator.isNull(sDataRgDtEmissao)) && (cliente != null) ) {
	if (Validator.isNotNull(cliente.getRgDataEmissao())) {
		sDataRgDtEmissao = DateUtil.dateToString(cliente.getRgDataEmissao());
	}
}

String sCpfCnpj = ParamUtil.getString(request, Constantes.CAMPO_CPF_CNPJ);
if ( (Validator.isNull(sCpfCnpj)) && (cliente != null) ) {
	if (Validator.isNotNull(cliente.getCpfCnpj())) {
		sCpfCnpj = cliente.getCpfCnpj();
	}
}
String sRgInscricaoMun = ParamUtil.getString(request, Constantes.CAMPO_RG_INSCRICAO_MUN);
if ( (Validator.isNull(sRgInscricaoMun)) && (cliente != null) ) {
	if (Validator.isNotNull(cliente.getRgInscricaoMun())) {
		sRgInscricaoMun = cliente.getRgInscricaoMun();
	}
}

String tipoPessoa = StringPool.BLANK;
String sexo = StringPool.BLANK;
String estadoCivil = StringPool.BLANK;
if (Validator.isNotNull(cliente)) {
	sexo = cliente.getSexo();
	estadoCivil = cliente.getEstadoCivil();
	tipoPessoa = cliente.getTipoPessoa();
}
%>
<liferay-ui:error-marker key="errorSection" value="dadosBasicos" />

<aui:model-context bean="<%= cliente %>" model="<%= Cliente.class %>" />

<aui:input name="versao" type="hidden"/>

<h3><liferay-ui:message key="dadosBasicos" /></h3>
<liferay-ui:error exception="<%= ClienteAlteradoOutroUsuarioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.reg.alterado.outroUsuario" />
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<aui:select label="label.tipoPessoa" name="<%=Constantes.CAMPO_TIPO_PESSOA %>">
			<aui:option label=""
				selected='<%=Validator.isNull(tipoPessoa)%>' value="" />
			<aui:option label="label.tipoPessoa.fisica" selected='<%=Constantes.PESSOA_FISICA.equals(tipoPessoa)%>'
				value="<%=Constantes.PESSOA_FISICA %>" />
			<aui:option label="label.tipoPessoa.juridica" selected='<%=Constantes.PESSOA_JURIDICA.equals(tipoPessoa)%>'
				value="<%=Constantes.PESSOA_JURIDICA %>" />
		</aui:select>
		<liferay-ui:error exception="<%= ClienteNomeObrigatorioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.nome.obrigatorio" />
		<aui:input name="<%=Constantes.CAMPO_NOME %>" label="label.nome">
			<aui:validator name="required" />
		</aui:input>

		<div id="<portlet:namespace />campodataNascimento">
		<liferay-ui:error exception="<%= ClienteDataNascimentoInvalidaException.class %>" focusField="dataNascimento" message="mensagem.dataNascimento.invalida" />
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
		</div>
		
		<div id="<portlet:namespace />campo<%=Constantes.CAMPO_CPF %>">
		<liferay-ui:error exception="<%= ClienteCPFInvalidoException.class %>" focusField="<%=Constantes.CAMPO_CPF %>" message="mensagem.cpf.invalido" />
		<liferay-ui:error exception="<%= ClienteCPFDuplicadoException.class %>" focusField="<%=Constantes.CAMPO_CPF %>" message="mensagem.cpf.duplicado" />
		<aui:field-wrapper label="label.cpf">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace /><%=Constantes.CAMPO_CPF %>" id="<portlet:namespace /><%=Constantes.CAMPO_CPF %>" value="<%=sCpfCnpj%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace /><%=Constantes.CAMPO_CPF %>" value="<%=sCpfCnpj%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
		</div>
		
		<div id="<portlet:namespace />campo<%=Constantes.CAMPO_CNPJ %>">
		<liferay-ui:error exception="<%= ClienteCNPJInvalidoException.class %>" focusField="<%=Constantes.CAMPO_CNPJ %>" message="mensagem.cnpj.invalido" />
		<liferay-ui:error exception="<%= ClienteCNPJDuplicadoException.class %>" focusField="<%=Constantes.CAMPO_CNPJ %>" message="mensagem.cnpj.duplicado" />
		<aui:field-wrapper label="label.cnpj">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace /><%=Constantes.CAMPO_CNPJ %>" id="<portlet:namespace /><%=Constantes.CAMPO_CNPJ %>" value="<%=sCpfCnpj%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace /><%=Constantes.CAMPO_CNPJ %>" value="<%=sCpfCnpj%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
		</div>

		<div id="<portlet:namespace />campo<%=Constantes.CAMPO_RG %>">
		<liferay-ui:error exception="<%= ClienteRGInscricaoMunDuplicadoException.class %>" focusField="<%=Constantes.CAMPO_RG_INSCRICAO_MUN %>" message="mensagem.rg.duplicado" />
		<aui:field-wrapper label="label.rg">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace /><%=Constantes.CAMPO_RG %>" id="<portlet:namespace /><%=Constantes.CAMPO_RG %>" value="<%=sRgInscricaoMun%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace /><%=Constantes.CAMPO_RG %>" value="<%=sRgInscricaoMun%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
		</div>
		
		<div id="<portlet:namespace />campo<%=Constantes.CAMPO_INSCRICAO_MUN %>">
		<liferay-ui:error exception="<%= ClienteRGInscricaoMunDuplicadoException.class %>" focusField="<%=Constantes.CAMPO_RG_INSCRICAO_MUN %>" message="mensagem.inscricaoMun.duplicado" />
		<aui:field-wrapper label="label.inscricaoMun">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace /><%=Constantes.CAMPO_INSCRICAO_MUN %>" id="<portlet:namespace /><%=Constantes.CAMPO_INSCRICAO_MUN %>" value="<%=sRgInscricaoMun%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace /><%=Constantes.CAMPO_INSCRICAO_MUN %>" value="<%=sRgInscricaoMun%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
		</div>

		<div id="<portlet:namespace />campo<%=Constantes.CAMPO_RG_ORGAO_EMISSOR %>">
		<aui:input name="<%=Constantes.CAMPO_RG_ORGAO_EMISSOR %>" label="label.orgaoEmissor" />
		</div>

		<div id="<portlet:namespace />camporgDataEmissao">
		<liferay-ui:error exception="<%= ClienteRGDataEmissaoInvalidaException.class %>" focusField="rgDataEmissao" message="mensagem.rdDataEmissao.invalida" />
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
		</div>
	</aui:fieldset>
	<aui:fieldset cssClass="span5">
		<div>
			<c:if test="<%= ((cliente != null) && (!Constantes.VIEW.equals(acao)) )%>">
				<portlet:renderURL var="editFotoURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="jspPage" value="/html/cliente/editarFoto.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="clienteId" value="<%= String.valueOf(cliente.getClienteId()) %>" />
					<portlet:param name="logoTipoId" value="<%= String.valueOf(cliente.getLogoTipoId()) %>" />
				</portlet:renderURL>

				<liferay-ui:logo-selector
					defaultLogoURL="<%= ClienteUtil.getLogoTipoURL(themeDisplay.getPathImage(), 0) %>"
					editLogoURL="<%= editFotoURL %>"
					imageId="<%= cliente.getLogoTipoId() %>"
					logoDisplaySelector=".user-logo"
				/>
			</c:if>
		</div>
	
		<div id="<portlet:namespace />campo<%=Constantes.CAMPO_SEXO %>">
		<aui:select label="label.sexo" name="<%=Constantes.CAMPO_SEXO %>">
			<aui:option label=""
				selected='<%=Validator.isNull(sexo)%>' value="" />
			<aui:option label="label.sexo.feminino" selected='<%=Constantes.FEMININO.equals(sexo)%>'
				value="<%=Constantes.FEMININO %>" />
			<aui:option label="label.sexo.masculino" selected='<%=Constantes.MASCULINO.equals(sexo)%>'
				value="<%=Constantes.MASCULINO %>" />
		</aui:select>
		</div>
		
		<div id="<portlet:namespace />campo<%=Constantes.CAMPO_ESTADO_CIVIL %>">
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
		</div>
		
		<aui:input type="textarea" name="<%=Constantes.CAMPO_OBSERVACAO %>" label="label.observacao" />
	</aui:fieldset>
</div>
<aui:script>
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PF', '<portlet:namespace />campodataNascimento');
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PF', '<portlet:namespace />campo<%=Constantes.CAMPO_CPF %>');
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PJ', '<portlet:namespace />campo<%=Constantes.CAMPO_CNPJ %>');
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PF', '<portlet:namespace />campo<%=Constantes.CAMPO_RG %>');
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PJ', '<portlet:namespace />campo<%=Constantes.CAMPO_INSCRICAO_MUN %>');
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PF', '<portlet:namespace />campo<%=Constantes.CAMPO_RG_ORGAO_EMISSOR %>');
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PF', '<portlet:namespace />camporgDataEmissao');
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PF', '<portlet:namespace />campo<%=Constantes.CAMPO_SEXO %>');
	Liferay.Util.toggleSelectBox('<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>', 'PF', '<portlet:namespace />campo<%=Constantes.CAMPO_ESTADO_CIVIL %>');
</aui:script>

<aui:script use="aui-base">
	var verSeDesabilitaCamposDadosPessoais = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_TIPO_PESSOA %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_NOME %>').set('disabled', desabilita);
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
					buttonImage: '/cliente-portlet/images/calendario.png', 
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
				buttonImage: '/cliente-portlet/images/calendario.png', 
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