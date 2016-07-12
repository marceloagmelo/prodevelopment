package br.com.prodevelopment.pesquisaopiniao.resultado.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.pesquisaopiniao.Constantes;
import br.com.prodevelopment.pesquisaopiniao.cadastro.action.PerguntaAction;
import br.com.prodevelopment.pesquisaopiniao.model.Pergunta;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_Usuario;
import br.com.prodevelopment.pesquisaopiniao.model.Resposta;
import br.com.prodevelopment.pesquisaopiniao.model.Resposta_Usuario;
import br.com.prodevelopment.pesquisaopiniao.service.PerguntaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.PesquisaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.Pesquisa_UsuarioLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.RespostaLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.service.Resposta_UsuarioLocalServiceUtil;
import br.com.prodevelopment.pesquisaopiniao.vo.PerguntaVO;
import br.com.prodevelopment.pesquisaopiniao.vo.RespostaVO;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class ResultadoAction {

	public static int perguntasLidas = 0;
	public static int totalPerguntas = 0;
	public static int totalRespostas = 0;
	public static int totalPaginas = 0;
	public static long idPergunta = 0;
	
	public static List<Pesquisa> buscar(RenderRequest req, RenderResponse res) throws Exception {

		// Recuperar a companhia e grupo
		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		long idGroup = themeDisplay.getScopeGroupId();
		long idCompany = themeDisplay.getCompanyId();

		List<String> errors = new ArrayList<String>();
		List<Pesquisa> listaPesquisa = null;
		try {
			// Recuperar pesquisas
			DynamicQuery pesquisaQuery = DynamicQueryFactoryUtil.forClass(Pesquisa.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq(Constantes.COMPANY_ID, idCompany);
			pesquisaQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq(Constantes.GROUP_ID, idGroup);
			pesquisaQuery.add(criteriaGroup);
			Criterion criteriaAtiva = RestrictionsFactoryUtil.eq(Constantes.ATIVA, Boolean.TRUE);
			pesquisaQuery.add(criteriaAtiva);
			pesquisaQuery.addOrder(OrderFactoryUtil.asc(Constantes.TITULO));

			listaPesquisa = (List<Pesquisa>)PesquisaLocalServiceUtil.dynamicQuery(pesquisaQuery);
		}
		catch (Exception e) {
			errors.add("mensagem.erro.bancoDados");
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
		req.setAttribute(Constantes.TOTAL_PESQUISA_RESPONDIDA, Constantes.ZERO);
		return listaPesquisa;
	}

	public static void gerar(ActionRequest req,	ActionResponse res, String idPesquisa)  throws Exception {
		// Rescuperar a lista de pesquisa usuário
		DynamicQuery pesquisaUsuarioQuery = DynamicQueryFactoryUtil.forClass(Pesquisa_Usuario.class);
		Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq(Constantes.PESQUISA_ID, Long.parseLong(idPesquisa));
		pesquisaUsuarioQuery.add(criteriaPesquisa);

		List<Pesquisa_Usuario> listaPesquisaUsuario = (List<Pesquisa_Usuario>)Pesquisa_UsuarioLocalServiceUtil.dynamicQuery(pesquisaUsuarioQuery);
		String totalPesquisaRespondida = String.valueOf(listaPesquisaUsuario.size());

		// Recuperar a lista de resposta usuário
		Map<Long, RespostaVO> mapRespostas = recuperarRespostasVO(listaPesquisaUsuario);

		List<Pergunta> listaPerguntas = (List<Pergunta>)PerguntaAction.buscar(req, res, null, idPesquisa);

		// Recuperar perguntas com respostas dos usuários
		List<PerguntaVO> listaPerguntasVO = recuperarPerguntasVO(listaPerguntas, mapRespostas);

		if (listaPesquisaUsuario.size() == 0) {
			SessionMessages.add(req, Constantes.MSG_PESQUISA_NAO_RSPONDIDA);
			req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA, null);
		}
		else {
			req.setAttribute(Constantes.NOME_PARAM_LISTA_PERGUNTA, listaPerguntasVO);
		}
		// Atribuir valores no request
		req.setAttribute(Constantes.NOME_PARAM_ID_PESQUISA, idPesquisa);
		req.setAttribute(Constantes.NOME_PARAM_MAP_PERGUNTAS_RESPONDIDAS, totalPesquisaRespondida);
	}

	private static Map<Long, RespostaVO> recuperarRespostasVO(List<Pesquisa_Usuario> listaPesquisaUsuario) throws Exception {
		Map<Long, RespostaVO> mapRespostas = new LinkedHashMap<Long, RespostaVO>();
		int totalRespostas = listaPesquisaUsuario.size();

		for (Pesquisa_Usuario pesquisaUsuario: listaPesquisaUsuario) {
			// Recuperar a lista de resposta do usuario
			DynamicQuery respostaUsuarioQuery = DynamicQueryFactoryUtil.forClass(Resposta_Usuario.class);
			Criterion criteriaPesquisaUsuario = RestrictionsFactoryUtil.eq(Constantes.PESQUISA_USUARIO_ID, pesquisaUsuario.getId());
			respostaUsuarioQuery.add(criteriaPesquisaUsuario);
			respostaUsuarioQuery.addOrder(OrderFactoryUtil.asc(Constantes.ID));

			List<Resposta_Usuario> listaRespostaUsuario = (List<Resposta_Usuario>)Resposta_UsuarioLocalServiceUtil.dynamicQuery(respostaUsuarioQuery);

			for (Resposta_Usuario respostaUsuario: listaRespostaUsuario) {
				// Recuperar a resposta
				RespostaVO respostaVO = new RespostaVO();
				Resposta resposta = RespostaLocalServiceUtil.getResposta(respostaUsuario.getRespostaId());
				if (Validator.isNotNull(resposta)) {
					respostaVO.setDescricaoCorrente(resposta.getDescricaoCurrentValue());
					respostaVO.setId(String.valueOf(resposta.getId()));
				}
				// Recuperar a pergunta
				PerguntaVO perguntaVO = new PerguntaVO();
				Pergunta pergunta = PerguntaLocalServiceUtil.getPergunta(resposta.getPerguntaId());
				if (Validator.isNotNull(pergunta)) {
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
			Criterion criteriaPergunta = RestrictionsFactoryUtil.eq(Constantes.PERGUNTA_ID, pergunta.getId());
			respostaQuery.add(criteriaPergunta);
			respostaQuery.addOrder(OrderFactoryUtil.asc(Constantes.ID));

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