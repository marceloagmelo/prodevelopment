package br.com.rasecmadeiras.produto.destaque.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.rasecmadeiras.produto.destaque.Constantes;
import br.com.rasecmadeiras.produto.util.Search;
import br.com.rasecmadeiras.produto.vo.ProdutoVO;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ProdutoDestaquePortlet
 */
public class ProdutoDestaquePortlet extends MVCPortlet {
	protected String naoConfiguradoJSP;
	protected String viewSingleJSP;

	@Override
	public void init() throws PortletException {

		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);

		super.init();
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {


		PortletPreferences preferences = request.getPreferences();

		String ids = preferences.getValue(Constantes.ID_PRODUTOS, "");
		String[] idsArray = preferences.getValues(Constantes.ID_PRODUTOS, new String[0]);

		List<ProdutoVO> produtos = null;

		try {

			if(Validator.isNotNull(ids) && idsArray.length == 1)
				idsArray = StringUtil.split(ids);

			produtos = new Search().buscarProdutosById(idsArray, request, false);

			// ordenando a lista
			produtos = ordenarList(produtos, idsArray);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("produtos", produtos);
		request.setAttribute("urlDestino",preferences.getValue(Constantes.URL_DESTINO, ""));

		if (produtos != null && !produtos.isEmpty()) {
			super.render(request, response);
		} else {
			SessionMessages.add(request,
					"mensagem.portletNaoConfigurado");
			include(naoConfiguradoJSP, request, response);
		}
	}

	private List<ProdutoVO> ordenarList(List<ProdutoVO> lista, String[] ids) {

		List<ProdutoVO> temp = new ArrayList<ProdutoVO>();

		if(ids != null )
		{
			for (String id : ids) {
				for (ProdutoVO produto : lista) {
					if (produto.getId().equals(id)) {
						temp.add(produto);
					}
				}
			}
		}
		return temp;
	}


}
