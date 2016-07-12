package br.com.prodevelopment.eticket.portlet.type.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.portlet.type.TypeTicketConstants;
import br.com.prodevelopment.eticket.portlet.type.comparator.TypeTicketComparator;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class TypeTicketSearch extends SearchContainer<TypeTicket> {
	private static Log _log = LogFactoryUtil.getLog(TypeTicketSearch.class);

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add(TypeTicketConstants.CAMPO_NAME);

		orderableHeaders.put(TypeTicketConstants.CAMPO_NAME, TypeTicketConstants.CAMPO_NAME);
	}

	public static final String EMPTY_RESULTS_MESSAGE = "mensagem-naoExistem-typetickets";

	public TypeTicketSearch(PortletRequest portletRequest,
			PortletURL iteratorURL) {
		super(portletRequest, new TypeTicketDisplayTerms(portletRequest),
				new TypeTicketDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		TypeTicketDisplayTerms displayTerms = (TypeTicketDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(TypeTicketConstants.CAMPO_NAME, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil
					.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest,
					"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest,
					"orderByType");

			if (Validator.isNotNull(orderByCol)
					&& Validator.isNotNull(orderByType)) {

				preferences.setValue(TypeTicketConstants.PORTLET_NAME,
						"cadastro-typeticket-order-by-col", orderByCol);
				preferences.setValue(TypeTicketConstants.PORTLET_NAME,
						"cadastro-typeticket-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(TypeTicketConstants.PORTLET_NAME,
						"cadastro-typeticket-order-by-col", TypeTicketConstants.CAMPO_NAME);
				orderByType = preferences.getValue(TypeTicketConstants.PORTLET_NAME,
						"cadastro-typeticket-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = TypeTicketComparator
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
