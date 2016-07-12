<%@ include file="/html/init.jsp"%>
<%
Map<String, String> mapPais = ImportRegionUtil.getCoutries(themeDisplay);
%>

<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	title="${portletTitulo }" />

<portlet:actionURL var="confirmarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION%>"
		value="<%=Constantes.CONFIRMAR%>" />
</portlet:actionURL>

<aui:form action="<%=confirmarURL%>" method="post" name="fm"
	enctype="multipart/form-data">
	<aui:fieldset>
		<aui:select name="<%=Constantes.PAIS %>" label="label.pais">
			<%
			Iterator<String> it = mapPais.keySet().iterator();
			while (it.hasNext()) {
				String nome = (String) it.next();
				String codigo = mapPais.get(nome);
			%>
			<aui:option label="<%=nome%>"
				value="<%=codigo%>" />
			<%
				}
			%>
		</aui:select>
		<aui:input name="<%=Constantes.ARQUIVO %>" type="file" label="label.arquivo" />
		<div class="separator">
			<!-- -->
		</div>
		<aui:button-row>
			<aui:button type="submit" value="botao.confirmar" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>
