package br.com.prodevelopment.testeconhecimento.vo;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PerguntaVO {

	private String id;
	private String descricao;
	private Map<Locale, String> descricaoMap;
	private String descricaoCorrente;
	private TesteVO testeVO;
	private List<RespostaVO> respostas;
	private String justificativaResposta;
	private Map<Locale, String> justificativaRespostaMap;
	private String justificativaRespostaCorrente;
	private String pontuacao;


	public PerguntaVO() {

		this.id = "";
		this.descricao = "";
		this.descricaoCorrente = "";
		this.descricaoMap = null;
		this.testeVO = null;
		this.respostas = null;
		this.justificativaResposta = "";
		this.justificativaRespostaCorrente = "";
		this.justificativaRespostaMap = null;
		this.pontuacao = "";
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

	public TesteVO getTesteVO() {
		return testeVO;
	}

	public void setTesteVO(TesteVO testeVO) {
		this.testeVO = testeVO;
	}

	public List<RespostaVO> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaVO> respostas) {
		this.respostas = respostas;
	}

	public String getJustificativaResposta() {
		return justificativaResposta;
	}

	public void setJustificativaResposta(String justificativaResposta) {
		this.justificativaResposta = justificativaResposta;
	}

	public String getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
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

	public Map<Locale, String> getJustificativaRespostaMap() {
		return justificativaRespostaMap;
	}

	public void setJustificativaRespostaMap(
			Map<Locale, String> justificativaRespostaMap) {
		this.justificativaRespostaMap = justificativaRespostaMap;
	}

	public String getJustificativaRespostaCorrente() {
		return justificativaRespostaCorrente;
	}

	public void setJustificativaRespostaCorrente(
			String justificativaRespostaCorrente) {
		this.justificativaRespostaCorrente = justificativaRespostaCorrente;
	}


}
