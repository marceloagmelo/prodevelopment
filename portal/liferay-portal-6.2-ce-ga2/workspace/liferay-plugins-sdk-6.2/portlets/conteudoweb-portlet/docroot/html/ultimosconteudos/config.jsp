<%@include file="init.jsp"%>
<%@ include file="mensagem.jspf"%>

<jsp:useBean class="java.lang.String" id="prefEstrutura" scope="request" />
<%
	String exibirTitulo = (String) request
			.getAttribute(Constantes.PREF_EXIBIR_TITULO);
%>
<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />
<aui:form action="<%= configuracaoURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="<%= Constantes.PREF_CONFIGURADO %>" type="hidden" value="<%= Constantes.S %>" />
	<aui:select label="label.pref.exibirTitulo" name="<%=Constantes.PREF_EXIBIR_TITULO%>">
		<aui:option label="label.sim" selected="<%= Constantes.S.equals(exibirTitulo) %>" value="S" />
		<aui:option label="label.nao" selected="<%= Constantes.N.equals(exibirTitulo) %>" value="N" />
	</aui:select>
	<aui:input name="<%=Constantes.PREF_QTDE_REGISTROS%>" value="${prefQtdeRegistros}" label="label.pref.qtdeRegistros" onkeypress="return SomenteNumero(event)"/>
	<aui:input name="<%=Constantes.PREF_URL_DESTINO%>" value="${prefUrlDestino}" label="label.pref.urlDestino"/>
	<aui:input name="<%=Constantes.PREF_URL_VER_TODOS%>" value="${prefUrlVerTodos}" label="label.pref.urlVerTodos"/>
		<%
			if (listaEstrutura != null) {
		%>
		<aui:select label="label.pref.estrutura" name="<%=Constantes.PREF_ESTRUTURA%>">
			<aui:option label="label.selecione"	selected="selected" value="" />
<%
				for (Iterator it = listaEstrutura.keySet().iterator(); it.hasNext();) {
					Long idEstrutura = (Long) it.next();
					String nome = listaEstrutura.get(idEstrutura);
%>
					<aui:option label="<%=nome%>" selected="<%=prefEstrutura.equals(String.valueOf(idEstrutura)) %>" value="<%=String.valueOf(idEstrutura)%>" />
<%
				}
%>							
		</aui:select>
		<%
			}
		%>
		<liferay-ui:message key="label.pref.categoria" /> <liferay-ui:asset-categories-selector
				curCategoryIds="${prefCategoria}" />
		<liferay-ui:message key="label.pref.tag" /> <liferay-ui:asset-tags-selector curTags="${prefTag}" />
		<aui:button-row>
			<aui:button type="submit" value="botao.salvar" />
		</aui:button-row>
</aui:form>	
