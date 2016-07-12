<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/atividade/view.jsp");
	portletURL.setParameter("redirect", currentURL);

	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();

	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
	
	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		portalPrefs.setValue("atividades_order", "atividades-order-by-col", orderByCol);
		portalPrefs.setValue("atividades_order", "atividades-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("atividades_order", "atividades-order-by-col", "nome");
		orderByType = portalPrefs.getValue("atividades_order", "atividades-order-by-type", "asc");
	}

	OrderByComparator orderByComparator = AtividadesComparator.getAtividadesOrderByComparator(orderByCol,orderByType);
	List<Atividade> atividades = AtividadeUtil.search(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), keywords, orderByComparator, 
			themeDisplay.getPermissionChecker(), prefSomenteEsseSite);
%>

<%@ include file="mensagens.jspf"%>

<aui:form action="<%=portletURLString%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:input name="deleteTagIds" type="hidden" />

	<liferay-ui:search-container emptyResultsMessage="mensagem.naoExistem.atividades"
		rowChecker="<%=new RowChecker(renderResponse)%>" iteratorURL="<%=portletURL %>">

		<aui:nav-bar>
			<aui:nav>
				<c:if test='<%= permissaoAdd %>'>
					<portlet:renderURL var="addURL">
						<portlet:param name="jspPage" value="/html/atividade/cadastro.jsp" />
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
				<div class="form-search">
					<liferay-ui:input-search
						autoFocus="<%=windowState.equals(WindowState.MAXIMIZED)%>"
						placeholder='<%=LanguageUtil.get(locale, "keywords")%>' />
				</div>

			</aui:nav-bar-search>
		</aui:nav-bar>


		<liferay-ui:search-container-results>

			<%
				results = ListUtil.subList(atividades, searchContainer.getStart(), searchContainer.getEnd());
				total = atividades.size();
				
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
				
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="br.com.prodevelopment.atividade.model.Atividade"
			keyProperty="atividadeId" modelVar="atividade">

			<%@ include file="/html/atividade/colunas.jspf"%>

			<liferay-ui:search-container-column-jsp cssClass="entry-action"
				path="/html/atividade/action.jsp" />

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</aui:form>