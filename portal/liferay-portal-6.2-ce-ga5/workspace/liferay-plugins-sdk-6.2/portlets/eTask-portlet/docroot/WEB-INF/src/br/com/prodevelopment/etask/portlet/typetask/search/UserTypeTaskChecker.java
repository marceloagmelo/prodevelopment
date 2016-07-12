package br.com.prodevelopment.etask.portlet.typetask.search;

import javax.portlet.RenderResponse;

import br.com.prodevelopment.etask.model.TypeTask;
import br.com.prodevelopment.etask.portlet.typetask.util.TypeTaskUsersUtil;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

public class UserTypeTaskChecker extends RowChecker {
	public UserTypeTaskChecker(RenderResponse renderResponse,
			TypeTask typeTask, String typeUser) {
		super(renderResponse);

		_typeTask = typeTask;
		_typeUser = typeUser;
	}

	@Override
	public boolean isChecked(Object obj) {
		User user = (User) obj;

		try {
			return TypeTaskUsersUtil.constaisUser(_typeTask.getTypeTaskId(),
					user.getUserId(), _typeUser);
		} catch (Exception e) {
			_log.error(e, e);

			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserTypeTaskChecker.class);

	private TypeTask _typeTask;
	private String _typeUser;

}
