package br.com.prodevelopment.portlet.emailmarketingexpress.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.portlet.emailmarketingexpress.Constantes;
import br.com.prodevelopment.portlet.emailmarketingexpress.util.Email;
import br.com.prodevelopment.portlet.emailmarketingexpress.util.EmailMarketingExpressUtil;
import br.com.prodevelopment.portlet.emailmarketingexpress.vo.ArquivoVO;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

/**
 * Portlet implementation class EmailMarketingExpressPortlet
 */
public class EmailMarketingExpressPortlet extends MVCPortlet {

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String arquivoGerado = (String) renderRequest.getParameter("arquivoGerado");

		// Recuperar objetos da sessao
		String nomeArquivo = (String) renderRequest.getPortletSession().getAttribute(
				Constantes.PROP_BUSCA_NOME_ARQUIVO);
		
		// Salvar id no request
		renderRequest.setAttribute(Constantes.PROP_BUSCA_NOME_ARQUIVO, nomeArquivo);
		renderRequest.setAttribute("arquivoGerado", arquivoGerado);

		PortletURL confirmarURL = renderResponse.createActionURL();
		confirmarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.URL_METODO_CONFIRMAR);
		renderRequest.setAttribute(Constantes.NOME_PARAM_CONFIRMAR, confirmarURL
				.toString());
		
		super.doView(renderRequest, renderResponse);
	}

	public void confirmar(ActionRequest request,
			ActionResponse response) throws Exception {
		
		//String urlPortal = PortletProps.get("email.url.portal");
		//String corpo = PortletProps.get("email.corpo");
		
		//FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(25706);
		//String urlImagem = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK, false, true);
		//StringBuffer sb = new StringBuffer();
		//sb.append("<html>");
		//sb.append("<b><i>");
		//sb.append("Programa de Fidelidade");
		//sb.append("</i></b><br><br>");
		//sb.append("Prezado cliente,");
		//sb.append("<br>");
		//sb.append(corpo);
		//sb.append("<br><br>");
		//sb.append("<img src='");
		//sb.append(HtmlUtil.escape(urlImagem));
		//sb.append("' alt='Programa de Fidelidade' style='width: 500px; height: 707px;'>");
		//sb.append("<br><br><br>");
		//sb.append("<a href='");
		//sb.append(urlPortal);
		//sb.append("'>");
		//sb.append("Clique aqui para conferir.");
		//sb.append("</a>");
		
		//sb.append("</html>");
		
		Map<String, ArquivoVO> lista = EmailMarketingExpressUtil.confirmar(request, response);
		
		String nomeArquivo = EmailMarketingExpressUtil.gerarArquivoTexto(request, lista);

		//String fromEmail = PortletProps.get("email.from");
		//String assunto = PortletProps.get("email.assunto");
		//String toEmail = "cesar@rasecmadeiras.com.br";
		
		/*
		UploadPortletRequest upLoadRequest = PortalUtil
				.getUploadPortletRequest(request);
		File arquivo = upLoadRequest.getFile(Constantes.PROP_NOME_IMAGEM);
		*/

		List<File> anexos = new ArrayList<File>(1);
		String pasta = PortletProps.get("pasta.arquivo");
		String nArquivo = PortletProps.get("nome.arquivo");
		
		File arquivo2 = new File(pasta+nArquivo);
		anexos.add(arquivo2);
		
		EmailMarketingExpressUtil.enviarEmail(request, nomeArquivo, anexos);
	}
}
