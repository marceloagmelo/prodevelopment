package br.com.prodevelopment.etask.portlet.typetask.util;

import java.util.ArrayList;
import java.util.List;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.service.TypeTaskLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

public class TypeTaskUtil {
	public static List<TypeTask> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<TypeTask> retorno = new ArrayList<TypeTask>();
		List<TypeTask> lista = null;
		long classNameId = PortalUtil.getClassNameId(TypeTask.class);
		int[ ] status = {WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_PENDING};
		if (Validator.isNotNull(keywords)) {
			lista = TypeTaskLocalServiceUtil.search(companyId, groupId,
					status, StringPool.PERCENT + keywords + StringPool.PERCENT, classNameId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		} else {
			lista = TypeTaskLocalServiceUtil.search(companyId, groupId, status, classNameId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		}

		for (TypeTask typeTask : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, TypeTask.class.getName(),
					typeTask.getTypeTaskId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(typeTask);
			}
		}

		return retorno;
	}

	public static List<TypeTask> search(long companyId, long groupId,
			String keywords, int[ ] status, int start, int end, OrderByComparator orderByComparator,
			PermissionChecker permissionChecker) throws SystemException {
		List<TypeTask> retorno = new ArrayList<TypeTask>();
		List<TypeTask> lista = null;
		//int[ ] status = {WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_PENDING};
		long classNameId = PortalUtil.getClassNameId(TypeTask.class);
		if (Validator.isNotNull(keywords)) {
			lista = TypeTaskLocalServiceUtil.search(companyId, groupId,
					status, StringPool.PERCENT + keywords + StringPool.PERCENT, classNameId,
					start, end, orderByComparator);

		} else {
			lista = TypeTaskLocalServiceUtil.search(companyId, groupId, status, classNameId,
					start, end, orderByComparator);
		}

		for (TypeTask typeTask : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, TypeTask.class.getName(),
					typeTask.getTypeTaskId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(typeTask);
			}
		}

		return retorno;
	}

	public static int searchCount(long companyId, long groupId,
			String keywords, int[ ] status, PermissionChecker permissionChecker) throws SystemException {
		int retorno = 0;
		List<TypeTask> lista = null;
		//int[ ] status = {WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_PENDING};
		long classNameId = PortalUtil.getClassNameId(TypeTask.class);
		if (Validator.isNotNull(keywords)) {
			lista = TypeTaskLocalServiceUtil.search(companyId, groupId,
					status, StringPool.PERCENT + keywords + StringPool.PERCENT, classNameId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		} else {
			lista = TypeTaskLocalServiceUtil.search(companyId, groupId, status, classNameId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		}

		for (TypeTask typeTask : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, TypeTask.class.getName(),
					typeTask.getTypeTaskId(), ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno++;
			}
		}

		return retorno;
	}
}
