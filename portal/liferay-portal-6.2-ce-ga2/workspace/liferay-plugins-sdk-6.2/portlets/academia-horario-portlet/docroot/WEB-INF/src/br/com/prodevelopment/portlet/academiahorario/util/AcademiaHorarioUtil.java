package br.com.prodevelopment.portlet.academiahorario.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.academiahorario.NoSuchAcademiaHorarioException;
import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil;
import br.com.prodevelopment.portlet.academiahorario.Constantes;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;

public class AcademiaHorarioUtil {

	private static String[] diasDaSemana = { "label.opcao.diaSemana.domingo",
			"label.opcao.diaSemana.segunda", "label.opcao.diaSemana.terca",
			"label.opcao.diaSemana.quarta", "label.opcao.diaSemana.quinta",
			"label.opcao.diaSemana.sexta", "label.opcao.diaSemana.sabado" };
	public static String[] valoresDiasDaSemana = { "1", "2", "3", "4", "5", "6", "7" };

	public static String getDiaDaSemana(int dia) {
		return diasDaSemana[dia];
	}

	public static AcademiaHorario getAcademiaHorario(long academiaHorarioId)
			throws SystemException {
		return AcademiaHorarioLocalServiceUtil.fetchAcademiaHorario(academiaHorarioId);
	}

	public static AcademiaHorario getAcademiaHorario(HttpServletRequest request) throws PortalException, SystemException {

		long academiaHorarioId = ParamUtil.getLong(request,
				Constantes.CAMPO_ACADEMIA_HORARIO_ID);
		long atividadeId = ParamUtil.getLong(request,
				Constantes.CAMPO_ATIVIDADE_ID);

		
		AcademiaHorario academiaHorario = null;
		if (academiaHorarioId > 0) {
			try {
				academiaHorario = AcademiaHorarioLocalServiceUtil
						.getAcademiaHorario(academiaHorarioId);
			}
			catch (NoSuchAcademiaHorarioException nsa) {
				nsa.getMessage();
			}
		}

		request.setAttribute(Constantes.ACADEMIA_HORARIO, academiaHorario);
		request.setAttribute(Constantes.CAMPO_ACADEMIA_HORARIO_ID, academiaHorarioId);
		request.setAttribute(Constantes.CAMPO_ATIVIDADE_ID, atividadeId);
		
		return academiaHorario;
	}

	public static AcademiaHorario getAcademiaHorario(PortletRequest portletRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getAcademiaHorario(request);
	}

	public static AcademiaHorario getAcademiaHorario(ActionRequest actionRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getAcademiaHorario(request);
	}

	public static List<AcademiaHorario> search(long companyId, long groupId, String keywords,
			PermissionChecker permissionChecker) throws SystemException {
		List<AcademiaHorario> retorno = new ArrayList<AcademiaHorario>();
		List<AcademiaHorario> lista = null;
		if (groupId > 0) {
			lista = AcademiaHorarioLocalServiceUtil
					.search(companyId, groupId, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS, null);
		} else {
			lista = AcademiaHorarioLocalServiceUtil
					.search(companyId, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS, null);
		}

		for (AcademiaHorario academiaHorario : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, AcademiaHorario.class.getName(), academiaHorario.getAcademiaHorarioId(),
					ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(academiaHorario);
			}
		}
		
		return retorno;
	}

	public static List<AcademiaHorario> search(long companyId, long groupId, String diaDaSemana, String atividadeId,
			boolean andSearch, PermissionChecker permissionChecker) throws SystemException {
		List<AcademiaHorario> retorno = new ArrayList<AcademiaHorario>();
		List<AcademiaHorario> lista = AcademiaHorarioLocalServiceUtil
					.search(companyId, groupId, GetterUtil.getInteger(diaDaSemana), GetterUtil.getLong(atividadeId), andSearch, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS);

		for (AcademiaHorario academiaHorario : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, AcademiaHorario.class.getName(), academiaHorario.getAcademiaHorarioId(),
					ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(academiaHorario);
			}
		}
		
		return retorno;
	}
}
