package br.com.studiniz.busca.resultado.vo;

import java.util.ArrayList;
import java.util.List;

public class ResultadoVO {

	private String id;
	private String titulo;
	private String descricao;
	private String dataCriacao;
	private String dataAlteracao;
	private String groupFriendlyURL;
	private String categorias;
	private String tagsNames;
	private List<String> urlPagina;
	private String paginaDestino;
	private String estrutura;
	private String iconeUrl;
	private String downloadUrl;
	private String assetEntryId;

	public ResultadoVO() {
		urlPagina = new ArrayList<String>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getGroupFriendlyURL() {
		return groupFriendlyURL;
	}

	public void setGroupFriendlyURL(String groupFriendlyURL) {
		this.groupFriendlyURL = groupFriendlyURL;
	}

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}

	public String getTagsNames() {
		return tagsNames;
	}

	public void setTagsNames(String tagsNames) {
		this.tagsNames = tagsNames;
	}

	public List<String> getUrlPagina() {
		return urlPagina;
	}

	public void setUrlPagina(List<String> urlPagina) {
		this.urlPagina = urlPagina;
	}

	public String getPaginaDestino() {
		return paginaDestino;
	}

	public void setPaginaDestino(String paginaDestino) {
		this.paginaDestino = paginaDestino;
	}

	public String getEstrutura() {
		return estrutura;
	}

	public void setEstrutura(String estrutura) {
		this.estrutura = estrutura;
	}

	public String getIconeUrl() {
		return iconeUrl;
	}

	public void setIconeUrl(String iconeUrl) {
		this.iconeUrl = iconeUrl;
	}

	public String getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getAssetEntryId() {
		return assetEntryId;
	}

	public void setAssetEntryId(String assetEntryId) {
		this.assetEntryId = assetEntryId;
	}
	
}
