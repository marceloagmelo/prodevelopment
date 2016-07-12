<%@ include file="/html/init.jsp"%>

<%@include file="/js/bannerrotativo/js_banner03.jsp"%>
<script type="text/javascript">
	
<%@ include file="/js/bannerrotativo/jquery.tools.js" %>
	
</script>


<style type="text/css">
#prev {
	background: #ffffff;
	/*padding-top: 5px;*/
}

#prev_but {
	float: right;
	padding-bottom: 10px;
	padding-right: 10px;
}

#prev_but ul {
	padding-left: 0px;
	padding-top: 5px;
	margin: 0px;
	list-style: none;
}

#prev_but li {
	display: inline;
}

#prev_but a {
	display: block;
	float: left;
	width: 15px;
	height: 14px;
	background: url(<%=renderRequest.getContextPath()%>/images/bannerrotativo/grande03/prev_but.png
		) no-repeat left;
	margin-right: 5px;
}

#prev_but a:hover,#prev_but .active {
	background: url(<%=renderRequest.getContextPath()%>/images/bannerrotativo/grande03/prev_but_hov.png
		) no-repeat center;
}

.item {
	width: 946px;
	height: 258px;
	/*padding-left: 5px;*/
}

.item img {
	float: left;
}

.item h2 {
	border: none;
	margin-bottom: 15px;
}

.scrollable {
	position: relative;
	overflow: hidden;
	width: 946px;
	height: 258px;
	border-bottom: 8px solid #DEB349;
	padding-bottom: 2px;
}

.scrollable .items {
	width: 20000em;
	position: absolute;
}

.scrollable .items div {
	float: left;
}

.scrollable .items .item {
	overflow: hidden;
}

.scrollable .items .item p {
	line-height: 16px;
}

.navi {
	width: auto;
	height: 20px;
	float: right;
	margin: 5px 0;
	padding-right: 20px;
}

.navi a {
	width: 17px;
	cursor: pointer;
	height: 14px;
	float: left;
	margin: 0 0 0 1px;
	background: url(<%=renderRequest.getContextPath()%>/images/bannerrotativo/grande03/prev_but.png
		) no-repeat scroll right top;
	display: block;
	font-size: 1px;
}

.navi a:hover,.navi a.active {
	background-position: left top;
	margin: 0 0 0 1px;
	background: url(<%=renderRequest.getContextPath()%>/images/bannerrotativo/grande03/prev_but_hov.png
		) no-repeat scroll right top
}

.bannerrotativo_03_imagem,.bannerrotativo_03_imagem img {
	width: 946px;
	height: 258px;
}
</style>

<div id="prev">

	<div class="scrollable">
		<div class="items">
			<c:forEach var="banners" items="${lista}">
				<div class="item">
					<a href="${banners.linkDestino}">
						<div class="bannerrotativo_03_imagem">
							<img src="${banners.imagem}" title="${banners.titulo}"
								id="${banners.idBanner}" alt="${banners.titulo}" />
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
		<!-- items -->
	</div>
	<!-- scrollable -->
	<div class="navi"></div>
	<!-- create automatically the point dor the navigation depending on the numbers of items -->

	<div style="clear: both"></div>
</div>