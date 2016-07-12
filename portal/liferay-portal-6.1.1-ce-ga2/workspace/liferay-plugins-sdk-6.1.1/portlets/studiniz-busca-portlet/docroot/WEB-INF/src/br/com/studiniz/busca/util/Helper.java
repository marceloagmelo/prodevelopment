package br.com.studiniz.busca.util;

import java.util.ResourceBundle;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class Helper {

	public static String trataTextoLongo(String texto, int tamanho) {
		if (texto == null)
			texto = "";
		if (texto.length() > tamanho) {
			texto = texto.substring(0, tamanho);
			texto = texto + "...";
		}
		return texto;
	}

	public static String getTituloPortlet(RenderRequest renderRequest,
			RenderResponse renderResponse, ThemeDisplay themeDisplay) throws SystemException {
		String portletTitulo = "";

		Portlet portlet = (Portlet) renderRequest
				.getAttribute(WebKeys.RENDER_PORTLET);

		String portletId = portlet.getPortletId();


		PortletPreferences portletSetup = PortletPreferencesFactoryUtil
		.getLayoutPortletSetup(themeDisplay.getLayout(), portletId);

		String defaultLanguageId = LocaleUtil.toLanguageId(LocaleUtil
				.getDefault());

		portletTitulo = GetterUtil.getString(portletSetup.getValue(
				"portletSetupTitle_"+defaultLanguageId, StringPool.BLANK));

		if (Validator.isNull(portletTitulo)) {
			ResourceBundle resource  = ResourceBundle.getBundle(portlet.getResourceBundle(), LocaleUtil.getDefault());
			portletTitulo = resource.getString("javax.portlet.title");
		}

		return portletTitulo;
	}

	/**
	 * Retorna a url do ícone do documento utilizando a mesma logica aplicada pelo portlet AssetPublisher
	 * @param doc Documento
	 * @param themeDisplay theme display
	 */
	public static String getDocDownloadUrl(String groupId, String uuid, ThemeDisplay themeDisplay){
		
		if(!empty(groupId) && !empty(uuid) && themeDisplay != null){
			StringBuilder sb= new StringBuilder();
			
			//sb.append(themeDisplay.getPathMain());
			sb.append("/documents/");
			//sb.append(themeDisplay.getPlid());
			//sb.append("&folderId=");
			sb.append(groupId);
			sb.append("/");
			//sb.append(HttpUtil.encodeURL(name));
			sb.append(uuid);
			
		return sb.toString();
		}
		else{
			return null;	
		}
	}
	private static boolean empty(String txt){
		return txt==null || txt.trim().length()==0;
	}
}