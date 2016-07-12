<%@include file="init.jsp"%>

<script type="text/javascript">
verifica();

function verifica() {
	if (typeof jQuery == 'undefined') {
		<%@ include file="/js/exibirconteudo/jquery.js" %>
	}
}
var j = jQuery.noConflict();

j(document).ready(function() {
	var imagens = j("div.bodyContent img");
	imagens.each(function(){
		j(this).click(function(){
			showImagePopup(j(this).attr('src'), '', '', '' ,'', '', '');
		})
	});
});

</script>

<liferay-portlet:actionURL var="popupURL" windowState="pop_up"/>

<%
	JournalArticleDisplay artigoDisplay = (JournalArticleDisplay) request
			.getAttribute(Constantes.ARTIGO_DISPLAY);

boolean print = ParamUtil.getString(request, "viewMode").equals(
		Constantes.PRINT);

boolean showEditArticleIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), Constantes.UPDATE_CONTENT);
boolean showAddArticleIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), Constantes.ADD_CONTENT);
boolean showEditTemplateIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), Constantes.UPDATE_TEMPLATE);
boolean showSelectArticleIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), ActionKeys.CONFIGURATION);
boolean showIconsActions = themeDisplay.isSignedIn() && (showEditArticleIcon || showEditTemplateIcon || showSelectArticleIcon || showAddArticleIcon);

String estrutura = (String) request.getAttribute(Constantes.NOME_PARAM_ESTRUTURA);
String categoria = (String) request.getAttribute(Constantes.NOME_PARAM_CATEGORIA);
String[] categorias = StringUtil.split(categoria, ",");

String prefId = GetterUtil.getString(preferences.getValue(
		"prefId", StringPool.BLANK));
if (!currentURL.contains("?id=")) {
	currentURL = currentURL + "?id=" + prefId;
}
JournalTemplate template = null;

if (Validator.isNotNull(artigoDisplay)) {
		AssetEntryServiceUtil.incrementViewCounter(
				JournalArticle.class.getName(),
				artigoDisplay.getResourcePrimKey());
		if (Validator.isNotNull(artigoDisplay.getTemplateId())) {
			try {
				template = JournalTemplateLocalServiceUtil.getTemplate(
						artigoDisplay.getGroupId(),
						artigoDisplay.getTemplateId());
			} catch (NoSuchTemplateException nste) {
				template = JournalTemplateLocalServiceUtil.getTemplate(
						themeDisplay.getCompanyGroupId(),
						artigoDisplay.getTemplateId());
			}
		}
}
%>

<!-- inicio codigo portlet -->
<div id="exibir_conteudo">
	<c:if test="${exibirTitulo == 'S' }">
		<div class="tit_portlets">${conteudoVO.titulo}</div>
	</c:if>
	
<%@ include file="mensagem.jspf"%>

<c:if test="<%=showAddArticleIcon%>">
	<div class="adicionar">
<%
long groupId = themeDisplay.getScopeGroup().getGroupId();

String taglibId = "addNew";
taglibId = taglibId.concat("In");

%>
	<liferay-ui:icon-menu
		align="left"
		icon='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>'
		id='<%= taglibId %>'
		message='<%= LanguageUtil.format(pageContext, "add-new", new Object[] {(GroupLocalServiceUtil.getGroup(groupId)).getDescriptiveName(locale)}) %>'
		showWhenSingleIcon="<%= true %>"
	>
<%
Map<String, String> mapEstruturas = Helper.getEstruturas(liferayPortletRequest, liferayPortletResponse, estrutura);
for (Map.Entry<String, String> estrut : mapEstruturas.entrySet()) {
%>
	<liferay-portlet:renderURL
		windowState="<%=WindowState.MAXIMIZED.toString()%>"
		var="addArticleURL" portletName="<%=PortletKeys.JOURNAL%>">
		<portlet:param name="struts_action" value="/journal/edit_article" />
		<portlet:param name="portletResource"
			value="<%=portletDisplay.getId()%>" />
		<portlet:param name="redirect" value="<%=currentURL%>" />
		<portlet:param name="groupId"
			value="<%=String.valueOf(themeDisplay.getScopeGroup()
								.getGroupId())%>" />
		<portlet:param name="structureId" value="<%=estrut.getKey() %>" />
