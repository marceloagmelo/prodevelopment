package br.com.prodevelopment.teste.formbuilder.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TesteFormBuilderPortlet
 */
public class TesteFormBuilderPortlet extends MVCPortlet {
 

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		String xsd = ParamUtil.getString(actionRequest, "xsd");
		
		System.out.println("XSD==="+xsd);
	}

}
