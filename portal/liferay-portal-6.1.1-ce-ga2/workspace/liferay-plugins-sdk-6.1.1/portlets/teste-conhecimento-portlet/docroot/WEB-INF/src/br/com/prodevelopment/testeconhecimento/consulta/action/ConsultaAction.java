package br.com.prodevelopment.testeconhecimento.consulta.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.testeconhecimento.Constantes;
import br.com.prodevelopment.testeconhecimento.model.Pergunta;
import br.com.prodevelopment.testeconhecimento.model.Resposta;
import br.com.prodevelopment.testeconhecimento.model.Resposta_Usuario;
import br.com.prodevelopment.testeconhecimento.model.Teste;
import br.com.prodevelopment.testeconhecimento.model.Teste_Usuario;
import br.com.prodevelopment.testeconhecimento.service.PerguntaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.RespostaLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.Resposta_UsuarioLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.TesteLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.service.Teste_UsuarioLocalServiceUtil;
import br.com.prodevelopment.testeconhecimento.vo.PerguntaVO;
import br.com.prodevelopment.testeconhecimento.vo.RespostaUsuarioVO;
import br.com.prodevelopment.testeconhecimento.vo.RespostaVO;
import br.com.prodevelopment.testeconhecimento.vo.TesteUsuarioVO;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class ConsultaAction {

	public static int perguntasLidas = 0;
	public static int totalPerguntas = 0;
	public static int totalRespostas = 0;
	public static int totalPaginas = 0;
	public static long idPergunta = 0;

	public static void buscar(RenderRequest req, RenderResponse res)
			throws Exception {

		// Recuperar a companhia e grupo
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long idGroup = themeDisplay.getScopeGroupId();
		long idCompany = themeDisplay.getCompanyId();

		List<String> errors = new ArrayList<String>();
		try {
			// Recuperar testes
			DynamicQuery testeQuery = DynamicQueryFactoryUtil.forClass(Teste.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq("companyId", idCompany);
			testeQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq("groupId", idGroup);
			testeQuery.add(criteriaGroup);
			Criterion criteriaAtivo = RestrictionsFactoryUtil.eq("ativo", Boolean.TRUE);
			testeQuery.add(criteriaAtivo);
			testeQuery.addOrder(OrderFactoryUtil.asc("titulo"));

			List<Teste> listaTeste = (List<Teste>)TesteLocalServiceUtil.dynamicQuery(testeQuery);

			req.setAttribute(Constantes.NOME_PARAM_LISTA_TESTE,
					listaTeste);
		} catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
		req.setAttribute(Constantes.TOTAL_TESTE_RESPONDIDO, Constantes.ZERO);
	}

	public static void gerar(ActionRequest req, ActionResponse res,
			String idTeste, String ordenacao) throws Exception {
		
		// Rescuperar a lista de teste usuário
		DynamicQuery testeUsuarioQuery = DynamicQueryFactoryUtil.forClass(Teste_Usuario.class);
		Criterion criteriaTeste = RestrictionsFactoryUtil.eq("testeId", Long.parseLong(idTeste));
		testeUsuarioQuery.add(criteriaTeste);
		if (Constantes.ZERO.equals(ordenacao)) {
			testeUsuarioQuery.addOrder(OrderFactoryUtil.asc("nome"));
		}
		if (Constantes.UM.equals(ordenacao)) {
			testeUsuarioQuery.addOrder(OrderFactoryUtil.desc("totalRespostaCorreta"));
		}
		else {
			testeUsuarioQuery.addOrder(OrderFactoryUtil.desc("totalPontuacao"));
		}

		List<Teste_Usuario> listaTesteUsuario = (List<Teste_Usuario>)Teste_UsuarioLocalServiceUtil.dynamicQuery(testeUsuarioQuery);

		/*
		if (Constantes.ZERO.equals(ordenacao)) {
			listaTesteUsuario = TesteUsuarioBD.singleton().filtrarPorTesteOrdemNome(Long.parseLong(idTeste));

		}
		else {
			listaTesteUsuario = TesteUsuarioBD.singleton().filtrarPorTesteOrdemRespostaCerta(Long.parseLong(idTeste));

		}
		*/

		// Recuperar a lista de resposta usuário
		List<TesteUsuarioVO> listaTesteUsuarioVO = recuperarTestesUsuarioVO(req, listaTesteUsuario);

		if (listaTesteUsuario.size() == 0) {
			SessionMessages.add(req,
					"mensagem.testeRelatorio.testeNaoRespondida");
			req
					.setAttribute(Constantes.NOME_PARAM_LISTA_TESTE_USUARIO,
							null);
		} else {
			req.setAttribute(Constantes.NOME_PARAM_LISTA_TESTE_USUARIO,
					listaTesteUsuarioVO);
		}
		// Atribuir valores no request
		req.setAttribute(Constantes.NOME_PARAM_ID_TESTE, idTeste);
	}

	private static List<TesteUsuarioVO> recuperarTestesUsuarioVO(ActionRequest request,
			List<Teste_Usuario> listaTesteUsuario) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		List<TesteUsuarioVO> lista = new ArrayList<TesteUsuarioVO>();

		for (Teste_Usuario testeUsuario : listaTesteUsuario) {
			// Recuperar a resposta do usuario
			DynamicQuery respostaUsuarioQuery = DynamicQueryFactoryUtil.forClass(Resposta_Usuario.class);
			Criterion criteriaTesteUsuario = RestrictionsFactoryUtil.eq("testeUsuarioId", testeUsuario.getId());
			respostaUsuarioQuery.add(criteriaTesteUsuario);
			respostaUsuarioQuery.addOrder(OrderFactoryUtil.asc("id"));

			List<Resposta_Usuario> listaRespostaUsuario = (List<Resposta_Usuario>)Resposta_UsuarioLocalServiceUtil.dynamicQuery(respostaUsuarioQuery);

			List<RespostaUsuarioVO> listaRespostasUsuario = new ArrayList<RespostaUsuarioVO>(
					listaRespostaUsuario.size());

			TesteUsuarioVO testeUsuarioVO = new TesteUsuarioVO();

			for (Resposta_Usuario respostaUsuario : listaRespostaUsuario) {
				// Instancia a resposta usuário vo
				RespostaUsuarioVO respostaUsuarioVO = new RespostaUsuarioVO();

				// Instancia a resposta vo
				RespostaVO respostaVO = new RespostaVO();

				// Recuperar a resposta
				Resposta resposta = RespostaLocalServiceUtil.getResposta(respostaUsuario.getRespostaId());

				// Povoa a resposta vo
				respostaVO.setDescricaoCorrente(resposta.getDescricaoCurrentValue());
				respostaVO.setId(String.valueOf(resposta.getId()));

				// Recuperar a pergunta
				Pergunta pergunta = PerguntaLocalServiceUtil.getPergunta(resposta.getPerguntaId());

				// Povoa a pergunta vo
				PerguntaVO perguntaVO = new PerguntaVO();
				perguntaVO.setId(String.valueOf(pergunta.getId()));
				perguntaVO.setDescricaoCorrente(pergunta.getDescricaoCurrentValue().replaceAll("\n", "<br>"));
				respostaVO.setPerguntaVO(perguntaVO);

				// Povoa a resposta usuário vo
				respostaUsuarioVO
						.setId(String.valueOf(respostaUsuario.getId()));
				respostaUsuarioVO.setCorreta(respostaUsuario.getCorreta() ? Constantes.S : Constantes.N);
				respostaUsuarioVO.setRespostaVO(respostaVO);

				// Adicionar a resposta usuário
				listaRespostasUsuario.add(respostaUsuarioVO);
			}
			// Povoar teste vo
			testeUsuarioVO.setId(String.valueOf(testeUsuario.getId()));
			testeUsuarioVO.setEmail(testeUsuario.getEmail());
			testeUsuarioVO.setNome(testeUsuario.getNome());
			testeUsuarioVO.setTotalRespostaCerta(String.valueOf(testeUsuario.getTotalRespostaCorreta()));
			testeUsuarioVO.setTotalRespostaErrada(String.valueOf(testeUsuario.getTotalRespostaErrada()));
			testeUsuarioVO.setTotalPontuacao(String.valueOf(testeUsuario.getTotalPontuacao()));

			testeUsuarioVO.setRespostas(listaRespostasUsuario);
			// Recuperar dados do usuário
			User usuario = UserLocalServiceUtil.getUser(testeUsuario.getUserId());
			testeUsuarioVO.setIdUsuario(String.valueOf(usuario.getUserId()));
			testeUsuarioVO.setImagemUrl(usuario.getPortraitURL(themeDisplay));

			// Adicionar pesquisa do usuário
			lista.add(testeUsuarioVO);
		}

		return lista;
	}
}