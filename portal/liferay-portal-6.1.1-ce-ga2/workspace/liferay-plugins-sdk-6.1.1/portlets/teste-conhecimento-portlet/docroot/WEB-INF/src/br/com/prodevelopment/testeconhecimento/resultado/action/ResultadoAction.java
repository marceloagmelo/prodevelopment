package br.com.prodevelopment.testeconhecimento.resultado.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import br.com.prodevelopment.testeconhecimento.vo.RespostaVO;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class ResultadoAction {

	public static int perguntasLidas = 0;
	public static int totalPerguntas = 0;
	public static int totalRespostas = 0;
	public static int totalPaginas = 0;
	public static long idPergunta = 0;
	public static void buscar(RenderRequest req, RenderResponse res) throws Exception {

		// Recuperar a companhia e grupo
		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
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
		}
		catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
		req.setAttribute(Constantes.TOTAL_TESTE_RESPONDIDO, Constantes.ZERO);
	}

	public static void gerar(ActionRequest req,	ActionResponse res, String idTeste)  throws Exception {
		// Rescuperar a lista de teste usuário
		DynamicQuery testeUsuarioQuery = DynamicQueryFactoryUtil.forClass(Teste_Usuario.class);
		Criterion criteriaTeste = RestrictionsFactoryUtil.eq("testeId", Long.parseLong(idTeste));
		testeUsuarioQuery.add(criteriaTeste);

		List<Teste_Usuario> listaTesteUsuario = (List<Teste_Usuario>)Teste_UsuarioLocalServiceUtil.dynamicQuery(testeUsuarioQuery);
		String totalTesteRespondido = String.valueOf(listaTesteUsuario.size());

		// Recuperar a lista de resposta usuário
		Map<Long, RespostaVO> mapRespostas = recuperarRespostasVO(listaTesteUsuario);

		// Recuperar as perguntas
		DynamicQuery perguntaQuery = DynamicQueryFactoryUtil.forClass(Pergunta.class);
		perguntaQuery.add(criteriaTeste);
		perguntaQuery.addOrder(OrderFactoryUtil.asc("id"));

		List<Pergunta> listaPerguntas = (List<Pergunta>)PerguntaLocalServiceUtil.dynamicQuery(perguntaQuery);

		// Recuperar perguntas com respostas dos usuários
		List<PerguntaVO> listaPerguntasVO = recuperarPerguntasVO(listaPerguntas, mapRespostas);

		if (listaTesteUsuario.size() == 0) {
			SessionMessages.add(req, "mensagem.testeEstatistica.testeNaoRespondida");
			req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA, null);
		}
		else {
			req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA, listaPerguntasVO);
		}
		// Atribuir valores no request
		req.setAttribute(Constantes.NOME_PARAM_ID_TESTE, idTeste);
		req.setAttribute(Constantes.NOME_PARAM_MAP_PERGUNTAS_RESPONDIDOS, totalTesteRespondido);
	}

	private static Map<Long, RespostaVO> recuperarRespostasVO(List<Teste_Usuario> listaTesteUsuario) throws Exception {
		Map<Long, RespostaVO> mapRespostas = new LinkedHashMap<Long, RespostaVO>();
		int totalRespostas = listaTesteUsuario.size();

		for (Teste_Usuario testeUsuario: listaTesteUsuario) {
			// Recuperar a resposta do usuario
			DynamicQuery respostaUsuarioQuery = DynamicQueryFactoryUtil.forClass(Resposta_Usuario.class);
			Criterion criteriaTesteUsuario = RestrictionsFactoryUtil.eq("testeUsuarioId", testeUsuario.getId());
			respostaUsuarioQuery.add(criteriaTesteUsuario);
			respostaUsuarioQuery.addOrder(OrderFactoryUtil.asc("id"));

			List<Resposta_Usuario> listaRespostaUsuario = (List<Resposta_Usuario>)Resposta_UsuarioLocalServiceUtil.dynamicQuery(respostaUsuarioQuery);

			for (Resposta_Usuario respostaUsuario: listaRespostaUsuario) {
				// Recuperar a resposta
				RespostaVO respostaVO = new RespostaVO();
				Resposta resposta = RespostaLocalServiceUtil.getResposta(respostaUsuario.getRespostaId());
				if (resposta != null) {
					respostaVO.setDescricaoCorrente(resposta.getDescricaoCurrentValue());
					respostaVO.setId(String.valueOf(resposta.getId()));
				}
				// Recuperar a pergunta
				PerguntaVO perguntaVO = new PerguntaVO();
				Pergunta pergunta = PerguntaLocalServiceUtil.getPergunta(resposta.getPerguntaId());
				if (pergunta != null) {
					perguntaVO.setId(String.valueOf(pergunta.getId()));
					perguntaVO.setDescricaoCorrente(pergunta.getDescricaoCurrentValue().replaceAll("\n", Constantes.BR));
				}
				respostaVO.setPerguntaVO(perguntaVO);

				if (mapRespostas.containsKey(Long.valueOf(respostaVO.getId()))) {
					respostaVO = (RespostaVO)mapRespostas.get(Long.valueOf(respostaVO.getId()));

					// Calcula a quantidade
					int quantidade = Integer.parseInt(respostaVO.getQuantidade());
					quantidade = quantidade + 1;

					// Calcula o percentual
					int percentual = (quantidade * 100 ) / totalRespostas;

					respostaVO.setPercentual(String.valueOf(percentual));
					respostaVO.setQuantidade(String.valueOf(quantidade));
				}
				else {
					respostaVO.setQuantidade(Constantes.UM);

					// Calcula o percentual
					int percentual = (Integer.parseInt(Constantes.UM) * 100 ) / totalRespostas;

					respostaVO.setPercentual(String.valueOf(percentual));
				}
				mapRespostas.put(Long.valueOf(respostaVO.getId()), respostaVO);
			}
		}

		return mapRespostas;
	}


	private static List<PerguntaVO> recuperarPerguntasVO(List<Pergunta> listaPerguntas, Map<Long, RespostaVO> mapRespostas) throws Exception {
		List<PerguntaVO> lista = new ArrayList<PerguntaVO>(listaPerguntas.size());

		for (Pergunta pergunta: listaPerguntas) {
			PerguntaVO perguntaVO = new PerguntaVO();
			perguntaVO.setDescricaoCorrente(pergunta.getDescricaoCurrentValue().replaceAll("\n", Constantes.BR));
			perguntaVO.setId(String.valueOf(pergunta.getId()));

			// Recuperar a resposta
			DynamicQuery respostaQuery = DynamicQueryFactoryUtil.forClass(Resposta.class);
			Criterion criteriaPergunta = RestrictionsFactoryUtil.eq("perguntaId", pergunta.getId());
			respostaQuery.add(criteriaPergunta);
			respostaQuery.addOrder(OrderFactoryUtil.asc("id"));

			List<Resposta> listaRespostas = (List<Resposta>)RespostaLocalServiceUtil.dynamicQuery(respostaQuery);

			List<RespostaVO> listaRespostasVO = new ArrayList<RespostaVO>(listaRespostas.size());

			for (Resposta resposta: listaRespostas) {
				if (mapRespostas.containsKey(Long.valueOf(resposta.getId()))) {
					RespostaVO respostaVO = (RespostaVO)mapRespostas.get(Long.valueOf(resposta.getId()));

					listaRespostasVO.add(respostaVO);
				}
				else {
					RespostaVO respostaVO = new RespostaVO();
					respostaVO.setId(String.valueOf(resposta.getId()));
					respostaVO.setDescricaoCorrente(resposta.getDescricaoCurrentValue());
					respostaVO.setPercentual(Constantes.ZERO);
					respostaVO.setQuantidade(Constantes.ZERO);
					listaRespostasVO.add(respostaVO);
				}
			}
			perguntaVO.setRespostas(listaRespostasVO);
			lista.add(perguntaVO);
		}

		return lista;
	}
}