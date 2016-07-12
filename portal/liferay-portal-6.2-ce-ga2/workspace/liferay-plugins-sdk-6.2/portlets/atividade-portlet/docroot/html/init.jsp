<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<%@page	import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page	import="com.liferay.portal.kernel.bean.BeanPropertiesUtil"%>
<%@page	import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page	import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page	import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page	import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page	import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page	import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page	import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page	import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page	import="com.liferay.portal.kernel.language.LanguageWrapper"%>
<%@page	import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page	import="com.liferay.portal.kernel.log.Log"%>
<%@page	import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page	import="com.liferay.portal.kernel.log.LogUtil"%>
<%@page	import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page	import="com.liferay.portal.kernel.portlet.LiferayPortletRequest"%>
<%@page	import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page	import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page	import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page	import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page	import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page	import="com.liferay.portal.kernel.search.SearchResultUtil"%>
<%@page	import="com.liferay.portal.kernel.search.Sort"%>
<%@page	import="com.liferay.portal.kernel.search.SortFactoryUtil"%>
<%@page	import="com.liferay.portal.kernel.servlet.PortalMessages"%>
<%@page	import="com.liferay.portal.kernel.servlet.ServletContextPool"%>
<%@page	import="com.liferay.portal.kernel.servlet.ServletContextUtil"%>
<%@page	import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page	import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page	import="com.liferay.portal.kernel.upload.UploadException"%>
<%@page	import="com.liferay.portal.kernel.util.Constants"%>
<%@page	import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page	import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page	import="com.liferay.portal.kernel.util.Http"%>
<%@page	import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page	import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page	import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page	import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@page	import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page	import="com.liferay.portal.kernel.util.OrderedProperties"%>
<%@page	import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page	import="com.liferay.portal.kernel.util.PrefsParamUtil"%>
<%@page	import="com.liferay.portal.kernel.util.PropertiesParamUtil"%>
<%@page	import="com.liferay.portal.kernel.util.PropertiesUtil"%>
<%@page	import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page	import="com.liferay.portal.kernel.util.StringPool"%>
<%@page	import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>

<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>

<%@ page import="javax.portlet.MimeResponse"%><%@
page
	import="javax.portlet.PortletConfig"%><%@
page
	import="javax.portlet.PortletContext"%><%@
page
	import="javax.portlet.PortletException"%><%@
page
	import="javax.portlet.PortletMode"%><%@
page
	import="javax.portlet.PortletPreferences"%><%@
page
	import="javax.portlet.PortletRequest"%><%@
page
	import="javax.portlet.PortletResponse"%><%@
page
	import="javax.portlet.PortletURL"%><%@
page
	import="javax.portlet.ResourceURL"%><%@
page
	import="javax.portlet.WindowState"%>

<%@page import="com.liferay.portal.theme.ThemeDisplay"%><%@
page
	import="com.liferay.portal.util.Portal"%><%@
page
	import="com.liferay.portal.util.PortalUtil"%><%@
page
	import="com.liferay.portal.util.PortletCategoryKeys"%><%@
page
	import="com.liferay.portal.util.PortletKeys"%><%@
page
	import="com.liferay.portal.util.SessionClicks"%><%@
page
	import="com.liferay.portal.util.comparator.PortletCategoryComparator"%><%@
page
	import="com.liferay.portal.util.comparator.PortletTitleComparator"%><%@
page
	import="com.liferay.portal.webserver.WebServerServletTokenUtil"%><%@
page
	import="com.liferay.portlet.InvokerPortlet"%><%@
page
	import="com.liferay.portlet.PortalPreferences"%><%@
page
	import="com.liferay.portlet.PortletConfigFactoryUtil"%><%@
page
	import="com.liferay.portlet.PortletInstanceFactoryUtil"%><%@
page
	import="com.liferay.portlet.PortletPreferencesFactoryUtil"%><%@
page
	import="com.liferay.portlet.PortletSetupUtil"%><%@
page
	import="com.liferay.portlet.PortletURLFactoryUtil"%><%@
page
	import="com.liferay.portlet.PortletURLUtil"%>

<%@page	import="com.liferay.portal.kernel.util.WebKeys"%>

<%@page import="br.com.prodevelopment.portlet.atividade.util.GroupUtil" %>

<%@page	import="com.liferay.portal.security.permission.ActionKeys"%>

<%@page	import="com.liferay.portal.kernel.util.Validator"%>



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
	String acao = ParamUtil.getString(request, "acao");
%>