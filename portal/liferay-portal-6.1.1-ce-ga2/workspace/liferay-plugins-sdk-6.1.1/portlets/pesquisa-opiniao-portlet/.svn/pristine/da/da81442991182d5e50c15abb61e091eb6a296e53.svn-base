<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="gerarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="totalPesquisaRespondida"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idPesquisa" scope="request" />

<liferay-ui:error key="mensagem.pesquisaRelatorio.pesquisa.obrigatoria"
	message="mensagem.pesquisaRelatorio.pesquisa.obrigatoria" />

<div class="pesquisa_consulta">

	<%
		List<Pesquisa> listaPesquisa = (List) request
				.getAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA);
		if (listaPesquisa == null) {
			listaPesquisa = new ArrayList();
		}
		List<PesquisaUsuarioVO> listaPesquisaUsuario = (List) request
				.getAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA_USUARIO);
		if (listaPesquisaUsuario == null) {
			listaPesquisaUsuario = new ArrayList();
		}
		String idPesqReq = (String) request
				.getAttribute(Constantes.NOME_PARAM_ID_PESQUISA);
	%>
	<form name="<portlet:namespace />fm" action="<%=gerarURL%>" method="POST"
		class="form_portlet">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="pesquisa_titulo">
			<liferay-ui:message key="${portletTitulo }" />
		</div>
	</c:if>		
		<fieldset>
			<legend>
				<liferay-ui:message key="label.pesquisaRelatorio.selecione" />
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
		key="mensagem.pesquisaRelatorio.pesquisaNaoRespondida"
		message="mensagem.pesquisaRelatorio.pesquisaNaoRespondida" />
	<%
		for (PesquisaUsuarioVO pesquisaUsuarioVO : listaPesquisaUsuario) {
			String nome = LanguageUtil.get(pageContext,
					"label.pesquisaRelatorio.anonimo");
			if (!Constantes.VAZIO.equals(pesquisaUsuarioVO.getNome())) {
				nome = pesquisaUsuarioVO.getNome();
			}
	%>
	<div class="participante">
		<a href="javascript: toggle('<%=pesquisaUsuarioVO.getId()%>');"
			title="<liferay-ui:message key="label.pesquisaRelatorio.verRespostas" />">
			<img
			src="<%=pesquisaUsuarioVO.getImagemUrl()%>" alt="<%= pesquisaUsuarioVO.getNome()%>"/>
			<span><%=nome%></span> </a>
	</div>
	<div class="resumo_pesquisa" id='<%=pesquisaUsuarioVO.getId()%>'
		style="display: none;">
		<%
			for (RespostaUsuarioVO respostaUsuarioVO : pesquisaUsuarioVO
						.getRespostas()) {
		%>
		<p class="pergunta"><%=respostaUsuarioVO.getRespostaVO().getPerguntaVO()
							.getDescricaoCorrente()%></p>
		<p class="resposta"><%=respostaUsuarioVO.getRespostaVO().getDescricaoCorrente()%></p>
		<%
			}
		%>
	</div>
	<%
		}
	%>

</div>