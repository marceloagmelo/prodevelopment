package br.com.prodevelopment.portlet.cliente.util;

import java.util.List;

import br.com.prodevelopment.municipio.model.Municipio;
import br.com.prodevelopment.municipio.service.MunicipioLocalServiceUtil;
import br.com.prodevelopment.portlet.cliente.Constantes;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;

public class MunicipioUtil {

	public static List<Region> listarUf(String pais) throws SystemException {
		
		List<Region> lista = RegionServiceUtil.getRegions(GetterUtil.getLong(pais));
		
		return lista;
	}

	public static List<Municipio> listarMunicipios(String uf) throws SystemException {
		return MunicipioLocalServiceUtil.search(uf);
	}

	public static JSONArray carregarUfs(List<Region> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (Region region : lista) {
			JSONObject jsonMunicipio = JSONFactoryUtil.createJSONObject();
			jsonMunicipio.put(Constantes.NOME, region.getName());
			jsonMunicipio.put(Constantes.CODIGO, region.getRegionCode());
			jsonArray.put(jsonMunicipio);
		}
		
		return jsonArray;
	}

	public static JSONArray carregarMunicipios(List<Municipio> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (Municipio municipio : lista) {
			JSONObject jsonMunicipio = JSONFactoryUtil.createJSONObject();
			jsonMunicipio.put(Constantes.CIDADE, municipio.getCidade());
			jsonMunicipio.put(Constantes.CODIGO, municipio.getCodigo());
			jsonArray.put(jsonMunicipio);
		}
		
		return jsonArray;
	}

	public static JSONArray carregarDadosCep(List<Municipio> lista) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (Municipio municipio : lista) {
			JSONObject jsonMunicipio = JSONFactoryUtil.createJSONObject();
			jsonMunicipio.put(Constantes.UF, municipio.getUf());
			jsonMunicipio.put(Constantes.LOGRADOURO, municipio.getLogradouro());
			jsonMunicipio.put(Constantes.BAIRRO, municipio.getBairro());
			jsonArray.put(jsonMunicipio);
		}
		
		return jsonArray;
	}
}