<%
Map<String, String> mapParamCategorias = Helper.getParametroCategoria(liferayPortletRequest, categorias);
for (Map.Entry<String, String> param : mapParamCategorias.entrySet()) {
%>
								<portlet:param name="<%=param.getKey() %>" value="<%=param.getValue() %>" />
<%
}
%>								
	</liferay-portlet:renderURL>
		<liferay-ui:icon image="add_article" message="<%=estrut.getValue() %>"
			url="<%=addArticleURL%>" />
<%	
}
%>		
	</liferay-ui:icon-menu>	

	</div>
</c:if>	
	
	
<%if (Validator.isNotNull(artigoDisplay)) {
%>	
	
	<div class="texto">${conteudoVO.conteudo}</div>
	<c:if test="<%= prefUsuarioDataAtualizacao %>">
		<div class="autor">
			${conteudoVO.autor }</span><span class="vertical_separator"></span><span
				class="data_alteracao">${conteudoVO.dataAlteracao}
		</div>
	</c:if>

	<c:choose>
	<c:when test="<%= print %>">
					<aui:script>
										print();
									</aui:script>
	</c:when>
	<c:otherwise>

	<c:if test="<%= prefPontuacao %>">
		<div class="taglib-ratings-wrapper">
			<liferay-ui:ratings className="<%= JournalArticle.class.getName() %>"
				classPK="<%= artigoDisplay.getResourcePrimKey() %>" />
		</div>
	</c:if>

	<c:if test="<%= prerfComentario %>">
		<br>
		<%
			int discussionMessagesCount = MBMessageLocalServiceUtil
							.getDiscussionMessagesCount(PortalUtil
									.getClassNameId(JournalArticle.class
											.getName()), artigoDisplay
									.getResourcePrimKey(),
									WorkflowConstants.STATUS_APPROVED);
		%>
		<c:if test="<%= discussionMessagesCount > 0 %>">
			<liferay-ui:header title="comments" />
		</c:if>

		<portlet:actionURL name="editarComentario" var="discussionURL" />

		<liferay-ui:discussion
			className="<%= JournalArticle.class.getName() %>"
			classPK="<%= artigoDisplay.getResourcePrimKey() %>"
			formAction="<%= discussionURL %>"
			ratingsEnabled="<%= prerfPontuacaoComentario %>"
			redirect="<%= currentURL %>"
			subject="<%= artigoDisplay.getTitle() %>"
			userId="<%= artigoDisplay.getUserId() %>" />
	</c:if>

<%@ include file="conteudosRelacionados.jsp"%>	
	
	<br/>
	<div class="acoes">
		<c:if test="<%= prefImprimir %>">
					<%
						PortletURL printPageURL = renderResponse
												.createRenderURL();

										printPageURL
												.setWindowState(LiferayWindowState.POP_UP);

										printPageURL.setParameter("struts_action",
												"/journal_content/view");
										printPageURL.setParameter("groupId",
												String.valueOf(artigoDisplay.getGroupId()));
										printPageURL.setParameter("id",
												artigoDisplay.getArticleId());
										printPageURL.setParameter("viewMode",
												Constantes.PRINT);
					%>
					<input class="aui-button-input aui-button-input-submit" type="button" onclick="<%= "javascript:" + renderResponse.getNamespace() + "printPage();" %>" value="<liferay-ui:message key="label.botao.imprimir"/>" />

					<aui:script>
										function <portlet:namespace />printPage() {
											window.open('<%=printPageURL%>', '', "directories=0,height=480,left=80,location=1,menubar=1,resizable=1,scrollbars=yes,status=0,toolbar=0,top=180,width=640");
										}
									</aui:script>
		</c:if>
	<c:if test="<%= prefEmail %>">
				<input class="aui-button-input aui-button-input-submit" type="button" onclick="javascript:showSharePageArticle('<%=popupURL%>','<%=artigoDisplay.getArticleId()%>');" value="<liferay-ui:message key="label.botao.email"/>" />
	</c:if>
	<c:if test="<%= prefVoltar %>">
		<input class="aui-button-input aui-button-input-submit" type="button" onclick="javascript:history.back();" value="<liferay-ui:message key="label.botao.voltar"/>" />
	</c:if>
	<div class="rede_social">
	<c:if test="<%= prefRsTwitter %>">
		<div class="rs_twitter">
			<a href='http://twitter.com/share' rel='nofollow' class='twitter-share-button' data-url='${urlAtual }' data-text='${conteudoVO.titulo }' data-count='horizontal'>Tweetar</a>
		</div>
	</c:if>
	<c:if test="<%= prefRsFacebook %>">
		<div class="rs_facebook">
			<div id="fb-root">
			<fb:like href="${urlAtual }" layout="button_count" width="133" show_faces="false" action="recommend" font="lucida grande" title="Compartilhar no facebook"></fb:like>
			<!--
			<fb:like href="${urlAtual }" show_faces="true" width="450" send="true"></fb:like>
			 -->
			</div>
		</div>
	</c:if>
	<c:if test="<%= prefRsLinkedIn %>">
		<div class="rs_linkedin">
			<script type="in/share" data-counter="right" data-url="${urlAtual }" ></script>
		</div>
	</c:if>
	<c:if test="<%= prefRsGoogle %>">
		<div class="rs_google">
			<div class="g-plus" data-action="share" data-annotation="bubble" data-url="${urlAtual }"></div>
		</div>
	</c:if>
	</div>
	</div>
	<c:choose>
		<c:when test="<%= showIconsActions %>">

			<div class="manutencao">
				<div class="acao">
					<c:if
						test="<%=showEditArticleIcon %>">
						<liferay-portlet:renderURL
							windowState="<%= WindowState.MAXIMIZED.toString() %>"
							var="editURL" portletName="<%= PortletKeys.JOURNAL %>">
							<portlet:param name="struts_action" value="/journal/edit_article" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="originalRedirect"
								value="<%= currentURL %>" />
							<portlet:param name="groupId"
								value="<%= String.valueOf(artigoDisplay.getGroupId()) %>" />
							<portlet:param name="articleId"
								value="<%= artigoDisplay.getArticleId() %>" />
							<portlet:param name="version"
								value="<%= String.valueOf(artigoDisplay.getVersion()) %>" />
						</liferay-portlet:renderURL>

						<liferay-ui:icon image="edit" message="edit-web-content"
							url="<%= editURL %>" />
					</c:if>
					<c:if test="<%= ((showEditTemplateIcon) && (template != null))%>">
						<liferay-portlet:renderURL
							windowState="<%= WindowState.MAXIMIZED.toString() %>"
							var="editTemplateURL" portletName="<%= PortletKeys.JOURNAL %>">
							<portlet:param name="struts_action"
								value="/journal/edit_template" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="groupId"
								value="<%= String.valueOf(template.getGroupId()) %>" />
							<portlet:param name="templateId"
								value="<%= template.getTemplateId() %>" />
						</liferay-portlet:renderURL>
						<liferay-ui:icon image="../file_system/small/xml"
							message="edit-template" url="<%= editTemplateURL %>" />
					</c:if>
					<c:if test="<%= showSelectArticleIcon %>">
						<liferay-ui:icon
							cssClass="portlet-configuration"
							image="configuration"
							message="select-web-content"
							method="get"
							onClick="<%= portletDisplay.getURLConfigurationJS() %>"
							url="<%= portletDisplay.getURLConfiguration() %>"
						/>
					</c:if>
				</div>
			</div>
		</c:when>
	</c:choose>
	</c:otherwise>
	</c:choose>
<!-- fim codigo portlet -->
<%
	}
	else {
%>
	<c:choose>
		<c:when test="<%= showIconsActions %>">

			<div class="manutencao">
				<div class="acao">
						<c:if test="<%= showSelectArticleIcon %>">
						<liferay-ui:icon
							cssClass="portlet-configuration"
							image="configuration"
							message="select-web-content"
							method="get"
							onClick="<%= portletDisplay.getURLConfigurationJS() %>"
							url="<%= portletDisplay.getURLConfiguration() %>"
						/>
					</c:if>

				</div>
			</div>
		</c:when>
	</c:choose>
<%		
	}
%>
</div>
