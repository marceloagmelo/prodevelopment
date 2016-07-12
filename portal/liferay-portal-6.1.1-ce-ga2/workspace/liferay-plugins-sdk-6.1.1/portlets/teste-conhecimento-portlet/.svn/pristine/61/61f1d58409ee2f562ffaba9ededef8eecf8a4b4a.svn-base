<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="gerarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="totalTesteRespondida"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idTeste" scope="request" />
<jsp:useBean class="java.lang.String" id="ordenacao" scope="request" />

<liferay-ui:error key="mensagem.testeRelatorio.teste.obrigatoria"
	message="mensagem.testeRelatorio.teste.obrigatoria" />

<div class="pesquisa_relatorio">

	<%
		List<Teste> listaTeste = (List) request
				.getAttribute(Constantes.NOME_PARAM_LISTA_TESTE);
		if (listaTeste == null) {
			listaTeste = new ArrayList();
		}
		List<TesteUsuarioVO> listaTesteUsuario = (List) request
				.getAttribute(Constantes.NOME_PARAM_LISTA_TESTE_USUARIO);
		if (listaTesteUsuario == null) {
			listaTesteUsuario = new ArrayList();
		}
	%>
	<form name="<portlet:namespace />fm" action="<%=gerarURL%>" method="POST"
		class="form_portlet">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="teste_titulo">
			<liferay-ui:message key="${portletTitulo }" />
		</div>
	</c:if>		
		<fieldset>
			<legend>
				<liferay-ui:message key="label.testeRelatorio.selecione" />
			</legend>

			<p>
				<select name="idTeste" id="idTeste">
					<%
						if (listaTeste != null) {
							for (Iterator it = listaTeste.iterator(); it.hasNext();) {
								Teste teste = (Teste) it.next();
								String id = String.valueOf(teste.getId());
								if (id.equals(idTeste)) {
					%>
					<option value="<%=id%>" selected="selected"><%=teste.getTituloCurrentValue()%></option>
					<%
						} else {
					%>
					<option value="<%=id%>"><%=teste.getTituloCurrentValue()%></option>
					<%
						}
							}
						}
					%>
				</select>&nbsp;
				<%
					if (Constantes.ZERO.equals(ordenacao)) {
				%>
				<input type="radio" name="ordenacao" value="<%=Constantes.ZERO%>"
					checked="checked">
				<liferay-ui:message key="label.testeRelatorio.ordenaPorNome" />
				&nbsp;&nbsp; <input type="radio" name="ordenacao"
					value="<%=Constantes.UM%>">
				<liferay-ui:message
					key="label.testeRelatorio.ordenaPorRespostaCerta" />
				&nbsp;&nbsp; <input type="radio" name="ordenacao"
					value="<%=Constantes.DOIS%>">
				<liferay-ui:message key="label.testeRelatorio.ordenaPorPontuacao" />
				&nbsp;&nbsp;
				<%
					} else if (Constantes.UM.equals(ordenacao)) {
				%>
				<input type="radio" name="ordenacao" value="<%=Constantes.ZERO%>">
				<liferay-ui:message key="label.testeRelatorio.ordenaPorNome" />
				&nbsp;&nbsp; <input type="radio" name="ordenacao"
					value="<%=Constantes.UM%>" checked="checked">
				<liferay-ui:message
					key="label.testeRelatorio.ordenaPorRespostaCerta" />
				&nbsp;&nbsp;<input type="radio" name="ordenacao"
					value="<%=Constantes.DOIS%>">
				<liferay-ui:message key="label.testeRelatorio.ordenaPorPontuacao" />
				&nbsp;&nbsp;
				<%
					} else {
				%>
				<input type="radio" name="ordenacao" value="<%=Constantes.ZERO%>">
				<liferay-ui:message key="label.testeRelatorio.ordenaPorNome" />
				&nbsp;&nbsp; <input type="radio" name="ordenacao"
					value="<%=Constantes.UM%>">
				<liferay-ui:message
					key="label.testeRelatorio.ordenaPorRespostaCerta" />
				&nbsp;&nbsp;<input type="radio" name="ordenacao"
					value="<%=Constantes.DOIS%>" checked="checked">
				<liferay-ui:message key="label.testeRelatorio.ordenaPorPontuacao" />
				&nbsp;&nbsp;
				<%
					}
				%>
				<input type="submit"
					value="<liferay-ui:message key="botao.gerar" />" />
			</p>
		</fieldset>
	</form>

	<liferay-ui:success key="mensagem.testeRelatorio.testeNaoRespondida"
		message="mensagem.testeRelatorio.testeNaoRespondida" />
	<%
		for (TesteUsuarioVO testeUsuarioVO : listaTesteUsuario) {
			String nome = "";
			if (!Constantes.VAZIO.equals(testeUsuarioVO.getNome())) {
				nome = testeUsuarioVO.getNome();
			}
	%>
	<div class="participante">
		<a href="javascript: toggle('<%=testeUsuarioVO.getId()%>');"
			title="<liferay-ui:message key="label.testeRelatorio.verRespostas" />">
			<img
			src="<%=testeUsuarioVO.getImagemUrl()%>" alt="<%= testeUsuarioVO.getNome()%>"/>
			<span><%=nome%> <span
				style="font-weight: normal;">- <liferay-ui:message
						key="label.testeRelatorio.pontos" />: <b><%=testeUsuarioVO.getTotalPontuacao()%></b> - <liferay-ui:message
						key="label.testeRelatorio.respostaCerta" />: <b><%=testeUsuarioVO.getTotalRespostaCerta()%></b>
					- <liferay-ui:message key="label.testeRelatorio.respostaErrada" />:
					<b><%=testeUsuarioVO.getTotalRespostaErrada()%></b> </span> </span> </a>
	</div>
	<div class="resumo_teste" id='<%=testeUsuarioVO.getId()%>'
		style="display: none;">
		<%
			for (RespostaUsuarioVO respostaUsuarioVO : testeUsuarioVO.getRespostas()) {
					String classeResposta = "";
					if (Constantes.S.equals(respostaUsuarioVO.getCorreta())) {
						classeResposta = "resposta certa";
					} else {
						classeResposta = "resposta errada";
					}
		%>
		<p class="pergunta"><%=respostaUsuarioVO.getRespostaVO().getPerguntaVO().getDescricaoCorrente()%></p>
		<p class="<%=classeResposta%>"><%=respostaUsuarioVO.getRespostaVO().getDescricaoCorrente()%></p>
		<%
			}
		%>
	</div>
	<%
		}
	%>
</div>