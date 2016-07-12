package br.com.prodevelopment.eticket.portlet.type.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.eticket.portlet.type.TypeTicketConstants;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class TypeTicketDisplayTerms extends DisplayTerms {
	
	public TypeTicketDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		name = ParamUtil.getString(portletRequest, TypeTicketConstants.CAMPO_NAME);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	protected String name;
}
