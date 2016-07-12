<%@ include file="init.jsp"%>

<%
	List<AcademiaHorario> lista = AcademiaHorarioLocalServiceUtil
			.search(themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId());
	long atividadeIdAnterior = 0;
	long atividadeId = 0;
	for (AcademiaHorario acadHorario : lista) {
		Atividade atividade = AtividadeLocalServiceUtil
				.fetchAtividade(acadHorario.getAtividadeId());
		if (atividadeIdAnterior != atividade.getAtividadeId()) {
			atividadeIdAnterior = atividade.getAtividadeId();
			atividadeId = atividade.getAtividadeId();
			pageContext.setAttribute("atividadeId", atividadeId);
%>
<liferay-ui:panel-container
	id="panel-container-site-${atividadeId }" extended="true"
	accordion="true">
	<liferay-ui:panel id="panel-site-${atividadeId }"
		title="<%=atividade.getNomeCurrentValue()%>" collapsible="true"
		extended="true">
		<%@ include file="/html/atividade/horariosResultado.jspf"%>
	</liferay-ui:panel>
</liferay-ui:panel-container>
<%
	}
	}
%>
