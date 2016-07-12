<%@include file="init.jsp"%>
<%@ include file="mensagem.jspf"%>

<jsp:useBean class="java.lang.String" id="prefId" scope="request" />
<jsp:useBean class="java.lang.String" id="prefEstrutura" scope="request" />

<liferay-portlet:renderURL portletConfiguration="true" var="renderURL">
 <liferay-portlet:param name="<%=Constantes.PROP_NOME%>" value="${nome}"></liferay-portlet:param>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<%
String exibirTitulo = (String) request.getAttribute(Constantes.PREF_EXIBIR_TITULO);

%>
<script type="text/javascript">
var alteracao = 0;

function enviarForm() {
	document.forms[0].submit();
}

function filtrar() {

	document.forms[0].action = '<%=renderURL%>';

		enviarForm();
	}

	function selecionar(id) {

		document.getElementById("prefId").value = id;
		enviarForm();
	}
</script>
<form action="<%=configuracaoURL%>" method="post" name="fm">
	<input type="hidden" name="<%=Constantes.PREF_ID%>"
		id="<%=Constantes.PREF_ID%>" value="${prefId }" /> <input
		type="hidden" name="<%=Constantes.PREF_ID%>"
		id="<%=Constantes.PREF_ID%>" value="${prefId }" />

	<fieldset>
		<legend>
			<liferay-ui:message key="label.pref.nome" />

		</legend>
		<input label="label.pref.nome" name="<%=Constantes.PROP_NOME%>"
			size="40" id="<%=Constantes.PROP_NOME%>" value="${nome }" /> <input
			type="button" value="<liferay-ui:message key="botao.filtrar"/>"
			onclick="javascript:filtrar()">

		<div
			style="border-bottom: 1px solid gray; margin-top: 4px; margin-bottom: 4px;"></div>

		<%
			List<JournalStructure> listaEstrutura = (List) request.getAttribute(Constantes.LISTA_ESTRUTURA);
			List<ConteudoVO> listaConteudos = (List<ConteudoVO>) request
					.getAttribute(Constantes.LISTA_CONTEUDOS);
			if (listaConteudos == null) {
				listaConteudos = new ArrayList<ConteudoVO>();
			}

			int linhasPorPagina = Constantes.TOTAL_POR_PAGINA;
		%>

		<liferay-ui:search-container
			emptyResultsMessage="mensagem.lista.registos.nao.encontrados"
			delta="<%=linhasPorPagina %>">
			<liferay-ui:search-container-results>
				<%
					results = ListUtil.subList(listaConteudos,
											searchContainer.getStart(),
											searchContainer.getEnd());
									pageContext.setAttribute("results", results);
									pageContext.setAttribute("total",
											request.getAttribute("total"));
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="br.com.prodevelopment.conteudo.vo.ConteudoVO" keyProperty="id"
				modelVar="conteudo">
				<liferay-ui:search-container-column-text name="label.id">

					<a href="#" onclick="javascript: selecionar('${conteudo.id}');"
						id="ids" name="ids"> ${conteudo.id } </a>

				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text orderable="true"
					name="label.titulo" property="titulo" />
				<liferay-ui:search-container-column-text name="label.descricao"
					property="descricao" />
				<liferay-ui:search-container-column-text orderable="true"
					name="label.DataAlteracao" property="dataAlteracao" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
		</liferay-ui:search-container>
		<liferay-ui:page-iterator cur="${page}" curParam="page"
			delta="${pageSize}" deltaConfigurable="false" maxPages="50"
			total="${total}" url="<%=renderURL%>" />
	</fieldset>
	
		<%
			if (listaEstrutura != null) {
		%>
	<fieldset>
		<legend>
			<liferay-ui:message key="label.pref.estrutura" />

		</legend>
	
					<select name="<%=Constantes.PREF_ESTRUTURA%>">
						<option value="" selected="selected">
							<liferay-ui:message key="label.todas" />
						</option>
						<%
							for (Iterator it = listaEstrutura.iterator(); it.hasNext();) {
									JournalStructure estrutura = (JournalStructure) it.next();
									if (estrutura.getStructureId().equals(prefEstrutura)) {
						%>
						<option value="<%=estrutura.getStructureId()%>"
							selected="selected"><%=estrutura.getName()%></option>
						<%
							} else {
						%>
						<option value="<%=estrutura.getStructureId()%>"><%=estrutura.getName()%></option>
						<%
							}
								}
						%>
					</select>

<%
			}
