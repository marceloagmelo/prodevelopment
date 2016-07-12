<%@ include file="init.jsp"%>

<%
Cargo cargo = (Cargo)request.getAttribute(Constantes.CARGO);
long cargoId = BeanParamUtil.getLong(cargo, request, Constantes.CARGO_ID);

String labelTitulo = "label.adicionar.cargo";
if (Validator.isNotNull(cargo)) {
	if (Constantes.VIEW.equals(acao)) {
		labelTitulo = HtmlUtil.escape(cargo.getNome(locale));
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.cargo.x", HtmlUtil.escape(cargo.getNome(locale)));
	}
}
%>
<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (cargo == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR_CARGO %>" />
</portlet:actionURL>

<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (cargoId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="cargoId" type="hidden" value="<%= cargoId %>" />
	<aui:input name="<%=Constantes.REDIRECT %>" type="hidden" value="<%= redirect %>" />
	
<%
request.setAttribute(Constantes.CARGO_ID, cargoId);
%>

<aui:model-context bean="<%= cargo %>" model="<%= Cargo.class %>" />

<aui:input name="versao" type="hidden"/>

<liferay-ui:error exception="<%= CargoAlteradoOutroUsuarioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.reg.alterado.outroUsuario" />
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= CargoNomeObrigatorioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.nome.obrigatorio" />
		<aui:input name="<%=Constantes.CAMPO_NOME %>" label="label.nome">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>
	<c:if test="<%=(!Constantes.VIEW.equals(acao)) %>">
		<aui:button-row>
			<aui:button type="submit" />
	
			<portlet:renderURL var="cancelarURL">
				<portlet:param name="<%=Constantes.REDIRECT %>" value="<%=Constantes.REDIRECT_VIEW_CARGO %>" />
			</portlet:renderURL>
	
			<aui:button href="<%= cancelarURL %>" value="botao.cancelar"/>
		</aui:button-row>
	</c:if>
</div>
</aui:form>

<aui:script use="aui-base">
	var verSeDesabilitaCamposCargo = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_NOME %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposCargo(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>
