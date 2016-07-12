package br.com.prodevelopment.video.vo;

public class VideoVO {

	private String idVideo;
	private String urlVideo;
	private String urlTumb;
	private String titulo;
	private String texto;
	private String dataCriacao;
	private String descricao;
	private String conteudo;
	private String dataAlteracao;
	private String idImagemPequena;
	private String urlImagemPequena;
	private String existeImagemPequena;
	private String autor;
	private String assetEntryId;
	private String groupId;
	private String versao;
	private String categorias;

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getUrlTumb() {
		return urlTumb;
	}

	public void setUrlTumb(String urlTumb) {
		this.urlTumb = urlTumb;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof VideoVO) || obj == null) {
			return false;
		}

		VideoVO video = (VideoVO) obj;

		if (video.getIdVideo().equals(this.idVideo)) {
			return true;
		}

		return super.equals(obj);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getIdImagemPequena() {
		return idImagemPequena;
	}

	public void setIdImagemPequena(String idImagemPequena) {
		this.idImagemPequena = idImagemPequena;
	}

	public String getUrlImagemPequena() {
		return urlImagemPequena;
	}

	public void setUrlImagemPequena(String urlImagemPequena) {
		this.urlImagemPequena = urlImagemPequena;
	}

	public String getExisteImagemPequena() {
		return existeImagemPequena;
	}

	public void setExisteImagemPequena(String existeImagemPequena) {
		this.existeImagemPequena = existeImagemPequena;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAssetEntryId() {
		return assetEntryId;
	}

	public void setAssetEntryId(String assetEntryId) {
		this.assetEntryId = assetEntryId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}


}
