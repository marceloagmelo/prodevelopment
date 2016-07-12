package br.com.rasecmadeiras.fornecedor.destaque.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.rasecmadeiras.fornecedor.destaque.Constantes;
import br.com.rasecmadeiras.fornecedor.util.Search;
import br.com.rasecmadeiras.fornecedor.vo.FornecedorVO;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FornecedorDestaquePortlet
 */
public class FornecedorDestaquePortlet extends MVCPortlet {

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

		String ids = preferences.getValue(Constantes.IDS_FORNECEDOR, "");

		String[] idsArray = preferences.getValues(Constantes.IDS_FORNECEDOR, new String[0]);
		request.setAttribute(Constantes.URL_DESTINO, preferences.getValue(Constantes.URL_DESTINO, ""));
		request.setAttribute(Constantes.CATEGORIA, preferences.getValue(Constantes.FILTRO_CATEGORIAS_IDS, ""));
		request.setAttribute(Constantes.TAG, preferences.getValue(Constantes.FILTRO_TAGS_NAMES, ""));

		// busca todos os fornecedores com aquela(s) categoria escolhida
		List<FornecedorVO> fornecedores = null;

		try {
			if(Validator.isNotNull(ids) && idsArray.length == 1)
				idsArray = StringUtil.split(ids);

			fornecedores = new Search().buscarById(idsArray, request, false);

			// ordenando a lista
			fornecedores = ordenarList(fornecedores, idsArray);


		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("lista", fornecedores);
		request.setAttribute("portletId", PortalUtil.getPortletId(request));
		request.setAttribute("urlDestino",preferences.getValue(Constantes.URL_DESTINO, ""));

		if (fornecedores != null && !fornecedores.isEmpty()) {
			super.render(request, response);

		} else {
			SessionMessages.add(request, "mensagem.portletNaoConfigurado");
			include(naoConfiguradoJSP, request, response);
		}

	}


	private List<FornecedorVO> ordenarList(List<FornecedorVO> lista, String[] ids) {

		List<FornecedorVO> temp = new ArrayList<FornecedorVO>();

		if (ids != null) {
			for(String id:ids) {
				for(FornecedorVO fornecedor:lista) {
					if(fornecedor.getId().equals(id)) {
						temp.add(fornecedor);
					}
				}
			}
		}

		return temp;
	}

}

