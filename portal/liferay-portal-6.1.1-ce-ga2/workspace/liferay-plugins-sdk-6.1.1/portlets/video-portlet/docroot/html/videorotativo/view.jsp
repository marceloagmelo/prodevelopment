<%@include file="/html/init.jsp" %>

<%@include file="/js/videorotativo/js.jsp" %>

<%
	List<VideoVO> videos = (List<VideoVO>)request.getAttribute("videos");
%>

<div id="container_bd">
	<div id="example_6">
		<ul id="example_6_frame">
			<%for(int i = 0;i<videos.size();i++) { %>
				<li class="tumb"><a href="#"><img height="41" width="58" id="thumb<%=i%>" src="<%=videos.get(i).getUrlTumb()%>" alt="thumbnail <%=(i+1)%>" /></a></li>
			<%}%>
		</ul>
		<ul id="example_6_content">
		<%for(int i = 0;i<videos.size();i++) { %>
			<li class="example_6_item">
				<div>
					<!-- <object type="application/x-shockwave-flash" width="176" height="160" data="<%=videos.get(i).getUrlVideo()%>">
						<param name="movie" value="<%=videos.get(i).getUrlVideo()%>"/>
						<param name="allowFullScreen" value="true"/>
						<param name="allowscriptaccess" value="always"/>
						<param name="wmode" value="transparent"/> -->
				 		<embed src="<%=videos.get(i).getUrlVideo()%>&wmode=transparent"
							type="application/x-shockwave-flash"
		     		 		width="176px" height="160px"
		     		 		wmode="transparent"
		     		 		allowfullscreen="true"
		     		 		allowscriptaccess="always"
		     		 		>
		     		 	</embed>
					<!--</object>-->
				</div>
				<div class="tituloVideo"><%=videos.get(i).getTitulo()%></div>
			</li>
		<%}%>
		</ul>
	</div>
	<div class="vermais">
		&raquo;&nbsp;<a href="${urlDestino}" target="${target}"><liferay-ui:message key="ver-mais"/></a>
	</div>
</div>


<!-- Retirando a borda do portlet -->
<c:set var="pid" value="<%=portletDisplay.getInstanceId()%>"/>
<c:set var="pName" value="_videorotativo_WAR_videoportlet_INSTANCE_"/>

<style type="text/css">
#${pName}${pid} {
	border: 0px solid #C8C9CA;
}

</style>
