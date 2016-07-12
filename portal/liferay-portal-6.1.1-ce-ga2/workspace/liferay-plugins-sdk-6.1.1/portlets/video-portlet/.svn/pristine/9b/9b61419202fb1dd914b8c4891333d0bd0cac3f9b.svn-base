<%@ include file="/html/init.jsp" %>

<%
	List<VideoVO> videos = (List<VideoVO>)request.getAttribute("videos");
%>

<div id="container_bd">
	<br />
	<div id="example_6" style="height: 193px;">
		<ul id="example_6_content" style="margin-top: 0;">
		<%for(int i = 0;i<videos.size();i++) { %>
			<li class="example_6_item">
				<div>
					<embed src="<%=videos.get(i).getUrlVideo()%>&wmode=transparent"
							type="application/x-shockwave-flash"
		     		 		width="178px" height="160px"
		     		 		wmode="transparent"
		     		 		allowfullscreen="true"
		     		 		allowscriptaccess="always"
		     		 		>
		     		 </embed>
				</div>
				<div class="tituloVideo"><%=videos.get(i).getTitulo()%></div>
			</li>

		<%}%>
		</ul>
	</div>
	<div class="vermais">
		<a href="${urlDestino}" target="${target}"><liferay-ui:message key="ver-mais"/></a>
	</div>
</div>

<!-- Retirando a borda do portlet -->
<c:set var="pid" value="<%=portletDisplay.getInstanceId()%>"/>
<c:set var="pName" value="portlet_videorotativo_WAR_videoportlet_INSTANCE_"/>

<style type="text/css">
#${pName}${pid} {
	border: 0px solid #C8C9CA;
}

</style>
