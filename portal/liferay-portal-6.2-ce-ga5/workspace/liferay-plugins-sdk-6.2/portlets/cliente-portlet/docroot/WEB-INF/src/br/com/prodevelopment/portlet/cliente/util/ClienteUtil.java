package br.com.prodevelopment.portlet.cliente.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.cliente.model.Cliente;
import br.com.prodevelopment.cliente.model.ClienteLimCredito;
import br.com.prodevelopment.cliente.service.ClienteLimCreditoLocalServiceUtil;
import br.com.prodevelopment.cliente.service.ClienteLocalServiceUtil;
import br.com.prodevelopment.contato.NoSuchContatoException;
import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.service.ContatoLocalServiceUtil;
import br.com.prodevelopment.portlet.cliente.Constantes;

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

public class ClienteUtil {

	public static Cliente getCliente(long clienteId)
			throws SystemException {
		return ClienteLocalServiceUtil.fetchCliente(clienteId);
	}

	public static Cliente getCliente(HttpServletRequest request)
			throws PortalException, SystemException {

		long clienteId = ParamUtil.getLong(request,
				Constantes.CLIENTE_ID);

		Cliente cliente = null;
		Contato contato = ContatoUtil.getContato();
		if (clienteId > 0) {
			cliente = ClienteLocalServiceUtil
					.getCliente(clienteId);
			long classNameId = PortalUtil.getClassNameId(Cliente.class.getName());
			try {
				Contato selContato = ContatoLocalServiceUtil.findByContato(classNameId, cliente.getClienteId());
				contato = selContato;
			} catch (NoSuchContatoException e) {
			}
		}

		request.setAttribute(Constantes.CLIENTE, cliente);
		request.setAttribute(Constantes.CLIENTE_ID, clienteId);
		request.setAttribute("enderecos.className", Contato.class.getName());
		request.setAttribute("enderecos.classPK", contato.getContatoId());
		request.setAttribute("enderecoEmail.className", Contato.class.getName());
		request.setAttribute("enderecoEmail.classPK", contato.getContatoId());
		request.setAttribute("telefones.className", Contato.class.getName());
		request.setAttribute("telefones.classPK", contato.getContatoId());
		
		return cliente;
	}

	public static Cliente getCliente(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getCliente(request);
	}

	public static Cliente getCliente(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getCliente(request);
	}

	public static String getLogoTipoURL(String imagePath, long fotoId) {

		StringBundler sb = new StringBundler(7);

		sb.append(imagePath);
		sb.append("/user_");

		sb.append("male");

		sb.append("_portrait?img_id=");
		sb.append(fotoId);
		sb.append("&t=");
		sb.append(WebServerServletTokenUtil.getToken(fotoId));

		return sb.toString();
	}

	public static List<Cliente> search(long companyId, long groupId,
			String keywords, OrderByComparator orderByComparator, PermissionChecker permissionChecker,
			boolean somenteEsseSite) throws SystemException {
		List<Cliente> retorno = new ArrayList<Cliente>();
		List<Cliente> lista = null;
		if (Validator.isNotNull(keywords)) {
			if (somenteEsseSite) {
				lista = ClienteLocalServiceUtil
						.search(companyId, groupId, StringPool.PERCENT
								+ keywords + StringPool.PERCENT,
								QueryUtil.ALL_POS, QueryUtil.ALL_POS,
								orderByComparator);

			} else {
				lista = ClienteLocalServiceUtil
						.search(companyId, StringPool.PERCENT + keywords
								+ StringPool.PERCENT, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			}
		} else {
			if (somenteEsseSite) {
				lista = ClienteLocalServiceUtil
						.search(companyId, groupId, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			} else {
				lista = ClienteLocalServiceUtil
						.search(companyId, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS, orderByComparator);
			}
		}

		for (Cliente cliente : lista) {
			// Permissao de visualizar
			boolean hasViewPermission = permissionChecker.hasPermission(
					groupId, Cliente.class.getName(), cliente.getClienteId(),
					ActionKeys.VIEW);
			if (hasViewPermission) {
				retorno.add(cliente);
			}
		}
		
		return retorno;
	}

	public static ClienteLimCredito getClienteLimCredito(long clienteId)
			throws PortalException, SystemException {
		return ClienteLimCreditoLocalServiceUtil.fetchByClienteLimCredito(clienteId);
	}
}
