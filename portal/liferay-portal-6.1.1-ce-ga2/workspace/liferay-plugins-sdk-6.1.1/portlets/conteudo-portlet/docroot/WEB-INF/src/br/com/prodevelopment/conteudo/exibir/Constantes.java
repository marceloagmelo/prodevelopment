package br.com.prodevelopment.conteudo.exibir;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

public interface Constantes {
	public final String JSP_NAO_CONFIGURADO = "naoConfigurado-jsp";
	public final String JSP_POPUP = "popup-jsp";

	public final String N = "N";
	public final String S = "S";
	public final String NAO = "Não";
	public final String SIM = "Sim";
	public final String VAZIO = "";
	public final String ZERO = "0";

	public final String NOME_PARAM_ID = "id";
	public final String NOME_PARAM_TERMO_BUSCA = "termoBusca";
	public final String NOME_PARAM_ESTRUTURA = "estrutura";
	public final String NOME_PARAM_CATEGORIA = "categoria";

	public final String PREF_CONFIGURADO = "prefConfigurado";
	public final String PREF_EXIBIR_TITULO = "prefExibirTitulo";
	public final String PREF_ID = "prefId";
	public final String PREF_IMPRIMIR = "prefImprimir";
	public final String PREF_PONTUACAO = "prefPontuacao";
	public final String PREF_COMENTARIO = "prefComentario";
	public final String PREF_PONTUACAO_COMENTARIO = "prefPontuacaoComentario";
	public final String PREF_USUARIO_DATA_ATUALIZACAO = "prefUsuarioDataAtualizacao";
	public final String PREF_VOLTAR = "prefVoltar";
	public final String PREF_EMAIL = "prefEmail";
	public final String PREF_RS_FACEBOOK = "prefRsFacebook";
	public final String PREF_RS_TWITTER = "prefRsTwitter";
	public final String PREF_RS_LINKEDIN = "prefRsLinkedIn";
	public final String PREF_ESTRUTURA = "prefEstrutura";
	public final String PREF_RS_GOOGLE = "prefRsGoogle";

	public final String CONTEUDO_VO = "conteudoVO";
	public final String ARTIGO_DISPLAY = "artigoDisplay";
	
	public final String NOME_PARAM_EXIBIR_TITULO="exibirTitulo";

	public static final String PRINT = "print";

	public static final String PROP_NOME = "nome";

	public static final boolean JOURNAL_ARTICLE_COMMENTS_ENABLED = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.JOURNAL_ARTICLE_COMMENTS_ENABLED));

	public final static int TOTAL_POR_PAGINA = 5;

	public final static String LISTA_CONTEUDOS = "listaConteudos";

	public final static String TOTAL = "total";
	
	public final static String TIPO_CONTEUDO = "content";
	public final static String TIPO_DOCUMENTO = "document";

	public final String ADD_CONTENT = "ADD_CONTENT";
	public final String UPDATE_CONTENT = "UPDATE_CONTENT";
	public final String UPDATE_TEMPLATE = "UPDATE_TEMPLATE";
	
	public final String PACKAGE_MODELO = "com.liferay.portlet.journal";
	
	public final String LISTA_ESTRUTURA = "listaEstrutura";
}
