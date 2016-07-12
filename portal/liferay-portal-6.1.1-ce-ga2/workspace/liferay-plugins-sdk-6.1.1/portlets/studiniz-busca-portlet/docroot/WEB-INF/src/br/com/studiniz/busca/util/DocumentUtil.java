package br.com.studiniz.busca.util;

import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.util.DLUtil;

public class DocumentUtil {

	private static boolean empty(String txt){
		return txt==null || txt.trim().length()==0;
	}
	
	/**
	 * Retorna a url do ícone do documento utilizando a mesma logica aplicada pelo portlet AssetPublisher
	 * @param doc Documento
	 * @param themeDisplay theme display
	 */
	public static String getDocIconUrl(String name, ThemeDisplay themeDisplay){
		if(!empty(name) && themeDisplay != null){
			StringBuilder sb= new StringBuilder();
			
			sb.append(themeDisplay.getPathThemeImages());
			sb.append("/file_system/small/");
			sb.append(DLUtil.getFileIcon(name));
			sb.append(".png");
			
			return sb.toString();
		}
		else{
			return null;
		}
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
}
