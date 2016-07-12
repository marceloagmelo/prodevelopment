package br.com.prodevelopment.etask.portlet.typetask.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.portlet.typetask.TypeTaskConstants;
import br.com.prodevelopment.etask.portlet.typetask.comparator.TypeTaskComparator;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class TypeTaskSearch extends SearchContainer<TypeTask> {
	private static Log _log = LogFactoryUtil.getLog(TypeTaskSearch.class);

	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		orderableHeaders.put(TypeTaskConstants.NAME, TypeTaskConstants.NAME);
	}

	public static final String EMPTY_RESULTS_MESSAGE = "notFound-typetasks";

	public TypeTaskSearch(PortletRequest portletRequest, PortletURL iteratorURL, List<String> headerNames) {
		super(portletRequest, new TypeTaskDisplayTerms(portletRequest),
				new TypeTaskDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		TypeTaskDisplayTerms displayTerms = (TypeTaskDisplayTerms) getDisplayTerms();

		iteratorURL
				.setParameter(TypeTaskConstants.NAME, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil
					.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest,
					"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest,
					"orderByType");

			if (Validator.isNotNull(orderByCol)
					&& Validator.isNotNull(orderByType)) {

				preferences.setValue(TypeTaskConstants.PORTLET_NAME,
						"cadastro-typetask-order-by-col", orderByCol);
				preferences.setValue(TypeTaskConstants.PORTLET_NAME,
						"cadastro-typetask-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(
						TypeTaskConstants.PORTLET_NAME,
						"cadastro-typetask-order-by-col",
						TypeTaskConstants.NAME);
				orderByType = preferences.getValue(
						TypeTaskConstants.PORTLET_NAME,
						"cadastro-typetask-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = TypeTaskComparator
					.getTypeTaskOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		} catch (Exception e) {
			_log.error(e);
		}

	}
}
