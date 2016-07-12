package br.com.prodevelopment.testeconhecimento.vo;

import java.util.List;

public class TesteResultadoVO {

	private String id;
	private String descricao;
	private String quantidadePontosInicial;
	private String quantidadePontosFinal;
	private TesteVO testeVO;
	private List<RespostaVO> respostas;
	
	public TesteResultadoVO() {

		this.id = "";
		this.descricao = "";
		this.quantidadePontosInicial = "";
		this.quantidadePontosFinal = "";
		this.testeVO = null;
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

	public List<RespostaVO> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaVO> respostas) {
		this.respostas = respostas;
	}

	public TesteVO getTesteVO() {
		return testeVO;
	}

	public void setTesteVO(TesteVO testeVO) {
		this.testeVO = testeVO;
	}

	public String getQuantidadePontosInicial() {
		return quantidadePontosInicial;
	}

	public void setQuantidadePontosInicial(String quantidadePontosInicial) {
		this.quantidadePontosInicial = quantidadePontosInicial;
	}

	public String getQuantidadePontosFinal() {
		return quantidadePontosFinal;
	}

	public void setQuantidadePontosFinal(String quantidadePontosFinal) {
		this.quantidadePontosFinal = quantidadePontosFinal;
	}

	
}
