package br.com.prodevelopment.ultimasnoticiasrss;

public class Constantes {

	public final static String JSP_NAO_CONFIGURADO = "naoConfigurado-jsp";

	public final static String APPROVED = "approved";
	public final static String EXPIRED = "expired";

	public final static String S = "S";
	public final static String N = "N";
	public final static String VAZIO = "";

	public final static String GOOGLE = "1";
	public final static String GLOBO = "2";
	public final static String UOL = "3";
	public final static String TERRA = "4";

	public final static String DEFAULT_TAMAMHO_CARACTERES = "100";

	public final static String URL_UOL_NOTICIA = "http://rss.uol.com.br/feed/noticias.xml";

	public final static String URL_GOOGLE_ULTIMAS_NOTICIAS = "https://news.google.com/news/feeds?ned=pt-BR_br&topic=h&output=rss";
	public final static String URL_GOOGLE_INTERNACIONAL = "https://news.google.com/news/feeds?ned=pt-BR_br&topic=w&output=rss";
	public final static String URL_GOOGLE_NEGOCIO = "http://news.google.com/news?ned=pt-BR_br&topic=b&output=rss";
	public final static String URL_GOOGLE_SAUDE = "https://news.google.com/news/feeds?ned=pt-BR_br&topic=m&output=rss";
	public final static String URL_GOOGLE_ESPORTE = "https://news.google.com/news/feeds?ned=pt-BR_br&topic=s&output=rss";

	public final static String PREF_URL_GOOGLE_ULTIMAS_NOTICIAS = "prefUrlGoogleUltimasNoticias";
	public final static String PREF_URL_GOOGLE_INTERNACIONAL = "prefUrlGoogleInternacional";
	public final static String PREF_URL_GOOGLE_NEGOCIO = "prefUrlGoogleNegocio";
	public final static String PREF_URL_GOOGLE_SAUDE = "prefUrlGoogleSaude";
	public final static String PREF_URL_GOOGLE_ESPORTE = "prefUrlGoogleEsporte";

	public final static String URL_GLOBO_ULTIMAS_NOTICIAS = "http://g1.globo.com/dynamo/rss2.xml";
	public final static String URL_GLOBO_INTERNACIONAL = "http://g1.globo.com/dynamo/mundo/rss2.xml";
	public final static String URL_GLOBO_NEGOCIO = "http://g1.globo.com/dynamo/economia/rss2.xml";
	public final static String URL_GLOBO_SAUDE = "http://g1.globo.com/dynamo/ciencia-e-saude/rss2.xml";
	public final static String URL_GLOBO_ESPORTE = "http://globoesporte.globo.com/dynamo/rss2.xml";

	public final static String PREF_URL_GLOBO_ULTIMAS_NOTICIAS = "prefUrlGloboUltimasNoticias";
	public final static String PREF_URL_GLOBO_INTERNACIONAL = "prefUrlGloboInternacional";
	public final static String PREF_URL_GLOBO_NEGOCIO = "prefUrlGloboNegocio";
	public final static String PREF_URL_GLOBO_SAUDE = "prefUrlGloboSaude";
	public final static String PREF_URL_GLOBO_ESPORTE = "prefUrlGloboEsporte";

	public final static String URL_UOL_ULTIMAS_NOTICIAS = "http://rss.uol.com.br/feed/noticias.xml";
	public final static String URL_UOL_INTERNACIONAL = "";
	public final static String URL_UOL_NEGOCIO = "http://rss.uol.com.br/feed/economia.xml";
	public final static String URL_UOL_SAUDE = "";
	public final static String URL_UOL_ESPORTE = "http://esporte.uol.com.br/ultimas/index.xml";

	public final static String PREF_URL_UOL_ULTIMAS_NOTICIAS = "prefUrlUolUltimasNoticias";
	public final static String PREF_URL_UOL_INTERNACIONAL = "prefUrlUolInternacional";
	public final static String PREF_URL_UOL_NEGOCIO = "prefUrlUolNegocio";
	public final static String PREF_URL_UOL_SAUDE = "prefUrlUolSaude";
	public final static String PREF_URL_UOL_ESPORTE = "prefUrlUolEsporte";

	public final static String URL_TERRA_ULTIMAS_NOTICIAS = "http://rss.terra.com.br/0,,EI1,00.xml";
	public final static String URL_TERRA_INTERNACIONAL = "http://rss.terra.com.br/0,,EI294,00.xml";
	public final static String URL_TERRA_NEGOCIO = "http://br.invertia.com/rss/economia/pt-br/feedrss.xml";
	public final static String URL_TERRA_SAUDE = "";
	public final static String URL_TERRA_ESPORTE = "http://rss.terra.com.br/0,,EI1137,00.xml";

	public final static String PREF_URL_TERRA_ULTIMAS_NOTICIAS = "prefUrlTerraUltimasNoticias";
	public final static String PREF_URL_TERRA_INTERNACIONAL = "prefUrlTerraInternacional";
	public final static String PREF_URL_TERRA_NEGOCIO = "prefUrlTerraNegocio";
	public final static String PREF_URL_TERRA_SAUDE = "prefUrlTerraSaude";
	public final static String PREF_URL_TERRA_ESPORTE = "prefUrlTerraEsporte";

	public final static String PREF_SERVICO = "prefServico";
	public final static String PREF_CONFIGURADO = "prefConfigurado";

	public final static int TOTAL_SERVICOS = 4;

	public final static String[] CAMPOS_GOOGLE = {
			"prefUrlGoogleUltimasNoticias", "prefUrlGoogleInternacional",
			"prefUrlGoogleNegocio", "prefUrlGoogleSaude",
			"prefUrlGoogleEsporte" };
	public final static String[] CAMPOS_GLOBO = {
		"prefUrlGloboUltimasNoticias", "prefUrlGloboInternacional",
		"prefUrlGloboNegocio", "prefUrlGloboSaude",
		"prefUrlGloboEsporte" };
	public final static String[] CAMPOS_UOL = {
		"prefUrlUolUltimasNoticias", "prefUrlUolInternacional",
		"prefUrlUolNegocio", "prefUrlUolSaude",
		"prefUrlUolEsporte" };
	public final static String[] CAMPOS_TERRA = {
		"prefUrlTerraUltimasNoticias", "prefUrlTerraInternacional",
		"prefUrlTerraNegocio", "prefUrlTerraSaude",
		"prefUrlTerraEsporte" };

	public final static String TEM_ULTIMAS_NOTICIAS = "temUltimasNoticias";
	public final static String TEM_NOTICIA_INTERNACIONAL = "temNoticiaInternacional";
	public final static String TEM_NOTICIA_NEGOCIO = "temNoticiaNegocio";
	public final static String TEM_NOTICIA_SAUDE = "temNoticiaSaude";
	public final static String TEM_NOTICIA_ESPORTE = "temNoticiaEsporte";
}
