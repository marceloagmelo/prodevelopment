package br.com.prodevelopment.portlet.cliente.util;

import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.contato.model.Contato;
import br.com.prodevelopment.contato.model.Endereco;
import br.com.prodevelopment.contato.service.EnderecoLocalServiceUtil;
import br.com.prodevelopment.portlet.cliente.Constantes;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class EnderecoUtil {

	public static Endereco getEndereco(long enderecoId) throws SystemException {
		return EnderecoLocalServiceUtil.fetchEndereco(enderecoId);
	}

	public static Endereco getEndereco(HttpServletRequest request)
			throws PortalException, SystemException {

		long enderecoId = ParamUtil.getLong(request, Constantes.ENDERECO_ID);

		Endereco endereco = null;
		if (enderecoId > 0) {
			endereco = EnderecoLocalServiceUtil.getEndereco(enderecoId);
		}

		request.setAttribute(Constantes.ENDERECO, endereco);
		request.setAttribute(Constantes.ENDERECO_ID, enderecoId);

		return endereco;
	}

	public static Endereco getEndereco(PortletRequest portletRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(portletRequest);

		return getEndereco(request);
	}

	public static Endereco getEndereco(ActionRequest actionRequest)
			throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		return getEndereco(request);
	}

	public static Endereco getEndereco() throws SystemException {
		return EnderecoLocalServiceUtil.createEndereco();
	}

	public static List<Endereco> getEnderecos(long companyId, long classPK)
			throws SystemException {
		return EnderecoLocalServiceUtil.getEnderecos(companyId,
				Contato.class.getName(), classPK);
	}

	public static List<Endereco> getEnderecos(ActionRequest actionRequest) {
		return getEnderecos(actionRequest, Collections.<Endereco> emptyList());
	}

	public static List<Endereco> getEnderecos(ActionRequest actionRequest,
			List<Endereco> defaultEnderecos) {

		return null;

		/*
		String enderecosIndexesString = actionRequest
				.getParameter("enderecosIndexes");

		if (enderecosIndexesString == null) {
			return defaultEnderecos;
		}

		List<Endereco> enderecos = new ArrayList<Endereco>();

		int[] enderecosIndexes = StringUtil.split(enderecosIndexesString, 0);

		int principal = ParamUtil.getInteger(actionRequest,
				Constantes.CAMPO_ENDERECO_PRINCIPAL);

		for (int enderecosIndex : enderecosIndexes) {
			long enderecoId = ParamUtil.getLong(actionRequest,
					Constantes.ENDERECO_ID + enderecosIndex);

			int tipo = ParamUtil.getInteger(actionRequest,
					Constantes.CAMPO_TIPO_ENDERECO + enderecosIndex);
			String logradouro = ParamUtil.getString(actionRequest,
					Constantes.CAMPO_LOGRADOURO + enderecosIndex);
			String numero = ParamUtil.getString(actionRequest,
					Constantes.CAMPO_NUMERO_ENDERECO + enderecosIndex);
			String complemento = ParamUtil.getString(actionRequest,
					Constantes.CAMPO_COMPLEMENTO + enderecosIndex);
			String cep = ParamUtil.getString(actionRequest,
					Constantes.CAMPO_CEP + enderecosIndex);
			String bairro = ParamUtil.getString(actionRequest,
					Constantes.CAMPO_BAIRRO + enderecosIndex);
			long cidadeId = ParamUtil.getLong(actionRequest,
					Constantes.CAMPO_CIDADE_ID + enderecosIndex);
			String uf = ParamUtil.getString(actionRequest,
					Constantes.CAMPO_UF + enderecosIndex);
			long paisId = ParamUtil.getLong(actionRequest,
					Constantes.CAMPO_PAIS_ID + enderecosIndex);
			

			if (tipo == 0) {
				continue;
			}

			boolean bPrincipal = false;

			if (enderecosIndex == principal) {
				bPrincipal = true;
			}

			Endereco endereco = EnderecoLocalServiceUtil
					.createEndereco(enderecoId);

			endereco.setTipo(tipo);
			endereco.setPrincipal(bPrincipal);
			endereco.setLogradouro(logradouro);
			endereco.setNumero(numero);
			endereco.setComplemento(complemento);
			endereco.setCep(cep);
			endereco.setBairro(bairro);
			endereco.setCidadeId(cidadeId);
			endereco.setUf(uf);
			endereco.setPaisId(paisId);

			enderecos.add(endereco);
		}

		return enderecos;
	*/
	}
}
