<%@ include file="init.jsp"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/academiahorario/view.jsp");
	portletURL.setParameter("redirect", currentURL);

	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
%>

<%@ include file="mensagens.jspf"%>

<aui:form action="<%=portletURLString%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:input name="deleteTagIds" type="hidden" />

	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="<%=Constantes.CAMPO_DIA_SEMANA %>" value="<%= diaDaSemana %>" />
		<portlet:param name="<%=Constantes.CAMPO_ATIVIDADE_ID %>" value="<%= atividadeId %>" />
		<portlet:param name="jspPage" value="/html/academiahorario/view.jsp" />
	</liferay-portlet:renderURL>

	<liferay-ui:search-container displayTerms="<%= new DisplayTerms(renderRequest) %>"
		emptyResultsMessage="mensagem.naoExistem.horarios" rowChecker="<%=new RowChecker(renderResponse) %>"
		headerNames="diaSemana,atividadeId"
		iteratorURL="<%= iteratorURL %>">
<%
DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
		<aui:nav-bar>
			<aui:nav>
				<c:if test='<%= permissaoAdd %>'>
					<portlet:renderURL var="addURL">
						<portlet:param name="jspPage" value="/html/academiahorario/cadastro.jsp" />
					</portlet:renderURL>
	
					<aui:nav-item href="<%=addURL%>"
						iconCssClass="icon-plus" label="add" />
				</c:if>

				<c:if test='<%= permissaoDelete %>'>
					<aui:nav-item cssClass="hide" dropdown="<%=true%>"
						id="tagsActionsButton" label="actions">
						<aui:nav-item cssClass="item-remove" iconCssClass="icon-remove"
							id="deleteSelectedTags" label="delete" />
					</aui:nav-item>

					<aui:script use="aui-base,liferay-util-list-fields">
						A.one('#<portlet:namespace /><%=searchContainerReference.getId()%>SearchContainer').delegate(
							'click',
							function() {
								var hide = (Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace /><%=RowChecker.ALL_ROW_IDS%>').length == 0);
					
								A.one('#<portlet:namespace />tagsActionsButton').toggle(!hide);
							},
							'input[type=checkbox]'
						);
					
						A.one('#<portlet:namespace />deleteSelectedTags').on(
							'click',
							function() {
								if (confirm('<liferay-ui:message
							key="are-you-sure-you-want-to-delete-this" />')) {
									<portlet:actionURL var="deleteURL" name="<%=Constantes.DELETAR_SELECIONADOS %>"/>
					
									document.<portlet:namespace />fm.method = "post";
									document.<portlet:namespace />fm.<portlet:namespace />deleteTagIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
									
									submitForm(document.<portlet:namespace />fm, '<%=deleteURL%>');
								}
							}
						);
					</aui:script>
					
				</c:if>

			</aui:nav>
			<aui:nav-bar-search cssClass="pull-right">
				<liferay-ui:search-form
					page="/html/academiahorario/search.jsp"
					servletContext="<%= application %>"
				/>

			</aui:nav-bar-search>
		</aui:nav-bar>


		<liferay-ui:search-container-results>

			<%
			long groupId = 0;
			if (prefSomenteEsseSite) {
				groupId = themeDisplay.getScopeGroupId();
			}
			if (displayTerms.isAdvancedSearch()) {
				
				results = AcademiaHorarioUtil.search(themeDisplay.getCompanyId(), groupId, diaDaSemana, atividadeId, displayTerms.isAndOperator(), themeDisplay.getPermissionChecker());
				total = results.size();

				searchContainer.setTotal(total);
			}
			else {
				String keywords = displayTerms.getKeywords();
				results = AcademiaHorarioUtil.search(themeDisplay.getCompanyId(), groupId, keywords, themeDisplay.getPermissionChecker());
				total = results.size();

				searchContainer.setTotal(total);
			}

			searchContainer.setResults(results);
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="br.com.prodevelopment.academiahorario.model.AcademiaHorario"
			keyProperty="academiaHorarioId" modelVar="academiaHorario">

			<%@ include file="/html/academiahorario/colunas.jspf"%>

			<liferay-ui:search-container-column-jsp cssClass="entry-action"
				path="/html/academiahorario/action.jsp" />

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />

	</liferay-ui:search-container>
</aui:form>