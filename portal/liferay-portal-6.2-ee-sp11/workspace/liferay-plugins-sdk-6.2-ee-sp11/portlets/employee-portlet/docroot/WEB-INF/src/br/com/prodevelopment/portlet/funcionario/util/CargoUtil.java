package br.com.prodevelopment.portlet.funcionario.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.funcionario.model.Cargo;
import br.com.prodevelopment.funcionario.service.CargoLocalServiceUtil;
import br.com.prodevelopment.portlet.funcionario.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

public class CargoUtil {

	public static Cargo getCargo(long cargoId)
			throws SystemException {
		return CargoLocalServiceUtil.fetchCargo(cargoId);
	}

	public static Cargo getCargo(HttpServletRequest request) throws PortalException, SystemException {

		long cargoId = ParamUtil.getLong(request,
				Constantes.CARGO_ID);

		Cargo cargo = null;
		if (cargoId > 0) {
			cargo = CargoLocalServiceUtil
					.getCargo(cargoId);
		}

		request.setAttribute(Constantes.CARGO, cargo);
		request.setAttribute(Constantes.CARGO_ID, cargoId);
		
		return cargo;
	}

	public static Cargo getCargo(PortletRequest portletRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getCargo(request);
	}

	public static Cargo getCargo(ActionRequest actionRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getCargo(request);
	}

	public static List<Cargo> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator, PermissionChecker permissionChecker) throws SystemException {
		List<Cargo> retorno = new ArrayList<Cargo>();
		List<Cargo> lista = null;
		if (Validator.isNotNull(keywords)) {
			lista = CargoLocalServiceUtil
					.search(companyId,
							StringPool.PERCENT+keywords+StringPool.PERCENT, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS, orderByComparator);
		} else {
			lista = CargoLocalServiceUtil
					.search(companyId, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS, orderByComparator);
		}

		for (Cargo cargo : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, Cargo.class.getName(), cargo.getCargoId(),
					ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(cargo);
			}
		}
		
		return retorno;
	}
}
