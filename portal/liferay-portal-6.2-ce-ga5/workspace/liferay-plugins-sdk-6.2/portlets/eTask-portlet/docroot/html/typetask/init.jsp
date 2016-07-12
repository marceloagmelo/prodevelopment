<%@ include file="/html/init.jsp" %>

<%@page
	import="br.com.prodevelopment.etask.portlet.typetask.TypeTaskConstants" %>

<%@page
	import="br.com.prodevelopment.etask.portlet.typetask.search.TypeTaskSearch" %>
<%@page
	import="br.com.prodevelopment.etask.portlet.typetask.search.TypeTaskDisplayTerms" %>
<%@page
	import="br.com.prodevelopment.etask.portlet.typetask.comparator.TypeTaskComparator" %>
<%@page
	import="br.com.prodevelopment.etask.model.TypeTask" %>
<%@page
	import="br.com.prodevelopment.etask.portlet.typetask.util.TypeTaskUtil" %>
<%@page
	import="br.com.prodevelopment.etask.portlet.typetask.util.TypeTaskUsersUtil" %>

<%@page
	import="com.liferay.portlet.dynamicdatamapping.StructureDuplicateStructureKeyException" %>
<%@page
	import="br.com.prodevelopment.etask.RequiredTypeTaskNameException" %>
<%@page
	import="com.liferay.portlet.dynamicdatamapping.StructureXsdException" %>
	

<%
	boolean permissaoConfigTypeTask = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTaskConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, ActionKeys.PERMISSIONS);
	boolean permissaoAddTypeTask = permissionChecker.hasPermission(
			scopeGroupId, TypeTaskConstants.RESOURCE_TYPE_TICKET,
			scopeGroupId, TypeTaskConstants.ADD);
	boolean permissaoDeleteTypeTask = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTaskConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, ActionKeys.DELETE);
	boolean permissaoUpdateTypeTask = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTaskConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, ActionKeys.UPDATE);
	/*
	boolean permissaoAdminTypeTaskUsers = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTaskConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, TypeTaskConstants.ADMIN_USER);
	*/
%>