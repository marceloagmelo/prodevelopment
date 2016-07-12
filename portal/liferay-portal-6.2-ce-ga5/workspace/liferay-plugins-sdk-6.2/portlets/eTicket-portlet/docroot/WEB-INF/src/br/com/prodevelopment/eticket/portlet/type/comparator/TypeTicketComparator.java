package br.com.prodevelopment.eticket.portlet.type.comparator;

import br.com.prodevelopment.eticket.portlet.type.TypeTicketConstants;

import com.liferay.portal.kernel.util.OrderByComparator;

public class TypeTicketComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getFuncionariosOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new TypeTicketNameComparator(orderByAsc);
		} else if (orderByCol.equals(TypeTicketConstants.CAMPO_NAME)) {
			orderByComparator = new TypeTicketNameComparator(orderByAsc);
		}
		return orderByComparator;
	}
}
