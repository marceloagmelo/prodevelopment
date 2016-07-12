<%@page import="br.com.prodevelopment.funcionario.service.CargoLocalServiceUtil"%>
<%@ include file="init.jsp"%>
<%
Funcionario funcionario = (Funcionario)request.getAttribute(Constantes.FUNCIONARIO);
long funcionarioId = BeanParamUtil.getLong(funcionario, request, Constantes.FUNCIONARIO_ID);

String cargoNome = ParamUtil.getString(request, Constantes.CAMPO_CARGO_NOME);

Cargo cargo = null;
long cargoId = BeanParamUtil.getLong(cargo, request, Constantes.CARGO_ID);

if ( (Validator.isNotNull(funcionario)) && (funcionario.getCargoId() > 0) ) {
	cargo = CargoLocalServiceUtil.fetchCargo(funcionario.getCargoId());
	if (Validator.isNotNull(cargo)) {
		cargoId = cargo.getCargoId();
		cargoNome = cargo.getNome(locale);
	}
}

String usuarioNome = ParamUtil.getString(request, Constantes.CAMPO_USUARIO_NOME);

User usuario = null;
long userId = BeanParamUtil.getLong(usuario, request, Constantes.USER_ID);

if ( (Validator.isNotNull(funcionario)) && (funcionario.getUserId() > 0) ) {
	usuario = UserLocalServiceUtil.fetchUser(funcionario.getUserId());
	if (Validator.isNotNull(usuario)) {
		userId = usuario.getUserId();
		usuarioNome = usuario.getFullName();
	}
}

//Data de entrada

String sDataEntrada = ParamUtil.getString(request, Constantes.CAMPO_DATA_ENTRADA);
if ( (Validator.isNull(sDataEntrada)) && (funcionario != null) ) {
	if (Validator.isNotNull(funcionario.getDataEntrada())) {
		sDataEntrada = DateUtil.dateToString(funcionario.getDataEntrada());
	}
}

//Data de saída
String sDataSaida = ParamUtil.getString(request, Constantes.CAMPO_DATA_SAIDA);
if ( (Validator.isNull(sDataSaida)) && (funcionario != null) ) {
	if (Validator.isNotNull(funcionario.getDataSaida())) {
		sDataSaida = DateUtil.dateToString(funcionario.getDataSaida());
	}
}

boolean ativo = false;
if (Validator.isNotNull(funcionario)) {
	ativo = funcionario.getAtivo();
}
%>
<liferay-ui:error-marker key="errorSection" value="outrosDados" />

<aui:model-context bean="<%= funcionario %>" model="<%= Funcionario.class %>" />

<h3><liferay-ui:message key="outrosDados" /></h3>

