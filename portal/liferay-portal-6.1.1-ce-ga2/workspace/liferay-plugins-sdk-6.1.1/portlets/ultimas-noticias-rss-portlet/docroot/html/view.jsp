<%@include file="/html/init.jsp"%>

<ul class="tabs">
	<li style="z-index: 100;" class="active"><a href="#tab1"><span><span><liferay-ui:message
						key="label.ultimasNoticicas" />
			</span>
		</span>
	</a>
	</li>
	<c:if test="${temNoticiaInternacional == 'S' }">
	<li style="z-index: 99;"><a href="#tab2"><span><span><liferay-ui:message
						key="label.noticiasInternacional" />
			</span>
		</span>
	</a>
	</li>
	</c:if>
	<c:if test="${temNoticiaNegocio == 'S' }">
	<li style="z-index: 99;"><a href="#tab3"><span><span><liferay-ui:message
						key="label.noticiasNegocios" />
			</span>
		</span>
	</a>
	</li>
	</c:if>
	<c:if test="${temNoticiaSaude == 'S' }">
	<li style="z-index: 99;"><a href="#tab4"><span><span><liferay-ui:message
						key="label.noticiasSaude" />
			</span>
		</span>
	</a>
	</li>
	</c:if>
	<c:if test="${temNoticiaEsporte == 'S' }">
	<li style="z-index: 99;"><a href="#tab5"><span><span><liferay-ui:message
						key="label.noticiasEsporte" />
			</span>
		</span>
	</a>
	</li>
	</c:if>
</ul>
<div class="tab_container">
	<div class="tab_content" id="tab1" style="display: block;">
		<div class="wrapper margin-bot1">
			<div class="col-1 margin-right">
				<ul class="ul-2">
					<c:forEach var="ultimaNoticias_1" items="${ultimasNoticias_1}">
						<li>${ultimaNoticias_1.titulo }
							<p class="p0">
								<a class=ultimas_noticias_leia_mais
									href="${ultimaNoticias_1.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-1">
				<ul class="ul-2">
					<c:forEach var="ultimaNoticias_2" items="${ultimasNoticias_2}">
						<li>${ultimaNoticias_2.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${ultimaNoticias_2.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<c:if test="${temNoticiaInternacional == 'S' }">
	<div class="tab_content" id="tab2" style="display: none;">
		<div class="wrapper margin-bot1">
			<div class="col-1 margin-right">
				<ul class="ul-2">
					<c:forEach var="noticiaInternacional_1"
						items="${noticiasInternacional_1}">
						<li>${noticiaInternacional_1.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${noticiaInternacional_1.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-1">
				<ul class="ul-2">
					<c:forEach var="noticiaInternacional_2"
						items="${noticiasInternacional_2}">
						<li>${noticiaInternacional_2.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${noticiaInternacional_2.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${temNoticiaNegocio == 'S' }">
	<div class="tab_content" id="tab3" style="display: none;">
		<div class="wrapper margin-bot1">
			<div class="col-1 margin-right">
				<ul class="ul-2">
					<c:forEach var="noticiaNegocio_1"
						items="${noticiasNegocio_1}">
						<li>${noticiaNegocio_1.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${noticiaNegocio_1.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-1">
				<ul class="ul-2">
					<c:forEach var="noticiaNegocio_2"
						items="${noticiasNegocio_2}">
						<li>${noticiaNegocio_2.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${noticiaNegocio_2.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${temNoticiaSaude == 'S' }">
	<div class="tab_content" id="tab4" style="display: none;">
		<div class="wrapper margin-bot1">
			<div class="col-1 margin-right">
				<ul class="ul-2">
					<c:forEach var="noticiaSaude_1"
						items="${noticiasSaude_1}">
						<li>${noticiaSaude_1.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${noticiaSaude_1.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-1">
				<ul class="ul-2">
					<c:forEach var="noticiaSaude_2"
						items="${noticiasSaude_2}">
						<li>${noticiaSaude_2.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${noticiaSaude_2.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${temNoticiaEsporte == 'S' }">
	<div class="tab_content" id="tab5" style="display: none;">
		<div class="wrapper margin-bot1">
			<div class="col-1 margin-right">
				<ul class="ul-2">
					<c:forEach var="noticiaEsporte_1"
						items="${noticiasEsporte_1}">
						<li>${noticiaEsporte_1.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${noticiaEsporte_1.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-1">
				<ul class="ul-2">
					<c:forEach var="noticiaEsporte_2"
						items="${noticiasEsporte_2}">
						<li>${noticiaEsporte_2.titulo }
							<p class="p0">
								<a
									class="ultimas_noticias_leia_mais"
									href="${noticiaEsporte_2.link }" target="_blank"><liferay-ui:message
										key="label.leiaMais" />&nbsp;&raquo;</a>
							</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	</c:if>
</div>
