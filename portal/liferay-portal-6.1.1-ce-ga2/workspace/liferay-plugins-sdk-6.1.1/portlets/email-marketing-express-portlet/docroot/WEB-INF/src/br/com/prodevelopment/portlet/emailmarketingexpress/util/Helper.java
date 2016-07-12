package br.com.prodevelopment.portlet.emailmarketingexpress.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;

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

    private static final char DOT  = '.';
    private static final char COMMA = ',';
    private static final char SPACE = ' ';
    private static final String NULL_PARAMETERS = "Null parameters were passed to the method where Null are not acceptable.";
    private static final String REGEX_VALIDA_EMAIL = "^[\\w-.]+@(([0-9a-zA-Z]+)\\.)+[a-zA-Z]{2,6}$";

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

    public static String trataTextoLongo(String texto, int tamanho) {
		if (texto == null)
			texto = "";
		if (texto.length() > tamanho) {
			texto = texto.substring(0, tamanho);
			texto = texto + "...";
		}
		return texto;
	}
	
    /**
     * Verifica se um string é nulo, vazio ou prenchido somente 
     * com espaços.
     * @param str o string a ser avaliado.
     * @return <code>true</code> caso o string é nulo, 
     * vazio ou prenchido somente com espaços. 
     */
    public static boolean isEmptyString(String str)
    {
        if(str == null) return true;

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != SPACE) return false;
        }

        return true;
    }
    
    /**
     * Verifica se uma collection é nula ou vazia.
     * @param collection a collection a ser avaliada.
     * @return <code>true</code> caso a collection seja 
     * nula ou vazia.
     */
    public static boolean isEmpty(Collection collection){
    	if(collection == null){
    		return true;
    	}
    	
    	return collection.isEmpty();
    }
    
    /**
     * Verifica se uma map é nula ou vazia.
     * @param map a map a ser avaliada.
     * @return <code>true</code> caso a map seja 
     * nula ou vazia.
     */
    public static boolean isEmpty(Map map){
    	if(map == null){
    		return true;
    	}
    	
    	return map.isEmpty();
    }
    
    /**
     * Compara a igualdade entre dois objetos livre observando
     * a nulidade de um dois objetos.
     * @param first O primeiro objeto.
     * @param second O segundo objeto.
     * @return <code>true</code> caso os dois objetos sejam iguais.
     */
    public static boolean equals(Object first, Object second){
    	//caso base, a mesma referência
    	if(first == second){
    		//retorna que os dois são iguais
    		return true;
    	}
    	
    	//caso os dois objetos sejam nulos
    	if(first == null && second == null){
    		//retorna que são iguais.
    		return true;
    	}
    	
    	//caso apenas um dois dois seja nulo
    	if(first == null || second == null){
    		//retorna false, pois apenas um deles é nulo.
    		return false;
    	}
    	
    	//caso os dois não sejam nulos
    	return first.equals(second);
    }

    /**
     * Valida se um determinado email é válido segundo a 
     * expressão regular 
     * <code>^[\\w-.]+@(([0-9a-zA-Z]+)\\.)+[a-zA-Z]{2,6}$</code>.
     * @param email O email a ser validado.
     * @return <code>true</code> caso o email seja válido.
     */
    public static boolean validaEmail(String email) {
		if (isEmptyString(email))
			return false;

		return email.matches(REGEX_VALIDA_EMAIL);
	}

    public static boolean validaCPF(long cpf)
    {

        if(cpf == 0L || cpf == 11111111111L || cpf == 22222222222L
                || cpf == 33333333333L || cpf == 44444444444L
                || cpf == 55555555555L || cpf == 66666666666L
                || cpf == 77777777777L || cpf == 88888888888L
                || cpf == 99999999999L)
            return false;

        // CPF Overflow
        if (cpf >= 100000000000L) return false;

        // armazena o segundo dv
        long dv     = cpf % 10;

        // Descarta segundo dv do CPF
        long numero = cpf / 10;

        // Valida o segundo dv
        if (dv != modulo11(numero,2,11)) return false;

        // armazena o primeiro dv
        dv = numero % 10;

        // Descarta o primero dv do CPF
        numero /= 10;

        // Valida o primeiro dv
        return dv == modulo11(numero,2,10) ? true : false;
    }

    public static boolean validaCNPJ(long cnpj)
    {
        // CNPJ Overflow
        if (cnpj >= 100000000000000L) return false;

        // armazena o segundo dv
        long dv = cnpj % 10;

        // Descartao segundo dv do CNPJ
        long numero = cnpj / 10;

        // valida o segundo dv
        if ( dv != modulo11(numero,2,9)) return false;

        // armazena o primenro dv
        dv = numero % 10;

        // Descarta o primero dv do CNPJ
        numero /= 10;

        // Valida o primeiro dv
        return dv == modulo11(numero,2,9) ? true : false;
    }

    public static long modulo11(long numero, int pesoInicial, int pesoFinal)
    {
        // Inicializacao
        long power = 1;
        long result = 0;

        // Loop calculando
        for (int i = 0;  ; i++)
        {
            // Atualiza a potencia
            power = i == 0 ? power : power * 10;

            // Descarte a direita
            long d = numero / power ;

            // caso base : o numero acabou
            if (d == 0) break;

            // Descarte a esquerda, sobrando o digito
            d %= 10;

            // Fator do Modulo 11
            d *= (i % (pesoFinal - pesoInicial + 1) + pesoInicial);

            // Incrementa resultado
            result += d;

        }

        // Resto da divisao para o modulo 11
        result %= 11;

        // Retorna o digito para o modulo 11
        return result > 1 ? 11 - result : 0;
    }

    public static long modulo10(long numero)
    {
        // Inicializacao
        long power = 1;
        long result = 0;

        // Loop calculando
        for (int i = 0;  ; i++)
        {
            // Atualiza a potencia
            power = i == 0 ? power : power * 10;

            // Descarte a direita
            long d = numero / power ;

            // caso base : o numero acabou
            if (d == 0) break;

            // Descarte a esquerda, sobrando o digito
            d %= 10;

            // Fator do Modulo 10
            d *= (i%2 == 0 ? 2 : 1 );

            // Incrementa resultado
            result += (d < 10 ? d : d - 9);

        }

        // Resto da divisao para o modulo 10
        result %= 10;

        // Retorna o digito para o modulo 10
        return result > 0 ? 10 - result : 0;
    }

    public static boolean isInteger(Object value)
    {
        if(value == null) return false;

        if(value instanceof Number)
        {
            //verifica se é BigDecimal, Double ou Float
            BigDecimal bd = null;
            if(value instanceof BigDecimal)
            {
                bd = (BigDecimal) value;
            } else if(value instanceof Double || value instanceof Float){
                bd = new BigDecimal(((Number) value).doubleValue());
            } else {
                //só restou representações númericas inteiras.
                return true;
            }

            //verifica se tem fração.
            try
            {
                bd.setScale(0,BigDecimal.ROUND_UNNECESSARY);
            } catch (ArithmeticException ae){
                //ops tinha fração!
                return false;
            }
            return true;
        }

        //se não é númerico monta o string e avalia caracter a caracter.
        String strValue = value.toString();

        if(isEmptyString(strValue)) return false;

        for(int i=0;i < strValue.length();i++)
        {
            char ch = strValue.charAt(i);
            if(!Character.isDigit(ch))
            {
                //TODO: verificar se esta de três em três.
                if(ch != DOT) return false;
            }
        }
        return true;
    }

    public static boolean isDecimal(Object value)
    {
    	if(value == null) return false;

        if(value instanceof Number)
        {
            //a principio todo número é decimal.
            return true;
        }

        //caso não seja númerico realiza a validação caracter a caracter.
        String strValue = value.toString();
        for(int i=0;i < strValue.length();i++)
        {
            char ch = strValue.charAt(i);
            if(!Character.isDigit(ch))
            {
                if(ch != DOT && ch != COMMA) return false;
            }
        }
        return true;
    }

    public static boolean isCPF(Object value)
    {
    	if(value == null) return false;

        if(value instanceof Number)
        {
            return validaCPF(((Number) value).longValue());
        }

        String strValue = onlyDigits(value.toString());
        return isEmptyString(strValue) ? false
                : validaCPF(Long.parseLong(strValue));
    }

    public static boolean isCPF(long value)
    {
        return validaCPF(value);
    }

    public static boolean isCNPJ(Object value)
    {
    	if(value == null) return false;

        if(value instanceof Number)
        {
            return validaCNPJ(((Number) value).longValue());
        }

        String strValue = onlyDigits(value.toString());
        return isEmptyString(strValue) ? false
                : validaCNPJ(Long.parseLong(strValue));
    }

    public static boolean isCNPJ(long value)
    {
        return validaCNPJ(value);
    }

    /**
     * Compara dois Calendar contendo data e hora para determinar a precedência entre eles.
     * @param first primeiro calendar na comparacação.
     * @param second segundo calendar na comparacação.
     * @return -1 se o primeiro calendar é anterior ao segundo, 0 se são iguais
     * e 1 se o primeiro calendar é posterior ao segundo.
     * @throws IllegalArgumentException Caso seja passado algum parâmetro <I><B>nulo</B></I>.
     */
    public static int compareDateTime(Calendar first, Calendar second)
    {
        int aux = compareDate(first, second);
        return aux == 0 ? compareTime(first, second) : aux;
    }

    /**
     * Compara duas datas para determinar a precedência entre elas.
     * @param first primeira data na comparacação.
     * @param second segunda data na comparacação.
     * @return -1 se a primeira data é anterior a segunda, 0 se são iguais
     * e 1 se a primeira data é posterior a segunda.
     * @throws IllegalArgumentException Caso seja passado algum parâmetro <I><B>nulo</B></I>.
     */
    public static int compareDate(Calendar first, Calendar second)
    {
    	if((first == null) || (second == null)){
			throw new IllegalArgumentException(NULL_PARAMETERS);
		}

        if(first.get(Calendar.YEAR) > second.get(Calendar.YEAR))
        {
            return 1;
        }

        if(first.get(Calendar.YEAR) == second.get(Calendar.YEAR))
        {
            if(first.get(Calendar.DAY_OF_YEAR) > second.get(Calendar.DAY_OF_YEAR))
            {
                return 1;
            }

            if(first.get(Calendar.DAY_OF_YEAR) == second.get(Calendar.DAY_OF_YEAR))
            {
                return 0;
            }
        }

        return -1;
    }

    /**
     * Compara dois horários para determinar a precedência entre eles.
     * @param first primeiro horário na comparacação.
     * @param second segundo horário na comparacação.
     * @return -1 se o primeiro horário é anterior ao segundo, 0 se são iguais
     * e 1 se o primeiro horário é posterior ao segundo.
     * @throws IllegalArgumentException Caso seja passado algum parâmetro <I><B>nulo</B></I>.
     */
    public static int compareTime(Calendar first, Calendar second)
    {
    	if((first == null) || (second == null)){
			throw new IllegalArgumentException(NULL_PARAMETERS);
		}

        if(first.get(Calendar.HOUR_OF_DAY) > second.get(Calendar.HOUR_OF_DAY))
        {
            return 1;
        }

        if(first.get(Calendar.HOUR_OF_DAY) == second.get(Calendar.HOUR_OF_DAY))
        {
            if(first.get(Calendar.MINUTE) > second.get(Calendar.MINUTE))
            {
                return 1;
            }

            if(first.get(Calendar.MINUTE) == second.get(Calendar.MINUTE))
            {
                return 0;
            }
        }

        return -1;
    }

	public static String onlyDigits(String source) {
		if (source == null)
			return StringPool.BLANK;

		boolean clear = true;
		for (int i = 0; i < source.length(); i++) {
			if (!Character.isDigit(source.charAt(i))) {
				clear = false;
			}
		}

		if (clear) {
			return source;
		}

		char[] result = new char[source.length()];
		int j = 0;
		for (int i = 0; i < source.length(); i++) {
			char c;
			if (Character.isDigit(c = source.charAt(i))) {
				result[j++] = c;
			}
		}

		return new String(result, 0, j);
	}

	public static String getTituloPortlet(RenderRequest renderRequest,
			RenderResponse renderResponse, ThemeDisplay themeDisplay)
			throws SystemException {
		String portletTitulo = "";

		Portlet portlet = (Portlet) renderRequest
				.getAttribute(WebKeys.RENDER_PORTLET);

		String portletId = portlet.getPortletId();

		PortletPreferences portletSetup = PortletPreferencesFactoryUtil
				.getLayoutPortletSetup(themeDisplay.getLayout(), portletId);

		String defaultLanguageId = LocaleUtil.toLanguageId(PortalUtil
				.getLocale(renderRequest));

		portletTitulo = GetterUtil.getString(portletSetup.getValue(
				"portletSetupTitle_" + defaultLanguageId, StringPool.BLANK));

		if (Validator.isNull(portletTitulo)) {
			ResourceBundle resource = ResourceBundle.getBundle(
					portlet.getResourceBundle(), LocaleUtil.getDefault());
			portletTitulo = resource.getString("javax.portlet.title");
		}

		return portletTitulo;
	}
}
