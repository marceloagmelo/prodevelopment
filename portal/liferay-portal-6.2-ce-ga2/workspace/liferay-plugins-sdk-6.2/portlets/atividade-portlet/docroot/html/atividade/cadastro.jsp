<%@ include file="init.jsp"%>

<%
Atividade atividade = (Atividade)request.getAttribute(Constantes.ATIVIDADE);
long atividadeId = BeanParamUtil.getLong(atividade, request, Constantes.CAMPO_ATIVIDADE_ID);
boolean existeImagem = false;
String descricao = StringPool.BLANK;
long imagemId = 0;

String labelTitulo = "label.adicionar.atividade";
if (Validator.isNotNull(atividade)) {
	imagemId = atividade.getImagemId();
	existeImagem = atividade.getExisteImagem();
	descricao = atividade.getDescricao();
	if (Constantes.VIEW.equals(acao)) {
		labelTitulo = HtmlUtil.escape(atividade.getNome(locale));
	} else {
		labelTitulo = LanguageUtil.format(pageContext, "label.alterar.atividade.x", HtmlUtil.escape(atividade.getNome(locale)));
	}
}
%>
<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%= (atividade == null) %>"
	title='<%= labelTitulo %>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION %>" value="<%=Constantes.SALVAR %>" />
</portlet:actionURL>

<aui:form action="<%= salvarURL %>" method="post" name="fm" enctype="multipart/form-data">
	<aui:input name="<%= Constantes.ACAO %>" type="hidden" value="<%= (atividadeId == 0) ? Constantes.ADD : Constantes.UPDATE %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="<%=Constantes.CAMPO_ATIVIDADE_ID %>" type="hidden" value="<%= atividadeId %>" />
	<aui:input name="<%=Constantes.CAMPO_EXISTE_IMAGEM %>" type="hidden" value="<%= existeImagem %>" />
	<aui:input name="<%=Constantes.CAMPO_IMAGEM_ID %>" type="hidden" value="<%= imagemId %>" />
<%
request.setAttribute(Constantes.CAMPO_ATIVIDADE_ID, atividadeId);
%>

<aui:model-context bean="<%= atividade %>" model="<%= Atividade.class %>" />

<aui:input name="versao" type="hidden"/>

<liferay-ui:error exception="<%= AtividadeAlteradoOutroUsuarioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.reg.alterado.outroUsuario" />
<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= AtividadeNomeObrigatorioException.class %>" focusField="<%=Constantes.CAMPO_NOME %>" message="mensagem.nome.obrigatorio" />
		<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" name="<%=Constantes.CAMPO_NOME %>" label="label.nome">
			<aui:validator name="required" />
		</aui:input>
		<aui:field-wrapper cssClass="lfr-textarea-container" label="label.descricao">
			<liferay-ui:input-localized name="<%=Constantes.CAMPO_DESCRICAO %>" type="textarea" xml="<%=descricao %>"/>
		</aui:field-wrapper>
	</aui:fieldset>
	<aui:fieldset cssClass="span5">
		<aui:input label="label.imagem" name="<%=Constantes.CAMPO_IMAGEM %>" type="file" />

		<c:if test="<%= existeImagem %>">
<%
if (!Constantes.VIEW.equals(acao)) {
%>			
			<liferay-ui:icon
				cssClass="modify-link"
				id="deleteImagemLink"
				image="delete"
				label="<%= true %>"
				url="javascript:;"
			/>
<%
}
%>	
			<div class="lfr-change-logo" id="<portlet:namespace />imagemContainer">
				<img alt="<liferay-ui:message key="logo" />" src="<%= themeDisplay.getPathImage() %>/layout_set_logo?img_id=<%= imagemId %>&t=<%= WebServerServletTokenUtil.getToken(atividade.getImagemId()) %>" />
			</div>
		</c:if>
		<c:if test="<%=(!Constantes.VIEW.equals(acao)) %>">
			<aui:button-row>
				<aui:button type="submit" />
		
				<portlet:renderURL var="cancelarURL"/>
		
				<aui:button href="<%= cancelarURL %>" value="botao.cancelar"/>
			</aui:button-row>
		</c:if>
	</aui:fieldset>
</div>
</aui:form>

<aui:script use="aui-base">
	var verSeDesabilitaCamposAtividade = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_NOME %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_DESCRICAO %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_IMAGEM %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposAtividade(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>

<aui:script use="aui-base">
	var deleteImagemLink = A.one('#<portlet:namespace />deleteImagemLink');
	var existeImagemInput = A.one('#<portlet:namespace /><%=Constantes.CAMPO_EXISTE_IMAGEM %>');
	var imagemContainer = A.one('#<portlet:namespace />imagemContainer');
	var imagemFileNameInput = A.one('#<portlet:namespace /><%=Constantes.CAMPO_IMAGEM %>');

	var changeLogo = function(event) {
		var changeLogo = (event.type == 'change');

		if (existeImagemInput) {
			existeImagemInput.val(changeLogo);
		}

		if (imagemContainer) {
			imagemContainer.hide();
		}
	};

	if (deleteImagemLink) {
		deleteImagemLink.on('click', changeLogo);
	}

	if (imagemFileNameInput) {
		imagemFileNameInput.on('change', changeLogo);
	}
</aui:script>