package br.com.prodevelopment.trabalheconosco.portlet;

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

import br.com.prodevelopment.trabalheconosco.Constantes;
import br.com.prodevelopment.trabalheconosco.action.TrabalheConoscoAction;
import br.com.prodevelopment.trabalheconosco.validacao.TrabalheConoscoValidator;
import br.com.prodevelopment.trabalheconosco.vo.CargoVO;
import br.com.prodevelopment.trabalheconosco.vo.TrabalheConoscoVO;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TrabalheConoscoPortlet
 */
public class TrabalheConoscoPortlet extends MVCPortlet {
	protected String naoConfiguradoJSP;

	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		super.init();
	}

	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {
		try {
			// Recuperar request
			TrabalheConoscoVO trabalheConoscoVO = (TrabalheConoscoVO) req
					.getAttribute(Constantes.TRABALHE_CONOSCO_VO);
			if (trabalheConoscoVO == null) {
				trabalheConoscoVO = new TrabalheConoscoVO();
			}

			// Recuperar preferencias do portlet
			String prefAssuntos = String.valueOf(req.getPreferences().getValue(
					Constantes.PREF_CARGOS, Constantes.VAZIO));
			String prefEmails = String.valueOf(req.getPreferences().getValue(
					Constantes.PREF_EMAILS, Constantes.VAZIO));
			String prefConfigurado = req.getPreferences().getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);

			Portlet portlet = (Portlet) req.getAttribute(WebKeys.RENDER_PORTLET);
			String resourceBundle = portlet.getResourceBundle();

			String configurado = Constantes.S;
			if (Constantes.S.equals(prefConfigurado)) {
				List<CargoVO> listaCargos = TrabalheConoscoAction
						.montarListaCargos(prefAssuntos);
				req.setAttribute(Constantes.LISTA_CARGOS, listaCargos);
				List<String> listaEstados = TrabalheConoscoAction
						.montarListaEstados();
				req.setAttribute(Constantes.LISTA_ESTADOS, listaEstados);

				req.setAttribute(Constantes.CONFIGURADO, configurado);
				req.setAttribute(Constantes.PROP_CARGO,
						trabalheConoscoVO.getCargo());
				req.setAttribute(Constantes.PROP_RESUMO,
						trabalheConoscoVO.getResumo());
				req.setAttribute(Constantes.PROP_NOME_USUARIO,
						trabalheConoscoVO.getNomeUsuario());
				req.setAttribute(Constantes.PROP_EMAIL_USUARIO,
						trabalheConoscoVO.getEmailUsuario());
				req.setAttribute(Constantes.TRABALHE_CONOSCO_VO,
						trabalheConoscoVO);
				req.setAttribute(Constantes.RESOURCE_BUNDLE, resourceBundle);

				include(viewTemplate, req, res);
			} else {
				SessionMessages.add(req,
						"mensagem.trabalheConosco.naoConfigurado");
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
		String cargo = ParamUtil.getString(request, Constantes.PROP_CARGO);
		String resumo = ParamUtil.getString(request, Constantes.PROP_RESUMO);
		String nomeUsuario = ParamUtil.getString(request,
				Constantes.PROP_NOME_USUARIO);
		String emailUsuario = ParamUtil.getString(request,
				Constantes.PROP_EMAIL_USUARIO);
		String endereco = ParamUtil
				.getString(request, Constantes.PROP_ENDERECO);
		String cep = ParamUtil.getString(request, Constantes.PROP_CEP);
		String cidade = ParamUtil.getString(request, Constantes.PROP_CIDADE);
		String estado = ParamUtil.getString(request, Constantes.PROP_ESTADO);
		String ddd = ParamUtil.getString(request, Constantes.PROP_DDD);
		String telefone = ParamUtil
				.getString(request, Constantes.PROP_TELEFONE);
		String resourceBundle = ParamUtil.getString(request, Constantes.RESOURCE_BUNDLE);

		cargo = cargo.replaceAll("\n", "<br>");

		// Recuperar preferencias do portlet
		String emailResponsavel = String.valueOf(request.getPreferences()
				.getValue(Constantes.PREF_EMAILS, Constantes.VAZIO));

		// Povoar TrabalheConoscoVO
		TrabalheConoscoVO trabalheConoscoVO = new TrabalheConoscoVO();
		trabalheConoscoVO.setCargo(cargo);
		trabalheConoscoVO.setResumo(resumo);
		trabalheConoscoVO.setEmailResponsavel(emailResponsavel);
		trabalheConoscoVO.setEndereco(endereco);
		trabalheConoscoVO.setCep(cep);
		trabalheConoscoVO.setCidade(cidade);
		trabalheConoscoVO.setEstado(estado);
		trabalheConoscoVO.setDdd(ddd);
		trabalheConoscoVO.setTelefone(telefone);

		// Recuperar usuário
		String usuarioLogado = (TrabalheConoscoAction.getDadosPortal(request)
				.getUser().isDefaultUser() ? Constantes.ZERO : Constantes.UM);
		if (Constantes.UM.equals(usuarioLogado)) {
			trabalheConoscoVO.setEmailUsuario(TrabalheConoscoAction
					.getDadosPortal(request).getRealUser().getEmailAddress());
			trabalheConoscoVO.setNomeUsuario(TrabalheConoscoAction
					.getDadosPortal(request).getRealUser().getFullName());
		} else {
			trabalheConoscoVO.setEmailUsuario(emailUsuario);
			trabalheConoscoVO.setNomeUsuario(nomeUsuario);
		}
		List<String> errors = new ArrayList<String>();

		// Validar dados
		if (TrabalheConoscoValidator.validar(trabalheConoscoVO, errors)) {
			TrabalheConoscoAction.enviar(trabalheConoscoVO, resourceBundle, PortalUtil.getLocale(httpReq));
			SessionMessages.add(request, "mensagem.trabalheConosco.enviado");
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			request.setAttribute(Constantes.TRABALHE_CONOSCO_VO,
					trabalheConoscoVO);
		}
	}

}
