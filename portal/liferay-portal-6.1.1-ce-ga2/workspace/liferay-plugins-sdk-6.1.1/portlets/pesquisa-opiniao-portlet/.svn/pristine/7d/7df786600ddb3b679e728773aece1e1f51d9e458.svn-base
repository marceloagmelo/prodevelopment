package br.com.prodevelopment.pesquisaopiniao.exibir.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.pesquisaopiniao.Constantes;
import br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException;
import br.com.prodevelopment.pesquisaopiniao.cadastro.action.PerguntaAction;
import br.com.prodevelopment.pesquisaopiniao.model.Pergunta;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario;
import br.com.prodevelopment.pesquisaopiniao.model.Resposta;
import br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario;
import br.com.prodevelopment.pesquisaopiniao.model.impl.PerguntaImpl;
import br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaImpl;
import br.com.prodevelopment.pesquisaopiniao.model.impl.Pesquisa_UsuarioImpl;
import br.com.prodevelopment.pesquisaopiniao.model.impl.RespostaImpl;
import br.com.prodevelopment.pesquisaopiniao.model.impl.Resposta_UsuarioImpl;
import br.com.prodevelopment.pesquisaopiniao.service.PerguntaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.PesquisaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.Pesquisa_UsuarioLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.RespostaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.Resposta_UsuarioLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.util.Helper;
import br.com.prodevelopment.pesquisaopiniao.vo.PerguntaVO;
import br.com.prodevelopment.pesquisaopiniao.vo.PesquisaUsuarioVO;
import br.com.prodevelopment.pesquisaopiniao.vo.PesquisaVO;
import br.com.prodevelopment.pesquisaopiniao.vo.RespostaUsuarioVO;
import br.com.prodevelopment.pesquisaopiniao.vo.RespostaVO;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
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
				Constantes.NOME_PARAM_MAP_PERGUNTAS_RESPONDIDAS);

		perguntasLidas = 0;
		totalPaginas = 0;

		int pagina = 1;
		int totalPerguntasPagina = 1;
		int perguntaInicio = 1;
		int quantidadePerguntasPagina = 1;

		List<String> errors = new ArrayList<String>();
		try {
			// Recuperar pesquisa
			Pesquisa pesquisa = PesquisaLocalServiceUtil.getPesquisa(id);
			PesquisaVO pesquisaVO = getPesquisaVOFromPesquisa(pesquisa);

			// Recuperar perguntas da pesquisa
			List<Pergunta> listaPerguntas = PerguntaAction.buscar(req, res, null, String.valueOf(id));
			pesquisaVO.setPerguntas(recuperarPerguntasVO(listaPerguntas));

			if ((Validator.isNotNull(pesquisaVO))
					&& (Validator.isNotNull(pesquisaVO.getPerguntas()))) {
				// Calcular o total de páginas
				int i = 0;
				while (i < listaPerguntas.size()) {
					totalPaginas++;
					i = i + quantidadePerguntasPagina;
				}

				// Calcular o número da pergunta inicial
				perguntaInicio = perguntasLidas
						- pesquisaVO.getPerguntas().size();

				totalPerguntasPagina = pesquisaVO.getPerguntas().size();
			}

			// Montar objetos request
			req.setAttribute(Constantes.NOME_PARAM_PESQUISA_VO, pesquisaVO);

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

			PortletURL acaoURL = res.createActionURL();
			acaoURL.setParameter(Constantes.PORTLET_ACTION,
					Constantes.URL_METODO_ACAO_PESQUISA);
			req.setAttribute(Constantes.NOME_PARAM_ACAO_URL, acaoURL.toString());
		} catch (NoSuchPesquisaException e) {
			errors.add(Constantes.MSG_PESQUISA_NAO_ENCONTRADA);
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		} catch (Exception e) {
			errors.add(Constantes.MSG_ERRO_BANCO_DADOS);
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	public static void renderiza(RenderRequest req, RenderResponse res,
			long id, int pagina) throws Exception {

		List<String> errors = new ArrayList<String>();
		try {
			// Recuperar pesquisa
			Pesquisa pesquisa = PesquisaLocalServiceUtil.getPesquisa(id);
			PesquisaVO pesquisaVO = getPesquisaVOFromPesquisa(pesquisa);

			// Recuperar perguntas da pesquisa
			List<Pergunta> listaPerguntas = PerguntaAction.buscar(req, res, null, String.valueOf(id));
			pesquisaVO.setPerguntas(recuperarPerguntasVO(listaPerguntas));
			// Calcular o número da pergunta inicial
			int perguntaInicio = perguntasLidas
					- pesquisaVO.getPerguntas().size();

			// Montar objetos request
			req.setAttribute(Constantes.NOME_PARAM_PESQUISA_VO, pesquisaVO);
			req.setAttribute(Constantes.NOME_PARAM_PAGINA,
					String.valueOf(pagina));
			req.setAttribute(Constantes.NOME_PARAM_TOTAL_PAGINAS,
					String.valueOf(totalPaginas));
			req.setAttribute(Constantes.NOME_PARAM_TOTAL_PERGUNTAS_PAGINA,
					String.valueOf(pesquisaVO.getPerguntas().size()));
			req.setAttribute(Constantes.NOME_PARAM_PERGUNTA_INICIO,
					String.valueOf(perguntaInicio));
			req.setAttribute(Constantes.NOME_PARAM_PERGUNTAS_LIDAS,
					String.valueOf(perguntasLidas));
			req.setAttribute(Constantes.NOME_PARAM_ID_PERGUNTA,
					String.valueOf(idPergunta));

			PortletURL acaoURL = res.createActionURL();
			acaoURL.setParameter(Constantes.PORTLET_ACTION,
					Constantes.URL_METODO_ACAO_PESQUISA);
			req.setAttribute(Constantes.NOME_PARAM_ACAO_URL, acaoURL.toString());
		} catch (Exception e) {
			errors.add(Constantes.MSG_ERRO_BANCO_DADOS);
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	public static void enviar(ActionRequest req, ActionResponse res,
			String anonima, String enviarEmail, String resourceBundle) throws Exception {
		List<String> errors = new ArrayList<String>();
		try {
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(req));

			// Recupera o mapa de perguntas respondidas da sessão
			Map<Long, RespostaUsuarioVO> mapPerguntasRespondidas = (Map) req
					.getPortletSession().getAttribute(
							Constantes.NOME_PARAM_MAP_PERGUNTAS_RESPONDIDAS);

			// Ler as respostas para gravar no banco
			if (Validator.isNotNull(mapPerguntasRespondidas)) {
				ResourceBundle resource  = ResourceBundle.getBundle(resourceBundle, PortalUtil.getLocale(httpReq));				

				// Recuperar textos da mensagem
				String mensagemObrigadoPesquisaRespondida = resource
						.getString(Constantes.MSG_EMAIL_OBRIGADO_PESQUISA_RESPONDIDA);
				String mensagemVejaRespostas = resource
						.getString(Constantes.MSG_EMAIL_VEJA_RESPOSTAS);
				String mensagemPergunta = resource
						.getString(Constantes.MSG_EMAIL_PERGUNTA);
				String mensagemResposta = resource
						.getString(Constantes.MSG_EMAIL_RESPOSTA);
				String mensagemAtenciosamente = resource
						.getString(Constantes.MSG_EMAIL_ATENCIOSAMENTE);
				String mensagemPortal = resource
						.getString(Constantes.MSG_EMAIL_PORTAL);

				int contador = 1;
				StringBuffer bfCorpoEmail = new StringBuffer();

				Pesquisa_Usuario pesquisaUsuario = new Pesquisa_UsuarioImpl();
				Pesquisa pesquisa = new PesquisaImpl();
				for (Iterator<RespostaUsuarioVO> it = mapPerguntasRespondidas
						.values().iterator(); it.hasNext();) {
					RespostaUsuarioVO respostaUsuarioVO = it.next();
					// Montar pesquisa usuário
					if (contador == 1) {
						// Recuperar objeto de pesquisa usuário com o VO
						pesquisaUsuario = getPesquisaUsuarioFromRespostaUsuarioVO(
								respostaUsuarioVO, pesquisaUsuario);

						// Recuperar objeto de pesquisa com o pesquisa usuário
						pesquisa = getPesquisaFromPesquisaUsuario(pesquisaUsuario);

						// Recuperar dados do usuário
						User usuario = ExibirAction.recuperarUsuario(req);
						pesquisaUsuario
								.setUserId(Long.valueOf(Constantes.ZERO));
						if (Constantes.N.equals(anonima)) {
							pesquisaUsuario.setUserId(usuario.getUserId());
						} else {
							ThemeDisplay themeDisplay = (ThemeDisplay) req
									.getAttribute(WebKeys.THEME_DISPLAY);
							
							pesquisaUsuario.setUserId(themeDisplay.getDefaultUser().getUserId());
						}

						// Executar a gravação da pesquisa usuário
						pesquisaUsuario = Pesquisa_UsuarioLocalServiceUtil
								.addPesquisa_Usuario(pesquisaUsuario);
						respostaUsuarioVO.getPesquisaUsuarioVO().setId(
								String.valueOf(pesquisaUsuario.getId()));

						// Preparar o corpo do email
						bfCorpoEmail.append(pesquisaUsuario.getNome() + ",");
						bfCorpoEmail.append(Constantes.BR);
						bfCorpoEmail.append(Constantes.BR);
						bfCorpoEmail.append(mensagemObrigadoPesquisaRespondida
								+ " (" + pesquisa.getTituloCurrentValue() + ")");
						bfCorpoEmail.append(Constantes.BR);
						bfCorpoEmail.append(Constantes.BR);
						bfCorpoEmail.append(mensagemVejaRespostas + ":");
					}
					// Montar resposta usuário
					Resposta_Usuario respostaUsuario = new Resposta_UsuarioImpl();
					respostaUsuario = getRespostaUsuarioFromRespostaUsuarioVO(
							respostaUsuarioVO, respostaUsuario);
					respostaUsuario.setPesquisaUsuarioId(pesquisaUsuario
							.getId());

					// Montar resposta com resposta usuário
					Resposta resposta = getRespostaFromRespostaUsuario(respostaUsuario);
					respostaUsuario.setRespostaId(resposta.getId());

					// Montar pergunta com resposta
					Pergunta pergunta = getPerguntaFromResposta(resposta);

					// Executar a gravação da resposta usuário
					respostaUsuario = Resposta_UsuarioLocalServiceUtil
							.addResposta_Usuario(respostaUsuario);
					bfCorpoEmail.append(Constantes.BR);
					bfCorpoEmail.append(Constantes.BR);
					bfCorpoEmail.append("<b>" + mensagemPergunta + ": "
							+ pergunta.getDescricaoCurrentValue()+ "</b>");
					bfCorpoEmail.append(Constantes.BR);
					bfCorpoEmail.append("<i>" + mensagemResposta + ": "
							+ resposta.getDescricaoCurrentValue() + "</i>");

					// Incrementa contador
					contador++;
				}
				bfCorpoEmail.append(Constantes.BR);
				bfCorpoEmail.append(Constantes.BR);
				bfCorpoEmail.append(mensagemAtenciosamente + ",");
				bfCorpoEmail.append(Constantes.BR);
				bfCorpoEmail.append(Constantes.BR);
				bfCorpoEmail.append(mensagemPortal);
				if (Constantes.N.equals(anonima)
						&& Constantes.S.equals(enviarEmail)) {
					try {
						enviarEmail(bfCorpoEmail.toString(), pesquisaUsuario,
								pesquisa.getTituloCurrentValue(),
								PortalUtil.getLocale(httpReq), resource);
					} catch (Exception e) {
						errors.add(Constantes.MSG_ERRO_ENVIAR_EMAIL);
						for (String error : errors) {
							SessionErrors.add(req, error);
						}
					}
				}
				SessionMessages.add(req,
						Constantes.MSG_PESQUISA_FINALIZADA_SUCESSO);
				res.setRenderParameter(Constantes.NOME_PARAM_METODO,
						Constantes.VALOR_PARAM_FIM);
			}
		} catch (Exception e) {
			errors.add(Constantes.MSG_ERRO_GRAVAR_BANCO_DADOS);
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	private static void enviarEmail(String mensagem,
			Pesquisa_Usuario pesquisaUsuario, String titulo, Locale locale,
			ResourceBundle resource) throws Exception {

		String body = mensagem;
		String subject = titulo;

		String fromName = resource.getString("email.assunto");
		String fromAddress = resource.getString("email.from");
		String toName = pesquisaUsuario.getNome();
		String toAddress = pesquisaUsuario.getEmail();

		InternetAddress from = new InternetAddress(fromAddress, fromName);

		InternetAddress to = new InternetAddress(toAddress, toName);

		MailMessage message = new MailMessage(from, to, subject, body, true);

		try {
			MailServiceUtil.sendEmail(message);
		} catch (Exception e) {
			new Exception(e.getMessage());
		}
	}

/*	
	private static List<Pergunta> recuperarPerguntas(long idPesquisa)
			throws Exception {
		DynamicQuery perguntaQuery = DynamicQueryFactoryUtil
				.forClass(Pergunta.class);
		Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq(
				Constantes.PESQUISA_ID, idPesquisa);
		perguntaQuery.add(criteriaPesquisa);
		perguntaQuery.addOrder(OrderFactoryUtil.asc(Constantes.ID));

		List<Pergunta> lista = (List<Pergunta>) PerguntaLocalServiceUtil
				.dynamicQuery(perguntaQuery);
		return lista;
	}
*/
	private static PesquisaVO getPesquisaVOFromPesquisa(Pesquisa pesquisa) {
		PesquisaVO pesquisaVO = new PesquisaVO();

		if (Validator.isNotNull(pesquisa)) {
			pesquisaVO.setId(String.valueOf(pesquisa.getId()));
			pesquisaVO.setTituloCorrente(pesquisa.getTituloCurrentValue());
			pesquisaVO.setDescricaoCorrente(pesquisa.getDescricaoCurrentValue());
		}
		return pesquisaVO;
	}

	private static List<PerguntaVO> recuperarPerguntasVO(
			List<Pergunta> listaPerguntas) throws Exception {
		List<PerguntaVO> lista = null;
		int totalPerguntas = listaPerguntas.size();

		if (totalPerguntas > 0) {
			// Recuperar a quantidade de perguntas por página
			int quantidadePerguntasPagina = 1;

			// Montar o controle de leitura das perguntas
			int perguntasInicio = perguntasLidas;
			int perguntasFim = perguntasLidas + (quantidadePerguntasPagina);
			if (perguntasFim > totalPerguntas) {
				perguntasFim = totalPerguntas;
			}

			lista = new ArrayList<PerguntaVO>(perguntasFim - perguntasInicio);

			// iniciar o contador de perguntas
			int iContadorPerguntas = 0;

			for (int i = perguntasInicio; i < perguntasFim; i++) {
				Pergunta pergunta = (Pergunta) listaPerguntas.get(i);
				PerguntaVO perguntaVO = new PerguntaVO();
				perguntaVO.setId(String.valueOf(pergunta.getId()));
				perguntaVO.setDescricaoCorrente(pergunta.getDescricaoCurrentValue().replaceAll(
						"\n", Constantes.BR));

				// Recuparar as respostas
				DynamicQuery respostaQuery = DynamicQueryFactoryUtil
						.forClass(Resposta.class);
				Criterion criteriaPergunta = RestrictionsFactoryUtil.eq(
						Constantes.PERGUNTA_ID, pergunta.getId());
				respostaQuery.add(criteriaPergunta);

				List<Resposta> listaRespostas = (List<Resposta>) RespostaLocalServiceUtil
						.dynamicQuery(respostaQuery);

				if ((Validator.isNotNull(listaRespostas))
						&& (listaRespostas.size() > 0)) {
					perguntaVO
							.setRespostas(recuperarRespostasVO(listaRespostas));
				}

				lista.add(perguntaVO);

				// Incrmenenta mais um ao número de perguntas lidas e ao
				// contador de perguntas
				iContadorPerguntas++;
				perguntasLidas++;
				idPergunta = pergunta.getId();
			}
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

	public static void gravarMaps(ActionRequest req, ActionResponse res,
			String id, String prefAnonima) {
		// Recupera a quantidade total de perguntas
		String idPergunta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_PERGUNTA);
		String idResposta = ParamUtil.getString(req,
				Constantes.NOME_PARAM_ID_RESPOSTA);
		String nome = ParamUtil.getString(req, Constantes.PROP_PESQUISA_NOME);
		String email = ParamUtil.getString(req, Constantes.PROP_PESQUISA_EMAIL);

		// Recupera o mapa de perguntas respondidas da sessão
		Map<Long, RespostaUsuarioVO> mapPerguntasRespondidas = (Map) req
				.getPortletSession().getAttribute(
						Constantes.NOME_PARAM_MAP_PERGUNTAS_RESPONDIDAS);
		if (Validator.isNull(mapPerguntasRespondidas)) {
			mapPerguntasRespondidas = new HashMap<Long, RespostaUsuarioVO>();
		}

		// Instanciar o objeto de pesquisa de usuário
		PesquisaUsuarioVO pesquisaUsuarioVO = new PesquisaUsuarioVO();
		if (Constantes.N.equals(prefAnonima)) {
			pesquisaUsuarioVO.setNome(nome);
			pesquisaUsuarioVO.setEmail(email);
		} else {
			pesquisaUsuarioVO.setNome(Constantes.VAZIO);
			pesquisaUsuarioVO.setEmail(Constantes.VAZIO);
		}
		PesquisaVO pesquisaVO = new PesquisaVO();
		pesquisaVO.setId(id);
		pesquisaUsuarioVO.setPesquisaVO(pesquisaVO);

		// Instanciar o objeto de resposta de usuário
		RespostaUsuarioVO respostaUsuarioVO = new RespostaUsuarioVO();
		RespostaVO respostaVO = new RespostaVO();
		respostaVO.setId(idResposta);
		PerguntaVO perguntaVO = new PerguntaVO();
		perguntaVO.setId(idPergunta);
		respostaVO.setPerguntaVO(perguntaVO);
		respostaUsuarioVO.setRespostaVO(respostaVO);
		respostaUsuarioVO.setPesquisaUsuarioVO(pesquisaUsuarioVO);

		mapPerguntasRespondidas.put(
				Long.valueOf(respostaUsuarioVO.getRespostaVO().getPerguntaVO()
						.getId()), respostaUsuarioVO);

		// Coloca o mapa de perguntas respondidas na sessão
		req.getPortletSession().setAttribute(
				Constantes.NOME_PARAM_MAP_PERGUNTAS_RESPONDIDAS,
				mapPerguntasRespondidas);
	}

	public static void buscarPesquisa(RenderRequest req, RenderResponse res)
			throws Exception {

		// Recuperar a companhia e grupo
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long idGroup = themeDisplay.getScopeGroupId();
		long idCompany = themeDisplay.getCompanyId();

		List<String> errors = new ArrayList<String>();
		try {
			// Recuperar pesquisas
			DynamicQuery pesquisaQuery = DynamicQueryFactoryUtil
					.forClass(Pesquisa.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq(
					Constantes.COMPANY_ID, idCompany);
			pesquisaQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq(
					Constantes.GROUP_ID, idGroup);
			pesquisaQuery.add(criteriaGroup);
			Criterion criteriaAtiva = RestrictionsFactoryUtil.eq(
					Constantes.ATIVA, Boolean.TRUE);
			pesquisaQuery.add(criteriaAtiva);
			pesquisaQuery.addOrder(OrderFactoryUtil.asc(Constantes.TITULO));

			List<Pesquisa> listaPesquisa = (List<Pesquisa>) PesquisaLocalServiceUtil
					.dynamicQuery(pesquisaQuery);
			req.setAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA,
					listaPesquisa);
		} catch (Exception e) {
			errors.add(Constantes.MSG_ERRO_BANCO_DADOS);
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
	}

	public static boolean jaRespondeu(String idPesquisa, String email)
			throws Exception {
		boolean retorno = false;

		DynamicQuery pesquisaUsuarioQuery = DynamicQueryFactoryUtil
				.forClass(Pesquisa_Usuario.class);
		Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq(
				Constantes.PESQUISA_ID, Long.parseLong(idPesquisa));
		pesquisaUsuarioQuery.add(criteriaPesquisa);
		Criterion criteriaEmail = RestrictionsFactoryUtil.eq(Constantes.EMAIL,
				email);
		pesquisaUsuarioQuery.add(criteriaEmail);

		List<Pesquisa_Usuario> lista = (List<Pesquisa_Usuario>) Pesquisa_UsuarioLocalServiceUtil
				.dynamicQuery(pesquisaUsuarioQuery);

		retorno = lista.size() > 0;

		return retorno;
	}

	public static boolean jaRespondeu(String idPesquisa, long idUsuario)
			throws Exception {
		boolean retorno = false;

		DynamicQuery pesquisaUsuarioQuery = DynamicQueryFactoryUtil
				.forClass(Pesquisa_Usuario.class);
		Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq(
				Constantes.PESQUISA_ID, Long.parseLong(idPesquisa));
		pesquisaUsuarioQuery.add(criteriaPesquisa);
		Criterion criteriaUsuario = RestrictionsFactoryUtil.eq(
				Constantes.USER_ID, idUsuario);
		pesquisaUsuarioQuery.add(criteriaUsuario);

		List<Pesquisa_Usuario> lista = (List<Pesquisa_Usuario>) Pesquisa_UsuarioLocalServiceUtil
				.dynamicQuery(pesquisaUsuarioQuery);

		retorno = lista.size() > 0;

		return retorno;
	}

	private static Pesquisa_Usuario getPesquisaUsuarioFromRespostaUsuarioVO(
			RespostaUsuarioVO respostaUsuarioVO,
			Pesquisa_Usuario pesquisaUsuario) {
		try {
			pesquisaUsuario.setDataInclusao(Helper.getDataAtual().getTime());
			pesquisaUsuario.setEmail(respostaUsuarioVO.getPesquisaUsuarioVO()
					.getEmail());
			pesquisaUsuario.setNome(respostaUsuarioVO.getPesquisaUsuarioVO()
					.getNome());
			pesquisaUsuario.setPesquisaId(Long.valueOf(respostaUsuarioVO
					.getPesquisaUsuarioVO().getPesquisaVO().getId()));

		} catch (Exception e) {
			e.getMessage();
		}
		return pesquisaUsuario;
	}

	private static Pesquisa getPesquisaFromPesquisaUsuario(
			Pesquisa_Usuario pesquisaUsuario) {
		Pesquisa pesquisa = new PesquisaImpl();
		try {
			// Recuperar a pesquisa
			pesquisa = PesquisaLocalServiceUtil.getPesquisa(pesquisaUsuario
					.getPesquisaId());
		} catch (Exception e) {
			e.getMessage();
		}
		return pesquisa;
	}

	private static Resposta_Usuario getRespostaUsuarioFromRespostaUsuarioVO(
			RespostaUsuarioVO respostaUsuarioVO,
			Resposta_Usuario respostaUsuario) {
		try {
			respostaUsuario.setDataInclusao(Helper.getDataAtual().getTime());
			respostaUsuario.setRespostaId(Long.valueOf(respostaUsuarioVO
					.getRespostaVO().getId()));
		} catch (Exception e) {
			e.getMessage();
		}
		return respostaUsuario;
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
}