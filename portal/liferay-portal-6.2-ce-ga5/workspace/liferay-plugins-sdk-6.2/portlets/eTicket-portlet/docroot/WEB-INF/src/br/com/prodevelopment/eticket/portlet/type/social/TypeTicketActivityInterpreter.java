package br.com.prodevelopment.eticket.portlet.type.social;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.portlet.type.TypeTicketConstants;

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
import com.liferay.portlet.social.model.SocialActivityConstants;

public class TypeTicketActivityInterpreter extends BaseSocialActivityInterpreter {

	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected String getEntryTitle(SocialActivity activity,
			ServiceContext serviceContext) throws Exception {

		return activity.getExtraDataValue("description", serviceContext.getLocale());
	}

	@Override
	protected String getPath(SocialActivity activity,
			ServiceContext serviceContext) throws Exception {

		long plid = PortalUtil.getPlidFromPortletId(activity.getGroupId(),
				TypeTicketConstants.PORTLET_NAME);

		PortletURL portletURL = PortletURLFactoryUtil.create(
				serviceContext.getRequest(), TypeTicketConstants.PORTLET_NAME, plid,
				PortletRequest.RENDER_PHASE);

		portletURL.setParameter("jspPage", "/html/cliente/cadastro.jsp");
		portletURL.setParameter("keywords",
				getEntryTitle(activity, serviceContext));
		portletURL.setParameter(TypeTicketConstants.CAMPO_TYPE_TICKET_ID, String.valueOf(activity.getClassPK()));
		portletURL.setParameter(TypeTicketConstants.ACAO, TypeTicketConstants.VIEW);
		portletURL.setParameter("backURL", serviceContext.getCurrentURL());

		return portletURL.toString();
	}

	@Override
	protected String getTitlePattern(String groupName, SocialActivity activity) {

		int activityType = activity.getType();

		if (activityType == TypeTicketActivityKeys.ADD_TYPE) {
			if (Validator.isNull(groupName)) {
				return "activity-typeticket-add";
			} else {
				return "activity-typeticket-add-in";
			}
		} else if (activityType == TypeTicketActivityKeys.UPDATE_TYPE) {
			if (Validator.isNull(groupName)) {
				return "activity-typeticket-update";
			} else {
				return "activity-typeticket-update-in";
			}
		} else if (activityType == SocialActivityConstants.TYPE_MOVE_TO_TRASH) {
			if (Validator.isNull(groupName)) {
				return "activity-typeticket-move-to-trash";
			} else {
				return "activity-typeticket-move-to-trash-in";
			}
		} else if (activityType == SocialActivityConstants.TYPE_RESTORE_FROM_TRASH) {
			if (Validator.isNull(groupName)) {
				return "activity-typeticket-restore-to-trash";
			} else {
				return "activity-typeticket-restore-to-trash-in";
			}
		} else if (activityType == TypeTicketActivityKeys.ADD_TYPE_USER) {
			if (Validator.isNull(groupName)) {
				return "activity-typeticketusers-update";
			} else {
				return "activity-typeticketusers-update-in";
			}
		} else if (activityType == TypeTicketActivityKeys.DELETE_TYPE_USER) {
			if (Validator.isNull(groupName)) {
				return "activity-typeticketusers-delete";
			} else {
				return "activity-typeticketuser-delete-in";
			}
		}

		return null;
	}

	@Override
	protected boolean hasPermissions(PermissionChecker permissionChecker,
			SocialActivity activity, String actionId,
			ServiceContext serviceContext) throws Exception {

		boolean permissaoView = permissionChecker.hasPermission(
				activity.getGroupId(), TypeTicket.class.getName(),
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

	private static final String[] _CLASS_NAMES = { TypeTicket.class.getName() };
}
