package br.com.prodevelopment.portlet.cliente.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.cliente.model.Cliente;
import br.com.prodevelopment.portlet.cliente.Constantes;
import br.com.prodevelopment.portlet.cliente.comparator.ClientesComparator;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ClienteSearch extends SearchContainer<Cliente> {

	private static Log _log = LogFactoryUtil.getLog(ClienteSearch.class);

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add(Constantes.CAMPO_NOME);

		orderableHeaders.put(Constantes.CAMPO_NOME, Constantes.CAMPO_NOME);
	}

	public static final String EMPTY_RESULTS_MESSAGE = "mensagem.naoExistem.clientes";

	public ClienteSearch(PortletRequest portletRequest,
			PortletURL iteratorURL) {
		super(portletRequest, new ClienteDisplayTerms(portletRequest),
				new ClienteDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		ClienteDisplayTerms displayTerms = (ClienteDisplayTerms) getDisplayTerms();

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
						"cadastro-cliente-order-by-col", orderByCol);
				preferences.setValue(Constantes.PORTLET_NAME,
						"cadastro-cliente-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(Constantes.PORTLET_NAME,
						"cadastro-cliente-order-by-col", Constantes.CAMPO_NOME);
				orderByType = preferences.getValue(Constantes.PORTLET_NAME,
						"cadastro-cliente-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = ClientesComparator
					.getClientesOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		} catch (Exception e) {
			_log.error(e);
		}

	}
}
