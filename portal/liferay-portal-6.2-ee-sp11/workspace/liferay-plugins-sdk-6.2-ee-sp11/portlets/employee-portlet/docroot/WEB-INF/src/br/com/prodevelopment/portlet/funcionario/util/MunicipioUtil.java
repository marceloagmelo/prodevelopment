package br.com.prodevelopment.portlet.funcionario.util;

import java.util.List;

import br.com.prodevelopment.municipio.model.Municipio;
import br.com.prodevelopment.municipio.service.MunicipioLocalServiceUtil;
import br.com.prodevelopment.portlet.funcionario.Constantes;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class MunicipioUtil {

	public static List<Municipio> listarMunicipios(String uf) throws SystemException {
		return MunicipioLocalServiceUtil.search(uf);
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

