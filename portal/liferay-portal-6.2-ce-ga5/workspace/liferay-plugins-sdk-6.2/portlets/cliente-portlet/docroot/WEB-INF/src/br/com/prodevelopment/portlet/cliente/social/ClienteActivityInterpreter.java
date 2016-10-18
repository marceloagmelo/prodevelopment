package br.com.prodevelopment.portlet.cliente.social;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.cliente.model.Cliente;
import br.com.prodevelopment.portlet.cliente.Constantes;

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

public class ClienteActivityInterpreter extends
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
		portletURL.setParameter("jspPage", "/html/cliente/cadastro.jsp");
		portletURL.setParameter("keywords",
				getEntryTitle(activity, serviceContext));
		portletURL.setParameter(Constantes.CLIENTE_ID, String.valueOf(activity.getClassPK()));
		portletURL.setParameter(Constantes.ACAO, Constantes.VIEW);
		portletURL.setParameter("backURL", serviceContext.getCurrentURL());

		return portletURL.toString();
	}

	@Override
	protected String getTitlePattern(String groupName, SocialActivity activity) {

		int activityType = activity.getType();

		if (activityType == ClienteActivityKeys.ADD_CLIENTE) {
			if (Validator.isNull(groupName)) {
				return "activity.cliente.add";
			} else {
				return "activity.cliente.add.em";
			}
		} else if (activityType == ClienteActivityKeys.UPDATE_CLIENTE) {
			if (Validator.isNull(groupName)) {
				return "activity.cliente.update";
			} else {
				return "activity.cliente.update.em";
			}
		} else if (activityType == ClienteActivityKeys.DELETE_CLIENTE) {
			if (Validator.isNull(groupName)) {
				return "activity.cliente.delete";
			} else {
				return "activity.cliente.delete.em";
			}
		} else if (activityType == ClienteActivityKeys.UPDATE_FOTO) {
			if (Validator.isNull(groupName)) {
				return "activity.foto.update";
			} else {
				return "activity.foto.update.em";
			}
		} else if (activityType == ClienteActivityKeys.DELETE_FOTO) {
			if (Validator.isNull(groupName)) {
				return "activity.foto.delete";
			} else {
				return "activity.foto.delete.em";
			}
		}

		return null;
	}

	@Override
	protected boolean hasPermissions(PermissionChecker permissionChecker,
			SocialActivity activity, String actionId,
			ServiceContext serviceContext) throws Exception {

		boolean permissaoView = permissionChecker.hasPermission(
				activity.getGroupId(), Cliente.class.getName(),
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

	private static final String[] _CLASS_NAMES = { Cliente.class.getName() };

}
