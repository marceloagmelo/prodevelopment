package br.com.prodevelopment.etask.portlet.typetask.util;

import java.util.ArrayList;
import java.util.List;

import br.com.prodevelopment.etask.NoSuchTypeTaskUsersException;
import br.com.prodevelopment.etask.model.TypeTaskUsers;
import br.com.prodevelopment.etask.service.TypeTaskUsersLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class TypeTaskUsersUtil {
	public static boolean constaisUser(long typeTaskId, long userId,
			String typeUser) throws SystemException {

		boolean retorno = false;

		TypeTaskUsers typeTaskUsers;
		try {
			
			typeTaskUsers = TypeTaskUsersLocalServiceUtil.getTypeTaskUsers(
					typeTaskId, userId, typeUser);
			retorno = (typeTaskUsers != null);
			
			
		} catch (NoSuchTypeTaskUsersException e) {
			retorno = false;
		}

		return retorno;

		/*
		boolean retorno = false;
		
		List<TypeTaskUsers> listTypeUsers = TypeTaskUsersLocalServiceUtil
				.searchByTypeTask(typeTaskId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null);
		//List<TypeTaskUsers> listTypeUsers = TypeTaskUsersLocalServiceUtil.getTypeTaskUserses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (TypeTaskUsers typeTaskUsers : listTypeUsers) {
			retorno = ((typeTaskUsers.getUserId() == userId) && (typeUser
					.equals(typeTaskUsers.getTypeUser())));
			if (retorno) {
				break;
			}
		}

		return retorno;
		*/
	}

	public static List<User> searchUsers(long companyId, String keywords,
			int status, long typeTaskId, String typeUser, int start, int end,
			OrderByComparator obc) throws SystemException {
		List<User> listUsersReturn = new ArrayList<User>();
		List<User> listUsers = UserLocalServiceUtil.search(companyId, keywords,
				status, null, start, end, obc);
		for (User user : listUsers) {
			if (constaisUser(typeTaskId, user.getUserId(), typeUser)) {
				listUsersReturn.add(user);
			}
		}
		return listUsersReturn;
	}

	public static int searchUsersCount(long companyId, String keywords,
			int status, long typeTaskId, String typeUser, OrderByComparator obc)
			throws SystemException {
		int listUsersCount = 0;
		List<User> listUsers = UserLocalServiceUtil.search(companyId, keywords,
				status, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS, obc);
		for (User user : listUsers) {
			if (constaisUser(typeTaskId, user.getUserId(), typeUser)) {
				listUsersCount++;
			}
		}
		return listUsersCount;
	}
}
