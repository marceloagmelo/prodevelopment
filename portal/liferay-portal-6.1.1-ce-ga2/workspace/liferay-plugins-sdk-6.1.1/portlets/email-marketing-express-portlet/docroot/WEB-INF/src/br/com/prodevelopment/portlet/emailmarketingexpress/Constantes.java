package br.com.prodevelopment.portlet.emailmarketingexpress;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface Constantes {
	/*
	 * Geral
	 */
	public final String MSG_ERRO_PORTLET = "erro.portlet";
	public final String MSG_ERRO_BANCO_DADOS = "erro.bancoDados";
	public final String MSG_INCLUDE_INVALIDO = " include nao valido";
	
	public final String NOME_PARAM_JSP_PAGE = "jspPage";
	
	public final String PROP_BUSCA_NOME_ARQUIVO = "nomeArquivo";
	
	public final String PORTLET_ACTION = "javax.portlet.action";
	
	public final String NOME_PARAM_CONFIRMAR = "confirmarURL";
	public final String URL_METODO_CONFIRMAR = "confirmar";
	
	public final String PROP_NOME_ARQUIVO = "nomeArquivo";
	public final String PROP_NOME_IMAGEM = "nomeImagem";
	public final String NOME_PARAM_NOME_ARQUIVO = "nomeArquivo";
	
	public final String MSG_ERRO = "mensagem.erro";
	
	public final DateFormat FORMATO_DATA_BR = new SimpleDateFormat("ddMMyyyy");
	public final DateFormat FORMATO_HORA_BR = new SimpleDateFormat("hhmmss");
}

