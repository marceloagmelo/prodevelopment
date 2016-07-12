package br.com.prodevelopment.video.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.video.rotativo.Constantes;

public class URLUtil {

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
