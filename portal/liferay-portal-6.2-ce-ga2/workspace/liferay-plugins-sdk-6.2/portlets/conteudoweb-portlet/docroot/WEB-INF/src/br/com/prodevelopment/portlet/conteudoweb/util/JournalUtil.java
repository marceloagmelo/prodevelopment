package br.com.prodevelopment.portlet.conteudoweb.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Attribute;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.comparator.ModelResourceComparator;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.assetpublisher.util.AssetPublisherUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.util.DDMXMLUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleImageLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.util.FiniteUniqueStack;
import com.liferay.util.JS;

public class JournalUtil {

	public static final int MAX_STACK_SIZE = 20;
	public static final String JOURNAL_RECENT_ARTICLES = "JOURNAL_RECENT_ARTICLES";
	public static final String CLASSNAME_SEPARATOR = "_CLASSNAME_";
	public static final String JOURNAL_ARTICLE_ASSET = "JournalArticleAssetRendererFactory";

	public static Stack<JournalArticle> getRecentArticles(
			PortletRequest portletRequest) {

		PortletSession portletSession = portletRequest.getPortletSession();

		Stack<JournalArticle> recentArticles = (Stack<JournalArticle>) portletSession
				.getAttribute(JOURNAL_RECENT_ARTICLES);

		if (recentArticles == null) {
			recentArticles = new FiniteUniqueStack<JournalArticle>(
					MAX_STACK_SIZE);

			portletSession
					.setAttribute(JOURNAL_RECENT_ARTICLES, recentArticles);
		}

		return recentArticles;
	}

	public static String removeOldContent(String content, String xsd) {
		try {
			Document contentDoc = SAXReaderUtil.read(content);
			Document xsdDoc = SAXReaderUtil.read(xsd);

			Element contentRoot = contentDoc.getRootElement();

			Stack<String> path = new Stack<String>();

			path.push(contentRoot.getName());

			_removeOldContent(path, contentRoot, xsdDoc);

			content = DDMXMLUtil.formatXML(contentDoc);
		} catch (Exception e) {
			e.getMessage();
		}

		return content;
	}

	public static void removeRecentArticle(PortletRequest portletRequest,
			String articleId) {

		removeRecentArticle(portletRequest, articleId, 0);
	}

	public static void removeRecentArticle(PortletRequest portletRequest,
			String articleId, double version) {

		Stack<JournalArticle> stack = getRecentArticles(portletRequest);

		Iterator<JournalArticle> itr = stack.iterator();

		while (itr.hasNext()) {
			JournalArticle journalArticle = itr.next();

			if (journalArticle.getArticleId().equals(articleId)
					&& ((journalArticle.getVersion() == version) || (version == 0))) {

				itr.remove();
			}
		}
	}

	public static JournalArticle getArticle(long classPK, long groupId)
			throws PortalException, SystemException {
		JournalArticleResource artigoResource = JournalArticleResourceLocalServiceUtil
				.getArticleResource(classPK);
		return JournalArticleLocalServiceUtil.getLatestArticle(groupId,
				String.valueOf(artigoResource.getArticleId()),
				WorkflowConstants.STATUS_APPROVED);
	}

	public static void addRecentArticle(PortletRequest portletRequest,
			JournalArticle article) {

		if (article != null) {
			Stack<JournalArticle> stack = getRecentArticles(portletRequest);

			stack.push(article);
		}
	}

	public static String mergeArticleContent(String curContent,
			String newContent, boolean removeNullElements) {

		try {
			Document curDocument = SAXReaderUtil.read(curContent);
			Document newDocument = SAXReaderUtil.read(newContent);

			Element curRootElement = curDocument.getRootElement();
			Element newRootElement = newDocument.getRootElement();

			curRootElement.addAttribute("default-locale",
					newRootElement.attributeValue("default-locale"));
			curRootElement.addAttribute("available-locales",
					newRootElement.attributeValue("available-locales"));

			_mergeArticleContentUpdate(curDocument, newRootElement,
					LocaleUtil.toLanguageId(LocaleUtil.getDefault()));

			if (removeNullElements) {
				_mergeArticleContentDelete(curRootElement, newDocument);
			}

			curContent = DDMXMLUtil.formatXML(curDocument);
		} catch (Exception e) {
			e.getMessage();
		}

		return curContent;
	}

	private static void _addElementOptions(Element curContentElement,
			Element newContentElement) {

		List<Element> newElementOptions = newContentElement.elements("option");

		for (Element newElementOption : newElementOptions) {
			Element curElementOption = SAXReaderUtil.createElement("option");

			curElementOption.addCDATA(newElementOption.getText());

			curContentElement.add(curElementOption);
		}
	}

