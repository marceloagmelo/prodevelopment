package br.com.prodevelopment.portlet.organizacao.util;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.service.AddressServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;

public class OrganizacaoUtil {
	
	public static List<Organization> listaSite(long companyId) throws SystemException, PortalException {
		return  OrganizationLocalServiceUtil.getOrganizations(companyId, 0, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/*
	public static List<Organization> listaSite(long companyId) throws SystemException, PortalException {
		List<Organization> listaOrganizacao = null;
		List<Group> listaSite = new ArrayList<Group>();
		
		listaOrganizacao = OrganizationLocalServiceUtil.getOrganizations(companyId, 0, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Organization org : listaOrganizacao) {
			Group site = GroupLocalServiceUtil.getGroup(org.getGroupId());
			site.setName(org.getName());
			listaSite.add(site);
			List<Address> listaEnderecos = org.getAddresses();
			List<Phone> lst = listaTelefones(companyId, org.getOrganizationId());
		}
		
		return listaOrganizacao;
	}
	*/
	
	public static List<Address> listaEnderecos(long groupId) throws SystemException, PortalException {
		List<Address> lista = AddressServiceUtil.getAddresses(Organization.class.getName(), groupId);
		for (Address endereco : lista) {
			if (endereco.getPrimary()) {
				System.out.println(endereco.getStreet1());
				System.out.println(endereco.getStreet2());
				System.out.println(endereco.getCity());
			}
		}
		return lista;
	}

	
	public static List<Phone> listaTelefones(long companyId, long groupId) throws SystemException, PortalException {
		List<Phone> lista = PhoneLocalServiceUtil.getPhones(companyId, Organization.class.getName(), groupId);
		for (Phone telefone : lista) {
			if (telefone.getPrimary()) {
				System.out.println(telefone.getNumber());
			}
		}
		return lista;
	}
}
