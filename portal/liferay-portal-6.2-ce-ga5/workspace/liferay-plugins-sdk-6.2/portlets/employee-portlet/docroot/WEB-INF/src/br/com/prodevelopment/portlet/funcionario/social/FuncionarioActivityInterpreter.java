package br.com.prodevelopment.portlet.funcionario.social;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.portlet.funcionario.Constantes;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;

public class FuncionarioActivityInterpreter extends
		BaseSocialActivityInterpreter {

	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected String getEntryTitle(SocialActivity activity,
			ServiceContext serviceContext) throws Exception {

		return activity.getExtraDataValue("nome", serviceContext.getLocale());
	}

	@Override
	protected String getPath(SocialActivity activity,
			ServiceContext serviceContext) throws Exception {

		long plid = PortalUtil.getPlidFromPortletId(activity.getGroupId(),
				Constantes.PORTLET_NAME);

		PortletURL portletURL = PortletURLFactoryUtil.create(
				serviceContext.getRequest(), Constantes.PORTLET_NAME, plid,
				PortletRequest.RENDER_PHASE);

		int activityType = activity.getType();
		if ((activityType == FuncionarioActivityKeys.ADD_CARGO)
				|| (activityType == FuncionarioActivityKeys.UPDATE_CARGO)
				|| (activityType == FuncionarioActivityKeys.DELETE_CARGO)) {
			portletURL.setParameter("jspPage", "/html/cargo/cadastro.jsp");
			portletURL.setParameter("keywords",
					getEntryTitle(activity, serviceContext));
			portletURL.setParameter(Constantes.ACAO, Constantes.VIEW);
			portletURL.setParameter(Constantes.CARGO_ID, String.valueOf(activity.getClassPK()));
			portletURL.setParameter("backURL", serviceContext.getCurrentURL());
			return portletURL.toString();
		} else {
			portletURL.setParameter("jspPage", "/html/funcionario/cadastro.jsp");
			portletURL.setParameter("keywords",
					getEntryTitle(activity, serviceContext));
			portletURL.setParameter(Constantes.FUNCIONARIO_ID, String.valueOf(activity.getClassPK()));
			portletURL.setParameter(Constantes.ACAO, Constantes.VIEW);
			portletURL.setParameter("backURL", serviceContext.getCurrentURL());
			return portletURL.toString();
		}
	}

	@Override
	protected String getTitlePattern(String groupName, SocialActivity activity) {

		int activityType = activity.getType();

		if (activityType == FuncionarioActivityKeys.ADD_FUNCIONARIO) {
			if (Validator.isNull(groupName)) {
				return "activity.funcionario.add";
			} else {
				return "activity.funcionario.add.em";
			}
		} else if (activityType == FuncionarioActivityKeys.UPDATE_FUNCIONARIO) {
			if (Validator.isNull(groupName)) {
				return "activity.funcionario.update";
			} else {
				return "activity.funcionario.update.em";
			}
		} else if (activityType == FuncionarioActivityKeys.DELETE_FUNCIONARIO) {
			if (Validator.isNull(groupName)) {
				return "activity.funcionario.delete";
			} else {
				return "activity.funcionario.delete.em";
			}
		} else if (activityType == FuncionarioActivityKeys.ADD_CARGO) {
			if (Validator.isNull(groupName)) {
				return "activity.cargo.add";
			} else {
				return "activity.cargo.add.em";
			}
		} else if (activityType == FuncionarioActivityKeys.UPDATE_CARGO) {
			if (Validator.isNull(groupName)) {
				return "activity.cargo.update";
			} else {
				return "activity.cargo.update.em";
			}
		} else if (activityType == FuncionarioActivityKeys.DELETE_CARGO) {
			if (Validator.isNull(groupName)) {
				return "activity.cargo.delete";
			} else {
				return "activity.cargo.delete.em";
			}
		} else if (activityType == FuncionarioActivityKeys.UPDATE_FOTO) {
			if (Validator.isNull(groupName)) {
				return "activity.foto.update";
			} else {
				return "activity.foto.update.em";
			}
		} else if (activityType == FuncionarioActivityKeys.DELETE_FOTO) {
			if (Validator.isNull(groupName)) {
				return "activity.foto.delete";
			} else {
				return "activity.foto.delete.em";
			}
		} else if (activityType == FuncionarioActivityKeys.ATIVOU) {
			if (Validator.isNull(groupName)) {
				return "activity.funcionario.ativou";
			} else {
				return "activity.funcionario.ativou.em";
			}
		} else if (activityType == FuncionarioActivityKeys.DESATIVOU) {
			if (Validator.isNull(groupName)) {
				return "activity.funcionario.desativou";
			} else {
				return "activity.funcionario.desativou.em";
			}
		}

		return null;
	}

	@Override
	protected boolean hasPermissions(PermissionChecker permissionChecker,
			SocialActivity activity, String actionId,
			ServiceContext serviceContext) throws Exception {

		boolean permissaoView = permissionChecker.hasPermission(
				activity.getGroupId(), Funcionario.class.getName(),
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

	private static final String[] _CLASS_NAMES = { Funcionario.class.getName() };

}
