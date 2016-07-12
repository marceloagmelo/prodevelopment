package br.com.prodevelopment.meloesantos.portlet.orcamento.vo;

public class OrcamentoVO {

	private String tipoResposta;
	private String solicitacao;
	private String nomeEmpresa;
	private String nomeUsuario;
	private String emailUsuario;
	private String emailResponsavel;
	private String endereco;
	private String cep;
	private String cidade;
	private String estado;
	private String ddd;
	private String telefone;
	private String remetente;

	public OrcamentoVO() {
		this.tipoResposta = "";
		this.solicitacao = "";
		this.nomeEmpresa = "";
		this.nomeUsuario = "";
		this.emailUsuario = "";
		this.emailResponsavel = "";
		this.endereco = "";
		this.cep = "";
		this.cidade = "";
		this.estado = "";
		this.ddd = "";
		this.telefone = "";
		this.remetente = "";
	}

	public String getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(String tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}


}
