<%@include file="/html/init.jsp"%>
<%@include file="init.jsp"%>
<%@ include file="mensagem.jspf"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />
<form action="<%=configuracaoURL%>" method="post" name="fm">

<%String prefServico = (String)request.getAttribute("prefServico"); %>
	<fieldset>
	<legend>
		<liferay-ui:message key="label.servico" />
	</legend>
<select name="<%=Constantes.PREF_SERVICO%>">
	<option value="1" <%=prefServico.equals(Constantes.GOOGLE)?"selected":""%> ><liferay-ui:message key="label.servico.google"/></option>
	<option value="2" <%=prefServico.equals(Constantes.GLOBO)?"selected":""%> ><liferay-ui:message key="label.servico.globo"/></option>
	<option value="3" <%=prefServico.equals(Constantes.UOL)?"selected":""%> ><liferay-ui:message key="label.servico.uol"/></option>
	<option value="4" <%=prefServico.equals(Constantes.TERRA)?"selected":""%> ><liferay-ui:message key="label.servico.terra"/></option>
</select>
	</fieldset>

	<liferay-ui:panel-container id="panel-container-ultimasNoticicas" extended="true" accordion="false" >
	<liferay-ui:panel id="panel-ultimasNoticicas"
	title='<%=LanguageUtil.get(pageContext, "label.ultimasNoticicas") %>'
	collapsible="true" extended="true">
		<liferay-ui:message key="label.url.google" />
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GOOGLE_ULTIMAS_NOTICIAS%>" value="${prefUrlGoogleUltimasNoticias }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.globo" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GLOBO_ULTIMAS_NOTICIAS%>" value="${prefUrlGloboUltimasNoticias }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.uol" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_UOL_ULTIMAS_NOTICIAS%>" value="${prefUrlUolUltimasNoticias }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.terra" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_TERRA_ULTIMAS_NOTICIAS%>" value="${prefUrlTerraUltimasNoticias }" size="100" />
		</p>
	</liferay-ui:panel>
	</liferay-ui:panel-container>

	<liferay-ui:panel-container id="panel-container-noticiasInternacional" extended="true" accordion="false" >
	<liferay-ui:panel id="panel-noticiasInternacional"
	title='<%=LanguageUtil.get(pageContext, "label.noticiasInternacional") %>'
	collapsible="true" extended="true">
		<liferay-ui:message key="label.url.google" />
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GOOGLE_INTERNACIONAL%>" value="${prefUrlGoogleInternacional }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.globo" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GLOBO_INTERNACIONAL%>" value="${prefUrlGloboInternacional }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.uol" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_UOL_INTERNACIONAL%>" value="${prefUrlUolInternacional }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.terra" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_TERRA_INTERNACIONAL%>" value="${prefUrlTerraInternacional }" size="100" />
		</p>
	</liferay-ui:panel>
	</liferay-ui:panel-container>

	<liferay-ui:panel-container id="panel-container-noticiasNegocios" extended="true" accordion="false" >
	<liferay-ui:panel id="panel-noticiasNegocios"
	title='<%=LanguageUtil.get(pageContext, "label.noticiasNegocios") %>'
	collapsible="true" extended="true">
		<liferay-ui:message key="label.url.google" />
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GOOGLE_NEGOCIO%>" value="${prefUrlGoogleNegocio }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.globo" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GLOBO_NEGOCIO%>" value="${prefUrlGloboNegocio }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.uol" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_UOL_NEGOCIO%>" value="${prefUrlUolNegocio }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.terra" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_TERRA_NEGOCIO%>" value="${prefUrlTerraNegocio }" size="100" />
		</p>
	</liferay-ui:panel>
	</liferay-ui:panel-container>

	<liferay-ui:panel-container id="panel-container-noticiasSaude" extended="true" accordion="false" >
	<liferay-ui:panel id="panel-noticiasSaude"
	title='<%=LanguageUtil.get(pageContext, "label.noticiasSaude") %>'
	collapsible="true" extended="true">
		<liferay-ui:message key="label.url.google" />
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GOOGLE_SAUDE%>" value="${prefUrlGoogleSaude }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.globo" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GLOBO_SAUDE%>" value="${prefUrlGloboSaude }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.uol" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_UOL_SAUDE%>" value="${prefUrlUolSaude }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.terra" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_TERRA_SAUDE%>" value="${prefUrlTerraSaude }" size="100" />
		</p>
	</liferay-ui:panel>
	</liferay-ui:panel-container>

	<liferay-ui:panel-container id="panel-container-noticiasEsporte" extended="true" accordion="false" >
	<liferay-ui:panel id="panel-noticiasEsporte"
	title='<%=LanguageUtil.get(pageContext, "label.noticiasEsporte") %>'
	collapsible="true" extended="true">
		<liferay-ui:message key="label.url.google" />
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GOOGLE_ESPORTE%>" value="${prefUrlGoogleEsporte }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.globo" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_GLOBO_ESPORTE%>" value="${prefUrlGloboEsporte }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.uol" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_UOL_ESPORTE%>" value="${prefUrlUolEsporte }" size="100" />
		</p>
		<p>
		<liferay-ui:message key="label.url.terra" />
		</p>
		<p>
		<input type="text" name="<%=Constantes.PREF_URL_TERRA_ESPORTE%>" value="${prefUrlTerraEsporte }" size="100" />
		</p>
	</liferay-ui:panel>
	</liferay-ui:panel-container>
<br><br>
<input type="submit" value="<liferay-ui:message key="botao.salvar" />" />
</form>