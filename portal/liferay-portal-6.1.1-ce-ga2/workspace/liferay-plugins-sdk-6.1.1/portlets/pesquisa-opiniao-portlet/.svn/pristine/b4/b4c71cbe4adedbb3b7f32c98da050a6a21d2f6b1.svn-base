<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="anteriorURL" scope="request" />
<jsp:useBean class="java.lang.String" id="acaoURL" scope="request" />
<jsp:useBean class="java.lang.String" id="idPesquisa" scope="request" />
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
<jsp:useBean class="java.lang.String" id="prefAnonima" scope="request" />

<liferay-ui:error key="mensagem.pesquisaUsuario.nome.obrigatorio"
	message="mensagem.pesquisaUsuario.nome.obrigatorio" />
<liferay-ui:error key="mensagem.pesquisaUsuario.email.obrigatorio"
	message="mensagem.pesquisaUsuario.email.obrigatorio" />
<liferay-ui:error key="mensagem.pesquisaUsuario.selecione.resposta"
	message="mensagem.pesquisaUsuario.selecione.resposta" />
<liferay-ui:error key="mensagem.pesquisaUsuario.jaRespondeu"
	message="mensagem.pesquisaUsuario.jaRespondeu" />
<liferay-ui:error key="mensagem.erro.enviarEmail"
	message="mensagem.erro.enviarEmail" />
<liferay-ui:error key="mensagem.erro.pesquisaNaoEncontrada"
	message="mensagem.erro.pesquisaNaoEncontrada" />
<liferay-ui:error key="mensagem.erro.bancoDados"
	message="mensagem.erro.bancoDados" />
<liferay-ui:success key="mensagem.pesquisaUsuario.finalizada.sucesso"
	message="mensagem.pesquisaUsuario.finalizada.sucesso" />

<%
	PesquisaVO pesquisaVO = (PesquisaVO) request
			.getAttribute(Constantes.NOME_PARAM_PESQUISA_VO);
	boolean incompleto = false;

	if (pesquisaVO != null) {
%>

<form name="<portlet:namespace />fm" action="<%=acaoURL%>" method="POST">
	<div class="pesquisa">
		<c:if test="${exibirTitulo == 'S' }">
			<div class="pesquisa_titulo">
				<liferay-ui:message key="${portletTitulo }" />
			</div>
		</c:if>
		<h3><%=pesquisaVO.getTituloCorrente()%></h3>
		<%
			if (pesquisaVO.getPerguntas() != null) {
		%>
		<c:choose>
			<c:when
				test="<%= Constantes.UM.equals(pagina) && Constantes.N.equals(usuarioLogado) && Constantes.N.equals(prefAnonima)%>">
				<div class="participante">
					<p>
						<liferay-ui:message key="label.pesquisaUsuario.nome" />
						<br /> <input type="text" name="nome" value="<%=nome%>" />
					</p>
					<p>
						<liferay-ui:message key="label.pesquisaUsuario.email" />
						<br /> <input type="text" name="email" value="<%=email%>" />
					</p>
					<span><liferay-ui:message
							key="label.pesquisaUsuario.preenchimentoObrigatorio" /> </span>
				</div>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="nome" value="<%=nome%>" />
				<input type="hidden" name="email" value="<%=email%>" />
			</c:otherwise>
		</c:choose>

		<%
			for (PerguntaVO perguntaVO : pesquisaVO.getPerguntas()) {
		%>
		<div class="pergunta"><%=perguntaVO.getDescricaoCorrente()%></div>
		<%
			if (perguntaVO.getRespostas() != null) {
		%>

		<ul>
			<%
				String objTotalResposta = "totalResposta";
								int contadorResposta = 0;

								for (RespostaVO respostaVO : perguntaVO
										.getRespostas()) {
			%>
			<li><input type="radio" class="radio" name="idResposta"
				value="<%=respostaVO.getId()%>"><%=respostaVO.getDescricaoCorrente()%>
			</li>
			<%
				contadorResposta++;
									totalRespostas = String
											.valueOf(contadorResposta);
								}
			%>
		</ul>
		<%
			} else {
							incompleto = true;
		%>
		<div class="portlet-configuration portlet-msg-info">
			<liferay-ui:message key="mensagem.pesquisa.semRespostas" />
		</div>
		<%
			}
					}
				} else {
					incompleto = true;
		%>
		<div class="portlet-configuration portlet-msg-info">
			<liferay-ui:message key="mensagem.pesquisa.semPerguntas" />
		</div>
		<%
			}
				if (!incompleto) {
		%>
		<div class="naveg">
			<c:if
				test="<%=Integer.parseInt(pagina) > Integer.parseInt(Constantes.UM) %>">
				<a class="voltar"
					href="javascript: document.<portlet:namespace />fm.acao.value = 'anterior'; document.<portlet:namespace />fm.submit()"
					title="<liferay-ui:message key="botao.anterior" />"><liferay-ui:message
						key="botao.anterior" /> </a>
			</c:if>
			<span class="resultado"> <liferay-ui:message
					key="label.texto.pagina" /> ${pagina } <liferay-ui:message
					key="label.texto.de" /> ${totalPaginas } </span>
			<c:if
				test="<%=Integer.parseInt(pagina) == Integer.parseInt(totalPaginas) %>">
				<a class="botao"
					href="javascript: document.<portlet:namespace />fm.acao.value = 'enviar'; document.<portlet:namespace />fm.submit();"
					title=<liferay-ui:message key="botao.finalizar" />><liferay-ui:message
						key="botao.finalizar" /> </a>
			</c:if>
			<c:if
				test="<%=Integer.parseInt(pagina) < Integer.parseInt(totalPaginas) %>">
				<a class="avancar"
					href="javascript: document.<portlet:namespace />fm.acao.value = 'proxima'; document.<portlet:namespace />fm.submit();"
					title="<liferay-ui:message key="botao.proxima" />"><liferay-ui:message
						key="botao.proxima" /> </a>
			</c:if>

		</div>

	</div>
	<input type="hidden" name="idPesquisa" id="idPesquisa"
		value="<%=idPesquisa%>" /> <input type="hidden" name="idPergunta"
		id="idPergunta" value="<%=idPergunta%>" /> <input type="hidden"
		name="pagina" value="<%=pagina%>" /> <input type="hidden"
		name="totalPaginas" value="<%=totalPaginas%>" /> <input type="hidden"
		name="totalPerguntasPagina" value="<%=totalPerguntasPagina%>" /> <input
		type="hidden" name="totalRespostas" value="<%=totalRespostas%>" /> <input
		type="hidden" name="perguntasLidas" value="<%=perguntasLidas%>" /> <input
		type="hidden" name="perguntaInicio" value="<%=perguntaInicio%>" /> <input
		type="hidden" name="acao" value="<%=acao%>" /> <input type="hidden"
		name="usuarioLogado" value="<%=usuarioLogado%>" />
	<input type="hidden" name="resourceBundle" value="${resourceBundle }"/>		
	<%
		}
		}
	%>
</form>
