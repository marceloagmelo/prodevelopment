package br.com.prodevelopment.portlet.atividade.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

public class GroupUtil {

	public static String getNomeSite(long groupId) throws PortalException, SystemException {
		String retorno = StringPool.BLANK;
		
		Group group = GroupLocalServiceUtil.getGroup(groupId);
		
		if (Validator.isNotNull(group)) {
			retorno = group.getName();
			if (group.isOrganization()) {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(group.getClassPK());
				retorno = organization.getName();
			}
		}

		return retorno;
	}

}