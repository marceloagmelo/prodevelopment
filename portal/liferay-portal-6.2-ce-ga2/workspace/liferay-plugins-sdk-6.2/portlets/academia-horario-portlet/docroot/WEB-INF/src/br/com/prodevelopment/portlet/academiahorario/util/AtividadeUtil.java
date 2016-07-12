package br.com.prodevelopment.portlet.academiahorario.util;

import java.util.List;

import br.com.prodevelopment.atividade.model.Atividade;
import br.com.prodevelopment.atividade.service.AtividadeLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class AtividadeUtil {

	public static Atividade getAtividade(long atividadeId)
			throws SystemException {
		return AtividadeLocalServiceUtil.fetchAtividade(atividadeId);
	}

	public static List<Atividade> listaAtividades(long companyId, long groupId)
			throws SystemException {
		return AtividadeLocalServiceUtil.search(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public static List<Atividade> listaAtividades(long companyId)
			throws SystemException {
		return AtividadeLocalServiceUtil.search(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);
	}
}
