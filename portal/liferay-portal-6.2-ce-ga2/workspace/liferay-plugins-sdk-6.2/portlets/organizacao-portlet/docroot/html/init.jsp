<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page	import="com.liferay.portlet.PortletConfigFactoryUtil"%>
<%@page	import="com.liferay.portlet.PortletInstanceFactoryUtil"%>
<%@page	import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page	import="com.liferay.portlet.PortletSetupUtil"%>
<%@page	import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>

<%@page import="com.liferay.portal.util.PortletKeys"%>

<%@page import="br.com.prodevelopment.portlet.organizacao.util.OrganizacaoUtil"%>
<%@page import="com.liferay.portal.model.Organization" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	PortletPreferences preferences = renderRequest.getPreferences();

	PortletMode portletMode = liferayPortletRequest.getPortletMode();
	WindowState windowState = liferayPortletRequest.getWindowState();

	PortletURL currentURLObj = PortletURLUtil.getCurrent(
			liferayPortletRequest, liferayPortletResponse);

	String currentURL = currentURLObj.toString();

	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil
			.getPortalPreferences(request);

	String backURL = ParamUtil.getString(request, "backURL");
%>
