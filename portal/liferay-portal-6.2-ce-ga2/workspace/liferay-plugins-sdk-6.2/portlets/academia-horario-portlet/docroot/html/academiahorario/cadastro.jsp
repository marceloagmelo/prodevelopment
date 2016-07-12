<%@ include file="init.jsp"%>

<%
	AcademiaHorario academiaHorario = (AcademiaHorario) request
			.getAttribute(Constantes.ACADEMIA_HORARIO);
	long academiaHorarioId = BeanParamUtil.getLong(academiaHorario,
			request, Constantes.CAMPO_ACADEMIA_HORARIO_ID);
	boolean existeImagem = false;
	String selHoraInicial = BeanParamUtil.getString(academiaHorario,
			request, Constantes.CAMPO_HORA_INICIAL);
	String selHoraFinal = BeanParamUtil.getString(academiaHorario,
			request, Constantes.CAMPO_HORA_FINAL);
	long imagemId = 0;
	String selDiaDaSemana = "0";
	String labelTitulo = "label.adicionar.academiaHorario";
	if (Validator.isNotNull(academiaHorario)) {
		selDiaDaSemana = String.valueOf(academiaHorario.getDiaSemana());
		selHoraInicial = academiaHorario.getHoraInicial();
		selHoraFinal = academiaHorario.getHoraFinal();
		pageContext.setAttribute("selAtividadeId",
				String.valueOf(academiaHorario.getAtividadeId()));
		pageContext.setAttribute("selGroupId",
				String.valueOf(academiaHorario.getGroupId()));
		labelTitulo = LanguageUtil.get(pageContext,
				"label.alterar.academiaHorario");
	}
	String selMinutoIni = "00";
	String selMinutoFim = "00";
	String selHoraIni = "00";
	String selHoraFim = "00";
	if (Validator.isNotNull(selHoraInicial)) {
    	String[] horaInicio = selHoraInicial.split(StringPool.COLON);
    	selHoraIni = horaInicio[0];
    	selMinutoIni = horaInicio[1];
	}
	if (Validator.isNotNull(selHoraFinal)) {
    	String[] horaFim = selHoraFinal.split(StringPool.COLON);
    	selHoraFim = horaFim[0];
    	selMinutoFim = horaFim[1];
	}
%>
<liferay-ui:header backURL="<%=backURL%>" escapeXml="<%=false%>"
	localizeTitle="<%=(academiaHorario == null)%>"
	title='<%=labelTitulo%>' />

<portlet:actionURL var="salvarURL">
	<portlet:param name="<%=Constantes.PORTLET_ACTION%>"
		value="<%=Constantes.SALVAR%>" />
</portlet:actionURL>

<aui:form action="<%=salvarURL%>" method="post" name="fm">
	<aui:input name="<%=Constantes.ACAO%>" type="hidden"
		value="<%=(academiaHorarioId == 0) ? Constantes.ADD
						: Constantes.UPDATE%>" />
	<aui:input name="backURL" type="hidden" value="<%=backURL%>" />
	<aui:input name="<%=Constantes.CAMPO_ACADEMIA_HORARIO_ID%>"
		type="hidden" value="<%=academiaHorarioId%>" />
	<%
		request.setAttribute(Constantes.CAMPO_ACADEMIA_HORARIO_ID,
					academiaHorarioId);
	%>

	<aui:model-context bean="<%=academiaHorario%>"
		model="<%=AcademiaHorario.class%>" />

	<aui:input name="versao" type="hidden" />

	<liferay-ui:error
		exception="<%=AcademiaHorarioAlteradoOutroUsuarioException.class%>"
		focusField="<%=Constantes.CAMPO_DIA_SEMANA %>"
		message="mensagem.reg.alterado.outroUsuario" />
	<div class="row-fluid">
		<aui:fieldset cssClass="span6">
