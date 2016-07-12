<%@ include file="../init.jsp"%>

<%@page import="br.com.prodevelopment.galeriaimagem.exibir.Constantes"%>
<%
	String portletResource = ParamUtil.getString(request,
			Constantes.PORTLET_RESOURCE);
	long folderId = ParamUtil.getLong(request, Constantes.FOLDER_ID);
	int pageSize = ParamUtil.getInteger(request, Constantes.PAGE_SIZE);

	boolean prefExibirTituloPortlet = GetterUtil.getBoolean(preferences
			.getValue(Constantes.PREF_EXIBIR_TITULO_PORTLET,
					Constantes.DEFAULT_PREF_EXIBIR_TITULO));
	boolean prefExibirTituloPasta = GetterUtil.getBoolean(preferences
			.getValue(Constantes.PREF_EXIBIR_TITULO_PASTA,
					Constantes.DEFAULT_PREF_EXIBIR_PASTA));
	String prefLarguraImagem = GetterUtil.getString(preferences
			.getValue(Constantes.PREF_LARGURA_IMAGEM,
					Constantes.DEFAULT_LARGURA_IMAGEM));
	String prefAlturaImagem = GetterUtil.getString(preferences
			.getValue(Constantes.PREF_ALTURA_IMAGEM,
					Constantes.DEFAULT_ALTURA_IMAGEM));
%>
