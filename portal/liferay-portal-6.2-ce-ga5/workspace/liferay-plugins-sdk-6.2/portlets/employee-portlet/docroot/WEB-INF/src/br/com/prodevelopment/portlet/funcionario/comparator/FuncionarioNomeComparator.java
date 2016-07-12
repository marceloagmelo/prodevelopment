package br.com.prodevelopment.portlet.funcionario.comparator;

import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.portlet.funcionario.Constantes;

import com.liferay.portal.kernel.util.OrderByComparator;

public class FuncionarioNomeComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "Funcionario.nome ASC";

	public static final String ORDER_BY_DESC =
		"Funcionario.nome DESC";

	public static final String[] ORDER_BY_FIELDS = {Constantes.CAMPO_NOME};

	public FuncionarioNomeComparator() {
		this(false);
	}

	public FuncionarioNomeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Funcionario funcionario1 = (Funcionario)obj1;
		Funcionario funcionario2 = (Funcionario)obj2;

		String nome1 = funcionario1.getNome();
		String nome2 = funcionario2.getNome();

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
