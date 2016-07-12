package br.com.prodevelopment.portlet.importregion.util;

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
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class Helper {
	public static String getTituloPortlet(RenderRequest renderRequest,
			RenderResponse renderResponse, ThemeDisplay themeDisplay)
			throws SystemException {
		String portletTitulo = "";

		Portlet portlet = (Portlet) renderRequest
				.getAttribute(WebKeys.RENDER_PORTLET);

		String portletId = portlet.getPortletId();

		PortletPreferences portletSetup = PortletPreferencesFactoryUtil
				.getLayoutPortletSetup(themeDisplay.getLayout(), portletId);

		String defaultLanguageId = LocaleUtil.toLanguageId(PortalUtil
				.getLocale(renderRequest));

		portletTitulo = GetterUtil.getString(portletSetup.getValue(
				"portletSetupTitle_" + defaultLanguageId, StringPool.BLANK));

		if (Validator.isNull(portletTitulo)) {
			ResourceBundle resource = ResourceBundle.getBundle(
					portlet.getResourceBundle(), LocaleUtil.getDefault());
			portletTitulo = resource.getString("javax.portlet.title");
		}

		return portletTitulo;
	}

	public static String retiraAcentos(String acentos)
    {
        if ( acentos != null ) {
            acentos = acentos.replaceAll("[èéêë]", "e");
            acentos = acentos.replaceAll("[ûùúü]", "u");
            acentos = acentos.replaceAll("[ïîíì]", "i");
            acentos = acentos.replaceAll("[àâáäã]", "a");
            acentos = acentos.replaceAll("[ôóòöõ]", "o");

            acentos = acentos.replaceAll("[ÈÉÊË]", "E");
            acentos = acentos.replaceAll("[ÛÙÚÜ]", "U");
            acentos = acentos.replaceAll("[ÏÎÍÌ]", "I");
            acentos = acentos.replaceAll("[ÀÂÁÄÃ]", "A");
            acentos = acentos.replaceAll("[ÔÓÖÒÕ]", "O");
            acentos = acentos.replaceAll("[´`'^~]", " ");
            acentos = acentos.replaceAll("ç", "c");
            acentos = acentos.replaceAll("Ç", "C");
            acentos = acentos.replaceAll("®", " ");
        }
		return acentos;
	}

}
