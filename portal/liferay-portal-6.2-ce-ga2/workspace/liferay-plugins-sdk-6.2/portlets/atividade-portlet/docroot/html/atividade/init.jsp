<%@ include file="/html/init.jsp"%>

<%@page import="br.com.prodevelopment.portlet.atividade.Constantes"%>
<%@page import="br.com.prodevelopment.portlet.atividade.util.AtividadeUtil"%>

<%@page import="br.com.prodevelopment.atividade.model.Atividade"%>

<%@page import="br.com.prodevelopment.atividade.AtividadeNomeObrigatorioException" %>
<%@page import="br.com.prodevelopment.atividade.AtividadeAlteradoOutroUsuarioException" %>
<%@page import="br.com.prodevelopment.atividade.ImagemAtividadeTamanhoException" %>

<%@page import="br.com.prodevelopment.portlet.atividade.comparator.AtividadesComparator"%>
<%
	boolean permissaoConfigFuncionario = permissionChecker
			.hasPermission(scopeGroupId, Constantes.RESOURCE_ATIVIDADE,
					scopeGroupId, ActionKeys.PERMISSIONS);
	boolean permissaoAdd = permissionChecker.hasPermission(
			scopeGroupId, Constantes.RESOURCE_ATIVIDADE, scopeGroupId,
			Constantes.PERMISSAO_ADD);
	boolean permissaoUpdate = permissionChecker.hasPermission(
			scopeGroupId, Constantes.RESOURCE_ATIVIDADE, scopeGroupId,
			ActionKeys.UPDATE);
	boolean permissaoDelete = permissionChecker.hasPermission(
			scopeGroupId, Constantes.RESOURCE_ATIVIDADE, scopeGroupId,
			ActionKeys.DELETE);

	boolean prefSomenteEsseSite = GetterUtil
			.getBoolean(preferences.getValue(
					Constantes.PREF_SOMENTE_ESSE_SITE, null));

	String nomeSite = StringPool.BLANK;
%>
