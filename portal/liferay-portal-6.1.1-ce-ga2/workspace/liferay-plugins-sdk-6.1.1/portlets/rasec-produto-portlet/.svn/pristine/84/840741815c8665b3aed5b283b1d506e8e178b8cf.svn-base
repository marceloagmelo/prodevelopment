<%@include file="/html/init.jsp"%>

<script type="text/javascript">

</script>

<div class="grid_6">
<ul class="tabs2">
	<li><a href="#tab_1"><span><span><liferay-ui:message key="label.destaques"/></span>
		</span>
	</a>
	</li>
</ul>

<div class="containerDestaqueProd">
	<div id="tab_1" class="conteudoDestaqueProd">

	<c:forEach var="produto" items="${produtos}">
		<div class="destaqueProduto">
			<a href="${urlDestino}?id=${produto.id}"><img class="imgDestaqueProduto" src="${produto.urlImagemPequena}" alt="" height="55" width="80px"></a>
				<div class="txtDestaqueProdudo">
					<a href="${urlDestino}?id=${produto.id}" class="link2 color-3 size-1"><strong
						style="color: black;">${produto.titulo}</strong>
					</a>
				</div>
		</div>
	</c:forEach>
	</div>

	<!-- fim da tab destaque -->

</div>
</div>