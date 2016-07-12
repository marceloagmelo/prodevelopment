package br.com.prodevelopment.portlet.funcionario.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CargosComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getCargosOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new CargoNomeComparator(orderByAsc);
		} else if (orderByCol.equals("nome")) {
			orderByComparator = new CargoNomeComparator(orderByAsc);
		}
		return orderByComparator;
	}
}


