package br.com.prodevelopment.etask.portlet.typetask.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import br.com.prodevelopment.etask.DuplicateTypeTaskUserException;
import br.com.prodevelopment.etask.RequiredTypeTaskNameException;
import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.portlet.typetask.TypeTaskConstants;
import br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil;
import br.com.prodevelopment.etask.service.TypeTaskUsersLocalServiceUtil;
import br.com.prodevelopment.etask.util.ActionUtil;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.NoSuchStructureException;
import com.liferay.portlet.dynamicdatamapping.RequiredStructureException;
import com.liferay.portlet.dynamicdatamapping.StructureDuplicateElementException;
import com.liferay.portlet.dynamicdatamapping.StructureDuplicateStructureKeyException;
import com.liferay.portlet.dynamicdatamapping.StructureNameException;
import com.liferay.portlet.dynamicdatamapping.StructureXsdException;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TypeTaskPortlet
 */
public class TypeTaskPortlet extends MVCPortlet {
	// private static Log _log = LogFactoryUtil.getLog(TypeTaskPortlet.class);
	private static Logger _log = Logger.getLogger(TypeTaskPortlet.class);

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			if (_log.isDebugEnabled()) {
				_log.debug("LOG com debug");
			}
			String moveTrashAction = ParamUtil.getString(renderRequest,
					TypeTaskConstants.MOVE_TRASH_ACTION);
			String restoreAction = ParamUtil.getString(renderRequest,
					TypeTaskConstants.RESTORE_ACTION);
			String deleteAction = ParamUtil.getString(renderRequest,
					TypeTaskConstants.DELETE_ACTION);
			String name = ParamUtil.getString(renderRequest,
					TypeTaskConstants.NAME);
			String restoreTypeTaskIds = ParamUtil.getString(renderRequest,
					TypeTaskConstants.RESTORE_TYPE_TASK_IDS);
			String deleteTypeTaskNames = ParamUtil.getString(renderRequest,
					TypeTaskConstants.DELETE_TYPE_TASK_NAMES);
			String restoreTypeTaskNames = ParamUtil.getString(renderRequest,
					TypeTaskConstants.RESTORE_TYPE_TASK_NAMES);

			renderRequest.setAttribute(TypeTaskConstants.MOVE_TRASH_ACTION,
					moveTrashAction);
			renderRequest.setAttribute(TypeTaskConstants.RESTORE_ACTION,
					restoreAction);
			renderRequest.setAttribute(TypeTaskConstants.DELETE_ACTION,
					deleteAction);
			renderRequest.setAttribute(TypeTaskConstants.NAME, name);
			renderRequest.setAttribute(TypeTaskConstants.RESTORE_TYPE_TASK_IDS,
					restoreTypeTaskIds);
			renderRequest.setAttribute(
					TypeTaskConstants.DELETE_TYPE_TASK_NAMES,
					deleteTypeTaskNames);
			renderRequest.setAttribute(
					TypeTaskConstants.RESTORE_TYPE_TASK_NAMES,
					restoreTypeTaskNames);

			String typeTaskId = ParamUtil.getString(renderRequest,
					TypeTaskConstants.TYPE_TASK_ID);
			renderRequest.setAttribute(TypeTaskConstants.TYPE_TASK_ID, typeTaskId);
			
