package br.com.prodevelopment.etask.util;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.portlet.typetask.TypeTaskConstants;
import br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ActionUtil {

	public static void setTypeTask(HttpServletRequest request) throws Exception {

		long typeTaskId = ParamUtil.getLong(request,
				TypeTaskConstants.TYPE_TASK_ID);

		TypeTask typeTask = null;

		if (typeTaskId > 0) {
			typeTask = TypeTaskLocalServiceUtil.fetchTypeTask(typeTaskId);
		}

		request.setAttribute(TypeTaskConstants.TYPE_TASK, typeTask);
	}

	public static void getTypeTask(RenderRequest renderRequest)
			throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(renderRequest);

		setTypeTask(request);
	}


	public static TypeTask getTypeTask(ActionRequest actionRequest)
			throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getTypeTask(request);
	}

	public static TypeTask getTypeTask(HttpServletRequest request) throws Exception {

		long typeTaskId = ParamUtil.getLong(request,
				TypeTaskConstants.TYPE_TASK_ID);

		TypeTask typeTask = null;

		if (typeTaskId > 0) {
			typeTask = TypeTaskLocalServiceUtil.fetchTypeTask(typeTaskId);
		}

		return typeTask;
	}
}
