package br.com.prodevelopment.conteudo.exibir.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.conteudo.exibir.Constantes;
import br.com.prodevelopment.conteudo.util.DateUtil;
import br.com.prodevelopment.conteudo.util.PortletLogic;
import br.com.prodevelopment.conteudo.util.Search;
import br.com.prodevelopment.conteudo.vo.ConteudoVO;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.LayoutTypePortletConstants;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.NoSuchTemplateException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.model.JournalTemplate;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil;

public class ConfiguracaoActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String prefId = ParamUtil.getString(actionRequest, Constantes.PREF_ID);
		String prefImprimir = ParamUtil.getString(actionRequest,
				Constantes.PREF_IMPRIMIR);
		String prefPontuacao = ParamUtil.getString(actionRequest,
				Constantes.PREF_PONTUACAO);
		String prefComentario = ParamUtil.getString(actionRequest,
				Constantes.PREF_COMENTARIO);
		String prefPontuacaoComentario = ParamUtil.getString(actionRequest,
				Constantes.PREF_PONTUACAO_COMENTARIO);
		String prefUsuarioDataAtualizacao = ParamUtil.getString(actionRequest,
				Constantes.PREF_USUARIO_DATA_ATUALIZACAO);
		String prefVoltar = ParamUtil.getString(actionRequest,
				Constantes.PREF_VOLTAR);
		String prefEmail = ParamUtil.getString(actionRequest,
				Constantes.PREF_EMAIL);
		String prefRsFacebook = ParamUtil.getString(actionRequest,
				Constantes.PREF_RS_FACEBOOK);
		String prefRsTwitter = ParamUtil.getString(actionRequest,
				Constantes.PREF_RS_TWITTER);
		String prefRsLinkedIn = ParamUtil.getString(actionRequest,
				Constantes.PREF_RS_LINKEDIN);
		String prefRsGoogle = ParamUtil.getString(actionRequest,
				Constantes.PREF_RS_GOOGLE);
		String prefEstrutura = ParamUtil.getString(actionRequest,
				Constantes.PREF_ESTRUTURA);
		String prefExibirTitulo = ParamUtil.getString(actionRequest,
				Constantes.PREF_EXIBIR_TITULO);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(themeDisplay.getPermissionChecker(),
				themeDisplay.getLayout(), portletResource,
				ActionKeys.CONFIGURATION);

		portletPreferences.setValue(Constantes.PREF_ID, prefId);
		portletPreferences.setValue(Constantes.PREF_IMPRIMIR, prefImprimir);
		portletPreferences.setValue(Constantes.PREF_PONTUACAO, prefPontuacao);
		portletPreferences.setValue(Constantes.PREF_COMENTARIO, prefComentario);
		portletPreferences.setValue(Constantes.PREF_PONTUACAO_COMENTARIO,
				prefPontuacaoComentario);
		portletPreferences.setValue(Constantes.PREF_USUARIO_DATA_ATUALIZACAO,
				prefUsuarioDataAtualizacao);
		portletPreferences.setValue(Constantes.PREF_VOLTAR, prefVoltar);
		portletPreferences.setValue(Constantes.PREF_EMAIL, prefEmail);
		portletPreferences
				.setValue(Constantes.PREF_RS_FACEBOOK, prefRsFacebook);
		portletPreferences.setValue(Constantes.PREF_RS_TWITTER, prefRsTwitter);
		portletPreferences
				.setValue(Constantes.PREF_RS_LINKEDIN, prefRsLinkedIn);
		portletPreferences
		.setValue(Constantes.PREF_RS_GOOGLE, prefRsGoogle);
		portletPreferences.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);
		portletPreferences.setValue(Constantes.PREF_ESTRUTURA, prefEstrutura);
		portletPreferences.setValue(Constantes.PREF_EXIBIR_TITULO,
				prefExibirTitulo);

		if (SessionErrors.isEmpty(actionRequest)) {
			portletPreferences.store();

			// updateContentSearch(actionRequest, portletResource, prefId);
			updateContentSearch(actionRequest, prefId);

			updateLayout(actionRequest, prefId);
			
			SessionMessages.add(actionRequest, portletConfig.getPortletName()
					+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
					portletResource);

			SessionMessages.add(actionRequest, portletConfig.getPortletName()
					+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(renderRequest));

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletResource);

		String prefId = preferences.getValue(Constantes.PREF_ID,
				Constantes.ZERO);
		boolean prefImprimir = GetterUtil.getBoolean(preferences.getValue(
				Constantes.PREF_IMPRIMIR, null));
		boolean prefPontuacao = GetterUtil.getBoolean(preferences.getValue(
				Constantes.PREF_PONTUACAO, null));
		boolean prefComentario = Constantes.JOURNAL_ARTICLE_COMMENTS_ENABLED
				&& GetterUtil.getBoolean(preferences.getValue(
						Constantes.PREF_COMENTARIO, null));
		boolean prefPontuacaoComentario = GetterUtil.getBoolean(preferences
				.getValue(Constantes.PREF_PONTUACAO_COMENTARIO, null));
		boolean prefUsuarioDataAtualizacao = GetterUtil.getBoolean(preferences
				.getValue(Constantes.PREF_USUARIO_DATA_ATUALIZACAO, null));
		boolean prefVoltar = GetterUtil.getBoolean(preferences.getValue(
				Constantes.PREF_VOLTAR, null));
		boolean prefEmail = GetterUtil.getBoolean(preferences.getValue(
				Constantes.PREF_EMAIL, null));
		boolean prefRsFacebook = GetterUtil.getBoolean(preferences.getValue(
				Constantes.PREF_RS_FACEBOOK, null));
		boolean prefRsTwitter = GetterUtil.getBoolean(preferences.getValue(
				Constantes.PREF_RS_TWITTER, null));
		boolean prefRsLinkedIn = GetterUtil.getBoolean(preferences.getValue(
				Constantes.PREF_RS_LINKEDIN, null));
		boolean prefRsGoogle = GetterUtil.getBoolean(preferences.getValue(
				Constantes.PREF_RS_GOOGLE, null));
		String prefEstrutura = preferences.getValue(Constantes.PREF_ESTRUTURA,
				Constantes.VAZIO);
		String prefExibirTitulo = preferences.getValue(
				Constantes.PREF_EXIBIR_TITULO, Constantes.N);

		String nome = ParamUtil.getString(renderRequest, Constantes.PROP_NOME);

		int pagina = Search.getPage(httpReq);
		int inicioPag = (pagina * Constantes.TOTAL_POR_PAGINA)
				- Constantes.TOTAL_POR_PAGINA;
		int fimPag = inicioPag + Constantes.TOTAL_POR_PAGINA;

		long groupId = PortalUtil.getScopeGroupId(httpReq);

		Hits hits = Search.busca(groupId, nome, null, null, null, null,
				inicioPag, fimPag, Field.MODIFIED_DATE);

		int totalConteudos = hits.getLength();

		Document[] docs = hits.getDocs();
		List<ConteudoVO> listaConteudos = new ArrayList<ConteudoVO>();

		for (Document doc : docs) {
			ConteudoVO conteudoVO = new ConteudoVO();
			conteudoVO.setId(doc.get("articleId"));

			JournalArticle artigo = JournalArticleLocalServiceUtil.getArticle(
					groupId, conteudoVO.getId());

			conteudoVO.setTitulo(doc.get(Field.TITLE));
			conteudoVO.setDescricao(doc.get(Field.DESCRIPTION));

			conteudoVO.setDataAlteracao(DateUtil.dateToStringWithHour(artigo
					.getModifiedDate()));

			listaConteudos.add(conteudoVO);
		}

		renderRequest.setAttribute(Constantes.PREF_ID, prefId);
		renderRequest.setAttribute(Constantes.PREF_IMPRIMIR, prefImprimir);
		renderRequest.setAttribute(Constantes.PREF_PONTUACAO, prefPontuacao);
		renderRequest.setAttribute(Constantes.PREF_COMENTARIO, prefComentario);
		renderRequest.setAttribute(Constantes.PREF_PONTUACAO_COMENTARIO,
				prefPontuacaoComentario);
		renderRequest.setAttribute(Constantes.PREF_USUARIO_DATA_ATUALIZACAO,
				prefUsuarioDataAtualizacao);
		renderRequest.setAttribute(Constantes.PREF_VOLTAR, prefVoltar);
		renderRequest.setAttribute(Constantes.PREF_EMAIL, prefEmail);
		renderRequest.setAttribute(Constantes.PREF_RS_FACEBOOK, prefRsFacebook);
		renderRequest.setAttribute(Constantes.PREF_RS_TWITTER, prefRsTwitter);
		renderRequest.setAttribute(Constantes.PREF_RS_LINKEDIN, prefRsLinkedIn);
		renderRequest.setAttribute(Constantes.PREF_RS_GOOGLE, prefRsGoogle);
		renderRequest.setAttribute("total", totalConteudos);
		renderRequest.setAttribute(Constantes.LISTA_CONTEUDOS, listaConteudos);
		renderRequest.setAttribute("page", pagina);
		renderRequest.setAttribute("pageSize", Constantes.TOTAL_POR_PAGINA);
		renderRequest.setAttribute(Constantes.PROP_NOME, nome);
		renderRequest.setAttribute(Constantes.PREF_ESTRUTURA, prefEstrutura);
		renderRequest.setAttribute(Constantes.PREF_EXIBIR_TITULO,
				prefExibirTitulo);

		List<JournalStructure> listaEstrutura = JournalStructureLocalServiceUtil
				.getStructures(PortalUtil.getScopeGroupId(renderRequest));

		if (listaEstrutura.size() > 0) {
			renderRequest.setAttribute(Constantes.LISTA_ESTRUTURA,
					listaEstrutura);
		}

		return "/html/exibirconteudo/config.jsp";
	}

	protected String getRuntimePortletId(String xml) throws Exception {
		com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(xml);

		Element rootElement = document.getRootElement();

		String instanceId = rootElement.attributeValue("instance");
		String portletId = rootElement.attributeValue("name");

		if (Validator.isNotNull(instanceId)) {
			portletId += PortletConstants.INSTANCE_SEPARATOR + instanceId;
		}

		return portletId;
	}

	protected String getRuntimePortletIds(String content) throws Exception {
		StringBundler sb = new StringBundler();

		for (int index = 0;;) {
			index = content.indexOf(PortletLogic.OPEN_TAG, index);

			if (index == -1) {
				break;
			}

			int close1 = content.indexOf(PortletLogic.CLOSE_1_TAG, index);
			int close2 = content.indexOf(PortletLogic.CLOSE_2_TAG, index);

			int closeIndex = -1;

			if ((close2 == -1) || ((close1 != -1) && (close1 < close2))) {
				closeIndex = close1 + PortletLogic.CLOSE_1_TAG.length();
			}
			else {
				closeIndex = close2 + PortletLogic.CLOSE_2_TAG.length();
			}

			if (closeIndex == -1) {
				break;
			}

			if (sb.length() > 0) {
				sb.append(StringPool.COMMA);
			}

			sb.append(
				getRuntimePortletId(content.substring(index, closeIndex)));

			index = closeIndex;
		}

		if (sb.length() == 0) {
			return null;
		}

		return sb.toString();
	}

	protected String getRuntimePortletIds(
			ThemeDisplay themeDisplay, String articleId)
		throws Exception {

		JournalArticle journalArticle = null;

		Group companyGroup = GroupLocalServiceUtil.getCompanyGroup(
			themeDisplay.getCompanyId());

		try {
			journalArticle = JournalArticleLocalServiceUtil.getDisplayArticle(
				themeDisplay.getScopeGroupId(), articleId);
		}
		catch (NoSuchArticleException nsae) {
		}

		if (journalArticle == null) {
			try {
				journalArticle =
					JournalArticleLocalServiceUtil.getDisplayArticle(
						companyGroup.getGroupId(), articleId);
			}
			catch (NoSuchArticleException nsae) {
				return null;
			}
		}

		String portletIds = getRuntimePortletIds(journalArticle.getContent());

		if (Validator.isNotNull(journalArticle.getTemplateId())) {
			JournalTemplate journalTemplate = null;

			try {
				journalTemplate = JournalTemplateLocalServiceUtil.getTemplate(
					themeDisplay.getScopeGroupId(),
					journalArticle.getTemplateId());
			}
			catch (NoSuchTemplateException nste) {
				journalTemplate = JournalTemplateLocalServiceUtil.getTemplate(
					companyGroup.getGroupId(), journalArticle.getTemplateId());
			}

			portletIds = StringUtil.add(
				portletIds, getRuntimePortletIds(journalTemplate.getXsl()));
		}

		return portletIds;
	}

	
	protected void updateContentSearch(PortletRequest portletRequest,
			String articleId) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		String portletResource = ParamUtil.getString(portletRequest,
				"portletResource");

		JournalContentSearchLocalServiceUtil.updateContentSearch(
				layout.getGroupId(), layout.isPrivateLayout(),
				layout.getLayoutId(), portletResource, articleId, true);
	}

	protected void updateLayout(PortletRequest portletRequest, String articleId)
			throws Exception {

		if (Validator.isNull(articleId)) {
			return;
		}
		if (Long.parseLong(articleId) == 0) {
			return;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
				.getLayoutType();

		String portletResource = ParamUtil.getString(portletRequest,
				"portletResource");


		layoutTypePortlet.setPortletIds(
				LayoutTypePortletConstants.RUNTIME_COLUMN_PREFIX
						+ portletResource,
				getRuntimePortletIds(themeDisplay, articleId));
		
		LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
				layout.isPrivateLayout(), layout.getLayoutId(),
				layout.getTypeSettings());
	}
}
