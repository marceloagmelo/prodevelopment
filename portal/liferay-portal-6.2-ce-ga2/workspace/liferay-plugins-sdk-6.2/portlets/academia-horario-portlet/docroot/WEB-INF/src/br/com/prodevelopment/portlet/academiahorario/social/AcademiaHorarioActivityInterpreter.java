package br.com.prodevelopment.portlet.academiahorario.social;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.portlet.academiahorario.Constantes;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;

public class AcademiaHorarioActivityInterpreter extends
		BaseSocialActivityInterpreter {

	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected String getEntryTitle(SocialActivity activity,
			ServiceContext serviceContext) throws Exception {
		String atividade = activity.getExtraDataValue("atividade", serviceContext.getLocale());
		String diaDaSemana = activity.getExtraDataValue("diaSemana");
		String horaInicial = activity.getExtraDataValue("horaInicial");
		String horaFinal = activity.getExtraDataValue("horaFinal");
		
		StringBuffer sbTitulo = new StringBuffer();
		sbTitulo.append(atividade);
		sbTitulo.append(StringPool.SPACE);
		sbTitulo.append(diaDaSemana);
		sbTitulo.append(StringPool.COLON);
		sbTitulo.append(StringPool.SPACE);
		sbTitulo.append(horaInicial);
		sbTitulo.append(StringPool.SPACE);
		sbTitulo.append(StringPool.MINUS);
		sbTitulo.append(StringPool.SPACE);
		sbTitulo.append(horaFinal);
		
		return sbTitulo.toString();
	}

	@Override
	protected String getPath(SocialActivity activity,
			ServiceContext serviceContext) throws Exception {

		long plid = PortalUtil.getPlidFromPortletId(activity.getGroupId(),
				Constantes.PORTLET_NAME);

		PortletURL portletURL = PortletURLFactoryUtil.create(
				serviceContext.getRequest(), Constantes.PORTLET_NAME, plid,
				PortletRequest.RENDER_PHASE);

		portletURL.setParameter("jspPage", "/html/academiahorario/cadastro.jsp");
		portletURL.setParameter("keywords",
				getEntryTitle(activity, serviceContext));
		portletURL.setParameter(Constantes.CAMPO_ACADEMIA_HORARIO_ID,
				String.valueOf(activity.getClassPK()));
		portletURL.setParameter(Constantes.ACAO, Constantes.VIEW);
		portletURL.setParameter("backURL", serviceContext.getCurrentURL());
		return portletURL.toString();
	}

	@Override
	protected String getTitlePattern(String groupName, SocialActivity activity) {

		int activityType = activity.getType();

		if (activityType == AcademiaHorarioActivityKeys.ADD_ACADEMIA_HORARIO) {
			if (Validator.isNull(groupName)) {
				return "activity.academiaHorario.add";
			} else {
				return "activity.academiaHorario.add.em";
			}
		} else if (activityType == AcademiaHorarioActivityKeys.UPDATE_ACADEMIA_HORARIO) {
			if (Validator.isNull(groupName)) {
				return "activity.academiaHorario.update";
			} else {
				return "activity.academiaHorario.update.em";
			}
		} else if (activityType == AcademiaHorarioActivityKeys.DELETE_ACADEMIA_HORARIO) {
			if (Validator.isNull(groupName)) {
				return "activity.academiaHorario.delete";
			} else {
				return "activity.academiaHorario.delete.em";
			}
		}

		return null;
	}

	@Override
	protected boolean hasPermissions(PermissionChecker permissionChecker,
			SocialActivity activity, String actionId,
			ServiceContext serviceContext) throws Exception {

		boolean permissaoView = permissionChecker.hasPermission(
				activity.getGroupId(), AcademiaHorario.class.getName(),
				activity.getClassPK(), actionId);

		if (!permissaoView) {

			return false;
		}

		return true;
	}

	@Override
	protected String getUserName(long userId, ServiceContext serviceContext) {
		try {
			if (userId <= 0) {
				return StringPool.BLANK;
			}

			User user = UserLocalServiceUtil.getUserById(userId);

			if (user.getUserId() == serviceContext.getUserId()) {
				return HtmlUtil.escape(user.getFirstName());
			}

			String userName = user.getFullName();

			Group group = user.getGroup();

			if (group.getGroupId() == serviceContext.getScopeGroupId()) {
				return HtmlUtil.escape(userName);
			}

			String userDisplayURL = user.getDisplayURL(serviceContext
					.getThemeDisplay());

			if (Validator.isNotNull(userDisplayURL)) {
				userName = "<a class=\"user\" href=\"" + userDisplayURL + "\">"
						+ HtmlUtil.escape(userName) + "</a>";
			} else {
				userName = HtmlUtil.escape(userName);
			}

			return userName;
		} catch (Exception e) {
			return StringPool.BLANK;
		}
	}

	private static final String[] _CLASS_NAMES = { AcademiaHorario.class.getName() };

}
