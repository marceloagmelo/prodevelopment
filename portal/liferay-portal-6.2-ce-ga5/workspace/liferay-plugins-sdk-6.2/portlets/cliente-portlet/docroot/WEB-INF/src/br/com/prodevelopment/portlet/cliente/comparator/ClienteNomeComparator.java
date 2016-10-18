package br.com.prodevelopment.portlet.cliente.comparator;

import br.com.prodevelopment.cliente.model.Cliente;
import br.com.prodevelopment.portlet.cliente.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ClienteNomeComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "Cliente.nome ASC";

	public static final String ORDER_BY_DESC =
		"Cliente.nome DESC";

	public static final String[] ORDER_BY_FIELDS = {Constantes.CAMPO_NOME};

	public ClienteNomeComparator() {
		this(false);
	}

	public ClienteNomeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Cliente cliente1 = (Cliente)obj1;
		Cliente cliente2 = (Cliente)obj2;

		String nome1 = cliente1.getNome();
		String nome2 = cliente2.getNome();

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
