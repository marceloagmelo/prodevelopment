package br.com.prodevelopment.testeconhecimento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface Constantes {

	/*
	 * Geral
	 */
	public final String JSP_EDIT = "edit-jsp";
	public final String JSP_VIEW = "view-jsp";
	public final String JSP_HELP = "help-jsp";
	public final String JSP_ERROR = "error-jsp";
	public final String JSP_RESULTADO= "resultado-jsp";
	public final String JSP_NAO_CONFIGURADO = "naoConfigurado-jsp";
	public final String JSP_VIEW_FIM = "viewFim-jsp";
	public final String JSP_USUARIO_NAO_LOGADO = "usuarioNaoLogado-jsp";

	public final String NOME_PARAM_JSP_PAGE = "jspPage";

	public final String MSG_ERRO_PORTLET = "erro.portlet";
	public final String MSG_ERRO_BANCO_DADOS = "mensagem.erro.bancoDados";
	public final String MSG_INCLUDE_INVALIDO = " include não válido";
	public final String MSG_PORTLET_NAO_CONFIGURADO = "mensagem.portlet.naoConfigurado";

	public final String VAZIO = "";
	public final String N = "N";
	public final String NAO = "Não";
	public final String S = "S";
	public final String SIM = "Sim";
	public final String TRALHA = "#";
	public final String ZERO = "0";
	public final String UM = "1";
	public final String DOIS = "2";
	public final String PERCENTE = "%";
	public final String CEM = "100";
	public final String BR = "<br>";

	public final String INICIO = "inicio";

	public final String PORTLET_ACTION = "javax.portlet.action";

	public final String NOME_PARAM_ID = "id";

	public final String NOME_PARAM_METODO = "metodo";
	
	public final String DEFAULT_LINHAS_PAGINA = "10";

	public final DateFormat FORMATO_DATA_BR = new SimpleDateFormat("dd/MM/yyyy");

	public final String NOME_PARAM_ADD_PERMISSAO = "hasAddPermission";
	public final String NOME_PARAM_VIEW_PERMISSAO = "hasViewPermission";
	public final String NOME_PARAM_EDIT_PERMISSAO = "hasEditPermission";
	public final String NOME_PARAM_DELETE_PERMISSAO = "hasDeletePermission";
	public final String NOME_PARAM_CONFIG_PERMISSAO = "hasConfigurePermission";

	public final String NOME_PARAM_TITULO = "titulo";
	public final String ID = "id";

	public final String LINHAS_PAGINA = "linhasPorPagina";

	public final String GROUP_ID = "groupId";

	public final String NOME_PARAM_TITULO_PORTLET = "portletTitulo";
	public final String NOME_PARAM_EXIBIR_TITULO="exibirTitulo";

	public final String RESOURCE_BUNDLE = "resourceBundle";
	
	/*
	 * Cadastro teste
	 */
	public final String JSP_VIEW_TESTE = "viewTeste-jsp";
	public final String JSP_CADASTRO_TESTE = "cadastroTeste-jsp";
	public final String JSP_VISUALIZAR_TESTE = "visualizarTeste-jsp";

	public final String PACKAGE_MODELO = "br.com.prodevelopment.testeconhecimento.model";
	public final String PACKAGE_OBJETO = "br.com.prodevelopment.testeconhecimento.model.Teste";
	public final String ADD_TESTE = "ADD_TESTE";

	public final String NOME_PARAM_ID_TESTE = "idTeste";
	public final String NOME_PARAM_FILTRO_TESTE = "filtroTeste";

	public final String URL_METODO_PREPARAR_NOVA_TESTE = "prepararNovaTeste";
	public final String NOME_PARAM_NOVA_TESTE_URL = "novoURL";
	public final String VALOR_PARAM_NOVA_TESTE = "novaTeste";

	public final String URL_METODO_FILTRAR_TESTE = "filtrarTeste";
	public final String NOME_PARAM_FILTRAR_TESTE_URL = "filtrarURL";

	public final String VALOR_PARAM_ALTERAR_TESTE = "alterarTeste";
	public final String VALOR_PARAM_VISUALIZAR_TESTE = "visualizarTeste";
	public final String VALOR_PARAM_EXCLUIR_TESTE = "excluirTeste";

	public final String URL_METODO_CONFIRMAR_TESTE = "confirmarTeste";
	public final String NOME_PARAM_CONFIRMAR_TESTE_URL = "confirmarURL";

	public final String URL_METODO_CANCELAR_TESTE = "cancelarTeste";
	public final String NOME_PARAM_CANCELAR_TESTE_URL = "cancelarURL";

	public final String NOME_PARAM_OPERACAO_TESTE = "operacaoTeste";

	public final String VALOR_PARAM_TITULO_TESTE_PRINCIPAL = "label.teste.titulo.principal";
	public final String VALOR_PARAM_TITULO_TESTE_NOVO = "label.teste.titulo.novo";
	public final String VALOR_PARAM_TITULO_TESTE_ALTERAR = "label.teste.titulo.alterar";
	public final String VALOR_PARAM_TITULO_TESTE_EXCLUIR = "label.teste.titulo.excluir";
	public final String VALOR_PARAM_TITULO_TESTE_VISUALIZAR = "label.teste.titulo.visualizar";

	public final String NOME_PARAM_LISTA_TESTE = "listaTeste";

	public final String NOME_PARAM_TESTE_ERROR = "testeErrorVO";

	public final String NOME_PARAM_TESTE_VO = "testeVO";

	public final String PROP_TESTE_ID = "idTeste";
	public final String PROP_TESTE_TITULO = "titulo";
	public final String PROP_TESTE_DESCRICAO = "descricao";
	public final String PROP_TESTE_ATIVO = "ativo";


	public final String MTH_FILTRAR_TESTE_POR_TITULO = "filtroTitulo";

	public final String MSG_TESTE_ERRO = "mensagem.teste.erro";

	public final String TITULO_PORTLET = "portletTitulo";
	public final String PREF_EXIBIR_TITULO = "prefExibirTitulo";
	public final String EXIBIR_TITULO = "exibirTitulo";
	public final String SOMENTE_USUARIO_LOGADO = "somenteUsuarioLogado";
	
	public final String JSP_CADASTRO_CONFIG = "/html/cadastroportlet/configuracao.jsp";
	
	public final String TESTE_ID = "testeId";
	
	/*
	 * Cadastro pergunta
	 */
	public final String JSP_CADASTRO_PERGUNTA = "cadastroPergunta-jsp";
	public final String JSP_VISUALIZAR_PERGUNTA = "visualizarPergunta-jsp";

	public final String NOME_PARAM_LISTA_PERGUNTA = "listaPergunta";

	public final String NOME_PARAM_PERGUNTA_ERROR = "perguntaErrorVO";
	public final String NOME_PARAM_LISTA_PERGUNTA_VO = "listaPerguntaVO";

	public final String NOME_PARAM_ID_PERGUNTA = "idPergunta";
	public final String NOME_PARAM_FILTRO_PERGUNTA = "filtroPergunta";

	public final String URL_METODO_PREPARAR_NOVA_PERGUNTA = "prepararNovaPergunta";
	public final String NOME_PARAM_NOVA_PERGUNTA_URL = "novoURL";
	public final String VALOR_PARAM_NOVA_PERGUNTA = "novaPergunta";

	public final String URL_METODO_FILTRAR_PERGUNTA = "filtrarPergunta";
	public final String NOME_PARAM_FILTRAR_PERGUNTA_URL = "filtrarURL";

	public final String VALOR_PARAM_ALTERAR_PERGUNTA = "alterarPergunta";
	public final String VALOR_PARAM_VISUALIZAR_PERGUNTA = "visualizarPergunta";
	public final String VALOR_PARAM_EXCLUIR_PERGUNTA = "excluirPergunta";
	public final String VALOR_PARAM_LISTAR_PERGUNTA = "listarPergunta";

	public final String URL_METODO_CONFIRMAR_PERGUNTA = "confirmarPergunta";
	public final String NOME_PARAM_CONFIRMAR_PERGUNTA_URL = "confirmarURL";

	public final String URL_METODO_CANCELAR_PERGUNTA = "cancelarPergunta";
	public final String NOME_PARAM_CANCELAR_PERGUNTA_URL = "cancelarURL";

	public final String NOME_PARAM_OPERACAO_PERGUNTA = "operacaoPergunta";

	public final String VALOR_PARAM_TITULO_PERGUNTA_NOVO = "label.pergunta.titulo.novo";
	public final String VALOR_PARAM_TITULO_PERGUNTA_ALTERAR = "label.pergunta.titulo.alterar";
	public final String VALOR_PARAM_TITULO_PERGUNTA_EXCLUIR = "label.pergunta.titulo.excluir";
	public final String VALOR_PARAM_TITULO_PERGUNTA_VISUALIZAR = "label.pergunta.titulo.visualizar";

	public final String NOME_PARAM_PERGUNTA_VO = "perguntaVO";

	public final String PROP_PERGUNTA_ID = "idPergunta";
	public final String PROP_PERGUNTA_DESCRICAO = "descricao";
	public final String PROP_PERGUNTA_JUSTIFICATIVA_RESPOSTA = "justificativaResposta";
	public final String PROP_PERGUNTA_PONTUACAO = "pontuacao";

	public final String MSG_PERGUNTA_ERRO = "mensagem.teste.erro";

	public final String VALOR_PARAM_FILTRAR_TESTE = "filtrarTeste";

	public final String PERGUNTA_ID = "perguntaId";
	
	/*
	 * Cadastro resposta
	 */
	public final String JSP_CADASTRO_RESPOSTA = "cadastroResposta-jsp";
	public final String JSP_VISUALIZAR_RESPOSTA = "visualizarResposta-jsp";

	public final String NOME_PARAM_LISTA_RESPOSTA = "listaResposta";

	public final String NOME_PARAM_RESPOSTA_ERROR = "respostaErrorVO";

	public final String NOME_PARAM_ID_RESPOSTA = "idResposta";
	public final String NOME_PARAM_FILTRO_RESPOSTA = "filtroResposta";

	public final String URL_METODO_PREPARAR_NOVA_RESPOSTA = "prepararNovaResposta";
	public final String NOME_PARAM_NOVA_RESPOSTA_URL = "novoURL";
	public final String VALOR_PARAM_NOVA_RESPOSTA = "novaResposta";

	public final String URL_METODO_FILTRAR_RESPOSTA = "filtrarResposta";
	public final String NOME_PARAM_FILTRAR_RESPOSTA_URL = "filtrarURL";

	public final String VALOR_PARAM_ALTERAR_RESPOSTA = "alterarResposta";
	public final String VALOR_PARAM_VISUALIZAR_RESPOSTA = "visualizarResposta";
	public final String VALOR_PARAM_EXCLUIR_RESPOSTA = "excluirResposta";
	public final String VALOR_PARAM_LISTAR_RESPOSTA = "listarResposta";

	public final String URL_METODO_CONFIRMAR_RESPOSTA = "confirmarResposta";
	public final String NOME_PARAM_CONFIRMAR_RESPOSTA_URL = "confirmarURL";

	public final String URL_METODO_CANCELAR_RESPOSTA = "cancelarResposta";
	public final String NOME_PARAM_CANCELAR_RESPOSTA_URL = "cancelarURL";

	public final String NOME_PARAM_OPERACAO_RESPOSTA = "operacaoResposta";

	public final String VALOR_PARAM_TITULO_RESPOSTA_NOVO = "label.resposta.titulo.novo";
	public final String VALOR_PARAM_TITULO_RESPOSTA_ALTERAR = "label.resposta.titulo.alterar";
	public final String VALOR_PARAM_TITULO_RESPOSTA_EXCLUIR = "label.resposta.titulo.excluir";
	public final String VALOR_PARAM_TITULO_RESPOSTA_VISUALIZAR = "label.resposta.titulo.visualizar";

	public final String NOME_PARAM_RESPOSTA_VO = "respostaVO";

	public final String PROP_RESPOSTA_ID = "idResposta";
	public final String PROP_RESPOSTA_DESCRICAO = "descricao";
	public final String PROP_RESPOSTA_CORRETA = "correta";

	public final String VALOR_PARAM_FILTRAR_RESPOSTA = "filtrarResposta";

	public final String MSG_RESPOSTA_ERRO = "mensagem.teste.erro";

	public final String VALOR_PARAM_FILTRAR_PERGUNTA = "filtrarPergunta";

	/*
	 * Teste exibir
	 */
	public final String URL_METODO_ANTERIOR = "anterior";
	public final String URL_METODO_PROXIMA = "proxima";
	public final String URL_METODO_ENVIAR_TESTE = "enviar";
	public final String URL_METODO_ACAO_TESTE = "acao";
	public final String NOME_PARAM_ACAO_URL = "acaoURL";
	public final String URL_METODO_VOLTAR_INICIO = "voltarInicio";

	public final String NOME_PARAM_VOTLAR_INICIO_URL = "voltarInicioURL";

	public final String VALOR_PARAM_CONFIRMAR = "confirmar";
	public final String VALOR_PARAM_PROXIMA = "proxima";
	public final String VALOR_PARAM_ENVIAR = "enviar";
	public final String VALOR_PARAM_ERRO = "erro";
	public final String VALOR_PARAM_FIM = "fim";
	public final String VALOR_PARAM_INICIO = "inicio";

	public final String PROP_TESTE_NOME = "nome";
	public final String PROP_TESTE_EMAIL = "email";
	public final String PROP_TESTE_USUARIO_LOGADO = "usuarioLogado";

	public final String NOME_PARAM_PAGINA = "pagina";
	public final String NOME_PARAM_PERGUNTAS_LIDAS = "perguntasLidas";
	public final String NOME_PARAM_TOTAL_PAGINAS = "totalPaginas";
	public final String NOME_PARAM_TOTAL_PERGUNTAS_PAGINA = "totalPerguntasPagina";
	public final String NOME_PARAM_PERGUNTA_INICIO = "perguntaInicio";
	public final String NOME_PARAM_ACAO = "acao";

	public final String NOME_PARAM_MAP_PERGUNTAS_RESPONDIDOS = "mapPerguntasRespondidos";

	public final String NOME_PARAM_PRECISA_RESPONDER = "precisaResponder";

	public final String NOME_PARAM_JUSTIFICATIVA = "justificativa";
	public final String NOME_PARAM_USUARIO_RESPONDEU = "usuarioRespondeu";

	public final String NOME_PARAM_RESPOSTA_CERTA = "respostaCerta";

	public final String NOME_PARAM_ORDENACAO = "ordenacao";

	public final String PREF_ID_TESTE = "prefIdTeste";
	public final String PREF_CONFIGURADO = "prefConfigurado";
	public final String PREF_ENVIAR_EMAIL = "prefEnviarEmail";
	public final String PREF_EXIBIR_ACERTO = "prefExibirAcerto";


	/*
	 * Teste Estatística
	 */
	public final String URL_METODO_GERAR = "gerar";
	public final String NOME_PARAM_GERAR_URL = "gerarURL";

	public final String VALOR_PARAM_GERAR = "gerar";

	public final String TOTAL_TESTE_RESPONDIDO = "totalTesteRespondido";

	public final String NOME_PARAM_LISTA_TESTE_USUARIO = "listaTesteUsuario";

	/*
	 * Cadastro teste resultado
	 */
	public final String JSP_CADASTRO_TESTE_RESULTADO = "cadastroTesteResultado-jsp";
	public final String JSP_VISUALIZAR_TESTE_RESULTADO = "visualizarTesteResultado-jsp";

	public final String NOME_PARAM_LISTA_TESTE_RESULTADO = "listaTesteResultado";

	public final String NOME_PARAM_TESTE_RESULTADO_ERROR = "perguntaErrorVO";

	public final String NOME_PARAM_ID_TESTE_RESULTADO = "idTesteResultado";
	public final String NOME_PARAM_FILTRO_TESTE_RESULTADO = "filtroTesteResultado";

	public final String URL_METODO_PREPARAR_NOVA_TESTE_RESULTADO = "prepararNovaTesteResultado";
	public final String NOME_PARAM_NOVA_TESTE_RESULTADO_URL = "novaTesteResultadoURL";
	public final String VALOR_PARAM_NOVA_TESTE_RESULTADO = "novaTesteResultado";

	public final String URL_METODO_FILTRAR_TESTE_RESULTADO = "filtrarTesteResultado";
	public final String NOME_PARAM_FILTRAR_TESTE_RESULTADO_URL = "filtrarURL";

	public final String VALOR_PARAM_ALTERAR_TESTE_RESULTADO = "alterarTesteResultado";
	public final String VALOR_PARAM_VISUALIZAR_TESTE_RESULTADO = "visualizarTesteResultado";
	public final String VALOR_PARAM_EXCLUIR_TESTE_RESULTADO = "excluirTesteResultado";
	public final String VALOR_PARAM_LISTAR_TESTE_RESULTADO = "listarTesteResultado";

	public final String URL_METODO_CONFIRMAR_TESTE_RESULTADO = "confirmarTesteResultado";
	public final String NOME_PARAM_CONFIRMAR_TESTE_RESULTADO_URL = "confirmarURL";

	public final String URL_METODO_CANCELAR_TESTE_RESULTADO = "cancelarTesteResultado";
	public final String NOME_PARAM_CANCELAR_TESTE_RESULTADO_URL = "cancelarURL";

	public final String NOME_PARAM_OPERACAO_TESTE_RESULTADO = "operacaoTesteResultado";

	public final String VALOR_PARAM_TITULO_TESTE_RESULTADO_NOVO = "label.testeResultado.titulo.novo";
	public final String VALOR_PARAM_TITULO_TESTE_RESULTADO_ALTERAR = "label.testeResultado.titulo.alterar";
	public final String VALOR_PARAM_TITULO_TESTE_RESULTADO_EXCLUIR = "label.testeResultado.titulo.excluir";
	public final String VALOR_PARAM_TITULO_TESTE_RESULTADO_VISUALIZAR = "label.testeResultado.titulo.visualizar";

	public final String NOME_PARAM_TESTE_RESULTADO_VO = "testeResultadoVO";

	public final String PROP_TESTE_RESULTADO_ID = "idTesteResultado";
	public final String PROP_TESTE_RESULTADO_DESCRICAO = "descricaoTesteResultado";
	public final String PROP_TESTE_RESULTADO_QTDE_INICIAL = "qtdeInicialTesteResultado";
	public final String PROP_TESTE_RESULTADO_QTDE_FINAL = "qtdeFinalTesteResultado";

	public final String MSG_TESTE_RESULTADO_ERRO = "mensagem.teste.erro";

	public final String JSP_RESULTADO_CONFIG = "/html/resultadoportlet/configuracao.jsp";
	public final String JSP_CONSULTA_CONFIG = "/html/consultaportlet/configuracao.jsp";
}
