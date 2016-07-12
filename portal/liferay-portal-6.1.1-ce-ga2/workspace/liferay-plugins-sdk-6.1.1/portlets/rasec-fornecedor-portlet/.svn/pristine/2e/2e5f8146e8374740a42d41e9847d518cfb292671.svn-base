package br.com.rasecmadeiras.fornecedor.destaque.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.rasecmadeiras.fornecedor.destaque.Constantes;
import br.com.rasecmadeiras.fornecedor.util.Search;
import br.com.rasecmadeiras.fornecedor.vo.FornecedorVO;

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

		// pegando da ordenacao dos fornecedores que foram marcados e serao
		// guardados na preferencia
		// detalhe: String ids ja esta na ordem
		String[] ids = null;
		if (!Constantes.SIM.equals(filtro)) {
			// fornecedores escolhidos para apresentacao
			ids = preferences.getValues(Constantes.IDS_FORNECEDOR,
					new String[0]);
		}
		if (ids != null && ids.length == 1) {
			ids = StringUtil.split(ids[0]);
		}

		List<FornecedorVO> fornecedores = null;
		List<FornecedorVO> meusFornecedores = null;

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

		int pagina = Search.getPage(httpReq);
		int inicio = (pagina * Constantes.TOTAL_POR_PAGINA)
				- Constantes.TOTAL_POR_PAGINA;
		int fim = inicio + Constantes.TOTAL_POR_PAGINA;
		int totalFornecedores = 0;

		// ordenacao
		String ordenacao = httpReq.getParameter("orderByColumn");
		String fornecedoresOrdemFromRequest = renderRequest
				.getParameter("ordem");

		try {

			fornecedores = busca.buscar(null, idsCategorias, ordenacao,
					curTags, inicio, fim, renderRequest);

			if (Validator.isNotNull(fornecedoresOrdemFromRequest)) {
				ids = fornecedoresOrdemFromRequest.split(",");
			}

			meusFornecedores = busca.buscarById(ids, renderRequest, true);

			// ordenando a lista
			meusFornecedores = ordenarList(meusFornecedores, ids);

			totalFornecedores = busca.getTotalFornecedores();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// contando qts estao cadastrados para visualizacao
		int count = meusFornecedores.size();

		StringBuilder sbIds = new StringBuilder();

		if (Validator.isNotNull(ids)) {
			for (String id : ids) {
				sbIds.append(id + " ");
			}

		}

		renderRequest.setAttribute("count", count);
		renderRequest.setAttribute("passei", passei);
		renderRequest.setAttribute("total", totalFornecedores);
		renderRequest.setAttribute("page", Search.getPage(httpReq));
		renderRequest.setAttribute("pageSize", Constantes.TOTAL_POR_PAGINA);
		renderRequest.setAttribute("fornecedores", fornecedores);
		renderRequest.setAttribute("meusFornecedores", meusFornecedores);
		renderRequest.setAttribute("meusFornecedoresId", ids);
		renderRequest
				.setAttribute("meusFornecedoresIdString", sbIds.toString());
		renderRequest.setAttribute("curTags", curTags);
		renderRequest.setAttribute("curCategoryIds", idsCategorias);
		renderRequest.setAttribute("urlDestino", urlDestino);

		return "/html/destaque/config.jsp";
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

		// pegando da ordenacao dos fornecedores que foram marcados e serao
		// guardados na preferencia
		// detalhe: String ids ja esta na ordem
		String[] ids = actionRequest.getParameterValues("layoutIdsBox");

		portletPreferences.setValues(Constantes.IDS_FORNECEDOR, ids);
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

	private List<FornecedorVO> ordenarList(List<FornecedorVO> lista,
			String[] ids) {

		List<FornecedorVO> temp = new ArrayList<FornecedorVO>();

		if (ids != null) {
			for (String id : ids) {
				for (FornecedorVO fornecedor : lista) {
					if (fornecedor.getId().equals(id)) {
						temp.add(fornecedor);
					}
				}
			}
		}

		return temp;
	}
}
