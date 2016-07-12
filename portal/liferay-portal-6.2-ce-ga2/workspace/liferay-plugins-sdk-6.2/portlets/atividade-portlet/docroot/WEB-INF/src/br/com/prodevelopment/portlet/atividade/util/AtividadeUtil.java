package br.com.prodevelopment.portlet.atividade.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.atividade.NoSuchAtividadeException;
import br.com.prodevelopment.atividade.model.Atividade;
import br.com.prodevelopment.atividade.service.AtividadeLocalServiceUtil;
import br.com.prodevelopment.portlet.atividade.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.webserver.WebServerServletTokenUtil;

public class AtividadeUtil {
	public static Atividade getAtividade(long atividadeId)
			throws SystemException {
		return AtividadeLocalServiceUtil.fetchAtividade(atividadeId);
	}

	public static Atividade getAtividade(HttpServletRequest request) throws PortalException, SystemException {

		long atividadeId = ParamUtil.getLong(request,
				Constantes.CAMPO_ATIVIDADE_ID);

		Atividade atividade = null;
		if (atividadeId > 0) {
			try {
				atividade = AtividadeLocalServiceUtil
						.getAtividade(atividadeId);
			}
			catch (NoSuchAtividadeException nsa) {
				nsa.getMessage();
			}
		}

		request.setAttribute(Constantes.ATIVIDADE, atividade);
		request.setAttribute(Constantes.CAMPO_ATIVIDADE_ID, atividadeId);
		
		return atividade;
	}

	public static Atividade getAtividade(PortletRequest portletRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getAtividade(request);
	}

	public static Atividade getAtividade(ActionRequest actionRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getAtividade(request);
	}

	public static List<Atividade> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator, PermissionChecker permissionChecker, boolean prefSomenteEsseSite) throws SystemException {
		List<Atividade> retorno = new ArrayList<Atividade>();
		List<Atividade> lista = null;
		if (Validator.isNotNull(keywords)) {
			if (prefSomenteEsseSite) {
				lista = AtividadeLocalServiceUtil
						.search(companyId, groupId,
								StringPool.PERCENT+keywords+StringPool.PERCENT, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			} else {
				lista = AtividadeLocalServiceUtil
						.search(companyId,
								StringPool.PERCENT+keywords+StringPool.PERCENT, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			}
		} else {
			if (prefSomenteEsseSite) {
				lista = AtividadeLocalServiceUtil
						.search(companyId, groupId, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			} else {
				lista = AtividadeLocalServiceUtil
						.search(companyId, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			}
		}

		for (Atividade atividade : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, Atividade.class.getName(), atividade.getAtividadeId(),
					ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(atividade);
			}
		}
		
		return retorno;
	}

	public static String getImagemURL(String imagePath, long imagemId) {

		StringBundler sb = new StringBundler(7);

		sb.append(imagePath);
		sb.append("/user_");

		sb.append("male");

		sb.append("_portrait?img_id=");
		sb.append(imagemId);
		sb.append("&t=");
		sb.append(WebServerServletTokenUtil.getToken(imagemId));

		return sb.toString();
	}
}
