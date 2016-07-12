package br.com.prodevelopment.eticket.portlet.type.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TypeTicketPortlet
 */
public class TypeTicketPortlet extends MVCPortlet {
 
	private static Log _log = LogFactoryUtil.getLog(TypeTicketPortlet.class);
	//private static Logger _log = Logger.getLogger(TypeTicketPortlet.class);
	//private final Logger _log = LoggerFactory.getLogger(TypeTicketPortlet.class);
			
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			if (_log.isDebugEnabled()) {
				_log.debug("LOG com debug");
			}
			_log.info("LOG sem debug");
			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e, e);
		}

	}

}
