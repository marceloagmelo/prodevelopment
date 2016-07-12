package br.com.prodevelopment.portlet.funcionario.comparator;

import br.com.prodevelopment.portlet.funcionario.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class FuncionariosComparator {
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
			orderByComparator = new FuncionarioNomeComparator(orderByAsc);
		} else if (orderByCol.equals(Constantes.CAMPO_NOME)) {
			orderByComparator = new FuncionarioNomeComparator(orderByAsc);
		} else if (orderByCol.equals(Constantes.CAMPO_NOME_REDUZIDO)) {
			orderByComparator = new FuncionarioNomeReduzidoComparator(orderByAsc);
		}
		return orderByComparator;
	}
}


