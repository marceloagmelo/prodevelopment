package br.com.prodevelopment.portlet.funcionario.comparator;

import br.com.prodevelopment.funcionario.model.Cargo;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CargoNomeComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "Cargo.nome ASC";

	public static final String ORDER_BY_DESC =
		"Funcionario.nome DESC";

	public static final String[] ORDER_BY_FIELDS = {"nome"};

	public CargoNomeComparator() {
		this(false);
	}

	public CargoNomeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Cargo cargo1 = (Cargo)obj1;
		Cargo cargo2 = (Cargo)obj2;

		String nome1 = cargo1.getNome();
		String nome2 = cargo2.getNome();

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
