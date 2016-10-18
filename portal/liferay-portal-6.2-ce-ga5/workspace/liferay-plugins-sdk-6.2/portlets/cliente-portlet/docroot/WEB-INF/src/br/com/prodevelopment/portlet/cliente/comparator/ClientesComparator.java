package br.com.prodevelopment.portlet.cliente.comparator;

import br.com.prodevelopment.portlet.cliente.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ClientesComparator {
	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getClientesOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new ClienteNomeComparator(orderByAsc);
		} else if (orderByCol.equals(Constantes.CAMPO_NOME)) {
			orderByComparator = new ClienteNomeComparator(orderByAsc);
		}
		return orderByComparator;
	}
}


