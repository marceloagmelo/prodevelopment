<%@ include file="init.jsp"%>
<%
	Long atividadeId = ParamUtil.getLong(request, "atividadeId");
	Atividade atividade = AtividadeUtil.getAtividade(atividadeId);
%>
<liferay-ui:header escapeXml="<%=false%>" localizeTitle="false"
	title='<%=atividade.getNomeCurrentValue()%>' />

<%@ include file="horariosResultado.jspf"%>

