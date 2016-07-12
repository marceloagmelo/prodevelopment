package br.com.prodevelopment.eticket.portlet.type.comparator;

import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.portlet.type.TypeTicketConstants;

import com.liferay.portal.kernel.util.OrderByComparator;

public class TypeTicketNameComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "TypeTicket.nome ASC";

	public static final String ORDER_BY_DESC =
		"TypeTicket.nome DESC";

	public static final String[] ORDER_BY_FIELDS = {TypeTicketConstants.CAMPO_NAME};

	public TypeTicketNameComparator() {
		this(false);
	}

	public TypeTicketNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		TypeTicket typeTicket1 = (TypeTicket)obj1;
		TypeTicket typeTicket2 = (TypeTicket)obj2;

		String nome1 = typeTicket1.getName();
		String nome2 = typeTicket2.getName();

		int value = nome1.compareTo(nome2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}
