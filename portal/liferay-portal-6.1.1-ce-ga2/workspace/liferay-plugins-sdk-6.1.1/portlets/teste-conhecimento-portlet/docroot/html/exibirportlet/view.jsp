<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="anteriorURL" scope="request" />
<jsp:useBean class="java.lang.String" id="acaoURL" scope="request" />
<jsp:useBean class="java.lang.String" id="idTeste" scope="request" />
<jsp:useBean class="java.lang.String" id="idPergunta" scope="request" />
<jsp:useBean class="java.lang.String" id="pagina" scope="request" />
<jsp:useBean class="java.lang.String" id="totalPaginas" scope="request" />
<jsp:useBean class="java.lang.String" id="totalPerguntasPagina"
	scope="request" />
<jsp:useBean class="java.lang.String" id="totalRespostas"
	scope="request" />
<jsp:useBean class="java.lang.String" id="perguntasLidas"
	scope="request" />
<jsp:useBean class="java.lang.String" id="perguntaInicio"
	scope="request" />
<jsp:useBean class="java.lang.String" id="acao" scope="request" />
<jsp:useBean class="java.lang.String" id="nome" scope="request" />
<jsp:useBean class="java.lang.String" id="email" scope="request" />
<jsp:useBean class="java.lang.String" id="usuarioLogado" scope="request" />
<jsp:useBean class="java.lang.String" id="precisaResponder"
	scope="request" />
<jsp:useBean class="java.lang.String" id="justificativa" scope="request" />
<jsp:useBean class="java.lang.String" id="usuarioRespondeu"
	scope="request" />
<jsp:useBean class="java.lang.String" id="respostaCerta" scope="request" />
<jsp:useBean class="java.lang.String" id="inicio" scope="request" />

<liferay-ui:error key="mensagem.testeUsuario.nome.obrigatorio"
	message="mensagem.testeUsuario.nome.obrigatorio" />
<liferay-ui:error key="mensagem.testeUsuario.email.obrigatorio"
	message="mensagem.testeUsuario.email.obrigatorio" />
<liferay-ui:error key="mensagem.testeUsuario.selecione.resposta"
	message="mensagem.testeUsuario.selecione.resposta" />
<liferay-ui:error key="mensagem.testeUsuario.jaRespondeu"
	message="mensagem.testeUsuario.jaRespondeu" />
<liferay-ui:error key="mensagem.erro.enviarEmail"
	message="mensagem.erro.enviarEmail" />
<liferay-ui:error key="mensagem.erro.bancoDados"
	message="mensagem.erro.bancoDados" />

<c:if test="${respostaCerta == 'N'}">
	<div class="resposta_errada">
		<liferay-ui:message key="mensagem.testeUsuario.respostaErrada" />
	</div>
</c:if>

