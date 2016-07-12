<%@ include file="/html/init.jsp"%>

<style type="text/css">
article {
	display: inline;
}

.grid {
	display: inline;
	position: relative;
}

.slider_bg {
	background: url(<%=renderRequest.getContextPath()%>/images/bannerrotativo/slider_bg.png
		) left top no-repeat;
	padding: 25px 0 19px 56px;
	overflow: hidden;
	margin-bottom: 10px;
}

.slider {
	height: 228px;
	position: relative;
}

.pagination {
	position: absolute;
	right: 60px;
	bottom: -20px;
	overflow: hidden;
	z-index: 999;
}

.pagination li {
	float: left;
	margin-left: 3px;
	list-style-type: none;
}

.pagination li:first-child {
	margin-left: 0;
}

.pagination li a {
	display: block;
	width: 18px;
	height: 18px;
	background: url(<%=renderRequest.getContextPath()%>/images/bannerrotativo/pag_nav.png
		) right top no-repeat;
}

.pagination li a:hover,.pagination .current a {
	background-position: left top;
}

.pagination .current a {
	cursor: default;
}

.items {
	display: none;
}

.banner {
	position: absolute;
	z-index: 99 !important;
	left: 234px;
	top: 13px;
	width: 410px;
	height: 200px;
	overflow: hidden;
	color: #fff;
	font-size: 15px;
	line-height: 20px;
	font-family: Arial, Helvetica, sans-serif;
}

.ban_bg {
	background:url(<%=renderRequest.getContextPath()%>/images/page1_img1.png) left 2px no-repeat;
	padding:0 0 0 73px;
	margin-bottom:8px;
}
.ban_bg strong {
	display:block;
	font-size:49px;
	line-height:59px;
	color:#b11524;
}
.ban_bg span {
	font-size:30px;
	line-height:36px;
	color:#B11524;
	display:block;
	font-weight:bold;
	margin:-7px 0 0 -2px;
}

.button {
	display:inline-block;
	font-size:14px;
	color:#fff;
	font-weight:bold;
	overflow:hidden;
	text-decoration:none;
	text-align: justify;
}

.button:hover {
	color: #EAEDF0;
}

p {margin-bottom:20px;}
.p1 {margin-bottom:15px;}

</style>

<article class="grid">
<div class="slider_bg">
	<div class="slider">
		<ul class="items">
			<c:forEach var="banner" items="${lista}">
			<li><img src="${banner.imagem}" alt="${banner.titulo}">
				<div class="banner">
					<div class="ban_bg">
						<span>${banner.titulo}</span>
					</div>
					<p class="p1">
					<c:choose>
						<c:when test="${banner.existeLink == 'S'}">
							<a href="${banner.linkDestino }" target="_blank" class="button">${banner.descricao }</a>
						</c:when>
						<c:otherwise>
							<span class="button">${banner.descricao }</span>
						</c:otherwise>
					</c:choose>
					</p>
				</div></li>
			</c:forEach>
		</ul>
	</div>
</div>
</article>

<script type="text/javascript">
jQuery(window).load(function(){
    jQuery('.slider')._TMS({
        duration:800,
        preset:'simpleFade',
        pagination:true,//'.pagination',true,'<ul></ul>'
        pagNums:false,
        slideshow:7000,
        banners:'fade',// fromLeft, fromRight, fromTop, fromBottom
        waitBannerAnimation:false
    });
});
</script>


