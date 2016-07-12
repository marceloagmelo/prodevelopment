package br.com.prodevelopment.conteudo.util;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portlet.layoutconfiguration.util.RuntimePortletUtil;
import com.liferay.portlet.layoutconfiguration.util.xml.RuntimeLogic;

public class PortletLogic extends RuntimeLogic {

	public static final String CLOSE_1_TAG = "</runtime-portlet>";

	public static final String CLOSE_2_TAG = "/>";

	public static final String OPEN_TAG = "<runtime-portlet";

	public PortletLogic(
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		_servletContext = servletContext;
		_request = request;
		_response = response;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
	}

	@Override
	public String getClose1Tag() {
		return CLOSE_1_TAG;
	}

	@Override
	public String getOpenTag() {
		return OPEN_TAG;
	}

	@Override
	public String processXML(String xml) throws Exception {
		Document doc = SAXReaderUtil.read(xml);

		Element root = doc.getRootElement();

		String rootPortletId = root.attributeValue("name");
		String instanceId = root.attributeValue("instance");
		String queryString = root.attributeValue("queryString");

		String portletId = rootPortletId;

		if (Validator.isNotNull(instanceId)) {
			portletId += PortletConstants.INSTANCE_SEPARATOR + instanceId;
		}

		return RuntimePortletUtil.processPortlet(
			_servletContext, _request, _response, _renderRequest,
			_renderResponse, portletId, queryString, false);
	}

	private RenderRequest _renderRequest;
	private RenderResponse _renderResponse;
	private HttpServletRequest _request;
	private HttpServletResponse _response;
	private ServletContext _servletContext;

}