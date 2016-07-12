package br.com.prodevelopment.video.lista;

public class Constantes {
	// para o Solr
	public static final String STRUCTURE_ID = "structureId";

	private final static String PREFIX = "web_content/";
	public final static String TITULO = PREFIX + "titulo";
	public final static String TEXTO = PREFIX + "texto";
	public final static String URL = PREFIX + "url";
	public final static String URL_FLASH = "v";

	public final static String TIPO_URL = "[turl]";

	// Constantes de parseamento da URL do YouTube
	public final static String PREFIX_IFRAME = "http://www.youtube.com/embed/";
	public final static String SUFIX_IFRAME = "?rel=0&fs=0&showinfo=0&theme=light&color=white";
	public final static String PREFIX_TUMB = "http://i2.ytimg.com/vi/";
	public final static String SUFIX_TUMB = "/default.jpg";
	public final static String PREFIX_TO_PARSE = "http://www.youtube.com/watch?v=";
	public final static String SUFIX_TO_PARSE = "&feature";

	//JSPs
	public static final String JSP_NAO_CONFIGURADO = "naoConfigurado-jsp";

	public static final String NOME_PARAM_METODO = "metodo";
	public static final String NOME_PARAM_ID = "id";
	public static final String NOME_PARAM_PAGINA = "pagina";
	public static final String NOME_PARAM_CHAVE = "chave";
	public static final String NOME_PARAM_CATEGORIA = "categoria";
	public static final String NOME_PARAM_TAG = "tag";
	public static final String NOME_PARAM_ESTRUTURA = "estrutura";
	public static final String NOME_PARAM_TITULO_PORTLET = "portletTitulo";
	public static final String NOME_SESSAO_CATEGORIA = "sessaoCategoria";
	public static final String NOME_SESSAO_TAG = "sessaoTag";
	public static final String NOME_SESSAO_ESTRUTURA = "sessaoEstrutura";
	public static final String NOME_SESSAO_TITULO_PORTLET = "sessaoPrtletTitulo";

	public static final String N = "N";
	public static final String S = "S";
	public static final String NAO = "Não";
	public static final String SIM = "Sim";
	public static final String VAZIO = "";
	public static final String TRALHA = "#";

	public static final String PREF_PAGINACAO = "prefPaginacao";
	public static final String PREF_QTDE_REGISTROS = "prefQtdeRegistros";
	public static final String PREF_TAG = "prefTag";
	public static final String PREF_CATEGORIA = "prefCategoria";
	public static final String PREF_ESTRUTURA = "prefEstrutura";
	public static final String PREF_CONFIGURADO = "prefConfigurado";
	public static final String PREF_EXIBIR_TITULO = "prefExibirTitulo";
	public static final String PREF_TAMANHO_CARACTERES = "prefTamanhoCaracteres";

	public static final String LISTA_ESTRUTURA = "listaEstrutura";

	public static final String CATEGORIAS_IDS = "assetCategoryIds";
	public static final String TAG_NAMES = "assetTagNames";

	public static final String DEFAULT_QTDE_REGISTROS = "5";
	public static final String DEFAULT_TAMAMHO_CARACTERES="200";

	public static final String URL_METODO_PROXIMO = "proximo";
	public static final String URL_METODO_ANTERIOR = "anterior";

	public static final String VIDEOS = "videos";

	public static final String NOME_PARAM_TOTAL_REGISTROS = "totalRegistros";
	public static final String NOME_PARAM_TOTAL_PAGINAS="totalPaginas";
	public static final String NOME_PARAM_PAGINACAO="paginacao";
	public static final String NOME_PARAM_EXIBIR_TITULO="exibirTitulo";

	public static final String PORTLET_TITULO = "portletTitulo";

	public static final String METODO_VER_CONTEUDO = "verConteudo";

	public static final String CONTEUDO_VO = "conteudoVO";
	public static final String ARTIGO_DISPLAY = "artigoDisplay";

	public static final String NOME_PARAM_VOLTAR_URL = "voltarUrl";

	public static final String TOTAL = "total";

	public static final String DESCRICAO = "web_content/descricao";

	public static final String ARTICLE_ID = "articleId";
}
