<%@ include file="/html/init.jsp"%>

<jsp:useBean class="java.lang.String" id="gerarURL" scope="request" />
<jsp:useBean class="java.lang.String" id="totalTesteRespondida"
	scope="request" />
<jsp:useBean class="java.lang.String" id="idTeste" scope="request" />

<liferay-ui:error
	key="mensagem.testeEstatistica.teste.obrigatoria"
	message="mensagem.testeEstatistica.teste.obrigatoria" />
<div class="pesquisa_estatistica">

<%
	List listaTeste = (List) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_TESTE);
	if (listaTeste == null) {
		listaTeste = new ArrayList();
	}
	List<PerguntaVO> listaPergunta = (List) request
			.getAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA);
	if (listaPergunta == null) {
		listaPergunta = new ArrayList();
	}
%>
<form name="formEstatisticaTeste" action="<%=gerarURL%>"
	method="POST" class="form_portlet">
<fieldset>
<legend><liferay-ui:message key="label.testeEstatistica.selecione"/></legend>
<p><select name="idTeste" id="idTeste">
	<%
		if (listaTeste != null) {
			for (Iterator it = listaTeste.iterator(); it.hasNext();) {
				Teste teste = (Teste) it.next();
				String id = String.valueOf(teste.getId());
	%>
	<option value="<%=id%>"><%=teste.getTituloCurrentValue()%></option>
	<%
		}
		}
	%>
</select>&nbsp;<input type="submit"
	value="<liferay-ui:message key="botao.gerar" />" /></p>
</fieldset>
</form>

<liferay-ui:success
	key="mensagem.testeEstatistica.testeNaoRespondida"
	message="mensagem.testeEstatistica.testeNaoRespondida" />
<%
	for (PerguntaVO perguntaVO : listaPergunta) {
%>
<p class="pergunta"><%=perguntaVO.getDescricao()%></p>
<%
	for (RespostaVO respostaVO : perguntaVO.getRespostas()) {
%>
<div class="resposta">
<p><%=respostaVO.getDescricao()%></p>

<span><liferay-ui:message
	key="label.testeEstatistica.quantidade" />:<strong class="qtd"><%=respostaVO.getQuantidade()%></strong>
| <liferay-ui:message key="label.testeEstatistica.percentual" />:<strong><%=respostaVO.getPercentual()%>%</strong></span>
</div>
<%
	}
%>
<div class="clear"></div>

<%
	}
%>
</div>