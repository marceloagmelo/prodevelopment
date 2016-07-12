<%@ include file="/html/init.jsp"%>

<%@page import="br.com.prodevelopment.equipefitness.portlet.atividade.Constantes"%>
<%@page import="br.com.prodevelopment.equipefitness.portlet.atividade.util.AtividadeUtil"%>
<%@page import="br.com.prodevelopment.equipefitness.portlet.atividade.util.Helper"%>
<%@page import="br.com.prodevelopment.equipefitness.portlet.atividade.util.AcademiaHorarioUtil"%>

<%@page import="br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil"%>

<%@page import="br.com.prodevelopment.atividade.model.Atividade"%>
<%@page import="br.com.prodevelopment.academiahorario.model.AcademiaHorario"%>

<%
int prefQuantidadeItens = GetterUtil.getInteger(preferences.getValue(
		Constantes.PREF_QUANTIDADE_ITENS, null));
int prefIntervaloSegundos = GetterUtil.getInteger(preferences.getValue(
		Constantes.PREF_INTERVALO_SEGUNDOS, null));
%>

