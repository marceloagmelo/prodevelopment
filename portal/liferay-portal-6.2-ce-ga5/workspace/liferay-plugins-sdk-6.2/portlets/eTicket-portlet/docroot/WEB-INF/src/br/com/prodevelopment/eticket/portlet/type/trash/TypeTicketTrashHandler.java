package br.com.prodevelopment.eticket.portlet.type.trash;

import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.portlet.type.permission.TypePermission;
import br.com.prodevelopment.eticket.portlet.type.util.ActionKeys;
import br.com.prodevelopment.eticket.service.TypeTicketLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.BaseTrashHandler;
import com.liferay.portal.security.permission.PermissionChecker;

public class TypeTicketTrashHandler extends BaseTrashHandler {
	public void deleteTrashEntry(long classPK)
			throws PortalException, SystemException {

			TypeTicketLocalServiceUtil.deleteTypeTicket(classPK);
		}


		public String getClassName() {
			return TypeTicket.class.getName();
		}


		public boolean isInTrash(long classPK)
			throws PortalException, SystemException {

			TypeTicket typeTicket =
				TypeTicketLocalServiceUtil.getTypeTicket(classPK);

			return typeTicket.isInTrash();
		}


		public boolean isRestorable(long classPK)
			throws PortalException, SystemException {

			TypeTicket typeTicket =
				TypeTicketLocalServiceUtil.getTypeTicket(classPK);

			//if (type.isMasterType()) {
			//	return true;
			//}

			//return false;
			return true;
		}


		public void restoreTrashEntry(long userId, long classPK)
			throws PortalException, SystemException {

			TypeTicketLocalServiceUtil.restoreTypeTicketFromTrash(
				userId, classPK);
		}


		protected boolean hasPermission(
				PermissionChecker permissionChecker, long classPK, String actionId)
			throws PortalException, SystemException {

			TypeTicket typeTicket =
				TypeTicketLocalServiceUtil.getTypeTicket(classPK);
			
			return TypePermission.contains(
				permissionChecker, typeTicket.getGroupId(),
				ActionKeys.MANAGE_TYPES);
		}
}
