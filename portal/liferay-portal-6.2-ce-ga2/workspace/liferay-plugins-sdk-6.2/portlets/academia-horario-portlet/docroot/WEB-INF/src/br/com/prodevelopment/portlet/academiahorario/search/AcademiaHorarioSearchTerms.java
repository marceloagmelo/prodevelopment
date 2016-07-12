package br.com.prodevelopment.portlet.academiahorario.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.portlet.academiahorario.Constantes;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;


public class AcademiaHorarioSearchTerms extends AcademiaHorarioDisplayTerms {

	public AcademiaHorarioSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		diaSemana = DAOParamUtil.getString(portletRequest, Constantes.CAMPO_DIA_SEMANA);
		atividadeId = DAOParamUtil.getString(portletRequest, Constantes.CAMPO_ATIVIDADE_ID);
	}
	
}
