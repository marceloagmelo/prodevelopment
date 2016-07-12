<%@ include file="/html/init.jsp"%>
<jsp:useBean class="java.lang.String" id="verTodosURL" scope="request" />
<!-- Essa div cerca tudo -->
<liferay-ui:success key="mensagem.aniversario.nao.existem"
	message="mensagem.aniversario.nao.existem" />
<div class="aniversariantes">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="titulo">${portletTitulo }</div>
	</c:if>
	<%
		List<UsuarioVO> listaUsuario = (List) request
				.getAttribute("listaUsuario");
		if (listaUsuario == null) {
			listaUsuario = new ArrayList();
		}
		for (UsuarioVO usuario : listaUsuario) {
			String departamento = usuario.getDepartamento();
	%>
	<portlet:actionURL name="<%=Constantes.METODO_PREPARAR_MENSAGEM%>"
		var="prepararMensagemURL" windowState="MAXIMIZED">
		<portlet:param name="<%=Constantes.NOME_PARAM_ID%>"
			value="<%=String.valueOf(usuario.getId())%>" />
	</portlet:actionURL>
	<!-- uma div dessa para cada aniversariante -->
	<div class="aniversariante">
		<div class="data">
			<span><%=usuario.getDiaAniversario()%> </span><%=usuario.getMesAniversario()%>/<%=usuario.getAnoAniversario()%></div>
		<div class="foto">
			<img alt="<%=usuario.getNome()%>" class="user-logo"
				src="<%=usuario.getUrlImagem()%>" />
		</div>
		<div class="texto">
			<h4><%=usuario.getNome()%></h4>
			<p class="msg">
				<a href="<%=prepararMensagemURL.toString()%>"><liferay-ui:message
						key="label.aniversariante.enviarMensagem" /></a>
			</p>
		</div>
	</div>
	<%
		}
	%>
	<div class="clear"></div>
</div>


