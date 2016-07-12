<%@include file="/html/init.jsp"%>

<%@ page
	import="br.com.prodevelopment.portlet.conteudoweb.ultimos.Constantes"%>
<%@ page import="br.com.prodevelopment.portlet.conteudoweb.util.Search"%>
<%
	Map<Long, String> listaEstrutura = (Map<Long, String>) request
			.getAttribute(Constantes.LISTA_ESTRUTURA);

	String categoryId = preferences.getValue(Constantes.PREF_CATEGORIA,
			StringPool.BLANK);

	String tag = preferences.getValue(Constantes.PREF_TAG,
			StringPool.BLANK);

	String structureId = preferences.getValue(
			Constantes.PREF_ESTRUTURA, StringPool.BLANK);

	String portletTitulo = ParamUtil.getString(renderRequest,
			Constantes.NOME_PARAM_TITULO_PORTLET);

	String prefQtdeRegistros = preferences.getValue(
			Constantes.PREF_QTDE_REGISTROS, StringPool.BLANK);
	String prefTamanhoCaracteres = preferences.getValue(Constantes.PREF_TAMANHO_CARACTERES,
			StringPool.BLANK);

	String prefExibirTitulo = preferences.getValue(
			Constantes.PREF_EXIBIR_TITULO, Constantes.N);
	String prefExibir = preferences.getValue(Constantes.PREF_EXIBIR,
			StringPool.BLANK);
	String prefUrlVerTodos = preferences.getValue(
			Constantes.PREF_URL_VER_TODOS, StringPool.BLANK);
	String prefUrlDestino = preferences.getValue(
			Constantes.PREF_URL_DESTINO, StringPool.BLANK);
%>