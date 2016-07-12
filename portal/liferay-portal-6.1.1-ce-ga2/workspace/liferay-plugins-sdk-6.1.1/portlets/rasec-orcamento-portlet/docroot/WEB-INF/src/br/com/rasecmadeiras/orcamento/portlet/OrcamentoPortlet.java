package br.com.rasecmadeiras.orcamento.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.rasecmadeiras.orcamento.Constantes;
import br.com.rasecmadeiras.orcamento.action.OrcamentoAction;
import br.com.rasecmadeiras.orcamento.validacao.OrcamentoValidator;
import br.com.rasecmadeiras.orcamento.vo.OrcamentoVO;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OrcamentoPortlet
 */
public class OrcamentoPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		super.init();
	}

	@Override
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {
		try {
			// Recuperar request
			OrcamentoVO orcamentoVO = (OrcamentoVO) req
					.getAttribute(Constantes.ORCAMENTO_VO);
			if (orcamentoVO == null) {
				orcamentoVO = new OrcamentoVO();
			}

			// Recuperar preferencias do portlet
			String prefConfigurado = req.getPreferences().getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);

			Portlet portlet = (Portlet) req.getAttribute(WebKeys.RENDER_PORTLET);
			String resourceBundle = portlet.getResourceBundle();

			String configurado = Constantes.S;
			if (Constantes.S.equals(prefConfigurado)) {
				List<String> listaEstados = OrcamentoAction.montarListaEstados();
				req.setAttribute(Constantes.LISTA_ESTADOS, listaEstados);
				List<String> listaTipoResposta = OrcamentoAction.montarListaTipoResposta();
				req.setAttribute(Constantes.LISTA_TIPO_RESPOSTA, listaTipoResposta);

				req.setAttribute(Constantes.CONFIGURADO, configurado);
				req.setAttribute(Constantes.PROP_SOLICITACAO,
						orcamentoVO.getSolicitacao());
				req.setAttribute(Constantes.PROP_NOME_USUARIO,
						orcamentoVO.getNomeUsuario());
				req.setAttribute(Constantes.PROP_EMAIL_USUARIO,
						orcamentoVO.getEmailUsuario());
				req.setAttribute(Constantes.ORCAMENTO_VO, orcamentoVO);
				req.setAttribute(Constantes.RESOURCE_BUNDLE, resourceBundle);

				include(viewTemplate, req, res);
			} else {
				SessionMessages.add(req, "mensagem.orcamento.naoConfigurado");
				include(naoConfiguradoJSP, req, res);
			}
		} catch (Exception e) {
			SessionErrors.add(req, Constantes.MSG_ERRO_PORTLET);
			include(viewTemplate, req, res);
		}
	}

	@ProcessAction(name = "enviar")
	public void enviar(ActionRequest request, ActionResponse response)
			throws Exception {
        HttpServletRequest httpReq = PortalUtil
        .getOriginalServletRequest(PortalUtil
                .getHttpServletRequest(request));

		// Recuperar propriedades
		String solicitacao = ParamUtil.getString(request,
				Constantes.PROP_SOLICITACAO);
		String nomeEmpresa = ParamUtil.getString(request,
				Constantes.PROP_NOME_EMPRESA);
		String nomeUsuario = ParamUtil.getString(request,
				Constantes.PROP_NOME_USUARIO);
		String emailUsuario = ParamUtil.getString(request,
				Constantes.PROP_EMAIL_USUARIO);
		String endereco = ParamUtil.getString(request, Constantes.PROP_ENDERECO);
		String cep = ParamUtil.getString(request, Constantes.PROP_CEP);
		String cidade = ParamUtil.getString(request, Constantes.PROP_CIDADE);
		String estado = ParamUtil.getString(request, Constantes.PROP_ESTADO);
		String ddd = ParamUtil.getString(request, Constantes.PROP_DDD);
		String telefone = ParamUtil.getString(request, Constantes.PROP_TELEFONE);
		String tipoResposta = ParamUtil.getString(request, Constantes.PROP_TIPO_RESPOSTA);
		String resourceBundle = ParamUtil.getString(request, Constantes.RESOURCE_BUNDLE);


		// Recuperar preferencias do portlet
		String emailResponsavel = String.valueOf(request.getPreferences()
				.getValue(Constantes.PREF_EMAILS, Constantes.VAZIO));

		// Povoar OrcamentoVO
		OrcamentoVO orcamentoVO = new OrcamentoVO();
		orcamentoVO.setSolicitacao(solicitacao);
		orcamentoVO.setNomeEmpresa(nomeEmpresa);
		orcamentoVO.setEmailResponsavel(emailResponsavel);
		orcamentoVO.setEndereco(endereco);
		orcamentoVO.setCep(cep);
		orcamentoVO.setCidade(cidade);
		orcamentoVO.setEstado(estado);
		orcamentoVO.setDdd(ddd);
		orcamentoVO.setTelefone(telefone);
		orcamentoVO.setTipoResposta(tipoResposta);

		// Recuperar usuário
		String usuarioLogado = (OrcamentoAction.getDadosPortal(request)
				.getUser().isDefaultUser() ? Constantes.ZERO : Constantes.UM);
		if (Constantes.UM.equals(usuarioLogado)) {
			orcamentoVO.setEmailUsuario(OrcamentoAction
					.getDadosPortal(request).getRealUser().getEmailAddress());
			orcamentoVO.setNomeUsuario(OrcamentoAction
					.getDadosPortal(request).getRealUser().getFullName());
		} else {
			orcamentoVO.setEmailUsuario(emailUsuario);
			orcamentoVO.setNomeUsuario(nomeUsuario);
		}
		List<String> errors = new ArrayList<String>();

		// Validar dados
		if (OrcamentoValidator.validar(orcamentoVO, errors)) {
			OrcamentoAction.enviar(orcamentoVO, resourceBundle, PortalUtil.getLocale(httpReq));
			SessionMessages.add(request, "mensagem.orcamento.enviado");
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			request.setAttribute(Constantes.ORCAMENTO_VO, orcamentoVO);
		}
	}


}
