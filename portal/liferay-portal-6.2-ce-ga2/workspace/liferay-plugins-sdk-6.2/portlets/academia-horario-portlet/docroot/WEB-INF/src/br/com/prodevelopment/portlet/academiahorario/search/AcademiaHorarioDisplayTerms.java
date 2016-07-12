package br.com.prodevelopment.portlet.academiahorario.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.portlet.academiahorario.Constantes;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class AcademiaHorarioDisplayTerms extends DisplayTerms {
	
	public AcademiaHorarioDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		diaSemana = ParamUtil.getString(portletRequest, Constantes.CAMPO_DIA_SEMANA);
		atividadeId = ParamUtil.getString(portletRequest, Constantes.CAMPO_ATIVIDADE_ID);
	}
	
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getAtividadeId() {
		return atividadeId;
	}
	public void setAtividadeId(String atividadeId) {
		this.atividadeId = atividadeId;
	}

	protected String diaSemana;
	protected String atividadeId;
}
