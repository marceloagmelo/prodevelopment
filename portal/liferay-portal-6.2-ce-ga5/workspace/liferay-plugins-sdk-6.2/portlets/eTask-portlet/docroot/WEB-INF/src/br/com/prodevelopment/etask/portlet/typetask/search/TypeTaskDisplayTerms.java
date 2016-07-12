package br.com.prodevelopment.etask.portlet.typetask.search;

import javax.portlet.PortletRequest;

import br.com.prodevelopment.etask.portlet.typetask.TypeTaskConstants;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;

public class TypeTaskDisplayTerms extends DisplayTerms {
	
	public TypeTaskDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		name = ParamUtil.getString(portletRequest, TypeTaskConstants.NAME);
		status = ParamUtil.getString(portletRequest, TypeTaskConstants.STATUS);
		structureId = ParamUtil.getLong(portletRequest, TypeTaskConstants.DDM_STRUCTURE_ID);
		typeTaskId = ParamUtil.getLong(portletRequest, TypeTaskConstants.TYPE_TASK_ID);
		description = ParamUtil.getString(portletRequest, TypeTaskConstants.DESCRIPTION);

		groupId = setGroupId(portletRequest);
		companyId = setCompanyId(portletRequest);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getStructureId() {
		return structureId;
	}

	public void setStructureId(long structureId) {
		this.structureId = structureId;
	}

	public long getTypeTaskId() {
		return typeTaskId;
	}

	public void setTypeTaskId(long typeTaskId) {
		this.typeTaskId = typeTaskId;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getGroupId() {
		return groupId;
	}

	public long setGroupId(PortletRequest portletRequest) {
		groupId = ParamUtil.getLong(portletRequest, TypeTaskConstants.GROUP_ID);

		if (groupId != 0) {
			return groupId;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		return themeDisplay.getScopeGroupId();
	}

	public long getCompanyId() {
		return companyId;
	}

	public long setCompanyId(PortletRequest portletRequest) {
		companyId = ParamUtil.getLong(portletRequest, TypeTaskConstants.COMPANY_ID);

		if (companyId != 0) {
			return companyId;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		return themeDisplay.getCompanyId();
	}

	public int getStatusCode() {
		if (status.equals("approved")) {
			return WorkflowConstants.STATUS_APPROVED;
		}
		else if (status.equals("draft")) {
			return WorkflowConstants.STATUS_DRAFT;
		}
		else if (status.equals("expired")) {
			return WorkflowConstants.STATUS_EXPIRED;
		}
		else if (status.equals("pending")) {
			return WorkflowConstants.STATUS_PENDING;
		}
		else {
			return WorkflowConstants.STATUS_ANY;
		}
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	protected String name;
	protected String description;
	protected String status;
	protected long structureId;
	protected long typeTaskId;
	protected long groupId;
	protected long companyId;
}
