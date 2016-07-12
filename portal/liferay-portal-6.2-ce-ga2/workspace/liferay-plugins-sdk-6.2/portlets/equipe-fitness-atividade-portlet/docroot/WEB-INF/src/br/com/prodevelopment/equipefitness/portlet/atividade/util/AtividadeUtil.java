package br.com.prodevelopment.equipefitness.portlet.atividade.util;

import java.util.ArrayList;
import java.util.List;

import br.com.prodevelopment.academiahorario.model.AcademiaHorario;
import br.com.prodevelopment.academiahorario.service.AcademiaHorarioLocalServiceUtil;
import br.com.prodevelopment.atividade.model.Atividade;
import br.com.prodevelopment.atividade.service.AtividadeLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class AtividadeUtil {
	public static List<Atividade> search(long companyId, long groupId)
			throws SystemException {
		List<Atividade> retorno = new ArrayList<Atividade>();
		List<Atividade> lista = AtividadeLocalServiceUtil.search(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		for (Atividade atividade : lista) {
			List<AcademiaHorario> listaAcademiaHorario = AcademiaHorarioLocalServiceUtil
					.searchByAcademia(companyId, groupId, atividade.getAtividadeId(),
							QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			if (listaAcademiaHorario.size() > 0) {
				retorno.add(atividade);
			}
		}

		return retorno;
	}

	public static List<Atividade> search(long companyId) throws SystemException {
		List<Atividade> retorno = new ArrayList<Atividade>();
		List<Atividade> lista = AtividadeLocalServiceUtil.search(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		for (Atividade atividade : lista) {
			List<AcademiaHorario> listaAcademiaHorario = AcademiaHorarioLocalServiceUtil
					.searchByAcademia(companyId, atividade.getAtividadeId(),
							QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			if (listaAcademiaHorario.size() > 0) {
				retorno.add(atividade);
			}
		}

		return retorno;
	}

	public static Atividade getAtividade(long atividadeId)
			throws SystemException {
		return AtividadeLocalServiceUtil.fetchAtividade(atividadeId);
	}
}
