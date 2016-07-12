package br.com.prodevelopment.faleconosco.vo;

public class AssuntoVO {
	
	private String id;
	private String descricao;
	
	public AssuntoVO() {
		this.id = "";
		this.descricao = "";
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
	
	

}
