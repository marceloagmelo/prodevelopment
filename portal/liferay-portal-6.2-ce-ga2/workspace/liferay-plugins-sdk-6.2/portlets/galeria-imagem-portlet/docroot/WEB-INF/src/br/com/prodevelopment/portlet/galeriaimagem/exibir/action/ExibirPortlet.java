package br.com.prodevelopment.portlet.galeriaimagem.exibir.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.portlet.galeriaimagem.exibir.Constantes;
import br.com.prodevelopment.portlet.galeriaimagem.util.Helper;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ExibirPortlet
 */
public class ExibirPortlet extends MVCPortlet {
 
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

			// Recuperar prefer�ncias do portlet
			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);
			String prefFolderId = prefs.getValue(Constantes.PREF_FOLDER_ID,
					Constantes.ZERO);

			String folderId = prefFolderId;
			
			/*
			 *  Verifica se o folderID vem do evento dispara
			 *  Se for ele ignora o restante 
			 */
			String folderIdEvento = (String)renderRequest.getParameter(Constantes.FOLDER_ID_EVENTO);
			if (Validator.isNotNull(folderIdEvento)) {
				folderId = folderIdEvento;
			}
			else {
				if (Validator.isNull(prefFolderId)) {
					folderId = ParamUtil.getString(renderRequest,
							Constantes.FOLDER_ID);
				}
				if (Validator.isNull(folderId)) {
					folderId = Constantes.ZERO;
				}
			}

			long repositoryId = themeDisplay.getScopeGroupId();

			renderRequest.setAttribute(Constantes.FOLDER_ID, folderId);

			if (Constantes.S.equals(prefConfigurado)) {
				int paginaTamanho = GetterUtil.getInteger(renderRequest
						.getPreferences().getValue(
								Constantes.PREF_QTDE_REGISTROS,
								Constantes.DEFAULT_QTDE_REGISTROS));
				if (paginaTamanho == 0) {
					paginaTamanho = Integer
							.parseInt(Constantes.DEFAULT_QTDE_REGISTROS);
				}

				// Trabalha com a p�gina
				int pagina = getPagina(renderRequest);
				int inicioPag = (pagina * paginaTamanho) - paginaTamanho;
				int fimPag = inicioPag + paginaTamanho;
				
				/*
				int total = DLAppServiceUtil.getFileEntriesCount(repositoryId, Long.parseLong(folderId));
				List<FileEntry> lista = DLAppServiceUtil.getFileEntries(
						repositoryId, Long.parseLong(folderId), inicioPag, fimPag );
				*/
				
				List<FileEntry> lista = new ArrayList<FileEntry>();
				List<FileEntry> resultado = DLAppServiceUtil.getFileEntries(repositoryId, Long.parseLong(folderId));
				int total = 0;
				for (FileEntry fileEntry : resultado) {
					Set<String> allMediaGalleryMimeTypes = DLUtil.getAllMediaGalleryMimeTypes();
					boolean encontrouImagem = false;
					
					for (String mimeType : allMediaGalleryMimeTypes) {
						if (fileEntry.getMimeType().equals(mimeType)) {
							encontrouImagem = true;
							break;	
						}
					}
					if (!encontrouImagem) {
						continue;
					}
					
					PermissionChecker permissionChecker = themeDisplay
							.getPermissionChecker();

					// Permissao de adicionar
					String nomeClasse = com.liferay.portlet.documentlibrary.model.DLFileEntry.class
							.getName();
					boolean hasAddPermission = permissionChecker.hasPermission(
							themeDisplay.getScopeGroup().getGroupId(), nomeClasse, fileEntry.getFileEntryId(),
							ActionKeys.VIEW);

					if (hasAddPermission) {
						total++;
						if ((total > inicioPag) && (total <= fimPag)) {
							lista.add(fileEntry);
						}
					}

				}
				
				renderRequest.setAttribute(Constantes.FILE_ENTRIES, lista);
				renderRequest.setAttribute(Constantes.TOTAL, total);
				renderRequest.setAttribute(Constantes.PAGINA_TAMANHO, paginaTamanho);
				renderRequest.setAttribute(Constantes.PAGINA, pagina);

				// Recupera o t�tulo do portlet
				String tituloPortlet = Helper.getTituloPortlet(renderRequest,
						renderResponse, themeDisplay);
				renderRequest.setAttribute(Constantes.TITULO_PORTLET, tituloPortlet);
				
				// Recuperar a pasta
				Folder folder = null;
				if (Long.valueOf(folderId) > 0) {
					folder = DLAppServiceUtil.getFolder(Long.valueOf(folderId));
				}
				if (folder != null) {
					renderRequest.setAttribute(Constantes.NOME_PASTA, folder.getName());
				} else {
					renderRequest.setAttribute(Constantes.NOME_PASTA, Constantes.PASTA_RAIZ);
				}
				
				super.render(renderRequest, renderResponse);

			} else {
				include(naoConfiguradoJSP, renderRequest, renderResponse);
			}
		} catch (Exception e) {
			SessionErrors.add(renderRequest, Constantes.MSG_ERRO_PORTLET);
		}
	}

	
	@ProcessEvent(qname="{http://prodevelopment.com.br/events}galeriaimagem.exibir")
	public void exibir(EventRequest request, EventResponse response) {
		Event event = request.getEvent();
		String folderIdEvento = (String)event.getValue();
		response.setRenderParameter("folderIdEvento", folderIdEvento);
	}

	private int getPagina(RenderRequest renderRequest) {
		int page = 1;

		if (renderRequest.getParameter(Constantes.PAGINA) != null
				&& !StringPool.BLANK.equals(renderRequest.getParameter(Constantes.PAGINA))) {
			page = Integer.valueOf(renderRequest.getParameter(Constantes.PAGINA));
		}

		return page;
	}

}
