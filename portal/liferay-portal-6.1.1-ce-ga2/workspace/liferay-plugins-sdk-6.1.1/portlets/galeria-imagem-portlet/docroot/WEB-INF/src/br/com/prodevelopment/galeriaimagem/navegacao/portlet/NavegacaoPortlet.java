package br.com.prodevelopment.galeriaimagem.navegacao.portlet;

import br.com.prodevelopment.galeriaimagem.navegacao.Constantes;
import br.com.prodevelopment.galeriaimagem.util.Helper;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

/**
 * Portlet implementation class NavegacaoPortlet
 */
public class NavegacaoPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			// Recuperar preferências do portlet
			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);
			String prefFolderId = prefs.getValue(Constantes.PREF_FOLDER_ID,
					Constantes.ZERO);

			if (Constantes.S.equals(prefConfigurado)) {
				// Recuperar objetos do request
				long folderId = ParamUtil.getLong(renderRequest,
						Constantes.FOLDER_ID);
				
				if (Validator.isNull(folderId)) {
					folderId = GetterUtil.getLong(prefFolderId);
				}

				long repositoryId = themeDisplay.getScopeGroupId();

				// Recuperar a lista de pastas
				List<Folder> listaPastas = DLAppServiceUtil.getFolders(
						repositoryId, folderId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);

				Folder folder = null;
				String folderNome = StringPool.BLANK;
				if (Long.valueOf(folderId) > 0) {
					folder = DLAppServiceUtil.getFolder(Long.valueOf(folderId));
					if (folder != null) {
						renderRequest.setAttribute(Constantes.FOLDER_ID_ANTERIOR,
								String.valueOf(folder.getParentFolderId()));
						folderNome = folder.getName();
					}
				}

				// Adiciona objetos de request
				renderRequest.setAttribute(Constantes.LISTA_PASTAS, listaPastas);
				renderRequest.setAttribute(Constantes.FOLDER_ID, folderId);
				renderRequest.setAttribute(Constantes.FOLDER_NOME, folderNome);

				// Recupera o título do portlet
				String tituloPortlet = Helper.getTituloPortlet(renderRequest,
						renderResponse, themeDisplay);
				renderRequest
						.setAttribute(Constantes.TITULO_PORTLET, tituloPortlet);
				
				super.doView(renderRequest, renderResponse);
				
			} else {
				include(naoConfiguradoJSP, renderRequest, renderResponse);
			}

		} catch (Exception e) {
			SessionErrors.add(renderRequest, Constantes.MSG_ERRO_PORTLET);
		}
	}

	public void renderiza(ActionRequest request, ActionResponse response) {
		String folderId = ParamUtil.getString(request, Constantes.FOLDER_ID);
		response.setRenderParameter(Constantes.FOLDER_ID, folderId);

		// Disparar o evento para exibir as imagens
		QName qName = new QName("http://prodevelopment.com.br/events",
				"galeriaimagem.exibir");
		response.setEvent(qName, folderId);

	}

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

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
		}
		catch (PortletException pe) {
			Throwable cause = pe.getCause();

			if (isSessionErrorException(cause)) {
				SessionErrors.add(
					actionRequest, cause.getClass().getName(), cause);
			}
			else {
				throw pe;
			}
		}
	}
	
}
