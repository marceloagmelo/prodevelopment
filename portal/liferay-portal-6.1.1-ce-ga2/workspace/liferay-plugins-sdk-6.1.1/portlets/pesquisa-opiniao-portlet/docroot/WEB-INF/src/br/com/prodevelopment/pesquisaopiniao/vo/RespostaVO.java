package br.com.prodevelopment.pesquisaopiniao.vo;

import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.pesquisaopiniao.Constantes;

public class RespostaVO {

	private String id;
	private String descricao;
	private Map<Locale, String> descricaoMap;
	private String descricaoCorrente;
	private PerguntaVO perguntaVO;
	private String quantidade;
	private String percentual;
	
	public RespostaVO() {
		this.id = "";
		this.descricao = "";
		this.descricaoCorrente = "";
		this.descricaoMap = null;
		this.perguntaVO = null;
		this.quantidade = "";
		this.percentual = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public PerguntaVO getPerguntaVO() {
		return perguntaVO;
	}

	public void setPerguntaVO(PerguntaVO perguntaVO) {
		this.perguntaVO = perguntaVO;
	}

	public Map<Locale, String> getDescricaoMap() {
		return descricaoMap;
	}

	public void setDescricaoMap(Map<Locale, String> descricaoMap) {
		this.descricaoMap = descricaoMap;
	}

	public String getDescricaoCorrente() {
		return descricaoCorrente;
	}

	public void setDescricaoCorrente(String descricaoCorrente) {
		this.descricaoCorrente = descricaoCorrente;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getPercentual() {
		return percentual;
	}

	public void setPercentual(String percentual) {
		this.percentual = percentual;
	}
	
}
