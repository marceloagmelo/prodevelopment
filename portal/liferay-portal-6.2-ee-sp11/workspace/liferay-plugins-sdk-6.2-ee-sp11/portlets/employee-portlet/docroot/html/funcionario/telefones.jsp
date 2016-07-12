<%@ include file="init.jsp"%>

<%
String className = (String)request.getAttribute("telefones.className");
long classPK = (Long)request.getAttribute("telefones.classPK");

long companyId = themeDisplay.getCompanyId();

List<Telefone> telefones = Collections.emptyList();

int[] telefonesIndexes = null;

String telefonesIndexesParam = ParamUtil.getString(request, "telefonesIndexes");

if (Validator.isNotNull(telefonesIndexesParam)) {
	telefones = new ArrayList<Telefone>();

	telefonesIndexes = StringUtil.split(telefonesIndexesParam, 0);

	for (int telefonesIndex : telefonesIndexes) {
		telefones.add(TelefoneUtil.getTelefone());
	}
}
else {

	if (classPK > 0) {
		telefones = TelefoneUtil.getTelefones(companyId, classPK);

		telefonesIndexes = new int[telefones.size()];

		for (int i = 0; i < telefones.size() ; i++) {
			telefonesIndexes[i] = i;
		}
	}

	if (telefones.isEmpty()) {
		telefones = new ArrayList<Telefone>();

		telefones.add(TelefoneUtil.getTelefone());

		telefonesIndexes = new int[] {0};
	}

	if (telefonesIndexes == null) {
		telefonesIndexes = new int[0];
	}
}
String paramTelefonesIndexes = StringUtil.merge(telefonesIndexes);
%>

<liferay-ui:error-marker key="errorSection" value="telefones" />

<h3><liferay-ui:message key="telefones" /></h3>

<div class="alert alert-info">
	<liferay-ui:message key="aviso.cadastro.telefone" />
</div>

<liferay-ui:error exception="<%= TelefoneTipoObrigatotioException.class %>" message="mensagem.tipoTelefone.obrigatorio" />
<liferay-ui:error exception="<%= TelefoneDDDObrigatotioException.class %>" message="mensagem.dddTelefone.obrigatorio" />
<liferay-ui:error exception="<%= TelefoneDDDInvalidoException.class %>" message="mensagem.dddTelefone.invalido" />
<liferay-ui:error exception="<%= TelefoneNumeroObrigatotioException.class %>" message="mensagem.numeroTelefone.obrigatorio" />
<liferay-ui:error exception="<%= TelefoneNumeroInvalidoException.class %>" message="mensagem.numeroTelefone.invalido" />
<aui:fieldset>
	<aui:input name="paramTelefonesIndexes" type="hidden" value="<%= paramTelefonesIndexes %>" />
	<%
	for (int i = 0; i < telefonesIndexes.length; i++) {
		int telefonesIndex = telefonesIndexes[i];

		Telefone telefone = telefones.get(i);
	%>

		<aui:model-context bean="<%= telefone %>" model="<%= Telefone.class %>" />

		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields">

				<aui:input name='<%= "telefoneId" + telefonesIndex %>' type="hidden" value="<%= telefone.getTelefoneId() %>" />

				<aui:select inlineField="<%= true %>" label="label.tipo" name='<%= "tipoTelefone" + telefonesIndex %>' id='<%= "tipoTelefone" + telefonesIndex %>' onClick="teste(this)">
					<aui:option value="0" label=""/>
					<aui:option value="1" label="label.tipoTelefone.residencial" selected="<%=telefone.getTipo() == 1%>"/>
					<aui:option value="2" label="label.tipoTelefone.comercial" selected="<%=telefone.getTipo() == 2%>"/>
					<aui:option value="3" label="label.tipoTelefone.celular" selected="<%=telefone.getTipo() == 3%>"/>
					<aui:option value="4" label="label.tipoTelefone.radio" selected="<%=telefone.getTipo() == 4%>"/>
				</aui:select>

				<aui:input checked="<%= telefone.isPrincipal()%>" id='<%= "telefonePrincipal" + telefonesIndex %>' inlineField="<%= true %>" label="label.principal" name="telefonePrincipal" type="radio" value="<%= telefonesIndex %>"/>
				
				<aui:input fieldParam='<%= "ddi" + telefonesIndex %>' id='<%= "ddi" + telefonesIndex %>' name="ddi" label="label.ddi"/>

				<aui:input fieldParam='<%= "ddd" + telefonesIndex %>' id='<%= "ddd" + telefonesIndex %>' inlineField="<%= true %>" name="ddd" label="label.ddd" />
				
				<aui:input inlineField="<%= true %>" fieldParam='<%= "numeroTelefone" + telefonesIndex %>' id='<%= "numeroTelefone" + telefonesIndex %>' name="numero" label="label.numero"/>

				<aui:input fieldParam='<%= "ramal" + telefonesIndex %>' id='<%= "ramal" + telefonesIndex %>' inlineField="<%= true %>" name="ramal" label="label.ramal"/>
				
			</div>
		</div>
		
		<script>
			function teste(valor) {
			}
		</script>

	<%
	}
	%>

	<aui:input name="telefonesIndexes" type="hidden" value="<%= StringUtil.merge(telefonesIndexes) %>" />
</aui:fieldset>

<aui:script use="aui-base">
	var verSeDesabilitaCamposTelefone = function(desabilita) {
		var paramTelefonesIndexes = A.one('#<portlet:namespace/>paramTelefonesIndexes').get('value');
		var arrayOfStrings = paramTelefonesIndexes.split(',');
		
		for (i = 0; i < arrayOfStrings.length; i++) {
			var valor = A.one('#<portlet:namespace/>tipoTelefone'+arrayOfStrings[i]).get('value');
			var campoTipo = '#<portlet:namespace/>tipoTelefone'+arrayOfStrings[i];
			var campoPrincipal = '#<portlet:namespace/>telefonePrincipal'+arrayOfStrings[i];
			var campoDdi = '#<portlet:namespace/>ddi'+arrayOfStrings[i];
			var campoDdd = '#<portlet:namespace/>ddd'+arrayOfStrings[i];
			var campoNumero = '#<portlet:namespace/>numeroTelefone'+arrayOfStrings[i];
			var campoRamal = '#<portlet:namespace/>ramal'+arrayOfStrings[i];
			A.one(campoTipo).set('disabled', desabilita);
			A.one(campoPrincipal).set('disabled', desabilita);
			A.one(campoDdi).set('disabled', desabilita);
			A.one(campoDdd).set('disabled', desabilita);
			A.one(campoNumero).set('disabled', desabilita);
			A.one(campoRamal).set('disabled', desabilita);
		}
	};

	verSeDesabilitaCamposTelefone(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>

<aui:script use="liferay-auto-fields">
	Liferay.once(
		'formNavigator:reveal<portlet:namespace />telefones',
		function() {
			new Liferay.AutoFields(
				{
					contentBox: '#<portlet:namespace />telefones > fieldset',
					fieldIndexes: '<portlet:namespace />telefonesIndexes',
					namespace: '<portlet:namespace />'
				}
			).render();
		}
	);
</aui:script>
