package br.com.elmaragon.busca.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.com.elmaragon.busca.resultado.Constantes;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;

public class URLUtil {

	public static List<String> getURLsById(String idConteudo, ThemeDisplay themeDisplay) throws PortalException, SystemException {


		// Recuperar páginas relacionadas com o conteúdo
		List<String> listaPaginas = null;
		Layout layout = themeDisplay.getLayout();

		List<Long> hitLayoutIds = JournalContentSearchLocalServiceUtil
				.getLayoutIds(layout.getGroupId(), layout.isPrivateLayout(),
						idConteudo);

		if (hitLayoutIds.size() > 0) {
			listaPaginas = new ArrayList<String>(hitLayoutIds.size());
		}

		for (int j = 0; j < hitLayoutIds.size(); j++) {
			Long hitLayoutId = (Long) hitLayoutIds.get(j);

			Layout hitLayout = null;

			try {
				hitLayout = LayoutLocalServiceUtil.getLayout(
						layout.getGroupId(), layout.isPrivateLayout(),
						hitLayoutId.longValue());
			} catch (Exception e) {
				System.out.println("Erro ao recuperar pagina associada ao conteudo");
				continue;
			}

			String hitLayoutURL = PortalUtil.getLayoutFullURL(hitLayout,
					themeDisplay);
			String url = StringUtil.shorten(hitLayoutURL, 100);

			listaPaginas.add(url);
		}

		return listaPaginas;
	}

	public static String parseToIframe(String url, HttpServletRequest httpReq) {

		if(url == null || url.isEmpty()) {
			return "";
		}

		String idFilme = getMovieId(url);

		StringBuilder sb = new StringBuilder();
		sb.append(Constantes.PREFIX_IFRAME);
		sb.append(idFilme);
		sb.append(Constantes.SUFIX_IFRAME);

		url = sb.toString();

		url = url.replace(Constantes.TIPO_URL, Constantes.URL_FLASH);

		return url;
	}

	public static String parseToTumb(String url)
	{
		String idFilme = getMovieId(url);

		StringBuilder sb = new StringBuilder();
		sb.append(Constantes.PREFIX_TUMB);
		sb.append(idFilme);
		sb.append(Constantes.SUFIX_TUMB);

		if(url == null || url.isEmpty()) {
			return "";
		}


		return sb.toString();
	}

	private static String getMovieId(String url)
	{
		if(url == null || url.isEmpty()) {
			return "";
		}

		String idFilme = "";
		try {
			URL urls = new URL(url);
			Map<String, String> params = getQueryMap( urls.getQuery());
			idFilme = params.get("v");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return idFilme;
	}

	private static Map<String, String> getQueryMap(String query)
	{
	    String[] params = query.split("&");
	    Map<String, String> map = new HashMap<String, String>();
	    for (String param : params)
	    {
	        String name = param.split("=")[0];
	        String value = param.split("=")[1];
	        map.put(name, value);
	    }
	    return map;
	}
}
