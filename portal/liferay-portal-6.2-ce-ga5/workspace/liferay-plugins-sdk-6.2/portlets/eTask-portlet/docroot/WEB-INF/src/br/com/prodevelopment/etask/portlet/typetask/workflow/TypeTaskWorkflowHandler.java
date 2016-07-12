package br.com.prodevelopment.etask.portlet.typetask.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;

public class TypeTaskWorkflowHandler extends BaseWorkflowHandler {

	@Override
	public String getClassName() {
		return TypeTask.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public TypeTask updateStatus(int status,
			Map<String, Serializable> workflowContext) throws PortalException,
			SystemException {

		long userId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		TypeTask typeTask = TypeTaskLocalServiceUtil.getTypeTask(classPK);

		ServiceContext serviceContext = (ServiceContext) workflowContext
				.get("serviceContext");

		return TypeTaskLocalServiceUtil.updateStatus(userId,
				typeTask.getTypeTaskId(), status, serviceContext);
	}

	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

}
