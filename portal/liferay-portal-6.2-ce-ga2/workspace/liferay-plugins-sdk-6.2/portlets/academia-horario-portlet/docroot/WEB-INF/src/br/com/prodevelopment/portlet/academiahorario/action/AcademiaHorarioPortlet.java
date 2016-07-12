package br.com.prodevelopment.portlet.academiahorario.action;

import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.academiahorario.AcademiaHorarioAlteradoOutroUsuarioException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioAtividadeObrigatoriaException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioDiaSemanaObrigatorioException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioHoraFinalObrigatoriaException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialIgualFinalException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialMaiorQueFinalException;
import br.com.prodevelopment.academiahorario.AcademiaHorarioHoraInicialObrigatoriaException;
import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil;
import br.com.prodevelopment.portlet.academiahorario.Constantes;
import br.com.prodevelopment.portlet.academiahorario.util.AcademiaHorarioUtil;
import br.com.prodevelopment.portlet.academiahorario.util.Helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AcademiaHorarioPortlet
 */
public class AcademiaHorarioPortlet extends MVCPortlet {
 
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

			// Recuperar preferencias
			PortletPreferences prefs = renderRequest.getPreferences();
			String prefConfigurado = prefs.getValue(
					Constantes.PREF_CONFIGURADO, Constantes.N);

			if (Constantes.S.equals(prefConfigurado)) {
				String portletTitulo = Helper.getTituloPortlet(renderRequest,
						renderResponse, themeDisplay);

				renderRequest
						.setAttribute(Constantes.PORTLET_TITULO, portletTitulo);

				AcademiaHorarioUtil.getAcademiaHorario(renderRequest);
				
				super.render(renderRequest, renderResponse);
			} else {
				include(naoConfiguradoJSP, renderRequest, renderResponse);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}


	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Recuperar preferencias
		PortletPreferences preferences = actionRequest.getPreferences();
		boolean prefSomenteEsseSite = GetterUtil.getBoolean(preferences
				.getValue(Constantes.PREF_SOMENTE_ESSE_SITE, null));

		InputStream imagem = null;
		long academiaHorarioId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_ACADEMIA_HORARIO_ID);
		long groupId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_GROUP_ID);
		if (prefSomenteEsseSite)  {
			groupId = themeDisplay.getScopeGroupId();
		}
		long atividadeId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_ATIVIDADE_ID);
		int diaSemana = ParamUtil.getInteger(actionRequest,
				Constantes.CAMPO_DIA_SEMANA);
		String horaInicial = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_HORA_INICIAL);
		String horaFinal = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_HORA_FINAL);
		double versao = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VERSAO);

		String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					AcademiaHorario.class.getName(), actionRequest);

			if (Constantes.ADD.equals(acao)) {
				AcademiaHorarioLocalServiceUtil.addAcademiaHorario(
						themeDisplay.getCompanyId(),
						groupId,
						themeDisplay.getUserId(), diaSemana, horaInicial,
						horaFinal, atividadeId, Constantes.VERSAO_INICIAL, serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.academiaHorario.adicionado.sucesso");
			} else {
				AcademiaHorarioLocalServiceUtil.update(academiaHorarioId,
						themeDisplay.getUserId(), diaSemana, horaInicial,
						horaFinal, atividadeId, versao, serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.academiaHorario.alterado.sucesso");
			}
			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			if (e instanceof AcademiaHorarioDiaSemanaObrigatorioException
					|| e instanceof AcademiaHorarioAtividadeObrigatoriaException
					|| e instanceof AcademiaHorarioHoraInicialObrigatoriaException
					|| e instanceof AcademiaHorarioHoraFinalObrigatoriaException
					|| e instanceof AcademiaHorarioHoraInicialMaiorQueFinalException
					|| e instanceof AcademiaHorarioHoraInicialIgualFinalException
					|| e instanceof AcademiaHorarioAlteradoOutroUsuarioException) {

				SessionErrors.add(actionRequest, e.getClass());

				// copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter("jspPage",
						"/html/academiahorario/cadastro.jsp");
			}
		}
		finally {
			StreamUtil.cleanUp(imagem);
		}
	}

	public void deletar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		AcademiaHorario academiaHorario = AcademiaHorarioUtil.getAcademiaHorario(actionRequest);
		if (Validator.isNotNull(academiaHorario)) {
			AcademiaHorarioLocalServiceUtil.deleteAcademiaHorario(academiaHorario,
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
			AcademiaHorario academiaHorario = AcademiaHorarioUtil.getAcademiaHorario(Long
					.valueOf(deleteId));
			if (Validator.isNotNull(academiaHorario)) {
				AcademiaHorarioLocalServiceUtil.deleteAcademiaHorario(academiaHorario,
						themeDisplay.getUserId());
			}
		}
	}
	
}
