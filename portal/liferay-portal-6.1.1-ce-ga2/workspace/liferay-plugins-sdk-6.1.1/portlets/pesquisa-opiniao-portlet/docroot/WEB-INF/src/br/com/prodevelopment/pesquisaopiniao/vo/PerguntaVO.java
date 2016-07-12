package br.com.prodevelopment.pesquisaopiniao.vo;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.pesquisaopiniao.Constantes;

public class PerguntaVO {

	private String id;
	private String descricao;
	private Map<Locale, String> descricaoMap;
	private String descricaoCorrente;
	private PesquisaVO pesquisaVO;
	private List<RespostaVO> respostas;
	
	public PerguntaVO() {

		this.id = "";
		this.descricao = "";
		this.descricaoCorrente = "";
		this.descricaoMap = null;
		this.pesquisaVO = null;
		this.respostas = null;
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

	public PesquisaVO getPesquisaVO() {
		return pesquisaVO;
	}

	public void setPesquisaVO(PesquisaVO pesquisaVO) {
		this.pesquisaVO = pesquisaVO;
	}

	public List<RespostaVO> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaVO> respostas) {
		this.respostas = respostas;
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
	
}
