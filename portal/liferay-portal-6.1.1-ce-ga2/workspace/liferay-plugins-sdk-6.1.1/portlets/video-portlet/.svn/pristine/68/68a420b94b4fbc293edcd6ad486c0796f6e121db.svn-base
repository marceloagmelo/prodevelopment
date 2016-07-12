package br.com.prodevelopment.video.destaque.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.video.destaque.Constantes;
import br.com.prodevelopment.video.util.Search;
import br.com.prodevelopment.video.vo.VideoVO;

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

		String filtro = ParamUtil.getString(renderRequest, Constantes.FILTRO);
		String urlDestino = ParamUtil.getString(renderRequest,
				Constantes.URL_DESTINO);

		// pegando da ordenacao dos videos que foram marcados e serao guardados
		// na preferencia
		// detalhe: String ids ja esta na ordem
		String[] ids = null;
		if (!Constantes.SIM.equals(filtro)) {
			// videos escolhidos para apresentacao
			ids = preferences.getValues(Constantes.ID_VIDEOS, new String[0]);
		}
		if (ids != null && ids.length == 1) {
			ids = StringUtil.split(ids[0]);
		}

		List<VideoVO> videos = null;
		List<VideoVO> meusVideos = null;

		Search busca = new Search();

		String idsCategorias = ParamUtil.getString(renderRequest,
				"assetCategoryIds");
		String curTags = ParamUtil.getString(renderRequest, "assetTagNames");

		String passei = ParamUtil.getString(renderRequest, "passei");

		if (passei == null || passei.isEmpty()) {
			passei = Constantes.SIM;

			idsCategorias = preferences.getValue(
					Constantes.FILTRO_CATEGORIAS_IDS, "");
			curTags = preferences.getValue(Constantes.FILTRO_TAGS_NAMES, "");
			urlDestino = preferences.getValue(Constantes.URL_DESTINO, "");

		} else {

			preferences.setValue(Constantes.FILTRO_CATEGORIAS_IDS,
					idsCategorias);
			preferences.setValue(Constantes.FILTRO_TAGS_NAMES, curTags);
			preferences.setValue(Constantes.URL_DESTINO, urlDestino);

			preferences.store();

		}

		if (curTags == null || curTags.isEmpty()) {
			curTags = preferences.getValue(Constantes.FILTRO_TAGS_NAMES, "");
		} else {
			preferences.setValue(Constantes.FILTRO_TAGS_NAMES, curTags);
			preferences.store();
		}

		int pagina = getPage(httpReq);
		int inicio = (pagina * Constantes.TOTAL_POR_PAGINA)
				- Constantes.TOTAL_POR_PAGINA;
		int fim = inicio + Constantes.TOTAL_POR_PAGINA;
		int totalVideos = 0;

		// ordenacao
		String ordenacao = httpReq.getParameter("orderByColumn");
		String videosOrdemFromRequest = renderRequest.getParameter("ordem");

		try {

			videos = busca.buscarVideos(null,
					idsCategorias, ordenacao, curTags, inicio, fim,
					renderRequest);

			if (Validator.isNotNull(videosOrdemFromRequest)) {
				ids = videosOrdemFromRequest.split(",");
			}

			meusVideos = busca.buscarVideosById(ids, renderRequest, true);

			// ordenando a lista
			meusVideos = ordenarList(meusVideos, ids);

			totalVideos = busca.getTotalVideos();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// contando qts estao cadastrados para visualizacao
		int count = meusVideos.size();

		StringBuilder sbIds = new StringBuilder();

		if (Validator.isNotNull(ids)) {
			for (String id : ids) {
				sbIds.append(id + " ");
			}

		}

		renderRequest.setAttribute("count", count);
		renderRequest.setAttribute("passei", passei);
		renderRequest.setAttribute("total", totalVideos);
		renderRequest.setAttribute("page", getPage(httpReq));
		renderRequest.setAttribute("pageSize", Constantes.TOTAL_POR_PAGINA);
		renderRequest.setAttribute("videos", videos);
		renderRequest.setAttribute("meusVideos", meusVideos);
		renderRequest.setAttribute("meusVideosId", ids);
		renderRequest.setAttribute("meusVideosIdString", sbIds.toString());
		renderRequest.setAttribute("curTags", curTags);
		renderRequest.setAttribute("curCategoryIds", idsCategorias);
		renderRequest.setAttribute("urlDestino", urlDestino);

		return "/html/videodestaque/config.jsp";
	}

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);

		PortletPermissionUtil.check(themeDisplay.getPermissionChecker(),
				themeDisplay.getLayout(), portletResource,
				ActionKeys.CONFIGURATION);

		// pegando da ordenacao dos videos que foram marcados e serao guardados
		// na preferencia
		// detalhe: String ids ja esta na ordem
		String[] ids = actionRequest.getParameterValues("layoutIdsBox");

		portletPreferences.setValues(Constantes.ID_VIDEOS, ids);
		portletPreferences.setValue(Constantes.URL_DESTINO,
				actionRequest.getParameter("urlDestino"));

		if (SessionErrors.isEmpty(actionRequest)) {
			portletPreferences.store();

			SessionMessages.add(actionRequest, portletConfig.getPortletName()
					+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
					portletResource);

			SessionMessages.add(actionRequest, portletConfig.getPortletName()
					+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

	private List<VideoVO> ordenarList(List<VideoVO> lista, String[] ids) {

		List<VideoVO> temp = new ArrayList<VideoVO>();

		if (ids != null) {
			for (String id : ids) {
				for (VideoVO video : lista) {
					if (video.getIdVideo().equals(id)) {
						temp.add(video);
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
