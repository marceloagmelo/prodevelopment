package br.com.prodevelopment.portlet.cliente.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.portlet.cliente.Constantes;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ClienteDisplayTerms extends DisplayTerms {

	public ClienteDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		nome = ParamUtil.getString(portletRequest, Constantes.CAMPO_NOME);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	protected String nome;

}
