<%@include file="/html/init.jsp"%>

<%@ page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil" %><%@
page import="com.liferay.portlet.asset.NoSuchEntryException" %><%@
page import="com.liferay.portlet.asset.model.AssetEntry" %><%@
page import="com.liferay.portlet.asset.model.AssetLink" %><%@
page import="com.liferay.portlet.asset.model.AssetRenderer" %><%@
page import="com.liferay.portlet.asset.model.AssetRendererFactory" %><%@
page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetEntryServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil" %>

<%@page import=" com.liferay.portlet.PortletURLFactory" %>
<%@page import=" com.liferay.portlet.PortletURLFactoryUtil" %>
<%@page import=" com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletRequest" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %>

<%@page import="br.com.prodevelopment.conteudo.util.Helper" %>
<%@ page import="br.com.prodevelopment.conteudo.exibir.Constantes" %>

<%
boolean prefVoltar = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_VOLTAR, null));
boolean prefEmail = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_EMAIL, null));
boolean prefImprimir = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_IMPRIMIR, null));
boolean prefPontuacao = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_PONTUACAO, null));
boolean prerfComentario = Constantes.JOURNAL_ARTICLE_COMMENTS_ENABLED && GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_COMENTARIO, null));
boolean prerfPontuacaoComentario = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_PONTUACAO_COMENTARIO, null));
boolean prefUsuarioDataAtualizacao = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_USUARIO_DATA_ATUALIZACAO, null));
boolean prefRsFacebook = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_RS_FACEBOOK, null));
boolean prefRsTwitter = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_RS_TWITTER, null));
boolean prefRsLinkedIn = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_RS_LINKEDIN, null));
boolean prefRsGoogle = GetterUtil.getBoolean(preferences.getValue(Constantes.PREF_RS_GOOGLE, null));
%>

