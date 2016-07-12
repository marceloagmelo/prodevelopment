package br.com.prodevelopment.portlet.funcionario.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.portlet.funcionario.Constantes;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class FuncionarioDisplayTerms extends DisplayTerms {

	public FuncionarioDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		nomeReduzido = ParamUtil.getString(portletRequest, Constantes.CAMPO_NOME_REDUZIDO);
		nome = ParamUtil.getString(portletRequest, Constantes.CAMPO_NOME);
	}

	public String getNomeReduzido() {
		return nomeReduzido;
	}
	public void setNomeReduzido(String nomeReduzido) {
		this.nomeReduzido = nomeReduzido;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	protected String nomeReduzido;
	protected String nome;

}
