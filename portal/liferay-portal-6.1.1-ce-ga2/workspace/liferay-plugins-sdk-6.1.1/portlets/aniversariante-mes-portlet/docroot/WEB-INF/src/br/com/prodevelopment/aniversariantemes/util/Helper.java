package br.com.prodevelopment.aniversariantemes.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class Helper {

	public static int parseInt(String str) throws Exception
	{
    	try {
    		int i;
        	
        	try 
        	{ 
        		i = Integer.parseInt(str); 
        	}
        	catch(NumberFormatException e) 
        	{ 
        		throw new Exception("Erro. Não foi possível transformar [" + str + "] para número inteiro!"); 
        	};
        	
        	return i;
    	}
    	catch (Exception e) {
    		throw new Exception(e);
    	}
	}

	public static long parseLong(String str) throws Exception
	{
    	try {
    		long i;
        	
        	try 
        	{ 
        		i = Long.parseLong(str); 
        	}
        	catch(NumberFormatException e) 
        	{ 
        		throw new Exception("Erro. NÃ£o foi possÃ­vel transformar [" + str + "] para nÃºmero longo!"); 
        	};
        	
        	return i;
    	}
    	catch (Exception e) {
    		throw new Exception(e);
    	}
	}


	public static double parseDouble(String str) throws Exception
	{
    	try {
    		double i;
        	
        	try 
        	{ 
        		i = Double.parseDouble(str); 
        	}
        	catch(NumberFormatException e) 
        	{ 
        		throw new Exception("Erro. NÃ£o foi possÃ­vel transformar [" + str + "] para nÃºmero!"); 
        	};
        	
        	return i;
    	}
    	catch (Exception e) {
    		throw new Exception(e);
    	}
	}

	public static Date obterData() {
		
        Date data = new GregorianCalendar().getTime();

        return data;
	}
	
	public static String obterData(Date data) {
		
        String retorno = null;

        Calendar calendarData = GregorianCalendar.getInstance();
        calendarData.clear(Calendar.ZONE_OFFSET);
        calendarData.setTime(data);

        int dia = calendarData.get(Calendar.DAY_OF_MONTH);
        int mes = calendarData.get(Calendar.MONTH);
        mes++;
        int ano = calendarData.get(Calendar.YEAR);

        String sDia = zerosEsquerda(Integer.toString(dia), 2);
        String sMes = zerosEsquerda(Integer.toString(mes), 2);
        String sAno = Integer.toString(ano);

        retorno = sDia + "/" + sMes + "/" + sAno;

        return retorno;
	}
	
    public static String espacosDireita(String valor, int tamanho) {
        
        valor = (valor==null? "" : valor );
        if (valor.length() < tamanho)
        {
            for (int i=valor.length(); i<tamanho; i++)
            {
                valor = valor + " ";
            }
        }
        else {
            valor = valor.substring(0, tamanho);
        }
        
        return valor;
    }
    
    /**
     * PreposiÃ§Ãµes e pronomes de nomes prÃ³prios que devem ser ignorados em
     * pesquisas de noivos.
     */
    public static final Set NOME_STOPWORDS = new HashSet(11);
        
    static {
        NOME_STOPWORDS.add("da");
        NOME_STOPWORDS.add("das");
        NOME_STOPWORDS.add("de");
        NOME_STOPWORDS.add("des");
        NOME_STOPWORDS.add("di");
        NOME_STOPWORDS.add("dis");
        NOME_STOPWORDS.add("do");
        NOME_STOPWORDS.add("dos");
        NOME_STOPWORDS.add("del");
        NOME_STOPWORDS.add("los");
        NOME_STOPWORDS.add("e");
    }

    public static String formatarIdTransacao(String idRetorno) {
        
        if (idRetorno.length() > 8) {
            idRetorno = idRetorno.substring(0, 8);
        } else {
            idRetorno = zerosEsquerda(idRetorno, 8);
        }
        
        return idRetorno;
    }

    public static String zerosEsquerda(String valor, int tamanho) {
        
        valor = (valor==null? "0" : valor );
        if (valor.length() < tamanho)
        {
            for (int i=valor.length(); i<tamanho; i++)
            {
            	valor = "0" + valor;
            }
        }
        else {
            valor = valor.substring(0, tamanho);
        }

        return valor;
    }
    
    /**
     * Trata as Strings inseridas
     */
    public static String trataStringsInsercao(String string) {
        string = string.trim();
        return string.replaceAll("['*]", "`");
    }        

	public static boolean isEmptyString(String s)
    {
		return s == null || "".equals(s.trim());
	}

	public static String retiraAcentos(String acentos)
    {
        if ( acentos != null ) {
            acentos = acentos.replaceAll("[èéêë]", "e");
            acentos = acentos.replaceAll("[ûùúü]", "u");
            acentos = acentos.replaceAll("[ïîíì]", "i");
            acentos = acentos.replaceAll("[àâáäã]", "a");
            acentos = acentos.replaceAll("[ôóòöõ]", "o");

            acentos = acentos.replaceAll("[ÈÉÊË]", "E");
            acentos = acentos.replaceAll("[ÛÙÚÜ]", "U");
            acentos = acentos.replaceAll("[ÏÎÍÌ]", "I");
            acentos = acentos.replaceAll("[ÀÂÁÄÃ]", "A");
            acentos = acentos.replaceAll("[ÔÓÖÒÕ]", "O");
            acentos = acentos.replaceAll("[´`'^~]", " ");
            acentos = acentos.replaceAll("ç", "c");
            acentos = acentos.replaceAll("Ç", "C");
            acentos = acentos.replaceAll("®", " ");
        }
		return acentos;
	}

	public static String getTituloPortlet(RenderRequest renderRequest,
			RenderResponse renderResponse, ThemeDisplay themeDisplay) throws SystemException {
		String portletTitulo = "";

		Portlet portlet = (Portlet) renderRequest
				.getAttribute(WebKeys.RENDER_PORTLET);

		String portletId = portlet.getPortletId();


		PortletPreferences portletSetup = PortletPreferencesFactoryUtil
		.getLayoutPortletSetup(themeDisplay.getLayout(), portletId);

		String defaultLanguageId = LocaleUtil.toLanguageId(PortalUtil.getLocale(renderRequest));

		portletTitulo = GetterUtil.getString(portletSetup.getValue(
				"portletSetupTitle_"+defaultLanguageId, StringPool.BLANK));

		String useCustomTitle = GetterUtil.getString(portletSetup.getValue(
				"portletSetupUseCustomTitle", StringPool.BLANK));

		ResourceBundle resource  = ResourceBundle.getBundle(portlet.getResourceBundle(), PortalUtil.getLocale(renderRequest));	
		
		if ((!useCustomTitle.equals("true")) || (Validator.isNull(portletTitulo)) ) {
			portletTitulo = resource.getString("javax.portlet.title");
		}

		return portletTitulo;
	}
}
