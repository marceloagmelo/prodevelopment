package br.com.prodevelopment.aniversariantemes.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.aniversariantemes.Constantes;
import br.com.prodevelopment.aniversariantemes.action.AniversarianteAction;
import br.com.prodevelopment.aniversariantemes.util.Helper;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AniversarianteMesPortlet
 */
public class AniversarianteMesPortlet extends MVCPortlet {

	protected String enviarMensagemJSP;

	@Override
	public void init() throws PortletException {
		enviarMensagemJSP = getInitParameter(Constantes.JSP_ENVIAR_MENSAGEM);
		super.init();
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String metodo = (String) renderRequest.getParameter(Constantes.NOME_PARAM_METODO);
		String id = ParamUtil.getString(renderRequest, Constantes.NOME_PARAM_ID);
		
		Portlet portlet = (Portlet) renderRequest.getAttribute(WebKeys.RENDER_PORTLET);
		String resourceBundle = portlet.getResourceBundle();
		renderRequest.setAttribute(Constantes.RESOURCE_BUNDLE, resourceBundle);
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			// Recuperar preferencias
			PortletPreferences prefs = renderRequest.getPreferences();
			String exibirTitulo = prefs.getValue(Constantes.PREF_EXIBIR_TITULO,
					Constantes.VAZIO);
			renderRequest.setAttribute(Constantes.NOME_PARAM_EXIBIR_TITULO,
					exibirTitulo);

			String portletTitulo = Helper.getTituloPortlet(renderRequest, renderResponse, themeDisplay);
			
			renderRequest.setAttribute(Constantes.NOME_PARAM_TITULO_PORTLET,
					portletTitulo);
			
			long companyId = themeDisplay.getCompanyId();

			int totalUsuarios = UserLocalServiceUtil.getCompanyUsersCount(companyId);
			List<User> users = UserLocalServiceUtil.getCompanyUsers(companyId, 0, totalUsuarios);
			
			if (Constantes.METODO_PREPARAR_MENSAGEM.equals(metodo)) {
				AniversarianteAction.prepararMensagem(renderRequest, renderResponse, Long.parseLong(id));
				include(enviarMensagemJSP, renderRequest, renderResponse);
			}
			else {
				AniversarianteAction.inicio(renderRequest, renderResponse, users, QueryUtil.ALL_POS);
				super.doView(renderRequest, renderResponse);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	public void prepararMensagem(ActionRequest request, ActionResponse response)
			throws Exception {
		String id = ParamUtil.getString(request, Constantes.NOME_PARAM_ID);
		String mensagem = ParamUtil.getString(request, Constantes.NOME_PARAM_MENSAGEM);
		response.setRenderParameter(Constantes.NOME_PARAM_ID, id);
		response.setRenderParameter(Constantes.NOME_PARAM_MENSAGEM, mensagem);
		response.setRenderParameter(Constantes.NOME_PARAM_METODO, Constantes.METODO_PREPARAR_MENSAGEM);
	}

	public void enviarMensagem(ActionRequest request, ActionResponse response)
			throws Exception {
		String id = ParamUtil.getString(request, Constantes.NOME_PARAM_ID);
		String mensagem = ParamUtil.getString(request, Constantes.NOME_PARAM_MENSAGEM);
		AniversarianteAction.enviar(request, response, Long.parseLong(id), mensagem);
	}

	public void cancelar(ActionRequest request, ActionResponse response)
			throws Exception {
		response.setRenderParameter(Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
	}

	public void voltar(ActionRequest request, ActionResponse response)
			throws Exception {
		response.setRenderParameter(Constantes.NOME_PARAM_METODO, Constantes.VAZIO);
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
}
