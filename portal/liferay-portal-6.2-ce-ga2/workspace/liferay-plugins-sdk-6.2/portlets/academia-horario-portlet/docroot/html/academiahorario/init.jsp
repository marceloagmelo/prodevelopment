<%@ include file="/html/init.jsp"%>

<%@page
	import="br.com.prodevelopment.portlet.academiahorario.Constantes"%>
<%@page
	import="br.com.prodevelopment.portlet.academiahorario.util.AcademiaHorarioUtil"%>
<%@page
	import="br.com.prodevelopment.portlet.academiahorario.util.AtividadeUtil"%>
<%@page
	import="br.com.prodevelopment.portlet.academiahorario.util.DateUtil"%>

<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>

<%@page
	import="br.com.prodevelopment.portlet.academiahorario.search.AcademiaHorarioSearch"%>
<%@page
	import="br.com.prodevelopment.portlet.academiahorario.search.AcademiaHorarioSearchTerms"%>
<%@page
	import="br.com.prodevelopment.portlet.academiahorario.search.AcademiaHorarioDisplayTerms"%>

<%@page
	import="br.com.prodevelopment.academiahorario.model.AcademiaHorario"%>
<%@page import="br.com.prodevelopment.atividade.model.Atividade"%>


<%@page
	import="br.com.prodevelopment.academiahorario.AcademiaHorarioAtividadeObrigatoriaException"%>
<%@page
	import="br.com.prodevelopment.academiahorario.AcademiaHorarioDiaSemanaObrigatorioException"%>
<%@page
	import="br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialObrigatoriaException"%>
<%@page
	import="br.com.prodevelopment.academiahorario.AcademiaHorarioHoraFinalObrigatoriaException"%>
<%@page
	import="br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialMaiorQueFinalException"%>
<%@page
	import="br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialIgualFinalException"%>
<%@page
	import="br.com.prodevelopment.academiahorario.AcademiaHorarioAlteradoOutroUsuarioException"%>

<%
	boolean permissaoConfigFuncionario = permissionChecker
			.hasPermission(scopeGroupId,
					Constantes.RESOURCE_ACADEMIA_HORARIO, scopeGroupId,
					ActionKeys.PERMISSIONS);
/*
	boolean permissaoAdd = permissionChecker.hasPermission(
			scopeGroupId, Constantes.RESOURCE_ACADEMIA_HORARIO,
			scopeGroupId, Constantes.PERMISSAO_ADD);
	boolean permissaoUpdate = permissionChecker.hasPermission(
			scopeGroupId, Constantes.RESOURCE_ACADEMIA_HORARIO,
			scopeGroupId, ActionKeys.UPDATE);
	boolean permissaoDelete = permissionChecker.hasPermission(
			scopeGroupId, Constantes.RESOURCE_ACADEMIA_HORARIO,
			scopeGroupId, ActionKeys.DELETE);
*/
	boolean permissaoAdd = true;
	boolean permissaoUpdate = true;
	boolean permissaoDelete = true;

boolean prefSomenteEsseSite = GetterUtil.getBoolean(preferences
			.getValue(Constantes.PREF_SOMENTE_ESSE_SITE, null));
	int prefIntervaloMinuto = GetterUtil.getInteger(preferences
			.getValue(Constantes.PREF_INTERVALO_MINUTO, null));

	String nomeSite = StringPool.BLANK;

	String diaDaSemana = ParamUtil.getString(request,
			Constantes.CAMPO_DIA_SEMANA);
	String atividadeId = ParamUtil.getString(request,
			Constantes.CAMPO_ATIVIDADE_ID);

	List<Organization> listaOrganizacao = OrganizationLocalServiceUtil
			.getOrganizations(themeDisplay.getCompanyId(), 0,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

	List<Atividade> listaAtividades = listaAtividades = AtividadeUtil
				.listaAtividades(themeDisplay.getCompanyId());
%>
