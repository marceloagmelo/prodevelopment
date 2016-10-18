<%@ include file="init.jsp"%>
<%
Cliente cliente = (Cliente)request.getAttribute(Constantes.CLIENTE);
ClienteLimCredito clienteLimCredito = null;
long clienteId = BeanParamUtil.getLong(cliente, request, Constantes.CLIENTE_ID);

//Data limite máximo de crédito
String sDataLimiteMaximoCredito = ParamUtil.getString(request, Constantes.CAMPO_DATA_LIM_MAX_CREDITO);
if ( (Validator.isNull(sDataLimiteMaximoCredito)) && (cliente != null) ) {
	clienteLimCredito = ClienteUtil.getClienteLimCredito(cliente.getClienteId());
	if ( (Validator.isNotNull(clienteLimCredito)) && (Validator.isNotNull(clienteLimCredito.getDataLimiteMaximoCredito())) ) {
		sDataLimiteMaximoCredito = DateUtil.dateToString(clienteLimCredito.getDataLimiteMaximoCredito());
	}
}

%>
<liferay-ui:error-marker key="errorSection" value="creditos" />

<aui:model-context bean="<%= clienteLimCredito %>" model="<%= ClienteLimCredito.class %>" />

<h3><liferay-ui:message key="creditos" /></h3>

<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<aui:input name="<%=Constantes.CAMPO_VALOR_LIM_MAX_CREDITO %>" label="label.valorLimiteMaxCredito" />
		<liferay-ui:error exception="<%= ClienteDataLimiteMaxCreditoInvalidaException.class %>" focusField="sDataLimiteMaximoCredito" message="mensagem.dataEntrada.invalida" />
		<aui:field-wrapper label="label.dataLimiteMaxCredito">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace />dataLimiteMaximoCredito" id="<portlet:namespace />dataLimiteMaximoCredito" value="<%=sDataLimiteMaximoCredito%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace />dtLimiteMaximoCredito" value="<%=sDataLimiteMaximoCredito%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
		
	</aui:fieldset>

	<aui:fieldset cssClass="span6">
		<aui:input name="<%=Constantes.CAMPO_VALOR_LIM_MAX_CHEQUE %>" label="label.valorLimiteMaxCheque" />
		<aui:input name="<%=Constantes.CAMPO_QTDE_LIM_MAX_CHEQUE %>" label="label.qtdeLimiteMaxCheque" />
	</aui:fieldset>
</div>

<aui:script use="aui-base">
	var verSeDesabilitaCamposCreditos = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_VALOR_LIM_MAX_CREDITO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_VALOR_LIM_MAX_CHEQUE %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_QTDE_LIM_MAX_CHEQUE %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposCreditos(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>

<script>
jQuery(document).ready(
		function() {
			jQuery("#<portlet:namespace />dataLimiteMaximoCredito")
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