	private static void _decodeXMLAttributes(List<Element> elements) {
		for (Element element : elements) {
			String elName = element.attributeValue("name", StringPool.BLANK);
			String elType = element.attributeValue("type", StringPool.BLANK);

			if (Validator.isNotNull(elName)) {
				elName = JS.decodeURIComponent(elName);

				element.addAttribute("name", elName);
			}

			if (Validator.isNotNull(elType)) {
				elType = JS.decodeURIComponent(elType);

				element.addAttribute("type", elType);
			}

			_decodeXMLAttributes(element.elements());
		}
	}

	private static Element _getElementByInstanceId(Document document,
			String instanceId) {

		XPath xPathSelector = SAXReaderUtil
				.createXPath("//dynamic-element[@instance-id='" + instanceId
						+ "']");

		List<Node> nodes = xPathSelector.selectNodes(document);

		if (nodes.size() == 1) {
			return (Element) nodes.get(0);
		} else {
			return null;
		}
	}

	private static void _mergeArticleContentDelete(Element curParentElement,
			Document newDocument) throws Exception {

		List<Element> curElements = curParentElement
				.elements("dynamic-element");

		for (int i = 0; i < curElements.size(); i++) {
			Element curElement = curElements.get(i);

			_mergeArticleContentDelete(curElement, newDocument);

			String instanceId = curElement.attributeValue("instance-id");

			Element newElement = _getElementByInstanceId(newDocument,
					instanceId);

			if (newElement == null) {
				curElement.detach();

				String type = curElement.attributeValue("type");

				if (type.equals("image")) {
					_mergeArticleContentDeleteImages(curElement
							.elements("dynamic-content"));
				}
			}
		}
	}

	private static void _mergeArticleContentDeleteImages(List<Element> elements)
			throws Exception {

		for (Element element : elements) {
			long articleImageId = GetterUtil.getLong(element
					.attributeValue("id"));

			JournalArticleImageLocalServiceUtil
					.deleteArticleImage(articleImageId);
		}
	}

	private static void _mergeArticleContentUpdate(Document curDocument,
			Element newParentElement, Element newElement, int pos,
			String defaultLocale) throws Exception {

		_mergeArticleContentUpdate(curDocument, newElement, defaultLocale);

		String instanceId = newElement.attributeValue("instance-id");

		Element curElement = _getElementByInstanceId(curDocument, instanceId);

		if (curElement != null) {
			_mergeArticleContentUpdate(curElement, newElement, defaultLocale);
		} else {
			String parentInstanceId = newParentElement
					.attributeValue("instance-id");

			if (Validator.isNull(parentInstanceId)) {
				Element curRoot = curDocument.getRootElement();

				List<Element> curRootElements = curRoot.elements();

				curRootElements.add(pos, newElement.createCopy());
			} else {
				Element curParentElement = _getElementByInstanceId(curDocument,
						parentInstanceId);

				if (curParentElement != null) {
					List<Element> curParentElements = curParentElement
							.elements();

					curParentElements.add(pos, newElement.createCopy());
				}
			}
		}
	}

	private static void _mergeArticleContentUpdate(Document curDocument,
			Element newParentElement, String defaultLocale) throws Exception {

		List<Element> newElements = newParentElement
				.elements("dynamic-element");

		for (int i = 0; i < newElements.size(); i++) {
			Element newElement = newElements.get(i);

			_mergeArticleContentUpdate(curDocument, newParentElement,
					newElement, i, defaultLocale);
		}
	}

	private static void _mergeArticleContentUpdate(Element curElement,
			Element newElement, String defaultLocale) {

		Attribute curTypeAttribute = curElement.attribute("type");
		Attribute newTypeAttribute = newElement.attribute("type");

		curTypeAttribute.setValue(newTypeAttribute.getValue());

		Attribute curIndexTypeAttribute = curElement.attribute("index-type");
		Attribute newIndexTypeAttribute = newElement.attribute("index-type");

		if (newIndexTypeAttribute != null) {
			if (curIndexTypeAttribute == null) {
				curElement.addAttribute("index-type",
						newIndexTypeAttribute.getValue());
			} else {
				curIndexTypeAttribute
						.setValue(newIndexTypeAttribute.getValue());
			}
		}

		Element newContentElement = newElement.elements("dynamic-content").get(
				0);

		String newLanguageId = newContentElement.attributeValue("language-id");
		String newValue = newContentElement.getText();

		String indexType = newElement.attributeValue("index-type");

		if (Validator.isNotNull(indexType)) {
			curElement.addAttribute("index-type", indexType);
		}

		List<Element> curContentElements = curElement
				.elements("dynamic-content");

		if (Validator.isNull(newLanguageId)) {
			for (Element curContentElement : curContentElements) {
				curContentElement.detach();
			}

			Element curContentElement = SAXReaderUtil
					.createElement("dynamic-content");

			if (newContentElement.element("option") != null) {
				_addElementOptions(curContentElement, newContentElement);
			} else {
				curContentElement.addCDATA(newValue);
			}

			curElement.add(curContentElement);
		} else {
			boolean alreadyExists = false;

			for (Element curContentElement : curContentElements) {
				String curLanguageId = curContentElement
						.attributeValue("language-id");

				if (newLanguageId.equals(curLanguageId)) {
					alreadyExists = true;

					curContentElement.clearContent();

					if (newContentElement.element("option") != null) {
						_addElementOptions(curContentElement, newContentElement);
					} else {
						curContentElement.addCDATA(newValue);
					}

					break;
				}
			}

			if (!alreadyExists) {
				Element curContentElement = curContentElements.get(0);

				String curLanguageId = curContentElement
						.attributeValue("language-id");

				if (Validator.isNull(curLanguageId)) {
					if (newLanguageId.equals(defaultLocale)) {
						curContentElement.clearContent();

						if (newContentElement.element("option") != null) {
							_addElementOptions(curContentElement,
									newContentElement);
						} else {
							curContentElement.addCDATA(newValue);
						}
					} else {
						curElement.add(newContentElement.createCopy());
					}

					curContentElement
							.addAttribute("language-id", defaultLocale);
				} else {
					curElement.add(newContentElement.createCopy());
				}
			}
		}
	}

