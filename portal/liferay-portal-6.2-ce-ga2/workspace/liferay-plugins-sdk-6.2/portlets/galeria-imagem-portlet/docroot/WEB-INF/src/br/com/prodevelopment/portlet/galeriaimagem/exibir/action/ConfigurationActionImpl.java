package br.com.prodevelopment.portlet.galeriaimagem.exibir.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.portlet.galeriaimagem.exibir.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		// Recupera dados da prefer�ncia
		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");
		String folderIdSelecionado = ParamUtil.getString(actionRequest,
				Constantes.FOLDER_ID_SELECIONADO);
		String prefExibirTituloPortlet = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_TITULO_PORTLET);
		String prefExibirTituloPasta = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_TITULO_PASTA);
		String prefQtdeRegistros = ParamUtil.getString(actionRequest,
				Constantes.PREF_QTDE_REGISTROS);
		String prefLarguraImagem = ParamUtil.getString(actionRequest,
				Constantes.PREF_LARGURA_IMAGEM);
		String prefAlturaImagem = ParamUtil.getString(actionRequest,
				Constantes.PREF_ALTURA_IMAGEM);

		// Salvar dados na prefer�ncia
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);
		preferences.setValue(Constantes.PREF_FOLDER_ID, folderIdSelecionado);
		preferences.setValue(Constantes.PREF_EXIBIR_TITULO_PORTLET,
				prefExibirTituloPortlet);
		preferences.setValue(Constantes.PREF_EXIBIR_TITULO_PASTA,
				prefExibirTituloPasta);
		preferences.setValue(Constantes.PREF_QTDE_REGISTROS, prefQtdeRegistros);
		preferences.setValue(Constantes.PREF_LARGURA_IMAGEM, prefLarguraImagem);
		preferences.setValue(Constantes.PREF_ALTURA_IMAGEM, prefAlturaImagem);
		preferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);

		preferences.store();

		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);

		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
	}

	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		try {
			// Recuperar objetos da prefer�ncia
			PortletPreferences portletPreferences = renderRequest.getPreferences();			
			String prefFolderId = portletPreferences.getValue(Constantes.PREF_FOLDER_ID,
					StringPool.BLANK);
			boolean prefExibirTituloPortlet = GetterUtil.getBoolean(portletPreferences
					.getValue(Constantes.PREF_EXIBIR_TITULO_PORTLET,
							Constantes.DEFAULT_PREF_EXIBIR_TITULO));
			boolean prefExibirTituloPasta = GetterUtil.getBoolean(portletPreferences
					.getValue(Constantes.PREF_EXIBIR_TITULO_PASTA,
							Constantes.DEFAULT_PREF_EXIBIR_PASTA));
			String prefQtdeRegistros = GetterUtil.getString(portletPreferences.getValue(
					Constantes.PREF_QTDE_REGISTROS,
					Constantes.DEFAULT_QTDE_REGISTROS));
			String prefLarguraImagem = GetterUtil.getString(portletPreferences.getValue(
					Constantes.PREF_LARGURA_IMAGEM,
					Constantes.DEFAULT_LARGURA_IMAGEM));
			String prefAlturaImagem = GetterUtil.getString(portletPreferences.getValue(
					Constantes.PREF_ALTURA_IMAGEM,
					Constantes.DEFAULT_ALTURA_IMAGEM));

			// Recuperar objetos do request
			String sFolderId = ParamUtil.getString(renderRequest,
					Constantes.FOLDER_ID);
			long folderId = 0;
			if (Validator.isNull(sFolderId)) {
				folderId = GetterUtil.getLong(prefFolderId);
			} else {
				folderId = ParamUtil.getLong(renderRequest,
						Constantes.FOLDER_ID);
			}

			long repositoryId = PortalUtil.getScopeGroupId(renderRequest);

			// Recuperar a pasta
			Folder folder = null;
			if (folderId > 0) {
				folder = DLAppServiceUtil.getFolder(folderId);
			}

			// Recuperar a lista de pastas
			List<Folder> listaPastas = DLAppServiceUtil.getFolders(
					repositoryId, folderId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);

			// Adiciona objetos de request
			renderRequest.setAttribute(Constantes.LISTA_PASTAS, listaPastas);
			renderRequest.setAttribute(Constantes.FOLDER_ID, folderId);
			renderRequest.setAttribute(Constantes.PAGE, getPage(renderRequest));
			renderRequest.setAttribute(Constantes.PAGE_SIZE, 20);
			renderRequest.setAttribute(Constantes.FOLDER_ID, folderId);
			renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO_PORTLET,
					prefExibirTituloPortlet);
			renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO_PASTA,
					prefExibirTituloPasta);
			renderRequest.setAttribute(Constantes.PREF_QTDE_REGISTROS,
					prefQtdeRegistros);
			renderRequest.setAttribute(Constantes.PREF_LARGURA_IMAGEM,
					prefLarguraImagem);
			renderRequest.setAttribute(Constantes.PREF_ALTURA_IMAGEM,
					prefAlturaImagem);

			// Adiciona objetos de request
			renderRequest.setAttribute(Constantes.FOLDER, folder);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constantes.JSP_CADASTRO_CONFIG;
	}

	private int getPage(RenderRequest renderRequest) {
		int page = 1;

		if (renderRequest.getParameter("page") != null
				&& !"".equals(renderRequest.getParameter("page"))) {
			page = Integer.valueOf(renderRequest.getParameter("page"));
		}

		return page;
	}
}
