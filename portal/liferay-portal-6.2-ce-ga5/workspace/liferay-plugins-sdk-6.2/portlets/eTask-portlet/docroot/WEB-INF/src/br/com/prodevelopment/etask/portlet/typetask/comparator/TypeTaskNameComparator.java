package br.com.prodevelopment.etask.portlet.typetask.comparator;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.portlet.typetask.TypeTaskConstants;

import com.liferay.portal.kernel.util.OrderByComparator;

public class TypeTaskNameComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "TypeTask.nome ASC";

	public static final String ORDER_BY_DESC =
		"TypeTask.nome DESC";

	public static final String[] ORDER_BY_FIELDS = {TypeTaskConstants.NAME};

	public TypeTaskNameComparator() {
		this(false);
	}

	public TypeTaskNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		TypeTask typeTask1 = (TypeTask)obj1;
		TypeTask typeTask2 = (TypeTask)obj2;

		String nome1 = typeTask1.getName();
		String nome2 = typeTask2.getName();

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
