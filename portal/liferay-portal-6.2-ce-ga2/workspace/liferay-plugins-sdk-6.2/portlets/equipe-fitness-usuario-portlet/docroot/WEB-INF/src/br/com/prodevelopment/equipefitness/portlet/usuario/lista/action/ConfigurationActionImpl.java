package br.com.prodevelopment.equipefitness.portlet.usuario.lista.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import br.com.prodevelopment.equipefitness.portlet.usuario.lista.Constantes;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategoryConstants;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyServiceUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		String prefCategoria = portletPreferences.getValue(
				Constantes.PREF_CATEGORIAS_IDS, StringPool.BLANK);

		long vocabularioId = getVocabularioId(themeDisplay);

		if (vocabularioId > 0) {
			renderRequest.setAttribute(Constantes.PREF_CATEGORIAS_IDS, prefCategoria);
		}
		PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);
		String configTemplate = selPortletConfig
				.getInitParameter(CONFIG_TEMPLATE);
		return configTemplate;
	}

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences prefs = actionRequest.getPreferences();
		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		long vocabularioId = getVocabularioId(themeDisplay);

		String prefCategorias = StringPool.BLANK;
		if (vocabularioId > 0) {
			prefCategorias = ParamUtil.getString(actionRequest,
					Constantes.PREF_CATEGORIAS_IDS + StringPool.UNDERLINE
							+ vocabularioId);
		}

		prefs.setValue(Constantes.PREF_CATEGORIAS_IDS, prefCategorias);
		prefs.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);

		if (SessionErrors.isEmpty(actionRequest)) {
			try {
				prefs.store();
				SessionMessages.add(actionRequest,
						Constantes.PORTLET_CONFIGURADO_SUCESSO);
			} catch (ValidatorException ve) {
				SessionErrors.add(actionRequest,
						ValidatorException.class.getName(), ve);

				return;
			}

			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
					portletResource);

			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

	private long getVocabularioId(ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		long vocabularioId = 0;
		long classNameId = PortalUtil.getClassNameId(User.class);

		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		Group siteGroup = themeDisplay.getSiteGroup();

		StringBundler vocabularyGroupIds = new StringBundler(3);

		vocabularies.addAll(AssetVocabularyServiceUtil.getGroupVocabularies(
				siteGroup.getGroupId(), false));

		vocabularyGroupIds.append(siteGroup.getGroupId());

		if (themeDisplay.getScopeGroupId() != themeDisplay.getCompanyGroupId()) {
			vocabularies.addAll(AssetVocabularyServiceUtil
					.getGroupVocabularies(themeDisplay.getCompanyGroupId(),
							false));

			vocabularyGroupIds.append(StringPool.COMMA);
			vocabularyGroupIds.append(themeDisplay.getCompanyGroupId());
		}

		for (AssetVocabulary vocabulary : vocabularies) {
			vocabulary = vocabulary.toEscapedModel();

			int vocabularyCategoriesCount = AssetCategoryServiceUtil
					.getVocabularyCategoriesCount(vocabulary.getGroupId(),
							vocabulary.getVocabularyId());

			if (vocabularyCategoriesCount == 0) {
				continue;
			}

			UnicodeProperties settingsProperties = vocabulary
					.getSettingsProperties();

			long[] selectedClassNameIds = StringUtil.split(
					settingsProperties.getProperty("selectedClassNameIds"), 0L);

			if ((selectedClassNameIds.length > 0)
					&& (selectedClassNameIds[0] != AssetCategoryConstants.ALL_CLASS_NAME_IDS)
					&& !ArrayUtil.contains(selectedClassNameIds, classNameId)) {
				continue;
			}
			vocabularioId = vocabulary.getVocabularyId();
		}
		return vocabularioId;
	}

	public static final String CONFIG_TEMPLATE = "config-template";
}