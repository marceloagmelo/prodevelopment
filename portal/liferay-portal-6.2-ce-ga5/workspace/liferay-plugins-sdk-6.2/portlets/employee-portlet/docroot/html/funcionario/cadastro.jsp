<%@ include file="init.jsp"%>

<%
Funcionario funcionario = (Funcionario)request.getAttribute(Constantes.FUNCIONARIO);
long funcionarioId = BeanParamUtil.getLong(funcionario, request, Constantes.FUNCIONARIO_ID);

String[] formInformacoes = {"dadosPessoais", "outrosDados"};
String[] formContantos = {"enderecos", "telefones", "enderecosEmail"};

String[][] categorySections = {formInformacoes, formContantos};

String labelTitulo = "label.adicionar.funcionario";
if (Validator.isNotNull(funcionario)) {
	if (Constantes.VIEW.equals(acao)) {
		labelTitulo = HtmlUtil.escape(funcionario.getNome());
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.funcionario.x", HtmlUtil.escape(funcionario.getNome()));
	}
}
%>
<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%=false%>"
		showCurrentPortlet="<%=false%>" showGuestGroup="<%=false%>"
		showLayout="<%=false%>" showPortletBreadcrumb="<%=true%>" />
</div>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (funcionario == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR %>" />
</portlet:actionURL>

<%@ include file="mensagens.jspf"%>
	
<aui:form action="<%= salvarURL %>" method="post" name="fm">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (funcionarioId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="funcionarioId" type="hidden" value="<%= funcionarioId %>" />
<%
request.setAttribute(Constantes.FUNCIONARIO_ID, funcionarioId);
%>
	<liferay-util:buffer var="htmlTop">
		<c:if test="<%= funcionario != null %>">
			<div class="user-info">
				<div class="float-container">
					<img alt="<%= HtmlUtil.escape(funcionario.getNomeReduzido()) %>" class="user-logo" src="<%= funcionario.getFotoURL(themeDisplay) %>" />

					<span class="user-name"><%= HtmlUtil.escape(funcionario.getNomeReduzido()) %></span>
				</div>
			</div>
		</c:if>
	</liferay-util:buffer>

	<liferay-ui:form-navigator
		backURL="<%= backURL %>"
		categoryNames="<%= _CATEGORY_NAMES %>"
		categorySections="<%= categorySections %>"
		htmlTop="<%= htmlTop %>"
		jspPath="/html/funcionario/"
		showButtons="<%= !Constantes.VIEW.equals(acao)%>"
	/>
</aui:form>

<%!
private static final String[] _CATEGORY_NAMES = {"informacoes", "contatos"};
%>