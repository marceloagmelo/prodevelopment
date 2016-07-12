package br.com.prodevelopment.pesquisaopiniao;

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
	public final String MSG_ERRO_ENVIAR_EMAIL = "mensagem.erro.enviarEmail";
	public final String MSG_ERRO_GRAVAR_BANCO_DADOS = "mensagem.erro.gravar.bancoDados";
	public final String MSG_PORTLET_NAO_CONFIGURADO = "mensagem.portlet.naoConfigurado";

	public final String VAZIO = "";
	public final String N = "N";
	public final String NAO = "Não";
	public final String S = "S";
	public final String SIM = "Sim";
	public final String TRALHA = "#";
	public final String ZERO = "0";
	public final String UM = "1";
	public final String PERCENTE = "%";
	public final String CEM = "100";
	public final String VIRGULA = ",";
	public final String BR = "<br>";

	public final String PORTLET_ACTION = "javax.portlet.action";

	public final String NOME_PARAM_ID = "id";

	public final String NOME_PARAM_METODO = "metodo";

	public final DateFormat FORMATO_DATA_BR = new SimpleDateFormat("dd/MM/yyyy");

	public final String NOME_PARAM_ADD_PERMISSAO = "hasAddPermission";
	public final String NOME_PARAM_VIEW_PERMISSAO = "hasViewPermission";
	public final String NOME_PARAM_EDIT_PERMISSAO = "hasEditPermission";
	public final String NOME_PARAM_DELETE_PERMISSAO = "hasDeletePermission";
	public final String NOME_PARAM_CONFIG_PERMISSAO = "hasConfigurePermission";

	public final String NOME_PARAM_TITULO = "titulo";

	public final String COMPANY_ID = "companyId";
	public final String GROUP_ID = "groupId";
	public final String ID = "id";
	public final String TITULO = "titulo";
	public final String ATIVA = "ativa";
	public final String NOME = "nome";
	public final String EMAIL = "email";
	public final String USER_ID = "userId";
	
	public final String TITULO_PORTLET = "portletTitulo";
	public final String PREF_EXIBIR_TITULO = "prefExibirTitulo";
	public final String EXIBIR_TITULO = "exibirTitulo";
	public final String SOMENTE_USUARIO_LOGADO = "somenteUsuarioLogado";
	
	public final String PT_BR = "pt_BR";
	
	public final String NOME_PARAM_TITULO_PORTLET = "portletTitulo";
	public final String NOME_PARAM_EXIBIR_TITULO="exibirTitulo";
	
	/*
	 * Cadastro pesquisa
	 */
	public final String JSP_VIEW_PESQUISA = "viewPesquisa-jsp";
	public final String JSP_CADASTRO_PESQUISA = "cadastroPesquisa-jsp";
	public final String JSP_VISUALIZAR_PESQUISA = "visualizarPesquisa-jsp";
	public final String JSP_CADASTRO_CONFIG = "/html/cadastroportlet/configuracao.jsp";

	public final String PACKAGE_MODELO = "br.com.prodevelopment.pesquisaopiniao.model";
	public final String PACKAGE_OBJETO = "br.com.prodevelopment.pesquisaopiniao.model.Pesquisa";
	public final String ADD_PESQUISA = "ADD_PESQUISA";

	public final String NOME_PARAM_ID_PESQUISA = "idPesquisa";
	public final String NOME_PARAM_FILTRO_PESQUISA = "filtroPesquisa";

	public final String URL_METODO_PREPARAR_NOVA_PESQUISA = "prepararNovaPesquisa";
	public final String NOME_PARAM_NOVA_PESQUISA_URL = "novoURL";
	public final String VALOR_PARAM_NOVA_PESQUISA = "novaPesquisa";

	public final String URL_METODO_FILTRAR_PESQUISA = "filtrarPesquisa";
	public final String NOME_PARAM_FILTRAR_PESQUISA_URL = "filtrarURL";

	public final String VALOR_PARAM_ALTERAR_PESQUISA = "alterarPesquisa";
	public final String VALOR_PARAM_VISUALIZAR_PESQUISA = "visualizarPesquisa";
	public final String VALOR_PARAM_EXCLUIR_PESQUISA = "excluirPesquisa";

	public final String URL_METODO_CONFIRMAR_PESQUISA = "confirmarPesquisa";
	public final String NOME_PARAM_CONFIRMAR_PESQUISA_URL = "confirmarURL";

	public final String URL_METODO_CANCELAR_PESQUISA = "cancelarPesquisa";
	public final String NOME_PARAM_CANCELAR_PESQUISA_URL = "cancelarURL";

	public final String NOME_PARAM_OPERACAO_PESQUISA = "operacaoPesquisa";

	public final String VALOR_PARAM_TITULO_PESQUISA_PRINCIPAL = "label.pesquisa.titulo.principal";
	public final String VALOR_PARAM_TITULO_PESQUISA_NOVO = "label.pesquisa.titulo.novo";
	public final String VALOR_PARAM_TITULO_PESQUISA_ALTERAR = "label.pesquisa.titulo.alterar";
	public final String VALOR_PARAM_TITULO_PESQUISA_EXCLUIR = "label.pesquisa.titulo.excluir";
	public final String VALOR_PARAM_TITULO_PESQUISA_VISUALIZAR = "label.pesquisa.titulo.visualizar";

	public final String NOME_PARAM_LISTA_PESQUISA = "listaPesquisa";

	public final String NOME_PARAM_PESQUISA_ERROR = "pesquisaErrorVO";

	public final String NOME_PARAM_PESQUISA_VO = "pesquisaVO";

	public final String PROP_PESQUISA_ID = "idPesquisa";
	public final String PROP_PESQUISA_TITULO = "titulo";
	public final String PROP_PESQUISA_DESCRICAO = "descricao";
	public final String PROP_PESQUISA_ATIVA = "ativa";

	public final String MTH_FILTRAR_PESQUISA_POR_TITULO = "filtroTitulo";

	public final String MSG_PESQUISA_ERRO = "mensagem.pesquisa.erro";

	public final String DEFAULT_LINHAS_PAGINA = "10";
	
	public final String PESQUISA_ID = "pesquisaId";
	public final String PESQUISA_USUARIO_ID = "pesquisaUsuarioId";
	public final String PESQUISA = "pesquisa";

	public final String MSG_EXISTE_PERGUNTA_CADASTRADA = "mensagem.pesquisa.existe.perguntaCadastrada";
	public final String MSG_PESQUISA_EXCLUIDA_SUCESSO = "mensagem.pesquisa.excluida.sucesso";
	public final String MSG_PESQUISA_CRIADA_SUCESSO = "mensagem.pesquisa.criada.sucesso";
	public final String MSG_PESQUISA_ALTERADA_SUCESSO = "mensagem.pesquisa.alterada.sucesso";
	public final String MSG_PESQUISA_NAO_RESPONDIDA = "mensagem.pesquisaRelatorio.pesquisaNaoRespondida";
	public final String MSG_PESQUISA_NAO_ENCONTRADA = "mensagem.erro.pesquisaNaoEncontrada";
	
	public final String MSG_EMAIL_OBRIGADO_PESQUISA_RESPONDIDA = "mensagem.email.obrigado.pesquisa.respondida";
	public final String MSG_EMAIL_VEJA_RESPOSTAS = "mensagem.email.veja.respostas";
	public final String MSG_EMAIL_PERGUNTA = "mensagem.email.pergunta";
	public final String MSG_EMAIL_RESPOSTA = "mensagem.email.resposta";
	public final String MSG_EMAIL_ATENCIOSAMENTE = "mensagem.email.atenciosamente";
	public final String MSG_EMAIL_PORTAL = "mensagem.email.portal";
	
	/*
	 * Cadastro pergunta
	 */
	public final String JSP_CADASTRO_PERGUNTA = "cadastroPergunta-jsp";
	public final String JSP_VISUALIZAR_PERGUNTA = "visualizarPergunta-jsp";

	public final String NOME_PARAM_LISTA_PERGUNTA = "listaPergunta";
	public final String NOME_PARAM_LISTA_PERGUNTA_VO = "listaPerguntaVO";

	public final String NOME_PARAM_PERGUNTA_ERROR = "perguntaErrorVO";

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

	public final String MSG_PERGUNTA_ERRO = "mensagem.pesquisa.erro";

	public final String VALOR_PARAM_FILTRAR_PESQUISA = "filtrarPesquisa";
	
	public final String PERGUNTA_ID = "perguntaId";
	
	public final String MSG_EXISTE_RESPOSTA_CADASTRADA = "mensagem.pergunta.existe.respostaCadastrada";
	public final String MSG_PERGUNTA_EXCLUIDA_SUCESSO = "mensagem.pergunta.excluida.sucesso";
	public final String MSG_PERGUNTA_CRIADA_SUCESSO = "mensagem.pergunta.criada.sucesso";
	public final String MSG_PERGUNTA_ALTERADA_SUCESSO = "mensagem.pergunta.alterada.sucesso";

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

	public final String VALOR_PARAM_FILTRAR_RESPOSTA = "filtrarResposta";

	public final String MSG_RESPOSTA_ERRO = "mensagem.pesquisa.erro";

	public final String VALOR_PARAM_FILTRAR_PERGUNTA = "filtrarPergunta";
	
	public final String MSG_RESPOSTA_EXCLUIDA_SUCESSO = "mensagem.resposta.excluida.sucesso";
	public final String MSG_RESPOSTA_CRIADA_SUCESSO = "mensagem.resposta.criada.sucesso";
	public final String MSG_RESPOSTA_ALTERADA_SUCESSO = "mensagem.resposta.alterada.sucesso";

	/*
	 * Pesquisa exibir
	 */
	public final String JSP_EXIBIR_CONFIG = "/html/exibirportlet/configuracao.jsp";

	public final String URL_METODO_ANTERIOR = "anterior";
	public final String URL_METODO_PROXIMA = "proxima";
	public final String URL_METODO_ENVIAR_PESQUISA = "enviar";
	public final String URL_METODO_ACAO_PESQUISA = "acao";
	public final String URL_METODO_VOLTAR_INICIO = "voltarInicio";

	public final String NOME_PARAM_ACAO_URL = "acaoURL";
	public final String NOME_PARAM_VOTLAR_INICIO_URL = "voltarInicioURL";


	public final String VALOR_PARAM_ANTERIOR = "anterior";
	public final String VALOR_PARAM_PROXIMA = "proxima";
	public final String VALOR_PARAM_ENVIAR = "enviar";
	public final String VALOR_PARAM_ERRO = "erro";
	public final String VALOR_PARAM_FIM = "fim";

	public final String PROP_PESQUISA_NOME = "nome";
	public final String PROP_PESQUISA_EMAIL = "email";
	public final String PROP_PESQUISA_USUARIO_LOGADO = "usuarioLogado";

	public final String NOME_PARAM_PAGINA = "pagina";
	public final String NOME_PARAM_PERGUNTAS_LIDAS = "perguntasLidas";
	public final String NOME_PARAM_TOTAL_PAGINAS = "totalPaginas";
	public final String NOME_PARAM_TOTAL_PERGUNTAS_PAGINA = "totalPerguntasPagina";
	public final String NOME_PARAM_PERGUNTA_INICIO = "perguntaInicio";
	public final String NOME_PARAM_ACAO = "acao";

	public final String NOME_PARAM_MAP_PERGUNTAS_RESPONDIDAS = "mapPerguntasRespondidas";

	public final String PREF_ID_PESQUISA = "prefIdPesquisa";
	public final String PREF_ANONIMA = "prefAnonima";
	public final String PREF_ENVIAR_EMAIL = "prefEnviarEmail";
	public final String PREF_CONFIGURADO = "prefConfigurado";

	public final String MSG_PESQUISA_FINALIZADA_SUCESSO = "mensagem.pesquisaUsuario.finalizada.sucesso";
	public final String MSG_PESQUISA_NOME_OBRIGATORIO = "mensagem.pesquisaUsuario.nome.obrigatorio";
	public final String MSG_PESQUISA_EMAIL_OBRIGATORIO = "mensagem.pesquisaUsuario.email.obrigatorio";
	public final String MSG_PESQUISA_USUARIO_RESPONDEU = "mensagem.pesquisaUsuario.jaRespondeu";
	public final String MSG_PESQUISA_SELECIONE_RESPOSTA = "mensagem.pesquisaUsuario.selecione.resposta";
	
	public final String RESOURCE_BUNDLE = "resourceBundle";

	/*
	 * Pesquisa resultado
	 */
	public final String JSP_RESULTADO_CONFIG = "/html/resultadoportlet/configuracao.jsp";
	public final String JSP_CONSULTA_CONFIG = "/html/consultaportlet/configuracao.jsp";

	public final String URL_METODO_GERAR = "gerar";
	public final String NOME_PARAM_GERAR_URL = "gerarURL";

	public final String VALOR_PARAM_GERAR = "gerar";

	public final String TOTAL_PESQUISA_RESPONDIDA = "totalPesquisaRespondida";

	public final String NOME_PARAM_LISTA_PESQUISA_USUARIO = "listaPesquisaUsuario";
	
	public final String MSG_PESQUISA_NAO_RSPONDIDA = "mensagem.pesquisaEstatistica.pesquisaNaoRespondida";
}