<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= FuncionarioDataEntradaInvalidaException.class %>" focusField="dataEntrada" message="mensagem.dataEntrada.invalida" />
		<aui:field-wrapper label="label.dataEntrada">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace />dataEntrada" id="<portlet:namespace />dataEntrada" value="<%=sDataEntrada%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace />dtEntrada" value="<%=sDataEntrada%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
		
		<liferay-ui:error exception="<%= FuncionarioDataSaidaInvalidaException.class %>" focusField="dataSaida" message="mensagem.dataSaida.invalida" />
		<aui:field-wrapper label="label.dataSaida">
			<c:choose>
				<c:when test="<%=!Constantes.VIEW.equals(acao) %>">
					<input type="text" name="<portlet:namespace />dataSaida" id="<portlet:namespace />dataSaida" value="<%=sDataSaida%>"/>
				</c:when>
				<c:otherwise>
					<input type="text" disabled="disabled" name="<portlet:namespace />dtSaida" value="<%=sDataSaida%>"/>
				</c:otherwise>
			</c:choose>
		</aui:field-wrapper>
	</aui:fieldset>

	<aui:fieldset cssClass="span6">
		<aui:field-wrapper helpMessage="help.cargo" label="label.cargo" >
			<aui:input name="<%=Constantes.CARGO_ID %>" type="hidden" value="<%= cargoId %>" />
			<aui:input name="<%=Constantes.CAMPO_CARGO_NOME %>" disabled="true" type="text" value="<%= cargoNome %>" label=""/>
			<c:if test="<%=!Constantes.VIEW.equals(acao) %>">
				<liferay-ui:icon
					iconCssClass="icon-search"
					id="selectCargoLink"
					linkCssClass="btn"
					message="select"
					url="javascript:;"
				/>
				<aui:button disabled="<%= Validator.isNull(cargoNome) %>" name="removeCargoButton" onClick='<%= renderResponse.getNamespace() + "removeCargo();" %>' value="remove" />			

				<aui:script use="aui-base">
					A.one('#<portlet:namespace />selectCargoLink').on(
						'click',
						function(event) {
							Liferay.Util.selectEntity(
								{
									id: '<portlet:namespace />openCargoSelector',
									title: '<%= UnicodeLanguageUtil.get(pageContext, "label.cargos") %>',
									uri: '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="jspPage" value="/html/cargo/selecione.jsp" /></liferay-portlet:renderURL>'
								},
								function(event) {
										document.<portlet:namespace />fm.<portlet:namespace />cargoId.value = event.cargoid;
										document.<portlet:namespace />fm.<portlet:namespace />cargoNome.value = event.nome;
										var A = new AUI();
										var button = A.one('#<portlet:namespace />removeCargoButton');
										Liferay.Util.toggleDisabled(button, false);
								}
							);
						}
					);
				
					Liferay.provide(
						window,
						'<portlet:namespace />removeCargo',
						function() {
							document.<portlet:namespace />fm.<portlet:namespace />cargoId.value = '0';
							document.<portlet:namespace />fm.<portlet:namespace />cargoNome.value = '';
							var A = new AUI();
							var button = A.one('#<portlet:namespace />removeCargoButton');
							Liferay.Util.toggleDisabled(button, true);
						}
					);
				</aui:script>
			</c:if>
		</aui:field-wrapper>

		<aui:field-wrapper helpMessage="help.usuario" label="label.usuario" >
			<liferay-ui:error exception="<%= FuncionarioUsuarioDuplicadoException.class %>" focusField="dataEntrada" message="mensagem.usuario.duplicado" />
			<aui:input name="<%=Constantes.USER_ID %>" type="hidden" value="<%= userId %>" />
			<aui:input name="<%=Constantes.CAMPO_USUARIO_NOME %>" disabled="true" type="text" value="<%= usuarioNome %>" label=""/>
			<c:if test="<%=!Constantes.VIEW.equals(acao) %>">
				<liferay-ui:icon
					iconCssClass="icon-search"
					id="selectUsuarioLink"
					linkCssClass="btn"
					message="select"
					url="javascript:;"
				/>
				<aui:button disabled="<%= Validator.isNull(usuarioNome) %>" name="removeUsuarioButton" onClick='<%= renderResponse.getNamespace() + "removeUsuario();" %>' value="remove" />

				<aui:script use="aui-base">
					A.one('#<portlet:namespace />selectUsuarioLink').on(
						'click',
						function(event) {
							Liferay.Util.selectEntity(
								{
									id: '<portlet:namespace />openUsuarioSelector',
									title: '<%= UnicodeLanguageUtil.get(pageContext, "label.usuarios") %>',
									uri: '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="jspPage" value="/html/usuario/selecione.jsp" /></liferay-portlet:renderURL>'
								},
								function(event) {
										document.<portlet:namespace />fm.<portlet:namespace />userId.value = event.userid;
										document.<portlet:namespace />fm.<portlet:namespace />usuarioNome.value = event.nome;
										var A = new AUI();
										var button = A.one('#<portlet:namespace />removeUsuarioButton');
										Liferay.Util.toggleDisabled(button, false);
								}
							);
						}
					);

					Liferay.provide(
						window,
						'<portlet:namespace />removeUsuario',
						function() {
							document.<portlet:namespace />fm.<portlet:namespace />userId.value = '0';
							document.<portlet:namespace />fm.<portlet:namespace />usuarioNome.value = '';
							var A = new AUI();
							var button = A.one('#<portlet:namespace />removeUsuarioButton');
							Liferay.Util.toggleDisabled(button, true);
						}
					);
				</aui:script>
			</c:if>
						
		</aui:field-wrapper>
		<c:if test="<%= funcionario != null %>">
			<aui:input label="label.ativo" name="<%=Constantes.CAMPO_ATIVO %>" type="checkbox" value="<%=ativo %>"/>
		</c:if>
	</aui:fieldset>
</div>

<aui:script use="aui-base">
	var verSeDesabilitaCamposOutrosDados = function(desabilita, edicao) {
		if (edicao) {
			A.one('#<portlet:namespace />ativoCheckbox').set('disabled', desabilita);
		}
	};

	verSeDesabilitaCamposOutrosDados(<%= (Constantes.VIEW.equals(acao)) %>, <%=(funcionario != null) %>);
</aui:script>

<script>
jQuery(document).ready(
		function() {
			jQuery("#<portlet:namespace />dataEntrada")
			.datepicker({
				showOn: 'button', 
				buttonImage: '/employee-portlet/images/calendario.png', 
				buttonImageOnly: true,
				dateFormat: 'dd/mm/yy',  
				dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sabado','Domingo'],  
				dayNamesMin: ['D','S','T','Q','Q','S','S','D'],  
				dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab','Dom'],  
				monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
				monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],  
				nextText: 'Próximo',
				prevText: 'Anterior',
				startDate: '01/01/1901'
			})
			.mask("99/99/9999");

			jQuery("#<portlet:namespace />dataSaida")
			.datepicker({
				showOn: 'button', 
				buttonImage: '/employee-portlet/images/calendario.png', 
				buttonImageOnly: true,
				dateFormat: 'dd/mm/yy',  
				dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sabado','Domingo'],  
				dayNamesMin: ['D','S','T','Q','Q','S','S','D'],  
				dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab','Dom'],  
				monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
				monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],  
				nextText: 'Próximo',
				prevText: 'Anterior',
				startDate: '01/01/1901'
			})
			.mask("99/99/9999");
});
</script>
