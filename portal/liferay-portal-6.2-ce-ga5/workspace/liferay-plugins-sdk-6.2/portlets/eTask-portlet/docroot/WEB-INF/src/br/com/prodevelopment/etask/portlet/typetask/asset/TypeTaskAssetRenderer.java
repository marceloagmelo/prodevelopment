package br.com.prodevelopment.etask.portlet.typetask.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.portlet.typetask.TypeTaskConstants;
import br.com.prodevelopment.etask.portlet.typetask.permission.TypeTaskPermission;
import br.com.prodevelopment.etask.portlet.typetask.util.ActionKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class TypeTaskAssetRenderer
	extends BaseAssetRenderer implements TrashRenderer {

	public TypeTaskAssetRenderer(TypeTask typeTask) {
		_typeTask = typeTask;
	}

	@Override
	public String getClassName() {
		return TypeTask.class.getName();
	}

	@Override
	public long getClassPK() {
		return _typeTask.getTypeTaskId();
	}

	@Override
	public long getGroupId() {
		return _typeTask.getGroupId();
	}

	@Override
	public String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

	@Override
	public String getPortletId() {
		AssetRendererFactory assetRendererFactory = getAssetRendererFactory();

		return assetRendererFactory.getPortletId();
	}

	@Override
	public String getSummary(Locale locale) {

		String summary = _typeTask.getDescription(locale);

		return StringUtil.shorten(HtmlUtil.stripHtml(summary), 200);
	}

	@Override
	public String getTitle(Locale locale) {
		return _typeTask.getName(locale);
	}

	@Override
	public String getType() {
		return TypeTaskAssetRendererFactory.TYPE;
	}

	@Override
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			getControlPanelPlid(liferayPortletRequest), PortletKeys.CALENDAR,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/edit_calendar_booking.jsp");
		portletURL.setParameter(
			"typeTaskId",
			String.valueOf(_typeTask.getTypeTaskId()));

		return portletURL;
	}

	@Override
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect) {

		try {
			PortletURL portletURL = liferayPortletResponse.createRenderURL(
				PortletKeys.CALENDAR);

			portletURL.setParameter("mvcPath", "/view_calendar_booking.jsp");
			portletURL.setParameter(
				"typeTaskId",
				String.valueOf(_typeTask.getTypeTaskId()));
			portletURL.setWindowState(WindowState.MAXIMIZED);

			return portletURL.toString();
		}
		catch (Exception e) {
		}

		return null;
	}

	@Override
	public long getUserId() {
		return _typeTask.getUserIdModified();
	}

	@Override
	public String getUserName() {
		return "marcelo";
	}

	@Override
	public String getUuid() {
		return _typeTask.getUuid();
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		TypeTask typeTask = null;

		try {
			typeTask = _typeTask;
		}
		catch (Exception e) {
			_log.error(e);
		}

		return TypeTaskPermission.contains(
			permissionChecker, typeTask.getTypeTaskId(), ActionKeys.VIEW);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		TypeTask typeTask = null;

		try {
			typeTask = _typeTask;
		}
		catch (Exception e) {
			_log.error(e);
		}

		return TypeTaskPermission.contains(
			permissionChecker, typeTask.getTypeTaskId(), ActionKeys.VIEW);
	}

	@Override
	public boolean isPrintable() {
		return true;
	}

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse,
			String template)
		throws Exception {

		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			renderRequest.setAttribute(
				TypeTaskConstants.TYPE_TASK, _typeTask);

			return "/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TypeTaskAssetRenderer.class);

	private TypeTask _typeTask;

}

