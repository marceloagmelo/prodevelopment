package br.com.prodevelopment.portlet.importregion.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import br.com.prodevelopment.portlet.importregion.Constantes;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Country;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ImportRegionUtil {

	public static Map<String, String> getCoutries(ThemeDisplay themeDisplay) throws SystemException {
		List<Country> lista = CountryServiceUtil.getCountries();
		Map<String, String> mapIndexado = new TreeMap<String, String>();
		if (Validator.isNotNull(lista)) {
			for (Country country : lista) {
				mapIndexado.put(country.getName(themeDisplay.getLocale()),
						String.valueOf(country.getPrimaryKey()));
			}

		}

		return mapIndexado;
	}

	public static void importar(ActionRequest request, ActionResponse response)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PrincipalThreadLocal.setName(themeDisplay.getUserId());
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil
				.create(UserLocalServiceUtil.getUser(themeDisplay.getUserId()));
		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		// Recupera os objetos de request
		UploadPortletRequest upLoadRequest = PortalUtil
				.getUploadPortletRequest(request);
		File arquivo = upLoadRequest.getFile(Constantes.ARQUIVO);
		String path = arquivo.getPath();
		String pais = (String) upLoadRequest.getParameter(Constantes.PAIS);
		long countryId = GetterUtil.getLong(pais, 0);

		// Preparar a leitura do arquivo
		FileInputStream stream = new FileInputStream(path);
		InputStreamReader streamReader = new InputStreamReader(stream,
				Constantes.ENCODING);
		BufferedReader reader = new BufferedReader(streamReader);

		// Neste while lemos o arquivo linha a linha
		String linha = null;
		int contadorRegistro = 0;
		while ((linha = reader.readLine()) != null) {
			String[] arrayEstados = linha.split(StringPool.SEMICOLON);
			String regionCode = arrayEstados[1];
			String name = Helper.retiraAcentos(arrayEstados[0]);

			RegionServiceUtil.addRegion(countryId, regionCode, name, true);

			contadorRegistro++;
		}
		// fechando os objetos de io:
		reader.close();
		streamReader.close();
		stream.close();
	}
}