	private static void _removeOldContent(Stack<String> path,
			Element contentElement, Document xsdDocument)
			throws SystemException {

		String elementPath = "";

		for (int i = 0; i < path.size(); i++) {
			elementPath += "/" + path.elementAt(i);
		}

		for (int i = 0; i < contentElement.nodeCount(); i++) {
			Node contentNode = contentElement.node(i);

			if (contentNode instanceof Element) {
				_removeOldContent(path, (Element) contentNode, xsdDocument,
						elementPath);
			}
		}
	}

	private static void _removeOldContent(Stack<String> path,
			Element contentElement, Document xsdDocument, String elementPath)
			throws SystemException {

		String name = contentElement.attributeValue("name");

		if (Validator.isNull(name)) {
			return;
		}

		String localPath = "dynamic-element[@name='" + name + "']";

		String fullPath = elementPath + "/" + localPath;

		XPath xPathSelector = SAXReaderUtil.createXPath(fullPath);

		List<Node> curNodes = xPathSelector.selectNodes(xsdDocument);

		if (curNodes.size() == 0) {
			contentElement.detach();
		}

		path.push(localPath);

		_removeOldContent(path, contentElement, xsdDocument);

		path.pop();
	}

	public static PortletURL getAddPortletURL(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String className,
			long classTypeId, long[] allAssetCategoryIds,
			String[] allAssetTagNames, String redirect) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil
				.getAssetRendererFactoryByClassName(className);

		if (assetRendererFactory == null) {
			return null;
		}

		liferayPortletRequest.setAttribute(
				WebKeys.ASSET_RENDERER_FACTORY_CLASS_TYPE_ID, classTypeId);

		PortletURL addPortletURL = assetRendererFactory.getURLAdd(
				liferayPortletRequest, liferayPortletResponse);

		if (addPortletURL == null) {
			return null;
		}

		if (redirect != null) {
			addPortletURL.setParameter("redirect", redirect);
		}

		String referringPortletResource = ParamUtil.getString(
				liferayPortletRequest, "portletResource");

		if (Validator.isNotNull(referringPortletResource)) {
			addPortletURL.setParameter("referringPortletResource",
					referringPortletResource);
		} else {
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			addPortletURL.setParameter("referringPortletResource",
					portletDisplay.getId());

			if (allAssetCategoryIds != null) {
				Map<Long, String> assetVocabularyAssetCategoryIds = new HashMap<Long, String>();

				for (long assetCategoryId : allAssetCategoryIds) {
					AssetCategory assetCategory = AssetCategoryLocalServiceUtil
							.fetchAssetCategory(assetCategoryId);

					if (assetCategory == null) {
						continue;
					}

					long assetVocabularyId = assetCategory.getVocabularyId();

					if (assetVocabularyAssetCategoryIds
							.containsKey(assetVocabularyId)) {

						String assetCategoryIds = assetVocabularyAssetCategoryIds
								.get(assetVocabularyId);

						assetVocabularyAssetCategoryIds.put(assetVocabularyId,
								assetCategoryIds + StringPool.COMMA
										+ assetCategoryId);
					} else {
						assetVocabularyAssetCategoryIds.put(assetVocabularyId,
								String.valueOf(assetCategoryId));
					}
				}

				for (Map.Entry<Long, String> entry : assetVocabularyAssetCategoryIds
						.entrySet()) {

					long assetVocabularyId = entry.getKey();
					String assetCategoryIds = entry.getValue();

					addPortletURL.setParameter("assetCategoryIds_"
							+ assetVocabularyId, assetCategoryIds);
				}
			}

			if (allAssetTagNames != null) {
				addPortletURL.setParameter("assetTagNames",
						StringUtil.merge(allAssetTagNames));
			}
		}