<%
if (!prefSomenteEsseSite) {
%>		
			<aui:select label="label.nomeSite"
				name="<%=Constantes.CAMPO_GROUP_ID%>">
				<aui:option label="label.selecione"
					selected="${'0' eq selGroupId}" value="0" />
				<c:forEach items="<%=listaOrganizacao%>" var="cboGroup">
					<aui:option label="${cboGroup.name }"
						selected="${cboGroup.groupId eq selGroupId}"
						value="${cboGroup.groupId }" />
				</c:forEach>
			</aui:select>
<%
}
%>			
			<aui:select label="label.atividade"
				name="<%=Constantes.CAMPO_ATIVIDADE_ID%>">
				<aui:option label="label.selecione"
					selected="${'0' eq selAtividadeId}" value="0" />
				<c:forEach items="<%=listaAtividades%>" var="cboAtividade">
					<aui:option label="${cboAtividade.nomeCurrentValue }"
						selected="${cboAtividade.atividadeId eq selAtividadeId}"
						value="${cboAtividade.atividadeId }" />
				</c:forEach>
			</aui:select>
			<liferay-ui:error
				exception="<%=AcademiaHorarioDiaSemanaObrigatorioException.class%>"
				focusField="<%=Constantes.CAMPO_DIA_SEMANA %>"
				message="mensagem.diaSemana.obrigatorio" />
			<aui:select
				autoFocus="<%=windowState.equals(WindowState.MAXIMIZED)%>"
				label="label.diaSemana" name="<%=Constantes.CAMPO_DIA_SEMANA%>">
				<aui:option label="label.selecione"
					selected='<%="0".equals(selDiaDaSemana)%>' value="0" />
				<%
					for (String dia : AcademiaHorarioUtil.valoresDiasDaSemana) {
									pageContext.setAttribute("diaDaSemana", String
											.valueOf(AcademiaHorarioUtil
													.getDiaDaSemana(Integer
															.parseInt(dia) - 1)));
				%>
				<aui:option label="${diaDaSemana }"
					selected="<%=dia.equals(selDiaDaSemana) %>" value="<%=dia %>" />
				<%
					}
				%>
			</aui:select>
		</aui:fieldset>
		<aui:fieldset cssClass="span5">
			<liferay-ui:error
				exception="<%=AcademiaHorarioHoraInicialMaiorQueFinalException.class%>"
				focusField="<%=Constantes.CAMPO_HORA_INICIAL%>"
				message="mensagem.horaInicial.maiorQueFinal" />
			<liferay-ui:error
				exception="<%=AcademiaHorarioHoraInicialIgualFinalException.class%>"
				focusField="<%=Constantes.CAMPO_HORA_INICIAL%>"
				message="mensagem.horaInicial.igualFinal" />
			<aui:field-wrapper label="label.horaInicial">
				<liferay-ui:input-time minuteInterval="<%=prefIntervaloMinuto %>"
					name="<%=Constantes.CAMPO_HORA_INICIAL%>"
					minuteParam="<%=Constantes.CAMPO_MINUTO_INI%>"
					amPmParam="<%=Constantes.CAMPO_AMPM_INI%>"
					hourParam="<%=Constantes.CAMPO_HORA_INI%>" 
					minuteValue="<%=GetterUtil.getInteger(selMinutoIni) %>"
					hourValue="<%=GetterUtil.getInteger(selHoraIni) %>"
					amPmValue="<%= Calendar.PM %>"/>
			</aui:field-wrapper>
			<liferay-ui:error
				exception="<%=AcademiaHorarioHoraFinalObrigatoriaException.class%>"
				focusField="<%=Constantes.CAMPO_HORA_INICIAL%>"
				message="mensagem.horaFinal.obrigatoria" />
			<aui:field-wrapper label="label.horaFinal">
				<liferay-ui:input-time minuteInterval="<%=prefIntervaloMinuto %>"
					name="<%=Constantes.CAMPO_HORA_FINAL%>"
					minuteParam="<%=Constantes.CAMPO_MINUTO_FIM%>"
					amPmParam="<%=Constantes.CAMPO_AMPM_FIM%>"
					hourParam="<%=Constantes.CAMPO_HORA_FIM%>" 
					minuteValue="<%=GetterUtil.getInteger(selMinutoFim) %>"
					hourValue="<%=GetterUtil.getInteger(selHoraFim) %>"
					amPmValue="<%= Calendar.PM %>"/>

			</aui:field-wrapper>
			<c:if test="<%=(!Constantes.VIEW.equals(acao))%>">
				<aui:button-row>
					<aui:button type="submit" />

					<portlet:renderURL var="cancelarURL" />

					<aui:button href="<%=cancelarURL%>" value="botao.cancelar" />
				</aui:button-row>
			</c:if>
		</aui:fieldset>
	</div>
</aui:form>

<aui:script use="aui-base">
	var verSeDesabilitaCamposAcademiaHorario = function(desabilita) {
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_DIA_SEMANA %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_ATIVIDADE_ID %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_HORA_INICIAL %>').set('disabled', desabilita);
		A.one('#<portlet:namespace /><%=Constantes.CAMPO_HORA_FINAL %>').set('disabled', desabilita);
	};

	verSeDesabilitaCamposAcademiaHorario(<%= (Constantes.VIEW.equals(acao)) %>);
</aui:script>
