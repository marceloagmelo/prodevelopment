package br.com.prodevelopment.etask.portlet.typetask.comparator;

import br.com.prodevelopment.etask.portlet.typetask.TypeTaskConstants;

import com.liferay.portal.kernel.util.OrderByComparator;

public class TypeTaskComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getTypeTaskOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new TypeTaskNameComparator(orderByAsc);
		} else if (orderByCol.equals(TypeTaskConstants.NAME)) {
			orderByComparator = new TypeTaskNameComparator(orderByAsc);
		}
		return orderByComparator;
	}
}
