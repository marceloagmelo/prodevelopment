package br.com.prodevelopment.testeconhecimento.consulta.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.testeconhecimento.Constantes;
import br.com.prodevelopment.testeconhecimento.consulta.action.ConsultaAction;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ConsultaPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		// Recuperar objetos request
		String idTeste = ParamUtil.getString(req, Constantes.NOME_PARAM_ID_TESTE);
		String ordenacao = ParamUtil.getString(req, Constantes.NOME_PARAM_ORDENACAO);

		// Salvar id no request
		req.setAttribute(Constantes.NOME_PARAM_ID_TESTE, idTeste);
		req.setAttribute(Constantes.NOME_PARAM_ORDENACAO, ordenacao);

		PortletURL gerarURL = res.createActionURL();
		gerarURL.setParameter(Constantes.PORTLET_ACTION, Constantes.URL_METODO_GERAR);
		req.setAttribute(Constantes.NOME_PARAM_GERAR_URL, gerarURL.toString());

		try {
			ConsultaAction.buscar(req, res);
		} catch (Exception e) {
			SessionErrors.add(req, Constantes.MSG_ERRO_PORTLET);
		}
		super.doView(req, res);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		try {
			if (!isProcessActionRequest(actionRequest)) {
				return;
			}

			if (!callActionMethod(actionRequest, actionResponse)) {
				return;
			}

			if (!SessionErrors.isEmpty(actionRequest)) {
				return;
			}

			if (!SessionMessages.isEmpty(actionRequest)) {
				return;
			}

			sendRedirect(actionRequest, actionResponse);
		} catch (PortletException pe) {
			Throwable cause = pe.getCause();

			if (isSessionErrorException(cause)) {
				SessionErrors.add(actionRequest, cause.getClass().getName(),
						cause);
			} else {
				throw pe;
			}
		}
	}

	public void gerar(ActionRequest req,	ActionResponse res) throws Exception {
		String idPesquisa = ParamUtil.getString(req, Constantes.NOME_PARAM_ID_TESTE);
		String ordenacao = ParamUtil.getString(req, Constantes.NOME_PARAM_ORDENACAO);
		res.setRenderParameter(Constantes.NOME_PARAM_ID_TESTE, idPesquisa);
		res.setRenderParameter(Constantes.NOME_PARAM_ORDENACAO, ordenacao);
		ConsultaAction.gerar(req, res, idPesquisa, ordenacao);
	}
}