		if (classTypeId > 0) {
			addPortletURL.setParameter("classTypeId",
					String.valueOf(classTypeId));

			if (className.equals(DLFileEntry.class.getName())) {
				addPortletURL.setParameter(Constants.CMD, Constants.ADD);
				addPortletURL.setParameter("folderId", String
						.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
				addPortletURL.setParameter("fileEntryTypeId",
						String.valueOf(classTypeId));
			}

			if (className.equals(JournalArticle.class.getName())) {
				DDMStructure ddmStructure = DDMStructureLocalServiceUtil
						.getStructure(classTypeId);

				addPortletURL.setParameter("structureId",
						ddmStructure.getStructureKey());
			}
		}

		addPortletURL.setPortletMode(PortletMode.VIEW);
		addPortletURL.setWindowState(LiferayWindowState.POP_UP);

		return addPortletURL;
	}

	public static Map<String, PortletURL> getAddPortletURLs(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, long[] classNameIds,
			long[] classTypeIds, long[] allAssetCategoryIds,
			String[] allAssetTagNames, String redirect) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		Map<String, PortletURL> addPortletURLs = new TreeMap<String, PortletURL>(
				new ModelResourceComparator(themeDisplay.getLocale()));

		if (Validator.isNull(redirect)) {
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			PortletURL redirectURL = liferayPortletResponse
					.createLiferayPortletURL(themeDisplay.getPlid(),
							portletDisplay.getId(),
							PortletRequest.RENDER_PHASE, false);

			redirectURL.setParameter("struts_action",
					"/asset_publisher/add_asset_redirect");
			redirectURL.setParameter("redirect", themeDisplay.getURLCurrent());
			redirectURL.setWindowState(LiferayWindowState.POP_UP);

			redirect = redirectURL.toString();
		}

		for (long classNameId : classNameIds) {
			String className = PortalUtil.getClassName(classNameId);

			AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil
					.getAssetRendererFactoryByClassName(className);

			Portlet portlet = PortletLocalServiceUtil.getPortletById(
					themeDisplay.getCompanyId(),
					assetRendererFactory.getPortletId());

			if (!portlet.isActive()) {
				continue;
			}

			Map<Long, String> classTypes = assetRendererFactory.getClassTypes(
					new long[] { themeDisplay.getCompanyGroupId(),
							themeDisplay.getScopeGroupId() },
					themeDisplay.getLocale());

			if (Validator.isNull(classTypeIds)) {
				PortletURL addPortletURL = getAddPortletURL(
						liferayPortletRequest, liferayPortletResponse,
						className, 0, allAssetCategoryIds, allAssetTagNames,
						redirect);

				if (addPortletURL != null) {
					addPortletURLs.put(className, addPortletURL);
				}
			}

			for (long classTypeId : classTypes.keySet()) {
				if (ArrayUtil.contains(classTypeIds, classTypeId)
						|| (Validator.isNull(classTypeIds))) {

					PortletURL addPortletURL = getAddPortletURL(
							liferayPortletRequest, liferayPortletResponse,
							className, classTypeId, allAssetCategoryIds,
							allAssetTagNames, redirect);

					if (addPortletURL != null) {
						String mesage = className + CLASSNAME_SEPARATOR
								+ classTypes.get(classTypeId);

						addPortletURLs.put(mesage, addPortletURL);
					}
				}
			}
		}

		return addPortletURLs;
	}

	public static boolean hasSubtype(String subtypeClassName,
			Map<String, PortletURL> addPortletURLs) {

		for (Map.Entry<String, PortletURL> entry : addPortletURLs.entrySet()) {
			String className = entry.getKey();

			if (className.startsWith(subtypeClassName)
					&& !className.equals(subtypeClassName)) {

				return true;
			}
		}

		return false;
	}

	public static Map<Long, String> getEstruturas(ThemeDisplay themeDisplay)
			throws Exception {
		Map<Long, String> retorno = null;

		for (AssetRendererFactory assetRendererFactory : AssetRendererFactoryRegistryUtil
				.getAssetRendererFactories(themeDisplay.getCompanyId())) {
			Map<Long, String> assetAvailableClassTypes = assetRendererFactory
					.getClassTypes(
							new long[] { themeDisplay.getCompanyGroupId(),
									themeDisplay.getScopeGroupId() },
							themeDisplay.getLocale());

			if (assetAvailableClassTypes.isEmpty()) {
				continue;
			}

			String className = AssetPublisherUtil
					.getClassName(assetRendererFactory);

			if (JOURNAL_ARTICLE_ASSET.equals(className)) {
				retorno = assetAvailableClassTypes;
				break;
			}

		}

		return retorno;
	}
}
