<%@ include file="/html/init.jsp"%>

<%@page
	import="br.com.prodevelopment.equipefitness.portlet.usuario.lista.Constantes"%>
<%@page	import="br.com.prodevelopment.equipefitness.portlet.usuario.util.UsuarioUtil"%>

<%
	String prefCategorias = GetterUtil.getString(preferences.getValue(
			Constantes.PREF_CATEGORIAS_IDS, StringPool.BLANK));
%>