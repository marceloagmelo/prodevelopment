package br.com.prodevelopment.portlet.atividade.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AtividadesComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getAtividadesOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new AtividadeNomeComparator(orderByAsc);
		} else if (orderByCol.equals("nome")) {
			orderByComparator = new AtividadeNomeComparator(orderByAsc);
		}
		return orderByComparator;
	}

}
