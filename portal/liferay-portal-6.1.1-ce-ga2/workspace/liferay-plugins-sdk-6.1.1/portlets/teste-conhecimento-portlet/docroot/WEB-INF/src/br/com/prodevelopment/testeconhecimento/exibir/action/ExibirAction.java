package br.com.prodevelopment.testeconhecimento.exibir.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.testeconhecimento.Constantes;
import br.com.prodevelopment.testeconhecimento.NoSuchTesteException;
import br.com.prodevelopment.testeconhecimento.cadastro.action.RespostaAction;
import br.com.prodevelopment.testeconhecimento.model.Pergunta;
import br.com.prodevelopment.testeconhecimento.model.Resposta;
import br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario;
import br.com.prodevelopment.testeconhecimento.model.Teste;
import br.com.prodevelopment.testeconhecimento.model.Teste_Usuario;
import br.com.prodevelopment.testeconhecimento.model.impl.PerguntaImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.RespostaImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.Resposta_UsuarioImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.TesteImpl;
import br.com.prodevelopment.testeconhecimento.model.impl.Teste_UsuarioImpl;
import br.com.prodevelopment.testeconhecimento.service.PerguntaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.RespostaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.Resposta_UsuarioLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.TesteLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.Teste_UsuarioLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.util.Helper;
import br.com.prodevelopment.testeconhecimento.vo.PerguntaVO;
import br.com.prodevelopment.testeconhecimento.vo.RespostaUsuarioVO;
import br.com.prodevelopment.testeconhecimento.vo.RespostaVO;
import br.com.prodevelopment.testeconhecimento.vo.TesteUsuarioVO;
import br.com.prodevelopment.testeconhecimento.vo.TesteVO;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ExibirAction {

	public static int perguntasLidas = 0;
	public static int totalPerguntas = 0;
	public static int totalRespostas = 0;
	public static int totalPaginas = 0;
	public static long idPergunta = 0;

	public static void inicio(RenderRequest req, RenderResponse res, long id)
			throws Exception {

		// Limpar o mapa de perguntas respondidas da sessão
		req.getPortletSession().removeAttribute(
				Constantes.NOME_PARAM_MAP_PERGUNTAS_RESPONDIDOS);

		perguntasLidas = 0;
		totalPaginas = 0;

		int pagina = 1;
		int totalPerguntasPagina = 1;
		int perguntaInicio = 1;
		int quantidadePerguntasPagina = 1;

		List<String> errors = new ArrayList<String>();
		try {
			// Recuperar teste
			Teste teste = TesteLocalServiceUtil.getTeste(id);
			TesteVO testeVO = getTesteVOFromTeste(teste);

			// Recuperar perguntas da teste
			List<Pergunta> listaPerguntas = recuperarPerguntas(id);
			testeVO.setPerguntas(recuperarPerguntasVO(listaPerguntas));

			// Calcular o total de páginas
			int i = 0;
			while (i < listaPerguntas.size()) {
				totalPaginas++;
				i = i + quantidadePerguntasPagina;
			}

			// Calcular o número da pergunta inicial
			perguntaInicio = perguntasLidas - testeVO.getPerguntas().size();

			totalPerguntasPagina = testeVO.getPerguntas().size();

			// Montar objetos request
			req.setAttribute(Constantes.NOME_PARAM_TESTE_VO, testeVO);
			req.setAttribute(Constantes.NOME_PARAM_PAGINA,
					String.valueOf(pagina));
			req.setAttribute(Constantes.NOME_PARAM_TOTAL_PAGINAS,
					String.valueOf(totalPaginas));
			req.setAttribute(Constantes.NOME_PARAM_TOTAL_PERGUNTAS_PAGINA,
					String.valueOf(totalPerguntasPagina));
			req.setAttribute(Constantes.NOME_PARAM_PERGUNTA_INICIO,
					String.valueOf(perguntaInicio));
			req.setAttribute(Constantes.NOME_PARAM_PERGUNTAS_LIDAS,
					String.valueOf(perguntasLidas));
			req.setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
					String.valueOf(idPergunta));
			req.setAttribute(Constantes.VALOR_PARAM_INICIO,
					String.valueOf(Constantes.INICIO));

			PortletURL acaoURL = res.createActionURL();
			acaoURL.setParameter(Constantes.PORTLET_ACTION,
						Constantes.URL_METODO_ACAO_TESTE);
			req.setAttribute(Constantes.NOME_PARAM_ACAO_URL, acaoURL.toString());
		} catch (NoSuchTesteException e) {
			errors.add("mensagem.erro.testeNaoEncontrado");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		} catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	public static void renderiza(RenderRequest req, RenderResponse res,
			long id, int pagina) throws Exception {

		List<String> errors = new ArrayList<String>();
		try {
			// Recuperar teste
			Teste teste = recuperarTeste(id);
			TesteVO testeVO = getTesteVOFromTeste(teste);

			// Recuperar perguntas da teste
			List<Pergunta> listaPerguntas = recuperarPerguntas(id);
			testeVO.setPerguntas(recuperarPerguntasVO(listaPerguntas));

			// Calcular o número da pergunta inicial
			int perguntaInicio = perguntasLidas - testeVO.getPerguntas().size();

			// Montar objetos request
			req.setAttribute(Constantes.NOME_PARAM_TESTE_VO, testeVO);
			req.setAttribute(Constantes.NOME_PARAM_PAGINA,
					String.valueOf(pagina));
			req.setAttribute(Constantes.NOME_PARAM_TOTAL_PAGINAS,
					String.valueOf(totalPaginas));
			req.setAttribute(Constantes.NOME_PARAM_TOTAL_PERGUNTAS_PAGINA,
					String.valueOf(testeVO.getPerguntas().size()));
			req.setAttribute(Constantes.NOME_PARAM_PERGUNTA_INICIO,
					String.valueOf(perguntaInicio));
			req.setAttribute(Constantes.NOME_PARAM_PERGUNTAS_LIDAS,
					String.valueOf(perguntasLidas));
			req.setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
					String.valueOf(idPergunta));

			PortletURL acaoURL = res.createActionURL();
			acaoURL.setParameter(Constantes.PORTLET_ACTION,
					Constantes.URL_METODO_ACAO_TESTE);
			req.setAttribute(Constantes.NOME_PARAM_ACAO_URL, acaoURL.toString());
		} catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	public static void enviar(ActionRequest req, ActionResponse res, String id, String enviarEmail, String resourceBundle)
			throws Exception {
		List<String> errors = new ArrayList<String>();
		try {
	        HttpServletRequest httpReq = PortalUtil
	        .getOriginalServletRequest(PortalUtil
	                .getHttpServletRequest(req));

	        StringBuffer bfCorpoEmail = new StringBuffer();

			// Recuperar dados do usuário
			User usuario = ExibirAction.recuperarUsuario(req);

			// Recuperar o teste de teste de usuário
			DynamicQuery testeUsuarioQuery = DynamicQueryFactoryUtil
					.forClass(Teste_Usuario.class);
			Criterion criteriaTeste = RestrictionsFactoryUtil.eq("testeId",
					Long.parseLong(id));
			testeUsuarioQuery.add(criteriaTeste);
			Criterion criteriaUsuario = RestrictionsFactoryUtil.eq("userId",
					usuario.getUserId());
			testeUsuarioQuery.add(criteriaUsuario);
			List<Teste_Usuario> listaTesteUsuario = (List<Teste_Usuario>) Teste_UsuarioLocalServiceUtil
					.dynamicQuery(testeUsuarioQuery);

			Teste teste = new TesteImpl();
			for (Teste_Usuario testeUsuario : listaTesteUsuario) {
				// Recuperar objeto de teste com o teste usuário
				teste = getTesteFromTesteUsuario(testeUsuario);

				// Atualizar o teste com finalização
				testeUsuario.setDataFinalizacao(new Date());
				testeUsuario = Teste_UsuarioLocalServiceUtil
						.updateTeste_Usuario(testeUsuario);

				// Preparar o corpo do email
				bfCorpoEmail.append(testeUsuario.getNome() + ",");
				bfCorpoEmail.append("<br>");
				bfCorpoEmail.append("<br>");
				bfCorpoEmail.append("Obrigado por ter respondido o teste ("
						+ teste.getTitulo() + ")");
				bfCorpoEmail.append("<br>");
				bfCorpoEmail.append("<br>");
				bfCorpoEmail.append("Segue abaixo as suas respostas:");

				// Recuperar as respostas do usuário
				DynamicQuery respostaUsuarioQuery = DynamicQueryFactoryUtil
						.forClass(Resposta_Usuario.class);
				Criterion criteriaTesteUsuario = RestrictionsFactoryUtil.eq(
						"testeUsuarioId", testeUsuario.getId());
				respostaUsuarioQuery.add(criteriaTesteUsuario);
				List<Resposta_Usuario> listaRespostaUsuario = (List<Resposta_Usuario>) Resposta_UsuarioLocalServiceUtil
						.dynamicQuery(respostaUsuarioQuery);

				for (Resposta_Usuario respostaUsuario : listaRespostaUsuario) {
					// Montar resposta com resposta usuário
					Resposta resposta = getRespostaFromRespostaUsuario(respostaUsuario);
					// respostaUsuario.setRespostaId(resposta.getId());

					// Montar pergunta com resposta
					Pergunta pergunta = getPerguntaFromResposta(resposta);

					// Montar dados do email
					bfCorpoEmail.append("<br>");
					bfCorpoEmail.append("<br>");
					bfCorpoEmail.append("<b>Pergunta: "
							+ pergunta.getDescricaoCurrentValue() + "</b>");
					bfCorpoEmail.append("<br>");
					if (Constantes.S.equals(respostaUsuario.getCorreta())) {
						bfCorpoEmail.append("<i>Resposta: "
								+ resposta.getDescricaoCurrentValue() + "</i>");
					} else {
						bfCorpoEmail.append("<font color=''red'><i>Resposta: "
								+ resposta.getDescricaoCurrentValue() + "</i></font>");
					}
				}
				bfCorpoEmail.append("<br>");
				bfCorpoEmail.append("<br>");
				bfCorpoEmail.append("Atenciosamente,");
				bfCorpoEmail.append("<br>");
				bfCorpoEmail.append("<br>");
				bfCorpoEmail.append("Portal");
        		if (Constantes.S.equals(enviarEmail)) {
        			try {
        				enviarEmail(bfCorpoEmail.toString(), testeUsuario, teste, PortalUtil.getLocale(httpReq));
        			}
        			catch (Exception e) {
        				errors.add("mensagem.erro.enviarEmail");
        				for (String error : errors) {
        					SessionErrors.add(req, error);
        				}
        			}
        		}
				SessionMessages.add(req,
						"mensagem.testeaUsuario.finalizado.sucesso");
				res.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_FIM);
				break;
			}
		} catch (Exception e) {
			errors.add("mensagem.erro.gravar.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	private static void enviarEmail(String mensagem,
			Teste_Usuario testeUsuario, Teste teste, Locale locale) throws Exception {

		String body = mensagem;
		String subject = teste.getTitulo();

		ResourceBundle resource  = ResourceBundle.getBundle("content/exibir/Language", locale);  

		String fromName = resource.getString("email.assunto");
		String fromAddress = resource.getString("email.from");
		String toName = testeUsuario.getNome();
		String toAddress = testeUsuario.getEmail();

		InternetAddress from = new InternetAddress(fromAddress, fromName);

		InternetAddress to = new InternetAddress(toAddress, toName);

		MailMessage message = new MailMessage(from, to, subject, body, true);

		try {
			MailServiceUtil.sendEmail(message);
		}
		catch (Exception e) {
			new Exception(e.getMessage());
		}
	}

	private static Teste recuperarTeste(long id) throws Exception {

		Teste teste = null;
		try {
			// Recuperar a teste
			teste = TesteLocalServiceUtil.getTeste(id);
		} catch (Exception e) {
			e.getMessage();
		}
		return teste;
	}

	private static List<Pergunta> recuperarPerguntas(long idTeste)
			throws Exception {
		DynamicQuery perguntaQuery = DynamicQueryFactoryUtil
				.forClass(Pergunta.class);
		Criterion criteriaTeste = RestrictionsFactoryUtil
				.eq("testeId", idTeste);
		perguntaQuery.add(criteriaTeste);
		perguntaQuery.addOrder(OrderFactoryUtil.asc("id"));

		List<Pergunta> lista = (List<Pergunta>) PerguntaLocalServiceUtil
				.dynamicQuery(perguntaQuery);
		return lista;
	}

	public static List<Resposta> recuperarListaRespostasPorPergunta(long idPergunta)
			throws Exception {
		DynamicQuery respostaQuery = DynamicQueryFactoryUtil.forClass(Resposta.class);
		Criterion criteriaPergunta = RestrictionsFactoryUtil.eq("perguntaId", idPergunta);
		respostaQuery.add(criteriaPergunta);
		respostaQuery.addOrder(OrderFactoryUtil.asc("id"));

		List<Resposta> lista = (List<Resposta>)RespostaLocalServiceUtil.dynamicQuery(respostaQuery);
		return lista;
	}

	private static TesteVO getTesteVOFromTeste(Teste teste) {
		TesteVO testeVO = new TesteVO();

		if (teste != null) {
			testeVO.setId(String.valueOf(teste.getId()));
			testeVO.setTituloCorrente(teste.getTituloCurrentValue());
			testeVO.setDescricaoCorrente(teste.getDescricaoCurrentValue());
			testeVO.setAtivo(teste.getAtivo() == true ? Constantes.S
					: Constantes.N);

		}
		return testeVO;
	}

	private static Pergunta recuperarPergunta(long idPergunta) {
		Pergunta pergunta = new PerguntaImpl();
		try {
			// Localiza Pergunta
			pergunta = PerguntaLocalServiceUtil.getPergunta(idPergunta);
		} catch (Exception e) {
			e.getMessage();
		}
		return pergunta;
	}
	
	private static List<PerguntaVO> recuperarPerguntasVO(
			List<Pergunta> listaPerguntas) throws Exception {
		int totalPerguntas = listaPerguntas.size();

		// Recuperar a quantidade de perguntas por página
		int quantidadePerguntasPagina = 1;

		// Montar o controle de leitura das perguntas
		int perguntasInicio = perguntasLidas;
		int perguntasFim = perguntasLidas + (quantidadePerguntasPagina);
		if (perguntasFim > totalPerguntas) {
			perguntasFim = totalPerguntas;
		}

		List<PerguntaVO> lista = new ArrayList<PerguntaVO>(perguntasFim
				- perguntasInicio);

		// iniciar o contador de perguntas
		int iContadorPerguntas = 0;

		for (int i = perguntasInicio; i < perguntasFim; i++) {
			Pergunta pergunta = (Pergunta) listaPerguntas.get(i);
			PerguntaVO perguntaVO = new PerguntaVO();
			perguntaVO.setId(String.valueOf(pergunta.getId()));
			perguntaVO.setDescricaoCorrente(pergunta.getDescricaoCurrentValue().replaceAll(
					"\n", Constantes.BR));

			// Recuparar as respostas
			List<Resposta> listaRespostas = recuperarListaRespostasPorPergunta(pergunta.getId());
			perguntaVO.setRespostas(recuperarRespostasVO(listaRespostas));

			lista.add(perguntaVO);

			// Incrmenenta mais um ao número de perguntas lidas e ao contador de
			// perguntas
			iContadorPerguntas++;
			perguntasLidas++;
			idPergunta = pergunta.getId();
		}
		return lista;
	}

	private static List<RespostaVO> recuperarRespostasVO(
			List<Resposta> listaRespostas) throws Exception {
		List<RespostaVO> lista = new ArrayList<RespostaVO>(
				listaRespostas.size());

		for (Resposta resposta : listaRespostas) {
			RespostaVO respostaVO = new RespostaVO();
			respostaVO.setId(String.valueOf(resposta.getId()));
			respostaVO.setDescricaoCorrente(resposta.getDescricaoCurrentValue());
			lista.add(respostaVO);
		}
		return lista;
	}

	public static void gravarNoBanco(ActionRequest req, ActionResponse res,
			String id, Boolean correta, String pagina) throws Exception {
		// Recupera a quantidade total de perguntas
		String idPergunta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PERGUNTA);
		String idResposta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_RESPOSTA);

		// Instanciar o objeto de teste de usuário
		TesteUsuarioVO testeUsuarioVO = new TesteUsuarioVO();
		TesteVO testeVO = new TesteVO();
		testeVO.setId(id);
		testeUsuarioVO.setTesteVO(testeVO);

		// Instanciar o objeto de resposta de usuário
		RespostaUsuarioVO respostaUsuarioVO = new RespostaUsuarioVO();
		RespostaVO respostaVO = new RespostaVO();
		respostaVO.setId(idResposta);
		PerguntaVO perguntaVO = new PerguntaVO();
		perguntaVO.setId(idPergunta);
		respostaVO.setPerguntaVO(perguntaVO);
		respostaUsuarioVO.setRespostaVO(respostaVO);
		respostaUsuarioVO.setTesteUsuarioVO(testeUsuarioVO);
		respostaUsuarioVO.setCorreta(String.valueOf(correta));

		int totalRespostaCorreta = 0;
		int totalRespostaErrada = 0;

		// Recuperar pergunta para poder recuperar os pontos válidos para pergunta
		Pergunta pergunta = recuperarPergunta(Long.valueOf(idPergunta));

		double totalPontuacao = pergunta.getPontuacao();

		// Verifica se a resposta foi certa ou errada
		if (correta) {
			totalRespostaCorreta = 1;
		} else {
			totalRespostaErrada = 1;
			totalPontuacao = 0;
		}

		Teste_Usuario testeUsuario = null;
		if (GetterUtil.getInteger(pagina) == 1) {
			testeUsuario = new Teste_UsuarioImpl();

			// Recuperar objeto de teste usuário com o VO
			testeUsuario = getTesteUsuarioFromRespostaUsuarioVO(
					respostaUsuarioVO, testeUsuario);

			// Recuperar dados do usuário
			User usuario = ExibirAction.recuperarUsuario(req);
			if (!usuario.isDefaultUser()) {
				testeUsuario.setUserId(usuario.getUserId());
			}
			else {
				testeUsuario.setUserId(usuario.getUserId());
			}
			testeUsuario.setNome(usuario.getFullName());
			testeUsuario.setEmail(usuario.getEmailAddress());
			testeUsuario.setTotalRespostaCorreta(totalRespostaCorreta);
			testeUsuario.setTotalRespostaErrada(totalRespostaErrada);
			testeUsuario.setTotalPontuacao(totalPontuacao);

			testeUsuario = Teste_UsuarioLocalServiceUtil
					.addTeste_Usuario(testeUsuario);
		} else {
			// Recuperar dados do usuário
			User usuario = ExibirAction.recuperarUsuario(req);
			// Recuperar o teste de usuário
			testeUsuario = recuperarTesteUsuarioPorUsuario(Long.parseLong(id),
					usuario.getUserId());

			testeUsuario.setTotalRespostaCorreta(testeUsuario
					.getTotalRespostaCorreta() + totalRespostaCorreta);
			testeUsuario.setTotalRespostaErrada(testeUsuario
					.getTotalRespostaErrada() + totalRespostaErrada);
			testeUsuario.setTotalPontuacao(testeUsuario.getTotalPontuacao() + totalPontuacao);

			testeUsuario = Teste_UsuarioLocalServiceUtil.updateTeste_Usuario(testeUsuario);
		}
		// Montar resposta usuário
		Resposta_Usuario respostaUsuario = new Resposta_UsuarioImpl();
		respostaUsuario.setTesteUsuarioId(testeUsuario.getId());
		respostaUsuario = getRespostaUsuarioFromRespostaUsuarioVO(
				respostaUsuarioVO, respostaUsuario);
		// Executar a gravação da resposta usuário
		respostaUsuario = Resposta_UsuarioLocalServiceUtil
				.addResposta_Usuario(respostaUsuario);
	}

	public static void buscarTeste(RenderRequest req, RenderResponse res)
			throws Exception {

		// Recuperar a companhia e grupo
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long idGroup = themeDisplay.getScopeGroupId();
		long idCompany = themeDisplay.getCompanyId();

		List<String> errors = new ArrayList<String>();
		try {
			// Recuperar testes
			DynamicQuery testeQuery = DynamicQueryFactoryUtil
					.forClass(Teste.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq("companyId",
					idCompany);
			testeQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq("groupId",
					idGroup);
			testeQuery.add(criteriaGroup);
			testeQuery.addOrder(OrderFactoryUtil.asc("titulo"));

			List<Teste> listaTeste = (List<Teste>) TesteLocalServiceUtil
					.dynamicQuery(testeQuery);
			req.setAttribute(Constantes.NOME_PARAM_LISTA_TESTE, listaTeste);
		} catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	public static boolean jaRespondeu(String idTeste, String email)
			throws Exception {
		boolean retorno = false;

		DynamicQuery testeUsuarioQuery = DynamicQueryFactoryUtil
				.forClass(Teste_Usuario.class);
		Criterion criteriaTeste = RestrictionsFactoryUtil.eq("testeId",
				Long.parseLong(idTeste));
		testeUsuarioQuery.add(criteriaTeste);
		Criterion criteriaEmail = RestrictionsFactoryUtil.eq("email", email);
		testeUsuarioQuery.add(criteriaEmail);

		List<Teste_Usuario> lista = (List<Teste_Usuario>) Teste_UsuarioLocalServiceUtil
				.dynamicQuery(testeUsuarioQuery);

		retorno = lista.size() > 0;

		return retorno;
	}

	public static boolean jaRespondeu(String idTeste, long idUsuario)
			throws Exception {
		boolean retorno = false;

		DynamicQuery testeUsuarioQuery = DynamicQueryFactoryUtil
				.forClass(Teste_Usuario.class);
		Criterion criteriaTeste = RestrictionsFactoryUtil.eq("testeId",
				Long.parseLong(idTeste));
		testeUsuarioQuery.add(criteriaTeste);
		Criterion criteriaUsuario = RestrictionsFactoryUtil.eq("userId",
				idUsuario);
		testeUsuarioQuery.add(criteriaUsuario);

		List<Teste_Usuario> lista = (List<Teste_Usuario>) Teste_UsuarioLocalServiceUtil
				.dynamicQuery(testeUsuarioQuery);

		retorno = lista.size() > 0;

		return retorno;
	}

	private static Teste_Usuario getTesteUsuarioFromRespostaUsuarioVO(
			RespostaUsuarioVO respostaUsuarioVO, Teste_Usuario testeUsuario) {
		try {
			testeUsuario.setDataInclusao(Helper.getDataAtual().getTime());
			testeUsuario.setEmail(respostaUsuarioVO.getTesteUsuarioVO()
					.getEmail());
			testeUsuario.setNome(respostaUsuarioVO.getTesteUsuarioVO()
					.getNome());
			testeUsuario.setTesteId(Long.valueOf(respostaUsuarioVO
					.getTesteUsuarioVO().getTesteVO().getId()));
		} catch (Exception e) {
			e.getMessage();
		}
		return testeUsuario;
	}

	private static Resposta_Usuario getRespostaUsuarioFromRespostaUsuarioVO(
			RespostaUsuarioVO respostaUsuarioVO,
			Resposta_Usuario respostaUsuario) {
		try {
			respostaUsuario.setDataInclusao(Helper.getDataAtual().getTime());
			respostaUsuario.setCorreta(Boolean.valueOf(respostaUsuarioVO.getCorreta()));
			respostaUsuario.setRespostaId(Long.valueOf(respostaUsuarioVO
					.getRespostaVO().getId()));
		} catch (Exception e) {
			e.getMessage();
		}
		return respostaUsuario;
	}

	public static void confirmar(ActionRequest req, ActionResponse res,
			String idTeste, String pagina, String prefExibirAcerto) {
		// Recupera a quantidade total de perguntas
		String idResposta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_RESPOSTA);

		List<String> errors = new ArrayList<String>();

		try {
			// Recuperar a resposta para saber se esta correta
			Resposta resposta = RespostaAction.recuperarResposta(Long.valueOf(idResposta));
			if (resposta != null) {
				if (Constantes.S.equals(prefExibirAcerto)) {
					if (resposta.getCorreta()) {
						SessionMessages.add(req,
								"mensagem.testeUsuario.respostaCerta");
						res.setRenderParameter(
								Constantes.NOME_PARAM_RESPOSTA_CERTA, Constantes.S);
					} else {
						res.setRenderParameter(
								Constantes.NOME_PARAM_RESPOSTA_CERTA, Constantes.N);
					}
					// Recuperar pergunta com resposta
					Pergunta pergunta = getPerguntaFromResposta(resposta);

					String justificativa = pergunta.getJustificativaRespostaCurrentValue();
					String usuarioRespondeu = resposta.getDescricaoCurrentValue();
					res.setRenderParameter(Constantes.NOME_PARAM_JUSTIFICATIVA,
							justificativa);
					res.setRenderParameter(Constantes.NOME_PARAM_USUARIO_RESPONDEU,
							usuarioRespondeu);
				}
				else {
					SessionMessages.add(req,
							"mensagem.testeUsuario.perguntaRespondida");
				}
				gravarNoBanco(req, res, idTeste, resposta.getCorreta(), pagina);
			}
		} catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	public static User recuperarUsuario(RenderRequest req) {
		// Recuperar dados do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Recuperar dados do usuário
		return themeDisplay.getUser();
	}

	public static User recuperarUsuario(ActionRequest req) {
		// Recuperar dados do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Recuperar dados do usuário
		return themeDisplay.getUser();
	}

	private static Teste getTesteFromTesteUsuario(Teste_Usuario testeUsuario) {
		Teste teste = new TesteImpl();
		try {
			// Recuperar a teste
			teste = TesteLocalServiceUtil.getTeste(testeUsuario.getTesteId());
		} catch (Exception e) {
			e.getMessage();
		}
		return teste;
	}

	private static Resposta getRespostaFromRespostaUsuario(
			Resposta_Usuario respostaUsuario) {
		Resposta resposta = new RespostaImpl();
		try {
			// Localiza resposta
			resposta = RespostaLocalServiceUtil.getResposta(respostaUsuario
					.getRespostaId());
		} catch (Exception e) {
			e.getMessage();
		}
		return resposta;
	}

	private static Pergunta getPerguntaFromResposta(Resposta resposta) {
		Pergunta pergunta = new PerguntaImpl();
		try {
			// Localiza Pergunta
			pergunta = PerguntaLocalServiceUtil.getPergunta(resposta
					.getPerguntaId());
		} catch (Exception e) {
			e.getMessage();
		}
		return pergunta;
	}

	private static Teste_Usuario recuperarTesteUsuarioPorUsuario(long idTeste,
			long idUsuario) throws Exception {
		Teste_Usuario testeUsuario = null;
		List<Teste_Usuario> lista = null;

		DynamicQuery testeUsuarioQuery = DynamicQueryFactoryUtil
				.forClass(Teste_Usuario.class);
		Criterion criteriaTeste = RestrictionsFactoryUtil
				.eq("testeId", idTeste);
		testeUsuarioQuery.add(criteriaTeste);
		Criterion criteriaUsuario = RestrictionsFactoryUtil.eq("userId",
				idUsuario);
		testeUsuarioQuery.add(criteriaUsuario);

		lista = (List<Teste_Usuario>) Teste_UsuarioLocalServiceUtil
				.dynamicQuery(testeUsuarioQuery);

		for (Teste_Usuario teste : lista) {
			testeUsuario = teste;
			if (testeUsuario.getDataFinalizacao() == null) {
				break;
			}
		}

		return testeUsuario;
	}

	public static List<Teste_Usuario> recuperarListaTesteUsuarioPorUsuario(long idTeste,
			long idUsuario) throws Exception {
		List<Teste_Usuario> lista = null;

		DynamicQuery testeUsuarioQuery = DynamicQueryFactoryUtil
				.forClass(Teste_Usuario.class);
		Criterion criteriaTeste = RestrictionsFactoryUtil
				.eq("testeId", idTeste);
		testeUsuarioQuery.add(criteriaTeste);
		Criterion criteriaUsuario = RestrictionsFactoryUtil.eq("userId",
				idUsuario);
		testeUsuarioQuery.add(criteriaUsuario);

		lista = (List<Teste_Usuario>) Teste_UsuarioLocalServiceUtil
				.dynamicQuery(testeUsuarioQuery);

		return lista;
	}

	public static List<Teste_Usuario> recuperarListaTesteUsuarioPorEmail(long idTeste,
			String email) throws Exception {
		List<Teste_Usuario> lista = null;

		DynamicQuery testeUsuarioQuery = DynamicQueryFactoryUtil
				.forClass(Teste_Usuario.class);
		Criterion criteriaTeste = RestrictionsFactoryUtil
				.eq("testeId", idTeste);
		testeUsuarioQuery.add(criteriaTeste);
		Criterion criteriaEmail = RestrictionsFactoryUtil.eq("email",
				email);
		testeUsuarioQuery.add(criteriaEmail);

		lista = (List<Teste_Usuario>) Teste_UsuarioLocalServiceUtil
				.dynamicQuery(testeUsuarioQuery);

		return lista;
	}

	public static List<Resposta_Usuario> recuperarListaRespostaUsuarioPorTesteUsuario(long idTesteUsuario) throws Exception {
		List<Resposta_Usuario> lista = null;

		DynamicQuery respostaUsuarioQuery = DynamicQueryFactoryUtil
				.forClass(Resposta_Usuario.class);
		Criterion criteriaTesteUsuario = RestrictionsFactoryUtil
				.eq("testeUsuarioId", idTesteUsuario);
		respostaUsuarioQuery.add(criteriaTesteUsuario);

		lista = (List<Resposta_Usuario>) Resposta_UsuarioLocalServiceUtil
				.dynamicQuery(respostaUsuarioQuery);

		return lista;
	}
}