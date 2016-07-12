package br.com.prodevelopment.faleconosco.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.faleconosco.Constantes;
import br.com.prodevelopment.faleconosco.action.FaleConoscoAction;
import br.com.prodevelopment.faleconosco.validacao.FaleConoscoValidator;
import br.com.prodevelopment.faleconosco.vo.AssuntoVO;
import br.com.prodevelopment.faleconosco.vo.FaleConoscoVO;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FaleConoscoPortlet
 */
public class FaleConoscoPortlet extends MVCPortlet {

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
			FaleConoscoVO faleConoscoVO = (FaleConoscoVO) req
					.getAttribute(Constantes.FALE_CONOSCO_VO);
			if (faleConoscoVO == null) {
				faleConoscoVO = new FaleConoscoVO();
			}

			// Recuperar preferencias do portlet
			String prefAssuntos = String.valueOf(req.getPreferences().getValue(
					Constantes.PREF_ASSUNTOS, Constantes.VAZIO));
			String prefEmails = String.valueOf(req.getPreferences().getValue(
					Constantes.PREF_EMAILS, Constantes.VAZIO));
			String prefConfigurado = req.getPreferences().getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);

			String configurado = Constantes.S;
			if (Constantes.S.equals(prefConfigurado)) {
				List<AssuntoVO> listaAssuntos = FaleConoscoAction
						.montarListaAssuntos(prefAssuntos);
				req.setAttribute(Constantes.LISTA_ASSUNTOS, listaAssuntos);
				List<String> listaEstados = FaleConoscoAction
						.montarListaEstados();
				req.setAttribute(Constantes.LISTA_ESTADOS, listaEstados);

				req.setAttribute(Constantes.CONFIGURADO, configurado);
				req.setAttribute(Constantes.PROP_ASSUNTO,
						faleConoscoVO.getAssunto());
				req.setAttribute(Constantes.PROP_MENSAGEM,
						faleConoscoVO.getMensagem());
				req.setAttribute(Constantes.PROP_NOME_USUARIO,
						faleConoscoVO.getNomeUsuario());
				req.setAttribute(Constantes.PROP_EMAIL_USUARIO,
						faleConoscoVO.getEmailUsuario());
				req.setAttribute(Constantes.FALE_CONOSCO_VO, faleConoscoVO);

				include(viewTemplate, req, res);

			} else {
				SessionMessages.add(req, "mensagem.faleConosco.naoConfigurado");
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
		// Recuperar propriedades
		String assunto = ParamUtil.getString(request, Constantes.PROP_ASSUNTO);
		String mensagem = ParamUtil
				.getString(request, Constantes.PROP_MENSAGEM);
		String nomeUsuario = ParamUtil.getString(request,
				Constantes.PROP_NOME_USUARIO);
		String emailUsuario = ParamUtil.getString(request,
				Constantes.PROP_EMAIL_USUARIO);

		mensagem = mensagem.replaceAll("\n", "<br>");

		// Recuperar preferencias do portlet
		String emailResponsavel = String.valueOf(request.getPreferences()
				.getValue(Constantes.PREF_EMAILS, Constantes.VAZIO));

		// Povoar FaleConoscoVO
		FaleConoscoVO faleConoscoVO = new FaleConoscoVO();
		faleConoscoVO.setAssunto(assunto);
		faleConoscoVO.setMensagem(mensagem);
		faleConoscoVO.setEmailResponsavel(emailResponsavel);
		// Recuperar usuário
		String usuarioLogado = (FaleConoscoAction.getDadosPortal(request)
				.getUser().isDefaultUser() ? Constantes.ZERO : Constantes.UM);
		if (Constantes.UM.equals(usuarioLogado)) {
			faleConoscoVO.setEmailUsuario(FaleConoscoAction
					.getDadosPortal(request).getRealUser().getEmailAddress());
			faleConoscoVO.setNomeUsuario(FaleConoscoAction
					.getDadosPortal(request).getRealUser().getFullName());
		} else {
			faleConoscoVO.setEmailUsuario(emailUsuario);
			faleConoscoVO.setNomeUsuario(nomeUsuario);
		}
		List<String> errors = new ArrayList<String>();

		// Validar dados
		if (FaleConoscoValidator.validar(faleConoscoVO, errors)) {
			FaleConoscoAction.enviar(faleConoscoVO);
			SessionMessages.add(request, "mensagem.faleConosco.enviado");
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			request.setAttribute(Constantes.FALE_CONOSCO_VO, faleConoscoVO);
		}
	}

}
