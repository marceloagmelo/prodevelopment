<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page	import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page	import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page	import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>

<%@
page import="com.liferay.portal.NoSuchUserException" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.messaging.DestinationNames" %><%@
page import="com.liferay.portal.kernel.messaging.MessageBusUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.portal.model.Contact" %><%@
page import="com.liferay.portal.model.Group" %><%@
page import="com.liferay.portal.model.GroupConstants" %><%@
page import="com.liferay.portal.model.Layout" %><%@
page import="com.liferay.portal.model.LayoutConstants" %><%@
page import="com.liferay.portal.model.Organization" %><%@
page import="com.liferay.portal.model.Portlet" %><%@
page import="com.liferay.portal.model.User" %><%@
page import="com.liferay.portal.security.permission.ActionKeys" %><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil" %><%@
page import="com.liferay.portal.service.LayoutLocalServiceUtil" %><%@
page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %><%@
page import="com.liferay.portal.service.PortletLocalServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.service.permission.UserPermissionUtil" %><%@
page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portal.util.PortletKeys" %><%@
page import="com.liferay.portal.util.comparator.UserLoginDateComparator" %><%@
page import="com.liferay.portal.webserver.WebServerServletTokenUtil" %><%@
page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %><%@
page import="com.liferay.portlet.blogs.service.BlogsStatsUserLocalServiceUtil" %><%@
page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil" %><%@
page import="com.liferay.portlet.messageboards.service.MBStatsUserLocalServiceUtil" %><%@
page import="com.liferay.portlet.social.model.SocialActivity" %><%@
page import="com.liferay.portlet.social.model.SocialRelationConstants" %><%@
page import="com.liferay.portlet.social.model.SocialRequestConstants" %><%@
page import="com.liferay.portlet.social.service.SocialActivityLocalServiceUtil" %><%@
page import="com.liferay.portlet.social.service.SocialRelationLocalServiceUtil" %><%@
page import="com.liferay.portlet.social.service.SocialRequestLocalServiceUtil" %><%@
page import="com.liferay.util.portlet.PortletProps" %>

<%@page import="com.liferay.portal.model.LayoutTypePortletConstants" %>

<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %>

<%@page import="java.util.Locale" %>
<%@page import="java.util.Iterator" %>
<%@ page import="com.liferay.portal.kernel.search.Field"%>

<%@page import="com.liferay.portlet.asset.model.AssetEntry" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>

<%@ page import="java.text.Format" %><%@
page import="java.text.NumberFormat" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.LinkedHashMap" %><%@
page import="java.util.List" %>

<%@ page import="com.liferay.portlet.PortletURLUtil"%>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="com.liferay.portal.kernel.util.StringUtil"%>

<%@ page import="com.liferay.portal.kernel.util.UnicodeProperties"%>

<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portlet.journal.model.JournalStructure" %>

<%@ page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>

<%@ page import="com.liferay.portlet.asset.service.AssetEntryServiceUtil"%>
<%@ page import="com.liferay.portlet.journal.model.JournalTemplate"%>
<%@ page import="com.liferay.portlet.journal.NoSuchTemplateException"%>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ page import="javax.portlet.ActionRequest" %><%@
page import="javax.portlet.PortletPreferences" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker" %>

<%@ page import="java.util.Map"%>
<%@page import="java.util.Set" %>

<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>

<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%>

<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"%>

<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil"%>

<%@ page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@ page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@ page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
PortletPreferences preferences = renderRequest.getPreferences();

//WindowState windowState = null;
//PortletMode portletMode = null;

//PortletURL currentURLObj = null;

PortletMode portletMode = liferayPortletRequest.getPortletMode();
WindowState windowState = liferayPortletRequest.getWindowState();

PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);

String currentURL = currentURLObj.toString();

/*
if (renderRequest != null) {
	windowState = renderRequest.getWindowState();
	portletMode = renderRequest.getPortletMode();

	currentURLObj = PortletURLUtil.getCurrent(renderRequest,
			renderResponse);
} else if (resourceRequest != null) {
	windowState = resourceRequest.getWindowState();
	portletMode = resourceRequest.getPortletMode();
}
*/

//String currentURL = PortalUtil.getCurrentURL(request);

Portlet portlet = (Portlet) request
		.getAttribute(WebKeys.RENDER_PORTLET);

String portletId = portlet.getPortletId();

Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

String backURL = ParamUtil.getString(request, "backURL");

String portletResource = ParamUtil.getString(request, "portletResource");

boolean defaultAssetPublisher = false;

UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();
String defaultAssetPublisherPortletId = typeSettingsProperties.getProperty(LayoutTypePortletConstants.DEFAULT_ASSET_PUBLISHER_PORTLET_ID, StringPool.BLANK);

if (defaultAssetPublisherPortletId.equals(portletDisplay.getId()) || (Validator.isNotNull(defaultAssetPublisherPortletId) && defaultAssetPublisherPortletId.equals(portletResource))) {
	defaultAssetPublisher = true;
}

long[] groupIds =  new long[] { themeDisplay.getScopeGroupId() };
long[] classNameIds =  new long[] { PortalUtil.getClassNameId(JournalArticle.class) };
%>
