package br.com.prodevelopment.conteudo.exibir.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.conteudo.exibir.Constantes;
import br.com.prodevelopment.conteudo.util.DateUtil;
import br.com.prodevelopment.conteudo.util.Email;
import br.com.prodevelopment.conteudo.vo.ConteudoVO;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLink;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.documentlibrary.FileNameException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.messageboards.MessageBodyException;
import com.liferay.portlet.messageboards.MessageSubjectException;
import com.liferay.portlet.messageboards.NoSuchMessageException;
import com.liferay.portlet.messageboards.RequiredMessageException;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ExibirConteudoPortlet
 */
public class ExibirConteudoPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;
	protected String popupJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		popupJSP = getInitParameter(Constantes.JSP_POPUP);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(renderRequest));

		String act = httpReq.getParameter("act");

		if (act != null) {

			if (renderRequest.getWindowState()
					.equals(LiferayWindowState.POP_UP)) {

				String articleUrl = httpReq.getParameter("articleurl");

				renderRequest.setAttribute("articleurl", articleUrl);
				include(popupJSP, renderRequest, renderResponse);
				super.render(renderRequest, renderResponse);
				return;
			}
		}
		try {
			HttpServletRequest httpReq1 = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(renderRequest));
			String id = httpReq1.getParameter(Constantes.NOME_PARAM_ID);
			
			// Recuperar preferências do portlet
			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);
			String prefExibirTitulo = prefs.getValue(
					Constantes.PREF_EXIBIR_TITULO, Constantes.N);

			String prefId = prefs.getValue(Constantes.PREF_ID, Constantes.ZERO);
			
			// Verificar a recuperação do id
			if (Validator.isNull(id)) {
				if ((Validator.isNull(prefId)) || (Constantes.ZERO.equals(prefId))) {
					id = Constantes.ZERO;
				} else {
					id = prefId;
				}
			}
			if (Constantes.ZERO.equals(id)) {
				id = ParamUtil.getString(renderRequest,
						Constantes.NOME_PARAM_ID);
			}

			if (Validator.isNull(id)) {
				id = httpReq1.getParameter(Constantes.NOME_PARAM_ID);
			}
			String estrutura = ParamUtil.getString(renderRequest,
					Constantes.NOME_PARAM_ESTRUTURA);
			if (Validator.isNull(estrutura)) {
				estrutura = httpReq1
						.getParameter(Constantes.NOME_PARAM_ESTRUTURA);
			}
			String termoBusca = ParamUtil.getString(renderRequest,
					Constantes.NOME_PARAM_TERMO_BUSCA);
			if (Validator.isNull(termoBusca)) {
				termoBusca = httpReq1
						.getParameter(Constantes.NOME_PARAM_TERMO_BUSCA);
			}

			if (Constantes.S.equals(prefConfigurado)) {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
						.getAttribute(WebKeys.THEME_DISPLAY);

				String urlAtual = themeDisplay.getPortalURL()
						+ PortalUtil.getCurrentURL(httpReq);
				httpReq.setAttribute("urlAtual", urlAtual);

				long groupId = themeDisplay.getScopeGroup().getGroupId();
				String languageId = LanguageUtil.getLanguageId(renderRequest);

				JournalArticle artigo = JournalArticleLocalServiceUtil
						.getLatestArticle(groupId, id,
								WorkflowConstants.STATUS_APPROVED);

				JournalArticleDisplay artigoDisplay = JournalArticleLocalServiceUtil
						.getArticleDisplay(groupId, artigo.getArticleId(),
								"normal", languageId, themeDisplay);
				
				ConteudoVO conteudoVO = new ConteudoVO();
				conteudoVO.setConteudo(artigoDisplay.getContent());
				if (Validator.isNotNull(termoBusca)) {
					String[] palavras = new String[] { termoBusca };
					palavras = StringUtil.split(termoBusca, " ");
					conteudoVO.setConteudo(StringUtil.highlight(
							conteudoVO.getConteudo(), palavras));
				}
				conteudoVO.setTitulo(artigoDisplay.getTitle());
				conteudoVO.setDataAlteracao(DateUtil
						.dateToStringWithHour(artigo.getModifiedDate()));
				conteudoVO.setAutor(artigo.getUserName());

				renderRequest.setAttribute(Constantes.CONTEUDO_VO, conteudoVO);
				renderRequest.setAttribute(Constantes.ARTIGO_DISPLAY,
						artigoDisplay);
				renderRequest.setAttribute(
						Constantes.NOME_PARAM_EXIBIR_TITULO,
						prefExibirTitulo);

				if (Validator.isNull(estrutura)) {
					estrutura = prefs.getValue(Constantes.PREF_ESTRUTURA,
							Constantes.VAZIO);

				}
				renderRequest.setAttribute(Constantes.NOME_PARAM_ESTRUTURA,
						estrutura);
				
				conteudoVO.setAprovado(artigo.isApproved()?Constantes.S : Constantes.N);
				conteudoVO.setExpirado(artigo.isExpired()?Constantes.S : Constantes.N);
				Date expirationDate = artigo.getExpirationDate();
				if ((expirationDate != null) && expirationDate.before(new Date())) {
					conteudoVO.setExpirado(Constantes.S);
				}
				
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
						JournalArticle.class.getName(), artigo.getResourcePrimKey());
				

				List<AssetLink> listaLinks = AssetLinkLocalServiceUtil
						.getLinks(assetEntry.getEntryId());
				for (AssetLink assetLink : listaLinks) {
					AssetEntry assetLinkEntry = null;

					if (assetLink.getEntryId1() == assetEntry.getEntryId()) {
						assetLinkEntry = AssetEntryServiceUtil
								.getEntry(assetLink.getEntryId2());
					} else {
						assetLinkEntry = AssetEntryServiceUtil
								.getEntry(assetLink.getEntryId1());
					}

					if (!assetLinkEntry.isVisible()) {
						System.out.println("NAO VISIVEL");
						continue;
					}

					assetLinkEntry = assetLinkEntry.toEscapedModel();
					
									
					AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil
							.getAssetRendererFactoryByClassName(PortalUtil
									.getClassName(assetLinkEntry
											.getClassNameId()));

					AssetRenderer assetRenderer = assetRendererFactory
							.getAssetRenderer(assetLinkEntry.getClassPK());
					
					String asseLinktEntryTitle = assetLinkEntry.getTitle(LanguageUtil.getLanguageId(renderRequest));
				}

				super.render(renderRequest, renderResponse);
			} else {
				SessionMessages.add(renderRequest,
						"mensagem.portletNaoConfigurado");
				include(naoConfiguradoJSP, renderRequest, renderResponse);

			}
		} catch (NoSuchArticleException e) {
			SessionMessages.add(renderRequest,
					"mensagem.conteudo.naoEncontrado");
			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(resourceRequest));

		// TODO Auto-generated method stub
		String userName = resourceRequest.getParameter("userName");
		String userMail = resourceRequest.getParameter("userEmail");
		String comentario = resourceRequest.getParameter("comentario");
		String articleUrl = httpReq.getParameter("articleUrl");
		String tituloNoticia = null;
		String url = null;

		try {
			url = PortalUtil.getLayoutFullURL((ThemeDisplay) resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY));
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (articleUrl != null && !articleUrl.isEmpty()) {
			url = url + "?" + Constantes.NOME_PARAM_ID + "=" + articleUrl;

			try {
				JournalArticle ja = JournalArticleLocalServiceUtil.getArticle(
						PortalUtil.getScopeGroupId(httpReq), articleUrl);

				if (ja != null) {
					tituloNoticia = ja.getTitleCurrentValue();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		for (int i = 1; i <= 5; i++) {
			String name = resourceRequest.getParameter("friendName" + i);
			String email = resourceRequest.getParameter("friendEmail" + i);
			if (email != null && !email.equals("")) {
				sendEmail(userName, userMail, comentario, name, email, url,
						tituloNoticia, PortalUtil.getLocale(httpReq));
			}
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private void sendEmail(String fromName, String fromMail, String comentario,
			String toName, String toEmail, String articleUrl,
			String tituloNoticia, Locale locale) {

		String assunto = LanguageUtil.get(locale,
				"email.indique.noticia.assunto");
		assunto = assunto.replace("{0}", fromName);
		assunto = assunto.replace("{3}", tituloNoticia);

		String corpo = LanguageUtil.get(locale, "email.indique.noticia.corpo");
		corpo = corpo.replace("{0}", toName);
		corpo = corpo.replace("{1}", fromName);
		corpo = corpo.replace("{2}", articleUrl);
		corpo = corpo.replace("{3}", tituloNoticia);
		comentario = comentario.replaceAll("\n", "<br>");
		corpo = corpo + comentario;

		Email.sendEmail(fromMail, toEmail, assunto, corpo);

	}

	public void editarComentario(ActionRequest request, ActionResponse response) {

		String cmd = ParamUtil.getString(request, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				MBMessage message = updateMessage(request);
			} else if (cmd.equals(Constants.DELETE)) {
				deleteMessage(request);
			}
		} catch (Exception e) {
			if (e instanceof NoSuchMessageException
					|| e instanceof PrincipalException
					|| e instanceof RequiredMessageException) {

				SessionErrors.add(request, e.getClass().getName());
			} else if (e instanceof FileNameException
					|| e instanceof FileSizeException
					|| e instanceof MessageBodyException
					|| e instanceof MessageSubjectException) {

				SessionErrors.add(request, e.getClass().getName());
			} else {
				e.getMessage();
			}
		}
	}

	protected void deleteMessage(ActionRequest actionRequest) throws Exception {
		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		String className = ParamUtil.getString(actionRequest, "className");
		long classPK = ParamUtil.getLong(actionRequest, "classPK");
		String permissionClassName = ParamUtil.getString(actionRequest,
				"permissionClassName");
		long permissionClassPK = ParamUtil.getLong(actionRequest,
				"permissionClassPK");
		long permissionOwnerId = ParamUtil.getLong(actionRequest,
				"permissionOwnerId");

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		MBMessageServiceUtil.deleteDiscussionMessage(groupId, className,
				classPK, permissionClassName, permissionClassPK,
				permissionOwnerId, messageId);
	}

	protected MBMessage updateMessage(ActionRequest actionRequest)
			throws Exception {

		String className = ParamUtil.getString(actionRequest, "className");
		long classPK = ParamUtil.getLong(actionRequest, "classPK");
		String permissionClassName = ParamUtil.getString(actionRequest,
				"permissionClassName");
		long permissionClassPK = ParamUtil.getLong(actionRequest,
				"permissionClassPK");
		long permissionOwnerId = ParamUtil.getLong(actionRequest,
				"permissionOwnerId");

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		long threadId = ParamUtil.getLong(actionRequest, "threadId");
		long parentMessageId = ParamUtil.getLong(actionRequest,
				"parentMessageId");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String body = ParamUtil.getString(actionRequest, "body");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				MBMessage.class.getName(), actionRequest);

		MBMessage message = null;

		if (messageId <= 0) {

			// Add message
			message = MBMessageServiceUtil.addDiscussionMessage(
					serviceContext.getScopeGroupId(), className, classPK,
					permissionClassName, permissionClassPK, permissionOwnerId,
					threadId, parentMessageId, subject, body, serviceContext);
		} else {

			// Update message

			message = MBMessageServiceUtil
					.updateDiscussionMessage(className, classPK,
							permissionClassName, permissionClassPK,
							permissionOwnerId, messageId, subject, body,
							serviceContext);
		}

		return message;
	}

}
