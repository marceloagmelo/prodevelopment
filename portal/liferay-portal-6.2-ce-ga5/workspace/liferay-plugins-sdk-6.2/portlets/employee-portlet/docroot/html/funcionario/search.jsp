<%@ include file="init.jsp" %>

<%
FuncionarioSearch searchContainer = (FuncionarioSearch)request.getAttribute("liferay-ui:search:searchContainer");

FuncionarioDisplayTerms displayTerms = (FuncionarioDisplayTerms)searchContainer.getDisplayTerms();
%>

<div class="form-search">
	<liferay-ui:input-search autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" 
		name="<%= displayTerms.NOME %>" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
</div>
