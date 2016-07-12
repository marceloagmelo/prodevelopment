package br.com.prodevelopment.hook.service.user.impl;

import java.util.List;

import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.funcionario.service.FuncionarioLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceWrapper;

public class ExtUserLocalService extends UserLocalServiceWrapper {
	/*
	 * (non-Java-doc)
	 * 
	 * @see
	 * com.liferay.portal.service.UserLocalServiceWrapper#UserLocalServiceWrapper
	 * (UserLocalService userLocalService)
	 */
	public ExtUserLocalService(UserLocalService userLocalService) {
		super(userLocalService);
	}

	@Override
	public User updateUser(long userId, String oldPassword,
			String newPassword1, String newPassword2, boolean passwordReset,
			String reminderQueryQuestion, String reminderQueryAnswer,
			String screenName, String emailAddress, long facebookId,
			String openId, String languageId, String timeZoneId,
			String greeting, String comments, String firstName,
			String middleName, String lastName, int prefixId, int suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
			String smsSn, String aimSn, String facebookSn, String icqSn,
			String jabberSn, String msnSn, String mySpaceSn, String skypeSn,
			String twitterSn, String ymSn, String jobTitle, long[] groupIds,
			long[] organizationIds, long[] roleIds,
			List<UserGroupRole> userGroupRoles, long[] userGroupIds,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		User user = super.updateUser(userId, oldPassword, newPassword1, newPassword2,
				passwordReset, reminderQueryQuestion, reminderQueryAnswer,
				screenName, emailAddress, facebookId, openId, languageId,
				timeZoneId, greeting, comments, firstName, middleName,
				lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
				birthdayYear, smsSn, aimSn, facebookSn, icqSn, jabberSn, msnSn,
				mySpaceSn, skypeSn, twitterSn, ymSn, jobTitle, groupIds,
				organizationIds, roleIds, userGroupRoles, userGroupIds,
				serviceContext);

		Funcionario funcionario = FuncionarioLocalServiceUtil.fetchByUSUARIO(user.getUserId());
		if (Validator.isNotNull(funcionario)) {
			FuncionarioLocalServiceUtil.updateFoto(funcionario.getFuncionarioId(), user.getPortraitId());
		}
		
		return user;
	}

	@Override
	public User updatePortrait(long userId, byte[] bytes)
		throws PortalException, SystemException {
		User user = super.updatePortrait(userId, bytes);
		Funcionario funcionario = FuncionarioLocalServiceUtil.fetchByUSUARIO(user.getUserId());
		if (Validator.isNotNull(funcionario)) {
			FuncionarioLocalServiceUtil.updateFoto(funcionario.getFuncionarioId(), user.getPortraitId());
		}
		
		return user;
	}

	@Override
	public void deletePortrait(long userId)
		throws PortalException, SystemException {

		super.deletePortrait(userId);
		
		Funcionario funcionario = FuncionarioLocalServiceUtil.fetchByUSUARIO(userId);
		if (Validator.isNotNull(funcionario)) {
			FuncionarioLocalServiceUtil.deleteFoto(funcionario.getFuncionarioId());
		}
	}
}