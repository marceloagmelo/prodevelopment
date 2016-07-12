package br.com.prodevelopment.etask.portlet.typetask.trash;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.portlet.typetask.permission.TypeTaskPermission;
import br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.BaseTrashHandler;
import com.liferay.portal.security.permission.PermissionChecker;

public class TypeTaskTrashHandler extends BaseTrashHandler {
	public void deleteTrashEntry(long classPK)
			throws PortalException, SystemException {

			TypeTaskLocalServiceUtil.deleteTypeTask(classPK);
		}


		public String getClassName() {
			return TypeTask.class.getName();
		}


		public boolean isInTrash(long classPK)
			throws PortalException, SystemException {

			TypeTask typeTask =
				TypeTaskLocalServiceUtil.getTypeTask(classPK);

			return typeTask.isInTrash();
		}


		public boolean isRestorable(long classPK)
			throws PortalException, SystemException {
			return true;
		}


		public void restoreTrashEntry(long userId, long classPK)
			throws PortalException, SystemException {

			TypeTaskLocalServiceUtil.restoreTypeTaskFromTrash(
				userId, classPK);
		}


		protected boolean hasPermission(
				PermissionChecker permissionChecker, long classPK, String actionId)
			throws PortalException, SystemException {

			TypeTask typeTask =
				TypeTaskLocalServiceUtil.getTypeTask(classPK);
			
			/*return permissionChecker.hasPermission(
					typeTask.getGroupId(), RESOURCE_NAME, typeTask.getGroupId(), actionId);*/

			return TypeTaskPermission.contains(
					permissionChecker, typeTask.getGroupId(),
				actionId);
		}
}
