<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="gerarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="totalPesquisaRespondida"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idPesquisa" scope="request" />

<liferay-ui:error
	key="mensagem.pesquisaEstatistica.pesquisa.obrigatoria"
	message="mensagem.pesquisaEstatistica.pesquisa.obrigatoria" />
<div class="pesquisa_estatistica">

	<%
		List<Pesquisa> listaPesquisa = (List) request
				.getAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA);
		if (listaPesquisa == null) {
			listaPesquisa = new ArrayList<Pesquisa>();
		}
		List<PerguntaVO> listaPergunta = (List) request
				.getAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA);
		if (listaPergunta == null) {
			listaPergunta = new ArrayList<PerguntaVO>();
		}

		String idPesqReq = (String) request
				.getAttribute(Constantes.NOME_PARAM_ID_PESQUISA);
	%>
	<form name="<portlet:namespace />fm" action="<%=gerarURL%>"
		method="POST" class="form_portlet">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="pesquisa_titulo">
			<liferay-ui:message key="${portletTitulo }" />
		</div>
	</c:if>		
		
		<fieldset>
			<legend>
				<liferay-ui:message key="label.pesquisaEstatistica.selecione" />
			</legend>
			<p>
				<select name="idPesquisa" id="idPesquisa">
					<%
						if (listaPesquisa != null) {
							for (Iterator<Pesquisa> it = listaPesquisa.iterator(); it
									.hasNext();) {
								Pesquisa pesquisa = (Pesquisa) it.next();
								String id = String.valueOf(pesquisa.getId());
								if (id.equals(idPesqReq)) {
					%>
					<option value="<%=id%>" selected="selected"><%=pesquisa.getTituloCurrentValue()%></option>
					<%
						} else {
					%>
					<option value="<%=id%>"><%=pesquisa.getTituloCurrentValue()%></option>
					<%
						}
							}
						}
					%>
				</select>&nbsp;<input type="submit"
					value="<liferay-ui:message key="botao.gerar" />" />
			</p>
		</fieldset>
	</form>

	<liferay-ui:success
		key="mensagem.pesquisaEstatistica.pesquisaNaoRespondida"
		message="mensagem.pesquisaEstatistica.pesquisaNaoRespondida" />
	<%
		for (PerguntaVO perguntaVO : listaPergunta) {
	%>
	<p class="pergunta"><%=perguntaVO.getDescricaoCorrente()%></p>
	<%
		for (RespostaVO respostaVO : perguntaVO.getRespostas()) {
	%>
	<div class="resposta">
		<p><%=respostaVO.getDescricaoCorrente()%></p>

		<span><liferay-ui:message
				key="label.pesquisaEstatistica.quantidade" />:<strong class="qtd"><%=respostaVO.getQuantidade()%></strong>
			| <liferay-ui:message key="label.pesquisaEstatistica.percentual" />:<strong><%=respostaVO.getPercentual()%>%</strong>
		</span>
	</div>
	<%
		}
	%>
	<div class="clear"></div>

	<%
		}
	%>
</div>