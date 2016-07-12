package br.com.prodevelopment.ultimasnoticiasrss.util;

import java.net.URL;
import java.util.Iterator;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class Helper {

	public static String trataTextoLongo(String texto, int tamanho) {
		if (texto == null)
			texto = "";
		if (texto.length() > tamanho) {
			texto = texto.substring(0, tamanho);
			texto = texto + "...";
		}
		return texto;
	}

	public static Iterator<SyndEntry> getNoticias(String urlNoticias) {
		Iterator<SyndEntry> ite = null;
		XmlReader reader = null;

		try {
			URL url = new URL(urlNoticias); // arquivo responsavel pela origem da noticia.

			reader = new XmlReader(url);
			SyndFeed feed = new SyndFeedInput().build(reader);
			ite = feed.getEntries().iterator();
		} catch (Exception e) {

		}

		return ite;
	}
}