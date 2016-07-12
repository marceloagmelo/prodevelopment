<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%@ page import="com.liferay.portal.kernel.util.StringPool" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="java.util.Locale" %>

<%@ page import="br.com.prodevelopment.pesquisaopiniao.Constantes" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.vo.PesquisaVO" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.vo.PerguntaVO" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.vo.RespostaVO" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.vo.PesquisaUsuarioVO" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.vo.RespostaUsuarioVO" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.vo.PesquisaResultadoVO" %>

<%@ page import="br.com.prodevelopment.pesquisaopiniao.model.Pesquisa" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.model.Pergunta" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.model.Resposta" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario" %>
<%@ page import="br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario" %>


<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.*" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>

<%@ page import="com.liferay.portal.kernel.util.LocalizationUtil"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />
