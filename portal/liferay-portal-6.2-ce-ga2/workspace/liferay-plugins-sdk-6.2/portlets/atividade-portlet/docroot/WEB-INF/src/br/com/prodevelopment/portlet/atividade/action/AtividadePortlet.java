package br.com.prodevelopment.portlet.atividade.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil;
import br.com.prodevelopment.atividade.AtividadeAlteradoOutroUsuarioException;
import br.com.prodevelopment.atividade.AtividadeNomeObrigatorioException;
import br.com.prodevelopment.atividade.model.Atividade;
import br.com.prodevelopment.atividade.service.AtividadeLocalServiceUtil;
import br.com.prodevelopment.portlet.atividade.Constantes;
import br.com.prodevelopment.portlet.atividade.util.AtividadeUtil;
import br.com.prodevelopment.portlet.atividade.util.Helper;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AtividadePortlet
 */
public class AtividadePortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {
		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);

		addProcessActionSuccessMessage = GetterUtil.getBoolean(
				getInitParameter("add-process-action-success-action"), false);
		super.init();
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String portletTitulo = Helper.getTituloPortlet(renderRequest,
					renderResponse, themeDisplay);

			renderRequest
					.setAttribute(Constantes.PORTLET_TITULO, portletTitulo);

			AtividadeUtil.getAtividade(renderRequest);

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		InputStream imagem = null;
		long atividadeId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_ATIVIDADE_ID);
		double versao = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VERSAO);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);
		boolean existeImagem = ParamUtil.getBoolean(actionRequest,
				Constantes.CAMPO_EXISTE_IMAGEM);

		// Recuperar campos do request
		Map<Locale, String> nomeMap = LocalizationUtil.getLocalizationMap(
				actionRequest, Constantes.CAMPO_NOME);
		Map<Locale, String> descricaoMap = LocalizationUtil.getLocalizationMap(
				actionRequest, Constantes.CAMPO_DESCRICAO);

		try {
			imagem = recuperarImagem(actionRequest);
			if (!existeImagem) {
				existeImagem = (imagem != null);
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Atividade.class.getName(), actionRequest);

			if (Constantes.ADD.equals(acao)) {
				AtividadeLocalServiceUtil.addAtividade(
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), nomeMap, descricaoMap,
						existeImagem, imagem, Constantes.VERSAO_INICIAL,
						serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.cargo.adicionado.sucesso");
			} else {
				Atividade atividade = AtividadeLocalServiceUtil.update(
						atividadeId, themeDisplay.getUserId(), nomeMap,
						descricaoMap, existeImagem, imagem, versao,
						serviceContext);

				// Atualizar os nomes da atividade nos horários
				List<AcademiaHorario> lstAcademiaHorario = AcademiaHorarioLocalServiceUtil
						.searchByAcademia(themeDisplay.getCompanyId(),
								atividade.getAtividadeId(), QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, null);
				for (AcademiaHorario academiaHorario : lstAcademiaHorario) {
					academiaHorario.setAtividadeNomeMap(atividade.getNomeMap());
					AcademiaHorarioLocalServiceUtil.updateAcademiaHorario(academiaHorario);
				}
				SessionMessages.add(actionRequest,
						"mensagem.cargo.alterado.sucesso");
			}
			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			if (e instanceof AtividadeNomeObrigatorioException
					|| e instanceof AtividadeAlteradoOutroUsuarioException) {

				SessionErrors.add(actionRequest, e.getClass());

				// copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter("jspPage",
						"/html/atividade/cadastro.jsp");
			}
		} finally {
			StreamUtil.cleanUp(imagem);
		}
	}

	public void deletar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		Atividade atividade = AtividadeUtil.getAtividade(actionRequest);
		if (Validator.isNotNull(atividade)) {
			AtividadeLocalServiceUtil.deleteAtividade(atividade,
					themeDisplay.getUserId());
		}
	}

	public void deletarSelecionados(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String[] deleteTagIds = StringUtil.split(ParamUtil.getString(
				actionRequest, Constantes.DELETE_TAG_IDS));
		for (String deleteId : deleteTagIds) {
			Atividade atividade = AtividadeUtil.getAtividade(Long
					.valueOf(deleteId));
			if (Validator.isNotNull(atividade)) {
				AtividadeLocalServiceUtil.deleteAtividade(atividade,
						themeDisplay.getUserId());
			}
		}
	}

	protected InputStream recuperarImagem(ActionRequest actionRequest)
			throws Exception {

		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);

		InputStream inputStream = null;

		File file = uploadPortletRequest.getFile(Constantes.CAMPO_IMAGEM);

		if ((file != null) && file.exists()) {
			inputStream = new ByteArrayFileInputStream(file, 1024);
		}
		return inputStream;
	}
}
