package br.com.prodevelopment.banner.lista.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.banner.lista.Constantes;
import br.com.prodevelopment.banner.util.Search;
import br.com.prodevelopment.banner.vo.BannerVO;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.NavItem;
import com.liferay.portal.theme.RequestVars;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ListaBannerPortlet
 */
public class ListaBannerPortlet extends MVCPortlet {

	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {

		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);

		super.init();
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		PortletPreferences preferences = request.getPreferences();

		String ids = preferences.getValue(Constantes.IDS_BANNER, "");

		String[] idsArray = preferences.getValues(Constantes.IDS_BANNER, new String[0]);

		// busca todos os banners com aquela(s) categoria escolhida
		List<BannerVO> banners = null;

		try {
			if(Validator.isNotNull(ids) && idsArray.length == 1)
				idsArray = StringUtil.split(ids);

			banners = new Search().buscarBannersById(idsArray, request, false);

			// ordenando a lista
			banners = ordenarList(banners, StringUtil.split(ids));

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("lista", banners);
		request.setAttribute("portletId", PortalUtil.getPortletId(request));

		//--------------------- menu topo ---------------------------------
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
					WebKeys.THEME_DISPLAY);

			List<Layout> paginas = getPagesFromGuest(themeDisplay);
			List<Layout> layouts = themeDisplay.getLayouts();

			Layout layout = themeDisplay.getLayout();

			Layout primeiro = this.getPrimeiroLayouts(themeDisplay, paginas);

			if (primeiro != null) {
				HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));


				RequestVars requestVars = new RequestVars(
						httpReq, themeDisplay, primeiro.getAncestorPlid(),
						primeiro.getAncestorLayoutId(), null);


				List<NavItem> navItems = NavItem.fromLayouts(
					requestVars, paginas);

				primeiro = null;
			}
		}
		catch (Exception e) {
			e.getMessage();
		}




		if (banners != null && !banners.isEmpty()) {
			super.render(request, response);

		} else {
			SessionMessages.add(request, "mensagem.portletNaoConfigurado");
			include(naoConfiguradoJSP, request, response);
		}

	}


	private List<BannerVO> ordenarList(List<BannerVO> lista, String[] ids) {

		List<BannerVO> temp = new ArrayList<BannerVO>();

		for(String id:ids) {
			for(BannerVO banner:lista) {
				if(banner.getIdBanner().equals(id)) {
					temp.add(banner);
				}
			}
		}

		return temp;
	}



	private List<Layout> getPagesFromGuest(ThemeDisplay themeDisplay) throws SystemException, PortalException{

		long companyId = themeDisplay.getCompanyId();
		String friendlyURL = "/guest";

		Group guest = GroupLocalServiceUtil.getFriendlyURLGroup(companyId, friendlyURL);


		// buscando todas a paginas da guest debaixo de home
		List<Layout> paginas = LayoutLocalServiceUtil.getLayouts(guest.getGroupId(),
				false, 0);

		return paginas;
	}

	private Layout getPrimeiroLayouts(ThemeDisplay themeDisplay, List<Layout> paginas) throws SystemException, PortalException {

		// pegando o primeiro
		Layout layout = null;

		for(Layout l:paginas) {
			layout = l;
			break;
		}

		return layout;
	}

}