<%
	TesteVO testeVO = (TesteVO) request
			.getAttribute(Constantes.NOME_PARAM_TESTE_VO);
	if (testeVO != null) {

		PortletPreferences prefs = renderRequest.getPreferences();
		String prefExibirAcerto = prefs.getValue(
				Constantes.PREF_EXIBIR_ACERTO, Constantes.VAZIO);
%>

<form name="formExibirTeste" action="<%=acaoURL%>" method="POST">
	<div class="pesquisa">
		<h3><%=testeVO.getTituloCorrente()%></h3>

<liferay-ui:success key="mensagem.testeaUsuario.finalizado.sucesso"
	message="mensagem.testeaUsuario.finalizado.sucesso" />
<liferay-ui:success key="mensagem.testeUsuario.respostaCerta"
	message="mensagem.testeUsuario.respostaCerta" />
<liferay-ui:success key="mensagem.testeUsuario.testeRespondido"
	message="mensagem.testeUsuario.testeRespondido" />
<liferay-ui:success key="mensagem.testeUsuario.perguntaRespondida"
	message="mensagem.testeUsuario.perguntaRespondida" />

		<%
			if (Constantes.UM.equals(precisaResponder)) {
			for (PerguntaVO perguntaVO : testeVO.getPerguntas()) {
		%>
		<div class="pergunta"><%=perguntaVO.getDescricaoCorrente()%></div>
		<ul>
			<%
				String objTotalResposta = "totalResposta";
							int contadorResposta = 0;

							for (RespostaVO respostaVO : perguntaVO.getRespostas()) {
			%>
			<li><input type="radio" class="radio" name="idResposta"
				value="<%=respostaVO.getId()%>"><%=respostaVO.getDescricaoCorrente()%>
			</li>
			<%
				contadorResposta++;
								totalRespostas = String.valueOf(contadorResposta);
							}
			%>
		</ul>
		<%
			}
				} else {
		%>
		<c:if test="<%=Constantes.S.equals(prefExibirAcerto) && Constantes.N.equals(respostaCerta) %>">
			<p>
				<textarea rows="5" cols="80"
					name="<%=Constantes.NOME_PARAM_USUARIO_RESPONDEU%>"
					disabled="disabled"><%=usuarioRespondeu%></textarea>
			</p>
			<p>			<liferay-ui:message key="label.testeUsuario.justificativaResposta" />
			</p>
			<p>
				<textarea rows="5" cols="80"
					name="<%=Constantes.NOME_PARAM_JUSTIFICATIVA%>" disabled="disabled"><%=justificativa%></textarea>
			</p>
		</c:if>
		<%
			}
		%>
		<div class="naveg">
			<%
				if (Constantes.UM.equals(precisaResponder)) {
			%>
			<span class="resultado"> <liferay-ui:message
					key="label.texto.pagina" /> ${pagina } <liferay-ui:message
					key="label.texto.de" /> ${totalPaginas } </span>
			<a class="botao"
				href="javascript: document.formExibirTeste.acao.value = 'confirmar'; document.formExibirTeste.submit();"
				title=<liferay-ui:message key="botao.confirmar" />><liferay-ui:message
					key="botao.confirmar" /> </a>
			<%
				} else {
			%>
			<c:if
				test="<%=Integer.parseInt(pagina) == Integer.parseInt(totalPaginas) %>">
				<a class="botao"
					href="javascript: document.formExibirTeste.acao.value = 'enviar'; document.formExibirTeste.submit();"
					title=<liferay-ui:message key="botao.finalizar" />><liferay-ui:message
						key="botao.finalizar" /> </a>
			</c:if>
			<c:if
				test="<%=Integer.parseInt(pagina) < Integer.parseInt(totalPaginas) %>">
				<a class="avancar"
					href="javascript: document.formExibirTeste.acao.value = 'proxima'; document.formExibirTeste.submit();"
					title="<liferay-ui:message key="botao.proximo" />"><liferay-ui:message
						key="botao.proximo" /> </a>
			</c:if>
			<%
				}
			%>

		</div>

	</div>
	<input type="hidden" name="idTeste" id="idTeste" value="<%=idTeste%>" />
	<input type="hidden" name="idPergunta" id="idPergunta"
		value="<%=idPergunta%>" /> <input type="hidden" name="pagina"
		value="<%=pagina%>" /> <input type="hidden" name="totalPaginas"
		value="<%=totalPaginas%>" /> <input type="hidden"
		name="totalPerguntasPagina" value="<%=totalPerguntasPagina%>" /> <input
		type="hidden" name="totalRespostas" value="<%=totalRespostas%>" /> <input
		type="hidden" name="perguntasLidas" value="<%=perguntasLidas%>" /> <input
		type="hidden" name="perguntaInicio" value="<%=perguntaInicio%>" /> <input
		type="hidden" name="acao" value="<%=acao%>" />
		<input type="hidden" name="inicio" value="<%=inicio%>" />
		<input type="hidden" name="resourceBundle" value="${resourceBundle }"/>
	<%
		}
	%>
</form>