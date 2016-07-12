package br.com.prodevelopment.portlet.funcionario.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.contato.NoSuchContatoException;
import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.funcionario.model.impl.FuncionarioImpl;
import br.com.prodevelopment.funcionario.service.FuncionarioLocalServiceUtil;
import br.com.prodevelopment.portlet.funcionario.Constantes;

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

public class FuncionarioUtil {

	public static Funcionario getFuncionario(long funcionarioId)
			throws SystemException {
		return FuncionarioLocalServiceUtil.fetchFuncionario(funcionarioId);
	}

	public static Funcionario getFuncionario(HttpServletRequest request)
			throws PortalException, SystemException {

		long funcinarioId = ParamUtil.getLong(request,
				Constantes.FUNCIONARIO_ID);

		Funcionario funcionario = null;
		Contato contato = ContatoUtil.getContato();
		if (funcinarioId > 0) {
			funcionario = FuncionarioLocalServiceUtil
					.getFuncionario(funcinarioId);
			long classNameId = PortalUtil.getClassNameId(Funcionario.class.getName());
			try {
				Contato selContato = ContatoLocalServiceUtil.findByContato(classNameId, funcionario.getFuncionarioId());
				contato = selContato;
			} catch (NoSuchContatoException e) {
			}
		}

		request.setAttribute(Constantes.FUNCIONARIO, funcionario);
		request.setAttribute(Constantes.FUNCIONARIO_ID, funcinarioId);
		request.setAttribute("enderecoEmail.className", Contato.class.getName());
		request.setAttribute("enderecoEmail.classPK", contato.getContatoId());
		request.setAttribute("telefones.className", Contato.class.getName());
		request.setAttribute("telefones.classPK", contato.getContatoId());

		
		return funcionario;
	}

	public static Funcionario getFuncionario(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getFuncionario(request);
	}

	public static Funcionario getFuncionario(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getFuncionario(request);
	}

	public static String getFotoURL(String imagePath, String sexo, long fotoId) {

		StringBundler sb = new StringBundler(7);

		sb.append(imagePath);
		sb.append("/user_");

		if (Constantes.MASCULINO.equals(sexo)) {
			sb.append("male");
		} else {
			sb.append("female");
		}

		sb.append("_portrait?img_id=");
		sb.append(fotoId);
		sb.append("&t=");
		sb.append(WebServerServletTokenUtil.getToken(fotoId));

		return sb.toString();
	}

	public static List<Funcionario> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator, PermissionChecker permissionChecker,
			boolean somenteEsseSite) throws SystemException {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		List<Funcionario> lista = null;
		if (Validator.isNotNull(keywords)) {
			if (somenteEsseSite) {
				lista = FuncionarioLocalServiceUtil
						.search(companyId, groupId, StringPool.PERCENT
								+ keywords + StringPool.PERCENT,
								QueryUtil.ALL_POS, QueryUtil.ALL_POS,
								orderByComparator);

			} else {
				lista = FuncionarioLocalServiceUtil
						.search(companyId, StringPool.PERCENT + keywords
								+ StringPool.PERCENT, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			}
		} else {
			if (somenteEsseSite) {
				lista = FuncionarioLocalServiceUtil
						.search(companyId, groupId, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			} else {
				lista = FuncionarioLocalServiceUtil
						.search(companyId, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			}
		}

		for (Funcionario funcionario : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, Funcionario.class.getName(), funcionario.getFuncionarioId(),
					ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(funcionario);
			}
		}
		
		return retorno;
	}
}
