package br.com.prodevelopment.portlet.cliente.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.portlet.cliente.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.comparator.UserFirstNameComparator;

public class UsuarioUtil {

	public static User getUsuario(long userId) throws SystemException {

		return UserLocalServiceUtil.fetchUser(userId);
	}

	public static User getUsuario(HttpServletRequest request)
			throws PortalException, SystemException {

		long userId = ParamUtil.getLong(request, Constantes.USER_ID);

		User user = null;
		if (userId > 0) {
			user = UserLocalServiceUtil.getUser(userId);
		}

		request.setAttribute(Constantes.USUARIO, user);
		request.setAttribute(Constantes.USER_ID, userId);

		return user;
	}

	public static User getUsuario(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getUsuario(request);
	}

	public static User getUsuario(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getUsuario(request);
	}

	public static List<User> listarUsuarios(long groupId, String keywords)
			throws SystemException {
		List<User> retorno = new ArrayList<User>();
		Map<String, User> mapUsuarios = new TreeMap<String, User>();
		List<User> lista = UserLocalServiceUtil.getGroupUsers(groupId);
		for (User user : lista) {
			if (Validator.isNotNull(keywords)) {
				if (user.getFullName().contains(keywords)) {
					mapUsuarios.put(user.getFullName(), user);
				}
			} else {
				mapUsuarios.put(user.getFullName(), user);
			}
		}
		Iterator<String> it = mapUsuarios.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			User user = mapUsuarios.get(key);
			retorno.add(user);
		}
		return retorno;
	}

	public static List<User> listarUsuarios(long companyId,
			LinkedHashMap<String, Object> userParams, String keywords)
			throws SystemException {
		List<User> retorno = new ArrayList<User>();
		Map<String, User> mapUsuarios = new TreeMap<String, User>();
		List<User> lista = UserLocalServiceUtil.search(companyId, keywords,
				WorkflowConstants.STATUS_APPROVED, userParams,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new UserFirstNameComparator());
		for (User user : lista) {
			mapUsuarios.put(user.getFullName(), user);
		}
		Iterator<String> it = mapUsuarios.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			User user = mapUsuarios.get(key);
			retorno.add(user);
		}
		return retorno;
	}
}
