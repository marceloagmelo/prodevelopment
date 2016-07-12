package br.com.elmaragon.produto.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;

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

}