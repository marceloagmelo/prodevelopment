<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="confirmarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="nomeArquivo" scope="request" />
<jsp:useBean class="java.lang.String" id="nomeImagem" scope="request" />
<jsp:useBean class="java.lang.String" id="urlArquivoGerado" scope="request" />
<jsp:useBean class="java.lang.String" id="arquivoGerado" scope="request" />

<liferay-ui:error key="mensagem.arquivo.obrigatorio"
	message="mensagem.arquivo.obrigatorio" />

<aui:form action="<%= confirmarURL %>" enctype="multipart/form-data" method="post" name="fm">
	<aui:input label="label.arquivo" name="nomeArquivo" size="100" type="file" value="<%=nomeArquivo %>"/>
	<aui:input label="label.imagem" name="nomeImagem" size="100" type="file" value="<%=nomeImagem %>"/>
	
	<div class="separator"></div>

	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="botao.confirmar" />
<%
if ( (arquivoGerado != null) && (!"".equals(arquivoGerado)) ) {
%>
		<aui:button onClick="self.location.href = '<%=urlArquivoGerado%>';" value="botao.download.arquivo" />
<%
}
%>		
	</aui:button-row>

</aui:form>	
