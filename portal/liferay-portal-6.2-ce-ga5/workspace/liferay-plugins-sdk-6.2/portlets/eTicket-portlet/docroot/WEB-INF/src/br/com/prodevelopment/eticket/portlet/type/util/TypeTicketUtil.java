package br.com.prodevelopment.eticket.portlet.type.util;

import java.util.ArrayList;
import java.util.List;

import br.com.prodevelopment.eticket.model.TypeTicket;
import br.com.prodevelopment.eticket.service.TypeTicketLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;

public class TypeTicketUtil {
	public static List<TypeTicket> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator, PermissionChecker permissionChecker) throws SystemException {
		List<TypeTicket> retorno = new ArrayList<TypeTicket>();
		List<TypeTicket> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = TypeTicketLocalServiceUtil
					.search(companyId, groupId, StringPool.PERCENT
							+ keywords + StringPool.PERCENT,
							QueryUtil.ALL_POS, QueryUtil.ALL_POS,
							orderByComparator);

		} else {
			lista = TypeTicketLocalServiceUtil
					.search(companyId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
							orderByComparator);
		}

		for (TypeTicket typeTicket : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, TypeTicket.class.getName(), typeTicket.getTypeTicketId(),
					ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(typeTicket);
			}
		}
		
		return retorno;
	}
}
