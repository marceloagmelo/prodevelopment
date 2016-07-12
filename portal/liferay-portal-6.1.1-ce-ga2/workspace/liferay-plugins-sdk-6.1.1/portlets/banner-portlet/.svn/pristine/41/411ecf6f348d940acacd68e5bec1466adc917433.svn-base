package br.com.prodevelopment.banner.rotativo.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.banner.rotativo.Constantes;
import br.com.prodevelopment.banner.util.Search;
import br.com.prodevelopment.banner.vo.BannerVO;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(renderRequest));

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletResource);

		String intervalo = preferences.getValue(Constantes.INTERVALO, Constantes.VALOR_INTERVALO_PADRAO);
		String duracao = preferences.getValue(Constantes.DURACAO, Constantes.DURACAO_NORMAL);
		String exibirTitulo = preferences.getValue(Constantes.EXIBIR_TITULO,"");
		String exibirControles = preferences.getValue(Constantes.EXIBIR_CONTROLES,"");

		duracao = duracao==null?Constantes.DURACAO_NORMAL:duracao;
		intervalo = intervalo==null?Constantes.VALOR_INTERVALO_PADRAO:intervalo;

		String filtro = ParamUtil.getString(renderRequest, Constantes.FILTRO);

		//pegando da ordenacao dos videos que foram marcados e serao guardados na preferencia
		//detalhe: String ids ja esta na ordem
		String[] ids = null;
		if(!Constantes.SIM.equals(filtro)) {
			//videos escolhidos para apresentacao
			ids = preferences.getValues(Constantes.IDS_BANNER, new String[0]);
		}
		if(ids!=null && ids.length == 1)
		{
			ids =StringUtil.split( ids[0]);
		}

		if(Validator.isNotNull(ids) && ids.length == 1)
		{
			ids =StringUtil.split( ids[0]);
		}

		List<BannerVO> banners = null;
		List<BannerVO> meusBanners = null;

		Search busca = new Search();

		String idsCategorias = ParamUtil.getString(renderRequest, "assetCategoryIds");
		String curTags = ParamUtil.getString(renderRequest, "assetTagNames");
		String passei =  ParamUtil.getString(renderRequest, "passei");

		if(passei == null || passei.isEmpty()) {
			passei = Constantes.SIM;

			idsCategorias = preferences.getValue(Constantes.FILTRO_CATEGORIAS_IDS, "");
			curTags = preferences.getValue(Constantes.FILTRO_TAGS_NAMES, "");

		} else {

			preferences.setValue(Constantes.FILTRO_CATEGORIAS_IDS, idsCategorias);
			preferences.setValue(Constantes.FILTRO_TAGS_NAMES, curTags);

			preferences.store();

		}

		if(curTags == null || curTags.isEmpty()) {
			curTags = preferences.getValue(Constantes.FILTRO_TAGS_NAMES, "");
		} else {
			preferences.setValue(Constantes.FILTRO_TAGS_NAMES, curTags);
			preferences.store();
		}

		int pagina = getPage(httpReq);
		int inicio = (pagina * Constantes.TOTAL_POR_PAGINA)	- Constantes.TOTAL_POR_PAGINA;
		int fim = inicio + Constantes.TOTAL_POR_PAGINA;
		int totalBanners = 0;

		//ordenacao
		String ordenacao = httpReq.getParameter("orderByColumn");
		String bannersOrdemFromRequest = renderRequest.getParameter("ordem");

		try {
			banners = busca.buscarBanners(null, idsCategorias, ordenacao,
					curTags, inicio, fim, renderRequest);

			totalBanners = busca.getTotalBanners();

			if(Validator.isNotNull(bannersOrdemFromRequest))
			{
				ids = bannersOrdemFromRequest.split(",");
			}

			meusBanners = busca.buscarBannersById(ids, renderRequest, true);
			//ordenando a lista
			meusBanners = ordenarList(meusBanners, ids);

		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuilder sbIds = new StringBuilder();

		if(Validator.isNotNull(ids))
		{
			for(String id : ids)
			{
				sbIds.append(id + " ");
			}

		}


		renderRequest.setAttribute("passei", passei);
		renderRequest.setAttribute("total", totalBanners);
		renderRequest.setAttribute("page", getPage(httpReq));
		renderRequest.setAttribute("pageSize", Constantes.TOTAL_POR_PAGINA);
		renderRequest.setAttribute("banners", banners);
		renderRequest.setAttribute("meusBanners", meusBanners);
		renderRequest.setAttribute("meusBannersId", ids);
		renderRequest.setAttribute("meusBannersIdString", sbIds.toString());
		renderRequest.setAttribute("curTags", curTags);
		renderRequest.setAttribute("curCategoryIds", idsCategorias);
		renderRequest.setAttribute("intervalo", intervalo);
		renderRequest.setAttribute("tipoBanner", preferences.getValue(Constantes.TIPO_BANNER,Constantes.TIPO_BANNER_PEQUENO_1));
		renderRequest.setAttribute("duracao", duracao);
		renderRequest.setAttribute("exibirTitulo", exibirTitulo != null?"checked":"");
		renderRequest.setAttribute("exibirControles", exibirControles != null?"checked":"");
		renderRequest.setAttribute("bannersOrdemFromRequest", bannersOrdemFromRequest);


		return "/html/bannerrotativo/config.jsp";
	}

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(
				themeDisplay.getPermissionChecker(), themeDisplay.getLayout(),
				portletResource, ActionKeys.CONFIGURATION);


		//pegando da ordenacao dos banners que foram marcados e serao guardados na preferencia
		//detalhe: String ids ja esta na ordem
		String[] ids = actionRequest.getParameterValues("layoutIdsBox");

		portletPreferences.setValue(Constantes.INTERVALO, actionRequest.getParameter("intervalo"));
		portletPreferences.setValue(Constantes.DURACAO, actionRequest.getParameter("duracao"));
		portletPreferences.setValue(Constantes.TIPO_BANNER, actionRequest.getParameter("tipoBanner"));
		portletPreferences.setValue(Constantes.EXIBIR_TITULO, actionRequest.getParameter("exibirTitulo"));
		portletPreferences.setValue(Constantes.EXIBIR_CONTROLES, actionRequest.getParameter("exibirControles"));
		portletPreferences.setValues(Constantes.IDS_BANNER, ids);

		if (SessionErrors.isEmpty(actionRequest)) {
			portletPreferences.store();

			SessionMessages.add(
				actionRequest,
				portletConfig.getPortletName() +
					SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
				portletResource);

			SessionMessages.add(
				actionRequest,
				portletConfig.getPortletName() +
					SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
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

	private int getPage(HttpServletRequest httpReq) {
		int page = 1;

		if (httpReq.getParameter("page") != null
				&& !"".equals(httpReq.getParameter("page"))) {
			page = Integer.valueOf(httpReq.getParameter("page"));
		}

		return page;
	}
}
