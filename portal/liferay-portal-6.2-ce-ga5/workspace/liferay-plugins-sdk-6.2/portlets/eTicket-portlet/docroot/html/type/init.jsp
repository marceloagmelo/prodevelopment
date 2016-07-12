<%@ include file="/html/init.jsp"%>

<%@page
	import="br.com.prodevelopment.eticket.portlet.type.TypeTicketConstants"%>

<%@page
	import="br.com.prodevelopment.eticket.portlet.type.search.TypeTicketSearch"%>
<%@page
	import="br.com.prodevelopment.eticket.portlet.type.search.TypeTicketDisplayTerms"%>
<%@page
	import="br.com.prodevelopment.eticket.portlet.type.comparator.TypeTicketComparator"%>

<%@page import="br.com.prodevelopment.eticket.model.TypeTicket"%>

<%@page import="br.com.prodevelopment.eticket.portlet.type.util.TypeTicketUtil"%>

<%
	boolean permissaoConfigTypeTicket = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTicketConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, ActionKeys.PERMISSIONS);
	boolean permissaoAddTypeTicket = permissionChecker.hasPermission(
			scopeGroupId, TypeTicketConstants.RESOURCE_TYPE_TICKET,
			scopeGroupId, TypeTicketConstants.ADD);
	boolean permissaoDeleteTypeTicket = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTicketConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, ActionKeys.DELETE);
	boolean permissaoUpdateTypeTicket = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTicketConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, ActionKeys.UPDATE);
	
	boolean permissaoAddTypeTicketUsers = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTicketConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, TypeTicketConstants.ADD_USER);
	boolean permissaoDeleteTypeTicketUsers = permissionChecker
			.hasPermission(scopeGroupId,
					TypeTicketConstants.RESOURCE_TYPE_TICKET,
					scopeGroupId, ActionKeys.DELETE_USER);
%>