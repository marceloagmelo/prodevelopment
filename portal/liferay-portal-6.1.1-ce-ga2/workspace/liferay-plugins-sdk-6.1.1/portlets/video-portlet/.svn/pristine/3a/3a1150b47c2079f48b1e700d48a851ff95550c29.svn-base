package br.com.prodevelopment.video.destaque.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.prodevelopment.video.destaque.Constantes;
import br.com.prodevelopment.video.util.Search;
import br.com.prodevelopment.video.vo.VideoVO;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoDestaquePortlet
 */
public class VideoDestaquePortlet extends MVCPortlet {
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

		String ids = preferences.getValue(Constantes.ID_VIDEOS, "");
		String[] idsArray = preferences.getValues(Constantes.ID_VIDEOS, new String[0]);

		List<VideoVO> videos = null;

		try {

			if(Validator.isNotNull(ids) && idsArray.length == 1)
				idsArray = StringUtil.split(ids);

			videos = new Search().buscarVideosById(idsArray, request, false);

			// ordenando a lista
			videos = ordenarList(videos, idsArray);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("videos", videos);
		request.setAttribute("urlDestino",preferences.getValue(Constantes.URL_DESTINO, ""));

		if (videos != null && !videos.isEmpty()) {
			if (videos.size() == 1) {
				include(viewSingleJSP, request, response);
			} else
				super.render(request, response);
		} else {
			SessionMessages.add(request,
					"mensagem.portletNaoConfigurado");
			include(naoConfiguradoJSP, request, response);
		}
	}

	private List<VideoVO> ordenarList(List<VideoVO> lista, String[] ids) {

		List<VideoVO> temp = new ArrayList<VideoVO>();

		if(ids != null )
		{
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


}
