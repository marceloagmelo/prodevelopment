package br.com.rasecmadeiras.busca.resultado;

public class Constantes {
	//init do portlet
	public static final String JSP_NAO_CONFIGURADO = "naoConfigurado-jsp";

	public static final String NOME_PARAM_INIT = "nome-parametro-busca";
	public static final String NOME_PARAM_ID_INIT = "nome-param-id";
	public static String NOME_PARAM;
	public static String NOME_PARAM_ID;

	public static final String N = "N";
	public static final String S = "S";

	public static final String STRUCTURE_ID = "structureId";
	public static final String NOME_PARAM_ESTRUTURA = "estrutura";


	//campos da busca avancada
	public static final String TIPO_CONTEUDO = "tconteudo";
	public static final String TIPO_CONTEUDO_PRODUTO = "tproduto";
	public static final String TIPO_CONTEUDO_FORNECEDOR = "tfornecedor";
	public static final String TIPO_CONTEUDO_VIDEOS = "tvideos";
	public static final String TIPO_CONTEUDO_OUTROS = "toutros";

	public static final int QUANTIDADE_RESULTADO_DEFAULT = 5;

	public static String PAGINA_DESTINO_PRODUTO = "/produto";
	public static String PAGINA_DESTINO_FORNECEDOR = "/fornecedor";
	public static String PAGINA_DESTINO_CONTEUDO = "/conteudo";

	//preferencia

	public final static String PREF_PRODUTO_ESTRUTURA = "prefProdutoEstrutura";
	public final static String PREF_VIDEO_ESTRUTURA = "prefVideoEstrutura";
	public final static String PREF_FORNECEDOR_ESTRUTURA = "prefFornecedorEstrutura";
	public final static String PREF_PRODUTO_PAGINA_DESTINO = "prefProdutoPaginaDestino";
	public final static String PREF_FORNECEDOR_PAGINA_DESTINO = "prefFornecedorPaginaDestino";
	public static final String APPEND_STOP_WORDS = "appendStopWords";
	public static final String PREF_CONFIGURADO = "prefConfigurado";

	//---------------------- campos da busca ----------------------------
	private static final String PREFIX = "web_content/";

	//produto
	public static final String PRODUTO_TITULO = PREFIX + "titulo";
	public static final String PRODUTO_BENEFICIOS = PREFIX + "beneficios";
	public static final String PRODUTO_CAPACIDADES = PREFIX + "capacidades";
	public static final String PRODUTO_CARACTERISTICA = PREFIX + "caracteristica";
	public static final String PRODUTO_DICAS = PREFIX + "dicas";
	public static final String PRODUTO_CAPACIDADE = PREFIX + "capacidade";
	public static final String PRODUTO_IMAGEM_TITULO = PREFIX + "imagem-titulo";
	public static final String PRODUTO_IMAGEM_DIMENSOES = PREFIX + "imagem-dimensoes";

	//fornecedor
	public static final String FORNECEDOR_TITULO = PREFIX + "titulo";

	//vídeo
	public static final String VIDEO_TITULO = PREFIX + "titulo";
	public static final String VIDEO_URL = PREFIX + "url";

	//outros
	public static final String OUTROS_TITULO = PREFIX + "titulo";
	public static final String OUTROS_TEXTO = PREFIX + "texto";
	public static final String OUTROS_CONTEUDO = PREFIX + "conteudo";

	public final static String TIPO_URL = "[turl]";
	public final static String PREFIX_IFRAME = "http://www.youtube.com/"+TIPO_URL+"/";
	public final static String SUFIX_IFRAME = "?rel=0&fs=0&showinfo=0&theme=light&color=white";
	public final static String PREFIX_TUMB = "http://i2.ytimg.com/vi/";
	public final static String SUFIX_TUMB = "/default.jpg";
	public final static String URL_NORMAL = "embed";
	public final static String URL_FLASH = "v";

	public final static String ARTICLE_ID = "articleId";

	public final static String LISTA_ESTRUTURA = "listaEstrutura";

	// estrutura
	public final static String TITULO = PREFIX + "titulo";
	public final static String DESCRICAO = PREFIX + "descricao";
}
