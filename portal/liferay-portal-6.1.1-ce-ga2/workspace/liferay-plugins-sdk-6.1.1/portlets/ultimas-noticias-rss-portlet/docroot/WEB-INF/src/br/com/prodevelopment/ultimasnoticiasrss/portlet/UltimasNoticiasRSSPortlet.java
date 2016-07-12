package br.com.prodevelopment.ultimasnoticiasrss.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.ultimasnoticiasrss.Constantes;
import br.com.prodevelopment.ultimasnoticiasrss.util.Helper;
import br.com.prodevelopment.ultimasnoticiasrss.vo.NoticiaVO;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.syndication.feed.synd.SyndEntry;

/**
 * Portlet implementation class UltimasNoticiasRSSPortlet
 */
public class UltimasNoticiasRSSPortlet extends MVCPortlet {
	protected String naoConfiguradoJSP;
	protected String viewSingleJSP;
	protected Map<String, List<String>> mapServico;

	@Override
	public void init() throws PortletException {

		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);

		super.init();
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		try {
            // Recuperar preferências do portlet
            String prefConfigurado = request.getPreferences().getValue(Constantes.PREF_CONFIGURADO, Constantes.N);

            if (Constantes.S.equals(prefConfigurado)) {

    			// Montar mapa de serviços
    			montarMapaServicos(request);

    			// Recuperar da preferencias do portlet o serviço
    			String prefServico = request.getPreferences().getValue(Constantes.PREF_SERVICO,
    					Constantes.VAZIO);

    			// Ler as urls dos seviços
    			List<String> lista = (List<String>)mapServico.get(prefServico);

    			for (int i=1; i<=lista.size(); i++) {
    				if (i==1) {
    					// Recuperar a url
    					String url = request.getPreferences().getValue((String)lista.get(i-1), Constantes.VAZIO);
    					if (Validator.isNotNull(url)) {
        					// Últimas Notícias
        					ultimasNoticias(request, url);
    						request.setAttribute(Constantes.TEM_ULTIMAS_NOTICIAS, Constantes.S);
    					}
    					else {
    		                SessionMessages.add(request, "mensagem.erro.urlVazia");
    					}
    				}
    				else if (i==2) {
    					// Recuperar a url
    					String url = request.getPreferences().getValue((String)lista.get(i-1), Constantes.VAZIO);
    					if (Validator.isNotNull(url)) {
        					// Notícias Internacional
        					noticiasInternacional(request, url);
    						request.setAttribute(Constantes.TEM_NOTICIA_INTERNACIONAL, Constantes.S);
    					}
    				}
    				else if (i==3) {
    					// Recuperar a url
    					String url = request.getPreferences().getValue((String)lista.get(i-1), Constantes.VAZIO);
    					if (Validator.isNotNull(url)) {
        					// Notícias Negócio
        					noticiasNegocio(request, url);
        					request.setAttribute(Constantes.TEM_NOTICIA_NEGOCIO, Constantes.S);
    					}
    				}
    				else if (i==4) {
    					// Recuperar a url
    					String url = request.getPreferences().getValue((String)lista.get(i-1), Constantes.VAZIO);
    					if (Validator.isNotNull(url)) {
        					// Notícias Saúde
        					noticiasSaude(request, url);
        					request.setAttribute(Constantes.TEM_NOTICIA_SAUDE, Constantes.S);
    					}
    				}
    				else if (i==5) {
    					// Recuperar a url
    					String url = request.getPreferences().getValue((String)lista.get(i-1), Constantes.VAZIO);
    					if (Validator.isNotNull(url)) {
        					// Notícias Esporte
        					noticiasEsporte(request, url);
        					request.setAttribute(Constantes.TEM_NOTICIA_ESPORTE, Constantes.S);
    					}
    				}
    			}
    			include(viewTemplate, request, response);
            } else {
                SessionMessages.add(request,
                        "mensagem.portletNaoConfigurado");
                include(naoConfiguradoJSP, request, response);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ultimasNoticias(RenderRequest request, String url) {

		int contador = 0;

		List<NoticiaVO> ultimasNoticias_1 = null;
		List<NoticiaVO> ultimasNoticias_2 = null;

		Iterator<SyndEntry> iteUltimasNoticias = Helper.getNoticias(url);

		while(iteUltimasNoticias.hasNext()){

			SyndEntry item = (SyndEntry) iteUltimasNoticias.next();

			contador++;
			if (contador == 1) {
				ultimasNoticias_1 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 6) {
				ultimasNoticias_2 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 11) {
				break;
			}
			//
			NoticiaVO noticiaVO = new NoticiaVO();
			noticiaVO.setDescricao(Helper.trataTextoLongo(
					item.getDescription().toString(),
					GetterUtil.getInteger(Constantes.DEFAULT_TAMAMHO_CARACTERES)));
			noticiaVO.setTitulo(item.getTitle().toString());
			noticiaVO.setLink(item.getLink().toString());

			if ((contador >= 1) && (contador <=5)) {
				ultimasNoticias_1.add(noticiaVO);
			}
			else {
				ultimasNoticias_2.add(noticiaVO);
			}
		}

		request.setAttribute("ultimasNoticias_1", ultimasNoticias_1);
		request.setAttribute("ultimasNoticias_2", ultimasNoticias_2);
	}

	private void noticiasInternacional(RenderRequest request, String url) {

		int contador = 0;

		List<NoticiaVO> noticiasInternacional_1 = null;
		List<NoticiaVO> noticiasInternacional_2 = null;

		Iterator<SyndEntry> iteNoticiasInternacional = Helper.getNoticias(url);

		while(iteNoticiasInternacional.hasNext()){

			SyndEntry item = (SyndEntry) iteNoticiasInternacional.next();

			contador++;
			if (contador == 1) {
				noticiasInternacional_1 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 6) {
				noticiasInternacional_2 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 11) {
				break;
			}
			//
			NoticiaVO noticiaVO = new NoticiaVO();
			noticiaVO.setDescricao(Helper.trataTextoLongo(
					item.getDescription().toString(),
					GetterUtil.getInteger(Constantes.DEFAULT_TAMAMHO_CARACTERES)));
			noticiaVO.setTitulo(item.getTitle().toString());
			noticiaVO.setLink(item.getLink().toString());

			if ((contador >= 1) && (contador <=5)) {
				noticiasInternacional_1.add(noticiaVO);
			}
			else {
				noticiasInternacional_2.add(noticiaVO);
			}
		}
		request.setAttribute("noticiasInternacional_1", noticiasInternacional_1);
		request.setAttribute("noticiasInternacional_2", noticiasInternacional_2);
	}

	private void noticiasNegocio(RenderRequest request, String url) {

		int contador = 0;

		List<NoticiaVO> noticiasNegocio_1 = null;
		List<NoticiaVO> noticiasNegocio_2 = null;

		Iterator<SyndEntry> iteNoticiasNegocio = Helper.getNoticias(url);

		while(iteNoticiasNegocio.hasNext()){

			SyndEntry item = (SyndEntry) iteNoticiasNegocio.next();

			contador++;
			if (contador == 1) {
				noticiasNegocio_1 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 6) {
				noticiasNegocio_2 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 11) {
				break;
			}
			//
			NoticiaVO noticiaVO = new NoticiaVO();
			noticiaVO.setDescricao(Helper.trataTextoLongo(
					item.getDescription().toString(),
					GetterUtil.getInteger(Constantes.DEFAULT_TAMAMHO_CARACTERES)));
			noticiaVO.setTitulo(item.getTitle().toString());
			noticiaVO.setLink(item.getLink().toString());

			if ((contador >= 1) && (contador <=5)) {
				noticiasNegocio_1.add(noticiaVO);
			}
			else {
				noticiasNegocio_2.add(noticiaVO);
			}
		}
		request.setAttribute("noticiasNegocio_1", noticiasNegocio_1);
		request.setAttribute("noticiasNegocio_2", noticiasNegocio_2);
	}

	private void noticiasSaude(RenderRequest request, String url) {

		int contador = 0;

		List<NoticiaVO> noticiasSaude_1 = null;
		List<NoticiaVO> noticiasSaude_2 = null;

		Iterator<SyndEntry> iteNoticiasSaude = Helper.getNoticias(url);

		while(iteNoticiasSaude.hasNext()){

			SyndEntry item = (SyndEntry) iteNoticiasSaude.next();

			contador++;
			if (contador == 1) {
				noticiasSaude_1 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 6) {
				noticiasSaude_2 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 11) {
				break;
			}
			//
			NoticiaVO noticiaVO = new NoticiaVO();
			noticiaVO.setDescricao(Helper.trataTextoLongo(
					item.getDescription().toString(),
					GetterUtil.getInteger(Constantes.DEFAULT_TAMAMHO_CARACTERES)));
			noticiaVO.setTitulo(item.getTitle().toString());
			noticiaVO.setLink(item.getLink().toString());

			if ((contador >= 1) && (contador <=5)) {
				noticiasSaude_1.add(noticiaVO);
			}
			else {
				noticiasSaude_2.add(noticiaVO);
			}
		}
		request.setAttribute("noticiasSaude_1", noticiasSaude_1);
		request.setAttribute("noticiasSaude_2", noticiasSaude_2);
	}

	private void noticiasEsporte(RenderRequest request, String url) {

		int contador = 0;

		List<NoticiaVO> noticiasEsporte_1 = null;
		List<NoticiaVO> noticiasEsporte_2 = null;

		Iterator<SyndEntry> iteNoticiasEsporte = Helper.getNoticias(url);

		while(iteNoticiasEsporte.hasNext()){

			SyndEntry item = (SyndEntry) iteNoticiasEsporte.next();

			contador++;
			if (contador == 1) {
				noticiasEsporte_1 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 6) {
				noticiasEsporte_2 = new ArrayList<NoticiaVO>(5);
			}
			else if (contador == 11) {
				break;
			}
			//
			NoticiaVO noticiaVO = new NoticiaVO();
			noticiaVO.setDescricao(Helper.trataTextoLongo(
					item.getDescription().toString(),
					GetterUtil.getInteger(Constantes.DEFAULT_TAMAMHO_CARACTERES)));
			noticiaVO.setTitulo(item.getTitle().toString());
			noticiaVO.setLink(item.getLink().toString());

			if ((contador >= 1) && (contador <=5)) {
				noticiasEsporte_1.add(noticiaVO);
			}
			else {
				noticiasEsporte_2.add(noticiaVO);
			}
		}
		request.setAttribute("noticiasEsporte_1", noticiasEsporte_1);
		request.setAttribute("noticiasEsporte_2", noticiasEsporte_2);
	}

	private void montarMapaServicos(RenderRequest request) {
		mapServico = new LinkedHashMap<String, List<String>>(Constantes.TOTAL_SERVICOS);

		for (int i=1; i<=Constantes.TOTAL_SERVICOS; i++) {
			List<String> lista = new ArrayList<String>(5);
			if (i == Integer.parseInt(Constantes.GOOGLE)) {
				for (String campo : Constantes.CAMPOS_GOOGLE ) {
					lista.add(campo);
				}
			}
			else if (i == Integer.parseInt(Constantes.GLOBO)) {
				for (String campo : Constantes.CAMPOS_GLOBO ) {
					lista.add(campo);
				}
			}
			else if (i == Integer.parseInt(Constantes.UOL)) {
				for (String campo : Constantes.CAMPOS_UOL ) {
					lista.add(campo);
				}
			}
			else if (i == Integer.parseInt(Constantes.TERRA)) {
				for (String campo : Constantes.CAMPOS_TERRA ) {
					lista.add(campo);
				}
			}
			mapServico.put(String.valueOf(i), lista);
		}
	}
}

