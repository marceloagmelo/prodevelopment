<%@ include file="init.jsp"%>

<%
Cliente cliente = (Cliente)request.getAttribute(Constantes.CLIENTE);
long clienteId = BeanParamUtil.getLong(cliente, request, Constantes.CLIENTE_ID);

String[] formInformacoes = {"dadosBasicos", "creditos"};
String[] formContantos = {"enderecos", "telefones", "enderecosEmail"};

String[][] categorySections = {formInformacoes, formContantos};

String labelTitulo = "label.adicionar.cliente";
if (Validator.isNotNull(cliente)) {
	if (Constantes.VIEW.equals(acao)) {
		labelTitulo = HtmlUtil.escape(cliente.getNome());
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.cliente.x", HtmlUtil.escape(cliente.getNome()));
	}
}
%>
<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
		showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
		showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
</div>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (cliente == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR %>" />
</portlet:actionURL>

<%@ include file="mensagens.jspf"%>
	
<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (clienteId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="clienteId" type="hidden" value="<%= clienteId %>" />
<%
request.setAttribute(Constantes.CLIENTE_ID, clienteId);
%>
	<liferay-util:buffer var="htmlTop">
		<c:if test="<%= cliente != null %>">
			<div class="user-info">
				<div class="float-container">
					<img alt="<%= HtmlUtil.escape(cliente.getNome()) %>" class="user-logo" src="<%= cliente.getLogoTipoURL(themeDisplay) %>" />

					<span class="user-name"><%= HtmlUtil.escape(cliente.getNome()) %></span>
				</div>
			</div>
		</c:if>
	</liferay-util:buffer>

	<liferay-ui:form-navigator
		backURL="<%= backURL %>"
		categoryNames="<%= _CATEGORY_NAMES %>"
		categorySections="<%= categorySections %>"
		htmlTop="<%= htmlTop %>"
		jspPath="/html/cliente/"
		showButtons="<%= !Constantes.VIEW.equals(acao)%>"
	/>
</aui:form>

<%!
private static final String[] _CATEGORY_NAMES = {"informacoes", "contatos"};
%>