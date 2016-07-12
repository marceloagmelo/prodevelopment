package br.com.prodevelopment.portlet.academiahorario.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.portlet.academiahorario.Constantes;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AcademiaHorarioSearch extends SearchContainer<AcademiaHorario> {

	private static Log _log = LogFactoryUtil.getLog(AcademiaHorarioSearch.class);

	static List<String> headerNames = new ArrayList<String>();
	
	static {
		headerNames.add(Constantes.CAMPO_DIA_SEMANA);
		headerNames.add(Constantes.CAMPO_ATIVIDADE_ID);
	}

	public static final String EMPTY_RESULTS_MESSAGE = "mensagem.naoExistem.funcionarios";		

	public AcademiaHorarioSearch(PortletRequest portletRequest,
			PortletURL iteratorURL) {
		super(portletRequest, new AcademiaHorarioDisplayTerms(portletRequest),
				new AcademiaHorarioDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		AcademiaHorarioDisplayTerms displayTerms = (AcademiaHorarioDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(Constantes.CAMPO_DIA_SEMANA, displayTerms.getDiaSemana());
		iteratorURL.setParameter(Constantes.CAMPO_ATIVIDADE_ID, displayTerms.getAtividadeId());
	}
}
