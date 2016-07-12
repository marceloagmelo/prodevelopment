package br.com.prodevelopment.portlet.funcionario.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.portlet.funcionario.Constantes;
import br.com.prodevelopment.portlet.funcionario.comparator.FuncionariosComparator;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class FuncionarioSearch extends SearchContainer<Funcionario> {

	private static Log _log = LogFactoryUtil.getLog(FuncionarioSearch.class);

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add(Constantes.CAMPO_NOME);
		headerNames.add(Constantes.CAMPO_NOME_REDUZIDO);

		orderableHeaders.put(Constantes.CAMPO_NOME, Constantes.CAMPO_NOME);
		orderableHeaders.put(Constantes.CAMPO_NOME_REDUZIDO,
				Constantes.CAMPO_NOME_REDUZIDO);
	}

	public static final String EMPTY_RESULTS_MESSAGE = "mensagem.naoExistem.funcionarios";

	public FuncionarioSearch(PortletRequest portletRequest,
			PortletURL iteratorURL) {
		super(portletRequest, new FuncionarioDisplayTerms(portletRequest),
				new FuncionarioDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		FuncionarioDisplayTerms displayTerms = (FuncionarioDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(Constantes.CAMPO_NOME, displayTerms.getNome());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil
					.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest,
					"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest,
					"orderByType");

			if (Validator.isNotNull(orderByCol)
					&& Validator.isNotNull(orderByType)) {

				preferences.setValue(Constantes.PORTLET_NAME,
						"cadastro-funcionario-order-by-col", orderByCol);
				preferences.setValue(Constantes.PORTLET_NAME,
						"cadastro-funcionario-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(Constantes.PORTLET_NAME,
						"cadastro-funcionario-order-by-col", Constantes.CAMPO_NOME);
				orderByType = preferences.getValue(Constantes.PORTLET_NAME,
						"cadastro-funcionario-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = FuncionariosComparator
					.getFuncionariosOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		} catch (Exception e) {
			_log.error(e);
		}

	}
}
