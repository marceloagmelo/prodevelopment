<%@ include file="init.jsp"%>

<%
String className = (String)request.getAttribute("enderecoEmail.className");
long classPK = (Long)request.getAttribute("enderecoEmail.classPK");

long companyId = themeDisplay.getCompanyId();

List<EnderecoEmail> enderecosEmail = Collections.emptyList();

int[] enderecosEmailIndexes = null;

String enderecosEmailIndexesParam = ParamUtil.getString(request, "enderecosEmailIndexes");

if (Validator.isNotNull(enderecosEmailIndexesParam)) {
	enderecosEmail = new ArrayList<EnderecoEmail>();

	enderecosEmailIndexes = StringUtil.split(enderecosEmailIndexesParam, 0);

	for (int enderecosEmailIndex : enderecosEmailIndexes) {
		enderecosEmail.add(EnderecoEmailUtil.getEnderecoEmail());
	}
}
else {

	if (classPK > 0) {
		enderecosEmail = EnderecoEmailUtil.getEnderecosEmail(companyId, classPK);

		enderecosEmailIndexes = new int[enderecosEmail.size()];

		for (int i = 0; i < enderecosEmail.size() ; i++) {
			enderecosEmailIndexes[i] = i;
		}
	}

	if (enderecosEmail.isEmpty()) {
		enderecosEmail = new ArrayList<EnderecoEmail>();

		enderecosEmail.add(EnderecoEmailUtil.getEnderecoEmail());

		enderecosEmailIndexes = new int[] {0};
	}

	if (enderecosEmailIndexes == null) {
		enderecosEmailIndexes = new int[0];
	}
}
String paramEnderecosEmailIndexes = StringUtil.merge(enderecosEmailIndexes);
%>

<liferay-ui:error-marker key="errorSection" value="enderecosEmail" />

<h3><liferay-ui:message key="enderecosEmail" /></h3>

<div class="alert alert-info">
	<liferay-ui:message key="aviso.cadastro.enderecoEmail" />
</div>

<liferay-ui:error exception="<%= EnderecoEmailTipoObrigatotioException.class %>" message="mensagem.tipoEnderecoEmail.obrigatorio" />
<liferay-ui:error exception="<%= EnderecoEmailEnderecoObrigatotioException.class %>" message="mensagem.enderecoEnderecoEmail.obrigatorio" />
<liferay-ui:error exception="<%= EnderecoEmailEnderecoInvalidoException.class %>" message="mensagem.enderecoEnderecoEmail.invalido" />
<aui:fieldset>
	<aui:input name="paramEnderecosEmailIndexes" type="hidden" value="<%= paramEnderecosEmailIndexes %>" />
	<%
	for (int i = 0; i < enderecosEmailIndexes.length; i++) {
		int enderecosEmailIndex = enderecosEmailIndexes[i];

		EnderecoEmail enderecoEmail = enderecosEmail.get(i);
	%>

		<aui:model-context bean="<%= enderecoEmail %>" model="<%= EnderecoEmail.class %>" />

		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields">

				<aui:input name='<%= "enderecoEmailId" + enderecosEmailIndex %>' type="hidden" value="<%= enderecoEmail.getEnderecoEmailId() %>" />

				<aui:select inlineField="<%= true %>" label="label.tipo" name='<%= "tipoEnderecoEmail" + enderecosEmailIndex %>' id='<%= "tipoEnderecoEmail" + enderecosEmailIndex %>'>
					<aui:option value="0" label=""/>
					<aui:option value="1" label="label.tipoEnderecoEmail.pessoal" selected="<%=enderecoEmail.getTipo() == 1%>"/>
					<aui:option value="2" label="label.tipoEnderecoEmail.trabalho" selected="<%=enderecoEmail.getTipo() == 2%>"/>
				</aui:select>

				<aui:input checked="<%= enderecoEmail.isPrincipal()%>" id='<%= "enderecoEmailPrincipal" + enderecosEmailIndex %>' inlineField="<%= true %>" label="label.principal" name="enderecoEmailPrincipal" type="radio" value="<%= enderecosEmailIndex %>"/>
				
				<aui:input fieldParam='<%= "enderecoEmailEndereco" + enderecosEmailIndex %>' id='<%= "enderecoEmailEndereco" + enderecosEmailIndex %>' name="endereco" label="label.enderecoEmail"/>
				
			</div>
		</div>
	<%
	}
	%>

	<aui:input name="enderecosEmailIndexes" type="hidden" value="<%= StringUtil.merge(enderecosEmailIndexes) %>" />
</aui:fieldset>

<aui:script use="aui-base">
	var verSeDesabilitaCamposEnderecoEmail = function(desabilita) {
		var paramEnderecosEmailIndexes = A.one('#<portlet:namespace/>paramEnderecosEmailIndexes').get('value');
		var arrayOfStrings = paramEnderecosEmailIndexes.split(',');
		
		for (i = 0; i < arrayOfStrings.length; i++) {
			var campoTipo = '#<portlet:namespace/>tipoEnderecoEmail'+arrayOfStrings[i];
			var campoPrincipal = '#<portlet:namespace/>enderecoEmailPrincipal'+arrayOfStrings[i];
			var campoEndereco = '#<portlet:namespace/>enderecoEmailEndereco'+arrayOfStrings[i];
			A.one(campoTipo).set('disabled', desabilita);
			A.one(campoPrincipal).set('disabled', desabilita);
			A.one(campoEndereco).set('disabled', desabilita);
		}
	};

	verSeDesabilitaCamposEnderecoEmail(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>

<aui:script use="liferay-auto-fields">
	Liferay.once(
		'formNavigator:reveal<portlet:namespace />enderecosEmail',
		function() {
			new Liferay.AutoFields(
				{
					contentBox: '#<portlet:namespace />enderecosEmail > fieldset',
					fieldIndexes: '<portlet:namespace />enderecosEmailIndexes',
					namespace: '<portlet:namespace />'
				}
			).render();
		}
	);
</aui:script>
