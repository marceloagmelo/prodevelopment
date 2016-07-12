package br.com.prodevelopment.etask.portlet.typetask.asset;

import javax.portlet.PortletURL;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.portlet.typetask.permission.TypeTaskPermission;
import br.com.prodevelopment.etask.portlet.typetask.util.ActionKeys;
import br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class TypeTaskAssetRendererFactory
	extends BaseAssetRendererFactory {

	public static final String TYPE = "typeTask";

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		TypeTask typeTask =
			TypeTaskLocalServiceUtil.getTypeTask(classPK);

		TypeTaskAssetRenderer typeTaskAssetRenderer =
			new TypeTaskAssetRenderer(typeTask);

		typeTaskAssetRenderer.setAssetRendererType(type);

		return typeTaskAssetRenderer;
	}

	@Override
	public String getClassName() {
		return TypeTask.class.getName();
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public PortletURL getURLAdd(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws PortalException {

		PortletURL portletURL = liferayPortletResponse.createRenderURL(
				PortletKeys.JOURNAL);

			portletURL.setParameter("struts_action", "/journal/edit_article");

			return portletURL;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		TypeTask typeTask =
			TypeTaskLocalServiceUtil.getTypeTask(classPK);

		if (actionId.equals(ActionKeys.DELETE) ||
			actionId.equals(ActionKeys.UPDATE)) {

			actionId = ActionKeys.VIEW;
		}

		return TypeTaskPermission.contains(
			permissionChecker, typeTask.getTypeTaskId(), actionId);
	}

	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

	private static final boolean _LINKABLE = true;
}
