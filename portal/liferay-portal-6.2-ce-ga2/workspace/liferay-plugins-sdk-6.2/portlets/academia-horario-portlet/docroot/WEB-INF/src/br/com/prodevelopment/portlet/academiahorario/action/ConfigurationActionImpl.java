package br.com.prodevelopment.portlet.academiahorario.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import br.com.prodevelopment.portlet.academiahorario.Constantes;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
        
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		
		boolean prefSomenteEsseSite = GetterUtil.getBoolean(portletPreferences.getValue(
				Constantes.PREF_SOMENTE_ESSE_SITE, null));
		int prefIntervaloMinuto = GetterUtil.getInteger(portletPreferences.getValue(
				Constantes.PREF_INTERVALO_MINUTO, null));
		
		renderRequest.setAttribute(Constantes.PREF_SOMENTE_ESSE_SITE, prefSomenteEsseSite);
		renderRequest.setAttribute(Constantes.PREF_INTERVALO_MINUTO, prefIntervaloMinuto);
	        
	    PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);
		String configTemplate = selPortletConfig.getInitParameter(
			CONFIG_TEMPLATE);
		return configTemplate;
	}
	
	
    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, 
    		ActionResponse actionResponse) throws Exception {
    	
    	PortletPreferences prefs = actionRequest.getPreferences();
		String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");

		String prefSomenteEsseSite = ParamUtil.getString(actionRequest,
				Constantes.PREF_SOMENTE_ESSE_SITE);
		String prefIntervaloMinuto = ParamUtil.getString(actionRequest,
				Constantes.PREF_INTERVALO_MINUTO);

    	prefs.setValue(Constantes.PREF_SOMENTE_ESSE_SITE, prefSomenteEsseSite);
    	prefs.setValue(Constantes.PREF_INTERVALO_MINUTO, prefIntervaloMinuto);
    	prefs.setValue(Constantes.PREF_CONFIGURADO, Constantes.S);
    	
		if (SessionErrors.isEmpty(actionRequest)) {
			try {
				prefs.store();
		        SessionMessages.add(actionRequest, Constantes.PORTLET_CONFIGURADO_SUCESSO);
			}
			catch (ValidatorException ve) {
				SessionErrors.add(
					actionRequest, ValidatorException.class.getName(), ve);

				return;
			}

			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
				portletResource);

			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
    }
    
    public static final String CONFIG_TEMPLATE = "config-template";
}