package br.com.prodevelopment.equipefitness.portlet.atividade.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import br.com.prodevelopment.equipefitness.portlet.atividade.Constantes;

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
		
		boolean prefQuantidadeItens = GetterUtil.getBoolean(portletPreferences.getValue(
				Constantes.PREF_QUANTIDADE_ITENS, null));
		int prefIntervaloSegundos = GetterUtil.getInteger(portletPreferences.getValue(
				Constantes.PREF_INTERVALO_SEGUNDOS, null));
		
		renderRequest.setAttribute(Constantes.PREF_QUANTIDADE_ITENS, prefQuantidadeItens);
		renderRequest.setAttribute(Constantes.PREF_INTERVALO_SEGUNDOS, prefIntervaloSegundos);
	        
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

		String prefQuantidadeItens = ParamUtil.getString(actionRequest,
				Constantes.PREF_QUANTIDADE_ITENS);
		String prefIntervaloSegundos = ParamUtil.getString(actionRequest,
				Constantes.PREF_INTERVALO_SEGUNDOS);

    	prefs.setValue(Constantes.PREF_QUANTIDADE_ITENS, prefQuantidadeItens);
    	prefs.setValue(Constantes.PREF_INTERVALO_SEGUNDOS, prefIntervaloSegundos);
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