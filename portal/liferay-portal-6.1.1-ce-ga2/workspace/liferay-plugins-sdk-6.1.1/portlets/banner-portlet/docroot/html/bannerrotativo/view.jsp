<%@ include file="/html/init.jsp" %>

<style type="text/css">

/* bottom center */
#${portletId}  .ws_bullets {
	bottom: -24px;
	left: 50%;
}

#${portletId}  .ws_bullets div {
	left: -50%;
}

#${portletId} .ws_bullets .ws_bulframe {
	bottom: 20px;
}

#${portletId} {
	zoom: 1;
	position: relative;
	width: ${widthBanner + 10}px;
	height: ${heightBanner + 10}px;
	margin: 0 auto 5px auto;
	z-index: 0;
}

#${portletId} .ws_frame {
	display: block;
	position: absolute;
	left: 5px;
	top: 5px;
	width: 944px;
	height: 344px;
	border: solid 8px black;
	opacity: 0.3;
	filter: progid : DXImageTransform.Microsoft.Alpha ( opacity = 30 );
}

#${portletId} .ws_shadow {
	width: 100%;
	height: 93px;
	position: absolute;
	left: 0;
	bottom: -37px;
	z-index: -1;
}

#${portletId} .ws_images {
	position: absolute;
	left: 5px;
	top: 0px;
	width: ${widthBanner}px;
	height: ${heightBanner}px;
	overflow: hidden;
}

#${portletId} .ws_images a {
	color: transparent;
}

#${portletId} .ws_images img {
	top: 0;
	left: 0;
	border: none 0;
}

#${portletId} a {
	text-decoration: none;
	outline: none;
	border: none;
}

#${portletId}  .ws_bullets {
	font-size: 0px;
	padding: 10px;
	float: left;
	position: absolute;
	z-index: 70;
}

#${portletId}  .ws_bullets div {
	position: relative;
	float: left;
}

#${portletId} .ws_bullets a {
	margin: 0;
	width: 16px;
	height: 15px;
	background: url(<%=renderRequest.getContextPath()%>/images/bannerrotativo/bullet.png) left top;
	float: left;
	text-indent: -1000px;
	position: relative;
}

#${portletId} .ws_bullets a:hover {
	background-position: -16px 0;
}

#${portletId} .ws_bullets a.ws_selbull {
	background-position: right top;
}

#${portletId} .ws_bullets a.ws_overbull {
	background-position: 50% top;
}

#${portletId} .ws_bullets a:hover {
	background-position: 50% top;
}

#${portletId} a.ws_next,#${portletId} a.ws_prev {
	position: absolute;
	display: block;
	top: 50%;
	margin-top: -22px;
	z-index: 60;
	height: 40px;
	width: 21px;
	background-image: url(<%=renderRequest.getContextPath()%>/images/bannerrotativo/arrows.png);
}

#${portletId} a.ws_next {
	background-position: 100% 0;
	right: -16px;
}

#${portletId} a.ws_prev {
	left: -16px;
	background-position: 0 0;
}

#${portletId} .ws-title {
	position: absolute;
	bottom: 18px;
	left: 18px;
	margin-right: 23px;
	z-index: 50;
	padding: 5px;
	color: #FFF;
	background: #000;
	font-family: Tahoma, Arial, Helvetica;
	font-size: 14px;
	opacity: 0.6;
	filter: progid : DXImageTransform.Microsoft.Alpha ( opacity = 80 );
}

#${portletId} .ws-title div {
	padding-top: 5px;
	font-size: 12px;
}

#${portletId} .ws_bullets  a img {
	text-indent: 0;
	display: block;
	bottom: 15px;
	left: -120px;
	visibility: hidden;
	position: absolute;
	-moz-box-shadow: 0 0 5px #999999;
	box-shadow: 0 0 5px #999999;
	border: 5px solid #FFFFFF;
}

#${portletId} .ws_bullets a:hover img {
	visibility: visible;
}

#${portletId} .ws_bulframe div div {
	height: 90px;
	overflow: visible;
	position: relative;
}

#${portletId} .ws_bulframe div {
	left: 0;
	overflow: hidden;
	position: relative;
	width: 220px;
}

#${portletId}  .ws_bullets .ws_bulframe {
	display: none;
	overflow: visible;
	position: absolute;
	cursor: pointer;
	-moz-box-shadow: 0 0 5px #999999;
	box-shadow: 0 0 5px #999999;
	border: 5px solid #FFFFFF;
}

#${portletId} .ws_bulframe span {
	display: block;
	position: absolute;
	bottom: -11px;
	margin-left: -5px;
	left: 120px;
	background: url(./triangle.png);
	width: 15px;
	height: 6px;
}

</style>


<div id="${portletId}">
	<div class="ws_images">
		<c:forEach var="banners" items="${lista}">
			<a href="${banners.linkDestino}"><img src="${banners.imagem}" title="${banners.titulo}" id="${banners.idBanner}" alt="${banners.titulo}"/></a>
		</c:forEach>
	</div>
	<c:if test="${exibirControles}">
	<div class="ws_bullets">
		<div>
			<c:forEach var="banners" items="${lista}">
				<a href="#"><img height="90" width="220" src="${banners.imagem}"/></a>
			</c:forEach>
		</div>
	</div>
	</c:if>
</div>
<%@include file="/js/bannerrotativo/js.jsp"%>
