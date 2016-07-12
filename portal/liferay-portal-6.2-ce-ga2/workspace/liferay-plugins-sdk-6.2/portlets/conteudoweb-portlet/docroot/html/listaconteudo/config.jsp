<%@include file="init.jsp"%>

<%@ include file="/html/common/mensagem.jspf"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<aui:form method="post" action="${configuracaoURL}" name="fm">
	<aui:fieldset>
		<aui:select name="<%=Constantes.PREF_EXIBIR_TITULO%>" label="label.pref.exibirTitulo">
			<aui:option label="label.sim" selected="<%=Constantes.S.equals(prefExibirTitulo) %>" value="<%=Constantes.S%>"/>
			<aui:option label="label.nao" selected="<%=Constantes.N.equals(prefExibirTitulo) %>" value="<%=Constantes.N%>"/>
		</aui:select>
		<aui:select name="<%=Constantes.PREF_PAGINACAO%>" label="label.pref.paginacao">
			<aui:option label="label.sim" selected="<%=Constantes.S.equals(prefPaginacao) %>" value="<%=Constantes.S%>"/>
			<aui:option label="label.nao" selected="<%=Constantes.N.equals(prefPaginacao) %>" value="<%=Constantes.N%>"/>
		</aui:select>
		<aui:select name="<%=Constantes.PREF_ORDENACAO%>" label="label.pref.ordenacao">
			<aui:option label="label.ordenacao.titulo" selected="<%=Field.TITLE.equals(prefOrdenacao) %>" value="<%=Field.TITLE%>"/>
			<aui:option label="label.ordenacao.dataAlteracao" selected="<%=Field.MODIFIED_DATE.equals(prefOrdenacao) %>" value="<%=Field.MODIFIED_DATE%>"/>
		</aui:select>
		<aui:select name="<%=Constantes.PREF_EXIBIR%>" label="label.pref.exibir">
			<aui:option label="label.exibir.conteudo" selected="<%=Field.TITLE.equals(prefExibir) %>" value="conteudo"/>
			<aui:option label="label.exibir.resumo" selected="<%=Field.MODIFIED_DATE.equals(prefExibir) %>" value="resumo"/>
		</aui:select>
		<aui:select name="<%=Constantes.PREF_QTDE_REGISTROS%>" label="label.pref.qtdeRegistros">
			<%
				for (int i = 1; i <= 50; i++) {
			%>
				<aui:option label="<%=i %>" selected="<%=i == GetterUtil.getInteger(prefQtdeRegistros) %>" value="<%=i %>"/>
			<%
				}
			%>
		</aui:select>
		<aui:select name="<%=Constantes.PREF_TAMANHO_CARACTERES%>" label="label.pref.tamanhoCaracteres">
			<%
				for (int i = 300; i <= 500; i+=50) {
			%>
				<aui:option label="<%=i %>" selected="<%=i == GetterUtil.getInteger(prefTamanhoCaracteres) %>" value="<%=i %>"/>
			<%
				}
			%>
		</aui:select>
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
		<liferay-ui:message key="label.pref.categoria" /> 
		<liferay-ui:asset-categories-selector
					curCategoryIds="${prefCategoria}" />
		<liferay-ui:message key="label.pref.tag" /> 
		<liferay-ui:asset-tags-selector curTags="${prefTag}" />
		<aui:input inlineLabel="left" label="label.pref.exibirDataAlteracao"
				name="<%=Constantes.PREF_EXIBIR_DATA_ALTERACAO %>" type="checkbox" value="${prefExibirDataAlteracao }" />
		<aui:input inlineLabel="left" label="label.pref.exibirLeiaMais"
				name="<%=Constantes.PREF_EXIBIR_LEIA_MAIS %>" type="checkbox" value="${prefExibirLeiaMais }" />
		<aui:input inlineLabel="left" label="label.pref.habilitarImpressao"
				name="<%=Constantes.PREF_IMPRIMIR %>" type="checkbox" value="${prefImprimir }" />
		<aui:input inlineLabel="left" label="label.pref.habilitarVoltar"
				name="<%=Constantes.PREF_VOLTAR %>" type="checkbox" value="${prefVoltar }" />

		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>

	</aui:fieldset>
</aui:form>