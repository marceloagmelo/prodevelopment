<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/cargo/view.jsp");
	portletURL.setParameter("redirect", currentURL);

	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();

	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
	
	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		portalPrefs.setValue("cargos_order", "cargos-order-by-col", orderByCol);
		portalPrefs.setValue("cargos_order", "cargos-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("cargos_order", "cargos-order-by-col", "nome");
		orderByType = portalPrefs.getValue("cargos_order", "cargos-order-by-type", "asc");
	}

	List<Cargo> cargos = new ArrayList<Cargo>();
	OrderByComparator orderByComparator = CargosComparator.getCargosOrderByComparator(orderByCol,orderByType);
	cargos = CargoUtil.search(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), keywords, orderByComparator, 
			themeDisplay.getPermissionChecker());
%>

<%@ include file="mensagens.jspf"%>

<aui:form action="<%=portletURLString%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:input name="deleteTagIds" type="hidden" />

	<liferay-ui:search-container emptyResultsMessage="mensagem.naoExistem.cargos"
		rowChecker="<%=new RowChecker(renderResponse)%>" iteratorURL="<%=portletURL %>">

		<aui:nav-bar>
			<aui:nav>
				<c:if test='<%= permissaoAddCargo %>'>
					<portlet:renderURL var="addURL">
						<portlet:param name="jspPage" value="/html/cargo/cadastro.jsp" />
						<portlet:param name="redirect" value="<%= Constantes.REDIRECT_VIEW_CARGO %>" />
					</portlet:renderURL>
	
					<aui:nav-item href="<%=addURL%>"
						iconCssClass="icon-plus" label="add" />
				</c:if>

				<c:if test='<%= permissaoDeleteCargo %>'>
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
									<portlet:actionURL var="deleteURL" name="deletarCargosSelecionados"/>
					
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
				results = ListUtil.subList(cargos, searchContainer.getStart(), searchContainer.getEnd());
				total = cargos.size();
				
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
				
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="br.com.prodevelopment.funcionario.model.Cargo"
			keyProperty="cargoId" modelVar="cargo">

			<%@ include file="/html/cargo/colunas.jspf"%>

			<liferay-ui:search-container-column-jsp cssClass="entry-action"
				path="/html/cargo/action.jsp" />

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</aui:form>
