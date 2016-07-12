package br.com.rasecmadeiras.busca.util;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;

public class AssetCategoryUtil {
	
	
	public static String getNameById(String categoryoId) {
		
		if(categoryoId == null || categoryoId.isEmpty())
			return null;
		
		categoryoId = categoryoId.replace("]", "").replace("[", "");
		
		String[]categorias = StringUtil.split(categoryoId);
		
		String name = null;
		
		try {
			
			StringBuffer sb = new StringBuffer();
			
			for(String cat:categorias) {
				sb.append(AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(cat.trim())).getName());
				sb.append(", ");
			}
			
			//retirando a ultima virgula
			name = sb.toString().substring(0,sb.toString().length() - 2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return name;
	}

}
