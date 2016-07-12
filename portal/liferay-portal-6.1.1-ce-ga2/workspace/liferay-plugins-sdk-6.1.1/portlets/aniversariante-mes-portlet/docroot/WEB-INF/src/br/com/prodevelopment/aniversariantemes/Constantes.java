package br.com.prodevelopment.aniversariantemes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface Constantes {

	/*
	 * Geral
	 */
	public final String JSP_ENVIAR_MENSAGEM = "enviarMensagem-jsp";

	public final String NOME_PARAM_JSP_PAGE = "jspPage";
	
	public final String JSP_CADASTRO_CONFIG = "/html/aniversariantemesportlet/configuracao.jsp";
	
	public final String MSG_ERRO_PORTLET = "erro.portlet";
	public final String MSG_ERRO_BANCO_DADOS = "mensagem.erro.bancoDados";
	public final String MSG_INCLUDE_INVALIDO = " include não válido";

	public final String VAZIO = "";
	public final String N = "N";
	public final String S = "S";
	public final String TRALHA = "#";
	public final String ZERO = "0";
	public final String ESPACO = " ";
	
	public final String PREF_EXIBIR_TITULO = "prefExibirTitulo";
	public final String NOME_PARAM_EXIBIR_TITULO="exibirTitulo";
	
	public final String NOME_PARAM_TITULO_PORTLET = "portletTitulo";
	
	public final String PORTLET_ACTION = "javax.portlet.action";

	public final String NOME_PARAM_ID = "id";
	public final String NOME_PARAM_MENSAGEM = "mensagem";
	
	public final String NOME_PARAM_METODO = "metodo";

	public final DateFormat FORMATO_DATA_BR = new SimpleDateFormat("dd/MM/yyyy");
	
	public final String NOME_PARAM_TITULO = "titulo";
	
	public final String GROUP_ID = "groupId";
	
	public final String METODO_VOLTAR = "voltar";
	public final String NOME_PARAM_VOLTAR_URL = "voltarURL";
	public final String NOME_PARAM_VER_TODOS_URL = "verTodosURL";
	public final String METODO_PREPARAR_MENSAGEM = "prepararMensagem";
	public final String NOME_PARAM_PREPARAR_MENSAGEM_URL = "prepararMensagemURL";
	public final String METODO_CANCELAR = "cancelar";
	public final String NOME_PARAM_CANCELAR_URL = "cancelarURL";
	public final String METODO_ENVIAR_MENSAGEM = "enviarMensagem";
	public final String NOME_PARAM_ENVIAR_MENSAGEM_URL = "enviarMensagemURL";
	
	public final String NOME_PARAM_USUARIO_VO = "usuarioVO";
	
	public final String RESOURCE_BUNDLE = "resourceBundle";
}
