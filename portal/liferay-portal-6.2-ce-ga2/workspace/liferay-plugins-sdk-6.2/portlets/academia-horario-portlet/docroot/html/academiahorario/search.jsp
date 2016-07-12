<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
	
	pageContext.setAttribute("selAtividadeId", String.valueOf(atividadeId));
	
%>
<liferay-ui:search-toggle buttonLabel="label.pesquisar"
	displayTerms="<%=displayTerms%>" id="toggle_id_search">
	<aui:select name="<%=Constantes.CAMPO_DIA_SEMANA%>"
		label="label.diaSemana">
		<aui:option label=""
			selected='<%="0".equals(diaDaSemana)%>' value="0" />
		<%
			for (String dia : AcademiaHorarioUtil.valoresDiasDaSemana) {
						pageContext
								.setAttribute("diaDaSemana", String
										.valueOf(AcademiaHorarioUtil
												.getDiaDaSemana(Integer
														.parseInt(dia) - 1)));
		%>
		<aui:option label="${diaDaSemana }"
			selected="<%=dia.equals(diaDaSemana) %>" value="<%=dia %>" />
		<%
			}
		%>
	</aui:select>
	<aui:select label="label.atividade"
		name="<%=Constantes.CAMPO_ATIVIDADE_ID%>">
		<aui:option label=""
			selected="${'0' eq selAtividadeId}" value="0" />
		<c:forEach items="<%=listaAtividades%>" var="cboAtividade">
			<aui:option label="${cboAtividade.nomeCurrentValue }"
				selected="${cboAtividade.atividadeId eq selAtividadeId}"
				value="${cboAtividade.atividadeId }" />
		</c:forEach>
	</aui:select>

</liferay-ui:search-toggle>