%>	
	
	</fieldset>
	<fieldset>
		<legend>
			<liferay-ui:message key="label.pref.exibirTitulo" />

		</legend>
	
					<select name="<%=Constantes.PREF_EXIBIR_TITULO%>">
						<%
							if (Constantes.S.equals(exibirTitulo)) {
						%>
						<option value="S" selected="true"><liferay-ui:message key="label.sim" /></option>
						<option value="N"><liferay-ui:message key="label.nao" /></option>
						<%
							} else {
						%>
						<option value="S"><liferay-ui:message key="label.sim" /></option>
						<option value="N" selected="true"><liferay-ui:message key="label.nao" /></option>
						<%
							}
						%>
					</select>
	
	</fieldset>
		<fieldset style="margin-top:10px">

			<aui:input inlineLabel="left" label="label.pref.habilitarFacebook"
				name="<%=Constantes.PREF_RS_FACEBOOK %>" type="checkbox"
				value="${prefRsFacebook }" />
			<aui:input inlineLabel="left" label="label.pref.habilitarTwitter"
				name="<%=Constantes.PREF_RS_TWITTER %>" type="checkbox"
				value="${prefRsTwitter }" />
			<aui:input inlineLabel="left" label="label.pref.habilitarLinkedIn"
				name="<%=Constantes.PREF_RS_LINKEDIN %>" type="checkbox"
				value="${prefRsLinkedIn }" />
			<aui:input inlineLabel="left" label="label.pref.habilitarGoogle"
				name="<%=Constantes.PREF_RS_GOOGLE %>" type="checkbox"
				value="${prefRsGoogle }" />
			<aui:input inlineLabel="left" label="label.pref.habilitarVoltar"
				name="<%=Constantes.PREF_VOLTAR %>" type="checkbox"
				value="${prefVoltar }" />
			<aui:input inlineLabel="left" label="label.pref.habilitarEmail"
				name="<%=Constantes.PREF_EMAIL %>" type="checkbox"
				value="${prefEmail }" />
			<aui:input inlineLabel="left" label="label.pref.habilitarImpressao"
				name="<%=Constantes.PREF_IMPRIMIR %>" type="checkbox"
				value="${prefImprimir }" />
			<aui:input inlineLabel="left" label="label.pref.habilitarPontuacao"
				name="<%=Constantes.PREF_PONTUACAO %>" type="checkbox"
				value="${prefPontuacao }" />
			<c:if test="<%= Constantes.JOURNAL_ARTICLE_COMMENTS_ENABLED %>">
				<aui:input inlineLabel="left"
					label="label.pref.habilitarComantarios"
					name="<%=Constantes.PREF_COMENTARIO %>" type="checkbox"
					value="${prefComentario }" />

				<aui:input inlineLabel="left"
					label="label.pref.habilitarPontuaçãoComentarios"
					name="<%=Constantes.PREF_PONTUACAO_COMENTARIO %>" type="checkbox"
					value="${prefPontuacaoComentario }" />
			</c:if>
			<aui:input inlineLabel="left"
				label="label.pref.habilitarUsuarioDataAtualizacao"
				name="<%=Constantes.PREF_USUARIO_DATA_ATUALIZACAO %>"
				type="checkbox" value="${prefUsuarioDataAtualizacao }" />
		</fieldset>
		<br> <input type="submit"
			value="<liferay-ui:message key="botao.salvar" />" />
</form>