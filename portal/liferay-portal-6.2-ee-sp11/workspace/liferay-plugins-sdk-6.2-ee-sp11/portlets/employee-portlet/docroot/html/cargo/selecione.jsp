<%@ include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "openCargoSelector");
	String target = ParamUtil.getString(request, "target");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("eventName", eventName);
	portletURL.setParameter("target", target);
	portletURL.setParameter("jspPage", "/html/cargo/selecione.jsp");
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


<aui:form action="<%=portletURLString%>"  method="post" name="openCargoSelectorFm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />

	<liferay-ui:search-container emptyResultsMessage="mensagem.naoExistem.cargos" iteratorURL="<%=portletURL %>">

		<aui:nav-bar>
			<aui:nav>
				<portlet:renderURL var="addURL">
					<portlet:param name="jspPage" value="/html/cargo/cadastro.jsp" />
					<portlet:param name="redirect" value="<%= Constantes.REDIRECT_SELECIONE_CARGO %>" />
				</portlet:renderURL>

				<aui:nav-item href="<%=addURL%>"
					iconCssClass="icon-plus" label="add" />

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

			<liferay-ui:search-container-column-text name="label.nome" buffer="buffer">
			<%
			buffer.append(cargo.getNome(locale));
			%>	
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text>
				<%
				Map<String, Object> data = new HashMap<String, Object>();

				data.put("cargoid", cargo.getCargoId());
				data.put("nome", HtmlUtil.escapeAttribute(cargo.getNome(locale)));
				%>

				<aui:button cssClass="selector-button" data="<%= data %>" value="choose" />
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	var Util = Liferay.Util;

	A.one('#<portlet:namespace />openCargoSelectorFm').delegate(
		'click',
		function(event) {
			var result = Util.getAttributes(event.currentTarget, 'data-');

			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);
			
			Util.getWindow().hide();
		},
		'.selector-button'
	);
</aui:script>