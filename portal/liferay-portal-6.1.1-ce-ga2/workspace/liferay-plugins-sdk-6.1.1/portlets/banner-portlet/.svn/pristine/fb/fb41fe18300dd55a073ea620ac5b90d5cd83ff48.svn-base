package br.com.prodevelopment.banner.rotativo.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.banner.rotativo.Constantes;
import br.com.prodevelopment.banner.util.Search;
import br.com.prodevelopment.banner.vo.BannerVO;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BannerRotativoPortlet
 */
public class BannerRotativoPortlet extends MVCPortlet {
	protected String naoConfiguradoJSP;
	protected String viewGrande2JSP;
	protected String viewGrande3JSP;

	@Override
	public void init() throws PortletException {


		Constantes.VALOR_INTERVALO_PADRAO = getInitParameter(Constantes.INTERVALO_DEFAULT);

		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);
		viewGrande2JSP = getInitParameter(Constantes.JSP_VIEW_GRANDE2);
		viewGrande3JSP = getInitParameter(Constantes.JSP_VIEW_GRANDE3);

		super.init();
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		PortletPreferences preferences = request.getPreferences();

		String intervalo = preferences.getValue(Constantes.INTERVALO,
				Constantes.VALOR_INTERVALO_PADRAO);
		String duracao = preferences.getValue(Constantes.DURACAO,
				Constantes.DURACAO_NORMAL);
		String ids = preferences.getValue(Constantes.IDS_BANNER, "");

		String[] idsArray = preferences.getValues(Constantes.IDS_BANNER, new String[0]);

		String exibirTitulo = preferences.getValue(Constantes.EXIBIR_TITULO, "false");
		String exibirControles= preferences.getValue(Constantes.EXIBIR_CONTROLES, "false");

		// busca todos os banners com aquela(s) categoria escolhida
		List<BannerVO> banners = null;

		try {
			if(Validator.isNotNull(ids) && idsArray.length == 1)
				idsArray = StringUtil.split(ids);

			banners = new Search().buscarBannersById(idsArray, request, false);

			// ordenando a lista
			banners = ordenarList(banners, idsArray);

		} catch (Exception e) {
			e.printStackTrace();
		}

		duracao = duracao == null ? Constantes.DURACAO_NORMAL : duracao;
		intervalo = intervalo == null ? Constantes.VALOR_INTERVALO_PADRAO
				: intervalo;

		request.setAttribute("intervalo", intervalo);
		request.setAttribute("duracao", duracao);
		request.setAttribute("lista", banners);
		request.setAttribute("exibirTitulo", exibirTitulo != null ? "true" : "false");
		request.setAttribute("exibirControles", exibirControles != null ? "true" : "false");
		request.setAttribute("portletId", PortalUtil.getPortletId(request));

		String tipoBanner = preferences.getValue(Constantes.TIPO_BANNER, Constantes.TIPO_BANNER_PEQUENO_1);

		if (banners != null && !banners.isEmpty()) {
			if(tipoBanner.equals(Constantes.TIPO_BANNER_GRANDE_1)) {
				request.setAttribute("widthBanner", Constantes.WIDTH_BANNER_GRANDE_1);
				request.setAttribute("heightBanner", Constantes.HEIGHT_BANNER_GRANDE_1);
				include(viewTemplate, request, response);
			} else if(tipoBanner.equals(Constantes.TIPO_BANNER_GRANDE_2)) {
				request.setAttribute("widthBanner", Constantes.WIDTH_BANNER_GRANDE_2);
				request.setAttribute("heightBanner", Constantes.HEIGHT_BANNER_GRANDE_2);
				include(viewGrande2JSP, request, response);
			} else if(tipoBanner.equals(Constantes.TIPO_BANNER_GRANDE_3)) {
				request.setAttribute("widthBanner", Constantes.WIDTH_BANNER_GRANDE_1);
				request.setAttribute("heightBanner", Constantes.HEIGHT_BANNER_GRANDE_1);
				include(viewGrande3JSP, request, response);
			} else {
				request.setAttribute("widthBanner", Constantes.WIDTH_BANNER_PEQUENO);
				request.setAttribute("heightBanner", Constantes.HEIGHT_BANNER_PEQUENO);
				include(viewTemplate, request, response);
			}

			//super.render(request, response);

		} else {
			SessionMessages.add(request, "mensagem.portletNaoConfigurado");
			include(naoConfiguradoJSP, request, response);
		}

	}


	private List<BannerVO> ordenarList(List<BannerVO> lista, String[] ids) {

		List<BannerVO> temp = new ArrayList<BannerVO>();

		if (ids != null) {
			for(String id:ids) {
				for(BannerVO banner:lista) {
					if(banner.getIdBanner().equals(id)) {
						temp.add(banner);
					}
				}
			}
		}

		return temp;
	}


}