			if (Validator.isNotNull(typeTaskId)) {
				ActionUtil.getTypeTask(renderRequest);
			}

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e, e);
		}
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String tabs1 = ParamUtil
				.getString(actionRequest, TypeTaskConstants.TABS1);
		String tabs2 = ParamUtil
				.getString(actionRequest, TypeTaskConstants.TABS2);
		String tabs3 = ParamUtil
				.getString(actionRequest, TypeTaskConstants.TABS3);

		String availableFields = ParamUtil.getString(actionRequest,
				"availableFields");
		String xsd = ParamUtil.getString(actionRequest, TypeTaskConstants.XSD);
		String typeTaskId = ParamUtil.getString(actionRequest,
				TypeTaskConstants.TYPE_TASK_ID);
		String keywords = ParamUtil.getString(actionRequest,
				TypeTaskConstants.KEYWORDS);

		
		boolean customFieldsActive = ParamUtil.getBoolean(actionRequest,
				TypeTaskConstants.CUSTOM_FIELDS_ACTIVE);
		if (!customFieldsActive) {
			xsd = StringPool.BLANK;
		}

		try {
			if (Constants.ADD.equals(cmd) || Constants.UPDATE.equals(cmd)) {
				TypeTask typeTask = updateTypeTask(actionRequest);
				typeTaskId = String.valueOf(typeTask.getTypeTaskId());

				actionResponse.setRenderParameter(TypeTaskConstants.JSP_PAGE,
						TypeTaskConstants.PATH_JSP_EDIT);
				SessionMessages
						.add(actionRequest, "typetask-saved-sucessfully");
			} else if (Constants.DELETE.equals(cmd)
					|| Constants.MOVE_TO_TRASH.equals(cmd)) {
				deleteTypeTasks(actionRequest, actionResponse, cmd);
			} else if (cmd.equals(Constants.RESTORE)) {
				restoreTypeTasks(actionRequest, actionResponse, cmd);
			} else if (TypeTaskConstants.UPDATE_USERS.equals(cmd)) {
				updateUsers(actionRequest);
				actionResponse.setRenderParameter(TypeTaskConstants.JSP_PAGE,
						TypeTaskConstants.PATH_JSP_EDIT);
				SessionMessages.add(actionRequest,
						"typetask-user-saved-sucessfully");
			} else if (TypeTaskConstants.USER_SEARCH_DELETE_ACTION.equals(cmd)) {
				actionResponse.setRenderParameter(TypeTaskConstants.JSP_PAGE,
						TypeTaskConstants.PATH_JSP_EDIT);
			}
		} catch (Exception e) {
			if (e instanceof NoSuchStructureException
					|| e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass());
			} else if (e instanceof LocaleException
					|| e instanceof RequiredStructureException
					|| e instanceof StructureDuplicateElementException
					|| e instanceof StructureNameException
					|| e instanceof StructureXsdException
					|| e instanceof StructureDuplicateStructureKeyException
					|| e instanceof RequiredTypeTaskNameException
					|| e instanceof DuplicateTypeTaskUserException) {

				SessionErrors.add(actionRequest, e.getClass(), e);

				if (Constants.ADD.equals(cmd) || Constants.UPDATE.equals(cmd)) {
					actionResponse.setRenderParameter(
							TypeTaskConstants.JSP_PAGE,
							TypeTaskConstants.PATH_JSP_EDIT);
				}
				copyRequestParameters(actionRequest, actionResponse);
			} else {
				_log.error(e, e);
			}
		}
		actionResponse.setRenderParameter(TypeTaskConstants.REDIRECT,
				getRedirect(actionRequest, actionResponse));
		actionResponse.setRenderParameter(Constants.CMD, cmd);
		actionResponse.setRenderParameter(TypeTaskConstants.COMPANY_ID,
				String.valueOf(themeDisplay.getCompanyId()));
		actionResponse.setRenderParameter(TypeTaskConstants.GROUP_ID,
				String.valueOf(themeDisplay.getScopeGroupId()));
		actionResponse.setRenderParameter("availableFields", availableFields);
		actionResponse.setRenderParameter(TypeTaskConstants.TYPE_TASK_ID,
				typeTaskId);
		actionResponse.setRenderParameter(TypeTaskConstants.XSD, xsd);
		actionResponse.setRenderParameter(TypeTaskConstants.TABS1, tabs1);
		actionResponse.setRenderParameter(TypeTaskConstants.TABS2, tabs2);
		actionResponse.setRenderParameter(TypeTaskConstants.TABS3, tabs3);
		actionResponse.setRenderParameter(TypeTaskConstants.KEYWORDS, keywords);
	}

	protected void deleteTypeTasks(ActionRequest actionRequest,
			ActionResponse actionResponse, String comand) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String moveTrashAction = StringPool.BLANK;
		String deleteAction = StringPool.BLANK;
		String sDeleteTypeTaskIds = StringPool.BLANK;
		String sDeleteTypeTaskNames = StringPool.BLANK;

		long[] restoreTypeTaskIds = null;

		long typeTaskId = ParamUtil.getLong(actionRequest,
				TypeTaskConstants.TYPE_TASK_ID);

		if (typeTaskId > 0) {
			restoreTypeTaskIds = new long[] { typeTaskId };
		} else {
			restoreTypeTaskIds = StringUtil.split(ParamUtil.getString(
					actionRequest, TypeTaskConstants.DELETE_TAG_IDS), 0L);
		}

		for (long deleteTypeTaskId : restoreTypeTaskIds) {
			TypeTask typeTask = TypeTaskLocalServiceUtil
					.getTypeTask(deleteTypeTaskId);
			if (Constants.DELETE.equals(comand)) {
				TypeTaskLocalServiceUtil.deleteTypeTask(deleteTypeTaskId);
				deleteAction = TypeTaskConstants.UM;
			} else if (Constants.MOVE_TO_TRASH.equals(comand)) {
				TypeTaskLocalServiceUtil.moveTypeTaskToTrash(
						themeDisplay.getRealUserId(), deleteTypeTaskId);
				moveTrashAction = TypeTaskConstants.UM;
			}
			if (sDeleteTypeTaskIds.length() > 0) {
				sDeleteTypeTaskIds = sDeleteTypeTaskIds + StringPool.SEMICOLON;
			}
			sDeleteTypeTaskIds = sDeleteTypeTaskIds
					+ String.valueOf(deleteTypeTaskId);
			if (sDeleteTypeTaskNames.length() > 0) {
				sDeleteTypeTaskNames = sDeleteTypeTaskNames
						+ StringPool.SEMICOLON;
			}
			sDeleteTypeTaskNames = sDeleteTypeTaskNames
					+ typeTask.getName(themeDisplay.getLocale());
		}

		if (Validator.isNotNull(sDeleteTypeTaskNames)) {
			actionResponse.setRenderParameter(
					TypeTaskConstants.MOVE_TRASH_ACTION, moveTrashAction);
			actionResponse.setRenderParameter(TypeTaskConstants.DELETE_ACTION,
					deleteAction);
		}
		actionResponse.setRenderParameter(
				TypeTaskConstants.RESTORE_TYPE_TASK_IDS, sDeleteTypeTaskIds);
		actionResponse.setRenderParameter(
				TypeTaskConstants.DELETE_TYPE_TASK_NAMES, sDeleteTypeTaskNames);
	}

	protected TypeTask updateTypeTask(ActionRequest actionRequest)
			throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		long typeTaskId = ParamUtil.getLong(actionRequest,
				TypeTaskConstants.TYPE_TASK_ID);

		long companyId = ParamUtil.getLong(actionRequest,
				TypeTaskConstants.COMPANY_ID);
		long groupId = ParamUtil.getLong(actionRequest,
				TypeTaskConstants.GROUP_ID);
		long userId = ParamUtil.getLong(actionRequest,
				TypeTaskConstants.USER_ID);
		long DDMStructureId = ParamUtil.getLong(actionRequest,
				TypeTaskConstants.DDM_STRUCTURE_ID, 0);
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
				actionRequest, TypeTaskConstants.NAME);
		Map<Locale, String> descriptionMap = LocalizationUtil
				.getLocalizationMap(actionRequest,
						TypeTaskConstants.DESCRIPTION);
		String xsd = ParamUtil.getString(actionRequest, TypeTaskConstants.XSD);
		boolean customFieldsActive = ParamUtil.getBoolean(actionRequest,
				TypeTaskConstants.CUSTOM_FIELDS_ACTIVE);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				TypeTask.class.getName(), actionRequest);

		TypeTask typeTask = null;
		
		long classNameId = PortalUtil.getClassNameId(TypeTask.class);

		if (cmd.equals(Constants.ADD)) {
			typeTask = TypeTaskLocalServiceUtil.addTypeTask(companyId, groupId,
					userId, nameMap, descriptionMap, customFieldsActive, xsd,
					0, classNameId, serviceContext);
		} else if (cmd.equals(Constants.UPDATE)) {
			typeTask = TypeTaskLocalServiceUtil.updateTypeTask(typeTaskId,
					companyId, groupId, userId, nameMap, descriptionMap,
					customFieldsActive, xsd, DDMStructureId, serviceContext);
		}

		return typeTask;
	}

	protected void restoreTypeTasks(ActionRequest actionRequest,
			ActionResponse actionResponse, String comand) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String restoreAction = StringPool.BLANK;
		String sResroreTypeTaskNames = StringPool.BLANK;

		String restoreTypeTaskIds = ParamUtil.getString(actionRequest,
				TypeTaskConstants.RESTORE_TYPE_TASK_IDS);

		if (Validator.isNotNull(restoreTypeTaskIds)) {
			for (String retval : restoreTypeTaskIds.split(";")) {
				TypeTask typeTask = TypeTaskLocalServiceUtil.getTypeTask(Long
						.valueOf(retval));
				if (Validator.isNotNull(typeTask)) {
					TypeTaskLocalServiceUtil.restoreTypeTaskFromTrash(
							themeDisplay.getUserId(), typeTask.getTypeTaskId());
					restoreAction = TypeTaskConstants.UM;

					if (sResroreTypeTaskNames.length() > 0) {
						sResroreTypeTaskNames = sResroreTypeTaskNames
								+ StringPool.SEMICOLON;
					}
					sResroreTypeTaskNames = sResroreTypeTaskNames
							+ typeTask.getName(themeDisplay.getLocale());
				}
			}
		}
		actionResponse.setRenderParameter(TypeTaskConstants.RESTORE_ACTION,
				restoreAction);
		actionResponse.setRenderParameter(
				TypeTaskConstants.RESTORE_TYPE_TASK_NAMES,
				sResroreTypeTaskNames);

	}

	protected void updateUsers(ActionRequest actionRequest) throws Exception {

		long typeTaskId = ParamUtil.getLong(actionRequest,
				TypeTaskConstants.TYPE_TASK_ID);
		long userId = ParamUtil.getLong(actionRequest,
				TypeTaskConstants.USER_ID);
		String typeUser = ParamUtil.getString(actionRequest,
				TypeTaskConstants.TYPE_USER);

		long[] addUserIds = StringUtil.split(ParamUtil.getString(actionRequest,
				TypeTaskConstants.ADD_USERS_IDS), 0L);
		long[] removeUserIds = StringUtil.split(ParamUtil.getString(
				actionRequest, TypeTaskConstants.REMOVE_USERS_IDS), 0L);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				TypeTask.class.getName(), actionRequest);

		TypeTaskUsersLocalServiceUtil.updateUsers(typeTaskId, addUserIds,
				removeUserIds, typeUser, userId, serviceContext);
	}

	private void copyRequestParameters(ActionRequest request,
			ActionResponse actionResponse) {

		actionResponse.setRenderParameter("p_p_lifecycle", "1");

		Enumeration<String> enu = request.getParameterNames();

		Map<String, String[]> renderParameters = actionResponse
				.getRenderParameterMap();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();
			String[] values = request.getParameterValues(param);

			if (renderParameters.get(actionResponse.getNamespace() + param) == null
					&& (Validator.isNotNull(param) && Validator
							.isNotNull(values))) {
				actionResponse.setRenderParameter(param, values);
			}
		}
	}
}
