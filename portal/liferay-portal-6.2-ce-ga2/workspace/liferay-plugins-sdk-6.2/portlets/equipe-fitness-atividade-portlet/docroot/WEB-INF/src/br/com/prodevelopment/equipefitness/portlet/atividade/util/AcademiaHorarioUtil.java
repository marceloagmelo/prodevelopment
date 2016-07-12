package br.com.prodevelopment.equipefitness.portlet.atividade.util;

import java.util.List;

import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;

public class AcademiaHorarioUtil {

	private static String[] diasDaSemana = { "label.opcao.diaSemana.domingo",
			"label.opcao.diaSemana.segunda", "label.opcao.diaSemana.terca",
			"label.opcao.diaSemana.quarta", "label.opcao.diaSemana.quinta",
			"label.opcao.diaSemana.sexta", "label.opcao.diaSemana.sabado" };

	public static String getDiaDaSemana(int dia) {
		return diasDaSemana[dia];
	}

	public static AcademiaHorario getAcademiaHorario(long academiaHorarioId)
			throws SystemException {
		return AcademiaHorarioLocalServiceUtil.fetchAcademiaHorario(academiaHorarioId);
	}

	public static List<AcademiaHorario> search(long companyId, long groupId, String diaDaSemana, String atividadeId,
			boolean andSearch) throws SystemException {
		return AcademiaHorarioLocalServiceUtil
					.search(companyId, groupId, GetterUtil.getInteger(diaDaSemana), GetterUtil.getLong(atividadeId), andSearch, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS);

	}
	
	public static List<AcademiaHorario> recuperarHorariosPorAtividade(long atividadeId) throws SystemException {
		return AcademiaHorarioLocalServiceUtil.recuperarHorariosPorAtividade(atividadeId);
	}
}
