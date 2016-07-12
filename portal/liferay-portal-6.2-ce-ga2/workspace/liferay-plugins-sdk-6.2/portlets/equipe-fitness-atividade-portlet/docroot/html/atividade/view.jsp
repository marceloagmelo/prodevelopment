<%@ include file="init.jsp"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/atividade/view.jsp");
	portletURL.setParameter("redirect", currentURL);

	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();

	List<Atividade> atividades = AtividadeUtil.search(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	
	if (atividades.size() > 0) { 
		int contadorReg = 0;
		int contadorCampo = 1;
		boolean existeAtividade = false;
		Map<String, List<Atividade>> mapAtividades = new TreeMap<String, List<Atividade>>();
		List<Atividade> lista = null;
		for (Atividade atividade : atividades) {
			contadorReg++;
			existeAtividade = true;
			if (contadorReg > prefQuantidadeItens) {
				contadorReg = 1;
				contadorCampo++;
				mapAtividades.put(Helper.zerosEsquerda(String.valueOf(contadorCampo), 2), lista);
			}
			if (contadorReg == 1) {
				lista = new ArrayList<Atividade>();
			}
			lista.add(atividade);
		}
		if (contadorReg <= prefQuantidadeItens) {
			contadorCampo++;
			mapAtividades.put(Helper.zerosEsquerda(String.valueOf(contadorCampo), 2), lista);
		}
		Collection< List<Atividade>> colecaoAtividades = mapAtividades.values();
%>

<div id="atividadeSlide">
	<%
		for (List<Atividade> lst : colecaoAtividades) {
	%>
	<div class="carousel-item">
		<%
			for (Atividade atividade : lst) {
		%>
				<liferay-portlet:renderURL var="horariosURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="<%=Constantes.CAMPO_ATIVIDADE_ID %>" value="<%=String.valueOf(atividade.getAtividadeId()) %>" />
					<portlet:param name="jspPage" value="/html/atividade/horarios.jsp" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
				</liferay-portlet:renderURL>
		<%						
				String taglibURL = "javascript:" + renderResponse.getNamespace() + "verHorarios("+atividade.getAtividadeId()+")";
				String taglibHorariosURL = "javascript:Liferay.Util.openWindow({id: '" + renderResponse.getNamespace() + "verHorarios', title: '" + UnicodeLanguageUtil.get(pageContext, "label.horarios") + "', uri:'" + HtmlUtil.escapeURL(horariosURL.toString()) + "'});";				
		%>
		<div class="subitem">
			<span class="subitem_img"><img
				src="<%=themeDisplay.getPathImage()%>/layout_set_logo?img_id=<%=atividade.getImagemId()%>&t=<%=WebServerServletTokenUtil.getToken(atividade
							.getImagemId())%>"
				alt="<%=atividade.getNomeCurrentValue()%>" /></span>
			<span class="subitem_info">
				<span class="nome">
					<%=atividade.getNomeCurrentValue() %>
				</span>
				<span class="ver-horario">
					<a href="<%= taglibHorariosURL %>"><liferay-ui:message
							key="label.verHorarios" />&nbsp;&raquo;</a>
				</span>
				
			</span>
		</div>
		<%
			}
		%>
	</div>
	<%
		}
	%>
</div>

<script type="text/javascript">
	AUI().use('aui-carousel', function(A) {
		var component = new A.Carousel({
			activeIndex : 0,
			contentBox : '#atividadeSlide',
			height : 180,
			intervalTime : <%=prefIntervaloSegundos%>,
		}).render();
	});
</script>
<%} %>
