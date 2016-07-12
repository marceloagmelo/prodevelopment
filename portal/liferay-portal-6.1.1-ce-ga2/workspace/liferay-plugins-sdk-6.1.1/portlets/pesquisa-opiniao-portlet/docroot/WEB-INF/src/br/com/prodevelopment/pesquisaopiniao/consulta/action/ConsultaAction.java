package br.com.prodevelopment.pesquisaopiniao.consulta.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.pesquisaopiniao.Constantes;
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
import br.com.prodevelopment.pesquisaopiniao.vo.PesquisaUsuarioVO;
import br.com.prodevelopment.pesquisaopiniao.vo.RespostaUsuarioVO;
import br.com.prodevelopment.pesquisaopiniao.vo.RespostaVO;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
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

	public static List<Pesquisa> buscar(RenderRequest req, RenderResponse res)
			throws Exception {

		// Recuperar a companhia e grupo
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long idGroup = themeDisplay.getScopeGroupId();
		long idCompany = themeDisplay.getCompanyId();

		List<String> errors = new ArrayList<String>();
		List<Pesquisa> listaPesquisa = null;
		try {
			// Recuperar o idioma
			String idiomaId = themeDisplay.getLanguageId();

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
		} catch (Exception e) {
			errors.add(Constantes.MSG_ERRO_BANCO_DADOS);
			for (String error : errors) {
				SessionErrors.add(req, error);
			}
		}
		req.setAttribute(Constantes.TOTAL_PESQUISA_RESPONDIDA, Constantes.ZERO);
		return listaPesquisa;
	}

	public static void gerar(ActionRequest req, ActionResponse res,
			String idPesquisa) throws Exception {
		// Rescuperar a lista de pesquisa usuário
		DynamicQuery pesquisaUsuarioQuery = DynamicQueryFactoryUtil.forClass(Pesquisa_Usuario.class);
		Criterion criteriaPesquisa = RestrictionsFactoryUtil.eq(Constantes.PESQUISA_ID, Long.parseLong(idPesquisa));
		pesquisaUsuarioQuery.add(criteriaPesquisa);
		pesquisaUsuarioQuery.addOrder(OrderFactoryUtil.asc(Constantes.NOME));
		
		List<Pesquisa_Usuario> listaPesquisaUsuario = (List<Pesquisa_Usuario>)Pesquisa_UsuarioLocalServiceUtil.dynamicQuery(pesquisaUsuarioQuery);			
		
		// Recuperar a lista de resposta usuário
		List<PesquisaUsuarioVO> listaPesquisaUsuarioVO = recuperarPesquisasUsuarioVO(req, listaPesquisaUsuario);

		if (listaPesquisaUsuario.size() == 0) {
			SessionMessages.add(req,
					Constantes.MSG_PESQUISA_NAO_RESPONDIDA);
			req
					.setAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA_USUARIO,
							null);
		} else {
			req.setAttribute(Constantes.NOME_PARAM_LISTA_PESQUISA_USUARIO,
					listaPesquisaUsuarioVO);
		}
		// Atribuir valores no request
		req.setAttribute(Constantes.NOME_PARAM_ID_PESQUISA, idPesquisa);
	}

	private static List<PesquisaUsuarioVO> recuperarPesquisasUsuarioVO(ActionRequest request,
			List<Pesquisa_Usuario> listaPesquisaUsuario) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		List<PesquisaUsuarioVO> lista = new ArrayList<PesquisaUsuarioVO>();

		for (Pesquisa_Usuario pesquisaUsuario : listaPesquisaUsuario) {
			// Recuperar lista de resposta do usuario
			DynamicQuery respostaUsuarioQuery = DynamicQueryFactoryUtil.forClass(Resposta_Usuario.class);
			Criterion criteriaPesquisaUsuario = RestrictionsFactoryUtil.eq(Constantes.PESQUISA_USUARIO_ID, pesquisaUsuario.getId());
			respostaUsuarioQuery.add(criteriaPesquisaUsuario);
			respostaUsuarioQuery.addOrder(OrderFactoryUtil.asc(Constantes.ID));
			
			List<Resposta_Usuario> listaRespostaUsuario = (List<Resposta_Usuario>)Resposta_UsuarioLocalServiceUtil.dynamicQuery(respostaUsuarioQuery);			

			List<RespostaUsuarioVO> listaRespostasUsuario = new ArrayList<RespostaUsuarioVO>(
					listaRespostaUsuario.size());

			PesquisaUsuarioVO pesquisaUsuarioVO = new PesquisaUsuarioVO();

			for (Resposta_Usuario respostaUsuario : listaRespostaUsuario) {
				// Instancia a resposta usuário vo
				RespostaUsuarioVO respostaUsuarioVO = new RespostaUsuarioVO();

				// Instancia a resposta vo
				RespostaVO respostaVO = new RespostaVO();
				
				// Recuperar a resposta
				Resposta resposta = RespostaLocalServiceUtil.getResposta(respostaUsuario.getRespostaId());

				if (Validator.isNotNull(resposta)) {
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
				}

				// Povoa a resposta usuário vo
				respostaUsuarioVO
						.setId(String.valueOf(respostaUsuario.getId()));
				respostaUsuarioVO.setRespostaVO(respostaVO);

				// Adicionar a resposta usuário
				listaRespostasUsuario.add(respostaUsuarioVO);
			}
			// Povoar pesquisa vo
			pesquisaUsuarioVO.setId(String.valueOf(pesquisaUsuario.getId()));
			pesquisaUsuarioVO.setEmail(pesquisaUsuario.getEmail());
			pesquisaUsuarioVO.setNome(pesquisaUsuario.getNome());
			pesquisaUsuarioVO.setRespostas(listaRespostasUsuario);
			// Recuperar dados do usuário
			if (pesquisaUsuario.getUserId() == 0) {
				pesquisaUsuarioVO.setIdUsuario(String.valueOf(pesquisaUsuario.getUserId()));
				pesquisaUsuarioVO.setImagemUrl(StringPool.BLANK);
			}
			else {
				User usuario = UserLocalServiceUtil.getUser(pesquisaUsuario.getUserId());
				pesquisaUsuarioVO.setIdUsuario(String.valueOf(usuario.getUserId()));
				pesquisaUsuarioVO.setImagemUrl(usuario.getPortraitURL(themeDisplay));
			}
			
			// Adicionar pesquisa do usuário
			lista.add(pesquisaUsuarioVO);
		}

		return lista;
	}
	
	public static User recuperarUsuario(RenderRequest req) {
		// Recuperar dados do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Recuperar dados do usuário
		return themeDisplay.getUser();
	}

	public static User recuperarUsuario(ActionRequest req) {
		// Recuperar dados do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Recuperar dados do usuário
		return themeDisplay.getUser();
	}
}