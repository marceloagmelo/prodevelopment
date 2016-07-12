package br.com.prodevelopment.portlet.atividade.comparator;

import br.com.prodevelopment.atividade.model.Atividade;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AtividadeNomeComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "Atividade.nome ASC";

	public static final String ORDER_BY_DESC =
		"Funcionario.nome DESC";

	public static final String[] ORDER_BY_FIELDS = {"nome"};

	public AtividadeNomeComparator() {
		this(false);
	}

	public AtividadeNomeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Atividade atividade1 = (Atividade)obj1;
		Atividade atividade2 = (Atividade)obj2;

		String nome1 = atividade1.getNome();
		String nome2 = atividade2.getNome();

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
